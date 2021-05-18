package d.a.k0.q0.x1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import d.a.k0.q0.j0;
/* loaded from: classes4.dex */
public class e extends d.a.j0.e0.b {
    public e(FrsFragment frsFragment) {
        getFragmentTabStructure().f49290a = frsFragment;
    }

    public void a(j0 j0Var) {
        if (j0Var != null && j0Var.i(1)) {
            j0Var.a(this);
        }
    }

    @Override // d.a.j0.e0.b
    public d.a.j0.e0.c createFragmentTabStructure() {
        d.a.j0.e0.c cVar = new d.a.j0.e0.c();
        cVar.f49294e = 1;
        cVar.f49291b = R.string.chosen_pb_title;
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
