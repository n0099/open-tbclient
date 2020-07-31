package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import java.util.List;
/* loaded from: classes20.dex */
public class MovieBox extends AbstractContainerBox {
    public static final String TYPE = "moov";

    public MovieBox() {
        super(TYPE);
    }

    public int getTrackCount() {
        return getBoxes(TrackBox.class).size();
    }

    public long[] getTrackNumbers() {
        List boxes = getBoxes(TrackBox.class);
        long[] jArr = new long[boxes.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < boxes.size()) {
                jArr[i2] = ((TrackBox) boxes.get(i2)).getTrackHeaderBox().getTrackId();
                i = i2 + 1;
            } else {
                return jArr;
            }
        }
    }

    public MovieHeaderBox getMovieHeaderBox() {
        for (Box box : getBoxes()) {
            if (box instanceof MovieHeaderBox) {
                return (MovieHeaderBox) box;
            }
        }
        return null;
    }
}
