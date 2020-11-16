package com.googlecode.mp4parser.authoring.container.mp4;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.TrackBox;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Mp4TrackImpl;
import java.io.File;
import java.io.IOException;
/* loaded from: classes12.dex */
public class MovieCreator {
    public static Movie build(String str) throws IOException {
        return build(new FileDataSourceImpl(new File(str)));
    }

    public static Movie build(DataSource dataSource) throws IOException {
        IsoFile isoFile = new IsoFile(dataSource);
        Movie movie = new Movie();
        for (TrackBox trackBox : isoFile.getMovieBox().getBoxes(TrackBox.class)) {
            movie.addTrack(new Mp4TrackImpl(trackBox, new IsoFile[0]));
        }
        movie.setMatrix(isoFile.getMovieBox().getMovieHeaderBox().getMatrix());
        return movie;
    }
}
