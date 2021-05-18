package com.vivo.push;

import android.content.Context;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class PushManager {
    public static final String DEFAULT_REQUEST_ID = "1";
    public static final Object SLOCK = new Object();
    public static final String TAG = "PushManager";
    public static volatile PushManager sPushClient;

    public PushManager(Context context) {
        p.a().a(context);
        LocalAliasTagsManager.getInstance(context).init();
    }

    private void delLocalTag(String str) {
        checkParam(str);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        delLocalTags(arrayList);
    }

    public static PushManager getInstance(Context context) {
        if (sPushClient == null) {
            synchronized (SLOCK) {
                if (sPushClient == null) {
                    sPushClient = new PushManager(context.getApplicationContext());
                }
            }
        }
        return sPushClient;
    }

    private void setLocalTag(String str) {
        checkParam(str);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        setLocalTags(arrayList);
    }

    private void stopWork() {
        p.a().j();
    }

    public void bindAlias(String str, IPushActionListener iPushActionListener) {
        checkParam(str);
        p.a().a(str, iPushActionListener);
    }

    public void checkManifest() throws VivoPushException {
        p.a().b();
    }

    public void checkParam(String str) {
        if (str != null) {
            return;
        }
        throw new RuntimeException("PushManager String param should not be " + str);
    }

    public void delLocalAlias() {
        String localAlias = LocalAliasTagsManager.getInstance(p.a().h()).getLocalAlias();
        if (localAlias != null) {
            LocalAliasTagsManager.getInstance(p.a().h()).delLocalAlias(localAlias);
        }
    }

    public void delLocalTags(ArrayList<String> arrayList) {
        checkParam(arrayList);
        LocalAliasTagsManager.getInstance(p.a().h()).delLocalTags(arrayList);
    }

    public void delTopic(String str, String str2) {
        checkParam(str2);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        p.a().b(str, arrayList);
    }

    public void disableNet() {
        p.a().n();
    }

    public void enableNet() {
        p.a().m();
    }

    public String getClientId() {
        return com.vivo.push.util.y.b(p.a().h()).a("com.vivo.pushservice.client_id", null);
    }

    public Map<String, String> getDebugInfo() {
        return p.a().s();
    }

    public String getRegId() {
        return p.a().f();
    }

    public String getVersion() {
        return "2.5.3";
    }

    public void initialize() {
        p.a().i();
    }

    public boolean isEnableNet() {
        return p.a().p();
    }

    public boolean isEnablePush() {
        return ClientConfigManagerImpl.getInstance(p.a().h()).isEnablePush();
    }

    public boolean isPushProcess() {
        return com.vivo.push.util.z.a(p.a().h());
    }

    public void killPush() {
        p.a().q();
    }

    public boolean reportData(Context context, long j, long j2) {
        com.vivo.push.util.p.d("PushManager", "report message: " + j + ", reportType: " + j2);
        if (j2 <= 0) {
            return false;
        }
        com.vivo.push.b.aa aaVar = new com.vivo.push.b.aa(j2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("messageID", String.valueOf(j));
        aaVar.a(hashMap);
        p.a().a(aaVar);
        return true;
    }

    public void reset() {
        if (com.vivo.push.util.p.a()) {
            p.a().a(-1);
        }
    }

    public void setDebugMode(boolean z) {
        p.a().b(z);
    }

    public void setLocalAlias(String str) {
        checkParam(str);
        LocalAliasTagsManager.getInstance(p.a().h()).setLocalAlias(str);
    }

    public void setLocalTags(ArrayList<String> arrayList) {
        checkParam(arrayList);
        LocalAliasTagsManager.getInstance(p.a().h()).setLocalTags(arrayList);
    }

    public void setMode(int i2) {
        p.a().b(i2);
    }

    public void setNotifyStyle(int i2) {
        p.a().c(i2);
    }

    public void setSystemModel(boolean z) {
        p.a().a(z);
    }

    public void setTopic(String str, String str2) {
        checkParam(str2);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        p.a().a(str, arrayList);
    }

    public void showDebugInfo() {
        p.a().o();
    }

    public void turnOffPush() {
        turnOffPush(null);
    }

    public void turnOnPush() {
        turnOnPush(null);
    }

    public void unBindAlias(String str, IPushActionListener iPushActionListener) {
        checkParam(str);
        p.a().b(str, iPushActionListener);
    }

    public void checkParam(List<String> list) {
        boolean z = list != null && list.size() > 0;
        if (z) {
            for (String str : list) {
                if (str == null) {
                    z = false;
                }
            }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException("PushManager param should not be " + list);
    }

    public void turnOffPush(IPushActionListener iPushActionListener) {
        p.a().b(iPushActionListener);
    }

    public void turnOnPush(IPushActionListener iPushActionListener) {
        p.a().a(iPushActionListener);
    }

    public void reset(int i2) {
        if (com.vivo.push.util.p.a()) {
            p.a().a(i2);
        }
    }

    public void delTopic(ArrayList<String> arrayList) {
        checkParam(arrayList);
        p.a().b("1", arrayList);
    }

    public void setTopic(ArrayList<String> arrayList) {
        checkParam(arrayList);
        p.a().a("1", arrayList);
    }

    public void delTopic(String str, ArrayList<String> arrayList) {
        checkParam(arrayList);
        p.a().b(str, arrayList);
    }

    public void setTopic(String str, ArrayList<String> arrayList) {
        checkParam(arrayList);
        p.a().a(str, arrayList);
    }
}
