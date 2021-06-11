package d.a.n0.v.g.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.gamefrslivetab.video.AlaGameFrsLiveTabVideoFragment;
import d.a.m0.e0.c;
/* loaded from: classes4.dex */
public class a extends d.a.m0.e0.b {

    /* renamed from: a  reason: collision with root package name */
    public AlaGameFrsLiveTabVideoFragment f65655a = new AlaGameFrsLiveTabVideoFragment();

    public a() {
        getFragmentTabStructure().f53008a = this.f65655a;
    }

    public void a(String str) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment = this.f65655a;
        if (alaGameFrsLiveTabVideoFragment != null) {
            alaGameFrsLiveTabVideoFragment.J0(str);
        }
    }

    public void b(String str) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment = this.f65655a;
        if (alaGameFrsLiveTabVideoFragment != null) {
            alaGameFrsLiveTabVideoFragment.K0(str);
        }
    }

    public void c(boolean z) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment = this.f65655a;
        if (alaGameFrsLiveTabVideoFragment != null) {
            alaGameFrsLiveTabVideoFragment.L0(z);
        }
    }

    @Override // d.a.m0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f53012e = 3;
        cVar.f53009b = R.string.ala_live;
        cVar.f53016i = c.k;
        return cVar;
    }

    @Override // d.a.m0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator = fragmentTabIndicator;
        fragmentTabIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    @Override // d.a.m0.e0.b
    public boolean isAvailable() {
        return true;
    }
}
