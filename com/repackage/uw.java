package com.repackage;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class uw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Rect a(tn tnVar, View view2, int i) {
        InterceptResult invokeLLI;
        BdTypeRecyclerView bdTypeRecyclerView;
        RecyclerView.LayoutManager layoutManager;
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, tnVar, view2, i)) == null) {
            if (view2.getTag() instanceof AutoVideoCardViewHolder) {
                return ThreadCardUtils.computeViewArea(((AutoVideoCardViewHolder) view2.getTag()).v().getVideoContainer());
            }
            if (!(tnVar instanceof BdTypeRecyclerView) || (layoutManager = (bdTypeRecyclerView = (BdTypeRecyclerView) tnVar).getLayoutManager()) == null) {
                return null;
            }
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            List<nn> data = tnVar.getData();
            Object item = ListUtils.getItem(data, i);
            if (item instanceof BaseCardInfo) {
                BaseCardInfo baseCardInfo = (BaseCardInfo) item;
                int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                for (int i2 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i2 <= lastVisiblePosition; i2++) {
                    Object item2 = ListUtils.getItem(data, i2 - headerViewsCount);
                    if ((item2 instanceof BaseCardInfo) && baseCardInfo.position == ((BaseCardInfo) item2).position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null && (findViewByPosition.getTag() instanceof AutoVideoCardViewHolder)) {
                        return ThreadCardUtils.computeViewArea(((AutoVideoCardViewHolder) findViewByPosition.getTag()).v().getVideoContainer());
                    }
                }
                return null;
            }
            return null;
        }
        return (Rect) invokeLLI.objValue;
    }
}
