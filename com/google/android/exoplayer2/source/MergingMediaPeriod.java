package com.google.android.exoplayer2.source;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
/* loaded from: classes7.dex */
public final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaPeriod.Callback callback;
    public MediaPeriod[] enabledPeriods;
    public int pendingChildPrepareCount;
    public final MediaPeriod[] periods;
    public SequenceableLoader sequenceableLoader;
    public final IdentityHashMap<SampleStream, Integer> streamPeriodIndices;
    public TrackGroupArray trackGroups;

    public MergingMediaPeriod(MediaPeriod... mediaPeriodArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaPeriodArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.periods = mediaPeriodArr;
        this.streamPeriodIndices = new IdentityHashMap<>();
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
            for (MediaPeriod mediaPeriod : this.enabledPeriods) {
                mediaPeriod.discardBuffer(j);
            }
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
            for (MediaPeriod mediaPeriod : this.periods) {
                mediaPeriod.maybeThrowPrepareError();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaPeriod) == null) {
            int i = this.pendingChildPrepareCount - 1;
            this.pendingChildPrepareCount = i;
            if (i > 0) {
                return;
            }
            int i2 = 0;
            for (MediaPeriod mediaPeriod2 : this.periods) {
                i2 += mediaPeriod2.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i2];
            int i3 = 0;
            for (MediaPeriod mediaPeriod3 : this.periods) {
                TrackGroupArray trackGroups = mediaPeriod3.getTrackGroups();
                int i4 = trackGroups.length;
                int i5 = 0;
                while (i5 < i4) {
                    trackGroupArr[i3] = trackGroups.get(i5);
                    i5++;
                    i3++;
                }
            }
            this.trackGroups = new TrackGroupArray(trackGroupArr);
            this.callback.onPrepared(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, callback, j) == null) {
            this.callback = callback;
            MediaPeriod[] mediaPeriodArr = this.periods;
            this.pendingChildPrepareCount = mediaPeriodArr.length;
            for (MediaPeriod mediaPeriod : mediaPeriodArr) {
                mediaPeriod.prepare(this, j);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        InterceptResult invokeV;
        MediaPeriod[] mediaPeriodArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048586, this)) != null) {
            return invokeV.longValue;
        }
        long readDiscontinuity = this.periods[0].readDiscontinuity();
        int i = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr2 = this.periods;
            if (i >= mediaPeriodArr2.length) {
                if (readDiscontinuity != C.TIME_UNSET) {
                    for (MediaPeriod mediaPeriod : this.enabledPeriods) {
                        if (mediaPeriod != this.periods[0] && mediaPeriod.seekToUs(readDiscontinuity) != readDiscontinuity) {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return readDiscontinuity;
            } else if (mediaPeriodArr2[i].readDiscontinuity() != C.TIME_UNSET) {
                throw new IllegalStateException("Child reported discontinuity");
            } else {
                i++;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048587, this, j)) != null) {
            return invokeJ.longValue;
        }
        long seekToUs = this.enabledPeriods[0].seekToUs(j);
        int i = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
            if (i >= mediaPeriodArr.length) {
                return seekToUs;
            }
            if (mediaPeriodArr[i].seekToUs(seekToUs) != seekToUs) {
                throw new IllegalStateException("Children seeked to different positions");
            }
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{trackSelectionArr, zArr, sampleStreamArr, zArr2, Long.valueOf(j)})) == null) {
            SampleStream[] sampleStreamArr2 = sampleStreamArr;
            int[] iArr = new int[trackSelectionArr.length];
            int[] iArr2 = new int[trackSelectionArr.length];
            for (int i = 0; i < trackSelectionArr.length; i++) {
                iArr[i] = sampleStreamArr2[i] == null ? -1 : this.streamPeriodIndices.get(sampleStreamArr2[i]).intValue();
                iArr2[i] = -1;
                if (trackSelectionArr[i] != null) {
                    TrackGroup trackGroup = trackSelectionArr[i].getTrackGroup();
                    int i2 = 0;
                    while (true) {
                        MediaPeriod[] mediaPeriodArr = this.periods;
                        if (i2 >= mediaPeriodArr.length) {
                            break;
                        } else if (mediaPeriodArr[i2].getTrackGroups().indexOf(trackGroup) != -1) {
                            iArr2[i] = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            this.streamPeriodIndices.clear();
            int length = trackSelectionArr.length;
            SampleStream[] sampleStreamArr3 = new SampleStream[length];
            SampleStream[] sampleStreamArr4 = new SampleStream[trackSelectionArr.length];
            TrackSelection[] trackSelectionArr2 = new TrackSelection[trackSelectionArr.length];
            ArrayList arrayList = new ArrayList(this.periods.length);
            long j2 = j;
            int i3 = 0;
            while (i3 < this.periods.length) {
                for (int i4 = 0; i4 < trackSelectionArr.length; i4++) {
                    TrackSelection trackSelection = null;
                    sampleStreamArr4[i4] = iArr[i4] == i3 ? sampleStreamArr2[i4] : null;
                    if (iArr2[i4] == i3) {
                        trackSelection = trackSelectionArr[i4];
                    }
                    trackSelectionArr2[i4] = trackSelection;
                }
                int i5 = i3;
                TrackSelection[] trackSelectionArr3 = trackSelectionArr2;
                ArrayList arrayList2 = arrayList;
                long selectTracks = this.periods[i3].selectTracks(trackSelectionArr2, zArr, sampleStreamArr4, zArr2, j2);
                if (i5 == 0) {
                    j2 = selectTracks;
                } else if (selectTracks != j2) {
                    throw new IllegalStateException("Children enabled at different positions");
                }
                boolean z = false;
                for (int i6 = 0; i6 < trackSelectionArr.length; i6++) {
                    if (iArr2[i6] == i5) {
                        Assertions.checkState(sampleStreamArr4[i6] != null);
                        sampleStreamArr3[i6] = sampleStreamArr4[i6];
                        this.streamPeriodIndices.put(sampleStreamArr4[i6], Integer.valueOf(i5));
                        z = true;
                    } else if (iArr[i6] == i5) {
                        Assertions.checkState(sampleStreamArr4[i6] == null);
                    }
                }
                if (z) {
                    arrayList2.add(this.periods[i5]);
                }
                i3 = i5 + 1;
                arrayList = arrayList2;
                trackSelectionArr2 = trackSelectionArr3;
                sampleStreamArr2 = sampleStreamArr;
            }
            SampleStream[] sampleStreamArr5 = sampleStreamArr2;
            ArrayList arrayList3 = arrayList;
            System.arraycopy(sampleStreamArr3, 0, sampleStreamArr5, 0, length);
            MediaPeriod[] mediaPeriodArr2 = new MediaPeriod[arrayList3.size()];
            this.enabledPeriods = mediaPeriodArr2;
            arrayList3.toArray(mediaPeriodArr2);
            this.sequenceableLoader = new CompositeSequenceableLoader(this.enabledPeriods);
            return j2;
        }
        return invokeCommon.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, mediaPeriod) == null) || this.trackGroups == null) {
            return;
        }
        this.callback.onContinueLoadingRequested(this);
    }
}
