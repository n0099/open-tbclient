package tv.athena.revenue.payui.view.adapter;

import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.hac;
import com.baidu.tieba.xac;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes2.dex */
public class PayCampaignListItemDecoration extends RecyclerView.ItemDecoration {
    public int a = 14;
    public int b = 15;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view2);
        boolean z = true;
        int i = 0;
        if (itemCount == 1) {
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.rl_item_content);
            relativeLayout.measure(0, 0);
            int measuredWidth = relativeLayout.getMeasuredWidth() + hac.a(this.a);
            int b = ((xac.b(view2.getContext()) - measuredWidth) / 2) - hac.a(this.b);
            rect.left = b;
            RLog.debug("PayCampaignListItemDecoration", "getItemOffsets itemCount == 1 width:" + measuredWidth + " marginLeft:" + b + " position:" + childAdapterPosition);
        } else if (itemCount == 2) {
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.rl_item_content);
            relativeLayout2.measure(0, 0);
            int measuredWidth2 = relativeLayout2.getMeasuredWidth() + hac.a(this.a);
            int b2 = xac.b(view2.getContext()) / 2;
            if (childAdapterPosition == 0) {
                i = ((b2 - (hac.a(this.a) / 2)) - measuredWidth2) - hac.a(this.b);
                rect.left = i;
            } else if (childAdapterPosition == 1) {
                i = hac.a(this.a) / 2;
                rect.left = i;
            }
            RLog.debug("PayCampaignListItemDecoration", "getItemOffsets itemCount == 2 width:" + measuredWidth2 + " marginLeft:" + i + " position:" + childAdapterPosition);
        } else {
            if (childAdapterPosition != itemCount - 1) {
                z = false;
            }
            if (z) {
                rect.right = hac.a(15.0f);
            }
            RLog.debug("PayCampaignListItemDecoration", "getItemOffsets itemCount > 2 default position:" + childAdapterPosition + " isLastItem：" + z);
        }
    }
}
