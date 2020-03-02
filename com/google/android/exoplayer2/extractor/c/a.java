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
    public static final int mgS = v.QE(FileTypeBox.TYPE);
    public static final int mgT = v.QE(VisualSampleEntry.TYPE3);
    public static final int mgU = v.QE(VisualSampleEntry.TYPE4);
    public static final int mgV = v.QE("hvc1");
    public static final int mgW = v.QE("hev1");
    public static final int mgX = v.QE(VisualSampleEntry.TYPE2);
    public static final int mgY = v.QE("d263");
    public static final int mgZ = v.QE(MediaDataBox.TYPE);
    public static final int mha = v.QE(AudioSampleEntry.TYPE3);
    public static final int mhb = v.QE(".mp3");
    public static final int mhc = v.QE("wave");
    public static final int mhd = v.QE("lpcm");
    public static final int mhe = v.QE("sowt");
    public static final int mhf = v.QE(AudioSampleEntry.TYPE8);
    public static final int mhg = v.QE(AC3SpecificBox.TYPE);
    public static final int mhh = v.QE(AudioSampleEntry.TYPE9);
    public static final int mhi = v.QE(EC3SpecificBox.TYPE);
    public static final int mhj = v.QE("dtsc");
    public static final int mhk = v.QE(AudioSampleEntry.TYPE12);
    public static final int mhl = v.QE(AudioSampleEntry.TYPE11);
    public static final int mhm = v.QE(AudioSampleEntry.TYPE13);
    public static final int mhn = v.QE(DTSSpecificBox.TYPE);
    public static final int mho = v.QE(TrackFragmentBaseMediaDecodeTimeBox.TYPE);
    public static final int mhp = v.QE(TrackFragmentHeaderBox.TYPE);
    public static final int mhq = v.QE(TrackExtendsBox.TYPE);
    public static final int mhr = v.QE(TrackRunBox.TYPE);
    public static final int mhs = v.QE(SegmentIndexBox.TYPE);
    public static final int mht = v.QE(MovieBox.TYPE);
    public static final int mhu = v.QE(MovieHeaderBox.TYPE);
    public static final int mhv = v.QE(TrackBox.TYPE);
    public static final int mhw = v.QE(MediaBox.TYPE);
    public static final int mhx = v.QE(MediaInformationBox.TYPE);
    public static final int mhy = v.QE(SampleTableBox.TYPE);
    public static final int mhz = v.QE(AvcConfigurationBox.TYPE);
    public static final int mhA = v.QE("hvcC");
    public static final int mhB = v.QE(ESDescriptorBox.TYPE);
    public static final int mhC = v.QE(MovieFragmentBox.TYPE);
    public static final int mhD = v.QE(TrackFragmentBox.TYPE);
    public static final int mhE = v.QE(MovieExtendsBox.TYPE);
    public static final int mhF = v.QE(MovieExtendsHeaderBox.TYPE);
    public static final int mhG = v.QE(TrackHeaderBox.TYPE);
    public static final int mhH = v.QE(EditBox.TYPE);
    public static final int mhI = v.QE(EditListBox.TYPE);
    public static final int mhJ = v.QE(MediaHeaderBox.TYPE);
    public static final int mhK = v.QE(HandlerBox.TYPE);
    public static final int mhL = v.QE(SampleDescriptionBox.TYPE);
    public static final int mhM = v.QE(ProtectionSystemSpecificHeaderBox.TYPE);
    public static final int mhN = v.QE(ProtectionSchemeInformationBox.TYPE);
    public static final int mhO = v.QE(SchemeTypeBox.TYPE);
    public static final int mhP = v.QE(SchemeInformationBox.TYPE);
    public static final int mhQ = v.QE(TrackEncryptionBox.TYPE);
    public static final int mhR = v.QE(VisualSampleEntry.TYPE_ENCRYPTED);
    public static final int mhS = v.QE(AudioSampleEntry.TYPE_ENCRYPTED);
    public static final int mhT = v.QE(OriginalFormatBox.TYPE);
    public static final int mhU = v.QE(SampleAuxiliaryInformationSizesBox.TYPE);
    public static final int mhV = v.QE(SampleAuxiliaryInformationOffsetsBox.TYPE);
    public static final int mhW = v.QE(SampleToGroupBox.TYPE);
    public static final int mhX = v.QE(SampleGroupDescriptionBox.TYPE);
    public static final int mhY = v.QE("uuid");
    public static final int mhZ = v.QE(SampleEncryptionBox.TYPE);
    public static final int mia = v.QE(PixelAspectRationAtom.TYPE);
    public static final int mib = v.QE("TTML");
    public static final int mic = v.QE(VideoMediaHeaderBox.TYPE);
    public static final int mie = v.QE(VisualSampleEntry.TYPE1);
    public static final int mif = v.QE(TimeToSampleBox.TYPE);
    public static final int mig = v.QE(SyncSampleBox.TYPE);
    public static final int mih = v.QE(CompositionTimeToSample.TYPE);
    public static final int mii = v.QE(SampleToChunkBox.TYPE);
    public static final int mij = v.QE(SampleSizeBox.TYPE);
    public static final int mik = v.QE("stz2");
    public static final int mil = v.QE(StaticChunkOffsetBox.TYPE);
    public static final int mim = v.QE(ChunkOffset64BitBox.TYPE);
    public static final int mio = v.QE(TextSampleEntry.TYPE1);
    public static final int mip = v.QE("wvtt");
    public static final int miq = v.QE(SubtitleSampleEntry.TYPE1);
    public static final int mir = v.QE("c608");
    public static final int mis = v.QE(AudioSampleEntry.TYPE1);
    public static final int mit = v.QE(AudioSampleEntry.TYPE2);
    public static final int miu = v.QE(UserDataBox.TYPE);
    public static final int miv = v.QE(MetaBox.TYPE);
    public static final int miw = v.QE(AppleItemListBox.TYPE);
    public static final int mix = v.QE("mean");
    public static final int miy = v.QE("name");
    public static final int miz = v.QE("data");
    public static final int miA = v.QE("emsg");
    public static final int miB = v.QE("st3d");
    public static final int miC = v.QE("sv3d");
    public static final int miD = v.QE("proj");
    public static final int miE = v.QE("vp08");
    public static final int miF = v.QE("vp09");
    public static final int miG = v.QE("vpcC");
    public static final int miH = v.QE("camm");
    public static final int miI = v.QE("alac");

    public a(int i) {
        this.type = i;
    }

    public String toString() {
        return JK(this.type);
    }

    /* loaded from: classes6.dex */
    static final class b extends a {
        public final com.google.android.exoplayer2.util.l miL;

        public b(int i, com.google.android.exoplayer2.util.l lVar) {
            super(i);
            this.miL = lVar;
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0674a extends a {
        public final long endPosition;
        public final List<b> miJ;
        public final List<C0674a> miK;

        public C0674a(int i, long j) {
            super(i);
            this.endPosition = j;
            this.miJ = new ArrayList();
            this.miK = new ArrayList();
        }

        public void a(b bVar) {
            this.miJ.add(bVar);
        }

        public void a(C0674a c0674a) {
            this.miK.add(c0674a);
        }

        public b JL(int i) {
            int size = this.miJ.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.miJ.get(i2);
                if (bVar.type == i) {
                    return bVar;
                }
            }
            return null;
        }

        public C0674a JM(int i) {
            int size = this.miK.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0674a c0674a = this.miK.get(i2);
                if (c0674a.type == i) {
                    return c0674a;
                }
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.extractor.c.a
        public String toString() {
            return JK(this.type) + " leaves: " + Arrays.toString(this.miJ.toArray()) + " containers: " + Arrays.toString(this.miK.toArray());
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
