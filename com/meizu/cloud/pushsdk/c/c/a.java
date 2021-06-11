package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.meizu.cloud.pushsdk.c.a.b> f38513a;

    /* renamed from: b  reason: collision with root package name */
    public final long f38514b;

    /* renamed from: c  reason: collision with root package name */
    public final String f38515c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static abstract class AbstractC0456a<T extends AbstractC0456a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f38516a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f38517b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f38518c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f38517b = j;
            return a();
        }
    }

    public a(AbstractC0456a<?> abstractC0456a) {
        d.a(abstractC0456a.f38516a);
        d.a(abstractC0456a.f38518c);
        d.a(!abstractC0456a.f38518c.isEmpty(), "eventId cannot be empty");
        this.f38513a = abstractC0456a.f38516a;
        this.f38514b = abstractC0456a.f38517b;
        this.f38515c = abstractC0456a.f38518c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f38513a);
    }

    public long b() {
        return this.f38514b;
    }

    public String c() {
        return this.f38515c;
    }
}
