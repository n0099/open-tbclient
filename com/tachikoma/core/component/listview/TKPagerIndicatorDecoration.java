package com.tachikoma.core.component.listview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class TKPagerIndicatorDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float mIndicatorHeight;
    public final float mIndicatorItemPadding;
    public final IIndicatorRender mIndicatorRender;
    public final float mIndicatorWidth;
    public final Interpolator mInterpolator;
    public final Paint mPaint;

    /* loaded from: classes7.dex */
    public interface IIndicatorRender {
        void drawHighlights(float f2, float f3, float f4, float f5, int i, int i2, Paint paint, Canvas canvas);

        void drawInactiveIndicators(float f2, float f3, float f4, float f5, Paint paint, Canvas canvas);

        float getIndicatorHeight();

        float getIndicatorPadding();

        int getIndicatorTopMargin();

        float getIndicatorWidth();

        Paint getPaint();

        void setItemWidth(int i);

        void setTextSize(int i);
    }

    public TKPagerIndicatorDecoration(@NonNull IIndicatorRender iIndicatorRender) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iIndicatorRender};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInterpolator = new AccelerateDecelerateInterpolator();
        this.mIndicatorRender = iIndicatorRender;
        this.mPaint = iIndicatorRender.getPaint();
        this.mIndicatorHeight = this.mIndicatorRender.getIndicatorHeight();
        this.mIndicatorWidth = this.mIndicatorRender.getIndicatorWidth();
        this.mIndicatorItemPadding = this.mIndicatorRender.getIndicatorPadding();
    }

    private void drawHighlights(Canvas canvas, float f2, float f3, int i, float f4, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i), Float.valueOf(f4), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            float f5 = this.mIndicatorWidth;
            float f6 = this.mIndicatorItemPadding + f5;
            float f7 = f2 + (i * f6);
            if (f4 == 0.0f) {
                this.mIndicatorRender.drawHighlights(f7, f3, f7 + f5, f3, i2, i3, this.mPaint, canvas);
                return;
            }
            float f8 = f5 * f4;
            this.mIndicatorRender.drawHighlights(f7 + f8, f3, f7 + f5, f3, i2, i3, this.mPaint, canvas);
            if (i < i2 - 1) {
                float f9 = f7 + f6;
                this.mIndicatorRender.drawHighlights(f9, f3, f9 + f8, f3, i2, i3, this.mPaint, canvas);
            }
        }
    }

    private void drawInactiveIndicators(Canvas canvas, float f2, float f3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i)}) == null) {
            float f4 = this.mIndicatorWidth + this.mIndicatorItemPadding;
            for (int i2 = 0; i2 < i; i2++) {
                this.mIndicatorRender.drawInactiveIndicators(f2, f3, f2 + this.mIndicatorWidth, f3, this.mPaint, canvas);
                f2 += f4;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.bottom = this.mIndicatorRender.getIndicatorTopMargin();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, recyclerView, state) == null) {
            super.onDrawOver(canvas, recyclerView, state);
            if (recyclerView.getAdapter() == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                return;
            }
            int itemCount = recyclerView.getAdapter().getItemCount();
            float width = (recyclerView.getWidth() - ((this.mIndicatorWidth * itemCount) + (Math.max(0, itemCount - 1) * this.mIndicatorItemPadding))) / 2.0f;
            float height = recyclerView.getHeight() - (this.mIndicatorHeight / 2.0f);
            drawInactiveIndicators(canvas, width, height, itemCount);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition == -1) {
                findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            }
            int i = findFirstCompletelyVisibleItemPosition;
            if (i == -1 || (findViewByPosition = linearLayoutManager.findViewByPosition(i)) == null) {
                return;
            }
            drawHighlights(canvas, width, height, i, this.mInterpolator.getInterpolation((findViewByPosition.getLeft() * (-1)) / findViewByPosition.getWidth()), itemCount, i);
        }
    }
}
