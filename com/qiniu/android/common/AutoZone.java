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
    public static final AutoZone nCx = new AutoZone();
    private Client nCA;
    private final String nCy;
    private Map<ZoneIndex, ZoneInfo> nCz;

    public AutoZone() {
        this("https://uc.qbox.me");
    }

    AutoZone(String str) {
        this.nCz = new ConcurrentHashMap();
        this.nCA = new Client();
        this.nCy = str;
    }

    private void a(ZoneIndex zoneIndex, CompletionHandler completionHandler) {
        this.nCA.a(this.nCy + "/v2/query?ak=" + zoneIndex.nCE + "&bucket=" + zoneIndex.bucket, null, UpToken.nEb, completionHandler);
    }

    ZoneInfo fX(String str, String str2) {
        return this.nCz.get(new ZoneIndex(str, str2));
    }

    ZoneInfo RA(String str) {
        try {
            String[] split = str.split(":");
            return fX(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void a(final ZoneIndex zoneIndex, final Zone.QueryHandler queryHandler) {
        if (zoneIndex == null) {
            queryHandler.KH(-5);
        } else if (this.nCz.get(zoneIndex) != null) {
            queryHandler.onSuccess();
        } else {
            a(zoneIndex, new CompletionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    if (responseInfo.dMC() && jSONObject != null) {
                        try {
                            AutoZone.this.nCz.put(zoneIndex, ZoneInfo.eo(jSONObject));
                            queryHandler.onSuccess();
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            queryHandler.KH(-1);
                            return;
                        }
                    }
                    queryHandler.KH(responseInfo.statusCode);
                }
            });
        }
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized String d(String str, boolean z, String str2) {
        ZoneInfo RA;
        RA = RA(str);
        return RA != null ? super.a(RA, z, str2) : null;
    }

    @Override // com.qiniu.android.common.Zone
    public void a(String str, Zone.QueryHandler queryHandler) {
        a(ZoneIndex.RC(str), queryHandler);
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized void RB(String str) {
        ZoneInfo zoneInfo;
        if (str != null) {
            String host = URI.create(str).getHost();
            Iterator<Map.Entry<ZoneIndex, ZoneInfo>> it = this.nCz.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    zoneInfo = null;
                    break;
                }
                zoneInfo = it.next().getValue();
                if (zoneInfo.nCM.contains(host)) {
                    break;
                }
            }
            if (zoneInfo != null) {
                zoneInfo.RB(host);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class ZoneIndex {
        final String bucket;
        final String nCE;

        ZoneIndex(String str, String str2) {
            this.nCE = str;
            this.bucket = str2;
        }

        static ZoneIndex RC(String str) {
            String[] split = str.split(":");
            try {
                return new ZoneIndex(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int hashCode() {
            return (this.nCE.hashCode() * 37) + this.bucket.hashCode();
        }

        public boolean equals(Object obj) {
            return obj == this || (obj != null && (obj instanceof ZoneIndex) && ((ZoneIndex) obj).nCE.equals(this.nCE) && ((ZoneIndex) obj).bucket.equals(this.bucket));
        }
    }
}
