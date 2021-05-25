package d.a.l0.f.j.m;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.dialog.GamenowRecommendPopView;
import com.baidu.swan.game.guide.view.GameGuideViewContainer;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import java.util.ArrayList;
@Singleton
@Service
/* loaded from: classes3.dex */
public class d implements d.a.l0.h.t.c.d {

    /* loaded from: classes3.dex */
    public class a implements GamenowRecommendPopView.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GameCloseGuidePopView.e f46875a;

        public a(d dVar, GameCloseGuidePopView.e eVar) {
            this.f46875a = eVar;
        }

        @Override // com.baidu.swan.game.guide.dialog.GamenowRecommendPopView.e
        public void a() {
            GameCloseGuidePopView.e eVar = this.f46875a;
            if (eVar == null) {
                return;
            }
            eVar.a();
        }
    }

    static {
        boolean z = k.f43199a;
    }

    @Override // d.a.l0.h.t.c.d
    public View a(Context context, GameCloseGuidePopView.e eVar) {
        d.a.l0.f.j.b bVar;
        GameGuideConfigInfo z;
        GameGuideConfigInfo.CloseInfo closeInfo;
        if (context == null || (bVar = d.a.l0.f.j.b.o) == null) {
            return null;
        }
        String I = bVar.I();
        if ((!TextUtils.equals(I, c.f46874a) && q0.F(context, I)) || (z = d.a.l0.f.j.b.o.z()) == null || (closeInfo = z.closeInfo) == null) {
            return null;
        }
        int i2 = closeInfo.type;
        ArrayList<GameGuideConfigInfo.RecommendGameInfo> arrayList = closeInfo.gameList;
        if ((i2 != 0 || arrayList == null || arrayList.size() < 3) && ((i2 != 1 || arrayList == null || arrayList.size() < 6) && i2 != 2)) {
            return null;
        }
        if (i2 == 0 || i2 == 1) {
            d.a.l0.f.j.r.b.n().c("gbBDialogShow");
        } else if (i2 == 2) {
            d.a.l0.f.j.r.b.n().c("gbADialogShow");
        }
        GamenowRecommendPopView gamenowRecommendPopView = new GamenowRecommendPopView(context, closeInfo);
        gamenowRecommendPopView.setOnClickListener(new a(this, eVar));
        return gamenowRecommendPopView;
    }

    @Override // d.a.l0.h.t.c.d
    public void b(int i2) {
        GameGuideViewContainer B;
        d.a.l0.f.j.b bVar = d.a.l0.f.j.b.o;
        if (bVar == null || (B = bVar.B()) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) B.getLayoutParams();
        layoutParams.rightMargin = i2;
        B.setLayoutParams(layoutParams);
    }

    @Override // d.a.l0.h.t.c.d
    public void release() {
        d.a.l0.f.j.n.c.n().u();
    }
}
