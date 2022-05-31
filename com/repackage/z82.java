package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d22;
import com.repackage.qu9;
import com.repackage.x82;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class z82 extends l22 implements cc4, zb4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public wu9<? super h84> d;
    public wu9<h84> e;
    public nc4 f;
    public final la4 g;
    public w64<h84> h;
    public final Map<String, y82> i;
    public final Map<String, dc4> j;
    public final x82 k;
    public final pa4<JSONArray> l;

    /* loaded from: classes7.dex */
    public class a implements pa4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z82 a;

        public a(z82 z82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.pa4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.a.i.isEmpty()) {
                return;
            }
            for (y82 y82Var : this.a.i.values()) {
                if (y82Var != null && y82Var.r(this.a)) {
                    y82Var.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ae3<y82> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z82 a;

        public b(z82 z82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(y82 y82Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y82Var) == null) {
                if (z82.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + y82Var);
                }
                if (y82Var != null) {
                    this.a.k.c(y82Var.k(), y82Var.o());
                }
                this.a.a0(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ae3<y82> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z82 a;

        public c(z82 z82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(y82 y82Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, y82Var) == null) || y82Var == null) {
                return;
            }
            this.a.k.d(y82Var.k(), y82Var.m());
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h84 a;
        public final /* synthetic */ z82 b;

        public d(z82 z82Var, h84 h84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z82Var, h84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z82Var;
            this.a = h84Var;
        }

        @Override // com.repackage.d22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.f.m(this.a);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.repackage.d22.c
        public void b(PMSDownloadType pMSDownloadType, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ab3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ab3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements qu9.a<h84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z82 a;

        public e(z82 z82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.qu9.a, com.repackage.ev9
        public void call(wu9<? super h84> wu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
                this.a.d = wu9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends wu9<h84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z82 e;

        public f(z82 z82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ru9
        /* renamed from: g */
        public void onNext(h84 h84Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, h84Var) == null) && z82.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + h84Var.toString());
            }
        }

        @Override // com.repackage.ru9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (z82.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.f0(null);
            }
        }

        @Override // com.repackage.ru9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (z82.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.f0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ f(z82 z82Var, a aVar) {
            this(z82Var);
        }
    }

    /* loaded from: classes7.dex */
    public class g extends t64<h84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z82 a;

        public g(z82 z82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w64
        /* renamed from: l */
        public String d(h84 h84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, h84Var)) == null) {
                String g = w82.d.g(h84Var);
                if (z82.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + h84Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.y64
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: o */
        public void e(h84 h84Var, z74 z74Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h84Var, z74Var) == null) {
                super.e(h84Var, z74Var);
                if (z82.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + h84Var.g + " err=" + z74Var);
                }
                this.a.f.l(h84Var);
                ab3 ab3Var = new ab3();
                ab3Var.k(13L);
                ab3Var.i(z74Var.a);
                ab3Var.d("so包下载失败");
                ab3Var.f(z74Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(h84Var, ab3Var));
                }
                d22.c().a(h84Var, z82.o, ab3Var);
                kf4.k(h84Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: p */
        public void i(h84 h84Var) {
            dc4 dc4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, h84Var) == null) {
                super.i(h84Var);
                if (z82.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + h84Var);
                }
                String str2 = h84Var.p;
                if (TextUtils.isEmpty(str2) && (dc4Var = (dc4) this.a.j.get(h84Var.g)) != null) {
                    str2 = dc4Var.a;
                }
                y82 b0 = this.a.b0(str2);
                if (b0 != null) {
                    boolean a = uc3.a(new File(h84Var.a), h84Var.m);
                    if (z82.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + h84Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (z82.m && !bd3.G() && gv2.j() == 1) ? false : false;
                    if (a || z) {
                        c74.i().m(h84Var);
                        if (z82.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + b0 + " libName=" + str2);
                        }
                    }
                    b0.q();
                }
                this.a.f.m(h84Var);
                if (this.a.d != null) {
                    this.a.d.onNext(h84Var);
                    this.a.d.onCompleted();
                }
                d22.c().b(h84Var, z82.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: q */
        public void a(h84 h84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, h84Var) == null) {
                super.a(h84Var);
                dc4 dc4Var = (dc4) this.a.j.get(h84Var.g);
                y82 b0 = this.a.b0(dc4Var == null ? null : dc4Var.a);
                if (b0 != null) {
                    b0.x(new x82.b(h84Var.b, h84Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: r */
        public void c(h84 h84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, h84Var) == null) {
                super.c(h84Var);
                if (z82.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + h84Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: s */
        public void f(h84 h84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, h84Var) == null) {
                super.f(h84Var);
                if (z82.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + h84Var.g);
                }
                this.a.g0(h84Var);
            }
        }

        public /* synthetic */ g(z82 z82Var, a aVar) {
            this(z82Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755158211, "Lcom/repackage/z82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755158211, "Lcom/repackage/z82;");
                return;
            }
        }
        m = rf1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    public z82(la4 la4Var, x82 x82Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {la4Var, x82Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = "SwanSoUpdater";
        this.i = new HashMap();
        this.j = new HashMap();
        this.l = new a(this);
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        int i3 = n;
        n = i3 + 1;
        sb.append(i3);
        String sb2 = sb.toString();
        this.c = sb2;
        if (m) {
            Log.i(sb2, "SwanSoUpdater: config=" + x82Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = la4Var;
        this.k = x82Var;
        if (x82Var != null) {
            Iterator<String> it = x82Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                u82 a2 = v82.a(next);
                if (a2 == null) {
                    x82Var.c(next, false);
                } else if (a2.f()) {
                    x82Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    y82 t = w82.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(dc4.b(e2));
                }
            }
        }
        if (m) {
            String str = this.c;
            Log.i(str, "SoNodeHandler() start mUpdatings=" + this.i.size());
        }
        if (this.i.isEmpty()) {
            f0(null);
        }
    }

    @Override // com.repackage.a74
    public w64<h84> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (w64) invokeV.objValue;
    }

    @Override // com.repackage.a74
    public void D(z74 z74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z74Var) == null) {
            super.D(z74Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + z74Var.toString());
            }
            f0(new Exception("failed by fetch error = " + z74Var));
        }
    }

    @Override // com.repackage.a74
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.repackage.a74
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.G();
            if (m) {
                Log.e(this.c, "onNoPackage:");
            }
            f0(null);
        }
    }

    @Override // com.repackage.a74
    public void H(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nc4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(nc4Var == null ? 0 : nc4Var.n());
                Log.i(str, sb.toString());
            }
            super.H(nc4Var);
            if (nc4Var == null) {
                return;
            }
            this.f = nc4Var;
            if (nc4Var.k()) {
                return;
            }
            d0();
        }
    }

    public final void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "finishWithUpdatingCheck: updatings=" + this.i.size() + " e=" + exc);
            }
            for (y82 y82Var : this.i.values()) {
                if (!y82Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + y82Var);
                        return;
                    }
                    return;
                }
            }
            e0(exc);
        }
    }

    public final y82 b0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            y82 y82Var = this.i.get(str);
            if (y82Var == null || !y82Var.r(this)) {
                return null;
            }
            return y82Var;
        }
        return (y82) invokeL.objValue;
    }

    public final wu9<h84> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (wu9) invokeV.objValue;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f.g()) {
                arrayList.add(qu9.a(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            qu9.i(arrayList).u(c0());
        }
    }

    public final void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
            }
            x82 x82Var = this.k;
            if (x82Var != null) {
                x82Var.b(exc);
            }
        }
    }

    public final void f0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyPmsFinish: updatings=" + this.i.size() + " e=" + exc);
            }
            for (y82 y82Var : this.i.values()) {
                if (y82Var != null && y82Var.r(this) && !y82Var.n() && !y82Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + y82Var);
                    }
                    y82Var.q();
                }
            }
            a0(exc);
        }
    }

    @Override // com.repackage.cc4
    public pa4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (pa4) invokeV.objValue;
    }

    public final void g0(h84 h84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, h84Var) == null) {
            d22.c().d(h84Var, new d(this, h84Var));
        }
    }

    @Override // com.repackage.cc4
    @Nullable
    public la4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.g : (la4) invokeV.objValue;
    }

    public final void h0(h84 h84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, h84Var) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler updateBestSo start so=" + h84Var);
            }
            if (h84Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            dc4 dc4Var = this.j.get(h84Var.g);
            if (dc4Var == null) {
                if (m) {
                    String str2 = this.c;
                    Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + h84Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(h84Var.p)) {
                h84Var.p = dc4Var.a;
            }
            y82 b0 = b0(h84Var.p);
            if (b0 == null) {
                if (m) {
                    String str3 = this.c;
                    Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + h84Var.p);
                    return;
                }
                return;
            }
            if (h84Var.q == null) {
                h84Var.q = dc4Var.c;
            }
            if (!AbiType.currentAbi().compat(h84Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            h84 l = b0.l();
            h84 j = b0.j();
            long max = Math.max(j != null ? j.i : 0L, l == null ? 0L : l.i);
            long j2 = h84Var.i;
            if (j2 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(h84Var.i)));
                }
            } else if (j2 > max) {
                if (m) {
                    String str4 = this.c;
                    Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + h84Var.i);
                }
                b0.w(this, h84Var);
            } else {
                if (j == null || !j.q.compat(h84Var.q)) {
                    if (m) {
                        String str5 = this.c;
                        Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + h84Var.q);
                    }
                    b0.w(this, h84Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.repackage.zb4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                h0((h84) mc4.j(jSONObject, new h84()));
            }
        }
    }

    @Override // com.repackage.cc4
    public a74 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (a74) invokeV.objValue;
    }

    @Override // com.repackage.zb4
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            xb4 xb4Var = new xb4();
            nc4 nc4Var = new nc4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !bd3.G() && gv2.j() == 1) ? false : false) {
                String i = gv2.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        h84 h84Var = (h84) mc4.j(new JSONObject(i), new h84());
                        h84Var.g = "so_zeus_armeabi";
                        h0(h84Var);
                        zy2.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f123f)).G();
                    } catch (JSONException e2) {
                        zy2.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f123e)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (y82 y82Var : this.i.values()) {
                if (y82Var.r(this)) {
                    h0(y82Var.l());
                    h84 j = y82Var.j();
                    if (y82Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        yb4.b(j, nc4Var);
                        if (xb4Var.d == null) {
                            xb4Var.d = new ArrayList();
                        }
                        xb4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        y82Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + nc4Var.n());
            }
            if (nc4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                G();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            H(nc4Var);
            q84.e(xb4Var, this);
        }
    }

    @Override // com.repackage.a74
    public zb4 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.x(str) : (zb4) invokeL.objValue;
    }
}
