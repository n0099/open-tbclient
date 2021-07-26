package d.a.o0.a.h0.g;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.l1.c;
import d.a.o0.o.a.a.l;
import d.a.o0.o.a.a.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45210e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f45211f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f45212g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f45213h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f45214i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public l f45215a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d> f45216b;

    /* renamed from: c  reason: collision with root package name */
    public Queue<Runnable> f45217c;

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f45218d;

    /* loaded from: classes7.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public n f45219a;

        /* renamed from: b  reason: collision with root package name */
        public String f45220b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f45221c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f45222e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f45223f;

            public a(b bVar, d dVar, d dVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dVar, dVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45222e = dVar;
                this.f45223f = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f45222e;
                    if (dVar != null && dVar.V()) {
                        this.f45222e.m1(false);
                    }
                    d dVar2 = this.f45222e;
                    if (dVar2 instanceof f) {
                        ((f) dVar2).K3();
                    }
                    this.f45223f.m1(true);
                }
            }
        }

        /* renamed from: d.a.o0.a.h0.g.g$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0739b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f45224e;

            public RunnableC0739b(b bVar, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45224e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f45224e) == null) {
                    return;
                }
                dVar.m1(true);
            }
        }

        /* loaded from: classes7.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f45225e;

            public c(b bVar, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45225e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f45225e) == null) {
                    return;
                }
                dVar.m1(false);
            }
        }

        public b(g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45221c = gVar;
            this.f45219a = gVar.f45215a.a();
            this.f45220b = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.f45220b)) {
                    f.F3(this.f45220b);
                }
                while (!this.f45221c.f45217c.isEmpty()) {
                    if (this.f45221c.f45217c.peek() != null) {
                        ((Runnable) this.f45221c.f45217c.poll()).run();
                    }
                }
                d();
                this.f45219a.e();
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                a();
                return this.f45221c.f45215a.c();
            }
            return invokeV.booleanValue;
        }

        public void c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                n nVar = this.f45219a;
                nVar.f(dVar);
                nVar.e();
                this.f45221c.f45215a.c();
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f45221c.f45216b.isEmpty()) {
                return;
            }
            int size = this.f45221c.f45216b.size();
            int i2 = size - 1;
            for (int i3 = i2; i3 >= 0; i3--) {
                if (i3 >= i2) {
                    if (g.f45210e) {
                        Log.d("SwanAppFragmentManager", "show fragment i " + i3 + " ,size: " + size);
                    }
                    this.f45219a.i((Fragment) this.f45221c.f45216b.get(i3));
                } else {
                    this.f45219a.f((Fragment) this.f45221c.f45216b.get(i3));
                }
            }
        }

        public final boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? g.f45211f.contains(str) : invokeL.booleanValue;
        }

        public b f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                List<Fragment> d2 = this.f45221c.f45215a.d();
                if (d2 != null && d2.size() != this.f45221c.f45216b.size()) {
                    for (Fragment fragment : d2) {
                        if (fragment != null && !this.f45221c.f45216b.contains(fragment)) {
                            if (g.f45210e) {
                                Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                            }
                            for (a aVar : this.f45221c.f45218d) {
                                if (aVar != null) {
                                    aVar.b(fragment);
                                }
                            }
                            this.f45219a.g(fragment);
                        }
                    }
                }
                h(this.f45221c.f45216b.size());
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                h(1);
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                if (this.f45221c.f45216b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.f45221c.f45216b.clone();
                int size = arrayList.size();
                int i3 = size - i2;
                d dVar = (i3 < 0 || i2 <= 0) ? null : (d) arrayList.get(i3);
                while (true) {
                    size--;
                    if (size <= i3 - 1 || size < 0) {
                        break;
                    }
                    for (a aVar : this.f45221c.f45218d) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(size));
                        }
                    }
                    this.f45219a.g((Fragment) arrayList.get(size));
                    this.f45221c.f45216b.remove(size);
                }
                this.f45221c.f45217c.offer(new c(this, dVar));
                q();
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.f45221c.f45216b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.f45221c.f45216b.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((d) arrayList.get(size)).Z1()) {
                        this.f45219a.g((Fragment) arrayList.get(size));
                        this.f45221c.f45216b.remove(size);
                    }
                }
                q();
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b j(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, dVar)) == null) {
                r(dVar);
                this.f45219a.b(d.a.o0.a.f.ai_apps_container, dVar, "SwanAppFragment");
                this.f45221c.f45216b.add(dVar);
                for (a aVar : this.f45221c.f45218d) {
                    if (aVar != null) {
                        aVar.a(dVar);
                    }
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b k(String str, d.a.o0.a.l1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bVar)) == null) ? l(str, bVar, false) : (b) invokeLL.objValue;
        }

        @Nullable
        public b l(String str, d.a.o0.a.l1.b bVar, boolean z) {
            InterceptResult invokeLLZ;
            d M2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, bVar, z)) == null) {
                if ("about".equals(str)) {
                    M2 = d.a.o0.a.h0.g.a.d3();
                } else if ("authority".equals(str)) {
                    M2 = d.a.o0.a.h0.g.c.S2();
                } else if ("pluginFunPage".equals(str)) {
                    M2 = h.L2(bVar.f46495g, bVar.f46494f);
                } else if (e(str)) {
                    M2 = k.P2(bVar, str);
                } else if (TextUtils.equals("settings", str)) {
                    M2 = j.I2();
                } else if ("normal".equals(str)) {
                    c.a aVar = new c.a();
                    aVar.d(bVar.f46493e);
                    aVar.e(bVar.f46494f);
                    aVar.b(bVar.f46495g);
                    aVar.c(z);
                    M2 = f.z3(aVar.a());
                } else {
                    M2 = "running_info".equals(str) ? i.M2() : null;
                }
                if (M2 == null) {
                    return null;
                }
                j(M2);
                return this;
            }
            return (b) invokeLLZ.objValue;
        }

        public b m(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                int size = this.f45221c.f45216b.size();
                if (!this.f45221c.f45216b.isEmpty() && i2 >= 0 && i2 < size) {
                    this.f45219a.g((d) this.f45221c.f45216b.remove(i2));
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b n(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i2, i3)) == null) {
                this.f45219a.h(i2, i3);
                return this;
            }
            return (b) invokeII.objValue;
        }

        public void o(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
                n nVar = this.f45219a;
                nVar.i(dVar);
                nVar.e();
                this.f45221c.f45215a.c();
            }
        }

        public b p(d.a.o0.a.l1.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bVar)) == null) {
                f l = this.f45221c.l();
                if (l != null) {
                    l.G3(bVar);
                    return this;
                }
                return k("normal", bVar);
            }
            return (b) invokeL.objValue;
        }

        public final void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                this.f45221c.f45217c.offer(new RunnableC0739b(this, this.f45221c.m()));
            }
        }

        public final void r(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
                this.f45221c.f45217c.offer(new a(this, this.f45221c.m(), dVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447251948, "Ld/a/o0/a/h0/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447251948, "Ld/a/o0/a/h0/g/g;");
                return;
            }
        }
        f45210e = d.a.o0.a.k.f46335a;
        f45211f = new HashSet();
        f45212g = d.a.o0.a.a.aiapps_slide_in_from_right;
        f45213h = d.a.o0.a.a.aiapps_slide_out_to_right;
        f45214i = d.a.o0.a.a.aiapps_hold;
        f45211f.add("adLanding");
        f45211f.add("wxPay");
        f45211f.add("default_webview");
        f45211f.add("allianceLogin");
        f45211f.add("allianceChooseAddress");
        f45211f.add("qrCodePay");
    }

    public g(FragmentActivity fragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45217c = new LinkedList();
        this.f45215a = fragmentActivity.getSupportFragmentManager();
        this.f45216b = new ArrayList<>();
        this.f45218d = new CopyOnWriteArrayList();
    }

    public void g(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f45218d.add(aVar);
    }

    public b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this, "") : (b) invokeV.objValue;
    }

    public b i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? new b(this, str) : (b) invokeL.objValue;
    }

    public d j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (this.f45216b.isEmpty() || i2 < 0 || i2 >= this.f45216b.size()) {
                return null;
            }
            return this.f45216b.get(i2);
        }
        return (d) invokeI.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45216b.size() : invokeV.intValue;
    }

    public f l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f45216b.isEmpty()) {
                return null;
            }
            int size = this.f45216b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f45216b.get(i2).Z1()) {
                    return (f) this.f45216b.get(i2);
                }
            }
            return null;
        }
        return (f) invokeV.objValue;
    }

    public d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? j(this.f45216b.size() - 1) : (d) invokeV.objValue;
    }

    public <T extends d> T n(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            if (cls != null) {
                for (int size = this.f45216b.size() - 1; size >= 0; size--) {
                    T t = (T) this.f45216b.get(size);
                    if (t.getClass() == cls) {
                        return t;
                    }
                }
                return null;
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public f o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            for (int size = this.f45216b.size() - 1; size >= 0; size--) {
                d dVar = this.f45216b.get(size);
                if (dVar instanceof f) {
                    return (f) dVar;
                }
            }
            return null;
        }
        return (f) invokeV.objValue;
    }

    public void p(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f45218d.remove(aVar);
    }
}
