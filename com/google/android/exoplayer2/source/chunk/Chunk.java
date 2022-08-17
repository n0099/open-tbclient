package com.google.android.exoplayer2.source.chunk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
/* loaded from: classes5.dex */
public abstract class Chunk implements Loader.Loadable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DataSource dataSource;
    public final DataSpec dataSpec;
    public final long endTimeUs;
    public final long startTimeUs;
    public final Format trackFormat;
    public final Object trackSelectionData;
    public final int trackSelectionReason;
    public final int type;

    public Chunk(DataSource dataSource, DataSpec dataSpec, int i, Format format, int i2, Object obj, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataSource, dataSpec, Integer.valueOf(i), format, Integer.valueOf(i2), obj, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dataSource = (DataSource) Assertions.checkNotNull(dataSource);
        this.dataSpec = (DataSpec) Assertions.checkNotNull(dataSpec);
        this.type = i;
        this.trackFormat = format;
        this.trackSelectionReason = i2;
        this.trackSelectionData = obj;
        this.startTimeUs = j;
        this.endTimeUs = j2;
    }

    public abstract long bytesLoaded();

    public final long getDurationUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.endTimeUs - this.startTimeUs : invokeV.longValue;
    }
}
