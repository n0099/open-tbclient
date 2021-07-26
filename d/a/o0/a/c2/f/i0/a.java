package d.a.o0.a.c2.f.i0;

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
import d.a.o0.a.e;
import d.a.o0.a.g;
import d.a.o0.a.h;
import d.a.o0.a.k;
import d.a.o0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f44198f;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f44199g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f44200a;

    /* renamed from: b  reason: collision with root package name */
    public FloatButton f44201b;

    /* renamed from: c  reason: collision with root package name */
    public String f44202c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f44203d;

    /* renamed from: e  reason: collision with root package name */
    public String f44204e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1870920464, "Ld/a/o0/a/c2/f/i0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1870920464, "Ld/a/o0/a/c2/f/i0/a;");
                return;
            }
        }
        f44198f = k.f46335a;
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
        this.f44204e = "";
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f44199g == null) {
                synchronized (a.class) {
                    if (f44199g == null) {
                        f44199g = new a();
                    }
                }
            }
            return f44199g;
        }
        return (a) invokeV.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || f44199g == null) {
            return;
        }
        f44199g = null;
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) || intent == null || this.f44201b == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        String substring = dataString.substring(8);
        if (TextUtils.isEmpty(substring) || !substring.equals(this.f44204e)) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            this.f44202c = this.f44200a.getResources().getString(h.aiapps_tip_open_app);
        } else if (TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, intent.getAction())) {
            this.f44202c = this.f44200a.getResources().getString(h.swan_app_hover_button_download);
        }
        this.f44201b.setFloatButtonText(this.f44202c);
    }

    public FloatButton c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44201b : (FloatButton) invokeV.objValue;
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
            Activity activity = this.f44200a;
            if (activity instanceof SwanAppActivity) {
                if (this.f44201b == null) {
                    this.f44201b = a(activity, (ViewGroup) activity.findViewById(16908290));
                }
                this.f44201b.setFloatButtonText(this.f44202c);
                this.f44201b.setFloatButtonDrawable(this.f44200a.getResources().getDrawable(e.swan_app_hover_button_shape));
                this.f44201b.setFloatButtonDefaultPosition();
                this.f44201b.setFloatButtonStyle(this.f44203d);
                this.f44201b.setVisibility(0);
                return this.f44201b;
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
        if (f44198f) {
            Log.i("FloatButtonGuideManager", jSONObject.toString());
        }
        this.f44200a = activity;
        String optString = jSONObject.optString("name");
        this.f44204e = optString;
        if (q0.F(activity, optString)) {
            string = activity.getString(h.aiapps_tip_open_app);
        } else {
            string = activity.getString(h.swan_app_hover_button_download);
        }
        this.f44202c = string;
        this.f44203d = jSONObject.optJSONObject("style");
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f44204e = str;
        }
    }

    public void j(FloatButton floatButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, floatButton) == null) {
            this.f44201b = floatButton;
        }
    }
}
