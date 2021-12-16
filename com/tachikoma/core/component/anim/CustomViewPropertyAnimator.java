package com.tachikoma.core.component.anim;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.TKBase;
/* loaded from: classes3.dex */
public class CustomViewPropertyAnimator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TKBase<?> mBase;
    public final long mDuration;
    public final float mEnd;
    public final String mProperty;
    public final float mStart;

    public CustomViewPropertyAnimator(TKBase<?> tKBase, String str, long j2, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tKBase, str, Long.valueOf(j2), Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBase = tKBase;
        this.mProperty = str;
        this.mDuration = j2;
        this.mStart = f2;
        this.mEnd = f3;
    }

    public void start() {
        TKBase<?> tKBase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.mProperty) || (tKBase = this.mBase) == null || tKBase.getDomNode() == null) {
            return;
        }
        if (!"height".equals(this.mProperty) && !"width".equals(this.mProperty)) {
            ObjectAnimator.ofFloat(this.mBase.getView(), this.mProperty, this.mStart, this.mEnd).setDuration(this.mDuration).start();
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.mStart, this.mEnd);
        ofFloat.setDuration(this.mDuration);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.tachikoma.core.component.anim.CustomViewPropertyAnimator.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomViewPropertyAnimator this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) || this.this$0.mBase == null || this.this$0.mBase.getDomNode() == null || this.this$0.mBase.getDomNode().getYogaNode() == null) {
                    return;
                }
                if ("height".equals(this.this$0.mProperty)) {
                    this.this$0.mBase.getDomNode().getYogaNode().setHeight(((Number) valueAnimator.getAnimatedValue()).intValue());
                } else {
                    this.this$0.mBase.getDomNode().getYogaNode().setWidth(((Number) valueAnimator.getAnimatedValue()).intValue());
                }
                if (this.this$0.mBase.getView().getParent() != null) {
                    this.this$0.mBase.getView().getParent().requestLayout();
                }
            }
        });
        ofFloat.start();
    }
}
