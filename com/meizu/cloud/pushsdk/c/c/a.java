package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.meizu.cloud.pushsdk.c.a.b> f68429a;

    /* renamed from: b  reason: collision with root package name */
    public final long f68430b;

    /* renamed from: c  reason: collision with root package name */
    public final String f68431c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC1993a<T extends AbstractC1993a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f68432a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f68433b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f68434c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f68433b = j;
            return a();
        }
    }

    public a(AbstractC1993a<?> abstractC1993a) {
        d.a(abstractC1993a.f68432a);
        d.a(abstractC1993a.f68434c);
        d.a(!abstractC1993a.f68434c.isEmpty(), "eventId cannot be empty");
        this.f68429a = abstractC1993a.f68432a;
        this.f68430b = abstractC1993a.f68433b;
        this.f68431c = abstractC1993a.f68434c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f68429a);
    }

    public long b() {
        return this.f68430b;
    }

    public String c() {
        return this.f68431c;
    }
}
