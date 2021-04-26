package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import java.util.List;
/* loaded from: classes6.dex */
public class MovieBox extends AbstractContainerBox {
    public static final String TYPE = "moov";

    public MovieBox() {
        super(TYPE);
    }

    public MovieHeaderBox getMovieHeaderBox() {
        for (Box box : getBoxes()) {
            if (box instanceof MovieHeaderBox) {
                return (MovieHeaderBox) box;
            }
        }
        return null;
    }

    public int getTrackCount() {
        return getBoxes(TrackBox.class).size();
    }

    public long[] getTrackNumbers() {
        List boxes = getBoxes(TrackBox.class);
        long[] jArr = new long[boxes.size()];
        for (int i2 = 0; i2 < boxes.size(); i2++) {
            jArr[i2] = ((TrackBox) boxes.get(i2)).getTrackHeaderBox().getTrackId();
        }
        return jArr;
    }
}
