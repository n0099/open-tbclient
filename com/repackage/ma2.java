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
import com.repackage.ka2;
import com.repackage.q32;
import com.repackage.wx9;
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
public final class ma2 extends y32 implements pd4, md4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public cy9<? super u94> d;
    public cy9<u94> e;
    public ae4 f;
    public final yb4 g;
    public j84<u94> h;
    public final Map<String, la2> i;
    public final Map<String, qd4> j;
    public final ka2 k;
    public final cc4<JSONArray> l;

    /* loaded from: classes6.dex */
    public class a implements cc4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma2 a;

        public a(ma2 ma2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ma2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cc4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.a.i.isEmpty()) {
                return;
            }
            for (la2 la2Var : this.a.i.values()) {
                if (la2Var != null && la2Var.r(this.a)) {
                    la2Var.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements nf3<la2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma2 a;

        public b(ma2 ma2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ma2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(la2 la2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, la2Var) == null) {
                if (ma2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + la2Var);
                }
                if (la2Var != null) {
                    this.a.k.c(la2Var.k(), la2Var.o());
                }
                this.a.a0(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements nf3<la2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma2 a;

        public c(ma2 ma2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ma2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(la2 la2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, la2Var) == null) || la2Var == null) {
                return;
            }
            this.a.k.d(la2Var.k(), la2Var.m());
        }
    }

    /* loaded from: classes6.dex */
    public class d implements q32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u94 a;
        public final /* synthetic */ ma2 b;

        public d(ma2 ma2Var, u94 u94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma2Var, u94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ma2Var;
            this.a = u94Var;
        }

        @Override // com.repackage.q32.c
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

        @Override // com.repackage.q32.c
        public void b(PMSDownloadType pMSDownloadType, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, nc3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, nc3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements wx9.a<u94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma2 a;

        public e(ma2 ma2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ma2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.wx9.a, com.repackage.ky9
        public void call(cy9<? super u94> cy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
                this.a.d = cy9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends cy9<u94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma2 e;

        public f(ma2 ma2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ma2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.xx9
        /* renamed from: g */
        public void onNext(u94 u94Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, u94Var) == null) && ma2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + u94Var.toString());
            }
        }

        @Override // com.repackage.xx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (ma2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.f0(null);
            }
        }

        @Override // com.repackage.xx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (ma2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.f0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ f(ma2 ma2Var, a aVar) {
            this(ma2Var);
        }
    }

    /* loaded from: classes6.dex */
    public class g extends g84<u94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma2 a;

        public g(ma2 ma2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ma2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.j84
        /* renamed from: l */
        public String d(u94 u94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, u94Var)) == null) {
                String g = ja2.d.g(u94Var);
                if (ma2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + u94Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.l84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: o */
        public void e(u94 u94Var, m94 m94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, u94Var, m94Var) == null) {
                super.e(u94Var, m94Var);
                if (ma2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + u94Var.g + " err=" + m94Var);
                }
                this.a.f.l(u94Var);
                nc3 nc3Var = new nc3();
                nc3Var.k(13L);
                nc3Var.i(m94Var.a);
                nc3Var.d("so包下载失败");
                nc3Var.f(m94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(u94Var, nc3Var));
                }
                q32.c().a(u94Var, ma2.o, nc3Var);
                xg4.k(u94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: p */
        public void i(u94 u94Var) {
            qd4 qd4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, u94Var) == null) {
                super.i(u94Var);
                if (ma2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + u94Var);
                }
                String str2 = u94Var.p;
                if (TextUtils.isEmpty(str2) && (qd4Var = (qd4) this.a.j.get(u94Var.g)) != null) {
                    str2 = qd4Var.a;
                }
                la2 b0 = this.a.b0(str2);
                if (b0 != null) {
                    boolean a = he3.a(new File(u94Var.a), u94Var.m);
                    if (ma2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + u94Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (ma2.m && !oe3.G() && tw2.j() == 1) ? false : false;
                    if (a || z) {
                        p84.i().m(u94Var);
                        if (ma2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + b0 + " libName=" + str2);
                        }
                    }
                    b0.q();
                }
                this.a.f.m(u94Var);
                if (this.a.d != null) {
                    this.a.d.onNext(u94Var);
                    this.a.d.onCompleted();
                }
                q32.c().b(u94Var, ma2.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: q */
        public void a(u94 u94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, u94Var) == null) {
                super.a(u94Var);
                qd4 qd4Var = (qd4) this.a.j.get(u94Var.g);
                la2 b0 = this.a.b0(qd4Var == null ? null : qd4Var.a);
                if (b0 != null) {
                    b0.x(new ka2.b(u94Var.b, u94Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: r */
        public void c(u94 u94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, u94Var) == null) {
                super.c(u94Var);
                if (ma2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + u94Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: s */
        public void f(u94 u94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, u94Var) == null) {
                super.f(u94Var);
                if (ma2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + u94Var.g);
                }
                this.a.g0(u94Var);
            }
        }

        public /* synthetic */ g(ma2 ma2Var, a aVar) {
            this(ma2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755506093, "Lcom/repackage/ma2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755506093, "Lcom/repackage/ma2;");
                return;
            }
        }
        m = eh1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    public ma2(yb4 yb4Var, ka2 ka2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yb4Var, ka2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + ka2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = yb4Var;
        this.k = ka2Var;
        if (ka2Var != null) {
            Iterator<String> it = ka2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                ha2 a2 = ia2.a(next);
                if (a2 == null) {
                    ka2Var.c(next, false);
                } else if (a2.f()) {
                    ka2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    la2 t = ja2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(qd4.b(e2));
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

    @Override // com.repackage.n84
    public j84<u94> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (j84) invokeV.objValue;
    }

    @Override // com.repackage.n84
    public void D(m94 m94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m94Var) == null) {
            super.D(m94Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + m94Var.toString());
            }
            f0(new Exception("failed by fetch error = " + m94Var));
        }
    }

    @Override // com.repackage.n84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.repackage.n84
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

    @Override // com.repackage.n84
    public void H(ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ae4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(ae4Var == null ? 0 : ae4Var.n());
                Log.i(str, sb.toString());
            }
            super.H(ae4Var);
            if (ae4Var == null) {
                return;
            }
            this.f = ae4Var;
            if (ae4Var.k()) {
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
            for (la2 la2Var : this.i.values()) {
                if (!la2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + la2Var);
                        return;
                    }
                    return;
                }
            }
            e0(exc);
        }
    }

    public final la2 b0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            la2 la2Var = this.i.get(str);
            if (la2Var == null || !la2Var.r(this)) {
                return null;
            }
            return la2Var;
        }
        return (la2) invokeL.objValue;
    }

    public final cy9<u94> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (cy9) invokeV.objValue;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f.g()) {
                arrayList.add(wx9.a(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            wx9.i(arrayList).u(c0());
        }
    }

    public final void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
            }
            ka2 ka2Var = this.k;
            if (ka2Var != null) {
                ka2Var.b(exc);
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
            for (la2 la2Var : this.i.values()) {
                if (la2Var != null && la2Var.r(this) && !la2Var.n() && !la2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + la2Var);
                    }
                    la2Var.q();
                }
            }
            a0(exc);
        }
    }

    @Override // com.repackage.pd4
    public cc4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (cc4) invokeV.objValue;
    }

    public final void g0(u94 u94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, u94Var) == null) {
            q32.c().d(u94Var, new d(this, u94Var));
        }
    }

    @Override // com.repackage.pd4
    @Nullable
    public yb4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.g : (yb4) invokeV.objValue;
    }

    public final void h0(u94 u94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, u94Var) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler updateBestSo start so=" + u94Var);
            }
            if (u94Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            qd4 qd4Var = this.j.get(u94Var.g);
            if (qd4Var == null) {
                if (m) {
                    String str2 = this.c;
                    Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + u94Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(u94Var.p)) {
                u94Var.p = qd4Var.a;
            }
            la2 b0 = b0(u94Var.p);
            if (b0 == null) {
                if (m) {
                    String str3 = this.c;
                    Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + u94Var.p);
                    return;
                }
                return;
            }
            if (u94Var.q == null) {
                u94Var.q = qd4Var.c;
            }
            if (!AbiType.currentAbi().compat(u94Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            u94 l = b0.l();
            u94 j = b0.j();
            long max = Math.max(j != null ? j.i : 0L, l == null ? 0L : l.i);
            long j2 = u94Var.i;
            if (j2 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(u94Var.i)));
                }
            } else if (j2 > max) {
                if (m) {
                    String str4 = this.c;
                    Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + u94Var.i);
                }
                b0.w(this, u94Var);
            } else {
                if (j == null || !j.q.compat(u94Var.q)) {
                    if (m) {
                        String str5 = this.c;
                        Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + u94Var.q);
                    }
                    b0.w(this, u94Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.repackage.md4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                h0((u94) zd4.j(jSONObject, new u94()));
            }
        }
    }

    @Override // com.repackage.pd4
    public n84 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (n84) invokeV.objValue;
    }

    @Override // com.repackage.md4
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            kd4 kd4Var = new kd4();
            ae4 ae4Var = new ae4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !oe3.G() && tw2.j() == 1) ? false : false) {
                String i = tw2.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        u94 u94Var = (u94) zd4.j(new JSONObject(i), new u94());
                        u94Var.g = "so_zeus_armeabi";
                        h0(u94Var);
                        m03.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f122d)).G();
                    } catch (JSONException e2) {
                        m03.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f122c)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (la2 la2Var : this.i.values()) {
                if (la2Var.r(this)) {
                    h0(la2Var.l());
                    u94 j = la2Var.j();
                    if (la2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        ld4.b(j, ae4Var);
                        if (kd4Var.d == null) {
                            kd4Var.d = new ArrayList();
                        }
                        kd4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        la2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + ae4Var.n());
            }
            if (ae4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                G();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            H(ae4Var);
            da4.e(kd4Var, this);
        }
    }

    @Override // com.repackage.n84
    public md4 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.x(str) : (md4) invokeL.objValue;
    }
}
