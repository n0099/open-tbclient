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
/* loaded from: classes5.dex */
abstract class a {
    public final int type;
    public static final int mgk = v.Qr(FileTypeBox.TYPE);
    public static final int mgl = v.Qr(VisualSampleEntry.TYPE3);
    public static final int mgm = v.Qr(VisualSampleEntry.TYPE4);
    public static final int mgn = v.Qr("hvc1");
    public static final int mgo = v.Qr("hev1");
    public static final int mgp = v.Qr(VisualSampleEntry.TYPE2);
    public static final int mgq = v.Qr("d263");
    public static final int mgr = v.Qr(MediaDataBox.TYPE);
    public static final int mgs = v.Qr(AudioSampleEntry.TYPE3);
    public static final int mgt = v.Qr(".mp3");
    public static final int mgu = v.Qr("wave");
    public static final int mgv = v.Qr("lpcm");
    public static final int mgw = v.Qr("sowt");
    public static final int mgx = v.Qr(AudioSampleEntry.TYPE8);
    public static final int mgy = v.Qr(AC3SpecificBox.TYPE);
    public static final int mgz = v.Qr(AudioSampleEntry.TYPE9);
    public static final int mgA = v.Qr(EC3SpecificBox.TYPE);
    public static final int mgB = v.Qr("dtsc");
    public static final int mgC = v.Qr(AudioSampleEntry.TYPE12);
    public static final int mgD = v.Qr(AudioSampleEntry.TYPE11);
    public static final int mgE = v.Qr(AudioSampleEntry.TYPE13);
    public static final int mgF = v.Qr(DTSSpecificBox.TYPE);
    public static final int mgG = v.Qr(TrackFragmentBaseMediaDecodeTimeBox.TYPE);
    public static final int mgH = v.Qr(TrackFragmentHeaderBox.TYPE);
    public static final int mgI = v.Qr(TrackExtendsBox.TYPE);
    public static final int mgJ = v.Qr(TrackRunBox.TYPE);
    public static final int mgK = v.Qr(SegmentIndexBox.TYPE);
    public static final int mgL = v.Qr(MovieBox.TYPE);
    public static final int mgM = v.Qr(MovieHeaderBox.TYPE);
    public static final int mgN = v.Qr(TrackBox.TYPE);
    public static final int mgO = v.Qr(MediaBox.TYPE);
    public static final int mgP = v.Qr(MediaInformationBox.TYPE);
    public static final int mgQ = v.Qr(SampleTableBox.TYPE);
    public static final int mgR = v.Qr(AvcConfigurationBox.TYPE);
    public static final int mgS = v.Qr("hvcC");
    public static final int mgT = v.Qr(ESDescriptorBox.TYPE);
    public static final int mgU = v.Qr(MovieFragmentBox.TYPE);
    public static final int mgV = v.Qr(TrackFragmentBox.TYPE);
    public static final int mgW = v.Qr(MovieExtendsBox.TYPE);
    public static final int mgX = v.Qr(MovieExtendsHeaderBox.TYPE);
    public static final int mgY = v.Qr(TrackHeaderBox.TYPE);
    public static final int mgZ = v.Qr(EditBox.TYPE);
    public static final int mha = v.Qr(EditListBox.TYPE);
    public static final int mhb = v.Qr(MediaHeaderBox.TYPE);
    public static final int mhc = v.Qr(HandlerBox.TYPE);
    public static final int mhd = v.Qr(SampleDescriptionBox.TYPE);
    public static final int mhe = v.Qr(ProtectionSystemSpecificHeaderBox.TYPE);
    public static final int mhf = v.Qr(ProtectionSchemeInformationBox.TYPE);
    public static final int mhg = v.Qr(SchemeTypeBox.TYPE);
    public static final int mhh = v.Qr(SchemeInformationBox.TYPE);
    public static final int mhi = v.Qr(TrackEncryptionBox.TYPE);
    public static final int mhj = v.Qr(VisualSampleEntry.TYPE_ENCRYPTED);
    public static final int mhk = v.Qr(AudioSampleEntry.TYPE_ENCRYPTED);
    public static final int mhl = v.Qr(OriginalFormatBox.TYPE);
    public static final int mhm = v.Qr(SampleAuxiliaryInformationSizesBox.TYPE);
    public static final int mhn = v.Qr(SampleAuxiliaryInformationOffsetsBox.TYPE);
    public static final int mho = v.Qr(SampleToGroupBox.TYPE);
    public static final int mhp = v.Qr(SampleGroupDescriptionBox.TYPE);
    public static final int mhq = v.Qr("uuid");
    public static final int mhr = v.Qr(SampleEncryptionBox.TYPE);
    public static final int mhs = v.Qr(PixelAspectRationAtom.TYPE);
    public static final int mht = v.Qr("TTML");
    public static final int mhu = v.Qr(VideoMediaHeaderBox.TYPE);
    public static final int mhv = v.Qr(VisualSampleEntry.TYPE1);
    public static final int mhw = v.Qr(TimeToSampleBox.TYPE);
    public static final int mhx = v.Qr(SyncSampleBox.TYPE);
    public static final int mhy = v.Qr(CompositionTimeToSample.TYPE);
    public static final int mhz = v.Qr(SampleToChunkBox.TYPE);
    public static final int mhA = v.Qr(SampleSizeBox.TYPE);
    public static final int mhB = v.Qr("stz2");
    public static final int mhC = v.Qr(StaticChunkOffsetBox.TYPE);
    public static final int mhD = v.Qr(ChunkOffset64BitBox.TYPE);
    public static final int mhE = v.Qr(TextSampleEntry.TYPE1);
    public static final int mhF = v.Qr("wvtt");
    public static final int mhG = v.Qr(SubtitleSampleEntry.TYPE1);
    public static final int mhH = v.Qr("c608");
    public static final int mhI = v.Qr(AudioSampleEntry.TYPE1);
    public static final int mhJ = v.Qr(AudioSampleEntry.TYPE2);
    public static final int mhK = v.Qr(UserDataBox.TYPE);
    public static final int mhL = v.Qr(MetaBox.TYPE);
    public static final int mhM = v.Qr(AppleItemListBox.TYPE);
    public static final int mhN = v.Qr("mean");
    public static final int mhO = v.Qr("name");
    public static final int mhP = v.Qr("data");
    public static final int mhQ = v.Qr("emsg");
    public static final int mhR = v.Qr("st3d");
    public static final int mhS = v.Qr("sv3d");
    public static final int mhT = v.Qr("proj");
    public static final int mhU = v.Qr("vp08");
    public static final int mhV = v.Qr("vp09");
    public static final int mhW = v.Qr("vpcC");
    public static final int mhX = v.Qr("camm");
    public static final int mhY = v.Qr("alac");

