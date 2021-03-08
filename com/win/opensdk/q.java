package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes14.dex */
public class q {
    public static q qkw;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f8171a = new ConcurrentHashMap();

    public static q eIY() {
        if (qkw == null) {
            synchronized (q.class) {
                if (qkw == null) {
                    qkw = new q();
                }
            }
        }
        return qkw;
    }

    public void a(String str, Info info) {
        synchronized (q.class) {
            this.f8171a.put(str, info);
        }
    }

    public Info abW(String str) {
        Info info;
        synchronized (q.class) {
            info = (Info) this.f8171a.remove(str);
        }
        return info;
    }
}
