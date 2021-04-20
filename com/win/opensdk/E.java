package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class E {

    /* renamed from: b  reason: collision with root package name */
    public static E f39946b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f39947a = new ConcurrentHashMap();

    public static E a() {
        if (f39946b == null) {
            synchronized (E.class) {
                if (f39946b == null) {
                    f39946b = new E();
                }
            }
        }
        return f39946b;
    }

    public Info a(String str) {
        Info info;
        synchronized (E.class) {
            info = (Info) this.f39947a.remove(str);
        }
        return info;
    }

    public void a(String str, Info info) {
        synchronized (E.class) {
            this.f39947a.put(str, info);
        }
    }
}
