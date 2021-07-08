package com.googlecode.mp4parser.authoring.adaptivestreaming;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes6.dex */
public class FlatPackageWriterImpl implements PackageWriter {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static Logger LOG;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean debugOutput;
    public FragmentIntersectionFinder intersectionFinder;
    public FragmentedMp4Builder ismvBuilder;
    public ManifestWriter manifestWriter;
    public File outputDirectory;
    public long timeScale;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(243892644, "Lcom/googlecode/mp4parser/authoring/adaptivestreaming/FlatPackageWriterImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(243892644, "Lcom/googlecode/mp4parser/authoring/adaptivestreaming/FlatPackageWriterImpl;");
                return;
            }
        }
        LOG = Logger.getLogger(FlatPackageWriterImpl.class.getName());
    }

    public FlatPackageWriterImpl(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.timeScale = 10000000L;
    }

    private Movie removeUnknownTracks(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, movie)) == null) {
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
        return (Movie) invokeL.objValue;
    }

    public Movie correctTimescale(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, movie)) == null) {
            LinkedList linkedList = new LinkedList();
            for (Track track : movie.getTracks()) {
                linkedList.add(new ChangeTimeScaleTrack(track, this.timeScale, this.ismvBuilder.getFragmentIntersectionFinder().sampleNumbers(track)));
            }
            movie.setTracks(linkedList);
            return movie;
        }
        return (Movie) invokeL.objValue;
    }

    public void setDebugOutput(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.debugOutput = z;
        }
    }

    public void setIntersectionFinder(FragmentIntersectionFinder fragmentIntersectionFinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fragmentIntersectionFinder) == null) {
            this.intersectionFinder = fragmentIntersectionFinder;
        }
    }

    public void setIsmvBuilder(FragmentedMp4Builder fragmentedMp4Builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fragmentedMp4Builder) == null) {
            this.ismvBuilder = fragmentedMp4Builder;
            this.manifestWriter = new FlatManifestWriterImpl(fragmentedMp4Builder.getFragmentIntersectionFinder());
        }
    }

    public void setManifestWriter(ManifestWriter manifestWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, manifestWriter) == null) {
            this.manifestWriter = manifestWriter;
        }
    }

    public void setOutputDirectory(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, file) == null) {
            this.outputDirectory = file;
        }
    }

    @Override // com.googlecode.mp4parser.authoring.adaptivestreaming.PackageWriter
    public void write(Movie movie) throws IOException {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, movie) == null) {
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
                    file = new File(this.outputDirectory, MediaStreamTrack.AUDIO_TRACK_KIND);
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
                int i2 = 0;
                while (it2.hasNext()) {
                    Box next2 = it2.next();
                    if ((next2 instanceof MovieFragmentBox) && ((MovieFragmentBox) next2).getTrackNumbers()[c2] == trackId) {
                        FileOutputStream fileOutputStream4 = new FileOutputStream(new File(file2, Long.toString(j)));
                        int i3 = i2 + 1;
                        j += calculateFragmentDurations[i2];
                        FileChannel channel = fileOutputStream4.getChannel();
                        next2.getBox(channel);
                        it2.next().getBox(channel);
                        channel.truncate(channel.position());
                        channel.close();
                        i2 = i3;
                    }
                    c2 = 0;
                }
            }
            FileWriter fileWriter = new FileWriter(new File(this.outputDirectory, "Manifest"));
            fileWriter.write(this.manifestWriter.getManifest(correctTimescale));
            fileWriter.close();
        }
    }
}
