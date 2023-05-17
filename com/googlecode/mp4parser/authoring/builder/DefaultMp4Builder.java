package com.googlecode.mp4parser.authoring.builder;

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
/* loaded from: classes9.dex */
public class DefaultMp4Builder implements Mp4Builder {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static Logger LOG = Logger.getLogger(DefaultMp4Builder.class.getName());
    public FragmentIntersectionFinder intersectionFinder;
    public Set<StaticChunkOffsetBox> chunkOffsetBoxes = new HashSet();
    public HashMap<Track, List<Sample>> track2Sample = new HashMap<>();
    public HashMap<Track, long[]> track2SampleSizes = new HashMap<>();

    public Box createUdta(Movie movie) {
        return null;
    }

    /* loaded from: classes9.dex */
    public class InterleaveChunkMdat implements Box {
        public List<List<Sample>> chunkList;
        public long contentSize;
        public Container parent;
        public List<Track> tracks;

        private boolean isSmallBox(long j) {
            return j + 8 < 4294967296L;
        }

        @Override // com.coremedia.iso.boxes.Box
        public String getType() {
            return MediaDataBox.TYPE;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        }

        public InterleaveChunkMdat(Movie movie, Map<Track, int[]> map, long j) {
            this.chunkList = new ArrayList();
            this.contentSize = j;
            this.tracks = movie.getTracks();
            for (int i = 0; i < map.values().iterator().next().length; i++) {
                for (Track track : this.tracks) {
                    int[] iArr = map.get(track);
                    long j2 = 0;
                    for (int i2 = 0; i2 < i; i2++) {
                        j2 += iArr[i2];
                    }
                    this.chunkList.add(DefaultMp4Builder.this.track2Sample.get(track).subList(CastUtils.l2i(j2), CastUtils.l2i(j2 + iArr[i])));
                }
            }
        }

        public /* synthetic */ InterleaveChunkMdat(DefaultMp4Builder defaultMp4Builder, Movie movie, Map map, long j, InterleaveChunkMdat interleaveChunkMdat) {
            this(movie, map, j);
        }

        @Override // com.coremedia.iso.boxes.Box
        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
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

        public long getDataOffset() {
            Box next;
            long j = 16;
            Container container = this;
            while (container instanceof Box) {
                InterleaveChunkMdat interleaveChunkMdat = container;
                Iterator<Box> it = interleaveChunkMdat.getParent().getBoxes().iterator();
                while (it.hasNext() && container != (next = it.next())) {
                    j += next.getSize();
                }
                container = interleaveChunkMdat.getParent();
            }
            return j;
        }

        @Override // com.coremedia.iso.boxes.Box
        public long getOffset() {
            throw new RuntimeException("Doesn't have any meaning for programmatically created boxes");
        }

        @Override // com.coremedia.iso.boxes.Box
        public Container getParent() {
            return this.parent;
        }

        @Override // com.coremedia.iso.boxes.Box
        public long getSize() {
            return this.contentSize + 16;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void setParent(Container container) {
            this.parent = container;
        }
    }

    public static long gcd(long j, long j2) {
        if (j2 == 0) {
            return j;
        }
        return gcd(j2, j % j2);
    }

    public void createCtts(Track track, SampleTableBox sampleTableBox) {
        List<CompositionTimeToSample.Entry> compositionTimeEntries = track.getCompositionTimeEntries();
        if (compositionTimeEntries != null && !compositionTimeEntries.isEmpty()) {
            CompositionTimeToSample compositionTimeToSample = new CompositionTimeToSample();
            compositionTimeToSample.setEntries(compositionTimeEntries);
            sampleTableBox.addBox(compositionTimeToSample);
        }
    }

    public void createSdtp(Track track, SampleTableBox sampleTableBox) {
        if (track.getSampleDependencies() != null && !track.getSampleDependencies().isEmpty()) {
            SampleDependencyTypeBox sampleDependencyTypeBox = new SampleDependencyTypeBox();
            sampleDependencyTypeBox.setEntries(track.getSampleDependencies());
            sampleTableBox.addBox(sampleDependencyTypeBox);
        }
    }

