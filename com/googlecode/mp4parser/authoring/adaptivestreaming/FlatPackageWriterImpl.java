package com.googlecode.mp4parser.authoring.adaptivestreaming;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
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
import java.io.PrintStream;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public class FlatPackageWriterImpl implements PackageWriter {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static Logger LOG = Logger.getLogger(FlatPackageWriterImpl.class.getName());
    public boolean debugOutput;
    public FragmentIntersectionFinder intersectionFinder;
    public FragmentedMp4Builder ismvBuilder;
    public ManifestWriter manifestWriter;
    public File outputDirectory;
    public long timeScale = 10000000;

    public FlatPackageWriterImpl(int i) {
    }

    private Movie removeUnknownTracks(Movie movie) {
        LinkedList linkedList = new LinkedList();
        for (Track track : movie.getTracks()) {
            if (!"vide".equals(track.getHandler()) && !"soun".equals(track.getHandler())) {
                Logger logger = LOG;
                logger.fine("Removed track " + track);
            } else {
                linkedList.add(track);
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

    public void setDebugOutput(boolean z) {
        this.debugOutput = z;
    }

    public void setIntersectionFinder(FragmentIntersectionFinder fragmentIntersectionFinder) {
        this.intersectionFinder = fragmentIntersectionFinder;
    }

    public void setIsmvBuilder(FragmentedMp4Builder fragmentedMp4Builder) {
        this.ismvBuilder = fragmentedMp4Builder;
        this.manifestWriter = new FlatManifestWriterImpl(fragmentedMp4Builder.getFragmentIntersectionFinder());
    }

    public void setManifestWriter(ManifestWriter manifestWriter) {
        this.manifestWriter = manifestWriter;
    }

    public void setOutputDirectory(File file) {
        this.outputDirectory = file;
    }

    @Override // com.googlecode.mp4parser.authoring.adaptivestreaming.PackageWriter
    public void write(Movie movie) throws IOException {
        File file;
        if (this.intersectionFinder == null) {
            Track track = null;
            Iterator<Track> it = movie.getTracks().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Track next = it.next();
                if (next.getHandler().equals("vide")) {
                    track = next;
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
                PrintStream printStream = System.err;
                printStream.println("Skipping Track with handler " + track2.getHandler() + " and " + track2.getMediaHeaderBox().getClass().getSimpleName());
            }
            File file2 = new File(file, l);
            file2.mkdirs();
            Logger logger = LOG;
            logger.finer("Created : " + file2.getCanonicalPath());
            long[] calculateFragmentDurations = this.manifestWriter.calculateFragmentDurations(track2, correctTimescale);
            long j = 0;
            char c2 = 0;
            int i = 0;
            while (it2.hasNext()) {
                Box next2 = it2.next();
                if ((next2 instanceof MovieFragmentBox) && ((MovieFragmentBox) next2).getTrackNumbers()[c2] == trackId) {
                    FileOutputStream fileOutputStream4 = new FileOutputStream(new File(file2, Long.toString(j)));
                    int i2 = i + 1;
                    j += calculateFragmentDurations[i];
                    FileChannel channel = fileOutputStream4.getChannel();
                    next2.getBox(channel);
                    it2.next().getBox(channel);
                    channel.truncate(channel.position());
                    channel.close();
                    i = i2;
                }
                c2 = 0;
            }
        }
        FileWriter fileWriter = new FileWriter(new File(this.outputDirectory, "Manifest"));
        fileWriter.write(this.manifestWriter.getManifest(correctTimescale));
        fileWriter.close();
    }
}
