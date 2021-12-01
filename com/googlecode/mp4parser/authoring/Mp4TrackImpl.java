package com.googlecode.mp4parser.authoring;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.AbstractMediaHeaderBox;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.SampleFlags;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.mdat.SampleList;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.boxes.cenc.CencSampleAuxiliaryDataFormat;
import com.googlecode.mp4parser.boxes.ultraviolet.SampleEncryptionBox;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
public class Mp4TrackImpl extends AbstractTrack {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<CompositionTimeToSample.Entry> compositionTimeEntries;
    public long[] decodingTimes;
    public String handler;
    public AbstractMediaHeaderBox mihd;
    public List<SampleDependencyTypeBox.Entry> sampleDependencies;
    public SampleDescriptionBox sampleDescriptionBox;
    public List<CencSampleAuxiliaryDataFormat> sampleEncryptionEntries;
    public List<Sample> samples;
    public long[] syncSamples;
    public TrackMetaData trackMetaData;

    public Mp4TrackImpl(TrackBox trackBox, IsoFile... isoFileArr) {
        Iterator it;
        long j2;
        Iterator it2;
        SampleFlags defaultSampleFlags;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {trackBox, isoFileArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int i5 = 0;
        this.syncSamples = new long[0];
        this.trackMetaData = new TrackMetaData();
        long trackId = trackBox.getTrackHeaderBox().getTrackId();
        this.samples = new SampleList(trackBox, isoFileArr);
        SampleTableBox sampleTableBox = trackBox.getMediaBox().getMediaInformationBox().getSampleTableBox();
        this.handler = trackBox.getMediaBox().getHandlerBox().getHandlerType();
        this.mihd = trackBox.getMediaBox().getMediaInformationBox().getMediaHeaderBox();
        ArrayList arrayList = new ArrayList();
        this.compositionTimeEntries = new ArrayList();
        this.sampleDependencies = new ArrayList();
        this.sampleEncryptionEntries = new ArrayList();
        arrayList.addAll(sampleTableBox.getTimeToSampleBox().getEntries());
        if (sampleTableBox.getCompositionTimeToSample() != null) {
            this.compositionTimeEntries.addAll(sampleTableBox.getCompositionTimeToSample().getEntries());
        }
        if (sampleTableBox.getSampleDependencyTypeBox() != null) {
            this.sampleDependencies.addAll(sampleTableBox.getSampleDependencyTypeBox().getEntries());
        }
        if (sampleTableBox.getSyncSampleBox() != null) {
            this.syncSamples = sampleTableBox.getSyncSampleBox().getSampleNumber();
        }
        this.sampleDescriptionBox = sampleTableBox.getSampleDescriptionBox();
        List<MovieExtendsBox> boxes = trackBox.getParent().getBoxes(MovieExtendsBox.class);
        if (boxes.size() > 0) {
            for (MovieExtendsBox movieExtendsBox : boxes) {
                for (TrackExtendsBox trackExtendsBox : movieExtendsBox.getBoxes(TrackExtendsBox.class)) {
                    if (trackExtendsBox.getTrackId() == trackId) {
                        LinkedList<Long> linkedList = new LinkedList();
                        long j3 = 1;
                        for (MovieFragmentBox movieFragmentBox : ((Box) trackBox.getParent()).getParent().getBoxes(MovieFragmentBox.class)) {
                            Iterator it3 = movieFragmentBox.getBoxes(TrackFragmentBox.class).iterator();
                            while (it3.hasNext()) {
                                TrackFragmentBox trackFragmentBox = (TrackFragmentBox) it3.next();
                                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == trackId) {
                                    for (SampleEncryptionBox sampleEncryptionBox : trackFragmentBox.getBoxes(SampleEncryptionBox.class)) {
                                        this.sampleEncryptionEntries.addAll(sampleEncryptionBox.getEntries());
                                        it3 = it3;
                                        trackId = trackId;
                                    }
                                    Iterator it4 = trackFragmentBox.getBoxes(TrackRunBox.class).iterator();
                                    while (it4.hasNext()) {
                                        TrackRunBox trackRunBox = (TrackRunBox) it4.next();
                                        TrackFragmentHeaderBox trackFragmentHeaderBox = ((TrackFragmentBox) trackRunBox.getParent()).getTrackFragmentHeaderBox();
                                        int i6 = 1;
                                        boolean z = true;
                                        for (TrackRunBox.Entry entry : trackRunBox.getEntries()) {
                                            if (trackRunBox.isSampleDurationPresent()) {
                                                if (arrayList.size() != 0) {
                                                    it = it3;
                                                    if (((TimeToSampleBox.Entry) arrayList.get(arrayList.size() - 1)).getDelta() == entry.getSampleDuration()) {
                                                        TimeToSampleBox.Entry entry2 = (TimeToSampleBox.Entry) arrayList.get(arrayList.size() - i6);
                                                        j2 = trackId;
                                                        it2 = it4;
                                                        entry2.setCount(entry2.getCount() + 1);
                                                    }
                                                } else {
                                                    it = it3;
                                                }
                                                j2 = trackId;
                                                it2 = it4;
                                                arrayList.add(new TimeToSampleBox.Entry(1L, entry.getSampleDuration()));
                                            } else {
                                                it = it3;
                                                j2 = trackId;
                                                it2 = it4;
                                                if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                                                    arrayList.add(new TimeToSampleBox.Entry(1L, trackFragmentHeaderBox.getDefaultSampleDuration()));
                                                } else {
                                                    arrayList.add(new TimeToSampleBox.Entry(1L, trackExtendsBox.getDefaultSampleDuration()));
                                                }
                                            }
                                            if (trackRunBox.isSampleCompositionTimeOffsetPresent()) {
                                                if (this.compositionTimeEntries.size() != 0) {
                                                    List<CompositionTimeToSample.Entry> list = this.compositionTimeEntries;
                                                    i2 = 1;
                                                    if (list.get(list.size() - 1).getOffset() == entry.getSampleCompositionTimeOffset()) {
                                                        List<CompositionTimeToSample.Entry> list2 = this.compositionTimeEntries;
                                                        CompositionTimeToSample.Entry entry3 = list2.get(list2.size() - 1);
                                                        entry3.setCount(entry3.getCount() + 1);
                                                    }
                                                } else {
                                                    i2 = 1;
                                                }
                                                this.compositionTimeEntries.add(new CompositionTimeToSample.Entry(i2, CastUtils.l2i(entry.getSampleCompositionTimeOffset())));
                                            }
                                            if (trackRunBox.isSampleFlagsPresent()) {
                                                defaultSampleFlags = entry.getSampleFlags();
                                            } else if (z && trackRunBox.isFirstSampleFlagsPresent()) {
                                                defaultSampleFlags = trackRunBox.getFirstSampleFlags();
                                            } else if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                                                defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                                            } else {
                                                defaultSampleFlags = trackExtendsBox.getDefaultSampleFlags();
                                            }
                                            if (defaultSampleFlags != null && !defaultSampleFlags.isSampleIsDifferenceSample()) {
                                                linkedList.add(Long.valueOf(j3));
                                            }
                                            j3++;
                                            it3 = it;
                                            it4 = it2;
                                            trackId = j2;
                                            i6 = 1;
                                            z = false;
                                        }
                                    }
                                }
                            }
                            i5 = 0;
                        }
                        long[] jArr = this.syncSamples;
                        long[] jArr2 = new long[jArr.length + linkedList.size()];
                        this.syncSamples = jArr2;
                        System.arraycopy(jArr, i5, jArr2, i5, jArr.length);
                        int length = jArr.length;
                        for (Long l : linkedList) {
                            this.syncSamples[length] = l.longValue();
                            length++;
                        }
                    }
                }
            }
        }
        this.decodingTimes = TimeToSampleBox.blowupTimeToSamples(arrayList);
        MediaHeaderBox mediaHeaderBox = trackBox.getMediaBox().getMediaHeaderBox();
        TrackHeaderBox trackHeaderBox = trackBox.getTrackHeaderBox();
        this.trackMetaData.setTrackId(trackHeaderBox.getTrackId());
        this.trackMetaData.setCreationTime(mediaHeaderBox.getCreationTime());
        this.trackMetaData.setLanguage(mediaHeaderBox.getLanguage());
        this.trackMetaData.setModificationTime(mediaHeaderBox.getModificationTime());
        this.trackMetaData.setTimescale(mediaHeaderBox.getTimescale());
        this.trackMetaData.setHeight(trackHeaderBox.getHeight());
        this.trackMetaData.setWidth(trackHeaderBox.getWidth());
        this.trackMetaData.setLayer(trackHeaderBox.getLayer());
        this.trackMetaData.setMatrix(trackHeaderBox.getMatrix());
        this.trackMetaData.setEditList((EditListBox) Path.getPath((AbstractContainerBox) trackBox, "edts/elst"));
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.compositionTimeEntries : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.handler : (String) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.sampleDependencies : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.sampleDescriptionBox : (SampleDescriptionBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSampleDurations() {
        InterceptResult invokeV;
        long[] jArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                jArr = this.decodingTimes;
            }
            return jArr;
        }
        return (long[]) invokeV.objValue;
    }

    public List<CencSampleAuxiliaryDataFormat> getSampleEncryptionEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.sampleEncryptionEntries : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.samples : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (SubSampleInformationBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.syncSamples : (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.trackMetaData : (TrackMetaData) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return "Mp4TrackImpl{handler='" + this.handler + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.googlecode.mp4parser.authoring.Track
    public AbstractMediaHeaderBox getMediaHeaderBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mihd : (AbstractMediaHeaderBox) invokeV.objValue;
    }
}
