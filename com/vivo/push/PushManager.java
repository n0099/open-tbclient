package com.vivo.push;

import android.content.Context;
import com.heytap.mcssdk.mode.Message;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class PushManager {
    public static final String DEFAULT_REQUEST_ID = "1";
    private static final Object SLOCK = new Object();
    private static final String TAG = "PushManager";
    private static volatile PushManager sPushClient;

    private PushManager(Context context) {
        p.a().a(context);
        LocalAliasTagsManager.getInstance(context).init();
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

    public void initialize() {
        p.a().i();
    }

    public void setNotifyStyle(int i) {
        p.a().c(i);
    }

    public void checkManifest() throws VivoPushException {
        p.a().b();
    }

    private void stopWork() {
        p.a().j();
    }

    void killPush() {
        p.a().q();
    }

    public void reset() {
        if (com.vivo.push.util.p.a()) {
            p.a().a(-1);
        }
    }

    public void reset(int i) {
        if (com.vivo.push.util.p.a()) {
            p.a().a(i);
        }
    }

    public void checkParam(String str) {
        if (str == null) {
            throw new RuntimeException("PushManager String param should not be " + str);
        }
    }

    public void checkParam(List<String> list) {
        boolean z;
        boolean z2 = true;
        if (list == null || list.size() <= 0) {
            z2 = false;
        }
        if (z2) {
            Iterator<String> it = list.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = it.next() == null ? false : z;
            }
        } else {
            z = z2;
        }
        if (!z) {
            throw new IllegalArgumentException("PushManager param should not be " + list);
        }
    }

    public void bindAlias(String str, IPushActionListener iPushActionListener) {
        checkParam(str);
        p.a().a(str, iPushActionListener);
    }

    public void unBindAlias(String str, IPushActionListener iPushActionListener) {
        checkParam(str);
        p.a().b(str, iPushActionListener);
    }

    public void setTopic(String str, String str2) {
        checkParam(str2);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        p.a().a(str, arrayList);
    }

    public void setTopic(ArrayList<String> arrayList) {
        checkParam(arrayList);
        p.a().a("1", arrayList);
    }

    public void setTopic(String str, ArrayList<String> arrayList) {
        checkParam(arrayList);
        p.a().a(str, arrayList);
    }

    public void delTopic(String str, String str2) {
        checkParam(str2);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        p.a().b(str, arrayList);
    }

    public void delTopic(ArrayList<String> arrayList) {
        checkParam(arrayList);
        p.a().b("1", arrayList);
    }

    public void delTopic(String str, ArrayList<String> arrayList) {
        checkParam(arrayList);
        p.a().b(str, arrayList);
    }

    public void turnOnPush() {
        turnOnPush(null);
    }

    public void turnOnPush(IPushActionListener iPushActionListener) {
        p.a().a(iPushActionListener);
    }

    public void turnOffPush() {
        turnOffPush(null);
    }

    public void turnOffPush(IPushActionListener iPushActionListener) {
        p.a().b(iPushActionListener);
    }

    public void setLocalAlias(String str) {
        checkParam(str);
        LocalAliasTagsManager.getInstance(p.a().h()).setLocalAlias(str);
    }

    private void setLocalTag(String str) {
        checkParam(str);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        setLocalTags(arrayList);
    }

    public void setLocalTags(ArrayList<String> arrayList) {
        checkParam(arrayList);
        LocalAliasTagsManager.getInstance(p.a().h()).setLocalTags(arrayList);
    }

    public void delLocalAlias() {
        String localAlias = LocalAliasTagsManager.getInstance(p.a().h()).getLocalAlias();
        if (localAlias != null) {
            LocalAliasTagsManager.getInstance(p.a().h()).delLocalAlias(localAlias);
        }
    }

    private void delLocalTag(String str) {
        checkParam(str);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        delLocalTags(arrayList);
    }

    public void delLocalTags(ArrayList<String> arrayList) {
        checkParam(arrayList);
        LocalAliasTagsManager.getInstance(p.a().h()).delLocalTags(arrayList);
    }

    public boolean isEnablePush() {
        return ClientConfigManagerImpl.getInstance(p.a().h()).isEnablePush();
    }

    public boolean isPushProcess() {
        return com.vivo.push.util.z.a(p.a().h());
    }

    public void enableNet() {
        p.a().m();
    }

    public boolean isEnableNet() {
        return p.a().p();
    }

    public void disableNet() {
        p.a().n();
    }

    public String getClientId() {
        return com.vivo.push.util.y.b(p.a().h()).a("com.vivo.pushservice.client_id", null);
    }

    public String getRegId() {
        return p.a().f();
    }

    public void setDebugMode(boolean z) {
        p.a().b(z);
    }

    public void setMode(int i) {
        p.a().b(i);
    }

    public void setSystemModel(boolean z) {
        p.a().a(z);
    }

    public String getVersion() {
        return "2.5.3";
    }

    public void showDebugInfo() {
        p.a().o();
    }

    public Map<String, String> getDebugInfo() {
        return p.a().s();
    }

    public boolean reportData(Context context, long j, long j2) {
        com.vivo.push.util.p.d(TAG, "report message: " + j + ", reportType: " + j2);
        if (j2 <= 0) {
            return false;
        }
        com.vivo.push.b.aa aaVar = new com.vivo.push.b.aa(j2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Message.MESSAGE_ID, String.valueOf(j));
        aaVar.a(hashMap);
        p.a().a(aaVar);
        return true;
    }
}
