package d.a.o0.v.d.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment;
import d.a.n0.e0.b;
import d.a.n0.e0.c;
/* loaded from: classes4.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public SpecialLiveFragment f65549a;

    public a(String str, String str2) {
        this.f65549a = SpecialLiveFragment.H1(str, str2);
        getFragmentTabStructure().f53115a = this.f65549a;
    }

    @Override // d.a.n0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f53119e = 4;
        cVar.f53116b = R.string.ala_live;
        cVar.f53123i = c.k;
        return cVar;
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
