package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public final List<com.meizu.cloud.pushsdk.c.a.b> a;

    /* renamed from: b  reason: collision with root package name */
    public final long f57261b;

    /* renamed from: c  reason: collision with root package name */
    public final String f57262c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractC2164a<T extends AbstractC2164a<T>> {
        public List<com.meizu.cloud.pushsdk.c.a.b> a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f57263b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f57264c = e.b();

        public abstract T a();

        public T a(long j2) {
            this.f57263b = j2;
            return a();
        }
    }

    public a(AbstractC2164a<?> abstractC2164a) {
        d.a(abstractC2164a.a);
        d.a(abstractC2164a.f57264c);
        d.a(!abstractC2164a.f57264c.isEmpty(), "eventId cannot be empty");
        this.a = abstractC2164a.a;
        this.f57261b = abstractC2164a.f57263b;
        this.f57262c = abstractC2164a.f57264c;
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
        return this.f57261b;
    }

    public String c() {
        return this.f57262c;
    }
}
