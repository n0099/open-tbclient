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
    public final List<com.meizu.cloud.pushsdk.c.a.b> f34905a;

    /* renamed from: b  reason: collision with root package name */
    public final long f34906b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34907c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC0404a<T extends AbstractC0404a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f34908a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f34909b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f34910c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f34909b = j;
            return a();
        }
    }

    public a(AbstractC0404a<?> abstractC0404a) {
        d.a(abstractC0404a.f34908a);
        d.a(abstractC0404a.f34910c);
        d.a(!abstractC0404a.f34910c.isEmpty(), "eventId cannot be empty");
        this.f34905a = abstractC0404a.f34908a;
        this.f34906b = abstractC0404a.f34909b;
        this.f34907c = abstractC0404a.f34910c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f34905a);
    }

    public long b() {
        return this.f34906b;
    }

    public String c() {
        return this.f34907c;
    }
}
