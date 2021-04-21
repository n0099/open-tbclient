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
    public final List<com.meizu.cloud.pushsdk.c.a.b> f38106a;

    /* renamed from: b  reason: collision with root package name */
    public final long f38107b;

    /* renamed from: c  reason: collision with root package name */
    public final String f38108c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC0473a<T extends AbstractC0473a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f38109a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f38110b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f38111c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f38110b = j;
            return a();
        }
    }

    public a(AbstractC0473a<?> abstractC0473a) {
        d.a(abstractC0473a.f38109a);
        d.a(abstractC0473a.f38111c);
        d.a(!abstractC0473a.f38111c.isEmpty(), "eventId cannot be empty");
        this.f38106a = abstractC0473a.f38109a;
        this.f38107b = abstractC0473a.f38110b;
        this.f38108c = abstractC0473a.f38111c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f38106a);
    }

    public long b() {
        return this.f38107b;
    }

    public String c() {
        return this.f38108c;
    }
}
