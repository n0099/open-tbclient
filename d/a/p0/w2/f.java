package d.a.p0.w2;

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
/* loaded from: classes8.dex */
public class f implements p, r {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile f f65888h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<d.a.c.e.d.l<String>> f65889a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicReference<d.a.c.e.d.l<String>> f65890b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, k> f65891c;

    /* renamed from: d  reason: collision with root package name */
    public int f65892d;

    /* renamed from: e  reason: collision with root package name */
    public String f65893e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65894f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65895g;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f65896e;

        /* renamed from: d.a.p0.w2.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1831a implements l.a<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65897a;

            public C1831a(a aVar) {
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
                this.f65897a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.c.e.d.l.a
            /* renamed from: b */
            public void a(String str, String str2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                    return;
                }
                Iterator it = this.f65897a.f65896e.q(str2).iterator();
                while (it.hasNext()) {
                    k kVar = (k) it.next();
                    if (kVar != null) {
                        this.f65897a.f65896e.f65891c.put(kVar.f66052a, kVar);
                        this.f65897a.f65896e.f65894f = true;
                    }
                }
            }
        }

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65896e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.c.e.d.l lVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (lVar = (d.a.c.e.d.l) this.f65896e.f65889a.get()) == null) {
                return;
            }
            lVar.f(this.f65896e.f65893e, new C1831a(this));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f65898e;

        /* loaded from: classes8.dex */
        public class a implements l.a<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f65899a;

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
                this.f65899a = bVar;
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
                    this.f65899a.f65898e.f65892d = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    this.f65899a.f65898e.f65892d = 0;
                }
                this.f65899a.f65898e.f65895g = true;
            }
        }

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65898e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((d.a.c.e.d.l) this.f65898e.f65890b.get()).f(this.f65898e.f65893e, new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReference<d.a.c.e.d.l<String>> f65900a;

        /* renamed from: b  reason: collision with root package name */
        public final String f65901b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f65902c;

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
                Runnable runnable = this.f65902c;
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
            this.f65900a = atomicReference;
            this.f65901b = str;
            this.f65902c = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                if (this.f65900a.get() != null) {
                    return null;
                }
                synchronized (c.class) {
                    if (this.f65900a.get() == null) {
                        this.f65900a.set(d.a.o0.r.r.a.f().g(this.f65901b));
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public f() {
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
        this.f65889a = new AtomicReference<>(null);
        this.f65890b = new AtomicReference<>(null);
        this.f65894f = false;
        this.f65895g = false;
        this.f65891c = new HashMap<>();
        this.f65892d = 0;
        this.f65893e = r();
    }

    public static f t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f65888h == null) {
                synchronized (f.class) {
                    if (f65888h == null) {
                        f65888h = new f();
                    }
                }
            }
            return f65888h;
        }
        return (f) invokeV.objValue;
    }

    @Override // d.a.p0.w2.r
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (v(r())) {
                return this.f65892d;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.w2.r
    public void b() {
        d.a.c.e.d.l<String> lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (lVar = this.f65890b.get()) == null) {
            return;
        }
        p();
        int i2 = this.f65892d + 1;
        this.f65892d = i2;
        lVar.i(this.f65893e, Integer.toString(i2), 86400000L);
    }

    @Override // d.a.p0.w2.r
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f65895g) {
            return;
        }
        b bVar = new b(this);
        if (this.f65890b.get() == null) {
            new c(this.f65890b, "hot.splash.count", bVar, null).execute(new Void[0]);
        }
    }

    @Override // d.a.p0.w2.p
    public int d(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) ? s(str, true, z) : invokeLZ.intValue;
    }

    @Override // d.a.p0.w2.p
    public int e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) ? s(str, false, z) : invokeLZ.intValue;
    }

    @Override // d.a.p0.w2.p
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f65894f) {
            return;
        }
        a aVar = new a(this);
        if (this.f65889a.get() == null) {
            new c(this.f65889a, "frs.refresh.count", aVar, null).execute(new Void[0]);
        }
    }

    @Override // d.a.p0.w2.p
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
            this.f65891c.clear();
            this.f65892d = 0;
            this.f65893e = r;
        }
    }

    public final ArrayList<k> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            ArrayList<k> arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(new k(jSONArray.optJSONObject(i2)));
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
            k kVar = this.f65891c.get(str);
            if (kVar == null || !v(r())) {
                return 0;
            }
            return kVar.b(z, z2);
        }
        return invokeCommon.intValue;
    }

    public final void u(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            p();
            k kVar = this.f65891c.get(str);
            if (kVar == null) {
                kVar = new k();
                kVar.f66052a = str;
                this.f65891c.put(str, kVar);
            }
            kVar.a(z, z2);
            w(this.f65891c);
        }
    }

    public final boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(this.f65893e)) {
                return false;
            }
            return this.f65893e.equals(str);
        }
        return invokeL.booleanValue;
    }

    public final synchronized void w(HashMap<String, k> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hashMap) == null) {
            synchronized (this) {
                d.a.c.e.d.l<String> lVar = this.f65889a.get();
                if (lVar == null) {
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, k> entry : hashMap.entrySet()) {
                    JSONObject c2 = entry.getValue().c();
                    if (c2 != null) {
                        jSONArray.put(c2);
                    }
                }
                lVar.i(this.f65893e, jSONArray.toString(), 86400000L);
            }
        }
    }
}
