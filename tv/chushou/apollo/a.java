package tv.chushou.apollo;
/* loaded from: classes6.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int oqL;
    public int oqM;
    public boolean oqN;
    public int oqO;
    public int strokeWidth;

    public a(C0945a c0945a) {
        this.oqL = 20;
        this.oqM = 20;
        this.oqN = true;
        this.strokeWidth = 2;
        this.oqO = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.oqL = c0945a.oqL;
        this.oqM = c0945a.oqM;
        this.oqN = c0945a.oqN;
        this.strokeWidth = c0945a.strokeWidth;
        this.oqO = c0945a.oqO;
        this.isFullScreen = c0945a.isFullScreen;
        this.borderColor = c0945a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0945a {
        public int borderColor;
        public boolean isFullScreen;
        public int oqL;
        public int oqM;
        public boolean oqN;
        public int oqO;
        public int strokeWidth;

        public C0945a ym(boolean z) {
            this.oqN = z;
            return this;
        }

        public C0945a LP(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C0945a LQ(int i) {
            this.oqO = i;
            return this;
        }

        public C0945a yn(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C0945a LR(int i) {
            this.borderColor = i;
            return this;
        }

        public a dZq() {
            return new a(this);
        }
    }
}
