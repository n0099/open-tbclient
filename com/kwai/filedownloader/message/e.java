package com.kwai.filedownloader.message;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private volatile g f11255a;

    /* renamed from: b  reason: collision with root package name */
    private volatile b f11256b;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f11257a = new e();
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(MessageSnapshot messageSnapshot);
    }

    public static e a() {
        return a.f11257a;
    }

    public void a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwai.filedownloader.message.b) {
            if (this.f11256b != null) {
                this.f11256b.a(messageSnapshot);
            }
        } else if (this.f11255a != null) {
            this.f11255a.a(messageSnapshot);
        }
    }

    public void a(b bVar) {
        this.f11256b = bVar;
        if (bVar == null) {
            this.f11255a = null;
        } else {
            this.f11255a = new g(5, bVar);
        }
    }
}
