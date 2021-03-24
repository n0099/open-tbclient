package d.a.a.u;

import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.MergePaths;
import java.io.IOException;
/* loaded from: classes.dex */
public class v {
    public static MergePaths a(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3488) {
                if (hashCode == 3519 && nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                    c2 = 0;
                }
            } else if (nextName.equals("mm")) {
                c2 = 1;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 != 1) {
                jsonReader.skipValue();
            } else {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.nextInt());
            }
        }
        return new MergePaths(str, mergePathsMode);
    }
}
