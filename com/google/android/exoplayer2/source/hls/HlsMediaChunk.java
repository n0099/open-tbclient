package com.google.android.exoplayer2.source.hls;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class HlsMediaChunk extends MediaChunk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PRIV_TIMESTAMP_FRAME_OWNER = "com.apple.streaming.transportStreamTimestamp";
    public static final AtomicInteger uidSource;
    public transient /* synthetic */ FieldHolder $fh;
    public int bytesLoaded;
    public final int discontinuitySequenceNumber;
    public final Extractor extractor;
    public final HlsMasterPlaylist.HlsUrl hlsUrl;
    public final ParsableByteArray id3Data;
    public final Id3Decoder id3Decoder;
    public boolean id3TimestampPeeked;
    public final DataSource initDataSource;
    public final DataSpec initDataSpec;
    public boolean initLoadCompleted;
    public int initSegmentBytesLoaded;
    public final boolean isEncrypted;
    public final boolean isMasterTimestampSource;
    public final boolean isPackedAudioExtractor;
    public volatile boolean loadCanceled;
    public volatile boolean loadCompleted;
    public HlsSampleStreamWrapper output;
    public final boolean reusingExtractor;
    public final boolean shouldSpliceIn;
    public final TimestampAdjuster timestampAdjuster;
    public final int uid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1979770969, "Lcom/google/android/exoplayer2/source/hls/HlsMediaChunk;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1979770969, "Lcom/google/android/exoplayer2/source/hls/HlsMediaChunk;");
                return;
            }
        }
        uidSource = new AtomicInteger();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HlsMediaChunk(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, DataSpec dataSpec, DataSpec dataSpec2, HlsMasterPlaylist.HlsUrl hlsUrl, List<Format> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, TimestampAdjuster timestampAdjuster, HlsMediaChunk hlsMediaChunk, DrmInitData drmInitData, byte[] bArr, byte[] bArr2) {
        super(buildDataSource(dataSource, bArr, bArr2), dataSpec, hlsUrl.format, i, obj, j, j2, i2);
        DataSpec dataSpec3;
        Extractor extractor;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {hlsExtractorFactory, dataSource, dataSpec, dataSpec2, hlsUrl, list, Integer.valueOf(i), obj, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), timestampAdjuster, hlsMediaChunk, drmInitData, bArr, bArr2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DataSource) objArr2[0], (DataSpec) objArr2[1], (Format) objArr2[2], ((Integer) objArr2[3]).intValue(), objArr2[4], ((Long) objArr2[5]).longValue(), ((Long) objArr2[6]).longValue(), ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.discontinuitySequenceNumber = i3;
        this.initDataSpec = dataSpec2;
        this.hlsUrl = hlsUrl;
        this.isMasterTimestampSource = z;
        this.timestampAdjuster = timestampAdjuster;
        this.isEncrypted = this.dataSource instanceof Aes128DataSource;
        boolean z2 = true;
        if (hlsMediaChunk != null) {
            boolean z3 = hlsMediaChunk.hlsUrl != hlsUrl;
            this.shouldSpliceIn = z3;
            extractor = (hlsMediaChunk.discontinuitySequenceNumber != i3 || z3) ? null : hlsMediaChunk.extractor;
            dataSpec3 = dataSpec;
        } else {
            this.shouldSpliceIn = false;
            dataSpec3 = dataSpec;
            extractor = null;
        }
        Pair<Extractor, Boolean> createExtractor = hlsExtractorFactory.createExtractor(extractor, dataSpec3.uri, this.trackFormat, list, drmInitData, timestampAdjuster);
        this.extractor = (Extractor) createExtractor.first;
        this.isPackedAudioExtractor = ((Boolean) createExtractor.second).booleanValue();
        boolean z4 = this.extractor == extractor;
        this.reusingExtractor = z4;
        this.initLoadCompleted = (!z4 || dataSpec2 == null) ? false : false;
        if (this.isPackedAudioExtractor) {
            this.id3Decoder = hlsMediaChunk != null ? hlsMediaChunk.id3Decoder : new Id3Decoder();
            this.id3Data = hlsMediaChunk != null ? hlsMediaChunk.id3Data : new ParsableByteArray(10);
        } else {
            this.id3Decoder = null;
            this.id3Data = null;
        }
        this.initDataSource = dataSource;
        this.uid = uidSource.getAndIncrement();
    }

    public static DataSource buildDataSource(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, dataSource, bArr, bArr2)) == null) ? bArr != null ? new Aes128DataSource(dataSource, bArr, bArr2) : dataSource : (DataSource) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065 A[Catch: all -> 0x00a8, TryCatch #1 {all -> 0x00a8, blocks: (B:17:0x003c, B:19:0x0050, B:21:0x0054, B:23:0x0065, B:25:0x006e, B:24:0x006c, B:27:0x0073, B:36:0x0094, B:29:0x007a, B:31:0x007e), top: B:45:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c A[Catch: all -> 0x00a8, TryCatch #1 {all -> 0x00a8, blocks: (B:17:0x003c, B:19:0x0050, B:21:0x0054, B:23:0x0065, B:25:0x006e, B:24:0x006c, B:27:0x0073, B:36:0x0094, B:29:0x007a, B:31:0x007e), top: B:45:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073 A[Catch: all -> 0x00a8, TRY_LEAVE, TryCatch #1 {all -> 0x00a8, blocks: (B:17:0x003c, B:19:0x0050, B:21:0x0054, B:23:0x0065, B:25:0x006e, B:24:0x006c, B:27:0x0073, B:36:0x0094, B:29:0x007a, B:31:0x007e), top: B:45:0x003c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void loadMedia() throws IOException, InterruptedException {
        DataSpec subrange;
        boolean z;
        DefaultExtractorInput defaultExtractorInput;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65539, this) != null) {
            return;
        }
        int i = 0;
        try {
            if (this.isEncrypted) {
                subrange = this.dataSpec;
                if (this.bytesLoaded != 0) {
                    z = true;
                    if (this.isMasterTimestampSource) {
                        this.timestampAdjuster.waitUntilInitialized();
                    } else if (this.timestampAdjuster.getFirstSampleTimestampUs() == Long.MAX_VALUE) {
                        this.timestampAdjuster.setFirstSampleTimestampUs(this.startTimeUs);
                    }
                    defaultExtractorInput = new DefaultExtractorInput(this.dataSource, subrange.absoluteStreamPosition, this.dataSource.open(subrange));
                    if (this.isPackedAudioExtractor && !this.id3TimestampPeeked) {
                        long peekId3PrivTimestamp = peekId3PrivTimestamp(defaultExtractorInput);
                        this.id3TimestampPeeked = true;
                        this.output.setSampleOffsetUs(peekId3PrivTimestamp == C.TIME_UNSET ? this.timestampAdjuster.adjustTsTimestamp(peekId3PrivTimestamp) : this.startTimeUs);
                    }
                    if (z) {
                        defaultExtractorInput.skipFully(this.bytesLoaded);
                    }
                    while (i == 0 && !this.loadCanceled) {
                        i = this.extractor.read(defaultExtractorInput, null);
                    }
                    this.bytesLoaded = (int) (defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition);
                    Util.closeQuietly(this.dataSource);
                    this.loadCompleted = true;
                    return;
                }
            } else {
                subrange = this.dataSpec.subrange(this.bytesLoaded);
            }
            defaultExtractorInput = new DefaultExtractorInput(this.dataSource, subrange.absoluteStreamPosition, this.dataSource.open(subrange));
            if (this.isPackedAudioExtractor) {
                long peekId3PrivTimestamp2 = peekId3PrivTimestamp(defaultExtractorInput);
                this.id3TimestampPeeked = true;
                this.output.setSampleOffsetUs(peekId3PrivTimestamp2 == C.TIME_UNSET ? this.timestampAdjuster.adjustTsTimestamp(peekId3PrivTimestamp2) : this.startTimeUs);
            }
            if (z) {
            }
            while (i == 0) {
                i = this.extractor.read(defaultExtractorInput, null);
            }
            this.bytesLoaded = (int) (defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition);
            Util.closeQuietly(this.dataSource);
            this.loadCompleted = true;
            return;
        } catch (Throwable th) {
            Util.closeQuietly(this.dataSource);
            throw th;
        }
        z = false;
        if (this.isMasterTimestampSource) {
        }
    }

    private void maybeLoadInitData() throws IOException, InterruptedException {
        DataSpec dataSpec;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.initLoadCompleted || (dataSpec = this.initDataSpec) == null) {
            return;
        }
        DataSpec subrange = dataSpec.subrange(this.initSegmentBytesLoaded);
        try {
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.initDataSource, subrange.absoluteStreamPosition, this.initDataSource.open(subrange));
            int i = 0;
            while (i == 0 && !this.loadCanceled) {
                i = this.extractor.read(defaultExtractorInput, null);
            }
            this.initSegmentBytesLoaded = (int) (defaultExtractorInput.getPosition() - this.initDataSpec.absoluteStreamPosition);
            Util.closeQuietly(this.dataSource);
            this.initLoadCompleted = true;
        } catch (Throwable th) {
            Util.closeQuietly(this.dataSource);
            throw th;
        }
    }

    private long peekId3PrivTimestamp(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Metadata decode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, extractorInput)) == null) {
            extractorInput.resetPeekPosition();
            if (extractorInput.peekFully(this.id3Data.data, 0, 10, true)) {
                this.id3Data.reset(10);
                if (this.id3Data.readUnsignedInt24() != Id3Decoder.ID3_TAG) {
                    return C.TIME_UNSET;
                }
                this.id3Data.skipBytes(3);
                int readSynchSafeInt = this.id3Data.readSynchSafeInt();
                int i = readSynchSafeInt + 10;
                if (i > this.id3Data.capacity()) {
                    ParsableByteArray parsableByteArray = this.id3Data;
                    byte[] bArr = parsableByteArray.data;
                    parsableByteArray.reset(i);
                    System.arraycopy(bArr, 0, this.id3Data.data, 0, 10);
                }
                if (extractorInput.peekFully(this.id3Data.data, 10, readSynchSafeInt, true) && (decode = this.id3Decoder.decode(this.id3Data.data, readSynchSafeInt)) != null) {
                    int length = decode.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        Metadata.Entry entry = decode.get(i2);
                        if (entry instanceof PrivFrame) {
                            PrivFrame privFrame = (PrivFrame) entry;
                            if (PRIV_TIMESTAMP_FRAME_OWNER.equals(privFrame.owner)) {
                                System.arraycopy(privFrame.privateData, 0, this.id3Data.data, 0, 8);
                                this.id3Data.reset(8);
                                return this.id3Data.readLong();
                            }
                        }
                    }
                    return C.TIME_UNSET;
                }
                return C.TIME_UNSET;
            }
            return C.TIME_UNSET;
        }
        return invokeL.longValue;
    }

    @Override // com.google.android.exoplayer2.source.chunk.Chunk
    public long bytesLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bytesLoaded : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.loadCanceled = true;
        }
    }

    public void init(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hlsSampleStreamWrapper) == null) {
            this.output = hlsSampleStreamWrapper;
            hlsSampleStreamWrapper.init(this.uid, this.shouldSpliceIn);
            if (this.reusingExtractor) {
                return;
            }
            this.extractor.init(hlsSampleStreamWrapper);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public boolean isLoadCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.loadCanceled : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.loadCompleted : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            maybeLoadInitData();
            if (this.loadCanceled) {
                return;
            }
            loadMedia();
        }
    }
}
