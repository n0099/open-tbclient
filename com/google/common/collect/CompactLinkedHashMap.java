package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ENDPOINT = -2;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean accessOrder;
    public transient int firstEntry;
    public transient int lastEntry;
    public transient long[] links;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompactLinkedHashMap() {
        this(3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new CompactLinkedHashMap<>() : (CompactLinkedHashMap) invokeV.objValue;
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? new CompactLinkedHashMap<>(i2) : (CompactLinkedHashMap) invokeI.objValue;
    }

    private int getPredecessor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i2)) == null) ? (int) (this.links[i2] >>> 32) : invokeI.intValue;
    }

    private void setPredecessor(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65542, this, i2, i3) == null) {
            long[] jArr = this.links;
            jArr[i2] = (jArr[i2] & 4294967295L) | (i3 << 32);
        }
    }

    private void setSucceeds(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, this, i2, i3) == null) {
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
        if (interceptable == null || interceptable.invokeII(65544, this, i2, i3) == null) {
            long[] jArr = this.links;
            jArr[i2] = (jArr[i2] & (-4294967296L)) | (i3 & 4294967295L);
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    public void accessEntry(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && this.accessOrder) {
            setSucceeds(getPredecessor(i2), getSuccessor(i2));
            setSucceeds(this.lastEntry, i2);
            setSucceeds(i2, -2);
            this.modCount++;
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    public int adjustAfterRemove(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) ? i2 >= size() ? i3 : i2 : invokeII.intValue;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void allocArrays() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.allocArrays();
            long[] jArr = new long[this.keys.length];
            this.links = jArr;
            Arrays.fill(jArr, -1L);
        }
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || needsAllocArrays()) {
            return;
        }
        this.firstEntry = -2;
        this.lastEntry = -2;
        Arrays.fill(this.links, 0, size(), -1L);
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    public int firstEntryIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.firstEntry : invokeV.intValue;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int getSuccessor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? (int) this.links[i2] : invokeI.intValue;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void init(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.init(i2);
            this.firstEntry = -2;
            this.lastEntry = -2;
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    public void insertEntry(int i2, K k2, V v, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), k2, v, Integer.valueOf(i3)}) == null) {
            super.insertEntry(i2, k2, v, i3);
            setSucceeds(this.lastEntry, i2);
            setSucceeds(i2, -2);
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    public void moveLastEntry(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            int size = size() - 1;
            super.moveLastEntry(i2);
            setSucceeds(getPredecessor(i2), getSuccessor(i2));
            if (i2 < size) {
                setSucceeds(getPredecessor(size), i2);
                setSucceeds(i2, getSuccessor(size));
            }
            this.links[size] = -1;
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    public void resizeEntries(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.resizeEntries(i2);
            long[] jArr = this.links;
            int length = jArr.length;
            long[] copyOf = Arrays.copyOf(jArr, i2);
            this.links = copyOf;
            if (length < i2) {
                Arrays.fill(copyOf, length, i2, -1L);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompactLinkedHashMap(int i2) {
        this(i2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompactLinkedHashMap(int i2, boolean z) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.accessOrder = z;
    }
}
