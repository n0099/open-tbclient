package tv.chushou.apollo;
/* loaded from: classes5.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public boolean lFU;
    public int nUp;
    public int nUq;
    public int nUr;
    public int strokeWidth;

    public a(C0802a c0802a) {
        this.nUp = 20;
        this.nUq = 20;
        this.lFU = true;
        this.strokeWidth = 2;
        this.nUr = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.nUp = c0802a.nUp;
        this.nUq = c0802a.nUq;
        this.lFU = c0802a.lFU;
        this.strokeWidth = c0802a.strokeWidth;
        this.nUr = c0802a.nUr;
        this.isFullScreen = c0802a.isFullScreen;
        this.borderColor = c0802a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0802a {
        public int borderColor;
        public boolean isFullScreen;
        public boolean lFU;
        public int nUp;
        public int nUq;
        public int nUr;
        public int strokeWidth;

        public C0802a wZ(boolean z) {
            this.lFU = z;
            return this;
        }

        public C0802a Ob(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C0802a Oc(int i) {
            this.nUr = i;
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

        public a dPD() {
            return new a(this);
        }
    }
}
