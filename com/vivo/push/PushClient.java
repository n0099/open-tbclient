package com.vivo.push;

import android.content.Context;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PushClient {
    public static final String DEFAULT_REQUEST_ID = "1";
    private static final Object SLOCK = new Object();
    private static volatile PushClient sPushClient;

    private PushClient(Context context) {
        p.a().a(context);
    }

    public static PushClient getInstance(Context context) {
        if (sPushClient == null) {
            synchronized (SLOCK) {
                if (sPushClient == null) {
                    sPushClient = new PushClient(context.getApplicationContext());
                }
            }
        }
        return sPushClient;
    }

    public void initialize() {
        p.a().i();
    }

    public void checkManifest() throws VivoPushException {
        p.a().b();
    }

    private void checkParam(String str) {
        if (str == null) {
            throw new IllegalArgumentException("PushManager String param should not be " + str);
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

    public void turnOnPush(IPushActionListener iPushActionListener) {
        p.a().a(iPushActionListener);
    }

    public void turnOffPush(IPushActionListener iPushActionListener) {
        p.a().b(iPushActionListener);
    }

    public String getAlias() {
        return p.a().l();
    }

    public String getRegId() {
        return p.a().f();
    }

    public String getVersion() {
        return "2.4.0";
    }

    public void setTopic(String str, IPushActionListener iPushActionListener) {
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str);
        p.a().a(arrayList, iPushActionListener);
    }

    public void delTopic(String str, IPushActionListener iPushActionListener) {
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str);
        p.a().b(arrayList, iPushActionListener);
    }

    public List<String> getTopics() {
        return p.a().c();
    }

    public void setSystemModel(boolean z) {
        p.a().a(z);
    }

    public boolean isSupport() {
        return p.a().d();
    }
}
