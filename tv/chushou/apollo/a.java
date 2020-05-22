package tv.chushou.apollo;
/* loaded from: classes5.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int nKZ;
    public int nLa;
    public boolean nLb;
    public int nLc;
    public int strokeWidth;

    public a(C0909a c0909a) {
        this.nKZ = 20;
        this.nLa = 20;
        this.nLb = true;
        this.strokeWidth = 2;
        this.nLc = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.nKZ = c0909a.nKZ;
        this.nLa = c0909a.nLa;
        this.nLb = c0909a.nLb;
        this.strokeWidth = c0909a.strokeWidth;
        this.nLc = c0909a.nLc;
        this.isFullScreen = c0909a.isFullScreen;
        this.borderColor = c0909a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0909a {
        public int borderColor;
        public boolean isFullScreen;
        public int nKZ;
        public int nLa;
        public boolean nLb;
        public int nLc;
        public int strokeWidth;

        public C0909a xk(boolean z) {
            this.nLb = z;
            return this;
        }

        public C0909a Km(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C0909a Kn(int i) {
            this.nLc = i;
            return this;
        }

        public C0909a xl(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C0909a Ko(int i) {
            this.borderColor = i;
            return this;
        }

        public a dQV() {
            return new a(this);
        }
    }
}
