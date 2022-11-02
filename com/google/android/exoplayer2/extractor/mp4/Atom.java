package com.google.android.exoplayer2.extractor.mp4;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.ChunkOffset64BitBox;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.OriginalFormatBox;
import com.coremedia.iso.boxes.ProtectionSchemeInformationBox;
import com.coremedia.iso.boxes.SampleAuxiliaryInformationOffsetsBox;
import com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.SchemeInformationBox;
import com.coremedia.iso.boxes.SchemeTypeBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.SyncSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.UserDataBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.apple.AppleItemListBox;
import com.coremedia.iso.boxes.apple.AppleWaveBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.h264.AvcConfigurationBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.SubtitleSampleEntry;
import com.coremedia.iso.boxes.sampleentry.TextSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.DTSSpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom;
import com.googlecode.mp4parser.boxes.cenc.ProtectionSystemSpecificHeaderBox;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox;
import com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox;
import com.googlecode.mp4parser.boxes.ultraviolet.SampleEncryptionBox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class Atom {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFINES_LARGE_SIZE = 1;
    public static final int EXTENDS_TO_END_SIZE = 0;
    public static final int FULL_HEADER_SIZE = 12;
    public static final int HEADER_SIZE = 8;
    public static final int LONG_HEADER_SIZE = 16;
    public static final int TYPE_TTML;
    public static final int TYPE__mp3;
    public static final int TYPE_ac_3;
    public static final int TYPE_alac;
    public static final int TYPE_avc1;
    public static final int TYPE_avc3;
    public static final int TYPE_avcC;
    public static final int TYPE_c608;
    public static final int TYPE_camm;
    public static final int TYPE_co64;
    public static final int TYPE_ctts;
    public static final int TYPE_d263;
    public static final int TYPE_dac3;
    public static final int TYPE_data;
    public static final int TYPE_ddts;
    public static final int TYPE_dec3;
    public static final int TYPE_dtsc;
    public static final int TYPE_dtse;
    public static final int TYPE_dtsh;
    public static final int TYPE_dtsl;
    public static final int TYPE_ec_3;
    public static final int TYPE_edts;
    public static final int TYPE_elst;
    public static final int TYPE_emsg;
    public static final int TYPE_enca;
    public static final int TYPE_encv;
    public static final int TYPE_esds;
    public static final int TYPE_frma;
    public static final int TYPE_ftyp;
    public static final int TYPE_hdlr;
    public static final int TYPE_hev1;
    public static final int TYPE_hvc1;
    public static final int TYPE_hvcC;
    public static final int TYPE_ilst;
    public static final int TYPE_lpcm;
    public static final int TYPE_mdat;
    public static final int TYPE_mdhd;
    public static final int TYPE_mdia;
    public static final int TYPE_mean;
    public static final int TYPE_mehd;
    public static final int TYPE_meta;
    public static final int TYPE_minf;
    public static final int TYPE_moof;
    public static final int TYPE_moov;
    public static final int TYPE_mp4a;
    public static final int TYPE_mp4v;
    public static final int TYPE_mvex;
    public static final int TYPE_mvhd;
    public static final int TYPE_name;
    public static final int TYPE_pasp;
    public static final int TYPE_proj;
    public static final int TYPE_pssh;
    public static final int TYPE_s263;
    public static final int TYPE_saio;
    public static final int TYPE_saiz;
    public static final int TYPE_samr;
    public static final int TYPE_sawb;
    public static final int TYPE_sbgp;
    public static final int TYPE_schi;
    public static final int TYPE_schm;
    public static final int TYPE_senc;
    public static final int TYPE_sgpd;
    public static final int TYPE_sidx;
    public static final int TYPE_sinf;
    public static final int TYPE_sowt;
    public static final int TYPE_st3d;
    public static final int TYPE_stbl;
    public static final int TYPE_stco;
    public static final int TYPE_stpp;
    public static final int TYPE_stsc;
    public static final int TYPE_stsd;
    public static final int TYPE_stss;
    public static final int TYPE_stsz;
    public static final int TYPE_stts;
    public static final int TYPE_stz2;
    public static final int TYPE_sv3d;
    public static final int TYPE_tenc;
    public static final int TYPE_tfdt;
    public static final int TYPE_tfhd;
    public static final int TYPE_tkhd;
    public static final int TYPE_traf;
    public static final int TYPE_trak;
    public static final int TYPE_trex;
    public static final int TYPE_trun;
    public static final int TYPE_tx3g;
    public static final int TYPE_udta;
    public static final int TYPE_uuid;
    public static final int TYPE_vmhd;
    public static final int TYPE_vp08;
    public static final int TYPE_vp09;
    public static final int TYPE_vpcC;
    public static final int TYPE_wave;
    public static final int TYPE_wvtt;
    public transient /* synthetic */ FieldHolder $fh;
    public final int type;

    public static int parseFullAtomFlags(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i & 16777215 : invokeI.intValue;
    }

    public static int parseFullAtomVersion(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? (i >> 24) & 255 : invokeI.intValue;
    }

    /* loaded from: classes7.dex */
    public static final class ContainerAtom extends Atom {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<ContainerAtom> containerChildren;
        public final long endPosition;
        public final List<LeafAtom> leafChildren;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContainerAtom(int i, long j) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.endPosition = j;
            this.leafChildren = new ArrayList();
            this.containerChildren = new ArrayList();
        }

        public void add(ContainerAtom containerAtom) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, containerAtom) == null) {
                this.containerChildren.add(containerAtom);
            }
        }

        public ContainerAtom getContainerAtomOfType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                int size = this.containerChildren.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ContainerAtom containerAtom = this.containerChildren.get(i2);
                    if (containerAtom.type == i) {
                        return containerAtom;
                    }
                }
                return null;
            }
            return (ContainerAtom) invokeI.objValue;
        }

        public LeafAtom getLeafAtomOfType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                int size = this.leafChildren.size();
                for (int i2 = 0; i2 < size; i2++) {
                    LeafAtom leafAtom = this.leafChildren.get(i2);
                    if (leafAtom.type == i) {
                        return leafAtom;
                    }
                }
                return null;
            }
            return (LeafAtom) invokeI.objValue;
        }

        public void add(LeafAtom leafAtom) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, leafAtom) == null) {
                this.leafChildren.add(leafAtom);
            }
        }

        public int getChildAtomOfTypeCount(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                int size = this.leafChildren.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (this.leafChildren.get(i3).type == i) {
                        i2++;
                    }
                }
                int size2 = this.containerChildren.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    if (this.containerChildren.get(i4).type == i) {
                        i2++;
                    }
                }
                return i2;
            }
            return invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.Atom
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return Atom.getAtomTypeString(this.type) + " leaves: " + Arrays.toString(this.leafChildren.toArray()) + " containers: " + Arrays.toString(this.containerChildren.toArray());
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class LeafAtom extends Atom {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ParsableByteArray data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LeafAtom(int i, ParsableByteArray parsableByteArray) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), parsableByteArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.data = parsableByteArray;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1063389763, "Lcom/google/android/exoplayer2/extractor/mp4/Atom;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1063389763, "Lcom/google/android/exoplayer2/extractor/mp4/Atom;");
                return;
            }
        }
        TYPE_ftyp = Util.getIntegerCodeForString(FileTypeBox.TYPE);
        TYPE_avc1 = Util.getIntegerCodeForString("avc1");
        TYPE_avc3 = Util.getIntegerCodeForString(VisualSampleEntry.TYPE4);
        TYPE_hvc1 = Util.getIntegerCodeForString(MediaCodecUtil.CODEC_ID_HVC1);
        TYPE_hev1 = Util.getIntegerCodeForString(MediaCodecUtil.CODEC_ID_HEV1);
        TYPE_s263 = Util.getIntegerCodeForString(VisualSampleEntry.TYPE2);
        TYPE_d263 = Util.getIntegerCodeForString("d263");
        TYPE_mdat = Util.getIntegerCodeForString(MediaDataBox.TYPE);
        TYPE_mp4a = Util.getIntegerCodeForString(AudioSampleEntry.TYPE3);
        TYPE__mp3 = Util.getIntegerCodeForString(".mp3");
        TYPE_wave = Util.getIntegerCodeForString(AppleWaveBox.TYPE);
        TYPE_lpcm = Util.getIntegerCodeForString("lpcm");
        TYPE_sowt = Util.getIntegerCodeForString("sowt");
        TYPE_ac_3 = Util.getIntegerCodeForString(AudioSampleEntry.TYPE8);
        TYPE_dac3 = Util.getIntegerCodeForString(AC3SpecificBox.TYPE);
        TYPE_ec_3 = Util.getIntegerCodeForString(AudioSampleEntry.TYPE9);
        TYPE_dec3 = Util.getIntegerCodeForString(EC3SpecificBox.TYPE);
        TYPE_dtsc = Util.getIntegerCodeForString("dtsc");
        TYPE_dtsh = Util.getIntegerCodeForString(AudioSampleEntry.TYPE12);
        TYPE_dtsl = Util.getIntegerCodeForString(AudioSampleEntry.TYPE11);
        TYPE_dtse = Util.getIntegerCodeForString(AudioSampleEntry.TYPE13);
        TYPE_ddts = Util.getIntegerCodeForString(DTSSpecificBox.TYPE);
        TYPE_tfdt = Util.getIntegerCodeForString(TrackFragmentBaseMediaDecodeTimeBox.TYPE);
        TYPE_tfhd = Util.getIntegerCodeForString(TrackFragmentHeaderBox.TYPE);
        TYPE_trex = Util.getIntegerCodeForString(TrackExtendsBox.TYPE);
        TYPE_trun = Util.getIntegerCodeForString(TrackRunBox.TYPE);
        TYPE_sidx = Util.getIntegerCodeForString(SegmentIndexBox.TYPE);
        TYPE_moov = Util.getIntegerCodeForString(MovieBox.TYPE);
        TYPE_mvhd = Util.getIntegerCodeForString(MovieHeaderBox.TYPE);
        TYPE_trak = Util.getIntegerCodeForString(TrackBox.TYPE);
        TYPE_mdia = Util.getIntegerCodeForString(MediaBox.TYPE);
        TYPE_minf = Util.getIntegerCodeForString(MediaInformationBox.TYPE);
        TYPE_stbl = Util.getIntegerCodeForString(SampleTableBox.TYPE);
        TYPE_avcC = Util.getIntegerCodeForString(AvcConfigurationBox.TYPE);
        TYPE_hvcC = Util.getIntegerCodeForString("hvcC");
        TYPE_esds = Util.getIntegerCodeForString(ESDescriptorBox.TYPE);
        TYPE_moof = Util.getIntegerCodeForString(MovieFragmentBox.TYPE);
        TYPE_traf = Util.getIntegerCodeForString(TrackFragmentBox.TYPE);
        TYPE_mvex = Util.getIntegerCodeForString(MovieExtendsBox.TYPE);
        TYPE_mehd = Util.getIntegerCodeForString(MovieExtendsHeaderBox.TYPE);
        TYPE_tkhd = Util.getIntegerCodeForString(TrackHeaderBox.TYPE);
        TYPE_edts = Util.getIntegerCodeForString(EditBox.TYPE);
        TYPE_elst = Util.getIntegerCodeForString(EditListBox.TYPE);
        TYPE_mdhd = Util.getIntegerCodeForString(MediaHeaderBox.TYPE);
        TYPE_hdlr = Util.getIntegerCodeForString(HandlerBox.TYPE);
        TYPE_stsd = Util.getIntegerCodeForString(SampleDescriptionBox.TYPE);
        TYPE_pssh = Util.getIntegerCodeForString(ProtectionSystemSpecificHeaderBox.TYPE);
        TYPE_sinf = Util.getIntegerCodeForString(ProtectionSchemeInformationBox.TYPE);
        TYPE_schm = Util.getIntegerCodeForString(SchemeTypeBox.TYPE);
        TYPE_schi = Util.getIntegerCodeForString(SchemeInformationBox.TYPE);
        TYPE_tenc = Util.getIntegerCodeForString(com.googlecode.mp4parser.boxes.basemediaformat.TrackEncryptionBox.TYPE);
        TYPE_encv = Util.getIntegerCodeForString(VisualSampleEntry.TYPE_ENCRYPTED);
        TYPE_enca = Util.getIntegerCodeForString(AudioSampleEntry.TYPE_ENCRYPTED);
        TYPE_frma = Util.getIntegerCodeForString(OriginalFormatBox.TYPE);
        TYPE_saiz = Util.getIntegerCodeForString(SampleAuxiliaryInformationSizesBox.TYPE);
        TYPE_saio = Util.getIntegerCodeForString(SampleAuxiliaryInformationOffsetsBox.TYPE);
        TYPE_sbgp = Util.getIntegerCodeForString(SampleToGroupBox.TYPE);
        TYPE_sgpd = Util.getIntegerCodeForString(SampleGroupDescriptionBox.TYPE);
        TYPE_uuid = Util.getIntegerCodeForString("uuid");
        TYPE_senc = Util.getIntegerCodeForString(SampleEncryptionBox.TYPE);
        TYPE_pasp = Util.getIntegerCodeForString(PixelAspectRationAtom.TYPE);
        TYPE_TTML = Util.getIntegerCodeForString("TTML");
        TYPE_vmhd = Util.getIntegerCodeForString(VideoMediaHeaderBox.TYPE);
        TYPE_mp4v = Util.getIntegerCodeForString(VisualSampleEntry.TYPE1);
        TYPE_stts = Util.getIntegerCodeForString(TimeToSampleBox.TYPE);
        TYPE_stss = Util.getIntegerCodeForString(SyncSampleBox.TYPE);
        TYPE_ctts = Util.getIntegerCodeForString(CompositionTimeToSample.TYPE);
        TYPE_stsc = Util.getIntegerCodeForString(SampleToChunkBox.TYPE);
        TYPE_stsz = Util.getIntegerCodeForString(SampleSizeBox.TYPE);
        TYPE_stz2 = Util.getIntegerCodeForString("stz2");
        TYPE_stco = Util.getIntegerCodeForString(StaticChunkOffsetBox.TYPE);
        TYPE_co64 = Util.getIntegerCodeForString(ChunkOffset64BitBox.TYPE);
        TYPE_tx3g = Util.getIntegerCodeForString(TextSampleEntry.TYPE1);
        TYPE_wvtt = Util.getIntegerCodeForString("wvtt");
        TYPE_stpp = Util.getIntegerCodeForString(SubtitleSampleEntry.TYPE1);
        TYPE_c608 = Util.getIntegerCodeForString("c608");
        TYPE_samr = Util.getIntegerCodeForString(AudioSampleEntry.TYPE1);
        TYPE_sawb = Util.getIntegerCodeForString(AudioSampleEntry.TYPE2);
        TYPE_udta = Util.getIntegerCodeForString(UserDataBox.TYPE);
        TYPE_meta = Util.getIntegerCodeForString("meta");
        TYPE_ilst = Util.getIntegerCodeForString(AppleItemListBox.TYPE);
        TYPE_mean = Util.getIntegerCodeForString("mean");
        TYPE_name = Util.getIntegerCodeForString("name");
        TYPE_data = Util.getIntegerCodeForString("data");
        TYPE_emsg = Util.getIntegerCodeForString("emsg");
        TYPE_st3d = Util.getIntegerCodeForString("st3d");
        TYPE_sv3d = Util.getIntegerCodeForString("sv3d");
        TYPE_proj = Util.getIntegerCodeForString("proj");
        TYPE_vp08 = Util.getIntegerCodeForString("vp08");
        TYPE_vp09 = Util.getIntegerCodeForString("vp09");
        TYPE_vpcC = Util.getIntegerCodeForString("vpcC");
        TYPE_camm = Util.getIntegerCodeForString("camm");
        TYPE_alac = Util.getIntegerCodeForString("alac");
    }

    public Atom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.type = i;
    }

    public static String getAtomTypeString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
        }
        return (String) invokeI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return getAtomTypeString(this.type);
        }
        return (String) invokeV.objValue;
    }
}
