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
/* loaded from: classes7.dex */
public class FragmentedMp4Builder implements Mp4Builder {
    private static final Logger LOG = Logger.getLogger(FragmentedMp4Builder.class.getName());
    protected FragmentIntersectionFinder intersectionFinder;

    public Date getDate() {
        return new Date();
    }

    public List<String> getAllowedHandlers() {
        return Arrays.asList("soun", "vide");
    }

    public Box createFtyp(Movie movie) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("iso2");
        linkedList.add(VisualSampleEntry.TYPE3);
        return new FileTypeBox("isom", 0L, linkedList);
    }

    protected List<Track> sortTracksInSequence(List<Track> list, final int i, final Map<Track, long[]> map) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList, new Comparator<Track>() { // from class: com.googlecode.mp4parser.authoring.builder.FragmentedMp4Builder.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Track track, Track track2) {
                long j = ((long[]) map.get(track))[i];
                long j2 = ((long[]) map.get(track2))[i];
                long[] sampleDurations = track.getSampleDurations();
                long[] sampleDurations2 = track2.getSampleDurations();
                long j3 = 0;
                long j4 = 0;
                for (int i2 = 1; i2 < j; i2++) {
                    j3 += sampleDurations[i2 - 1];
                }
                for (int i3 = 1; i3 < j2; i3++) {
                    j4 += sampleDurations2[i3 - 1];
                }
                return (int) (((j3 / track.getTrackMetaData().getTimescale()) - (j4 / track2.getTrackMetaData().getTimescale())) * 100.0d);
            }
        });
        return linkedList;
    }

    protected Box createPdin(Movie movie) {
        Iterator<Sample> it;
        ProgressiveDownloadInformationBox progressiveDownloadInformationBox = new ProgressiveDownloadInformationBox();
        LinkedList linkedList = new LinkedList();
        double d = 0.0d;
        long j = 0;
        for (Track track : movie.getTracks()) {
            long duration = track.getDuration() / track.getTrackMetaData().getTimescale();
            if (duration > j) {
                j = duration;
            }
            List<Sample> samples = track.getSamples();
            if (samples.size() < 10000) {
                while (samples.iterator().hasNext()) {
                    d += it.next().getSize();
                }
            } else {
                long j2 = 0;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 10000) {
                        break;
                    }
                    j2 += samples.get(i2).getSize();
                    i = i2 + 1;
                }
                d = ((samples.size() * j2) / 10000) + d;
            }
        }
        double d2 = (1.2d * d) / j;
        long j3 = 10000;
        do {
            long round = Math.round(((j * d2) / j3) - j) * 1000;
            linkedList.add(new ProgressiveDownloadInformationBox.Entry(j3, round > 0 ? round + 3000 : 0L));
            j3 *= 2;
        } while (d2 > j3);
        progressiveDownloadInformationBox.setEntries(linkedList);
        return progressiveDownloadInformationBox;
    }

    protected List<Box> createMoofMdat(Movie movie) {
        List<Box> linkedList = new LinkedList<>();
        HashMap hashMap = new HashMap();
        int i = 0;
        for (Track track : movie.getTracks()) {
            long[] sampleNumbers = this.intersectionFinder.sampleNumbers(track);
            hashMap.put(track, sampleNumbers);
            i = Math.max(i, sampleNumbers.length);
        }
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            for (Track track2 : sortTracksInSequence(movie.getTracks(), i3, hashMap)) {
                if (getAllowedHandlers().isEmpty() || getAllowedHandlers().contains(track2.getHandler())) {
                    i2 = createFragment(linkedList, track2, (long[]) hashMap.get(track2), i3, i2);
                }
            }
        }
        return linkedList;
    }

    protected int createFragment(List<Box> list, Track track, long[] jArr, int i, int i2) {
        if (i < jArr.length) {
            long j = jArr[i];
            long size = i + 1 < jArr.length ? jArr[i + 1] : track.getSamples().size() + 1;
            if (j != size) {
                list.add(createMoof(j, size, track, i2));
                int i3 = i2 + 1;
                list.add(createMdat(j, size, track, i2));
                return i3;
            }
            return i2;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.Mp4Builder
    public Container build(Movie movie) {
        Track track;
        LOG.fine("Creating movie " + movie);
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
        BasicContainer basicContainer = new BasicContainer();
        basicContainer.addBox(createFtyp(movie));
        basicContainer.addBox(createMoov(movie));
        for (Box box : createMoofMdat(movie)) {
            basicContainer.addBox(box);
        }
        basicContainer.addBox(createMfra(movie, basicContainer));
        return basicContainer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements Box {
        private final /* synthetic */ int lDE;
        long mGm = -1;
        private final /* synthetic */ long mGn;
        private final /* synthetic */ long mGo;
        private final /* synthetic */ Track mGp;
        Container parent;

        a(long j, long j2, Track track, int i) {
            this.mGn = j;
            this.mGo = j2;
            this.mGp = track;
            this.lDE = i;
        }

        @Override // com.coremedia.iso.boxes.Box
        public Container getParent() {
            return this.parent;
        }

        @Override // com.coremedia.iso.boxes.Box
        public long getOffset() {
            throw new RuntimeException("Doesn't have any meaning for programmatically created boxes");
        }

        @Override // com.coremedia.iso.boxes.Box
        public void setParent(Container container) {
            this.parent = container;
        }

        @Override // com.coremedia.iso.boxes.Box
        public long getSize() {
            if (this.mGm != -1) {
                return this.mGm;
            }
            long j = 8;
            for (Sample sample : FragmentedMp4Builder.this.getSamples(this.mGn, this.mGo, this.mGp, this.lDE)) {
                j = sample.getSize() + j;
            }
            this.mGm = j;
            return j;
        }

        @Override // com.coremedia.iso.boxes.Box
        public String getType() {
            return MediaDataBox.TYPE;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            IsoTypeWriter.writeUInt32(allocate, CastUtils.l2i(getSize()));
            allocate.put(IsoFile.fourCCtoBytes(getType()));
            allocate.rewind();
            writableByteChannel.write(allocate);
            for (Sample sample : FragmentedMp4Builder.this.getSamples(this.mGn, this.mGo, this.mGp, this.lDE)) {
                sample.writeTo(writableByteChannel);
            }
        }

        @Override // com.coremedia.iso.boxes.Box
        public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        }
    }

    protected Box createMdat(long j, long j2, Track track, int i) {
        return new a(j, j2, track, i);
    }

    protected Box createTfhd(long j, long j2, Track track, int i) {
        TrackFragmentHeaderBox trackFragmentHeaderBox = new TrackFragmentHeaderBox();
        trackFragmentHeaderBox.setDefaultSampleFlags(new SampleFlags());
        trackFragmentHeaderBox.setBaseDataOffset(-1L);
        trackFragmentHeaderBox.setTrackId(track.getTrackMetaData().getTrackId());
        return trackFragmentHeaderBox;
    }

    protected Box createMfhd(long j, long j2, Track track, int i) {
        MovieFragmentHeaderBox movieFragmentHeaderBox = new MovieFragmentHeaderBox();
        movieFragmentHeaderBox.setSequenceNumber(i);
        return movieFragmentHeaderBox;
    }

    protected Box createTraf(long j, long j2, Track track, int i) {
        TrackFragmentBox trackFragmentBox = new TrackFragmentBox();
        trackFragmentBox.addBox(createTfhd(j, j2, track, i));
        trackFragmentBox.addBox(createTfdt(j, track));
        trackFragmentBox.addBox(createTrun(j, j2, track, i));
        return trackFragmentBox;
    }

    protected List<Sample> getSamples(long j, long j2, Track track, int i) {
        return track.getSamples().subList(CastUtils.l2i(j) - 1, CastUtils.l2i(j2) - 1);
    }

    protected long[] getSampleSizes(long j, long j2, Track track, int i) {
        List<Sample> samples = getSamples(j, j2, track, i);
        long[] jArr = new long[samples.size()];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < jArr.length) {
                jArr[i3] = samples.get(i3).getSize();
                i2 = i3 + 1;
            } else {
                return jArr;
            }
        }
    }

    protected TrackFragmentBaseMediaDecodeTimeBox createTfdt(long j, Track track) {
        TrackFragmentBaseMediaDecodeTimeBox trackFragmentBaseMediaDecodeTimeBox = new TrackFragmentBaseMediaDecodeTimeBox();
        trackFragmentBaseMediaDecodeTimeBox.setVersion(1);
        long j2 = 0;
        long[] sampleDurations = track.getSampleDurations();
        for (int i = 1; i < j; i++) {
            j2 += sampleDurations[i];
        }
        trackFragmentBaseMediaDecodeTimeBox.setBaseMediaDecodeTime(j2);
        return trackFragmentBaseMediaDecodeTimeBox;
    }

    protected TrackRunBox createTrun(long j, long j2, Track track, int i) {
        int i2;
        TrackRunBox trackRunBox = new TrackRunBox();
        long[] sampleSizes = getSampleSizes(j, j2, track, i);
        trackRunBox.setSampleDurationPresent(true);
        trackRunBox.setSampleSizePresent(true);
        ArrayList arrayList = new ArrayList(CastUtils.l2i(j2 - j));
        List<CompositionTimeToSample.Entry> compositionTimeEntries = track.getCompositionTimeEntries();
        CompositionTimeToSample.Entry[] entryArr = (compositionTimeEntries == null || compositionTimeEntries.size() <= 0) ? null : (CompositionTimeToSample.Entry[]) compositionTimeEntries.toArray(new CompositionTimeToSample.Entry[compositionTimeEntries.size()]);
        if (entryArr != null) {
            i2 = entryArr[0].getCount();
        } else {
            i2 = -1;
        }
        long j3 = i2;
        trackRunBox.setSampleCompositionTimeOffsetPresent(j3 > 0);
        long j4 = j3;
        int i3 = 0;
        for (long j5 = 1; j5 < j; j5++) {
            if (entryArr != null) {
                j4--;
                if (j4 == 0 && entryArr.length - i3 > 1) {
                    i3++;
                    j4 = entryArr[i3].getCount();
                }
            }
        }
        boolean z = ((track.getSampleDependencies() == null || track.getSampleDependencies().isEmpty()) && (track.getSyncSamples() == null || track.getSyncSamples().length == 0)) ? false : true;
        trackRunBox.setSampleFlagsPresent(z);
        long j6 = j4;
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
                    if (Arrays.binarySearch(track.getSyncSamples(), i4 + j) >= 0) {
                        sampleFlags.setSampleIsDifferenceSample(false);
                        sampleFlags.setSampleDependsOn(2);
                    } else {
                        sampleFlags.setSampleIsDifferenceSample(true);
                        sampleFlags.setSampleDependsOn(1);
                    }
                }
                entry.setSampleFlags(sampleFlags);
            }
            entry.setSampleDuration(track.getSampleDurations()[CastUtils.l2i((i4 + j) - 1)]);
            if (entryArr != null) {
                entry.setSampleCompositionTimeOffset(entryArr[i3].getOffset());
                j6--;
                if (j6 == 0 && entryArr.length - i3 > 1) {
                    i3++;
                    j6 = entryArr[i3].getCount();
                }
            }
            arrayList.add(entry);
        }
        trackRunBox.setEntries(arrayList);
        return trackRunBox;
    }

    protected Box createMoof(long j, long j2, Track track, int i) {
        MovieFragmentBox movieFragmentBox = new MovieFragmentBox();
        movieFragmentBox.addBox(createMfhd(j, j2, track, i));
        movieFragmentBox.addBox(createTraf(j, j2, track, i));
        TrackRunBox trackRunBox = movieFragmentBox.getTrackRunBoxes().get(0);
        trackRunBox.setDataOffset(1);
        trackRunBox.setDataOffset((int) (8 + movieFragmentBox.getSize()));
        return movieFragmentBox;
    }

    protected Box createMvhd(Movie movie) {
        long j = 0;
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.setVersion(1);
        movieHeaderBox.setCreationTime(getDate());
        movieHeaderBox.setModificationTime(getDate());
        movieHeaderBox.setDuration(0L);
        movieHeaderBox.setTimescale(movie.getTimescale());
        Iterator<Track> it = movie.getTracks().iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                Track next = it.next();
                j = j2 < next.getTrackMetaData().getTrackId() ? next.getTrackMetaData().getTrackId() : j2;
            } else {
                movieHeaderBox.setNextTrackId(1 + j2);
                return movieHeaderBox;
            }
        }
    }

    protected Box createMoov(Movie movie) {
        MovieBox movieBox = new MovieBox();
        movieBox.addBox(createMvhd(movie));
        for (Track track : movie.getTracks()) {
            movieBox.addBox(createTrak(track, movie));
        }
        movieBox.addBox(createMvex(movie));
        return movieBox;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00eb, code lost:
        if (r25.size() != r14.getEntries().size()) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f5, code lost:
        if (r14.getEntries().size() <= 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f7, code lost:
        r21.add((com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.Entry) r25.get(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0172, code lost:
        r21.addAll(r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0086, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00bb, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Box createTfra(Track track, Container container) {
        SampleFlags defaultSampleFlags;
        TrackFragmentRandomAccessBox trackFragmentRandomAccessBox = new TrackFragmentRandomAccessBox();
        trackFragmentRandomAccessBox.setVersion(1);
        LinkedList linkedList = new LinkedList();
        TrackExtendsBox trackExtendsBox = null;
        for (Box box : Path.getPaths(container, "moov/mvex/trex")) {
            if (((TrackExtendsBox) box).getTrackId() == track.getTrackMetaData().getTrackId()) {
                trackExtendsBox = (TrackExtendsBox) box;
            }
        }
        long j = 0;
        long j2 = 0;
        for (Box box2 : container.getBoxes()) {
            if (box2 instanceof MovieFragmentBox) {
                List boxes = ((MovieFragmentBox) box2).getBoxes(TrackFragmentBox.class);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= boxes.size()) {
                        break;
                    }
                    TrackFragmentBox trackFragmentBox = (TrackFragmentBox) boxes.get(i2);
                    if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == track.getTrackMetaData().getTrackId()) {
                        List boxes2 = trackFragmentBox.getBoxes(TrackRunBox.class);
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= boxes2.size()) {
                                break;
                            }
                            LinkedList linkedList2 = new LinkedList();
                            TrackRunBox trackRunBox = (TrackRunBox) boxes2.get(i4);
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= trackRunBox.getEntries().size()) {
                                    break;
                                }
                                TrackRunBox.Entry entry = trackRunBox.getEntries().get(i6);
                                if (i6 == 0 && trackRunBox.isFirstSampleFlagsPresent()) {
                                    defaultSampleFlags = trackRunBox.getFirstSampleFlags();
                                } else if (trackRunBox.isSampleFlagsPresent()) {
                                    defaultSampleFlags = entry.getSampleFlags();
                                } else {
                                    defaultSampleFlags = trackExtendsBox.getDefaultSampleFlags();
                                }
                                if (defaultSampleFlags == null && track.getHandler().equals("vide")) {
                                    throw new RuntimeException("Cannot find SampleFlags for video track but it's required to build tfra");
                                }
                                if (defaultSampleFlags == null || defaultSampleFlags.getSampleDependsOn() == 2) {
                                    linkedList2.add(new TrackFragmentRandomAccessBox.Entry(j2, j, i2 + 1, i4 + 1, i6 + 1));
                                }
                                j2 += entry.getSampleDuration();
                                i5 = i6 + 1;
                            }
                            i3 = i4 + 1;
                        }
                    }
                    i = i2 + 1;
                }
            }
            j += box2.getSize();
        }
        trackFragmentRandomAccessBox.setEntries(linkedList);
        trackFragmentRandomAccessBox.setTrackId(track.getTrackMetaData().getTrackId());
        return trackFragmentRandomAccessBox;
    }

    protected Box createMfra(Movie movie, Container container) {
        MovieFragmentRandomAccessBox movieFragmentRandomAccessBox = new MovieFragmentRandomAccessBox();
        for (Track track : movie.getTracks()) {
            movieFragmentRandomAccessBox.addBox(createTfra(track, container));
        }
        MovieFragmentRandomAccessOffsetBox movieFragmentRandomAccessOffsetBox = new MovieFragmentRandomAccessOffsetBox();
        movieFragmentRandomAccessBox.addBox(movieFragmentRandomAccessOffsetBox);
        movieFragmentRandomAccessOffsetBox.setMfraSize(movieFragmentRandomAccessBox.getSize());
        return movieFragmentRandomAccessBox;
    }

    protected Box createTrex(Movie movie, Track track) {
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

    protected Box createMvex(Movie movie) {
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

    protected Box createTkhd(Movie movie, Track track) {
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

    private long getTrackDuration(Movie movie, Track track) {
        return (track.getDuration() * movie.getTimescale()) / track.getTrackMetaData().getTimescale();
    }

    protected Box createMdhd(Movie movie, Track track) {
        MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
        mediaHeaderBox.setCreationTime(track.getTrackMetaData().getCreationTime());
        mediaHeaderBox.setModificationTime(getDate());
        mediaHeaderBox.setDuration(0L);
        mediaHeaderBox.setTimescale(track.getTrackMetaData().getTimescale());
        mediaHeaderBox.setLanguage(track.getTrackMetaData().getLanguage());
        return mediaHeaderBox;
    }

    protected Box createStbl(Movie movie, Track track) {
        SampleTableBox sampleTableBox = new SampleTableBox();
        createStsd(track, sampleTableBox);
        sampleTableBox.addBox(new TimeToSampleBox());
        sampleTableBox.addBox(new SampleToChunkBox());
        sampleTableBox.addBox(new SampleSizeBox());
        sampleTableBox.addBox(new StaticChunkOffsetBox());
        return sampleTableBox;
    }

    protected void createStsd(Track track, SampleTableBox sampleTableBox) {
        sampleTableBox.addBox(track.getSampleDescriptionBox());
    }

    protected Box createMinf(Track track, Movie movie) {
        MediaInformationBox mediaInformationBox = new MediaInformationBox();
        mediaInformationBox.addBox(track.getMediaHeaderBox());
        mediaInformationBox.addBox(createDinf(movie, track));
        mediaInformationBox.addBox(createStbl(movie, track));
        return mediaInformationBox;
    }

    protected Box createMdiaHdlr(Track track, Movie movie) {
        HandlerBox handlerBox = new HandlerBox();
        handlerBox.setHandlerType(track.getHandler());
        return handlerBox;
    }

    protected Box createMdia(Track track, Movie movie) {
        MediaBox mediaBox = new MediaBox();
        mediaBox.addBox(createMdhd(movie, track));
        mediaBox.addBox(createMdiaHdlr(track, movie));
        mediaBox.addBox(createMinf(track, movie));
        return mediaBox;
    }

    protected Box createTrak(Track track, Movie movie) {
        LOG.fine("Creating Track " + track);
        TrackBox trackBox = new TrackBox();
        trackBox.addBox(createTkhd(movie, track));
        Box createEdts = createEdts(track, movie);
        if (createEdts != null) {
            trackBox.addBox(createEdts);
        }
        trackBox.addBox(createMdia(track, movie));
        return trackBox;
    }

    protected Box createEdts(Track track, Movie movie) {
        EditListBox editList = track.getTrackMetaData().getEditList();
        if (editList != null) {
            EditBox editBox = new EditBox();
            editBox.addBox(editList);
            return editBox;
        }
        return null;
    }

    protected DataInformationBox createDinf(Movie movie, Track track) {
        DataInformationBox dataInformationBox = new DataInformationBox();
        DataReferenceBox dataReferenceBox = new DataReferenceBox();
        dataInformationBox.addBox(dataReferenceBox);
        DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
        dataEntryUrlBox.setFlags(1);
        dataReferenceBox.addBox(dataEntryUrlBox);
        return dataInformationBox;
    }

    public FragmentIntersectionFinder getFragmentIntersectionFinder() {
        return this.intersectionFinder;
    }

    public void setIntersectionFinder(FragmentIntersectionFinder fragmentIntersectionFinder) {
        this.intersectionFinder = fragmentIntersectionFinder;
    }
}
