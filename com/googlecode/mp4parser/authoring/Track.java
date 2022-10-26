package com.googlecode.mp4parser.authoring;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import java.util.List;
/* loaded from: classes7.dex */
public interface Track {
    List getCompositionTimeEntries();

    long getDuration();

    String getHandler();

    Box getMediaHeaderBox();

    List getSampleDependencies();

    SampleDescriptionBox getSampleDescriptionBox();

    long[] getSampleDurations();

    List getSamples();

    SubSampleInformationBox getSubsampleInformationBox();

    long[] getSyncSamples();

    TrackMetaData getTrackMetaData();
}
