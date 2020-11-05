// tag::vars[]

const React = require('react'); // <1>
const ReactDOM = require('react-dom'); // <2>
const client = require('./client'); // <3>

// end::vars[]

// tag::app[]
class App extends React.Component { // <1>

	constructor(props) {
		super(props);
		this.state = {products: []};
	}

	componentDidMount() { // <2>
		client({method: 'GET', path: '/api/v1/products'}).done(response => {
			this.setState({products: response.entity._embedded.products});
		});
	}

	render() { // <3>
		return (
			<ProductList products={this.state.products}/>
		)
	}
}
// end::app[]

// tag::employee-list[]
class ProductList extends React.Component{
	render() {
		const products = this.props.products.map(product =>
			<Product key={product._links.self.href} product={product}/>
		);
		return (
			<table class="table">
				<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">First</th>
					<th scope="col">Last</th>
					<th scope="col">Handle</th>
   			    </tr>
				</thead>
				<tbody>
					{products}
				</tbody>
			</table>
		)
	}
}
// end::employee-list[]

// tag::employee[]
class Product extends React.Component{
	render() {
		return (
			<tr>
				<th scope="row">{this.props.product.id}</th>
				<td>{this.props.product.name}</td>
				<td>{this.props.product.category}</td>
				<td>{this.props.product.description}</td>
			</tr>
		)
	}
}
// end::employee[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]