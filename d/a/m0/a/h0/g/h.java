package d.a.m0.a.h0.g;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import d.a.m0.a.v2.w;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends d {
    public String C0;
    public JSONObject D0;
    public boolean E0 = true;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45874e;

        public a(JSONObject jSONObject) {
            this.f45874e = jSONObject;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.m0.a.g1.f.V().v(new d.a.m0.a.t1.c.c.b(h.this.C0, this.f45874e.toString(), h.this.D0.optString("slaveId")).a());
            h.this.E0 = false;
        }
    }

    public static h L2(String str, String str2) {
        h hVar = new h();
        if (!TextUtils.isEmpty(str2)) {
            Bundle bundle = new Bundle();
            bundle.putString("plugin_fun_page_path", str);
            bundle.putString("plugin_pay_params", str2);
            hVar.j1(bundle);
        }
        return hVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.a.m0.a.g.swan_app_plugin_fun_page_fragment, viewGroup, false);
        Q1(inflate);
        K2(inflate);
        if (P1()) {
            inflate = S1(inflate);
        }
        return A1(inflate, this);
    }

    @Override // d.a.m0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void E0() {
        this.k0 = null;
        super.E0();
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean K() {
        JSONObject jSONObject;
        if (!this.E0 || (jSONObject = this.D0) == null) {
            return false;
        }
        d.a.m0.a.t1.c.c.a aVar = new d.a.m0.a.t1.c.c.a(jSONObject.optString("componentId"));
        aVar.f48543a = this.D0.optString("slaveId");
        aVar.b();
        return false;
    }

    public final void K2(View view) {
        if (view == null || this.D0 == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(d.a.m0.a.f.id_swan_app_plugin_app_name);
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q != null) {
            textView.setText(Q.N().K());
        }
        JSONObject optJSONObject = this.D0.optJSONObject("args");
        if (optJSONObject == null) {
            return;
        }
        ((TextView) view.findViewById(d.a.m0.a.f.id_swan_app_plugin_money)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
        TextView textView2 = (TextView) view.findViewById(d.a.m0.a.f.id_swan_app_plugin_service_name);
        d.a.m0.n.h.h g2 = d.a.m0.a.t1.g.b.g(this.D0.optString("pluginProvider"));
        if (g2 != null) {
            textView2.setText(g2.s);
        }
        ((Button) view.findViewById(d.a.m0.a.f.id_swan_app_plugin_pay)).setOnClickListener(new a(optJSONObject));
    }

    @Override // d.a.m0.a.h0.g.d
    public void Q1(View view) {
        R1(view);
        l2(-1);
        t2(-16777216);
        n2(J(d.a.m0.a.h.swan_app_plugin_fun_page_title));
        p2(true);
        z2(false);
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean X1() {
        return false;
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean Z1() {
        return false;
    }

    @Override // d.a.m0.a.h0.g.d
    public void e2() {
    }

    @Override // d.a.m0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle n = n();
        if (n == null) {
            return;
        }
        this.C0 = n.getString("plugin_fun_page_path");
        this.D0 = w.d(n.getString("plugin_pay_params"));
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.m0.a.a2.d.g().r().T().v();
    }

    @Override // d.a.m0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        x2(1);
    }
}
