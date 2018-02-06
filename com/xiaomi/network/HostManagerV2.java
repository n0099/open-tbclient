package com.xiaomi.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.coremedia.iso.boxes.UserBox;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.network.HostManager;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class HostManagerV2 extends HostManager {
    private final int a;
    private final int b;
    private int c;

    /* JADX INFO: Access modifiers changed from: protected */
    public HostManagerV2(Context context, HostFilter hostFilter, HostManager.HttpGet httpGet, String str) {
        this(context, hostFilter, httpGet, str, null, null);
    }

    protected HostManagerV2(Context context, HostFilter hostFilter, HostManager.HttpGet httpGet, String str, String str2, String str3) {
        super(context, hostFilter, httpGet, str, str2, str3);
        this.a = 80;
        this.b = 5222;
        this.c = 80;
        addReservedHost("resolver.msg.xiaomi.net", "resolver.msg.xiaomi.net:5222");
    }

    static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                if ((b & 240) != 240) {
                    bytes[i] = (byte) (((b & 15) ^ ((byte) (((b >> 4) + length) & 15))) | (b & 240));
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    protected JSONObject a() {
        JSONObject jSONObject;
        synchronized (this.mHostsMapping) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            jSONObject.put("data", toJSON());
        }
        return jSONObject;
    }

    protected void b(String str) {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                Fallbacks fromJSON = new Fallbacks().fromJSON(optJSONArray.getJSONObject(i));
                this.mHostsMapping.put(fromJSON.getHost(), fromJSON);
            }
        }
    }

    @Override // com.xiaomi.network.HostManager
    protected boolean checkHostMapping() {
        synchronized (this.mHostsMapping) {
            if (hostLoaded) {
                return true;
            }
            hostLoaded = true;
            this.mHostsMapping.clear();
            String loadHosts = loadHosts();
            if (TextUtils.isEmpty(loadHosts)) {
                return false;
            }
            b(loadHosts);
            com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
            return true;
        }
    }

    @Override // com.xiaomi.network.HostManager
    protected String getHost() {
        return "resolver.msg.xiaomi.net";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.network.HostManager
    public String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2) {
        ArrayList<String> a;
        String str3 = null;
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<com.xiaomi.channel.commonutils.network.c> arrayList3 = new ArrayList();
        arrayList3.add(new com.xiaomi.channel.commonutils.network.a("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new com.xiaomi.channel.commonutils.network.a("conpt", a(d.k(this.sAppContext))));
        }
        arrayList3.add(new com.xiaomi.channel.commonutils.network.a(UserBox.TYPE, str2));
        arrayList3.add(new com.xiaomi.channel.commonutils.network.a("list", join(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        Fallback localFallback = getLocalFallback("resolver.msg.xiaomi.net");
        String format = String.format(Locale.US, "http://%1$s/gslb/?ver=3.0", "resolver.msg.xiaomi.net:" + this.c);
        if (localFallback == null) {
            arrayList2.add(format);
            synchronized (mReservedHosts) {
                Iterator<String> it = mReservedHosts.get("resolver.msg.xiaomi.net").iterator();
                while (it.hasNext()) {
                    arrayList2.add(String.format(Locale.US, "http://%1$s/gslb/?ver=3.0", it.next()));
                }
            }
            a = arrayList2;
        } else {
            a = localFallback.a(format);
        }
        Iterator<String> it2 = a.iterator();
        IOException e = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (com.xiaomi.channel.commonutils.network.c cVar : arrayList3) {
                buildUpon.appendQueryParameter(cVar.a(), cVar.b());
            }
            try {
                str3 = this.sHttpGetter == null ? d.a(this.sAppContext, new URL(buildUpon.toString())) : this.sHttpGetter.a(buildUpon.toString());
                return str3;
            } catch (IOException e2) {
                e = e2;
            }
        }
        return e != null ? super.getRemoteFallbackJSON(arrayList, str, str2) : str3;
    }

    @Override // com.xiaomi.network.HostManager
    public void persist() {
        synchronized (this.mHostsMapping) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.sAppContext.openFileOutput(getProcessName(), 0)));
                String jSONObject = a().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a("persist bucket failure: " + e.getMessage());
            }
        }
    }

    @Override // com.xiaomi.network.HostManager
    public void purge() {
        synchronized (this.mHostsMapping) {
            for (Fallbacks fallbacks : this.mHostsMapping.values()) {
                fallbacks.purge(true);
            }
            boolean z = false;
            while (!z) {
                Iterator<String> it = this.mHostsMapping.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    String next = it.next();
                    if (this.mHostsMapping.get(next).getFallbacks().isEmpty()) {
                        this.mHostsMapping.remove(next);
                        z = false;
                        break;
                    }
                }
            }
        }
    }
}
