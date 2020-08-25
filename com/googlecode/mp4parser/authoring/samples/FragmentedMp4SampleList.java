package com.googlecode.mp4parser.authoring.samples;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Path;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class FragmentedMp4SampleList extends AbstractList<Sample> {
    private List<TrackFragmentBox> allTrafs;
    IsoFile[] fragments;
    private SoftReference<Sample>[] sampleCache;
    private int size_ = -1;
    Container topLevel;
    TrackBox trackBox;
    TrackExtendsBox trex;

    public FragmentedMp4SampleList(long j, Container container, IsoFile... isoFileArr) {
        this.trackBox = null;
        this.trex = null;
        this.topLevel = container;
        this.fragments = isoFileArr;
        for (TrackBox trackBox : ((MovieBox) container.getBoxes(MovieBox.class).get(0)).getBoxes(TrackBox.class)) {
            if (trackBox.getTrackHeaderBox().getTrackId() == j) {
                this.trackBox = trackBox;
            }
        }
        if (this.trackBox == null) {
            throw new RuntimeException("This MP4 does not contain track " + j);
        }
        for (Box box : Path.getPaths(container, "moov/mvex/trex")) {
            if (((TrackExtendsBox) box).getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                this.trex = (TrackExtendsBox) box;
            }
        }
        this.sampleCache = (SoftReference[]) Array.newInstance(SoftReference.class, size());
    }

    private List<TrackFragmentBox> allFragments() {
        if (this.allTrafs != null) {
            return this.allTrafs;
        }
        LinkedList linkedList = new LinkedList();
        for (MovieFragmentBox movieFragmentBox : this.topLevel.getBoxes(MovieFragmentBox.class)) {
            for (TrackFragmentBox trackFragmentBox : movieFragmentBox.getBoxes(TrackFragmentBox.class)) {
                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                    linkedList.add(trackFragmentBox);
                }
            }
        }
        if (this.fragments != null) {
            for (IsoFile isoFile : this.fragments) {
                for (MovieFragmentBox movieFragmentBox2 : isoFile.getBoxes(MovieFragmentBox.class)) {
                    for (TrackFragmentBox trackFragmentBox2 : movieFragmentBox2.getBoxes(TrackFragmentBox.class)) {
                        if (trackFragmentBox2.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                            linkedList.add(trackFragmentBox2);
                        }
                    }
                }
            }
        }
        this.allTrafs = linkedList;
        return linkedList;
    }

    private int getTrafSize(TrackFragmentBox trackFragmentBox) {
        return CastUtils.l2i(((TrackRunBox) trackFragmentBox.getBoxes(TrackRunBox.class).get(0)).getSampleCount());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i) {
        long offset;
        long defaultSampleSize;
        long defaultSampleSize2;
        Sample sample;
        if (this.sampleCache[i] == null || (sample = this.sampleCache[i].get()) == null) {
            int i2 = 1;
            int i3 = i + 1;
            Iterator<TrackFragmentBox> it = allFragments().iterator();
            while (true) {
                int i4 = i2;
                if (it.hasNext()) {
                    TrackFragmentBox next = it.next();
                    int trafSize = getTrafSize(next);
                    if (i3 >= i4 && i3 < i4 + trafSize) {
                        int i5 = i3 - i4;
                        MovieFragmentBox movieFragmentBox = (MovieFragmentBox) next.getParent();
                        TrackRunBox trackRunBox = (TrackRunBox) next.getBoxes(TrackRunBox.class).get(0);
                        long dataOffset = trackRunBox.isDataOffsetPresent() ? 0 + trackRunBox.getDataOffset() : 0L;
                        List<TrackRunBox.Entry> entries = trackRunBox.getEntries();
                        if (next.getTrackFragmentHeaderBox().hasBaseDataOffset()) {
                            offset = dataOffset + next.getTrackFragmentHeaderBox().getBaseDataOffset();
                        } else {
                            offset = dataOffset + movieFragmentBox.getOffset();
                        }
                        for (int i6 = 0; i6 < i5; i6++) {
                            if (trackRunBox.isSampleSizePresent()) {
                                defaultSampleSize2 = entries.get(i6).getSampleSize();
                            } else if (next.getTrackFragmentHeaderBox().hasDefaultSampleSize()) {
                                defaultSampleSize2 = next.getTrackFragmentHeaderBox().getDefaultSampleSize();
                            } else if (this.trex == null) {
                                throw new RuntimeException("File doesn't contain trex box but track fragments aren't fully self contained. Cannot determine sample size.");
                            } else {
                                defaultSampleSize2 = this.trex.getDefaultSampleSize();
                            }
                            offset += defaultSampleSize2;
                        }
                        if (trackRunBox.isSampleSizePresent()) {
                            defaultSampleSize = entries.get(i5).getSampleSize();
                        } else if (next.getTrackFragmentHeaderBox().hasDefaultSampleSize()) {
                            defaultSampleSize = next.getTrackFragmentHeaderBox().getDefaultSampleSize();
                        } else if (this.trex == null) {
                            throw new RuntimeException("File doesn't contain trex box but track fragments aren't fully self contained. Cannot determine sample size.");
                        } else {
                            defaultSampleSize = this.trex.getDefaultSampleSize();
                        }
                        SampleImpl sampleImpl = new SampleImpl(offset, defaultSampleSize, movieFragmentBox.getParent());
                        this.sampleCache[i] = new SoftReference<>(sampleImpl);
                        return sampleImpl;
                    }
                    i2 = i4 + trafSize;
                } else {
                    return null;
                }
            }
        } else {
            return sample;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        if (this.size_ != -1) {
            return this.size_;
        }
        int i = 0;
        for (MovieFragmentBox movieFragmentBox : this.topLevel.getBoxes(MovieFragmentBox.class)) {
            for (TrackFragmentBox trackFragmentBox : movieFragmentBox.getBoxes(TrackFragmentBox.class)) {
                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                    i = (int) (((TrackRunBox) trackFragmentBox.getBoxes(TrackRunBox.class).get(0)).getSampleCount() + i);
                }
            }
        }
        IsoFile[] isoFileArr = this.fragments;
        int length = isoFileArr.length;
        int i2 = 0;
        int i3 = i;
        while (i2 < length) {
            int i4 = i3;
            for (MovieFragmentBox movieFragmentBox2 : isoFileArr[i2].getBoxes(MovieFragmentBox.class)) {
                for (TrackFragmentBox trackFragmentBox2 : movieFragmentBox2.getBoxes(TrackFragmentBox.class)) {
                    if (trackFragmentBox2.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                        i4 = (int) (((TrackRunBox) trackFragmentBox2.getBoxes(TrackRunBox.class).get(0)).getSampleCount() + i4);
                    }
                }
            }
            i2++;
            i3 = i4;
        }
        this.size_ = i3;
        return i3;
    }
}
