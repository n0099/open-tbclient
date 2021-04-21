package d.b.j0.t.e.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment;
/* loaded from: classes4.dex */
public class a extends d.b.i0.e0.b {

    /* renamed from: a  reason: collision with root package name */
    public AlaFrsLiveFragment f62672a;

    public a(boolean z) {
        AlaFrsLiveFragment alaFrsLiveFragment = new AlaFrsLiveFragment();
        this.f62672a = alaFrsLiveFragment;
        alaFrsLiveFragment.S0(z);
        getFragmentTabStructure().f50884a = this.f62672a;
    }

    public void a(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f62672a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.O0(str);
        }
    }

    public void b(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f62672a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.P0(str);
        }
    }

    public void c(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f62672a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.Q0(str);
        }
    }

    @Override // d.b.i0.e0.b
    public d.b.i0.e0.c createFragmentTabStructure() {
        d.b.i0.e0.c cVar = new d.b.i0.e0.c();
        cVar.f50888e = 2;
        cVar.f50885b = R.string.ala_live;
        cVar.i = d.b.i0.e0.c.k;
        return cVar;
    }

    public void d(int i) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f62672a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.R0(i);
        }
    }

    public void e(boolean z) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f62672a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.T0(z);
        }
    }

    @Override // d.b.i0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator = fragmentTabIndicator;
        fragmentTabIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    @Override // d.b.i0.e0.b
    public boolean isAvailable() {
        return true;
    }
}
