package d.a.h0.a.e0.l;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import d.a.h0.a.e0.l.f;
/* loaded from: classes2.dex */
public class h extends c implements View.OnClickListener {
    public RelativeLayout y0;
    public RelativeLayout z0;

    public static h B2() {
        return new h();
    }

    public final void A2(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(d.a.h0.a.f.message_item);
        this.y0 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(d.a.h0.a.f.authority_item);
        this.z0 = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
    }

    public final void C2() {
        if (c.x0) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        f E1 = E1();
        if (E1 == null) {
            d.a.h0.a.q1.b.f.d.e(m(), d.a.h0.a.h.aiapps_open_fragment_failed_toast).C();
            return;
        }
        f.b i2 = E1.i("navigateTo");
        i2.n(f.f42031g, f.f42033i);
        i2.k("authority", null).a();
        d.a.h0.a.c1.a.p("permission");
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean I() {
        return false;
    }

    @Override // d.a.h0.a.e0.l.c
    public void L1(View view) {
        M1(view);
        f2(-1);
        n2(-16777216);
        h2(B(d.a.h0.a.h.swan_app_menu_setting));
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.a.h0.a.f.message_item) {
            d.a.h0.a.w0.a.X().a();
        } else if (view.getId() == d.a.h0.a.f.authority_item) {
            C2();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View u0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.a.h0.a.g.swan_app_settings_layout, viewGroup, false);
        L1(inflate);
        A2(inflate);
        if (K1()) {
            inflate = N1(inflate);
        }
        return u1(inflate, this);
    }
}
