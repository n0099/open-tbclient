package com.kwai.filedownloader.message;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public volatile g f35167a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f35168b;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f35169a = new e();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(MessageSnapshot messageSnapshot);
    }

    public static e a() {
        return a.f35169a;
    }

    public void a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwai.filedownloader.message.b) {
            if (this.f35168b != null) {
                this.f35168b.a(messageSnapshot);
            }
        } else if (this.f35167a != null) {
            this.f35167a.a(messageSnapshot);
        }
    }

    public void a(b bVar) {
        this.f35168b = bVar;
        if (bVar == null) {
            this.f35167a = null;
        } else {
            this.f35167a = new g(5, bVar);
        }
    }
}
