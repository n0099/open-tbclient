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
import com.repackage.bz9;
import com.repackage.f32;
import com.repackage.z92;
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
public final class ba2 extends n32 implements ed4, bd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public hz9<? super j94> d;
    public hz9<j94> e;
    public pd4 f;
    public final nb4 g;
    public y74<j94> h;
    public final Map<String, aa2> i;
    public final Map<String, fd4> j;
    public final z92 k;
    public final rb4<JSONArray> l;

    /* loaded from: classes5.dex */
    public class a implements rb4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 a;

        public a(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.rb4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.a.i.isEmpty()) {
                return;
            }
            for (aa2 aa2Var : this.a.i.values()) {
                if (aa2Var != null && aa2Var.r(this.a)) {
                    aa2Var.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements cf3<aa2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 a;

        public b(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(aa2 aa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aa2Var) == null) {
                if (ba2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + aa2Var);
                }
                if (aa2Var != null) {
                    this.a.k.c(aa2Var.k(), aa2Var.o());
                }
                this.a.a0(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements cf3<aa2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 a;

        public c(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(aa2 aa2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aa2Var) == null) || aa2Var == null) {
                return;
            }
            this.a.k.d(aa2Var.k(), aa2Var.m());
        }
    }

    /* loaded from: classes5.dex */
    public class d implements f32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j94 a;
        public final /* synthetic */ ba2 b;

        public d(ba2 ba2Var, j94 j94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var, j94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ba2Var;
            this.a = j94Var;
        }

        @Override // com.repackage.f32.c
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

        @Override // com.repackage.f32.c
        public void b(PMSDownloadType pMSDownloadType, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cc3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, cc3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements bz9.a<j94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 a;

        public e(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bz9.a, com.repackage.pz9
        public void call(hz9<? super j94> hz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz9Var) == null) {
                this.a.d = hz9Var;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends hz9<j94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 e;

        public f(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ba2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cz9
        /* renamed from: g */
        public void onNext(j94 j94Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, j94Var) == null) && ba2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + j94Var.toString());
            }
        }

        @Override // com.repackage.cz9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (ba2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.f0(null);
            }
        }

        @Override // com.repackage.cz9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (ba2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.f0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ f(ba2 ba2Var, a aVar) {
            this(ba2Var);
        }
    }

    /* loaded from: classes5.dex */
    public class g extends v74<j94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 a;

        public g(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.y74
        /* renamed from: l */
        public String d(j94 j94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, j94Var)) == null) {
                String g = y92.d.g(j94Var);
                if (ba2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + j94Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.a84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: o */
        public void e(j94 j94Var, b94 b94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j94Var, b94Var) == null) {
                super.e(j94Var, b94Var);
                if (ba2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + j94Var.g + " err=" + b94Var);
                }
                this.a.f.l(j94Var);
                cc3 cc3Var = new cc3();
                cc3Var.k(13L);
                cc3Var.i(b94Var.a);
                cc3Var.d("so包下载失败");
                cc3Var.f(b94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(j94Var, cc3Var));
                }
                f32.c().a(j94Var, ba2.o, cc3Var);
                mg4.k(j94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: p */
        public void i(j94 j94Var) {
            fd4 fd4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, j94Var) == null) {
                super.i(j94Var);
                if (ba2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + j94Var);
                }
                String str2 = j94Var.p;
                if (TextUtils.isEmpty(str2) && (fd4Var = (fd4) this.a.j.get(j94Var.g)) != null) {
                    str2 = fd4Var.a;
                }
                aa2 b0 = this.a.b0(str2);
                if (b0 != null) {
                    boolean a = wd3.a(new File(j94Var.a), j94Var.m);
                    if (ba2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + j94Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (ba2.m && !de3.G() && iw2.j() == 1) ? false : false;
                    if (a || z) {
                        e84.i().m(j94Var);
                        if (ba2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + b0 + " libName=" + str2);
                        }
                    }
                    b0.q();
                }
                this.a.f.m(j94Var);
                if (this.a.d != null) {
                    this.a.d.onNext(j94Var);
                    this.a.d.onCompleted();
                }
                f32.c().b(j94Var, ba2.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: q */
        public void a(j94 j94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, j94Var) == null) {
                super.a(j94Var);
                fd4 fd4Var = (fd4) this.a.j.get(j94Var.g);
                aa2 b0 = this.a.b0(fd4Var == null ? null : fd4Var.a);
                if (b0 != null) {
                    b0.x(new z92.b(j94Var.b, j94Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: r */
        public void c(j94 j94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, j94Var) == null) {
                super.c(j94Var);
                if (ba2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + j94Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: s */
        public void f(j94 j94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, j94Var) == null) {
                super.f(j94Var);
                if (ba2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + j94Var.g);
                }
                this.a.g0(j94Var);
            }
        }

        public /* synthetic */ g(ba2 ba2Var, a aVar) {
            this(ba2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755833794, "Lcom/repackage/ba2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755833794, "Lcom/repackage/ba2;");
                return;
            }
        }
        m = tg1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    public ba2(nb4 nb4Var, z92 z92Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nb4Var, z92Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + z92Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = nb4Var;
        this.k = z92Var;
        if (z92Var != null) {
            Iterator<String> it = z92Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                w92 a2 = x92.a(next);
                if (a2 == null) {
                    z92Var.c(next, false);
                } else if (a2.f()) {
                    z92Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    aa2 t = y92.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(fd4.b(e2));
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

    @Override // com.repackage.c84
    public y74<j94> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (y74) invokeV.objValue;
    }

    @Override // com.repackage.c84
    public void D(b94 b94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b94Var) == null) {
            super.D(b94Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + b94Var.toString());
            }
            f0(new Exception("failed by fetch error = " + b94Var));
        }
    }

    @Override // com.repackage.c84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.repackage.c84
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

    @Override // com.repackage.c84
    public void H(pd4 pd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pd4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(pd4Var == null ? 0 : pd4Var.n());
                Log.i(str, sb.toString());
            }
            super.H(pd4Var);
            if (pd4Var == null) {
                return;
            }
            this.f = pd4Var;
            if (pd4Var.k()) {
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
            for (aa2 aa2Var : this.i.values()) {
                if (!aa2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + aa2Var);
                        return;
                    }
                    return;
                }
            }
            e0(exc);
        }
    }

    public final aa2 b0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            aa2 aa2Var = this.i.get(str);
            if (aa2Var == null || !aa2Var.r(this)) {
                return null;
            }
            return aa2Var;
        }
        return (aa2) invokeL.objValue;
    }

    public final hz9<j94> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (hz9) invokeV.objValue;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f.g()) {
                arrayList.add(bz9.a(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            bz9.i(arrayList).u(c0());
        }
    }

    public final void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
            }
            z92 z92Var = this.k;
            if (z92Var != null) {
                z92Var.b(exc);
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
            for (aa2 aa2Var : this.i.values()) {
                if (aa2Var != null && aa2Var.r(this) && !aa2Var.n() && !aa2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + aa2Var);
                    }
                    aa2Var.q();
                }
            }
            a0(exc);
        }
    }

    @Override // com.repackage.ed4
    public rb4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (rb4) invokeV.objValue;
    }

    public final void g0(j94 j94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, j94Var) == null) {
            f32.c().d(j94Var, new d(this, j94Var));
        }
    }

    @Override // com.repackage.ed4
    @Nullable
    public nb4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.g : (nb4) invokeV.objValue;
    }

    public final void h0(j94 j94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, j94Var) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler updateBestSo start so=" + j94Var);
            }
            if (j94Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            fd4 fd4Var = this.j.get(j94Var.g);
            if (fd4Var == null) {
                if (m) {
                    String str2 = this.c;
                    Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + j94Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(j94Var.p)) {
                j94Var.p = fd4Var.a;
            }
            aa2 b0 = b0(j94Var.p);
            if (b0 == null) {
                if (m) {
                    String str3 = this.c;
                    Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + j94Var.p);
                    return;
                }
                return;
            }
            if (j94Var.q == null) {
                j94Var.q = fd4Var.c;
            }
            if (!AbiType.currentAbi().compat(j94Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            j94 l = b0.l();
            j94 j = b0.j();
            long max = Math.max(j != null ? j.i : 0L, l == null ? 0L : l.i);
            long j2 = j94Var.i;
            if (j2 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(j94Var.i)));
                }
            } else if (j2 > max) {
                if (m) {
                    String str4 = this.c;
                    Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + j94Var.i);
                }
                b0.w(this, j94Var);
            } else {
                if (j == null || !j.q.compat(j94Var.q)) {
                    if (m) {
                        String str5 = this.c;
                        Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + j94Var.q);
                    }
                    b0.w(this, j94Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.repackage.bd4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                h0((j94) od4.j(jSONObject, new j94()));
            }
        }
    }

    @Override // com.repackage.ed4
    public c84 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (c84) invokeV.objValue;
    }

    @Override // com.repackage.bd4
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            zc4 zc4Var = new zc4();
            pd4 pd4Var = new pd4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !de3.G() && iw2.j() == 1) ? false : false) {
                String i = iw2.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        j94 j94Var = (j94) od4.j(new JSONObject(i), new j94());
                        j94Var.g = "so_zeus_armeabi";
                        h0(j94Var);
                        b03.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f120c)).G();
                    } catch (JSONException e2) {
                        b03.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f120b)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (aa2 aa2Var : this.i.values()) {
                if (aa2Var.r(this)) {
                    h0(aa2Var.l());
                    j94 j = aa2Var.j();
                    if (aa2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        ad4.b(j, pd4Var);
                        if (zc4Var.d == null) {
                            zc4Var.d = new ArrayList();
                        }
                        zc4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        aa2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + pd4Var.n());
            }
            if (pd4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                G();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            H(pd4Var);
            s94.e(zc4Var, this);
        }
    }

    @Override // com.repackage.c84
    public bd4 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.x(str) : (bd4) invokeL.objValue;
    }
}
