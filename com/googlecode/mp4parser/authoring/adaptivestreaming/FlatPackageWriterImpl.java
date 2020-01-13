package com.googlecode.mp4parser.authoring.adaptivestreaming;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.builder.FragmentIntersectionFinder;
import com.googlecode.mp4parser.authoring.builder.FragmentedMp4Builder;
import com.googlecode.mp4parser.authoring.builder.SyncSampleIntersectFinderImpl;
import com.googlecode.mp4parser.authoring.tracks.ChangeTimeScaleTrack;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;
/* loaded from: classes5.dex */
public class FlatPackageWriterImpl implements PackageWriter {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static Logger LOG;
    private boolean debugOutput;
    FragmentIntersectionFinder intersectionFinder;
    private FragmentedMp4Builder ismvBuilder;
    ManifestWriter manifestWriter;
    private File outputDirectory;
    long timeScale = 10000000;

    static {
        $assertionsDisabled = !FlatPackageWriterImpl.class.desiredAssertionStatus();
        LOG = Logger.getLogger(FlatPackageWriterImpl.class.getName());
    }

    public void setIntersectionFinder(FragmentIntersectionFinder fragmentIntersectionFinder) {
        this.intersectionFinder = fragmentIntersectionFinder;
    }

    public FlatPackageWriterImpl(int i) {
    }

    public void setOutputDirectory(File file) {
        if (!$assertionsDisabled && !file.isDirectory()) {
            throw new AssertionError();
        }
        this.outputDirectory = file;
    }

    public void setDebugOutput(boolean z) {
        this.debugOutput = z;
    }

    public void setIsmvBuilder(FragmentedMp4Builder fragmentedMp4Builder) {
        this.ismvBuilder = fragmentedMp4Builder;
        this.manifestWriter = new FlatManifestWriterImpl(fragmentedMp4Builder.getFragmentIntersectionFinder());
    }

    public void setManifestWriter(ManifestWriter manifestWriter) {
        this.manifestWriter = manifestWriter;
    }

    @Override // com.googlecode.mp4parser.authoring.adaptivestreaming.PackageWriter
    public void write(Movie movie) throws IOException {
        File file;
        Track track;
        if (this.intersectionFinder == null) {
            Iterator<Track> it = movie.getTracks().iterator();
            while (true) {
                if (!it.hasNext()) {
                    track = null;
                    break;
                }
                track = it.next();
                if (track.getHandler().equals("vide")) {
                    break;
                }
            }
            this.intersectionFinder = new SyncSampleIntersectFinderImpl(movie, track, -1);
        }
        if (this.ismvBuilder == null) {
            this.ismvBuilder = new FragmentedMp4Builder();
        }
        this.ismvBuilder.setIntersectionFinder(this.intersectionFinder);
        this.manifestWriter = new FlatManifestWriterImpl(this.intersectionFinder);
        if (this.debugOutput) {
            this.outputDirectory.mkdirs();
            Container build = new DefaultMp4Builder().build(movie);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.outputDirectory, "debug_1_muxed.mp4"));
            build.writeContainer(fileOutputStream.getChannel());
            fileOutputStream.close();
        }
        Movie correctTimescale = correctTimescale(removeUnknownTracks(movie));
        if (this.debugOutput) {
            Container build2 = new DefaultMp4Builder().build(correctTimescale);
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(this.outputDirectory, "debug_2_timescale.mp4"));
            build2.writeContainer(fileOutputStream2.getChannel());
            fileOutputStream2.close();
        }
        Container build3 = this.ismvBuilder.build(correctTimescale);
        if (this.debugOutput) {
            FileOutputStream fileOutputStream3 = new FileOutputStream(new File(this.outputDirectory, "debug_3_fragmented.mp4"));
            build3.writeContainer(fileOutputStream3.getChannel());
            fileOutputStream3.close();
        }
        for (Track track2 : correctTimescale.getTracks()) {
            String l = Long.toString(this.manifestWriter.getBitrate(track2));
            long trackId = track2.getTrackMetaData().getTrackId();
            Iterator<Box> it2 = build3.getBoxes().iterator();
            if (track2.getMediaHeaderBox() instanceof SoundMediaHeaderBox) {
                file = new File(this.outputDirectory, "audio");
            } else if (track2.getMediaHeaderBox() instanceof VideoMediaHeaderBox) {
                file = new File(this.outputDirectory, "video");
            } else {
                System.err.println("Skipping Track with handler " + track2.getHandler() + " and " + track2.getMediaHeaderBox().getClass().getSimpleName());
            }
            File file2 = new File(file, l);
            file2.mkdirs();
            LOG.finer("Created : " + file2.getCanonicalPath());
            long[] calculateFragmentDurations = this.manifestWriter.calculateFragmentDurations(track2, correctTimescale);
            long j = 0;
            int i = 0;
            while (it2.hasNext()) {
                Box next = it2.next();
                if (next instanceof MovieFragmentBox) {
                    if (!$assertionsDisabled && ((MovieFragmentBox) next).getTrackCount() != 1) {
                        throw new AssertionError();
                    }
                    if (((MovieFragmentBox) next).getTrackNumbers()[0] == trackId) {
                        FileOutputStream fileOutputStream4 = new FileOutputStream(new File(file2, Long.toString(j)));
                        int i2 = i + 1;
                        j += calculateFragmentDurations[i];
                        FileChannel channel = fileOutputStream4.getChannel();
                        Box next2 = it2.next();
                        if (!$assertionsDisabled && !next2.getType().equals(MediaDataBox.TYPE)) {
                            throw new AssertionError();
                        }
                        next.getBox(channel);
                        next2.getBox(channel);
                        channel.truncate(channel.position());
                        channel.close();
                        i = i2;
                    } else {
                        continue;
                    }
                }
            }
            continue;
        }
        FileWriter fileWriter = new FileWriter(new File(this.outputDirectory, "Manifest"));
        fileWriter.write(this.manifestWriter.getManifest(correctTimescale));
        fileWriter.close();
    }

    private Movie removeUnknownTracks(Movie movie) {
        LinkedList linkedList = new LinkedList();
        for (Track track : movie.getTracks()) {
            if ("vide".equals(track.getHandler()) || "soun".equals(track.getHandler())) {
                linkedList.add(track);
            } else {
                LOG.fine("Removed track " + track);
            }
        }
        movie.setTracks(linkedList);
        return movie;
    }

    public Movie correctTimescale(Movie movie) {
        LinkedList linkedList = new LinkedList();
        for (Track track : movie.getTracks()) {
            linkedList.add(new ChangeTimeScaleTrack(track, this.timeScale, this.ismvBuilder.getFragmentIntersectionFinder().sampleNumbers(track)));
        }
        movie.setTracks(linkedList);
        return movie;
    }
}
