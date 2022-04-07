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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xz1;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qz1 extends pz1 {
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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz1 a;

        public a(qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz1Var;
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

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gl2 a;
        public final /* synthetic */ qz1 b;

        public b(qz1 qz1Var, gl2 gl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var, gl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz1Var;
            this.a = gl2Var;
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

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ qz1 b;

        public c(qz1 qz1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz1Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.H0 == null || TextUtils.isEmpty(this.b.H0.forbiddenDetail)) {
                return;
            }
            qj2.u().b(this.b.getActivity(), this.a, this.b.H0.appTitle, this.b.H0.forbiddenDetail);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gl2 a;
        public final /* synthetic */ qz1 b;

        public d(qz1 qz1Var, gl2 gl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var, gl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz1Var;
            this.a = gl2Var;
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

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz1 a;

        public e(qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || TextUtils.isEmpty(this.a.L0)) {
                return;
            }
            Activity activity = this.a.i0;
            if (activity instanceof FragmentActivity) {
                ee4 supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                xz1.d a3 = xz1.a3(this.a.L0);
                a3.a(false);
                a3.c(supportFragmentManager);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz1 a;

        public f(qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FragmentActivity activity = this.a.getActivity();
                if (!(activity instanceof SwanAppClearCacheErrorActivity)) {
                    if (pz1.E0) {
                        throw new IllegalStateException("非SwanAppClearCacheErrorActivity");
                    }
                    return;
                }
                ((SwanAppClearCacheErrorActivity) activity).markHasGotoClearCache();
                try {
                    this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("baiduboxapp://v16/ucenter/cleanCache")));
                } catch (Exception e) {
                    jx1.l("SwanAppErrorFragment", "打开清理缓存界面失败", e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz1 a;

        public g(qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.O1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gl2 a;
        public final /* synthetic */ qz1 b;

        public h(qz1 qz1Var, gl2 gl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var, gl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz1Var;
            this.a = gl2Var;
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

    /* loaded from: classes7.dex */
    public class i implements o64 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ qz1 b;

        public i(qz1 qz1Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz1Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz1Var;
            this.a = activity;
        }

        @Override // com.repackage.o64
        public boolean b(View view2, q64 q64Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, q64Var)) == null) {
                int c = q64Var.c();
                if (c == 5) {
                    this.b.i3(this.a);
                } else if (c == 9) {
                    this.b.f3(this.a);
                    return true;
                } else if (c == 39) {
                    this.b.j3(this.a);
                } else if (c == 46) {
                    this.b.g3(q64Var, this.a);
                } else if (c == 47) {
                    this.b.h3(q64Var, this.a);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l73 a;

            public a(l73 l73Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l73Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = l73Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    q63.i("934", "85", this.a.f());
                }
            }
        }

        public static void a(String str, gl2 gl2Var, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65536, null, str, gl2Var, forbiddenInfo) == null) {
                l73 l73Var = new l73();
                l73Var.f = forbiddenInfo.appId;
                l73Var.g = "errormenu";
                l73Var.b = "click";
                l73Var.e = str;
                l73Var.c = forbiddenInfo.launchSource;
                l73Var.b(c73.k(gl2Var.W()));
                l73Var.d(gl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                dd3.j(new a(l73Var), "SwanAppFuncClickUBC");
            }
        }
    }

    public qz1() {
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

    public static qz1 e3(String str, String str2, String str3, int i2, ForbiddenInfo forbiddenInfo, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Integer.valueOf(i2), forbiddenInfo, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            qz1 qz1Var = new qz1();
            Bundle bundle = new Bundle();
            bundle.putString(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, str2);
            bundle.putString(SwanAppErrorActivity.KEY_SWAN_ERROR_CODE, str);
            bundle.putString("webUrl", str3);
            bundle.putInt(SwanAppErrorActivity.KEY_SWAN_WEB_PERMIT, i2);
            bundle.putParcelable("key_forbidden_info", forbiddenInfo);
            bundle.putInt("key_show_menu_notice", i3);
            bundle.putInt("key_show_menu_privacy", i4);
            qz1Var.i1(bundle);
            return qz1Var;
        }
        return (qz1) invokeCommon.objValue;
    }

    @Override // com.repackage.pz1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.pz1
    public void T1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.T1(view2);
            U1(view2);
            s2(-1);
            B2(-16777216);
            w2(false);
            I2(true);
            this.l0.setRightExitOnClickListener(new a(this));
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo == null || TextUtils.isEmpty(forbiddenInfo.appTitle)) {
                return;
            }
            u2(this.H0.appTitle);
        }
    }

    public final boolean V2() {
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

    public final CharSequence W2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            Map<String, String> g2 = kc4.f().g();
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo != null) {
                String str2 = forbiddenInfo.forbiddenDetail;
                if (str2.length() > 4) {
                    String m = kc4.m(g2, str2.substring(str2.length() - 4));
                    if (!TextUtils.isEmpty(m)) {
                        return m;
                    }
                }
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1242268664:
                    if (str.equals(SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -429452284:
                    if (str.equals(SwanAppErrorActivity.TYPE_PATH_FORBIDDEN)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 38398066:
                    if (str.equals(SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 517286506:
                    if (str.equals(SwanAppErrorActivity.TYPE_MEMORY_LACK)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 517347882:
                    if (str.equals(SwanAppErrorActivity.TYPE_DISK_LACK)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 731215244:
                    if (str.equals(SwanAppErrorActivity.TYPE_NORMAL)) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                String m2 = kc4.m(g2, "net_conn_failed");
                return TextUtils.isEmpty(m2) ? O(R.string.obfuscated_res_0x7f0f1288) : m2;
            } else if (c2 == 1) {
                String m3 = kc4.m(g2, "app_open_failed");
                return TextUtils.isEmpty(m3) ? O(R.string.obfuscated_res_0x7f0f1288) : m3;
            } else if (c2 == 2) {
                String m4 = kc4.m(g2, "app_need_upgrade");
                return TextUtils.isEmpty(m4) ? O(R.string.obfuscated_res_0x7f0f1288) : m4;
            } else if (c2 == 3) {
                String m5 = kc4.m(g2, "app_page_banned");
                return TextUtils.isEmpty(m5) ? O(R.string.obfuscated_res_0x7f0f1287) : m5;
            } else if (c2 == 4) {
                String m6 = kc4.m(g2, "0049");
                return TextUtils.isEmpty(m6) ? O(R.string.obfuscated_res_0x7f0f1288) : m6;
            } else if (c2 != 5) {
                return "";
            } else {
                String m7 = kc4.m(g2, "2205");
                return TextUtils.isEmpty(m7) ? O(R.string.obfuscated_res_0x7f0f1286) : m7;
            }
        }
        return (CharSequence) invokeL.objValue;
    }

    public final JSONObject X2(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                ForbiddenInfo forbiddenInfo = ((SwanAppErrorActivity) activity).getForbiddenInfo();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("title", forbiddenInfo.appTitle);
                    jSONObject.put("url", forbiddenInfo.launchPath);
                    jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, forbiddenInfo.appId);
                    jSONObject.put("errorPath", forbiddenInfo.launchPath);
                    jSONObject.put("errorDes", forbiddenInfo.forbiddenReason);
                } catch (JSONException e2) {
                    if (pz1.E0) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final gl2 Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getActivity() == null || !(getActivity() instanceof SwanAppErrorActivity)) {
                return null;
            }
            return ((SwanAppErrorActivity) getActivity()).getLaunchInfo();
        }
        return (gl2) invokeV.objValue;
    }

    public final String Z2(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            String str3 = "";
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1242268664:
                        if (str.equals(SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -429452284:
                        if (str.equals(SwanAppErrorActivity.TYPE_PATH_FORBIDDEN)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 38398066:
                        if (str.equals(SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 517286506:
                        if (str.equals(SwanAppErrorActivity.TYPE_MEMORY_LACK)) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 517347882:
                        if (str.equals(SwanAppErrorActivity.TYPE_DISK_LACK)) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 731215244:
                        if (str.equals(SwanAppErrorActivity.TYPE_NORMAL)) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f12e5);
                } else if (c2 == 1) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f128f);
                } else if (c2 == 2) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f128d);
                } else if (c2 == 3) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f1290);
                } else if (c2 == 4) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f128c);
                } else if (c2 == 5) {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f1289);
                }
                Map<String, String> g2 = kc4.f().g();
                if (g2 != null) {
                    ForbiddenInfo forbiddenInfo = this.H0;
                    if (forbiddenInfo != null) {
                        String str4 = forbiddenInfo.forbiddenDetail;
                        if (str4.length() > 4) {
                            String o = kc4.o(g2, str4.substring(str4.length() - 4));
                            if (!TextUtils.isEmpty(o)) {
                                return o;
                            }
                        }
                    }
                    String o2 = kc4.o(g2, str2);
                    if (!TextUtils.isEmpty(o2)) {
                        return o2;
                    }
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public void a3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (activity = getActivity()) != null && this.m0 == null) {
            p64 p64Var = new p64(activity, this.l0, 19, qj2.K(), new sf3());
            this.m0 = p64Var;
            p64Var.o(new i(this, activity));
            p3();
        }
    }

    @Override // com.repackage.pz1
    public boolean b2() {
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
    public void b3(View view2) {
        String str;
        gl2 launchInfo;
        String N;
        ForbiddenInfo forbiddenInfo;
        String o3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view2) == null) || view2 == null) {
            return;
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09017d);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017a);
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090188);
        TextView textView3 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090180);
        TextView textView4 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017c);
        TextView textView5 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017b);
        String str2 = this.F0;
        boolean z = true;
        if (str2 != null) {
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1869797338:
                    if (str2.equals(SwanAppErrorActivity.TYPE_LOAD_V8_FAILED)) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -1242268664:
                    if (str2.equals(SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -429452284:
                    if (str2.equals(SwanAppErrorActivity.TYPE_PATH_FORBIDDEN)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 38398066:
                    if (str2.equals(SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 157273878:
                    if (str2.equals(SwanAppErrorActivity.TYPE_APP_FORBIDDEN)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 517286506:
                    if (str2.equals(SwanAppErrorActivity.TYPE_MEMORY_LACK)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 517347882:
                    if (str2.equals(SwanAppErrorActivity.TYPE_DISK_LACK)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 731215244:
                    if (str2.equals(SwanAppErrorActivity.TYPE_NORMAL)) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    c73.w(this.H0, "offline");
                    o3 = o3();
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f08116b));
                    textView.setVisibility(8);
                    str = o3;
                    break;
                case 1:
                    c73.w(this.H0, "pageblock");
                    o3 = TextUtils.isEmpty(this.H0.forbiddenInformation) ? getContext().getString(R.string.obfuscated_res_0x7f0f1290) : this.H0.forbiddenInformation;
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081168));
                    if (l3(this.F0, "app_page_banned")) {
                        textView.setVisibility(0);
                        textView.setText(W2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    if (d3()) {
                        textView.setVisibility(8);
                    }
                    str = o3;
                    break;
                case 2:
                    c73.w(this.H0, "neterror");
                    o3 = Z2(this.F0, "net_conn_failed");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f08116a));
                    if (l3(this.F0, "net_conn_failed")) {
                        textView.setVisibility(0);
                        textView.setText(W2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    textView3.setVisibility(8);
                    str = o3;
                    break;
                case 3:
                    c73.w(this.H0, "commonerror");
                    o3 = Z2(this.F0, "app_open_failed");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081169));
                    if (l3(this.F0, "app_open_failed")) {
                        textView.setVisibility(0);
                        textView.setText(W2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = o3;
                    break;
                case 4:
                    c73.w(this.H0, "update");
                    str = Z2(this.F0, "app_need_upgrade");
                    if (l3(this.F0, "app_need_upgrade")) {
                        textView.setVisibility(0);
                        textView.setText(W2(this.F0));
                        break;
                    } else {
                        textView.setVisibility(8);
                        break;
                    }
                case 5:
                    c73.w(this.H0, "lackresources");
                    String Z2 = Z2(this.F0, "0049");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081167));
                    if (l3(this.F0, "0049")) {
                        textView.setVisibility(0);
                        textView.setText(W2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = Z2;
                    break;
                case 6:
                    c73.w(this.H0, "outdisk");
                    String Z22 = Z2(this.F0, "2205");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081167));
                    if (de3.G()) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    if (l3(this.F0, "2205")) {
                        textView.setVisibility(0);
                        textView.setText(W2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = Z22;
                    break;
                case 7:
                    str = getContext().getString(R.string.obfuscated_res_0x7f0f0175);
                    textView.setVisibility(8);
                    break;
            }
            TextView textView6 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017f);
            if (TextUtils.isEmpty(str)) {
                str = getContext().getString(R.string.obfuscated_res_0x7f0f128f);
            }
            textView6.setText(str);
            Activity activity = this.i0;
            launchInfo = !(activity instanceof SwanAppErrorActivity) ? ((SwanAppErrorActivity) activity).getLaunchInfo() : null;
            j03 a0 = j03.a0();
            if (launchInfo == null) {
                N = launchInfo.H();
            } else {
                N = a0 != null ? a0.N() : null;
            }
            forbiddenInfo = this.H0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.forbiddenDetail)) {
                textView3.setText("(" + this.H0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
                textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0603a2));
            }
            k3(textView, launchInfo);
            textView2.setOnClickListener(new b(this, launchInfo));
            if (de3.G() && !TextUtils.equals(this.F0, SwanAppErrorActivity.TYPE_NETWORK_ERROR)) {
                textView4.setVisibility(0);
                textView4.setOnClickListener(new c(this, N));
            }
            z = (this.N0 == 1 || TextUtils.isEmpty(this.M0)) ? false : false;
            if (!c3() && z && qc4.d()) {
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
        TextView textView62 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017f);
        if (TextUtils.isEmpty(str)) {
        }
        textView62.setText(str);
        Activity activity2 = this.i0;
        if (!(activity2 instanceof SwanAppErrorActivity)) {
        }
        j03 a02 = j03.a0();
        if (launchInfo == null) {
        }
        forbiddenInfo = this.H0;
        if (forbiddenInfo != null) {
            textView3.setText("(" + this.H0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
            textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0603a2));
        }
        k3(textView, launchInfo);
        textView2.setOnClickListener(new b(this, launchInfo));
        if (de3.G()) {
            textView4.setVisibility(0);
            textView4.setOnClickListener(new c(this, N));
        }
        if (this.N0 == 1) {
        }
        if (!c3()) {
        }
        textView5.setVisibility(8);
        textView2.setVisibility(8);
        textView4.setVisibility(0);
    }

    public final boolean c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList<String> a2 = qc4.b().a();
            return a2 != null && a2.contains(this.G0);
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.pz1
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.H0;
            return forbiddenInfo != null && de3.I(forbiddenInfo.launchPath);
        }
        return invokeV.booleanValue;
    }

    public void f3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
            qj2.K().h(activity, X2(activity));
            j.a("feedback", Y2(), this.H0);
        }
    }

    public void g3(q64 q64Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, q64Var, activity) == null) {
            qj2.K().g(activity, q64Var);
            j.a("notice", Y2(), this.H0);
        }
    }

    public void h3(q64 q64Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, q64Var, activity) == null) {
            qj2.K().b(activity, q64Var);
            j.a("notice", Y2(), this.H0);
        }
    }

    @Override // com.repackage.pz1
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a3();
            m3();
            p3();
            n3();
        }
    }

    public void i3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, activity) == null) {
            zp2.j(activity);
            j.a("daynightmode", Y2(), this.H0);
        }
    }

    @Override // com.repackage.pz1, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) ? V2() : invokeL.booleanValue;
    }

    public void j3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, activity) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                zp2.t(activity);
            }
            j.a(Headers.REFRESH, Y2(), this.H0);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void k3(TextView textView, gl2 gl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, textView, gl2Var) == null) {
            if (TextUtils.equals(this.K0, "1")) {
                textView.setOnClickListener(new d(this, gl2Var));
            } else if (TextUtils.equals(this.K0, "2")) {
                textView.setOnClickListener(new e(this));
            } else if (TextUtils.equals(this.K0, "3")) {
                textView.setOnClickListener(new f(this));
            } else if (TextUtils.equals(this.K0, "4")) {
                if (d3()) {
                    textView.setVisibility(8);
                } else {
                    textView.setOnClickListener(new g(this));
                }
            } else {
                textView.setText(R.string.obfuscated_res_0x7f0f1288);
                textView.setOnClickListener(new h(this, gl2Var));
            }
        }
    }

    public final boolean l3(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            Map<String, String> g2 = kc4.f().g();
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo != null) {
                String str3 = forbiddenInfo.forbiddenDetail;
                if (str3.length() > 4) {
                    String substring = str3.substring(str3.length() - 4);
                    if (!TextUtils.isEmpty(kc4.l(g2, substring))) {
                        this.K0 = kc4.l(g2, substring);
                        this.L0 = kc4.n(g2, substring);
                        return !TextUtils.equals(this.K0, "0");
                    }
                }
            }
            String l = kc4.l(g2, str2);
            this.K0 = l;
            if (TextUtils.isEmpty(l)) {
                if (TextUtils.equals(str, SwanAppErrorActivity.TYPE_PATH_FORBIDDEN)) {
                    this.K0 = "4";
                } else if (TextUtils.equals(str, SwanAppErrorActivity.TYPE_DISK_LACK)) {
                    this.K0 = "3";
                } else if (TextUtils.equals(str, SwanAppErrorActivity.TYPE_APP_FORBIDDEN)) {
                    this.K0 = "0";
                } else if (TextUtils.equals(str, SwanAppErrorActivity.TYPE_LOAD_V8_FAILED)) {
                    this.K0 = "0";
                } else {
                    this.K0 = "1";
                }
            }
            this.L0 = kc4.n(g2, str2);
            return !TextUtils.equals(this.K0, "0");
        }
        return invokeLL.booleanValue;
    }

    public final void m3() {
        p64 p64Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (p64Var = this.m0) == null) {
            return;
        }
        p64Var.s(qj2.M().a());
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            j.a(SupportMenuInflater.XML_MENU, Y2(), this.H0);
        }
    }

    public final String o3() {
        InterceptResult invokeV;
        PMSAppInfo u;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f1284);
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo == null) {
                return string;
            }
            String str = forbiddenInfo.appId;
            return (TextUtils.isEmpty(str) || (u = f84.i().u(str)) == null || TextUtils.isEmpty(u.statusDesc)) ? string : u.statusDesc;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.pz1, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onResume();
            p64 p64Var = this.m0;
            if (p64Var != null && p64Var.j()) {
                this.m0.C(qj2.M().a());
            }
            SwanAppActionBar swanAppActionBar = this.l0;
            if (swanAppActionBar != null) {
                hq2.o(swanAppActionBar, this.J0 + this.I0);
            }
        }
    }

    public final void p3() {
        p64 p64Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (p64Var = this.m0) == null) {
            return;
        }
        q64 i2 = p64Var.i(46);
        q64 i3 = this.m0.i(47);
        if (i2 != null && this.I0 > 0) {
            i3.o(1);
            i3.n(this.I0);
        }
        if (i3 == null || this.J0 <= 0) {
            return;
        }
        i3.o(1);
        i3.n(this.J0);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            super.v0(bundle);
            Bundle p = p();
            if (p == null) {
                return;
            }
            this.F0 = p.getString(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE);
            this.G0 = p.getString(SwanAppErrorActivity.KEY_SWAN_ERROR_CODE);
            this.M0 = p.getString("webUrl");
            this.N0 = p.getInt(SwanAppErrorActivity.KEY_SWAN_WEB_PERMIT);
            this.H0 = (ForbiddenInfo) p.getParcelable("key_forbidden_info");
            this.I0 = p.getInt("key_show_menu_notice");
            this.J0 = p.getInt("key_show_menu_privacy");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00a8, viewGroup, false);
            b3(inflate);
            T1(inflate);
            return S1() ? V1(inflate) : inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
