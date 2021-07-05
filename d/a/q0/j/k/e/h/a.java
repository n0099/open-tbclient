package d.a.q0.j.k.e.h;

import android.animation.TypeEvaluator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a implements TypeEvaluator<LatLng> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public LatLng evaluate(float f2, LatLng latLng, LatLng latLng2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), latLng, latLng2})) == null) {
            double d2 = latLng.latitude;
            double d3 = f2;
            double d4 = latLng.longitude;
            return new LatLng(d2 + ((latLng2.latitude - d2) * d3), d4 + (d3 * (latLng2.longitude - d4)));
        }
        return (LatLng) invokeCommon.objValue;
    }
}
