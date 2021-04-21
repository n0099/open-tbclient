package d.b.h0.h.a.f.e.h;

import android.animation.TypeEvaluator;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes3.dex */
public class a implements TypeEvaluator<LatLng> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public LatLng evaluate(float f2, LatLng latLng, LatLng latLng2) {
        double d2 = latLng.latitude;
        double d3 = f2;
        double d4 = latLng.longitude;
        return new LatLng(d2 + ((latLng2.latitude - d2) * d3), d4 + (d3 * (latLng2.longitude - d4)));
    }
}
