package tv.athena.revenue.payui.view.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.p5a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes9.dex */
public class PayAmountGridItemDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public GridLayoutManager e;

    public PayAmountGridItemDecoration(int i, int i2, int i3, int i4, GridLayoutManager gridLayoutManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), gridLayoutManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = gridLayoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
            View findViewByPosition = this.e.findViewByPosition(this.d);
            int i2 = 0;
            if (findViewByPosition == null || findViewByPosition.getVisibility() != 0) {
                z = false;
            } else {
                z = true;
            }
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view2);
            int i3 = -1;
            int i4 = this.d;
            if (childAdapterPosition == i4) {
                rect.left = 0;
                rect.right = 0;
                if (z) {
                    i2 = p5a.a(2.0f);
                }
                rect.top = i2;
            } else if (childAdapterPosition < i4) {
                int i5 = this.a;
                int i6 = childAdapterPosition % i5;
                int i7 = this.c;
                rect.left = (i6 * i7) / i5;
                rect.right = i7 - (((i6 + 1) * i7) / i5);
                rect.top = 0;
                i3 = i6;
            } else if (childAdapterPosition > i4) {
                int i8 = this.a;
                i3 = (childAdapterPosition - 1) % i8;
                int i9 = this.c;
                rect.left = (i3 * i9) / i8;
                rect.right = i9 - (((i3 + 1) * i9) / i8);
                if (z) {
                    i = p5a.a(2.0f);
                } else {
                    i = this.b;
                }
                rect.top = i;
            }
            RLog.debug("PayAmountGridItemDecoration", "position:" + childAdapterPosition + "    columnIndex: " + i3 + "    left,right ->" + rect.left + "," + rect.right + " isCampaignItemVisible:" + z);
        }
    }
}
