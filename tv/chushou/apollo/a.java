package tv.chushou.apollo;
/* loaded from: classes5.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public boolean lHL;
    public int nWn;
    public int nWo;
    public int nWp;
    public int strokeWidth;

    public a(C0803a c0803a) {
        this.nWn = 20;
        this.nWo = 20;
        this.lHL = true;
        this.strokeWidth = 2;
        this.nWp = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.nWn = c0803a.nWn;
        this.nWo = c0803a.nWo;
        this.lHL = c0803a.lHL;
        this.strokeWidth = c0803a.strokeWidth;
        this.nWp = c0803a.nWp;
        this.isFullScreen = c0803a.isFullScreen;
        this.borderColor = c0803a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0803a {
        public int borderColor;
        public boolean isFullScreen;
        public boolean lHL;
        public int nWn;
        public int nWo;
        public int nWp;
        public int strokeWidth;

        public C0803a xh(boolean z) {
            this.lHL = z;
            return this;
        }

        public C0803a Oh(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C0803a Oi(int i) {
            this.nWp = i;
            return this;
        }

        public C0803a xi(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C0803a Oj(int i) {
            this.borderColor = i;
            return this;
        }

        public a dQe() {
            return new a(this);
        }
    }
}
