package d.a.m0.a.c2.f.i0;

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
import d.a.m0.a.e;
import d.a.m0.a.g;
import d.a.m0.a.h;
import d.a.m0.a.k;
import d.a.m0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f44846f = k.f46983a;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f44847g;

    /* renamed from: a  reason: collision with root package name */
    public Activity f44848a;

    /* renamed from: b  reason: collision with root package name */
    public FloatButton f44849b;

    /* renamed from: c  reason: collision with root package name */
    public String f44850c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f44851d;

    /* renamed from: e  reason: collision with root package name */
    public String f44852e = "";

    public static a d() {
        if (f44847g == null) {
            synchronized (a.class) {
                if (f44847g == null) {
                    f44847g = new a();
                }
            }
        }
        return f44847g;
    }

    public static void h() {
        if (f44847g == null) {
            return;
        }
        f44847g = null;
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
        if (intent == null || this.f44849b == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        String substring = dataString.substring(8);
        if (TextUtils.isEmpty(substring) || !substring.equals(this.f44852e)) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            this.f44850c = this.f44848a.getResources().getString(h.aiapps_tip_open_app);
        } else if (TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, intent.getAction())) {
            this.f44850c = this.f44848a.getResources().getString(h.swan_app_hover_button_download);
        }
        this.f44849b.setFloatButtonText(this.f44850c);
    }

    public FloatButton c() {
        return this.f44849b;
    }

    public final FloatButton e(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(g.swan_app_float_button, (ViewGroup) null);
    }

    public FloatButton f() {
        Activity activity = this.f44848a;
        if (activity instanceof SwanAppActivity) {
            if (this.f44849b == null) {
                this.f44849b = a(activity, (ViewGroup) activity.findViewById(16908290));
            }
            this.f44849b.setFloatButtonText(this.f44850c);
            this.f44849b.setFloatButtonDrawable(this.f44848a.getResources().getDrawable(e.swan_app_hover_button_shape));
            this.f44849b.setFloatButtonDefaultPosition();
            this.f44849b.setFloatButtonStyle(this.f44851d);
            this.f44849b.setVisibility(0);
            return this.f44849b;
        }
        return null;
    }

    public void g(Activity activity, JSONObject jSONObject) {
        String string;
        if (jSONObject != null) {
            if (f44846f) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.f44848a = activity;
            String optString = jSONObject.optString("name");
            this.f44852e = optString;
            if (q0.F(activity, optString)) {
                string = activity.getString(h.aiapps_tip_open_app);
            } else {
                string = activity.getString(h.swan_app_hover_button_download);
            }
            this.f44850c = string;
            this.f44851d = jSONObject.optJSONObject("style");
        }
    }

    public void i(String str) {
        this.f44852e = str;
    }

    public void j(FloatButton floatButton) {
        this.f44849b = floatButton;
    }
}
