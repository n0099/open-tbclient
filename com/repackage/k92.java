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
import com.repackage.i92;
import com.repackage.o22;
import com.repackage.xu9;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class k92 extends w22 implements nc4, kc4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public dv9<? super s84> d;
    public dv9<s84> e;
    public yc4 f;
    public final wa4 g;
    public h74<s84> h;
    public final Map<String, j92> i;
    public final Map<String, oc4> j;
    public final i92 k;
    public final ab4<JSONArray> l;

    /* loaded from: classes6.dex */
    public class a implements ab4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 a;

        public a(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ab4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.a.i.isEmpty()) {
                return;
            }
            for (j92 j92Var : this.a.i.values()) {
                if (j92Var != null && j92Var.r(this.a)) {
                    j92Var.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements le3<j92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 a;

        public b(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(j92 j92Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j92Var) == null) {
                if (k92.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + j92Var);
                }
                if (j92Var != null) {
                    this.a.k.c(j92Var.k(), j92Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements le3<j92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 a;

        public c(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(j92 j92Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j92Var) == null) || j92Var == null) {
                return;
            }
            this.a.k.d(j92Var.k(), j92Var.m());
        }
    }

    /* loaded from: classes6.dex */
    public class d implements o22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s84 a;
        public final /* synthetic */ k92 b;

        public d(k92 k92Var, s84 s84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, s84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k92Var;
            this.a = s84Var;
        }

        @Override // com.repackage.o22.c
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

        @Override // com.repackage.o22.c
        public void b(PMSDownloadType pMSDownloadType, lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, lb3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, lb3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements xu9.a<s84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 a;

        public e(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.xu9.a, com.repackage.lv9
        public void call(dv9<? super s84> dv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dv9Var) == null) {
                this.a.d = dv9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends dv9<s84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 e;

        public f(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.yu9
        /* renamed from: g */
        public void onNext(s84 s84Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, s84Var) == null) && k92.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + s84Var.toString());
            }
        }

        @Override // com.repackage.yu9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (k92.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }

        @Override // com.repackage.yu9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (k92.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ f(k92 k92Var, a aVar) {
            this(k92Var);
        }
    }

    /* loaded from: classes6.dex */
    public class g extends e74<s84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 a;

        public g(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.h74
        /* renamed from: l */
        public String d(s84 s84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, s84Var)) == null) {
                String g = h92.d.g(s84Var);
                if (k92.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + s84Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.j74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: o */
        public void e(s84 s84Var, k84 k84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s84Var, k84Var) == null) {
                super.e(s84Var, k84Var);
                if (k92.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + s84Var.g + " err=" + k84Var);
                }
                this.a.f.l(s84Var);
                lb3 lb3Var = new lb3();
                lb3Var.k(13L);
                lb3Var.i(k84Var.a);
                lb3Var.d("so包下载失败");
                lb3Var.f(k84Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(s84Var, lb3Var));
                }
                o22.c().a(s84Var, k92.o, lb3Var);
                uf4.k(s84Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: p */
        public void i(s84 s84Var) {
            oc4 oc4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, s84Var) == null) {
                super.i(s84Var);
                if (k92.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + s84Var);
                }
                String str2 = s84Var.p;
                if (TextUtils.isEmpty(str2) && (oc4Var = (oc4) this.a.j.get(s84Var.g)) != null) {
                    str2 = oc4Var.a;
                }
                j92 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = fd3.a(new File(s84Var.a), s84Var.m);
                    if (k92.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + s84Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (k92.m && !md3.G() && rv2.j() == 1) ? false : false;
                    if (a || z) {
                        n74.i().m(s84Var);
                        if (k92.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(s84Var);
                if (this.a.d != null) {
                    this.a.d.onNext(s84Var);
                    this.a.d.onCompleted();
                }
                o22.c().b(s84Var, k92.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: q */
        public void a(s84 s84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, s84Var) == null) {
                super.a(s84Var);
                oc4 oc4Var = (oc4) this.a.j.get(s84Var.g);
                j92 a0 = this.a.a0(oc4Var == null ? null : oc4Var.a);
                if (a0 != null) {
                    a0.x(new i92.b(s84Var.b, s84Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: r */
        public void c(s84 s84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, s84Var) == null) {
                super.c(s84Var);
                if (k92.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + s84Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: s */
        public void f(s84 s84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, s84Var) == null) {
                super.f(s84Var);
                if (k92.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + s84Var.g);
                }
                this.a.f0(s84Var);
            }
        }

        public /* synthetic */ g(k92 k92Var, a aVar) {
            this(k92Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755604115, "Lcom/repackage/k92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755604115, "Lcom/repackage/k92;");
                return;
            }
        }
        m = cg1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    public k92(wa4 wa4Var, i92 i92Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wa4Var, i92Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + i92Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = wa4Var;
        this.k = i92Var;
        if (i92Var != null) {
            Iterator<String> it = i92Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                f92 a2 = g92.a(next);
                if (a2 == null) {
                    i92Var.c(next, false);
                } else if (a2.f()) {
                    i92Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    j92 t = h92.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(oc4.b(e2));
                }
            }
        }
        if (m) {
            String str = this.c;
            Log.i(str, "SoNodeHandler() start mUpdatings=" + this.i.size());
        }
        if (this.i.isEmpty()) {
            e0(null);
        }
    }

    @Override // com.repackage.l74
    public void C(k84 k84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k84Var) == null) {
            super.C(k84Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + k84Var.toString());
            }
            e0(new Exception("failed by fetch error = " + k84Var));
        }
    }

    @Override // com.repackage.l74
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.repackage.l74
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            if (m) {
                Log.e(this.c, "onNoPackage:");
            }
            e0(null);
        }
    }

    @Override // com.repackage.l74
    public void G(yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yc4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(yc4Var == null ? 0 : yc4Var.n());
                Log.i(str, sb.toString());
            }
            super.G(yc4Var);
            if (yc4Var == null) {
                return;
            }
            this.f = yc4Var;
            if (yc4Var.k()) {
                return;
            }
            c0();
        }
    }

    public final void Z(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "finishWithUpdatingCheck: updatings=" + this.i.size() + " e=" + exc);
            }
            for (j92 j92Var : this.i.values()) {
                if (!j92Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + j92Var);
                        return;
                    }
                    return;
                }
            }
            d0(exc);
        }
    }

    public final j92 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            j92 j92Var = this.i.get(str);
            if (j92Var == null || !j92Var.r(this)) {
                return null;
            }
            return j92Var;
        }
        return (j92) invokeL.objValue;
    }

    public final dv9<s84> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (dv9) invokeV.objValue;
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f.g()) {
                arrayList.add(xu9.a(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            xu9.i(arrayList).u(b0());
        }
    }

    public final void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
            }
            i92 i92Var = this.k;
            if (i92Var != null) {
                i92Var.b(exc);
            }
        }
    }

    public final void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyPmsFinish: updatings=" + this.i.size() + " e=" + exc);
            }
            for (j92 j92Var : this.i.values()) {
                if (j92Var != null && j92Var.r(this) && !j92Var.n() && !j92Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + j92Var);
                    }
                    j92Var.q();
                }
            }
            Z(exc);
        }
    }

    public final void f0(s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, s84Var) == null) {
            o22.c().d(s84Var, new d(this, s84Var));
        }
    }

    @Override // com.repackage.nc4
    public ab4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (ab4) invokeV.objValue;
    }

    public final void g0(s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, s84Var) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler updateBestSo start so=" + s84Var);
            }
            if (s84Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            oc4 oc4Var = this.j.get(s84Var.g);
            if (oc4Var == null) {
                if (m) {
                    String str2 = this.c;
                    Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + s84Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(s84Var.p)) {
                s84Var.p = oc4Var.a;
            }
            j92 a0 = a0(s84Var.p);
            if (a0 == null) {
                if (m) {
                    String str3 = this.c;
                    Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + s84Var.p);
                    return;
                }
                return;
            }
            if (s84Var.q == null) {
                s84Var.q = oc4Var.c;
            }
            if (!AbiType.currentAbi().compat(s84Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            s84 l = a0.l();
            s84 j = a0.j();
            long max = Math.max(j != null ? j.i : 0L, l == null ? 0L : l.i);
            long j2 = s84Var.i;
            if (j2 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(s84Var.i)));
                }
            } else if (j2 > max) {
                if (m) {
                    String str4 = this.c;
                    Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + s84Var.i);
                }
                a0.w(this, s84Var);
            } else {
                if (j == null || !j.q.compat(s84Var.q)) {
                    if (m) {
                        String str5 = this.c;
                        Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + s84Var.q);
                    }
                    a0.w(this, s84Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.repackage.nc4
    public l74 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (l74) invokeV.objValue;
    }

    @Override // com.repackage.nc4
    @Nullable
    public wa4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.g : (wa4) invokeV.objValue;
    }

    @Override // com.repackage.kc4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((s84) xc4.j(jSONObject, new s84()));
            }
        }
    }

    @Override // com.repackage.kc4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ic4 ic4Var = new ic4();
            yc4 yc4Var = new yc4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !md3.G() && rv2.j() == 1) ? false : false) {
                String i = rv2.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        s84 s84Var = (s84) xc4.j(new JSONObject(i), new s84());
                        s84Var.g = "so_zeus_armeabi";
                        g0(s84Var);
                        kz2.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f124c)).G();
                    } catch (JSONException e2) {
                        kz2.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f124b)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (j92 j92Var : this.i.values()) {
                if (j92Var.r(this)) {
                    g0(j92Var.l());
                    s84 j = j92Var.j();
                    if (j92Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        jc4.b(j, yc4Var);
                        if (ic4Var.d == null) {
                            ic4Var.d = new ArrayList();
                        }
                        ic4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        j92Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + yc4Var.n());
            }
            if (yc4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(yc4Var);
            b94.e(ic4Var, this);
        }
    }

    @Override // com.repackage.l74
    public kc4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.w(str) : (kc4) invokeL.objValue;
    }

    @Override // com.repackage.l74
    public h74<s84> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (h74) invokeV.objValue;
    }
}
