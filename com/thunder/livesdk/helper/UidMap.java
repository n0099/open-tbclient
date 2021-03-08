package com.thunder.livesdk.helper;

import com.baidu.android.common.others.IStringUtil;
import com.thunder.livesdk.log.ThunderLog;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class UidMap {
    private static final String TAG = "UidMap";
    private static Map<Long, String> mUidToStringMap = new HashMap();

    public static void addUid2String(long j, String str) {
        ThunderLog.release(TAG, String.format("addUid2String %d,%s", Long.valueOf(j), str));
        removeUid2String(str);
        removeUid2String(j);
        synchronized (UidMap.class) {
            mUidToStringMap.put(Long.valueOf(j), str);
        }
    }

    public static String getStringUid(long j) {
        String str;
        synchronized (UidMap.class) {
            str = mUidToStringMap.get(Long.valueOf(j));
        }
        if (str == null || str.isEmpty()) {
            return Long.toString(j);
        }
        return str;
    }

    public static String getStringUidFromMap(long j) {
        String str;
        synchronized (UidMap.class) {
            str = mUidToStringMap.get(Long.valueOf(j));
        }
        return str;
    }

    public static long getLongUid(String str) {
        long longValue;
        synchronized (UidMap.class) {
            if (str != null) {
                if (str.length() != 0) {
                    for (Long l : mUidToStringMap.keySet()) {
                        if (str.equals(mUidToStringMap.get(l))) {
                            longValue = l.longValue();
                            break;
                        }
                    }
                }
            }
            longValue = 0;
        }
        if (longValue == 0 && isNumeric(str)) {
            try {
                return Long.parseLong(str, 10);
            } catch (NumberFormatException e) {
                return 0L;
            }
        }
        return longValue;
    }

    public static void removeUid2String(long j) {
        synchronized (UidMap.class) {
            mUidToStringMap.remove(Long.valueOf(j));
        }
    }

    public static void removeUid2String(String str) {
        synchronized (UidMap.class) {
            if (str != null) {
                if (str.length() != 0) {
                    Iterator<Long> it = mUidToStringMap.keySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Long next = it.next();
                        if (str.equals(mUidToStringMap.get(next))) {
                            mUidToStringMap.remove(next);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void removeAllUid2String() {
        synchronized (UidMap.class) {
            mUidToStringMap.clear();
        }
    }

    public static boolean isNumeric(String str) {
        try {
            return Pattern.compile(IStringUtil.REGEX_NUM).matcher(new BigDecimal(str).toString()).matches();
        } catch (Exception e) {
            return false;
        }
    }
}
