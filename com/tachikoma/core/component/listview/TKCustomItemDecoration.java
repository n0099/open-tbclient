package com.tachikoma.core.component.listview;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.recyclerview.export.TKWaterLayoutConfiguration;
/* loaded from: classes8.dex */
public class TKCustomItemDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TKWaterLayoutConfiguration mConfiguration;

    public TKCustomItemDecoration(TKWaterLayoutConfiguration tKWaterLayoutConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tKWaterLayoutConfiguration};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mConfiguration = tKWaterLayoutConfiguration;
    }

    private void offsetGridLayoutRowAndEdge(Rect rect, View view2, RecyclerView recyclerView) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, this, rect, view2, recyclerView) == null) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            int spanCount = ((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
            if (spanCount <= 1) {
                offsetLinearLayoutRowAndEdge(rect, view2, recyclerView);
                return;
            }
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view2);
            if (childAdapterPosition == -1) {
                return;
            }
            int itemCount = recyclerView.getLayoutManager().getItemCount();
            int i2 = childAdapterPosition + 1;
            if (i2 % spanCount != 0) {
                TKWaterLayoutConfiguration tKWaterLayoutConfiguration = this.mConfiguration;
                rect.left = tKWaterLayoutConfiguration.edgePadding;
                if (childAdapterPosition != itemCount) {
                    i = tKWaterLayoutConfiguration.centerPadding;
                }
                if (itemCount > spanCount || i2 <= spanCount) {
                }
                rect.top = this.mConfiguration.rowPadding;
                return;
            }
            i = this.mConfiguration.edgePadding;
            rect.right = i;
            if (itemCount > spanCount) {
            }
        }
    }

    private void offsetLinearLayoutRowAndEdge(Rect rect, View view2, RecyclerView recyclerView) {
        int childAdapterPosition;
        RecyclerView.Adapter adapter;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, this, rect, view2, recyclerView) == null) || (childAdapterPosition = recyclerView.getChildAdapterPosition(view2)) == -1 || (adapter = recyclerView.getAdapter()) == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        if (((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation() == 1) {
            if (childAdapterPosition != adapter.getItemCount() - 1 && childAdapterPosition != 0) {
                rect.top = this.mConfiguration.rowPadding;
            }
            i = this.mConfiguration.edgePadding;
            rect.left = i;
        } else {
            if (childAdapterPosition != adapter.getItemCount() - 1) {
                rect.right = this.mConfiguration.centerPadding;
            }
            if (childAdapterPosition == 0) {
                rect.left = this.mConfiguration.edgePadding;
            }
            if (childAdapterPosition != adapter.getItemCount() - 1) {
                return;
            }
            i = this.mConfiguration.edgePadding;
        }
        rect.right = i;
    }

    private void offsetStaggerGridLayoutRowAndEdge(Rect rect, View view2, RecyclerView recyclerView) {
        TKWaterLayoutConfiguration tKWaterLayoutConfiguration;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, this, rect, view2, recyclerView) == null) && (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager)) {
            int spanCount = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view2);
            if (spanCount > 1) {
                int spanIndex = ((StaggeredGridLayoutManager.LayoutParams) view2.getLayoutParams()).getSpanIndex();
                if (spanIndex == -1) {
                    return;
                }
                if (spanIndex == 0) {
                    rect.left = this.mConfiguration.edgePadding;
                }
                int i = spanCount - 1;
                if (spanIndex != i) {
                    rect.right = this.mConfiguration.centerPadding;
                }
                if (spanIndex == i) {
                    rect.right = this.mConfiguration.edgePadding;
                }
                if (childAdapterPosition + 1 <= spanCount) {
                    return;
                }
                tKWaterLayoutConfiguration = this.mConfiguration;
            } else {
                tKWaterLayoutConfiguration = this.mConfiguration;
                int i2 = tKWaterLayoutConfiguration.edgePadding;
                rect.left = i2;
                rect.right = i2;
                if (childAdapterPosition + 1 <= spanCount) {
                    return;
                }
            }
            rect.top = tKWaterLayoutConfiguration.rowPadding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view2, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
            super.getItemOffsets(rect, view2, recyclerView, state);
            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                offsetGridLayoutRowAndEdge(rect, view2, recyclerView);
            } else if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                offsetStaggerGridLayoutRowAndEdge(rect, view2, recyclerView);
            } else if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                offsetLinearLayoutRowAndEdge(rect, view2, recyclerView);
            }
        }
    }
}
