package com.google.android.exoplayer2.extractor.c;

import com.coremedia.iso.boxes.ChunkOffset64BitBox;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MetaBox;
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
import com.google.android.exoplayer2.util.v;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.DTSSpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom;
import com.googlecode.mp4parser.boxes.basemediaformat.TrackEncryptionBox;
import com.googlecode.mp4parser.boxes.cenc.ProtectionSystemSpecificHeaderBox;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox;
import com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox;
import com.googlecode.mp4parser.boxes.ultraviolet.SampleEncryptionBox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
abstract class a {
    public final int type;
    public static final int mhd = v.QF(FileTypeBox.TYPE);
    public static final int mhe = v.QF(VisualSampleEntry.TYPE3);
    public static final int mhf = v.QF(VisualSampleEntry.TYPE4);
    public static final int mhg = v.QF("hvc1");
    public static final int mhh = v.QF("hev1");
    public static final int mhi = v.QF(VisualSampleEntry.TYPE2);
    public static final int mhj = v.QF("d263");
    public static final int mhk = v.QF(MediaDataBox.TYPE);
    public static final int mhl = v.QF(AudioSampleEntry.TYPE3);
    public static final int mhm = v.QF(".mp3");
    public static final int mhn = v.QF("wave");
    public static final int mho = v.QF("lpcm");
    public static final int mhp = v.QF("sowt");
    public static final int mhq = v.QF(AudioSampleEntry.TYPE8);
    public static final int mhr = v.QF(AC3SpecificBox.TYPE);
    public static final int mhs = v.QF(AudioSampleEntry.TYPE9);
    public static final int mht = v.QF(EC3SpecificBox.TYPE);
    public static final int mhu = v.QF("dtsc");
    public static final int mhv = v.QF(AudioSampleEntry.TYPE12);
    public static final int mhw = v.QF(AudioSampleEntry.TYPE11);
    public static final int mhx = v.QF(AudioSampleEntry.TYPE13);
    public static final int mhy = v.QF(DTSSpecificBox.TYPE);
    public static final int mhz = v.QF(TrackFragmentBaseMediaDecodeTimeBox.TYPE);
    public static final int mhA = v.QF(TrackFragmentHeaderBox.TYPE);
    public static final int mhB = v.QF(TrackExtendsBox.TYPE);
    public static final int mhC = v.QF(TrackRunBox.TYPE);
    public static final int mhD = v.QF(SegmentIndexBox.TYPE);
    public static final int mhE = v.QF(MovieBox.TYPE);
    public static final int mhF = v.QF(MovieHeaderBox.TYPE);
    public static final int mhG = v.QF(TrackBox.TYPE);
    public static final int mhH = v.QF(MediaBox.TYPE);
    public static final int mhI = v.QF(MediaInformationBox.TYPE);
    public static final int mhJ = v.QF(SampleTableBox.TYPE);
    public static final int mhK = v.QF(AvcConfigurationBox.TYPE);
    public static final int mhL = v.QF("hvcC");
    public static final int mhM = v.QF(ESDescriptorBox.TYPE);
    public static final int mhN = v.QF(MovieFragmentBox.TYPE);
    public static final int mhO = v.QF(TrackFragmentBox.TYPE);
    public static final int mhP = v.QF(MovieExtendsBox.TYPE);
    public static final int mhQ = v.QF(MovieExtendsHeaderBox.TYPE);
    public static final int mhR = v.QF(TrackHeaderBox.TYPE);
    public static final int mhS = v.QF(EditBox.TYPE);
    public static final int mhT = v.QF(EditListBox.TYPE);
    public static final int mhU = v.QF(MediaHeaderBox.TYPE);
    public static final int mhV = v.QF(HandlerBox.TYPE);
    public static final int mhW = v.QF(SampleDescriptionBox.TYPE);
    public static final int mhX = v.QF(ProtectionSystemSpecificHeaderBox.TYPE);
    public static final int mhY = v.QF(ProtectionSchemeInformationBox.TYPE);
    public static final int mhZ = v.QF(SchemeTypeBox.TYPE);
    public static final int mia = v.QF(SchemeInformationBox.TYPE);
    public static final int mib = v.QF(TrackEncryptionBox.TYPE);
    public static final int mic = v.QF(VisualSampleEntry.TYPE_ENCRYPTED);
    public static final int mie = v.QF(AudioSampleEntry.TYPE_ENCRYPTED);
    public static final int mif = v.QF(OriginalFormatBox.TYPE);
    public static final int mig = v.QF(SampleAuxiliaryInformationSizesBox.TYPE);
    public static final int mih = v.QF(SampleAuxiliaryInformationOffsetsBox.TYPE);
    public static final int mii = v.QF(SampleToGroupBox.TYPE);
    public static final int mij = v.QF(SampleGroupDescriptionBox.TYPE);
    public static final int mik = v.QF("uuid");
    public static final int mil = v.QF(SampleEncryptionBox.TYPE);
    public static final int mim = v.QF(PixelAspectRationAtom.TYPE);
    public static final int mio = v.QF("TTML");
    public static final int mip = v.QF(VideoMediaHeaderBox.TYPE);
    public static final int miq = v.QF(VisualSampleEntry.TYPE1);
    public static final int mir = v.QF(TimeToSampleBox.TYPE);
    public static final int mis = v.QF(SyncSampleBox.TYPE);
    public static final int mit = v.QF(CompositionTimeToSample.TYPE);
    public static final int miu = v.QF(SampleToChunkBox.TYPE);
    public static final int miv = v.QF(SampleSizeBox.TYPE);
    public static final int miw = v.QF("stz2");
    public static final int mix = v.QF(StaticChunkOffsetBox.TYPE);
    public static final int miy = v.QF(ChunkOffset64BitBox.TYPE);
    public static final int miz = v.QF(TextSampleEntry.TYPE1);
    public static final int miA = v.QF("wvtt");
    public static final int miB = v.QF(SubtitleSampleEntry.TYPE1);
    public static final int miC = v.QF("c608");
    public static final int miD = v.QF(AudioSampleEntry.TYPE1);
    public static final int miE = v.QF(AudioSampleEntry.TYPE2);
    public static final int miF = v.QF(UserDataBox.TYPE);
    public static final int miG = v.QF(MetaBox.TYPE);
    public static final int miH = v.QF(AppleItemListBox.TYPE);
    public static final int miI = v.QF("mean");
    public static final int miJ = v.QF("name");
    public static final int miK = v.QF("data");
    public static final int miL = v.QF("emsg");
    public static final int miM = v.QF("st3d");
    public static final int miN = v.QF("sv3d");
    public static final int miO = v.QF("proj");
    public static final int miP = v.QF("vp08");
    public static final int miQ = v.QF("vp09");
    public static final int miR = v.QF("vpcC");
    public static final int miS = v.QF("camm");
    public static final int miT = v.QF("alac");

