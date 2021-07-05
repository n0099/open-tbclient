package d.a.s0.w2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.d.l;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e implements p, r {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile e f69104h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<d.a.c.e.d.l<String>> f69105a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicReference<d.a.c.e.d.l<String>> f69106b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, j> f69107c;

    /* renamed from: d  reason: collision with root package name */
    public int f69108d;

    /* renamed from: e  reason: collision with root package name */
    public String f69109e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f69110f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f69111g;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f69112e;

        /* renamed from: d.a.s0.w2.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1873a implements l.a<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f69113a;

            public C1873a(a aVar) {
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
                this.f69113a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.c.e.d.l.a
            /* renamed from: b */
            public void a(String str, String str2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                    return;
                }
                Iterator it = this.f69113a.f69112e.q(str2).iterator();
                while (it.hasNext()) {
                    j jVar = (j) it.next();
                    if (jVar != null) {
                        this.f69113a.f69112e.f69107c.put(jVar.f69235a, jVar);
                        this.f69113a.f69112e.f69110f = true;
                    }
                }
            }
        }

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69112e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.c.e.d.l lVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (lVar = (d.a.c.e.d.l) this.f69112e.f69105a.get()) == null) {
                return;
            }
            lVar.f(this.f69112e.f69109e, new C1873a(this));
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f69114e;

        /* loaded from: classes9.dex */
        public class a implements l.a<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f69115a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f69115a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.c.e.d.l.a
            /* renamed from: b */
            public void a(String str, String str2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    this.f69115a.f69114e.f69108d = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    this.f69115a.f69114e.f69108d = 0;
                }
                this.f69115a.f69114e.f69111g = true;
            }
        }

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69114e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((d.a.c.e.d.l) this.f69114e.f69106b.get()).f(this.f69114e.f69109e, new a(this));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReference<d.a.c.e.d.l<String>> f69116a;

        /* renamed from: b  reason: collision with root package name */
        public final String f69117b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f69118c;

        public /* synthetic */ c(AtomicReference atomicReference, String str, Runnable runnable, a aVar) {
            this(atomicReference, str, runnable);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                super.onPostExecute(r5);
                Runnable runnable = this.f69118c;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        public c(AtomicReference<d.a.c.e.d.l<String>> atomicReference, String str, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReference, str, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69116a = atomicReference;
            this.f69117b = str;
            this.f69118c = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                if (this.f69116a.get() != null) {
                    return null;
                }
                synchronized (c.class) {
                    if (this.f69116a.get() == null) {
                        this.f69116a.set(d.a.r0.r.r.a.f().g(this.f69117b));
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69105a = new AtomicReference<>(null);
        this.f69106b = new AtomicReference<>(null);
        this.f69110f = false;
        this.f69111g = false;
        this.f69107c = new HashMap<>();
        this.f69108d = 0;
        this.f69109e = r();
    }

    public static e t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f69104h == null) {
                synchronized (e.class) {
                    if (f69104h == null) {
                        f69104h = new e();
                    }
                }
            }
            return f69104h;
        }
        return (e) invokeV.objValue;
    }

    @Override // d.a.s0.w2.r
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (v(r())) {
                return this.f69108d;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.s0.w2.r
    public void b() {
        d.a.c.e.d.l<String> lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (lVar = this.f69106b.get()) == null) {
            return;
        }
        p();
        int i2 = this.f69108d + 1;
        this.f69108d = i2;
        lVar.i(this.f69109e, Integer.toString(i2), 86400000L);
    }

    @Override // d.a.s0.w2.r
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f69111g) {
            return;
        }
        b bVar = new b(this);
        if (this.f69106b.get() == null) {
            new c(this.f69106b, "hot.splash.count", bVar, null).execute(new Void[0]);
        }
    }

    @Override // d.a.s0.w2.p
    public int d(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) ? s(str, true, z) : invokeLZ.intValue;
    }

    @Override // d.a.s0.w2.p
    public int e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) ? s(str, false, z) : invokeLZ.intValue;
    }

    @Override // d.a.s0.w2.p
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f69110f) {
            return;
        }
        a aVar = new a(this);
        if (this.f69105a.get() == null) {
            new c(this.f69105a, "frs.refresh.count", aVar, null).execute(new Void[0]);
        }
    }

    @Override // d.a.s0.w2.p
    public void g(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 1) {
                u(str, true, z);
            } else if (i2 == 2) {
                u(str, false, z);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String r = r();
            if (v(r)) {
                return;
            }
            this.f69107c.clear();
            this.f69108d = 0;
            this.f69109e = r;
        }
    }

    public final ArrayList<j> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            ArrayList<j> arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(new j(jSONArray.optJSONObject(i2)));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new SimpleDateFormat("yyyy-MM-dd").format(new Date()) : (String) invokeV.objValue;
    }

    public final int s(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            j jVar = this.f69107c.get(str);
            if (jVar == null || !v(r())) {
                return 0;
            }
            return jVar.b(z, z2);
        }
        return invokeCommon.intValue;
    }

    public final void u(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            p();
            j jVar = this.f69107c.get(str);
            if (jVar == null) {
                jVar = new j();
                jVar.f69235a = str;
                this.f69107c.put(str, jVar);
            }
            jVar.a(z, z2);
            w(this.f69107c);
        }
    }

    public final boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(this.f69109e)) {
                return false;
            }
            return this.f69109e.equals(str);
        }
        return invokeL.booleanValue;
    }

    public final synchronized void w(HashMap<String, j> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hashMap) == null) {
            synchronized (this) {
                d.a.c.e.d.l<String> lVar = this.f69105a.get();
                if (lVar == null) {
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, j> entry : hashMap.entrySet()) {
                    JSONObject c2 = entry.getValue().c();
                    if (c2 != null) {
                        jSONArray.put(c2);
                    }
                }
                lVar.i(this.f69109e, jSONArray.toString(), 86400000L);
            }
        }
    }
}
