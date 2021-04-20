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
    public final List<com.meizu.cloud.pushsdk.c.a.b> f38011a;

    /* renamed from: b  reason: collision with root package name */
    public final long f38012b;

    /* renamed from: c  reason: collision with root package name */
    public final String f38013c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC0470a<T extends AbstractC0470a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f38014a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f38015b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f38016c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f38015b = j;
            return a();
        }
    }

    public a(AbstractC0470a<?> abstractC0470a) {
        d.a(abstractC0470a.f38014a);
        d.a(abstractC0470a.f38016c);
        d.a(!abstractC0470a.f38016c.isEmpty(), "eventId cannot be empty");
        this.f38011a = abstractC0470a.f38014a;
        this.f38012b = abstractC0470a.f38015b;
        this.f38013c = abstractC0470a.f38016c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f38011a);
    }

    public long b() {
        return this.f38012b;
    }

    public String c() {
        return this.f38013c;
    }
}
