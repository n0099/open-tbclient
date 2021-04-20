package d.b.i0.q0.y1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment;
/* loaded from: classes4.dex */
public class c extends d.b.h0.e0.b {
    public c(int i, String str) {
        d.b.h0.e0.c cVar = this.mFragement;
        cVar.f50552e = i;
        SpecialFrsWebFragment specialFrsWebFragment = (SpecialFrsWebFragment) cVar.f50548a;
        specialFrsWebFragment.x1(i);
        if (str != null && !str.contains("&_client_version=") && !str.contains("?_client_version=")) {
            if (str.contains("&ufanS=1")) {
                str = str + "&_client_version=" + TbConfig.getVersion();
            } else if (str.contains("?ufanS=1")) {
                str = str + "&_client_version=" + TbConfig.getVersion();
            }
        }
        specialFrsWebFragment.M0(str);
    }

    @Override // d.b.h0.e0.b
    public d.b.h0.e0.c createFragmentTabStructure() {
        d.b.h0.e0.c cVar = new d.b.h0.e0.c();
        cVar.f50548a = new SpecialFrsWebFragment();
        cVar.f50552e = 101;
        cVar.i = d.b.h0.e0.c.k;
        return cVar;
    }

    @Override // d.b.h0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator = fragmentTabIndicator;
        fragmentTabIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    @Override // d.b.h0.e0.b
    public boolean isAvailable() {
        return true;
    }
}
