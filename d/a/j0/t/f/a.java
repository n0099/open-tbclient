package d.a.j0.t.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment;
import d.a.i0.e0.b;
import d.a.i0.e0.c;
import d.a.j0.q0.j0;
/* loaded from: classes4.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public AlaGameFrsLiveTabFragment f60927a = new AlaGameFrsLiveTabFragment();

    public a() {
        getFragmentTabStructure().f48462a = this.f60927a;
    }

    public void a(j0 j0Var) {
        if (j0Var != null && j0Var.i(2)) {
            j0Var.a(this);
        }
    }

    public void b(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment = this.f60927a;
        if (alaGameFrsLiveTabFragment != null) {
            alaGameFrsLiveTabFragment.O0(str);
        }
    }

    public void c(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment = this.f60927a;
        if (alaGameFrsLiveTabFragment != null) {
            alaGameFrsLiveTabFragment.P0(str);
        }
    }

    @Override // d.a.i0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f48466e = 2;
        cVar.f48463b = R.string.ala_live;
        cVar.f48470i = c.k;
        return cVar;
    }

    public void d(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment = this.f60927a;
        if (alaGameFrsLiveTabFragment != null) {
            alaGameFrsLiveTabFragment.Q0(str);
        }
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
