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
    public static final AutoZone nfx = new AutoZone();
    private Client nfA;
    private final String nfy;
    private Map<ZoneIndex, ZoneInfo> nfz;

    public AutoZone() {
        this("https://uc.qbox.me");
    }

    AutoZone(String str) {
        this.nfz = new ConcurrentHashMap();
        this.nfA = new Client();
        this.nfy = str;
    }

    private void a(ZoneIndex zoneIndex, CompletionHandler completionHandler) {
        this.nfA.a(this.nfy + "/v2/query?ak=" + zoneIndex.nfE + "&bucket=" + zoneIndex.bucket, null, UpToken.nhb, completionHandler);
    }

    ZoneInfo fN(String str, String str2) {
        return this.nfz.get(new ZoneIndex(str, str2));
    }

    ZoneInfo QN(String str) {
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
            queryHandler.Jy(-5);
        } else if (this.nfz.get(zoneIndex) != null) {
            queryHandler.onSuccess();
        } else {
            a(zoneIndex, new CompletionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    if (responseInfo.dHI() && jSONObject != null) {
                        try {
                            AutoZone.this.nfz.put(zoneIndex, ZoneInfo.ee(jSONObject));
                            queryHandler.onSuccess();
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            queryHandler.Jy(-1);
                            return;
                        }
                    }
                    queryHandler.Jy(responseInfo.statusCode);
                }
            });
        }
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized String d(String str, boolean z, String str2) {
        ZoneInfo QN;
        QN = QN(str);
        return QN != null ? super.a(QN, z, str2) : null;
    }

    @Override // com.qiniu.android.common.Zone
    public void a(String str, Zone.QueryHandler queryHandler) {
        a(ZoneIndex.QP(str), queryHandler);
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized void QO(String str) {
        ZoneInfo zoneInfo;
        if (str != null) {
            String host = URI.create(str).getHost();
            Iterator<Map.Entry<ZoneIndex, ZoneInfo>> it = this.nfz.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    zoneInfo = null;
                    break;
                }
                zoneInfo = it.next().getValue();
                if (zoneInfo.nfM.contains(host)) {
                    break;
                }
            }
            if (zoneInfo != null) {
                zoneInfo.QO(host);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class ZoneIndex {
        final String bucket;
        final String nfE;

        ZoneIndex(String str, String str2) {
            this.nfE = str;
            this.bucket = str2;
        }

        static ZoneIndex QP(String str) {
            String[] split = str.split(":");
            try {
                return new ZoneIndex(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int hashCode() {
            return (this.nfE.hashCode() * 37) + this.bucket.hashCode();
        }

        public boolean equals(Object obj) {
            return obj == this || (obj != null && (obj instanceof ZoneIndex) && ((ZoneIndex) obj).nfE.equals(this.nfE) && ((ZoneIndex) obj).bucket.equals(this.bucket));
        }
    }
}
