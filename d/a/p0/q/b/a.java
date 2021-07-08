package d.a.p0.q.b;

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
import d.a.p0.w2.e;
import d.a.p0.w2.i0.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class a implements AdAsyncRequestModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PlaceId f61417a;

    /* renamed from: b  reason: collision with root package name */
    public String f61418b;

    /* renamed from: c  reason: collision with root package name */
    public int f61419c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61420d;

    /* renamed from: e  reason: collision with root package name */
    public AdAsyncRequestModel f61421e;

    /* renamed from: f  reason: collision with root package name */
    public long f61422f;

    /* renamed from: g  reason: collision with root package name */
    public final IAdBaseAsyncController.a f61423g;

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
        this.f61420d = false;
        this.f61422f = 0L;
        this.f61417a = placeId;
        this.f61418b = str;
        this.f61423g = aVar;
        this.f61421e = new AdAsyncRequestModel(this, this.f61417a);
    }

    @Override // com.baidu.tieba.ad.asyncpv.AdAsyncRequestModel.b
    public final void a(boolean z, List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
            if (z && !d.a.p0.n1.o.k.a.e(list)) {
                g(list);
                c(list);
                IAdBaseAsyncController.a aVar = this.f61423g;
                if (aVar != null) {
                    aVar.a(list);
                    return;
                }
                return;
            }
            IAdBaseAsyncController.a aVar2 = this.f61423g;
            if (aVar2 != null) {
                aVar2.a(null);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f61421e.c();
        }
    }

    public void c(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
        }
    }

    public void d(int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, map) == null) || System.currentTimeMillis() - this.f61422f < this.f61419c * e.f65887c) {
            return;
        }
        this.f61421e.d(map, i2);
        this.f61422f = System.currentTimeMillis();
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f61419c = i2;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f61420d = z;
        }
    }

    public void g(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.V3 = this.f61418b;
                if (d.a.p0.w2.a.n(next) && this.f61420d) {
                    it.remove();
                } else {
                    int w4 = next.w4();
                    if (w4 != 0) {
                        d.h(next, 0, w4);
                        it.remove();
                    }
                }
            }
        }
    }
}
