package com.googlecode.mp4parser.authoring;

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
/* loaded from: classes5.dex */
public class Mp4TrackImpl extends AbstractTrack {
    private List<CompositionTimeToSample.Entry> compositionTimeEntries;
    private long[] decodingTimes;
    private String handler;
    private AbstractMediaHeaderBox mihd;
    private List<SampleDependencyTypeBox.Entry> sampleDependencies;
    private SampleDescriptionBox sampleDescriptionBox;
    private List<CencSampleAuxiliaryDataFormat> sampleEncryptionEntries;
    private List<Sample> samples;
    private long[] syncSamples;
    private TrackMetaData trackMetaData = new TrackMetaData();

    public Mp4TrackImpl(TrackBox trackBox, IsoFile... isoFileArr) {
        long j;
        SampleFlags defaultSampleFlags;
        this.syncSamples = new long[0];
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
                        long j2 = 1;
                        for (MovieFragmentBox movieFragmentBox : ((Box) trackBox.getParent()).getParent().getBoxes(MovieFragmentBox.class)) {
                            long j3 = j2;
                            for (TrackFragmentBox trackFragmentBox : movieFragmentBox.getBoxes(TrackFragmentBox.class)) {
                                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == trackId) {
                                    for (SampleEncryptionBox sampleEncryptionBox : trackFragmentBox.getBoxes(SampleEncryptionBox.class)) {
                                        this.sampleEncryptionEntries.addAll(sampleEncryptionBox.getEntries());
                                    }
                                    for (TrackRunBox trackRunBox : trackFragmentBox.getBoxes(TrackRunBox.class)) {
                                        TrackFragmentHeaderBox trackFragmentHeaderBox = ((TrackFragmentBox) trackRunBox.getParent()).getTrackFragmentHeaderBox();
                                        boolean z = true;
                                        Iterator<TrackRunBox.Entry> it = trackRunBox.getEntries().iterator();
                                        while (true) {
                                            j = j3;
                                            boolean z2 = z;
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            TrackRunBox.Entry next = it.next();
                                            if (trackRunBox.isSampleDurationPresent()) {
                                                if (arrayList.size() == 0 || ((TimeToSampleBox.Entry) arrayList.get(arrayList.size() - 1)).getDelta() != next.getSampleDuration()) {
                                                    arrayList.add(new TimeToSampleBox.Entry(1L, next.getSampleDuration()));
                                                } else {
                                                    TimeToSampleBox.Entry entry = (TimeToSampleBox.Entry) arrayList.get(arrayList.size() - 1);
                                                    entry.setCount(entry.getCount() + 1);
                                                }
                                            } else if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                                                arrayList.add(new TimeToSampleBox.Entry(1L, trackFragmentHeaderBox.getDefaultSampleDuration()));
                                            } else {
                                                arrayList.add(new TimeToSampleBox.Entry(1L, trackExtendsBox.getDefaultSampleDuration()));
                                            }
                                            if (trackRunBox.isSampleCompositionTimeOffsetPresent()) {
                                                if (this.compositionTimeEntries.size() == 0 || this.compositionTimeEntries.get(this.compositionTimeEntries.size() - 1).getOffset() != next.getSampleCompositionTimeOffset()) {
                                                    this.compositionTimeEntries.add(new CompositionTimeToSample.Entry(1, CastUtils.l2i(next.getSampleCompositionTimeOffset())));
                                                } else {
                                                    CompositionTimeToSample.Entry entry2 = this.compositionTimeEntries.get(this.compositionTimeEntries.size() - 1);
                                                    entry2.setCount(entry2.getCount() + 1);
                                                }
                                            }
                                            if (trackRunBox.isSampleFlagsPresent()) {
                                                defaultSampleFlags = next.getSampleFlags();
                                            } else if (z2 && trackRunBox.isFirstSampleFlagsPresent()) {
                                                defaultSampleFlags = trackRunBox.getFirstSampleFlags();
                                            } else if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                                                defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                                            } else {
                                                defaultSampleFlags = trackExtendsBox.getDefaultSampleFlags();
                                            }
                                            if (defaultSampleFlags != null && !defaultSampleFlags.isSampleIsDifferenceSample()) {
                                                linkedList.add(Long.valueOf(j));
                                            }
                                            j3 = 1 + j;
                                            z = false;
                                        }
                                        j3 = j;
                                    }
                                }
                            }
                            j2 = j3;
                        }
                        long[] jArr = this.syncSamples;
                        this.syncSamples = new long[this.syncSamples.length + linkedList.size()];
                        System.arraycopy(jArr, 0, this.syncSamples, 0, jArr.length);
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

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSampleDurations() {
        return this.decodingTimes;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return this.compositionTimeEntries;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        return this.syncSamples;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return this.sampleDependencies;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return this.handler;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.googlecode.mp4parser.authoring.Track
    public AbstractMediaHeaderBox getMediaHeaderBox() {
        return this.mihd;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return null;
    }

    public List<CencSampleAuxiliaryDataFormat> getSampleEncryptionEntries() {
        return this.sampleEncryptionEntries;
    }

    public String toString() {
        return "Mp4TrackImpl{handler='" + this.handler + "'}";
    }
}
