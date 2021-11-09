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
    public final List<com.meizu.cloud.pushsdk.c.a.b> f67516a;

    /* renamed from: b  reason: collision with root package name */
    public final long f67517b;

    /* renamed from: c  reason: collision with root package name */
    public final String f67518c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC1953a<T extends AbstractC1953a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f67519a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f67520b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f67521c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f67520b = j;
            return a();
        }
    }

    public a(AbstractC1953a<?> abstractC1953a) {
        d.a(abstractC1953a.f67519a);
        d.a(abstractC1953a.f67521c);
        d.a(!abstractC1953a.f67521c.isEmpty(), "eventId cannot be empty");
        this.f67516a = abstractC1953a.f67519a;
        this.f67517b = abstractC1953a.f67520b;
        this.f67518c = abstractC1953a.f67521c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f67516a);
    }

    public long b() {
        return this.f67517b;
    }

    public String c() {
        return this.f67518c;
    }
}
