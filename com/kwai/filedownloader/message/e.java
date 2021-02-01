package com.kwai.filedownloader.message;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private volatile g f10957a;

    /* renamed from: b  reason: collision with root package name */
    private volatile b f10958b;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f10959a = new e();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(MessageSnapshot messageSnapshot);
    }

    public static e a() {
        return a.f10959a;
    }

    public void a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwai.filedownloader.message.b) {
            if (this.f10958b != null) {
                this.f10958b.a(messageSnapshot);
            }
        } else if (this.f10957a != null) {
            this.f10957a.a(messageSnapshot);
        }
    }

    public void a(b bVar) {
        this.f10958b = bVar;
        if (bVar == null) {
            this.f10957a = null;
        } else {
            this.f10957a = new g(5, bVar);
        }
    }
}
