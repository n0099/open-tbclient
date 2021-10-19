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
    public final List<com.meizu.cloud.pushsdk.c.a.b> f75155a;

    /* renamed from: b  reason: collision with root package name */
    public final long f75156b;

    /* renamed from: c  reason: collision with root package name */
    public final String f75157c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC2043a<T extends AbstractC2043a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f75158a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f75159b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f75160c = e.b();

        public abstract T a();

        public T a(long j2) {
            this.f75159b = j2;
            return a();
        }
    }

    public a(AbstractC2043a<?> abstractC2043a) {
        d.a(abstractC2043a.f75158a);
        d.a(abstractC2043a.f75160c);
        d.a(!abstractC2043a.f75160c.isEmpty(), "eventId cannot be empty");
        this.f75155a = abstractC2043a.f75158a;
        this.f75156b = abstractC2043a.f75159b;
        this.f75157c = abstractC2043a.f75160c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f75155a);
    }

    public long b() {
        return this.f75156b;
    }

    public String c() {
        return this.f75157c;
    }
}
