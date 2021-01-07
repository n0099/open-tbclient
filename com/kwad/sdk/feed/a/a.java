package com.kwad.sdk.feed.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    private static volatile a d;

    /* renamed from: a  reason: collision with root package name */
    private List<AdTemplate> f10107a;

    /* renamed from: b  reason: collision with root package name */
    private List<AdTemplate> f10108b;
    private List<InterfaceC1127a> c;

    /* renamed from: com.kwad.sdk.feed.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1127a {
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
        for (InterfaceC1127a interfaceC1127a : this.c) {
            interfaceC1127a.a(i);
        }
    }

    @MainThread
    public void a(InterfaceC1127a interfaceC1127a) {
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.add(interfaceC1127a);
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f10107a == null) {
            this.f10107a = new ArrayList();
        }
        this.f10107a.clear();
        this.f10107a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f10107a;
    }

    @MainThread
    public void b(InterfaceC1127a interfaceC1127a) {
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.remove(interfaceC1127a);
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f10108b == null) {
            this.f10108b = new ArrayList();
        }
        this.f10108b.clear();
        this.f10108b.addAll(list);
    }

    public void c() {
        if (this.f10107a != null) {
            this.f10107a.clear();
        }
        this.f10107a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f10108b;
    }

    public void e() {
        if (this.f10108b != null) {
            this.f10108b.clear();
        }
        this.f10108b = null;
    }

    @MainThread
    public void f() {
        if (this.c != null) {
            this.c.clear();
        }
    }
}
