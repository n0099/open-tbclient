package com.kwai.filedownloader.message;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public volatile g f37825a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f37826b;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f37827a = new e();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(MessageSnapshot messageSnapshot);
    }

    public static e a() {
        return a.f37827a;
    }

    public void a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwai.filedownloader.message.b) {
            if (this.f37826b != null) {
                this.f37826b.a(messageSnapshot);
            }
        } else if (this.f37825a != null) {
            this.f37825a.a(messageSnapshot);
        }
    }

    public void a(b bVar) {
        this.f37826b = bVar;
        if (bVar == null) {
            this.f37825a = null;
        } else {
            this.f37825a = new g(5, bVar);
        }
    }
}
