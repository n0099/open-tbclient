package com.kwad.sdk.feed.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f35547d;

    /* renamed from: a  reason: collision with root package name */
    public List<AdTemplate> f35548a;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f35549b;

    /* renamed from: c  reason: collision with root package name */
    public List<InterfaceC0404a> f35550c;

    /* renamed from: com.kwad.sdk.feed.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0404a {
        @MainThread
        void a(int i2);
    }

    public static a a() {
        if (f35547d == null) {
            synchronized (a.class) {
                if (f35547d == null) {
                    f35547d = new a();
                }
            }
        }
        return f35547d;
    }

    @MainThread
    public void a(int i2) {
        List<InterfaceC0404a> list = this.f35550c;
        if (list == null) {
            return;
        }
        for (InterfaceC0404a interfaceC0404a : list) {
            interfaceC0404a.a(i2);
        }
    }

    @MainThread
    public void a(InterfaceC0404a interfaceC0404a) {
        if (this.f35550c == null) {
            this.f35550c = new LinkedList();
        }
        this.f35550c.add(interfaceC0404a);
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f35548a == null) {
            this.f35548a = new ArrayList();
        }
        this.f35548a.clear();
        this.f35548a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f35548a;
    }

    @MainThread
    public void b(InterfaceC0404a interfaceC0404a) {
        if (this.f35550c == null) {
            this.f35550c = new LinkedList();
        }
        this.f35550c.remove(interfaceC0404a);
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f35549b == null) {
            this.f35549b = new ArrayList();
        }
        this.f35549b.clear();
        this.f35549b.addAll(list);
    }

    public void c() {
        List<AdTemplate> list = this.f35548a;
        if (list != null) {
            list.clear();
        }
        this.f35548a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f35549b;
    }

    public void e() {
        List<AdTemplate> list = this.f35549b;
        if (list != null) {
            list.clear();
        }
        this.f35549b = null;
    }

    @MainThread
    public void f() {
        List<InterfaceC0404a> list = this.f35550c;
        if (list != null) {
            list.clear();
        }
    }
}
