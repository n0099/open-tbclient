package com.googlecode.mp4parser.authoring.adaptivestreaming;

import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import java.io.IOException;
/* loaded from: classes5.dex */
public interface ManifestWriter {
    long[] calculateFragmentDurations(Track track, Movie movie);

    long getBitrate(Track track);

    String getManifest(Movie movie) throws IOException;
}
