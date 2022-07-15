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
import com.repackage.d32;
import com.repackage.ur9;
import com.repackage.x92;
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
public final class z92 extends l32 implements cd4, zc4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public as9<? super h94> d;
    public as9<h94> e;
    public nd4 f;
    public final lb4 g;
    public w74<h94> h;
    public final Map<String, y92> i;
    public final Map<String, dd4> j;
    public final x92 k;
    public final pb4<JSONArray> l;

    /* loaded from: classes7.dex */
    public class a implements pb4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z92 a;

        public a(z92 z92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.pb4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.a.i.isEmpty()) {
                return;
            }
            for (y92 y92Var : this.a.i.values()) {
                if (y92Var != null && y92Var.r(this.a)) {
                    y92Var.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements af3<y92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z92 a;

        public b(z92 z92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(y92 y92Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y92Var) == null) {
                if (z92.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + y92Var);
                }
                if (y92Var != null) {
                    this.a.k.c(y92Var.k(), y92Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements af3<y92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z92 a;

        public c(z92 z92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(y92 y92Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y92Var) == null) || y92Var == null) {
                return;
            }
            this.a.k.d(y92Var.k(), y92Var.m());
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h94 a;
        public final /* synthetic */ z92 b;

        public d(z92 z92Var, h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z92Var, h94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z92Var;
            this.a = h94Var;
        }

        @Override // com.repackage.d32.c
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

        @Override // com.repackage.d32.c
        public void b(PMSDownloadType pMSDownloadType, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ac3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ac3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ur9.a<h94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z92 a;

        public e(z92 z92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super h94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.d = as9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends as9<h94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z92 e;

        public f(z92 z92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vr9
        /* renamed from: g */
        public void onNext(h94 h94Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, h94Var) == null) && z92.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + h94Var.toString());
            }
        }

        @Override // com.repackage.vr9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (z92.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }

        @Override // com.repackage.vr9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (z92.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ f(z92 z92Var, a aVar) {
            this(z92Var);
        }
    }

    /* loaded from: classes7.dex */
    public class g extends t74<h94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z92 a;

        public g(z92 z92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74
        /* renamed from: l */
        public String d(h94 h94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, h94Var)) == null) {
                String g = w92.d.g(h94Var);
                if (z92.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + h94Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.y74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: o */
        public void e(h94 h94Var, z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h94Var, z84Var) == null) {
                super.e(h94Var, z84Var);
                if (z92.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + h94Var.g + " err=" + z84Var);
                }
                this.a.f.l(h94Var);
                ac3 ac3Var = new ac3();
                ac3Var.k(13L);
                ac3Var.i(z84Var.a);
                ac3Var.d("so包下载失败");
                ac3Var.f(z84Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(h94Var, ac3Var));
                }
                d32.c().a(h94Var, z92.o, ac3Var);
                jg4.k(h94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: p */
        public void i(h94 h94Var) {
            dd4 dd4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, h94Var) == null) {
                super.i(h94Var);
                if (z92.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + h94Var);
                }
                String str2 = h94Var.p;
                if (TextUtils.isEmpty(str2) && (dd4Var = (dd4) this.a.j.get(h94Var.g)) != null) {
                    str2 = dd4Var.a;
                }
                y92 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = ud3.a(new File(h94Var.a), h94Var.m);
                    if (z92.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + h94Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (z92.m && !be3.G() && gw2.j() == 1) ? false : false;
                    if (a || z) {
                        c84.i().m(h94Var);
                        if (z92.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(h94Var);
                if (this.a.d != null) {
                    this.a.d.onNext(h94Var);
                    this.a.d.onCompleted();
                }
                d32.c().b(h94Var, z92.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: q */
        public void a(h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, h94Var) == null) {
                super.a(h94Var);
                dd4 dd4Var = (dd4) this.a.j.get(h94Var.g);
                y92 a0 = this.a.a0(dd4Var == null ? null : dd4Var.a);
                if (a0 != null) {
                    a0.x(new x92.b(h94Var.b, h94Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: r */
        public void c(h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, h94Var) == null) {
                super.c(h94Var);
                if (z92.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + h94Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: s */
        public void f(h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, h94Var) == null) {
                super.f(h94Var);
                if (z92.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + h94Var.g);
                }
                this.a.f0(h94Var);
            }
        }

        public /* synthetic */ g(z92 z92Var, a aVar) {
            this(z92Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755157250, "Lcom/repackage/z92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755157250, "Lcom/repackage/z92;");
                return;
            }
        }
        m = rg1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    public z92(lb4 lb4Var, x92 x92Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lb4Var, x92Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + x92Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = lb4Var;
        this.k = x92Var;
        if (x92Var != null) {
            Iterator<String> it = x92Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                u92 a2 = v92.a(next);
                if (a2 == null) {
                    x92Var.c(next, false);
                } else if (a2.f()) {
                    x92Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    y92 t = w92.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(dd4.b(e2));
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

    @Override // com.repackage.a84
    public void C(z84 z84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z84Var) == null) {
            super.C(z84Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + z84Var.toString());
            }
            e0(new Exception("failed by fetch error = " + z84Var));
        }
    }

    @Override // com.repackage.a84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.repackage.a84
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

    @Override // com.repackage.a84
    public void G(nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nd4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(nd4Var == null ? 0 : nd4Var.n());
                Log.i(str, sb.toString());
            }
            super.G(nd4Var);
            if (nd4Var == null) {
                return;
            }
            this.f = nd4Var;
            if (nd4Var.k()) {
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
            for (y92 y92Var : this.i.values()) {
                if (!y92Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + y92Var);
                        return;
                    }
                    return;
                }
            }
            d0(exc);
        }
    }

    public final y92 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            y92 y92Var = this.i.get(str);
            if (y92Var == null || !y92Var.r(this)) {
                return null;
            }
            return y92Var;
        }
        return (y92) invokeL.objValue;
    }

    public final as9<h94> b0() {
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
            x92 x92Var = this.k;
            if (x92Var != null) {
                x92Var.b(exc);
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
            for (y92 y92Var : this.i.values()) {
                if (y92Var != null && y92Var.r(this) && !y92Var.n() && !y92Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + y92Var);
                    }
                    y92Var.q();
                }
            }
            Z(exc);
        }
    }

    public final void f0(h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, h94Var) == null) {
            d32.c().d(h94Var, new d(this, h94Var));
        }
    }

    @Override // com.repackage.cd4
    public pb4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (pb4) invokeV.objValue;
    }

    public final void g0(h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, h94Var) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler updateBestSo start so=" + h94Var);
            }
            if (h94Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            dd4 dd4Var = this.j.get(h94Var.g);
            if (dd4Var == null) {
                if (m) {
                    String str2 = this.c;
                    Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + h94Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(h94Var.p)) {
                h94Var.p = dd4Var.a;
            }
            y92 a0 = a0(h94Var.p);
            if (a0 == null) {
                if (m) {
                    String str3 = this.c;
                    Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + h94Var.p);
                    return;
                }
                return;
            }
            if (h94Var.q == null) {
                h94Var.q = dd4Var.c;
            }
            if (!AbiType.currentAbi().compat(h94Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            h94 l = a0.l();
            h94 j = a0.j();
            long max = Math.max(j != null ? j.i : 0L, l == null ? 0L : l.i);
            long j2 = h94Var.i;
            if (j2 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(h94Var.i)));
                }
            } else if (j2 > max) {
                if (m) {
                    String str4 = this.c;
                    Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + h94Var.i);
                }
                a0.w(this, h94Var);
            } else {
                if (j == null || !j.q.compat(h94Var.q)) {
                    if (m) {
                        String str5 = this.c;
                        Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + h94Var.q);
                    }
                    a0.w(this, h94Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.repackage.cd4
    public a84 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (a84) invokeV.objValue;
    }

    @Override // com.repackage.cd4
    @Nullable
    public lb4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.g : (lb4) invokeV.objValue;
    }

    @Override // com.repackage.zc4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((h94) md4.j(jSONObject, new h94()));
            }
        }
    }

    @Override // com.repackage.zc4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            xc4 xc4Var = new xc4();
            nd4 nd4Var = new nd4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !be3.G() && gw2.j() == 1) ? false : false) {
                String i = gw2.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        h94 h94Var = (h94) md4.j(new JSONObject(i), new h94());
                        h94Var.g = "so_zeus_armeabi";
                        g0(h94Var);
                        zz2.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1245)).G();
                    } catch (JSONException e2) {
                        zz2.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1244)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (y92 y92Var : this.i.values()) {
                if (y92Var.r(this)) {
                    g0(y92Var.l());
                    h94 j = y92Var.j();
                    if (y92Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        yc4.b(j, nd4Var);
                        if (xc4Var.d == null) {
                            xc4Var.d = new ArrayList();
                        }
                        xc4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        y92Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + nd4Var.n());
            }
            if (nd4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(nd4Var);
            q94.e(xc4Var, this);
        }
    }

    @Override // com.repackage.a84
    public zc4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.w(str) : (zc4) invokeL.objValue;
    }

    @Override // com.repackage.a84
    public w74<h94> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (w74) invokeV.objValue;
    }
}
