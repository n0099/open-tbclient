package com.meizu.cloud.pushsdk.d.c;

import com.meizu.cloud.pushsdk.d.a.c;
import com.meizu.cloud.pushsdk.d.f.d;
import com.meizu.cloud.pushsdk.d.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    public final List<com.meizu.cloud.pushsdk.d.a.b> a;
    public final long b;
    public final String c;

    /* renamed from: com.meizu.cloud.pushsdk.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC0719a<T extends AbstractC0719a<T>> {
        public List<com.meizu.cloud.pushsdk.d.a.b> a = new LinkedList();
        public long b = System.currentTimeMillis();
        public String c = e.b();

        public abstract T a();

        public T a(long j) {
            this.b = j;
            return a();
        }
    }

    public a(AbstractC0719a<?> abstractC0719a) {
        d.a(abstractC0719a.a);
        d.a(abstractC0719a.c);
        d.a(!abstractC0719a.c.isEmpty(), "eventId cannot be empty");
        this.a = abstractC0719a.a;
        this.b = abstractC0719a.b;
        this.c = abstractC0719a.c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.d.a.b> a() {
        return new ArrayList(this.a);
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
