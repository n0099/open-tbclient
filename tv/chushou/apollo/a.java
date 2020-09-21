package tv.chushou.apollo;
/* loaded from: classes6.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int oUB;
    public int oUC;
    public boolean oUD;
    public int oUE;
    public int strokeWidth;

    public a(C1000a c1000a) {
        this.oUB = 20;
        this.oUC = 20;
        this.oUD = true;
        this.strokeWidth = 2;
        this.oUE = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.oUB = c1000a.oUB;
        this.oUC = c1000a.oUC;
        this.oUD = c1000a.oUD;
        this.strokeWidth = c1000a.strokeWidth;
        this.oUE = c1000a.oUE;
        this.isFullScreen = c1000a.isFullScreen;
        this.borderColor = c1000a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1000a {
        public int borderColor;
        public boolean isFullScreen;
        public int oUB;
        public int oUC;
        public boolean oUD;
        public int oUE;
        public int strokeWidth;

        public C1000a zo(boolean z) {
            this.oUD = z;
            return this;
        }

        public C1000a OX(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C1000a OY(int i) {
            this.oUE = i;
            return this;
        }

        public C1000a zp(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C1000a OZ(int i) {
            this.borderColor = i;
            return this;
        }

        public a epB() {
            return new a(this);
        }
    }
}
