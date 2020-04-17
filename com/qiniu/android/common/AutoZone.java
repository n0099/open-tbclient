package com.qiniu.android.common;

import com.qiniu.android.common.Zone;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.UrlSafeBase64;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class AutoZone extends Zone {
    public static final AutoZone mLq = new AutoZone();
    private final String mLr;
    private Map<ZoneIndex, ZoneInfo> mLs;
    private Client mLt;

    public AutoZone() {
        this("https://uc.qbox.me");
    }

    AutoZone(String str) {
        this.mLs = new ConcurrentHashMap();
        this.mLt = new Client();
        this.mLr = str;
    }

    private void a(ZoneIndex zoneIndex, CompletionHandler completionHandler) {
        this.mLt.a(this.mLr + "/v2/query?ak=" + zoneIndex.mLx + "&bucket=" + zoneIndex.bucket, null, UpToken.mMU, completionHandler);
    }

    ZoneInfo fl(String str, String str2) {
        return this.mLs.get(new ZoneIndex(str, str2));
    }

    ZoneInfo OU(String str) {
        try {
            String[] split = str.split(":");
            return fl(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void a(final ZoneIndex zoneIndex, final Zone.QueryHandler queryHandler) {
        if (zoneIndex == null) {
            queryHandler.IN(-5);
        } else if (this.mLs.get(zoneIndex) != null) {
            queryHandler.onSuccess();
        } else {
            a(zoneIndex, new CompletionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    if (responseInfo.dAs() && jSONObject != null) {
                        try {
                            AutoZone.this.mLs.put(zoneIndex, ZoneInfo.dX(jSONObject));
                            queryHandler.onSuccess();
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            queryHandler.IN(-1);
                            return;
                        }
                    }
                    queryHandler.IN(responseInfo.statusCode);
                }
            });
        }
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized String d(String str, boolean z, String str2) {
        ZoneInfo OU;
        OU = OU(str);
        return OU != null ? super.a(OU, z, str2) : null;
    }

    @Override // com.qiniu.android.common.Zone
    public void a(String str, Zone.QueryHandler queryHandler) {
        a(ZoneIndex.OW(str), queryHandler);
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized void OV(String str) {
        ZoneInfo zoneInfo;
        if (str != null) {
            String host = URI.create(str).getHost();
            Iterator<Map.Entry<ZoneIndex, ZoneInfo>> it = this.mLs.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    zoneInfo = null;
                    break;
                }
                zoneInfo = it.next().getValue();
                if (zoneInfo.mLF.contains(host)) {
                    break;
                }
            }
            if (zoneInfo != null) {
                zoneInfo.OV(host);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class ZoneIndex {
        final String bucket;
        final String mLx;

        ZoneIndex(String str, String str2) {
            this.mLx = str;
            this.bucket = str2;
        }

        static ZoneIndex OW(String str) {
            String[] split = str.split(":");
            try {
                return new ZoneIndex(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int hashCode() {
            return (this.mLx.hashCode() * 37) + this.bucket.hashCode();
        }

        public boolean equals(Object obj) {
            return obj == this || (obj != null && (obj instanceof ZoneIndex) && ((ZoneIndex) obj).mLx.equals(this.mLx) && ((ZoneIndex) obj).bucket.equals(this.bucket));
        }
    }
}
