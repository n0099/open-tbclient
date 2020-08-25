package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class SilenceTrackImpl implements Track {
    long[] decodingTimes;
    List<Sample> samples = new LinkedList();
    Track source;

    public SilenceTrackImpl(Track track, long j) {
        this.source = track;
        if (AudioSampleEntry.TYPE3.equals(track.getSampleDescriptionBox().getSampleEntry().getType())) {
            int l2i = CastUtils.l2i(((getTrackMetaData().getTimescale() * j) / 1000) / 1024);
            this.decodingTimes = new long[l2i];
            Arrays.fill(this.decodingTimes, ((getTrackMetaData().getTimescale() * j) / l2i) / 1000);
            while (true) {
                int i = l2i - 1;
                if (l2i > 0) {
                    this.samples.add(new SampleImpl((ByteBuffer) ByteBuffer.wrap(new byte[]{33, 16, 4, 96, -116, 28}).rewind()));
                    l2i = i;
                } else {
                    return;
                }
            }
        } else {
            throw new RuntimeException("Tracks of type " + track.getClass().getSimpleName() + " are not supported");
        }
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.source.getSampleDescriptionBox();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return this.decodingTimes;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long getDuration() {
        long j = 0;
        for (long j2 : this.decodingTimes) {
            j += j2;
        }
        return j;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.source.getTrackMetaData();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return this.source.getHandler();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Box getMediaHeaderBox() {
        return this.source.getMediaHeaderBox();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return null;
    }
}
