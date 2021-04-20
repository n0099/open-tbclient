package d.a.a.w;

import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes.dex */
public class u {
    public static Mask a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        char c2;
        jsonReader.o();
        Mask.MaskMode maskMode = null;
        d.a.a.u.i.h hVar = null;
        d.a.a.u.i.d dVar2 = null;
        boolean z = false;
        while (jsonReader.t()) {
            String y = jsonReader.y();
            int hashCode = y.hashCode();
            char c3 = 65535;
            if (hashCode == 111) {
                if (y.equals(Config.OS)) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode == 3588) {
                if (y.equals(Config.PLATFORM_TYPE)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode != 104433) {
                if (hashCode == 3357091 && y.equals("mode")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (y.equals("inv")) {
                    c2 = 3;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                String z2 = jsonReader.z();
                int hashCode2 = z2.hashCode();
                if (hashCode2 != 97) {
                    if (hashCode2 != 105) {
                        if (hashCode2 != 110) {
                            if (hashCode2 == 115 && z2.equals("s")) {
                                c3 = 1;
                            }
                        } else if (z2.equals("n")) {
                            c3 = 2;
                        }
                    } else if (z2.equals("i")) {
                        c3 = 3;
                    }
                } else if (z2.equals("a")) {
                    c3 = 0;
                }
                if (c3 == 0) {
                    maskMode = Mask.MaskMode.MASK_MODE_ADD;
                } else if (c3 == 1) {
                    maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                } else if (c3 == 2) {
                    maskMode = Mask.MaskMode.MASK_MODE_NONE;
                } else if (c3 != 3) {
                    d.a.a.x.d.c("Unknown mask mode " + y + ". Defaulting to Add.");
                    maskMode = Mask.MaskMode.MASK_MODE_ADD;
                } else {
                    dVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                    maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                }
            } else if (c2 == 1) {
                hVar = d.k(jsonReader, dVar);
            } else if (c2 == 2) {
                dVar2 = d.h(jsonReader, dVar);
            } else if (c2 != 3) {
                jsonReader.F();
            } else {
                z = jsonReader.v();
            }
        }
        jsonReader.r();
        return new Mask(maskMode, hVar, dVar2, z);
    }
}
