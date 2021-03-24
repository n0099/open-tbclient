package d.a.a.u;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.layer.Layer;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.fun.ad.sdk.FunAdSdk;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes.dex */
public class s {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Layer a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        char c2;
        char c3;
        Layer.MatteType matteType = Layer.MatteType.None;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.beginObject();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        boolean z = false;
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String str = null;
        d.a.a.s.i.l lVar = null;
        d.a.a.s.i.j jVar = null;
        d.a.a.s.i.k kVar = null;
        d.a.a.s.i.b bVar = null;
        long j = 0;
        long j2 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        float f4 = 1.0f;
        float f5 = 0.0f;
        int i4 = 0;
        int i5 = 0;
        String str2 = null;
        String str3 = "UNSET";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            switch (nextName.hashCode()) {
                case -995424086:
                    if (nextName.equals("parent")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -903568142:
                    if (nextName.equals("shapes")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c2 = 17;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        c2 = 16;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3177:
                    if (nextName.equals(Config.CELL_LOCATION)) {
                        c2 = 21;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3233:
                    if (nextName.equals("ef")) {
                        c2 = '\r';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3367:
                    if (nextName.equals("ip")) {
                        c2 = 18;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3432:
                    if (nextName.equals(FunAdSdk.PLATFORM_KS)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3519:
                    if (nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        c2 = 19;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3664:
                    if (nextName.equals(Config.STAT_SDK_CHANNEL)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3669:
                    if (nextName.equals(IXAdRequestInfo.SCREEN_HEIGHT)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3679:
                    if (nextName.equals("sr")) {
                        c2 = 14;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3681:
                    if (nextName.equals("st")) {
                        c2 = 15;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3705:
                    if (nextName.equals(IXAdRequestInfo.MAX_TITLE_LENGTH)) {
                        c2 = 20;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3712:
                    if (nextName.equals(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP)) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3717:
                    if (nextName.equals("ty")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 104415:
                    if (nextName.equals("ind")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 108390670:
                    if (nextName.equals("refId")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1441620890:
                    if (nextName.equals("masksProperties")) {
                        c2 = '\n';
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
                    str3 = jsonReader.nextString();
                    break;
                case 1:
                    j = jsonReader.nextInt();
                    break;
                case 2:
                    str = jsonReader.nextString();
                    break;
                case 3:
                    int nextInt = jsonReader.nextInt();
                    if (nextInt < Layer.LayerType.Unknown.ordinal()) {
                        layerType = Layer.LayerType.values()[nextInt];
                        break;
                    } else {
                        layerType = Layer.LayerType.Unknown;
                        break;
                    }
                case 4:
                    j2 = jsonReader.nextInt();
                    break;
                case 5:
                    i = (int) (jsonReader.nextInt() * d.a.a.v.f.e());
                    break;
                case 6:
                    i2 = (int) (jsonReader.nextInt() * d.a.a.v.f.e());
                    break;
                case 7:
                    i3 = Color.parseColor(jsonReader.nextString());
                    break;
                case '\b':
                    lVar = c.a(jsonReader, dVar);
                    break;
                case '\t':
                    matteType2 = Layer.MatteType.values()[jsonReader.nextInt()];
                    break;
                case '\n':
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList3.add(u.a(jsonReader, dVar));
                    }
                    jsonReader.endArray();
                    break;
                case 11:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        d.a.a.s.j.b a2 = g.a(jsonReader, dVar);
                        if (a2 != null) {
                            arrayList4.add(a2);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case '\f':
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        int hashCode = nextName2.hashCode();
                        if (hashCode != 97) {
                            if (hashCode == 100 && nextName2.equals("d")) {
                                c3 = 0;
                            }
                            c3 = 65535;
                        } else {
                            if (nextName2.equals("a")) {
                                c3 = 1;
                            }
                            c3 = 65535;
                        }
                        if (c3 == 0) {
                            jVar = d.d(jsonReader, dVar);
                        } else if (c3 != 1) {
                            jsonReader.skipValue();
                        } else {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                kVar = b.a(jsonReader, dVar);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case '\r':
                    jsonReader.beginArray();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName3 = jsonReader.nextName();
                            if (((nextName3.hashCode() == 3519 && nextName3.equals(SearchView.IME_OPTION_NO_MICROPHONE)) ? (char) 0 : (char) 65535) != 0) {
                                jsonReader.skipValue();
                            } else {
                                arrayList5.add(jsonReader.nextString());
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    dVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f4 = (float) jsonReader.nextDouble();
                    break;
                case 15:
                    f5 = (float) jsonReader.nextDouble();
                    break;
                case 16:
                    i4 = (int) (jsonReader.nextInt() * d.a.a.v.f.e());
                    break;
                case 17:
                    i5 = (int) (jsonReader.nextInt() * d.a.a.v.f.e());
                    break;
                case 18:
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case 19:
                    f3 = (float) jsonReader.nextDouble();
                    break;
                case 20:
                    bVar = d.f(jsonReader, dVar, z);
                    break;
                case 21:
                    str2 = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            z = false;
        }
        jsonReader.endObject();
        float f6 = f2 / f4;
        float f7 = f3 / f4;
        ArrayList arrayList6 = new ArrayList();
        if (f6 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new d.a.a.w.a(dVar, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f6)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f7 <= 0.0f) {
            f7 = dVar.f();
        }
        arrayList2.add(new d.a.a.w.a(dVar, valueOf, valueOf, null, f6, Float.valueOf(f7)));
        arrayList2.add(new d.a.a.w.a(dVar, valueOf2, valueOf2, null, f7, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || "ai".equals(str2)) {
            dVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, dVar, str3, j, layerType, j2, str, arrayList, lVar, i, i2, i3, f4, f5, i4, i5, jVar, kVar, arrayList2, matteType2, bVar);
    }

    public static Layer b(d.a.a.d dVar) {
        Rect b2 = dVar.b();
        return new Layer(Collections.emptyList(), dVar, "__container", -1L, Layer.LayerType.PreComp, -1L, null, Collections.emptyList(), new d.a.a.s.i.l(), 0, 0, 0, 0.0f, 0.0f, b2.width(), b2.height(), null, null, Collections.emptyList(), Layer.MatteType.None, null);
    }
}
