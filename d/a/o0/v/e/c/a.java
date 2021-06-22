package d.a.o0.v.e.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment;
/* loaded from: classes4.dex */
public class a extends d.a.n0.e0.b {

    /* renamed from: a  reason: collision with root package name */
    public AlaFrsLiveFragment f65712a;

    public a(boolean z) {
        AlaFrsLiveFragment alaFrsLiveFragment = new AlaFrsLiveFragment();
        this.f65712a = alaFrsLiveFragment;
        alaFrsLiveFragment.U0(z);
        getFragmentTabStructure().f53115a = this.f65712a;
    }

    public void a(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f65712a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.Q0(str);
        }
    }

    public void b(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f65712a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.R0(str);
        }
    }

    public void c(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f65712a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.S0(str);
        }
    }

    @Override // d.a.n0.e0.b
    public d.a.n0.e0.c createFragmentTabStructure() {
        d.a.n0.e0.c cVar = new d.a.n0.e0.c();
        cVar.f53119e = 2;
        cVar.f53116b = R.string.ala_live;
        cVar.f53123i = d.a.n0.e0.c.k;
        return cVar;
    }

    public void d(int i2) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f65712a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.T0(i2);
        }
    }

    public void e(boolean z) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f65712a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.V0(z);
        }
    }

    @Override // d.a.n0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator = fragmentTabIndicator;
        fragmentTabIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    @Override // d.a.n0.e0.b
    public boolean isAvailable() {
        return true;
    }
}
