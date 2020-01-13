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
/* loaded from: classes5.dex */
final class f {
    private static final int mjc = v.Qr("nam");
    private static final int mjd = v.Qr("trk");
    private static final int mje = v.Qr("cmt");
    private static final int mjf = v.Qr("day");
    private static final int mjg = v.Qr("ART");
    private static final int mjh = v.Qr("too");
    private static final int mji = v.Qr("alb");
    private static final int mjj = v.Qr("com");
    private static final int mjk = v.Qr("wrt");
    private static final int mjl = v.Qr("lyr");
    private static final int mjm = v.Qr("gen");
    private static final int mjn = v.Qr("covr");
    private static final int mjo = v.Qr(GenreBox.TYPE);
    private static final int mjp = v.Qr("grp");
    private static final int mjq = v.Qr("disk");
    private static final int mjr = v.Qr("trkn");
    private static final int mjs = v.Qr("tmpo");
    private static final int mjt = v.Qr("cpil");
    private static final int mju = v.Qr("aART");
    private static final int mjv = v.Qr("sonm");
    private static final int mjw = v.Qr("soal");
    private static final int mjx = v.Qr("soar");
    private static final int mjy = v.Qr("soaa");
    private static final int mjz = v.Qr("soco");
    private static final int mjA = v.Qr(RatingBox.TYPE);
    private static final int mjB = v.Qr("pgap");
    private static final int mjC = v.Qr("sosn");
    private static final int mjD = v.Qr("tvsh");
    private static final int mjE = v.Qr("----");
    private static final String[] mjF = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [180=28] */
    public static Metadata.Entry u(com.google.android.exoplayer2.util.l lVar) {
        int readInt = lVar.readInt() + lVar.getPosition();
        int readInt2 = lVar.readInt();
        int i = (readInt2 >> 24) & 255;
        try {
            if (i == 169 || i == 65533) {
                int i2 = 16777215 & readInt2;
                if (i2 == mje) {
                    CommentFrame a = a(readInt2, lVar);
                    lVar.setPosition(readInt);
                    return a;
                } else if (i2 == mjc || i2 == mjd) {
                    return a(readInt2, "TIT2", lVar);
                } else {
                    if (i2 == mjj || i2 == mjk) {
                        return a(readInt2, "TCOM", lVar);
                    }
                    if (i2 == mjf) {
                        return a(readInt2, "TDRC", lVar);
                    }
                    if (i2 == mjg) {
                        return a(readInt2, "TPE1", lVar);
                    }
                    if (i2 == mjh) {
                        return a(readInt2, "TSSE", lVar);
                    }
                    if (i2 == mji) {
                        return a(readInt2, "TALB", lVar);
                    }
                    if (i2 == mjl) {
                        return a(readInt2, "USLT", lVar);
                    }
                    if (i2 == mjm) {
                        return a(readInt2, "TCON", lVar);
                    }
                    if (i2 == mjp) {
                        return a(readInt2, "TIT1", lVar);
                    }
                }
            } else if (readInt2 == mjo) {
                return v(lVar);
            } else {
                if (readInt2 == mjq) {
                    return b(readInt2, "TPOS", lVar);
                }
                if (readInt2 == mjr) {
                    return b(readInt2, "TRCK", lVar);
                }
                if (readInt2 == mjs) {
                    return a(readInt2, "TBPM", lVar, true, false);
                }
                if (readInt2 == mjt) {
                    return a(readInt2, "TCMP", lVar, true, true);
                }
                if (readInt2 == mjn) {
                    return w(lVar);
                }
                if (readInt2 == mju) {
                    return a(readInt2, "TPE2", lVar);
                }
                if (readInt2 == mjv) {
                    return a(readInt2, "TSOT", lVar);
                }
                if (readInt2 == mjw) {
                    return a(readInt2, "TSO2", lVar);
                }
                if (readInt2 == mjx) {
                    return a(readInt2, "TSOA", lVar);
                }
                if (readInt2 == mjy) {
                    return a(readInt2, "TSOP", lVar);
                }
                if (readInt2 == mjz) {
                    return a(readInt2, "TSOC", lVar);
                }
                if (readInt2 == mjA) {
                    return a(readInt2, "ITUNESADVISORY", lVar, false, false);
                }
                if (readInt2 == mjB) {
                    return a(readInt2, "ITUNESGAPLESS", lVar, false, true);
                }
                if (readInt2 == mjC) {
                    return a(readInt2, "TVSHOWSORT", lVar);
                }
                if (readInt2 == mjD) {
                    return a(readInt2, "TVSHOW", lVar);
                }
                if (readInt2 == mjE) {
                    return h(lVar, readInt);
                }
            }
            Log.d("MetadataUtil", "Skipped unknown metadata entry: " + a.JF(readInt2));
            return null;
        } finally {
            lVar.setPosition(readInt);
        }
    }

