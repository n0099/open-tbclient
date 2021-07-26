package d.a.o0.a.u.e.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c2.f.p0.g;
import d.a.o0.a.u.c.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.u.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0910a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47969a;

        public C0910a(a aVar) {
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
            this.f47969a = aVar;
        }

        @Override // d.a.o0.a.u.c.d.b
        public d.a.o0.a.u.h.b a(d.a.o0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
                if (!TextUtils.isEmpty(optString)) {
                    this.f47969a.x(eVar, optString, str);
                    return new d.a.o0.a.u.h.b(0);
                }
                d.a.o0.a.e0.d.b("Api-LoadSubPackage", "subPackage root is null");
                return new d.a.o0.a.u.h.b(202);
            }
            return (d.a.o0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47970a;

        public b(a aVar) {
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
            this.f47970a = aVar;
        }

        @Override // d.a.o0.a.u.c.d.b
        public d.a.o0.a.u.h.b a(d.a.o0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("roots");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    this.f47970a.v(eVar, str, optJSONArray);
                    return new d.a.o0.a.u.h.b(0);
                }
                return new d.a.o0.a.u.h.b(202);
            }
            return (d.a.o0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f47971e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47972f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f47973g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f47974h;

        /* renamed from: d.a.o0.a.u.e.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0911a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f47975a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ List f47976b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f47977c;

            public C0911a(c cVar, CountDownLatch countDownLatch, List list, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, countDownLatch, list, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47975a = countDownLatch;
                this.f47976b = list;
                this.f47977c = str;
            }

            @Override // d.a.o0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.f47975a.countDown();
                    this.f47976b.add(this.f47977c);
                }
            }

            @Override // d.a.o0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    this.f47975a.countDown();
                    d.a.o0.a.e0.d.l("Api-LoadSubPackage", "downloadSubPackage fail, code=" + i2);
                }
            }
        }

        public c(a aVar, d.a.o0.a.a2.e eVar, String str, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, str, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47974h = aVar;
            this.f47971e = eVar;
            this.f47972f = str;
            this.f47973g = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String Z = this.f47971e.Z();
                if (!TextUtils.isDigitsOnly(Z)) {
                    a aVar = this.f47974h;
                    String str = this.f47972f;
                    aVar.d(str, new d.a.o0.a.u.h.b(202, "current version error:" + Z));
                    return;
                }
                List<d.a.o0.n.h.g> j = d.a.o0.n.g.a.h().j(this.f47971e.f43885f, Integer.parseInt(Z));
                ArraySet<String> arraySet = new ArraySet();
                List synchronizedList = Collections.synchronizedList(new ArrayList());
                for (int i2 = 0; i2 < this.f47973g.length(); i2++) {
                    String optString = this.f47973g.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        if (a.y(optString, j) && this.f47971e.k0(optString)) {
                            synchronizedList.add(optString);
                        } else {
                            arraySet.add(optString);
                        }
                    }
                }
                if (!arraySet.isEmpty()) {
                    CountDownLatch countDownLatch = new CountDownLatch(arraySet.size());
                    for (String str2 : arraySet) {
                        String G = this.f47971e.G(str2);
                        if (TextUtils.isEmpty(G)) {
                            countDownLatch.countDown();
                        } else {
                            d.a.o0.a.a2.e eVar = this.f47971e;
                            g.k(eVar.f43885f, eVar.Z(), "1", str2, G, null, new C0911a(this, countDownLatch, synchronizedList, str2));
                        }
                    }
                    try {
                        countDownLatch.await(1L, TimeUnit.MINUTES);
                    } catch (InterruptedException e2) {
                        d.a.o0.a.e0.d.c("Api-LoadSubPackage", "loadSubPackages", e2);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (int i3 = 0; i3 < this.f47973g.length(); i3++) {
                    try {
                        jSONObject.put(this.f47973g.optString(i3), synchronizedList.contains(this.f47973g.optString(i3)) ? 0 : 1001);
                    } catch (Exception e3) {
                        if (d.a.o0.a.u.c.d.f47942c) {
                            e3.printStackTrace();
                        }
                    }
                }
                this.f47974h.d(this.f47972f, new d.a.o0.a.u.h.b(0, jSONObject));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f47978e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47979f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47980g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f47981h;

        public d(a aVar, d.a.o0.a.a2.e eVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47981h = aVar;
            this.f47978e = eVar;
            this.f47979f = str;
            this.f47980g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f47978e.l0(this.f47979f) && this.f47978e.k0(this.f47979f)) {
                    d.a.o0.a.e0.d.g("Api-LoadSubPackage", "subPackage have existed");
                    this.f47981h.d(this.f47980g, new d.a.o0.a.u.h.b(1001, "subPackage have existed"));
                    return;
                }
                String G = this.f47978e.G(this.f47979f);
                if (!TextUtils.isEmpty(G)) {
                    this.f47981h.w(this.f47978e, this.f47979f, G, this.f47980g);
                    return;
                }
                d.a.o0.a.e0.d.g("Api-LoadSubPackage", "subPackage cannot find aps key");
                this.f47981h.d(this.f47980g, new d.a.o0.a.u.h.b(202));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47982a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f47983b;

        public e(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47983b = aVar;
            this.f47982a = str;
        }

        @Override // d.a.o0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.o0.a.e0.d.g("Api-LoadSubPackage", "preload subPackage success");
                this.f47983b.d(this.f47982a, new d.a.o0.a.u.h.b(0, "preload subPackage success"));
            }
        }

        @Override // d.a.o0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.o0.a.e0.d.b("Api-LoadSubPackage", "preload subPackage failed");
                this.f47983b.d(this.f47982a, new d.a.o0.a.u.h.b(202, "No SubPackage"));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.o0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean y(@Nullable String str, @Nullable List<d.a.o0.n.h.g> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, list)) == null) {
            if (str != null && list != null && !list.isEmpty()) {
                for (d.a.o0.n.h.g gVar : list) {
                    if (gVar != null && TextUtils.equals(gVar.p, str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public d.a.o0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? j(str, true, new b(this)) : (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final void v(d.a.o0.a.a2.e eVar, @Nullable String str, @NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, str, jSONArray) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this, eVar, str, jSONArray), "Api-LoadSubPackage", 2);
        }
    }

    public final void w(d.a.o0.a.a2.e eVar, String str, String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str, str2, str3) == null) {
            g.k(eVar.f43885f, eVar.Z(), "1", str, str2, null, new e(this, str3));
        }
    }

    public final void x(d.a.o0.a.a2.e eVar, String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, eVar, str, str2) == null) {
            ExecutorUtilsExt.postOnElastic(new d(this, eVar, str, str2), "doLoadSubPackageAsync", 2);
        }
    }

    public d.a.o0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-LoadSubPackage", "start pre load sub package");
            }
            return j(str, true, new C0910a(this));
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
