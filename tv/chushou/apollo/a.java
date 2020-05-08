package tv.chushou.apollo;
/* loaded from: classes5.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int nqb;
    public int nqc;
    public boolean nqd;
    public int nqe;
    public int strokeWidth;

    public a(C0847a c0847a) {
        this.nqb = 20;
        this.nqc = 20;
        this.nqd = true;
        this.strokeWidth = 2;
        this.nqe = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.nqb = c0847a.nqb;
        this.nqc = c0847a.nqc;
        this.nqd = c0847a.nqd;
        this.strokeWidth = c0847a.strokeWidth;
        this.nqe = c0847a.nqe;
        this.isFullScreen = c0847a.isFullScreen;
        this.borderColor = c0847a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0847a {
        public int borderColor;
        public boolean isFullScreen;
        public int nqb;
        public int nqc;
        public boolean nqd;
        public int nqe;
        public int strokeWidth;

        public C0847a wM(boolean z) {
            this.nqd = z;
            return this;
        }

        public C0847a JB(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C0847a JC(int i) {
            this.nqe = i;
            return this;
        }

        public C0847a wN(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C0847a JD(int i) {
            this.borderColor = i;
            return this;
        }

        public a dJa() {
            return new a(this);
        }
    }
}
