package d.b.g0.a.e0.l;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import d.b.g0.a.i2.v;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends c {
    public boolean A0 = true;
    public String y0;
    public JSONObject z0;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44026e;

        public a(JSONObject jSONObject) {
            this.f44026e = jSONObject;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.g0.a.z0.f.V().N(new d.b.g0.a.l1.c.c.b(g.this.y0, this.f44026e.toString(), g.this.z0.optString("slaveId")).a());
            g.this.A0 = false;
        }
    }

    public static g F2(String str, String str2) {
        g gVar = new g();
        if (!TextUtils.isEmpty(str2)) {
            Bundle bundle = new Bundle();
            bundle.putString("plugin_fun_page_path", str);
            bundle.putString("plugin_pay_params", str2);
            gVar.d1(bundle);
        }
        return gVar;
    }

    public final void E2(View view) {
        if (view == null || this.z0 == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(d.b.g0.a.f.id_swan_app_plugin_app_name);
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O != null) {
            textView.setText(O.L().J());
        }
        JSONObject optJSONObject = this.z0.optJSONObject("args");
        if (optJSONObject == null) {
            return;
        }
        ((TextView) view.findViewById(d.b.g0.a.f.id_swan_app_plugin_money)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
        TextView textView2 = (TextView) view.findViewById(d.b.g0.a.f.id_swan_app_plugin_service_name);
        d.b.g0.l.k.h f2 = d.b.g0.a.l1.g.b.f(this.z0.optString("pluginProvider"));
        if (f2 != null) {
            textView2.setText(f2.s);
        }
        ((Button) view.findViewById(d.b.g0.a.f.id_swan_app_plugin_pay)).setOnClickListener(new a(optJSONObject));
    }

    @Override // d.b.g0.a.e0.l.c
    public void M1(View view) {
        N1(view);
        g2(-1);
        o2(-16777216);
        i2(G(d.b.g0.a.h.swan_app_plugin_fun_page_title));
        k2(true);
        u2(false);
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean T1() {
        return false;
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean V1() {
        return false;
    }

    @Override // d.b.g0.a.e0.l.c
    public void a2() {
    }

    @Override // d.b.g0.a.e0.l.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle j = j();
        if (j == null) {
            return;
        }
        this.y0 = j.getString("plugin_fun_page_path");
        this.z0 = v.b(j.getString("plugin_pay_params"));
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.b.g0.a.r1.d.e().s().R().u();
    }

    @Override // d.b.g0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        s2(1);
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean v() {
        JSONObject jSONObject;
        if (!this.A0 || (jSONObject = this.z0) == null) {
            return false;
        }
        d.b.g0.a.l1.c.c.a aVar = new d.b.g0.a.l1.c.c.a(jSONObject.optString("componentId"));
        aVar.f45195a = this.z0.optString("slaveId");
        aVar.b();
        return false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View v0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.b.g0.a.g.swan_app_plugin_fun_page_fragment, viewGroup, false);
        M1(inflate);
        E2(inflate);
        if (L1()) {
            inflate = O1(inflate);
        }
        return v1(inflate, this);
    }

    @Override // d.b.g0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        this.f0 = null;
        super.y0();
    }
}
