package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class InterpolateOnScrollPositionChangeHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] containerLocation;
    public ScrollView containingScrollView;
    public MaterialShapeDrawable materialShapeDrawable;
    public final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    public final int[] scrollLocation;
    public View shapedView;

    public InterpolateOnScrollPositionChangeHelper(View view2, MaterialShapeDrawable materialShapeDrawable, ScrollView scrollView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, materialShapeDrawable, scrollView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.scrollLocation = new int[2];
        this.containerLocation = new int[2];
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener(this) { // from class: com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ InterpolateOnScrollPositionChangeHelper this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.updateInterpolationForScreenPosition();
                }
            }
        };
        this.shapedView = view2;
        this.materialShapeDrawable = materialShapeDrawable;
        this.containingScrollView = scrollView;
    }

    public void setContainingScrollView(ScrollView scrollView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, scrollView) == null) {
            this.containingScrollView = scrollView;
        }
    }

    public void setMaterialShapeDrawable(MaterialShapeDrawable materialShapeDrawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, materialShapeDrawable) == null) {
            this.materialShapeDrawable = materialShapeDrawable;
        }
    }

    public void startListeningForScrollChanges(@NonNull ViewTreeObserver viewTreeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewTreeObserver) == null) {
            viewTreeObserver.addOnScrollChangedListener(this.scrollChangedListener);
        }
    }

    public void stopListeningForScrollChanges(@NonNull ViewTreeObserver viewTreeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewTreeObserver) == null) {
            viewTreeObserver.removeOnScrollChangedListener(this.scrollChangedListener);
        }
    }

    public void updateInterpolationForScreenPosition() {
        ScrollView scrollView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (scrollView = this.containingScrollView) == null) {
            return;
        }
        if (scrollView.getChildCount() != 0) {
            this.containingScrollView.getLocationInWindow(this.scrollLocation);
            this.containingScrollView.getChildAt(0).getLocationInWindow(this.containerLocation);
            int top = (this.shapedView.getTop() - this.scrollLocation[1]) + this.containerLocation[1];
            int height = this.shapedView.getHeight();
            int height2 = this.containingScrollView.getHeight();
            if (top < 0) {
                this.materialShapeDrawable.setInterpolation(Math.max(0.0f, Math.min(1.0f, (top / height) + 1.0f)));
                this.shapedView.invalidate();
                return;
            }
            int i = top + height;
            if (i > height2) {
                this.materialShapeDrawable.setInterpolation(Math.max(0.0f, Math.min(1.0f, 1.0f - ((i - height2) / height))));
                this.shapedView.invalidate();
                return;
            } else if (this.materialShapeDrawable.getInterpolation() != 1.0f) {
                this.materialShapeDrawable.setInterpolation(1.0f);
                this.shapedView.invalidate();
                return;
            } else {
                return;
            }
        }
        throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
    }
}
