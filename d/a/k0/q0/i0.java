package d.a.k0.q0;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.view.FrsTopItemInfoView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ItemInfo;
/* loaded from: classes4.dex */
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f58529a;

    /* renamed from: b  reason: collision with root package name */
    public FrsTopItemInfoView f58530b;

    public i0(BaseFragment baseFragment) {
        FrsViewData frsViewData;
        if (baseFragment == null) {
            return;
        }
        this.f58529a = baseFragment;
        this.f58530b = new FrsTopItemInfoView(baseFragment.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        this.f58530b.setLayoutParams(layoutParams);
        b();
        BaseFragment baseFragment2 = this.f58529a;
        if (!(baseFragment2 instanceof FrsCommonTabFragment) || (frsViewData = ((FrsCommonTabFragment) baseFragment2).f15367h) == null || frsViewData.getForum() == null) {
            return;
        }
        ForumData forum = frsViewData.getForum();
        this.f58530b.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
    }

    public View a() {
        return this.f58530b;
    }

    public void b() {
        FrsTopItemInfoView frsTopItemInfoView = this.f58530b;
        if (frsTopItemInfoView != null) {
            frsTopItemInfoView.e();
        }
    }

    public void c(ItemInfo itemInfo) {
        FrsTopItemInfoView frsTopItemInfoView = this.f58530b;
        if (frsTopItemInfoView != null) {
            frsTopItemInfoView.setData(itemInfo);
        }
    }
}
