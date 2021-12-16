package com.googlecode.mp4parser.authoring.builder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.coremedia.iso.boxes.DataInformationBox;
import com.coremedia.iso.boxes.DataReferenceBox;
import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.SyncSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Path;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes3.dex */
public class DefaultMp4Builder implements Mp4Builder {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static Logger LOG;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<StaticChunkOffsetBox> chunkOffsetBoxes;
    public FragmentIntersectionFinder intersectionFinder;
    public HashMap<Track, List<Sample>> track2Sample;
    public HashMap<Track, long[]> track2SampleSizes;

    /* renamed from: com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2128542518, "Lcom/googlecode/mp4parser/authoring/builder/DefaultMp4Builder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2128542518, "Lcom/googlecode/mp4parser/authoring/builder/DefaultMp4Builder;");
                return;
            }
        }
        LOG = Logger.getLogger(DefaultMp4Builder.class.getName());
    }

    public DefaultMp4Builder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.chunkOffsetBoxes = new HashSet();
        this.track2Sample = new HashMap<>();
        this.track2SampleSizes = new HashMap<>();
    }

    public static long gcd(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? j3 == 0 ? j2 : gcd(j3, j2 % j3) : invokeCommon.longValue;
    }

    public static long sum(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iArr)) == null) {
            long j2 = 0;
            for (int i2 : iArr) {
                j2 += i2;
            }
            return j2;
        }
        return invokeL.longValue;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.Mp4Builder
    public Container build(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, movie)) == null) {
            if (this.intersectionFinder == null) {
                this.intersectionFinder = new TwoSecondIntersectionFinder(movie, 2);
            }
            LOG.fine("Creating movie " + movie);
            Iterator<Track> it = movie.getTracks().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Track next = it.next();
                List<Sample> samples = next.getSamples();
                putSamples(next, samples);
                int size = samples.size();
                long[] jArr = new long[size];
                for (int i2 = 0; i2 < size; i2++) {
                    jArr[i2] = samples.get(i2).getSize();
                }
                this.track2SampleSizes.put(next, jArr);
            }
            BasicContainer basicContainer = new BasicContainer();
            basicContainer.addBox(createFileTypeBox(movie));
            HashMap hashMap = new HashMap();
            for (Track track : movie.getTracks()) {
                hashMap.put(track, getChunkSizes(track, movie));
            }
            MovieBox createMovieBox = createMovieBox(movie, hashMap);
            basicContainer.addBox(createMovieBox);
            Iterator<Box> it2 = Path.getPaths((Box) createMovieBox, "trak/mdia/minf/stbl/stsz").iterator();
            long j2 = 0;
            while (it2.hasNext()) {
                j2 += sum(((SampleSizeBox) it2.next()).getSampleSizes());
            }
            InterleaveChunkMdat interleaveChunkMdat = new InterleaveChunkMdat(this, movie, hashMap, j2, null);
            basicContainer.addBox(interleaveChunkMdat);
            long dataOffset = interleaveChunkMdat.getDataOffset();
            for (StaticChunkOffsetBox staticChunkOffsetBox : this.chunkOffsetBoxes) {
                long[] chunkOffsets = staticChunkOffsetBox.getChunkOffsets();
                for (int i3 = 0; i3 < chunkOffsets.length; i3++) {
                    chunkOffsets[i3] = chunkOffsets[i3] + dataOffset;
                }
            }
            return basicContainer;
        }
        return (Container) invokeL.objValue;
    }

    public void createCtts(Track track, SampleTableBox sampleTableBox) {
        List<CompositionTimeToSample.Entry> compositionTimeEntries;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, track, sampleTableBox) == null) || (compositionTimeEntries = track.getCompositionTimeEntries()) == null || compositionTimeEntries.isEmpty()) {
            return;
        }
        CompositionTimeToSample compositionTimeToSample = new CompositionTimeToSample();
        compositionTimeToSample.setEntries(compositionTimeEntries);
        sampleTableBox.addBox(compositionTimeToSample);
    }

    public FileTypeBox createFileTypeBox(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, movie)) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add("isom");
            linkedList.add("iso2");
            linkedList.add(VisualSampleEntry.TYPE3);
            return new FileTypeBox("isom", 0L, linkedList);
        }
        return (FileTypeBox) invokeL.objValue;
    }

    public MovieBox createMovieBox(Movie movie, Map<Track, int[]> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, movie, map)) == null) {
            MovieBox movieBox = new MovieBox();
            MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
            movieHeaderBox.setCreationTime(new Date());
            movieHeaderBox.setModificationTime(new Date());
            movieHeaderBox.setMatrix(movie.getMatrix());
            long timescale = getTimescale(movie);
            long j2 = 0;
            long j3 = 0;
            for (Track track : movie.getTracks()) {
                long duration = (track.getDuration() * timescale) / track.getTrackMetaData().getTimescale();
                if (duration > j3) {
                    j3 = duration;
                }
            }
            movieHeaderBox.setDuration(j3);
            movieHeaderBox.setTimescale(timescale);
            for (Track track2 : movie.getTracks()) {
                if (j2 < track2.getTrackMetaData().getTrackId()) {
                    j2 = track2.getTrackMetaData().getTrackId();
                }
            }
            movieHeaderBox.setNextTrackId(j2 + 1);
            movieBox.addBox(movieHeaderBox);
            for (Track track3 : movie.getTracks()) {
                movieBox.addBox(createTrackBox(track3, movie, map));
            }
            Box createUdta = createUdta(movie);
            if (createUdta != null) {
                movieBox.addBox(createUdta);
            }
            return movieBox;
        }
        return (MovieBox) invokeLL.objValue;
    }

    public void createSdtp(Track track, SampleTableBox sampleTableBox) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, track, sampleTableBox) == null) || track.getSampleDependencies() == null || track.getSampleDependencies().isEmpty()) {
            return;
        }
        SampleDependencyTypeBox sampleDependencyTypeBox = new SampleDependencyTypeBox();
        sampleDependencyTypeBox.setEntries(track.getSampleDependencies());
        sampleTableBox.addBox(sampleDependencyTypeBox);
    }

    public Box createStbl(Track track, Movie movie, Map<Track, int[]> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, track, movie, map)) == null) {
            SampleTableBox sampleTableBox = new SampleTableBox();
            createStsd(track, sampleTableBox);
            createStts(track, sampleTableBox);
            createCtts(track, sampleTableBox);
            createStss(track, sampleTableBox);
            createSdtp(track, sampleTableBox);
            createStsc(track, map, sampleTableBox);
            createStsz(track, sampleTableBox);
            createStco(track, movie, map, sampleTableBox);
            return sampleTableBox;
        }
        return (Box) invokeLLL.objValue;
    }

    public void createStco(Track track, Movie movie, Map<Track, int[]> map, SampleTableBox sampleTableBox) {
        String str;
        int[] iArr;
        StaticChunkOffsetBox staticChunkOffsetBox;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, track, movie, map, sampleTableBox) == null) {
            Track track2 = track;
            Map<Track, int[]> map2 = map;
            int[] iArr2 = map2.get(track2);
            StaticChunkOffsetBox staticChunkOffsetBox2 = new StaticChunkOffsetBox();
            this.chunkOffsetBoxes.add(staticChunkOffsetBox2);
            long[] jArr = new long[iArr2.length];
            String str2 = "Calculating chunk offsets for track_";
            if (LOG.isLoggable(Level.FINE)) {
                Logger logger = LOG;
                logger.fine("Calculating chunk offsets for track_" + track.getTrackMetaData().getTrackId());
            }
            int i2 = 0;
            long j2 = 0;
            while (i2 < iArr2.length) {
                if (LOG.isLoggable(Level.FINER)) {
                    Logger logger2 = LOG;
                    StringBuilder sb = new StringBuilder(str2);
                    str = str2;
                    sb.append(track.getTrackMetaData().getTrackId());
                    sb.append(" chunk ");
                    sb.append(i2);
                    logger2.finer(sb.toString());
                } else {
                    str = str2;
                }
                for (Track track3 : movie.getTracks()) {
                    if (LOG.isLoggable(Level.FINEST)) {
                        Logger logger3 = LOG;
                        logger3.finest("Adding offsets of track_" + track3.getTrackMetaData().getTrackId());
                    }
                    int[] iArr3 = map2.get(track3);
                    int i3 = 0;
                    long j3 = 0;
                    while (i3 < i2) {
                        j3 += iArr3[i3];
                        i3++;
                        track2 = track;
                    }
                    if (track3 == track2) {
                        jArr[i2] = j2;
                    }
                    int l2i = CastUtils.l2i(j3);
                    while (true) {
                        iArr = iArr2;
                        staticChunkOffsetBox = staticChunkOffsetBox2;
                        if (l2i >= iArr3[i2] + j3) {
                            break;
                        }
                        j2 += this.track2SampleSizes.get(track3)[l2i];
                        l2i++;
                        iArr2 = iArr;
                        staticChunkOffsetBox2 = staticChunkOffsetBox;
                    }
                    track2 = track;
                    map2 = map;
                    iArr2 = iArr;
                    staticChunkOffsetBox2 = staticChunkOffsetBox;
                }
                i2++;
                str2 = str;
            }
            staticChunkOffsetBox2.setChunkOffsets(jArr);
            sampleTableBox.addBox(staticChunkOffsetBox2);
        }
    }

    public void createStsc(Track track, Map<Track, int[]> map, SampleTableBox sampleTableBox) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, track, map, sampleTableBox) == null) {
            int[] iArr = map.get(track);
            SampleToChunkBox sampleToChunkBox = new SampleToChunkBox();
            sampleToChunkBox.setEntries(new LinkedList());
            long j2 = -2147483648L;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (j2 != iArr[i2]) {
                    sampleToChunkBox.getEntries().add(new SampleToChunkBox.Entry(i2 + 1, iArr[i2], 1L));
                    j2 = iArr[i2];
                }
            }
            sampleTableBox.addBox(sampleToChunkBox);
        }
    }

    public void createStsd(Track track, SampleTableBox sampleTableBox) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, track, sampleTableBox) == null) {
            sampleTableBox.addBox(track.getSampleDescriptionBox());
        }
    }

    public void createStss(Track track, SampleTableBox sampleTableBox) {
        long[] syncSamples;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, track, sampleTableBox) == null) || (syncSamples = track.getSyncSamples()) == null || syncSamples.length <= 0) {
            return;
        }
        SyncSampleBox syncSampleBox = new SyncSampleBox();
        syncSampleBox.setSampleNumber(syncSamples);
        sampleTableBox.addBox(syncSampleBox);
    }

    public void createStsz(Track track, SampleTableBox sampleTableBox) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, track, sampleTableBox) == null) {
            SampleSizeBox sampleSizeBox = new SampleSizeBox();
            sampleSizeBox.setSampleSizes(this.track2SampleSizes.get(track));
            sampleTableBox.addBox(sampleSizeBox);
        }
    }

    public void createStts(Track track, SampleTableBox sampleTableBox) {
        long[] sampleDurations;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, track, sampleTableBox) == null) {
            ArrayList arrayList = new ArrayList();
            TimeToSampleBox.Entry entry = null;
            for (long j2 : track.getSampleDurations()) {
                if (entry != null && entry.getDelta() == j2) {
                    entry.setCount(entry.getCount() + 1);
                } else {
                    entry = new TimeToSampleBox.Entry(1L, j2);
                    arrayList.add(entry);
                }
            }
            TimeToSampleBox timeToSampleBox = new TimeToSampleBox();
            timeToSampleBox.setEntries(arrayList);
            sampleTableBox.addBox(timeToSampleBox);
        }
    }

    public TrackBox createTrackBox(Track track, Movie movie, Map<Track, int[]> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, track, movie, map)) == null) {
            TrackBox trackBox = new TrackBox();
            TrackHeaderBox trackHeaderBox = new TrackHeaderBox();
            trackHeaderBox.setEnabled(true);
            trackHeaderBox.setInMovie(true);
            trackHeaderBox.setInPreview(true);
            trackHeaderBox.setInPoster(true);
            trackHeaderBox.setMatrix(track.getTrackMetaData().getMatrix());
            trackHeaderBox.setAlternateGroup(track.getTrackMetaData().getGroup());
            trackHeaderBox.setCreationTime(track.getTrackMetaData().getCreationTime());
            trackHeaderBox.setDuration((track.getDuration() * getTimescale(movie)) / track.getTrackMetaData().getTimescale());
            trackHeaderBox.setHeight(track.getTrackMetaData().getHeight());
            trackHeaderBox.setWidth(track.getTrackMetaData().getWidth());
            trackHeaderBox.setLayer(track.getTrackMetaData().getLayer());
            trackHeaderBox.setModificationTime(new Date());
            trackHeaderBox.setTrackId(track.getTrackMetaData().getTrackId());
            trackHeaderBox.setVolume(track.getTrackMetaData().getVolume());
            trackBox.addBox(trackHeaderBox);
            MediaBox mediaBox = new MediaBox();
            trackBox.addBox(mediaBox);
            MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
            mediaHeaderBox.setCreationTime(track.getTrackMetaData().getCreationTime());
            mediaHeaderBox.setDuration(track.getDuration());
            mediaHeaderBox.setTimescale(track.getTrackMetaData().getTimescale());
            mediaHeaderBox.setLanguage(track.getTrackMetaData().getLanguage());
            mediaBox.addBox(mediaHeaderBox);
            HandlerBox handlerBox = new HandlerBox();
            mediaBox.addBox(handlerBox);
            handlerBox.setHandlerType(track.getHandler());
            MediaInformationBox mediaInformationBox = new MediaInformationBox();
            mediaInformationBox.addBox(track.getMediaHeaderBox());
            DataInformationBox dataInformationBox = new DataInformationBox();
            DataReferenceBox dataReferenceBox = new DataReferenceBox();
            dataInformationBox.addBox(dataReferenceBox);
            DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
            dataEntryUrlBox.setFlags(1);
            dataReferenceBox.addBox(dataEntryUrlBox);
            mediaInformationBox.addBox(dataInformationBox);
            mediaInformationBox.addBox(createStbl(track, movie, map));
            mediaBox.addBox(mediaInformationBox);
            return trackBox;
        }
        return (TrackBox) invokeLLL.objValue;
    }

    public Box createUdta(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, movie)) == null) {
            return null;
        }
        return (Box) invokeL.objValue;
    }

    public int[] getChunkSizes(Track track, Movie movie) {
        InterceptResult invokeLL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, track, movie)) == null) {
            long[] sampleNumbers = this.intersectionFinder.sampleNumbers(track);
            int[] iArr = new int[sampleNumbers.length];
            int i2 = 0;
            while (i2 < sampleNumbers.length) {
                long j3 = sampleNumbers[i2] - 1;
                int i3 = i2 + 1;
                if (sampleNumbers.length == i3) {
                    j2 = track.getSamples().size();
                } else {
                    j2 = sampleNumbers[i3] - 1;
                }
                iArr[i2] = CastUtils.l2i(j2 - j3);
                i2 = i3;
            }
            return iArr;
        }
        return (int[]) invokeLL.objValue;
    }

    public long getTimescale(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, movie)) == null) {
            long timescale = movie.getTracks().iterator().next().getTrackMetaData().getTimescale();
            for (Track track : movie.getTracks()) {
                timescale = gcd(track.getTrackMetaData().getTimescale(), timescale);
            }
            return timescale;
        }
        return invokeL.longValue;
    }

    public List<Sample> putSamples(Track track, List<Sample> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, track, list)) == null) ? this.track2Sample.put(track, list) : (List) invokeLL.objValue;
    }

    public void setIntersectionFinder(FragmentIntersectionFinder fragmentIntersectionFinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fragmentIntersectionFinder) == null) {
            this.intersectionFinder = fragmentIntersectionFinder;
        }
    }

    public static long sum(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jArr)) == null) {
            long j2 = 0;
            for (long j3 : jArr) {
                j2 += j3;
            }
            return j2;
        }
        return invokeL.longValue;
    }

    /* loaded from: classes3.dex */
    public class InterleaveChunkMdat implements Box {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<List<Sample>> chunkList;
        public long contentSize;
        public Container parent;
        public final /* synthetic */ DefaultMp4Builder this$0;
        public List<Track> tracks;

