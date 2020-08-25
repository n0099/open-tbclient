package tv.chushou.apollo;
/* loaded from: classes6.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int oKF;
    public int oKG;
    public boolean oKH;
    public int oKI;
    public int strokeWidth;

    public a(C1003a c1003a) {
        this.oKF = 20;
        this.oKG = 20;
        this.oKH = true;
        this.strokeWidth = 2;
        this.oKI = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.oKF = c1003a.oKF;
        this.oKG = c1003a.oKG;
        this.oKH = c1003a.oKH;
        this.strokeWidth = c1003a.strokeWidth;
        this.oKI = c1003a.oKI;
        this.isFullScreen = c1003a.isFullScreen;
        this.borderColor = c1003a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1003a {
        public int borderColor;
        public boolean isFullScreen;
        public int oKF;
        public int oKG;
        public boolean oKH;
        public int oKI;
        public int strokeWidth;

        public C1003a ze(boolean z) {
            this.oKH = z;
            return this;
        }

        public C1003a Os(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C1003a Ot(int i) {
            this.oKI = i;
            return this;
        }

        public C1003a zf(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C1003a Ou(int i) {
            this.borderColor = i;
            return this;
        }

        public a elu() {
            return new a(this);
        }
    }
}
