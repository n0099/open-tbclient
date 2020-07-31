package com.googlecode.mp4parser.authoring;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import java.util.List;
/* loaded from: classes20.dex */
public interface Track {
    List<CompositionTimeToSample.Entry> getCompositionTimeEntries();

    long getDuration();

    String getHandler();

    Box getMediaHeaderBox();

    List<SampleDependencyTypeBox.Entry> getSampleDependencies();

    SampleDescriptionBox getSampleDescriptionBox();

    long[] getSampleDurations();

    List<Sample> getSamples();

    SubSampleInformationBox getSubsampleInformationBox();

    long[] getSyncSamples();

    TrackMetaData getTrackMetaData();
}