        public InterleaveChunkMdat(DefaultMp4Builder defaultMp4Builder, Movie movie, Map<Track, int[]> map, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultMp4Builder, movie, map, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = defaultMp4Builder;
            this.chunkList = new ArrayList();
            this.contentSize = j2;
            this.tracks = movie.getTracks();
            for (int i4 = 0; i4 < map.values().iterator().next().length; i4++) {
                for (Track track : this.tracks) {
                    int[] iArr = map.get(track);
                    long j3 = 0;
                    for (int i5 = 0; i5 < i4; i5++) {
                        j3 += iArr[i5];
                    }
                    this.chunkList.add(defaultMp4Builder.track2Sample.get(track).subList(CastUtils.l2i(j3), CastUtils.l2i(j3 + iArr[i4])));
                }
            }
        }

        private boolean isSmallBox(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j2)) == null) ? j2 + 8 < 4294967296L : invokeJ.booleanValue;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writableByteChannel) == null) {
                ByteBuffer allocate = ByteBuffer.allocate(16);
                long size = getSize();
                if (isSmallBox(size)) {
                    IsoTypeWriter.writeUInt32(allocate, size);
                } else {
                    IsoTypeWriter.writeUInt32(allocate, 1L);
                }
                allocate.put(IsoFile.fourCCtoBytes(MediaDataBox.TYPE));
                if (isSmallBox(size)) {
                    allocate.put(new byte[8]);
                } else {
                    IsoTypeWriter.writeUInt64(allocate, size);
                }
                allocate.rewind();
                writableByteChannel.write(allocate);
                for (List<Sample> list : this.chunkList) {
                    for (Sample sample : list) {
                        sample.writeTo(writableByteChannel);
                    }
                }
            }
        }

        public long getDataOffset() {
            InterceptResult invokeV;
            Box next;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                long j2 = 16;
                Container container = this;
                while (container instanceof Box) {
                    InterleaveChunkMdat interleaveChunkMdat = container;
                    Iterator<Box> it = interleaveChunkMdat.getParent().getBoxes().iterator();
                    while (it.hasNext() && container != (next = it.next())) {
                        j2 += next.getSize();
                    }
                    container = interleaveChunkMdat.getParent();
                }
                return j2;
            }
            return invokeV.longValue;
        }

        @Override // com.coremedia.iso.boxes.Box
        public long getOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                throw new RuntimeException("Doesn't have any meaning for programmatically created boxes");
            }
            return invokeV.longValue;
        }

        @Override // com.coremedia.iso.boxes.Box
        public Container getParent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.parent : (Container) invokeV.objValue;
        }

        @Override // com.coremedia.iso.boxes.Box
        public long getSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.contentSize + 16 : invokeV.longValue;
        }

        @Override // com.coremedia.iso.boxes.Box
        public String getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? MediaDataBox.TYPE : (String) invokeV.objValue;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j2, BoxParser boxParser) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j2), boxParser}) == null) {
            }
        }

        @Override // com.coremedia.iso.boxes.Box
        public void setParent(Container container) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, container) == null) {
                this.parent = container;
            }
        }

        public /* synthetic */ InterleaveChunkMdat(DefaultMp4Builder defaultMp4Builder, Movie movie, Map map, long j2, InterleaveChunkMdat interleaveChunkMdat) {
            this(defaultMp4Builder, movie, map, j2);
        }
    }
}
