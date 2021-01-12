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

    /* renamed from: a  reason: collision with root package name */
    protected final List<com.meizu.cloud.pushsdk.c.a.b> f11274a;

    /* renamed from: b  reason: collision with root package name */
    protected final long f11275b;
    protected final String c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static abstract class AbstractC1165a<T extends AbstractC1165a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private List<com.meizu.cloud.pushsdk.c.a.b> f11276a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        private long f11277b = System.currentTimeMillis();
        private String c = e.b();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract T a();

        public T a(long j) {
            this.f11277b = j;
            return a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(AbstractC1165a<?> abstractC1165a) {
        d.a(((AbstractC1165a) abstractC1165a).f11276a);
        d.a(((AbstractC1165a) abstractC1165a).c);
        d.a(!((AbstractC1165a) abstractC1165a).c.isEmpty(), "eventId cannot be empty");
        this.f11274a = ((AbstractC1165a) abstractC1165a).f11276a;
        this.f11275b = ((AbstractC1165a) abstractC1165a).f11277b;
        this.c = ((AbstractC1165a) abstractC1165a).c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a(TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f11274a);
    }

    public long b() {
        return this.f11275b;
    }

    public String c() {
        return this.c;
    }
}
