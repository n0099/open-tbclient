package d.a.n0.a.c2.f.i0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.e;
import d.a.n0.a.g;
import d.a.n0.a.h;
import d.a.n0.a.k;
import d.a.n0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f43694f;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f43695g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f43696a;

    /* renamed from: b  reason: collision with root package name */
    public FloatButton f43697b;

    /* renamed from: c  reason: collision with root package name */
    public String f43698c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f43699d;

    /* renamed from: e  reason: collision with root package name */
    public String f43700e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(363368655, "Ld/a/n0/a/c2/f/i0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(363368655, "Ld/a/n0/a/c2/f/i0/a;");
                return;
            }
        }
        f43694f = k.f45831a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43700e = "";
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f43695g == null) {
                synchronized (a.class) {
                    if (f43695g == null) {
                        f43695g = new a();
                    }
                }
            }
            return f43695g;
        }
        return (a) invokeV.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || f43695g == null) {
            return;
        }
        f43695g = null;
    }

    public final FloatButton a(Context context, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, viewGroup)) == null) {
            if (context == null || viewGroup == null) {
                return null;
            }
            FloatButton e2 = e(context);
            viewGroup.addView(e2);
            return e2;
        }
        return (FloatButton) invokeLL.objValue;
    }

    public void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) || intent == null || this.f43697b == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        String substring = dataString.substring(8);
        if (TextUtils.isEmpty(substring) || !substring.equals(this.f43700e)) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            this.f43698c = this.f43696a.getResources().getString(h.aiapps_tip_open_app);
        } else if (TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, intent.getAction())) {
            this.f43698c = this.f43696a.getResources().getString(h.swan_app_hover_button_download);
        }
        this.f43697b.setFloatButtonText(this.f43698c);
    }

    public FloatButton c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43697b : (FloatButton) invokeV.objValue;
    }

    public final FloatButton e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (context == null) {
                return null;
            }
            return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(g.swan_app_float_button, (ViewGroup) null);
        }
        return (FloatButton) invokeL.objValue;
    }

    public FloatButton f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Activity activity = this.f43696a;
            if (activity instanceof SwanAppActivity) {
                if (this.f43697b == null) {
                    this.f43697b = a(activity, (ViewGroup) activity.findViewById(16908290));
                }
                this.f43697b.setFloatButtonText(this.f43698c);
                this.f43697b.setFloatButtonDrawable(this.f43696a.getResources().getDrawable(e.swan_app_hover_button_shape));
                this.f43697b.setFloatButtonDefaultPosition();
                this.f43697b.setFloatButtonStyle(this.f43699d);
                this.f43697b.setVisibility(0);
                return this.f43697b;
            }
            return null;
        }
        return (FloatButton) invokeV.objValue;
    }

    public void g(Activity activity, JSONObject jSONObject) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, activity, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (f43694f) {
            Log.i("FloatButtonGuideManager", jSONObject.toString());
        }
        this.f43696a = activity;
        String optString = jSONObject.optString("name");
        this.f43700e = optString;
        if (q0.F(activity, optString)) {
            string = activity.getString(h.aiapps_tip_open_app);
        } else {
            string = activity.getString(h.swan_app_hover_button_download);
        }
        this.f43698c = string;
        this.f43699d = jSONObject.optJSONObject("style");
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f43700e = str;
        }
    }

    public void j(FloatButton floatButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, floatButton) == null) {
            this.f43697b = floatButton;
        }
    }
}
