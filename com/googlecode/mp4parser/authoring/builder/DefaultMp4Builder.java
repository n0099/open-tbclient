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
/* loaded from: classes7.dex */
public class DefaultMp4Builder implements Mp4Builder {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static Logger LOG;
    public transient /* synthetic */ FieldHolder $fh;
    public Set chunkOffsetBoxes;
    public FragmentIntersectionFinder intersectionFinder;
    public HashMap track2Sample;
    public HashMap track2SampleSizes;

    /* renamed from: com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public Box createUdta(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, movie)) == null) {
            return null;
        }
        return (Box) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public class InterleaveChunkMdat implements Box {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List chunkList;
        public long contentSize;
        public Container parent;
        public final /* synthetic */ DefaultMp4Builder this$0;
        public List tracks;

        private boolean isSmallBox(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j)) == null) ? j + 8 < 4294967296L : invokeJ.booleanValue;
        }

        @Override // com.coremedia.iso.boxes.Box
        public String getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? MediaDataBox.TYPE : (String) invokeV.objValue;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j), boxParser}) == null) {
            }
        }

        public InterleaveChunkMdat(DefaultMp4Builder defaultMp4Builder, Movie movie, Map map, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultMp4Builder, movie, map, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = defaultMp4Builder;
            this.chunkList = new ArrayList();
            this.contentSize = j;
            this.tracks = movie.getTracks();
            for (int i3 = 0; i3 < ((int[]) map.values().iterator().next()).length; i3++) {
                for (Track track : this.tracks) {
                    int[] iArr = (int[]) map.get(track);
                    long j2 = 0;
                    for (int i4 = 0; i4 < i3; i4++) {
                        j2 += iArr[i4];
                    }
                    this.chunkList.add(((List) defaultMp4Builder.track2Sample.get(track)).subList(CastUtils.l2i(j2), CastUtils.l2i(j2 + iArr[i3])));
                }
            }
        }

        public /* synthetic */ InterleaveChunkMdat(DefaultMp4Builder defaultMp4Builder, Movie movie, Map map, long j, InterleaveChunkMdat interleaveChunkMdat) {
            this(defaultMp4Builder, movie, map, j);
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
            Box box;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                long j = 16;
                Container container = this;
                while (container instanceof Box) {
                    InterleaveChunkMdat interleaveChunkMdat = container;
                    Iterator it = interleaveChunkMdat.getParent().getBoxes().iterator();
                    while (it.hasNext() && container != (box = (Box) it.next())) {
                        j += box.getSize();
                    }
                    container = interleaveChunkMdat.getParent();
                }
                return j;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.parent;
            }
            return (Container) invokeV.objValue;
        }

        @Override // com.coremedia.iso.boxes.Box
        public long getSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.contentSize + 16;
            }
            return invokeV.longValue;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void setParent(Container container) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, container) == null) {
                this.parent = container;
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.chunkOffsetBoxes = new HashSet();
        this.track2Sample = new HashMap();
        this.track2SampleSizes = new HashMap();
    }

    public static long gcd(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j2 == 0) {
                return j;
            }
            return gcd(j2, j % j2);
        }
        return invokeCommon.longValue;
    }

    public void createCtts(Track track, SampleTableBox sampleTableBox) {
        List compositionTimeEntries;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, track, sampleTableBox) == null) && (compositionTimeEntries = track.getCompositionTimeEntries()) != null && !compositionTimeEntries.isEmpty()) {
            CompositionTimeToSample compositionTimeToSample = new CompositionTimeToSample();
            compositionTimeToSample.setEntries(compositionTimeEntries);
            sampleTableBox.addBox(compositionTimeToSample);
        }
    }

    public void createSdtp(Track track, SampleTableBox sampleTableBox) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, track, sampleTableBox) == null) && track.getSampleDependencies() != null && !track.getSampleDependencies().isEmpty()) {
            SampleDependencyTypeBox sampleDependencyTypeBox = new SampleDependencyTypeBox();
            sampleDependencyTypeBox.setEntries(track.getSampleDependencies());
            sampleTableBox.addBox(sampleDependencyTypeBox);
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
        if ((interceptable == null || interceptable.invokeLL(1048585, this, track, sampleTableBox) == null) && (syncSamples = track.getSyncSamples()) != null && syncSamples.length > 0) {
            SyncSampleBox syncSampleBox = new SyncSampleBox();
            syncSampleBox.setSampleNumber(syncSamples);
            sampleTableBox.addBox(syncSampleBox);
        }
    }

    public void createStsz(Track track, SampleTableBox sampleTableBox) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, track, sampleTableBox) == null) {
            SampleSizeBox sampleSizeBox = new SampleSizeBox();
            sampleSizeBox.setSampleSizes((long[]) this.track2SampleSizes.get(track));
            sampleTableBox.addBox(sampleSizeBox);
        }
    }

    public List putSamples(Track track, List list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, track, list)) == null) {
            return (List) this.track2Sample.put(track, list);
        }
        return (List) invokeLL.objValue;
    }

    public static long sum(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iArr)) == null) {
            long j = 0;
            for (int i : iArr) {
                j += i;
            }
            return j;
        }
        return invokeL.longValue;
    }

    public FileTypeBox createFileTypeBox(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, movie)) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add("isom");
            linkedList.add("iso2");
            linkedList.add("avc1");
            return new FileTypeBox("isom", 0L, linkedList);
        }
        return (FileTypeBox) invokeL.objValue;
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
            long j = 0;
            for (long j2 : jArr) {
                j += j2;
            }
            return j;
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
            Iterator it = movie.getTracks().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Track track = (Track) it.next();
                List samples = track.getSamples();
                putSamples(track, samples);
                int size = samples.size();
                long[] jArr = new long[size];
                for (int i = 0; i < size; i++) {
                    jArr[i] = ((Sample) samples.get(i)).getSize();
                }
                this.track2SampleSizes.put(track, jArr);
            }
            BasicContainer basicContainer = new BasicContainer();
            basicContainer.addBox(createFileTypeBox(movie));
            HashMap hashMap = new HashMap();
            for (Track track2 : movie.getTracks()) {
                hashMap.put(track2, getChunkSizes(track2, movie));
            }
            MovieBox createMovieBox = createMovieBox(movie, hashMap);
            basicContainer.addBox(createMovieBox);
            long j = 0;
            for (Box box : Path.getPaths((Box) createMovieBox, "trak/mdia/minf/stbl/stsz")) {
                j += sum(((SampleSizeBox) box).getSampleSizes());
            }
            InterleaveChunkMdat interleaveChunkMdat = new InterleaveChunkMdat(this, movie, hashMap, j, null);
            basicContainer.addBox(interleaveChunkMdat);
            long dataOffset = interleaveChunkMdat.getDataOffset();
            for (StaticChunkOffsetBox staticChunkOffsetBox : this.chunkOffsetBoxes) {
                long[] chunkOffsets = staticChunkOffsetBox.getChunkOffsets();
                for (int i2 = 0; i2 < chunkOffsets.length; i2++) {
                    chunkOffsets[i2] = chunkOffsets[i2] + dataOffset;
                }
            }
            return basicContainer;
        }
        return (Container) invokeL.objValue;
    }

    public MovieBox createMovieBox(Movie movie, Map map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, movie, map)) == null) {
            MovieBox movieBox = new MovieBox();
            MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
            movieHeaderBox.setCreationTime(new Date());
            movieHeaderBox.setModificationTime(new Date());
            movieHeaderBox.setMatrix(movie.getMatrix());
            long timescale = getTimescale(movie);
            long j = 0;
            long j2 = 0;
            for (Track track : movie.getTracks()) {
                long duration = (track.getDuration() * timescale) / track.getTrackMetaData().getTimescale();
                if (duration > j2) {
                    j2 = duration;
                }
            }
            movieHeaderBox.setDuration(j2);
            movieHeaderBox.setTimescale(timescale);
            for (Track track2 : movie.getTracks()) {
                if (j < track2.getTrackMetaData().getTrackId()) {
                    j = track2.getTrackMetaData().getTrackId();
                }
            }
            movieHeaderBox.setNextTrackId(j + 1);
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

    public Box createStbl(Track track, Movie movie, Map map) {
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

    public void createStco(Track track, Movie movie, Map map, SampleTableBox sampleTableBox) {
        String str;
        int[] iArr;
        StaticChunkOffsetBox staticChunkOffsetBox;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, track, movie, map, sampleTableBox) == null) {
            Object obj = track;
            Map map2 = map;
            int[] iArr2 = (int[]) map2.get(obj);
            StaticChunkOffsetBox staticChunkOffsetBox2 = new StaticChunkOffsetBox();
            this.chunkOffsetBoxes.add(staticChunkOffsetBox2);
            long[] jArr = new long[iArr2.length];
            String str2 = "Calculating chunk offsets for track_";
            if (LOG.isLoggable(Level.FINE)) {
                Logger logger = LOG;
                logger.fine("Calculating chunk offsets for track_" + track.getTrackMetaData().getTrackId());
            }
            int i = 0;
            long j = 0;
            while (i < iArr2.length) {
                if (LOG.isLoggable(Level.FINER)) {
                    Logger logger2 = LOG;
                    StringBuilder sb = new StringBuilder(str2);
                    str = str2;
                    sb.append(track.getTrackMetaData().getTrackId());
                    sb.append(" chunk ");
                    sb.append(i);
                    logger2.finer(sb.toString());
                } else {
                    str = str2;
                }
                for (Track track2 : movie.getTracks()) {
                    if (LOG.isLoggable(Level.FINEST)) {
                        Logger logger3 = LOG;
                        logger3.finest("Adding offsets of track_" + track2.getTrackMetaData().getTrackId());
                    }
                    int[] iArr3 = (int[]) map2.get(track2);
                    int i2 = 0;
                    long j2 = 0;
                    while (i2 < i) {
                        j2 += iArr3[i2];
                        i2++;
                        obj = track;
                    }
                    if (track2 == obj) {
                        jArr[i] = j;
                    }
                    int l2i = CastUtils.l2i(j2);
                    while (true) {
                        iArr = iArr2;
                        staticChunkOffsetBox = staticChunkOffsetBox2;
                        if (l2i >= iArr3[i] + j2) {
                            break;
                        }
                        j += ((long[]) this.track2SampleSizes.get(track2))[l2i];
                        l2i++;
                        iArr2 = iArr;
                        staticChunkOffsetBox2 = staticChunkOffsetBox;
                    }
                    obj = track;
                    map2 = map;
                    iArr2 = iArr;
                    staticChunkOffsetBox2 = staticChunkOffsetBox;
                }
                i++;
                str2 = str;
            }
            staticChunkOffsetBox2.setChunkOffsets(jArr);
            sampleTableBox.addBox(staticChunkOffsetBox2);
        }
    }

    public void createStsc(Track track, Map map, SampleTableBox sampleTableBox) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, track, map, sampleTableBox) == null) {
            int[] iArr = (int[]) map.get(track);
            SampleToChunkBox sampleToChunkBox = new SampleToChunkBox();
            sampleToChunkBox.setEntries(new LinkedList());
            long j = -2147483648L;
            for (int i = 0; i < iArr.length; i++) {
                if (j != iArr[i]) {
                    sampleToChunkBox.getEntries().add(new SampleToChunkBox.Entry(i + 1, iArr[i], 1L));
                    j = iArr[i];
                }
            }
            sampleTableBox.addBox(sampleToChunkBox);
        }
    }

    public void createStts(Track track, SampleTableBox sampleTableBox) {
        long[] sampleDurations;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, track, sampleTableBox) == null) {
            ArrayList arrayList = new ArrayList();
            TimeToSampleBox.Entry entry = null;
            for (long j : track.getSampleDurations()) {
                if (entry != null && entry.getDelta() == j) {
                    entry.setCount(entry.getCount() + 1);
                } else {
                    entry = new TimeToSampleBox.Entry(1L, j);
                    arrayList.add(entry);
                }
            }
            TimeToSampleBox timeToSampleBox = new TimeToSampleBox();
            timeToSampleBox.setEntries(arrayList);
            sampleTableBox.addBox(timeToSampleBox);
        }
    }

    public TrackBox createTrackBox(Track track, Movie movie, Map map) {
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

    public int[] getChunkSizes(Track track, Movie movie) {
        InterceptResult invokeLL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, track, movie)) == null) {
            long[] sampleNumbers = this.intersectionFinder.sampleNumbers(track);
            int[] iArr = new int[sampleNumbers.length];
            int i = 0;
            while (i < sampleNumbers.length) {
                long j2 = sampleNumbers[i] - 1;
                int i2 = i + 1;
                if (sampleNumbers.length == i2) {
                    j = track.getSamples().size();
                } else {
                    j = sampleNumbers[i2] - 1;
                }
                iArr[i] = CastUtils.l2i(j - j2);
                i = i2;
            }
            return iArr;
        }
        return (int[]) invokeLL.objValue;
    }

    public long getTimescale(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, movie)) == null) {
            long timescale = ((Track) movie.getTracks().iterator().next()).getTrackMetaData().getTimescale();
            for (Track track : movie.getTracks()) {
                timescale = gcd(track.getTrackMetaData().getTimescale(), timescale);
            }
            return timescale;
        }
        return invokeL.longValue;
    }
}
