package com.xiaomi.network;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.coremedia.iso.boxes.UserBox;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.module.PushChannelRegion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HostManager {
    private static HostManagerFactory factory;
    protected static Context sAppContext;
    private static String sAppName;
    private static String sAppVersion;
    private static HostManager sInstance;
    private final long MAX_REQUEST_FAILURE_CNT;
    private String currentISP;
    private long lastRemoteRequestTimestamp;
    protected Map<String, Fallbacks> mHostsMapping;
    private long remoteRequestFailureCount;
    private HostFilter sHostFilter;
    protected HttpGet sHttpGetter;
    private String sUserId;
    protected static Map<String, Fallback> sReservedHosts = new HashMap();
    protected static boolean hostLoaded = false;

    /* loaded from: classes3.dex */
    public interface HostManagerFactory {
        HostManager a(Context context, HostFilter hostFilter, HttpGet httpGet, String str);
    }

    /* loaded from: classes3.dex */
    public interface HttpGet {
        String a(String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HostManager(Context context, HostFilter hostFilter, HttpGet httpGet, String str) {
        this(context, hostFilter, httpGet, str, null, null);
    }

    protected HostManager(Context context, HostFilter hostFilter, HttpGet httpGet, String str, String str2, String str3) {
        this.mHostsMapping = new HashMap();
        this.sUserId = "0";
        this.remoteRequestFailureCount = 0L;
        this.MAX_REQUEST_FAILURE_CNT = 15L;
        this.lastRemoteRequestTimestamp = 0L;
        this.currentISP = "isp_prov_city_country_ip";
        this.sHttpGetter = httpGet;
        if (hostFilter == null) {
            this.sHostFilter = new a(this);
        } else {
            this.sHostFilter = hostFilter;
        }
        this.sUserId = str;
        sAppName = str2 == null ? context.getPackageName() : str2;
        sAppVersion = str3 == null ? getVersionName() : str3;
    }

    public static void addReservedHost(String str, String str2) {
        Fallback fallback = sReservedHosts.get(str);
        synchronized (sReservedHosts) {
            if (fallback == null) {
                Fallback fallback2 = new Fallback(str);
                fallback2.a(604800000L);
                fallback2.b(str2);
                sReservedHosts.put(str, fallback2);
            } else {
                fallback.b(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007c -> B:23:0x0007). Please submit an issue!!! */
    public static String getActiveNetworkLabel() {
        String str;
        ConnectivityManager connectivityManager;
        if (sAppContext == null) {
            return "unknown";
        }
        try {
            connectivityManager = (ConnectivityManager) sAppContext.getSystemService("connectivity");
        } catch (Throwable th) {
        }
        if (connectivityManager == null) {
            str = "unknown";
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                str = "unknown";
            } else if (activeNetworkInfo.getType() == 1) {
                WifiManager wifiManager = (WifiManager) sAppContext.getSystemService("wifi");
                if (wifiManager != null && wifiManager.getConnectionInfo() != null) {
                    str = "WIFI-" + wifiManager.getConnectionInfo().getSSID();
                }
                str = "unknown";
            } else {
                str = activeNetworkInfo.getTypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName();
            }
        }
        return str;
    }

    public static synchronized HostManager getInstance() {
        HostManager hostManager;
        synchronized (HostManager.class) {
            if (sInstance == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
            hostManager = sInstance;
        }
        return hostManager;
    }

    private String getVersionName() {
        try {
            PackageInfo packageInfo = sAppContext.getPackageManager().getPackageInfo(sAppContext.getPackageName(), 16384);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Exception e) {
        }
        return "0";
    }

    public static synchronized void init(Context context, HostFilter hostFilter, HttpGet httpGet, String str, String str2, String str3) {
        synchronized (HostManager.class) {
            sAppContext = context.getApplicationContext();
            if (sAppContext == null) {
                sAppContext = context;
            }
            if (sInstance == null) {
                if (factory == null) {
                    sInstance = new HostManager(context, hostFilter, httpGet, str, str2, str3);
                } else {
                    sInstance = factory.a(context, hostFilter, httpGet, str);
                }
            }
        }
    }

    static String obfuscate(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes(HTTP.UTF_8);
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

    private ArrayList<Fallback> requestRemoteFallbacks(ArrayList<String> arrayList) {
        purge();
        synchronized (this.mHostsMapping) {
            checkHostMapping();
            for (String str : this.mHostsMapping.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        boolean isEmpty = sReservedHosts.isEmpty();
        synchronized (sReservedHosts) {
            Object[] array = sReservedHosts.values().toArray();
            int length = array.length;
            int i = 0;
            while (i < length) {
                Fallback fallback = (Fallback) array[i];
                if (!fallback.b()) {
                    isEmpty = true;
                    sReservedHosts.remove(fallback.b);
                }
                i++;
                isEmpty = isEmpty;
            }
        }
        if (!arrayList.contains(getHost())) {
            arrayList.add(getHost());
        }
        ArrayList<Fallback> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(null);
        }
        try {
            String str2 = d.e(sAppContext) ? "wifi" : "wap";
            String remoteFallbackJSON = getRemoteFallbackJSON(arrayList, str2, this.sUserId, isEmpty);
            if (!TextUtils.isEmpty(remoteFallbackJSON)) {
                JSONObject jSONObject = new JSONObject(remoteFallbackJSON);
                com.xiaomi.channel.commonutils.logger.b.b(remoteFallbackJSON);
                if ("OK".equalsIgnoreCase(jSONObject.getString("S"))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("R");
                    String string = jSONObject2.getString("province");
                    String string2 = jSONObject2.getString("city");
                    String string3 = jSONObject2.getString("isp");
                    String string4 = jSONObject2.getString("ip");
                    String string5 = jSONObject2.getString("country");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(str2);
                    if (str2.equals("wap")) {
                        str2 = getActiveNetworkLabel();
                    }
                    com.xiaomi.channel.commonutils.logger.b.c("get bucket: ip = " + string4 + " net = " + string3 + str2 + " hosts = " + jSONObject3.toString());
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        String str3 = arrayList.get(i3);
                        JSONArray optJSONArray = jSONObject3.optJSONArray(str3);
                        if (optJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.b.a("no bucket found for " + str3);
                        } else {
                            Fallback fallback2 = new Fallback(str3);
                            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                String string6 = optJSONArray.getString(i4);
                                if (!TextUtils.isEmpty(string6)) {
                                    fallback2.a(new c(string6, optJSONArray.length() - i4));
                                }
                            }
                            arrayList2.set(i3, fallback2);
                            fallback2.g = string5;
                            fallback2.c = string;
                            fallback2.e = string3;
                            fallback2.f = string4;
                            fallback2.d = string2;
                            if (jSONObject2.has("stat-percent")) {
                                fallback2.a(jSONObject2.getDouble("stat-percent"));
                            }
                            if (jSONObject2.has("stat-domain")) {
                                fallback2.c(jSONObject2.getString("stat-domain"));
                            }
                            if (jSONObject2.has("ttl")) {
                                fallback2.a(jSONObject2.getInt("ttl") * 1000);
                            }
                            setCurrentISP(fallback2.e());
                        }
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j = jSONObject2.has("reserved-ttl") ? jSONObject2.getInt("reserved-ttl") * 1000 : 604800000L;
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                com.xiaomi.channel.commonutils.logger.b.a("no bucket found for " + next);
                            } else {
                                Fallback fallback3 = new Fallback(next);
                                fallback3.a(j);
                                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                    String string7 = optJSONArray2.getString(i5);
                                    if (!TextUtils.isEmpty(string7)) {
                                        fallback3.a(new c(string7, optJSONArray2.length() - i5));
                                    }
                                }
                                synchronized (sReservedHosts) {
                                    if (this.sHostFilter.a(next)) {
                                        sReservedHosts.put(next, fallback3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("failed to get bucket " + e.getMessage());
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= arrayList.size()) {
                persist();
                return arrayList2;
            }
            Fallback fallback4 = arrayList2.get(i7);
            if (fallback4 != null) {
                updateFallbacks(arrayList.get(i7), fallback4);
            }
            i6 = i7 + 1;
        }
    }

    public static synchronized void setHostManagerFactory(HostManagerFactory hostManagerFactory) {
        synchronized (HostManager.class) {
            factory = hostManagerFactory;
            sInstance = null;
        }
    }

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
            fromJSON(loadHosts);
            com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
            return true;
        }
    }

    public void clear() {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
        }
    }

    public String dump() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.mHostsMapping) {
            for (Map.Entry<String, Fallbacks> entry : this.mHostsMapping.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    protected void fromJSON(String str) {
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
            JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                Fallback a = new Fallback("").a(optJSONArray2.getJSONObject(i2));
                sReservedHosts.put(a.b, a);
            }
        }
    }

    public Fallback getFallbacksByHost(String str) {
        return getFallbacksByHost(str, true);
    }

    public Fallback getFallbacksByHost(String str, boolean z) {
        Fallback requestRemoteFallback;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        if (this.sHostFilter.a(str)) {
            Fallback localFallback = getLocalFallback(str);
            return (localFallback == null || !localFallback.b()) ? (z && d.c(sAppContext) && (requestRemoteFallback = requestRemoteFallback(str)) != null) ? requestRemoteFallback : new b(this, str, localFallback) : localFallback;
        }
        return null;
    }

    public Fallback getFallbacksByURL(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty");
        }
        return getFallbacksByHost(new URL(str).getHost(), true);
    }

    protected String getHost() {
        String a = com.xiaomi.push.service.a.a(sAppContext).a();
        return (TextUtils.isEmpty(a) || !PushChannelRegion.Europe.name().equals(a)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
    }

    protected Fallback getLocalFallback(String str) {
        Fallbacks fallbacks;
        Fallback fallback;
        synchronized (this.mHostsMapping) {
            checkHostMapping();
            fallbacks = this.mHostsMapping.get(str);
        }
        if (fallbacks == null || (fallback = fallbacks.getFallback()) == null) {
            return null;
        }
        return fallback;
    }

    protected String getProcessName() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) sAppContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "com.xiaomi";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> a;
        String str3 = null;
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<com.xiaomi.channel.commonutils.network.c> arrayList3 = new ArrayList();
        arrayList3.add(new com.xiaomi.channel.commonutils.network.a("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new com.xiaomi.channel.commonutils.network.a("conpt", obfuscate(d.k(sAppContext))));
        }
        if (z) {
            arrayList3.add(new com.xiaomi.channel.commonutils.network.a("reserved", "1"));
        }
        arrayList3.add(new com.xiaomi.channel.commonutils.network.a(UserBox.TYPE, str2));
        arrayList3.add(new com.xiaomi.channel.commonutils.network.a(IntentConfig.LIST, com.xiaomi.channel.commonutils.string.d.a(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        Fallback localFallback = getLocalFallback(getHost());
        String format = String.format(Locale.US, "http://%1$s/gslb/?ver=4.0", getHost());
        if (localFallback == null) {
            arrayList2.add(format);
            synchronized (sReservedHosts) {
                Fallback fallback = sReservedHosts.get("resolver.msg.xiaomi.net");
                if (fallback != null) {
                    Iterator<String> it = fallback.a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "http://%1$s/gslb/?ver=4.0", it.next()));
                    }
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
                str3 = this.sHttpGetter == null ? d.a(sAppContext, new URL(buildUpon.toString())) : this.sHttpGetter.a(buildUpon.toString());
                return str3;
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            com.xiaomi.channel.commonutils.logger.b.a("network exception: " + e.getMessage());
            throw e;
        }
        return str3;
    }

    protected String loadHosts() {
        BufferedReader bufferedReader;
        String str = null;
        try {
            File file = new File(sAppContext.getFilesDir(), getProcessName());
            if (file.isFile()) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    str = sb.toString();
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.xiaomi.channel.commonutils.logger.b.a("load host exception " + th.getMessage());
                        return str;
                    } finally {
                        com.xiaomi.channel.commonutils.file.b.a(bufferedReader);
                    }
                }
            } else {
                com.xiaomi.channel.commonutils.file.b.a((Closeable) null);
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        return str;
    }

    public void persist() {
        synchronized (this.mHostsMapping) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(sAppContext.openFileOutput(getProcessName(), 0)));
                String jSONObject = toJSON().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a("persist bucket failure: " + e.getMessage());
            }
        }
    }

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

    public void refreshFallbacks() {
        ArrayList<String> arrayList;
        synchronized (this.mHostsMapping) {
            checkHostMapping();
            arrayList = new ArrayList<>(this.mHostsMapping.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fallbacks fallbacks = this.mHostsMapping.get(arrayList.get(size));
                if (fallbacks != null && fallbacks.getFallback() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<Fallback> requestRemoteFallbacks = requestRemoteFallbacks(arrayList);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return;
            }
            if (requestRemoteFallbacks.get(i2) != null) {
                updateFallbacks(arrayList.get(i2), requestRemoteFallbacks.get(i2));
            }
            i = i2 + 1;
        }
    }

    protected Fallback requestRemoteFallback(String str) {
        if (System.currentTimeMillis() - this.lastRemoteRequestTimestamp > this.remoteRequestFailureCount * 60 * 1000) {
            this.lastRemoteRequestTimestamp = System.currentTimeMillis();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            Fallback fallback = requestRemoteFallbacks(arrayList).get(0);
            if (fallback != null) {
                this.remoteRequestFailureCount = 0L;
                return fallback;
            } else if (this.remoteRequestFailureCount < 15) {
                this.remoteRequestFailureCount++;
            }
        }
        return null;
    }

    public void setCurrentISP(String str) {
        this.currentISP = str;
    }

    protected JSONObject toJSON() {
        JSONObject jSONObject;
        synchronized (this.mHostsMapping) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (Fallbacks fallbacks : this.mHostsMapping.values()) {
                jSONArray.put(fallbacks.toJSON());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Fallback fallback : sReservedHosts.values()) {
                jSONArray2.put(fallback.f());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    public void updateFallbacks(String str, Fallback fallback) {
        if (TextUtils.isEmpty(str) || fallback == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + fallback);
        }
        if (this.sHostFilter.a(str)) {
            synchronized (this.mHostsMapping) {
                checkHostMapping();
                if (this.mHostsMapping.containsKey(str)) {
                    this.mHostsMapping.get(str).addFallback(fallback);
                } else {
                    Fallbacks fallbacks = new Fallbacks(str);
                    fallbacks.addFallback(fallback);
                    this.mHostsMapping.put(str, fallbacks);
                }
            }
        }
    }
}
