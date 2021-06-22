package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class x {

    /* renamed from: b  reason: collision with root package name */
    public static x f40952b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f40953a = new ConcurrentHashMap();

    public static x a() {
        if (f40952b == null) {
            synchronized (x.class) {
                if (f40952b == null) {
                    f40952b = new x();
                }
            }
        }
        return f40952b;
    }

    public Info a(String str) {
        Info info;
        synchronized (x.class) {
            info = (Info) this.f40953a.remove(str);
        }
        return info;
    }

    public void a(String str, Info info) {
        synchronized (x.class) {
            this.f40953a.put(str, info);
        }
    }
}
