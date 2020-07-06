package tv.chushou.apollo;
/* loaded from: classes5.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int oia;
    public int oib;
    public boolean oic;
    public int oid;
    public int strokeWidth;

    public a(C0930a c0930a) {
        this.oia = 20;
        this.oib = 20;
        this.oic = true;
        this.strokeWidth = 2;
        this.oid = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.oia = c0930a.oia;
        this.oib = c0930a.oib;
        this.oic = c0930a.oic;
        this.strokeWidth = c0930a.strokeWidth;
        this.oid = c0930a.oid;
        this.isFullScreen = c0930a.isFullScreen;
        this.borderColor = c0930a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0930a {
        public int borderColor;
        public boolean isFullScreen;
        public int oia;
        public int oib;
        public boolean oic;
        public int oid;
        public int strokeWidth;

        public C0930a xH(boolean z) {
            this.oic = z;
            return this;
        }

        public C0930a Lv(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C0930a Lw(int i) {
            this.oid = i;
            return this;
        }

        public C0930a xI(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C0930a Lx(int i) {
            this.borderColor = i;
            return this;
        }

        public a dVT() {
            return new a(this);
        }
    }
}
