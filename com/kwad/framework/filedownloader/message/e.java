package com.kwad.framework.filedownloader.message;
/* loaded from: classes10.dex */
public final class e {
    public volatile g ahd;
    public volatile b ahe;

    /* loaded from: classes10.dex */
    public interface b {
        void r(MessageSnapshot messageSnapshot);
    }

    /* loaded from: classes10.dex */
    public static final class a {
        public static final e ahf = new e();
    }

    public static e vV() {
        return a.ahf;
    }

    public final void a(b bVar) {
        this.ahe = bVar;
        if (bVar == null) {
            this.ahd = null;
        } else {
            this.ahd = new g(5, bVar);
        }
    }

    public final void s(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwad.framework.filedownloader.message.b) {
            if (this.ahe != null) {
                this.ahe.r(messageSnapshot);
            }
        } else if (this.ahd != null) {
            this.ahd.u(messageSnapshot);
        }
    }
}