    public void createStsd(Track track, SampleTableBox sampleTableBox) {
        sampleTableBox.addBox(track.getSampleDescriptionBox());
    }

    public void createStss(Track track, SampleTableBox sampleTableBox) {
        long[] syncSamples = track.getSyncSamples();
        if (syncSamples != null && syncSamples.length > 0) {
            SyncSampleBox syncSampleBox = new SyncSampleBox();
            syncSampleBox.setSampleNumber(syncSamples);
            sampleTableBox.addBox(syncSampleBox);
        }
    }

    public void createStsz(Track track, SampleTableBox sampleTableBox) {
        SampleSizeBox sampleSizeBox = new SampleSizeBox();
        sampleSizeBox.setSampleSizes(this.track2SampleSizes.get(track));
        sampleTableBox.addBox(sampleSizeBox);
    }

    public int[] getChunkSizes(Track track, Movie movie) {
        long j;
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

    public List<Sample> putSamples(Track track, List<Sample> list) {
        return this.track2Sample.put(track, list);
    }

    public static long sum(int[] iArr) {
        long j = 0;
        for (int i : iArr) {
            j += i;
        }
        return j;
    }

    public FileTypeBox createFileTypeBox(Movie movie) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("iso2");
        linkedList.add("avc1");
        return new FileTypeBox("isom", 0L, linkedList);
    }

    public void setIntersectionFinder(FragmentIntersectionFinder fragmentIntersectionFinder) {
        this.intersectionFinder = fragmentIntersectionFinder;
    }

    public static long sum(long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        return j;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.Mp4Builder
    public Container build(Movie movie) {
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
            for (int i = 0; i < size; i++) {
                jArr[i] = samples.get(i).getSize();
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
        long j = 0;
        while (it2.hasNext()) {
            j += sum(((SampleSizeBox) it2.next()).getSampleSizes());
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

    public MovieBox createMovieBox(Movie movie, Map<Track, int[]> map) {
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

    public Box createStbl(Track track, Movie movie, Map<Track, int[]> map) {
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

    public void createStco(Track track, Movie movie, Map<Track, int[]> map, SampleTableBox sampleTableBox) {
        String str;
        int[] iArr;
        StaticChunkOffsetBox staticChunkOffsetBox;
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
            for (Track track3 : movie.getTracks()) {
                if (LOG.isLoggable(Level.FINEST)) {
                    Logger logger3 = LOG;
                    logger3.finest("Adding offsets of track_" + track3.getTrackMetaData().getTrackId());
                }
                int[] iArr3 = map2.get(track3);
                int i2 = 0;
                long j2 = 0;
                while (i2 < i) {
                    j2 += iArr3[i2];
                    i2++;
                    track2 = track;
                }
                if (track3 == track2) {
                    jArr[i] = j;
                }
                int l2i = CastUtils.l2i(j2);
                while (true) {
                    iArr = iArr2;
                    staticChunkOffsetBox = staticChunkOffsetBox2;
                    if (l2i >= iArr3[i] + j2) {
                        break;
                    }
                    j += this.track2SampleSizes.get(track3)[l2i];
                    l2i++;
                    iArr2 = iArr;
                    staticChunkOffsetBox2 = staticChunkOffsetBox;
                }
                track2 = track;
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

    public void createStsc(Track track, Map<Track, int[]> map, SampleTableBox sampleTableBox) {
        int[] iArr = map.get(track);
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

    public void createStts(Track track, SampleTableBox sampleTableBox) {
        long[] sampleDurations;
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

    public TrackBox createTrackBox(Track track, Movie movie, Map<Track, int[]> map) {
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

    public long getTimescale(Movie movie) {
        long timescale = movie.getTracks().iterator().next().getTrackMetaData().getTimescale();
        for (Track track : movie.getTracks()) {
            timescale = gcd(track.getTrackMetaData().getTimescale(), timescale);
        }
        return timescale;
    }
}
