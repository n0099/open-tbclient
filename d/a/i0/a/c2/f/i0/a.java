package d.a.i0.a.c2.f.i0;

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
import d.a.i0.a.e;
import d.a.i0.a.g;
import d.a.i0.a.h;
import d.a.i0.a.k;
import d.a.i0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f40888f = k.f43025a;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f40889g;

    /* renamed from: a  reason: collision with root package name */
    public Activity f40890a;

    /* renamed from: b  reason: collision with root package name */
    public FloatButton f40891b;

    /* renamed from: c  reason: collision with root package name */
    public String f40892c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f40893d;

    /* renamed from: e  reason: collision with root package name */
    public String f40894e = "";

    public static a d() {
        if (f40889g == null) {
            synchronized (a.class) {
                if (f40889g == null) {
                    f40889g = new a();
                }
            }
        }
        return f40889g;
    }

    public static void h() {
        if (f40889g == null) {
            return;
        }
        f40889g = null;
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
        if (intent == null || this.f40891b == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        String substring = dataString.substring(8);
        if (TextUtils.isEmpty(substring) || !substring.equals(this.f40894e)) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            this.f40892c = this.f40890a.getResources().getString(h.aiapps_tip_open_app);
        } else if (TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, intent.getAction())) {
            this.f40892c = this.f40890a.getResources().getString(h.swan_app_hover_button_download);
        }
        this.f40891b.setFloatButtonText(this.f40892c);
    }

    public FloatButton c() {
        return this.f40891b;
    }

    public final FloatButton e(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(g.swan_app_float_button, (ViewGroup) null);
    }

    public FloatButton f() {
        Activity activity = this.f40890a;
        if (activity instanceof SwanAppActivity) {
            if (this.f40891b == null) {
                this.f40891b = a(activity, (ViewGroup) activity.findViewById(16908290));
            }
            this.f40891b.setFloatButtonText(this.f40892c);
            this.f40891b.setFloatButtonDrawable(this.f40890a.getResources().getDrawable(e.swan_app_hover_button_shape));
            this.f40891b.setFloatButtonDefaultPosition();
            this.f40891b.setFloatButtonStyle(this.f40893d);
            this.f40891b.setVisibility(0);
            return this.f40891b;
        }
        return null;
    }

    public void g(Activity activity, JSONObject jSONObject) {
        String string;
        if (jSONObject != null) {
            if (f40888f) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.f40890a = activity;
            String optString = jSONObject.optString("name");
            this.f40894e = optString;
            if (q0.F(activity, optString)) {
                string = activity.getString(h.aiapps_tip_open_app);
            } else {
                string = activity.getString(h.swan_app_hover_button_download);
            }
            this.f40892c = string;
            this.f40893d = jSONObject.optJSONObject("style");
        }
    }

    public void i(String str) {
        this.f40894e = str;
    }

    public void j(FloatButton floatButton) {
        this.f40891b = floatButton;
    }
}
