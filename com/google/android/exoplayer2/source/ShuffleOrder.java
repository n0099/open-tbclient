package com.google.android.exoplayer2.source;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Random;
/* loaded from: classes4.dex */
public interface ShuffleOrder {

    /* loaded from: classes4.dex */
    public static class DefaultShuffleOrder implements ShuffleOrder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] indexInShuffled;
        public final Random random;
        public final int[] shuffled;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DefaultShuffleOrder(int i) {
            this(i, new Random());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), (Random) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static int[] createShuffledList(int i, Random random) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, random)) == null) {
                int[] iArr = new int[i];
                int i2 = 0;
                while (i2 < i) {
                    int i3 = i2 + 1;
                    int nextInt = random.nextInt(i3);
                    iArr[i2] = iArr[nextInt];
                    iArr[nextInt] = i2;
                    i2 = i3;
                }
                return iArr;
            }
            return (int[]) invokeIL.objValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndInsert(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
                int[] iArr = new int[i2];
                int[] iArr2 = new int[i2];
                int i3 = 0;
                while (i3 < i2) {
                    iArr[i3] = this.random.nextInt(this.shuffled.length + 1);
                    int i4 = i3 + 1;
                    int nextInt = this.random.nextInt(i4);
                    iArr2[i3] = iArr2[nextInt];
                    iArr2[nextInt] = i3 + i;
                    i3 = i4;
                }
                Arrays.sort(iArr);
                int[] iArr3 = new int[this.shuffled.length + i2];
                int i5 = 0;
                int i6 = 0;
                for (int i7 = 0; i7 < this.shuffled.length + i2; i7++) {
                    if (i5 < i2 && i6 == iArr[i5]) {
                        iArr3[i7] = iArr2[i5];
                        i5++;
                    } else {
                        int i8 = i6 + 1;
                        iArr3[i7] = this.shuffled[i6];
                        if (iArr3[i7] >= i) {
                            iArr3[i7] = iArr3[i7] + i2;
                        }
                        i6 = i8;
                    }
                }
                return new DefaultShuffleOrder(iArr3, new Random(this.random.nextLong()));
            }
            return (ShuffleOrder) invokeII.objValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndRemove(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) != null) {
                return (ShuffleOrder) invokeI.objValue;
            }
            int[] iArr = new int[this.shuffled.length - 1];
            int i2 = 0;
            boolean z = false;
            while (true) {
                int[] iArr2 = this.shuffled;
                if (i2 < iArr2.length) {
                    if (iArr2[i2] == i) {
                        z = true;
                    } else {
                        int i3 = z ? i2 - 1 : i2;
                        int[] iArr3 = this.shuffled;
                        iArr[i3] = iArr3[i2] > i ? iArr3[i2] - 1 : iArr3[i2];
                    }
                    i2++;
                } else {
                    return new DefaultShuffleOrder(iArr, new Random(this.random.nextLong()));
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int[] iArr = this.shuffled;
                if (iArr.length > 0) {
                    return iArr[0];
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int[] iArr = this.shuffled;
                if (iArr.length > 0) {
                    return iArr[iArr.length - 1];
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.shuffled.length : invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                int i2 = this.indexInShuffled[i] + 1;
                int[] iArr = this.shuffled;
                if (i2 < iArr.length) {
                    return iArr[i2];
                }
                return -1;
            }
            return invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                int i2 = this.indexInShuffled[i] - 1;
                if (i2 >= 0) {
                    return this.shuffled[i2];
                }
                return -1;
            }
            return invokeI.intValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DefaultShuffleOrder(int i, long j) {
            this(i, new Random(j));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), (Random) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DefaultShuffleOrder(int i, Random random) {
            this(createShuffledList(i, random), random);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), random};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((int[]) objArr2[0], (Random) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        public DefaultShuffleOrder(int[] iArr, Random random) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iArr, random};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.shuffled = iArr;
            this.random = random;
            this.indexInShuffled = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                this.indexInShuffled[iArr[i3]] = i3;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class UnshuffledShuffleOrder implements ShuffleOrder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int length;

        public UnshuffledShuffleOrder(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.length = i;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndInsert(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) ? new UnshuffledShuffleOrder(this.length + i2) : (ShuffleOrder) invokeII.objValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndRemove(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new UnshuffledShuffleOrder(this.length - 1) : (ShuffleOrder) invokeI.objValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.length > 0 ? 0 : -1 : invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i = this.length;
                if (i > 0) {
                    return i - 1;
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.length : invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                int i2 = i + 1;
                if (i2 < this.length) {
                    return i2;
                }
                return -1;
            }
            return invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                int i2 = i - 1;
                if (i2 >= 0) {
                    return i2;
                }
                return -1;
            }
            return invokeI.intValue;
        }
    }

    ShuffleOrder cloneAndInsert(int i, int i2);

    ShuffleOrder cloneAndRemove(int i);

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int i);

    int getPreviousIndex(int i);
}
