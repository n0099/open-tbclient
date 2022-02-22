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
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import j.a.a.e.p.c;
/* loaded from: classes5.dex */
public class PayAmountGridItemDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f63224b;

    /* renamed from: c  reason: collision with root package name */
    public int f63225c;

    /* renamed from: d  reason: collision with root package name */
    public int f63226d;

    /* renamed from: e  reason: collision with root package name */
    public GridLayoutManager f63227e;

    public PayAmountGridItemDecoration(int i2, int i3, int i4, int i5, GridLayoutManager gridLayoutManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), gridLayoutManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i2;
        this.f63224b = i3;
        this.f63225c = i4;
        this.f63226d = i5;
        this.f63227e = gridLayoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
            View findViewByPosition = this.f63227e.findViewByPosition(this.f63226d);
            boolean z = findViewByPosition != null && findViewByPosition.getVisibility() == 0;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i2 = -1;
            int i3 = this.f63226d;
            if (childAdapterPosition == i3) {
                rect.left = 0;
                rect.right = 0;
                rect.top = z ? c.a(2.0f) : 0;
            } else if (childAdapterPosition < i3) {
                int i4 = this.a;
                int i5 = childAdapterPosition % i4;
                int i6 = this.f63225c;
                rect.left = (i5 * i6) / i4;
                rect.right = i6 - (((i5 + 1) * i6) / i4);
                rect.top = 0;
                i2 = i5;
            } else if (childAdapterPosition > i3) {
                int i7 = this.a;
                i2 = (childAdapterPosition - 1) % i7;
                int i8 = this.f63225c;
                rect.left = (i2 * i8) / i7;
                rect.right = i8 - (((i2 + 1) * i8) / i7);
                rect.top = z ? c.a(2.0f) : this.f63224b;
            }
            RLog.debug("PayAmountGridItemDecoration", "position:" + childAdapterPosition + "    columnIndex: " + i2 + "    left,right ->" + rect.left + "," + rect.right + " isCampaignItemVisible:" + z);
        }
    }
}
