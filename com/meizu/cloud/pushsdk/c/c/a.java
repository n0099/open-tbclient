package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public final List<com.meizu.cloud.pushsdk.c.a.b> a;

    /* renamed from: b  reason: collision with root package name */
    public final long f42095b;

    /* renamed from: c  reason: collision with root package name */
    public final String f42096c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static abstract class AbstractC2025a<T extends AbstractC2025a<T>> {
        public List<com.meizu.cloud.pushsdk.c.a.b> a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f42097b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f42098c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f42097b = j;
            return a();
        }
    }

    public a(AbstractC2025a<?> abstractC2025a) {
        d.a(abstractC2025a.a);
        d.a(abstractC2025a.f42098c);
        d.a(!abstractC2025a.f42098c.isEmpty(), "eventId cannot be empty");
        this.a = abstractC2025a.a;
        this.f42095b = abstractC2025a.f42097b;
        this.f42096c = abstractC2025a.f42098c;
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
        return this.f42095b;
    }

    public String c() {
        return this.f42096c;
    }
}
