package d.b.i0.t.g.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.gamefrslivetab.video.AlaGameFrsLiveTabVideoFragment;
import d.b.h0.e0.c;
/* loaded from: classes4.dex */
public class a extends d.b.h0.e0.b {

    /* renamed from: a  reason: collision with root package name */
    public AlaGameFrsLiveTabVideoFragment f62312a = new AlaGameFrsLiveTabVideoFragment();

    public a() {
        getFragmentTabStructure().f50548a = this.f62312a;
    }

    public void a(String str) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment = this.f62312a;
        if (alaGameFrsLiveTabVideoFragment != null) {
            alaGameFrsLiveTabVideoFragment.H0(str);
        }
    }

    public void b(String str) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment = this.f62312a;
        if (alaGameFrsLiveTabVideoFragment != null) {
            alaGameFrsLiveTabVideoFragment.I0(str);
        }
    }

    public void c(boolean z) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment = this.f62312a;
        if (alaGameFrsLiveTabVideoFragment != null) {
            alaGameFrsLiveTabVideoFragment.J0(z);
        }
    }

    @Override // d.b.h0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f50552e = 3;
        cVar.f50549b = R.string.ala_live;
        cVar.i = c.k;
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
