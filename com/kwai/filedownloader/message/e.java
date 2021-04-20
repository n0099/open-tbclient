package com.kwai.filedownloader.message;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public volatile g f37350a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f37351b;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f37352a = new e();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(MessageSnapshot messageSnapshot);
    }

    public static e a() {
        return a.f37352a;
    }

    public void a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwai.filedownloader.message.b) {
            if (this.f37351b != null) {
                this.f37351b.a(messageSnapshot);
            }
        } else if (this.f37350a != null) {
            this.f37350a.a(messageSnapshot);
        }
    }

    public void a(b bVar) {
        this.f37351b = bVar;
        if (bVar == null) {
            this.f37350a = null;
        } else {
            this.f37350a = new g(5, bVar);
        }
    }
}
