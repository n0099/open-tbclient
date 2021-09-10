package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.meizu.cloud.pushsdk.c.a.b> f74801a;

    /* renamed from: b  reason: collision with root package name */
    public final long f74802b;

    /* renamed from: c  reason: collision with root package name */
    public final String f74803c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC2037a<T extends AbstractC2037a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f74804a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f74805b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f74806c = e.b();

        public abstract T a();

        public T a(long j2) {
            this.f74805b = j2;
            return a();
        }
    }

    public a(AbstractC2037a<?> abstractC2037a) {
        d.a(abstractC2037a.f74804a);
        d.a(abstractC2037a.f74806c);
        d.a(!abstractC2037a.f74806c.isEmpty(), "eventId cannot be empty");
        this.f74801a = abstractC2037a.f74804a;
        this.f74802b = abstractC2037a.f74805b;
        this.f74803c = abstractC2037a.f74806c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f74801a);
    }

    public long b() {
        return this.f74802b;
    }

    public String c() {
        return this.f74803c;
    }
}
