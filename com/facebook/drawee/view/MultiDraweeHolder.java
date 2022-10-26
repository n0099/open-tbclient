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
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class MultiDraweeHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList mHolders;
    public boolean mIsAttached;

    public MultiDraweeHolder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsAttached = false;
        this.mHolders = new ArrayList();
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mIsAttached) {
                for (int i = 0; i < this.mHolders.size(); i++) {
                    ((DraweeHolder) this.mHolders.get(i)).onDetach();
                }
            }
            this.mHolders.clear();
        }
    }

    public void onAttach() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.mIsAttached) {
            return;
        }
        this.mIsAttached = true;
        for (int i = 0; i < this.mHolders.size(); i++) {
            ((DraweeHolder) this.mHolders.get(i)).onAttach();
        }
    }

    public void onDetach() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || !this.mIsAttached) {
            return;
        }
        this.mIsAttached = false;
        for (int i = 0; i < this.mHolders.size(); i++) {
            ((DraweeHolder) this.mHolders.get(i)).onDetach();
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mHolders.size();
        }
        return invokeV.intValue;
    }

    public void add(int i, DraweeHolder draweeHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, draweeHolder) == null) {
            Preconditions.checkNotNull(draweeHolder);
            Preconditions.checkElementIndex(i, this.mHolders.size() + 1);
            this.mHolders.add(i, draweeHolder);
            if (this.mIsAttached) {
                draweeHolder.onAttach();
            }
        }
    }

    public void add(DraweeHolder draweeHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, draweeHolder) == null) {
            add(this.mHolders.size(), draweeHolder);
        }
    }

    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            for (int i = 0; i < this.mHolders.size(); i++) {
                Drawable topLevelDrawable = get(i).getTopLevelDrawable();
                if (topLevelDrawable != null) {
                    topLevelDrawable.draw(canvas);
                }
            }
        }
    }

    public DraweeHolder get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return (DraweeHolder) this.mHolders.get(i);
        }
        return (DraweeHolder) invokeI.objValue;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            for (int i = 0; i < this.mHolders.size(); i++) {
                if (((DraweeHolder) this.mHolders.get(i)).onTouchEvent(motionEvent)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void remove(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            DraweeHolder draweeHolder = (DraweeHolder) this.mHolders.get(i);
            if (this.mIsAttached) {
                draweeHolder.onDetach();
            }
            this.mHolders.remove(i);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, drawable)) == null) {
            for (int i = 0; i < this.mHolders.size(); i++) {
                if (drawable == get(i).getTopLevelDrawable()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
