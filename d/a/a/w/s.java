package d.a.a.w;

import android.graphics.Color;
import android.graphics.Rect;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.fun.ad.sdk.FunAdSdk;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonReader.a f41868a = JsonReader.a.a(SearchView.IME_OPTION_NO_MICROPHONE, "ind", "refId", "ty", "parent", "sw", IAdRequestParam.SCREEN_HEIGHT, Config.STAT_SDK_CHANNEL, FunAdSdk.PLATFORM_KS, PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", Config.CELL_LOCATION, "hd");

    /* renamed from: b  reason: collision with root package name */
    public static final JsonReader.a f41869b = JsonReader.a.a("d", "a");

    /* renamed from: c  reason: collision with root package name */
    public static final JsonReader.a f41870c = JsonReader.a.a(SearchView.IME_OPTION_NO_MICROPHONE);

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41871a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f41871a = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41871a[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Layer a(d.a.a.d dVar) {
        Rect b2 = dVar.b();
        return new Layer(Collections.emptyList(), dVar, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new d.a.a.u.i.l(), 0, 0, 0, 0.0f, 0.0f, b2.width(), b2.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false);
    }

    public static Layer b(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.o();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String str = null;
        d.a.a.u.i.l lVar = null;
        d.a.a.u.i.j jVar = null;
        d.a.a.u.i.k kVar = null;
        d.a.a.u.i.b bVar = null;
        long j = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        float f4 = 1.0f;
        float f5 = 0.0f;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        long j2 = 0;
        String str2 = null;
        String str3 = "UNSET";
        while (jsonReader.t()) {
            switch (jsonReader.D(f41868a)) {
                case 0:
                    str3 = jsonReader.z();
                    break;
                case 1:
                    j2 = jsonReader.x();
                    break;
                case 2:
                    str = jsonReader.z();
                    break;
                case 3:
                    int x = jsonReader.x();
                    if (x < Layer.LayerType.UNKNOWN.ordinal()) {
                        layerType = Layer.LayerType.values()[x];
                        break;
                    } else {
                        layerType = Layer.LayerType.UNKNOWN;
                        break;
                    }
                case 4:
                    j = jsonReader.x();
                    break;
                case 5:
                    i = (int) (jsonReader.x() * d.a.a.x.h.e());
                    break;
                case 6:
                    i2 = (int) (jsonReader.x() * d.a.a.x.h.e());
                    break;
                case 7:
                    i3 = Color.parseColor(jsonReader.z());
                    break;
                case 8:
                    lVar = c.g(jsonReader, dVar);
                    break;
                case 9:
                    int x2 = jsonReader.x();
                    if (x2 >= Layer.MatteType.values().length) {
                        dVar.a("Unsupported matte type: " + x2);
                        break;
                    } else {
                        matteType2 = Layer.MatteType.values()[x2];
                        int i6 = a.f41871a[matteType2.ordinal()];
                        if (i6 == 1) {
                            dVar.a("Unsupported matte type: Luma");
                        } else if (i6 == 2) {
                            dVar.a("Unsupported matte type: Luma Inverted");
                        }
                        dVar.q(1);
                        break;
                    }
                case 10:
                    jsonReader.n();
                    while (jsonReader.t()) {
                        arrayList3.add(u.a(jsonReader, dVar));
                    }
                    dVar.q(arrayList3.size());
                    jsonReader.q();
                    break;
                case 11:
                    jsonReader.n();
                    while (jsonReader.t()) {
                        d.a.a.u.j.b a2 = g.a(jsonReader, dVar);
                        if (a2 != null) {
                            arrayList4.add(a2);
                        }
                    }
                    jsonReader.q();
                    break;
                case 12:
                    jsonReader.o();
                    while (jsonReader.t()) {
                        int D = jsonReader.D(f41869b);
                        if (D == 0) {
                            jVar = d.d(jsonReader, dVar);
                        } else if (D != 1) {
                            jsonReader.E();
                            jsonReader.F();
                        } else {
                            jsonReader.n();
                            if (jsonReader.t()) {
                                kVar = b.a(jsonReader, dVar);
                            }
                            while (jsonReader.t()) {
                                jsonReader.F();
                            }
                            jsonReader.q();
                        }
                    }
                    jsonReader.r();
                    break;
                case 13:
                    jsonReader.n();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.t()) {
                        jsonReader.o();
                        while (jsonReader.t()) {
                            if (jsonReader.D(f41870c) != 0) {
                                jsonReader.E();
                                jsonReader.F();
                            } else {
                                arrayList5.add(jsonReader.z());
                            }
                        }
                        jsonReader.r();
                    }
                    jsonReader.q();
                    dVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f4 = (float) jsonReader.w();
                    break;
                case 15:
                    f5 = (float) jsonReader.w();
                    break;
                case 16:
                    i4 = (int) (jsonReader.x() * d.a.a.x.h.e());
                    break;
                case 17:
                    i5 = (int) (jsonReader.x() * d.a.a.x.h.e());
                    break;
                case 18:
                    f2 = (float) jsonReader.w();
                    break;
                case 19:
                    f3 = (float) jsonReader.w();
                    break;
                case 20:
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                case 21:
                    str2 = jsonReader.z();
                    break;
                case 22:
                    z = jsonReader.v();
                    break;
                default:
                    jsonReader.E();
                    jsonReader.F();
                    break;
            }
        }
        jsonReader.r();
        float f6 = f2 / f4;
        float f7 = f3 / f4;
        ArrayList arrayList6 = new ArrayList();
        if (f6 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new d.a.a.y.a(dVar, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f6)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f7 <= 0.0f) {
            f7 = dVar.f();
        }
        arrayList2.add(new d.a.a.y.a(dVar, valueOf, valueOf, null, f6, Float.valueOf(f7)));
        arrayList2.add(new d.a.a.y.a(dVar, valueOf2, valueOf2, null, f7, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || "ai".equals(str2)) {
            dVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, dVar, str3, j2, layerType, j, str, arrayList, lVar, i, i2, i3, f4, f5, i4, i5, jVar, kVar, arrayList2, matteType2, bVar, z);
    }
}
