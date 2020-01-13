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
/* loaded from: classes4.dex */
public final class AutoZone extends Zone {
    public static final AutoZone nlZ = new AutoZone();
    private final String nma;
    private Map<ZoneIndex, ZoneInfo> nmb;
    private Client nmc;

    public AutoZone() {
        this("https://uc.qbox.me");
    }

    AutoZone(String str) {
        this.nmb = new ConcurrentHashMap();
        this.nmc = new Client();
        this.nma = str;
    }

    private void a(ZoneIndex zoneIndex, CompletionHandler completionHandler) {
        this.nmc.a(this.nma + "/v2/query?ak=" + zoneIndex.nmg + "&bucket=" + zoneIndex.bucket, null, UpToken.nnD, completionHandler);
    }

    ZoneInfo fo(String str, String str2) {
        return this.nmb.get(new ZoneIndex(str, str2));
    }

    ZoneInfo QY(String str) {
        try {
            String[] split = str.split(":");
            return fo(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void a(final ZoneIndex zoneIndex, final Zone.QueryHandler queryHandler) {
        if (zoneIndex == null) {
            queryHandler.Nk(-5);
        } else if (this.nmb.get(zoneIndex) != null) {
            queryHandler.onSuccess();
        } else {
            a(zoneIndex, new CompletionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    if (responseInfo.dED() && jSONObject != null) {
                        try {
                            AutoZone.this.nmb.put(zoneIndex, ZoneInfo.dU(jSONObject));
                            queryHandler.onSuccess();
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            queryHandler.Nk(-1);
                            return;
                        }
                    }
                    queryHandler.Nk(responseInfo.statusCode);
                }
            });
        }
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized String d(String str, boolean z, String str2) {
        ZoneInfo QY;
        QY = QY(str);
        return QY != null ? super.a(QY, z, str2) : null;
    }

    @Override // com.qiniu.android.common.Zone
    public void a(String str, Zone.QueryHandler queryHandler) {
        a(ZoneIndex.Ra(str), queryHandler);
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized void QZ(String str) {
        ZoneInfo zoneInfo;
        if (str != null) {
            String host = URI.create(str).getHost();
            Iterator<Map.Entry<ZoneIndex, ZoneInfo>> it = this.nmb.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    zoneInfo = null;
                    break;
                }
                zoneInfo = it.next().getValue();
                if (zoneInfo.nmo.contains(host)) {
                    break;
                }
            }
            if (zoneInfo != null) {
                zoneInfo.QZ(host);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class ZoneIndex {
        final String bucket;
        final String nmg;

        ZoneIndex(String str, String str2) {
            this.nmg = str;
            this.bucket = str2;
        }

        static ZoneIndex Ra(String str) {
            String[] split = str.split(":");
            try {
                return new ZoneIndex(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int hashCode() {
            return (this.nmg.hashCode() * 37) + this.bucket.hashCode();
        }

        public boolean equals(Object obj) {
            return obj == this || (obj != null && (obj instanceof ZoneIndex) && ((ZoneIndex) obj).nmg.equals(this.nmg) && ((ZoneIndex) obj).bucket.equals(this.bucket));
        }
    }
}
