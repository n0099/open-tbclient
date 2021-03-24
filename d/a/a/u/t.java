package d.a.a.u;

import android.graphics.Rect;
import android.util.JsonReader;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class t {
    public static d.a.a.d a(JsonReader jsonReader) throws IOException {
        SparseArrayCompat<d.a.a.s.d> sparseArrayCompat;
        HashMap hashMap;
        float e2 = d.a.a.v.f.e();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        SparseArrayCompat<d.a.a.s.d> sparseArrayCompat2 = new SparseArrayCompat<>();
        d.a.a.d dVar = new d.a.a.d();
        jsonReader.beginObject();
        int i = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i2 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1408207997:
                    if (nextName.equals("assets")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -1109732030:
                    if (nextName.equals("layers")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 118:
                    if (nextName.equals("v")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3276:
                    if (nextName.equals("fr")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3367:
                    if (nextName.equals("ip")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 94623709:
                    if (nextName.equals("chars")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 97615364:
                    if (nextName.equals("fonts")) {
                        c2 = '\b';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    sparseArrayCompat = sparseArrayCompat2;
                    hashMap = hashMap4;
                    i = jsonReader.nextInt();
                    continue;
                    hashMap4 = hashMap;
                    sparseArrayCompat2 = sparseArrayCompat;
                case 1:
                    sparseArrayCompat = sparseArrayCompat2;
                    hashMap = hashMap4;
                    i2 = jsonReader.nextInt();
                    continue;
                    hashMap4 = hashMap;
                    sparseArrayCompat2 = sparseArrayCompat;
                case 2:
                    sparseArrayCompat = sparseArrayCompat2;
                    hashMap = hashMap4;
                    f2 = (float) jsonReader.nextDouble();
                    continue;
                    hashMap4 = hashMap;
                    sparseArrayCompat2 = sparseArrayCompat;
                case 3:
                    sparseArrayCompat = sparseArrayCompat2;
                    hashMap = hashMap4;
                    f3 = ((float) jsonReader.nextDouble()) - 0.01f;
                    continue;
                    hashMap4 = hashMap;
                    sparseArrayCompat2 = sparseArrayCompat;
                case 4:
                    sparseArrayCompat = sparseArrayCompat2;
                    hashMap = hashMap4;
                    f4 = (float) jsonReader.nextDouble();
                    continue;
                    hashMap4 = hashMap;
                    sparseArrayCompat2 = sparseArrayCompat;
                case 5:
                    String[] split = jsonReader.nextString().split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    if (!d.a.a.v.f.h(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        dVar.a("Lottie only supports bodymovin >= 4.4.0");
                        break;
                    }
                    break;
                case 6:
                    e(jsonReader, dVar, arrayList, longSparseArray);
                    break;
                case 7:
                    b(jsonReader, dVar, hashMap2, hashMap3);
                    break;
                case '\b':
                    d(jsonReader, hashMap4);
                    break;
                case '\t':
                    c(jsonReader, dVar, sparseArrayCompat2);
                    break;
                default:
                    sparseArrayCompat = sparseArrayCompat2;
                    hashMap = hashMap4;
                    jsonReader.skipValue();
                    continue;
                    hashMap4 = hashMap;
                    sparseArrayCompat2 = sparseArrayCompat;
            }
            sparseArrayCompat = sparseArrayCompat2;
            hashMap = hashMap4;
            hashMap4 = hashMap;
            sparseArrayCompat2 = sparseArrayCompat;
        }
        jsonReader.endObject();
        dVar.n(new Rect(0, 0, (int) (i * e2), (int) (i2 * e2)), f2, f3, f4, arrayList, longSparseArray, hashMap2, hashMap3, sparseArrayCompat2, hashMap4);
        return dVar;
    }

    public static void b(JsonReader jsonReader, d.a.a.d dVar, Map<String, List<Layer>> map, Map<String, d.a.a.g> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 0;
            int i2 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c2 = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != -1109732030) {
                    if (hashCode != 104) {
                        if (hashCode != 112) {
                            if (hashCode != 117) {
                                if (hashCode != 119) {
                                    if (hashCode == 3355 && nextName.equals("id")) {
                                        c2 = 0;
                                    }
                                } else if (nextName.equals("w")) {
                                    c2 = 2;
                                }
                            } else if (nextName.equals("u")) {
                                c2 = 5;
                            }
                        } else if (nextName.equals("p")) {
                            c2 = 4;
                        }
                    } else if (nextName.equals("h")) {
                        c2 = 3;
                    }
                } else if (nextName.equals("layers")) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    str = jsonReader.nextString();
                } else if (c2 == 1) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        Layer a2 = s.a(jsonReader, dVar);
                        longSparseArray.put(a2.b(), a2);
                        arrayList.add(a2);
                    }
                    jsonReader.endArray();
                } else if (c2 == 2) {
                    i = jsonReader.nextInt();
                } else if (c2 == 3) {
                    i2 = jsonReader.nextInt();
                } else if (c2 == 4) {
                    str2 = jsonReader.nextString();
                } else if (c2 != 5) {
                    jsonReader.skipValue();
                } else {
                    str3 = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                d.a.a.g gVar = new d.a.a.g(i, i2, str, str2, str3);
                map2.put(gVar.d(), gVar);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.endArray();
    }

    public static void c(JsonReader jsonReader, d.a.a.d dVar, SparseArrayCompat<d.a.a.s.d> sparseArrayCompat) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            d.a.a.s.d a2 = j.a(jsonReader, dVar);
            sparseArrayCompat.put(a2.hashCode(), a2);
        }
        jsonReader.endArray();
    }

    public static void d(JsonReader jsonReader, Map<String, d.a.a.s.c> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            if (nextName.hashCode() == 3322014 && nextName.equals("list")) {
                c2 = 0;
            }
            if (c2 != 0) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    d.a.a.s.c a2 = k.a(jsonReader);
                    map.put(a2.b(), a2);
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
    }

    public static void e(JsonReader jsonReader, d.a.a.d dVar, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            Layer a2 = s.a(jsonReader, dVar);
            if (a2.d() == Layer.LayerType.Image) {
                i++;
            }
            list.add(a2);
            longSparseArray.put(a2.b(), a2);
            if (i > 4) {
                d.a.a.c.d("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }
}
