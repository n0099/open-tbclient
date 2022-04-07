package com.repackage;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
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
public class xa1 implements ld1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jd1 a;
    public String b;
    public final Context c;
    public final sa1 d;
    public u8.b e;
    public int f;
    public int g;
    public bb1 h;
    public int i;
    public final ra1 j;

    /* loaded from: classes7.dex */
    public class a implements ra1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa1 a;

        public a(xa1 xa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa1Var;
        }

        @Override // com.repackage.ra1
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

        @Override // com.repackage.ra1
        public void b(@NonNull bb1 bb1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bb1Var) == null) || u8.f().i()) {
                return;
            }
            int f = za1.f(bb1Var, this.a.i);
            if (f == 0) {
                this.a.h = bb1Var;
                jd1 a = new rc1().a(this.a.c, ya1.a(bb1Var));
                if (a == null) {
                    return;
                }
                this.a.a = a;
                if (this.a.d != null) {
                    ta1 ta1Var = new ta1(a, this.a.d.h(), bb1Var);
                    ta1Var.l(this.a.d);
                    a.c(ta1Var);
                    a.a(ta1Var);
                    ta1Var.k(this.a);
                    this.a.i(!bb1Var.i());
                    this.a.l(!bb1Var.g());
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
                sa1 sa1Var = this.a.d;
                sa1Var.c("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public xa1(Context context, String str, tc1 tc1Var, sa1 sa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, tc1Var, sa1Var};
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
        this.d = sa1Var;
        if (tc1Var == null || tc1Var.a() == null || !tc1Var.a().containsKey("launch_type")) {
            return;
        }
        try {
            this.i = Integer.parseInt(tc1Var.a().get("launch_type"));
        } catch (NumberFormatException unused) {
            this.i = 0;
        }
    }

    @Override // com.repackage.ld1
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.h != null) {
                    jSONObject.put("source", this.h.D);
                    jSONObject.put(QuickPersistConfigConst.KEY_SPLASH_SORT, this.h.E);
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

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a == null) {
            return;
        }
        this.a = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!u8.f().h()) {
                k(za1.n(this.i));
            } else {
                new qa1().j(this.b, this.j);
            }
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f = i;
        }
    }

    public void j(jd1 jd1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jd1Var) == null) {
            this.a = jd1Var;
        }
    }

    public void k(bb1 bb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bb1Var) == null) {
            if (bb1Var != null) {
                this.h = bb1Var;
                sc1 a2 = ya1.a(bb1Var);
                jd1 a3 = new rc1().a(this.c, a2);
                if (a3 == null) {
                    if (la1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                        return;
                    }
                    return;
                }
                this.a = a3;
                sa1 sa1Var = this.d;
                if (sa1Var != null) {
                    ta1 ta1Var = new ta1(a3, sa1Var.h(), bb1Var);
                    ta1Var.l(this.d);
                    a3.c(ta1Var);
                    a3.a(ta1Var);
                    ta1Var.k(this);
                    i(!bb1Var.i());
                    l(!bb1Var.g());
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
            sa1 sa1Var2 = this.d;
            if (sa1Var2 != null) {
                sa1Var2.c("本地物料null");
            }
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.g = i;
        }
    }

    public void m(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewGroup) == null) {
            jd1 jd1Var = this.a;
            if (viewGroup != null && jd1Var != null) {
                jd1Var.load();
                View adView = jd1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                } else {
                    g();
                    return;
                }
            }
            g();
        }
    }
}
