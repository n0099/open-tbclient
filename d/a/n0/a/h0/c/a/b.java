package d.a.n0.a.h0.c.a;

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
import d.a.n0.a.h0.m.d;
import d.a.n0.a.k;
import d.a.n0.a.k2.g.h;
import d.a.n0.a.v2.o0;
import d.a.n0.a.v2.t0;
import d.a.n0.n.h.g;
import d.a.n0.n.i.l.a;
import d.a.n0.n.i.m.b;
import d.a.n0.n.i.m.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public final class b implements d.a.n0.a.n0.l.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44582e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends d.a.n0.a.h0.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f44583a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0712b f44584b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f44585c;

        public a(InterfaceC0712b interfaceC0712b, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0712b, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44584b = interfaceC0712b;
            this.f44585c = map;
            this.f44583a = false;
        }

        @Override // d.a.n0.a.h0.m.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                InterfaceC0712b interfaceC0712b = this.f44584b;
                if (interfaceC0712b != null) {
                    interfaceC0712b.a();
                }
            }
        }

        @Override // d.a.n0.a.h0.m.a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                super.b(i2);
                InterfaceC0712b interfaceC0712b = this.f44584b;
                if (interfaceC0712b != null) {
                    if (i2 == 1010) {
                        interfaceC0712b.a();
                    } else {
                        interfaceC0712b.b(3);
                    }
                }
            }
        }

        @Override // d.a.n0.a.h0.m.a
        public void c(@NonNull a.C1146a c1146a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c1146a) == null) {
                super.c(c1146a);
                i(c1146a.f50706b);
                d.a.n0.a.h0.m.p.a.c(c1146a.f50706b);
            }
        }

        @Override // d.a.n0.a.h0.m.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                h();
                InterfaceC0712b interfaceC0712b = this.f44584b;
                if (interfaceC0712b == null || this.f44583a) {
                    return;
                }
                interfaceC0712b.a();
            }
        }

        @Override // d.a.n0.a.h0.m.a
        public void e(d.a.n0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                super.e(aVar);
                if (aVar.f50626a != 1010) {
                    this.f44583a = true;
                    InterfaceC0712b interfaceC0712b = this.f44584b;
                    if (interfaceC0712b != null) {
                        interfaceC0712b.b(3);
                    }
                }
            }
        }

        @Override // d.a.n0.a.h0.m.a
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
                for (String str : this.f44585c.keySet()) {
                    i(str);
                }
            }
        }

        public final void i(@NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.f44585c.containsKey(str)) {
                Set<String> set = (Set) this.f44585c.get(str);
                if (set != null && !set.isEmpty()) {
                    for (String str2 : set) {
                        d.a.n0.a.h0.m.p.a.d(str, str2);
                    }
                    return;
                }
                d.a.n0.a.h0.m.p.a.c(str);
            }
        }
    }

    /* renamed from: d.a.n0.a.h0.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0712b {
        void a();

        void b(int i2);

        void c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(703247268, "Ld/a/n0/a/h0/c/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(703247268, "Ld/a/n0/a/h0/c/a/b;");
                return;
            }
        }
        f44582e = k.f45831a;
    }

    public static void a(@NonNull List<e.b> list, @Nullable String str, InterfaceC0712b interfaceC0712b) {
        String[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, list, str, interfaceC0712b) == null) {
            if (!c(h.a().getString("predownload_network_switch", "1"))) {
                if (f44582e) {
                    Log.e("SwanPreDownload", "pre download net invalid");
                }
                if (interfaceC0712b != null) {
                    interfaceC0712b.b(6);
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (e.b bVar : list) {
                if (bVar != null) {
                    if (bVar.h() == null) {
                        if (d.a.n0.a.h0.m.p.a.e(bVar.b())) {
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
                            if (d.a.n0.a.h0.m.p.a.f(bVar.b(), str2) && !z) {
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
                if (f44582e) {
                    Log.i("SwanPreDownload", "preDownload list empty");
                }
                if (interfaceC0712b != null) {
                    interfaceC0712b.a();
                    return;
                }
                return;
            }
            e eVar = new e(arrayList, t0.b());
            eVar.e(str);
            eVar.d("1");
            boolean equals = "1".equals(str);
            d dVar = new d(new a(interfaceC0712b, hashMap));
            dVar.K(equals ? 6 : 7);
            d.a.n0.n.b.d(eVar, dVar);
        }
    }

    public static void b(@NonNull List<b.a> list, @NonNull String str, @NonNull d.a.n0.a.h0.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, list, str, aVar) == null) {
            if (!c(h.a().getString("predownload_network_switch", "1"))) {
                aVar.b(6);
                return;
            }
            List<b.a> i2 = d.a.n0.a.h0.m.p.a.i(list);
            if (i2.isEmpty()) {
                aVar.d();
                return;
            }
            d.a.n0.n.i.m.b bVar = new d.a.n0.n.i.m.b((List<? extends b.a>) i2, (d.a.n0.n.o.a) t0.b());
            bVar.d("1");
            bVar.e(str);
            d.a.n0.n.b.d(bVar, new d(aVar));
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
            if (f44582e) {
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
                d.a.n0.a.c1.a.Z().getSwitch("swan_game_feed_predownload", 0);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void e(@NonNull String str, @Nullable String str2, @Nullable String str3, InterfaceC0712b interfaceC0712b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, str3, interfaceC0712b) == null) {
            e.b bVar = new e.b(str);
            if (!TextUtils.isEmpty(str2)) {
                bVar.j(new String[]{str2});
            }
            a(Collections.singletonList(bVar), str3, interfaceC0712b);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str)) {
                if (f44582e) {
                    Log.e("SwanPreDownload", "pre download swanAppId invalid");
                }
            } else if (!c(h.a().getString("predownload_network_switch", "1"))) {
                if (f44582e) {
                    Log.e("SwanPreDownload", "pre download net invalid");
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new b.a(str));
                List<b.a> i2 = d.a.n0.a.h0.m.p.a.i(arrayList);
                if (i2.isEmpty()) {
                    if (f44582e) {
                        Log.e("SwanPreDownload", "pre download has record");
                        return;
                    }
                    return;
                }
                d.a.n0.n.i.m.b bVar = new d.a.n0.n.i.m.b((List<? extends b.a>) i2, (d.a.n0.n.o.a) t0.b());
                bVar.e(str2);
                bVar.d("1");
                boolean equals = "1".equals(str2);
                d dVar = new d();
                dVar.K(equals ? 6 : 7);
                d.a.n0.n.b.d(bVar, dVar);
            }
        }
    }

    public static void g(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, @Nullable String str4, InterfaceC0712b interfaceC0712b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, Boolean.valueOf(z), str4, interfaceC0712b}) == null) {
            if (f44582e) {
                Log.d("SwanPreDownload", "preDownloadSwanAppByFeed appId: " + str + " ,appType: " + str2 + " ,isClick: " + z + ", scheme=" + str4);
            }
            if (z) {
                if (interfaceC0712b != null) {
                    interfaceC0712b.a();
                }
            } else if (TextUtils.isEmpty(str)) {
                if (interfaceC0712b != null) {
                    interfaceC0712b.c();
                }
            } else if (!d(str2)) {
                if (interfaceC0712b != null) {
                    interfaceC0712b.b(6);
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
                        if (f44582e) {
                            e2.printStackTrace();
                        }
                    }
                }
                e(str, str5, str3, interfaceC0712b);
            }
        }
    }
}
