package com.google.android.exoplayer2.extractor.c;

import android.util.Log;
import com.baidu.android.util.media.MimeType;
import com.coremedia.iso.boxes.GenreBox;
import com.coremedia.iso.boxes.RatingBox;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
final class f {
    private static final int mka = v.QF("nam");
    private static final int mkb = v.QF("trk");
    private static final int mkc = v.QF("cmt");
    private static final int mkd = v.QF("day");
    private static final int mke = v.QF("ART");
    private static final int mkf = v.QF("too");
    private static final int mkg = v.QF("alb");
    private static final int mkh = v.QF("com");
    private static final int mki = v.QF("wrt");
    private static final int mkj = v.QF("lyr");
    private static final int mkk = v.QF("gen");
    private static final int mkl = v.QF("covr");
    private static final int mkm = v.QF(GenreBox.TYPE);
    private static final int mkn = v.QF("grp");
    private static final int mko = v.QF("disk");
    private static final int mkp = v.QF("trkn");
    private static final int mkq = v.QF("tmpo");
    private static final int mkr = v.QF("cpil");
    private static final int mks = v.QF("aART");
    private static final int mkt = v.QF("sonm");
    private static final int mku = v.QF("soal");
    private static final int mkv = v.QF("soar");
    private static final int mkw = v.QF("soaa");
    private static final int mkx = v.QF("soco");
    private static final int mky = v.QF(RatingBox.TYPE);
    private static final int mkz = v.QF("pgap");
    private static final int mkA = v.QF("sosn");
    private static final int mkB = v.QF("tvsh");
    private static final int mkC = v.QF("----");
    private static final String[] mkD = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [180=28] */
    public static Metadata.Entry u(com.google.android.exoplayer2.util.l lVar) {
        int readInt = lVar.readInt() + lVar.getPosition();
        int readInt2 = lVar.readInt();
        int i = (readInt2 >> 24) & 255;
        try {
            if (i == 169 || i == 65533) {
                int i2 = 16777215 & readInt2;
                if (i2 == mkc) {
                    CommentFrame a = a(readInt2, lVar);
                    lVar.setPosition(readInt);
                    return a;
                } else if (i2 == mka || i2 == mkb) {
                    return a(readInt2, "TIT2", lVar);
                } else {
                    if (i2 == mkh || i2 == mki) {
                        return a(readInt2, "TCOM", lVar);
                    }
                    if (i2 == mkd) {
                        return a(readInt2, "TDRC", lVar);
                    }
                    if (i2 == mke) {
                        return a(readInt2, "TPE1", lVar);
                    }
                    if (i2 == mkf) {
                        return a(readInt2, "TSSE", lVar);
                    }
                    if (i2 == mkg) {
                        return a(readInt2, "TALB", lVar);
                    }
                    if (i2 == mkj) {
                        return a(readInt2, "USLT", lVar);
                    }
                    if (i2 == mkk) {
                        return a(readInt2, "TCON", lVar);
                    }
                    if (i2 == mkn) {
                        return a(readInt2, "TIT1", lVar);
                    }
                }
            } else if (readInt2 == mkm) {
                return v(lVar);
            } else {
                if (readInt2 == mko) {
                    return b(readInt2, "TPOS", lVar);
                }
                if (readInt2 == mkp) {
                    return b(readInt2, "TRCK", lVar);
                }
                if (readInt2 == mkq) {
                    return a(readInt2, "TBPM", lVar, true, false);
                }
                if (readInt2 == mkr) {
                    return a(readInt2, "TCMP", lVar, true, true);
                }
                if (readInt2 == mkl) {
                    return w(lVar);
                }
                if (readInt2 == mks) {
                    return a(readInt2, "TPE2", lVar);
                }
                if (readInt2 == mkt) {
                    return a(readInt2, "TSOT", lVar);
                }
                if (readInt2 == mku) {
                    return a(readInt2, "TSO2", lVar);
                }
                if (readInt2 == mkv) {
                    return a(readInt2, "TSOA", lVar);
                }
                if (readInt2 == mkw) {
                    return a(readInt2, "TSOP", lVar);
                }
                if (readInt2 == mkx) {
                    return a(readInt2, "TSOC", lVar);
                }
                if (readInt2 == mky) {
                    return a(readInt2, "ITUNESADVISORY", lVar, false, false);
                }
                if (readInt2 == mkz) {
                    return a(readInt2, "ITUNESGAPLESS", lVar, false, true);
                }
                if (readInt2 == mkA) {
                    return a(readInt2, "TVSHOWSORT", lVar);
                }
                if (readInt2 == mkB) {
                    return a(readInt2, "TVSHOW", lVar);
                }
                if (readInt2 == mkC) {
                    return h(lVar, readInt);
                }
            }
            Log.d("MetadataUtil", "Skipped unknown metadata entry: " + a.JK(readInt2));
            return null;
        } finally {
            lVar.setPosition(readInt);
        }
    }

