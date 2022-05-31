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
import com.repackage.u8;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class v91 implements jc1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hc1 a;
    public String b;
    public final Context c;
    public final q91 d;
    public u8.b e;
    public int f;
    public int g;
    public z91 h;
    public int i;
    public final p91 j;

    /* loaded from: classes7.dex */
    public class a implements p91 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v91 a;

        public a(v91 v91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v91Var;
        }

        @Override // com.repackage.p91
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

        @Override // com.repackage.p91
        public void b(@NonNull z91 z91Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z91Var) == null) || u8.f().i()) {
                return;
            }
            int f = x91.f(z91Var, this.a.i);
            if (f == 0) {
                this.a.h = z91Var;
                hc1 a = new pb1().a(this.a.c, w91.a(z91Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.c("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a.a = a;
                if (this.a.d != null) {
                    r91 r91Var = new r91(a, this.a.d.h(), z91Var);
                    r91Var.l(this.a.d);
                    a.c(r91Var);
                    a.a(r91Var);
                    r91Var.k(this.a);
                    this.a.j(!z91Var.i());
                    this.a.m(!z91Var.g());
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
                q91 q91Var = this.a.d;
                q91Var.c("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public v91(Context context, String str, rb1 rb1Var, q91 q91Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, rb1Var, q91Var};
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
        this.d = q91Var;
        if (rb1Var == null || rb1Var.a() == null || !rb1Var.a().containsKey("launch_type")) {
            return;
        }
        try {
            this.i = Integer.parseInt(rb1Var.a().get("launch_type"));
        } catch (NumberFormatException unused) {
            this.i = 0;
        }
    }

    @Override // com.repackage.jc1
    @Nullable
    public z91 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h : (z91) invokeV.objValue;
    }

    @Override // com.repackage.jc1
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
            if (!u8.f().h()) {
                l(x91.n(this.i));
            } else {
                new o91().j(this.b, this.j);
            }
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f = i;
        }
    }

    public void k(hc1 hc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hc1Var) == null) {
            this.a = hc1Var;
        }
    }

    public void l(z91 z91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, z91Var) == null) {
            if (z91Var != null) {
                this.h = z91Var;
                qb1 a2 = w91.a(z91Var);
                hc1 a3 = new pb1().a(this.c, a2);
                if (a3 == null) {
                    if (j91.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    q91 q91Var = this.d;
                    if (q91Var != null) {
                        q91Var.c("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a = a3;
                q91 q91Var2 = this.d;
                if (q91Var2 != null) {
                    r91 r91Var = new r91(a3, q91Var2.h(), z91Var);
                    r91Var.l(this.d);
                    a3.c(r91Var);
                    a3.a(r91Var);
                    r91Var.k(this);
                    j(!z91Var.i());
                    m(!z91Var.g());
                    this.d.f(this);
                }
                u8.b bVar = this.e;
                if (bVar != null) {
                    bVar.onSuccess();
                    return;
                }
                return;
            }
            u8.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            q91 q91Var3 = this.d;
            if (q91Var3 != null) {
                q91Var3.c("本地物料null");
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
            hc1 hc1Var = this.a;
            if (viewGroup != null && hc1Var != null) {
                hc1Var.load();
                View adView = hc1Var.getAdView();
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
