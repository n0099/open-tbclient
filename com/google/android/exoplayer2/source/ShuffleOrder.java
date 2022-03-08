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
/* loaded from: classes7.dex */
public interface ShuffleOrder {

    /* loaded from: classes7.dex */
    public static class DefaultShuffleOrder implements ShuffleOrder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] indexInShuffled;
        public final Random random;
        public final int[] shuffled;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DefaultShuffleOrder(int i2) {
            this(i2, new Random());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), (Random) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static int[] createShuffledList(int i2, Random random) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, random)) == null) {
                int[] iArr = new int[i2];
                int i3 = 0;
                while (i3 < i2) {
                    int i4 = i3 + 1;
                    int nextInt = random.nextInt(i4);
                    iArr[i3] = iArr[nextInt];
                    iArr[nextInt] = i3;
                    i3 = i4;
                }
                return iArr;
            }
            return (int[]) invokeIL.objValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndInsert(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
                int[] iArr = new int[i3];
                int[] iArr2 = new int[i3];
                int i4 = 0;
                while (i4 < i3) {
                    iArr[i4] = this.random.nextInt(this.shuffled.length + 1);
                    int i5 = i4 + 1;
                    int nextInt = this.random.nextInt(i5);
                    iArr2[i4] = iArr2[nextInt];
                    iArr2[nextInt] = i4 + i2;
                    i4 = i5;
                }
                Arrays.sort(iArr);
                int[] iArr3 = new int[this.shuffled.length + i3];
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < this.shuffled.length + i3; i8++) {
                    if (i6 < i3 && i7 == iArr[i6]) {
                        iArr3[i8] = iArr2[i6];
                        i6++;
                    } else {
                        int i9 = i7 + 1;
                        iArr3[i8] = this.shuffled[i7];
                        if (iArr3[i8] >= i2) {
                            iArr3[i8] = iArr3[i8] + i3;
                        }
                        i7 = i9;
                    }
                }
                return new DefaultShuffleOrder(iArr3, new Random(this.random.nextLong()));
            }
            return (ShuffleOrder) invokeII.objValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndRemove(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) != null) {
                return (ShuffleOrder) invokeI.objValue;
            }
            int[] iArr = new int[this.shuffled.length - 1];
            int i3 = 0;
            boolean z = false;
            while (true) {
                int[] iArr2 = this.shuffled;
                if (i3 < iArr2.length) {
                    if (iArr2[i3] == i2) {
                        z = true;
                    } else {
                        int i4 = z ? i3 - 1 : i3;
                        int[] iArr3 = this.shuffled;
                        iArr[i4] = iArr3[i3] > i2 ? iArr3[i3] - 1 : iArr3[i3];
                    }
                    i3++;
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
        public int getNextIndex(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                int i3 = this.indexInShuffled[i2] + 1;
                int[] iArr = this.shuffled;
                if (i3 < iArr.length) {
                    return iArr[i3];
                }
                return -1;
            }
            return invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                int i3 = this.indexInShuffled[i2] - 1;
                if (i3 >= 0) {
                    return this.shuffled[i3];
                }
                return -1;
            }
            return invokeI.intValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DefaultShuffleOrder(int i2, long j2) {
            this(i2, new Random(j2));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), (Random) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DefaultShuffleOrder(int i2, Random random) {
            this(createShuffledList(i2, random), random);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), random};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.shuffled = iArr;
            this.random = random;
            this.indexInShuffled = new int[iArr.length];
            for (int i4 = 0; i4 < iArr.length; i4++) {
                this.indexInShuffled[iArr[i4]] = i4;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class UnshuffledShuffleOrder implements ShuffleOrder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int length;

        public UnshuffledShuffleOrder(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.length = i2;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndInsert(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? new UnshuffledShuffleOrder(this.length + i3) : (ShuffleOrder) invokeII.objValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndRemove(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new UnshuffledShuffleOrder(this.length - 1) : (ShuffleOrder) invokeI.objValue;
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
                int i2 = this.length;
                if (i2 > 0) {
                    return i2 - 1;
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
        public int getNextIndex(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                int i3 = i2 + 1;
                if (i3 < this.length) {
                    return i3;
                }
                return -1;
            }
            return invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                int i3 = i2 - 1;
                if (i3 >= 0) {
                    return i3;
                }
                return -1;
            }
            return invokeI.intValue;
        }
    }

    ShuffleOrder cloneAndInsert(int i2, int i3);

    ShuffleOrder cloneAndRemove(int i2);

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int i2);

    int getPreviousIndex(int i2);
}