    private static TextInformationFrame a(int i, String str, com.google.android.exoplayer2.util.l lVar) {
        int readInt = lVar.readInt();
        if (lVar.readInt() == a.miK) {
            lVar.skipBytes(8);
            return new TextInformationFrame(str, null, lVar.LV(readInt - 16));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: " + a.JK(i));
        return null;
    }

    private static CommentFrame a(int i, com.google.android.exoplayer2.util.l lVar) {
        int readInt = lVar.readInt();
        if (lVar.readInt() == a.miK) {
            lVar.skipBytes(8);
            String LV = lVar.LV(readInt - 16);
            return new CommentFrame("und", LV, LV);
        }
        Log.w("MetadataUtil", "Failed to parse comment attribute: " + a.JK(i));
        return null;
    }

    private static Id3Frame a(int i, String str, com.google.android.exoplayer2.util.l lVar, boolean z, boolean z2) {
        int x = x(lVar);
        int min = z2 ? Math.min(1, x) : x;
        if (min >= 0) {
            return z ? new TextInformationFrame(str, null, Integer.toString(min)) : new CommentFrame("und", str, Integer.toString(min));
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute: " + a.JK(i));
        return null;
    }

    private static TextInformationFrame b(int i, String str, com.google.android.exoplayer2.util.l lVar) {
        int readInt = lVar.readInt();
        if (lVar.readInt() == a.miK && readInt >= 22) {
            lVar.skipBytes(10);
            int readUnsignedShort = lVar.readUnsignedShort();
            if (readUnsignedShort > 0) {
                String str2 = "" + readUnsignedShort;
                int readUnsignedShort2 = lVar.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    str2 = str2 + "/" + readUnsignedShort2;
                }
                return new TextInformationFrame(str, null, str2);
            }
        }
        Log.w("MetadataUtil", "Failed to parse index/count attribute: " + a.JK(i));
        return null;
    }

    private static TextInformationFrame v(com.google.android.exoplayer2.util.l lVar) {
        int x = x(lVar);
        String str = (x <= 0 || x > mkD.length) ? null : mkD[x - 1];
        if (str != null) {
            return new TextInformationFrame("TCON", null, str);
        }
        Log.w("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    private static ApicFrame w(com.google.android.exoplayer2.util.l lVar) {
        String str;
        int readInt = lVar.readInt();
        if (lVar.readInt() == a.miK) {
            int JJ = a.JJ(lVar.readInt());
            if (JJ == 13) {
                str = MimeType.Image.JPEG;
            } else {
                str = JJ == 14 ? MimeType.Image.PNG : null;
            }
            if (str == null) {
                Log.w("MetadataUtil", "Unrecognized cover art flags: " + JJ);
                return null;
            }
            lVar.skipBytes(4);
            byte[] bArr = new byte[readInt - 16];
            lVar.G(bArr, 0, bArr.length);
            return new ApicFrame(str, null, 3, bArr);
        }
        Log.w("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    private static Id3Frame h(com.google.android.exoplayer2.util.l lVar, int i) {
        int i2 = -1;
        int i3 = -1;
        String str = null;
        String str2 = null;
        while (lVar.getPosition() < i) {
            int position = lVar.getPosition();
            int readInt = lVar.readInt();
            int readInt2 = lVar.readInt();
            lVar.skipBytes(4);
            if (readInt2 == a.miI) {
                str2 = lVar.LV(readInt - 12);
            } else if (readInt2 == a.miJ) {
                str = lVar.LV(readInt - 12);
            } else {
                if (readInt2 == a.miK) {
                    i2 = readInt;
                    i3 = position;
                }
                lVar.skipBytes(readInt - 12);
            }
        }
        if ("com.apple.iTunes".equals(str2) && "iTunSMPB".equals(str) && i3 != -1) {
            lVar.setPosition(i3);
            lVar.skipBytes(16);
            return new CommentFrame("und", str, lVar.LV(i2 - 16));
        }
        return null;
    }

    private static int x(com.google.android.exoplayer2.util.l lVar) {
        lVar.skipBytes(4);
        if (lVar.readInt() == a.miK) {
            lVar.skipBytes(8);
            return lVar.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
