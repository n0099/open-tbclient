package d.a.a.u;

import android.util.JsonReader;
import android.util.Log;
import com.airbnb.lottie.model.content.Mask;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes.dex */
public class u {
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
        if (r0.equals("a") != false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00be A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x008e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Mask a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        char c2;
        jsonReader.beginObject();
        Mask.MaskMode maskMode = null;
        d.a.a.s.i.h hVar = null;
        d.a.a.s.i.d dVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            char c3 = 0;
            if (hashCode == 111) {
                if (nextName.equals(Config.OS)) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != 3588) {
                if (hashCode == 3357091 && nextName.equals("mode")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (nextName.equals(Config.PLATFORM_TYPE)) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                String nextString = jsonReader.nextString();
                int hashCode2 = nextString.hashCode();
                if (hashCode2 != 97) {
                    if (hashCode2 != 105) {
                        if (hashCode2 == 115 && nextString.equals("s")) {
                            c3 = 1;
                            if (c3 != 0) {
                                maskMode = Mask.MaskMode.MaskModeAdd;
                            } else if (c3 == 1) {
                                maskMode = Mask.MaskMode.MaskModeSubtract;
                            } else if (c3 != 2) {
                                Log.w("LOTTIE", "Unknown mask mode " + nextName + ". Defaulting to Add.");
                                maskMode = Mask.MaskMode.MaskModeAdd;
                            } else {
                                dVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                                maskMode = Mask.MaskMode.MaskModeIntersect;
                            }
                        }
                        c3 = 65535;
                        if (c3 != 0) {
                        }
                    } else {
                        if (nextString.equals("i")) {
                            c3 = 2;
                            if (c3 != 0) {
                            }
                        }
                        c3 = 65535;
                        if (c3 != 0) {
                        }
                    }
                }
            } else if (c2 == 1) {
                hVar = d.k(jsonReader, dVar);
            } else if (c2 != 2) {
                jsonReader.skipValue();
            } else {
                dVar2 = d.h(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        return new Mask(maskMode, hVar, dVar2);
    }
}
