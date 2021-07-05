package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
@Keep
/* loaded from: classes7.dex */
public class KSViewOffsetBehavior<V extends View> extends KSCoordinatorLayout.Behavior<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mTempLeftRightOffset;
    public int mTempTopBottomOffset;
    public KSViewOffsetHelper mViewOffsetHelper;

    public KSViewOffsetBehavior() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTempTopBottomOffset = 0;
        this.mTempLeftRightOffset = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTempTopBottomOffset = 0;
        this.mTempLeftRightOffset = 0;
    }

    public int getLeftAndRightOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            KSViewOffsetHelper kSViewOffsetHelper = this.mViewOffsetHelper;
            if (kSViewOffsetHelper != null) {
                return kSViewOffsetHelper.getLeftAndRightOffset();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getTopAndBottomOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            KSViewOffsetHelper kSViewOffsetHelper = this.mViewOffsetHelper;
            if (kSViewOffsetHelper != null) {
                return kSViewOffsetHelper.getTopAndBottomOffset();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void layoutChild(KSCoordinatorLayout kSCoordinatorLayout, V v, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, kSCoordinatorLayout, v, i2) == null) {
            kSCoordinatorLayout.onLayoutChild(v, i2);
        }
    }

    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onLayoutChild(KSCoordinatorLayout kSCoordinatorLayout, V v, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048579, this, kSCoordinatorLayout, v, i2)) == null) {
            layoutChild(kSCoordinatorLayout, v, i2);
            if (this.mViewOffsetHelper == null) {
                this.mViewOffsetHelper = new KSViewOffsetHelper(v);
            }
            this.mViewOffsetHelper.onViewLayout();
            int i3 = this.mTempTopBottomOffset;
            if (i3 != 0) {
                this.mViewOffsetHelper.setTopAndBottomOffset(i3);
                this.mTempTopBottomOffset = 0;
            }
            int i4 = this.mTempLeftRightOffset;
            if (i4 != 0) {
                this.mViewOffsetHelper.setLeftAndRightOffset(i4);
                this.mTempLeftRightOffset = 0;
                return true;
            }
            return true;
        }
        return invokeLLI.booleanValue;
    }

    public boolean setLeftAndRightOffset(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            KSViewOffsetHelper kSViewOffsetHelper = this.mViewOffsetHelper;
            if (kSViewOffsetHelper != null) {
                return kSViewOffsetHelper.setLeftAndRightOffset(i2);
            }
            this.mTempLeftRightOffset = i2;
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean setTopAndBottomOffset(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            KSViewOffsetHelper kSViewOffsetHelper = this.mViewOffsetHelper;
            if (kSViewOffsetHelper != null) {
                return kSViewOffsetHelper.setTopAndBottomOffset(i2);
            }
            this.mTempTopBottomOffset = i2;
            return false;
        }
        return invokeI.booleanValue;
    }
}
