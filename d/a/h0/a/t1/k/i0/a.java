package d.a.h0.a.t1.k.i0;

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
import d.a.h0.a.e;
import d.a.h0.a.g;
import d.a.h0.a.h;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f44507f = k.f43101a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f44508g;

    /* renamed from: a  reason: collision with root package name */
    public Activity f44509a;

    /* renamed from: b  reason: collision with root package name */
    public FloatButton f44510b;

    /* renamed from: c  reason: collision with root package name */
    public String f44511c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f44512d;

    /* renamed from: e  reason: collision with root package name */
    public String f44513e = "";

    public static a d() {
        if (f44508g == null) {
            synchronized (a.class) {
                if (f44508g == null) {
                    f44508g = new a();
                }
            }
        }
        return f44508g;
    }

    public static void h() {
        if (f44508g == null) {
            return;
        }
        f44508g = null;
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
        if (intent == null || this.f44510b == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        String substring = dataString.substring(8);
        if (TextUtils.isEmpty(substring) || !substring.equals(this.f44513e)) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            this.f44511c = this.f44509a.getResources().getString(h.swan_app_hover_button_open);
        } else if (TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, intent.getAction())) {
            this.f44511c = this.f44509a.getResources().getString(h.swan_app_hover_button_download);
        }
        this.f44510b.setFloatButtonText(this.f44511c);
    }

    public FloatButton c() {
        return this.f44510b;
    }

    public final FloatButton e(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(g.swan_app_float_button, (ViewGroup) null);
    }

    public FloatButton f() {
        Activity activity = this.f44509a;
        if (activity instanceof SwanAppActivity) {
            if (this.f44510b == null) {
                this.f44510b = a(activity, (ViewGroup) activity.findViewById(16908290));
            }
            this.f44510b.setFloatButtonText(this.f44511c);
            this.f44510b.setFloatButtonDrawable(this.f44509a.getResources().getDrawable(e.swan_app_hover_button_shape));
            this.f44510b.setFloatButtonDefaultPosition();
            this.f44510b.setFloatButtonStyle(this.f44512d);
            this.f44510b.setVisibility(0);
            return this.f44510b;
        }
        return null;
    }

    public void g(Activity activity, JSONObject jSONObject) {
        String string;
        if (jSONObject != null) {
            if (f44507f) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.f44509a = activity;
            String optString = jSONObject.optString("name");
            this.f44513e = optString;
            if (k0.C(activity, optString)) {
                string = activity.getString(h.swan_app_hover_button_open);
            } else {
                string = activity.getString(h.swan_app_hover_button_download);
            }
            this.f44511c = string;
            this.f44512d = jSONObject.optJSONObject("style");
        }
    }

    public void i(String str) {
        this.f44513e = str;
    }

    public void j(FloatButton floatButton) {
        this.f44510b = floatButton;
    }
}
