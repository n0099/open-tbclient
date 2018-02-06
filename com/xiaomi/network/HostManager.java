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
import com.coremedia.iso.boxes.UserBox;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class HostManager {
    private static HostManagerFactory factory;
    private static String sAppName;
    private static String sAppVersion;
    private static HostManager sInstance;
    protected Context sAppContext;
    private HostFilter sHostFilter;
    protected HttpGet sHttpGetter;
    private String sUserId;
    protected static Map<String, ArrayList<String>> mReservedHosts = new HashMap();
    protected static boolean hostLoaded = false;
    protected Map<String, Fallbacks> mHostsMapping = new HashMap();
    private long remoteRequestFailureCount = 0;
    private final long MAX_REQUEST_FAILURE_CNT = 15;
    private long lastRemoteRequestTimestamp = 0;
    private String currentISP = "isp_prov_city_country_ip";

    /* loaded from: classes2.dex */
    public interface HostManagerFactory {
        HostManager a(Context context, HostFilter hostFilter, HttpGet httpGet, String str);
    }

    /* loaded from: classes2.dex */
    public interface HttpGet {
        String a(String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HostManager(Context context, HostFilter hostFilter, HttpGet httpGet, String str, String str2, String str3) {
        this.sUserId = "0";
        this.sAppContext = context.getApplicationContext();
        if (this.sAppContext == null) {
            this.sAppContext = context;
        }
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
        ArrayList<String> arrayList = mReservedHosts.get(str);
        synchronized (mReservedHosts) {
            if (arrayList == null) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                arrayList2.add(str2);
                mReservedHosts.put(str, arrayList2);
            } else if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
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
            PackageInfo packageInfo = this.sAppContext.getPackageManager().getPackageInfo(this.sAppContext.getPackageName(), 16384);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Exception e) {
        }
        return "0";
    }

    public static synchronized void init(Context context, HostFilter hostFilter, HttpGet httpGet, String str, String str2, String str3) {
        synchronized (HostManager.class) {
            if (sInstance == null) {
                if (factory == null) {
                    sInstance = new HostManager(context, hostFilter, httpGet, str, str2, str3);
                } else {
                    sInstance = factory.a(context, hostFilter, httpGet, str);
                }
            }
        }
    }

    public static <T> String join(Collection<T> collection, String str) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static String join(String[] strArr, String str) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(str);
            sb.append(strArr[i]);
        }
        return sb.toString();
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
        synchronized (mReservedHosts) {
            for (String str2 : mReservedHosts.keySet()) {
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (!arrayList.contains(getHost())) {
            arrayList.add(getHost());
        }
        ArrayList<Fallback> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(null);
        }
        try {
            String str3 = d.f(this.sAppContext) ? "wifi" : "wap";
            String remoteFallbackJSON = getRemoteFallbackJSON(arrayList, str3, this.sUserId);
            if (!TextUtils.isEmpty(remoteFallbackJSON)) {
                JSONObject jSONObject = new JSONObject(remoteFallbackJSON);
                if ("OK".equalsIgnoreCase(jSONObject.getString("S"))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("R");
                    String string = jSONObject2.getString("province");
                    String string2 = jSONObject2.getString("city");
                    String string3 = jSONObject2.getString("isp");
                    String string4 = jSONObject2.getString("ip");
                    String string5 = jSONObject2.getString("country");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(str3);
                    if (str3.equals("wap")) {
                        str3 = getActiveNetworkLabel();
                    }
                    com.xiaomi.channel.commonutils.logger.b.a("get bucket: ip = " + string4 + " net = " + string3 + str3 + " hosts = " + jSONObject3.toString());
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        String str4 = arrayList.get(i2);
                        JSONArray optJSONArray = jSONObject3.optJSONArray(str4);
                        if (optJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.b.a("no bucket found for " + str4);
                        } else {
                            Fallback fallback = new Fallback(str4);
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                String string6 = optJSONArray.getString(i3);
                                if (!TextUtils.isEmpty(string6)) {
                                    fallback.a(new c(string6, optJSONArray.length() - i3));
                                }
                            }
                            arrayList2.set(i2, fallback);
                            fallback.g = string5;
                            fallback.c = string;
                            fallback.e = string3;
                            fallback.f = string4;
                            fallback.d = string2;
                            if (jSONObject2.has("stat-percent")) {
                                fallback.a(jSONObject2.getDouble("stat-percent"));
                            }
                            if (jSONObject2.has("stat-domain")) {
                                fallback.b(jSONObject2.getString("stat-domain"));
                            }
                            if (jSONObject2.has("ttl")) {
                                fallback.a(jSONObject2.getInt("ttl") * 1000);
                            }
                            setCurrentISP(fallback.e());
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("failed to get bucket " + e.getMessage());
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= arrayList.size()) {
                persist();
                return arrayList2;
            }
            Fallback fallback2 = arrayList2.get(i5);
            if (fallback2 != null) {
                updateFallbacks(arrayList.get(i5), fallback2);
            }
            i4 = i5 + 1;
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
            com.xiaomi.channel.commonutils.logger.b.a("loading the new hosts succeed");
            return true;
        }
    }

    public void clear() {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
        }
    }

    protected void fromJSON(String str) {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                Fallbacks fromJSON = new Fallbacks().fromJSON(jSONArray.getJSONObject(i));
                this.mHostsMapping.put(fromJSON.getHost(), fromJSON);
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007c -> B:23:0x0007). Please submit an issue!!! */
    public String getActiveNetworkLabel() {
        String str;
        ConnectivityManager connectivityManager;
        if (this.sAppContext == null) {
            return "unknown";
        }
        try {
            connectivityManager = (ConnectivityManager) this.sAppContext.getSystemService("connectivity");
        } catch (Throwable th) {
        }
        if (connectivityManager == null) {
            str = "unknown";
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                str = "unknown";
            } else if (activeNetworkInfo.getType() == 1) {
                WifiManager wifiManager = (WifiManager) this.sAppContext.getSystemService("wifi");
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
            return (localFallback == null || !localFallback.b()) ? (z && d.d(this.sAppContext) && (requestRemoteFallback = requestRemoteFallback(str)) != null) ? requestRemoteFallback : new b(this, str, localFallback) : localFallback;
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
        return "resolver.gslb.mi-idc.com";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Fallback getLocalFallback(String str) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public String getProcessName() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.sAppContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
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
    public String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2) {
        String str3 = null;
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<com.xiaomi.channel.commonutils.network.c> arrayList3 = new ArrayList();
        arrayList3.add(new com.xiaomi.channel.commonutils.network.a("type", str));
        arrayList3.add(new com.xiaomi.channel.commonutils.network.a(UserBox.TYPE, str2));
        arrayList3.add(new com.xiaomi.channel.commonutils.network.a("list", join(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        Fallback localFallback = getLocalFallback("resolver.gslb.mi-idc.com");
        String format = String.format("http://%1$s/gslb/gslb/getbucket.asp?ver=3.0", "resolver.gslb.mi-idc.com");
        if (localFallback == null) {
            arrayList2.add(format);
        } else {
            arrayList2 = localFallback.a(format);
        }
        Iterator<String> it = arrayList2.iterator();
        IOException e = null;
        while (it.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it.next()).buildUpon();
            for (com.xiaomi.channel.commonutils.network.c cVar : arrayList3) {
                buildUpon.appendQueryParameter(cVar.a(), cVar.b());
            }
            try {
                str3 = this.sHttpGetter == null ? d.a(this.sAppContext, new URL(buildUpon.toString())) : this.sHttpGetter.a(buildUpon.toString());
                return str3;
            } catch (IOException e2) {
                e = e2;
                com.xiaomi.channel.commonutils.logger.b.a("network ioErr: " + e.getMessage());
            }
        }
        if (e != null) {
            throw e;
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String loadHosts() {
        BufferedReader bufferedReader;
        String str = null;
        try {
            File file = new File(this.sAppContext.getFilesDir(), getProcessName());
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
                        com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
                    }
                }
            } else {
                com.xiaomi.channel.commonutils.file.a.a((Reader) null);
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        return str;
    }

    public void persist() {
        purge();
        synchronized (this.mHostsMapping) {
            try {
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.sAppContext.openFileOutput(getProcessName(), 0)));
                    String jSONArray = toJSON().toString();
                    if (!TextUtils.isEmpty(jSONArray)) {
                        bufferedWriter.write(jSONArray);
                    }
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void purge() {
        synchronized (this.mHostsMapping) {
            for (Fallbacks fallbacks : this.mHostsMapping.values()) {
                fallbacks.purge(false);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONArray toJSON() {
        JSONArray jSONArray;
        synchronized (this.mHostsMapping) {
            jSONArray = new JSONArray();
            for (Fallbacks fallbacks : this.mHostsMapping.values()) {
                jSONArray.put(fallbacks.toJSON());
            }
        }
        return jSONArray;
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
