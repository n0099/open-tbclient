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
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import com.qq.e.comm.constants.Constants;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.TDialog;
import com.tencent.open.a.d;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
import com.tencent.open.utils.l;
import com.tencent.open.web.security.JniInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AuthAgent extends BaseApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_FORCE_QR_LOGIN = "KEY_FORCE_QR_LOGIN";
    public static final String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
    public static final String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_NAME = null;
    public static final int SECURE_LIB_VERSION = 5;
    public static final String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
    public static final String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";
    public transient /* synthetic */ FieldHolder $fh;
    public IUiListener a;
    public String d;
    public WeakReference<Activity> e;

    /* loaded from: classes7.dex */
    public class a extends DefaultUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public IUiListener a;
        public final /* synthetic */ AuthAgent b;

        public a(AuthAgent authAgent, IUiListener iUiListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authAgent, iUiListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = authAgent;
            this.a = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iUiListener = this.a) == null) {
                return;
            }
            iUiListener.onCancel();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (obj == null) {
                    SLog.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
                    return;
                }
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    int i = jSONObject.getInt(Constants.KEYS.RET);
                    String string = i == 0 ? "success" : jSONObject.getString("msg");
                    if (this.a != null) {
                        this.a.onComplete(new JSONObject().put(Constants.KEYS.RET, i).put("msg", string));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    SLog.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
                }
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) || (iUiListener = this.a) == null) {
                return;
            }
            iUiListener.onError(uiError);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends DefaultUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AuthAgent a;
        public final IUiListener b;
        public final boolean c;
        public final Context d;

        public c(AuthAgent authAgent, Context context, IUiListener iUiListener, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authAgent, context, iUiListener, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = authAgent;
            this.d = context;
            this.b = iUiListener;
            this.c = z;
            SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
                this.b.onCancel();
                SLog.release();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    String string = jSONObject.getString("access_token");
                    String string2 = jSONObject.getString("expires_in");
                    String string3 = jSONObject.getString("openid");
                    if (string != null && this.a.c != null && string3 != null) {
                        this.a.c.setAccessToken(string, string2);
                        this.a.c.setOpenId(string3);
                        com.tencent.connect.a.a.d(this.d, this.a.c);
                    }
                    String string4 = jSONObject.getString("pf");
                    if (string4 != null) {
                        try {
                            this.d.getSharedPreferences(com.tencent.connect.common.Constants.PREFERENCE_PF, 0).edit().putString("pf", string4).commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                            SLog.e("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e);
                        }
                    }
                    if (this.c) {
                        CookieSyncManager.getInstance().sync();
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    SLog.e("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e2);
                }
                this.b.onComplete(jSONObject);
                this.a.releaseResource();
                SLog.release();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
                this.b.onError(uiError);
                SLog.release();
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
                SLog.i("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
                return;
            } else if (str.equalsIgnoreCase("x86")) {
                SECURE_LIB_FILE_NAME = SECURE_LIB_X86_FILE_NAME;
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                SLog.i("openSDK_LOG.AuthAgent", "is x86 architecture");
                return;
            } else if (str.equalsIgnoreCase("x86_64")) {
                SECURE_LIB_FILE_NAME = SECURE_LIB_X86_64_FILE_NAME;
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                SLog.i("openSDK_LOG.AuthAgent", "is x86_64 architecture");
                return;
            } else {
                SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                SLog.i("openSDK_LOG.AuthAgent", "is arm(default) architecture");
                return;
            }
        }
        SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        SLog.i("openSDK_LOG.AuthAgent", "is arm(default) architecture");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((QQToken) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void a(Bundle bundle, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, bundle, map) == null) {
        }
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener, boolean z, Fragment fragment, boolean z2, Map<String, Object> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{activity, str, iUiListener, Boolean.valueOf(z), fragment, Boolean.valueOf(z2), map})) == null) {
            this.d = str;
            this.e = new WeakReference<>(activity);
            this.a = iUiListener;
            Object[] objArr = new Object[2];
            if (!activity.getIntent().getBooleanExtra(KEY_FORCE_QR_LOGIN, false) && !g.a(activity, this.c.getAppId()).b("C_LoginWeb") && a(activity, fragment, map, z, objArr)) {
                SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
                d.a().a(this.c.getOpenId(), this.c.getAppId(), "2", "1", "5", (String) objArr[0], "0", "0");
                return ((Integer) objArr[1]).intValue();
            }
            d.a().a(this.c.getOpenId(), this.c.getAppId(), "2", "1", "5", "1", "0", "0");
            SLog.w("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
            b bVar = new b(this, this.a);
            this.a = bVar;
            return a(z, bVar, z2);
        }
        return invokeCommon.intValue;
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = null;
        }
    }

    public void b(IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, iUiListener) == null) {
            Bundle a2 = a();
            a2.putString("reqType", "checkLogin");
            HttpUtils.requestAsync(this.c, f.a(), "https://openmobile.qq.com/v3/user/get_info", a2, "GET", new BaseApi.TempRequestListener(this, new a(this, iUiListener)));
        }
    }

    public int a(Activity activity, String str, IUiListener iUiListener, boolean z, Fragment fragment, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{activity, str, iUiListener, Boolean.valueOf(z), fragment, Boolean.valueOf(z2)})) == null) ? doLogin(activity, str, iUiListener, z, fragment, z2, null) : invokeCommon.intValue;
    }

    private int a(boolean z, IUiListener iUiListener, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Boolean.valueOf(z), iUiListener, Boolean.valueOf(z2)})) == null) {
            SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start");
            CookieSyncManager.createInstance(f.a());
            Bundle a2 = a();
            if (z) {
                a2.putString("isadd", "1");
            }
            a2.putString("scope", this.d);
            a2.putString("client_id", this.c.getAppId());
            if (BaseApi.isOEM) {
                a2.putString("pf", "desktop_m_qq-" + BaseApi.installChannel + "-android-" + BaseApi.registerChannel + "-" + BaseApi.businessId);
            } else {
                a2.putString("pf", com.tencent.connect.common.Constants.DEFAULT_PF);
            }
            String str = (System.currentTimeMillis() / 1000) + "";
            a2.putString("sign", i.b(f.a(), str));
            a2.putString("time", str);
            a2.putString(CriusAttrConstants.DISPLAY, "mobile");
            a2.putString("response_type", "token");
            a2.putString("redirect_uri", "auth://tauth.qq.com/");
            a2.putString("cancel_display", "1");
            a2.putString("switch", "1");
            a2.putString("compat_v", "1");
            if (z2) {
                a2.putString("style", "qr");
            }
            c cVar = new c(this, f.a(), iUiListener, true, false);
            SLog.d("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
            j.a(new Runnable(this, h.a().a(f.a(), "https://openmobile.qq.com/oauth2.0/m_authorize?") + HttpUtils.encodeUrl(a2), cVar) { // from class: com.tencent.connect.auth.AuthAgent.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ IUiListener b;
                public final /* synthetic */ AuthAgent c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = r7;
                    this.b = cVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Activity activity;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        i.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                        JniInterface.loadSo();
                        if (this.c.e == null || (activity = (Activity) this.c.e.get()) == null) {
                            return;
                        }
                        activity.runOnUiThread(new Runnable(this, activity) { // from class: com.tencent.connect.auth.AuthAgent.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Activity a;
                            public final /* synthetic */ AnonymousClass1 b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, activity};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.b = this;
                                this.a = activity;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (JniInterface.isJniOk) {
                                        Activity activity2 = this.a;
                                        AnonymousClass1 anonymousClass1 = this.b;
                                        com.tencent.connect.auth.a aVar = new com.tencent.connect.auth.a(activity2, "action_login", anonymousClass1.a, anonymousClass1.b, anonymousClass1.c.c);
                                        if (this.a.isFinishing()) {
                                            return;
                                        }
                                        aVar.show();
                                        return;
                                    }
                                    SLog.w("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                                    Activity activity3 = this.a;
                                    String a3 = this.b.c.a("");
                                    AnonymousClass1 anonymousClass12 = this.b;
                                    TDialog tDialog = new TDialog(activity3, "", a3, anonymousClass12.b, anonymousClass12.c.c);
                                    if (this.a.isFinishing()) {
                                        return;
                                    }
                                    tDialog.show();
                                }
                            }
                        });
                    }
                }
            });
            SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
            return 2;
        }
        return invokeCommon.intValue;
    }

    /* loaded from: classes7.dex */
    public class b extends DefaultUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<IUiListener> a;
        public final /* synthetic */ AuthAgent b;
        public final String c;
        public final String d;
        public final String e;

        /* loaded from: classes7.dex */
        public abstract class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Dialog d;
            public final /* synthetic */ b e;

            public a(b bVar, Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dialog};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = bVar;
                this.d = dialog;
            }
        }

        public b(AuthAgent authAgent, IUiListener iUiListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authAgent, iUiListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = authAgent;
            this.c = "sendinstall";
            this.d = "installwording";
            this.e = "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";
            this.a = new WeakReference<>(iUiListener);
        }

        private void a(String str, IUiListener iUiListener, Object obj) {
            PackageInfo packageInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65539, this, str, iUiListener, obj) == null) {
                if (this.b.e != null) {
                    Activity activity = (Activity) this.b.e.get();
                    if (activity == null) {
                        SLog.i("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity.get() null and return");
                        return;
                    }
                    Dialog dialog = new Dialog(activity);
                    dialog.requestWindowFeature(1);
                    PackageManager packageManager = activity.getPackageManager();
                    try {
                        packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
                    } catch (PackageManager.NameNotFoundException e) {
                        SLog.e("openSDK_LOG.AuthAgent", "showFeedConfrimDialog exception:" + e.getStackTrace().toString());
                        packageInfo = null;
                    }
                    Drawable loadIcon = packageInfo != null ? packageInfo.applicationInfo.loadIcon(packageManager) : null;
                    View.OnClickListener onClickListener = new a(this, dialog, iUiListener, obj) { // from class: com.tencent.connect.auth.AuthAgent.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ IUiListener a;
                        public final /* synthetic */ Object b;
                        public final /* synthetic */ b c;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(this, dialog);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, dialog, iUiListener, obj};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((b) objArr2[0], (Dialog) objArr2[1]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.c = this;
                            this.a = iUiListener;
                            this.b = obj;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                this.c.a();
                                Dialog dialog2 = this.d;
                                if (dialog2 != null && dialog2.isShowing()) {
                                    this.d.dismiss();
                                }
                                IUiListener iUiListener2 = this.a;
                                if (iUiListener2 != null) {
                                    iUiListener2.onComplete(this.b);
                                }
                            }
                        }
                    };
                    View.OnClickListener onClickListener2 = new a(this, dialog, iUiListener, obj) { // from class: com.tencent.connect.auth.AuthAgent.b.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ IUiListener a;
                        public final /* synthetic */ Object b;
                        public final /* synthetic */ b c;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(this, dialog);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, dialog, iUiListener, obj};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((b) objArr2[0], (Dialog) objArr2[1]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.c = this;
                            this.a = iUiListener;
                            this.b = obj;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                Dialog dialog2 = this.d;
                                if (dialog2 != null && dialog2.isShowing()) {
                                    this.d.dismiss();
                                }
                                IUiListener iUiListener2 = this.a;
                                if (iUiListener2 != null) {
                                    iUiListener2.onComplete(this.b);
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
                        public final /* synthetic */ IUiListener a;
                        public final /* synthetic */ Object b;
                        public final /* synthetic */ b c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iUiListener, obj};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.c = this;
                            this.a = iUiListener;
                            this.b = obj;
                        }

                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            IUiListener iUiListener2;
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) || (iUiListener2 = this.a) == null) {
                                return;
                            }
                            iUiListener2.onComplete(this.b);
                        }
                    });
                    if (activity == null || activity.isFinishing()) {
                        return;
                    }
                    dialog.show();
                    return;
                }
                SLog.i("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity null and return");
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.get() == null) {
                return;
            }
            this.a.get().onCancel();
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a4  */
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onComplete(Object obj) {
            JSONObject jSONObject;
            boolean z;
            String str;
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, obj) == null) || obj == null || (jSONObject = (JSONObject) obj) == null) {
                return;
            }
            boolean z2 = false;
            try {
                z = jSONObject.getInt("sendinstall") == 1;
                try {
                    str = jSONObject.getString("installwording");
                } catch (JSONException unused) {
                    SLog.w("openSDK_LOG.AuthAgent", "FeedConfirmListener onComplete There is no value for sendinstall.");
                    str = "";
                    String decode = URLDecoder.decode(str);
                    SLog.i("openSDK_LOG.AuthAgent", " WORDING = " + decode + "xx,showConfirmDialog=" + z);
                    if (!z) {
                    }
                    iUiListener = this.a.get();
                    if (iUiListener == null) {
                    }
                }
            } catch (JSONException unused2) {
                z = false;
            }
            String decode2 = URLDecoder.decode(str);
            SLog.i("openSDK_LOG.AuthAgent", " WORDING = " + decode2 + "xx,showConfirmDialog=" + z);
            if (!z && !TextUtils.isEmpty(decode2)) {
                a(decode2, this.a.get(), obj);
                SLog.i("openSDK_LOG.AuthAgent", " WORDING is not empty and return");
                return;
            }
            iUiListener = this.a.get();
            if (iUiListener == null) {
                if (this.b.c != null) {
                    z2 = this.b.c.saveSession(jSONObject);
                    SLog.i("openSDK_LOG.AuthAgent", " saveSession saveSuccess=" + z2);
                }
                if (z2) {
                    iUiListener.onComplete(obj);
                    return;
                } else {
                    iUiListener.onError(new UiError(-6, com.tencent.connect.common.Constants.MSG_PERSISTENCE_FAIL, null));
                    return;
                }
            }
            SLog.i("openSDK_LOG.AuthAgent", " userListener is null");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, uiError) == null) || this.a.get() == null) {
                return;
            }
            this.a.get().onError(uiError);
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (open == null) {
                    return null;
                }
                if (str.endsWith(".9.png")) {
                    try {
                        bitmap = BitmapFactory.decodeStream(open);
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
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
                float f = displayMetrics.density;
                RelativeLayout relativeLayout = new RelativeLayout(context);
                ImageView imageView = new ImageView(context);
                imageView.setImageDrawable(drawable);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setId(1);
                int i = (int) (60.0f * f);
                int i2 = (int) (f * 14.0f);
                int i3 = (int) (18.0f * f);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
                layoutParams.addRule(9);
                layoutParams.setMargins(0, i3, (int) (6.0f * f), i3);
                relativeLayout.addView(imageView, layoutParams);
                TextView textView = new TextView(context);
                textView.setText(str);
                textView.setTextSize(14.0f);
                textView.setGravity(3);
                textView.setIncludeFontPadding(false);
                textView.setPadding(0, 0, 0, 0);
                textView.setLines(2);
                textView.setId(5);
                textView.setMinWidth((int) (185.0f * f));
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(1, 1);
                layoutParams2.addRule(6, 1);
                float f2 = 5.0f * f;
                layoutParams2.setMargins(0, 0, (int) f2, 0);
                relativeLayout.addView(textView, layoutParams2);
                View view2 = new View(context);
                view2.setBackgroundColor(Color.rgb((int) w0.c0, (int) w0.c0, (int) w0.c0));
                view2.setId(3);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, 2);
                layoutParams3.addRule(3, 1);
                layoutParams3.addRule(5, 1);
                layoutParams3.addRule(7, 5);
                int i4 = (int) (12.0f * f);
                layoutParams3.setMargins(0, 0, 0, i4);
                relativeLayout.addView(view2, layoutParams3);
                LinearLayout linearLayout = new LinearLayout(context);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams4.addRule(5, 1);
                layoutParams4.addRule(7, 5);
                layoutParams4.addRule(3, 3);
                Button button = new Button(context);
                button.setText("跳过");
                button.setBackgroundDrawable(a("buttonNegt.png", context));
                button.setTextColor(Color.rgb(36, 97, 131));
                button.setTextSize(20.0f);
                button.setOnClickListener(onClickListener2);
                button.setId(4);
                int i5 = (int) (45.0f * f);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, i5);
                layoutParams5.rightMargin = i2;
                int i6 = (int) (4.0f * f);
                layoutParams5.leftMargin = i6;
                layoutParams5.weight = 1.0f;
                linearLayout.addView(button, layoutParams5);
                Button button2 = new Button(context);
                button2.setText("确定");
                button2.setTextSize(20.0f);
                button2.setTextColor(Color.rgb(255, 255, 255));
                button2.setBackgroundDrawable(a("buttonPost.png", context));
                button2.setOnClickListener(onClickListener);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, i5);
                layoutParams6.weight = 1.0f;
                layoutParams6.rightMargin = i6;
                linearLayout.addView(button2, layoutParams6);
                relativeLayout.addView(linearLayout, layoutParams4);
                ViewGroup.LayoutParams layoutParams7 = new FrameLayout.LayoutParams((int) (279.0f * f), (int) (f * 163.0f));
                relativeLayout.setPadding(i2, 0, i4, i4);
                relativeLayout.setLayoutParams(layoutParams7);
                relativeLayout.setBackgroundColor(Color.rgb((int) GDiffPatcher.DATA_USHORT, 251, (int) GDiffPatcher.DATA_USHORT));
                PaintDrawable paintDrawable = new PaintDrawable(Color.rgb((int) GDiffPatcher.DATA_USHORT, 251, (int) GDiffPatcher.DATA_USHORT));
                paintDrawable.setCornerRadius(f2);
                relativeLayout.setBackgroundDrawable(paintDrawable);
                return relativeLayout;
            }
            return (View) invokeLLLLL.objValue;
        }

        public void a() {
            Activity activity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bundle b = this.b.b();
                if (this.b.e == null || (activity = (Activity) this.b.e.get()) == null) {
                    return;
                }
                HttpUtils.requestAsync(this.b.c, activity, "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", b, "POST", null);
            }
        }
    }

    private boolean a(Activity activity, Fragment fragment, Map<String, Object> map, boolean z, Object[] objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{activity, fragment, map, Boolean.valueOf(z), objArr})) == null) {
            SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
            Intent b2 = b("com.tencent.open.agent.AgentActivity");
            if (b2 != null) {
                Bundle a2 = a();
                if (z) {
                    a2.putString("isadd", "1");
                }
                a2.putString("scope", this.d);
                a2.putString("client_id", this.c.getAppId());
                if (BaseApi.isOEM) {
                    a2.putString("pf", "desktop_m_qq-" + BaseApi.installChannel + "-android-" + BaseApi.registerChannel + "-" + BaseApi.businessId);
                } else {
                    a2.putString("pf", com.tencent.connect.common.Constants.DEFAULT_PF);
                }
                a2.putString("need_pay", "1");
                a(a2, map);
                a2.putString(com.tencent.connect.common.Constants.KEY_APP_NAME, i.a(f.a()));
                b2.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_login");
                b2.putExtra(com.tencent.connect.common.Constants.KEY_PARAMS, a2);
                b2.putExtra("appid", this.c.getAppId());
                a2.putString(com.tencent.connect.common.Constants.KEY_PPSTS, i.a(activity, a(a2)));
                if (a(b2)) {
                    this.a = new b(this, this.a);
                    UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_LOGIN, this.a);
                    if (fragment != null) {
                        SLog.d("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                        a(fragment, b2, com.tencent.connect.common.Constants.REQUEST_LOGIN, map);
                    } else {
                        SLog.d("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                        a(activity, b2, com.tencent.connect.common.Constants.REQUEST_LOGIN, map);
                    }
                    SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                    d.a().a(0, "LOGIN_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                    objArr[0] = "0";
                    objArr[1] = 1;
                    return true;
                }
            }
            d.a().a(1, "LOGIN_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
            SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private String a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bundle)) == null) {
            String string = bundle.getString("status_os");
            String string2 = bundle.getString("status_machine");
            String string3 = bundle.getString("status_version");
            String string4 = bundle.getString("sdkv");
            String string5 = bundle.getString("client_id");
            String string6 = bundle.getString("need_pay");
            String string7 = bundle.getString("pf");
            SLog.d("openSDK_LOG.AuthAgent", "os=" + string + ", machine=" + string2 + ", version=" + string3 + ", sdkv=" + string4 + ", appId=" + string5 + ", needPay=" + string6 + ", pf=" + string7);
            StringBuilder sb = new StringBuilder();
            if (string == null) {
                string = "";
            }
            sb.append(string);
            if (string2 == null) {
                string2 = "";
            }
            sb.append(string2);
            if (string3 == null) {
                string3 = "";
            }
            sb.append(string3);
            if (string4 == null) {
                string4 = "";
            }
            sb.append(string4);
            if (string5 == null) {
                string5 = "";
            }
            sb.append(string5);
            if (string6 == null) {
                string6 = "";
            }
            sb.append(string6);
            if (string7 == null) {
                string7 = "";
            }
            sb.append(string7);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void a(IUiListener iUiListener) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iUiListener) == null) {
            SLog.i("openSDK_LOG.AuthAgent", "reportDAU() -- start");
            String accessToken = this.c.getAccessToken();
            String openId = this.c.getOpenId();
            String appId = this.c.getAppId();
            if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openId) || TextUtils.isEmpty(appId)) {
                str = "";
            } else {
                str = l.f("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
            }
            if (TextUtils.isEmpty(str)) {
                SLog.e("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
                return;
            }
            Bundle a2 = a();
            a2.putString("encrytoken", str);
            HttpUtils.requestAsync(this.c, f.a(), "https://openmobile.qq.com/user/user_login_statis", a2, "POST", null);
            SLog.i("openSDK_LOG.AuthAgent", "reportDAU() -- end");
        }
    }
}
