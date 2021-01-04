package com.qq.e.comm.plugin.v;

import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes3.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<Integer, WeakReference<f>> f12906a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f a(int i) {
        WeakReference<f> weakReference = f12906a.get(Integer.valueOf(i));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, f fVar) {
        f12906a.put(Integer.valueOf(i), new WeakReference<>(fVar));
    }
}
