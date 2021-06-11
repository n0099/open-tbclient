package com.yy.hiidostatis.inner;

import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class BaseStatisContent {
    public static final String ACT = "act";
    public static final String APPID = "app";
    public static final String APPKEY = "appkey";
    public static final String ARID = "arid";
    public static final String AUTOID = "hd_autoid";
    public static final String BDCUID = "bdcuid";
    public static final String CHANNEL = "chn";
    public static final Comparator<String> COMPARATOR = new Comparator<String>() { // from class: com.yy.hiidostatis.inner.BaseStatisContent.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            boolean equals = "act".equals(str);
            boolean equals2 = "act".equals(str2);
            if (equals || equals2) {
                if (equals || !equals2) {
                    if (!equals || equals2) {
                        if (!equals || equals2) {
                        }
                        return 0;
                    }
                    return -1;
                }
                return 1;
            }
            return str.compareTo(str2);
        }
    };
    public static final String CREPID = "hd_crepid";
    public static final String CURPID = "hd_curpid";
    public static final String FROM = "from";
    public static final String GUID = "guid";
    public static final String HDID = "hdid";
    public static final String IDFV = "idfv";
    public static final String IMC = "imc";
    public static final String IMEI = "imei";
    public static final String IMSI = "imsi";
    public static final String KEY = "key";
    public static final String MAC = "mac";
    public static final String MBL = "mbl";
    public static final String MBOS = "mbos";
    public static final String MDSR = "mdsr";
    public static final String NET = "net";
    public static final String NTM = "ntm";
    public static final String OAID = "oaid";
    public static final String OPID = "opid";
    public static final String PACKID = "hd_packid";
    public static final String REMAIN = "hd_remain";
    public static final String SDKVER = "sdkver";
    public static final String SESSIONID = "sessionid";
    public static final String SJM = "sjm";
    public static final String SJP = "sjp";
    public static final String SR = "sr";
    public static final String SYS = "sys";
    public static final String TIME = "time";
    public static final String TIMEZONE = "timezone";
    public static final String VER = "ver";
    public TreeMap<String, String> raw = new TreeMap<>(COMPARATOR);

    public boolean containsKey(String str) {
        return this.raw.containsKey(str);
    }

    public BaseStatisContent copy() {
        BaseStatisContent baseStatisContent = new BaseStatisContent();
        TreeMap<String, String> treeMap = new TreeMap<>(COMPARATOR);
        baseStatisContent.raw = treeMap;
        treeMap.putAll(this.raw);
        return baseStatisContent;
    }

    public String get(String str) {
        return this.raw.get(str);
    }

    public synchronized String getContent() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.raw.entrySet()) {
            String value = entry.getValue();
            if (Util.empty(value)) {
                L.verbose(this, "No value for key %s", entry.getKey());
            } else {
                sb.append(entry.getKey());
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(value, "UTF-8"));
                } catch (UnsupportedEncodingException unused) {
                    L.debug(this, "encoding fail for key %s", entry.getKey());
                }
                sb.append("&");
            }
        }
        if (sb.length() == 0) {
            L.debug(this, "Warn : http content may be null?", new Object[0]);
            return null;
        }
        if (sb.length() > 0) {
            sb.append("hd_p=E&");
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        String sb2 = sb.toString();
        sb.setLength(0);
        return sb2;
    }

    public boolean isEmpty() {
        return this.raw.isEmpty();
    }

    public String put(String str, int i2) {
        return put(str, String.valueOf(i2));
    }

    public synchronized void putContent(BaseStatisContent baseStatisContent, boolean z) {
        if (baseStatisContent != null) {
            if (!baseStatisContent.isEmpty()) {
                for (Map.Entry<String, String> entry : baseStatisContent.raw.entrySet()) {
                    if (z) {
                        String put = put(entry.getKey(), entry.getValue());
                        if (put != null) {
                            L.brief("value-cover:isCover=%b,key=%s,old-value=%s,new-value=%s", Boolean.valueOf(z), entry.getKey(), put, entry.getValue());
                        }
                    } else if (containsKey(entry.getKey())) {
                        L.brief("value-cover:isCover=%b,key=%s,old-value=%s,new-value=%s,ignore-value=%s", Boolean.valueOf(z), entry.getKey(), get(entry.getKey()), get(entry.getKey()), entry.getValue());
                    } else {
                        put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }

    public String toString() {
        return getContent();
    }

    public String put(String str, long j) {
        return put(str, String.valueOf(j));
    }

    public String put(String str, double d2) {
        return put(str, String.valueOf(d2));
    }

    public synchronized String put(String str, String str2) {
        if (Util.empty(str)) {
            L.debug("BaseStatisContent", "key is invalid for value %s", str2);
            return null;
        }
        return this.raw.put(str, Util.asEmptyOnNull(str2));
    }

    public synchronized String put(String str, String str2, boolean z) {
        if (Util.empty(str)) {
            L.debug("BaseStatisContent", "key is invalid for value %s", str2);
            return null;
        }
        String asEmptyOnNull = Util.asEmptyOnNull(str2);
        if (z) {
            return this.raw.put(str, asEmptyOnNull);
        } else if (this.raw.containsKey(str)) {
            return this.raw.get(str);
        } else {
            return this.raw.put(str, asEmptyOnNull);
        }
    }
}
