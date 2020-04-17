package tv.chushou.apollo;
/* loaded from: classes5.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int npY;
    public int npZ;
    public boolean nqa;
    public int nqb;
    public int strokeWidth;

    public a(C0826a c0826a) {
        this.npY = 20;
        this.npZ = 20;
        this.nqa = true;
        this.strokeWidth = 2;
        this.nqb = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.npY = c0826a.npY;
        this.npZ = c0826a.npZ;
        this.nqa = c0826a.nqa;
        this.strokeWidth = c0826a.strokeWidth;
        this.nqb = c0826a.nqb;
        this.isFullScreen = c0826a.isFullScreen;
        this.borderColor = c0826a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0826a {
        public int borderColor;
        public boolean isFullScreen;
        public int npY;
        public int npZ;
        public boolean nqa;
        public int nqb;
        public int strokeWidth;

        public C0826a wM(boolean z) {
            this.nqa = z;
            return this;
        }

        public C0826a JB(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C0826a JC(int i) {
            this.nqb = i;
            return this;
        }

        public C0826a wN(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C0826a JD(int i) {
            this.borderColor = i;
            return this;
        }

        public a dJe() {
            return new a(this);
        }
    }
}
