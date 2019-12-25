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
/* loaded from: classes4.dex */
abstract class a {
    public final int type;
    public static final int mcq = v.Qg(FileTypeBox.TYPE);
    public static final int mcr = v.Qg(VisualSampleEntry.TYPE3);
    public static final int mcs = v.Qg(VisualSampleEntry.TYPE4);
    public static final int mct = v.Qg("hvc1");
    public static final int mcu = v.Qg("hev1");
    public static final int mcv = v.Qg(VisualSampleEntry.TYPE2);
    public static final int mcw = v.Qg("d263");
    public static final int mcx = v.Qg(MediaDataBox.TYPE);
    public static final int mcy = v.Qg(AudioSampleEntry.TYPE3);
    public static final int mcz = v.Qg(".mp3");
    public static final int mcA = v.Qg("wave");
    public static final int mcB = v.Qg("lpcm");
    public static final int mcC = v.Qg("sowt");
    public static final int mcD = v.Qg(AudioSampleEntry.TYPE8);
    public static final int mcE = v.Qg(AC3SpecificBox.TYPE);
    public static final int mcF = v.Qg(AudioSampleEntry.TYPE9);
    public static final int mcG = v.Qg(EC3SpecificBox.TYPE);
    public static final int mcH = v.Qg("dtsc");
    public static final int mcI = v.Qg(AudioSampleEntry.TYPE12);
    public static final int mcJ = v.Qg(AudioSampleEntry.TYPE11);
    public static final int mcK = v.Qg(AudioSampleEntry.TYPE13);
    public static final int mcL = v.Qg(DTSSpecificBox.TYPE);
    public static final int mcM = v.Qg(TrackFragmentBaseMediaDecodeTimeBox.TYPE);
    public static final int mcN = v.Qg(TrackFragmentHeaderBox.TYPE);
    public static final int mcO = v.Qg(TrackExtendsBox.TYPE);
    public static final int mcP = v.Qg(TrackRunBox.TYPE);
    public static final int mcQ = v.Qg(SegmentIndexBox.TYPE);
    public static final int mcR = v.Qg(MovieBox.TYPE);
    public static final int mcS = v.Qg(MovieHeaderBox.TYPE);
    public static final int mcT = v.Qg(TrackBox.TYPE);
    public static final int mcU = v.Qg(MediaBox.TYPE);
    public static final int mcV = v.Qg(MediaInformationBox.TYPE);
    public static final int mcW = v.Qg(SampleTableBox.TYPE);
    public static final int mcX = v.Qg(AvcConfigurationBox.TYPE);
    public static final int mcY = v.Qg("hvcC");
    public static final int mcZ = v.Qg(ESDescriptorBox.TYPE);
    public static final int mda = v.Qg(MovieFragmentBox.TYPE);
    public static final int mdb = v.Qg(TrackFragmentBox.TYPE);
    public static final int mdc = v.Qg(MovieExtendsBox.TYPE);
    public static final int mdd = v.Qg(MovieExtendsHeaderBox.TYPE);
    public static final int mde = v.Qg(TrackHeaderBox.TYPE);
    public static final int mdf = v.Qg(EditBox.TYPE);
    public static final int mdg = v.Qg(EditListBox.TYPE);
    public static final int mdh = v.Qg(MediaHeaderBox.TYPE);
    public static final int mdi = v.Qg(HandlerBox.TYPE);
    public static final int mdj = v.Qg(SampleDescriptionBox.TYPE);
    public static final int mdk = v.Qg(ProtectionSystemSpecificHeaderBox.TYPE);
    public static final int mdl = v.Qg(ProtectionSchemeInformationBox.TYPE);
    public static final int mdm = v.Qg(SchemeTypeBox.TYPE);
    public static final int mdn = v.Qg(SchemeInformationBox.TYPE);
    public static final int mdo = v.Qg(TrackEncryptionBox.TYPE);
    public static final int mdp = v.Qg(VisualSampleEntry.TYPE_ENCRYPTED);
    public static final int mdq = v.Qg(AudioSampleEntry.TYPE_ENCRYPTED);
    public static final int mdr = v.Qg(OriginalFormatBox.TYPE);
    public static final int mds = v.Qg(SampleAuxiliaryInformationSizesBox.TYPE);
    public static final int mdt = v.Qg(SampleAuxiliaryInformationOffsetsBox.TYPE);
    public static final int mdu = v.Qg(SampleToGroupBox.TYPE);
    public static final int mdv = v.Qg(SampleGroupDescriptionBox.TYPE);
    public static final int mdw = v.Qg("uuid");
    public static final int mdx = v.Qg(SampleEncryptionBox.TYPE);
    public static final int mdy = v.Qg(PixelAspectRationAtom.TYPE);
    public static final int mdz = v.Qg("TTML");
    public static final int mdA = v.Qg(VideoMediaHeaderBox.TYPE);
    public static final int mdB = v.Qg(VisualSampleEntry.TYPE1);
    public static final int mdC = v.Qg(TimeToSampleBox.TYPE);
    public static final int mdD = v.Qg(SyncSampleBox.TYPE);
    public static final int mdE = v.Qg(CompositionTimeToSample.TYPE);
    public static final int mdF = v.Qg(SampleToChunkBox.TYPE);
    public static final int mdG = v.Qg(SampleSizeBox.TYPE);
    public static final int mdH = v.Qg("stz2");
    public static final int mdI = v.Qg(StaticChunkOffsetBox.TYPE);
    public static final int mdJ = v.Qg(ChunkOffset64BitBox.TYPE);
    public static final int mdK = v.Qg(TextSampleEntry.TYPE1);
    public static final int mdL = v.Qg("wvtt");
    public static final int mdM = v.Qg(SubtitleSampleEntry.TYPE1);
    public static final int mdN = v.Qg("c608");
    public static final int mdO = v.Qg(AudioSampleEntry.TYPE1);
    public static final int mdP = v.Qg(AudioSampleEntry.TYPE2);
    public static final int mdQ = v.Qg(UserDataBox.TYPE);
    public static final int mdR = v.Qg(MetaBox.TYPE);
    public static final int mdS = v.Qg(AppleItemListBox.TYPE);
    public static final int mdT = v.Qg("mean");
    public static final int mdU = v.Qg("name");
    public static final int mdV = v.Qg("data");
    public static final int mdW = v.Qg("emsg");
    public static final int mdX = v.Qg("st3d");
    public static final int mdY = v.Qg("sv3d");
    public static final int mdZ = v.Qg("proj");
    public static final int mea = v.Qg("vp08");
    public static final int meb = v.Qg("vp09");
    public static final int mec = v.Qg("vpcC");
    public static final int med = v.Qg("camm");
    public static final int mee = v.Qg("alac");

