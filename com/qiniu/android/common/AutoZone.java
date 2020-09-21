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
    public static final AutoZone ope = new AutoZone();
    private final String opf;
    private Map<ZoneIndex, ZoneInfo> opg;
    private Client oph;

    public AutoZone() {
        this("https://uc.qbox.me");
    }

    AutoZone(String str) {
        this.opg = new ConcurrentHashMap();
        this.oph = new Client();
        this.opf = str;
    }

    private void a(ZoneIndex zoneIndex, CompletionHandler completionHandler) {
        this.oph.a(this.opf + "/v2/query?ak=" + zoneIndex.opl + "&bucket=" + zoneIndex.bucket, null, UpToken.oqJ, completionHandler);
    }

    ZoneInfo gD(String str, String str2) {
        return this.opg.get(new ZoneIndex(str, str2));
    }

    ZoneInfo VS(String str) {
        try {
            String[] split = str.split(":");
            return gD(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void a(final ZoneIndex zoneIndex, final Zone.QueryHandler queryHandler) {
        if (zoneIndex == null) {
            queryHandler.onFailure(-5);
        } else if (this.opg.get(zoneIndex) != null) {
            queryHandler.onSuccess();
        } else {
            a(zoneIndex, new CompletionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    if (responseInfo.egl() && jSONObject != null) {
                        try {
                            AutoZone.this.opg.put(zoneIndex, ZoneInfo.eO(jSONObject));
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
        ZoneInfo VS;
        VS = VS(str);
        return VS != null ? super.a(VS, z, str2) : null;
    }

    @Override // com.qiniu.android.common.Zone
    public void a(String str, Zone.QueryHandler queryHandler) {
        a(ZoneIndex.VU(str), queryHandler);
    }

    @Override // com.qiniu.android.common.Zone
    public synchronized void VT(String str) {
        ZoneInfo zoneInfo;
        if (str != null) {
            String host = URI.create(str).getHost();
            Iterator<Map.Entry<ZoneIndex, ZoneInfo>> it = this.opg.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    zoneInfo = null;
                    break;
                }
                zoneInfo = it.next().getValue();
                if (zoneInfo.opu.contains(host)) {
                    break;
                }
            }
            if (zoneInfo != null) {
                zoneInfo.VT(host);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ZoneIndex {
        final String bucket;
        final String opl;

        ZoneIndex(String str, String str2) {
            this.opl = str;
            this.bucket = str2;
        }

        static ZoneIndex VU(String str) {
            String[] split = str.split(":");
            try {
                return new ZoneIndex(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int hashCode() {
            return (this.opl.hashCode() * 37) + this.bucket.hashCode();
        }

        public boolean equals(Object obj) {
            return obj == this || (obj != null && (obj instanceof ZoneIndex) && ((ZoneIndex) obj).opl.equals(this.opl) && ((ZoneIndex) obj).bucket.equals(this.bucket));
        }
    }
}
