package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class E {

    /* renamed from: b  reason: collision with root package name */
    public static E f40041b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f40042a = new ConcurrentHashMap();

    public static E a() {
        if (f40041b == null) {
            synchronized (E.class) {
                if (f40041b == null) {
                    f40041b = new E();
                }
            }
        }
        return f40041b;
    }

    public Info a(String str) {
        Info info;
        synchronized (E.class) {
            info = (Info) this.f40042a.remove(str);
        }
        return info;
    }

    public void a(String str, Info info) {
        synchronized (E.class) {
            this.f40042a.put(str, info);
        }
    }
}
