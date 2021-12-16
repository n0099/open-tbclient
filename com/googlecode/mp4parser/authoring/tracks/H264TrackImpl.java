package com.googlecode.mp4parser.authoring.tracks;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class H264TrackImpl extends AbstractTrack {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions;
    public static /* synthetic */ Interceptable $ic;
    public static int BUFFER;
    public static final Logger LOG;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* renamed from: com.googlecode.mp4parser.authoring.tracks.H264TrackImpl$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1208195180, "Lcom/googlecode/mp4parser/authoring/tracks/H264TrackImpl$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1208195180, "Lcom/googlecode/mp4parser/authoring/tracks/H264TrackImpl$1;");
                    return;
                }
            }
            int[] iArr = new int[NALActions.values().length];
            $SwitchMap$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions = iArr;
            try {
                iArr[NALActions.IGNORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions[NALActions.BUFFER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions[NALActions.STORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions[NALActions.END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class LookAhead {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteBuffer buffer;
        public long bufferStartPos;
        public DataSource dataSource;
        public int inBufferPos;
        public long start;
        public final /* synthetic */ H264TrackImpl this$0;

        public LookAhead(H264TrackImpl h264TrackImpl, DataSource dataSource) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h264TrackImpl, dataSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = h264TrackImpl;
            this.bufferStartPos = 0L;
            this.inBufferPos = 0;
            this.dataSource = dataSource;
            fillBuffer();
        }

        public void discardByte() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.inBufferPos++;
            }
        }

        public void discardNext3AndMarkStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i2 = this.inBufferPos + 3;
                this.inBufferPos = i2;
                this.start = this.bufferStartPos + i2;
            }
        }

        public void fillBuffer() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                DataSource dataSource = this.dataSource;
                this.buffer = dataSource.map(this.bufferStartPos, Math.min(dataSource.size() - this.bufferStartPos, H264TrackImpl.BUFFER));
            }
        }

        public ByteBuffer getSample() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                long j2 = this.start;
                long j3 = this.bufferStartPos;
                if (j2 >= j3) {
                    this.buffer.position((int) (j2 - j3));
                    ByteBuffer slice = this.buffer.slice();
                    slice.limit((int) (this.inBufferPos - (this.start - this.bufferStartPos)));
                    return slice;
                }
                throw new RuntimeException("damn sample crosses buffers");
            }
            return (ByteBuffer) invokeV.objValue;
        }

        public boolean nextThreeEquals000or001orEof() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                int limit = this.buffer.limit();
                int i2 = this.inBufferPos;
                if (limit - i2 >= 3) {
                    return this.buffer.get(i2) == 0 && this.buffer.get(this.inBufferPos + 1) == 0 && (this.buffer.get(this.inBufferPos + 2) == 0 || this.buffer.get(this.inBufferPos + 2) == 1);
                } else if (this.bufferStartPos + i2 + 3 > this.dataSource.size()) {
                    return this.bufferStartPos + ((long) this.inBufferPos) == this.dataSource.size();
                } else {
                    this.bufferStartPos = this.start;
                    this.inBufferPos = 0;
                    fillBuffer();
                    return nextThreeEquals000or001orEof();
                }
            }
            return invokeV.booleanValue;
        }

        public boolean nextThreeEquals001() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int limit = this.buffer.limit();
                int i2 = this.inBufferPos;
                if (limit - i2 >= 3) {
                    return this.buffer.get(i2) == 0 && this.buffer.get(this.inBufferPos + 1) == 0 && this.buffer.get(this.inBufferPos + 2) == 1;
                } else if (this.bufferStartPos + i2 != this.dataSource.size()) {
                    System.err.println(this.this$0.samples.size());
                    throw new RuntimeException("buffer repositioning require");
                } else {
                    throw new EOFException();
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class NALActions {
        public static /* synthetic */ Interceptable $ic;
        public static final NALActions BUFFER;
        public static final NALActions END;
        public static final /* synthetic */ NALActions[] ENUM$VALUES;
        public static final NALActions IGNORE;
        public static final NALActions STORE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-224905483, "Lcom/googlecode/mp4parser/authoring/tracks/H264TrackImpl$NALActions;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-224905483, "Lcom/googlecode/mp4parser/authoring/tracks/H264TrackImpl$NALActions;");
                    return;
                }
            }
            IGNORE = new NALActions("IGNORE", 0);
            BUFFER = new NALActions("BUFFER", 1);
            STORE = new NALActions("STORE", 2);
            NALActions nALActions = new NALActions("END", 3);
            END = nALActions;
            ENUM$VALUES = new NALActions[]{IGNORE, BUFFER, STORE, nALActions};
        }

        public NALActions(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static NALActions valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NALActions) Enum.valueOf(NALActions.class, str) : (NALActions) invokeL.objValue;
        }

        public static NALActions[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                NALActions[] nALActionsArr = ENUM$VALUES;
                int length = nALActionsArr.length;
                NALActions[] nALActionsArr2 = new NALActions[length];
                System.arraycopy(nALActionsArr, 0, nALActionsArr2, 0, length);
                return nALActionsArr2;
            }
            return (NALActions[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class SEIMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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
        public final /* synthetic */ H264TrackImpl this$0;
        public int time_offset;
        public int time_offset_length;

        public SEIMessage(H264TrackImpl h264TrackImpl, InputStream inputStream, SeqParameterSet seqParameterSet) throws IOException {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {h264TrackImpl, inputStream, seqParameterSet};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = h264TrackImpl;
            boolean z = false;
            this.payloadType = 0;
            this.payloadSize = 0;
            this.sps = seqParameterSet;
            inputStream.read();
            int available = inputStream.available();
            int i5 = 0;
            while (i5 < available) {
                this.payloadType = z ? 1 : 0;
                this.payloadSize = z ? 1 : 0;
                int read = inputStream.read();
                int i6 = i5 + 1;
                while (read == 255) {
                    this.payloadType += read;
                    read = inputStream.read();
                    i6++;
                    z = false;
                }
                this.payloadType += read;
                int read2 = inputStream.read();
                i5 = i6 + 1;
                while (read2 == 255) {
                    this.payloadSize += read2;
                    read2 = inputStream.read();
                    i5++;
                    z = false;
                }
                int i7 = this.payloadSize + read2;
                this.payloadSize = i7;
                if (available - i5 < i7) {
                    i5 = available;
                } else if (this.payloadType == 1) {
                    VUIParameters vUIParameters = seqParameterSet.vuiParams;
                    if (vUIParameters != null && (vUIParameters.nalHRDParams != null || vUIParameters.vclHRDParams != null || vUIParameters.pic_struct_present_flag)) {
                        byte[] bArr = new byte[this.payloadSize];
                        inputStream.read(bArr);
                        i5 += this.payloadSize;
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
                                    i2 = 2;
                                    break;
                                case 5:
                                case 6:
                                case 8:
                                    i2 = 3;
                                    break;
                                default:
                                    i2 = 1;
                                    break;
                            }
                            for (int i8 = 0; i8 < i2; i8++) {
                                boolean readBool = cAVLCReader.readBool("pic_timing SEI: clock_timestamp_flag[" + i8 + PreferencesUtil.RIGHT_MOUNT);
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
                        for (int i9 = 0; i9 < this.payloadSize; i9++) {
                            inputStream.read();
                            i5++;
                        }
                    }
                } else {
                    for (int i10 = 0; i10 < this.payloadSize; i10++) {
                        inputStream.read();
                        i5++;
                    }
                }
                H264TrackImpl.LOG.fine(toString());
                z = false;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
                return String.valueOf(str) + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class SliceHeader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes3.dex */
        public static final class SliceType {
            public static /* synthetic */ Interceptable $ic;
            public static final SliceType B;
            public static final /* synthetic */ SliceType[] ENUM$VALUES;
            public static final SliceType I;
            public static final SliceType P;
            public static final SliceType SI;
            public static final SliceType SP;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1744836010, "Lcom/googlecode/mp4parser/authoring/tracks/H264TrackImpl$SliceHeader$SliceType;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1744836010, "Lcom/googlecode/mp4parser/authoring/tracks/H264TrackImpl$SliceHeader$SliceType;");
                        return;
                    }
                }
                P = new SliceType("P", 0);
                B = new SliceType("B", 1);
                I = new SliceType("I", 2);
                SP = new SliceType("SP", 3);
                SliceType sliceType = new SliceType("SI", 4);
                SI = sliceType;
                ENUM$VALUES = new SliceType[]{P, B, I, SP, sliceType};
            }

            public SliceType(String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static SliceType valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SliceType) Enum.valueOf(SliceType.class, str) : (SliceType) invokeL.objValue;
            }

            public static SliceType[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                    SliceType[] sliceTypeArr = ENUM$VALUES;
                    int length = sliceTypeArr.length;
                    SliceType[] sliceTypeArr2 = new SliceType[length];
                    System.arraycopy(sliceTypeArr, 0, sliceTypeArr2, 0, length);
                    return sliceTypeArr2;
                }
                return (SliceType[]) invokeV.objValue;
            }
        }

        public SliceHeader(InputStream inputStream, SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, boolean z) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream, seqParameterSet, pictureParameterSet, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "SliceHeader{first_mb_in_slice=" + this.first_mb_in_slice + ", slice_type=" + this.slice_type + ", pic_parameter_set_id=" + this.pic_parameter_set_id + ", colour_plane_id=" + this.colour_plane_id + ", frame_num=" + this.frame_num + ", field_pic_flag=" + this.field_pic_flag + ", bottom_field_flag=" + this.bottom_field_flag + ", idr_pic_id=" + this.idr_pic_id + ", pic_order_cnt_lsb=" + this.pic_order_cnt_lsb + ", delta_pic_order_cnt_bottom=" + this.delta_pic_order_cnt_bottom + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    public static /* synthetic */ int[] $SWITCH_TABLE$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions() {
        int[] iArr = $SWITCH_TABLE$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[NALActions.values().length];
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-454608167, "Lcom/googlecode/mp4parser/authoring/tracks/H264TrackImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-454608167, "Lcom/googlecode/mp4parser/authoring/tracks/H264TrackImpl;");
                return;
            }
        }
        LOG = Logger.getLogger(H264TrackImpl.class.getName());
        BUFFER = 67107840;
    }

    public H264TrackImpl(DataSource dataSource, String str, long j2, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataSource, str, Long.valueOf(j2), Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
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
        this.timescale = j2;
        this.frametick = i2;
        this.dataSource = dataSource;
        if (j2 > 0 && i2 > 0) {
            this.determineFrameRate = false;
        }
        parse(new LookAhead(this, this.dataSource));
    }

    private void configureFramerate() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && this.determineFrameRate) {
            VUIParameters vUIParameters = this.seqParameterSet.vuiParams;
            if (vUIParameters != null) {
                long j2 = vUIParameters.time_scale >> 1;
                this.timescale = j2;
                int i2 = vUIParameters.num_units_in_tick;
                this.frametick = i2;
                if (j2 == 0 || i2 == 0) {
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

    private ByteBuffer findNextSample(LookAhead lookAhead) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, lookAhead)) == null) {
            while (!lookAhead.nextThreeEquals001()) {
                try {
                    lookAhead.discardByte();
                } catch (EOFException unused) {
                    return null;
                }
            }
            lookAhead.discardNext3AndMarkStart();
            while (!lookAhead.nextThreeEquals000or001orEof()) {
                lookAhead.discardByte();
            }
            return lookAhead.getSample();
        }
        return (ByteBuffer) invokeL.objValue;
    }

    private NALActions handleNALUnit(int i2, int i3, ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65545, this, i2, i3, byteBuffer)) == null) {
            switch (i3) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return NALActions.STORE;
                case 6:
                    this.seiMessage = new SEIMessage(this, cleanBuffer(new ByteBufferBackedInputStream(this, byteBuffer)), this.seqParameterSet);
                    return NALActions.BUFFER;
                case 7:
                    if (this.seqParameterSet == null) {
                        InputStream cleanBuffer = cleanBuffer(new ByteBufferBackedInputStream(this, byteBuffer));
                        cleanBuffer.read();
                        this.seqParameterSet = SeqParameterSet.read(cleanBuffer);
                        this.seqParameterSetList.add(toArray(byteBuffer));
                        configureFramerate();
                    }
                    return NALActions.IGNORE;
                case 8:
                    if (this.pictureParameterSet == null) {
                        ByteBufferBackedInputStream byteBufferBackedInputStream = new ByteBufferBackedInputStream(this, byteBuffer);
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
                    printStream.println("Unknown NAL unit type: " + i3);
                    return NALActions.IGNORE;
            }
        }
        return (NALActions) invokeIIL.objValue;
    }

    private void parse(LookAhead lookAhead) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, lookAhead) == null) {
            this.ctts = new LinkedList();
            this.sdtp = new LinkedList();
            this.stss = new LinkedList();
            this.samples = new LinkedList();
            if (readSamples(lookAhead)) {
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
    }

    private boolean readSamples(LookAhead lookAhead) throws IOException {
        InterceptResult invokeL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65547, this, lookAhead)) != null) {
            return invokeL.booleanValue;
        }
        if (this.readSamples) {
            return true;
        }
        this.readSamples = true;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            ByteBuffer findNextSample = findNextSample(lookAhead);
            if (findNextSample == null) {
                long[] jArr = new long[this.samples.size()];
                this.decodingTimes = jArr;
                Arrays.fill(jArr, this.frametick);
                return true;
            }
            byte b2 = findNextSample.get(0);
            int i4 = b2 & 31;
            int i5 = $SWITCH_TABLE$com$googlecode$mp4parser$authoring$tracks$H264TrackImpl$NALActions()[handleNALUnit((b2 >> 5) & 3, i4, findNextSample).ordinal()];
            if (i5 == 2) {
                arrayList.add(findNextSample);
            } else if (i5 == 3) {
                int i6 = 22;
                i3++;
                arrayList.add(findNextSample);
                if (i4 == 5) {
                    i6 = 38;
                    z = true;
                } else {
                    z = false;
                }
                if (new SliceHeader(cleanBuffer(new ByteBufferBackedInputStream(this, (ByteBuffer) arrayList.get(arrayList.size() - 1))), this.seqParameterSet, this.pictureParameterSet, z).slice_type == SliceHeader.SliceType.B) {
                    i6 += 4;
                }
                Sample createSample = createSample(arrayList);
                ArrayList arrayList2 = new ArrayList();
                this.samples.add(createSample);
                if (i4 == 5) {
                    this.stss.add(Integer.valueOf(i3));
                }
                SEIMessage sEIMessage = this.seiMessage;
                if (sEIMessage == null || sEIMessage.n_frames == 0) {
                    this.frameNrInGop = 0;
                }
                SEIMessage sEIMessage2 = this.seiMessage;
                if (sEIMessage2 != null && sEIMessage2.clock_timestamp_flag) {
                    i2 = sEIMessage2.n_frames - this.frameNrInGop;
                } else {
                    SEIMessage sEIMessage3 = this.seiMessage;
                    i2 = (sEIMessage3 == null || !sEIMessage3.removal_delay_flag) ? 0 : sEIMessage3.dpb_removal_delay / 2;
                }
                this.ctts.add(new CompositionTimeToSample.Entry(1, i2 * this.frametick));
                this.sdtp.add(new SampleDependencyTypeBox.Entry(i6));
                this.frameNrInGop++;
                arrayList = arrayList2;
            } else if (i5 == 4) {
                return true;
            }
        }
    }

    private boolean readVariables() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            SeqParameterSet seqParameterSet = this.seqParameterSet;
            this.width = (seqParameterSet.pic_width_in_mbs_minus1 + 1) * 16;
            int i3 = seqParameterSet.frame_mbs_only_flag ? 1 : 2;
            SeqParameterSet seqParameterSet2 = this.seqParameterSet;
            this.height = (seqParameterSet2.pic_height_in_map_units_minus1 + 1) * 16 * i3;
            if (seqParameterSet2.frame_cropping_flag) {
                if ((seqParameterSet2.residual_color_transform_flag ? 0 : seqParameterSet2.chroma_format_idc.getId()) != 0) {
                    i2 = this.seqParameterSet.chroma_format_idc.getSubWidth();
                    i3 *= this.seqParameterSet.chroma_format_idc.getSubHeight();
                } else {
                    i2 = 1;
                }
                int i4 = this.width;
                SeqParameterSet seqParameterSet3 = this.seqParameterSet;
                this.width = i4 - (i2 * (seqParameterSet3.frame_crop_left_offset + seqParameterSet3.frame_crop_right_offset));
                this.height -= i3 * (seqParameterSet3.frame_crop_top_offset + seqParameterSet3.frame_crop_bottom_offset);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static byte[] toArray(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, byteBuffer)) == null) {
            ByteBuffer duplicate = byteBuffer.duplicate();
            int remaining = duplicate.remaining();
            byte[] bArr = new byte[remaining];
            duplicate.get(bArr, 0, remaining);
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public InputStream cleanBuffer(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, inputStream)) == null) ? new CleanInputStream(this, inputStream) : (InputStream) invokeL.objValue;
    }

    public Sample createSample(List<? extends ByteBuffer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            byte[] bArr = new byte[list.size() * 4];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            for (ByteBuffer byteBuffer : list) {
                wrap.putInt(byteBuffer.remaining());
            }
            ByteBuffer[] byteBufferArr = new ByteBuffer[list.size() * 2];
            for (int i2 = 0; i2 < list.size(); i2++) {
                int i3 = i2 * 2;
                byteBufferArr[i3] = ByteBuffer.wrap(bArr, i2 * 4, 4);
                byteBufferArr[i3 + 1] = list.get(i2);
            }
            return new SampleImpl(byteBufferArr);
        }
        return (Sample) invokeL.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ctts : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "vide" : (String) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.sdtp : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.sampleDescriptionBox : (SampleDescriptionBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.decodingTimes : (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.samples : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            long[] jArr = new long[this.stss.size()];
            for (int i2 = 0; i2 < this.stss.size(); i2++) {
                jArr[i2] = this.stss.get(i2).intValue();
            }
            return jArr;
        }
        return (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.trackMetaData : (TrackMetaData) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class ByteBufferBackedInputStream extends InputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ByteBuffer buf;
        public final /* synthetic */ H264TrackImpl this$0;

        public ByteBufferBackedInputStream(H264TrackImpl h264TrackImpl, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h264TrackImpl, byteBuffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = h264TrackImpl;
            this.buf = byteBuffer.duplicate();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.buf.hasRemaining()) {
                    return this.buf.get() & 255;
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3)) == null) {
                if (this.buf.hasRemaining()) {
                    int min = Math.min(i3, this.buf.remaining());
                    this.buf.get(bArr, i2, min);
                    return min;
                }
                return -1;
            }
            return invokeLII.intValue;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.googlecode.mp4parser.authoring.Track
    public AbstractMediaHeaderBox getMediaHeaderBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new VideoMediaHeaderBox() : (AbstractMediaHeaderBox) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class CleanInputStream extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int prev;
        public int prevprev;
        public final /* synthetic */ H264TrackImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CleanInputStream(H264TrackImpl h264TrackImpl, InputStream inputStream) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h264TrackImpl, inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = h264TrackImpl;
            this.prevprev = -1;
            this.prev = -1;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public boolean markSupported() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3)) == null) {
                if (bArr != null) {
                    if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
                        throw new IndexOutOfBoundsException();
                    }
                    if (i3 == 0) {
                        return 0;
                    }
                    int read = read();
                    if (read == -1) {
                        return -1;
                    }
                    bArr[i2] = (byte) read;
                    int i4 = 1;
                    while (true) {
                        if (i4 < i3) {
                            try {
                                int read2 = read();
                                if (read2 == -1) {
                                    break;
                                }
                                bArr[i2 + i4] = (byte) read2;
                                i4++;
                            } catch (IOException unused) {
                            }
                        }
                        return i4;
                    }
                    return i4;
                }
                throw null;
            }
            return invokeLII.intValue;
        }
    }

    public H264TrackImpl(DataSource dataSource, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataSource, str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
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
        parse(new LookAhead(this, dataSource));
    }

    public H264TrackImpl(DataSource dataSource) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataSource};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
        parse(new LookAhead(this, dataSource));
    }
}
