package com.kwai.filedownloader.message;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public volatile g f37923a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f37924b;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f37925a = new e();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(MessageSnapshot messageSnapshot);
    }

    public static e a() {
        return a.f37925a;
    }

    public void a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwai.filedownloader.message.b) {
            if (this.f37924b != null) {
                this.f37924b.a(messageSnapshot);
            }
        } else if (this.f37923a != null) {
            this.f37923a.a(messageSnapshot);
        }
    }

    public void a(b bVar) {
        this.f37924b = bVar;
        if (bVar == null) {
            this.f37923a = null;
        } else {
            this.f37923a = new g(5, bVar);
        }
    }
}
