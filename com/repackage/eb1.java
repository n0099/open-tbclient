package com.repackage;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class eb1 implements td1, vd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final ud1 a;
    @NonNull
    public ViewGroup b;
    @NonNull
    public final mb1 c;
    @NonNull
    public final BaseVM d;
    @Nullable
    public db1 e;
    public long f;
    public long g;
    public final long h;
    public long i;
    public boolean j;
    public ib1 k;

    /* loaded from: classes5.dex */
    public class a implements qb1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eb1 a;

        public a(eb1 eb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eb1Var;
        }

        @Override // com.repackage.qb1
        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.a.e != null) {
                    return this.a.e.d(str);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.qb1
        public void handleSchemeDispatchCallback(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eb1 a;

        public b(eb1 eb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eb1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.e();
            }
        }
    }

    public eb1(@NonNull ud1 ud1Var, @NonNull ViewGroup viewGroup, @NonNull mb1 mb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ud1Var, viewGroup, mb1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = true;
        this.h = System.currentTimeMillis();
        this.a = ud1Var;
        this.b = viewGroup;
        this.c = mb1Var;
        this.d = new BaseVM(mb1Var);
        hb1.b(mb1Var);
    }

    @Override // com.repackage.td1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.td1
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (lb1.r() && !TextUtils.isEmpty(this.c.p)) {
                th0.b(this.c.p);
                if (bg0.a) {
                    u01.a().a(this.a.getAdView().getContext(), "执行nad统一新协议跳转");
                }
            } else {
                tb1.a(ki0.b(), this.c.o, new a(this));
                if (bg0.a) {
                    u01.a().a(this.a.getAdView().getContext(), "执行splash旧协议跳转");
                }
            }
            j(BaseVM.CloseType.CLICK_AD_AREA.value);
            this.d.b("");
            db1 db1Var = this.e;
            if (db1Var != null) {
                db1Var.b();
            }
        }
    }

    @Override // com.repackage.td1
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.repackage.vd1
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g = System.currentTimeMillis();
        }
    }

    @Override // com.repackage.td1
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            db1 db1Var = this.e;
            if (db1Var != null) {
                db1Var.a();
            }
            j(BaseVM.CloseType.CLICK_SKIP_BUTTON.value);
        }
    }

    @Override // com.repackage.td1
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.repackage.vd1
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adShowScene", this.c.D);
                jSONObject.put("adSplashType", this.c.e);
                if (this.c.D == 1) {
                    long j = this.g - this.h;
                    if (j > 0) {
                        jSONObject.put("adLoadCostTime", j);
                    }
                }
                jSONObject.put("adRenderCostTime", this.f - this.h);
            } catch (JSONException unused) {
            }
            this.d.c(jSONObject);
            kb1.B(this.c);
            ob1.e(this.c);
            db1 db1Var = this.e;
            if (db1Var != null) {
                db1Var.onAdShow();
            }
        }
    }

    @Override // com.repackage.vd1
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.i = System.currentTimeMillis() - this.f;
            if ("time_end".equals(str)) {
                j(BaseVM.CloseType.COUNTDOWN_TIME_FINISH.value);
            } else if ("click_skip_button".equals(str)) {
                j(BaseVM.CloseType.CLICK_SKIP_BUTTON.value);
            } else if ("click_ad_area".equals(str)) {
                j(BaseVM.CloseType.CLICK_AD_AREA.value);
            } else {
                j(BaseVM.CloseType.OTHER.value);
            }
            if (this.e != null) {
                vi0.b(new b(this));
            }
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            u8.f().e();
            if (this.j) {
                this.j = false;
                this.d.e(str, this.i);
            }
        }
    }

    public void k(ib1 ib1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ib1Var) == null) {
            this.k = ib1Var;
            ud1 ud1Var = this.a;
            if (ud1Var != null) {
                ib1Var.k(ud1Var);
            }
        }
    }

    public void l(@NonNull db1 db1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, db1Var) == null) {
            this.e = db1Var;
        }
    }

    @Override // com.repackage.vd1
    public void onAdError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.i = System.currentTimeMillis() - this.f;
            db1 db1Var = this.e;
            if (db1Var != null) {
                db1Var.g();
            }
        }
    }
}
