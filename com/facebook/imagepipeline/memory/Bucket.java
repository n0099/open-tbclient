package com.facebook.imagepipeline.memory;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@VisibleForTesting
@NotThreadSafe
/* loaded from: classes7.dex */
public class Bucket<V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BUCKET";
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean mFixBucketsReinitialization;
    public final Queue mFreeList;
    public int mInUseLength;
    public final int mItemSize;
    public final int mMaxLength;

    public Bucket(int i, int i2, int i3, boolean z) {
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
        Preconditions.checkState(i > 0);
        Preconditions.checkState(i2 >= 0);
        Preconditions.checkState(i3 >= 0);
        this.mItemSize = i;
        this.mMaxLength = i2;
        this.mFreeList = new LinkedList();
        this.mInUseLength = i3;
        this.mFixBucketsReinitialization = z;
    }

    public void addToFreeList(V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
            this.mFreeList.add(v);
        }
    }

    public void decrementInUseCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Preconditions.checkState(this.mInUseLength > 0);
            this.mInUseLength--;
        }
    }

    @Nullable
    @Deprecated
    public V get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            V pop = pop();
            if (pop != null) {
                this.mInUseLength++;
            }
            return pop;
        }
        return (V) invokeV.objValue;
    }

    public int getFreeListSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFreeList.size() : invokeV.intValue;
    }

    public int getInUseCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mInUseLength : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mInUseLength + getFreeListSize() > this.mMaxLength : invokeV.booleanValue;
    }

    @Nullable
    public V pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (V) this.mFreeList.poll() : (V) invokeV.objValue;
    }

    public void release(V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v) == null) {
            Preconditions.checkNotNull(v);
            if (this.mFixBucketsReinitialization) {
                Preconditions.checkState(this.mInUseLength > 0);
                this.mInUseLength--;
                addToFreeList(v);
                return;
            }
            int i = this.mInUseLength;
            if (i > 0) {
                this.mInUseLength = i - 1;
                addToFreeList(v);
                return;
            }
            FLog.e(TAG, "Tried to release value %s from an empty bucket!", v);
        }
    }
}
