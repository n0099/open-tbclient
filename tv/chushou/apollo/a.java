package tv.chushou.apollo;
/* loaded from: classes6.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int qkF;
    public int qkG;
    public boolean qkH;
    public int qkI;
    public int strokeWidth;

    public a(C1110a c1110a) {
        this.qkF = 20;
        this.qkG = 20;
        this.qkH = true;
        this.strokeWidth = 2;
        this.qkI = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.qkF = c1110a.qkF;
        this.qkG = c1110a.qkG;
        this.qkH = c1110a.qkH;
        this.strokeWidth = c1110a.strokeWidth;
        this.qkI = c1110a.qkI;
        this.isFullScreen = c1110a.isFullScreen;
        this.borderColor = c1110a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1110a {
        public int borderColor;
        public boolean isFullScreen;
        public int qkF;
        public int qkG;
        public boolean qkH;
        public int qkI;
        public int strokeWidth;

        public C1110a Bo(boolean z) {
            this.qkH = z;
            return this;
        }

        public C1110a RP(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C1110a RQ(int i) {
            this.qkI = i;
            return this;
        }

        public C1110a Bp(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C1110a RR(int i) {
            this.borderColor = i;
            return this;
        }

        public a eGZ() {
            return new a(this);
        }
    }
}
