import java.util.List;

public class Minions extends Thread{
    
    private List<List<String>> Stringdata;
	private Results results;

	public Minions( Results results, List<List<String>> Stringdata) {
		this.results = results;
		this.Stringdata = Stringdata;
	}

	public void run() {

		

		//System.out.println("Thread " + Thread.currentThread().getId() + " is running");

		Converter converter = new Converter(Stringdata);
		converter.convertToFloat();
		List<List<Float>> data = converter.getList();


		Evaluator evaluator = new Evaluator(data);

		float[][] temp_precios = evaluator.ComparatorPrecio();


		
		for (int j = 0; j < 4; j++) {
			results.update(0, j, temp_precios[0][j]);
			results.update(1, j, temp_precios[1][j]);
		}
		//System.out.println("Thread " + Thread.currentThread().getId() + " is finished");
	}
}