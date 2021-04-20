package d.a.a.w;

import android.graphics.PointF;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonReader.a f41784a = JsonReader.a.a(SearchView.IME_OPTION_NO_MICROPHONE, "sy", Config.PLATFORM_TYPE, "p", com.baidu.mapsdkplatform.comapi.map.r.f7699a, "or", IAdRequestParam.OS, "ir", "is", "hd");

    public static PolystarShape a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        String str = null;
        PolystarShape.Type type = null;
        d.a.a.u.i.b bVar = null;
        d.a.a.u.i.m<PointF, PointF> mVar = null;
        d.a.a.u.i.b bVar2 = null;
        d.a.a.u.i.b bVar3 = null;
        d.a.a.u.i.b bVar4 = null;
        d.a.a.u.i.b bVar5 = null;
        d.a.a.u.i.b bVar6 = null;
        boolean z = false;
        while (jsonReader.t()) {
            switch (jsonReader.D(f41784a)) {
                case 0:
                    str = jsonReader.z();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.x());
                    break;
                case 2:
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                case 3:
                    mVar = a.b(jsonReader, dVar);
                    break;
                case 4:
                    bVar2 = d.f(jsonReader, dVar, false);
                    break;
                case 5:
                    bVar4 = d.e(jsonReader, dVar);
                    break;
                case 6:
                    bVar6 = d.f(jsonReader, dVar, false);
                    break;
                case 7:
                    bVar3 = d.e(jsonReader, dVar);
                    break;
                case 8:
                    bVar5 = d.f(jsonReader, dVar, false);
                    break;
                case 9:
                    z = jsonReader.v();
                    break;
                default:
                    jsonReader.E();
                    jsonReader.F();
                    break;
            }
        }
        return new PolystarShape(str, type, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6, z);
    }
}
