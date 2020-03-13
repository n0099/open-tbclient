package tv.chushou.apollo;
/* loaded from: classes5.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public boolean lGf;
    public int nUA;
    public int nUB;
    public int nUC;
    public int strokeWidth;

    public a(C0802a c0802a) {
        this.nUA = 20;
        this.nUB = 20;
        this.lGf = true;
        this.strokeWidth = 2;
        this.nUC = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.nUA = c0802a.nUA;
        this.nUB = c0802a.nUB;
        this.lGf = c0802a.lGf;
        this.strokeWidth = c0802a.strokeWidth;
        this.nUC = c0802a.nUC;
        this.isFullScreen = c0802a.isFullScreen;
        this.borderColor = c0802a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0802a {
        public int borderColor;
        public boolean isFullScreen;
        public boolean lGf;
        public int nUA;
        public int nUB;
        public int nUC;
        public int strokeWidth;

        public C0802a wZ(boolean z) {
            this.lGf = z;
            return this;
        }

        public C0802a Ob(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C0802a Oc(int i) {
            this.nUC = i;
            return this;
        }

        public C0802a xa(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C0802a Od(int i) {
            this.borderColor = i;
            return this;
        }

        public a dPE() {
            return new a(this);
        }
    }
}
