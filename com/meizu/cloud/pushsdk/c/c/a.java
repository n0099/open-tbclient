package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public final List a;
    public final long b;
    public final String c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public abstract class AbstractC0637a {
        public List a = new LinkedList();
        public long b = System.currentTimeMillis();
        public String c = e.b();

        public abstract AbstractC0637a a();

        public AbstractC0637a a(long j) {
            this.b = j;
            return a();
        }
    }

    public a(AbstractC0637a abstractC0637a) {
        d.a(abstractC0637a.a);
        d.a(abstractC0637a.c);
        d.a(!abstractC0637a.c.isEmpty(), "eventId cannot be empty");
        this.a = abstractC0637a.a;
        this.b = abstractC0637a.b;
        this.c = abstractC0637a.c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List a() {
        return new ArrayList(this.a);
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
