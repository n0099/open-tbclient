package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.statistics.h;
import com.baidu.fsg.base.statistics.j;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class PinyinUtils {
    private static final int DISTINGUISH_LEN = 10;
    private static final char FIRST_CHINA = 19968;
    private static final char LAST_CHINA = 40869;
    private static final char SPECIAL_HANZI = 12295;
    private static final String SPECIAL_HANZI_PINYIN = "LING";
    private static PinyinUtils sInstance;
    private static short[] sPinyinIndex;
    private static final String[] PINYIN = {"a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", NotificationStyle.BANNER_IMAGE_URL, "bian", "biao", "bie", "bin", "bing", "bo", "bu", "ca", "cai", "can", "cang", "cao", "ce", "cen", "ceng", "cha", "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", j.a, "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", "de", "deng", AppIconSetting.DEFAULT_LARGE_ICON, "dia", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun", "duo", "e", NotificationStyle.EXPANDABLE_IMAGE_URL, h.a, "er", "fa", "fan", "fang", "fei", "fen", "feng", "fo", "fou", "fu", "ga", "gai", "gan", "gang", "gao", "ge", "gei", "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "ji", "jia", "jian", "jiang", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng", AppIconSetting.LARGE_ICON_URL, "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "luan", "lun", "luo", "lv", "lve", "m", "ma", "mai", "man", "mang", "mao", "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "none", "nong", "nou", h.f, "nuan", "nuo", "nv", "nve", "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", "pu", "qi", "qia", "qian", "qiang", "qiao", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", "she", "shei", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "yao", "ye", "yi", "yiao", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", FeedData.TYPE_ZAN, "zang", "zao", "ze", "zei", "zen", "zeng", "zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhei", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo"};
    private static volatile boolean isLoad = false;

    /* loaded from: classes3.dex */
    public static class MatchedResult {
        public int start = -1;
        public int end = -1;
    }

    private PinyinUtils() {
    }

    public static synchronized PinyinUtils getInstance(Context context) {
        PinyinUtils pinyinUtils;
        synchronized (PinyinUtils.class) {
            if (sInstance == null) {
                sInstance = new PinyinUtils();
            }
            loadData(context);
            pinyinUtils = sInstance;
        }
        return pinyinUtils;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [109=5, 110=5, 112=5, 113=5, 115=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x0084 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x0094 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007e A[Catch: IOException -> 0x0082, TRY_LEAVE, TryCatch #11 {IOException -> 0x0082, blocks: (B:50:0x0079, B:52:0x007e), top: B:79:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.DataInputStream] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void loadData(Context context) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        InputStream inputStream = null;
        ?? r2 = 0;
        try {
            try {
                if (isLoad) {
                    if (0 != 0) {
                        try {
                            r2.close();
                        } catch (IOException e) {
                            return;
                        }
                    }
                    if (0 != 0) {
                        inputStream.close();
                        return;
                    }
                    return;
                }
                r2 = context.getAssets().open("pinyinindex");
                try {
                    dataInputStream = new DataInputStream(r2);
                    try {
                        sPinyinIndex = new short[dataInputStream.available() >> 1];
                        for (int i = 0; i < sPinyinIndex.length; i++) {
                            sPinyinIndex[i] = dataInputStream.readShort();
                        }
                        isLoad = true;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e2) {
                                return;
                            }
                        }
                        if (r2 != 0) {
                            r2.close();
                        }
                    } catch (IOException e3) {
                        dataInputStream2 = r2;
                        try {
                            isLoad = false;
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException e4) {
                                    return;
                                }
                            }
                            if (dataInputStream2 != null) {
                                dataInputStream2.close();
                            }
                        } catch (Throwable th) {
                            r2 = dataInputStream2;
                            dataInputStream2 = dataInputStream;
                            th = th;
                            if (dataInputStream2 != null) {
                                try {
                                    dataInputStream2.close();
                                } catch (IOException e5) {
                                    throw th;
                                }
                            }
                            if (r2 != 0) {
                                r2.close();
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        isLoad = false;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e7) {
                                return;
                            }
                        }
                        if (r2 != 0) {
                            r2.close();
                        }
                    }
                } catch (IOException e8) {
                    dataInputStream = null;
                    dataInputStream2 = r2;
                } catch (Exception e9) {
                    dataInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (dataInputStream2 != null) {
                    }
                    if (r2 != 0) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                dataInputStream2 = null;
                th = th3;
            }
        } catch (IOException e10) {
            dataInputStream = null;
        } catch (Exception e11) {
            dataInputStream = null;
            r2 = 0;
        } catch (Throwable th4) {
            th = th4;
            r2 = 0;
        }
    }

    private String getPinyin(char c) {
        if (!isLoad) {
            return "";
        }
        if (c == 12295) {
            return SPECIAL_HANZI_PINYIN;
        }
        if (c < 19968 || c > 40869) {
            return String.valueOf(c);
        }
        String str = PINYIN[sPinyinIndex[c - 19968]];
        if (str == null) {
            return "";
        }
        return str;
    }

    public String getPinyin(String str) {
        if (TextUtils.isEmpty(str) || !isLoad) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            sb.append(getPinyin(str.charAt(i)));
        }
        return sb.toString();
    }

    public MatchedResult getMatchedResult(String str, String str2) {
        String str3;
        int distinguish;
        MatchedResult matchedResult = new MatchedResult();
        matchedResult.start = -1;
        matchedResult.end = -1;
        if (isLoad) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return matchedResult;
            }
            String upperCase = str.toUpperCase();
            String upperCase2 = str2.toUpperCase();
            if (Math.min(upperCase.length(), upperCase2.length()) > 10) {
                String substring = upperCase.substring(0, 10);
                upperCase2 = upperCase2.substring(0, 10);
                str3 = substring;
            } else {
                str3 = upperCase;
            }
            int indexOf = str3.indexOf(upperCase2);
            if (indexOf >= 0) {
                matchedResult.start = indexOf;
                matchedResult.end = (indexOf + upperCase2.length()) - 1;
            }
            char[] cArr = new char[upperCase2.length()];
            for (int i = 0; i < upperCase2.length(); i++) {
                cArr[i] = upperCase2.charAt(i);
            }
            char[] cArr2 = new char[str3.length()];
            String[] strArr = new String[str3.length()];
            int length = str3.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str3.charAt(i2);
                cArr2[i2] = charAt;
                String pinyin = getPinyin(charAt);
                if (!TextUtils.isEmpty(pinyin)) {
                    strArr[i2] = pinyin.toUpperCase();
                } else {
                    strArr[i2] = new StringBuilder(String.valueOf(charAt)).toString();
                }
            }
            char c = cArr[0];
            for (int i3 = 0; i3 < strArr.length; i3++) {
                char charAt2 = strArr[i3].charAt(0);
                char c2 = cArr2[i3];
                if ((charAt2 == c || c2 == c) && (distinguish = distinguish(cArr, 0, subCharRangeArray(cArr2, i3, cArr2.length - 1), subStringRangeArray(strArr, i3, strArr.length - 1), 0, 0)) != -1) {
                    matchedResult.start = i3;
                    matchedResult.end = distinguish + i3;
                    return matchedResult;
                }
            }
            return matchedResult;
        }
        return matchedResult;
    }

    public int distinguish(char[] cArr, int i, char[] cArr2, String[] strArr, int i2, int i3) {
        if (i == 0 && (cArr[0] == cArr2[0] || cArr[0] == strArr[0].charAt(0))) {
            if (cArr.length != 1) {
                return distinguish(cArr, 1, cArr2, strArr, 0, 1);
            }
            return 0;
        } else if (strArr[i2].length() > i3 && i < cArr.length && (cArr[i] == cArr2[i2] || cArr[i] == strArr[i2].charAt(i3))) {
            if (i == cArr.length - 1) {
                if (!distinguish(cArr, cArr2, strArr, i2)) {
                    return -1;
                }
                return i2;
            }
            return distinguish(cArr, i + 1, cArr2, strArr, i2, i3 + 1);
        } else if (strArr.length > i2 + 1 && i < cArr.length && (cArr[i] == cArr2[i2 + 1] || cArr[i] == strArr[i2 + 1].charAt(0))) {
            if (i == cArr.length - 1) {
                if (distinguish(cArr, cArr2, strArr, i2)) {
                    return i2 + 1;
                }
                return -1;
            }
            return distinguish(cArr, i + 1, cArr2, strArr, i2 + 1, 1);
        } else {
            if (strArr.length > i2 + 1) {
                for (int i4 = 1; i4 < i; i4++) {
                    if (distinguish(cArr, i - i4, cArr2, strArr, i2 + 1, 0) != -1) {
                        return i2 + 1;
                    }
                }
            }
            return -1;
        }
    }

    private boolean distinguish(char[] cArr, char[] cArr2, String[] strArr, int i) {
        String str = new String(cArr);
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int indexOf = str.indexOf(strArr[i2].charAt(0), i3);
            if (indexOf == -1) {
                indexOf = str.indexOf(cArr2[i2], indexOf);
            }
            if (indexOf == -1) {
                return false;
            }
            i2++;
            i3 = indexOf + 1;
        }
        return true;
    }

    private char[] subCharRangeArray(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[(i2 - i) + 1];
        int i3 = 0;
        while (i <= i2) {
            cArr2[i3] = cArr[i];
            i++;
            i3++;
        }
        return cArr2;
    }

    private String[] subStringRangeArray(String[] strArr, int i, int i2) {
        String[] strArr2 = new String[(i2 - i) + 1];
        int i3 = 0;
        while (i <= i2) {
            strArr2[i3] = strArr[i];
            i++;
            i3++;
        }
        return strArr2;
    }

    public static PinyinUtils getObject() {
        return sInstance;
    }
}
