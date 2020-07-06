package com.qiniu.android.common;

import java.net.URI;
/* loaded from: classes5.dex */
public abstract class Zone {

    /* loaded from: classes5.dex */
    public interface QueryHandler {
        void KH(int i);

        void onSuccess();
    }

    public abstract void RC(String str);

    public abstract void a(String str, QueryHandler queryHandler);

    public abstract String d(String str, boolean z, String str2);

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized String a(ZoneInfo zoneInfo, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        int i = 0;
        synchronized (this) {
            if (str != null) {
                zoneInfo.RC(URI.create(str).getHost());
            }
            while (true) {
                int i2 = i;
                if (i2 >= zoneInfo.nCP.size()) {
                    str2 = null;
                    break;
                }
                str5 = zoneInfo.nCP.get(i2);
                long longValue = zoneInfo.nCQ.get(str5).longValue();
                if (longValue == 0 || longValue <= System.currentTimeMillis() / 1000) {
                    break;
                }
                i = i2 + 1;
            }
            str2 = str5;
            if (str2 != null) {
                zoneInfo.nCQ.put(str2, 0L);
                str3 = str2;
            } else {
                for (String str6 : zoneInfo.nCP) {
                    zoneInfo.nCQ.put(str6, 0L);
                }
                str3 = zoneInfo.nCP.size() > 0 ? zoneInfo.nCP.get(0) : str2;
            }
            if (str3 == null) {
                str4 = null;
            } else if (z) {
                str4 = String.format("https://%s", str3);
            } else {
                str4 = String.format("http://%s", str3);
            }
        }
        return str4;
    }
}
