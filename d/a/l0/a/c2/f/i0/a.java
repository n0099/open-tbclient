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
    public static final boolean f44738f = k.f46875a;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f44739g;

    /* renamed from: a  reason: collision with root package name */
    public Activity f44740a;

    /* renamed from: b  reason: collision with root package name */
    public FloatButton f44741b;

    /* renamed from: c  reason: collision with root package name */
    public String f44742c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f44743d;

    /* renamed from: e  reason: collision with root package name */
    public String f44744e = "";

    public static a d() {
        if (f44739g == null) {
            synchronized (a.class) {
                if (f44739g == null) {
                    f44739g = new a();
                }
            }
        }
        return f44739g;
    }

    public static void h() {
        if (f44739g == null) {
            return;
        }
        f44739g = null;
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
        if (intent == null || this.f44741b == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        String substring = dataString.substring(8);
        if (TextUtils.isEmpty(substring) || !substring.equals(this.f44744e)) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            this.f44742c = this.f44740a.getResources().getString(h.aiapps_tip_open_app);
        } else if (TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, intent.getAction())) {
            this.f44742c = this.f44740a.getResources().getString(h.swan_app_hover_button_download);
        }
        this.f44741b.setFloatButtonText(this.f44742c);
    }

    public FloatButton c() {
        return this.f44741b;
    }

    public final FloatButton e(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(g.swan_app_float_button, (ViewGroup) null);
    }

    public FloatButton f() {
        Activity activity = this.f44740a;
        if (activity instanceof SwanAppActivity) {
            if (this.f44741b == null) {
                this.f44741b = a(activity, (ViewGroup) activity.findViewById(16908290));
            }
            this.f44741b.setFloatButtonText(this.f44742c);
            this.f44741b.setFloatButtonDrawable(this.f44740a.getResources().getDrawable(e.swan_app_hover_button_shape));
            this.f44741b.setFloatButtonDefaultPosition();
            this.f44741b.setFloatButtonStyle(this.f44743d);
            this.f44741b.setVisibility(0);
            return this.f44741b;
        }
        return null;
    }

    public void g(Activity activity, JSONObject jSONObject) {
        String string;
        if (jSONObject != null) {
            if (f44738f) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.f44740a = activity;
            String optString = jSONObject.optString("name");
            this.f44744e = optString;
            if (q0.F(activity, optString)) {
                string = activity.getString(h.aiapps_tip_open_app);
            } else {
                string = activity.getString(h.swan_app_hover_button_download);
            }
            this.f44742c = string;
            this.f44743d = jSONObject.optJSONObject("style");
        }
    }

    public void i(String str) {
        this.f44744e = str;
    }

    public void j(FloatButton floatButton) {
        this.f44741b = floatButton;
    }
}
