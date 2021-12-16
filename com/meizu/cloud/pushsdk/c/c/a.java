package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public final List<com.meizu.cloud.pushsdk.c.a.b> a;

    /* renamed from: b  reason: collision with root package name */
    public final long f61008b;

    /* renamed from: c  reason: collision with root package name */
    public final String f61009c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC2145a<T extends AbstractC2145a<T>> {
        public List<com.meizu.cloud.pushsdk.c.a.b> a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f61010b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f61011c = e.b();

        public abstract T a();

        public T a(long j2) {
            this.f61010b = j2;
            return a();
        }
    }

    public a(AbstractC2145a<?> abstractC2145a) {
        d.a(abstractC2145a.a);
        d.a(abstractC2145a.f61011c);
        d.a(!abstractC2145a.f61011c.isEmpty(), "eventId cannot be empty");
        this.a = abstractC2145a.a;
        this.f61008b = abstractC2145a.f61010b;
        this.f61009c = abstractC2145a.f61011c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a(TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.a);
    }

    public long b() {
        return this.f61008b;
    }

    public String c() {
        return this.f61009c;
    }
}
