package com.google.android.exoplayer2.extractor.mp4;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes7.dex */
public final class FixedSampleSizeRechunker {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_SAMPLE_SIZE = 8192;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class Results {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] flags;
        public final int maximumSize;
        public final long[] offsets;
        public final int[] sizes;
        public final long[] timestamps;

        public /* synthetic */ Results(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, AnonymousClass1 anonymousClass1) {
            this(jArr, iArr, i2, jArr2, iArr2);
        }

        public Results(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jArr, iArr, Integer.valueOf(i2), jArr2, iArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.offsets = jArr;
            this.sizes = iArr;
            this.maximumSize = i2;
            this.timestamps = jArr2;
            this.flags = iArr2;
        }
    }

    public FixedSampleSizeRechunker() {
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

    public static Results rechunk(int i2, long[] jArr, int[] iArr, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), jArr, iArr, Long.valueOf(j2)})) == null) {
            int i3 = 8192 / i2;
            int i4 = 0;
            for (int i5 : iArr) {
                i4 += Util.ceilDivide(i5, i3);
            }
            long[] jArr2 = new long[i4];
            int[] iArr2 = new int[i4];
            long[] jArr3 = new long[i4];
            int[] iArr3 = new int[i4];
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < iArr.length; i9++) {
                int i10 = iArr[i9];
                long j3 = jArr[i9];
                while (i10 > 0) {
                    int min = Math.min(i3, i10);
                    jArr2[i7] = j3;
                    iArr2[i7] = i2 * min;
                    i8 = Math.max(i8, iArr2[i7]);
                    jArr3[i7] = i6 * j2;
                    iArr3[i7] = 1;
                    j3 += iArr2[i7];
                    i6 += min;
                    i10 -= min;
                    i7++;
                }
            }
            return new Results(jArr2, iArr2, i8, jArr3, iArr3, null);
        }
        return (Results) invokeCommon.objValue;
    }
}
