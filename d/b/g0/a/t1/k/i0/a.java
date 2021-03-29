package d.b.g0.a.t1.k.i0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import d.b.g0.a.e;
import d.b.g0.a.g;
import d.b.g0.a.h;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46391f = k.f45051a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f46392g;

    /* renamed from: a  reason: collision with root package name */
    public Activity f46393a;

    /* renamed from: b  reason: collision with root package name */
    public FloatButton f46394b;

    /* renamed from: c  reason: collision with root package name */
    public String f46395c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f46396d;

    /* renamed from: e  reason: collision with root package name */
    public String f46397e = "";

    public static a d() {
        if (f46392g == null) {
            synchronized (a.class) {
                if (f46392g == null) {
                    f46392g = new a();
                }
            }
        }
        return f46392g;
    }

    public static void h() {
        if (f46392g == null) {
            return;
        }
        f46392g = null;
    }

    public final FloatButton a(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton e2 = e(context);
        viewGroup.addView(e2);
        return e2;
    }

    public void b(Intent intent) {
        if (intent == null || this.f46394b == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        String substring = dataString.substring(8);
        if (TextUtils.isEmpty(substring) || !substring.equals(this.f46397e)) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            this.f46395c = this.f46393a.getResources().getString(h.swan_app_hover_button_open);
        } else if (TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, intent.getAction())) {
            this.f46395c = this.f46393a.getResources().getString(h.swan_app_hover_button_download);
        }
        this.f46394b.setFloatButtonText(this.f46395c);
    }

    public FloatButton c() {
        return this.f46394b;
    }

    public final FloatButton e(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(g.swan_app_float_button, (ViewGroup) null);
    }

    public FloatButton f() {
        Activity activity = this.f46393a;
        if (activity instanceof SwanAppActivity) {
            if (this.f46394b == null) {
                this.f46394b = a(activity, (ViewGroup) activity.findViewById(16908290));
            }
            this.f46394b.setFloatButtonText(this.f46395c);
            this.f46394b.setFloatButtonDrawable(this.f46393a.getResources().getDrawable(e.swan_app_hover_button_shape));
            this.f46394b.setFloatButtonDefaultPosition();
            this.f46394b.setFloatButtonStyle(this.f46396d);
            this.f46394b.setVisibility(0);
            return this.f46394b;
        }
        return null;
    }

    public void g(Activity activity, JSONObject jSONObject) {
        String string;
        if (jSONObject != null) {
            if (f46391f) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.f46393a = activity;
            String optString = jSONObject.optString("name");
            this.f46397e = optString;
            if (k0.C(activity, optString)) {
                string = activity.getString(h.swan_app_hover_button_open);
            } else {
                string = activity.getString(h.swan_app_hover_button_download);
            }
            this.f46395c = string;
            this.f46396d = jSONObject.optJSONObject("style");
        }
    }

    public void i(String str) {
        this.f46397e = str;
    }

    public void j(FloatButton floatButton) {
        this.f46394b = floatButton;
    }
}
