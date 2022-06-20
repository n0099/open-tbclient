package com.repackage;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.sdk.container.interfaces.LoadState;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.w8;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ga1 implements uc1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sc1 a;
    public String b;
    public final Context c;
    public final ba1 d;
    public w8.b e;
    public int f;
    public int g;
    public ka1 h;
    public int i;
    public final aa1 j;

    /* loaded from: classes6.dex */
    public class a implements aa1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga1 a;

        public a(ga1 ga1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga1Var;
        }

        @Override // com.repackage.aa1
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    this.a.d.c(th == null ? "unKnow" : th.getMessage());
                }
            }
        }

        @Override // com.repackage.aa1
        public void b(@NonNull ka1 ka1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ka1Var) == null) || w8.f().i()) {
                return;
            }
            int f = ia1.f(ka1Var, this.a.i);
            if (f == 0) {
                this.a.h = ka1Var;
                sc1 a = new ac1().a(this.a.c, ha1.a(ka1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.c("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a.a = a;
                if (this.a.d != null) {
                    ca1 ca1Var = new ca1(a, this.a.d.h(), ka1Var);
                    ca1Var.l(this.a.d);
                    a.c(ca1Var);
                    a.a(ca1Var);
                    ca1Var.k(this.a);
                    this.a.j(!ka1Var.i());
                    this.a.m(!ka1Var.g());
                    this.a.d.f(this.a);
                }
                if (this.a.e != null) {
                    this.a.e.onSuccess();
                    return;
                }
                return;
            }
            if (this.a.e != null) {
                this.a.e.onFailed();
            } else if (this.a.d != null) {
                ba1 ba1Var = this.a.d;
                ba1Var.c("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public ga1(Context context, String str, cc1 cc1Var, ba1 ba1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, cc1Var, ba1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LoadState loadState = LoadState.INIT;
        this.i = 0;
        this.j = new a(this);
        this.c = context;
        this.b = str;
        this.d = ba1Var;
        if (cc1Var == null || cc1Var.a() == null || !cc1Var.a().containsKey("launch_type")) {
            return;
        }
        try {
            this.i = Integer.parseInt(cc1Var.a().get("launch_type"));
        } catch (NumberFormatException unused) {
            this.i = 0;
        }
    }

    @Override // com.repackage.uc1
    @Nullable
    public ka1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h : (ka1) invokeV.objValue;
    }

    @Override // com.repackage.uc1
    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.h != null) {
                    jSONObject.put("source", this.h.E);
                    jSONObject.put(QuickPersistConfigConst.KEY_SPLASH_SORT, this.h.F);
                }
                jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f);
                jSONObject.put("full_type", this.g);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == null) {
            return;
        }
        this.a = null;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!w8.f().h()) {
                l(ia1.n(this.i));
            } else {
                new z91().j(this.b, this.j);
            }
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f = i;
        }
    }

    public void k(sc1 sc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sc1Var) == null) {
            this.a = sc1Var;
        }
    }

    public void l(ka1 ka1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ka1Var) == null) {
            if (ka1Var != null) {
                this.h = ka1Var;
                bc1 a2 = ha1.a(ka1Var);
                sc1 a3 = new ac1().a(this.c, a2);
                if (a3 == null) {
                    if (u91.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    ba1 ba1Var = this.d;
                    if (ba1Var != null) {
                        ba1Var.c("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a = a3;
                ba1 ba1Var2 = this.d;
                if (ba1Var2 != null) {
                    ca1 ca1Var = new ca1(a3, ba1Var2.h(), ka1Var);
                    ca1Var.l(this.d);
                    a3.c(ca1Var);
                    a3.a(ca1Var);
                    ca1Var.k(this);
                    j(!ka1Var.i());
                    m(!ka1Var.g());
                    this.d.f(this);
                }
                w8.b bVar = this.e;
                if (bVar != null) {
                    bVar.onSuccess();
                    return;
                }
                return;
            }
            w8.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            ba1 ba1Var3 = this.d;
            if (ba1Var3 != null) {
                ba1Var3.c("本地物料null");
            }
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    public void n(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            sc1 sc1Var = this.a;
            if (viewGroup != null && sc1Var != null) {
                sc1Var.load();
                View adView = sc1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                } else {
                    h();
                    return;
                }
            }
            h();
        }
    }
}
