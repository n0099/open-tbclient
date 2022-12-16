package com.googlecode.mp4parser.authoring.samples;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<TrackFragmentBox> allTrafs;
    public IsoFile[] fragments;
    public SoftReference<Sample>[] sampleCache;
    public int size_;
    public Container topLevel;
    public TrackBox trackBox;
    public TrackExtendsBox trex;

    public FragmentedMp4SampleList(long j, Container container, IsoFile... isoFileArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), container, isoFileArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.trackBox = null;
        this.trex = null;
        this.size_ = -1;
        this.topLevel = container;
        this.fragments = isoFileArr;
        for (TrackBox trackBox : ((MovieBox) container.getBoxes(MovieBox.class).get(0)).getBoxes(TrackBox.class)) {
            if (trackBox.getTrackHeaderBox().getTrackId() == j) {
                this.trackBox = trackBox;
            }
        }
        if (this.trackBox != null) {
            Iterator<Box> it = Path.getPaths(container, "moov/mvex/trex").iterator();
            while (it.hasNext()) {
                TrackExtendsBox trackExtendsBox = (TrackExtendsBox) it.next();
                if (trackExtendsBox.getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                    this.trex = trackExtendsBox;
                }
            }
            this.sampleCache = (SoftReference[]) Array.newInstance(SoftReference.class, size());
            return;
        }
        throw new RuntimeException("This MP4 does not contain track " + j);
    }

    private List<TrackFragmentBox> allFragments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            List<TrackFragmentBox> list = this.allTrafs;
            if (list != null) {
                return list;
            }
            LinkedList linkedList = new LinkedList();
            for (MovieFragmentBox movieFragmentBox : this.topLevel.getBoxes(MovieFragmentBox.class)) {
                for (TrackFragmentBox trackFragmentBox : movieFragmentBox.getBoxes(TrackFragmentBox.class)) {
                    if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                        linkedList.add(trackFragmentBox);
                    }
                }
            }
            IsoFile[] isoFileArr = this.fragments;
            if (isoFileArr != null) {
                for (IsoFile isoFile : isoFileArr) {
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
        return (List) invokeV.objValue;
    }

    private int getTrafSize(TrackFragmentBox trackFragmentBox) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, trackFragmentBox)) == null) {
            return CastUtils.l2i(((TrackRunBox) trackFragmentBox.getBoxes(TrackRunBox.class).get(0)).getSampleCount());
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i) {
        InterceptResult invokeI;
        long offset;
        long defaultSampleSize;
        long defaultSampleSize2;
        Sample sample;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            SoftReference<Sample>[] softReferenceArr = this.sampleCache;
            if (softReferenceArr[i] != null && (sample = softReferenceArr[i].get()) != null) {
                return sample;
            }
            int i2 = i + 1;
            int i3 = 1;
            for (TrackFragmentBox trackFragmentBox : allFragments()) {
                int trafSize = getTrafSize(trackFragmentBox);
                if (i2 >= i3 && i2 < i3 + trafSize) {
                    int i4 = i2 - i3;
                    MovieFragmentBox movieFragmentBox = (MovieFragmentBox) trackFragmentBox.getParent();
                    TrackRunBox trackRunBox = (TrackRunBox) trackFragmentBox.getBoxes(TrackRunBox.class).get(0);
                    long j = 0;
                    if (trackRunBox.isDataOffsetPresent()) {
                        j = 0 + trackRunBox.getDataOffset();
                    }
                    List<TrackRunBox.Entry> entries = trackRunBox.getEntries();
                    if (trackFragmentBox.getTrackFragmentHeaderBox().hasBaseDataOffset()) {
                        offset = trackFragmentBox.getTrackFragmentHeaderBox().getBaseDataOffset();
                    } else {
                        offset = movieFragmentBox.getOffset();
                    }
                    long j2 = j + offset;
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (trackRunBox.isSampleSizePresent()) {
                            defaultSampleSize2 = entries.get(i5).getSampleSize();
                        } else if (trackFragmentBox.getTrackFragmentHeaderBox().hasDefaultSampleSize()) {
                            defaultSampleSize2 = trackFragmentBox.getTrackFragmentHeaderBox().getDefaultSampleSize();
                        } else {
                            TrackExtendsBox trackExtendsBox = this.trex;
                            if (trackExtendsBox != null) {
                                defaultSampleSize2 = trackExtendsBox.getDefaultSampleSize();
                            } else {
                                throw new RuntimeException("File doesn't contain trex box but track fragments aren't fully self contained. Cannot determine sample size.");
                            }
                        }
                        j2 += defaultSampleSize2;
                    }
                    if (trackRunBox.isSampleSizePresent()) {
                        defaultSampleSize = entries.get(i4).getSampleSize();
                    } else if (trackFragmentBox.getTrackFragmentHeaderBox().hasDefaultSampleSize()) {
                        defaultSampleSize = trackFragmentBox.getTrackFragmentHeaderBox().getDefaultSampleSize();
                    } else {
                        TrackExtendsBox trackExtendsBox2 = this.trex;
                        if (trackExtendsBox2 != null) {
                            defaultSampleSize = trackExtendsBox2.getDefaultSampleSize();
                        } else {
                            throw new RuntimeException("File doesn't contain trex box but track fragments aren't fully self contained. Cannot determine sample size.");
                        }
                    }
                    SampleImpl sampleImpl = new SampleImpl(j2, defaultSampleSize, movieFragmentBox.getParent());
                    this.sampleCache[i] = new SoftReference<>(sampleImpl);
                    return sampleImpl;
                }
                i3 += trafSize;
            }
            return null;
        }
        return (Sample) invokeI.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.size_;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (MovieFragmentBox movieFragmentBox : this.topLevel.getBoxes(MovieFragmentBox.class)) {
                for (TrackFragmentBox trackFragmentBox : movieFragmentBox.getBoxes(TrackFragmentBox.class)) {
                    if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                        i2 = (int) (i2 + ((TrackRunBox) trackFragmentBox.getBoxes(TrackRunBox.class).get(0)).getSampleCount());
                    }
                }
            }
            for (IsoFile isoFile : this.fragments) {
                for (MovieFragmentBox movieFragmentBox2 : isoFile.getBoxes(MovieFragmentBox.class)) {
                    for (TrackFragmentBox trackFragmentBox2 : movieFragmentBox2.getBoxes(TrackFragmentBox.class)) {
                        if (trackFragmentBox2.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                            i2 = (int) (i2 + ((TrackRunBox) trackFragmentBox2.getBoxes(TrackRunBox.class).get(0)).getSampleCount());
                        }
                    }
                }
            }
            this.size_ = i2;
            return i2;
        }
        return invokeV.intValue;
    }
}
