package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class E {

    /* renamed from: b  reason: collision with root package name */
    public static E f39656b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f39657a = new ConcurrentHashMap();

    public static E a() {
        if (f39656b == null) {
            synchronized (E.class) {
                if (f39656b == null) {
                    f39656b = new E();
                }
            }
        }
        return f39656b;
    }

    public Info a(String str) {
        Info info;
        synchronized (E.class) {
            info = (Info) this.f39657a.remove(str);
        }
        return info;
    }

    public void a(String str, Info info) {
        synchronized (E.class) {
            this.f39657a.put(str, info);
        }
    }
}
