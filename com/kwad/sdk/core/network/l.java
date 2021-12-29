package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class l {
    public static volatile l a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, String> f58101b = new ConcurrentHashMap();

    public static l a() {
        if (a == null) {
            synchronized (l.class) {
                if (a == null) {
                    a = new l();
                }
            }
        }
        return a;
    }

    public String a(String str) {
        return this.f58101b.get(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f58101b.put(str, str2);
    }
}
