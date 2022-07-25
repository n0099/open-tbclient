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
import com.repackage.e32;
import com.repackage.ur9;
import com.repackage.y92;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class aa2 extends m32 implements dd4, ad4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public as9<? super i94> d;
    public as9<i94> e;
    public od4 f;
    public final mb4 g;
    public x74<i94> h;
    public final Map<String, z92> i;
    public final Map<String, ed4> j;
    public final y92 k;
    public final qb4<JSONArray> l;

    /* loaded from: classes5.dex */
    public class a implements qb4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa2 a;

        public a(aa2 aa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.qb4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.a.i.isEmpty()) {
                return;
            }
            for (z92 z92Var : this.a.i.values()) {
                if (z92Var != null && z92Var.r(this.a)) {
                    z92Var.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements bf3<z92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa2 a;

        public b(aa2 aa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(z92 z92Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z92Var) == null) {
                if (aa2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + z92Var);
                }
                if (z92Var != null) {
                    this.a.k.c(z92Var.k(), z92Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements bf3<z92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa2 a;

        public c(aa2 aa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(z92 z92Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z92Var) == null) || z92Var == null) {
                return;
            }
            this.a.k.d(z92Var.k(), z92Var.m());
        }
    }

    /* loaded from: classes5.dex */
    public class d implements e32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i94 a;
        public final /* synthetic */ aa2 b;

        public d(aa2 aa2Var, i94 i94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa2Var, i94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aa2Var;
            this.a = i94Var;
        }

        @Override // com.repackage.e32.c
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

        @Override // com.repackage.e32.c
        public void b(PMSDownloadType pMSDownloadType, bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, bc3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, bc3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ur9.a<i94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa2 a;

        public e(aa2 aa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super i94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.d = as9Var;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends as9<i94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa2 e;

        public f(aa2 aa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = aa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vr9
        /* renamed from: g */
        public void onNext(i94 i94Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, i94Var) == null) && aa2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + i94Var.toString());
            }
        }

        @Override // com.repackage.vr9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (aa2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }

        @Override // com.repackage.vr9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (aa2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ f(aa2 aa2Var, a aVar) {
            this(aa2Var);
        }
    }

    /* loaded from: classes5.dex */
    public class g extends u74<i94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa2 a;

        public g(aa2 aa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.x74
        /* renamed from: l */
        public String d(i94 i94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, i94Var)) == null) {
                String g = x92.d.g(i94Var);
                if (aa2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + i94Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.z74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: o */
        public void e(i94 i94Var, a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i94Var, a94Var) == null) {
                super.e(i94Var, a94Var);
                if (aa2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + i94Var.g + " err=" + a94Var);
                }
                this.a.f.l(i94Var);
                bc3 bc3Var = new bc3();
                bc3Var.k(13L);
                bc3Var.i(a94Var.a);
                bc3Var.d("so包下载失败");
                bc3Var.f(a94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(i94Var, bc3Var));
                }
                e32.c().a(i94Var, aa2.o, bc3Var);
                kg4.k(i94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: p */
        public void i(i94 i94Var) {
            ed4 ed4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, i94Var) == null) {
                super.i(i94Var);
                if (aa2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + i94Var);
                }
                String str2 = i94Var.p;
                if (TextUtils.isEmpty(str2) && (ed4Var = (ed4) this.a.j.get(i94Var.g)) != null) {
                    str2 = ed4Var.a;
                }
                z92 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = vd3.a(new File(i94Var.a), i94Var.m);
                    if (aa2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + i94Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (aa2.m && !ce3.G() && hw2.j() == 1) ? false : false;
                    if (a || z) {
                        d84.i().m(i94Var);
                        if (aa2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(i94Var);
                if (this.a.d != null) {
                    this.a.d.onNext(i94Var);
                    this.a.d.onCompleted();
                }
                e32.c().b(i94Var, aa2.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: q */
        public void a(i94 i94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, i94Var) == null) {
                super.a(i94Var);
                ed4 ed4Var = (ed4) this.a.j.get(i94Var.g);
                z92 a0 = this.a.a0(ed4Var == null ? null : ed4Var.a);
                if (a0 != null) {
                    a0.x(new y92.b(i94Var.b, i94Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: r */
        public void c(i94 i94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, i94Var) == null) {
                super.c(i94Var);
                if (aa2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + i94Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: s */
        public void f(i94 i94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, i94Var) == null) {
                super.f(i94Var);
                if (aa2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + i94Var.g);
                }
                this.a.f0(i94Var);
            }
        }

        public /* synthetic */ g(aa2 aa2Var, a aVar) {
            this(aa2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755863585, "Lcom/repackage/aa2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755863585, "Lcom/repackage/aa2;");
                return;
            }
        }
        m = sg1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    public aa2(mb4 mb4Var, y92 y92Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mb4Var, y92Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + y92Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = mb4Var;
        this.k = y92Var;
        if (y92Var != null) {
            Iterator<String> it = y92Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                v92 a2 = w92.a(next);
                if (a2 == null) {
                    y92Var.c(next, false);
                } else if (a2.f()) {
                    y92Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    z92 t = x92.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(ed4.b(e2));
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

    @Override // com.repackage.b84
    public void C(a94 a94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a94Var) == null) {
            super.C(a94Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + a94Var.toString());
            }
            e0(new Exception("failed by fetch error = " + a94Var));
        }
    }

    @Override // com.repackage.b84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.repackage.b84
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

    @Override // com.repackage.b84
    public void G(od4 od4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, od4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(od4Var == null ? 0 : od4Var.n());
                Log.i(str, sb.toString());
            }
            super.G(od4Var);
            if (od4Var == null) {
                return;
            }
            this.f = od4Var;
            if (od4Var.k()) {
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
            for (z92 z92Var : this.i.values()) {
                if (!z92Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + z92Var);
                        return;
                    }
                    return;
                }
            }
            d0(exc);
        }
    }

    public final z92 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            z92 z92Var = this.i.get(str);
            if (z92Var == null || !z92Var.r(this)) {
                return null;
            }
            return z92Var;
        }
        return (z92) invokeL.objValue;
    }

    public final as9<i94> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (as9) invokeV.objValue;
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f.g()) {
                arrayList.add(ur9.a(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            ur9.i(arrayList).u(b0());
        }
    }

    public final void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
            }
            y92 y92Var = this.k;
            if (y92Var != null) {
                y92Var.b(exc);
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
            for (z92 z92Var : this.i.values()) {
                if (z92Var != null && z92Var.r(this) && !z92Var.n() && !z92Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + z92Var);
                    }
                    z92Var.q();
                }
            }
            Z(exc);
        }
    }

    public final void f0(i94 i94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, i94Var) == null) {
            e32.c().d(i94Var, new d(this, i94Var));
        }
    }

    @Override // com.repackage.dd4
    public qb4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (qb4) invokeV.objValue;
    }

    public final void g0(i94 i94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, i94Var) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler updateBestSo start so=" + i94Var);
            }
            if (i94Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            ed4 ed4Var = this.j.get(i94Var.g);
            if (ed4Var == null) {
                if (m) {
                    String str2 = this.c;
                    Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + i94Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(i94Var.p)) {
                i94Var.p = ed4Var.a;
            }
            z92 a0 = a0(i94Var.p);
            if (a0 == null) {
                if (m) {
                    String str3 = this.c;
                    Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + i94Var.p);
                    return;
                }
                return;
            }
            if (i94Var.q == null) {
                i94Var.q = ed4Var.c;
            }
            if (!AbiType.currentAbi().compat(i94Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            i94 l = a0.l();
            i94 j = a0.j();
            long max = Math.max(j != null ? j.i : 0L, l == null ? 0L : l.i);
            long j2 = i94Var.i;
            if (j2 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(i94Var.i)));
                }
            } else if (j2 > max) {
                if (m) {
                    String str4 = this.c;
                    Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + i94Var.i);
                }
                a0.w(this, i94Var);
            } else {
                if (j == null || !j.q.compat(i94Var.q)) {
                    if (m) {
                        String str5 = this.c;
                        Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + i94Var.q);
                    }
                    a0.w(this, i94Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.repackage.dd4
    public b84 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (b84) invokeV.objValue;
    }

    @Override // com.repackage.dd4
    @Nullable
    public mb4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.g : (mb4) invokeV.objValue;
    }

    @Override // com.repackage.ad4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((i94) nd4.j(jSONObject, new i94()));
            }
        }
    }

    @Override // com.repackage.ad4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            yc4 yc4Var = new yc4();
            od4 od4Var = new od4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !ce3.G() && hw2.j() == 1) ? false : false) {
                String i = hw2.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        i94 i94Var = (i94) nd4.j(new JSONObject(i), new i94());
                        i94Var.g = "so_zeus_armeabi";
                        g0(i94Var);
                        a03.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f11f4)).G();
                    } catch (JSONException e2) {
                        a03.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f11f3)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (z92 z92Var : this.i.values()) {
                if (z92Var.r(this)) {
                    g0(z92Var.l());
                    i94 j = z92Var.j();
                    if (z92Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        zc4.b(j, od4Var);
                        if (yc4Var.d == null) {
                            yc4Var.d = new ArrayList();
                        }
                        yc4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        z92Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + od4Var.n());
            }
            if (od4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(od4Var);
            r94.e(yc4Var, this);
        }
    }

    @Override // com.repackage.b84
    public ad4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.w(str) : (ad4) invokeL.objValue;
    }

    @Override // com.repackage.b84
    public x74<i94> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (x74) invokeV.objValue;
    }
}
