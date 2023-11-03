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
/* loaded from: classes10.dex */
public class FragmentedMp4Builder implements Mp4Builder {
    public static final Logger LOG = Logger.getLogger(FragmentedMp4Builder.class.getName());
    public FragmentIntersectionFinder intersectionFinder;

    public List<String> getAllowedHandlers() {
        return Arrays.asList("soun", "vide");
    }

    public Date getDate() {
        return new Date();
    }

    public FragmentIntersectionFinder getFragmentIntersectionFinder() {
        return this.intersectionFinder;
    }

    private long getTrackDuration(Movie movie, Track track) {
        return (track.getDuration() * movie.getTimescale()) / track.getTrackMetaData().getTimescale();
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
        for (int i = 1; i < j; i++) {
            j2 += sampleDurations[i];
        }
        trackFragmentBaseMediaDecodeTimeBox.setBaseMediaDecodeTime(j2);
        return trackFragmentBaseMediaDecodeTimeBox;
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

    public List<Box> createMoofMdat(Movie movie) {
        List<Box> linkedList = new LinkedList<>();
        HashMap hashMap = new HashMap();
        int i = 0;
        for (Track track : movie.getTracks()) {
            long[] sampleNumbers = this.intersectionFinder.sampleNumbers(track);
            hashMap.put(track, sampleNumbers);
            i = Math.max(i, sampleNumbers.length);
        }
        int i2 = 1;
        int i3 = 0;
        while (i3 < i) {
            int i4 = i2;
            for (Track track2 : sortTracksInSequence(movie.getTracks(), i3, hashMap)) {
                if (getAllowedHandlers().isEmpty() || getAllowedHandlers().contains(track2.getHandler())) {
                    i4 = createFragment(linkedList, track2, (long[]) hashMap.get(track2), i3, i4);
                }
            }
            i3++;
            i2 = i4;
        }
        return linkedList;
    }

    public int createFragment(List<Box> list, Track track, long[] jArr, int i, int i2) {
        long size;
        if (i < jArr.length) {
            long j = jArr[i];
            int i3 = i + 1;
            if (i3 < jArr.length) {
                size = jArr[i3];
            } else {
                size = track.getSamples().size() + 1;
            }
            if (j != size) {
                long j2 = size;
                list.add(createMoof(j, j2, track, i2));
                int i4 = i2 + 1;
                list.add(createMdat(j, j2, track, i2));
                return i4;
            }
            return i2;
        }
        return i2;
    }

    public Box createFtyp(Movie movie) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("iso2");
        linkedList.add("avc1");
        return new FileTypeBox("isom", 0L, linkedList);
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

    public void setIntersectionFinder(FragmentIntersectionFinder fragmentIntersectionFinder) {
        this.intersectionFinder = fragmentIntersectionFinder;
    }

    public Box createMdat(final long j, final long j2, final Track track, final int i) {
        return new Box() { // from class: com.googlecode.mp4parser.authoring.builder.FragmentedMp4Builder.1Mdat
            public Container parent;
            public long size_ = -1;

            @Override // com.coremedia.iso.boxes.Box
            public String getType() {
                return MediaDataBox.TYPE;
            }

            @Override // com.coremedia.iso.boxes.Box
            public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j3, BoxParser boxParser) throws IOException {
            }

            @Override // com.coremedia.iso.boxes.Box
            public void getBox(WritableByteChannel writableByteChannel) throws IOException {
                ByteBuffer allocate = ByteBuffer.allocate(8);
                IsoTypeWriter.writeUInt32(allocate, CastUtils.l2i(getSize()));
                allocate.put(IsoFile.fourCCtoBytes(getType()));
                allocate.rewind();
                writableByteChannel.write(allocate);
                for (Sample sample : FragmentedMp4Builder.this.getSamples(j, j2, track, i)) {
                    sample.writeTo(writableByteChannel);
                }
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
                long j3 = this.size_;
                if (j3 != -1) {
                    return j3;
                }
                long j4 = 8;
                for (Sample sample : FragmentedMp4Builder.this.getSamples(j, j2, track, i)) {
                    j4 += sample.getSize();
                }
                this.size_ = j4;
                return j4;
            }

            @Override // com.coremedia.iso.boxes.Box
            public void setParent(Container container) {
                this.parent = container;
            }
        };
    }

    public Box createMfhd(long j, long j2, Track track, int i) {
        MovieFragmentHeaderBox movieFragmentHeaderBox = new MovieFragmentHeaderBox();
        movieFragmentHeaderBox.setSequenceNumber(i);
        return movieFragmentHeaderBox;
    }

