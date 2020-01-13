package com.googlecode.mp4parser.authoring.tracks;

import com.baidu.sapi2.SapiWebView;
import com.coremedia.iso.boxes.AbstractMediaHeaderBox;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.h264.AvcConfigurationBox;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.h264.model.PictureParameterSet;
import com.googlecode.mp4parser.h264.model.SeqParameterSet;
import com.googlecode.mp4parser.h264.read.CAVLCReader;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
/* loaded from: classes5.dex */
public class H264TrackImpl extends AbstractTrack {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions;
    List<CompositionTimeToSample.Entry> ctts;
    private int currentScSize;
    private DataSource dataSource;
    private long[] decodingTimes;
    private boolean determineFrameRate;
    int frameNrInGop;
    private int frametick;
    private int height;
    private String lang;
    PictureParameterSet pictureParameterSet;
    LinkedList<byte[]> pictureParameterSetList;
    private int prevScSize;
    boolean readSamples;
    SampleDescriptionBox sampleDescriptionBox;
    private List<Sample> samples;
    List<SampleDependencyTypeBox.Entry> sdtp;
    private SEIMessage seiMessage;
    SeqParameterSet seqParameterSet;
    LinkedList<byte[]> seqParameterSetList;
    ByteBuffer sixtyFourK;
    List<Integer> stss;
    private long timescale;
    TrackMetaData trackMetaData;
    private int width;
    private static final Logger LOG = Logger.getLogger(H264TrackImpl.class.getName());
    static int BUFFER = 67107840;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum NALActions {
        IGNORE,
        BUFFER,
        STORE,
        END;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NALActions[] valuesCustom() {
            NALActions[] valuesCustom = values();
            int length = valuesCustom.length;
            NALActions[] nALActionsArr = new NALActions[length];
            System.arraycopy(valuesCustom, 0, nALActionsArr, 0, length);
            return nALActionsArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions() {
        int[] iArr = $SWITCH_TABLE$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions;
        if (iArr == null) {
            iArr = new int[NALActions.valuesCustom().length];
            try {
                iArr[NALActions.BUFFER.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NALActions.END.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NALActions.IGNORE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[NALActions.STORE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            $SWITCH_TABLE$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions = iArr;
        }
        return iArr;
    }

    public H264TrackImpl(DataSource dataSource, String str, long j, int i) throws IOException {
        this.trackMetaData = new TrackMetaData();
        this.readSamples = false;
        this.seqParameterSet = null;
        this.pictureParameterSet = null;
        this.seqParameterSetList = new LinkedList<>();
        this.pictureParameterSetList = new LinkedList<>();
        this.frameNrInGop = 0;
        this.determineFrameRate = true;
        this.lang = "eng";
        this.sixtyFourK = ByteBuffer.allocate(1);
        this.lang = str;
        this.timescale = j;
        this.frametick = i;
        this.dataSource = dataSource;
        if (j > 0 && i > 0) {
            this.determineFrameRate = false;
        }
        parse(new a(this.dataSource));
    }

    public H264TrackImpl(DataSource dataSource, String str) throws IOException {
        this.trackMetaData = new TrackMetaData();
        this.readSamples = false;
        this.seqParameterSet = null;
        this.pictureParameterSet = null;
        this.seqParameterSetList = new LinkedList<>();
        this.pictureParameterSetList = new LinkedList<>();
        this.frameNrInGop = 0;
        this.determineFrameRate = true;
        this.lang = "eng";
        this.sixtyFourK = ByteBuffer.allocate(1);
        this.lang = str;
        this.dataSource = dataSource;
        parse(new a(this.dataSource));
    }

    public H264TrackImpl(DataSource dataSource) throws IOException {
        this.trackMetaData = new TrackMetaData();
        this.readSamples = false;
        this.seqParameterSet = null;
        this.pictureParameterSet = null;
        this.seqParameterSetList = new LinkedList<>();
        this.pictureParameterSetList = new LinkedList<>();
        this.frameNrInGop = 0;
        this.determineFrameRate = true;
        this.lang = "eng";
        this.sixtyFourK = ByteBuffer.allocate(1);
        this.dataSource = dataSource;
        parse(new a(this.dataSource));
    }

    private void parse(a aVar) throws IOException {
        this.ctts = new LinkedList();
        this.sdtp = new LinkedList();
        this.stss = new LinkedList();
        this.samples = new LinkedList();
        if (!readSamples(aVar)) {
            throw new IOException();
        }
        if (!readVariables()) {
            throw new IOException();
        }
        this.sampleDescriptionBox = new SampleDescriptionBox();
        VisualSampleEntry visualSampleEntry = new VisualSampleEntry(VisualSampleEntry.TYPE3);
        visualSampleEntry.setDataReferenceIndex(1);
        visualSampleEntry.setDepth(24);
        visualSampleEntry.setFrameCount(1);
        visualSampleEntry.setHorizresolution(72.0d);
        visualSampleEntry.setVertresolution(72.0d);
        visualSampleEntry.setWidth(this.width);
        visualSampleEntry.setHeight(this.height);
        visualSampleEntry.setCompressorname("AVC Coding");
        AvcConfigurationBox avcConfigurationBox = new AvcConfigurationBox();
        avcConfigurationBox.setSequenceParameterSets(this.seqParameterSetList);
        avcConfigurationBox.setPictureParameterSets(this.pictureParameterSetList);
        avcConfigurationBox.setAvcLevelIndication(this.seqParameterSet.level_idc);
        avcConfigurationBox.setAvcProfileIndication(this.seqParameterSet.profile_idc);
        avcConfigurationBox.setBitDepthLumaMinus8(this.seqParameterSet.bit_depth_luma_minus8);
        avcConfigurationBox.setBitDepthChromaMinus8(this.seqParameterSet.bit_depth_chroma_minus8);
        avcConfigurationBox.setChromaFormat(this.seqParameterSet.chroma_format_idc.getId());
        avcConfigurationBox.setConfigurationVersion(1);
        avcConfigurationBox.setLengthSizeMinusOne(3);
        avcConfigurationBox.setProfileCompatibility(this.seqParameterSetList.get(0)[1]);
        visualSampleEntry.addBox(avcConfigurationBox);
        this.sampleDescriptionBox.addBox(visualSampleEntry);
        this.trackMetaData.setCreationTime(new Date());
        this.trackMetaData.setModificationTime(new Date());
        this.trackMetaData.setLanguage(this.lang);
        this.trackMetaData.setTimescale(this.timescale);
        this.trackMetaData.setWidth(this.width);
        this.trackMetaData.setHeight(this.height);
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return this.ctts;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        long[] jArr = new long[this.stss.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.stss.size()) {
                jArr[i2] = this.stss.get(i2).intValue();
                i = i2 + 1;
            } else {
                return jArr;
            }
        }
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return this.sdtp;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "vide";
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.googlecode.mp4parser.authoring.Track
    public AbstractMediaHeaderBox getMediaHeaderBox() {
        return new VideoMediaHeaderBox();
    }

    private boolean readVariables() {
        int i;
        this.width = (this.seqParameterSet.pic_width_in_mbs_minus1 + 1) * 16;
        int i2 = this.seqParameterSet.frame_mbs_only_flag ? 1 : 2;
        this.height = (this.seqParameterSet.pic_height_in_map_units_minus1 + 1) * 16 * i2;
        if (this.seqParameterSet.frame_cropping_flag) {
            int i3 = 0;
            if (!this.seqParameterSet.residual_color_transform_flag) {
                i3 = this.seqParameterSet.chroma_format_idc.getId();
            }
            if (i3 != 0) {
                i = this.seqParameterSet.chroma_format_idc.getSubWidth();
                i2 *= this.seqParameterSet.chroma_format_idc.getSubHeight();
            } else {
                i = 1;
            }
            this.width -= i * (this.seqParameterSet.frame_crop_left_offset + this.seqParameterSet.frame_crop_right_offset);
            this.height -= i2 * (this.seqParameterSet.frame_crop_top_offset + this.seqParameterSet.frame_crop_bottom_offset);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a {
        ByteBuffer buffer;
        DataSource dataSource;
        long mNr = 0;
        int mNs = 0;
        long start;

        public void dAs() throws IOException {
            this.buffer = this.dataSource.map(this.mNr, Math.min(this.dataSource.size() - this.mNr, H264TrackImpl.BUFFER));
        }

        a(DataSource dataSource) throws IOException {
            this.dataSource = dataSource;
            dAs();
        }

        boolean dAt() throws IOException {
            if (this.buffer.limit() - this.mNs >= 3) {
                return this.buffer.get(this.mNs) == 0 && this.buffer.get(this.mNs + 1) == 0 && this.buffer.get(this.mNs + 2) == 1;
            } else if (this.mNr + this.mNs != this.dataSource.size()) {
                System.err.println(H264TrackImpl.this.samples.size());
                throw new RuntimeException("buffer repositioning require");
            } else {
                throw new EOFException();
            }
        }

        boolean dAu() throws IOException {
            if (this.buffer.limit() - this.mNs >= 3) {
                return this.buffer.get(this.mNs) == 0 && this.buffer.get(this.mNs + 1) == 0 && (this.buffer.get(this.mNs + 2) == 0 || this.buffer.get(this.mNs + 2) == 1);
            } else if (this.mNr + this.mNs + 3 > this.dataSource.size()) {
                return this.mNr + ((long) this.mNs) == this.dataSource.size();
            } else {
                this.mNr = this.start;
                this.mNs = 0;
                dAs();
                return dAu();
            }
        }

        void dAv() {
            this.mNs++;
        }

        void dAw() {
            this.mNs += 3;
            this.start = this.mNr + this.mNs;
        }

        public ByteBuffer dAx() {
            if (this.start >= this.mNr) {
                this.buffer.position((int) (this.start - this.mNr));
                ByteBuffer slice = this.buffer.slice();
                slice.limit((int) (this.mNs - (this.start - this.mNr)));
                return slice;
            }
            throw new RuntimeException("damn sample crosses buffers");
        }
    }

    private ByteBuffer findNextSample(a aVar) throws IOException {
        while (!aVar.dAt()) {
            try {
                aVar.dAv();
            } catch (EOFException e) {
                return null;
            }
        }
        aVar.dAw();
        while (!aVar.dAu()) {
            aVar.dAv();
        }
        return aVar.dAx();
    }

    protected Sample createSample(List<? extends ByteBuffer> list) {
        byte[] bArr = new byte[list.size() * 4];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        for (ByteBuffer byteBuffer : list) {
            wrap.putInt(byteBuffer.remaining());
        }
        ByteBuffer[] byteBufferArr = new ByteBuffer[list.size() * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                byteBufferArr[i2 * 2] = ByteBuffer.wrap(bArr, i2 * 4, 4);
                byteBufferArr[(i2 * 2) + 1] = list.get(i2);
                i = i2 + 1;
            } else {
                return new SampleImpl(byteBufferArr);
            }
        }
    }

    private boolean readSamples(a aVar) throws IOException {
        int i;
        boolean z;
        int i2;
        if (!this.readSamples) {
            this.readSamples = true;
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (true) {
                ByteBuffer findNextSample = findNextSample(aVar);
                if (findNextSample != null) {
                    byte b = findNextSample.get(0);
                    int i4 = b & 31;
                    switch ($SWITCH_TABLE$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions()[handleNALUnit((b >> 5) & 3, i4, findNextSample).ordinal()]) {
                        case 2:
                            arrayList.add(findNextSample);
                            break;
                        case 3:
                            int i5 = i3 + 1;
                            arrayList.add(findNextSample);
                            if (i4 != 5) {
                                i = 22;
                                z = false;
                            } else {
                                z = true;
                                i = 38;
                            }
                            if (new SliceHeader(cleanBuffer(new ByteBufferBackedInputStream((ByteBuffer) arrayList.get(arrayList.size() - 1))), this.seqParameterSet, this.pictureParameterSet, z).slice_type == SliceHeader.SliceType.B) {
                                i += 4;
                            }
                            Sample createSample = createSample(arrayList);
                            ArrayList arrayList2 = new ArrayList();
                            this.samples.add(createSample);
                            if (i4 == 5) {
                                this.stss.add(Integer.valueOf(i5));
                            }
                            if (this.seiMessage == null || this.seiMessage.n_frames == 0) {
                                this.frameNrInGop = 0;
                            }
                            if (this.seiMessage != null && this.seiMessage.clock_timestamp_flag) {
                                i2 = this.seiMessage.n_frames - this.frameNrInGop;
                            } else {
                                i2 = (this.seiMessage == null || !this.seiMessage.removal_delay_flag) ? 0 : this.seiMessage.dpb_removal_delay / 2;
                            }
                            this.ctts.add(new CompositionTimeToSample.Entry(1, i2 * this.frametick));
                            this.sdtp.add(new SampleDependencyTypeBox.Entry(i));
                            this.frameNrInGop++;
                            arrayList = arrayList2;
                            i3 = i5;
                            break;
                    }
                } else {
                    this.decodingTimes = new long[this.samples.size()];
                    Arrays.fill(this.decodingTimes, this.frametick);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public class CleanInputStream extends FilterInputStream {
        int prev;
        int prevprev;

        CleanInputStream(InputStream inputStream) {
            super(inputStream);
            this.prevprev = -1;
            this.prev = -1;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read == 3 && this.prevprev == 0 && this.prev == 0) {
                this.prevprev = -1;
                this.prev = -1;
                read = super.read();
            }
            this.prevprev = this.prev;
            this.prev = read;
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return 0;
            }
            int read = read();
            if (read != -1) {
                bArr[i] = (byte) read;
                int i3 = 1;
                while (i3 < i2) {
                    try {
                        int read2 = read();
                        if (read2 == -1) {
                            break;
                        }
                        bArr[i + i3] = (byte) read2;
                        i3++;
                    } catch (IOException e) {
                    }
                }
                return i3;
            }
            return -1;
        }
    }

    protected InputStream cleanBuffer(InputStream inputStream) {
        return new CleanInputStream(inputStream);
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return this.decodingTimes;
    }

    static byte[] toArray(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        byte[] bArr = new byte[duplicate.remaining()];
        duplicate.get(bArr, 0, bArr.length);
        return bArr;
    }

    private NALActions handleNALUnit(int i, int i2, ByteBuffer byteBuffer) throws IOException {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return NALActions.STORE;
            case 6:
                this.seiMessage = new SEIMessage(cleanBuffer(new ByteBufferBackedInputStream(byteBuffer)), this.seqParameterSet);
                return NALActions.BUFFER;
            case 7:
                if (this.seqParameterSet == null) {
                    InputStream cleanBuffer = cleanBuffer(new ByteBufferBackedInputStream(byteBuffer));
                    cleanBuffer.read();
                    this.seqParameterSet = SeqParameterSet.read(cleanBuffer);
                    this.seqParameterSetList.add(toArray(byteBuffer));
                    configureFramerate();
                }
                return NALActions.IGNORE;
            case 8:
                if (this.pictureParameterSet == null) {
                    ByteBufferBackedInputStream byteBufferBackedInputStream = new ByteBufferBackedInputStream(byteBuffer);
                    byteBufferBackedInputStream.read();
                    this.pictureParameterSet = PictureParameterSet.read(byteBufferBackedInputStream);
                    this.pictureParameterSetList.add(toArray(byteBuffer));
                }
                return NALActions.IGNORE;
            case 9:
                return NALActions.BUFFER;
            case 10:
            case 11:
                return NALActions.END;
            default:
                System.err.println("Unknown NAL unit type: " + i2);
                return NALActions.IGNORE;
        }
    }

    private void configureFramerate() {
        if (this.determineFrameRate) {
            if (this.seqParameterSet.vuiParams != null) {
                this.timescale = this.seqParameterSet.vuiParams.time_scale >> 1;
                this.frametick = this.seqParameterSet.vuiParams.num_units_in_tick;
                if (this.timescale == 0 || this.frametick == 0) {
                    System.err.println("Warning: vuiParams contain invalid values: time_scale: " + this.timescale + " and frame_tick: " + this.frametick + ". Setting frame rate to 25fps");
                    this.timescale = SapiWebView.DEFAULT_TIMEOUT_MILLIS;
                    this.frametick = 3600;
                    return;
                }
                return;
            }
            System.err.println("Warning: Can't determine frame rate. Guessing 25 fps");
            this.timescale = SapiWebView.DEFAULT_TIMEOUT_MILLIS;
            this.frametick = 3600;
        }
    }

    /* loaded from: classes5.dex */
    public static class SliceHeader {
        public boolean bottom_field_flag;
        public int colour_plane_id;
        public int delta_pic_order_cnt_bottom;
        public boolean field_pic_flag;
        public int first_mb_in_slice;
        public int frame_num;
        public int idr_pic_id;
        public int pic_order_cnt_lsb;
        public int pic_parameter_set_id;
        public SliceType slice_type;

        /* loaded from: classes5.dex */
        public enum SliceType {
            P,
            B,
            I,
            SP,
            SI;

            /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
            /* renamed from: values  reason: to resolve conflict with enum method */
            public static SliceType[] valuesCustom() {
                SliceType[] valuesCustom = values();
                int length = valuesCustom.length;
                SliceType[] sliceTypeArr = new SliceType[length];
                System.arraycopy(valuesCustom, 0, sliceTypeArr, 0, length);
                return sliceTypeArr;
            }
        }

        public SliceHeader(InputStream inputStream, SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, boolean z) throws IOException {
            this.field_pic_flag = false;
            this.bottom_field_flag = false;
            inputStream.read();
            CAVLCReader cAVLCReader = new CAVLCReader(inputStream);
            this.first_mb_in_slice = cAVLCReader.readUE("SliceHeader: first_mb_in_slice");
            switch (cAVLCReader.readUE("SliceHeader: slice_type")) {
                case 0:
                case 5:
                    this.slice_type = SliceType.P;
                    break;
                case 1:
                case 6:
                    this.slice_type = SliceType.B;
                    break;
                case 2:
                case 7:
                    this.slice_type = SliceType.I;
                    break;
                case 3:
                case 8:
                    this.slice_type = SliceType.SP;
                    break;
                case 4:
                case 9:
                    this.slice_type = SliceType.SI;
                    break;
            }
            this.pic_parameter_set_id = cAVLCReader.readUE("SliceHeader: pic_parameter_set_id");
            if (seqParameterSet.residual_color_transform_flag) {
                this.colour_plane_id = cAVLCReader.readU(2, "SliceHeader: colour_plane_id");
            }
            this.frame_num = cAVLCReader.readU(seqParameterSet.log2_max_frame_num_minus4 + 4, "SliceHeader: frame_num");
            if (!seqParameterSet.frame_mbs_only_flag) {
                this.field_pic_flag = cAVLCReader.readBool("SliceHeader: field_pic_flag");
                if (this.field_pic_flag) {
                    this.bottom_field_flag = cAVLCReader.readBool("SliceHeader: bottom_field_flag");
                }
            }
            if (z) {
                this.idr_pic_id = cAVLCReader.readUE("SliceHeader: idr_pic_id");
                if (seqParameterSet.pic_order_cnt_type == 0) {
                    this.pic_order_cnt_lsb = cAVLCReader.readU(seqParameterSet.log2_max_pic_order_cnt_lsb_minus4 + 4, "SliceHeader: pic_order_cnt_lsb");
                    if (pictureParameterSet.pic_order_present_flag && !this.field_pic_flag) {
                        this.delta_pic_order_cnt_bottom = cAVLCReader.readSE("SliceHeader: delta_pic_order_cnt_bottom");
                    }
                }
            }
        }

        public String toString() {
            return "SliceHeader{first_mb_in_slice=" + this.first_mb_in_slice + ", slice_type=" + this.slice_type + ", pic_parameter_set_id=" + this.pic_parameter_set_id + ", colour_plane_id=" + this.colour_plane_id + ", frame_num=" + this.frame_num + ", field_pic_flag=" + this.field_pic_flag + ", bottom_field_flag=" + this.bottom_field_flag + ", idr_pic_id=" + this.idr_pic_id + ", pic_order_cnt_lsb=" + this.pic_order_cnt_lsb + ", delta_pic_order_cnt_bottom=" + this.delta_pic_order_cnt_bottom + '}';
        }
    }

    /* loaded from: classes5.dex */
    public class ByteBufferBackedInputStream extends InputStream {
        private final ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer.duplicate();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.buf.hasRemaining()) {
                return this.buf.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!this.buf.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, this.buf.remaining());
            this.buf.get(bArr, i, min);
            return min;
        }
    }

    /* loaded from: classes5.dex */
    public class SEIMessage {
        boolean clock_timestamp_flag;
        int cnt_dropped_flag;
        int counting_type;
        int cpb_removal_delay;
        int ct_type;
        int discontinuity_flag;
        int dpb_removal_delay;
        int full_timestamp_flag;
        int hours_value;
        int minutes_value;
        int n_frames;
        int nuit_field_based_flag;
        int payloadSize;
        int payloadType;
        int pic_struct;
        boolean removal_delay_flag;
        int seconds_value;
        SeqParameterSet sps;
        int time_offset;
        int time_offset_length;

        public SEIMessage(InputStream inputStream, SeqParameterSet seqParameterSet) throws IOException {
            int i;
            this.payloadType = 0;
            this.payloadSize = 0;
            this.sps = seqParameterSet;
            inputStream.read();
            int available = inputStream.available();
            int i2 = 0;
            while (i2 < available) {
                this.payloadType = 0;
                this.payloadSize = 0;
                int read = inputStream.read();
                while (true) {
                    i2++;
                    if (read == 255) {
                        this.payloadType = read + this.payloadType;
                        read = inputStream.read();
                    } else {
                        this.payloadType = read + this.payloadType;
                        int read2 = inputStream.read();
                        while (true) {
                            i2++;
                            if (read2 == 255) {
                                this.payloadSize = read2 + this.payloadSize;
                                read2 = inputStream.read();
                            } else {
                                this.payloadSize = read2 + this.payloadSize;
                                if (available - i2 < this.payloadSize) {
                                    i2 = available;
                                } else if (this.payloadType == 1) {
                                    if (seqParameterSet.vuiParams != null && (seqParameterSet.vuiParams.nalHRDParams != null || seqParameterSet.vuiParams.vclHRDParams != null || seqParameterSet.vuiParams.pic_struct_present_flag)) {
                                        byte[] bArr = new byte[this.payloadSize];
                                        inputStream.read(bArr);
                                        i2 += this.payloadSize;
                                        CAVLCReader cAVLCReader = new CAVLCReader(new ByteArrayInputStream(bArr));
                                        if (seqParameterSet.vuiParams.nalHRDParams != null || seqParameterSet.vuiParams.vclHRDParams != null) {
                                            this.removal_delay_flag = true;
                                            this.cpb_removal_delay = cAVLCReader.readU(seqParameterSet.vuiParams.nalHRDParams.cpb_removal_delay_length_minus1 + 1, "SEI: cpb_removal_delay");
                                            this.dpb_removal_delay = cAVLCReader.readU(seqParameterSet.vuiParams.nalHRDParams.dpb_output_delay_length_minus1 + 1, "SEI: dpb_removal_delay");
                                        } else {
                                            this.removal_delay_flag = false;
                                        }
                                        if (seqParameterSet.vuiParams.pic_struct_present_flag) {
                                            this.pic_struct = cAVLCReader.readU(4, "SEI: pic_struct");
                                            switch (this.pic_struct) {
                                                case 3:
                                                case 4:
                                                case 7:
                                                    i = 2;
                                                    break;
                                                case 5:
                                                case 6:
                                                case 8:
                                                    i = 3;
                                                    break;
                                                default:
                                                    i = 1;
                                                    break;
                                            }
                                            for (int i3 = 0; i3 < i; i3++) {
                                                this.clock_timestamp_flag = cAVLCReader.readBool("pic_timing SEI: clock_timestamp_flag[" + i3 + "]");
                                                if (this.clock_timestamp_flag) {
                                                    this.ct_type = cAVLCReader.readU(2, "pic_timing SEI: ct_type");
                                                    this.nuit_field_based_flag = cAVLCReader.readU(1, "pic_timing SEI: nuit_field_based_flag");
                                                    this.counting_type = cAVLCReader.readU(5, "pic_timing SEI: counting_type");
                                                    this.full_timestamp_flag = cAVLCReader.readU(1, "pic_timing SEI: full_timestamp_flag");
                                                    this.discontinuity_flag = cAVLCReader.readU(1, "pic_timing SEI: discontinuity_flag");
                                                    this.cnt_dropped_flag = cAVLCReader.readU(1, "pic_timing SEI: cnt_dropped_flag");
                                                    this.n_frames = cAVLCReader.readU(8, "pic_timing SEI: n_frames");
                                                    if (this.full_timestamp_flag == 1) {
                                                        this.seconds_value = cAVLCReader.readU(6, "pic_timing SEI: seconds_value");
                                                        this.minutes_value = cAVLCReader.readU(6, "pic_timing SEI: minutes_value");
                                                        this.hours_value = cAVLCReader.readU(5, "pic_timing SEI: hours_value");
                                                    } else if (cAVLCReader.readBool("pic_timing SEI: seconds_flag")) {
                                                        this.seconds_value = cAVLCReader.readU(6, "pic_timing SEI: seconds_value");
                                                        if (cAVLCReader.readBool("pic_timing SEI: minutes_flag")) {
                                                            this.minutes_value = cAVLCReader.readU(6, "pic_timing SEI: minutes_value");
                                                            if (cAVLCReader.readBool("pic_timing SEI: hours_flag")) {
                                                                this.hours_value = cAVLCReader.readU(5, "pic_timing SEI: hours_value");
                                                            }
                                                        }
                                                    }
                                                    if (seqParameterSet.vuiParams.nalHRDParams != null) {
                                                        this.time_offset_length = seqParameterSet.vuiParams.nalHRDParams.time_offset_length;
                                                    } else if (seqParameterSet.vuiParams.vclHRDParams != null) {
                                                        this.time_offset_length = seqParameterSet.vuiParams.vclHRDParams.time_offset_length;
                                                    } else {
                                                        this.time_offset_length = 24;
                                                    }
                                                    this.time_offset = cAVLCReader.readU(24, "pic_timing SEI: time_offset");
                                                }
                                            }
                                        }
                                    } else {
                                        for (int i4 = 0; i4 < this.payloadSize; i4++) {
                                            inputStream.read();
                                            i2++;
                                        }
                                    }
                                } else {
                                    for (int i5 = 0; i5 < this.payloadSize; i5++) {
                                        inputStream.read();
                                        i2++;
                                    }
                                }
                                H264TrackImpl.LOG.fine(toString());
                            }
                        }
                    }
                }
            }
        }

        public String toString() {
            String str = "SEIMessage{payloadType=" + this.payloadType + ", payloadSize=" + this.payloadSize;
            if (this.payloadType == 1) {
                if (this.sps.vuiParams.nalHRDParams != null || this.sps.vuiParams.vclHRDParams != null) {
                    str = String.valueOf(str) + ", cpb_removal_delay=" + this.cpb_removal_delay + ", dpb_removal_delay=" + this.dpb_removal_delay;
                }
                if (this.sps.vuiParams.pic_struct_present_flag) {
                    str = String.valueOf(str) + ", pic_struct=" + this.pic_struct;
                    if (this.clock_timestamp_flag) {
                        str = String.valueOf(str) + ", ct_type=" + this.ct_type + ", nuit_field_based_flag=" + this.nuit_field_based_flag + ", counting_type=" + this.counting_type + ", full_timestamp_flag=" + this.full_timestamp_flag + ", discontinuity_flag=" + this.discontinuity_flag + ", cnt_dropped_flag=" + this.cnt_dropped_flag + ", n_frames=" + this.n_frames + ", seconds_value=" + this.seconds_value + ", minutes_value=" + this.minutes_value + ", hours_value=" + this.hours_value + ", time_offset_length=" + this.time_offset_length + ", time_offset=" + this.time_offset;
                    }
                }
            }
            return String.valueOf(str) + '}';
        }
    }
}
