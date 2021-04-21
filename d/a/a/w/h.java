package d.a.a.w;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes.dex */
public class h implements j0<DocumentData> {

    /* renamed from: a  reason: collision with root package name */
    public static final h f41846a = new h();

    /* renamed from: b  reason: collision with root package name */
    public static final JsonReader.a f41847b = JsonReader.a.a("t", "f", "s", "j", "tr", IAdRequestParam.QUERY_HEIGHT, "ls", "fc", Config.STAT_SDK_CHANNEL, "sw", "of");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.w.j0
    /* renamed from: b */
    public DocumentData a(JsonReader jsonReader, float f2) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.o();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        float f3 = 0.0f;
        int i = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f6 = 0.0f;
        boolean z = true;
        while (jsonReader.t()) {
            switch (jsonReader.D(f41847b)) {
                case 0:
                    str = jsonReader.z();
                    break;
                case 1:
                    str2 = jsonReader.z();
                    break;
                case 2:
                    f3 = (float) jsonReader.w();
                    break;
                case 3:
                    int x = jsonReader.x();
                    if (x <= DocumentData.Justification.CENTER.ordinal() && x >= 0) {
                        justification2 = DocumentData.Justification.values()[x];
                        break;
                    } else {
                        justification2 = DocumentData.Justification.CENTER;
                        break;
                    }
                case 4:
                    i = jsonReader.x();
                    break;
                case 5:
                    f4 = (float) jsonReader.w();
                    break;
                case 6:
                    f5 = (float) jsonReader.w();
                    break;
                case 7:
                    i2 = p.d(jsonReader);
                    break;
                case 8:
                    i3 = p.d(jsonReader);
                    break;
                case 9:
                    f6 = (float) jsonReader.w();
                    break;
                case 10:
                    z = jsonReader.v();
                    break;
                default:
                    jsonReader.E();
                    jsonReader.F();
                    break;
            }
        }
        jsonReader.r();
        return new DocumentData(str, str2, f3, justification2, i, f4, f5, i2, i3, f6, z);
    }
}
