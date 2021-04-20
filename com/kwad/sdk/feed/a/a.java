package com.kwad.sdk.feed.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f35078d;

    /* renamed from: a  reason: collision with root package name */
    public List<AdTemplate> f35079a;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f35080b;

    /* renamed from: c  reason: collision with root package name */
    public List<InterfaceC0415a> f35081c;

    /* renamed from: com.kwad.sdk.feed.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0415a {
        @MainThread
        void a(int i);
    }

    public static a a() {
        if (f35078d == null) {
            synchronized (a.class) {
                if (f35078d == null) {
                    f35078d = new a();
                }
            }
        }
        return f35078d;
    }

    @MainThread
    public void a(int i) {
        List<InterfaceC0415a> list = this.f35081c;
        if (list == null) {
            return;
        }
        for (InterfaceC0415a interfaceC0415a : list) {
            interfaceC0415a.a(i);
        }
    }

    @MainThread
    public void a(InterfaceC0415a interfaceC0415a) {
        if (this.f35081c == null) {
            this.f35081c = new LinkedList();
        }
        this.f35081c.add(interfaceC0415a);
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f35079a == null) {
            this.f35079a = new ArrayList();
        }
        this.f35079a.clear();
        this.f35079a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f35079a;
    }

    @MainThread
    public void b(InterfaceC0415a interfaceC0415a) {
        if (this.f35081c == null) {
            this.f35081c = new LinkedList();
        }
        this.f35081c.remove(interfaceC0415a);
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f35080b == null) {
            this.f35080b = new ArrayList();
        }
        this.f35080b.clear();
        this.f35080b.addAll(list);
    }

    public void c() {
        List<AdTemplate> list = this.f35079a;
        if (list != null) {
            list.clear();
        }
        this.f35079a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f35080b;
    }

    public void e() {
        List<AdTemplate> list = this.f35080b;
        if (list != null) {
            list.clear();
        }
        this.f35080b = null;
    }

    @MainThread
    public void f() {
        List<InterfaceC0415a> list = this.f35081c;
        if (list != null) {
            list.clear();
        }
    }
}
