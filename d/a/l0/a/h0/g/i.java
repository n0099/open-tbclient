package d.a.l0.a.h0.g;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import d.a.l0.a.v2.p;
import d.a.l0.a.v2.q0;
import d.a.l0.a.z1.b.c.a;
import java.io.File;
/* loaded from: classes2.dex */
public class i extends d implements a.InterfaceC0935a {
    public d.a.l0.a.z1.b.c.a x0;
    public View y0;
    public String z0;

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<String> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            i.this.z0 = str;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.N2();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.l0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f42094e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f42095f;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.f42095f.setText(cVar.f42094e.toString());
            }
        }

        public c(StringBuilder sb, TextView textView) {
            this.f42094e = sb;
            this.f42095f = textView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            i.this.z0 = str;
            this.f42094e.append(str);
            q0.X(new a());
        }
    }

    static {
        boolean z = d.a.l0.a.k.f43199a;
    }

    @Nullable
    public static File K2() {
        String x;
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null || (x = d.a.l0.a.k2.b.x(Q.getAppId())) == null) {
            return null;
        }
        return new File(x, "running_info_share_cache");
    }

    public static i M2() {
        return new i();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.a.l0.a.g.aiapps_running_info_fragment, viewGroup, false);
        Q1(inflate);
        L2(inflate);
        if (P1()) {
            inflate = S1(inflate);
        }
        View A1 = A1(inflate, this);
        this.y0 = A1;
        return A1;
    }

    public final boolean J2() {
        File[] listFiles;
        File K2 = K2();
        if (K2 == null || !K2.exists() || (listFiles = K2.listFiles()) == null) {
            return true;
        }
        for (File file : listFiles) {
            if (!d.a.l0.t.d.K(file)) {
                return false;
            }
        }
        return true;
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean K() {
        d.a.l0.a.z1.b.c.a aVar = this.x0;
        return aVar != null && aVar.f();
    }

    public final void L2(View view) {
        if (d.a.l0.a.a2.e.Q() == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(d.a.l0.a.f.running_info_text);
        textView.setTextIsSelectable(true);
        StringBuilder sb = new StringBuilder();
        sb.append(p.h(this.f0));
        sb.append("===== 启动信息 =====");
        sb.append("\n");
        if (!TextUtils.isEmpty(this.z0)) {
            sb.append(this.z0);
            textView.setText(sb.toString());
            return;
        }
        textView.setText(sb.toString());
        p.g(this.f0, new c(sb, textView));
    }

    public final void N2() {
        d.a.l0.a.c1.a.f0().a(this.f0);
    }

    public final void O2() {
        TextView textView = new TextView(q());
        textView.setText(d.a.l0.a.h.swan_app_reporting);
        textView.setTextColor(ContextCompat.getColor(q(), d.a.l0.a.c.GC7));
        textView.setOnClickListener(new b());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = q().getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_action_bar_right_operation_margin);
        textView.setLayoutParams(layoutParams);
        this.i0.addView(textView);
    }

    @Override // d.a.l0.a.h0.g.d
    public void Q1(View view) {
        R1(view);
        z2(false);
        l2(-1);
        t2(-16777216);
        n2(q().getResources().getString(d.a.l0.a.h.swan_app_running_info));
        p2(true);
        O2();
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean X1() {
        return false;
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean Z1() {
        return false;
    }

    @Override // d.a.l0.a.h0.g.d
    public void e2() {
    }

    @Override // d.a.l0.a.z1.b.c.a.InterfaceC0935a
    public d.a.l0.a.z1.b.c.a getFloatLayer() {
        if (this.x0 == null) {
            View view = this.y0;
            if (view == null) {
                return null;
            }
            this.x0 = new d.a.l0.a.z1.b.c.a(this, (LinearLayout) view.findViewById(d.a.l0.a.f.aiapps_running_info_fragment_base_view), 0);
        }
        return this.x0;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.z0 = null;
        p.g(this.f0, new a());
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (J2()) {
            return;
        }
        d.a.l0.a.e0.d.a("SwanAppRunningInfoFragment", "分享中间文件删除失败。。。");
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        x2(1);
    }
}
