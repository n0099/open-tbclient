package tv.chushou.apollo;
/* loaded from: classes6.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int oqJ;
    public int oqK;
    public boolean oqL;
    public int oqM;
    public int strokeWidth;

    public a(C0945a c0945a) {
        this.oqJ = 20;
        this.oqK = 20;
        this.oqL = true;
        this.strokeWidth = 2;
        this.oqM = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.oqJ = c0945a.oqJ;
        this.oqK = c0945a.oqK;
        this.oqL = c0945a.oqL;
        this.strokeWidth = c0945a.strokeWidth;
        this.oqM = c0945a.oqM;
        this.isFullScreen = c0945a.isFullScreen;
        this.borderColor = c0945a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0945a {
        public int borderColor;
        public boolean isFullScreen;
        public int oqJ;
        public int oqK;
        public boolean oqL;
        public int oqM;
        public int strokeWidth;

        public C0945a ym(boolean z) {
            this.oqL = z;
            return this;
        }

        public C0945a LP(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C0945a LQ(int i) {
            this.oqM = i;
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

        public a dZp() {
            return new a(this);
        }
    }
}
