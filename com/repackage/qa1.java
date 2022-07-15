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
/* loaded from: classes7.dex */
public class qa1 implements gd1, id1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final hd1 a;
    @NonNull
    public ViewGroup b;
    @NonNull
    public final za1 c;
    @NonNull
    public final BaseVM d;
    @Nullable
    public pa1 e;
    public long f;
    public long g;
    public final long h;
    public long i;
    public boolean j;
    public ua1 k;

    /* loaded from: classes7.dex */
    public class a implements db1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qa1 a;

        public a(qa1 qa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qa1Var;
        }

        @Override // com.repackage.db1
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.a.e != null) {
                    return this.a.e.c(str);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.db1
        public void handleSchemeDispatchCallback(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qa1 a;

        public b(qa1 qa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qa1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.d();
            }
        }
    }

    public qa1(@NonNull hd1 hd1Var, @NonNull ViewGroup viewGroup, @NonNull za1 za1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hd1Var, viewGroup, za1Var};
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
        this.a = hd1Var;
        this.b = viewGroup;
        this.c = za1Var;
        this.d = new BaseVM(za1Var);
        ta1.b(za1Var);
    }

    @Override // com.repackage.gd1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (ya1.r() && !TextUtils.isEmpty(this.c.p)) {
                qg0.b(this.c.p);
                if (xe0.a) {
                    yz0.a().a(this.a.getAdView().getContext(), "执行nad统一新协议跳转");
                }
            } else {
                gb1.a(hh0.b(), this.c.o, new a(this));
                if (xe0.a) {
                    yz0.a().a(this.a.getAdView().getContext(), "执行splash旧协议跳转");
                }
            }
            j(BaseVM.CloseType.CLICK_AD_AREA.value);
            this.d.b("");
            pa1 pa1Var = this.e;
            if (pa1Var != null) {
                pa1Var.a();
            }
        }
    }

    @Override // com.repackage.gd1
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.repackage.gd1
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.repackage.id1
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g = System.currentTimeMillis();
        }
    }

    @Override // com.repackage.gd1
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            pa1 pa1Var = this.e;
            if (pa1Var != null) {
                pa1Var.onSkip();
            }
            j(BaseVM.CloseType.CLICK_SKIP_BUTTON.value);
        }
    }

    @Override // com.repackage.gd1
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.repackage.id1
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
            xa1.D(this.c);
            bb1.e(this.c);
            pa1 pa1Var = this.e;
            if (pa1Var != null) {
                pa1Var.onAdShow();
            }
        }
    }

    @Override // com.repackage.id1
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
                uh0.b(new b(this));
            }
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            w8.f().e();
            if (this.j) {
                this.j = false;
                this.d.e(str, this.i);
            }
        }
    }

    public void k(ua1 ua1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ua1Var) == null) {
            this.k = ua1Var;
            hd1 hd1Var = this.a;
            if (hd1Var != null) {
                ua1Var.k(hd1Var);
            }
        }
    }

    public void l(@NonNull pa1 pa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pa1Var) == null) {
            this.e = pa1Var;
        }
    }

    @Override // com.repackage.id1
    public void onAdError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.i = System.currentTimeMillis() - this.f;
            pa1 pa1Var = this.e;
            if (pa1Var != null) {
                pa1Var.f();
            }
        }
    }
}
