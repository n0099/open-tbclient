package d.a.o0.v.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.AlaPersonCenterFragment;
import d.a.n0.e0.b;
import d.a.n0.e0.c;
import d.a.o0.r0.j0;
/* loaded from: classes4.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public AlaPersonCenterFragment f65851a = new AlaPersonCenterFragment();

    public a() {
        getFragmentTabStructure().f53115a = this.f65851a;
    }

    public void a(j0 j0Var) {
        if (j0Var != null && j0Var.i(5)) {
            j0Var.a(this);
        }
    }

    public void b(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment = this.f65851a;
        if (alaPersonCenterFragment != null) {
            alaPersonCenterFragment.G0(str);
        }
    }

    public void c(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment = this.f65851a;
        if (alaPersonCenterFragment != null) {
            alaPersonCenterFragment.H0(str);
        }
    }

    @Override // d.a.n0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f53119e = 5;
        cVar.f53116b = R.string.ala_live;
        cVar.f53123i = c.k;
        return cVar;
    }

    public void d(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment = this.f65851a;
        if (alaPersonCenterFragment != null) {
            alaPersonCenterFragment.I0(str);
        }
    }

    public void e(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment = this.f65851a;
        if (alaPersonCenterFragment != null) {
            alaPersonCenterFragment.J0(str);
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
