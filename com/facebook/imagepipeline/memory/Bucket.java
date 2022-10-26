package com.facebook.imagepipeline.memory;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class Bucket {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BUCKET";
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean mFixBucketsReinitialization;
    public final Queue mFreeList;
    public int mInUseLength;
    public final int mItemSize;
    public final int mMaxLength;

    public Bucket(int i, int i2, int i3, boolean z) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        if (i2 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        Preconditions.checkState(i3 >= 0);
        this.mItemSize = i;
        this.mMaxLength = i2;
        this.mFreeList = new LinkedList();
        this.mInUseLength = i3;
        this.mFixBucketsReinitialization = z;
    }

    public void addToFreeList(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            this.mFreeList.add(obj);
        }
    }

    public void decrementInUseCount() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.mInUseLength > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z);
            this.mInUseLength--;
        }
    }

    @Nullable
    @Deprecated
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object pop = pop();
            if (pop != null) {
                this.mInUseLength++;
            }
            return pop;
        }
        return invokeV.objValue;
    }

    public int getFreeListSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mFreeList.size();
        }
        return invokeV.intValue;
    }

    public int getInUseCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mInUseLength;
        }
        return invokeV.intValue;
    }

    public void incrementInUseCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mInUseLength++;
        }
    }

    public boolean isMaxLengthExceeded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mInUseLength + getFreeListSize() > this.mMaxLength) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public Object pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mFreeList.poll();
        }
        return invokeV.objValue;
    }

    public void release(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj) == null) {
            Preconditions.checkNotNull(obj);
            boolean z = false;
            if (this.mFixBucketsReinitialization) {
                if (this.mInUseLength > 0) {
                    z = true;
                }
                Preconditions.checkState(z);
                this.mInUseLength--;
                addToFreeList(obj);
                return;
            }
            int i = this.mInUseLength;
            if (i > 0) {
                this.mInUseLength = i - 1;
                addToFreeList(obj);
                return;
            }
            FLog.e(TAG, "Tried to release value %s from an empty bucket!", obj);
        }
    }
}
