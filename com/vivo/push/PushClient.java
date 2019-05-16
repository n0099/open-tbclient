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
        m.a().a(context);
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
        m.a().j();
    }

    public void checkManifest() throws VivoPushException {
        m.a().b();
    }

    private void checkParam(String str) {
        if (str == null) {
            throw new IllegalArgumentException("PushManager String param should not be " + str);
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

    public void turnOnPush(IPushActionListener iPushActionListener) {
        m.a().a(iPushActionListener);
    }

    public void turnOffPush(IPushActionListener iPushActionListener) {
        m.a().b(iPushActionListener);
    }

    public String getAlias() {
        return m.a().m();
    }

    public String getRegId() {
        return m.a().g();
    }

    public String getVersion() {
        return "2.1.0";
    }

    public void setTopic(String str, IPushActionListener iPushActionListener) {
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str);
        m.a().a(arrayList, iPushActionListener);
    }

    public void delTopic(String str, IPushActionListener iPushActionListener) {
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str);
        m.a().b(arrayList, iPushActionListener);
    }

    public List<String> getTopics() {
        return m.a().c();
    }
}
