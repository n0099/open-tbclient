package d.a.n0.v.e.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment;
/* loaded from: classes4.dex */
public class a extends d.a.m0.e0.b {

    /* renamed from: a  reason: collision with root package name */
    public AlaFrsLiveFragment f61872a;

    public a(boolean z) {
        AlaFrsLiveFragment alaFrsLiveFragment = new AlaFrsLiveFragment();
        this.f61872a = alaFrsLiveFragment;
        alaFrsLiveFragment.R0(z);
        getFragmentTabStructure().f49334a = this.f61872a;
    }

    public void a(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f61872a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.N0(str);
        }
    }

    public void b(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f61872a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.O0(str);
        }
    }

    public void c(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f61872a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.P0(str);
        }
    }

    @Override // d.a.m0.e0.b
    public d.a.m0.e0.c createFragmentTabStructure() {
        d.a.m0.e0.c cVar = new d.a.m0.e0.c();
        cVar.f49338e = 2;
        cVar.f49335b = R.string.ala_live;
        cVar.f49342i = d.a.m0.e0.c.k;
        return cVar;
    }

    public void d(int i2) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f61872a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.Q0(i2);
        }
    }

    public void e(boolean z) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f61872a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.S0(z);
        }
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
