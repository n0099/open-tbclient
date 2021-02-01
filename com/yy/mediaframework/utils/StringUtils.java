package com.yy.mediaframework.utils;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.yy.mediaframework.utils.FP;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Vector;
/* loaded from: classes4.dex */
public class StringUtils {
    public static final boolean IGNORE_CASE = true;
    public static final boolean IGNORE_WIDTH = true;
    private static final int SHA1_LENGTH = 40;

    public static boolean isNullOrEmpty(String str) {
        return FP.empty(str);
    }

    public static boolean isAllWhitespaces(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean equal(String str, String str2) {
        return equal(str, str2, false);
    }

    public static boolean equal(String str, String str2, boolean z) {
        if (str == null || str2 == null) {
            return str == null && str2 == null;
        } else if (z) {
            return str.equalsIgnoreCase(str2);
        } else {
            return str.equals(str2);
        }
    }

    public static Vector<String> parseMediaUrls(String str, String str2, String str3) {
        Vector<String> vector = new Vector<>();
        if (!isNullOrEmpty(str)) {
            int indexOf = str.indexOf(str2, 0);
            int indexOf2 = str.indexOf(str3, 0);
            while (indexOf != -1 && indexOf2 != -1 && indexOf2 > indexOf) {
                String substring = str.substring(indexOf + str2.length(), indexOf2);
                if (!isNullOrEmpty(substring) && substring.charAt(0) != '[') {
                    vector.add(substring);
                }
                int length = indexOf2 + str3.length() + indexOf2;
                indexOf = str.indexOf(str2, length);
                indexOf2 = str.indexOf(str3, length);
            }
        }
        return vector;
    }

    public static int find(String str, String str2) {
        return find(str, str2, false);
    }

    public static int find(String str, String str2, boolean z) {
        return find(str, str2, z, false);
    }

    public static int find(String str, String str2, boolean z, boolean z2) {
        String str3;
        if (FP.empty(str2)) {
            return -1;
        }
        String ref = FP.ref(str);
        if (z) {
            ref = ref.toLowerCase();
            str3 = str2.toLowerCase();
        } else {
            str3 = str2;
        }
        if (z2) {
            ref = narrow(ref);
            str3 = narrow(str3);
        }
        return str3.indexOf(ref);
    }

    public static String narrow(String str) {
        if (FP.empty(str)) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = narrow(charArray[i]);
        }
        return new String(charArray);
    }

    public static char narrow(char c) {
        if (c >= 65281 && c <= 65373) {
            return (char) (c - 65248);
        }
        if (c == 12288) {
            return (char) ((c - 12288) + 32);
        }
        if (c == 65377) {
            return (char) 12290;
        }
        if (c == 12539 || c == 8226) {
            return (char) 183;
        }
        return c;
    }

    public static int ord(char c) {
        if ('a' > c || c > 'z') {
            if ('A' <= c && c <= 'Z') {
                return (c - 'A') + 97;
            }
            return 0;
        }
        return c;
    }

    public static int compare(String str, String str2) {
        return FP.ref(str).compareTo(FP.ref(str2));
    }

    public static String getHashIfPassIsPlainText(String str) {
        if (!isNullOrEmpty(str) && str.length() < 40) {
            return sha1(str);
        }
        return str;
    }

    public static String sha1(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(bytesToHexString(MessageDigest.getInstance("SHA1").digest(str.getBytes())));
        } catch (NoSuchAlgorithmException e) {
            YMFLog.error((Object) null, "[Util    ]", "sha1 exception:" + e.toString());
        }
        return sb.toString();
    }

    public static String bytesToHexString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            int i = b2 & 255;
            if (i < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }

    public static boolean isValidMobileNumber(String str) {
        if (str != null && str.length() == 11 && str.startsWith("1")) {
            return isAllDigits(str);
        }
        return false;
    }

    public static boolean isNameMatchMobilePattern(String str) {
        return str != null && str.matches("1\\d{10}(y*|s*)");
    }

    public static String getMobileFromName(String str) {
        YMFLog.debug(null, "[Util    ]", "mobile user name:%s", str);
        if (str != null && str.startsWith("1") && str.length() >= 11) {
            String substring = str.substring(0, 11);
            if (isValidMobileNumber(substring)) {
                return substring;
            }
        }
        return "";
    }

    public static boolean isIpv4Addr(String str) {
        return str != null && str.matches("(\\d{1,3}\\.){3}\\d{1,3}");
    }

    public static <A, B> String fromPair(Pair<A, B> pair) {
        return pair.first + ":" + pair.second;
    }

    public static <A, B> String join(CharSequence charSequence, List<Pair<A, B>> list) {
        return TextUtils.join(charSequence, FP.map(new FP.UnaryFunc<String, Pair<A, B>>() { // from class: com.yy.mediaframework.utils.StringUtils.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.yy.mediaframework.utils.FP.UnaryFunc
            public String apply(Pair<A, B> pair) {
                return StringUtils.fromPair(pair);
            }
        }, list));
    }

    public static <E> String join(CharSequence charSequence, SparseArray<E> sparseArray) {
        return join(charSequence, FP.toList((SparseArray) sparseArray));
    }

    public static String join(CharSequence charSequence, SparseIntArray sparseIntArray) {
        return join(charSequence, FP.toList(sparseIntArray));
    }
}
