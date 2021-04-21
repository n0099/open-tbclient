package d.b.h0.a.t1.k.i0;

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
import d.b.h0.a.e;
import d.b.h0.a.g;
import d.b.h0.a.h;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47112f = k.f45772a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f47113g;

    /* renamed from: a  reason: collision with root package name */
    public Activity f47114a;

    /* renamed from: b  reason: collision with root package name */
    public FloatButton f47115b;

    /* renamed from: c  reason: collision with root package name */
    public String f47116c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f47117d;

    /* renamed from: e  reason: collision with root package name */
    public String f47118e = "";

    public static a d() {
        if (f47113g == null) {
            synchronized (a.class) {
                if (f47113g == null) {
                    f47113g = new a();
                }
            }
        }
        return f47113g;
    }

    public static void h() {
        if (f47113g == null) {
            return;
        }
        f47113g = null;
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
        if (intent == null || this.f47115b == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        String substring = dataString.substring(8);
        if (TextUtils.isEmpty(substring) || !substring.equals(this.f47118e)) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            this.f47116c = this.f47114a.getResources().getString(h.swan_app_hover_button_open);
        } else if (TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, intent.getAction())) {
            this.f47116c = this.f47114a.getResources().getString(h.swan_app_hover_button_download);
        }
        this.f47115b.setFloatButtonText(this.f47116c);
    }

    public FloatButton c() {
        return this.f47115b;
    }

    public final FloatButton e(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(g.swan_app_float_button, (ViewGroup) null);
    }

    public FloatButton f() {
        Activity activity = this.f47114a;
        if (activity instanceof SwanAppActivity) {
            if (this.f47115b == null) {
                this.f47115b = a(activity, (ViewGroup) activity.findViewById(16908290));
            }
            this.f47115b.setFloatButtonText(this.f47116c);
            this.f47115b.setFloatButtonDrawable(this.f47114a.getResources().getDrawable(e.swan_app_hover_button_shape));
            this.f47115b.setFloatButtonDefaultPosition();
            this.f47115b.setFloatButtonStyle(this.f47117d);
            this.f47115b.setVisibility(0);
            return this.f47115b;
        }
        return null;
    }

    public void g(Activity activity, JSONObject jSONObject) {
        String string;
        if (jSONObject != null) {
            if (f47112f) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.f47114a = activity;
            String optString = jSONObject.optString("name");
            this.f47118e = optString;
            if (k0.C(activity, optString)) {
                string = activity.getString(h.swan_app_hover_button_open);
            } else {
                string = activity.getString(h.swan_app_hover_button_download);
            }
            this.f47116c = string;
            this.f47117d = jSONObject.optJSONObject("style");
        }
    }

    public void i(String str) {
        this.f47118e = str;
    }

    public void j(FloatButton floatButton) {
        this.f47115b = floatButton;
    }
}
