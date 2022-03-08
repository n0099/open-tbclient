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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.loaders = sequenceableLoaderArr;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean continueLoading(long j2) {
        InterceptResult invokeJ;
        SequenceableLoader[] sequenceableLoaderArr;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            boolean z2 = false;
            do {
                long nextLoadPositionUs = getNextLoadPositionUs();
                if (nextLoadPositionUs == Long.MIN_VALUE) {
                    break;
                }
                z = false;
                for (SequenceableLoader sequenceableLoader : this.loaders) {
                    long nextLoadPositionUs2 = sequenceableLoader.getNextLoadPositionUs();
                    boolean z3 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= j2;
                    if (nextLoadPositionUs2 == nextLoadPositionUs || z3) {
                        z |= sequenceableLoader.continueLoading(j2);
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
            long j2 = Long.MAX_VALUE;
            for (SequenceableLoader sequenceableLoader : this.loaders) {
                long bufferedPositionUs = sequenceableLoader.getBufferedPositionUs();
                if (bufferedPositionUs != Long.MIN_VALUE) {
                    j2 = Math.min(j2, bufferedPositionUs);
                }
            }
            if (j2 == Long.MAX_VALUE) {
                return Long.MIN_VALUE;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j2 = Long.MAX_VALUE;
            for (SequenceableLoader sequenceableLoader : this.loaders) {
                long nextLoadPositionUs = sequenceableLoader.getNextLoadPositionUs();
                if (nextLoadPositionUs != Long.MIN_VALUE) {
                    j2 = Math.min(j2, nextLoadPositionUs);
                }
            }
            if (j2 == Long.MAX_VALUE) {
                return Long.MIN_VALUE;
            }
            return j2;
        }
        return invokeV.longValue;
    }
}
