package com.kwad.sdk.feed.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static volatile a d;

    /* renamed from: a  reason: collision with root package name */
    private List<AdTemplate> f9809a;

    /* renamed from: b  reason: collision with root package name */
    private List<AdTemplate> f9810b;
    private List<InterfaceC1116a> c;

    /* renamed from: com.kwad.sdk.feed.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1116a {
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
        for (InterfaceC1116a interfaceC1116a : this.c) {
            interfaceC1116a.a(i);
        }
    }

    @MainThread
    public void a(InterfaceC1116a interfaceC1116a) {
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.add(interfaceC1116a);
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f9809a == null) {
            this.f9809a = new ArrayList();
        }
        this.f9809a.clear();
        this.f9809a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f9809a;
    }

    @MainThread
    public void b(InterfaceC1116a interfaceC1116a) {
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.remove(interfaceC1116a);
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f9810b == null) {
            this.f9810b = new ArrayList();
        }
        this.f9810b.clear();
        this.f9810b.addAll(list);
    }

    public void c() {
        if (this.f9809a != null) {
            this.f9809a.clear();
        }
        this.f9809a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f9810b;
    }

    public void e() {
        if (this.f9810b != null) {
            this.f9810b.clear();
        }
        this.f9810b = null;
    }

    @MainThread
    public void f() {
        if (this.c != null) {
            this.c.clear();
        }
    }
}
