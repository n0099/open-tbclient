package d.a.i0.f.i.s;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import d.a.i0.f.i.f;
/* loaded from: classes3.dex */
public class b extends a {
    public boolean G;

    public b(Context context, AdElementInfo adElementInfo, d.a.i0.f.i.n.a aVar) {
        super(context, adElementInfo, aVar);
        this.G = false;
    }

    @Override // d.a.i0.f.i.s.a
    public void C(RelativeLayout relativeLayout, AdElementInfo adElementInfo) {
        int J = adElementInfo.J();
        int H = adElementInfo.H();
        this.n = d.a.i0.f.i.m.a.b().q();
        this.o = d.a.i0.f.i.m.a.b().p();
        if (J < H) {
            this.G = true;
            int i2 = this.n;
            int i3 = (int) (((i2 - J) / 2) * 0.8d);
            int i4 = (int) (((i2 - J) / 2) * 0.1d);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
            layoutParams.leftMargin = (this.n - i3) - i4;
            layoutParams.addRule(15);
            layoutParams.removeRule(13);
            layoutParams.removeRule(12);
            layoutParams.bottomMargin = 0;
            relativeLayout.setLayoutParams(layoutParams);
            relativeLayout.setBackgroundColor(this.w.getColor(d.a.i0.f.i.b.ng_game_black));
        }
    }

    @Override // d.a.i0.f.i.s.a
    public String q() {
        return this.G ? "reward_banner_land_html" : "reward_banner_html";
    }

    @Override // d.a.i0.f.i.s.a
    @SuppressLint({"InflateParams"})
    public View u() {
        return LayoutInflater.from(this.p).inflate(f.ng_game_land_play, (ViewGroup) null);
    }
}
