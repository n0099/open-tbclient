package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r72 a;
    public k34 b;
    public Context c;
    public os1 d;
    public os1 e;
    public os1 f;
    public ay3 g;
    public dy3 h;
    public cy3 i;
    public cy3 j;
    public zx3 k;
    public f l;

    /* loaded from: classes7.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx3 a;

        public a(yx3 yx3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx3Var;
        }

        @Override // com.repackage.yx3.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }

        @Override // com.repackage.yx3.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                dy3 dy3Var = new dy3();
                dy3Var.errMsg = "showKeyboard:ok";
                dy3Var.height = i;
                s24.call(this.a.d, true, dy3Var);
            }
        }

        @Override // com.repackage.yx3.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.c(str);
        }

        @Override // com.repackage.yx3.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.b(str);
        }

        @Override // com.repackage.yx3.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.d(str);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx3 a;

        public b(yx3 yx3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l34.p().n(this.a.b)) {
                    this.a.h.errMsg = "showKeyboard:fail";
                    s24.call(this.a.d, false, this.a.h);
                    return;
                }
                this.a.b.j(this.a.g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx3 a;

        public c(yx3 yx3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (l34.p().s(this.a.b)) {
                    this.a.i.errMsg = "hideKeyboard:ok";
                    s24.call(this.a.e, true, this.a.i);
                    return;
                }
                this.a.i.errMsg = "hideKeyboard:fail";
                s24.call(this.a.e, false, this.a.i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx3 a;

        public d(yx3 yx3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l34.p().s(this.a.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yx3 b;

        public e(yx3 yx3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yx3Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.b.m(this.a)) {
                    this.b.j.errMsg = "updateKeyboard:ok";
                    s24.call(this.b.f, true, this.b.j);
                    return;
                }
                this.b.j.errMsg = "updateKeyboard:fail";
                s24.call(this.b.f, false, this.b.j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a();

        void b(int i);

        void c(String str);

        void d(String str);

        void e(String str);
    }

    public yx3(r72 r72Var, zx3 zx3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r72Var, zx3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        this.l = new a(this);
        this.a = r72Var;
        Context appContext = AppRuntime.getAppContext();
        this.c = appContext;
        k34 k34Var = new k34(appContext);
        this.b = k34Var;
        k34Var.i(this.l);
        this.k = zx3Var;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            be3.e0(new d(this));
        }
    }

    public void k(JsObject jsObject) {
        k34 k34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.i = new cy3();
            os1 F = os1.F(jsObject);
            this.e = F;
            if (F == null) {
                this.e = new os1();
            }
            if (this.a != null && (k34Var = this.b) != null && k34Var.g()) {
                be3.e0(new c(this));
                return;
            }
            cy3 cy3Var = this.i;
            cy3Var.errMsg = "hideKeyboard:fail";
            s24.call(this.e, false, cy3Var);
        }
    }

    public void l(JsObject jsObject) {
        k34 k34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.h = new dy3();
            os1 F = os1.F(jsObject);
            this.d = F;
            if (F == null) {
                this.d = new os1();
            }
            if (this.a != null && (k34Var = this.b) != null && !k34Var.g()) {
                ay3 ay3Var = new ay3();
                this.g = ay3Var;
                try {
                    if (ay3Var.a(this.d)) {
                        be3.f0(new b(this), 500L);
                    } else {
                        this.h.errMsg = "showKeyboard:fail";
                        s24.call(this.d, false, this.h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    dy3 dy3Var = this.h;
                    dy3Var.errMsg = "showKeyboard:fail";
                    s24.call(this.d, false, dy3Var);
                    return;
                }
            }
            dy3 dy3Var2 = this.h;
            dy3Var2.errMsg = "showKeyboard:fail";
            s24.call(this.d, false, dy3Var2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.j = new cy3();
            os1 F = os1.F(jsObject);
            this.f = F;
            if (F == null) {
                this.f = new os1();
            }
            if (this.a != null && this.b != null) {
                be3.e0(new e(this, this.f.B("value")));
                return;
            }
            cy3 cy3Var = this.j;
            cy3Var.errMsg = "updateKeyboard:fail";
            s24.call(this.f, false, cy3Var);
        }
    }
}
