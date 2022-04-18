package tv.athena.revenue.payui.view.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j6a;
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
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view2, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
            View findViewByPosition = this.e.findViewByPosition(this.d);
            boolean z = findViewByPosition != null && findViewByPosition.getVisibility() == 0;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view2);
            int i = -1;
            int i2 = this.d;
            if (childAdapterPosition == i2) {
                rect.left = 0;
                rect.right = 0;
                rect.top = z ? j6a.a(2.0f) : 0;
            } else if (childAdapterPosition < i2) {
                int i3 = this.a;
                int i4 = childAdapterPosition % i3;
                int i5 = this.c;
                rect.left = (i4 * i5) / i3;
                rect.right = i5 - (((i4 + 1) * i5) / i3);
                rect.top = 0;
                i = i4;
            } else if (childAdapterPosition > i2) {
                int i6 = this.a;
                i = (childAdapterPosition - 1) % i6;
                int i7 = this.c;
                rect.left = (i * i7) / i6;
                rect.right = i7 - (((i + 1) * i7) / i6);
                rect.top = z ? j6a.a(2.0f) : this.b;
            }
            RLog.debug("PayAmountGridItemDecoration", "position:" + childAdapterPosition + "    columnIndex: " + i + "    left,right ->" + rect.left + "," + rect.right + " isCampaignItemVisible:" + z);
        }
    }
}