    public Box createMoof(long j, long j2, Track track, int i) {
        MovieFragmentBox movieFragmentBox = new MovieFragmentBox();
        movieFragmentBox.addBox(createMfhd(j, j2, track, i));
        movieFragmentBox.addBox(createTraf(j, j2, track, i));
        TrackRunBox trackRunBox = movieFragmentBox.getTrackRunBoxes().get(0);
        trackRunBox.setDataOffset(1);
        trackRunBox.setDataOffset((int) (movieFragmentBox.getSize() + 8));
        return movieFragmentBox;
    }

    public Box createTfhd(long j, long j2, Track track, int i) {
        TrackFragmentHeaderBox trackFragmentHeaderBox = new TrackFragmentHeaderBox();
        trackFragmentHeaderBox.setDefaultSampleFlags(new SampleFlags());
        trackFragmentHeaderBox.setBaseDataOffset(-1L);
        trackFragmentHeaderBox.setTrackId(track.getTrackMetaData().getTrackId());
        return trackFragmentHeaderBox;
    }

    public Box createTraf(long j, long j2, Track track, int i) {
        TrackFragmentBox trackFragmentBox = new TrackFragmentBox();
        trackFragmentBox.addBox(createTfhd(j, j2, track, i));
        trackFragmentBox.addBox(createTfdt(j, track));
        trackFragmentBox.addBox(createTrun(j, j2, track, i));
        return trackFragmentBox;
    }

