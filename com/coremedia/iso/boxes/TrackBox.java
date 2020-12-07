package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import java.util.List;
/* loaded from: classes7.dex */
public class TrackBox extends AbstractContainerBox {
    public static final String TYPE = "trak";
    private SampleTableBox sampleTableBox;

    public TrackBox() {
        super(TYPE);
    }

    public TrackHeaderBox getTrackHeaderBox() {
        for (Box box : getBoxes()) {
            if (box instanceof TrackHeaderBox) {
                return (TrackHeaderBox) box;
            }
        }
        return null;
    }

    public SampleTableBox getSampleTableBox() {
        MediaInformationBox mediaInformationBox;
        if (this.sampleTableBox != null) {
            return this.sampleTableBox;
        }
        MediaBox mediaBox = getMediaBox();
        if (mediaBox != null && (mediaInformationBox = mediaBox.getMediaInformationBox()) != null) {
            this.sampleTableBox = mediaInformationBox.getSampleTableBox();
            return this.sampleTableBox;
        }
        return null;
    }

    public MediaBox getMediaBox() {
        for (Box box : getBoxes()) {
            if (box instanceof MediaBox) {
                return (MediaBox) box;
            }
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.BasicContainer, com.coremedia.iso.boxes.Container
    public void setBoxes(List<Box> list) {
        super.setBoxes(list);
        this.sampleTableBox = null;
    }
}
