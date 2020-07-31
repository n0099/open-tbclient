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
    public static final AutoZone nLi = new AutoZone();
    private final String nLj;
    private Map<ZoneIndex, ZoneInfo> nLk;
    private Client nLl;

    public AutoZone() {
        this("https://uc.qbox.me");
    }

    AutoZone(String str) {
        this.nLk = new ConcurrentHashMap();
        this.nLl = new Client();
        this.nLj = str;
    }

    private void a(ZoneIndex zoneIndex, CompletionHandler completionHandler) {
        this.nLl.a(this.nLj + "/v2/query?ak=" + zoneIndex.nLp + "&bucket=" + zoneIndex.bucket, null, UpToken.nMM, completionHandler);
    }

    ZoneInfo fZ(String str, String str2) {
        return this.nLk.get(new ZoneIndex(str, str2));
    }

    ZoneInfo Sm(String str) {
        try {
            String[] split = str.split(":");
            return fZ(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void a(final ZoneIndex zoneIndex, final Zone.QueryHandler queryHandler) {
        if (zoneIndex == null) {
            queryHandler.Lb(-5);
        } else if (this.nLk.get(zoneIndex) != null) {
            queryHandler.onSuccess();
        } else {
            a(zoneIndex, new CompletionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    if (responseInfo.dQc() && jSONObject != null) {
                        try {
                            AutoZone.this.nLk.put(zoneIndex, ZoneInfo.ev(jSONObject));
                            queryHandler.onSuccess();
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            queryHandler.Lb(-1);
                            return;
                        }
                    }
                    queryHandler.Lb(responseInfo.statusCode);
                }
            });
        }
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized String d(String str, boolean z, String str2) {
        ZoneInfo Sm;
        Sm = Sm(str);
        return Sm != null ? super.a(Sm, z, str2) : null;
    }

    @Override // com.qiniu.android.common.Zone
    public void a(String str, Zone.QueryHandler queryHandler) {
        a(ZoneIndex.So(str), queryHandler);
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized void Sn(String str) {
        ZoneInfo zoneInfo;
        if (str != null) {
            String host = URI.create(str).getHost();
            Iterator<Map.Entry<ZoneIndex, ZoneInfo>> it = this.nLk.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    zoneInfo = null;
                    break;
                }
                zoneInfo = it.next().getValue();
                if (zoneInfo.nLx.contains(host)) {
                    break;
                }
            }
            if (zoneInfo != null) {
                zoneInfo.Sn(host);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ZoneIndex {
        final String bucket;
        final String nLp;

        ZoneIndex(String str, String str2) {
            this.nLp = str;
            this.bucket = str2;
        }

        static ZoneIndex So(String str) {
            String[] split = str.split(":");
            try {
                return new ZoneIndex(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int hashCode() {
            return (this.nLp.hashCode() * 37) + this.bucket.hashCode();
        }

        public boolean equals(Object obj) {
            return obj == this || (obj != null && (obj instanceof ZoneIndex) && ((ZoneIndex) obj).nLp.equals(this.nLp) && ((ZoneIndex) obj).bucket.equals(this.bucket));
        }
    }
}
