package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public class ChangeTimeScaleTrack implements Track {
    public static final Logger LOG = Logger.getLogger(ChangeTimeScaleTrack.class.getName());
    public List<CompositionTimeToSample.Entry> ctts;
    public long[] decodingTimes;
    public Track source;
    public long timeScale;

    public ChangeTimeScaleTrack(Track track, long j, long[] jArr) {
        this.source = track;
        this.timeScale = j;
        double timescale = j / track.getTrackMetaData().getTimescale();
        this.ctts = adjustCtts(track.getCompositionTimeEntries(), timescale);
        this.decodingTimes = adjustTts(track.getSampleDurations(), timescale, jArr, getTimes(track, jArr, j));
    }

    public static List<CompositionTimeToSample.Entry> adjustCtts(List<CompositionTimeToSample.Entry> list, double d2) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (CompositionTimeToSample.Entry entry : list) {
                arrayList.add(new CompositionTimeToSample.Entry(entry.getCount(), (int) Math.round(entry.getOffset() * d2)));
            }
            return arrayList;
        }
        return null;
    }

    public static long[] adjustTts(long[] jArr, double d2, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[jArr.length];
        long j = 0;
        int i2 = 1;
        while (i2 <= jArr.length) {
            int i3 = i2 - 1;
            long round = Math.round(jArr[i3] * d2);
            int i4 = i2 + 1;
            int binarySearch = Arrays.binarySearch(jArr2, i4);
            if (binarySearch >= 0 && jArr3[binarySearch] != j) {
                long j2 = jArr3[binarySearch] - (j + round);
                LOG.finest(String.format("Sample %d %d / %d - correct by %d", Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(jArr3[binarySearch]), Long.valueOf(j2)));
                round += j2;
            }
            j += round;
            jArr4[i3] = round;
            i2 = i4;
        }
        return jArr4;
    }

    public static long[] getTimes(Track track, long[] jArr, long j) {
        long[] jArr2 = new long[jArr.length];
        long j2 = 0;
        int i2 = 0;
        int i3 = 1;
        while (true) {
            long j3 = i3;
            if (j3 > jArr[jArr.length - 1]) {
                return jArr2;
            }
            if (j3 == jArr[i2]) {
                jArr2[i2] = (j2 * j) / track.getTrackMetaData().getTimescale();
                i2++;
            }
            j2 += track.getSampleDurations()[i3 - 1];
            i3++;
        }
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return this.ctts;
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
    public String getHandler() {
        return this.source.getHandler();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Box getMediaHeaderBox() {
        return this.source.getMediaHeaderBox();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return this.source.getSampleDependencies();
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
    public List<Sample> getSamples() {
        return this.source.getSamples();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return this.source.getSubsampleInformationBox();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        return this.source.getSyncSamples();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        TrackMetaData trackMetaData = (TrackMetaData) this.source.getTrackMetaData().clone();
        trackMetaData.setTimescale(this.timeScale);
        return trackMetaData;
    }

    public String toString() {
        return "ChangeTimeScaleTrack{source=" + this.source + '}';
    }
}
