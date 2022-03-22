package com.google.android.exoplayer2.extractor.mp4;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes6.dex */
public final class FixedSampleSizeRechunker {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_SAMPLE_SIZE = 8192;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class Results {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] flags;
        public final int maximumSize;
        public final long[] offsets;
        public final int[] sizes;
        public final long[] timestamps;

        public /* synthetic */ Results(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, AnonymousClass1 anonymousClass1) {
            this(jArr, iArr, i, jArr2, iArr2);
        }

        public Results(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jArr, iArr, Integer.valueOf(i), jArr2, iArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.offsets = jArr;
            this.sizes = iArr;
            this.maximumSize = i;
            this.timestamps = jArr2;
            this.flags = iArr2;
        }
    }

    public FixedSampleSizeRechunker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Results rechunk(int i, long[] jArr, int[] iArr, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), jArr, iArr, Long.valueOf(j)})) == null) {
            int i2 = 8192 / i;
            int i3 = 0;
            for (int i4 : iArr) {
                i3 += Util.ceilDivide(i4, i2);
            }
            long[] jArr2 = new long[i3];
            int[] iArr2 = new int[i3];
            long[] jArr3 = new long[i3];
            int[] iArr3 = new int[i3];
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < iArr.length; i8++) {
                int i9 = iArr[i8];
                long j2 = jArr[i8];
                while (i9 > 0) {
                    int min = Math.min(i2, i9);
                    jArr2[i6] = j2;
                    iArr2[i6] = i * min;
                    i7 = Math.max(i7, iArr2[i6]);
                    jArr3[i6] = i5 * j;
                    iArr3[i6] = 1;
                    j2 += iArr2[i6];
                    i5 += min;
                    i9 -= min;
                    i6++;
                }
            }
            return new Results(jArr2, iArr2, i7, jArr3, iArr3, null);
        }
        return (Results) invokeCommon.objValue;
    }
}
