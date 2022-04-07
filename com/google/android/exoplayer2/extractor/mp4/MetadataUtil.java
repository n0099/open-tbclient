package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.GenreBox;
import com.coremedia.iso.boxes.RatingBox;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes4.dex */
public final class MetadataUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LANGUAGE_UNDEFINED = "und";
    public static final int SHORT_TYPE_ALBUM;
    public static final int SHORT_TYPE_ARTIST;
    public static final int SHORT_TYPE_COMMENT;
    public static final int SHORT_TYPE_COMPOSER_1;
    public static final int SHORT_TYPE_COMPOSER_2;
    public static final int SHORT_TYPE_ENCODER;
    public static final int SHORT_TYPE_GENRE;
    public static final int SHORT_TYPE_LYRICS;
    public static final int SHORT_TYPE_NAME_1;
    public static final int SHORT_TYPE_NAME_2;
    public static final int SHORT_TYPE_YEAR;
    public static final String[] STANDARD_GENRES;
    public static final String TAG = "MetadataUtil";
    public static final int TYPE_ALBUM_ARTIST;
    public static final int TYPE_COMPILATION;
    public static final int TYPE_COVER_ART;
    public static final int TYPE_DISK_NUMBER;
    public static final int TYPE_GAPLESS_ALBUM;
    public static final int TYPE_GENRE;
    public static final int TYPE_GROUPING;
    public static final int TYPE_INTERNAL;
    public static final int TYPE_RATING;
    public static final int TYPE_SORT_ALBUM;
    public static final int TYPE_SORT_ALBUM_ARTIST;
    public static final int TYPE_SORT_ARTIST;
    public static final int TYPE_SORT_COMPOSER;
    public static final int TYPE_SORT_TRACK_NAME;
    public static final int TYPE_TEMPO;
    public static final int TYPE_TRACK_NUMBER;
    public static final int TYPE_TV_SHOW;
    public static final int TYPE_TV_SORT_SHOW;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(627555011, "Lcom/google/android/exoplayer2/extractor/mp4/MetadataUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(627555011, "Lcom/google/android/exoplayer2/extractor/mp4/MetadataUtil;");
                return;
            }
        }
        SHORT_TYPE_NAME_1 = Util.getIntegerCodeForString("nam");
        SHORT_TYPE_NAME_2 = Util.getIntegerCodeForString("trk");
        SHORT_TYPE_COMMENT = Util.getIntegerCodeForString("cmt");
        SHORT_TYPE_YEAR = Util.getIntegerCodeForString(Config.TRACE_VISIT_RECENT_DAY);
        SHORT_TYPE_ARTIST = Util.getIntegerCodeForString("ART");
        SHORT_TYPE_ENCODER = Util.getIntegerCodeForString("too");
        SHORT_TYPE_ALBUM = Util.getIntegerCodeForString("alb");
        SHORT_TYPE_COMPOSER_1 = Util.getIntegerCodeForString("com");
        SHORT_TYPE_COMPOSER_2 = Util.getIntegerCodeForString("wrt");
        SHORT_TYPE_LYRICS = Util.getIntegerCodeForString("lyr");
        SHORT_TYPE_GENRE = Util.getIntegerCodeForString("gen");
        TYPE_COVER_ART = Util.getIntegerCodeForString("covr");
        TYPE_GENRE = Util.getIntegerCodeForString(GenreBox.TYPE);
        TYPE_GROUPING = Util.getIntegerCodeForString("grp");
        TYPE_DISK_NUMBER = Util.getIntegerCodeForString("disk");
        TYPE_TRACK_NUMBER = Util.getIntegerCodeForString("trkn");
        TYPE_TEMPO = Util.getIntegerCodeForString("tmpo");
        TYPE_COMPILATION = Util.getIntegerCodeForString("cpil");
        TYPE_ALBUM_ARTIST = Util.getIntegerCodeForString("aART");
        TYPE_SORT_TRACK_NAME = Util.getIntegerCodeForString("sonm");
        TYPE_SORT_ALBUM = Util.getIntegerCodeForString("soal");
        TYPE_SORT_ARTIST = Util.getIntegerCodeForString("soar");
        TYPE_SORT_ALBUM_ARTIST = Util.getIntegerCodeForString("soaa");
        TYPE_SORT_COMPOSER = Util.getIntegerCodeForString("soco");
        TYPE_RATING = Util.getIntegerCodeForString(RatingBox.TYPE);
        TYPE_GAPLESS_ALBUM = Util.getIntegerCodeForString("pgap");
        TYPE_TV_SORT_SHOW = Util.getIntegerCodeForString("sosn");
        TYPE_TV_SHOW = Util.getIntegerCodeForString("tvsh");
        TYPE_INTERNAL = Util.getIntegerCodeForString("----");
        STANDARD_GENRES = new String[]{"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};
    }

    public MetadataUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static CommentFrame parseCommentAttribute(int i, ParsableByteArray parsableByteArray) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, parsableByteArray)) == null) {
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_data) {
                parsableByteArray.skipBytes(8);
                String readNullTerminatedString = parsableByteArray.readNullTerminatedString(readInt - 16);
                return new CommentFrame(LANGUAGE_UNDEFINED, readNullTerminatedString, readNullTerminatedString);
            }
            Log.w(TAG, "Failed to parse comment attribute: " + Atom.getAtomTypeString(i));
            return null;
        }
        return (CommentFrame) invokeIL.objValue;
    }

    public static ApicFrame parseCoverArt(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, parsableByteArray)) == null) {
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_data) {
                int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
                String str = parseFullAtomFlags == 13 ? "image/jpeg" : parseFullAtomFlags == 14 ? "image/png" : null;
                if (str == null) {
                    Log.w(TAG, "Unrecognized cover art flags: " + parseFullAtomFlags);
                    return null;
                }
                parsableByteArray.skipBytes(4);
                int i = readInt - 16;
                byte[] bArr = new byte[i];
                parsableByteArray.readBytes(bArr, 0, i);
                return new ApicFrame(str, null, 3, bArr);
            }
            Log.w(TAG, "Failed to parse cover art attribute");
            return null;
        }
        return (ApicFrame) invokeL.objValue;
    }

    public static Metadata.Entry parseIlstElement(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, parsableByteArray)) == null) {
            int position = parsableByteArray.getPosition() + parsableByteArray.readInt();
            int readInt = parsableByteArray.readInt();
            int i = (readInt >> 24) & 255;
            try {
                if (i != 169 && i != 65533) {
                    if (readInt == TYPE_GENRE) {
                        return parseStandardGenreAttribute(parsableByteArray);
                    }
                    if (readInt == TYPE_DISK_NUMBER) {
                        return parseIndexAndCountAttribute(readInt, "TPOS", parsableByteArray);
                    }
                    if (readInt == TYPE_TRACK_NUMBER) {
                        return parseIndexAndCountAttribute(readInt, "TRCK", parsableByteArray);
                    }
                    if (readInt == TYPE_TEMPO) {
                        return parseUint8Attribute(readInt, "TBPM", parsableByteArray, true, false);
                    }
                    if (readInt == TYPE_COMPILATION) {
                        return parseUint8Attribute(readInt, "TCMP", parsableByteArray, true, true);
                    }
                    if (readInt == TYPE_COVER_ART) {
                        return parseCoverArt(parsableByteArray);
                    }
                    if (readInt == TYPE_ALBUM_ARTIST) {
                        return parseTextAttribute(readInt, "TPE2", parsableByteArray);
                    }
                    if (readInt == TYPE_SORT_TRACK_NAME) {
                        return parseTextAttribute(readInt, "TSOT", parsableByteArray);
                    }
                    if (readInt == TYPE_SORT_ALBUM) {
                        return parseTextAttribute(readInt, "TSO2", parsableByteArray);
                    }
                    if (readInt == TYPE_SORT_ARTIST) {
                        return parseTextAttribute(readInt, "TSOA", parsableByteArray);
                    }
                    if (readInt == TYPE_SORT_ALBUM_ARTIST) {
                        return parseTextAttribute(readInt, "TSOP", parsableByteArray);
                    }
                    if (readInt == TYPE_SORT_COMPOSER) {
                        return parseTextAttribute(readInt, "TSOC", parsableByteArray);
                    }
                    if (readInt == TYPE_RATING) {
                        return parseUint8Attribute(readInt, "ITUNESADVISORY", parsableByteArray, false, false);
                    }
                    if (readInt == TYPE_GAPLESS_ALBUM) {
                        return parseUint8Attribute(readInt, "ITUNESGAPLESS", parsableByteArray, false, true);
                    }
                    if (readInt == TYPE_TV_SORT_SHOW) {
                        return parseTextAttribute(readInt, "TVSHOWSORT", parsableByteArray);
                    }
                    if (readInt == TYPE_TV_SHOW) {
                        return parseTextAttribute(readInt, "TVSHOW", parsableByteArray);
                    }
                    if (readInt == TYPE_INTERNAL) {
                        return parseInternalAttribute(parsableByteArray, position);
                    }
                } else {
                    int i2 = 16777215 & readInt;
                    if (i2 == SHORT_TYPE_COMMENT) {
                        return parseCommentAttribute(readInt, parsableByteArray);
                    }
                    if (i2 != SHORT_TYPE_NAME_1 && i2 != SHORT_TYPE_NAME_2) {
                        if (i2 != SHORT_TYPE_COMPOSER_1 && i2 != SHORT_TYPE_COMPOSER_2) {
                            if (i2 == SHORT_TYPE_YEAR) {
                                return parseTextAttribute(readInt, "TDRC", parsableByteArray);
                            }
                            if (i2 == SHORT_TYPE_ARTIST) {
                                return parseTextAttribute(readInt, "TPE1", parsableByteArray);
                            }
                            if (i2 == SHORT_TYPE_ENCODER) {
                                return parseTextAttribute(readInt, "TSSE", parsableByteArray);
                            }
                            if (i2 == SHORT_TYPE_ALBUM) {
                                return parseTextAttribute(readInt, "TALB", parsableByteArray);
                            }
                            if (i2 == SHORT_TYPE_LYRICS) {
                                return parseTextAttribute(readInt, "USLT", parsableByteArray);
                            }
                            if (i2 == SHORT_TYPE_GENRE) {
                                return parseTextAttribute(readInt, "TCON", parsableByteArray);
                            }
                            if (i2 == TYPE_GROUPING) {
                                return parseTextAttribute(readInt, "TIT1", parsableByteArray);
                            }
                        }
                        return parseTextAttribute(readInt, "TCOM", parsableByteArray);
                    }
                    return parseTextAttribute(readInt, "TIT2", parsableByteArray);
                }
                Log.d(TAG, "Skipped unknown metadata entry: " + Atom.getAtomTypeString(readInt));
                return null;
            } finally {
                parsableByteArray.setPosition(position);
            }
        }
        return (Metadata.Entry) invokeL.objValue;
    }

    public static TextInformationFrame parseIndexAndCountAttribute(int i, String str, ParsableByteArray parsableByteArray) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65541, null, i, str, parsableByteArray)) == null) {
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_data && readInt >= 22) {
                parsableByteArray.skipBytes(10);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                if (readUnsignedShort > 0) {
                    String str2 = "" + readUnsignedShort;
                    int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                    if (readUnsignedShort2 > 0) {
                        str2 = str2 + "/" + readUnsignedShort2;
                    }
                    return new TextInformationFrame(str, null, str2);
                }
            }
            Log.w(TAG, "Failed to parse index/count attribute: " + Atom.getAtomTypeString(i));
            return null;
        }
        return (TextInformationFrame) invokeILL.objValue;
    }

    public static Id3Frame parseInternalAttribute(ParsableByteArray parsableByteArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, parsableByteArray, i)) == null) {
            String str = null;
            String str2 = null;
            int i2 = -1;
            int i3 = -1;
            while (parsableByteArray.getPosition() < i) {
                int position = parsableByteArray.getPosition();
                int readInt = parsableByteArray.readInt();
                int readInt2 = parsableByteArray.readInt();
                parsableByteArray.skipBytes(4);
                if (readInt2 == Atom.TYPE_mean) {
                    str = parsableByteArray.readNullTerminatedString(readInt - 12);
                } else if (readInt2 == Atom.TYPE_name) {
                    str2 = parsableByteArray.readNullTerminatedString(readInt - 12);
                } else {
                    if (readInt2 == Atom.TYPE_data) {
                        i2 = position;
                        i3 = readInt;
                    }
                    parsableByteArray.skipBytes(readInt - 12);
                }
            }
            if ("com.apple.iTunes".equals(str) && GaplessInfoHolder.GAPLESS_COMMENT_ID.equals(str2) && i2 != -1) {
                parsableByteArray.setPosition(i2);
                parsableByteArray.skipBytes(16);
                return new CommentFrame(LANGUAGE_UNDEFINED, str2, parsableByteArray.readNullTerminatedString(i3 - 16));
            }
            return null;
        }
        return (Id3Frame) invokeLI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TextInformationFrame parseStandardGenreAttribute(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, null, parsableByteArray)) != null) {
            return (TextInformationFrame) invokeL.objValue;
        }
        int parseUint8AttributeValue = parseUint8AttributeValue(parsableByteArray);
        if (parseUint8AttributeValue > 0) {
            String[] strArr = STANDARD_GENRES;
            if (parseUint8AttributeValue <= strArr.length) {
                str = strArr[parseUint8AttributeValue - 1];
                if (str == null) {
                    return new TextInformationFrame("TCON", null, str);
                }
                Log.w(TAG, "Failed to parse standard genre code");
                return null;
            }
        }
        str = null;
        if (str == null) {
        }
    }

    public static TextInformationFrame parseTextAttribute(int i, String str, ParsableByteArray parsableByteArray) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65544, null, i, str, parsableByteArray)) == null) {
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_data) {
                parsableByteArray.skipBytes(8);
                return new TextInformationFrame(str, null, parsableByteArray.readNullTerminatedString(readInt - 16));
            }
            Log.w(TAG, "Failed to parse text attribute: " + Atom.getAtomTypeString(i));
            return null;
        }
        return (TextInformationFrame) invokeILL.objValue;
    }

    public static Id3Frame parseUint8Attribute(int i, String str, ParsableByteArray parsableByteArray, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i), str, parsableByteArray, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int parseUint8AttributeValue = parseUint8AttributeValue(parsableByteArray);
            if (z2) {
                parseUint8AttributeValue = Math.min(1, parseUint8AttributeValue);
            }
            if (parseUint8AttributeValue >= 0) {
                if (z) {
                    return new TextInformationFrame(str, null, Integer.toString(parseUint8AttributeValue));
                }
                return new CommentFrame(LANGUAGE_UNDEFINED, str, Integer.toString(parseUint8AttributeValue));
            }
            Log.w(TAG, "Failed to parse uint8 attribute: " + Atom.getAtomTypeString(i));
            return null;
        }
        return (Id3Frame) invokeCommon.objValue;
    }

    public static int parseUint8AttributeValue(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, parsableByteArray)) == null) {
            parsableByteArray.skipBytes(4);
            if (parsableByteArray.readInt() == Atom.TYPE_data) {
                parsableByteArray.skipBytes(8);
                return parsableByteArray.readUnsignedByte();
            }
            Log.w(TAG, "Failed to parse uint8 attribute value");
            return -1;
        }
        return invokeL.intValue;
    }
}
