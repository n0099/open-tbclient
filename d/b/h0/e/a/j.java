package d.b.h0.e.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes3.dex */
public class j extends b {
    public boolean F;

    public j(Context context, AdElementInfo adElementInfo, d.b.h0.e.a.n.a aVar) {
        super(context, adElementInfo, aVar);
        this.F = false;
    }

    @Override // d.b.h0.e.a.b
    public void A(RelativeLayout relativeLayout, AdElementInfo adElementInfo) {
        int J = adElementInfo.J();
        int H = adElementInfo.H();
        this.m = d.b.h0.g.k0.e.c.c();
        this.n = d.b.h0.g.k0.e.c.b();
        if (J < H) {
            this.F = true;
            int i = this.m;
            int i2 = (int) (((i - J) / 2) * 0.8d);
            int i3 = (int) (((i - J) / 2) * 0.1d);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams.leftMargin = (this.m - i2) - i3;
            layoutParams.addRule(15);
            layoutParams.removeRule(13);
            layoutParams.removeRule(12);
            layoutParams.bottomMargin = 0;
            relativeLayout.setLayoutParams(layoutParams);
            relativeLayout.setBackgroundColor(this.v.getColor(d.ng_game_black));
        }
    }

    @Override // d.b.h0.e.a.b
    public String p() {
        return this.F ? "reward_banner_land_html" : "reward_banner_html";
    }

    @Override // d.b.h0.e.a.b
    public View t() {
        return LayoutInflater.from(this.o).inflate(h.ng_game_land_play, (ViewGroup) null);
    }
}
