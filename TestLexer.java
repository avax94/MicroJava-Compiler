import java_cup.runtime.*;

class TestLexer {
    public static void main(String []argv) {
	if (argv.length == 0) {
	    System.out.println("Usage : java Lexer2 <inputfile>");
	}
	else {
	    for (int i = 0; i < argv.length; i++) {
		Lexer scanner = null;
		try {
		    scanner = new Lexer( new java.io.FileReader(argv[i]) );
		    while (true) {
			Symbol token = scanner.next_token();
			if(token.sym == sym.EOF) break;
			System.out.println(token.value.toString());
		    }
		}
		catch (java.io.FileNotFoundException e) {
		    System.out.println("File not found : \""+argv[i]+"\"");
		}
		catch (java.io.IOException e) {
		    System.out.println("IO error scanning file \""+argv[i]+"\"");
		    System.out.println(e);
		}
		catch (Exception e) {
		    System.out.println("Unexpected exception:");
		    e.printStackTrace();
		}
	    }	}
    }
}
