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
public class c extends a {
    public c(Context context, AdElementInfo adElementInfo, d.a.i0.f.i.n.a aVar) {
        super(context, adElementInfo, aVar);
    }

    @Override // d.a.i0.f.i.s.a
    public void C(RelativeLayout relativeLayout, AdElementInfo adElementInfo) {
    }

    @Override // d.a.i0.f.i.s.a
    public String q() {
        return "reward_banner_html";
    }

    @Override // d.a.i0.f.i.s.a
    @SuppressLint({"InflateParams"})
    public View u() {
        return LayoutInflater.from(this.p).inflate(f.ng_game_portrait_por_play, (ViewGroup) null);
    }
}
