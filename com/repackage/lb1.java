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
public class lb1 implements ae1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yd1 a;
    public String b;
    public final Context c;
    public final gb1 d;
    public w8.b e;
    public int f;
    public int g;
    public qb1 h;
    public int i;
    public eb1 j;
    public final fb1 k;

    /* loaded from: classes6.dex */
    public class a implements fb1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lb1 a;

        public a(lb1 lb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lb1Var;
        }

        @Override // com.repackage.fb1
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

        @Override // com.repackage.fb1
        public void b(@NonNull qb1 qb1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qb1Var) == null) || w8.f().i()) {
                return;
            }
            int f = ob1.f(qb1Var, this.a.i);
            if (f == 0) {
                this.a.h = qb1Var;
                yd1 a = new gd1().a(this.a.c, mb1.a(qb1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a.a = a;
                if (this.a.d != null) {
                    hb1 hb1Var = new hb1(a, this.a.d.g(), qb1Var);
                    hb1Var.l(this.a.d);
                    a.c(hb1Var);
                    a.a(hb1Var);
                    hb1Var.k(this.a);
                    this.a.j(!qb1Var.i());
                    this.a.m(!qb1Var.g());
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
                gb1 gb1Var = this.a.d;
                gb1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public lb1(Context context, String str, id1 id1Var, gb1 gb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, id1Var, gb1Var};
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
        this.d = gb1Var;
        if (id1Var == null || id1Var.a() == null || !id1Var.a().containsKey("launch_type")) {
            return;
        }
        try {
            this.i = Integer.parseInt(id1Var.a().get("launch_type"));
        } catch (NumberFormatException unused) {
            this.i = 0;
        }
    }

    @Override // com.repackage.ae1
    @Nullable
    public qb1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h : (qb1) invokeV.objValue;
    }

    @Override // com.repackage.ae1
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
                l(ob1.p(this.i));
                return;
            }
            eb1 eb1Var = new eb1();
            this.j = eb1Var;
            eb1Var.j(this.b, this.k);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f = i;
        }
    }

    public void k(yd1 yd1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yd1Var) == null) {
            this.a = yd1Var;
        }
    }

    public void l(qb1 qb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, qb1Var) == null) {
            if (qb1Var != null) {
                this.h = qb1Var;
                hd1 a2 = mb1.a(qb1Var);
                yd1 a3 = new gd1().a(this.c, a2);
                if (a3 == null) {
                    if (za1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    gb1 gb1Var = this.d;
                    if (gb1Var != null) {
                        gb1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a = a3;
                gb1 gb1Var2 = this.d;
                if (gb1Var2 != null) {
                    hb1 hb1Var = new hb1(a3, gb1Var2.g(), qb1Var);
                    hb1Var.l(this.d);
                    a3.c(hb1Var);
                    a3.a(hb1Var);
                    hb1Var.k(this);
                    j(!qb1Var.i());
                    m(!qb1Var.g());
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
            gb1 gb1Var3 = this.d;
            if (gb1Var3 != null) {
                gb1Var3.b("本地物料null");
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
            yd1 yd1Var = this.a;
            if (viewGroup != null && yd1Var != null) {
                yd1Var.load();
                View adView = yd1Var.getAdView();
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
