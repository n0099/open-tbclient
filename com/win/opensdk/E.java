package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class E {

    /* renamed from: b  reason: collision with root package name */
    public static E f39657b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f39658a = new ConcurrentHashMap();

    public static E a() {
        if (f39657b == null) {
            synchronized (E.class) {
                if (f39657b == null) {
                    f39657b = new E();
                }
            }
        }
        return f39657b;
    }

    public Info a(String str) {
        Info info;
        synchronized (E.class) {
            info = (Info) this.f39658a.remove(str);
        }
        return info;
    }

    public void a(String str, Info info) {
        synchronized (E.class) {
            this.f39658a.put(str, info);
        }
    }
}