    public a(int i) {
        this.type = i;
    }

    public String toString() {
        return JF(this.type);
    }

    /* loaded from: classes5.dex */
    static final class b extends a {
        public final com.google.android.exoplayer2.util.l mib;

        public b(int i, com.google.android.exoplayer2.util.l lVar) {
            super(i);
            this.mib = lVar;
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static final class C0666a extends a {
        public final long endPosition;
        public final List<b> mhZ;
        public final List<C0666a> mia;

        public C0666a(int i, long j) {
            super(i);
            this.endPosition = j;
            this.mhZ = new ArrayList();
            this.mia = new ArrayList();
        }

        public void a(b bVar) {
            this.mhZ.add(bVar);
        }

        public void a(C0666a c0666a) {
            this.mia.add(c0666a);
        }

        public b JG(int i) {
            int size = this.mhZ.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.mhZ.get(i2);
                if (bVar.type == i) {
                    return bVar;
                }
            }
            return null;
        }

        public C0666a JH(int i) {
            int size = this.mia.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0666a c0666a = this.mia.get(i2);
                if (c0666a.type == i) {
                    return c0666a;
                }
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.extractor.c.a
        public String toString() {
            return JF(this.type) + " leaves: " + Arrays.toString(this.mhZ.toArray()) + " containers: " + Arrays.toString(this.mia.toArray());
        }
    }

    public static int JD(int i) {
        return (i >> 24) & 255;
    }

    public static int JE(int i) {
        return 16777215 & i;
    }

    public static String JF(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }
}
