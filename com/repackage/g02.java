package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.Headers;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppClearCacheErrorActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.n02;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g02 extends f02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String F0;
    public String G0;
    public ForbiddenInfo H0;
    public int I0;
    public int J0;
    public String K0;
    public String L0;
    public String M0;
    public int N0;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g02 a;

        public a(g02 g02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g02Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (activity = this.a.c0) == null) {
                return;
            }
            activity.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl2 a;
        public final /* synthetic */ g02 b;

        public b(g02 g02Var, wl2 wl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g02Var, wl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g02Var;
            this.a = wl2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.b.c0) != null && SwanAppNetworkUtils.i(activity)) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("property_web_mode_degrade", true);
                SwanLauncher.j().n(this.a, bundle);
                this.b.c0.finishAndRemoveTask();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ g02 b;

        public c(g02 g02Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g02Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g02Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.H0 == null || TextUtils.isEmpty(this.b.H0.forbiddenDetail)) {
                return;
            }
            gk2.u().b(this.b.getActivity(), this.a, this.b.H0.appTitle, this.b.H0.forbiddenDetail);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl2 a;
        public final /* synthetic */ g02 b;

        public d(g02 g02Var, wl2 wl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g02Var, wl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g02Var;
            this.a = wl2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.b.c0) != null && SwanAppNetworkUtils.i(activity)) {
                SwanLauncher.j().n(this.a, null);
                this.b.c0.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g02 a;

        public e(g02 g02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g02Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || TextUtils.isEmpty(this.a.L0)) {
                return;
            }
            Activity activity = this.a.c0;
            if (activity instanceof FragmentActivity) {
                te4 l = ((FragmentActivity) activity).l();
                n02.d b3 = n02.b3(this.a.L0);
                b3.a(false);
                b3.c(l);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g02 a;

        public f(g02 g02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g02Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FragmentActivity activity = this.a.getActivity();
                if (!(activity instanceof SwanAppClearCacheErrorActivity)) {
                    if (f02.E0) {
                        throw new IllegalStateException("非SwanAppClearCacheErrorActivity");
                    }
                    return;
                }
                ((SwanAppClearCacheErrorActivity) activity).E();
                try {
                    this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("baiduboxapp://v16/ucenter/cleanCache")));
                } catch (Exception e) {
                    zx1.l("SwanAppErrorFragment", "打开清理缓存界面失败", e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g02 a;

        public g(g02 g02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g02Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.P1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl2 a;
        public final /* synthetic */ g02 b;

        public h(g02 g02Var, wl2 wl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g02Var, wl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g02Var;
            this.a = wl2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.b.c0) != null && SwanAppNetworkUtils.i(activity)) {
                SwanLauncher.j().n(this.a, null);
                this.b.c0.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements d74 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ g02 b;

        public i(g02 g02Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g02Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g02Var;
            this.a = activity;
        }

        @Override // com.repackage.d74
        public boolean b(View view2, f74 f74Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, f74Var)) == null) {
                int c = f74Var.c();
                if (c == 5) {
                    this.b.j3(this.a);
                } else if (c == 9) {
                    this.b.g3(this.a);
                    return true;
                } else if (c == 39) {
                    this.b.k3(this.a);
                } else if (c == 46) {
                    this.b.h3(f74Var, this.a);
                } else if (c == 47) {
                    this.b.i3(f74Var, this.a);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b83 a;

            public a(b83 b83Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {b83Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = b83Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g73.i("934", "85", this.a.f());
                }
            }
        }

        public static void a(String str, wl2 wl2Var, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65536, null, str, wl2Var, forbiddenInfo) == null) {
                b83 b83Var = new b83();
                b83Var.f = forbiddenInfo.appId;
                b83Var.g = "errormenu";
                b83Var.b = "click";
                b83Var.e = str;
                b83Var.c = forbiddenInfo.launchSource;
                b83Var.b(s73.k(wl2Var.W()));
                b83Var.d(wl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                td3.j(new a(b83Var), "SwanAppFuncClickUBC");
            }
        }
    }

    public g02() {
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

    public static g02 f3(String str, String str2, String str3, int i2, ForbiddenInfo forbiddenInfo, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Integer.valueOf(i2), forbiddenInfo, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            g02 g02Var = new g02();
            Bundle bundle = new Bundle();
            bundle.putString("swan_error_type", str2);
            bundle.putString("swan_error_code", str);
            bundle.putString(DeepLinkItem.DEEPLINK_WEBURL_KEY, str3);
            bundle.putInt("webPermit", i2);
            bundle.putParcelable("key_forbidden_info", forbiddenInfo);
            bundle.putInt("key_show_menu_notice", i3);
            bundle.putInt("key_show_menu_privacy", i4);
            g02Var.j1(bundle);
            return g02Var;
        }
        return (g02) invokeCommon.objValue;
    }

    @Override // com.repackage.f02
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.f02
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.U1(view2);
            V1(view2);
            t2(-1);
            C2(-16777216);
            x2(false);
            J2(true);
            this.f0.setRightExitOnClickListener(new a(this));
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo == null || TextUtils.isEmpty(forbiddenInfo.appTitle)) {
                return;
            }
            v2(this.H0.appTitle);
        }
    }

    public final boolean W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo == null) {
                return false;
            }
            return forbiddenInfo.enableSliding();
        }
        return invokeV.booleanValue;
    }

    public final CharSequence X2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            Map<String, String> g2 = zc4.f().g();
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo != null) {
                String str2 = forbiddenInfo.forbiddenDetail;
                if (str2.length() > 4) {
                    String m = zc4.m(g2, str2.substring(str2.length() - 4));
                    if (!TextUtils.isEmpty(m)) {
                        return m;
                    }
                }
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1242268664:
                    if (str.equals("type_need_update_sdk")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -429452284:
                    if (str.equals("type_path_forbidden")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 38398066:
                    if (str.equals("type_network_error")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 517286506:
                    if (str.equals("type_0049")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 517347882:
                    if (str.equals("type_2205")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 731215244:
                    if (str.equals("type_normal")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                String m2 = zc4.m(g2, "net_conn_failed");
                return TextUtils.isEmpty(m2) ? S(R.string.obfuscated_res_0x7f0f12ad) : m2;
            } else if (c2 == 1) {
                String m3 = zc4.m(g2, "app_open_failed");
                return TextUtils.isEmpty(m3) ? S(R.string.obfuscated_res_0x7f0f12ad) : m3;
            } else if (c2 == 2) {
                String m4 = zc4.m(g2, "app_need_upgrade");
                return TextUtils.isEmpty(m4) ? S(R.string.obfuscated_res_0x7f0f12ad) : m4;
            } else if (c2 == 3) {
                String m5 = zc4.m(g2, "app_page_banned");
                return TextUtils.isEmpty(m5) ? S(R.string.obfuscated_res_0x7f0f12ac) : m5;
            } else if (c2 == 4) {
                String m6 = zc4.m(g2, "0049");
                return TextUtils.isEmpty(m6) ? S(R.string.obfuscated_res_0x7f0f12ad) : m6;
            } else if (c2 != 5) {
                return "";
            } else {
                String m7 = zc4.m(g2, "2205");
                return TextUtils.isEmpty(m7) ? S(R.string.obfuscated_res_0x7f0f12ab) : m7;
            }
        }
        return (CharSequence) invokeL.objValue;
    }

    public final JSONObject Y2(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                ForbiddenInfo w = ((SwanAppErrorActivity) activity).w();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("title", w.appTitle);
                    jSONObject.put("url", w.launchPath);
                    jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, w.appId);
                    jSONObject.put("errorPath", w.launchPath);
                    jSONObject.put("errorDes", w.forbiddenReason);
                } catch (JSONException e2) {
                    if (f02.E0) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final wl2 Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getActivity() == null || !(getActivity() instanceof SwanAppErrorActivity)) {
                return null;
            }
            return ((SwanAppErrorActivity) getActivity()).x();
        }
        return (wl2) invokeV.objValue;
    }

    public final String a3(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            String str3 = "";
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1242268664:
                        if (str.equals("type_need_update_sdk")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -429452284:
                        if (str.equals("type_path_forbidden")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 38398066:
                        if (str.equals("type_network_error")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 517286506:
                        if (str.equals("type_0049")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 517347882:
                        if (str.equals("type_2205")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 731215244:
                        if (str.equals("type_normal")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f130a);
                } else if (c2 == 1) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f12b4);
                } else if (c2 == 2) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f12b2);
                } else if (c2 == 3) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f12b5);
                } else if (c2 == 4) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f12b1);
                } else if (c2 == 5) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f12ae);
                }
                Map<String, String> g2 = zc4.f().g();
                if (g2 != null) {
                    ForbiddenInfo forbiddenInfo = this.H0;
                    if (forbiddenInfo != null) {
                        String str4 = forbiddenInfo.forbiddenDetail;
                        if (str4.length() > 4) {
                            String o = zc4.o(g2, str4.substring(str4.length() - 4));
                            if (!TextUtils.isEmpty(o)) {
                                return o;
                            }
                        }
                    }
                    String o2 = zc4.o(g2, str2);
                    if (!TextUtils.isEmpty(o2)) {
                        return o2;
                    }
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public void b3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (activity = getActivity()) != null && this.g0 == null) {
            e74 e74Var = new e74(activity, this.f0, 19, gk2.K(), new ig3());
            this.g0 = e74Var;
            e74Var.n(new i(this, activity));
            q3();
        }
    }

    @Override // com.repackage.f02
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0273  */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c3(View view2) {
        String str;
        wl2 x;
        String O;
        ForbiddenInfo forbiddenInfo;
        String p3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view2) == null) || view2 == null) {
            return;
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090177);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090174);
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090182);
        TextView textView3 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017a);
        TextView textView4 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090176);
        TextView textView5 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090175);
        String str2 = this.F0;
        boolean z = true;
        if (str2 != null) {
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1869797338:
                    if (str2.equals("type_load_v8_failed")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -1242268664:
                    if (str2.equals("type_need_update_sdk")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -429452284:
                    if (str2.equals("type_path_forbidden")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 38398066:
                    if (str2.equals("type_network_error")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 157273878:
                    if (str2.equals("type_app_forbidden")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 517286506:
                    if (str2.equals("type_0049")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 517347882:
                    if (str2.equals("type_2205")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 731215244:
                    if (str2.equals("type_normal")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    s73.w(this.H0, "offline");
                    p3 = p3();
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081173));
                    textView.setVisibility(8);
                    str = p3;
                    break;
                case 1:
                    s73.w(this.H0, "pageblock");
                    p3 = TextUtils.isEmpty(this.H0.forbiddenInformation) ? getContext().getString(R.string.obfuscated_res_0x7f0f12b5) : this.H0.forbiddenInformation;
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081170));
                    if (m3(this.F0, "app_page_banned")) {
                        textView.setVisibility(0);
                        textView.setText(X2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    if (e3()) {
                        textView.setVisibility(8);
                    }
                    str = p3;
                    break;
                case 2:
                    s73.w(this.H0, "neterror");
                    p3 = a3(this.F0, "net_conn_failed");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081172));
                    if (m3(this.F0, "net_conn_failed")) {
                        textView.setVisibility(0);
                        textView.setText(X2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    textView3.setVisibility(8);
                    str = p3;
                    break;
                case 3:
                    s73.w(this.H0, "commonerror");
                    p3 = a3(this.F0, "app_open_failed");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081171));
                    if (m3(this.F0, "app_open_failed")) {
                        textView.setVisibility(0);
                        textView.setText(X2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = p3;
                    break;
                case 4:
                    s73.w(this.H0, "update");
                    str = a3(this.F0, "app_need_upgrade");
                    if (m3(this.F0, "app_need_upgrade")) {
                        textView.setVisibility(0);
                        textView.setText(X2(this.F0));
                        break;
                    } else {
                        textView.setVisibility(8);
                        break;
                    }
                case 5:
                    s73.w(this.H0, "lackresources");
                    String a3 = a3(this.F0, "0049");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f08116f));
                    if (m3(this.F0, "0049")) {
                        textView.setVisibility(0);
                        textView.setText(X2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = a3;
                    break;
                case 6:
                    s73.w(this.H0, "outdisk");
                    String a32 = a3(this.F0, "2205");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f08116f));
                    if (te3.G()) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    if (m3(this.F0, "2205")) {
                        textView.setVisibility(0);
                        textView.setText(X2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = a32;
                    break;
                case 7:
                    str = getContext().getString(R.string.obfuscated_res_0x7f0f017d);
                    textView.setVisibility(8);
                    break;
            }
            TextView textView6 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090179);
            if (TextUtils.isEmpty(str)) {
                str = getContext().getString(R.string.obfuscated_res_0x7f0f12b4);
            }
            textView6.setText(str);
            Activity activity = this.c0;
            x = !(activity instanceof SwanAppErrorActivity) ? ((SwanAppErrorActivity) activity).x() : null;
            z03 b0 = z03.b0();
            if (x == null) {
                O = x.H();
            } else {
                O = b0 != null ? b0.O() : null;
            }
            forbiddenInfo = this.H0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.forbiddenDetail)) {
                textView3.setText("(" + this.H0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
                textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0603b7));
            }
            l3(textView, x);
            textView2.setOnClickListener(new b(this, x));
            if (te3.G() && !TextUtils.equals(this.F0, "type_network_error")) {
                textView4.setVisibility(0);
                textView4.setOnClickListener(new c(this, O));
            }
            z = (this.N0 == 1 || TextUtils.isEmpty(this.M0)) ? false : false;
            if (!d3() && z && fd4.d()) {
                textView5.setVisibility(0);
                textView2.setVisibility(0);
                textView4.setVisibility(8);
                return;
            }
            textView5.setVisibility(8);
            textView2.setVisibility(8);
            textView4.setVisibility(0);
        }
        str = null;
        TextView textView62 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090179);
        if (TextUtils.isEmpty(str)) {
        }
        textView62.setText(str);
        Activity activity2 = this.c0;
        if (!(activity2 instanceof SwanAppErrorActivity)) {
        }
        z03 b02 = z03.b0();
        if (x == null) {
        }
        forbiddenInfo = this.H0;
        if (forbiddenInfo != null) {
            textView3.setText("(" + this.H0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
            textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0603b7));
        }
        l3(textView, x);
        textView2.setOnClickListener(new b(this, x));
        if (te3.G()) {
            textView4.setVisibility(0);
            textView4.setOnClickListener(new c(this, O));
        }
        if (this.N0 == 1) {
        }
        if (!d3()) {
        }
        textView5.setVisibility(8);
        textView2.setVisibility(8);
        textView4.setVisibility(0);
    }

    public final boolean d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList<String> a2 = fd4.b().a();
            return a2 != null && a2.contains(this.G0);
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.f02
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.H0;
            return forbiddenInfo != null && te3.I(forbiddenInfo.launchPath);
        }
        return invokeV.booleanValue;
    }

    public void g3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
            gk2.K().h(activity, Y2(activity));
            j.a("feedback", Z2(), this.H0);
        }
    }

    public void h3(f74 f74Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, f74Var, activity) == null) {
            gk2.K().g(activity, f74Var);
            j.a("notice", Z2(), this.H0);
        }
    }

    public void i3(f74 f74Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, f74Var, activity) == null) {
            gk2.K().b(activity, f74Var);
            j.a("notice", Z2(), this.H0);
        }
    }

    @Override // com.repackage.f02, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) ? W2() : invokeL.booleanValue;
    }

    @Override // com.repackage.f02
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b3();
            n3();
            q3();
            o3();
        }
    }

    public void j3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, activity) == null) {
            pq2.j(activity);
            j.a("daynightmode", Z2(), this.H0);
        }
    }

    public void k3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, activity) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                pq2.t(activity);
            }
            j.a(Headers.REFRESH, Z2(), this.H0);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void l3(TextView textView, wl2 wl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, textView, wl2Var) == null) {
            if (TextUtils.equals(this.K0, "1")) {
                textView.setOnClickListener(new d(this, wl2Var));
            } else if (TextUtils.equals(this.K0, "2")) {
                textView.setOnClickListener(new e(this));
            } else if (TextUtils.equals(this.K0, "3")) {
                textView.setOnClickListener(new f(this));
            } else if (TextUtils.equals(this.K0, "4")) {
                if (e3()) {
                    textView.setVisibility(8);
                } else {
                    textView.setOnClickListener(new g(this));
                }
            } else {
                textView.setText(R.string.obfuscated_res_0x7f0f12ad);
                textView.setOnClickListener(new h(this, wl2Var));
            }
        }
    }

    public final boolean m3(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            Map<String, String> g2 = zc4.f().g();
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo != null) {
                String str3 = forbiddenInfo.forbiddenDetail;
                if (str3.length() > 4) {
                    String substring = str3.substring(str3.length() - 4);
                    if (!TextUtils.isEmpty(zc4.l(g2, substring))) {
                        this.K0 = zc4.l(g2, substring);
                        this.L0 = zc4.n(g2, substring);
                        return !TextUtils.equals(this.K0, "0");
                    }
                }
            }
            String l = zc4.l(g2, str2);
            this.K0 = l;
            if (TextUtils.isEmpty(l)) {
                if (TextUtils.equals(str, "type_path_forbidden")) {
                    this.K0 = "4";
                } else if (TextUtils.equals(str, "type_2205")) {
                    this.K0 = "3";
                } else if (TextUtils.equals(str, "type_app_forbidden")) {
                    this.K0 = "0";
                } else if (TextUtils.equals(str, "type_load_v8_failed")) {
                    this.K0 = "0";
                } else {
                    this.K0 = "1";
                }
            }
            this.L0 = zc4.n(g2, str2);
            return !TextUtils.equals(this.K0, "0");
        }
        return invokeLL.booleanValue;
    }

    public final void n3() {
        e74 e74Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (e74Var = this.g0) == null) {
            return;
        }
        e74Var.s(gk2.M().a());
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            j.a(SupportMenuInflater.XML_MENU, Z2(), this.H0);
        }
    }

    @Override // com.repackage.f02, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            e74 e74Var = this.g0;
            if (e74Var != null && e74Var.i()) {
                this.g0.B(gk2.M().a());
            }
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar != null) {
                xq2.o(swanAppActionBar, this.J0 + this.I0);
            }
        }
    }

    public final String p3() {
        InterceptResult invokeV;
        PMSAppInfo u;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f12a9);
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo == null) {
                return string;
            }
            String str = forbiddenInfo.appId;
            return (TextUtils.isEmpty(str) || (u = u84.i().u(str)) == null || TextUtils.isEmpty(u.statusDesc)) ? string : u.statusDesc;
        }
        return (String) invokeV.objValue;
    }

    public final void q3() {
        e74 e74Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (e74Var = this.g0) == null) {
            return;
        }
        f74 h2 = e74Var.h(46);
        f74 h3 = this.g0.h(47);
        if (h2 != null && this.I0 > 0) {
            h3.o(1);
            h3.n(this.I0);
        }
        if (h3 == null || this.J0 <= 0) {
            return;
        }
        h3.o(1);
        h3.n(this.J0);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            super.u0(bundle);
            Bundle p = p();
            if (p == null) {
                return;
            }
            this.F0 = p.getString("swan_error_type");
            this.G0 = p.getString("swan_error_code");
            this.M0 = p.getString(DeepLinkItem.DEEPLINK_WEBURL_KEY);
            this.N0 = p.getInt("webPermit");
            this.H0 = (ForbiddenInfo) p.getParcelable("key_forbidden_info");
            this.I0 = p.getInt("key_show_menu_notice");
            this.J0 = p.getInt("key_show_menu_privacy");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d009f, viewGroup, false);
            c3(inflate);
            U1(inflate);
            return T1() ? W1(inflate) : inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