    private static TextInformationFrame a(int i, String str, com.google.android.exoplayer2.util.l lVar) {
        int readInt = lVar.readInt();
        if (lVar.readInt() == a.mhK) {
            lVar.skipBytes(8);
            return new TextInformationFrame(str, null, lVar.LQ(readInt - 16));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: " + a.JF(i));
        return null;
    }

    private static CommentFrame a(int i, com.google.android.exoplayer2.util.l lVar) {
        int readInt = lVar.readInt();
        if (lVar.readInt() == a.mhK) {
            lVar.skipBytes(8);
            String LQ = lVar.LQ(readInt - 16);
            return new CommentFrame("und", LQ, LQ);
        }
        Log.w("MetadataUtil", "Failed to parse comment attribute: " + a.JF(i));
        return null;
    }

    private static Id3Frame a(int i, String str, com.google.android.exoplayer2.util.l lVar, boolean z, boolean z2) {
        int x = x(lVar);
        int min = z2 ? Math.min(1, x) : x;
        if (min >= 0) {
            return z ? new TextInformationFrame(str, null, Integer.toString(min)) : new CommentFrame("und", str, Integer.toString(min));
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute: " + a.JF(i));
        return null;
    }

    private static TextInformationFrame b(int i, String str, com.google.android.exoplayer2.util.l lVar) {
        int readInt = lVar.readInt();
        if (lVar.readInt() == a.mhK && readInt >= 22) {
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
        Log.w("MetadataUtil", "Failed to parse index/count attribute: " + a.JF(i));
        return null;
    }

    private static TextInformationFrame v(com.google.android.exoplayer2.util.l lVar) {
        int x = x(lVar);
        String str = (x <= 0 || x > mjF.length) ? null : mjF[x - 1];
        if (str != null) {
            return new TextInformationFrame("TCON", null, str);
        }
        Log.w("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    private static ApicFrame w(com.google.android.exoplayer2.util.l lVar) {
        String str;
        int readInt = lVar.readInt();
        if (lVar.readInt() == a.mhK) {
            int JE = a.JE(lVar.readInt());
            if (JE == 13) {
                str = MimeType.Image.JPEG;
            } else {
                str = JE == 14 ? MimeType.Image.PNG : null;
            }
            if (str == null) {
                Log.w("MetadataUtil", "Unrecognized cover art flags: " + JE);
                return null;
            }
            lVar.skipBytes(4);
            byte[] bArr = new byte[readInt - 16];
            lVar.C(bArr, 0, bArr.length);
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
            if (readInt2 == a.mhI) {
                str2 = lVar.LQ(readInt - 12);
            } else if (readInt2 == a.mhJ) {
                str = lVar.LQ(readInt - 12);
            } else {
                if (readInt2 == a.mhK) {
                    i2 = readInt;
                    i3 = position;
                }
                lVar.skipBytes(readInt - 12);
            }
        }
        if ("com.apple.iTunes".equals(str2) && "iTunSMPB".equals(str) && i3 != -1) {
            lVar.setPosition(i3);
            lVar.skipBytes(16);
            return new CommentFrame("und", str, lVar.LQ(i2 - 16));
        }
        return null;
    }

    private static int x(com.google.android.exoplayer2.util.l lVar) {
        lVar.skipBytes(4);
        if (lVar.readInt() == a.mhK) {
            lVar.skipBytes(8);
            return lVar.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
