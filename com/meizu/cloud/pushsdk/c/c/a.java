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
    protected final List<com.meizu.cloud.pushsdk.c.a.b> a;
    protected final long b;
    protected final String c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractC0731a<T extends AbstractC0731a<T>> {
        private List<com.meizu.cloud.pushsdk.c.a.b> a = new LinkedList();
        private long b = System.currentTimeMillis();
        private String c = e.b();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract T a();

        public T a(long j) {
            this.b = j;
            return a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(AbstractC0731a<?> abstractC0731a) {
        d.a(((AbstractC0731a) abstractC0731a).a);
        d.a(((AbstractC0731a) abstractC0731a).c);
        d.a(!((AbstractC0731a) abstractC0731a).c.isEmpty(), "eventId cannot be empty");
        this.a = ((AbstractC0731a) abstractC0731a).a;
        this.b = ((AbstractC0731a) abstractC0731a).b;
        this.c = ((AbstractC0731a) abstractC0731a).c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
