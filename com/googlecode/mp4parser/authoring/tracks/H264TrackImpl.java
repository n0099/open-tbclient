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
import com.googlecode.mp4parser.h264.model.HRDParameters;
import com.googlecode.mp4parser.h264.model.PictureParameterSet;
import com.googlecode.mp4parser.h264.model.SeqParameterSet;
import com.googlecode.mp4parser.h264.model.VUIParameters;
import com.googlecode.mp4parser.h264.read.CAVLCReader;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public class H264TrackImpl extends AbstractTrack {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions;
    public List<CompositionTimeToSample.Entry> ctts;
    public int currentScSize;
    public DataSource dataSource;
    public long[] decodingTimes;
    public boolean determineFrameRate;
    public int frameNrInGop;
    public int frametick;
    public int height;
    public String lang;
    public PictureParameterSet pictureParameterSet;
    public LinkedList<byte[]> pictureParameterSetList;
    public int prevScSize;
    public boolean readSamples;
    public SampleDescriptionBox sampleDescriptionBox;
    public List<Sample> samples;
    public List<SampleDependencyTypeBox.Entry> sdtp;
    public SEIMessage seiMessage;
    public SeqParameterSet seqParameterSet;
    public LinkedList<byte[]> seqParameterSetList;
    public ByteBuffer sixtyFourK;
    public List<Integer> stss;
    public long timescale;
    public TrackMetaData trackMetaData;
    public int width;
    public static final Logger LOG = Logger.getLogger(H264TrackImpl.class.getName());
    public static int BUFFER = 67107840;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class SEIMessage {
        public boolean clock_timestamp_flag;
        public int cnt_dropped_flag;
        public int counting_type;
        public int cpb_removal_delay;
        public int ct_type;
        public int discontinuity_flag;
        public int dpb_removal_delay;
        public int full_timestamp_flag;
        public int hours_value;
        public int minutes_value;
        public int n_frames;
        public int nuit_field_based_flag;
        public int payloadSize;
        public int payloadType;
        public int pic_struct;
        public boolean removal_delay_flag;
        public int seconds_value;
        public SeqParameterSet sps;
        public int time_offset;
        public int time_offset_length;

        public SEIMessage(InputStream inputStream, SeqParameterSet seqParameterSet) throws IOException {
            int i;
            boolean z = false;
            this.payloadType = 0;
            this.payloadSize = 0;
            this.sps = seqParameterSet;
            inputStream.read();
            int available = inputStream.available();
            int i2 = 0;
            while (i2 < available) {
                this.payloadType = z ? 1 : 0;
                this.payloadSize = z ? 1 : 0;
                int read = inputStream.read();
                int i3 = i2 + 1;
                while (read == 255) {
                    this.payloadType += read;
                    read = inputStream.read();
                    i3++;
                    z = false;
                }
                this.payloadType += read;
                int read2 = inputStream.read();
                i2 = i3 + 1;
                while (read2 == 255) {
                    this.payloadSize += read2;
                    read2 = inputStream.read();
                    i2++;
                    z = false;
                }
                int i4 = this.payloadSize + read2;
                this.payloadSize = i4;
                if (available - i2 < i4) {
                    i2 = available;
                } else if (this.payloadType == 1) {
                    VUIParameters vUIParameters = seqParameterSet.vuiParams;
                    if (vUIParameters != null && (vUIParameters.nalHRDParams != null || vUIParameters.vclHRDParams != null || vUIParameters.pic_struct_present_flag)) {
                        byte[] bArr = new byte[this.payloadSize];
                        inputStream.read(bArr);
                        i2 += this.payloadSize;
                        CAVLCReader cAVLCReader = new CAVLCReader(new ByteArrayInputStream(bArr));
                        VUIParameters vUIParameters2 = seqParameterSet.vuiParams;
                        if (vUIParameters2.nalHRDParams == null && vUIParameters2.vclHRDParams == null) {
                            this.removal_delay_flag = z;
                        } else {
                            this.removal_delay_flag = true;
                            this.cpb_removal_delay = cAVLCReader.readU(seqParameterSet.vuiParams.nalHRDParams.cpb_removal_delay_length_minus1 + 1, "SEI: cpb_removal_delay");
                            this.dpb_removal_delay = cAVLCReader.readU(seqParameterSet.vuiParams.nalHRDParams.dpb_output_delay_length_minus1 + 1, "SEI: dpb_removal_delay");
                        }
                        if (seqParameterSet.vuiParams.pic_struct_present_flag) {
                            int readU = cAVLCReader.readU(4, "SEI: pic_struct");
                            this.pic_struct = readU;
                            switch (readU) {
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
                            for (int i5 = 0; i5 < i; i5++) {
                                boolean readBool = cAVLCReader.readBool("pic_timing SEI: clock_timestamp_flag[" + i5 + "]");
                                this.clock_timestamp_flag = readBool;
                                if (readBool) {
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
                                    VUIParameters vUIParameters3 = seqParameterSet.vuiParams;
                                    HRDParameters hRDParameters = vUIParameters3.nalHRDParams;
                                    if (hRDParameters != null) {
                                        this.time_offset_length = hRDParameters.time_offset_length;
                                    } else {
                                        HRDParameters hRDParameters2 = vUIParameters3.vclHRDParams;
                                        if (hRDParameters2 != null) {
                                            this.time_offset_length = hRDParameters2.time_offset_length;
                                        } else {
                                            this.time_offset_length = 24;
                                        }
                                    }
                                    this.time_offset = cAVLCReader.readU(24, "pic_timing SEI: time_offset");
                                }
                            }
                        }
                    } else {
                        for (int i6 = 0; i6 < this.payloadSize; i6++) {
                            inputStream.read();
                            i2++;
                        }
                    }
                } else {
                    for (int i7 = 0; i7 < this.payloadSize; i7++) {
                        inputStream.read();
                        i2++;
                    }
                }
                H264TrackImpl.LOG.fine(toString());
                z = false;
            }
        }

        public String toString() {
            String str = "SEIMessage{payloadType=" + this.payloadType + ", payloadSize=" + this.payloadSize;
            if (this.payloadType == 1) {
                VUIParameters vUIParameters = this.sps.vuiParams;
                if (vUIParameters.nalHRDParams != null || vUIParameters.vclHRDParams != null) {
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

    /* loaded from: classes6.dex */
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

        /* loaded from: classes6.dex */
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
                boolean readBool = cAVLCReader.readBool("SliceHeader: field_pic_flag");
                this.field_pic_flag = readBool;
                if (readBool) {
                    this.bottom_field_flag = cAVLCReader.readBool("SliceHeader: bottom_field_flag");
                }
            }
            if (z) {
                this.idr_pic_id = cAVLCReader.readUE("SliceHeader: idr_pic_id");
                if (seqParameterSet.pic_order_cnt_type == 0) {
                    this.pic_order_cnt_lsb = cAVLCReader.readU(seqParameterSet.log2_max_pic_order_cnt_lsb_minus4 + 4, "SliceHeader: pic_order_cnt_lsb");
                    if (!pictureParameterSet.pic_order_present_flag || this.field_pic_flag) {
                        return;
                    }
                    this.delta_pic_order_cnt_bottom = cAVLCReader.readSE("SliceHeader: delta_pic_order_cnt_bottom");
                }
            }
        }

        public String toString() {
            return "SliceHeader{first_mb_in_slice=" + this.first_mb_in_slice + ", slice_type=" + this.slice_type + ", pic_parameter_set_id=" + this.pic_parameter_set_id + ", colour_plane_id=" + this.colour_plane_id + ", frame_num=" + this.frame_num + ", field_pic_flag=" + this.field_pic_flag + ", bottom_field_flag=" + this.bottom_field_flag + ", idr_pic_id=" + this.idr_pic_id + ", pic_order_cnt_lsb=" + this.pic_order_cnt_lsb + ", delta_pic_order_cnt_bottom=" + this.delta_pic_order_cnt_bottom + '}';
        }
    }

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f31336a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f31337b = 0;

        /* renamed from: c  reason: collision with root package name */
        public DataSource f31338c;

        /* renamed from: d  reason: collision with root package name */
        public ByteBuffer f31339d;

        /* renamed from: e  reason: collision with root package name */
        public long f31340e;

        public a(DataSource dataSource) throws IOException {
            this.f31338c = dataSource;
            c();
        }

        public void a() {
            this.f31337b++;
        }

        public void b() {
            int i = this.f31337b + 3;
            this.f31337b = i;
            this.f31340e = this.f31336a + i;
        }

        public void c() throws IOException {
            DataSource dataSource = this.f31338c;
            this.f31339d = dataSource.map(this.f31336a, Math.min(dataSource.size() - this.f31336a, H264TrackImpl.BUFFER));
        }

        public ByteBuffer d() {
            long j = this.f31340e;
            long j2 = this.f31336a;
            if (j >= j2) {
                this.f31339d.position((int) (j - j2));
                ByteBuffer slice = this.f31339d.slice();
                slice.limit((int) (this.f31337b - (this.f31340e - this.f31336a)));
                return slice;
            }
            throw new RuntimeException("damn sample crosses buffers");
        }

        public boolean e() throws IOException {
            int limit = this.f31339d.limit();
            int i = this.f31337b;
            if (limit - i >= 3) {
                return this.f31339d.get(i) == 0 && this.f31339d.get(this.f31337b + 1) == 0 && (this.f31339d.get(this.f31337b + 2) == 0 || this.f31339d.get(this.f31337b + 2) == 1);
            } else if (this.f31336a + i + 3 > this.f31338c.size()) {
                return this.f31336a + ((long) this.f31337b) == this.f31338c.size();
            } else {
                this.f31336a = this.f31340e;
                this.f31337b = 0;
                c();
                return e();
            }
        }

        public boolean f() throws IOException {
            int limit = this.f31339d.limit();
            int i = this.f31337b;
            if (limit - i >= 3) {
                return this.f31339d.get(i) == 0 && this.f31339d.get(this.f31337b + 1) == 0 && this.f31339d.get(this.f31337b + 2) == 1;
            } else if (this.f31336a + i != this.f31338c.size()) {
                System.err.println(H264TrackImpl.this.samples.size());
                throw new RuntimeException("buffer repositioning require");
            } else {
                throw new EOFException();
            }
        }
    }

    public static /* synthetic */ int[] $SWITCH_TABLE$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions() {
        int[] iArr = $SWITCH_TABLE$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[NALActions.valuesCustom().length];
        try {
            iArr2[NALActions.BUFFER.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[NALActions.END.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[NALActions.IGNORE.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[NALActions.STORE.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions = iArr2;
        return iArr2;
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

    private void configureFramerate() {
        if (this.determineFrameRate) {
            VUIParameters vUIParameters = this.seqParameterSet.vuiParams;
            if (vUIParameters != null) {
                long j = vUIParameters.time_scale >> 1;
                this.timescale = j;
                int i = vUIParameters.num_units_in_tick;
                this.frametick = i;
                if (j == 0 || i == 0) {
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

    private ByteBuffer findNextSample(a aVar) throws IOException {
        while (!aVar.f()) {
            try {
                aVar.a();
            } catch (EOFException unused) {
                return null;
            }
        }
        aVar.b();
        while (!aVar.e()) {
            aVar.a();
        }
        return aVar.d();
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
                PrintStream printStream = System.err;
                printStream.println("Unknown NAL unit type: " + i2);
                return NALActions.IGNORE;
        }
    }

    private void parse(a aVar) throws IOException {
        this.ctts = new LinkedList();
        this.sdtp = new LinkedList();
        this.stss = new LinkedList();
        this.samples = new LinkedList();
        if (readSamples(aVar)) {
            if (readVariables()) {
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
                return;
            }
            throw new IOException();
        }
        throw new IOException();
    }

    private boolean readSamples(a aVar) throws IOException {
        boolean z;
        int i;
        if (this.readSamples) {
            return true;
        }
        this.readSamples = true;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            ByteBuffer findNextSample = findNextSample(aVar);
            if (findNextSample == null) {
                long[] jArr = new long[this.samples.size()];
                this.decodingTimes = jArr;
                Arrays.fill(jArr, this.frametick);
                return true;
            }
            byte b2 = findNextSample.get(0);
            int i3 = b2 & 31;
            int i4 = $SWITCH_TABLE$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions()[handleNALUnit((b2 >> 5) & 3, i3, findNextSample).ordinal()];
            if (i4 == 2) {
                arrayList.add(findNextSample);
            } else if (i4 == 3) {
                int i5 = 22;
                i2++;
                arrayList.add(findNextSample);
                if (i3 == 5) {
                    i5 = 38;
                    z = true;
                } else {
                    z = false;
                }
                if (new SliceHeader(cleanBuffer(new ByteBufferBackedInputStream((ByteBuffer) arrayList.get(arrayList.size() - 1))), this.seqParameterSet, this.pictureParameterSet, z).slice_type == SliceHeader.SliceType.B) {
                    i5 += 4;
                }
                Sample createSample = createSample(arrayList);
                ArrayList arrayList2 = new ArrayList();
                this.samples.add(createSample);
                if (i3 == 5) {
                    this.stss.add(Integer.valueOf(i2));
                }
                SEIMessage sEIMessage = this.seiMessage;
                if (sEIMessage == null || sEIMessage.n_frames == 0) {
                    this.frameNrInGop = 0;
                }
                SEIMessage sEIMessage2 = this.seiMessage;
                if (sEIMessage2 != null && sEIMessage2.clock_timestamp_flag) {
                    i = sEIMessage2.n_frames - this.frameNrInGop;
                } else {
                    SEIMessage sEIMessage3 = this.seiMessage;
                    i = (sEIMessage3 == null || !sEIMessage3.removal_delay_flag) ? 0 : sEIMessage3.dpb_removal_delay / 2;
                }
                this.ctts.add(new CompositionTimeToSample.Entry(1, i * this.frametick));
                this.sdtp.add(new SampleDependencyTypeBox.Entry(i5));
                this.frameNrInGop++;
                arrayList = arrayList2;
            } else if (i4 == 4) {
                return true;
            }
        }
    }

    private boolean readVariables() {
        int i;
        SeqParameterSet seqParameterSet = this.seqParameterSet;
        this.width = (seqParameterSet.pic_width_in_mbs_minus1 + 1) * 16;
        int i2 = seqParameterSet.frame_mbs_only_flag ? 1 : 2;
        SeqParameterSet seqParameterSet2 = this.seqParameterSet;
        this.height = (seqParameterSet2.pic_height_in_map_units_minus1 + 1) * 16 * i2;
        if (seqParameterSet2.frame_cropping_flag) {
            if ((seqParameterSet2.residual_color_transform_flag ? 0 : seqParameterSet2.chroma_format_idc.getId()) != 0) {
                i = this.seqParameterSet.chroma_format_idc.getSubWidth();
                i2 *= this.seqParameterSet.chroma_format_idc.getSubHeight();
            } else {
                i = 1;
            }
            int i3 = this.width;
            SeqParameterSet seqParameterSet3 = this.seqParameterSet;
            this.width = i3 - (i * (seqParameterSet3.frame_crop_left_offset + seqParameterSet3.frame_crop_right_offset));
            this.height -= i2 * (seqParameterSet3.frame_crop_top_offset + seqParameterSet3.frame_crop_bottom_offset);
        }
        return true;
    }

    public static byte[] toArray(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        int remaining = duplicate.remaining();
        byte[] bArr = new byte[remaining];
        duplicate.get(bArr, 0, remaining);
        return bArr;
    }

    public InputStream cleanBuffer(InputStream inputStream) {
        return new CleanInputStream(inputStream);
    }

    public Sample createSample(List<? extends ByteBuffer> list) {
        byte[] bArr = new byte[list.size() * 4];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        for (ByteBuffer byteBuffer : list) {
            wrap.putInt(byteBuffer.remaining());
        }
        ByteBuffer[] byteBufferArr = new ByteBuffer[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            int i2 = i * 2;
            byteBufferArr[i2] = ByteBuffer.wrap(bArr, i * 4, 4);
            byteBufferArr[i2 + 1] = list.get(i);
        }
        return new SampleImpl(byteBufferArr);
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return this.ctts;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "vide";
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return this.sdtp;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return this.decodingTimes;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        long[] jArr = new long[this.stss.size()];
        for (int i = 0; i < this.stss.size(); i++) {
            jArr[i] = this.stss.get(i).intValue();
        }
        return jArr;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }

    /* loaded from: classes6.dex */
    public class ByteBufferBackedInputStream extends InputStream {
        public final ByteBuffer buf;

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
            if (this.buf.hasRemaining()) {
                int min = Math.min(i2, this.buf.remaining());
                this.buf.get(bArr, i, min);
                return min;
            }
            return -1;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.googlecode.mp4parser.authoring.Track
    public AbstractMediaHeaderBox getMediaHeaderBox() {
        return new VideoMediaHeaderBox();
    }

    /* loaded from: classes6.dex */
    public class CleanInputStream extends FilterInputStream {
        public int prev;
        public int prevprev;

        public CleanInputStream(InputStream inputStream) {
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
            if (bArr != null) {
                if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                    throw new IndexOutOfBoundsException();
                }
                if (i2 == 0) {
                    return 0;
                }
                int read = read();
                if (read == -1) {
                    return -1;
                }
                bArr[i] = (byte) read;
                int i3 = 1;
                while (true) {
                    if (i3 < i2) {
                        try {
                            int read2 = read();
                            if (read2 == -1) {
                                break;
                            }
                            bArr[i + i3] = (byte) read2;
                            i3++;
                        } catch (IOException unused) {
                        }
                    }
                    return i3;
                }
                return i3;
            }
            throw null;
        }
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
        parse(new a(dataSource));
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
        parse(new a(dataSource));
    }
}
