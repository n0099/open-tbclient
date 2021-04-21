package d.a.a.w;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonReader.a f41876a = JsonReader.a.a(SearchView.IME_OPTION_NO_MICROPHONE, "mm", "hd");

    public static MergePaths a(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z = false;
        while (jsonReader.t()) {
            int D = jsonReader.D(f41876a);
            if (D == 0) {
                str = jsonReader.z();
            } else if (D == 1) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.x());
            } else if (D != 2) {
                jsonReader.E();
                jsonReader.F();
            } else {
                z = jsonReader.v();
            }
        }
        return new MergePaths(str, mergePathsMode, z);
    }
}
