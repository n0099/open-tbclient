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
    public static final boolean f46783f = k.f45443a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f46784g;

    /* renamed from: a  reason: collision with root package name */
    public Activity f46785a;

    /* renamed from: b  reason: collision with root package name */
    public FloatButton f46786b;

    /* renamed from: c  reason: collision with root package name */
    public String f46787c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f46788d;

    /* renamed from: e  reason: collision with root package name */
    public String f46789e = "";

    public static a d() {
        if (f46784g == null) {
            synchronized (a.class) {
                if (f46784g == null) {
                    f46784g = new a();
                }
            }
        }
        return f46784g;
    }

    public static void h() {
        if (f46784g == null) {
            return;
        }
        f46784g = null;
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
        if (intent == null || this.f46786b == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        String substring = dataString.substring(8);
        if (TextUtils.isEmpty(substring) || !substring.equals(this.f46789e)) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            this.f46787c = this.f46785a.getResources().getString(h.swan_app_hover_button_open);
        } else if (TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, intent.getAction())) {
            this.f46787c = this.f46785a.getResources().getString(h.swan_app_hover_button_download);
        }
        this.f46786b.setFloatButtonText(this.f46787c);
    }

    public FloatButton c() {
        return this.f46786b;
    }

    public final FloatButton e(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(g.swan_app_float_button, (ViewGroup) null);
    }

    public FloatButton f() {
        Activity activity = this.f46785a;
        if (activity instanceof SwanAppActivity) {
            if (this.f46786b == null) {
                this.f46786b = a(activity, (ViewGroup) activity.findViewById(16908290));
            }
            this.f46786b.setFloatButtonText(this.f46787c);
            this.f46786b.setFloatButtonDrawable(this.f46785a.getResources().getDrawable(e.swan_app_hover_button_shape));
            this.f46786b.setFloatButtonDefaultPosition();
            this.f46786b.setFloatButtonStyle(this.f46788d);
            this.f46786b.setVisibility(0);
            return this.f46786b;
        }
        return null;
    }

    public void g(Activity activity, JSONObject jSONObject) {
        String string;
        if (jSONObject != null) {
            if (f46783f) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.f46785a = activity;
            String optString = jSONObject.optString("name");
            this.f46789e = optString;
            if (k0.C(activity, optString)) {
                string = activity.getString(h.swan_app_hover_button_open);
            } else {
                string = activity.getString(h.swan_app_hover_button_download);
            }
            this.f46787c = string;
            this.f46788d = jSONObject.optJSONObject("style");
        }
    }

    public void i(String str) {
        this.f46789e = str;
    }

    public void j(FloatButton floatButton) {
        this.f46786b = floatButton;
    }
}