    public long[] getSampleSizes(long j, long j2, Track track, int i) {
        List<Sample> samples = getSamples(j, j2, track, i);
        int size = samples.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = samples.get(i2).getSize();
        }
        return jArr;
    }

    public List<Sample> getSamples(long j, long j2, Track track, int i) {
        return track.getSamples().subList(CastUtils.l2i(j) - 1, CastUtils.l2i(j2) - 1);
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
        long j2;
        Iterator<Sample> it;
        ProgressiveDownloadInformationBox progressiveDownloadInformationBox = new ProgressiveDownloadInformationBox();
        LinkedList linkedList = new LinkedList();
        Iterator<Track> it2 = movie.getTracks().iterator();
        double d = 0.0d;
        long j3 = 0;
        while (true) {
            j = 10000;
            if (!it2.hasNext()) {
                break;
            }
            Track next = it2.next();
            long duration = next.getDuration() / next.getTrackMetaData().getTimescale();
            if (duration > j3) {
                j3 = duration;
            }
            List<Sample> samples = next.getSamples();
            if (samples.size() < 10000) {
                while (samples.iterator().hasNext()) {
                    d += it.next().getSize();
                }
            } else {
                long j4 = 0;
                for (int i = 0; i < 10000; i++) {
                    j4 += samples.get(i).getSize();
                }
                d += (j4 * samples.size()) / 10000;
            }
        }
        double d2 = j3;
        double d3 = (d * 1.2d) / d2;
        do {
            long round = Math.round(((d3 * d2) / j) - d2) * 1000;
            if (round > 0) {
                j2 = round + 3000;
            } else {
                j2 = 0;
            }
            linkedList.add(new ProgressiveDownloadInformationBox.Entry(j, j2));
            j *= 2;
        } while (d3 > j);
        progressiveDownloadInformationBox.setEntries(linkedList);
        return progressiveDownloadInformationBox;
    }

    public Box createTfra(Track track, Container container) {
        SampleFlags defaultSampleFlags;
        TrackFragmentRandomAccessBox trackFragmentRandomAccessBox;
        LinkedList linkedList;
        TrackExtendsBox trackExtendsBox;
        Iterator<Box> it;
        int i;
        int i2;
        int i3;
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
                int i4 = 0;
                int i5 = 0;
                while (i5 < boxes.size()) {
                    TrackFragmentBox trackFragmentBox = (TrackFragmentBox) boxes.get(i5);
                    if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == track.getTrackMetaData().getTrackId()) {
                        List boxes2 = trackFragmentBox.getBoxes(TrackRunBox.class);
                        int i6 = 0;
                        while (i6 < boxes2.size()) {
                            LinkedList linkedList4 = new LinkedList();
                            TrackRunBox trackRunBox = (TrackRunBox) boxes2.get(i6);
                            long j3 = j2;
                            int i7 = 0;
                            while (i7 < trackRunBox.getEntries().size()) {
                                TrackRunBox.Entry entry = trackRunBox.getEntries().get(i7);
                                if (i7 == 0 && trackRunBox.isFirstSampleFlagsPresent()) {
                                    defaultSampleFlags = trackRunBox.getFirstSampleFlags();
                                } else if (trackRunBox.isSampleFlagsPresent()) {
                                    defaultSampleFlags = entry.getSampleFlags();
                                } else {
                                    defaultSampleFlags = trackExtendsBox2.getDefaultSampleFlags();
                                }
                                if (defaultSampleFlags == null && track.getHandler().equals("vide")) {
                                    throw new RuntimeException("Cannot find SampleFlags for video track but it's required to build tfra");
                                }
                                if (defaultSampleFlags != null && defaultSampleFlags.getSampleDependsOn() != 2) {
                                    trackFragmentRandomAccessBox = trackFragmentRandomAccessBox2;
                                    linkedList = linkedList3;
                                    trackExtendsBox = trackExtendsBox2;
                                    it = it3;
                                    i = i7;
                                    i2 = i6;
                                    linkedList2 = linkedList4;
                                    i3 = i5;
                                    list = boxes2;
                                    list2 = boxes;
                                    box = next;
                                } else {
                                    trackFragmentRandomAccessBox = trackFragmentRandomAccessBox2;
                                    linkedList = linkedList3;
                                    trackExtendsBox = trackExtendsBox2;
                                    it = it3;
                                    i = i7;
                                    i2 = i6;
                                    i3 = i5;
                                    list = boxes2;
                                    list2 = boxes;
                                    box = next;
                                    linkedList2 = linkedList4;
                                    linkedList2.add(new TrackFragmentRandomAccessBox.Entry(j3, j, i5 + 1, i6 + 1, i7 + 1));
                                }
                                j3 += entry.getSampleDuration();
                                i7 = i + 1;
                                boxes = list2;
                                linkedList4 = linkedList2;
                                trackFragmentRandomAccessBox2 = trackFragmentRandomAccessBox;
                                linkedList3 = linkedList;
                                trackExtendsBox2 = trackExtendsBox;
                                it3 = it;
                                next = box;
                                i6 = i2;
                                i5 = i3;
                                boxes2 = list;
                                i4 = 0;
                            }
                            if (linkedList4.size() == trackRunBox.getEntries().size() && trackRunBox.getEntries().size() > 0) {
                                linkedList3.add((TrackFragmentRandomAccessBox.Entry) linkedList4.get(i4));
                            } else {
                                linkedList3.addAll(linkedList4);
                            }
                            i6++;
                            j2 = j3;
                        }
                        continue;
                    }
                    i5++;
                    boxes = boxes;
                    trackFragmentRandomAccessBox2 = trackFragmentRandomAccessBox2;
                    linkedList3 = linkedList3;
                    trackExtendsBox2 = trackExtendsBox2;
                    it3 = it3;
                    next = next;
                    i4 = 0;
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

    public TrackRunBox createTrun(long j, long j2, Track track, int i) {
        CompositionTimeToSample.Entry[] entryArr;
        int i2;
        boolean z;
        boolean z2;
        TrackRunBox trackRunBox = new TrackRunBox();
        long[] sampleSizes = getSampleSizes(j, j2, track, i);
        trackRunBox.setSampleDurationPresent(true);
        trackRunBox.setSampleSizePresent(true);
        ArrayList arrayList = new ArrayList(CastUtils.l2i(j2 - j));
        List<CompositionTimeToSample.Entry> compositionTimeEntries = track.getCompositionTimeEntries();
        if (compositionTimeEntries != null && compositionTimeEntries.size() > 0) {
            entryArr = (CompositionTimeToSample.Entry[]) compositionTimeEntries.toArray(new CompositionTimeToSample.Entry[compositionTimeEntries.size()]);
        } else {
            entryArr = null;
        }
        if (entryArr != null) {
            i2 = entryArr[0].getCount();
        } else {
            i2 = -1;
        }
        long j3 = i2;
        if (j3 > 0) {
            z = true;
        } else {
            z = false;
        }
        trackRunBox.setSampleCompositionTimeOffsetPresent(z);
        int i3 = 0;
        for (long j4 = 1; j4 < j; j4++) {
            if (entryArr != null) {
                j3--;
                if (j3 == 0 && entryArr.length - i3 > 1) {
                    i3++;
                    j3 = entryArr[i3].getCount();
                }
            }
        }
        if ((track.getSampleDependencies() != null && !track.getSampleDependencies().isEmpty()) || (track.getSyncSamples() != null && track.getSyncSamples().length != 0)) {
            z2 = true;
        } else {
            z2 = false;
        }
        trackRunBox.setSampleFlagsPresent(z2);
        for (int i4 = 0; i4 < sampleSizes.length; i4++) {
            TrackRunBox.Entry entry = new TrackRunBox.Entry();
            entry.setSampleSize(sampleSizes[i4]);
            if (z2) {
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
                j3--;
                if (j3 == 0 && entryArr.length - i3 > 1) {
                    i3++;
                    j3 = entryArr[i3].getCount();
                }
            }
            arrayList.add(entry);
        }
        trackRunBox.setEntries(arrayList);
        return trackRunBox;
    }

    public List<Track> sortTracksInSequence(List<Track> list, final int i, final Map<Track, long[]> map) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList, new Comparator<Track>() { // from class: com.googlecode.mp4parser.authoring.builder.FragmentedMp4Builder.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Track track, Track track2) {
                long j = ((long[]) map.get(track))[i];
                long j2 = ((long[]) map.get(track2))[i];
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
        });
        return linkedList;
    }
}
