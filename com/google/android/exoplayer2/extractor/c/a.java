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
    public static final int mgQ = v.QE(FileTypeBox.TYPE);
    public static final int mgR = v.QE(VisualSampleEntry.TYPE3);
    public static final int mgS = v.QE(VisualSampleEntry.TYPE4);
    public static final int mgT = v.QE("hvc1");
    public static final int mgU = v.QE("hev1");
    public static final int mgV = v.QE(VisualSampleEntry.TYPE2);
    public static final int mgW = v.QE("d263");
    public static final int mgX = v.QE(MediaDataBox.TYPE);
    public static final int mgY = v.QE(AudioSampleEntry.TYPE3);
    public static final int mgZ = v.QE(".mp3");
    public static final int mha = v.QE("wave");
    public static final int mhb = v.QE("lpcm");
    public static final int mhc = v.QE("sowt");
    public static final int mhd = v.QE(AudioSampleEntry.TYPE8);
    public static final int mhe = v.QE(AC3SpecificBox.TYPE);
    public static final int mhf = v.QE(AudioSampleEntry.TYPE9);
    public static final int mhg = v.QE(EC3SpecificBox.TYPE);
    public static final int mhh = v.QE("dtsc");
    public static final int mhi = v.QE(AudioSampleEntry.TYPE12);
    public static final int mhj = v.QE(AudioSampleEntry.TYPE11);
    public static final int mhk = v.QE(AudioSampleEntry.TYPE13);
    public static final int mhl = v.QE(DTSSpecificBox.TYPE);
    public static final int mhm = v.QE(TrackFragmentBaseMediaDecodeTimeBox.TYPE);
    public static final int mhn = v.QE(TrackFragmentHeaderBox.TYPE);
    public static final int mho = v.QE(TrackExtendsBox.TYPE);
    public static final int mhp = v.QE(TrackRunBox.TYPE);
    public static final int mhq = v.QE(SegmentIndexBox.TYPE);
    public static final int mhr = v.QE(MovieBox.TYPE);
    public static final int mhs = v.QE(MovieHeaderBox.TYPE);
    public static final int mht = v.QE(TrackBox.TYPE);
    public static final int mhu = v.QE(MediaBox.TYPE);
    public static final int mhv = v.QE(MediaInformationBox.TYPE);
    public static final int mhw = v.QE(SampleTableBox.TYPE);
    public static final int mhx = v.QE(AvcConfigurationBox.TYPE);
    public static final int mhy = v.QE("hvcC");
    public static final int mhz = v.QE(ESDescriptorBox.TYPE);
    public static final int mhA = v.QE(MovieFragmentBox.TYPE);
    public static final int mhB = v.QE(TrackFragmentBox.TYPE);
    public static final int mhC = v.QE(MovieExtendsBox.TYPE);
    public static final int mhD = v.QE(MovieExtendsHeaderBox.TYPE);
    public static final int mhE = v.QE(TrackHeaderBox.TYPE);
    public static final int mhF = v.QE(EditBox.TYPE);
    public static final int mhG = v.QE(EditListBox.TYPE);
    public static final int mhH = v.QE(MediaHeaderBox.TYPE);
    public static final int mhI = v.QE(HandlerBox.TYPE);
    public static final int mhJ = v.QE(SampleDescriptionBox.TYPE);
    public static final int mhK = v.QE(ProtectionSystemSpecificHeaderBox.TYPE);
    public static final int mhL = v.QE(ProtectionSchemeInformationBox.TYPE);
    public static final int mhM = v.QE(SchemeTypeBox.TYPE);
    public static final int mhN = v.QE(SchemeInformationBox.TYPE);
    public static final int mhO = v.QE(TrackEncryptionBox.TYPE);
    public static final int mhP = v.QE(VisualSampleEntry.TYPE_ENCRYPTED);
    public static final int mhQ = v.QE(AudioSampleEntry.TYPE_ENCRYPTED);
    public static final int mhR = v.QE(OriginalFormatBox.TYPE);
    public static final int mhS = v.QE(SampleAuxiliaryInformationSizesBox.TYPE);
    public static final int mhT = v.QE(SampleAuxiliaryInformationOffsetsBox.TYPE);
    public static final int mhU = v.QE(SampleToGroupBox.TYPE);
    public static final int mhV = v.QE(SampleGroupDescriptionBox.TYPE);
    public static final int mhW = v.QE("uuid");
    public static final int mhX = v.QE(SampleEncryptionBox.TYPE);
    public static final int mhY = v.QE(PixelAspectRationAtom.TYPE);
    public static final int mhZ = v.QE("TTML");
    public static final int mia = v.QE(VideoMediaHeaderBox.TYPE);
    public static final int mib = v.QE(VisualSampleEntry.TYPE1);
    public static final int mic = v.QE(TimeToSampleBox.TYPE);
    public static final int mie = v.QE(SyncSampleBox.TYPE);
    public static final int mif = v.QE(CompositionTimeToSample.TYPE);
    public static final int mig = v.QE(SampleToChunkBox.TYPE);
    public static final int mih = v.QE(SampleSizeBox.TYPE);
    public static final int mii = v.QE("stz2");
    public static final int mij = v.QE(StaticChunkOffsetBox.TYPE);
    public static final int mik = v.QE(ChunkOffset64BitBox.TYPE);
    public static final int mil = v.QE(TextSampleEntry.TYPE1);
    public static final int mim = v.QE("wvtt");
    public static final int mio = v.QE(SubtitleSampleEntry.TYPE1);
    public static final int mip = v.QE("c608");
    public static final int miq = v.QE(AudioSampleEntry.TYPE1);
    public static final int mir = v.QE(AudioSampleEntry.TYPE2);
    public static final int mis = v.QE(UserDataBox.TYPE);
    public static final int mit = v.QE(MetaBox.TYPE);
    public static final int miu = v.QE(AppleItemListBox.TYPE);
    public static final int miv = v.QE("mean");
    public static final int miw = v.QE("name");
    public static final int mix = v.QE("data");
    public static final int miy = v.QE("emsg");
    public static final int miz = v.QE("st3d");
    public static final int miA = v.QE("sv3d");
    public static final int miB = v.QE("proj");
    public static final int miC = v.QE("vp08");
    public static final int miD = v.QE("vp09");
    public static final int miE = v.QE("vpcC");
    public static final int miF = v.QE("camm");
    public static final int miG = v.QE("alac");

    public a(int i) {
        this.type = i;
    }

    public String toString() {
        return JK(this.type);
    }

    /* loaded from: classes6.dex */
    static final class b extends a {
        public final com.google.android.exoplayer2.util.l miJ;

        public b(int i, com.google.android.exoplayer2.util.l lVar) {
            super(i);
            this.miJ = lVar;
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0674a extends a {
        public final long endPosition;
        public final List<b> miH;
        public final List<C0674a> miI;

        public C0674a(int i, long j) {
            super(i);
            this.endPosition = j;
            this.miH = new ArrayList();
            this.miI = new ArrayList();
        }

        public void a(b bVar) {
            this.miH.add(bVar);
        }

        public void a(C0674a c0674a) {
            this.miI.add(c0674a);
        }

        public b JL(int i) {
            int size = this.miH.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.miH.get(i2);
                if (bVar.type == i) {
                    return bVar;
                }
            }
            return null;
        }

        public C0674a JM(int i) {
            int size = this.miI.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0674a c0674a = this.miI.get(i2);
                if (c0674a.type == i) {
                    return c0674a;
                }
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.extractor.c.a
        public String toString() {
            return JK(this.type) + " leaves: " + Arrays.toString(this.miH.toArray()) + " containers: " + Arrays.toString(this.miI.toArray());
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
