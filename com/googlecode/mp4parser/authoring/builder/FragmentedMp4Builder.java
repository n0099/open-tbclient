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
    public static /* synthetic */ Interceptable $ic;
    public static final Logger LOG;
    public transient /* synthetic */ FieldHolder $fh;
    public FragmentIntersectionFinder intersectionFinder;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1860598360, "Lcom/googlecode/mp4parser/authoring/builder/FragmentedMp4Builder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1860598360, "Lcom/googlecode/mp4parser/authoring/builder/FragmentedMp4Builder;");
                return;
            }
        }
        LOG = Logger.getLogger(FragmentedMp4Builder.class.getName());
    }

    public FragmentedMp4Builder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private long getTrackDuration(Movie movie, Track track) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, movie, track)) == null) ? (track.getDuration() * movie.getTimescale()) / track.getTrackMetaData().getTimescale() : invokeLL.longValue;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.Mp4Builder
    public Container build(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, movie)) == null) {
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
        return (Container) invokeL.objValue;
    }

    public DataInformationBox createDinf(Movie movie, Track track) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, movie, track)) == null) {
            DataInformationBox dataInformationBox = new DataInformationBox();
            DataReferenceBox dataReferenceBox = new DataReferenceBox();
            dataInformationBox.addBox(dataReferenceBox);
            DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
            dataEntryUrlBox.setFlags(1);
            dataReferenceBox.addBox(dataEntryUrlBox);
            return dataInformationBox;
        }
        return (DataInformationBox) invokeLL.objValue;
    }

    public Box createEdts(Track track, Movie movie) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, track, movie)) == null) {
            EditListBox editList = track.getTrackMetaData().getEditList();
            if (editList != null) {
                EditBox editBox = new EditBox();
                editBox.addBox(editList);
                return editBox;
            }
            return null;
        }
        return (Box) invokeLL.objValue;
    }

    public int createFragment(List<Box> list, Track track, long[] jArr, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{list, track, jArr, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (i < jArr.length) {
                long j = jArr[i];
                int i3 = i + 1;
                long size = i3 < jArr.length ? jArr[i3] : track.getSamples().size() + 1;
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
        return invokeCommon.intValue;
    }

    public Box createFtyp(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, movie)) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add("isom");
            linkedList.add("iso2");
            linkedList.add("avc1");
            return new FileTypeBox("isom", 0L, linkedList);
        }
        return (Box) invokeL.objValue;
    }

    public Box createMdat(long j, long j2, Track track, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), track, Integer.valueOf(i)})) == null) ? new Box(this, j, j2, track, i) { // from class: com.googlecode.mp4parser.authoring.builder.FragmentedMp4Builder.1Mdat
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Container parent;
            public long size_;
            public final /* synthetic */ FragmentedMp4Builder this$0;
            public final /* synthetic */ long val$endSample;
            public final /* synthetic */ int val$i;
            public final /* synthetic */ long val$startSample;
            public final /* synthetic */ Track val$track;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Long.valueOf(j), Long.valueOf(j2), track, Integer.valueOf(i)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$startSample = j;
                this.val$endSample = j2;
                this.val$track = track;
                this.val$i = i;
                this.size_ = -1L;
            }

            @Override // com.coremedia.iso.boxes.Box
            public void getBox(WritableByteChannel writableByteChannel) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, writableByteChannel) == null) {
                    ByteBuffer allocate = ByteBuffer.allocate(8);
                    IsoTypeWriter.writeUInt32(allocate, CastUtils.l2i(getSize()));
                    allocate.put(IsoFile.fourCCtoBytes(getType()));
                    allocate.rewind();
                    writableByteChannel.write(allocate);
                    for (Sample sample : this.this$0.getSamples(this.val$startSample, this.val$endSample, this.val$track, this.val$i)) {
                        sample.writeTo(writableByteChannel);
                    }
                }
            }

            @Override // com.coremedia.iso.boxes.Box
            public long getOffset() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    throw new RuntimeException("Doesn't have any meaning for programmatically created boxes");
                }
                return invokeV.longValue;
            }

            @Override // com.coremedia.iso.boxes.Box
            public Container getParent() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.parent : (Container) invokeV.objValue;
            }

            @Override // com.coremedia.iso.boxes.Box
            public long getSize() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    long j3 = this.size_;
                    if (j3 != -1) {
                        return j3;
                    }
                    long j4 = 8;
                    for (Sample sample : this.this$0.getSamples(this.val$startSample, this.val$endSample, this.val$track, this.val$i)) {
                        j4 += sample.getSize();
                    }
                    this.size_ = j4;
                    return j4;
                }
                return invokeV.longValue;
            }

            @Override // com.coremedia.iso.boxes.Box
            public String getType() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) ? "mdat" : (String) invokeV.objValue;
            }

            @Override // com.coremedia.iso.boxes.Box
            public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j3, BoxParser boxParser) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j3), boxParser}) == null) {
                }
            }

            @Override // com.coremedia.iso.boxes.Box
            public void setParent(Container container) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048582, this, container) == null) {
                    this.parent = container;
                }
            }
        } : (Box) invokeCommon.objValue;
    }

    public Box createMdhd(Movie movie, Track track) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, movie, track)) == null) {
            MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
            mediaHeaderBox.setCreationTime(track.getTrackMetaData().getCreationTime());
            mediaHeaderBox.setModificationTime(getDate());
            mediaHeaderBox.setDuration(0L);
            mediaHeaderBox.setTimescale(track.getTrackMetaData().getTimescale());
            mediaHeaderBox.setLanguage(track.getTrackMetaData().getLanguage());
            return mediaHeaderBox;
        }
        return (Box) invokeLL.objValue;
    }

    public Box createMdia(Track track, Movie movie) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, track, movie)) == null) {
            MediaBox mediaBox = new MediaBox();
            mediaBox.addBox(createMdhd(movie, track));
            mediaBox.addBox(createMdiaHdlr(track, movie));
            mediaBox.addBox(createMinf(track, movie));
            return mediaBox;
        }
        return (Box) invokeLL.objValue;
    }

    public Box createMdiaHdlr(Track track, Movie movie) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, track, movie)) == null) {
            HandlerBox handlerBox = new HandlerBox();
            handlerBox.setHandlerType(track.getHandler());
            return handlerBox;
        }
        return (Box) invokeLL.objValue;
    }

    public Box createMfhd(long j, long j2, Track track, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), track, Integer.valueOf(i)})) == null) {
            MovieFragmentHeaderBox movieFragmentHeaderBox = new MovieFragmentHeaderBox();
            movieFragmentHeaderBox.setSequenceNumber(i);
            return movieFragmentHeaderBox;
        }
        return (Box) invokeCommon.objValue;
    }

    public Box createMfra(Movie movie, Container container) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, movie, container)) == null) {
            MovieFragmentRandomAccessBox movieFragmentRandomAccessBox = new MovieFragmentRandomAccessBox();
            for (Track track : movie.getTracks()) {
                movieFragmentRandomAccessBox.addBox(createTfra(track, container));
            }
            MovieFragmentRandomAccessOffsetBox movieFragmentRandomAccessOffsetBox = new MovieFragmentRandomAccessOffsetBox();
            movieFragmentRandomAccessBox.addBox(movieFragmentRandomAccessOffsetBox);
            movieFragmentRandomAccessOffsetBox.setMfraSize(movieFragmentRandomAccessBox.getSize());
            return movieFragmentRandomAccessBox;
        }
        return (Box) invokeLL.objValue;
    }

    public Box createMinf(Track track, Movie movie) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, track, movie)) == null) {
            MediaInformationBox mediaInformationBox = new MediaInformationBox();
            mediaInformationBox.addBox(track.getMediaHeaderBox());
            mediaInformationBox.addBox(createDinf(movie, track));
            mediaInformationBox.addBox(createStbl(movie, track));
            return mediaInformationBox;
        }
        return (Box) invokeLL.objValue;
    }

    public Box createMoof(long j, long j2, Track track, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), track, Integer.valueOf(i)})) == null) {
            MovieFragmentBox movieFragmentBox = new MovieFragmentBox();
            movieFragmentBox.addBox(createMfhd(j, j2, track, i));
            movieFragmentBox.addBox(createTraf(j, j2, track, i));
            TrackRunBox trackRunBox = movieFragmentBox.getTrackRunBoxes().get(0);
            trackRunBox.setDataOffset(1);
            trackRunBox.setDataOffset((int) (movieFragmentBox.getSize() + 8));
            return movieFragmentBox;
        }
        return (Box) invokeCommon.objValue;
    }

    public List<Box> createMoofMdat(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, movie)) == null) {
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
        return (List) invokeL.objValue;
    }

    public Box createMoov(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, movie)) == null) {
            MovieBox movieBox = new MovieBox();
            movieBox.addBox(createMvhd(movie));
            for (Track track : movie.getTracks()) {
                movieBox.addBox(createTrak(track, movie));
            }
            movieBox.addBox(createMvex(movie));
            return movieBox;
        }
        return (Box) invokeL.objValue;
    }

    public Box createMvex(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, movie)) == null) {
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
        return (Box) invokeL.objValue;
    }

    public Box createMvhd(Movie movie) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, movie)) == null) {
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
        return (Box) invokeL.objValue;
    }

    public Box createPdin(Movie movie) {
        InterceptResult invokeL;
        long j;
        Iterator<Sample> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, movie)) == null) {
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
                    for (int i = 0; i < 10000; i++) {
                        j3 += samples.get(i).getSize();
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
        return (Box) invokeL.objValue;
    }

    public Box createStbl(Movie movie, Track track) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, movie, track)) == null) {
            SampleTableBox sampleTableBox = new SampleTableBox();
            createStsd(track, sampleTableBox);
            sampleTableBox.addBox(new TimeToSampleBox());
            sampleTableBox.addBox(new SampleToChunkBox());
            sampleTableBox.addBox(new SampleSizeBox());
            sampleTableBox.addBox(new StaticChunkOffsetBox());
            return sampleTableBox;
        }
        return (Box) invokeLL.objValue;
    }

    public void createStsd(Track track, SampleTableBox sampleTableBox) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, track, sampleTableBox) == null) {
            sampleTableBox.addBox(track.getSampleDescriptionBox());
        }
    }

    public TrackFragmentBaseMediaDecodeTimeBox createTfdt(long j, Track track) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, track)) == null) {
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
        return (TrackFragmentBaseMediaDecodeTimeBox) invokeJL.objValue;
    }

    public Box createTfhd(long j, long j2, Track track, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), track, Integer.valueOf(i)})) == null) {
            TrackFragmentHeaderBox trackFragmentHeaderBox = new TrackFragmentHeaderBox();
            trackFragmentHeaderBox.setDefaultSampleFlags(new SampleFlags());
            trackFragmentHeaderBox.setBaseDataOffset(-1L);
            trackFragmentHeaderBox.setTrackId(track.getTrackMetaData().getTrackId());
            return trackFragmentHeaderBox;
        }
        return (Box) invokeCommon.objValue;
    }

    public Box createTfra(Track track, Container container) {
        InterceptResult invokeLL;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, track, container)) == null) {
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
                                    if (defaultSampleFlags == null || defaultSampleFlags.getSampleDependsOn() == 2) {
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
                                    } else {
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
        return (Box) invokeLL.objValue;
    }

    public Box createTkhd(Movie movie, Track track) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, movie, track)) == null) {
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
        return (Box) invokeLL.objValue;
    }

    public Box createTraf(long j, long j2, Track track, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), track, Integer.valueOf(i)})) == null) {
            TrackFragmentBox trackFragmentBox = new TrackFragmentBox();
            trackFragmentBox.addBox(createTfhd(j, j2, track, i));
            trackFragmentBox.addBox(createTfdt(j, track));
            trackFragmentBox.addBox(createTrun(j, j2, track, i));
            return trackFragmentBox;
        }
        return (Box) invokeCommon.objValue;
    }

    public Box createTrak(Track track, Movie movie) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, track, movie)) == null) {
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
        return (Box) invokeLL.objValue;
    }

    public Box createTrex(Movie movie, Track track) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, movie, track)) == null) {
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
        return (Box) invokeLL.objValue;
    }

    public TrackRunBox createTrun(long j, long j2, Track track, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), track, Integer.valueOf(i)})) == null) {
            TrackRunBox trackRunBox = new TrackRunBox();
            long[] sampleSizes = getSampleSizes(j, j2, track, i);
            trackRunBox.setSampleDurationPresent(true);
            trackRunBox.setSampleSizePresent(true);
            ArrayList arrayList = new ArrayList(CastUtils.l2i(j2 - j));
            List<CompositionTimeToSample.Entry> compositionTimeEntries = track.getCompositionTimeEntries();
            CompositionTimeToSample.Entry[] entryArr = (compositionTimeEntries == null || compositionTimeEntries.size() <= 0) ? null : (CompositionTimeToSample.Entry[]) compositionTimeEntries.toArray(new CompositionTimeToSample.Entry[compositionTimeEntries.size()]);
            long count = entryArr != null ? entryArr[0].getCount() : -1;
            trackRunBox.setSampleCompositionTimeOffsetPresent(count > 0);
            int i2 = 0;
            for (long j3 = 1; j3 < j; j3++) {
                if (entryArr != null) {
                    count--;
                    if (count == 0 && entryArr.length - i2 > 1) {
                        i2++;
                        count = entryArr[i2].getCount();
                    }
                }
            }
            boolean z = ((track.getSampleDependencies() == null || track.getSampleDependencies().isEmpty()) && (track.getSyncSamples() == null || track.getSyncSamples().length == 0)) ? false : true;
            trackRunBox.setSampleFlagsPresent(z);
            for (int i3 = 0; i3 < sampleSizes.length; i3++) {
                TrackRunBox.Entry entry = new TrackRunBox.Entry();
                entry.setSampleSize(sampleSizes[i3]);
                if (z) {
                    SampleFlags sampleFlags = new SampleFlags();
                    if (track.getSampleDependencies() != null && !track.getSampleDependencies().isEmpty()) {
                        SampleDependencyTypeBox.Entry entry2 = track.getSampleDependencies().get(i3);
                        sampleFlags.setSampleDependsOn(entry2.getSampleDependsOn());
                        sampleFlags.setSampleIsDependedOn(entry2.getSampleIsDependentOn());
                        sampleFlags.setSampleHasRedundancy(entry2.getSampleHasRedundancy());
                    }
                    if (track.getSyncSamples() != null && track.getSyncSamples().length > 0) {
                        if (Arrays.binarySearch(track.getSyncSamples(), j + i3) >= 0) {
                            sampleFlags.setSampleIsDifferenceSample(false);
                            sampleFlags.setSampleDependsOn(2);
                        } else {
                            sampleFlags.setSampleIsDifferenceSample(true);
                            sampleFlags.setSampleDependsOn(1);
                        }
                    }
                    entry.setSampleFlags(sampleFlags);
                }
                entry.setSampleDuration(track.getSampleDurations()[CastUtils.l2i((j + i3) - 1)]);
                if (entryArr != null) {
                    entry.setSampleCompositionTimeOffset(entryArr[i2].getOffset());
                    count--;
                    if (count == 0 && entryArr.length - i2 > 1) {
                        i2++;
                        count = entryArr[i2].getCount();
                    }
                }
                arrayList.add(entry);
            }
            trackRunBox.setEntries(arrayList);
            return trackRunBox;
        }
        return (TrackRunBox) invokeCommon.objValue;
    }

    public List<String> getAllowedHandlers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? Arrays.asList("soun", "vide") : (List) invokeV.objValue;
    }

    public Date getDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? new Date() : (Date) invokeV.objValue;
    }

    public FragmentIntersectionFinder getFragmentIntersectionFinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.intersectionFinder : (FragmentIntersectionFinder) invokeV.objValue;
    }

    public long[] getSampleSizes(long j, long j2, Track track, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), track, Integer.valueOf(i)})) == null) {
            List<Sample> samples = getSamples(j, j2, track, i);
            int size = samples.size();
            long[] jArr = new long[size];
            for (int i2 = 0; i2 < size; i2++) {
                jArr[i2] = samples.get(i2).getSize();
            }
            return jArr;
        }
        return (long[]) invokeCommon.objValue;
    }

    public List<Sample> getSamples(long j, long j2, Track track, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), track, Integer.valueOf(i)})) == null) ? track.getSamples().subList(CastUtils.l2i(j) - 1, CastUtils.l2i(j2) - 1) : (List) invokeCommon.objValue;
    }

    public void setIntersectionFinder(FragmentIntersectionFinder fragmentIntersectionFinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, fragmentIntersectionFinder) == null) {
            this.intersectionFinder = fragmentIntersectionFinder;
        }
    }

    public List<Track> sortTracksInSequence(List<Track> list, int i, Map<Track, long[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048610, this, list, i, map)) == null) {
            LinkedList linkedList = new LinkedList(list);
            Collections.sort(linkedList, new Comparator<Track>(this, map, i) { // from class: com.googlecode.mp4parser.authoring.builder.FragmentedMp4Builder.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FragmentedMp4Builder this$0;
                public final /* synthetic */ int val$cycle;
                public final /* synthetic */ Map val$intersectionMap;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, map, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$intersectionMap = map;
                    this.val$cycle = i;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(Track track, Track track2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, track, track2)) == null) {
                        long j = ((long[]) this.val$intersectionMap.get(track))[this.val$cycle];
                        long j2 = ((long[]) this.val$intersectionMap.get(track2))[this.val$cycle];
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
                    return invokeLL.intValue;
                }
            });
            return linkedList;
        }
        return (List) invokeLIL.objValue;
    }
}
