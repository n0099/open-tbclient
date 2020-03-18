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
    public static final int miL = v.QE(FileTypeBox.TYPE);
    public static final int miM = v.QE(VisualSampleEntry.TYPE3);
    public static final int miN = v.QE(VisualSampleEntry.TYPE4);
    public static final int miO = v.QE("hvc1");
    public static final int miP = v.QE("hev1");
    public static final int miQ = v.QE(VisualSampleEntry.TYPE2);
    public static final int miR = v.QE("d263");
    public static final int miS = v.QE(MediaDataBox.TYPE);
    public static final int miT = v.QE(AudioSampleEntry.TYPE3);
    public static final int miU = v.QE(".mp3");
    public static final int miV = v.QE("wave");
    public static final int miW = v.QE("lpcm");
    public static final int miX = v.QE("sowt");
    public static final int miY = v.QE(AudioSampleEntry.TYPE8);
    public static final int miZ = v.QE(AC3SpecificBox.TYPE);
    public static final int mja = v.QE(AudioSampleEntry.TYPE9);
    public static final int mjb = v.QE(EC3SpecificBox.TYPE);
    public static final int mjc = v.QE("dtsc");
    public static final int mjd = v.QE(AudioSampleEntry.TYPE12);
    public static final int mje = v.QE(AudioSampleEntry.TYPE11);
    public static final int mjf = v.QE(AudioSampleEntry.TYPE13);
    public static final int mjg = v.QE(DTSSpecificBox.TYPE);
    public static final int mjh = v.QE(TrackFragmentBaseMediaDecodeTimeBox.TYPE);
    public static final int mji = v.QE(TrackFragmentHeaderBox.TYPE);
    public static final int mjj = v.QE(TrackExtendsBox.TYPE);
    public static final int mjk = v.QE(TrackRunBox.TYPE);
    public static final int mjl = v.QE(SegmentIndexBox.TYPE);
    public static final int mjm = v.QE(MovieBox.TYPE);
    public static final int mjn = v.QE(MovieHeaderBox.TYPE);
    public static final int mjo = v.QE(TrackBox.TYPE);
    public static final int mjp = v.QE(MediaBox.TYPE);
    public static final int mjq = v.QE(MediaInformationBox.TYPE);
    public static final int mjr = v.QE(SampleTableBox.TYPE);
    public static final int mjs = v.QE(AvcConfigurationBox.TYPE);
    public static final int mjt = v.QE("hvcC");
    public static final int mju = v.QE(ESDescriptorBox.TYPE);
    public static final int mjv = v.QE(MovieFragmentBox.TYPE);
    public static final int mjw = v.QE(TrackFragmentBox.TYPE);
    public static final int mjx = v.QE(MovieExtendsBox.TYPE);
    public static final int mjy = v.QE(MovieExtendsHeaderBox.TYPE);
    public static final int mjz = v.QE(TrackHeaderBox.TYPE);
    public static final int mjA = v.QE(EditBox.TYPE);
    public static final int mjB = v.QE(EditListBox.TYPE);
    public static final int mjC = v.QE(MediaHeaderBox.TYPE);
    public static final int mjD = v.QE(HandlerBox.TYPE);
    public static final int mjE = v.QE(SampleDescriptionBox.TYPE);
    public static final int mjF = v.QE(ProtectionSystemSpecificHeaderBox.TYPE);
    public static final int mjG = v.QE(ProtectionSchemeInformationBox.TYPE);
    public static final int mjH = v.QE(SchemeTypeBox.TYPE);
    public static final int mjI = v.QE(SchemeInformationBox.TYPE);
    public static final int mjJ = v.QE(TrackEncryptionBox.TYPE);
    public static final int mjK = v.QE(VisualSampleEntry.TYPE_ENCRYPTED);
    public static final int mjL = v.QE(AudioSampleEntry.TYPE_ENCRYPTED);
    public static final int mjM = v.QE(OriginalFormatBox.TYPE);
    public static final int mjN = v.QE(SampleAuxiliaryInformationSizesBox.TYPE);
    public static final int mjO = v.QE(SampleAuxiliaryInformationOffsetsBox.TYPE);
    public static final int mjP = v.QE(SampleToGroupBox.TYPE);
    public static final int mjQ = v.QE(SampleGroupDescriptionBox.TYPE);
    public static final int mjR = v.QE("uuid");
    public static final int mjS = v.QE(SampleEncryptionBox.TYPE);
    public static final int mjT = v.QE(PixelAspectRationAtom.TYPE);
    public static final int mjU = v.QE("TTML");
    public static final int mjV = v.QE(VideoMediaHeaderBox.TYPE);
    public static final int mjW = v.QE(VisualSampleEntry.TYPE1);
    public static final int mjX = v.QE(TimeToSampleBox.TYPE);
    public static final int mjY = v.QE(SyncSampleBox.TYPE);
    public static final int mjZ = v.QE(CompositionTimeToSample.TYPE);
    public static final int mka = v.QE(SampleToChunkBox.TYPE);
    public static final int mkb = v.QE(SampleSizeBox.TYPE);
    public static final int mkc = v.QE("stz2");
    public static final int mkd = v.QE(StaticChunkOffsetBox.TYPE);
    public static final int mke = v.QE(ChunkOffset64BitBox.TYPE);
    public static final int mkf = v.QE(TextSampleEntry.TYPE1);
    public static final int mkg = v.QE("wvtt");
    public static final int mkh = v.QE(SubtitleSampleEntry.TYPE1);
    public static final int mki = v.QE("c608");
    public static final int mkj = v.QE(AudioSampleEntry.TYPE1);
    public static final int mkk = v.QE(AudioSampleEntry.TYPE2);
    public static final int mkl = v.QE(UserDataBox.TYPE);
    public static final int mkm = v.QE(MetaBox.TYPE);
    public static final int mkn = v.QE(AppleItemListBox.TYPE);
    public static final int mko = v.QE("mean");
    public static final int mkp = v.QE("name");
    public static final int mkq = v.QE("data");
    public static final int mkr = v.QE("emsg");
    public static final int mks = v.QE("st3d");
    public static final int mkt = v.QE("sv3d");
    public static final int mku = v.QE("proj");
    public static final int mkv = v.QE("vp08");
    public static final int mkw = v.QE("vp09");
    public static final int mkx = v.QE("vpcC");
    public static final int mky = v.QE("camm");
    public static final int mkz = v.QE("alac");

    public a(int i) {
        this.type = i;
    }

    public String toString() {
        return JQ(this.type);
    }

    /* loaded from: classes6.dex */
    static final class b extends a {
        public final com.google.android.exoplayer2.util.l mkC;

        public b(int i, com.google.android.exoplayer2.util.l lVar) {
            super(i);
            this.mkC = lVar;
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0675a extends a {
        public final long endPosition;
        public final List<b> mkA;
        public final List<C0675a> mkB;

        public C0675a(int i, long j) {
            super(i);
            this.endPosition = j;
            this.mkA = new ArrayList();
            this.mkB = new ArrayList();
        }

        public void a(b bVar) {
            this.mkA.add(bVar);
        }

        public void a(C0675a c0675a) {
            this.mkB.add(c0675a);
        }

        public b JR(int i) {
            int size = this.mkA.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.mkA.get(i2);
                if (bVar.type == i) {
                    return bVar;
                }
            }
            return null;
        }

        public C0675a JS(int i) {
            int size = this.mkB.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0675a c0675a = this.mkB.get(i2);
                if (c0675a.type == i) {
                    return c0675a;
                }
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.extractor.c.a
        public String toString() {
            return JQ(this.type) + " leaves: " + Arrays.toString(this.mkA.toArray()) + " containers: " + Arrays.toString(this.mkB.toArray());
        }
    }

    public static int JO(int i) {
        return (i >> 24) & 255;
    }

    public static int JP(int i) {
        return 16777215 & i;
    }

    public static String JQ(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }
}
