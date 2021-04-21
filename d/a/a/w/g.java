package d.a.a.w;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import java.io.IOException;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static JsonReader.a f41844a = JsonReader.a.a("ty", "d");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
        if (r2.equals("gs") != false) goto L24;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d.a.a.u.j.b a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        d.a.a.u.j.b bVar;
        String str;
        jsonReader.o();
        char c2 = 2;
        int i = 2;
        while (true) {
            bVar = null;
            if (!jsonReader.t()) {
                str = null;
                break;
            }
            int D = jsonReader.D(f41844a);
            if (D == 0) {
                str = jsonReader.z();
                break;
            } else if (D != 1) {
                jsonReader.E();
                jsonReader.F();
            } else {
                i = jsonReader.x();
            }
        }
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 3239:
                if (str.equals("el")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 3270:
                if (str.equals("fl")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3295:
                if (str.equals("gf")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 3307:
                if (str.equals("gr")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3308:
                break;
            case 3488:
                if (str.equals("mm")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 3633:
                if (str.equals("rc")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 3646:
                if (str.equals("rp")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 3669:
                if (str.equals(IAdRequestParam.SCREEN_HEIGHT)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 3679:
                if (str.equals("sr")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 3681:
                if (str.equals("st")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3705:
                if (str.equals("tm")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 3710:
                if (str.equals("tr")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                bVar = f0.a(jsonReader, dVar);
                break;
            case 1:
                bVar = h0.a(jsonReader, dVar);
                break;
            case 2:
                bVar = n.a(jsonReader, dVar);
                break;
            case 3:
                bVar = e0.a(jsonReader, dVar);
                break;
            case 4:
                bVar = m.a(jsonReader, dVar);
                break;
            case 5:
                bVar = c.g(jsonReader, dVar);
                break;
            case 6:
                bVar = g0.a(jsonReader, dVar);
                break;
            case 7:
                bVar = e.a(jsonReader, dVar, i);
                break;
            case '\b':
                bVar = a0.a(jsonReader, dVar);
                break;
            case '\t':
                bVar = i0.a(jsonReader, dVar);
                break;
            case '\n':
                bVar = z.a(jsonReader, dVar);
                break;
            case 11:
                bVar = v.a(jsonReader);
                dVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case '\f':
                bVar = b0.a(jsonReader, dVar);
                break;
            default:
                d.a.a.x.d.c("Unknown shape type " + str);
                break;
        }
        while (jsonReader.t()) {
            jsonReader.F();
        }
        jsonReader.r();
        return bVar;
    }
}
