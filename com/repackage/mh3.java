package com.repackage;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cp1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class mh3 extends d63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public transient /* synthetic */ FieldHolder $fh;
    public String s;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends t53 implements gh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh3 c;

        public b(mh3 mh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mh3Var;
        }

        @Override // com.repackage.t53
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean e = bk2.h0().e(this.c.m);
                if (mh3.t) {
                    Log.d("LoginRequest", "LoginPreparation isLogin : " + e + " call stack:" + Log.getStackTraceString(new Exception()));
                }
                if (!e) {
                    this.c.M().M().f(this.c.m, this.c.p, this);
                    return false;
                }
                mh3 mh3Var = this.c;
                mh3Var.h(new c(mh3Var, null));
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.gh1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                s53.k("onResult :: " + i, Boolean.FALSE);
                if (i == -2) {
                    s53.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else if (i != 0) {
                    s53.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else {
                    s53.k("Login Preparation ok, is already login", Boolean.FALSE);
                    mh3 mh3Var = this.c;
                    mh3Var.h(new c(mh3Var, null));
                    d();
                }
            }
        }

        public /* synthetic */ b(mh3 mh3Var, a aVar) {
            this(mh3Var);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends t53 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh3 c;

        /* loaded from: classes6.dex */
        public class a implements nf3<Bundle> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.nf3
            /* renamed from: a */
            public void onCallback(Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                    if (bundle == null) {
                        s53.k("null stoken", Boolean.TRUE);
                        this.a.e(new OAuthException(10001));
                        return;
                    }
                    String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                    if (!TextUtils.isEmpty(string)) {
                        this.a.c.s = string;
                        this.a.d();
                        return;
                    }
                    s53.k("empty stoken", Boolean.TRUE);
                    this.a.e(new OAuthException(10001));
                }
            }
        }

        public /* synthetic */ c(mh3 mh3Var, a aVar) {
            this(mh3Var);
        }

        @Override // com.repackage.t53
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ug3.t(this.c.m, new a(this), BdZeusUtil.URL_KEY_MACHINE);
                return false;
            }
            return invokeV.booleanValue;
        }

        public c(mh3 mh3Var) {
            cp1.d dVar;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mh3Var;
            if (mh3Var.o == null || (dVar = mh3Var.n) == null || !dVar.a) {
                return;
            }
            long j = dVar.b;
            if (mh3.t) {
                Log.d("LoginRequest", "send timeout " + j + "ms msg");
            }
            mh3Var.o.sendEmptyMessageDelayed(1, j < 0 ? 0L : j);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755499335, "Lcom/repackage/mh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755499335, "Lcom/repackage/mh3;");
                return;
            }
        }
        t = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mh3(Activity activity, cp1.d dVar, Bundle bundle) {
        super(activity, dVar, bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, dVar, bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Activity) objArr2[0], (cp1.d) objArr2[1], (Bundle) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        x();
        y();
    }

    @Override // com.repackage.d63
    @NonNull
    public t53 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this, null) : (t53) invokeV.objValue;
    }

    @Override // com.repackage.d63, com.repackage.r53
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                boolean isEmpty = TextUtils.isEmpty(this.q);
                jSONObject.put("ma_id", isEmpty ? M().N() : this.q);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(GameGuideConfigInfo.KEY_APP_KEY, isEmpty ? M().N() : this.q);
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", s53.g());
                jSONObject2.put("stoken", this.s);
                String l = bk2.o().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject2.put("host_api_key", l);
                }
                jSONObject.put("open", jSONObject2);
            } catch (JSONException e) {
                if (t) {
                    e.printStackTrace();
                }
            }
            v("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }
}
