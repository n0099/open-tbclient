package d.a.j0.q0.u1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment;
import d.a.i0.e0.b;
import d.a.i0.e0.c;
/* loaded from: classes4.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public FrsGameRecommendFragment f58780a;

    public a(String str, String str2) {
        this.f58780a = FrsGameRecommendFragment.I0(str, str2);
        getFragmentTabStructure().f48462a = this.f58780a;
    }

    @Override // d.a.i0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f48466e = 11;
        cVar.f48463b = R.string.frs_game_recommend_tab_title;
        cVar.f48470i = c.k;
        return cVar;
    }

    @Override // d.a.i0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator = fragmentTabIndicator;
        fragmentTabIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    @Override // d.a.i0.e0.b
    public boolean isAvailable() {
        return true;
    }
}
