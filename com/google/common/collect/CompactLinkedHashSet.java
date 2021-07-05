package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.c.u0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
/* loaded from: classes7.dex */
public class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ENDPOINT = -2;
    public transient /* synthetic */ FieldHolder $fh;
    public transient int firstEntry;
    public transient int lastEntry;
    public transient int[] predecessor;
    public transient int[] successor;

    public CompactLinkedHashSet() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <E> CompactLinkedHashSet<E> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new CompactLinkedHashSet<>() : (CompactLinkedHashSet) invokeV.objValue;
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? new CompactLinkedHashSet<>(i2) : (CompactLinkedHashSet) invokeI.objValue;
    }

    private int getPredecessor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2)) == null) ? this.predecessor[i2] : invokeI.intValue;
    }

    private void setPredecessor(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, this, i2, i3) == null) {
            this.predecessor[i2] = i3;
        }
    }

    private void setSucceeds(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65544, this, i2, i3) == null) {
            if (i2 == -2) {
                this.firstEntry = i3;
            } else {
                setSuccessor(i2, i3);
            }
            if (i3 == -2) {
                this.lastEntry = i2;
            } else {
                setPredecessor(i3, i2);
            }
        }
    }

    private void setSuccessor(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65545, this, i2, i3) == null) {
            this.successor[i2] = i3;
        }
    }

    @Override // com.google.common.collect.CompactHashSet
    public int adjustAfterRemove(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? i2 >= size() ? i3 : i2 : invokeII.intValue;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void allocArrays() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.allocArrays();
            int length = this.elements.length;
            int[] iArr = new int[length];
            this.predecessor = iArr;
            this.successor = new int[length];
            Arrays.fill(iArr, -1);
            Arrays.fill(this.successor, -1);
        }
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || needsAllocArrays()) {
            return;
        }
        this.firstEntry = -2;
        this.lastEntry = -2;
        Arrays.fill(this.predecessor, 0, size(), -1);
        Arrays.fill(this.successor, 0, size(), -1);
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashSet
    public int firstEntryIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.firstEntry : invokeV.intValue;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int getSuccessor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.successor[i2] : invokeI.intValue;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void init(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.init(i2);
            this.firstEntry = -2;
            this.lastEntry = -2;
        }
    }

    @Override // com.google.common.collect.CompactHashSet
    public void insertEntry(int i2, E e2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), e2, Integer.valueOf(i3)}) == null) {
            super.insertEntry(i2, e2, i3);
            setSucceeds(this.lastEntry, i2);
            setSucceeds(i2, -2);
        }
    }

    @Override // com.google.common.collect.CompactHashSet
    public void moveLastEntry(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            int size = size() - 1;
            super.moveLastEntry(i2);
            setSucceeds(getPredecessor(i2), getSuccessor(i2));
            if (i2 < size) {
                setSucceeds(getPredecessor(size), i2);
                setSucceeds(i2, getSuccessor(size));
            }
            this.predecessor[size] = -1;
            this.successor[size] = -1;
        }
    }

    @Override // com.google.common.collect.CompactHashSet
    public void resizeEntries(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.resizeEntries(i2);
            int[] iArr = this.predecessor;
            int length = iArr.length;
            this.predecessor = Arrays.copyOf(iArr, i2);
            this.successor = Arrays.copyOf(this.successor, i2);
            if (length < i2) {
                Arrays.fill(this.predecessor, length, i2, -1);
                Arrays.fill(this.successor, length, i2, -1);
            }
        }
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? u0.h(this) : (Object[]) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompactLinkedHashSet(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, collection)) == null) {
            CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
            createWithExpectedSize.addAll(collection);
            return createWithExpectedSize;
        }
        return (CompactLinkedHashSet) invokeL.objValue;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, tArr)) == null) ? (T[]) u0.i(this, tArr) : (T[]) ((Object[]) invokeL.objValue);
    }

    public static <E> CompactLinkedHashSet<E> create(E... eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, eArr)) == null) {
            CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
            Collections.addAll(createWithExpectedSize, eArr);
            return createWithExpectedSize;
        }
        return (CompactLinkedHashSet) invokeL.objValue;
    }
}
