package com.coremedia.iso.boxes.fragment;

import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.DataSource;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MovieFragmentBox extends AbstractContainerBox {
    public static final String TYPE = "moof";

    public MovieFragmentBox() {
        super(TYPE);
    }

    public List<Long> getSyncSamples(SampleDependencyTypeBox sampleDependencyTypeBox) {
        ArrayList arrayList = new ArrayList();
        long j = 1;
        for (SampleDependencyTypeBox.Entry entry : sampleDependencyTypeBox.getEntries()) {
            if (entry.getSampleDependsOn() == 2) {
                arrayList.add(Long.valueOf(j));
            }
            j++;
        }
        return arrayList;
    }

    public int getTrackCount() {
        return getBoxes(TrackFragmentBox.class, false).size();
    }

    public long[] getTrackNumbers() {
        int i = 0;
        List boxes = getBoxes(TrackFragmentBox.class, false);
        long[] jArr = new long[boxes.size()];
        while (true) {
            int i2 = i;
            if (i2 < boxes.size()) {
                jArr[i2] = ((TrackFragmentBox) boxes.get(i2)).getTrackFragmentHeaderBox().getTrackId();
                i = i2 + 1;
            } else {
                return jArr;
            }
        }
    }

    public List<TrackFragmentHeaderBox> getTrackFragmentHeaderBoxes() {
        return getBoxes(TrackFragmentHeaderBox.class, true);
    }

    public List<TrackRunBox> getTrackRunBoxes() {
        return getBoxes(TrackRunBox.class, true);
    }

    public DataSource getFileChannel() {
        return this.dataSource;
    }
}
