package com.kwad.sdk.reward;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class b {
    public Set<InterfaceC2139b> a;

    /* loaded from: classes3.dex */
    public static class a {
        public static b a = new b();
    }

    /* renamed from: com.kwad.sdk.reward.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2139b {
        void onPageClose();
    }

    public b() {
        this.a = new HashSet();
    }

    public static b a() {
        return a.a;
    }

    public void a(InterfaceC2139b interfaceC2139b) {
        if (interfaceC2139b != null) {
            this.a.add(interfaceC2139b);
        }
    }

    public void b() {
        if (this.a.size() == 0) {
            return;
        }
        for (InterfaceC2139b interfaceC2139b : this.a) {
            interfaceC2139b.onPageClose();
        }
    }

    public void b(InterfaceC2139b interfaceC2139b) {
        this.a.remove(interfaceC2139b);
    }
}
