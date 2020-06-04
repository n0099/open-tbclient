package tv.chushou.apollo;
/* loaded from: classes5.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int nMj;
    public int nMk;
    public boolean nMl;
    public int nMm;
    public int strokeWidth;

    public a(C0910a c0910a) {
        this.nMj = 20;
        this.nMk = 20;
        this.nMl = true;
        this.strokeWidth = 2;
        this.nMm = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.nMj = c0910a.nMj;
        this.nMk = c0910a.nMk;
        this.nMl = c0910a.nMl;
        this.strokeWidth = c0910a.strokeWidth;
        this.nMm = c0910a.nMm;
        this.isFullScreen = c0910a.isFullScreen;
        this.borderColor = c0910a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0910a {
        public int borderColor;
        public boolean isFullScreen;
        public int nMj;
        public int nMk;
        public boolean nMl;
        public int nMm;
        public int strokeWidth;

        public C0910a xm(boolean z) {
            this.nMl = z;
            return this;
        }

        public C0910a Ko(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C0910a Kp(int i) {
            this.nMm = i;
            return this;
        }

        public C0910a xn(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C0910a Kq(int i) {
            this.borderColor = i;
            return this;
        }

        public a dRj() {
            return new a(this);
        }
    }
}
