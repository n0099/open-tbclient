package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected final List<com.meizu.cloud.pushsdk.c.a.b> f7408a;
    protected final long b;
    protected final String c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC1188a<T extends AbstractC1188a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private List<com.meizu.cloud.pushsdk.c.a.b> f7409a = new LinkedList();
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
    public a(AbstractC1188a<?> abstractC1188a) {
        d.a(((AbstractC1188a) abstractC1188a).f7409a);
        d.a(((AbstractC1188a) abstractC1188a).c);
        d.a(!((AbstractC1188a) abstractC1188a).c.isEmpty(), "eventId cannot be empty");
        this.f7408a = ((AbstractC1188a) abstractC1188a).f7409a;
        this.b = ((AbstractC1188a) abstractC1188a).b;
        this.c = ((AbstractC1188a) abstractC1188a).c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a(TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f7408a);
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
