package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class x {

    /* renamed from: b  reason: collision with root package name */
    public static x f37996b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f37997a = new ConcurrentHashMap();

    public static x a() {
        if (f37996b == null) {
            synchronized (x.class) {
                if (f37996b == null) {
                    f37996b = new x();
                }
            }
        }
        return f37996b;
    }

    public Info a(String str) {
        Info info;
        synchronized (x.class) {
            info = (Info) this.f37997a.remove(str);
        }
        return info;
    }

    public void a(String str, Info info) {
        synchronized (x.class) {
            this.f37997a.put(str, info);
        }
    }
}
