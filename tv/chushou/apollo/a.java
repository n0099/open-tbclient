package tv.chushou.apollo;
/* loaded from: classes4.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public boolean lFl;
    public int nTA;
    public int nTB;
    public int nTz;
    public int strokeWidth;

    public a(C0794a c0794a) {
        this.nTz = 20;
        this.nTA = 20;
        this.lFl = true;
        this.strokeWidth = 2;
        this.nTB = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.nTz = c0794a.nTz;
        this.nTA = c0794a.nTA;
        this.lFl = c0794a.lFl;
        this.strokeWidth = c0794a.strokeWidth;
        this.nTB = c0794a.nTB;
        this.isFullScreen = c0794a.isFullScreen;
        this.borderColor = c0794a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0794a {
        public int borderColor;
        public boolean isFullScreen;
        public boolean lFl;
        public int nTA;
        public int nTB;
        public int nTz;
        public int strokeWidth;

        public C0794a wW(boolean z) {
            this.lFl = z;
            return this;
        }

        public C0794a NY(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C0794a NZ(int i) {
            this.nTB = i;
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

        public a dOo() {
            return new a(this);
        }
    }
}
