package com.googlecode.mp4parser.authoring.tracks;

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
/* loaded from: classes6.dex */
public class ReplaceSampleTrack extends AbstractTrack {
    public Track origTrack;
    public Sample sampleContent;
    public long sampleNumber;
    public List<Sample> samples = new a(this, null);

    /* loaded from: classes6.dex */
    public class a extends AbstractList<Sample> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public Sample get(int i) {
            if (ReplaceSampleTrack.this.sampleNumber == i) {
                return ReplaceSampleTrack.this.sampleContent;
            }
            return ReplaceSampleTrack.this.origTrack.getSamples().get(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return ReplaceSampleTrack.this.origTrack.getSamples().size();
        }

        public /* synthetic */ a(ReplaceSampleTrack replaceSampleTrack, a aVar) {
            this();
        }
    }

    public ReplaceSampleTrack(Track track, long j, ByteBuffer byteBuffer) {
        this.origTrack = track;
        this.sampleNumber = j;
        this.sampleContent = new SampleImpl(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return this.origTrack.getCompositionTimeEntries();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return this.origTrack.getHandler();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Box getMediaHeaderBox() {
        return this.origTrack.getMediaHeaderBox();
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return this.origTrack.getSampleDependencies();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.origTrack.getSampleDescriptionBox();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSampleDurations() {
        return this.origTrack.getSampleDurations();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return this.origTrack.getSubsampleInformationBox();
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSyncSamples() {
        return this.origTrack.getSyncSamples();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.origTrack.getTrackMetaData();
    }
}
