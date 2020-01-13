package tv.chushou.apollo;
/* loaded from: classes4.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public boolean lFg;
    public int nTu;
    public int nTv;
    public int nTw;
    public int strokeWidth;

    public a(C0794a c0794a) {
        this.nTu = 20;
        this.nTv = 20;
        this.lFg = true;
        this.strokeWidth = 2;
        this.nTw = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.nTu = c0794a.nTu;
        this.nTv = c0794a.nTv;
        this.lFg = c0794a.lFg;
        this.strokeWidth = c0794a.strokeWidth;
        this.nTw = c0794a.nTw;
        this.isFullScreen = c0794a.isFullScreen;
        this.borderColor = c0794a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0794a {
        public int borderColor;
        public boolean isFullScreen;
        public boolean lFg;
        public int nTu;
        public int nTv;
        public int nTw;
        public int strokeWidth;

        public C0794a wW(boolean z) {
            this.lFg = z;
            return this;
        }

        public C0794a NY(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C0794a NZ(int i) {
            this.nTw = i;
            return this;
        }

        public C0794a wX(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C0794a Oa(int i) {
            this.borderColor = i;
            return this;
        }

        public a dOm() {
            return new a(this);
        }
    }
}
