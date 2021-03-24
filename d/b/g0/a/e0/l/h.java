package d.b.g0.a.e0.l;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import d.b.g0.a.e0.l.f;
/* loaded from: classes3.dex */
public class h extends c implements View.OnClickListener {
    public RelativeLayout y0;
    public RelativeLayout z0;

    public static h C2() {
        return new h();
    }

    public final void B2(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(d.b.g0.a.f.message_item);
        this.y0 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(d.b.g0.a.f.authority_item);
        this.z0 = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
    }

    public final void D2() {
        if (c.x0) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        f F1 = F1();
        if (F1 == null) {
            d.b.g0.a.q1.b.f.d.e(l(), d.b.g0.a.h.aiapps_open_fragment_failed_toast).C();
            return;
        }
        f.b i = F1.i("navigateTo");
        i.n(f.f44012g, f.i);
        i.k("authority", null).a();
        d.b.g0.a.c1.a.p("permission");
    }

    @Override // d.b.g0.a.e0.l.c
    public void M1(View view) {
        N1(view);
        g2(-1);
        o2(-16777216);
        i2(G(d.b.g0.a.h.swan_app_menu_setting));
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.b.g0.a.f.message_item) {
            d.b.g0.a.w0.a.X().a();
        } else if (view.getId() == d.b.g0.a.f.authority_item) {
            D2();
        }
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean v() {
        return false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View v0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.b.g0.a.g.swan_app_settings_layout, viewGroup, false);
        M1(inflate);
        B2(inflate);
        if (L1()) {
            inflate = O1(inflate);
        }
        return v1(inflate, this);
    }
}
