package com.kwai.filedownloader.message;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public volatile g f34412a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f34413b;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f34414a = new e();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(MessageSnapshot messageSnapshot);
    }

    public static e a() {
        return a.f34414a;
    }

    public void a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwai.filedownloader.message.b) {
            if (this.f34413b != null) {
                this.f34413b.a(messageSnapshot);
            }
        } else if (this.f34412a != null) {
            this.f34412a.a(messageSnapshot);
        }
    }

    public void a(b bVar) {
        this.f34413b = bVar;
        if (bVar == null) {
            this.f34412a = null;
        } else {
            this.f34412a = new g(5, bVar);
        }
    }
}
