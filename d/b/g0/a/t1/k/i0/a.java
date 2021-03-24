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
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46390f = k.f45050a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f46391g;

    /* renamed from: a  reason: collision with root package name */
    public Activity f46392a;

    /* renamed from: b  reason: collision with root package name */
    public FloatButton f46393b;

    /* renamed from: c  reason: collision with root package name */
    public String f46394c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f46395d;

    /* renamed from: e  reason: collision with root package name */
    public String f46396e = "";

    public static a d() {
        if (f46391g == null) {
            synchronized (a.class) {
                if (f46391g == null) {
                    f46391g = new a();
                }
            }
        }
        return f46391g;
    }

    public static void h() {
        if (f46391g == null) {
            return;
        }
        f46391g = null;
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
        if (intent == null || this.f46393b == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        String substring = dataString.substring(8);
        if (TextUtils.isEmpty(substring) || !substring.equals(this.f46396e)) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            this.f46394c = this.f46392a.getResources().getString(h.swan_app_hover_button_open);
        } else if (TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, intent.getAction())) {
            this.f46394c = this.f46392a.getResources().getString(h.swan_app_hover_button_download);
        }
        this.f46393b.setFloatButtonText(this.f46394c);
    }

    public FloatButton c() {
        return this.f46393b;
    }

    public final FloatButton e(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(g.swan_app_float_button, (ViewGroup) null);
    }

    public FloatButton f() {
        Activity activity = this.f46392a;
        if (activity instanceof SwanAppActivity) {
            if (this.f46393b == null) {
                this.f46393b = a(activity, (ViewGroup) activity.findViewById(16908290));
            }
            this.f46393b.setFloatButtonText(this.f46394c);
            this.f46393b.setFloatButtonDrawable(this.f46392a.getResources().getDrawable(e.swan_app_hover_button_shape));
            this.f46393b.setFloatButtonDefaultPosition();
            this.f46393b.setFloatButtonStyle(this.f46395d);
            this.f46393b.setVisibility(0);
            return this.f46393b;
        }
        return null;
    }

    public void g(Activity activity, JSONObject jSONObject) {
        String string;
        if (jSONObject != null) {
            if (f46390f) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.f46392a = activity;
            String optString = jSONObject.optString("name");
            this.f46396e = optString;
            if (k0.C(activity, optString)) {
                string = activity.getString(h.swan_app_hover_button_open);
            } else {
                string = activity.getString(h.swan_app_hover_button_download);
            }
            this.f46394c = string;
            this.f46395d = jSONObject.optJSONObject("style");
        }
    }

    public void i(String str) {
        this.f46396e = str;
    }

    public void j(FloatButton floatButton) {
        this.f46393b = floatButton;
    }
}
