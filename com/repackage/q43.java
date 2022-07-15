package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m53;
import com.repackage.po1;
import com.repackage.q53;
import com.repackage.qz1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class q43 extends i03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public u83 a;
    public final String b;
    public final String c;
    public final Set<j> d;
    public final Map<String, m53> e;
    public final xe3 f;

    /* loaded from: classes7.dex */
    public class a implements af3<h53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ q43 e;

        /* renamed from: com.repackage.q43$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0713a implements af3<k53<m53.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0713a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(k53<m53.e> k53Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                    a aVar = this.a;
                    aVar.e.u(aVar.a, k53Var);
                }
            }
        }

        public a(q43 q43Var, af3 af3Var, String str, boolean z, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q43Var, af3Var, str, Boolean.valueOf(z), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = q43Var;
            this.a = af3Var;
            this.b = str;
            this.c = z;
            this.d = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r8v4, types: [com.repackage.m53$e, ResultDataT] */
        /* JADX WARN: Type inference failed for: r8v6, types: [com.repackage.m53$e, ResultDataT] */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(h53 h53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h53Var) == null) {
                k53 k53Var = new k53();
                if (q43.g && gw2.m()) {
                    k53Var.e();
                    k53Var.a = new m53.e(true, null);
                    this.e.u(this.a, k53Var);
                    return;
                }
                boolean z = false;
                boolean z2 = h53Var == null;
                hx1.k("SwanAppSetting", "isResultNull = " + z2 + "; scope = " + this.b);
                if (!z2 && !h53Var.d) {
                    if (!this.c ? h53Var.j == 0 : h53Var.j <= 0) {
                        z = true;
                    }
                    if (z) {
                        this.e.c(this.d, this.b, this.c, new C0713a(this));
                        return;
                    }
                    if (h53Var.j > 0) {
                        k53Var.e();
                        k53Var.a = new m53.e(true, null);
                    } else {
                        k53Var.d(new OAuthException(10003));
                    }
                    this.e.u(this.a, k53Var);
                    return;
                }
                k53Var.d(new OAuthException(10005));
                this.e.u(this.a, k53Var);
                hx1.l("SwanAppSetting", "checkOrAuthorize", new Exception("authorize fail"));
                a73.r(10005, h53Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements af3<h53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af3 a;
        public final /* synthetic */ q43 b;

        public b(q43 q43Var, af3 af3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q43Var, af3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q43Var;
            this.a = af3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(h53 h53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h53Var) == null) {
                this.b.u(this.a, h53Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ q43 b;

        public c(q43 q43Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q43Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q43Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                this.b.e.remove(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends ve3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m53 b;
        public final /* synthetic */ String c;

        /* loaded from: classes7.dex */
        public class a implements af3<k53<m53.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(k53<m53.e> k53Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                    this.a.a();
                }
            }
        }

        public d(q43 q43Var, m53 m53Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q43Var, m53Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m53Var;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m53 m53Var = this.b;
                m53Var.q(s63.a(this.c));
                m53Var.o(new a(this));
                this.b.call();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends i<af3<ResulT>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(q43 q43Var, Object obj) {
            super(q43Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q43Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((q43) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q43.i
        /* renamed from: b */
        public void a(af3<ResulT> af3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, af3Var) == null) {
                af3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;
        public final /* synthetic */ Object b;

        public f(q43 q43Var, i iVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q43Var, iVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends i<j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(q43 q43Var) {
            super(q43Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((q43) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q43.i
        /* renamed from: b */
        public void a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) {
                jVar.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends ve3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ po1.d c;
        public final /* synthetic */ Bundle d;
        public final /* synthetic */ String e;
        public final /* synthetic */ af3 f;

        /* loaded from: classes7.dex */
        public class a implements af3<k53<q53.d>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(k53<q53.d> k53Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                    this.a.a();
                }
            }
        }

        public h(q43 q43Var, Activity activity, po1.d dVar, Bundle bundle, String str, af3 af3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q43Var, activity, dVar, bundle, str, af3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = activity;
            this.c = dVar;
            this.d = bundle;
            this.e = str;
            this.f = af3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q53 b = g03.K().x().a().b().b(this.b, this.c, this.d);
                b.q(this.e);
                b.o(this.f);
                b.o(new a(this));
                b.call();
            }
        }
    }

    /* loaded from: classes7.dex */
    public abstract class i<CallBackT> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(q43 q43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract void a(CallBackT callbackt);

        public /* synthetic */ i(q43 q43Var, a aVar) {
            this(q43Var);
        }
    }

    /* loaded from: classes7.dex */
    public interface j {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755430143, "Lcom/repackage/q43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755430143, "Lcom/repackage/q43;");
                return;
            }
        }
        g = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q43(h03 h03Var) {
        super(h03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h03Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new HashSet();
        this.e = new HashMap();
        this.f = new xe3();
        this.b = p73.t(h03Var);
        this.c = "aiapp_setting_" + this.b;
    }

    public static void x(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable) == null) {
            be3.e0(runnable);
        }
    }

    public void A(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            o().putLong(str, j2);
        }
    }

    public void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            o().putString(str, str2);
        }
    }

    public synchronized void C(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar) == null) {
            synchronized (this) {
                this.d.add(jVar);
            }
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.a.remove(str);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            qz1 V = ul2.U().V();
            if (V == null) {
                zz2.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01a1).G();
                return false;
            }
            qz1.b i2 = V.i("navigateTo");
            i2.n(qz1.g, qz1.i);
            i2.k("authority", null).a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void F(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            synchronized (this) {
                this.d.remove(jVar);
            }
        }
    }

    public void c(Context context, String str, boolean z, af3<k53<m53.e>> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, Boolean.valueOf(z), af3Var}) == null) {
            d(context, str, z, true, false, af3Var);
        }
    }

    public void d(Context context, String str, boolean z, boolean z2, boolean z3, af3<k53<m53.e>> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), af3Var}) == null) {
            y(context, str, z, z2, z3, af3Var);
        }
    }

    public void e(String str, af3<h53> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, af3Var) == null) {
            if (TextUtils.isEmpty(str)) {
                u(af3Var, null);
            } else {
                fs2.i(str, new b(this, af3Var));
            }
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (g && gw2.m()) {
                return true;
            }
            h53 k = fs2.k(str);
            return (k == null || k.d || !k.a()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void g(Context context, String str, af3<k53<m53.e>> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, str, af3Var) == null) {
            h(context, str, false, af3Var);
        }
    }

    public void h(Context context, String str, boolean z, af3<k53<m53.e>> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, Boolean.valueOf(z), af3Var}) == null) {
            e(str, new a(this, af3Var, str, z, context));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            o().edit().clear().apply();
        }
    }

    public synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                this.e.clear();
                this.f.c();
                k();
            }
        }
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                this.d.clear();
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            o().edit().clear().commit();
        }
    }

    public boolean m(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) ? o().getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public long n(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048593, this, str, j2)) == null) ? o().getLong(str, j2) : invokeLJ.longValue;
    }

    public final u83 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                this.a = new u83(this.c, false);
            }
            return this.a;
        }
        return (u83) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public String q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) ? o().getString(str, str2) : (String) invokeLL.objValue;
    }

    public void r(Activity activity, po1.d dVar, Bundle bundle, af3<k53<q53.d>> af3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048597, this, activity, dVar, bundle, af3Var, str) == null) {
            this.f.d(new h(this, activity, dVar, bundle, str, af3Var));
        }
    }

    public synchronized <CallBackT> void s(CallBackT callbackt, i<CallBackT> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, callbackt, iVar) == null) {
            synchronized (this) {
                x(new f(this, iVar, callbackt));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.repackage.q43 */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized <CallBackT> void t(Collection<CallBackT> collection, i<CallBackT> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, collection, iVar) == null) {
            synchronized (this) {
                Iterator it = new ArrayList(collection).iterator();
                while (it.hasNext()) {
                    s(it.next(), iVar);
                }
            }
        }
    }

    public final <ResulT> void u(af3<ResulT> af3Var, ResulT result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, af3Var, result) == null) {
            s(af3Var, new e(this, result));
        }
    }

    public synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                t(this.d, new g(this));
            }
        }
    }

    public void w(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, activity) == null) {
        }
    }

    public final void y(Context context, String str, boolean z, boolean z2, boolean z3, af3<k53<m53.e>> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), af3Var}) == null) {
            String str2 = TextUtils.isEmpty(str) ? "" : str;
            m53 m53Var = this.e.get(str2);
            if (m53Var != null && TaskState.FINISHED != m53Var.e()) {
                m53Var.o(af3Var);
                return;
            }
            m53 d2 = g03.K().x().a().b().d(context, z, z2, new String[]{str2}, null, z3);
            this.e.put(str2, d2);
            d2.o(af3Var);
            d2.o(new c(this, str2));
            a73.T(s63.a(str), "requestModifyScope");
            this.f.d(new d(this, d2, str));
        }
    }

    public void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, str, z) == null) {
            o().putBoolean(str, z);
        }
    }
}
