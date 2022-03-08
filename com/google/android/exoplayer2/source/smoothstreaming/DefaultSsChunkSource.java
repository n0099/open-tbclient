package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import java.io.IOException;
import java.util.List;
/* loaded from: classes7.dex */
public class DefaultSsChunkSource implements SsChunkSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int currentManifestChunkOffset;
    public final DataSource dataSource;
    public final int elementIndex;
    public final ChunkExtractorWrapper[] extractorWrappers;
    public IOException fatalError;
    public SsManifest manifest;
    public final LoaderErrorThrower manifestLoaderErrorThrower;
    public final TrackSelection trackSelection;

    /* loaded from: classes7.dex */
    public static final class Factory implements SsChunkSource.Factory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DataSource.Factory dataSourceFactory;

        public Factory(DataSource.Factory factory) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {factory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dataSourceFactory = factory;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory
        public SsChunkSource createChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i2, TrackSelection trackSelection, TrackEncryptionBox[] trackEncryptionBoxArr) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{loaderErrorThrower, ssManifest, Integer.valueOf(i2), trackSelection, trackEncryptionBoxArr})) == null) ? new DefaultSsChunkSource(loaderErrorThrower, ssManifest, i2, trackSelection, this.dataSourceFactory.createDataSource(), trackEncryptionBoxArr) : (SsChunkSource) invokeCommon.objValue;
        }
    }

    public DefaultSsChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i2, TrackSelection trackSelection, DataSource dataSource, TrackEncryptionBox[] trackEncryptionBoxArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {loaderErrorThrower, ssManifest, Integer.valueOf(i2), trackSelection, dataSource, trackEncryptionBoxArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = ssManifest;
        this.elementIndex = i2;
        this.trackSelection = trackSelection;
        this.dataSource = dataSource;
        SsManifest.StreamElement streamElement = ssManifest.streamElements[i2];
        this.extractorWrappers = new ChunkExtractorWrapper[trackSelection.length()];
        int i5 = 0;
        while (i5 < this.extractorWrappers.length) {
            int indexInTrackGroup = trackSelection.getIndexInTrackGroup(i5);
            Format format = streamElement.formats[indexInTrackGroup];
            int i6 = i5;
            this.extractorWrappers[i6] = new ChunkExtractorWrapper(new FragmentedMp4Extractor(3, null, new Track(indexInTrackGroup, streamElement.type, streamElement.timescale, C.TIME_UNSET, ssManifest.durationUs, format, 0, trackEncryptionBoxArr, streamElement.type == 2 ? 4 : 0, null, null), null), streamElement.type, format);
            i5 = i6 + 1;
        }
    }

    public static MediaChunk newMediaChunk(Format format, DataSource dataSource, Uri uri, String str, int i2, long j2, long j3, int i3, Object obj, ChunkExtractorWrapper chunkExtractorWrapper) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{format, dataSource, uri, str, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), obj, chunkExtractorWrapper})) == null) ? new ContainerMediaChunk(dataSource, new DataSpec(uri, 0L, -1L, str), format, i3, obj, j2, j3, i2, 1, j2, chunkExtractorWrapper) : (MediaChunk) invokeCommon.objValue;
    }

    private long resolveTimeToLiveEdgeUs(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j2)) == null) {
            SsManifest ssManifest = this.manifest;
            if (ssManifest.isLive) {
                SsManifest.StreamElement streamElement = ssManifest.streamElements[this.elementIndex];
                int i2 = streamElement.chunkCount - 1;
                return (streamElement.getStartTimeUs(i2) + streamElement.getChunkDurationUs(i2)) - j2;
            }
            return C.TIME_UNSET;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public final void getNextChunk(MediaChunk mediaChunk, long j2, long j3, ChunkHolder chunkHolder) {
        int nextChunkIndex;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{mediaChunk, Long.valueOf(j2), Long.valueOf(j3), chunkHolder}) == null) && this.fatalError == null) {
            SsManifest ssManifest = this.manifest;
            SsManifest.StreamElement streamElement = ssManifest.streamElements[this.elementIndex];
            if (streamElement.chunkCount == 0) {
                chunkHolder.endOfStream = !ssManifest.isLive;
                return;
            }
            if (mediaChunk == null) {
                nextChunkIndex = streamElement.getChunkIndex(j3);
            } else {
                nextChunkIndex = mediaChunk.getNextChunkIndex() - this.currentManifestChunkOffset;
                if (nextChunkIndex < 0) {
                    this.fatalError = new BehindLiveWindowException();
                    return;
                }
            }
            int i2 = nextChunkIndex;
            if (i2 >= streamElement.chunkCount) {
                chunkHolder.endOfStream = !this.manifest.isLive;
                return;
            }
            this.trackSelection.updateSelectedTrack(j2, j3 - j2, resolveTimeToLiveEdgeUs(j2));
            long startTimeUs = streamElement.getStartTimeUs(i2);
            long chunkDurationUs = startTimeUs + streamElement.getChunkDurationUs(i2);
            int i3 = i2 + this.currentManifestChunkOffset;
            int selectedIndex = this.trackSelection.getSelectedIndex();
            chunkHolder.chunk = newMediaChunk(this.trackSelection.getSelectedFormat(), this.dataSource, streamElement.buildRequestUri(this.trackSelection.getIndexInTrackGroup(selectedIndex), i2), null, i3, startTimeUs, chunkDurationUs, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), this.extractorWrappers[selectedIndex]);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long j2, List<? extends MediaChunk> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, list)) == null) {
            if (this.fatalError == null && this.trackSelection.length() >= 2) {
                return this.trackSelection.evaluateQueueSize(j2, list);
            }
            return list.size();
        }
        return invokeJL.intValue;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            IOException iOException = this.fatalError;
            if (iOException == null) {
                this.manifestLoaderErrorThrower.maybeThrowError();
                return;
            }
            throw iOException;
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(Chunk chunk) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, chunk) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{chunk, Boolean.valueOf(z), exc})) == null) {
            if (z) {
                TrackSelection trackSelection = this.trackSelection;
                if (ChunkedTrackBlacklistUtil.maybeBlacklistTrack(trackSelection, trackSelection.indexOf(chunk.trackFormat), exc)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource
    public void updateManifest(SsManifest ssManifest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ssManifest) == null) {
            SsManifest.StreamElement[] streamElementArr = this.manifest.streamElements;
            int i2 = this.elementIndex;
            SsManifest.StreamElement streamElement = streamElementArr[i2];
            int i3 = streamElement.chunkCount;
            SsManifest.StreamElement streamElement2 = ssManifest.streamElements[i2];
            if (i3 != 0 && streamElement2.chunkCount != 0) {
                int i4 = i3 - 1;
                long startTimeUs = streamElement.getStartTimeUs(i4) + streamElement.getChunkDurationUs(i4);
                long startTimeUs2 = streamElement2.getStartTimeUs(0);
                if (startTimeUs <= startTimeUs2) {
                    this.currentManifestChunkOffset += i3;
                } else {
                    this.currentManifestChunkOffset += streamElement.getChunkIndex(startTimeUs2);
                }
            } else {
                this.currentManifestChunkOffset += i3;
            }
            this.manifest = ssManifest;
        }
    }
}
