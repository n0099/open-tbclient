package d.a.a.w;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonReader.a f41872a = JsonReader.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b  reason: collision with root package name */
    public static JsonReader.a f41873b = JsonReader.a.a("id", "layers", "w", "h", "p", "u");

    /* renamed from: c  reason: collision with root package name */
    public static final JsonReader.a f41874c = JsonReader.a.a("list");

    /* renamed from: d  reason: collision with root package name */
    public static final JsonReader.a f41875d = JsonReader.a.a("cm", "tm", "dr");

    public static d.a.a.d a(JsonReader jsonReader) throws IOException {
        HashMap hashMap;
        ArrayList arrayList;
        JsonReader jsonReader2 = jsonReader;
        float e2 = d.a.a.x.h.e();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<d.a.a.u.c> sparseArrayCompat = new SparseArrayCompat<>();
        d.a.a.d dVar = new d.a.a.d();
        jsonReader.o();
        int i = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i2 = 0;
        while (jsonReader.t()) {
            switch (jsonReader2.D(f41872a)) {
                case 0:
                    i = jsonReader.x();
                    continue;
                    jsonReader2 = jsonReader;
                case 1:
                    i2 = jsonReader.x();
                    continue;
                    jsonReader2 = jsonReader;
                case 2:
                    f2 = (float) jsonReader.w();
                    continue;
                    jsonReader2 = jsonReader;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f3 = ((float) jsonReader.w()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f4 = (float) jsonReader.w();
                    break;
                case 5:
                    String[] split = jsonReader.z().split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    if (!d.a.a.x.h.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        dVar.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 6:
                    e(jsonReader2, dVar, arrayList2, longSparseArray);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 7:
                    b(jsonReader2, dVar, hashMap2, hashMap3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 8:
                    d(jsonReader2, hashMap4);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 9:
                    c(jsonReader2, dVar, sparseArrayCompat);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 10:
                    f(jsonReader2, dVar, arrayList3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    jsonReader.E();
                    jsonReader.F();
                    break;
            }
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            jsonReader2 = jsonReader;
        }
        dVar.r(new Rect(0, 0, (int) (i * e2), (int) (i2 * e2)), f2, f3, f4, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
        return dVar;
    }

    public static void b(JsonReader jsonReader, d.a.a.d dVar, Map<String, List<Layer>> map, Map<String, d.a.a.g> map2) throws IOException {
        jsonReader.n();
        while (jsonReader.t()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.o();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 0;
            int i2 = 0;
            while (jsonReader.t()) {
                int D = jsonReader.D(f41873b);
                if (D == 0) {
                    str = jsonReader.z();
                } else if (D == 1) {
                    jsonReader.n();
                    while (jsonReader.t()) {
                        Layer b2 = s.b(jsonReader, dVar);
                        longSparseArray.put(b2.b(), b2);
                        arrayList.add(b2);
                    }
                    jsonReader.q();
                } else if (D == 2) {
                    i = jsonReader.x();
                } else if (D == 3) {
                    i2 = jsonReader.x();
                } else if (D == 4) {
                    str2 = jsonReader.z();
                } else if (D != 5) {
                    jsonReader.E();
                    jsonReader.F();
                } else {
                    str3 = jsonReader.z();
                }
            }
            jsonReader.r();
            if (str2 != null) {
                d.a.a.g gVar = new d.a.a.g(i, i2, str, str2, str3);
                map2.put(gVar.e(), gVar);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.q();
    }

    public static void c(JsonReader jsonReader, d.a.a.d dVar, SparseArrayCompat<d.a.a.u.c> sparseArrayCompat) throws IOException {
        jsonReader.n();
        while (jsonReader.t()) {
            d.a.a.u.c a2 = j.a(jsonReader, dVar);
            sparseArrayCompat.put(a2.hashCode(), a2);
        }
        jsonReader.q();
    }

    public static void d(JsonReader jsonReader, Map<String, d.a.a.u.b> map) throws IOException {
        jsonReader.o();
        while (jsonReader.t()) {
            if (jsonReader.D(f41874c) != 0) {
                jsonReader.E();
                jsonReader.F();
            } else {
                jsonReader.n();
                while (jsonReader.t()) {
                    d.a.a.u.b a2 = k.a(jsonReader);
                    map.put(a2.b(), a2);
                }
                jsonReader.q();
            }
        }
        jsonReader.r();
    }

    public static void e(JsonReader jsonReader, d.a.a.d dVar, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.n();
        int i = 0;
        while (jsonReader.t()) {
            Layer b2 = s.b(jsonReader, dVar);
            if (b2.d() == Layer.LayerType.IMAGE) {
                i++;
            }
            list.add(b2);
            longSparseArray.put(b2.b(), b2);
            if (i > 4) {
                d.a.a.x.d.c("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.q();
    }

    public static void f(JsonReader jsonReader, d.a.a.d dVar, List<d.a.a.u.g> list) throws IOException {
        jsonReader.n();
        while (jsonReader.t()) {
            String str = null;
            jsonReader.o();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (jsonReader.t()) {
                int D = jsonReader.D(f41875d);
                if (D == 0) {
                    str = jsonReader.z();
                } else if (D == 1) {
                    f2 = (float) jsonReader.w();
                } else if (D != 2) {
                    jsonReader.E();
                    jsonReader.F();
                } else {
                    f3 = (float) jsonReader.w();
                }
            }
            jsonReader.r();
            list.add(new d.a.a.u.g(str, f2, f3));
        }
        jsonReader.q();
    }
}
