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
/* loaded from: classes6.dex */
public class ib1 implements wd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ud1 a;
    public String b;
    public final Context c;
    public final db1 d;
    public u8.b e;
    public int f;
    public int g;
    public mb1 h;
    public int i;
    public final cb1 j;

    /* loaded from: classes6.dex */
    public class a implements cb1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ib1 a;

        public a(ib1 ib1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ib1Var;
        }

        @Override // com.repackage.cb1
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

        @Override // com.repackage.cb1
        public void b(@NonNull mb1 mb1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mb1Var) == null) || u8.f().i()) {
                return;
            }
            int f = kb1.f(mb1Var, this.a.i);
            if (f == 0) {
                this.a.h = mb1Var;
                ud1 a = new cd1().a(this.a.c, jb1.a(mb1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.c("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a.a = a;
                if (this.a.d != null) {
                    eb1 eb1Var = new eb1(a, this.a.d.h(), mb1Var);
                    eb1Var.l(this.a.d);
                    a.c(eb1Var);
                    a.a(eb1Var);
                    eb1Var.k(this.a);
                    this.a.j(!mb1Var.i());
                    this.a.m(!mb1Var.g());
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
                db1 db1Var = this.a.d;
                db1Var.c("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public ib1(Context context, String str, ed1 ed1Var, db1 db1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, ed1Var, db1Var};
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
        this.d = db1Var;
        if (ed1Var == null || ed1Var.a() == null || !ed1Var.a().containsKey("launch_type")) {
            return;
        }
        try {
            this.i = Integer.parseInt(ed1Var.a().get("launch_type"));
        } catch (NumberFormatException unused) {
            this.i = 0;
        }
    }

    @Override // com.repackage.wd1
    @Nullable
    public mb1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h : (mb1) invokeV.objValue;
    }

    @Override // com.repackage.wd1
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
                l(kb1.n(this.i));
            } else {
                new bb1().j(this.b, this.j);
            }
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f = i;
        }
    }

    public void k(ud1 ud1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ud1Var) == null) {
            this.a = ud1Var;
        }
    }

    public void l(mb1 mb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mb1Var) == null) {
            if (mb1Var != null) {
                this.h = mb1Var;
                dd1 a2 = jb1.a(mb1Var);
                ud1 a3 = new cd1().a(this.c, a2);
                if (a3 == null) {
                    if (wa1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    db1 db1Var = this.d;
                    if (db1Var != null) {
                        db1Var.c("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a = a3;
                db1 db1Var2 = this.d;
                if (db1Var2 != null) {
                    eb1 eb1Var = new eb1(a3, db1Var2.h(), mb1Var);
                    eb1Var.l(this.d);
                    a3.c(eb1Var);
                    a3.a(eb1Var);
                    eb1Var.k(this);
                    j(!mb1Var.i());
                    m(!mb1Var.g());
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
            db1 db1Var3 = this.d;
            if (db1Var3 != null) {
                db1Var3.c("本地物料null");
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
            ud1 ud1Var = this.a;
            if (viewGroup != null && ud1Var != null) {
                ud1Var.load();
                View adView = ud1Var.getAdView();
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
