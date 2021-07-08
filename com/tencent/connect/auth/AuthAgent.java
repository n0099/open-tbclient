package com.tencent.connect.auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.e;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
import com.tencent.open.web.security.JniInterface;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AuthAgent extends BaseApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
    public static final String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_NAME = null;
    public static final String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
    public static final String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public IUiListener f38711c;

    /* renamed from: d  reason: collision with root package name */
    public String f38712d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f38713e;

    /* loaded from: classes6.dex */
    public class a implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public IUiListener f38719a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AuthAgent f38720b;

        public a(AuthAgent authAgent, IUiListener iUiListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authAgent, iUiListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38720b = authAgent;
            this.f38719a = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iUiListener = this.f38719a) == null) {
                return;
            }
            iUiListener.onCancel();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (obj == null) {
                    f.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
                    return;
                }
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    int i2 = jSONObject.getInt(Constants.KEYS.RET);
                    String string = i2 == 0 ? "success" : jSONObject.getString("msg");
                    if (this.f38719a != null) {
                        this.f38719a.onComplete(new JSONObject().put(Constants.KEYS.RET, i2).put("msg", string));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    f.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
                }
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) || (iUiListener = this.f38719a) == null) {
                return;
            }
            iUiListener.onError(uiError);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AuthAgent f38737a;

        /* renamed from: b  reason: collision with root package name */
        public final IUiListener f38738b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f38739c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f38740d;

        public c(AuthAgent authAgent, Context context, IUiListener iUiListener, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authAgent, context, iUiListener, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38737a = authAgent;
            this.f38740d = context;
            this.f38738b = iUiListener;
            this.f38739c = z;
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
                this.f38738b.onCancel();
                f.b();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    String string = jSONObject.getString("access_token");
                    String string2 = jSONObject.getString("expires_in");
                    String string3 = jSONObject.getString("openid");
                    if (string != null && this.f38737a.f38790b != null && string3 != null) {
                        this.f38737a.f38790b.setAccessToken(string, string2);
                        this.f38737a.f38790b.setOpenId(string3);
                        com.tencent.connect.a.a.d(this.f38740d, this.f38737a.f38790b);
                    }
                    String string4 = jSONObject.getString("pf");
                    if (string4 != null) {
                        try {
                            this.f38740d.getSharedPreferences(com.tencent.connect.common.Constants.PREFERENCE_PF, 0).edit().putString("pf", string4).commit();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e2);
                        }
                    }
                    if (this.f38739c) {
                        CookieSyncManager.getInstance().sync();
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e3);
                }
                this.f38738b.onComplete(jSONObject);
                this.f38737a.releaseResource();
                f.b();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
                this.f38738b.onError(uiError);
                f.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1149043772, "Lcom/tencent/connect/auth/AuthAgent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1149043772, "Lcom/tencent/connect/auth/AuthAgent;");
                return;
            }
        }
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        String str = Build.CPU_ABI;
        if (str != null && !str.equals("")) {
            if (str.equalsIgnoreCase("arm64-v8a")) {
                SECURE_LIB_FILE_NAME = SECURE_LIB_ARM64_FILE_NAME;
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                f.c("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
                return;
            } else if (str.equalsIgnoreCase("x86")) {
                SECURE_LIB_FILE_NAME = SECURE_LIB_X86_FILE_NAME;
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                f.c("openSDK_LOG.AuthAgent", "is x86 architecture");
                return;
            } else if (str.equalsIgnoreCase("x86_64")) {
                SECURE_LIB_FILE_NAME = SECURE_LIB_X86_64_FILE_NAME;
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                f.c("openSDK_LOG.AuthAgent", "is x86_64 architecture");
                return;
            } else {
                SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                f.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
                return;
            }
        }
        SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        f.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthAgent(QQToken qQToken) {
        super(qQToken);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qQToken};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((QQToken) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, activity, str, iUiListener)) == null) ? doLogin(activity, str, iUiListener, false, null) : invokeLLL.intValue;
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f38711c = null;
        }
    }

    public void b(IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iUiListener) == null) {
            Bundle a2 = a();
            a2.putString("reqType", "checkLogin");
            HttpUtils.requestAsync(this.f38790b, e.a(), "https://openmobile.qq.com/v3/user/get_info", a2, "GET", new BaseApi.TempRequestListener(this, new a(this, iUiListener)));
        }
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener, boolean z, Fragment fragment) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{activity, str, iUiListener, Boolean.valueOf(z), fragment})) == null) {
            this.f38712d = str;
            this.f38713e = new WeakReference<>(activity);
            this.f38711c = iUiListener;
            if (!com.tencent.open.utils.f.a(activity, this.f38790b.getAppId()).b("C_LoginWeb") && a(activity, fragment, z)) {
                f.c("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
                d.a().a(this.f38790b.getOpenId(), this.f38790b.getAppId(), "2", "1", "5", "0", "0", "0");
                return 1;
            }
            d.a().a(this.f38790b.getOpenId(), this.f38790b.getAppId(), "2", "1", "5", "1", "0", "0");
            f.d("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
            b bVar = new b(this, this.f38711c);
            this.f38711c = bVar;
            return a(z, bVar);
        }
        return invokeCommon.intValue;
    }

    private int a(boolean z, IUiListener iUiListener) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65538, this, z, iUiListener)) == null) {
            f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start");
            CookieSyncManager.createInstance(e.a());
            Bundle a2 = a();
            if (z) {
                a2.putString("isadd", "1");
            }
            a2.putString("scope", this.f38712d);
            a2.putString("client_id", this.f38790b.getAppId());
            if (BaseApi.isOEM) {
                a2.putString("pf", "desktop_m_qq-" + BaseApi.installChannel + "-android-" + BaseApi.registerChannel + "-" + BaseApi.businessId);
            } else {
                a2.putString("pf", com.tencent.connect.common.Constants.DEFAULT_PF);
            }
            String str = (System.currentTimeMillis() / 1000) + "";
            a2.putString("sign", h.b(e.a(), str));
            a2.putString("time", str);
            a2.putString("display", "mobile");
            a2.putString(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, "token");
            a2.putString(WBConstants.AUTH_PARAMS_REDIRECT_URL, "auth://tauth.qq.com/");
            a2.putString("cancel_display", "1");
            a2.putString(SetImageWatermarkTypeReqMsg.SWITCH, "1");
            a2.putString("status_userip", j.a());
            c cVar = new c(this, e.a(), iUiListener, true, false);
            f.b("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
            i.a(new Runnable(this, g.a().a(e.a(), "https://openmobile.qq.com/oauth2.0/m_authorize?") + HttpUtils.encodeUrl(a2), cVar) { // from class: com.tencent.connect.auth.AuthAgent.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f38714a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ IUiListener f38715b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AuthAgent f38716c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38716c = this;
                    this.f38714a = r7;
                    this.f38715b = cVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Activity activity;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        h.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 3);
                        JniInterface.loadSo();
                        if (this.f38716c.f38713e == null || (activity = (Activity) this.f38716c.f38713e.get()) == null) {
                            return;
                        }
                        activity.runOnUiThread(new Runnable(this, activity) { // from class: com.tencent.connect.auth.AuthAgent.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Activity f38717a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f38718b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, activity};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f38718b = this;
                                this.f38717a = activity;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (JniInterface.isJniOk) {
                                        Activity activity2 = this.f38717a;
                                        AnonymousClass1 anonymousClass1 = this.f38718b;
                                        com.tencent.connect.auth.a aVar = new com.tencent.connect.auth.a(activity2, "action_login", anonymousClass1.f38714a, anonymousClass1.f38715b, anonymousClass1.f38716c.f38790b);
                                        if (this.f38717a.isFinishing()) {
                                            return;
                                        }
                                        aVar.show();
                                        return;
                                    }
                                    f.d("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                                    TDialog tDialog = new TDialog(this.f38717a, "", this.f38718b.f38716c.a(""), null, this.f38718b.f38716c.f38790b);
                                    if (this.f38717a.isFinishing()) {
                                        return;
                                    }
                                    tDialog.show();
                                }
                            }
                        });
                    }
                }
            });
            f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
            return 2;
        }
        return invokeZL.intValue;
    }

    /* loaded from: classes6.dex */
    public class b implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public IUiListener f38721a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AuthAgent f38722b;

        /* renamed from: c  reason: collision with root package name */
        public final String f38723c;

        /* renamed from: d  reason: collision with root package name */
        public final String f38724d;

        /* renamed from: e  reason: collision with root package name */
        public final String f38725e;

        /* loaded from: classes6.dex */
        public abstract class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: d  reason: collision with root package name */
            public Dialog f38735d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f38736e;

            public a(b bVar, Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dialog};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38736e = bVar;
                this.f38735d = dialog;
            }
        }

        public b(AuthAgent authAgent, IUiListener iUiListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authAgent, iUiListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38722b = authAgent;
            this.f38723c = "sendinstall";
            this.f38724d = "installwording";
            this.f38725e = "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";
            this.f38721a = iUiListener;
        }

        private void a(String str, IUiListener iUiListener, Object obj) {
            Activity activity;
            PackageInfo packageInfo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(65539, this, str, iUiListener, obj) == null) || this.f38722b.f38713e == null || (activity = (Activity) this.f38722b.f38713e.get()) == null) {
                return;
            }
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            PackageManager packageManager = activity.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                packageInfo = null;
            }
            Drawable loadIcon = packageInfo != null ? packageInfo.applicationInfo.loadIcon(packageManager) : null;
            View.OnClickListener onClickListener = new a(this, dialog, iUiListener, obj) { // from class: com.tencent.connect.auth.AuthAgent.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IUiListener f38726a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f38727b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f38728c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(this, dialog);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, dialog, iUiListener, obj};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((b) objArr2[0], (Dialog) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38728c = this;
                    this.f38726a = iUiListener;
                    this.f38727b = obj;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f38728c.a();
                        Dialog dialog2 = this.f38735d;
                        if (dialog2 != null && dialog2.isShowing()) {
                            this.f38735d.dismiss();
                        }
                        IUiListener iUiListener2 = this.f38726a;
                        if (iUiListener2 != null) {
                            iUiListener2.onComplete(this.f38727b);
                        }
                    }
                }
            };
            View.OnClickListener onClickListener2 = new a(this, dialog, iUiListener, obj) { // from class: com.tencent.connect.auth.AuthAgent.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IUiListener f38729a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f38730b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f38731c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(this, dialog);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, dialog, iUiListener, obj};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((b) objArr2[0], (Dialog) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38731c = this;
                    this.f38729a = iUiListener;
                    this.f38730b = obj;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        Dialog dialog2 = this.f38735d;
                        if (dialog2 != null && dialog2.isShowing()) {
                            this.f38735d.dismiss();
                        }
                        IUiListener iUiListener2 = this.f38729a;
                        if (iUiListener2 != null) {
                            iUiListener2.onComplete(this.f38730b);
                        }
                    }
                }
            };
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setAlpha(0);
            dialog.getWindow().setBackgroundDrawable(colorDrawable);
            dialog.setContentView(a(activity, loadIcon, str, onClickListener, onClickListener2));
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener(this, iUiListener, obj) { // from class: com.tencent.connect.auth.AuthAgent.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IUiListener f38732a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f38733b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f38734c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iUiListener, obj};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38734c = this;
                    this.f38732a = iUiListener;
                    this.f38733b = obj;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    IUiListener iUiListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) || (iUiListener2 = this.f38732a) == null) {
                        return;
                    }
                    iUiListener2.onComplete(this.f38733b);
                }
            });
            if (activity == null || activity.isFinishing()) {
                return;
            }
            dialog.show();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (iUiListener = this.f38721a) == null) {
                return;
            }
            iUiListener.onCancel();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, obj) == null) || obj == null || (jSONObject = (JSONObject) obj) == null) {
                return;
            }
            try {
                r2 = jSONObject.getInt("sendinstall") == 1;
                str = jSONObject.getString("installwording");
            } catch (JSONException unused) {
                f.d("openSDK_LOG.AuthAgent", "FeedConfirmListener onComplete There is no value for sendinstall.");
                str = "";
            }
            String decode = URLDecoder.decode(str);
            f.a("openSDK_LOG.AuthAgent", " WORDING = " + decode + "xx");
            if (r2 && !TextUtils.isEmpty(decode)) {
                a(decode, this.f38721a, obj);
            } else if (this.f38721a != null) {
                if (this.f38722b.f38790b != null) {
                    this.f38722b.f38790b.saveSession(jSONObject);
                }
                this.f38721a.onComplete(obj);
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, uiError) == null) || (iUiListener = this.f38721a) == null) {
                return;
            }
            iUiListener.onError(uiError);
        }

        private Drawable a(String str, Context context) {
            InterceptResult invokeLL;
            InputStream open;
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, context)) == null) {
                Drawable drawable = null;
                try {
                    open = context.getApplicationContext().getAssets().open(str);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                if (open == null) {
                    return null;
                }
                if (str.endsWith(".9.png")) {
                    try {
                        bitmap = BitmapFactory.decodeStream(open);
                    } catch (OutOfMemoryError e3) {
                        e3.printStackTrace();
                        bitmap = null;
                    }
                    if (bitmap != null) {
                        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
                        NinePatch.isNinePatchChunk(ninePatchChunk);
                        return new NinePatchDrawable(bitmap, ninePatchChunk, new Rect(), null);
                    }
                    return null;
                }
                drawable = Drawable.createFromStream(open, str);
                open.close();
                return drawable;
            }
            return (Drawable) invokeLL.objValue;
        }

        private View a(Context context, Drawable drawable, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, this, context, drawable, str, onClickListener, onClickListener2)) == null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                float f2 = displayMetrics.density;
                RelativeLayout relativeLayout = new RelativeLayout(context);
                ImageView imageView = new ImageView(context);
                imageView.setImageDrawable(drawable);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setId(1);
                int i2 = (int) (60.0f * f2);
                int i3 = (int) (f2 * 14.0f);
                int i4 = (int) (18.0f * f2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
                layoutParams.addRule(9);
                layoutParams.setMargins(0, i4, (int) (6.0f * f2), i4);
                relativeLayout.addView(imageView, layoutParams);
                TextView textView = new TextView(context);
                textView.setText(str);
                textView.setTextSize(14.0f);
                textView.setGravity(3);
                textView.setIncludeFontPadding(false);
                textView.setPadding(0, 0, 0, 0);
                textView.setLines(2);
                textView.setId(5);
                textView.setMinWidth((int) (185.0f * f2));
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(1, 1);
                layoutParams2.addRule(6, 1);
                float f3 = 5.0f * f2;
                layoutParams2.setMargins(0, 0, (int) f3, 0);
                relativeLayout.addView(textView, layoutParams2);
                View view = new View(context);
                view.setBackgroundColor(Color.rgb(214, 214, 214));
                view.setId(3);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, 2);
                layoutParams3.addRule(3, 1);
                layoutParams3.addRule(5, 1);
                layoutParams3.addRule(7, 5);
                int i5 = (int) (12.0f * f2);
                layoutParams3.setMargins(0, 0, 0, i5);
                relativeLayout.addView(view, layoutParams3);
                LinearLayout linearLayout = new LinearLayout(context);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams4.addRule(5, 1);
                layoutParams4.addRule(7, 5);
                layoutParams4.addRule(3, 3);
                Button button = new Button(context);
                button.setText("跳过");
                button.setBackgroundDrawable(a("buttonNegt.png", context));
                button.setTextColor(Color.rgb(36, 97, (int) IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER));
                button.setTextSize(20.0f);
                button.setOnClickListener(onClickListener2);
                button.setId(4);
                int i6 = (int) (45.0f * f2);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, i6);
                layoutParams5.rightMargin = i3;
                int i7 = (int) (4.0f * f2);
                layoutParams5.leftMargin = i7;
                layoutParams5.weight = 1.0f;
                linearLayout.addView(button, layoutParams5);
                Button button2 = new Button(context);
                button2.setText("确定");
                button2.setTextSize(20.0f);
                button2.setTextColor(Color.rgb(255, 255, 255));
                button2.setBackgroundDrawable(a("buttonPost.png", context));
                button2.setOnClickListener(onClickListener);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, i6);
                layoutParams6.weight = 1.0f;
                layoutParams6.rightMargin = i7;
                linearLayout.addView(button2, layoutParams6);
                relativeLayout.addView(linearLayout, layoutParams4);
                ViewGroup.LayoutParams layoutParams7 = new FrameLayout.LayoutParams((int) (279.0f * f2), (int) (f2 * 163.0f));
                relativeLayout.setPadding(i3, 0, i5, i5);
                relativeLayout.setLayoutParams(layoutParams7);
                relativeLayout.setBackgroundColor(Color.rgb((int) GDiffPatcher.DATA_USHORT, (int) GDiffPatcher.COPY_USHORT_INT, (int) GDiffPatcher.DATA_USHORT));
                PaintDrawable paintDrawable = new PaintDrawable(Color.rgb((int) GDiffPatcher.DATA_USHORT, (int) GDiffPatcher.COPY_USHORT_INT, (int) GDiffPatcher.DATA_USHORT));
                paintDrawable.setCornerRadius(f3);
                relativeLayout.setBackgroundDrawable(paintDrawable);
                return relativeLayout;
            }
            return (View) invokeLLLLL.objValue;
        }

        public void a() {
            Activity activity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bundle b2 = this.f38722b.b();
                if (this.f38722b.f38713e == null || (activity = (Activity) this.f38722b.f38713e.get()) == null) {
                    return;
                }
                HttpUtils.requestAsync(this.f38722b.f38790b, activity, "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", b2, "POST", null);
            }
        }
    }

    private boolean a(Activity activity, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.AD_TEXT_ID, this, activity, fragment, z)) == null) {
            f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
            Intent b2 = b("com.tencent.open.agent.AgentActivity");
            if (b2 != null) {
                Bundle a2 = a();
                if (z) {
                    a2.putString("isadd", "1");
                }
                a2.putString("scope", this.f38712d);
                a2.putString("client_id", this.f38790b.getAppId());
                if (BaseApi.isOEM) {
                    a2.putString("pf", "desktop_m_qq-" + BaseApi.installChannel + "-android-" + BaseApi.registerChannel + "-" + BaseApi.businessId);
                } else {
                    a2.putString("pf", com.tencent.connect.common.Constants.DEFAULT_PF);
                }
                a2.putString("need_pay", "1");
                a2.putString(com.tencent.connect.common.Constants.KEY_APP_NAME, h.a(e.a()));
                b2.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_login");
                b2.putExtra(com.tencent.connect.common.Constants.KEY_PARAMS, a2);
                b2.putExtra("appid", this.f38790b.getAppId());
                if (a(b2)) {
                    this.f38711c = new b(this, this.f38711c);
                    UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_LOGIN, this.f38711c);
                    if (fragment != null) {
                        f.b("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                        a(fragment, b2, com.tencent.connect.common.Constants.REQUEST_LOGIN);
                    } else {
                        f.b("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                        a(activity, b2, com.tencent.connect.common.Constants.REQUEST_LOGIN);
                    }
                    f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                    d.a().a(0, "LOGIN_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.f38790b.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                    return true;
                }
            }
            d.a().a(1, "LOGIN_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.f38790b.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
            f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public void a(IUiListener iUiListener) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iUiListener) == null) {
            f.c("openSDK_LOG.AuthAgent", "reportDAU() -- start");
            String accessToken = this.f38790b.getAccessToken();
            String openId = this.f38790b.getOpenId();
            String appId = this.f38790b.getAppId();
            if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openId) || TextUtils.isEmpty(appId)) {
                str = "";
            } else {
                str = j.f("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
            }
            if (TextUtils.isEmpty(str)) {
                f.e("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
                return;
            }
            Bundle a2 = a();
            a2.putString("encrytoken", str);
            HttpUtils.requestAsync(this.f38790b, e.a(), "https://openmobile.qq.com/user/user_login_statis", a2, "POST", null);
            f.c("openSDK_LOG.AuthAgent", "reportDAU() -- end");
        }
    }
}
