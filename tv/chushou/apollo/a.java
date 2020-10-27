package tv.chushou.apollo;
/* loaded from: classes6.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int qbk;
    public int qbl;
    public boolean qbm;
    public int qbn;
    public int strokeWidth;

    public a(C1090a c1090a) {
        this.qbk = 20;
        this.qbl = 20;
        this.qbm = true;
        this.strokeWidth = 2;
        this.qbn = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.qbk = c1090a.qbk;
        this.qbl = c1090a.qbl;
        this.qbm = c1090a.qbm;
        this.strokeWidth = c1090a.strokeWidth;
        this.qbn = c1090a.qbn;
        this.isFullScreen = c1090a.isFullScreen;
        this.borderColor = c1090a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1090a {
        public int borderColor;
        public boolean isFullScreen;
        public int qbk;
        public int qbl;
        public boolean qbm;
        public int qbn;
        public int strokeWidth;

        public C1090a Bd(boolean z) {
            this.qbm = z;
            return this;
        }

        public C1090a Ru(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C1090a Rv(int i) {
            this.qbn = i;
            return this;
        }

        public C1090a Be(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C1090a Rw(int i) {
            this.borderColor = i;
            return this;
        }

        public a eDk() {
            return new a(this);
        }
    }
}
