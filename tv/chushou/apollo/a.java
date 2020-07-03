package tv.chushou.apollo;
/* loaded from: classes5.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int ohX;
    public int ohY;
    public boolean ohZ;
    public int oia;
    public int strokeWidth;

    public a(C0929a c0929a) {
        this.ohX = 20;
        this.ohY = 20;
        this.ohZ = true;
        this.strokeWidth = 2;
        this.oia = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.ohX = c0929a.ohX;
        this.ohY = c0929a.ohY;
        this.ohZ = c0929a.ohZ;
        this.strokeWidth = c0929a.strokeWidth;
        this.oia = c0929a.oia;
        this.isFullScreen = c0929a.isFullScreen;
        this.borderColor = c0929a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0929a {
        public int borderColor;
        public boolean isFullScreen;
        public int ohX;
        public int ohY;
        public boolean ohZ;
        public int oia;
        public int strokeWidth;

        public C0929a xH(boolean z) {
            this.ohZ = z;
            return this;
        }

        public C0929a Lv(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C0929a Lw(int i) {
            this.oia = i;
            return this;
        }

        public C0929a xI(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C0929a Lx(int i) {
            this.borderColor = i;
            return this;
        }

        public a dVP() {
            return new a(this);
        }
    }
}
