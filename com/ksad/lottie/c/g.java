package com.ksad.lottie.c;

import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0091, code lost:
        if (r6.equals("gs") != false) goto L16;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.ksad.lottie.model.content.b a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        String str;
        com.ksad.lottie.model.content.b a2;
        boolean z;
        char c = 2;
        jsonReader.beginObject();
        int i = 2;
        while (true) {
            if (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                switch (nextName.hashCode()) {
                    case 100:
                        if (nextName.equals("d")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 3717:
                        if (nextName.equals("ty")) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        str = jsonReader.nextString();
                        break;
                    case true:
                        i = jsonReader.nextInt();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else {
                str = null;
            }
        }
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 3239:
                if (str.equals("el")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 3270:
                if (str.equals("fl")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3295:
                if (str.equals("gf")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3307:
                if (str.equals("gr")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3308:
                break;
            case 3488:
                if (str.equals("mm")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 3633:
                if (str.equals("rc")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 3646:
                if (str.equals("rp")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 3669:
                if (str.equals(IXAdRequestInfo.SCREEN_HEIGHT)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 3679:
                if (str.equals("sr")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3681:
                if (str.equals("st")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3705:
                if (str.equals(IXAdRequestInfo.MAX_TITLE_LENGTH)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 3710:
                if (str.equals("tr")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                a2 = af.a(jsonReader, dVar);
                break;
            case 1:
                a2 = ah.a(jsonReader, dVar);
                break;
            case 2:
                a2 = n.a(jsonReader, dVar);
                break;
            case 3:
                a2 = ae.a(jsonReader, dVar);
                break;
            case 4:
                a2 = m.a(jsonReader, dVar);
                break;
            case 5:
                a2 = c.a(jsonReader, dVar);
                break;
            case 6:
                a2 = ag.a(jsonReader, dVar);
                break;
            case 7:
                a2 = e.a(jsonReader, dVar, i);
                break;
            case '\b':
                a2 = aa.a(jsonReader, dVar);
                break;
            case '\t':
                a2 = ai.a(jsonReader, dVar);
                break;
            case '\n':
                a2 = z.a(jsonReader, dVar);
                break;
            case 11:
                a2 = v.a(jsonReader);
                dVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case '\f':
                a2 = ab.a(jsonReader, dVar);
                break;
            default:
                Log.w("LOTTIE", "Unknown shape type " + str);
                a2 = null;
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return a2;
    }
}
