package d.a.k0.t.e.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment;
/* loaded from: classes4.dex */
public class a extends d.a.j0.e0.b {

    /* renamed from: a  reason: collision with root package name */
    public AlaFrsLiveFragment f61584a;

    public a(boolean z) {
        AlaFrsLiveFragment alaFrsLiveFragment = new AlaFrsLiveFragment();
        this.f61584a = alaFrsLiveFragment;
        alaFrsLiveFragment.R0(z);
        getFragmentTabStructure().f49290a = this.f61584a;
    }

    public void a(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f61584a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.N0(str);
        }
    }

    public void b(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f61584a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.O0(str);
        }
    }

    public void c(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f61584a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.P0(str);
        }
    }

    @Override // d.a.j0.e0.b
    public d.a.j0.e0.c createFragmentTabStructure() {
        d.a.j0.e0.c cVar = new d.a.j0.e0.c();
        cVar.f49294e = 2;
        cVar.f49291b = R.string.ala_live;
        cVar.f49298i = d.a.j0.e0.c.k;
        return cVar;
    }

    public void d(int i2) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f61584a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.Q0(i2);
        }
    }

    public void e(boolean z) {
        AlaFrsLiveFragment alaFrsLiveFragment = this.f61584a;
        if (alaFrsLiveFragment != null) {
            alaFrsLiveFragment.S0(z);
        }
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
