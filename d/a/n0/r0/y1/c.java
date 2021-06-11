package d.a.n0.r0.y1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment;
/* loaded from: classes4.dex */
public class c extends d.a.m0.e0.b {
    public c(int i2, String str) {
        d.a.m0.e0.c cVar = this.mFragement;
        cVar.f53012e = i2;
        SpecialFrsWebFragment specialFrsWebFragment = (SpecialFrsWebFragment) cVar.f53008a;
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

    @Override // d.a.m0.e0.b
    public d.a.m0.e0.c createFragmentTabStructure() {
        d.a.m0.e0.c cVar = new d.a.m0.e0.c();
        cVar.f53008a = new SpecialFrsWebFragment();
        cVar.f53012e = 101;
        cVar.f53016i = d.a.m0.e0.c.k;
        return cVar;
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
