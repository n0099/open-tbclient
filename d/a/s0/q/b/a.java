package d.a.s0.q.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.ad.asyncpv.AdAsyncRequestModel;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.w2.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class a implements AdAsyncRequestModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PlaceId f64651a;

    /* renamed from: b  reason: collision with root package name */
    public String f64652b;

    /* renamed from: c  reason: collision with root package name */
    public int f64653c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64654d;

    /* renamed from: e  reason: collision with root package name */
    public AdAsyncRequestModel f64655e;

    /* renamed from: f  reason: collision with root package name */
    public long f64656f;

    /* renamed from: g  reason: collision with root package name */
    public final IAdBaseAsyncController.a f64657g;

    public a(@NonNull PlaceId placeId, @NonNull String str, @Nullable IAdBaseAsyncController.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {placeId, str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64654d = false;
        this.f64656f = 0L;
        this.f64651a = placeId;
        this.f64652b = str;
        this.f64657g = aVar;
        this.f64655e = new AdAsyncRequestModel(this, this.f64651a);
    }

    @Override // com.baidu.tieba.ad.asyncpv.AdAsyncRequestModel.b
    public final void a(boolean z, List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
            if (z && !d.a.s0.n1.o.k.a.e(list)) {
                g(list);
                c(list);
                IAdBaseAsyncController.a aVar = this.f64657g;
                if (aVar != null) {
                    aVar.a(list);
                    return;
                }
                return;
            }
            IAdBaseAsyncController.a aVar2 = this.f64657g;
            if (aVar2 != null) {
                aVar2.a(null);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f64655e.b();
        }
    }

    public abstract void c(List<AdvertAppInfo> list);

    public void d(int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, map) == null) || System.currentTimeMillis() - this.f64656f < this.f64653c * d.f69102c) {
            return;
        }
        this.f64655e.c(map, i2);
        this.f64656f = System.currentTimeMillis();
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f64653c = i2;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f64654d = z;
        }
    }

    public void g(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.V3 = this.f64652b;
                if (d.a.s0.w2.a.l(next) && this.f64654d) {
                    it.remove();
                } else {
                    int w4 = next.w4();
                    if (w4 != 0) {
                        d.a.s0.w2.i0.d.g(next, 0, w4);
                        it.remove();
                    }
                }
            }
        }
    }
}
