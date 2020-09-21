package com.tb.airbnb.lottie.c;

import android.util.JsonReader;
import com.tb.airbnb.lottie.model.content.MergePaths;
import java.io.IOException;
/* loaded from: classes17.dex */
class v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static MergePaths h(JsonReader jsonReader) throws IOException {
        MergePaths.MergePathsMode mergePathsMode = null;
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 3488:
                    if (nextName.equals("mm")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new MergePaths(str, mergePathsMode);
    }
}
