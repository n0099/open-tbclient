package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.AbstractMediaHeaderBox;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.NullMediaHeaderBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.sampleentry.TextSampleEntry;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class TextTrackImpl extends AbstractTrack {
    TrackMetaData trackMetaData = new TrackMetaData();
    List<Line> subs = new LinkedList();
    SampleDescriptionBox sampleDescriptionBox = new SampleDescriptionBox();

    public List<Line> getSubs() {
        return this.subs;
    }

    public TextTrackImpl() {
        TextSampleEntry textSampleEntry = new TextSampleEntry(TextSampleEntry.TYPE1);
        textSampleEntry.setDataReferenceIndex(1);
        textSampleEntry.setStyleRecord(new TextSampleEntry.StyleRecord());
        textSampleEntry.setBoxRecord(new TextSampleEntry.BoxRecord());
        this.sampleDescriptionBox.addBox(textSampleEntry);
        FontTableBox fontTableBox = new FontTableBox();
        fontTableBox.setEntries(Collections.singletonList(new FontTableBox.FontRecord(1, "Serif")));
        textSampleEntry.addBox(fontTableBox);
        this.trackMetaData.setCreationTime(new Date());
        this.trackMetaData.setModificationTime(new Date());
        this.trackMetaData.setTimescale(1000L);
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        LinkedList linkedList = new LinkedList();
        long j = 0;
        for (Line line : this.subs) {
            long j2 = line.from - j;
            if (j2 > 0) {
                linkedList.add(new SampleImpl(ByteBuffer.wrap(new byte[2])));
            } else if (j2 < 0) {
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
            } catch (IOException e) {
                throw new Error("VM is broken. Does not support UTF-8");
            }
        }
        return linkedList;
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
            if (j2 > 0) {
                arrayList.add(Long.valueOf(j2));
            } else if (j2 < 0) {
                throw new Error("Subtitle display times may not intersect");
            }
            arrayList.add(Long.valueOf(line.to - line.from));
            j = line.to;
        }
        long[] jArr = new long[arrayList.size()];
        int i = 0;
        for (Long l : arrayList) {
            jArr[i] = l.longValue();
            i++;
        }
        return jArr;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "sbtl";
    }

    /* loaded from: classes8.dex */
    public static class Line {
        long from;
        String text;
        long to;

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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.googlecode.mp4parser.authoring.Track
    public AbstractMediaHeaderBox getMediaHeaderBox() {
        return new NullMediaHeaderBox();
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return null;
    }
}
