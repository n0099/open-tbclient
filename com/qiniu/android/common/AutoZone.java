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
    public static final AutoZone nCA = new AutoZone();
    private final String nCB;
    private Map<ZoneIndex, ZoneInfo> nCC;
    private Client nCD;

    public AutoZone() {
        this("https://uc.qbox.me");
    }

    AutoZone(String str) {
        this.nCC = new ConcurrentHashMap();
        this.nCD = new Client();
        this.nCB = str;
    }

    private void a(ZoneIndex zoneIndex, CompletionHandler completionHandler) {
        this.nCD.a(this.nCB + "/v2/query?ak=" + zoneIndex.nCH + "&bucket=" + zoneIndex.bucket, null, UpToken.nEe, completionHandler);
    }

    ZoneInfo fX(String str, String str2) {
        return this.nCC.get(new ZoneIndex(str, str2));
    }

    ZoneInfo RB(String str) {
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
        } else if (this.nCC.get(zoneIndex) != null) {
            queryHandler.onSuccess();
        } else {
            a(zoneIndex, new CompletionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    if (responseInfo.dMG() && jSONObject != null) {
                        try {
                            AutoZone.this.nCC.put(zoneIndex, ZoneInfo.eo(jSONObject));
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
        ZoneInfo RB;
        RB = RB(str);
        return RB != null ? super.a(RB, z, str2) : null;
    }

    @Override // com.qiniu.android.common.Zone
    public void a(String str, Zone.QueryHandler queryHandler) {
        a(ZoneIndex.RD(str), queryHandler);
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized void RC(String str) {
        ZoneInfo zoneInfo;
        if (str != null) {
            String host = URI.create(str).getHost();
            Iterator<Map.Entry<ZoneIndex, ZoneInfo>> it = this.nCC.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    zoneInfo = null;
                    break;
                }
                zoneInfo = it.next().getValue();
                if (zoneInfo.nCP.contains(host)) {
                    break;
                }
            }
            if (zoneInfo != null) {
                zoneInfo.RC(host);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class ZoneIndex {
        final String bucket;
        final String nCH;

        ZoneIndex(String str, String str2) {
            this.nCH = str;
            this.bucket = str2;
        }

        static ZoneIndex RD(String str) {
            String[] split = str.split(":");
            try {
                return new ZoneIndex(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int hashCode() {
            return (this.nCH.hashCode() * 37) + this.bucket.hashCode();
        }

        public boolean equals(Object obj) {
            return obj == this || (obj != null && (obj instanceof ZoneIndex) && ((ZoneIndex) obj).nCH.equals(this.nCH) && ((ZoneIndex) obj).bucket.equals(this.bucket));
        }
    }
}
