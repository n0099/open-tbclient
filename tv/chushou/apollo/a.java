package tv.chushou.apollo;
/* loaded from: classes6.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int pjU;
    public int pjV;
    public boolean pjW;
    public int pjX;
    public int strokeWidth;

    public a(C1018a c1018a) {
        this.pjU = 20;
        this.pjV = 20;
        this.pjW = true;
        this.strokeWidth = 2;
        this.pjX = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.pjU = c1018a.pjU;
        this.pjV = c1018a.pjV;
        this.pjW = c1018a.pjW;
        this.strokeWidth = c1018a.strokeWidth;
        this.pjX = c1018a.pjX;
        this.isFullScreen = c1018a.isFullScreen;
        this.borderColor = c1018a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1018a {
        public int borderColor;
        public boolean isFullScreen;
        public int pjU;
        public int pjV;
        public boolean pjW;
        public int pjX;
        public int strokeWidth;

        public C1018a zV(boolean z) {
            this.pjW = z;
            return this;
        }

        public C1018a PD(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C1018a PE(int i) {
            this.pjX = i;
            return this;
        }

        public C1018a zW(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C1018a PF(int i) {
            this.borderColor = i;
            return this;
        }

        public a etm() {
            return new a(this);
        }
    }
}
