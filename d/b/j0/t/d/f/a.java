package d.b.j0.t.d.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment;
import d.b.i0.e0.b;
import d.b.i0.e0.c;
/* loaded from: classes4.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public SpecialLiveFragment f62510a;

    public a(String str, String str2) {
        this.f62510a = SpecialLiveFragment.G1(str, str2);
        getFragmentTabStructure().f50884a = this.f62510a;
    }

    @Override // d.b.i0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f50888e = 4;
        cVar.f50885b = R.string.ala_live;
        cVar.i = c.k;
        return cVar;
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
