package com.google.android.exoplayer2.source.chunk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes4.dex */
public abstract class DataChunk extends Chunk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int READ_GRANULARITY = 16384;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] data;
    public int limit;
    public volatile boolean loadCanceled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i, Format format, int i2, Object obj, byte[] bArr) {
        super(dataSource, dataSpec, i, format, i2, obj, C.TIME_UNSET, C.TIME_UNSET);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {dataSource, dataSpec, Integer.valueOf(i), format, Integer.valueOf(i2), obj, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DataSource) objArr2[0], (DataSpec) objArr2[1], ((Integer) objArr2[2]).intValue(), (Format) objArr2[3], ((Integer) objArr2[4]).intValue(), objArr2[5], ((Long) objArr2[6]).longValue(), ((Long) objArr2[7]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.data = bArr;
    }

    private void maybeExpandData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            byte[] bArr = this.data;
            if (bArr == null) {
                this.data = new byte[16384];
            } else if (bArr.length < this.limit + 16384) {
                this.data = Arrays.copyOf(bArr, bArr.length + 16384);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.Chunk
    public long bytesLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.limit : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.loadCanceled = true;
        }
    }

    public abstract void consume(byte[] bArr, int i) throws IOException;

    public byte[] getDataHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.data : (byte[]) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final boolean isLoadCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.loadCanceled : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                this.dataSource.open(this.dataSpec);
                int i = 0;
                this.limit = 0;
                while (i != -1 && !this.loadCanceled) {
                    maybeExpandData();
                    i = this.dataSource.read(this.data, this.limit, 16384);
                    if (i != -1) {
                        this.limit += i;
                    }
                }
                if (!this.loadCanceled) {
                    consume(this.data, this.limit);
                }
            } finally {
                Util.closeQuietly(this.dataSource);
            }
        }
    }
}
