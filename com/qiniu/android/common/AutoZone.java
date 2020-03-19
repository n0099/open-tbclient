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
    public static final AutoZone noH = new AutoZone();
    private final String noI;
    private Map<ZoneIndex, ZoneInfo> noJ;
    private Client noK;

    public AutoZone() {
        this("https://uc.qbox.me");
    }

    AutoZone(String str) {
        this.noJ = new ConcurrentHashMap();
        this.noK = new Client();
        this.noI = str;
    }

    private void a(ZoneIndex zoneIndex, CompletionHandler completionHandler) {
        this.noK.a(this.noI + "/v2/query?ak=" + zoneIndex.noO + "&bucket=" + zoneIndex.bucket, null, UpToken.nql, completionHandler);
    }

    ZoneInfo fu(String str, String str2) {
        return this.noJ.get(new ZoneIndex(str, str2));
    }

    ZoneInfo Rk(String str) {
        try {
            String[] split = str.split(":");
            return fu(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void a(final ZoneIndex zoneIndex, final Zone.QueryHandler queryHandler) {
        if (zoneIndex == null) {
            queryHandler.Nt(-5);
        } else if (this.noJ.get(zoneIndex) != null) {
            queryHandler.onSuccess();
        } else {
            a(zoneIndex, new CompletionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    if (responseInfo.dGp() && jSONObject != null) {
                        try {
                            AutoZone.this.noJ.put(zoneIndex, ZoneInfo.dU(jSONObject));
                            queryHandler.onSuccess();
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            queryHandler.Nt(-1);
                            return;
                        }
                    }
                    queryHandler.Nt(responseInfo.statusCode);
                }
            });
        }
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized String d(String str, boolean z, String str2) {
        ZoneInfo Rk;
        Rk = Rk(str);
        return Rk != null ? super.a(Rk, z, str2) : null;
    }

    @Override // com.qiniu.android.common.Zone
    public void a(String str, Zone.QueryHandler queryHandler) {
        a(ZoneIndex.Rm(str), queryHandler);
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized void Rl(String str) {
        ZoneInfo zoneInfo;
        if (str != null) {
            String host = URI.create(str).getHost();
            Iterator<Map.Entry<ZoneIndex, ZoneInfo>> it = this.noJ.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    zoneInfo = null;
                    break;
                }
                zoneInfo = it.next().getValue();
                if (zoneInfo.noW.contains(host)) {
                    break;
                }
            }
            if (zoneInfo != null) {
                zoneInfo.Rl(host);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class ZoneIndex {
        final String bucket;
        final String noO;

        ZoneIndex(String str, String str2) {
            this.noO = str;
            this.bucket = str2;
        }

        static ZoneIndex Rm(String str) {
            String[] split = str.split(":");
            try {
                return new ZoneIndex(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int hashCode() {
            return (this.noO.hashCode() * 37) + this.bucket.hashCode();
        }

        public boolean equals(Object obj) {
            return obj == this || (obj != null && (obj instanceof ZoneIndex) && ((ZoneIndex) obj).noO.equals(this.noO) && ((ZoneIndex) obj).bucket.equals(this.bucket));
        }
    }
}
