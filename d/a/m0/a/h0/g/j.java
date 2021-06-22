package d.a.m0.a.h0.g;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import d.a.m0.a.h0.g.g;
/* loaded from: classes3.dex */
public class j extends d implements View.OnClickListener {
    public RelativeLayout C0;
    public RelativeLayout D0;

    public static j I2() {
        return new j();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View B0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.a.m0.a.g.swan_app_settings_layout, viewGroup, false);
        Q1(inflate);
        H2(inflate);
        if (P1()) {
            inflate = S1(inflate);
        }
        return A1(inflate, this);
    }

    public final void H2(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(d.a.m0.a.f.message_item);
        this.C0 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(d.a.m0.a.f.authority_item);
        this.D0 = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
    }

    public final void J2() {
        if (d.B0) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        g J1 = J1();
        if (J1 == null) {
            d.a.m0.a.z1.b.f.e.f(q(), d.a.m0.a.h.aiapps_open_fragment_failed_toast).F();
            return;
        }
        g.b i2 = J1.i("navigateTo");
        i2.n(g.f45860g, g.f45862i);
        i2.k("authority", null).a();
        d.a.m0.a.j1.a.o("permission");
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean K() {
        return false;
    }

    @Override // d.a.m0.a.h0.g.d
    public void Q1(View view) {
        R1(view);
        l2(-1);
        t2(-16777216);
        n2(J(d.a.m0.a.h.swan_app_menu_setting));
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.a.m0.a.f.message_item) {
            d.a.m0.a.c1.a.k0().a();
        } else if (view.getId() == d.a.m0.a.f.authority_item) {
            J2();
        }
    }
}
