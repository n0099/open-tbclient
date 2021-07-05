package com.googlecode.mp4parser.authoring.tracks;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import java.nio.ByteBuffer;
import java.util.AbstractList;
import java.util.List;
/* loaded from: classes7.dex */
public class ReplaceSampleTrack extends AbstractTrack {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Track origTrack;
    public Sample sampleContent;
    public long sampleNumber;
    public List<Sample> samples;

    /* renamed from: com.googlecode.mp4parser.authoring.tracks.ReplaceSampleTrack$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class ReplaceASingleEntryList extends AbstractList<Sample> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplaceSampleTrack this$0;

        public ReplaceASingleEntryList(ReplaceSampleTrack replaceSampleTrack) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replaceSampleTrack};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = replaceSampleTrack;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.origTrack.getSamples().size() : invokeV.intValue;
        }

        public /* synthetic */ ReplaceASingleEntryList(ReplaceSampleTrack replaceSampleTrack, ReplaceASingleEntryList replaceASingleEntryList) {
            this(replaceSampleTrack);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Sample get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.this$0.sampleNumber == i2) {
                    return this.this$0.sampleContent;
                }
                return this.this$0.origTrack.getSamples().get(i2);
            }
            return (Sample) invokeI.objValue;
        }
    }

    public ReplaceSampleTrack(Track track, long j, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {track, Long.valueOf(j), byteBuffer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.origTrack = track;
        this.sampleNumber = j;
        this.sampleContent = new SampleImpl(byteBuffer);
        this.samples = new ReplaceASingleEntryList(this, null);
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.origTrack.getCompositionTimeEntries() : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.origTrack.getHandler() : (String) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Box getMediaHeaderBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.origTrack.getMediaHeaderBox() : (Box) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.origTrack.getSampleDependencies() : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.origTrack.getSampleDescriptionBox() : (SampleDescriptionBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSampleDurations() {
        InterceptResult invokeV;
        long[] sampleDurations;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                sampleDurations = this.origTrack.getSampleDurations();
            }
            return sampleDurations;
        }
        return (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.samples : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.origTrack.getSubsampleInformationBox() : (SubSampleInformationBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSyncSamples() {
        InterceptResult invokeV;
        long[] syncSamples;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                syncSamples = this.origTrack.getSyncSamples();
            }
            return syncSamples;
        }
        return (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.origTrack.getTrackMetaData() : (TrackMetaData) invokeV.objValue;
    }
}
