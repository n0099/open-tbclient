package d.a.s0.u.b.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.x;
import d.a.q0.a.z1.b.b.h;
import d.a.q0.b.g;
import d.a.q0.b.j.a0;
import d.a.q0.b.j.b0;
import d.a.q0.b.j.l;
import d.a.q0.b.j.z;
import d.a.q0.b.k.a;
import d.a.q0.b.l.b;
import d.a.q0.b.o.a;
import d.a.q0.t.f;
import java.util.ArrayList;
import java.util.List;
@Service
/* loaded from: classes9.dex */
public class d implements d.a.q0.b.j.c0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.z1.b.b.c f65652a;

    /* loaded from: classes9.dex */
    public class a extends GetTplStokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l.a f65653e;

        public a(d dVar, l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65653e = aVar;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f65653e) == null) {
                return;
            }
            aVar.onFinish();
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.f65653e) == null) {
                return;
            }
            aVar.onStart();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, getTplStokenResult) == null) || this.f65653e == null) {
                return;
            }
            l lVar = new l();
            if (getTplStokenResult != null) {
                lVar.f52181b = getTplStokenResult.tplStokenMap;
                lVar.f52180a = getTplStokenResult.getResultCode();
                getTplStokenResult.getResultMsg();
                GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                if (failureType != null) {
                    failureType.name();
                }
            }
            this.f65653e.a(lVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, getTplStokenResult) == null) || this.f65653e == null) {
                return;
            }
            l lVar = new l();
            if (getTplStokenResult != null) {
                lVar.f52181b = getTplStokenResult.tplStokenMap;
                lVar.f52180a = getTplStokenResult.getResultCode();
                getTplStokenResult.getResultMsg();
                GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                if (failureType != null) {
                    failureType.name();
                }
            }
            this.f65653e.b(lVar);
        }
    }

    /* loaded from: classes9.dex */
    public class b extends SmsViewLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppPhoneLoginDialog.g f65654e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f65655f;

        /* loaded from: classes9.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                }
            }
        }

        /* renamed from: d.a.s0.u.b.b.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class DialogInterface$OnClickListenerC1693b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f65656e;

            /* renamed from: d.a.s0.u.b.b.d$b$b$a */
            /* loaded from: classes9.dex */
            public class a implements d.a.q0.a.m.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DialogInterface$OnClickListenerC1693b f65657e;

                public a(DialogInterface$OnClickListenerC1693b dialogInterface$OnClickListenerC1693b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogInterface$OnClickListenerC1693b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65657e = dialogInterface$OnClickListenerC1693b;
                }

                @Override // d.a.q0.a.m.a
                public void onResult(int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                        if (i2 == 0) {
                            this.f65657e.f65656e.f65654e.onSuccess();
                        } else {
                            this.f65657e.f65656e.f65654e.onFailure();
                        }
                    }
                }
            }

            public DialogInterface$OnClickListenerC1693b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65656e = bVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    d.a.q0.b.j.a.N((FragmentActivity) this.f65656e.f65655f, false, null, new a(this));
                }
            }
        }

        /* loaded from: classes9.dex */
        public class c implements d.a.q0.a.m.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f65658e;

            public c(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65658e = bVar;
            }

            @Override // d.a.q0.a.m.a
            public void onResult(int i2) {
                SwanAppPhoneLoginDialog.g gVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (gVar = this.f65658e.f65654e) == null) {
                    return;
                }
                if (i2 == 0) {
                    gVar.onSuccess();
                } else {
                    gVar.onFailure();
                }
            }
        }

        public b(d dVar, SwanAppPhoneLoginDialog.g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65654e = gVar;
            this.f65655f = context;
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewHide() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f65654e.b();
            }
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f65654e.a();
            }
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onNeedBack(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                Context context = this.f65655f;
                x.a(context, ((FragmentActivity) context).getWindow().getDecorView().getWindowToken());
                String string = this.f65655f.getResources().getString(g.account_login_dialog_needback_other);
                String string2 = this.f65655f.getResources().getString(g.account_login_dialog_needback_positive_btn_login);
                if (webAuthResult.getResultCode() == 12) {
                    string = this.f65655f.getResources().getString(g.account_login_dialog_needback_phone);
                    string2 = this.f65655f.getResources().getString(g.account_login_dialog_needback_positive_btn_register);
                }
                h.a aVar = new h.a(this.f65655f);
                aVar.V(this.f65655f.getResources().getString(g.account_login_dialog_needback_title));
                aVar.x(string);
                aVar.P(string2, new DialogInterface$OnClickListenerC1693b(this));
                aVar.C(this.f65655f.getResources().getString(g.account_login_dialog_needback_negative_btn), new a(this));
                aVar.X();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                this.f65654e.onFailure();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, webAuthResult) == null) {
                d.a.s0.u.b.b.a.l().x(new c(this));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.b.n.g.e f65659a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f65660b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f65661c;

        /* loaded from: classes9.dex */
        public class a implements d.a.q0.a.m.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f65662e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65662e = cVar;
            }

            @Override // d.a.q0.a.m.a
            public void onResult(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                    if (i2 == 0) {
                        this.f65662e.f65659a.onResult(0);
                    } else {
                        this.f65662e.f65659a.onResult(-1);
                    }
                    c cVar = this.f65662e;
                    cVar.f65661c.r(cVar.f65660b);
                }
            }
        }

        public c(d dVar, d.a.q0.b.n.g.e eVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, eVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65661c = dVar;
            this.f65659a = eVar;
            this.f65660b = activity;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                this.f65659a.onResult(-1);
                this.f65661c.r(this.f65660b);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                this.f65659a.onResult(-1);
                this.f65661c.r(this.f65660b);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oneKeyLoginResult) == null) {
                d.a.s0.u.b.b.a.l().x(new a(this));
            }
        }
    }

    /* renamed from: d.a.s0.u.b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1694d extends VerifyUserFaceIDCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b0 f65663a;

        public C1694d(d dVar, b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, b0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65663a = b0Var;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                this.f65663a.onFailure(sapiResult.getResultMsg());
            }
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiResult) == null) {
                z zVar = new z();
                if (sapiResult instanceof RealNameFaceIDResult) {
                    zVar.f52196a = ((RealNameFaceIDResult) sapiResult).callBackKey;
                    this.f65663a.a(zVar);
                } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                    zVar.f52196a = ((UnRealNameFaceIDResult) sapiResult).registerResult;
                    this.f65663a.a(zVar);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends AccountRealNameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b0 f65664a;

        public e(d dVar, b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, b0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65664a = b0Var;
        }

        @Override // com.baidu.sapi2.callback.AccountRealNameCallback
        public void onFinish(AccountRealNameResult accountRealNameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountRealNameResult) == null) {
                super.onFinish(accountRealNameResult);
                if (accountRealNameResult.getResultCode() == 0) {
                    z zVar = new z();
                    if (accountRealNameResult.seniorRealNameSuc) {
                        zVar.f52196a = accountRealNameResult.callbackkey;
                        this.f65664a.a(zVar);
                        return;
                    }
                }
                this.f65664a.onFailure(accountRealNameResult.getResultMsg());
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? CommonParam.getCUID(context) : (String) invokeL.objValue;
    }

    public static String s(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (TextUtils.isEmpty(str) || str.length() <= 7) {
                return null;
            }
            String substring = str.substring(0, 8);
            String substring2 = str.substring(8, str.length());
            String upperCase = SapiUtils.getClientId(context).toUpperCase();
            return substring + f.d((substring2 + f.d(upperCase.getBytes(), false)).getBytes(), false);
        }
        return (String) invokeLL.objValue;
    }

    @Override // d.a.q0.b.j.c0.a
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? d.a.q0.a.k2.g.h.a().getString("bd_box_ptoken", "") : (String) invokeL.objValue;
    }

    @Override // d.a.q0.b.j.c0.a
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? d.a.s0.u.b.b.a.l().p() : (String) invokeL.objValue;
    }

    @Override // d.a.q0.b.j.c0.a
    public void c(Context context, Bundle bundle, d.a.q0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, bundle, aVar) == null) {
            d.a.s0.u.b.b.a.l().t(context, bundle, aVar);
        }
    }

    @Override // d.a.q0.b.j.c0.a
    public a0 d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            a0 a0Var = new a0();
            a0Var.f52176a = d.a.s0.u.b.b.a.l().k();
            a0Var.f52177b = d.a.s0.u.b.b.a.l().i();
            return a0Var;
        }
        return (a0) invokeL.objValue;
    }

    @Override // d.a.q0.b.j.c0.a
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? TbadkCoreApplication.getInst().getZid() : (String) invokeL.objValue;
    }

    @Override // d.a.q0.b.j.c0.a
    public void f(Activity activity, String str, String str2, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, activity, str, str2, b0Var) == null) {
            RealNameDTO realNameDTO = new RealNameDTO();
            realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
            realNameDTO.scene = str;
            realNameDTO.needCbKey = true;
            PassportSDK.getInstance().loadAccountRealName(activity, new e(this, b0Var), realNameDTO);
        }
    }

    @Override // d.a.q0.b.j.c0.a
    public void g(Context context, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, dVar) == null) {
            d.a.s0.u.b.b.a.l().h(context, "1", dVar);
        }
    }

    @Override // d.a.q0.b.j.c0.a
    public String getBduss(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? d.a.s0.u.b.b.a.l().j() : (String) invokeL.objValue;
    }

    @Override // d.a.q0.b.j.c0.a
    public boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) ? d.a.s0.u.b.b.a.l().s() : invokeL.booleanValue;
    }

    @Override // d.a.q0.b.j.c0.a
    public void i(d.a.q0.a.m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            d.a.s0.u.b.b.a.l().f(cVar);
        }
    }

    @Override // d.a.q0.b.j.c0.a
    public void j(Context context, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, dVar) == null) {
            d.a.s0.u.b.b.a.l().g(context, "1", dVar);
        }
    }

    @Override // d.a.q0.b.j.c0.a
    public void k(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, context, gVar, str) == null) {
            PassportSDK.getInstance().startSmsViewLogin(new b(this, gVar, context), str);
        }
    }

    @Override // d.a.q0.b.j.c0.a
    public String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("aps_identity", 0);
            String string = sharedPreferences.getString("uid_v3", "");
            if (TextUtils.isEmpty(string)) {
                String q = q(context);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("uid_v3", q);
                edit.apply();
                return q;
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.q0.b.j.c0.a
    public void m(Activity activity, String str, String str2, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, activity, str, str2, b0Var) == null) {
            FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
            faceIDVerifyDTO.businessSence = str;
            faceIDVerifyDTO.bduss = str2;
            PassportSDK.getInstance().verifyUserFaceId(activity, new C1694d(this, b0Var), faceIDVerifyDTO);
        }
    }

    @Override // d.a.q0.b.j.c0.a
    public void n(Activity activity, String str, d.a.q0.b.n.g.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, str, eVar) == null) {
            t(activity);
            PassportSDK.getInstance().loadOneKeyLogin(activity, s(activity, str), new c(this, eVar, activity));
        }
    }

    @Override // d.a.q0.b.j.c0.a
    public void o(String str, ArrayList<String> arrayList, b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, arrayList, cVar) == null) {
            d.a.s0.u.b.b.a.l().n(str, arrayList, cVar);
        }
    }

    @Override // d.a.q0.b.j.c0.a
    public void p(l.a aVar, String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, aVar, str, list) == null) {
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new a(this, aVar), str, list);
        }
    }

    public void r(Context context) {
        d.a.q0.a.z1.b.b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, context) == null) || !(context instanceof Activity) || ((Activity) context).isFinishing() || (cVar = this.f65652a) == null) {
            return;
        }
        cVar.dismiss();
    }

    public final void t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, context) == null) {
            d.a.q0.a.z1.b.b.c cVar = new d.a.q0.a.z1.b.b.c(context, 16973833);
            this.f65652a = cVar;
            Window window = cVar.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(17170445);
                window.setDimAmount(0.0f);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = context.getResources().getDimensionPixelSize(R.dimen.account_loading_height);
                attributes.width = -1;
                window.setAttributes(attributes);
            }
            this.f65652a.setCanceledOnTouchOutside(false);
            this.f65652a.setCancelable(false);
            this.f65652a.a(true);
            this.f65652a.setContentView(R.layout.loading_layout);
            View findViewById = this.f65652a.findViewById(R.id.root_container);
            ProgressBar progressBar = (ProgressBar) this.f65652a.findViewById(R.id.loading_bar);
            TextView textView = (TextView) this.f65652a.findViewById(R.id.message);
            if (findViewById != null) {
                findViewById.setBackground(findViewById.getResources().getDrawable(R.drawable.novel_loading_bg));
            }
            if (progressBar != null) {
                progressBar.setIndeterminateDrawable(progressBar.getResources().getDrawable(R.drawable.loading_progress_animation));
            }
            if (textView != null) {
                textView.setTextColor(textView.getResources().getColor(R.color.loading_text_color));
                textView.setText(R.string.account_onekey_loading);
            }
            this.f65652a.show();
        }
    }
}
