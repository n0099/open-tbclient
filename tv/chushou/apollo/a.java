package tv.chushou.apollo;
/* loaded from: classes6.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int oKX;
    public int oKY;
    public boolean oKZ;
    public int oLa;
    public int strokeWidth;

    public a(C1003a c1003a) {
        this.oKX = 20;
        this.oKY = 20;
        this.oKZ = true;
        this.strokeWidth = 2;
        this.oLa = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.oKX = c1003a.oKX;
        this.oKY = c1003a.oKY;
        this.oKZ = c1003a.oKZ;
        this.strokeWidth = c1003a.strokeWidth;
        this.oLa = c1003a.oLa;
        this.isFullScreen = c1003a.isFullScreen;
        this.borderColor = c1003a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1003a {
        public int borderColor;
        public boolean isFullScreen;
        public int oKX;
        public int oKY;
        public boolean oKZ;
        public int oLa;
        public int strokeWidth;

        public C1003a zg(boolean z) {
            this.oKZ = z;
            return this;
        }

        public C1003a Os(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C1003a Ot(int i) {
            this.oLa = i;
            return this;
        }

        public C1003a zh(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C1003a Ou(int i) {
            this.borderColor = i;
            return this;
        }

        public a elD() {
            return new a(this);
        }
    }
}
