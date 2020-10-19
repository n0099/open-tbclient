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
    public static final AutoZone oEw = new AutoZone();
    private final String oEx;
    private Map<ZoneIndex, ZoneInfo> oEy;
    private Client oEz;

    public AutoZone() {
        this("https://uc.qbox.me");
    }

    AutoZone(String str) {
        this.oEy = new ConcurrentHashMap();
        this.oEz = new Client();
        this.oEx = str;
    }

    private void a(ZoneIndex zoneIndex, CompletionHandler completionHandler) {
        this.oEz.a(this.oEx + "/v2/query?ak=" + zoneIndex.oED + "&bucket=" + zoneIndex.bucket, null, UpToken.oGa, completionHandler);
    }

    ZoneInfo gK(String str, String str2) {
        return this.oEy.get(new ZoneIndex(str, str2));
    }

    ZoneInfo WG(String str) {
        try {
            String[] split = str.split(":");
            return gK(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void a(final ZoneIndex zoneIndex, final Zone.QueryHandler queryHandler) {
        if (zoneIndex == null) {
            queryHandler.onFailure(-5);
        } else if (this.oEy.get(zoneIndex) != null) {
            queryHandler.onSuccess();
        } else {
            a(zoneIndex, new CompletionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    if (responseInfo.ejW() && jSONObject != null) {
                        try {
                            AutoZone.this.oEy.put(zoneIndex, ZoneInfo.eS(jSONObject));
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
        ZoneInfo WG;
        WG = WG(str);
        return WG != null ? super.a(WG, z, str2) : null;
    }

    @Override // com.qiniu.android.common.Zone
    public void a(String str, Zone.QueryHandler queryHandler) {
        a(ZoneIndex.WI(str), queryHandler);
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized void WH(String str) {
        ZoneInfo zoneInfo;
        if (str != null) {
            String host = URI.create(str).getHost();
            Iterator<Map.Entry<ZoneIndex, ZoneInfo>> it = this.oEy.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    zoneInfo = null;
                    break;
                }
                zoneInfo = it.next().getValue();
                if (zoneInfo.oEL.contains(host)) {
                    break;
                }
            }
            if (zoneInfo != null) {
                zoneInfo.WH(host);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ZoneIndex {
        final String bucket;
        final String oED;

        ZoneIndex(String str, String str2) {
            this.oED = str;
            this.bucket = str2;
        }

        static ZoneIndex WI(String str) {
            String[] split = str.split(":");
            try {
                return new ZoneIndex(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int hashCode() {
            return (this.oED.hashCode() * 37) + this.bucket.hashCode();
        }

        public boolean equals(Object obj) {
            return obj == this || (obj != null && (obj instanceof ZoneIndex) && ((ZoneIndex) obj).oED.equals(this.oED) && ((ZoneIndex) obj).bucket.equals(this.bucket));
        }
    }
}
