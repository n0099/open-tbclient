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
/* loaded from: classes6.dex */
public final class AutoZone extends Zone {
    public static final AutoZone pFm = new AutoZone();
    private final String pFn;
    private Map<ZoneIndex, ZoneInfo> pFo;
    private Client pFp;

    public AutoZone() {
        this("https://uc.qbox.me");
    }

    AutoZone(String str) {
        this.pFo = new ConcurrentHashMap();
        this.pFp = new Client();
        this.pFn = str;
    }

    private void a(ZoneIndex zoneIndex, CompletionHandler completionHandler) {
        this.pFp.a(this.pFn + "/v2/query?ak=" + zoneIndex.pFt + "&bucket=" + zoneIndex.bucket, null, UpToken.pGQ, completionHandler);
    }

    ZoneInfo hc(String str, String str2) {
        return this.pFo.get(new ZoneIndex(str, str2));
    }

    ZoneInfo YX(String str) {
        try {
            String[] split = str.split(":");
            return hc(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void a(final ZoneIndex zoneIndex, final Zone.QueryHandler queryHandler) {
        if (zoneIndex == null) {
            queryHandler.onFailure(-5);
        } else if (this.pFo.get(zoneIndex) != null) {
            queryHandler.onSuccess();
        } else {
            a(zoneIndex, new CompletionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    if (responseInfo.exL() && jSONObject != null) {
                        try {
                            AutoZone.this.pFo.put(zoneIndex, ZoneInfo.fg(jSONObject));
                            queryHandler.onSuccess();
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            queryHandler.onFailure(-1);
                            return;
                        }
                    }
                    queryHandler.onFailure(responseInfo.statusCode);
                }
            });
        }
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized String d(String str, boolean z, String str2) {
        ZoneInfo YX;
        YX = YX(str);
        return YX != null ? super.a(YX, z, str2) : null;
    }

    @Override // com.qiniu.android.common.Zone
    public void a(String str, Zone.QueryHandler queryHandler) {
        a(ZoneIndex.YZ(str), queryHandler);
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized void YY(String str) {
        ZoneInfo zoneInfo;
        if (str != null) {
            String host = URI.create(str).getHost();
            Iterator<Map.Entry<ZoneIndex, ZoneInfo>> it = this.pFo.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    zoneInfo = null;
                    break;
                }
                zoneInfo = it.next().getValue();
                if (zoneInfo.pFB.contains(host)) {
                    break;
                }
            }
            if (zoneInfo != null) {
                zoneInfo.YY(host);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ZoneIndex {
        final String bucket;
        final String pFt;

        ZoneIndex(String str, String str2) {
            this.pFt = str;
            this.bucket = str2;
        }

        static ZoneIndex YZ(String str) {
            String[] split = str.split(":");
            try {
                return new ZoneIndex(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int hashCode() {
            return (this.pFt.hashCode() * 37) + this.bucket.hashCode();
        }

        public boolean equals(Object obj) {
            return obj == this || (obj != null && (obj instanceof ZoneIndex) && ((ZoneIndex) obj).pFt.equals(this.pFt) && ((ZoneIndex) obj).bucket.equals(this.bucket));
        }
    }
}
