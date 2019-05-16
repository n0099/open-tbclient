package com.vivo.push;

import android.content.Context;
import com.vivo.push.cache.ClientConfigManagerImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class PushManager {
    public static final String DEFAULT_REQUEST_ID = "1";
    private static final Object SLOCK = new Object();
    private static volatile PushManager sPushClient;

    private PushManager(Context context) {
        m.a().a(context);
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
        m.a().j();
    }

    private void stopWork() {
        m.a().k();
    }

    void killPush() {
        m.a().r();
    }

    public void reset() {
        if (com.vivo.push.util.m.a()) {
            m.a().n();
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
        m.a().a(str, iPushActionListener);
    }

    public void unBindAlias(String str, IPushActionListener iPushActionListener) {
        checkParam(str);
        m.a().b(str, iPushActionListener);
    }

    public void setTag(String str, String str2) {
        checkParam(str2);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        m.a().a(str, arrayList);
    }

    public void setTopic(ArrayList<String> arrayList) {
        checkParam(arrayList);
        m.a().a("1", arrayList);
    }

    public void setTopic(String str, ArrayList<String> arrayList) {
        checkParam(arrayList);
        m.a().a(str, arrayList);
    }

    public void delTopic(String str, String str2) {
        checkParam(str2);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        m.a().b(str, arrayList);
    }

    public void delTopic(ArrayList<String> arrayList) {
        checkParam(arrayList);
        m.a().b("1", arrayList);
    }

    public void delTopic(String str, ArrayList<String> arrayList) {
        checkParam(arrayList);
        m.a().b(str, arrayList);
    }

    public void turnOnPush() {
        turnOnPush(null);
    }

    public void turnOnPush(IPushActionListener iPushActionListener) {
        m.a().a(iPushActionListener);
    }

    public void turnOffPush() {
        turnOffPush(null);
    }

    public void turnOffPush(IPushActionListener iPushActionListener) {
        m.a().b(iPushActionListener);
    }

    public void setLocalAlias(String str) {
        checkParam(str);
        LocalAliasTagsManager.getInstance(m.a().i()).setLocalAlias(str);
    }

    private void setLocalTag(String str) {
        checkParam(str);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        setLocalTags(arrayList);
    }

    public void setLocalTags(ArrayList<String> arrayList) {
        checkParam(arrayList);
        LocalAliasTagsManager.getInstance(m.a().i()).setLocalTags(arrayList);
    }

    public void delLocalAlias() {
        String localAlias = LocalAliasTagsManager.getInstance(m.a().i()).getLocalAlias();
        if (localAlias != null) {
            LocalAliasTagsManager.getInstance(m.a().i()).delLocalAlias(localAlias);
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
        LocalAliasTagsManager.getInstance(m.a().i()).delLocalTags(arrayList);
    }

    public boolean isEnablePush() {
        return ClientConfigManagerImpl.getInstance(m.a().i()).isEnablePush();
    }

    public boolean isPushProcess() {
        return com.vivo.push.util.w.a(m.a().i());
    }

    public void enableNet() {
        m.a().o();
    }

    public boolean isEnableNet() {
        return m.a().q();
    }

    public void disableNet() {
        m.a().p();
    }

    public String getClientId() {
        return com.vivo.push.util.v.b(m.a().i()).a("com.vivo.pushservice.client_id", null);
    }

    public String getRegId() {
        return m.a().g();
    }

    public void setDebugMode(boolean z) {
        m.a().b(z);
    }

    public void setSystemModel(boolean z) {
        m.a().a(z);
    }

    public String getVersion() {
        return "2.1.0";
    }
}
