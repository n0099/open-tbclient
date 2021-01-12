package com.kwad.sdk.feed.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static volatile a d;

    /* renamed from: a  reason: collision with root package name */
    private List<AdTemplate> f9807a;

    /* renamed from: b  reason: collision with root package name */
    private List<AdTemplate> f9808b;
    private List<InterfaceC1110a> c;

    /* renamed from: com.kwad.sdk.feed.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1110a {
        @MainThread
        void a(int i);
    }

    private a() {
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    @MainThread
    public void a(int i) {
        if (this.c == null) {
            return;
        }
        for (InterfaceC1110a interfaceC1110a : this.c) {
            interfaceC1110a.a(i);
        }
    }

    @MainThread
    public void a(InterfaceC1110a interfaceC1110a) {
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.add(interfaceC1110a);
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f9807a == null) {
            this.f9807a = new ArrayList();
        }
        this.f9807a.clear();
        this.f9807a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f9807a;
    }

    @MainThread
    public void b(InterfaceC1110a interfaceC1110a) {
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.remove(interfaceC1110a);
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f9808b == null) {
            this.f9808b = new ArrayList();
        }
        this.f9808b.clear();
        this.f9808b.addAll(list);
    }

    public void c() {
        if (this.f9807a != null) {
            this.f9807a.clear();
        }
        this.f9807a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f9808b;
    }

    public void e() {
        if (this.f9808b != null) {
            this.f9808b.clear();
        }
        this.f9808b = null;
    }

    @MainThread
    public void f() {
        if (this.c != null) {
            this.c.clear();
        }
    }
}
