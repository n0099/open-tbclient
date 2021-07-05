package d.a.s0.n1.o.h;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.j.a.e;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f63793a;

    /* loaded from: classes9.dex */
    public class a extends BdAsyncTask<String, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f63794a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63794a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                HashMap c2 = this.f63794a.c();
                e eVar = new e();
                eVar.b().s(this.f63794a.f63793a);
                eVar.b().q(HttpMessageTask.HTTP_METHOD.GET);
                if (c2 != null && !c2.isEmpty()) {
                    eVar.b().p(this.f63794a.c());
                }
                new d.a.c.e.j.a.c(eVar).n(1, 0, 0);
                eVar.c();
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63793a = str;
    }

    public static b e(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.T3) == null || !(iLegoAdvert instanceof b)) {
                return null;
            }
            return (b) iLegoAdvert;
        }
        return (b) invokeL.objValue;
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        new c(str).d();
    }

    public static void g(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar) == null) || bVar == null || bVar.getParallelCharge() == null) {
            return;
        }
        f(bVar.getParallelCharge().f63790b);
        Iterator<String> it = bVar.getParallelCharge().f63791c.iterator();
        while (it.hasNext()) {
            f(it.next());
        }
    }

    public static boolean h(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bVar)) == null) {
            if (bVar == null || bVar.getParallelCharge() == null) {
                return false;
            }
            String str = bVar.getParallelCharge().f63789a;
            f(str);
            boolean z = !TextUtils.isEmpty(str);
            Iterator<String> it = bVar.getParallelCharge().f63792d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                z = z || !TextUtils.isEmpty(next);
                f(next);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final HashMap<String, String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = d.a.r0.l.a.f55367a;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("Cookie", cookie);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            new a(this).execute(new String[0]);
        }
    }
}
