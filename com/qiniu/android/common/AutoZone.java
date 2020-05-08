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
    public static final AutoZone mLt = new AutoZone();
    private final String mLu;
    private Map<ZoneIndex, ZoneInfo> mLv;
    private Client mLw;

    public AutoZone() {
        this("https://uc.qbox.me");
    }

    AutoZone(String str) {
        this.mLv = new ConcurrentHashMap();
        this.mLw = new Client();
        this.mLu = str;
    }

    private void a(ZoneIndex zoneIndex, CompletionHandler completionHandler) {
        this.mLw.a(this.mLu + "/v2/query?ak=" + zoneIndex.mLA + "&bucket=" + zoneIndex.bucket, null, UpToken.mMX, completionHandler);
    }

    ZoneInfo fl(String str, String str2) {
        return this.mLv.get(new ZoneIndex(str, str2));
    }

    ZoneInfo OX(String str) {
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
        } else if (this.mLv.get(zoneIndex) != null) {
            queryHandler.onSuccess();
        } else {
            a(zoneIndex, new CompletionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    if (responseInfo.dAo() && jSONObject != null) {
                        try {
                            AutoZone.this.mLv.put(zoneIndex, ZoneInfo.dX(jSONObject));
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
        ZoneInfo OX;
        OX = OX(str);
        return OX != null ? super.a(OX, z, str2) : null;
    }

    @Override // com.qiniu.android.common.Zone
    public void a(String str, Zone.QueryHandler queryHandler) {
        a(ZoneIndex.OZ(str), queryHandler);
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized void OY(String str) {
        ZoneInfo zoneInfo;
        if (str != null) {
            String host = URI.create(str).getHost();
            Iterator<Map.Entry<ZoneIndex, ZoneInfo>> it = this.mLv.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    zoneInfo = null;
                    break;
                }
                zoneInfo = it.next().getValue();
                if (zoneInfo.mLI.contains(host)) {
                    break;
                }
            }
            if (zoneInfo != null) {
                zoneInfo.OY(host);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class ZoneIndex {
        final String bucket;
        final String mLA;

        ZoneIndex(String str, String str2) {
            this.mLA = str;
            this.bucket = str2;
        }

        static ZoneIndex OZ(String str) {
            String[] split = str.split(":");
            try {
                return new ZoneIndex(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int hashCode() {
            return (this.mLA.hashCode() * 37) + this.bucket.hashCode();
        }

        public boolean equals(Object obj) {
            return obj == this || (obj != null && (obj instanceof ZoneIndex) && ((ZoneIndex) obj).mLA.equals(this.mLA) && ((ZoneIndex) obj).bucket.equals(this.bucket));
        }
    }
}
