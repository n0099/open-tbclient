package d.a.o0.r0.y1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment;
/* loaded from: classes4.dex */
public class c extends d.a.n0.e0.b {
    public c(int i2, String str) {
        d.a.n0.e0.c cVar = this.mFragement;
        cVar.f53119e = i2;
        SpecialFrsWebFragment specialFrsWebFragment = (SpecialFrsWebFragment) cVar.f53115a;
        specialFrsWebFragment.z1(i2);
        if (str != null && !str.contains("&_client_version=") && !str.contains("?_client_version=")) {
            if (str.contains("&ufanS=1")) {
                str = str + "&_client_version=" + TbConfig.getVersion();
            } else if (str.contains("?ufanS=1")) {
                str = str + "&_client_version=" + TbConfig.getVersion();
            }
        }
        specialFrsWebFragment.O0(str);
    }

    @Override // d.a.n0.e0.b
    public d.a.n0.e0.c createFragmentTabStructure() {
        d.a.n0.e0.c cVar = new d.a.n0.e0.c();
        cVar.f53115a = new SpecialFrsWebFragment();
        cVar.f53119e = 101;
        cVar.f53123i = d.a.n0.e0.c.k;
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
