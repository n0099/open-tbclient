package d.a.q0.q.b;

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
import d.a.q0.w2.e;
import d.a.q0.w2.i0.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class a implements AdAsyncRequestModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PlaceId f62031a;

    /* renamed from: b  reason: collision with root package name */
    public String f62032b;

    /* renamed from: c  reason: collision with root package name */
    public int f62033c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62034d;

    /* renamed from: e  reason: collision with root package name */
    public AdAsyncRequestModel f62035e;

    /* renamed from: f  reason: collision with root package name */
    public long f62036f;

    /* renamed from: g  reason: collision with root package name */
    public final IAdBaseAsyncController.a f62037g;

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
        this.f62034d = false;
        this.f62036f = 0L;
        this.f62031a = placeId;
        this.f62032b = str;
        this.f62037g = aVar;
        this.f62035e = new AdAsyncRequestModel(this, this.f62031a);
    }

    @Override // com.baidu.tieba.ad.asyncpv.AdAsyncRequestModel.b
    public final void a(boolean z, List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
            if (z && !d.a.q0.n1.o.k.a.e(list)) {
                g(list);
                c(list);
                IAdBaseAsyncController.a aVar = this.f62037g;
                if (aVar != null) {
                    aVar.a(list);
                    return;
                }
                return;
            }
            IAdBaseAsyncController.a aVar2 = this.f62037g;
            if (aVar2 != null) {
                aVar2.a(null);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f62035e.c();
        }
    }

    public void c(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
        }
    }

    public void d(int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, map) == null) || System.currentTimeMillis() - this.f62036f < this.f62033c * e.f66562c) {
            return;
        }
        this.f62035e.d(map, i2);
        this.f62036f = System.currentTimeMillis();
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f62033c = i2;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f62034d = z;
        }
    }

    public void g(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.b4 = this.f62032b;
                if (d.a.q0.w2.a.n(next) && this.f62034d) {
                    it.remove();
                } else {
                    int z4 = next.z4();
                    if (z4 != 0) {
                        d.h(next, 0, z4);
                        it.remove();
                    }
                }
            }
        }
    }
}
