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
import h.a.a.e.h.c;
/* loaded from: classes8.dex */
public class PayAmountGridItemDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f45917b;

    /* renamed from: c  reason: collision with root package name */
    public int f45918c;

    /* renamed from: d  reason: collision with root package name */
    public int f45919d;

    /* renamed from: e  reason: collision with root package name */
    public GridLayoutManager f45920e;

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
        this.f45917b = i2;
        this.f45918c = i3;
        this.f45919d = i4;
        this.f45920e = gridLayoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
            View findViewByPosition = this.f45920e.findViewByPosition(this.f45919d);
            boolean z = findViewByPosition != null && findViewByPosition.getVisibility() == 0;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = -1;
            int i2 = this.f45919d;
            if (childAdapterPosition == i2) {
                rect.left = 0;
                rect.right = 0;
                rect.top = z ? c.a(2.0f) : 0;
            } else if (childAdapterPosition < i2) {
                int i3 = this.a;
                int i4 = childAdapterPosition % i3;
                int i5 = this.f45918c;
                rect.left = (i4 * i5) / i3;
                rect.right = i5 - (((i4 + 1) * i5) / i3);
                rect.top = 0;
                i = i4;
            } else if (childAdapterPosition > i2) {
                int i6 = this.a;
                i = (childAdapterPosition - 1) % i6;
                int i7 = this.f45918c;
                rect.left = (i * i7) / i6;
                rect.right = i7 - (((i + 1) * i7) / i6);
                rect.top = z ? c.a(2.0f) : this.f45917b;
            }
            RLog.debug("PayAmountGridItemDecoration", "position:" + childAdapterPosition + "    columnIndex: " + i + "    left,right ->" + rect.left + "," + rect.right + " isCampaignItemVisible:" + z);
        }
    }
}
