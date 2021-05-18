package d.a.k0.q0.y1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment;
/* loaded from: classes4.dex */
public class c extends d.a.j0.e0.b {
    public c(int i2, String str) {
        d.a.j0.e0.c cVar = this.mFragement;
        cVar.f49294e = i2;
        SpecialFrsWebFragment specialFrsWebFragment = (SpecialFrsWebFragment) cVar.f49290a;
        specialFrsWebFragment.w1(i2);
        if (str != null && !str.contains("&_client_version=") && !str.contains("?_client_version=")) {
            if (str.contains("&ufanS=1")) {
                str = str + "&_client_version=" + TbConfig.getVersion();
            } else if (str.contains("?ufanS=1")) {
                str = str + "&_client_version=" + TbConfig.getVersion();
            }
        }
        specialFrsWebFragment.L0(str);
    }

    @Override // d.a.j0.e0.b
    public d.a.j0.e0.c createFragmentTabStructure() {
        d.a.j0.e0.c cVar = new d.a.j0.e0.c();
        cVar.f49290a = new SpecialFrsWebFragment();
        cVar.f49294e = 101;
        cVar.f49298i = d.a.j0.e0.c.k;
        return cVar;
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
