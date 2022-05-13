package com.kwad.sdk.reward;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class b {
    public Set<InterfaceC0328b> a;

    /* loaded from: classes5.dex */
    public static class a {
        public static b a = new b();
    }

    /* renamed from: com.kwad.sdk.reward.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0328b {
        void onPageClose();
    }

    public b() {
        this.a = new HashSet();
    }

    public static b a() {
        return a.a;
    }

    public void a(InterfaceC0328b interfaceC0328b) {
        if (interfaceC0328b != null) {
            this.a.add(interfaceC0328b);
        }
    }

    public void b() {
        if (this.a.size() == 0) {
            return;
        }
        for (InterfaceC0328b interfaceC0328b : this.a) {
            interfaceC0328b.onPageClose();
        }
    }

    public void b(InterfaceC0328b interfaceC0328b) {
        this.a.remove(interfaceC0328b);
    }
}
