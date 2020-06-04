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
    public static final AutoZone ngH = new AutoZone();
    private final String ngI;
    private Map<ZoneIndex, ZoneInfo> ngJ;
    private Client ngK;

    public AutoZone() {
        this("https://uc.qbox.me");
    }

    AutoZone(String str) {
        this.ngJ = new ConcurrentHashMap();
        this.ngK = new Client();
        this.ngI = str;
    }

    private void a(ZoneIndex zoneIndex, CompletionHandler completionHandler) {
        this.ngK.a(this.ngI + "/v2/query?ak=" + zoneIndex.ngO + "&bucket=" + zoneIndex.bucket, null, UpToken.nim, completionHandler);
    }

    ZoneInfo fN(String str, String str2) {
        return this.ngJ.get(new ZoneIndex(str, str2));
    }

    ZoneInfo QO(String str) {
        try {
            String[] split = str.split(":");
            return fN(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void a(final ZoneIndex zoneIndex, final Zone.QueryHandler queryHandler) {
        if (zoneIndex == null) {
            queryHandler.JA(-5);
        } else if (this.ngJ.get(zoneIndex) != null) {
            queryHandler.onSuccess();
        } else {
            a(zoneIndex, new CompletionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    if (responseInfo.dHW() && jSONObject != null) {
                        try {
                            AutoZone.this.ngJ.put(zoneIndex, ZoneInfo.ee(jSONObject));
                            queryHandler.onSuccess();
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            queryHandler.JA(-1);
                            return;
                        }
                    }
                    queryHandler.JA(responseInfo.statusCode);
                }
            });
        }
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized String d(String str, boolean z, String str2) {
        ZoneInfo QO;
        QO = QO(str);
        return QO != null ? super.a(QO, z, str2) : null;
    }

    @Override // com.qiniu.android.common.Zone
    public void a(String str, Zone.QueryHandler queryHandler) {
        a(ZoneIndex.QQ(str), queryHandler);
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized void QP(String str) {
        ZoneInfo zoneInfo;
        if (str != null) {
            String host = URI.create(str).getHost();
            Iterator<Map.Entry<ZoneIndex, ZoneInfo>> it = this.ngJ.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    zoneInfo = null;
                    break;
                }
                zoneInfo = it.next().getValue();
                if (zoneInfo.ngW.contains(host)) {
                    break;
                }
            }
            if (zoneInfo != null) {
                zoneInfo.QP(host);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class ZoneIndex {
        final String bucket;
        final String ngO;

        ZoneIndex(String str, String str2) {
            this.ngO = str;
            this.bucket = str2;
        }

        static ZoneIndex QQ(String str) {
            String[] split = str.split(":");
            try {
                return new ZoneIndex(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int hashCode() {
            return (this.ngO.hashCode() * 37) + this.bucket.hashCode();
        }

        public boolean equals(Object obj) {
            return obj == this || (obj != null && (obj instanceof ZoneIndex) && ((ZoneIndex) obj).ngO.equals(this.ngO) && ((ZoneIndex) obj).bucket.equals(this.bucket));
        }
    }
}
