package tv.chushou.apollo;
/* loaded from: classes5.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public boolean lFS;
    public int nUn;
    public int nUo;
    public int nUp;
    public int strokeWidth;

    public a(C0802a c0802a) {
        this.nUn = 20;
        this.nUo = 20;
        this.lFS = true;
        this.strokeWidth = 2;
        this.nUp = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.nUn = c0802a.nUn;
        this.nUo = c0802a.nUo;
        this.lFS = c0802a.lFS;
        this.strokeWidth = c0802a.strokeWidth;
        this.nUp = c0802a.nUp;
        this.isFullScreen = c0802a.isFullScreen;
        this.borderColor = c0802a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0802a {
        public int borderColor;
        public boolean isFullScreen;
        public boolean lFS;
        public int nUn;
        public int nUo;
        public int nUp;
        public int strokeWidth;

        public C0802a wZ(boolean z) {
            this.lFS = z;
            return this;
        }

        public C0802a Ob(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C0802a Oc(int i) {
            this.nUp = i;
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

        public a dPB() {
            return new a(this);
        }
    }
}
