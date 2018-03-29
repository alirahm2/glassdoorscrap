package crawler;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;

import java.util.List;

public class Parser {
    public static void main(String[] args) throws APIError {
        DetectLanguage.apiKey = "26432ac7eae076cb6bc18f9ba69964fa";

        List<Result> results = DetectLanguage.detect("Sie sind offen für neue Ideen und hinterfragen konventionelle Denkmuster. Sie schätzen es, in einer leistungsorientierten Umgebung zu arbeiten, die von gegenseitigem Respekt, Diskussion und Zusammenarbeit getragen wird. Dann ist Roche für Sie der Ausgangspunkt für ein spannendes und internationales Arbeitsumfeld mit vielfältigen Entwicklungschancen.");

        Result result = results.get(0);

        System.out.println("Language: " + result.language);
        System.out.println("Is reliable: " + result.isReliable);
        System.out.println("Confidence: " + result.confidence);




    }
}
