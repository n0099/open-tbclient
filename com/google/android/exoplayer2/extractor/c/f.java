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
    private static final int mjN = v.QE("nam");
    private static final int mjO = v.QE("trk");
    private static final int mjP = v.QE("cmt");
    private static final int mjQ = v.QE("day");
    private static final int mjR = v.QE("ART");
    private static final int mjS = v.QE("too");
    private static final int mjT = v.QE("alb");
    private static final int mjU = v.QE("com");
    private static final int mjV = v.QE("wrt");
    private static final int mjW = v.QE("lyr");
    private static final int mjX = v.QE("gen");
    private static final int mjY = v.QE("covr");
    private static final int mjZ = v.QE(GenreBox.TYPE);
    private static final int mka = v.QE("grp");
    private static final int mkb = v.QE("disk");
    private static final int mkc = v.QE("trkn");
    private static final int mkd = v.QE("tmpo");
    private static final int mke = v.QE("cpil");
    private static final int mkf = v.QE("aART");
    private static final int mkg = v.QE("sonm");
    private static final int mkh = v.QE("soal");
    private static final int mki = v.QE("soar");
    private static final int mkj = v.QE("soaa");
    private static final int mkk = v.QE("soco");
    private static final int mkl = v.QE(RatingBox.TYPE);
    private static final int mkm = v.QE("pgap");
    private static final int mkn = v.QE("sosn");
    private static final int mko = v.QE("tvsh");
    private static final int mkp = v.QE("----");
    private static final String[] mkq = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [180=28] */
    public static Metadata.Entry u(com.google.android.exoplayer2.util.l lVar) {
        int readInt = lVar.readInt() + lVar.getPosition();
        int readInt2 = lVar.readInt();
        int i = (readInt2 >> 24) & 255;
        try {
            if (i == 169 || i == 65533) {
                int i2 = 16777215 & readInt2;
                if (i2 == mjP) {
                    CommentFrame a = a(readInt2, lVar);
                    lVar.setPosition(readInt);
                    return a;
                } else if (i2 == mjN || i2 == mjO) {
                    return a(readInt2, "TIT2", lVar);
                } else {
                    if (i2 == mjU || i2 == mjV) {
                        return a(readInt2, "TCOM", lVar);
                    }
                    if (i2 == mjQ) {
                        return a(readInt2, "TDRC", lVar);
                    }
                    if (i2 == mjR) {
                        return a(readInt2, "TPE1", lVar);
                    }
                    if (i2 == mjS) {
                        return a(readInt2, "TSSE", lVar);
                    }
                    if (i2 == mjT) {
                        return a(readInt2, "TALB", lVar);
                    }
                    if (i2 == mjW) {
                        return a(readInt2, "USLT", lVar);
                    }
                    if (i2 == mjX) {
                        return a(readInt2, "TCON", lVar);
                    }
                    if (i2 == mka) {
                        return a(readInt2, "TIT1", lVar);
                    }
                }
            } else if (readInt2 == mjZ) {
                return v(lVar);
            } else {
                if (readInt2 == mkb) {
                    return b(readInt2, "TPOS", lVar);
                }
                if (readInt2 == mkc) {
                    return b(readInt2, "TRCK", lVar);
                }
                if (readInt2 == mkd) {
                    return a(readInt2, "TBPM", lVar, true, false);
                }
                if (readInt2 == mke) {
                    return a(readInt2, "TCMP", lVar, true, true);
                }
                if (readInt2 == mjY) {
                    return w(lVar);
                }
                if (readInt2 == mkf) {
                    return a(readInt2, "TPE2", lVar);
                }
                if (readInt2 == mkg) {
                    return a(readInt2, "TSOT", lVar);
                }
                if (readInt2 == mkh) {
                    return a(readInt2, "TSO2", lVar);
                }
                if (readInt2 == mki) {
                    return a(readInt2, "TSOA", lVar);
                }
                if (readInt2 == mkj) {
                    return a(readInt2, "TSOP", lVar);
                }
                if (readInt2 == mkk) {
                    return a(readInt2, "TSOC", lVar);
                }
                if (readInt2 == mkl) {
                    return a(readInt2, "ITUNESADVISORY", lVar, false, false);
                }
                if (readInt2 == mkm) {
                    return a(readInt2, "ITUNESGAPLESS", lVar, false, true);
                }
                if (readInt2 == mkn) {
                    return a(readInt2, "TVSHOWSORT", lVar);
                }
                if (readInt2 == mko) {
                    return a(readInt2, "TVSHOW", lVar);
                }
                if (readInt2 == mkp) {
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
        if (lVar.readInt() == a.mix) {
            lVar.skipBytes(8);
            return new TextInformationFrame(str, null, lVar.LV(readInt - 16));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: " + a.JK(i));
        return null;
    }

    private static CommentFrame a(int i, com.google.android.exoplayer2.util.l lVar) {
        int readInt = lVar.readInt();
        if (lVar.readInt() == a.mix) {
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
        if (lVar.readInt() == a.mix && readInt >= 22) {
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
        String str = (x <= 0 || x > mkq.length) ? null : mkq[x - 1];
        if (str != null) {
            return new TextInformationFrame("TCON", null, str);
        }
        Log.w("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    private static ApicFrame w(com.google.android.exoplayer2.util.l lVar) {
        String str;
        int readInt = lVar.readInt();
        if (lVar.readInt() == a.mix) {
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
            if (readInt2 == a.miv) {
                str2 = lVar.LV(readInt - 12);
            } else if (readInt2 == a.miw) {
                str = lVar.LV(readInt - 12);
            } else {
                if (readInt2 == a.mix) {
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
        if (lVar.readInt() == a.mix) {
            lVar.skipBytes(8);
            return lVar.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
