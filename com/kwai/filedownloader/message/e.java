package com.kwai.filedownloader.message;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private volatile g f10955a;

    /* renamed from: b  reason: collision with root package name */
    private volatile b f10956b;

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f10957a = new e();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(MessageSnapshot messageSnapshot);
    }

    public static e a() {
        return a.f10957a;
    }

    public void a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwai.filedownloader.message.b) {
            if (this.f10956b != null) {
                this.f10956b.a(messageSnapshot);
            }
        } else if (this.f10955a != null) {
            this.f10955a.a(messageSnapshot);
        }
    }

    public void a(b bVar) {
        this.f10956b = bVar;
        if (bVar == null) {
            this.f10955a = null;
        } else {
            this.f10955a = new g(5, bVar);
        }
    }
}
