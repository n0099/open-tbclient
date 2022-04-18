package com.repackage;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bj3;
import com.repackage.mh3;
import com.repackage.nz2;
import com.repackage.qh3;
import com.repackage.ug3;
import java.util.ArrayList;
import java.util.List;
@Service
/* loaded from: classes7.dex */
public class zl5 implements lh3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iz2 a;

    /* loaded from: classes7.dex */
    public class a extends GetTplStokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug3.a a;

        public a(zl5 zl5Var, ug3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zl5Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            ug3.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.onFinish();
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            ug3.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.onStart();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, getTplStokenResult) == null) || this.a == null) {
                return;
            }
            ug3 ug3Var = new ug3();
            if (getTplStokenResult != null) {
                ug3Var.b = getTplStokenResult.tplStokenMap;
                ug3Var.a = getTplStokenResult.getResultCode();
                getTplStokenResult.getResultMsg();
                GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                if (failureType != null) {
                    failureType.name();
                }
            }
            this.a.a(ug3Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, getTplStokenResult) == null) || this.a == null) {
                return;
            }
            ug3 ug3Var = new ug3();
            if (getTplStokenResult != null) {
                ug3Var.b = getTplStokenResult.tplStokenMap;
                ug3Var.a = getTplStokenResult.getResultCode();
                getTplStokenResult.getResultMsg();
                GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                if (failureType != null) {
                    failureType.name();
                }
            }
            this.a.b(ug3Var);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends SmsViewLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppPhoneLoginDialog.g a;
        public final /* synthetic */ Context b;

        /* loaded from: classes7.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                }
            }
        }

        /* renamed from: com.repackage.zl5$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class DialogInterface$OnClickListenerC0571b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* renamed from: com.repackage.zl5$b$b$a */
            /* loaded from: classes7.dex */
            public class a implements vg1 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogInterface$OnClickListenerC0571b a;

                public a(DialogInterface$OnClickListenerC0571b dialogInterface$OnClickListenerC0571b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogInterface$OnClickListenerC0571b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = dialogInterface$OnClickListenerC0571b;
                }

                @Override // com.repackage.vg1
                public void onResult(int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                        if (i == 0) {
                            this.a.a.a.onSuccess();
                        } else {
                            this.a.a.a.onFailure();
                        }
                    }
                }
            }

            public DialogInterface$OnClickListenerC0571b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    jg3.M((FragmentActivity) this.a.b, false, null, new a(this));
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements vg1 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public c(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.repackage.vg1
            public void onResult(int i) {
                SwanAppPhoneLoginDialog.g gVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (gVar = this.a.a) == null) {
                    return;
                }
                if (i == 0) {
                    gVar.onSuccess();
                } else {
                    gVar.onFailure();
                }
            }
        }

        public b(zl5 zl5Var, SwanAppPhoneLoginDialog.g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zl5Var, gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
            this.b = context;
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewHide() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b();
            }
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.a();
            }
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onNeedBack(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                Context context = this.b;
                kd3.a(context, ((FragmentActivity) context).getWindow().getDecorView().getWindowToken());
                String string = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0072);
                String string2 = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0074);
                if (webAuthResult.getResultCode() == 12) {
                    string = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0073);
                    string2 = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0075);
                }
                nz2.a aVar = new nz2.a(this.b);
                aVar.V(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0076));
                aVar.x(string);
                aVar.P(string2, new DialogInterface$OnClickListenerC0571b(this));
                aVar.C(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0071), new a(this));
                aVar.X();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                this.a.onFailure();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, webAuthResult) == null) {
                xl5.l().x(new c(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qi3 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ zl5 c;

        /* loaded from: classes7.dex */
        public class a implements vg1 {
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

            @Override // com.repackage.vg1
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    if (i == 0) {
                        this.a.a.onResult(0);
                    } else {
                        this.a.a.onResult(-1);
                    }
                    c cVar = this.a;
                    cVar.c.q(cVar.b);
                }
            }
        }

        public c(zl5 zl5Var, qi3 qi3Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zl5Var, qi3Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zl5Var;
            this.a = qi3Var;
            this.b = activity;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                this.a.onResult(-1);
                this.c.q(this.b);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                this.a.onResult(-1);
                this.c.q(this.b);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oneKeyLoginResult) == null) {
                xl5.l().x(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends VerifyUserFaceIDCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh3 a;

        public d(zl5 zl5Var, kh3 kh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zl5Var, kh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kh3Var;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                this.a.onFailure(sapiResult.getResultMsg());
            }
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiResult) == null) {
                ih3 ih3Var = new ih3();
                if (sapiResult instanceof RealNameFaceIDResult) {
                    ih3Var.a = ((RealNameFaceIDResult) sapiResult).callBackKey;
                    this.a.a(ih3Var);
                } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                    ih3Var.a = ((UnRealNameFaceIDResult) sapiResult).registerResult;
                    this.a.a(ih3Var);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends AccountRealNameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh3 a;

        public e(zl5 zl5Var, kh3 kh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zl5Var, kh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kh3Var;
        }

        @Override // com.baidu.sapi2.callback.AccountRealNameCallback
        public void onFinish(AccountRealNameResult accountRealNameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountRealNameResult) == null) {
                super.onFinish(accountRealNameResult);
                if (accountRealNameResult.getResultCode() == 0) {
                    ih3 ih3Var = new ih3();
                    if (accountRealNameResult.seniorRealNameSuc) {
                        ih3Var.a = accountRealNameResult.callbackkey;
                        this.a.a(ih3Var);
                        return;
                    }
                }
                this.a.onFailure(accountRealNameResult.getResultMsg());
            }
        }
    }

    public zl5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? CommonParam.getCUID(context) : (String) invokeL.objValue;
    }

    public static String r(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (TextUtils.isEmpty(str) || str.length() <= 7) {
                return null;
            }
            String substring = str.substring(0, 8);
            String substring2 = str.substring(8, str.length());
            String upperCase = SapiUtils.getClientId(context).toUpperCase();
            return substring + og4.d((substring2 + og4.d(upperCase.getBytes(), false)).getBytes(), false);
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.repackage.lh3
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? x83.a().getString("bd_box_ptoken", "") : (String) invokeL.objValue;
    }

    @Override // com.repackage.lh3
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? xl5.l().p() : (String) invokeL.objValue;
    }

    @Override // com.repackage.lh3
    public void c(Context context, Bundle bundle, vg1 vg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, bundle, vg1Var) == null) {
            xl5.l().t(context, bundle, vg1Var);
        }
    }

    @Override // com.repackage.lh3
    public jh3 d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            jh3 jh3Var = new jh3();
            jh3Var.a = xl5.l().k();
            jh3Var.b = xl5.l().i();
            return jh3Var;
        }
        return (jh3) invokeL.objValue;
    }

    @Override // com.repackage.lh3
    public void e(Activity activity, String str, String str2, kh3 kh3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, activity, str, str2, kh3Var) == null) {
            RealNameDTO realNameDTO = new RealNameDTO();
            realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
            realNameDTO.scene = str;
            realNameDTO.needCbKey = true;
            PassportSDK.getInstance().loadAccountRealName(activity, new e(this, kh3Var), realNameDTO);
        }
    }

    @Override // com.repackage.lh3
    public void f(Context context, bj3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, dVar) == null) {
            xl5.l().h(context, "1", dVar);
        }
    }

    @Override // com.repackage.lh3
    public boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? xl5.l().s() : invokeL.booleanValue;
    }

    @Override // com.repackage.lh3
    public String getBduss(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? xl5.l().j() : (String) invokeL.objValue;
    }

    @Override // com.repackage.lh3
    public void h(xg1 xg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xg1Var) == null) {
            xl5.l().f(xg1Var);
        }
    }

    @Override // com.repackage.lh3
    public void i(Context context, mh3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, dVar) == null) {
            xl5.l().g(context, "1", dVar);
        }
    }

    @Override // com.repackage.lh3
    public void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, gVar, str) == null) {
            PassportSDK.getInstance().startSmsViewLogin(new b(this, gVar, context), str);
        }
    }

    @Override // com.repackage.lh3
    public String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("aps_identity", 0);
            String string = sharedPreferences.getString("uid_v3", "");
            if (TextUtils.isEmpty(string)) {
                String p = p(context);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("uid_v3", p);
                edit.apply();
                return p;
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.lh3
    public void l(Activity activity, String str, String str2, kh3 kh3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048588, this, activity, str, str2, kh3Var) == null) {
            FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
            faceIDVerifyDTO.businessSence = str;
            faceIDVerifyDTO.bduss = str2;
            PassportSDK.getInstance().verifyUserFaceId(activity, new d(this, kh3Var), faceIDVerifyDTO);
        }
    }

    @Override // com.repackage.lh3
    public void m(Activity activity, String str, qi3 qi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, str, qi3Var) == null) {
            s(activity);
            PassportSDK.getInstance().loadOneKeyLogin(activity, r(activity, str), new c(this, qi3Var, activity));
        }
    }

    @Override // com.repackage.lh3
    public void n(String str, ArrayList<String> arrayList, qh3.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, arrayList, cVar) == null) {
            xl5.l().n(str, arrayList, cVar);
        }
    }

    @Override // com.repackage.lh3
    public void o(ug3.a aVar, String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, aVar, str, list) == null) {
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new a(this, aVar), str, list);
        }
    }

    public void q(Context context) {
        iz2 iz2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, context) == null) || !(context instanceof Activity) || ((Activity) context).isFinishing() || (iz2Var = this.a) == null) {
            return;
        }
        iz2Var.dismiss();
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            iz2 iz2Var = new iz2(context, 16973833);
            this.a = iz2Var;
            Window window = iz2Var.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(17170445);
                window.setDimAmount(0.0f);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700d9);
                attributes.width = -1;
                window.setAttributes(attributes);
            }
            this.a.setCanceledOnTouchOutside(false);
            this.a.setCancelable(false);
            this.a.a(true);
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d0527);
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091ad0);
            ProgressBar progressBar = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091302);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0913f5);
            if (findViewById != null) {
                findViewById.setBackground(findViewById.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e57));
            }
            if (progressBar != null) {
                progressBar.setIndeterminateDrawable(progressBar.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080d39));
            }
            if (textView != null) {
                textView.setTextColor(textView.getResources().getColor(R.color.obfuscated_res_0x7f06077f));
                textView.setText(R.string.obfuscated_res_0x7f0f007a);
            }
            this.a.show();
        }
    }
}