    public a(int i) {
        this.type = i;
    }

    public String toString() {
        return Jw(this.type);
    }

    /* loaded from: classes4.dex */
    static final class b extends a {
        public final com.google.android.exoplayer2.util.l meh;

        public b(int i, com.google.android.exoplayer2.util.l lVar) {
            super(i);
            this.meh = lVar;
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static final class C0660a extends a {
        public final long endPosition;
        public final List<b> mef;
        public final List<C0660a> meg;

        public C0660a(int i, long j) {
            super(i);
            this.endPosition = j;
            this.mef = new ArrayList();
            this.meg = new ArrayList();
        }

        public void a(b bVar) {
            this.mef.add(bVar);
        }

        public void a(C0660a c0660a) {
            this.meg.add(c0660a);
        }

        public b Jx(int i) {
            int size = this.mef.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.mef.get(i2);
                if (bVar.type == i) {
                    return bVar;
                }
            }
            return null;
        }

        public C0660a Jy(int i) {
            int size = this.meg.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0660a c0660a = this.meg.get(i2);
                if (c0660a.type == i) {
                    return c0660a;
                }
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.extractor.c.a
        public String toString() {
            return Jw(this.type) + " leaves: " + Arrays.toString(this.mef.toArray()) + " containers: " + Arrays.toString(this.meg.toArray());
        }
    }

    public static int Ju(int i) {
        return (i >> 24) & 255;
    }

    public static int Jv(int i) {
        return 16777215 & i;
    }

    public static String Jw(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }
}
