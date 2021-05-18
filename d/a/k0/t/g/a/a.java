package d.a.k0.t.g.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.gamefrslivetab.video.AlaGameFrsLiveTabVideoFragment;
import d.a.j0.e0.c;
/* loaded from: classes4.dex */
public class a extends d.a.j0.e0.b {

    /* renamed from: a  reason: collision with root package name */
    public AlaGameFrsLiveTabVideoFragment f61652a = new AlaGameFrsLiveTabVideoFragment();

    public a() {
        getFragmentTabStructure().f49290a = this.f61652a;
    }

    public void a(String str) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment = this.f61652a;
        if (alaGameFrsLiveTabVideoFragment != null) {
            alaGameFrsLiveTabVideoFragment.G0(str);
        }
    }

    public void b(String str) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment = this.f61652a;
        if (alaGameFrsLiveTabVideoFragment != null) {
            alaGameFrsLiveTabVideoFragment.H0(str);
        }
    }

    public void c(boolean z) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment = this.f61652a;
        if (alaGameFrsLiveTabVideoFragment != null) {
            alaGameFrsLiveTabVideoFragment.I0(z);
        }
    }

    @Override // d.a.j0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f49294e = 3;
        cVar.f49291b = R.string.ala_live;
        cVar.f49298i = c.k;
        return cVar;
    }

    @Override // d.a.j0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator = fragmentTabIndicator;
        fragmentTabIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    @Override // d.a.j0.e0.b
    public boolean isAvailable() {
        return true;
    }
}