    public a(int i) {
        this.type = i;
    }

    public String toString() {
        return JK(this.type);
    }

    /* loaded from: classes6.dex */
    static final class b extends a {
        public final com.google.android.exoplayer2.util.l miW;

        public b(int i, com.google.android.exoplayer2.util.l lVar) {
            super(i);
            this.miW = lVar;
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0674a extends a {
        public final long endPosition;
        public final List<b> miU;
        public final List<C0674a> miV;

        public C0674a(int i, long j) {
            super(i);
            this.endPosition = j;
            this.miU = new ArrayList();
            this.miV = new ArrayList();
        }

        public void a(b bVar) {
            this.miU.add(bVar);
        }

        public void a(C0674a c0674a) {
            this.miV.add(c0674a);
        }

        public b JL(int i) {
            int size = this.miU.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.miU.get(i2);
                if (bVar.type == i) {
                    return bVar;
                }
            }
            return null;
        }

        public C0674a JM(int i) {
            int size = this.miV.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0674a c0674a = this.miV.get(i2);
                if (c0674a.type == i) {
                    return c0674a;
                }
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.extractor.c.a
        public String toString() {
            return JK(this.type) + " leaves: " + Arrays.toString(this.miU.toArray()) + " containers: " + Arrays.toString(this.miV.toArray());
        }
    }

    public static int JI(int i) {
        return (i >> 24) & 255;
    }

    public static int JJ(int i) {
        return 16777215 & i;
    }

    public static String JK(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }
}
