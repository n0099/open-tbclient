package d.a.l0.a.c2.f.i0;

import android.annotation.SuppressLint;
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
import d.a.l0.a.e;
import d.a.l0.a.g;
import d.a.l0.a.h;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f41062f = k.f43199a;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f41063g;

    /* renamed from: a  reason: collision with root package name */
    public Activity f41064a;

    /* renamed from: b  reason: collision with root package name */
    public FloatButton f41065b;

    /* renamed from: c  reason: collision with root package name */
    public String f41066c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f41067d;

    /* renamed from: e  reason: collision with root package name */
    public String f41068e = "";

    public static a d() {
        if (f41063g == null) {
            synchronized (a.class) {
                if (f41063g == null) {
                    f41063g = new a();
                }
            }
        }
        return f41063g;
    }

    public static void h() {
        if (f41063g == null) {
            return;
        }
        f41063g = null;
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
        if (intent == null || this.f41065b == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        String substring = dataString.substring(8);
        if (TextUtils.isEmpty(substring) || !substring.equals(this.f41068e)) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            this.f41066c = this.f41064a.getResources().getString(h.aiapps_tip_open_app);
        } else if (TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, intent.getAction())) {
            this.f41066c = this.f41064a.getResources().getString(h.swan_app_hover_button_download);
        }
        this.f41065b.setFloatButtonText(this.f41066c);
    }

    public FloatButton c() {
        return this.f41065b;
    }

    public final FloatButton e(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(g.swan_app_float_button, (ViewGroup) null);
    }

    public FloatButton f() {
        Activity activity = this.f41064a;
        if (activity instanceof SwanAppActivity) {
            if (this.f41065b == null) {
                this.f41065b = a(activity, (ViewGroup) activity.findViewById(16908290));
            }
            this.f41065b.setFloatButtonText(this.f41066c);
            this.f41065b.setFloatButtonDrawable(this.f41064a.getResources().getDrawable(e.swan_app_hover_button_shape));
            this.f41065b.setFloatButtonDefaultPosition();
            this.f41065b.setFloatButtonStyle(this.f41067d);
            this.f41065b.setVisibility(0);
            return this.f41065b;
        }
        return null;
    }

    public void g(Activity activity, JSONObject jSONObject) {
        String string;
        if (jSONObject != null) {
            if (f41062f) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.f41064a = activity;
            String optString = jSONObject.optString("name");
            this.f41068e = optString;
            if (q0.F(activity, optString)) {
                string = activity.getString(h.aiapps_tip_open_app);
            } else {
                string = activity.getString(h.swan_app_hover_button_download);
            }
            this.f41066c = string;
            this.f41067d = jSONObject.optJSONObject("style");
        }
    }

    public void i(String str) {
        this.f41068e = str;
    }

    public void j(FloatButton floatButton) {
        this.f41065b = floatButton;
    }
}
