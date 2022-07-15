package tv.athena.revenue.payui.view.adapter;

import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bz9;
import com.repackage.lz9;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes9.dex */
public class PayCampaignListItemDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public PayCampaignListItemDecoration() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 14;
        this.b = 15;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
            int itemCount = recyclerView.getAdapter().getItemCount();
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view2);
            int i = 0;
            if (itemCount == 1) {
                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b53);
                relativeLayout.measure(0, 0);
                int measuredWidth = relativeLayout.getMeasuredWidth() + bz9.a(this.a);
                int b = ((lz9.b(view2.getContext()) - measuredWidth) / 2) - bz9.a(this.b);
                rect.left = b;
                RLog.debug("PayCampaignListItemDecoration", "getItemOffsets itemCount == 1 width:" + measuredWidth + " marginLeft:" + b + " position:" + childAdapterPosition);
            } else if (itemCount == 2) {
                RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b53);
                relativeLayout2.measure(0, 0);
                int measuredWidth2 = relativeLayout2.getMeasuredWidth() + bz9.a(this.a);
                int b2 = lz9.b(view2.getContext()) / 2;
                if (childAdapterPosition == 0) {
                    i = ((b2 - (bz9.a(this.a) / 2)) - measuredWidth2) - bz9.a(this.b);
                    rect.left = i;
                } else if (childAdapterPosition == 1) {
                    i = bz9.a(this.a) / 2;
                    rect.left = i;
                }
                RLog.debug("PayCampaignListItemDecoration", "getItemOffsets itemCount == 2 width:" + measuredWidth2 + " marginLeft:" + i + " position:" + childAdapterPosition);
            } else {
                boolean z = childAdapterPosition == itemCount - 1;
                if (z) {
                    rect.right = bz9.a(15.0f);
                }
                RLog.debug("PayCampaignListItemDecoration", "getItemOffsets itemCount > 2 default position:" + childAdapterPosition + " isLastItem：" + z);
            }
        }
    }
}
