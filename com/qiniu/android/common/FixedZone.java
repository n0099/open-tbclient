package com.qiniu.android.common;

import android.util.Log;
import com.qiniu.android.common.Zone;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class FixedZone extends Zone {
    public static final Zone oEE = new FixedZone(new String[]{"upload.qiniup.com", "upload-jjh.qiniup.com", "upload-xs.qiniup.com", "up.qiniup.com", "up-jjh.qiniup.com", "up-xs.qiniup.com", "upload.qbox.me", "up.qbox.me"});
    public static final Zone oEF = new FixedZone(new String[]{"upload-z1.qiniup.com", "up-z1.qiniup.com", "upload-z1.qbox.me", "up-z1.qbox.me"});
    public static final Zone oEG = new FixedZone(new String[]{"upload-z2.qiniup.com", "upload-dg.qiniup.com", "upload-fs.qiniup.com", "up-z2.qiniup.com", "up-dg.qiniup.com", "up-fs.qiniup.com", "upload-z2.qbox.me", "up-z2.qbox.me"});
    public static final Zone oEH = new FixedZone(new String[]{"upload-na0.qiniup.com", "up-na0.qiniup.com", "upload-na0.qbox.me", "up-na0.qbox.me"});
    public static final Zone oEI = new FixedZone(new String[]{"upload-as0.qiniup.com", "up-as0.qiniup.com", "upload-as0.qbox.me", "up-as0.qbox.me"});
    private ZoneInfo oEJ;

    public FixedZone(String[] strArr) {
        this.oEJ = X(strArr);
    }

    public static ZoneInfo X(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (String str : strArr) {
            arrayList.add(str);
            concurrentHashMap.put(str, 0L);
        }
        return new ZoneInfo(0, arrayList, concurrentHashMap);
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized String d(String str, boolean z, String str2) {
        String a2;
        a2 = a(this.oEJ, z, str2);
        for (Map.Entry<String, Long> entry : this.oEJ.oEM.entrySet()) {
            Log.d("Qiniu.FixedZone", entry.getKey() + ", " + entry.getValue());
        }
        return a2;
    }

    @Override // com.qiniu.android.common.Zone
    public void a(String str, Zone.QueryHandler queryHandler) {
        queryHandler.onSuccess();
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized void WH(String str) {
        if (str != null) {
            this.oEJ.WH(URI.create(str).getHost());
        }
    }
}
