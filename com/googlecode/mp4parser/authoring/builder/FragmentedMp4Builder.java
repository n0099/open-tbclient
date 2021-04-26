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
import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.ProgressiveDownloadInformationBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessOffsetBox;
import com.coremedia.iso.boxes.fragment.SampleFlags;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public class FragmentedMp4Builder implements Mp4Builder {
    public static final Logger LOG = Logger.getLogger(FragmentedMp4Builder.class.getName());
    public FragmentIntersectionFinder intersectionFinder;

    /* loaded from: classes6.dex */
    public class a implements Comparator<Track> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f32279e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f32280f;

        public a(FragmentedMp4Builder fragmentedMp4Builder, Map map, int i2) {
            this.f32279e = map;
            this.f32280f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Track track, Track track2) {
            long j = ((long[]) this.f32279e.get(track))[this.f32280f];
            long j2 = ((long[]) this.f32279e.get(track2))[this.f32280f];
            long[] sampleDurations = track.getSampleDurations();
            long[] sampleDurations2 = track2.getSampleDurations();
            long j3 = 0;
            for (int i2 = 1; i2 < j; i2++) {
                j3 += sampleDurations[i2 - 1];
            }
            long j4 = 0;
            for (int i3 = 1; i3 < j2; i3++) {
                j4 += sampleDurations2[i3 - 1];
            }
            return (int) (((j3 / track.getTrackMetaData().getTimescale()) - (j4 / track2.getTrackMetaData().getTimescale())) * 100.0d);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Box {

        /* renamed from: e  reason: collision with root package name */
        public Container f32281e;

        /* renamed from: f  reason: collision with root package name */
        public long f32282f = -1;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f32284h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f32285i;
        public final /* synthetic */ Track j;
        public final /* synthetic */ int k;

        public b(long j, long j2, Track track, int i2) {
            this.f32284h = j;
            this.f32285i = j2;
            this.j = track;
            this.k = i2;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            IsoTypeWriter.writeUInt32(allocate, CastUtils.l2i(getSize()));
            allocate.put(IsoFile.fourCCtoBytes(getType()));
            allocate.rewind();
            writableByteChannel.write(allocate);
            for (Sample sample : FragmentedMp4Builder.this.getSamples(this.f32284h, this.f32285i, this.j, this.k)) {
                sample.writeTo(writableByteChannel);
            }
        }

        @Override // com.coremedia.iso.boxes.Box
        public long getOffset() {
            throw new RuntimeException("Doesn't have any meaning for programmatically created boxes");
        }

        @Override // com.coremedia.iso.boxes.Box
        public Container getParent() {
            return this.f32281e;
        }

        @Override // com.coremedia.iso.boxes.Box
        public long getSize() {
            long j = this.f32282f;
            if (j != -1) {
                return j;
            }
            long j2 = 8;
            for (Sample sample : FragmentedMp4Builder.this.getSamples(this.f32284h, this.f32285i, this.j, this.k)) {
                j2 += sample.getSize();
            }
            this.f32282f = j2;
            return j2;
        }

        @Override // com.coremedia.iso.boxes.Box
        public String getType() {
            return MediaDataBox.TYPE;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        }

        @Override // com.coremedia.iso.boxes.Box
        public void setParent(Container container) {
            this.f32281e = container;
        }
    }

    private long getTrackDuration(Movie movie, Track track) {
        return (track.getDuration() * movie.getTimescale()) / track.getTrackMetaData().getTimescale();
    }

    @Override // com.googlecode.mp4parser.authoring.builder.Mp4Builder
    public Container build(Movie movie) {
        Logger logger = LOG;
        logger.fine("Creating movie " + movie);
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
        BasicContainer basicContainer = new BasicContainer();
        basicContainer.addBox(createFtyp(movie));
        basicContainer.addBox(createMoov(movie));
        for (Box box : createMoofMdat(movie)) {
            basicContainer.addBox(box);
        }
        basicContainer.addBox(createMfra(movie, basicContainer));
        return basicContainer;
    }

    public DataInformationBox createDinf(Movie movie, Track track) {
        DataInformationBox dataInformationBox = new DataInformationBox();
        DataReferenceBox dataReferenceBox = new DataReferenceBox();
        dataInformationBox.addBox(dataReferenceBox);
        DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
        dataEntryUrlBox.setFlags(1);
        dataReferenceBox.addBox(dataEntryUrlBox);
        return dataInformationBox;
    }

    public Box createEdts(Track track, Movie movie) {
        EditListBox editList = track.getTrackMetaData().getEditList();
        if (editList != null) {
            EditBox editBox = new EditBox();
            editBox.addBox(editList);
            return editBox;
        }
        return null;
    }

    public int createFragment(List<Box> list, Track track, long[] jArr, int i2, int i3) {
        if (i2 < jArr.length) {
            long j = jArr[i2];
            int i4 = i2 + 1;
            long size = i4 < jArr.length ? jArr[i4] : track.getSamples().size() + 1;
            if (j != size) {
                long j2 = size;
                list.add(createMoof(j, j2, track, i3));
                int i5 = i3 + 1;
                list.add(createMdat(j, j2, track, i3));
                return i5;
            }
            return i3;
        }
        return i3;
    }

    public Box createFtyp(Movie movie) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("iso2");
        linkedList.add(VisualSampleEntry.TYPE3);
        return new FileTypeBox("isom", 0L, linkedList);
    }

    public Box createMdat(long j, long j2, Track track, int i2) {
        return new b(j, j2, track, i2);
    }

    public Box createMdhd(Movie movie, Track track) {
        MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
        mediaHeaderBox.setCreationTime(track.getTrackMetaData().getCreationTime());
        mediaHeaderBox.setModificationTime(getDate());
        mediaHeaderBox.setDuration(0L);
        mediaHeaderBox.setTimescale(track.getTrackMetaData().getTimescale());
        mediaHeaderBox.setLanguage(track.getTrackMetaData().getLanguage());
        return mediaHeaderBox;
    }

    public Box createMdia(Track track, Movie movie) {
        MediaBox mediaBox = new MediaBox();
        mediaBox.addBox(createMdhd(movie, track));
        mediaBox.addBox(createMdiaHdlr(track, movie));
        mediaBox.addBox(createMinf(track, movie));
        return mediaBox;
    }

    public Box createMdiaHdlr(Track track, Movie movie) {
        HandlerBox handlerBox = new HandlerBox();
        handlerBox.setHandlerType(track.getHandler());
        return handlerBox;
    }

    public Box createMfhd(long j, long j2, Track track, int i2) {
        MovieFragmentHeaderBox movieFragmentHeaderBox = new MovieFragmentHeaderBox();
        movieFragmentHeaderBox.setSequenceNumber(i2);
        return movieFragmentHeaderBox;
    }

    public Box createMfra(Movie movie, Container container) {
        MovieFragmentRandomAccessBox movieFragmentRandomAccessBox = new MovieFragmentRandomAccessBox();
        for (Track track : movie.getTracks()) {
            movieFragmentRandomAccessBox.addBox(createTfra(track, container));
        }
        MovieFragmentRandomAccessOffsetBox movieFragmentRandomAccessOffsetBox = new MovieFragmentRandomAccessOffsetBox();
        movieFragmentRandomAccessBox.addBox(movieFragmentRandomAccessOffsetBox);
        movieFragmentRandomAccessOffsetBox.setMfraSize(movieFragmentRandomAccessBox.getSize());
        return movieFragmentRandomAccessBox;
    }

    public Box createMinf(Track track, Movie movie) {
        MediaInformationBox mediaInformationBox = new MediaInformationBox();
        mediaInformationBox.addBox(track.getMediaHeaderBox());
        mediaInformationBox.addBox(createDinf(movie, track));
        mediaInformationBox.addBox(createStbl(movie, track));
        return mediaInformationBox;
    }

    public Box createMoof(long j, long j2, Track track, int i2) {
        MovieFragmentBox movieFragmentBox = new MovieFragmentBox();
        movieFragmentBox.addBox(createMfhd(j, j2, track, i2));
        movieFragmentBox.addBox(createTraf(j, j2, track, i2));
        TrackRunBox trackRunBox = movieFragmentBox.getTrackRunBoxes().get(0);
        trackRunBox.setDataOffset(1);
        trackRunBox.setDataOffset((int) (movieFragmentBox.getSize() + 8));
        return movieFragmentBox;
    }

    public List<Box> createMoofMdat(Movie movie) {
        List<Box> linkedList = new LinkedList<>();
        HashMap hashMap = new HashMap();
        int i2 = 0;
        for (Track track : movie.getTracks()) {
            long[] sampleNumbers = this.intersectionFinder.sampleNumbers(track);
            hashMap.put(track, sampleNumbers);
            i2 = Math.max(i2, sampleNumbers.length);
        }
        int i3 = 1;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = i3;
            for (Track track2 : sortTracksInSequence(movie.getTracks(), i4, hashMap)) {
                if (getAllowedHandlers().isEmpty() || getAllowedHandlers().contains(track2.getHandler())) {
                    i5 = createFragment(linkedList, track2, (long[]) hashMap.get(track2), i4, i5);
                }
            }
            i4++;
            i3 = i5;
        }
        return linkedList;
    }

    public Box createMoov(Movie movie) {
        MovieBox movieBox = new MovieBox();
        movieBox.addBox(createMvhd(movie));
        for (Track track : movie.getTracks()) {
            movieBox.addBox(createTrak(track, movie));
        }
        movieBox.addBox(createMvex(movie));
        return movieBox;
    }

    public Box createMvex(Movie movie) {
        MovieExtendsBox movieExtendsBox = new MovieExtendsBox();
        MovieExtendsHeaderBox movieExtendsHeaderBox = new MovieExtendsHeaderBox();
        movieExtendsHeaderBox.setVersion(1);
        for (Track track : movie.getTracks()) {
            long trackDuration = getTrackDuration(movie, track);
            if (movieExtendsHeaderBox.getFragmentDuration() < trackDuration) {
                movieExtendsHeaderBox.setFragmentDuration(trackDuration);
            }
        }
        movieExtendsBox.addBox(movieExtendsHeaderBox);
        for (Track track2 : movie.getTracks()) {
            movieExtendsBox.addBox(createTrex(movie, track2));
        }
        return movieExtendsBox;
    }

    public Box createMvhd(Movie movie) {
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.setVersion(1);
        movieHeaderBox.setCreationTime(getDate());
        movieHeaderBox.setModificationTime(getDate());
        long j = 0;
        movieHeaderBox.setDuration(0L);
        movieHeaderBox.setTimescale(movie.getTimescale());
        for (Track track : movie.getTracks()) {
            if (j < track.getTrackMetaData().getTrackId()) {
                j = track.getTrackMetaData().getTrackId();
            }
        }
        movieHeaderBox.setNextTrackId(j + 1);
        return movieHeaderBox;
    }

    public Box createPdin(Movie movie) {
        long j;
        Iterator<Sample> it;
        ProgressiveDownloadInformationBox progressiveDownloadInformationBox = new ProgressiveDownloadInformationBox();
        LinkedList linkedList = new LinkedList();
        Iterator<Track> it2 = movie.getTracks().iterator();
        double d2 = 0.0d;
        long j2 = 0;
        while (true) {
            j = 10000;
            if (!it2.hasNext()) {
                break;
            }
            Track next = it2.next();
            long duration = next.getDuration() / next.getTrackMetaData().getTimescale();
            if (duration > j2) {
                j2 = duration;
            }
            List<Sample> samples = next.getSamples();
            if (samples.size() < 10000) {
                while (samples.iterator().hasNext()) {
                    d2 += it.next().getSize();
                }
            } else {
                long j3 = 0;
                for (int i2 = 0; i2 < 10000; i2++) {
                    j3 += samples.get(i2).getSize();
                }
                d2 += (j3 * samples.size()) / 10000;
            }
        }
        double d3 = j2;
        double d4 = (d2 * 1.2d) / d3;
        do {
            long round = Math.round(((d4 * d3) / j) - d3) * 1000;
            linkedList.add(new ProgressiveDownloadInformationBox.Entry(j, round > 0 ? round + 3000 : 0L));
            j *= 2;
        } while (d4 > j);
        progressiveDownloadInformationBox.setEntries(linkedList);
        return progressiveDownloadInformationBox;
    }

    public Box createStbl(Movie movie, Track track) {
        SampleTableBox sampleTableBox = new SampleTableBox();
        createStsd(track, sampleTableBox);
        sampleTableBox.addBox(new TimeToSampleBox());
        sampleTableBox.addBox(new SampleToChunkBox());
        sampleTableBox.addBox(new SampleSizeBox());
        sampleTableBox.addBox(new StaticChunkOffsetBox());
        return sampleTableBox;
    }

    public void createStsd(Track track, SampleTableBox sampleTableBox) {
        sampleTableBox.addBox(track.getSampleDescriptionBox());
    }

    public TrackFragmentBaseMediaDecodeTimeBox createTfdt(long j, Track track) {
        TrackFragmentBaseMediaDecodeTimeBox trackFragmentBaseMediaDecodeTimeBox = new TrackFragmentBaseMediaDecodeTimeBox();
        trackFragmentBaseMediaDecodeTimeBox.setVersion(1);
        long[] sampleDurations = track.getSampleDurations();
        long j2 = 0;
        for (int i2 = 1; i2 < j; i2++) {
            j2 += sampleDurations[i2];
        }
        trackFragmentBaseMediaDecodeTimeBox.setBaseMediaDecodeTime(j2);
        return trackFragmentBaseMediaDecodeTimeBox;
    }

    public Box createTfhd(long j, long j2, Track track, int i2) {
        TrackFragmentHeaderBox trackFragmentHeaderBox = new TrackFragmentHeaderBox();
        trackFragmentHeaderBox.setDefaultSampleFlags(new SampleFlags());
        trackFragmentHeaderBox.setBaseDataOffset(-1L);
        trackFragmentHeaderBox.setTrackId(track.getTrackMetaData().getTrackId());
        return trackFragmentHeaderBox;
    }

    public Box createTfra(Track track, Container container) {
        SampleFlags defaultSampleFlags;
        TrackFragmentRandomAccessBox trackFragmentRandomAccessBox;
        LinkedList linkedList;
        TrackExtendsBox trackExtendsBox;
        Iterator<Box> it;
        int i2;
        int i3;
        int i4;
        List list;
        List list2;
        Box box;
        LinkedList linkedList2;
        TrackFragmentRandomAccessBox trackFragmentRandomAccessBox2 = new TrackFragmentRandomAccessBox();
        trackFragmentRandomAccessBox2.setVersion(1);
        LinkedList linkedList3 = new LinkedList();
        Iterator<Box> it2 = Path.getPaths(container, "moov/mvex/trex").iterator();
        TrackExtendsBox trackExtendsBox2 = null;
        while (it2.hasNext()) {
            TrackExtendsBox trackExtendsBox3 = trackExtendsBox2;
            trackExtendsBox2 = (TrackExtendsBox) it2.next();
            trackFragmentRandomAccessBox2 = trackFragmentRandomAccessBox2;
            linkedList3 = linkedList3;
            if (trackExtendsBox2.getTrackId() != track.getTrackMetaData().getTrackId()) {
                trackExtendsBox2 = trackExtendsBox3;
            }
        }
        Iterator<Box> it3 = container.getBoxes().iterator();
        long j = 0;
        long j2 = 0;
        while (it3.hasNext()) {
            Box next = it3.next();
            if (next instanceof MovieFragmentBox) {
                List boxes = ((MovieFragmentBox) next).getBoxes(TrackFragmentBox.class);
                int i5 = 0;
                int i6 = 0;
                while (i6 < boxes.size()) {
                    TrackFragmentBox trackFragmentBox = (TrackFragmentBox) boxes.get(i6);
                    if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == track.getTrackMetaData().getTrackId()) {
                        List boxes2 = trackFragmentBox.getBoxes(TrackRunBox.class);
                        int i7 = 0;
                        while (i7 < boxes2.size()) {
                            LinkedList linkedList4 = new LinkedList();
                            TrackRunBox trackRunBox = (TrackRunBox) boxes2.get(i7);
                            long j3 = j2;
                            int i8 = 0;
                            while (i8 < trackRunBox.getEntries().size()) {
                                TrackRunBox.Entry entry = trackRunBox.getEntries().get(i8);
                                if (i8 == 0 && trackRunBox.isFirstSampleFlagsPresent()) {
                                    defaultSampleFlags = trackRunBox.getFirstSampleFlags();
                                } else if (trackRunBox.isSampleFlagsPresent()) {
                                    defaultSampleFlags = entry.getSampleFlags();
                                } else {
                                    defaultSampleFlags = trackExtendsBox2.getDefaultSampleFlags();
                                }
                                if (defaultSampleFlags == null && track.getHandler().equals("vide")) {
                                    throw new RuntimeException("Cannot find SampleFlags for video track but it's required to build tfra");
                                }
                                if (defaultSampleFlags == null || defaultSampleFlags.getSampleDependsOn() == 2) {
                                    trackFragmentRandomAccessBox = trackFragmentRandomAccessBox2;
                                    linkedList = linkedList3;
                                    trackExtendsBox = trackExtendsBox2;
                                    it = it3;
                                    i2 = i8;
                                    i3 = i7;
                                    i4 = i6;
                                    list = boxes2;
                                    list2 = boxes;
                                    box = next;
                                    linkedList2 = linkedList4;
                                    linkedList2.add(new TrackFragmentRandomAccessBox.Entry(j3, j, i6 + 1, i7 + 1, i8 + 1));
                                } else {
                                    trackFragmentRandomAccessBox = trackFragmentRandomAccessBox2;
                                    linkedList = linkedList3;
                                    trackExtendsBox = trackExtendsBox2;
                                    it = it3;
                                    i2 = i8;
                                    i3 = i7;
                                    linkedList2 = linkedList4;
                                    i4 = i6;
                                    list = boxes2;
                                    list2 = boxes;
                                    box = next;
                                }
                                j3 += entry.getSampleDuration();
                                i8 = i2 + 1;
                                boxes = list2;
                                linkedList4 = linkedList2;
                                trackFragmentRandomAccessBox2 = trackFragmentRandomAccessBox;
                                linkedList3 = linkedList;
                                trackExtendsBox2 = trackExtendsBox;
                                it3 = it;
                                next = box;
                                i7 = i3;
                                i6 = i4;
                                boxes2 = list;
                                i5 = 0;
                            }
                            if (linkedList4.size() == trackRunBox.getEntries().size() && trackRunBox.getEntries().size() > 0) {
                                linkedList3.add((TrackFragmentRandomAccessBox.Entry) linkedList4.get(i5));
                            } else {
                                linkedList3.addAll(linkedList4);
                            }
                            i7++;
                            j2 = j3;
                        }
                        continue;
                    }
                    i6++;
                    boxes = boxes;
                    trackFragmentRandomAccessBox2 = trackFragmentRandomAccessBox2;
                    linkedList3 = linkedList3;
                    trackExtendsBox2 = trackExtendsBox2;
                    it3 = it3;
                    next = next;
                    i5 = 0;
                }
                continue;
            }
            j += next.getSize();
            trackFragmentRandomAccessBox2 = trackFragmentRandomAccessBox2;
            linkedList3 = linkedList3;
            trackExtendsBox2 = trackExtendsBox2;
            it3 = it3;
        }
        trackFragmentRandomAccessBox2.setEntries(linkedList3);
        trackFragmentRandomAccessBox2.setTrackId(track.getTrackMetaData().getTrackId());
        return trackFragmentRandomAccessBox2;
    }

    public Box createTkhd(Movie movie, Track track) {
        TrackHeaderBox trackHeaderBox = new TrackHeaderBox();
        trackHeaderBox.setVersion(1);
        trackHeaderBox.setFlags(7);
        trackHeaderBox.setAlternateGroup(track.getTrackMetaData().getGroup());
        trackHeaderBox.setCreationTime(track.getTrackMetaData().getCreationTime());
        trackHeaderBox.setDuration(0L);
        trackHeaderBox.setHeight(track.getTrackMetaData().getHeight());
        trackHeaderBox.setWidth(track.getTrackMetaData().getWidth());
        trackHeaderBox.setLayer(track.getTrackMetaData().getLayer());
        trackHeaderBox.setModificationTime(getDate());
        trackHeaderBox.setTrackId(track.getTrackMetaData().getTrackId());
        trackHeaderBox.setVolume(track.getTrackMetaData().getVolume());
        return trackHeaderBox;
    }

    public Box createTraf(long j, long j2, Track track, int i2) {
        TrackFragmentBox trackFragmentBox = new TrackFragmentBox();
        trackFragmentBox.addBox(createTfhd(j, j2, track, i2));
        trackFragmentBox.addBox(createTfdt(j, track));
        trackFragmentBox.addBox(createTrun(j, j2, track, i2));
        return trackFragmentBox;
    }

    public Box createTrak(Track track, Movie movie) {
        Logger logger = LOG;
        logger.fine("Creating Track " + track);
        TrackBox trackBox = new TrackBox();
        trackBox.addBox(createTkhd(movie, track));
        Box createEdts = createEdts(track, movie);
        if (createEdts != null) {
            trackBox.addBox(createEdts);
        }
        trackBox.addBox(createMdia(track, movie));
        return trackBox;
    }

    public Box createTrex(Movie movie, Track track) {
        TrackExtendsBox trackExtendsBox = new TrackExtendsBox();
        trackExtendsBox.setTrackId(track.getTrackMetaData().getTrackId());
        trackExtendsBox.setDefaultSampleDescriptionIndex(1L);
        trackExtendsBox.setDefaultSampleDuration(0L);
        trackExtendsBox.setDefaultSampleSize(0L);
        SampleFlags sampleFlags = new SampleFlags();
        if ("soun".equals(track.getHandler()) || "subt".equals(track.getHandler())) {
            sampleFlags.setSampleDependsOn(2);
            sampleFlags.setSampleIsDependedOn(2);
        }
        trackExtendsBox.setDefaultSampleFlags(sampleFlags);
        return trackExtendsBox;
    }

    public TrackRunBox createTrun(long j, long j2, Track track, int i2) {
        TrackRunBox trackRunBox = new TrackRunBox();
        long[] sampleSizes = getSampleSizes(j, j2, track, i2);
        trackRunBox.setSampleDurationPresent(true);
        trackRunBox.setSampleSizePresent(true);
        ArrayList arrayList = new ArrayList(CastUtils.l2i(j2 - j));
        List<CompositionTimeToSample.Entry> compositionTimeEntries = track.getCompositionTimeEntries();
        CompositionTimeToSample.Entry[] entryArr = (compositionTimeEntries == null || compositionTimeEntries.size() <= 0) ? null : (CompositionTimeToSample.Entry[]) compositionTimeEntries.toArray(new CompositionTimeToSample.Entry[compositionTimeEntries.size()]);
        long count = entryArr != null ? entryArr[0].getCount() : -1;
        trackRunBox.setSampleCompositionTimeOffsetPresent(count > 0);
        int i3 = 0;
        for (long j3 = 1; j3 < j; j3++) {
            if (entryArr != null) {
                count--;
                if (count == 0 && entryArr.length - i3 > 1) {
                    i3++;
                    count = entryArr[i3].getCount();
                }
            }
        }
        boolean z = ((track.getSampleDependencies() == null || track.getSampleDependencies().isEmpty()) && (track.getSyncSamples() == null || track.getSyncSamples().length == 0)) ? false : true;
        trackRunBox.setSampleFlagsPresent(z);
        for (int i4 = 0; i4 < sampleSizes.length; i4++) {
            TrackRunBox.Entry entry = new TrackRunBox.Entry();
            entry.setSampleSize(sampleSizes[i4]);
            if (z) {
                SampleFlags sampleFlags = new SampleFlags();
                if (track.getSampleDependencies() != null && !track.getSampleDependencies().isEmpty()) {
                    SampleDependencyTypeBox.Entry entry2 = track.getSampleDependencies().get(i4);
                    sampleFlags.setSampleDependsOn(entry2.getSampleDependsOn());
                    sampleFlags.setSampleIsDependedOn(entry2.getSampleIsDependentOn());
                    sampleFlags.setSampleHasRedundancy(entry2.getSampleHasRedundancy());
                }
                if (track.getSyncSamples() != null && track.getSyncSamples().length > 0) {
                    if (Arrays.binarySearch(track.getSyncSamples(), j + i4) >= 0) {
                        sampleFlags.setSampleIsDifferenceSample(false);
                        sampleFlags.setSampleDependsOn(2);
                    } else {
                        sampleFlags.setSampleIsDifferenceSample(true);
                        sampleFlags.setSampleDependsOn(1);
                    }
                }
                entry.setSampleFlags(sampleFlags);
            }
            entry.setSampleDuration(track.getSampleDurations()[CastUtils.l2i((j + i4) - 1)]);
            if (entryArr != null) {
                entry.setSampleCompositionTimeOffset(entryArr[i3].getOffset());
                count--;
                if (count == 0 && entryArr.length - i3 > 1) {
                    i3++;
                    count = entryArr[i3].getCount();
                }
            }
            arrayList.add(entry);
        }
        trackRunBox.setEntries(arrayList);
        return trackRunBox;
    }

    public List<String> getAllowedHandlers() {
        return Arrays.asList("soun", "vide");
    }

    public Date getDate() {
        return new Date();
    }

    public FragmentIntersectionFinder getFragmentIntersectionFinder() {
        return this.intersectionFinder;
    }

    public long[] getSampleSizes(long j, long j2, Track track, int i2) {
        List<Sample> samples = getSamples(j, j2, track, i2);
        int size = samples.size();
        long[] jArr = new long[size];
        for (int i3 = 0; i3 < size; i3++) {
            jArr[i3] = samples.get(i3).getSize();
        }
        return jArr;
    }

    public List<Sample> getSamples(long j, long j2, Track track, int i2) {
        return track.getSamples().subList(CastUtils.l2i(j) - 1, CastUtils.l2i(j2) - 1);
    }

    public void setIntersectionFinder(FragmentIntersectionFinder fragmentIntersectionFinder) {
        this.intersectionFinder = fragmentIntersectionFinder;
    }

    public List<Track> sortTracksInSequence(List<Track> list, int i2, Map<Track, long[]> map) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList, new a(this, map, i2));
        return linkedList;
    }
}
