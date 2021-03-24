package d.a.a.u;

import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h0 {
    public static ShapeStroke a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        char c2;
        char c3;
        char c4;
        ArrayList arrayList = new ArrayList();
        String str = null;
        d.a.a.s.i.b bVar = null;
        d.a.a.s.i.a aVar = null;
        d.a.a.s.i.d dVar2 = null;
        d.a.a.s.i.b bVar2 = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f2 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == 99) {
                if (nextName.equals("c")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode == 100) {
                if (nextName.equals("d")) {
                    c2 = 7;
                }
                c2 = 65535;
            } else if (hashCode == 111) {
                if (nextName.equals(Config.OS)) {
                    c2 = 3;
                }
                c2 = 65535;
            } else if (hashCode == 119) {
                if (nextName.equals("w")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode == 3447) {
                if (nextName.equals("lc")) {
                    c2 = 4;
                }
                c2 = 65535;
            } else if (hashCode == 3454) {
                if (nextName.equals("lj")) {
                    c2 = 5;
                }
                c2 = 65535;
            } else if (hashCode != 3487) {
                if (hashCode == 3519 && nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (nextName.equals("ml")) {
                    c2 = 6;
                }
                c2 = 65535;
            }
            switch (c2) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    aVar = d.c(jsonReader, dVar);
                    break;
                case 2:
                    bVar2 = d.e(jsonReader, dVar);
                    break;
                case 3:
                    dVar2 = d.h(jsonReader, dVar);
                    break;
                case 4:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    break;
                case 5:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    break;
                case 6:
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String str2 = null;
                        d.a.a.s.i.b bVar3 = null;
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            int hashCode2 = nextName2.hashCode();
                            if (hashCode2 != 110) {
                                if (hashCode2 == 118 && nextName2.equals("v")) {
                                    c4 = 1;
                                }
                                c4 = 65535;
                            } else {
                                if (nextName2.equals("n")) {
                                    c4 = 0;
                                }
                                c4 = 65535;
                            }
                            if (c4 == 0) {
                                str2 = jsonReader.nextString();
                            } else if (c4 != 1) {
                                jsonReader.skipValue();
                            } else {
                                bVar3 = d.e(jsonReader, dVar);
                            }
                        }
                        jsonReader.endObject();
                        int hashCode3 = str2.hashCode();
                        if (hashCode3 == 100) {
                            if (str2.equals("d")) {
                                c3 = 1;
                            }
                            c3 = 65535;
                        } else if (hashCode3 != 103) {
                            if (hashCode3 == 111 && str2.equals(Config.OS)) {
                                c3 = 0;
                            }
                            c3 = 65535;
                        } else {
                            if (str2.equals("g")) {
                                c3 = 2;
                            }
                            c3 = 65535;
                        }
                        if (c3 != 0) {
                            if (c3 != 1 && c3 != 2) {
                            }
                            arrayList.add(bVar3);
                        } else {
                            bVar = bVar3;
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new ShapeStroke(str, bVar, arrayList, aVar, dVar2, bVar2, lineCapType, lineJoinType, f2);
    }
}
