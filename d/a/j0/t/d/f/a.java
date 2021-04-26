package d.a.j0.t.d.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment;
import d.a.i0.e0.b;
import d.a.i0.e0.c;
/* loaded from: classes4.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public SpecialLiveFragment f60698a;

    public a(String str, String str2) {
        this.f60698a = SpecialLiveFragment.G1(str, str2);
        getFragmentTabStructure().f48462a = this.f60698a;
    }

    @Override // d.a.i0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f48466e = 4;
        cVar.f48463b = R.string.ala_live;
        cVar.f48470i = c.k;
        return cVar;
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
