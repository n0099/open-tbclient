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
import com.repackage.pa2;
import com.repackage.pu9;
import com.repackage.v32;
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
public final class ra2 extends d42 implements ud4, rd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public vu9<? super z94> d;
    public vu9<z94> e;
    public fe4 f;
    public final dc4 g;
    public o84<z94> h;
    public final Map<String, qa2> i;
    public final Map<String, vd4> j;
    public final pa2 k;
    public final hc4<JSONArray> l;

    /* loaded from: classes7.dex */
    public class a implements hc4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra2 a;

        public a(ra2 ra2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ra2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hc4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.a.i.isEmpty()) {
                return;
            }
            for (qa2 qa2Var : this.a.i.values()) {
                if (qa2Var != null && qa2Var.r(this.a)) {
                    qa2Var.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements sf3<qa2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra2 a;

        public b(ra2 ra2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ra2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(qa2 qa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qa2Var) == null) {
                if (ra2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + qa2Var);
                }
                if (qa2Var != null) {
                    this.a.k.c(qa2Var.k(), qa2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements sf3<qa2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra2 a;

        public c(ra2 ra2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ra2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(qa2 qa2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qa2Var) == null) || qa2Var == null) {
                return;
            }
            this.a.k.d(qa2Var.k(), qa2Var.m());
        }
    }

    /* loaded from: classes7.dex */
    public class d implements v32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z94 a;
        public final /* synthetic */ ra2 b;

        public d(ra2 ra2Var, z94 z94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra2Var, z94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ra2Var;
            this.a = z94Var;
        }

        @Override // com.repackage.v32.c
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

        @Override // com.repackage.v32.c
        public void b(PMSDownloadType pMSDownloadType, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sc3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, sc3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements pu9.a<z94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra2 a;

        public e(ra2 ra2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ra2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.pu9.a, com.repackage.dv9
        public void call(vu9<? super z94> vu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vu9Var) == null) {
                this.a.d = vu9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends vu9<z94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra2 e;

        public f(ra2 ra2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ra2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.qu9
        /* renamed from: g */
        public void onNext(z94 z94Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, z94Var) == null) && ra2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + z94Var.toString());
            }
        }

        @Override // com.repackage.qu9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (ra2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }

        @Override // com.repackage.qu9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (ra2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ f(ra2 ra2Var, a aVar) {
            this(ra2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class g extends l84<z94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra2 a;

        public g(ra2 ra2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ra2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o84
        /* renamed from: l */
        public String d(z94 z94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, z94Var)) == null) {
                String g = oa2.d.g(z94Var);
                if (ra2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + z94Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.q84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: o */
        public void e(z94 z94Var, r94 r94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z94Var, r94Var) == null) {
                super.e(z94Var, r94Var);
                if (ra2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + z94Var.g + " err=" + r94Var);
                }
                this.a.f.l(z94Var);
                sc3 sc3Var = new sc3();
                sc3Var.k(13L);
                sc3Var.i(r94Var.a);
                sc3Var.d("so包下载失败");
                sc3Var.f(r94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(z94Var, sc3Var));
                }
                v32.c().a(z94Var, ra2.o, sc3Var);
                bh4.k(z94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: p */
        public void i(z94 z94Var) {
            vd4 vd4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, z94Var) == null) {
                super.i(z94Var);
                if (ra2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + z94Var);
                }
                String str2 = z94Var.p;
                if (TextUtils.isEmpty(str2) && (vd4Var = (vd4) this.a.j.get(z94Var.g)) != null) {
                    str2 = vd4Var.a;
                }
                qa2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = me3.a(new File(z94Var.a), z94Var.m);
                    if (ra2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + z94Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (ra2.m && !te3.G() && yw2.j() == 1) ? false : false;
                    if (a || z) {
                        u84.i().m(z94Var);
                        if (ra2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(z94Var);
                if (this.a.d != null) {
                    this.a.d.onNext(z94Var);
                    this.a.d.onCompleted();
                }
                v32.c().b(z94Var, ra2.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: q */
        public void a(z94 z94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, z94Var) == null) {
                super.a(z94Var);
                vd4 vd4Var = (vd4) this.a.j.get(z94Var.g);
                qa2 a0 = this.a.a0(vd4Var == null ? null : vd4Var.a);
                if (a0 != null) {
                    a0.x(new pa2.b(z94Var.b, z94Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: r */
        public void c(z94 z94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, z94Var) == null) {
                super.c(z94Var);
                if (ra2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + z94Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: s */
        public void f(z94 z94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, z94Var) == null) {
                super.f(z94Var);
                if (ra2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + z94Var.g);
                }
                this.a.f0(z94Var);
            }
        }

        public /* synthetic */ g(ra2 ra2Var, a aVar) {
            this(ra2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755357138, "Lcom/repackage/ra2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755357138, "Lcom/repackage/ra2;");
                return;
            }
        }
        m = jh1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    public ra2(dc4 dc4Var, pa2 pa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dc4Var, pa2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + pa2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = dc4Var;
        this.k = pa2Var;
        if (pa2Var != null) {
            Iterator<String> it = pa2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                ma2 a2 = na2.a(next);
                if (a2 == null) {
                    pa2Var.c(next, false);
                } else if (a2.f()) {
                    pa2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    qa2 t = oa2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(vd4.b(e2));
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

    @Override // com.repackage.s84
    public void C(r94 r94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, r94Var) == null) {
            super.C(r94Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + r94Var.toString());
            }
            e0(new Exception("failed by fetch error = " + r94Var));
        }
    }

    @Override // com.repackage.s84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.repackage.s84
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

    @Override // com.repackage.s84
    public void G(fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fe4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(fe4Var == null ? 0 : fe4Var.n());
                Log.i(str, sb.toString());
            }
            super.G(fe4Var);
            if (fe4Var == null) {
                return;
            }
            this.f = fe4Var;
            if (fe4Var.k()) {
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
            for (qa2 qa2Var : this.i.values()) {
                if (!qa2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + qa2Var);
                        return;
                    }
                    return;
                }
            }
            d0(exc);
        }
    }

    public final qa2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            qa2 qa2Var = this.i.get(str);
            if (qa2Var == null || !qa2Var.r(this)) {
                return null;
            }
            return qa2Var;
        }
        return (qa2) invokeL.objValue;
    }

    public final vu9<z94> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (vu9) invokeV.objValue;
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f.g()) {
                arrayList.add(pu9.a(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            pu9.i(arrayList).u(b0());
        }
    }

    public final void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
            }
            pa2 pa2Var = this.k;
            if (pa2Var != null) {
                pa2Var.b(exc);
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
            for (qa2 qa2Var : this.i.values()) {
                if (qa2Var != null && qa2Var.r(this) && !qa2Var.n() && !qa2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + qa2Var);
                    }
                    qa2Var.q();
                }
            }
            Z(exc);
        }
    }

    public final void f0(z94 z94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, z94Var) == null) {
            v32.c().d(z94Var, new d(this, z94Var));
        }
    }

    @Override // com.repackage.ud4
    public hc4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (hc4) invokeV.objValue;
    }

    public final void g0(z94 z94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, z94Var) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler updateBestSo start so=" + z94Var);
            }
            if (z94Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            vd4 vd4Var = this.j.get(z94Var.g);
            if (vd4Var == null) {
                if (m) {
                    String str2 = this.c;
                    Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + z94Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(z94Var.p)) {
                z94Var.p = vd4Var.a;
            }
            qa2 a0 = a0(z94Var.p);
            if (a0 == null) {
                if (m) {
                    String str3 = this.c;
                    Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + z94Var.p);
                    return;
                }
                return;
            }
            if (z94Var.q == null) {
                z94Var.q = vd4Var.c;
            }
            if (!AbiType.currentAbi().compat(z94Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            z94 l = a0.l();
            z94 j = a0.j();
            long max = Math.max(j != null ? j.i : 0L, l == null ? 0L : l.i);
            long j2 = z94Var.i;
            if (j2 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(z94Var.i)));
                }
            } else if (j2 > max) {
                if (m) {
                    String str4 = this.c;
                    Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + z94Var.i);
                }
                a0.w(this, z94Var);
            } else {
                if (j == null || !j.q.compat(z94Var.q)) {
                    if (m) {
                        String str5 = this.c;
                        Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + z94Var.q);
                    }
                    a0.w(this, z94Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.repackage.ud4
    public s84 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (s84) invokeV.objValue;
    }

    @Override // com.repackage.ud4
    @Nullable
    public dc4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.g : (dc4) invokeV.objValue;
    }

    @Override // com.repackage.rd4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((z94) ee4.j(jSONObject, new z94()));
            }
        }
    }

    @Override // com.repackage.rd4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            pd4 pd4Var = new pd4();
            fe4 fe4Var = new fe4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !te3.G() && yw2.j() == 1) ? false : false) {
                String i = yw2.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        z94 z94Var = (z94) ee4.j(new JSONObject(i), new z94());
                        z94Var.g = "so_zeus_armeabi";
                        g0(z94Var);
                        r03.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1230)).G();
                    } catch (JSONException e2) {
                        r03.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f122f)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (qa2 qa2Var : this.i.values()) {
                if (qa2Var.r(this)) {
                    g0(qa2Var.l());
                    z94 j = qa2Var.j();
                    if (qa2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        qd4.b(j, fe4Var);
                        if (pd4Var.d == null) {
                            pd4Var.d = new ArrayList();
                        }
                        pd4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        qa2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + fe4Var.n());
            }
            if (fe4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(fe4Var);
            ia4.e(pd4Var, this);
        }
    }

    @Override // com.repackage.s84
    public rd4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.w(str) : (rd4) invokeL.objValue;
    }

    @Override // com.repackage.s84
    public o84<z94> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (o84) invokeV.objValue;
    }
}
