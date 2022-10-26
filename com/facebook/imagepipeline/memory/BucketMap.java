package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class BucketMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public LinkedEntry mHead;
    public final SparseArray mMap;
    @Nullable
    public LinkedEntry mTail;

    /* renamed from: com.facebook.imagepipeline.memory.BucketMap$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class LinkedEntry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int key;
        @Nullable
        public LinkedEntry next;
        @Nullable
        public LinkedEntry prev;
        public LinkedList value;

        public LinkedEntry(@Nullable LinkedEntry linkedEntry, int i, LinkedList linkedList, @Nullable LinkedEntry linkedEntry2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedEntry, Integer.valueOf(i), linkedList, linkedEntry2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.prev = linkedEntry;
            this.key = i;
            this.value = linkedList;
            this.next = linkedEntry2;
        }

        public /* synthetic */ LinkedEntry(LinkedEntry linkedEntry, int i, LinkedList linkedList, LinkedEntry linkedEntry2, AnonymousClass1 anonymousClass1) {
            this(linkedEntry, i, linkedList, linkedEntry2);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "LinkedEntry(key: " + this.key + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    public BucketMap() {
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
        this.mMap = new SparseArray();
    }

    @Nullable
    public synchronized Object removeFromEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                LinkedEntry linkedEntry = this.mTail;
                if (linkedEntry == null) {
                    return null;
                }
                Object pollLast = linkedEntry.value.pollLast();
                maybePrune(linkedEntry);
                return pollLast;
            }
        }
        return invokeV.objValue;
    }

    public synchronized int valueCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                i = 0;
                for (LinkedEntry linkedEntry = this.mHead; linkedEntry != null; linkedEntry = linkedEntry.next) {
                    if (linkedEntry.value != null) {
                        i += linkedEntry.value.size();
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    private void maybePrune(LinkedEntry linkedEntry) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, linkedEntry) == null) && linkedEntry != null && linkedEntry.value.isEmpty()) {
            prune(linkedEntry);
            this.mMap.remove(linkedEntry.key);
        }
    }

    private void moveToFront(LinkedEntry linkedEntry) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, this, linkedEntry) != null) || this.mHead == linkedEntry) {
            return;
        }
        prune(linkedEntry);
        LinkedEntry linkedEntry2 = this.mHead;
        if (linkedEntry2 == null) {
            this.mHead = linkedEntry;
            this.mTail = linkedEntry;
            return;
        }
        linkedEntry.next = linkedEntry2;
        linkedEntry2.prev = linkedEntry;
        this.mHead = linkedEntry;
    }

    private synchronized void prune(LinkedEntry linkedEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, linkedEntry) == null) {
            synchronized (this) {
                LinkedEntry linkedEntry2 = linkedEntry.prev;
                LinkedEntry linkedEntry3 = linkedEntry.next;
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
    public synchronized Object acquire(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            synchronized (this) {
                LinkedEntry linkedEntry = (LinkedEntry) this.mMap.get(i);
                if (linkedEntry == null) {
                    return null;
                }
                Object pollFirst = linkedEntry.value.pollFirst();
                moveToFront(linkedEntry);
                return pollFirst;
            }
        }
        return invokeI.objValue;
    }

    public synchronized void release(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, obj) == null) {
            synchronized (this) {
                LinkedEntry linkedEntry = (LinkedEntry) this.mMap.get(i);
                if (linkedEntry == null) {
                    linkedEntry = new LinkedEntry(null, i, new LinkedList(), null, null);
                    this.mMap.put(i, linkedEntry);
                }
                linkedEntry.value.addLast(obj);
                moveToFront(linkedEntry);
            }
        }
    }
}
