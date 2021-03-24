package d.b.g0.e.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes3.dex */
public class k extends b {
    public k(Context context, AdElementInfo adElementInfo, d.b.g0.e.a.n.a aVar) {
        super(context, adElementInfo, aVar);
    }

    @Override // d.b.g0.e.a.b
    public void A(RelativeLayout relativeLayout, AdElementInfo adElementInfo) {
    }

    @Override // d.b.g0.e.a.b
    public String p() {
        return "reward_banner_html";
    }

    @Override // d.b.g0.e.a.b
    public View t() {
        return LayoutInflater.from(this.o).inflate(h.ng_game_portrait_por_play, (ViewGroup) null);
    }
}
