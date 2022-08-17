package com.google.android.exoplayer2.source.smoothstreaming;

import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.CompositeSequenceableLoader;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class SsMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<SsChunkSource>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INITIALIZATION_VECTOR_SIZE = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public final Allocator allocator;
    public MediaPeriod.Callback callback;
    public final SsChunkSource.Factory chunkSourceFactory;
    public final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    public SsManifest manifest;
    public final LoaderErrorThrower manifestLoaderErrorThrower;
    public final int minLoadableRetryCount;
    public ChunkSampleStream<SsChunkSource>[] sampleStreams;
    public CompositeSequenceableLoader sequenceableLoader;
    public final TrackEncryptionBox[] trackEncryptionBoxes;
    public final TrackGroupArray trackGroups;

    public SsMediaPeriod(SsManifest ssManifest, SsChunkSource.Factory factory, int i, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher, LoaderErrorThrower loaderErrorThrower, Allocator allocator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ssManifest, factory, Integer.valueOf(i), eventDispatcher, loaderErrorThrower, allocator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.chunkSourceFactory = factory;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.minLoadableRetryCount = i;
        this.eventDispatcher = eventDispatcher;
        this.allocator = allocator;
        this.trackGroups = buildTrackGroups(ssManifest);
        SsManifest.ProtectionElement protectionElement = ssManifest.protectionElement;
        if (protectionElement != null) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[]{new TrackEncryptionBox(true, null, 8, getProtectionElementKeyId(protectionElement.data), 0, 0, null)};
        } else {
            this.trackEncryptionBoxes = null;
        }
        this.manifest = ssManifest;
        ChunkSampleStream<SsChunkSource>[] newSampleStreamArray = newSampleStreamArray(0);
        this.sampleStreams = newSampleStreamArray;
        this.sequenceableLoader = new CompositeSequenceableLoader(newSampleStreamArray);
    }

    private ChunkSampleStream<SsChunkSource> buildSampleStream(TrackSelection trackSelection, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, this, trackSelection, j)) == null) {
            int indexOf = this.trackGroups.indexOf(trackSelection.getTrackGroup());
            return new ChunkSampleStream<>(this.manifest.streamElements[indexOf].type, null, this.chunkSourceFactory.createChunkSource(this.manifestLoaderErrorThrower, this.manifest, indexOf, trackSelection, this.trackEncryptionBoxes), this, this.allocator, j, this.minLoadableRetryCount, this.eventDispatcher);
        }
        return (ChunkSampleStream) invokeLJ.objValue;
    }

    public static TrackGroupArray buildTrackGroups(SsManifest ssManifest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, ssManifest)) != null) {
            return (TrackGroupArray) invokeL.objValue;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[ssManifest.streamElements.length];
        int i = 0;
        while (true) {
            SsManifest.StreamElement[] streamElementArr = ssManifest.streamElements;
            if (i < streamElementArr.length) {
                trackGroupArr[i] = new TrackGroup(streamElementArr[i].formats);
                i++;
            } else {
                return new TrackGroupArray(trackGroupArr);
            }
        }
    }

    public static byte[] getProtectionElementKeyId(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bArr.length; i += 2) {
                sb.append((char) bArr[i]);
            }
            String sb2 = sb.toString();
            byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
            swap(decode, 0, 3);
            swap(decode, 1, 2);
            swap(decode, 4, 5);
            swap(decode, 6, 7);
            return decode;
        }
        return (byte[]) invokeL.objValue;
    }

    public static ChunkSampleStream<SsChunkSource>[] newSampleStreamArray(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? new ChunkSampleStream[i] : (ChunkSampleStream[]) invokeI.objValue;
    }

    public static void swap(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65541, null, bArr, i, i2) == null) {
            byte b = bArr[i];
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? this.sequenceableLoader.continueLoading(j) : invokeJ.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.sequenceableLoader.getBufferedPositionUs() : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sequenceableLoader.getNextLoadPositionUs() : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.trackGroups : (TrackGroupArray) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.manifestLoaderErrorThrower.maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, callback, j) == null) {
            this.callback = callback;
            callback.onPrepared(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? C.TIME_UNSET : invokeV.longValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            for (ChunkSampleStream<SsChunkSource> chunkSampleStream : this.sampleStreams) {
                chunkSampleStream.release();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            for (ChunkSampleStream<SsChunkSource> chunkSampleStream : this.sampleStreams) {
                chunkSampleStream.seekToUs(j);
            }
            return j;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{trackSelectionArr, zArr, sampleStreamArr, zArr2, Long.valueOf(j)})) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < trackSelectionArr.length; i++) {
                if (sampleStreamArr[i] != null) {
                    ChunkSampleStream chunkSampleStream = (ChunkSampleStream) sampleStreamArr[i];
                    if (trackSelectionArr[i] != null && zArr[i]) {
                        arrayList.add(chunkSampleStream);
                    } else {
                        chunkSampleStream.release();
                        sampleStreamArr[i] = null;
                    }
                }
                if (sampleStreamArr[i] == null && trackSelectionArr[i] != null) {
                    ChunkSampleStream<SsChunkSource> buildSampleStream = buildSampleStream(trackSelectionArr[i], j);
                    arrayList.add(buildSampleStream);
                    sampleStreamArr[i] = buildSampleStream;
                    zArr2[i] = true;
                }
            }
            ChunkSampleStream<SsChunkSource>[] newSampleStreamArray = newSampleStreamArray(arrayList.size());
            this.sampleStreams = newSampleStreamArray;
            arrayList.toArray(newSampleStreamArray);
            this.sequenceableLoader = new CompositeSequenceableLoader(this.sampleStreams);
            return j;
        }
        return invokeCommon.longValue;
    }

    public void updateManifest(SsManifest ssManifest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ssManifest) == null) {
            this.manifest = ssManifest;
            for (ChunkSampleStream<SsChunkSource> chunkSampleStream : this.sampleStreams) {
                chunkSampleStream.getChunkSource().updateManifest(ssManifest);
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(ChunkSampleStream<SsChunkSource> chunkSampleStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, chunkSampleStream) == null) {
            this.callback.onContinueLoadingRequested(this);
        }
    }
}
