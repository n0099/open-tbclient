package com.ksad.lottie.c;

import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
/* loaded from: classes6.dex */
public class g {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b2, code lost:
        if (r2.equals("gs") != false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0042 A[SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.ksad.lottie.model.content.b a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        com.ksad.lottie.model.content.b bVar;
        String str;
        char c2;
        jsonReader.beginObject();
        char c3 = 2;
        int i = 2;
        while (true) {
            bVar = null;
            if (!jsonReader.hasNext()) {
                str = null;
                break;
            }
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode != 100) {
                if (hashCode == 3717 && nextName.equals("ty")) {
                    c2 = 0;
                    if (c2 != 0) {
                        str = jsonReader.nextString();
                        break;
                    } else if (c2 != 1) {
                        jsonReader.skipValue();
                    } else {
                        i = jsonReader.nextInt();
                    }
                }
                c2 = 65535;
                if (c2 != 0) {
                }
            } else {
                if (nextName.equals("d")) {
                    c2 = 1;
                    if (c2 != 0) {
                    }
                }
                c2 = 65535;
                if (c2 != 0) {
                }
            }
        }
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 3239:
                if (str.equals("el")) {
                    c3 = 7;
                    break;
                }
                c3 = 65535;
                break;
            case 3270:
                if (str.equals("fl")) {
                    c3 = 3;
                    break;
                }
                c3 = 65535;
                break;
            case 3295:
                if (str.equals("gf")) {
                    c3 = 4;
                    break;
                }
                c3 = 65535;
                break;
            case 3307:
                if (str.equals("gr")) {
                    c3 = 0;
                    break;
                }
                c3 = 65535;
                break;
            case 3308:
                break;
            case 3488:
                if (str.equals("mm")) {
                    c3 = 11;
                    break;
                }
                c3 = 65535;
                break;
            case 3633:
                if (str.equals("rc")) {
                    c3 = '\b';
                    break;
                }
                c3 = 65535;
                break;
            case 3646:
                if (str.equals("rp")) {
                    c3 = '\f';
                    break;
                }
                c3 = 65535;
                break;
            case 3669:
                if (str.equals(IXAdRequestInfo.SCREEN_HEIGHT)) {
                    c3 = 6;
                    break;
                }
                c3 = 65535;
                break;
            case 3679:
                if (str.equals("sr")) {
                    c3 = '\n';
                    break;
                }
                c3 = 65535;
                break;
            case 3681:
                if (str.equals("st")) {
                    c3 = 1;
                    break;
                }
                c3 = 65535;
                break;
            case 3705:
                if (str.equals(IXAdRequestInfo.MAX_TITLE_LENGTH)) {
                    c3 = '\t';
                    break;
                }
                c3 = 65535;
                break;
            case 3710:
                if (str.equals("tr")) {
                    c3 = 5;
                    break;
                }
                c3 = 65535;
                break;
            default:
                c3 = 65535;
                break;
        }
        switch (c3) {
            case 0:
                bVar = af.a(jsonReader, dVar);
                break;
            case 1:
                bVar = ah.a(jsonReader, dVar);
                break;
            case 2:
                bVar = n.a(jsonReader, dVar);
                break;
            case 3:
                bVar = ae.a(jsonReader, dVar);
                break;
            case 4:
                bVar = m.a(jsonReader, dVar);
                break;
            case 5:
                bVar = c.a(jsonReader, dVar);
                break;
            case 6:
                bVar = ag.a(jsonReader, dVar);
                break;
            case 7:
                bVar = e.a(jsonReader, dVar, i);
                break;
            case '\b':
                bVar = aa.a(jsonReader, dVar);
                break;
            case '\t':
                bVar = ai.a(jsonReader, dVar);
                break;
            case '\n':
                bVar = z.a(jsonReader, dVar);
                break;
            case 11:
                bVar = v.a(jsonReader);
                dVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case '\f':
                bVar = ab.a(jsonReader, dVar);
                break;
            default:
                Log.w("LOTTIE", "Unknown shape type " + str);
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return bVar;
    }
}
