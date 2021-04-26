package d.a.h0.a.e0.l;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import d.a.h0.a.i2.v;
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
        public final /* synthetic */ JSONObject f42045e;

        public a(JSONObject jSONObject) {
            this.f42045e = jSONObject;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.h0.a.z0.f.V().x(new d.a.h0.a.l1.c.c.b(g.this.y0, this.f42045e.toString(), g.this.z0.optString("slaveId")).a());
            g.this.A0 = false;
        }
    }

    public static g E2(String str, String str2) {
        g gVar = new g();
        if (!TextUtils.isEmpty(str2)) {
            Bundle bundle = new Bundle();
            bundle.putString("plugin_fun_page_path", str);
            bundle.putString("plugin_pay_params", str2);
            gVar.c1(bundle);
        }
        return gVar;
    }

    public final void D2(View view) {
        if (view == null || this.z0 == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(d.a.h0.a.f.id_swan_app_plugin_app_name);
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O != null) {
            textView.setText(O.L().J());
        }
        JSONObject optJSONObject = this.z0.optJSONObject("args");
        if (optJSONObject == null) {
            return;
        }
        ((TextView) view.findViewById(d.a.h0.a.f.id_swan_app_plugin_money)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
        TextView textView2 = (TextView) view.findViewById(d.a.h0.a.f.id_swan_app_plugin_service_name);
        d.a.h0.l.k.h f2 = d.a.h0.a.l1.g.b.f(this.z0.optString("pluginProvider"));
        if (f2 != null) {
            textView2.setText(f2.s);
        }
        ((Button) view.findViewById(d.a.h0.a.f.id_swan_app_plugin_pay)).setOnClickListener(new a(optJSONObject));
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean I() {
        JSONObject jSONObject;
        if (!this.A0 || (jSONObject = this.z0) == null) {
            return false;
        }
        d.a.h0.a.l1.c.c.a aVar = new d.a.h0.a.l1.c.c.a(jSONObject.optString("componentId"));
        aVar.f43252a = this.z0.optString("slaveId");
        aVar.b();
        return false;
    }

    @Override // d.a.h0.a.e0.l.c
    public void L1(View view) {
        M1(view);
        f2(-1);
        n2(-16777216);
        h2(B(d.a.h0.a.h.swan_app_plugin_fun_page_title));
        j2(true);
        t2(false);
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean S1() {
        return false;
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean U1() {
        return false;
    }

    @Override // d.a.h0.a.e0.l.c
    public void Z1() {
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle i2 = i();
        if (i2 == null) {
            return;
        }
        this.y0 = i2.getString("plugin_fun_page_path");
        this.z0 = v.b(i2.getString("plugin_pay_params"));
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.h0.a.r1.d.e().p().R().u();
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        r2(1);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View u0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.a.h0.a.g.swan_app_plugin_fun_page_fragment, viewGroup, false);
        L1(inflate);
        D2(inflate);
        if (K1()) {
            inflate = N1(inflate);
        }
        return u1(inflate, this);
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void x0() {
        this.f0 = null;
        super.x0();
    }
}
