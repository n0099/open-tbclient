package com.kwai.filedownloader.message;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public volatile g f34341a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f34342b;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f34343a = new e();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(MessageSnapshot messageSnapshot);
    }

    public static e a() {
        return a.f34343a;
    }

    public void a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwai.filedownloader.message.b) {
            if (this.f34342b != null) {
                this.f34342b.a(messageSnapshot);
            }
        } else if (this.f34341a != null) {
            this.f34341a.a(messageSnapshot);
        }
    }

    public void a(b bVar) {
        this.f34342b = bVar;
        if (bVar == null) {
            this.f34341a = null;
        } else {
            this.f34341a = new g(5, bVar);
        }
    }
}
