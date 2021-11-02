package com.facebook.drawee.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class MultiDraweeHolder<DH extends DraweeHierarchy> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting
    public ArrayList<DraweeHolder<DH>> mHolders;
    @VisibleForTesting
    public boolean mIsAttached;

    public MultiDraweeHolder() {
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
        this.mIsAttached = false;
        this.mHolders = new ArrayList<>();
    }

    public void add(DraweeHolder<DH> draweeHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, draweeHolder) == null) {
            add(this.mHolders.size(), draweeHolder);
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mIsAttached) {
                for (int i2 = 0; i2 < this.mHolders.size(); i2++) {
                    this.mHolders.get(i2).onDetach();
                }
            }
            this.mHolders.clear();
        }
    }

    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            for (int i2 = 0; i2 < this.mHolders.size(); i2++) {
                Drawable topLevelDrawable = get(i2).getTopLevelDrawable();
                if (topLevelDrawable != null) {
                    topLevelDrawable.draw(canvas);
                }
            }
        }
    }

    public DraweeHolder<DH> get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.mHolders.get(i2) : (DraweeHolder) invokeI.objValue;
    }

    public void onAttach() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.mIsAttached) {
            return;
        }
        this.mIsAttached = true;
        for (int i2 = 0; i2 < this.mHolders.size(); i2++) {
            this.mHolders.get(i2).onAttach();
        }
    }

    public void onDetach() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.mIsAttached) {
            this.mIsAttached = false;
            for (int i2 = 0; i2 < this.mHolders.size(); i2++) {
                this.mHolders.get(i2).onDetach();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            for (int i2 = 0; i2 < this.mHolders.size(); i2++) {
                if (this.mHolders.get(i2).onTouchEvent(motionEvent)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void remove(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            DraweeHolder<DH> draweeHolder = this.mHolders.get(i2);
            if (this.mIsAttached) {
                draweeHolder.onDetach();
            }
            this.mHolders.remove(i2);
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mHolders.size() : invokeV.intValue;
    }

    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, drawable)) == null) {
            for (int i2 = 0; i2 < this.mHolders.size(); i2++) {
                if (drawable == get(i2).getTopLevelDrawable()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void add(int i2, DraweeHolder<DH> draweeHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, draweeHolder) == null) {
            Preconditions.checkNotNull(draweeHolder);
            Preconditions.checkElementIndex(i2, this.mHolders.size() + 1);
            this.mHolders.add(i2, draweeHolder);
            if (this.mIsAttached) {
                draweeHolder.onAttach();
            }
        }
    }
}
