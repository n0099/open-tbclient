package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.infer.annotation.ThreadSafe;
import java.util.LinkedList;
import javax.annotation.Nullable;
@ThreadSafe
/* loaded from: classes7.dex */
public class BucketMap<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting
    @Nullable
    public LinkedEntry<T> mHead;
    public final SparseArray<LinkedEntry<T>> mMap;
    @VisibleForTesting
    @Nullable
    public LinkedEntry<T> mTail;

    /* renamed from: com.facebook.imagepipeline.memory.BucketMap$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class LinkedEntry<I> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int key;
        @Nullable
        public LinkedEntry<I> next;
        @Nullable
        public LinkedEntry<I> prev;
        public LinkedList<I> value;

        public /* synthetic */ LinkedEntry(LinkedEntry linkedEntry, int i2, LinkedList linkedList, LinkedEntry linkedEntry2, AnonymousClass1 anonymousClass1) {
            this(linkedEntry, i2, linkedList, linkedEntry2);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "LinkedEntry(key: " + this.key + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }

        public LinkedEntry(@Nullable LinkedEntry<I> linkedEntry, int i2, LinkedList<I> linkedList, @Nullable LinkedEntry<I> linkedEntry2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedEntry, Integer.valueOf(i2), linkedList, linkedEntry2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.prev = linkedEntry;
            this.key = i2;
            this.value = linkedList;
            this.next = linkedEntry2;
        }
    }

    public BucketMap() {
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
        this.mMap = new SparseArray<>();
    }

    private void maybePrune(LinkedEntry<T> linkedEntry) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, linkedEntry) == null) && linkedEntry != null && linkedEntry.value.isEmpty()) {
            prune(linkedEntry);
            this.mMap.remove(linkedEntry.key);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.facebook.imagepipeline.memory.BucketMap$LinkedEntry<T> */
    /* JADX WARN: Multi-variable type inference failed */
    private void moveToFront(LinkedEntry<T> linkedEntry) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, linkedEntry) == null) || this.mHead == linkedEntry) {
            return;
        }
        prune(linkedEntry);
        LinkedEntry linkedEntry2 = (LinkedEntry<T>) this.mHead;
        if (linkedEntry2 == null) {
            this.mHead = linkedEntry;
            this.mTail = linkedEntry;
            return;
        }
        linkedEntry.next = linkedEntry2;
        linkedEntry2.prev = linkedEntry;
        this.mHead = linkedEntry;
    }

    private synchronized void prune(LinkedEntry<T> linkedEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, linkedEntry) == null) {
            synchronized (this) {
                LinkedEntry linkedEntry2 = (LinkedEntry<T>) linkedEntry.prev;
                LinkedEntry linkedEntry3 = (LinkedEntry<T>) linkedEntry.next;
                if (linkedEntry2 != null) {
                    linkedEntry2.next = linkedEntry3;
                }
                if (linkedEntry3 != null) {
                    linkedEntry3.prev = linkedEntry2;
                }
                linkedEntry.prev = null;
                linkedEntry.next = null;
                if (linkedEntry == this.mHead) {
                    this.mHead = linkedEntry3;
                }
                if (linkedEntry == this.mTail) {
                    this.mTail = linkedEntry2;
                }
            }
        }
    }

    @Nullable
    public synchronized T acquire(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            synchronized (this) {
                LinkedEntry<T> linkedEntry = this.mMap.get(i2);
                if (linkedEntry == null) {
                    return null;
                }
                T pollFirst = linkedEntry.value.pollFirst();
                moveToFront(linkedEntry);
                return pollFirst;
            }
        }
        return (T) invokeI.objValue;
    }

    public synchronized void release(int i2, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, t) == null) {
            synchronized (this) {
                LinkedEntry<T> linkedEntry = this.mMap.get(i2);
                if (linkedEntry == null) {
                    linkedEntry = new LinkedEntry<>(null, i2, new LinkedList(), null, null);
                    this.mMap.put(i2, linkedEntry);
                }
                linkedEntry.value.addLast(t);
                moveToFront(linkedEntry);
            }
        }
    }

    @Nullable
    public synchronized T removeFromEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                LinkedEntry<T> linkedEntry = this.mTail;
                if (linkedEntry == null) {
                    return null;
                }
                T pollLast = linkedEntry.value.pollLast();
                maybePrune(linkedEntry);
                return pollLast;
            }
        }
        return (T) invokeV.objValue;
    }

    @VisibleForTesting
    public synchronized int valueCount() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                i2 = 0;
                for (LinkedEntry linkedEntry = this.mHead; linkedEntry != null; linkedEntry = linkedEntry.next) {
                    if (linkedEntry.value != null) {
                        i2 += linkedEntry.value.size();
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }
}
