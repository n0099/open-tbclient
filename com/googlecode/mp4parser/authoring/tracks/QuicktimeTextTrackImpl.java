package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom;
import com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderAtom;
import com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom;
import com.googlecode.mp4parser.boxes.apple.QuicktimeTextSampleEntry;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class QuicktimeTextTrackImpl extends AbstractTrack {
    public TrackMetaData trackMetaData = new TrackMetaData();
    public List<Line> subs = new LinkedList();
    public SampleDescriptionBox sampleDescriptionBox = new SampleDescriptionBox();

    /* loaded from: classes6.dex */
    public static class Line {
        public long from;
        public String text;
        public long to;

        public Line(long j, long j2, String str) {
            this.from = j;
            this.to = j2;
            this.text = str;
        }

        public long getFrom() {
            return this.from;
        }

        public String getText() {
            return this.text;
        }

        public long getTo() {
            return this.to;
        }
    }

    public QuicktimeTextTrackImpl() {
        QuicktimeTextSampleEntry quicktimeTextSampleEntry = new QuicktimeTextSampleEntry();
        quicktimeTextSampleEntry.setDataReferenceIndex(1);
        this.sampleDescriptionBox.addBox(quicktimeTextSampleEntry);
        this.trackMetaData.setCreationTime(new Date());
        this.trackMetaData.setModificationTime(new Date());
        this.trackMetaData.setTimescale(1000L);
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "text";
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Box getMediaHeaderBox() {
        GenericMediaHeaderAtom genericMediaHeaderAtom = new GenericMediaHeaderAtom();
        genericMediaHeaderAtom.addBox(new BaseMediaInfoAtom());
        genericMediaHeaderAtom.addBox(new GenericMediaHeaderTextAtom());
        return genericMediaHeaderAtom;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        ArrayList<Long> arrayList = new ArrayList();
        long j = 0;
        for (Line line : this.subs) {
            long j2 = line.from - j;
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 > 0) {
                arrayList.add(Long.valueOf(j2));
            } else if (i2 < 0) {
                throw new Error("Subtitle display times may not intersect");
            }
            arrayList.add(Long.valueOf(line.to - line.from));
            j = line.to;
        }
        long[] jArr = new long[arrayList.size()];
        int i3 = 0;
        for (Long l : arrayList) {
            jArr[i3] = l.longValue();
            i3++;
        }
        return jArr;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        LinkedList linkedList = new LinkedList();
        long j = 0;
        for (Line line : this.subs) {
            int i2 = ((line.from - j) > 0L ? 1 : ((line.from - j) == 0L ? 0 : -1));
            if (i2 > 0) {
                linkedList.add(new SampleImpl(ByteBuffer.wrap(new byte[2])));
            } else if (i2 < 0) {
                throw new Error("Subtitle display times may not intersect");
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(line.text.getBytes("UTF-8").length);
                dataOutputStream.write(line.text.getBytes("UTF-8"));
                dataOutputStream.close();
                linkedList.add(new SampleImpl(ByteBuffer.wrap(byteArrayOutputStream.toByteArray())));
                j = line.to;
            } catch (IOException unused) {
                throw new Error("VM is broken. Does not support UTF-8");
            }
        }
        return linkedList;
    }

    public List<Line> getSubs() {
        return this.subs;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }
}
