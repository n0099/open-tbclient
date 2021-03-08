package com.kwai.filedownloader.message;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private volatile g f7226a;
    private volatile b b;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f7227a = new e();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(MessageSnapshot messageSnapshot);
    }

    public static e a() {
        return a.f7227a;
    }

    public void a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwai.filedownloader.message.b) {
            if (this.b != null) {
                this.b.a(messageSnapshot);
            }
        } else if (this.f7226a != null) {
            this.f7226a.a(messageSnapshot);
        }
    }

    public void a(b bVar) {
        this.b = bVar;
        if (bVar == null) {
            this.f7226a = null;
        } else {
            this.f7226a = new g(5, bVar);
        }
    }
}
