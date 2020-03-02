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
    public static final AutoZone nmH = new AutoZone();
    private final String nmI;
    private Map<ZoneIndex, ZoneInfo> nmJ;
    private Client nmK;

    public AutoZone() {
        this("https://uc.qbox.me");
    }

    AutoZone(String str) {
        this.nmJ = new ConcurrentHashMap();
        this.nmK = new Client();
        this.nmI = str;
    }

    private void a(ZoneIndex zoneIndex, CompletionHandler completionHandler) {
        this.nmK.a(this.nmI + "/v2/query?ak=" + zoneIndex.nmO + "&bucket=" + zoneIndex.bucket, null, UpToken.nol, completionHandler);
    }

    ZoneInfo fw(String str, String str2) {
        return this.nmJ.get(new ZoneIndex(str, str2));
    }

    ZoneInfo Rj(String str) {
        try {
            String[] split = str.split(":");
            return fw(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void a(final ZoneIndex zoneIndex, final Zone.QueryHandler queryHandler) {
        if (zoneIndex == null) {
            queryHandler.Nn(-5);
        } else if (this.nmJ.get(zoneIndex) != null) {
            queryHandler.onSuccess();
        } else {
            a(zoneIndex, new CompletionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    if (responseInfo.dFO() && jSONObject != null) {
                        try {
                            AutoZone.this.nmJ.put(zoneIndex, ZoneInfo.dU(jSONObject));
                            queryHandler.onSuccess();
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            queryHandler.Nn(-1);
                            return;
                        }
                    }
                    queryHandler.Nn(responseInfo.statusCode);
                }
            });
        }
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized String d(String str, boolean z, String str2) {
        ZoneInfo Rj;
        Rj = Rj(str);
        return Rj != null ? super.a(Rj, z, str2) : null;
    }

    @Override // com.qiniu.android.common.Zone
    public void a(String str, Zone.QueryHandler queryHandler) {
        a(ZoneIndex.Rl(str), queryHandler);
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized void Rk(String str) {
        ZoneInfo zoneInfo;
        if (str != null) {
            String host = URI.create(str).getHost();
            Iterator<Map.Entry<ZoneIndex, ZoneInfo>> it = this.nmJ.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    zoneInfo = null;
                    break;
                }
                zoneInfo = it.next().getValue();
                if (zoneInfo.nmW.contains(host)) {
                    break;
                }
            }
            if (zoneInfo != null) {
                zoneInfo.Rk(host);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class ZoneIndex {
        final String bucket;
        final String nmO;

        ZoneIndex(String str, String str2) {
            this.nmO = str;
            this.bucket = str2;
        }

        static ZoneIndex Rl(String str) {
            String[] split = str.split(":");
            try {
                return new ZoneIndex(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int hashCode() {
            return (this.nmO.hashCode() * 37) + this.bucket.hashCode();
        }

        public boolean equals(Object obj) {
            return obj == this || (obj != null && (obj instanceof ZoneIndex) && ((ZoneIndex) obj).nmO.equals(this.nmO) && ((ZoneIndex) obj).bucket.equals(this.bucket));
        }
    }
}
