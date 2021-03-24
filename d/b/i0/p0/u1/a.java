package d.b.i0.p0.u1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment;
import d.b.h0.e0.b;
import d.b.h0.e0.c;
/* loaded from: classes4.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public FrsGameRecommendFragment f58583a;

    public a(String str, String str2) {
        this.f58583a = FrsGameRecommendFragment.I0(str, str2);
        getFragmentTabStructure().f50154a = this.f58583a;
    }

    @Override // d.b.h0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f50158e = 11;
        cVar.f50155b = R.string.frs_game_recommend_tab_title;
        cVar.f50161h = c.j;
        return cVar;
    }

    @Override // d.b.h0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator = fragmentTabIndicator;
        fragmentTabIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    @Override // d.b.h0.e0.b
    public boolean isAvailable() {
        return true;
    }
}
