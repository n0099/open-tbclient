package d.a.s0.k1.k;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.w2.w;
import java.util.List;
/* loaded from: classes9.dex */
public class c implements IAdBaseAsyncController.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f62589a;

    /* renamed from: b  reason: collision with root package name */
    public final String f62590b;

    public c(List<String> list, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62589a = str;
        this.f62590b = str2;
        d.a.s0.w2.b0.b bVar = (d.a.s0.w2.b0.b) w.p().l(IAdBaseAsyncController.Type.PIC_PAGE, this);
    }

    @Override // com.baidu.tieba.recapp.async.IAdBaseAsyncController.a
    public void a(@Nullable List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.r0.z0.c cVar = new d.a.r0.z0.c();
            cVar.l = this.f62589a;
            cVar.m = this.f62590b;
        }
    }
}
