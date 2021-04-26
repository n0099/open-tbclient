package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.meizu.cloud.pushsdk.c.a.b> f35660a;

    /* renamed from: b  reason: collision with root package name */
    public final long f35661b;

    /* renamed from: c  reason: collision with root package name */
    public final String f35662c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC0417a<T extends AbstractC0417a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f35663a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f35664b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f35665c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f35664b = j;
            return a();
        }
    }

    public a(AbstractC0417a<?> abstractC0417a) {
        d.a(abstractC0417a.f35663a);
        d.a(abstractC0417a.f35665c);
        d.a(!abstractC0417a.f35665c.isEmpty(), "eventId cannot be empty");
        this.f35660a = abstractC0417a.f35663a;
        this.f35661b = abstractC0417a.f35664b;
        this.f35662c = abstractC0417a.f35665c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f35660a);
    }

    public long b() {
        return this.f35661b;
    }

    public String c() {
        return this.f35662c;
    }
}
