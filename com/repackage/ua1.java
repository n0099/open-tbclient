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
/* loaded from: classes7.dex */
public class ua1 implements jd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hd1 a;
    public String b;
    public final Context c;
    public final pa1 d;
    public w8.b e;
    public int f;
    public int g;
    public za1 h;
    public int i;
    public na1 j;
    public final oa1 k;

    /* loaded from: classes7.dex */
    public class a implements oa1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ua1 a;

        public a(ua1 ua1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ua1Var;
        }

        @Override // com.repackage.oa1
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    this.a.d.b(th == null ? "unKnow" : th.getMessage());
                }
            }
        }

        @Override // com.repackage.oa1
        public void b(@NonNull za1 za1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, za1Var) == null) || w8.f().i()) {
                return;
            }
            int f = xa1.f(za1Var, this.a.i);
            if (f == 0) {
                this.a.h = za1Var;
                hd1 a = new pc1().a(this.a.c, va1.a(za1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a.a = a;
                if (this.a.d != null) {
                    qa1 qa1Var = new qa1(a, this.a.d.g(), za1Var);
                    qa1Var.l(this.a.d);
                    a.c(qa1Var);
                    a.a(qa1Var);
                    qa1Var.k(this.a);
                    this.a.j(!za1Var.i());
                    this.a.m(!za1Var.g());
                    this.a.d.e(this.a);
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
                pa1 pa1Var = this.a.d;
                pa1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public ua1(Context context, String str, rc1 rc1Var, pa1 pa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, rc1Var, pa1Var};
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
        this.k = new a(this);
        this.c = context;
        this.b = str;
        this.d = pa1Var;
        if (rc1Var == null || rc1Var.a() == null || !rc1Var.a().containsKey("launch_type")) {
            return;
        }
        try {
            this.i = Integer.parseInt(rc1Var.a().get("launch_type"));
        } catch (NumberFormatException unused) {
            this.i = 0;
        }
    }

    @Override // com.repackage.jd1
    @Nullable
    public za1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h : (za1) invokeV.objValue;
    }

    @Override // com.repackage.jd1
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
                l(xa1.p(this.i));
                return;
            }
            na1 na1Var = new na1();
            this.j = na1Var;
            na1Var.j(this.b, this.k);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f = i;
        }
    }

    public void k(hd1 hd1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hd1Var) == null) {
            this.a = hd1Var;
        }
    }

    public void l(za1 za1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, za1Var) == null) {
            if (za1Var != null) {
                this.h = za1Var;
                qc1 a2 = va1.a(za1Var);
                hd1 a3 = new pc1().a(this.c, a2);
                if (a3 == null) {
                    if (ia1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    pa1 pa1Var = this.d;
                    if (pa1Var != null) {
                        pa1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a = a3;
                pa1 pa1Var2 = this.d;
                if (pa1Var2 != null) {
                    qa1 qa1Var = new qa1(a3, pa1Var2.g(), za1Var);
                    qa1Var.l(this.d);
                    a3.c(qa1Var);
                    a3.a(qa1Var);
                    qa1Var.k(this);
                    j(!za1Var.i());
                    m(!za1Var.g());
                    this.d.e(this);
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
            pa1 pa1Var3 = this.d;
            if (pa1Var3 != null) {
                pa1Var3.b("本地物料null");
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
            hd1 hd1Var = this.a;
            if (viewGroup != null && hd1Var != null) {
                hd1Var.load();
                View adView = hd1Var.getAdView();
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
