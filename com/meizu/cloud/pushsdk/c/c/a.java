package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public final List<com.meizu.cloud.pushsdk.c.a.b> a;
    public final long b;
    public final String c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static abstract class AbstractC0425a<T extends AbstractC0425a<T>> {
        public List<com.meizu.cloud.pushsdk.c.a.b> a = new LinkedList();
        public long b = System.currentTimeMillis();
        public String c = e.b();

        public abstract T a();

        public T a(long j) {
            this.b = j;
            return a();
        }
    }

    public a(AbstractC0425a<?> abstractC0425a) {
        d.a(abstractC0425a.a);
        d.a(abstractC0425a.c);
        d.a(!abstractC0425a.c.isEmpty(), "eventId cannot be empty");
        this.a = abstractC0425a.a;
        this.b = abstractC0425a.b;
        this.c = abstractC0425a.c;
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
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
