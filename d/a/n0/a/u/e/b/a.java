package d.a.n0.a.u.e.b;

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
import d.a.n0.a.c2.f.p0.g;
import d.a.n0.a.u.c.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.u.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0901a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47465a;

        public C0901a(a aVar) {
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
            this.f47465a = aVar;
        }

        @Override // d.a.n0.a.u.c.d.b
        public d.a.n0.a.u.h.b a(d.a.n0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
                if (!TextUtils.isEmpty(optString)) {
                    this.f47465a.x(eVar, optString, str);
                    return new d.a.n0.a.u.h.b(0);
                }
                d.a.n0.a.e0.d.b("Api-LoadSubPackage", "subPackage root is null");
                return new d.a.n0.a.u.h.b(202);
            }
            return (d.a.n0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47466a;

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
            this.f47466a = aVar;
        }

        @Override // d.a.n0.a.u.c.d.b
        public d.a.n0.a.u.h.b a(d.a.n0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("roots");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    this.f47466a.v(eVar, str, optJSONArray);
                    return new d.a.n0.a.u.h.b(0);
                }
                return new d.a.n0.a.u.h.b(202);
            }
            return (d.a.n0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f47467e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47468f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f47469g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f47470h;

        /* renamed from: d.a.n0.a.u.e.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0902a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f47471a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ List f47472b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f47473c;

            public C0902a(c cVar, CountDownLatch countDownLatch, List list, String str) {
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
                this.f47471a = countDownLatch;
                this.f47472b = list;
                this.f47473c = str;
            }

            @Override // d.a.n0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.f47471a.countDown();
                    this.f47472b.add(this.f47473c);
                }
            }

            @Override // d.a.n0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    this.f47471a.countDown();
                    d.a.n0.a.e0.d.l("Api-LoadSubPackage", "downloadSubPackage fail, code=" + i2);
                }
            }
        }

        public c(a aVar, d.a.n0.a.a2.e eVar, String str, JSONArray jSONArray) {
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
            this.f47470h = aVar;
            this.f47467e = eVar;
            this.f47468f = str;
            this.f47469g = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String Z = this.f47467e.Z();
                if (!TextUtils.isDigitsOnly(Z)) {
                    a aVar = this.f47470h;
                    String str = this.f47468f;
                    aVar.d(str, new d.a.n0.a.u.h.b(202, "current version error:" + Z));
                    return;
                }
                List<d.a.n0.n.h.g> j = d.a.n0.n.g.a.h().j(this.f47467e.f43381f, Integer.parseInt(Z));
                ArraySet<String> arraySet = new ArraySet();
                List synchronizedList = Collections.synchronizedList(new ArrayList());
                for (int i2 = 0; i2 < this.f47469g.length(); i2++) {
                    String optString = this.f47469g.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        if (a.y(optString, j) && this.f47467e.k0(optString)) {
                            synchronizedList.add(optString);
                        } else {
                            arraySet.add(optString);
                        }
                    }
                }
                if (!arraySet.isEmpty()) {
                    CountDownLatch countDownLatch = new CountDownLatch(arraySet.size());
                    for (String str2 : arraySet) {
                        String G = this.f47467e.G(str2);
                        if (TextUtils.isEmpty(G)) {
                            countDownLatch.countDown();
                        } else {
                            d.a.n0.a.a2.e eVar = this.f47467e;
                            g.k(eVar.f43381f, eVar.Z(), "1", str2, G, null, new C0902a(this, countDownLatch, synchronizedList, str2));
                        }
                    }
                    try {
                        countDownLatch.await(1L, TimeUnit.MINUTES);
                    } catch (InterruptedException e2) {
                        d.a.n0.a.e0.d.c("Api-LoadSubPackage", "loadSubPackages", e2);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (int i3 = 0; i3 < this.f47469g.length(); i3++) {
                    try {
                        jSONObject.put(this.f47469g.optString(i3), synchronizedList.contains(this.f47469g.optString(i3)) ? 0 : 1001);
                    } catch (Exception e3) {
                        if (d.a.n0.a.u.c.d.f47438c) {
                            e3.printStackTrace();
                        }
                    }
                }
                this.f47470h.d(this.f47468f, new d.a.n0.a.u.h.b(0, jSONObject));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f47474e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47475f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47476g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f47477h;

        public d(a aVar, d.a.n0.a.a2.e eVar, String str, String str2) {
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
            this.f47477h = aVar;
            this.f47474e = eVar;
            this.f47475f = str;
            this.f47476g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f47474e.l0(this.f47475f) && this.f47474e.k0(this.f47475f)) {
                    d.a.n0.a.e0.d.g("Api-LoadSubPackage", "subPackage have existed");
                    this.f47477h.d(this.f47476g, new d.a.n0.a.u.h.b(1001, "subPackage have existed"));
                    return;
                }
                String G = this.f47474e.G(this.f47475f);
                if (!TextUtils.isEmpty(G)) {
                    this.f47477h.w(this.f47474e, this.f47475f, G, this.f47476g);
                    return;
                }
                d.a.n0.a.e0.d.g("Api-LoadSubPackage", "subPackage cannot find aps key");
                this.f47477h.d(this.f47476g, new d.a.n0.a.u.h.b(202));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47478a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f47479b;

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
            this.f47479b = aVar;
            this.f47478a = str;
        }

        @Override // d.a.n0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.n0.a.e0.d.g("Api-LoadSubPackage", "preload subPackage success");
                this.f47479b.d(this.f47478a, new d.a.n0.a.u.h.b(0, "preload subPackage success"));
            }
        }

        @Override // d.a.n0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.n0.a.e0.d.b("Api-LoadSubPackage", "preload subPackage failed");
                this.f47479b.d(this.f47478a, new d.a.n0.a.u.h.b(202, "No SubPackage"));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.n0.a.u.c.b bVar) {
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
                super((d.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean y(@Nullable String str, @Nullable List<d.a.n0.n.h.g> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, list)) == null) {
            if (str != null && list != null && !list.isEmpty()) {
                for (d.a.n0.n.h.g gVar : list) {
                    if (gVar != null && TextUtils.equals(gVar.p, str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public d.a.n0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? j(str, true, new b(this)) : (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    public final void v(d.a.n0.a.a2.e eVar, @Nullable String str, @NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, str, jSONArray) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this, eVar, str, jSONArray), "Api-LoadSubPackage", 2);
        }
    }

    public final void w(d.a.n0.a.a2.e eVar, String str, String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str, str2, str3) == null) {
            g.k(eVar.f43381f, eVar.Z(), "1", str, str2, null, new e(this, str3));
        }
    }

    public final void x(d.a.n0.a.a2.e eVar, String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, eVar, str, str2) == null) {
            ExecutorUtilsExt.postOnElastic(new d(this, eVar, str, str2), "doLoadSubPackageAsync", 2);
        }
    }

    public d.a.n0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-LoadSubPackage", "start pre load sub package");
            }
            return j(str, true, new C0901a(this));
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }
}
