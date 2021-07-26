package d.a.o0.a.h0.c.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.h0.m.d;
import d.a.o0.a.k;
import d.a.o0.a.k2.g.h;
import d.a.o0.a.v2.o0;
import d.a.o0.a.v2.t0;
import d.a.o0.n.h.g;
import d.a.o0.n.i.l.a;
import d.a.o0.n.i.m.b;
import d.a.o0.n.i.m.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public final class b implements d.a.o0.a.n0.l.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45086e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends d.a.o0.a.h0.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f45087a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0721b f45088b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f45089c;

        public a(InterfaceC0721b interfaceC0721b, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0721b, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45088b = interfaceC0721b;
            this.f45089c = map;
            this.f45087a = false;
        }

        @Override // d.a.o0.a.h0.m.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                InterfaceC0721b interfaceC0721b = this.f45088b;
                if (interfaceC0721b != null) {
                    interfaceC0721b.a();
                }
            }
        }

        @Override // d.a.o0.a.h0.m.a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                super.b(i2);
                InterfaceC0721b interfaceC0721b = this.f45088b;
                if (interfaceC0721b != null) {
                    if (i2 == 1010) {
                        interfaceC0721b.a();
                    } else {
                        interfaceC0721b.b(3);
                    }
                }
            }
        }

        @Override // d.a.o0.a.h0.m.a
        public void c(@NonNull a.C1155a c1155a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c1155a) == null) {
                super.c(c1155a);
                i(c1155a.f51210b);
                d.a.o0.a.h0.m.p.a.c(c1155a.f51210b);
            }
        }

        @Override // d.a.o0.a.h0.m.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                h();
                InterfaceC0721b interfaceC0721b = this.f45088b;
                if (interfaceC0721b == null || this.f45087a) {
                    return;
                }
                interfaceC0721b.a();
            }
        }

        @Override // d.a.o0.a.h0.m.a
        public void e(d.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                super.e(aVar);
                if (aVar.f51130a != 1010) {
                    this.f45087a = true;
                    InterfaceC0721b interfaceC0721b = this.f45088b;
                    if (interfaceC0721b != null) {
                        interfaceC0721b.b(3);
                    }
                }
            }
        }

        @Override // d.a.o0.a.h0.m.a
        public void f(@NonNull g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
                super.f(gVar);
                i(gVar.o);
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                for (String str : this.f45089c.keySet()) {
                    i(str);
                }
            }
        }

        public final void i(@NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.f45089c.containsKey(str)) {
                Set<String> set = (Set) this.f45089c.get(str);
                if (set != null && !set.isEmpty()) {
                    for (String str2 : set) {
                        d.a.o0.a.h0.m.p.a.d(str, str2);
                    }
                    return;
                }
                d.a.o0.a.h0.m.p.a.c(str);
            }
        }
    }

    /* renamed from: d.a.o0.a.h0.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0721b {
        void a();

        void b(int i2);

        void c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(197688643, "Ld/a/o0/a/h0/c/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(197688643, "Ld/a/o0/a/h0/c/a/b;");
                return;
            }
        }
        f45086e = k.f46335a;
    }

    public static void a(@NonNull List<e.b> list, @Nullable String str, InterfaceC0721b interfaceC0721b) {
        String[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, list, str, interfaceC0721b) == null) {
            if (!c(h.a().getString("predownload_network_switch", "1"))) {
                if (f45086e) {
                    Log.e("SwanPreDownload", "pre download net invalid");
                }
                if (interfaceC0721b != null) {
                    interfaceC0721b.b(6);
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (e.b bVar : list) {
                if (bVar != null) {
                    if (bVar.h() == null) {
                        if (d.a.o0.a.h0.m.p.a.e(bVar.b())) {
                            arrayList.add(bVar);
                            hashMap.put(bVar.b(), null);
                        }
                    } else {
                        Set set = (Set) hashMap.get(bVar.b());
                        if (set == null) {
                            set = new HashSet();
                        }
                        boolean z = false;
                        for (String str2 : bVar.h()) {
                            if (d.a.o0.a.h0.m.p.a.f(bVar.b(), str2) && !z) {
                                arrayList.add(bVar);
                                z = true;
                            }
                            set.add(str2);
                        }
                        hashMap.put(bVar.b(), set);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                if (f45086e) {
                    Log.i("SwanPreDownload", "preDownload list empty");
                }
                if (interfaceC0721b != null) {
                    interfaceC0721b.a();
                    return;
                }
                return;
            }
            e eVar = new e(arrayList, t0.b());
            eVar.e(str);
            eVar.d("1");
            boolean equals = "1".equals(str);
            d dVar = new d(new a(interfaceC0721b, hashMap));
            dVar.K(equals ? 6 : 7);
            d.a.o0.n.b.d(eVar, dVar);
        }
    }

    public static void b(@NonNull List<b.a> list, @NonNull String str, @NonNull d.a.o0.a.h0.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, list, str, aVar) == null) {
            if (!c(h.a().getString("predownload_network_switch", "1"))) {
                aVar.b(6);
                return;
            }
            List<b.a> i2 = d.a.o0.a.h0.m.p.a.i(list);
            if (i2.isEmpty()) {
                aVar.d();
                return;
            }
            d.a.o0.n.i.m.b bVar = new d.a.o0.n.i.m.b((List<? extends b.a>) i2, (d.a.o0.n.o.a) t0.b());
            bVar.d("1");
            bVar.e(str);
            d.a.o0.n.b.d(bVar, new d(aVar));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (com.baidu.swan.apps.network.SwanAppNetworkUtils.j(com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, str)) != null) {
            return invokeL.booleanValue;
        }
        boolean z = true;
        if (!TextUtils.equals(str, "0")) {
            if (!TextUtils.equals(str, "1")) {
                TextUtils.equals(str, "2");
                z = false;
            }
            if (f45086e) {
                Log.d("SwanPreDownload", "SwanPredownload: current net suits for net config = " + z);
            }
            return z;
        }
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.equals(SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME, str)) {
                d.a.o0.a.c1.a.Z().getSwitch("swan_game_feed_predownload", 0);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void e(@NonNull String str, @Nullable String str2, @Nullable String str3, InterfaceC0721b interfaceC0721b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, str3, interfaceC0721b) == null) {
            e.b bVar = new e.b(str);
            if (!TextUtils.isEmpty(str2)) {
                bVar.j(new String[]{str2});
            }
            a(Collections.singletonList(bVar), str3, interfaceC0721b);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str)) {
                if (f45086e) {
                    Log.e("SwanPreDownload", "pre download swanAppId invalid");
                }
            } else if (!c(h.a().getString("predownload_network_switch", "1"))) {
                if (f45086e) {
                    Log.e("SwanPreDownload", "pre download net invalid");
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new b.a(str));
                List<b.a> i2 = d.a.o0.a.h0.m.p.a.i(arrayList);
                if (i2.isEmpty()) {
                    if (f45086e) {
                        Log.e("SwanPreDownload", "pre download has record");
                        return;
                    }
                    return;
                }
                d.a.o0.n.i.m.b bVar = new d.a.o0.n.i.m.b((List<? extends b.a>) i2, (d.a.o0.n.o.a) t0.b());
                bVar.e(str2);
                bVar.d("1");
                boolean equals = "1".equals(str2);
                d dVar = new d();
                dVar.K(equals ? 6 : 7);
                d.a.o0.n.b.d(bVar, dVar);
            }
        }
    }

    public static void g(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, @Nullable String str4, InterfaceC0721b interfaceC0721b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, Boolean.valueOf(z), str4, interfaceC0721b}) == null) {
            if (f45086e) {
                Log.d("SwanPreDownload", "preDownloadSwanAppByFeed appId: " + str + " ,appType: " + str2 + " ,isClick: " + z + ", scheme=" + str4);
            }
            if (z) {
                if (interfaceC0721b != null) {
                    interfaceC0721b.a();
                }
            } else if (TextUtils.isEmpty(str)) {
                if (interfaceC0721b != null) {
                    interfaceC0721b.c();
                }
            } else if (!d(str2)) {
                if (interfaceC0721b != null) {
                    interfaceC0721b.b(6);
                }
            } else {
                String str5 = null;
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        Uri parse = Uri.parse(str4);
                        if (parse != null) {
                            str5 = o0.n(str, parse, false);
                        }
                    } catch (Exception e2) {
                        if (f45086e) {
                            e2.printStackTrace();
                        }
                    }
                }
                e(str, str5, str3, interfaceC0721b);
            }
        }
    }
}
