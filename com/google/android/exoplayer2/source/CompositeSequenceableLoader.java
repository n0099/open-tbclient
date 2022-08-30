package com.google.android.exoplayer2.source;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class CompositeSequenceableLoader implements SequenceableLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SequenceableLoader[] loaders;

    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sequenceableLoaderArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.loaders = sequenceableLoaderArr;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean continueLoading(long j) {
        InterceptResult invokeJ;
        SequenceableLoader[] sequenceableLoaderArr;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            boolean z2 = false;
            do {
                long nextLoadPositionUs = getNextLoadPositionUs();
                if (nextLoadPositionUs == Long.MIN_VALUE) {
                    break;
                }
                z = false;
                for (SequenceableLoader sequenceableLoader : this.loaders) {
                    long nextLoadPositionUs2 = sequenceableLoader.getNextLoadPositionUs();
                    boolean z3 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= j;
                    if (nextLoadPositionUs2 == nextLoadPositionUs || z3) {
                        z |= sequenceableLoader.continueLoading(j);
                    }
                }
                z2 |= z;
            } while (z);
            return z2;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j = Long.MAX_VALUE;
            for (SequenceableLoader sequenceableLoader : this.loaders) {
                long bufferedPositionUs = sequenceableLoader.getBufferedPositionUs();
                if (bufferedPositionUs != Long.MIN_VALUE) {
                    j = Math.min(j, bufferedPositionUs);
                }
            }
            if (j == Long.MAX_VALUE) {
                return Long.MIN_VALUE;
            }
            return j;
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j = Long.MAX_VALUE;
            for (SequenceableLoader sequenceableLoader : this.loaders) {
                long nextLoadPositionUs = sequenceableLoader.getNextLoadPositionUs();
                if (nextLoadPositionUs != Long.MIN_VALUE) {
                    j = Math.min(j, nextLoadPositionUs);
                }
            }
            if (j == Long.MAX_VALUE) {
                return Long.MIN_VALUE;
            }
            return j;
        }
        return invokeV.longValue;
    }
}
