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
    public static volatile a f35173d;

    /* renamed from: a  reason: collision with root package name */
    public List<AdTemplate> f35174a;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f35175b;

    /* renamed from: c  reason: collision with root package name */
    public List<InterfaceC0418a> f35176c;

    /* renamed from: com.kwad.sdk.feed.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0418a {
        @MainThread
        void a(int i);
    }

    public static a a() {
        if (f35173d == null) {
            synchronized (a.class) {
                if (f35173d == null) {
                    f35173d = new a();
                }
            }
        }
        return f35173d;
    }

    @MainThread
    public void a(int i) {
        List<InterfaceC0418a> list = this.f35176c;
        if (list == null) {
            return;
        }
        for (InterfaceC0418a interfaceC0418a : list) {
            interfaceC0418a.a(i);
        }
    }

    @MainThread
    public void a(InterfaceC0418a interfaceC0418a) {
        if (this.f35176c == null) {
            this.f35176c = new LinkedList();
        }
        this.f35176c.add(interfaceC0418a);
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f35174a == null) {
            this.f35174a = new ArrayList();
        }
        this.f35174a.clear();
        this.f35174a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f35174a;
    }

    @MainThread
    public void b(InterfaceC0418a interfaceC0418a) {
        if (this.f35176c == null) {
            this.f35176c = new LinkedList();
        }
        this.f35176c.remove(interfaceC0418a);
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f35175b == null) {
            this.f35175b = new ArrayList();
        }
        this.f35175b.clear();
        this.f35175b.addAll(list);
    }

    public void c() {
        List<AdTemplate> list = this.f35174a;
        if (list != null) {
            list.clear();
        }
        this.f35174a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f35175b;
    }

    public void e() {
        List<AdTemplate> list = this.f35175b;
        if (list != null) {
            list.clear();
        }
        this.f35175b = null;
    }

    @MainThread
    public void f() {
        List<InterfaceC0418a> list = this.f35176c;
        if (list != null) {
            list.clear();
        }
    }
}
