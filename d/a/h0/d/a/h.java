package d.a.h0.d.a;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.service.network.Request;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.b.a f45674a;

        public a(d.a.h0.a.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45674a = aVar;
        }

        @Override // d.a.h0.d.a.k
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, th) == null) && this.f45674a.s()) {
                Log.e("ParallelCharge", "als on error response", th);
            }
        }

        @Override // d.a.h0.d.a.k
        public void b(long j, InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, inputStream) == null) {
            }
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && !TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
            d.a.h0.a.b.a aVar = d.a.h0.a.b.a.f45561a.get();
            Request.c cVar = new Request.c(aVar.o(), str);
            cVar.k("User-Agent", aVar.h());
            cVar.l().d(new a(aVar));
        }
    }
}
