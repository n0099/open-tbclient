package d.a.s0.w2.h0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.w2.d;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends d.a.s0.q.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.q.b.b f69203h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull PlaceId placeId, @NonNull String str, @Nullable IAdBaseAsyncController.a aVar) {
        super(placeId, str, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {placeId, str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((PlaceId) objArr2[0], (String) objArr2[1], (IAdBaseAsyncController.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69203h = d.a.s0.q.b.b.d();
    }

    @Override // d.a.s0.q.b.a
    public void c(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f69203h.a(this.f64651a, list);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (d.e(System.currentTimeMillis(), this.f69203h.e(this.f64651a), i2)) {
                List<AdvertAppInfo> b2 = this.f69203h.b(this.f64651a);
                if (d.a.s0.n1.o.k.a.e(b2)) {
                    return;
                }
                for (AdvertAppInfo advertAppInfo : b2) {
                    d.a.s0.w2.i0.d.g(advertAppInfo, 0, 44);
                }
            }
        }
    }

    @Nullable
    public AdvertAppInfo i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69203h.c(this.f64651a) : (AdvertAppInfo) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f69203h.f(this.f64651a) : invokeV.booleanValue;
    }
}
