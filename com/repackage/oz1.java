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
import com.repackage.vz1;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class oz1 extends nz1 {
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
        public final /* synthetic */ oz1 a;

        public a(oz1 oz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (activity = this.a.i0) == null) {
                return;
            }
            activity.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el2 a;
        public final /* synthetic */ oz1 b;

        public b(oz1 oz1Var, el2 el2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz1Var, el2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oz1Var;
            this.a = el2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.b.i0) != null && SwanAppNetworkUtils.i(activity)) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("property_web_mode_degrade", true);
                SwanLauncher.j().n(this.a, bundle);
                this.b.i0.finishAndRemoveTask();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ oz1 b;

        public c(oz1 oz1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oz1Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.H0 == null || TextUtils.isEmpty(this.b.H0.forbiddenDetail)) {
                return;
            }
            oj2.u().b(this.b.getActivity(), this.a, this.b.H0.appTitle, this.b.H0.forbiddenDetail);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el2 a;
        public final /* synthetic */ oz1 b;

        public d(oz1 oz1Var, el2 el2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz1Var, el2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oz1Var;
            this.a = el2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.b.i0) != null && SwanAppNetworkUtils.i(activity)) {
                SwanLauncher.j().n(this.a, null);
                this.b.i0.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oz1 a;

        public e(oz1 oz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || TextUtils.isEmpty(this.a.L0)) {
                return;
            }
            Activity activity = this.a.i0;
            if (activity instanceof FragmentActivity) {
                be4 l = ((FragmentActivity) activity).l();
                vz1.d b3 = vz1.b3(this.a.L0);
                b3.a(false);
                b3.c(l);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oz1 a;

        public f(oz1 oz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FragmentActivity activity = this.a.getActivity();
                if (!(activity instanceof SwanAppClearCacheErrorActivity)) {
                    if (nz1.E0) {
                        throw new IllegalStateException("非SwanAppClearCacheErrorActivity");
                    }
                    return;
                }
                ((SwanAppClearCacheErrorActivity) activity).E();
                try {
                    this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("baiduboxapp://v16/ucenter/cleanCache")));
                } catch (Exception e) {
                    hx1.l("SwanAppErrorFragment", "打开清理缓存界面失败", e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oz1 a;

        public g(oz1 oz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oz1Var;
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
        public final /* synthetic */ el2 a;
        public final /* synthetic */ oz1 b;

        public h(oz1 oz1Var, el2 el2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz1Var, el2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oz1Var;
            this.a = el2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.b.i0) != null && SwanAppNetworkUtils.i(activity)) {
                SwanLauncher.j().n(this.a, null);
                this.b.i0.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements l64 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ oz1 b;

        public i(oz1 oz1Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz1Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oz1Var;
            this.a = activity;
        }

        @Override // com.repackage.l64
        public boolean b(View view2, n64 n64Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, n64Var)) == null) {
                int c = n64Var.c();
                if (c == 5) {
                    this.b.j3(this.a);
                } else if (c == 9) {
                    this.b.g3(this.a);
                    return true;
                } else if (c == 39) {
                    this.b.k3(this.a);
                } else if (c == 46) {
                    this.b.h3(n64Var, this.a);
                } else if (c == 47) {
                    this.b.i3(n64Var, this.a);
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
            public final /* synthetic */ j73 a;

            public a(j73 j73Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {j73Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j73Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    o63.i("934", "85", this.a.f());
                }
            }
        }

        public static void a(String str, el2 el2Var, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65536, null, str, el2Var, forbiddenInfo) == null) {
                j73 j73Var = new j73();
                j73Var.f = forbiddenInfo.appId;
                j73Var.g = "errormenu";
                j73Var.b = "click";
                j73Var.e = str;
                j73Var.c = forbiddenInfo.launchSource;
                j73Var.b(a73.k(el2Var.W()));
                j73Var.d(el2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                bd3.j(new a(j73Var), "SwanAppFuncClickUBC");
            }
        }
    }

    public oz1() {
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

    public static oz1 f3(String str, String str2, String str3, int i2, ForbiddenInfo forbiddenInfo, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Integer.valueOf(i2), forbiddenInfo, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            oz1 oz1Var = new oz1();
            Bundle bundle = new Bundle();
            bundle.putString("swan_error_type", str2);
            bundle.putString("swan_error_code", str);
            bundle.putString(DeepLinkItem.DEEPLINK_WEBURL_KEY, str3);
            bundle.putInt("webPermit", i2);
            bundle.putParcelable("key_forbidden_info", forbiddenInfo);
            bundle.putInt("key_show_menu_notice", i3);
            bundle.putInt("key_show_menu_privacy", i4);
            oz1Var.j1(bundle);
            return oz1Var;
        }
        return (oz1) invokeCommon.objValue;
    }

    @Override // com.repackage.nz1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.nz1
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.U1(view2);
            V1(view2);
            t2(-1);
            C2(-16777216);
            x2(false);
            J2(true);
            this.l0.setRightExitOnClickListener(new a(this));
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
            Map<String, String> g2 = hc4.f().g();
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo != null) {
                String str2 = forbiddenInfo.forbiddenDetail;
                if (str2.length() > 4) {
                    String m = hc4.m(g2, str2.substring(str2.length() - 4));
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
                String m2 = hc4.m(g2, "net_conn_failed");
                return TextUtils.isEmpty(m2) ? P(R.string.obfuscated_res_0x7f0f12c0) : m2;
            } else if (c2 == 1) {
                String m3 = hc4.m(g2, "app_open_failed");
                return TextUtils.isEmpty(m3) ? P(R.string.obfuscated_res_0x7f0f12c0) : m3;
            } else if (c2 == 2) {
                String m4 = hc4.m(g2, "app_need_upgrade");
                return TextUtils.isEmpty(m4) ? P(R.string.obfuscated_res_0x7f0f12c0) : m4;
            } else if (c2 == 3) {
                String m5 = hc4.m(g2, "app_page_banned");
                return TextUtils.isEmpty(m5) ? P(R.string.obfuscated_res_0x7f0f12bf) : m5;
            } else if (c2 == 4) {
                String m6 = hc4.m(g2, "0049");
                return TextUtils.isEmpty(m6) ? P(R.string.obfuscated_res_0x7f0f12c0) : m6;
            } else if (c2 != 5) {
                return "";
            } else {
                String m7 = hc4.m(g2, "2205");
                return TextUtils.isEmpty(m7) ? P(R.string.obfuscated_res_0x7f0f12be) : m7;
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
                    if (nz1.E0) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final el2 Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getActivity() == null || !(getActivity() instanceof SwanAppErrorActivity)) {
                return null;
            }
            return ((SwanAppErrorActivity) getActivity()).x();
        }
        return (el2) invokeV.objValue;
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
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f131d);
                } else if (c2 == 1) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f12c7);
                } else if (c2 == 2) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f12c5);
                } else if (c2 == 3) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f12c8);
                } else if (c2 == 4) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f12c4);
                } else if (c2 == 5) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f12c1);
                }
                Map<String, String> g2 = hc4.f().g();
                if (g2 != null) {
                    ForbiddenInfo forbiddenInfo = this.H0;
                    if (forbiddenInfo != null) {
                        String str4 = forbiddenInfo.forbiddenDetail;
                        if (str4.length() > 4) {
                            String o = hc4.o(g2, str4.substring(str4.length() - 4));
                            if (!TextUtils.isEmpty(o)) {
                                return o;
                            }
                        }
                    }
                    String o2 = hc4.o(g2, str2);
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
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (activity = getActivity()) != null && this.m0 == null) {
            m64 m64Var = new m64(activity, this.l0, 19, oj2.K(), new qf3());
            this.m0 = m64Var;
            m64Var.n(new i(this, activity));
            q3();
        }
    }

    @Override // com.repackage.nz1
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
        el2 x;
        String O;
        ForbiddenInfo forbiddenInfo;
        String p3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view2) == null) || view2 == null) {
            return;
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090171);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09016e);
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017c);
        TextView textView3 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090174);
        TextView textView4 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090170);
        TextView textView5 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09016f);
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
                    a73.w(this.H0, "offline");
                    p3 = p3();
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081108));
                    textView.setVisibility(8);
                    str = p3;
                    break;
                case 1:
                    a73.w(this.H0, "pageblock");
                    p3 = TextUtils.isEmpty(this.H0.forbiddenInformation) ? getContext().getString(R.string.obfuscated_res_0x7f0f12c8) : this.H0.forbiddenInformation;
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081105));
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
                    a73.w(this.H0, "neterror");
                    p3 = a3(this.F0, "net_conn_failed");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081107));
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
                    a73.w(this.H0, "commonerror");
                    p3 = a3(this.F0, "app_open_failed");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081106));
                    if (m3(this.F0, "app_open_failed")) {
                        textView.setVisibility(0);
                        textView.setText(X2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = p3;
                    break;
                case 4:
                    a73.w(this.H0, "update");
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
                    a73.w(this.H0, "lackresources");
                    String a3 = a3(this.F0, "0049");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081104));
                    if (m3(this.F0, "0049")) {
                        textView.setVisibility(0);
                        textView.setText(X2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = a3;
                    break;
                case 6:
                    a73.w(this.H0, "outdisk");
                    String a32 = a3(this.F0, "2205");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081104));
                    if (be3.G()) {
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
                    str = getContext().getString(R.string.obfuscated_res_0x7f0f017a);
                    textView.setVisibility(8);
                    break;
            }
            TextView textView6 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090173);
            if (TextUtils.isEmpty(str)) {
                str = getContext().getString(R.string.obfuscated_res_0x7f0f12c7);
            }
            textView6.setText(str);
            Activity activity = this.i0;
            x = !(activity instanceof SwanAppErrorActivity) ? ((SwanAppErrorActivity) activity).x() : null;
            h03 b0 = h03.b0();
            if (x == null) {
                O = x.H();
            } else {
                O = b0 != null ? b0.O() : null;
            }
            forbiddenInfo = this.H0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.forbiddenDetail)) {
                textView3.setText("(" + this.H0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
                textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0603a8));
            }
            l3(textView, x);
            textView2.setOnClickListener(new b(this, x));
            if (be3.G() && !TextUtils.equals(this.F0, "type_network_error")) {
                textView4.setVisibility(0);
                textView4.setOnClickListener(new c(this, O));
            }
            z = (this.N0 == 1 || TextUtils.isEmpty(this.M0)) ? false : false;
            if (!d3() && z && nc4.d()) {
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
        TextView textView62 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090173);
        if (TextUtils.isEmpty(str)) {
        }
        textView62.setText(str);
        Activity activity2 = this.i0;
        if (!(activity2 instanceof SwanAppErrorActivity)) {
        }
        h03 b02 = h03.b0();
        if (x == null) {
        }
        forbiddenInfo = this.H0;
        if (forbiddenInfo != null) {
            textView3.setText("(" + this.H0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
            textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0603a8));
        }
        l3(textView, x);
        textView2.setOnClickListener(new b(this, x));
        if (be3.G()) {
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
            ArrayList<String> a2 = nc4.b().a();
            return a2 != null && a2.contains(this.G0);
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.nz1
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
            return forbiddenInfo != null && be3.I(forbiddenInfo.launchPath);
        }
        return invokeV.booleanValue;
    }

    public void g3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
            oj2.K().h(activity, Y2(activity));
            j.a("feedback", Z2(), this.H0);
        }
    }

    public void h3(n64 n64Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, n64Var, activity) == null) {
            oj2.K().g(activity, n64Var);
            j.a("notice", Z2(), this.H0);
        }
    }

    public void i3(n64 n64Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, n64Var, activity) == null) {
            oj2.K().b(activity, n64Var);
            j.a("notice", Z2(), this.H0);
        }
    }

    @Override // com.repackage.nz1, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) ? W2() : invokeL.booleanValue;
    }

    @Override // com.repackage.nz1
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
            xp2.j(activity);
            j.a("daynightmode", Z2(), this.H0);
        }
    }

    public void k3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, activity) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                xp2.t(activity);
            }
            j.a(Headers.REFRESH, Z2(), this.H0);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void l3(TextView textView, el2 el2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, textView, el2Var) == null) {
            if (TextUtils.equals(this.K0, "1")) {
                textView.setOnClickListener(new d(this, el2Var));
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
                textView.setText(R.string.obfuscated_res_0x7f0f12c0);
                textView.setOnClickListener(new h(this, el2Var));
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
            Map<String, String> g2 = hc4.f().g();
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo != null) {
                String str3 = forbiddenInfo.forbiddenDetail;
                if (str3.length() > 4) {
                    String substring = str3.substring(str3.length() - 4);
                    if (!TextUtils.isEmpty(hc4.l(g2, substring))) {
                        this.K0 = hc4.l(g2, substring);
                        this.L0 = hc4.n(g2, substring);
                        return !TextUtils.equals(this.K0, "0");
                    }
                }
            }
            String l = hc4.l(g2, str2);
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
            this.L0 = hc4.n(g2, str2);
            return !TextUtils.equals(this.K0, "0");
        }
        return invokeLL.booleanValue;
    }

    public final void n3() {
        m64 m64Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (m64Var = this.m0) == null) {
            return;
        }
        m64Var.s(oj2.M().a());
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            j.a(SupportMenuInflater.XML_MENU, Z2(), this.H0);
        }
    }

    @Override // com.repackage.nz1, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            m64 m64Var = this.m0;
            if (m64Var != null && m64Var.i()) {
                this.m0.B(oj2.M().a());
            }
            SwanAppActionBar swanAppActionBar = this.l0;
            if (swanAppActionBar != null) {
                fq2.o(swanAppActionBar, this.J0 + this.I0);
            }
        }
    }

    public final String p3() {
        InterceptResult invokeV;
        PMSAppInfo u;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f12bc);
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo == null) {
                return string;
            }
            String str = forbiddenInfo.appId;
            return (TextUtils.isEmpty(str) || (u = c84.i().u(str)) == null || TextUtils.isEmpty(u.statusDesc)) ? string : u.statusDesc;
        }
        return (String) invokeV.objValue;
    }

    public final void q3() {
        m64 m64Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (m64Var = this.m0) == null) {
            return;
        }
        n64 h2 = m64Var.h(46);
        n64 h3 = this.m0.h(47);
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
