package com.ksad.lottie.c;

import android.graphics.Rect;
import android.util.JsonReader;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.ksad.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class t {
    public static com.ksad.lottie.d a(JsonReader jsonReader) {
        float a2 = com.ksad.lottie.d.f.a();
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        SparseArrayCompat<com.ksad.lottie.model.d> sparseArrayCompat = new SparseArrayCompat<>();
        com.ksad.lottie.d dVar = new com.ksad.lottie.d();
        jsonReader.beginObject();
        while (true) {
            int i3 = i2;
            int i4 = i;
            float f4 = f3;
            float f5 = f2;
            float f6 = f;
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                dVar.a(new Rect(0, 0, (int) (i4 * a2), (int) (i3 * a2)), f6, f5, f4, arrayList, longSparseArray, hashMap, hashMap2, sparseArrayCompat, hashMap3);
                return dVar;
            }
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1408207997:
                    if (nextName.equals("assets")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1109732030:
                    if (nextName.equals("layers")) {
                        c = 6;
                        break;
                    }
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c = 1;
                        break;
                    }
                    break;
                case 118:
                    if (nextName.equals("v")) {
                        c = 5;
                        break;
                    }
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3276:
                    if (nextName.equals("fr")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3367:
                    if (nextName.equals(TableDefine.UserInfoColumns.COLUMN_IP)) {
                        c = 2;
                        break;
                    }
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        c = 3;
                        break;
                    }
                    break;
                case 94623709:
                    if (nextName.equals("chars")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 97615364:
                    if (nextName.equals("fonts")) {
                        c = '\b';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    i4 = jsonReader.nextInt();
                    break;
                case 1:
                    i3 = jsonReader.nextInt();
                    break;
                case 2:
                    f6 = (float) jsonReader.nextDouble();
                    break;
                case 3:
                    f5 = ((float) jsonReader.nextDouble()) - 0.01f;
                    break;
                case 4:
                    f4 = (float) jsonReader.nextDouble();
                    break;
                case 5:
                    String[] split = jsonReader.nextString().split("\\.");
                    if (!com.ksad.lottie.d.f.a(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        dVar.a("Lottie only supports bodymovin >= 4.4.0");
                        break;
                    } else {
                        break;
                    }
                case 6:
                    a(jsonReader, dVar, arrayList, longSparseArray);
                    break;
                case 7:
                    a(jsonReader, dVar, hashMap, hashMap2);
                    break;
                case '\b':
                    a(jsonReader, hashMap3);
                    break;
                case '\t':
                    a(jsonReader, dVar, sparseArrayCompat);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            i2 = i3;
            i = i4;
            f3 = f4;
            f2 = f5;
            f = f6;
        }
    }

    private static void a(JsonReader jsonReader, com.ksad.lottie.d dVar, SparseArrayCompat<com.ksad.lottie.model.d> sparseArrayCompat) {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.ksad.lottie.model.d a2 = j.a(jsonReader, dVar);
            sparseArrayCompat.put(a2.hashCode(), a2);
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, com.ksad.lottie.d dVar, List<Layer> list, LongSparseArray<Layer> longSparseArray) {
        int i = 0;
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            Layer a2 = s.a(jsonReader, dVar);
            if (a2.k() == Layer.LayerType.Image) {
                i++;
            }
            list.add(a2);
            longSparseArray.put(a2.e(), a2);
            if (i > 4) {
                com.ksad.lottie.c.b("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, com.ksad.lottie.d dVar, Map<String, List<Layer>> map, Map<String, com.ksad.lottie.g> map2) {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            int i = 0;
            int i2 = 0;
            String str3 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -1109732030:
                        if (nextName.equals("layers")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 104:
                        if (nextName.equals("h")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 112:
                        if (nextName.equals("p")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 117:
                        if (nextName.equals("u")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 119:
                        if (nextName.equals("w")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 3355:
                        if (nextName.equals("id")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        str3 = jsonReader.nextString();
                        break;
                    case 1:
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            Layer a2 = s.a(jsonReader, dVar);
                            longSparseArray.put(a2.e(), a2);
                            arrayList.add(a2);
                        }
                        jsonReader.endArray();
                        break;
                    case 2:
                        i2 = jsonReader.nextInt();
                        break;
                    case 3:
                        i = jsonReader.nextInt();
                        break;
                    case 4:
                        str2 = jsonReader.nextString();
                        break;
                    case 5:
                        str = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                com.ksad.lottie.g gVar = new com.ksad.lottie.g(i2, i, str3, str2, str);
                map2.put(gVar.a(), gVar);
            } else {
                map.put(str3, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, Map<String, com.ksad.lottie.model.c> map) {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 3322014:
                    if (nextName.equals("list")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.ksad.lottie.model.c a2 = k.a(jsonReader);
                        map.put(a2.b(), a2);
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
    }
}
