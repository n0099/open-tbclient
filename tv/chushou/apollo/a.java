package tv.chushou.apollo;
/* loaded from: classes6.dex */
public class a {
    public int borderColor;
    public boolean isFullScreen;
    public int qmi;
    public int qmj;
    public boolean qmk;
    public int qml;
    public int strokeWidth;

    public a(C1113a c1113a) {
        this.qmi = 20;
        this.qmj = 20;
        this.qmk = true;
        this.strokeWidth = 2;
        this.qml = 800;
        this.isFullScreen = false;
        this.borderColor = -16711936;
        this.qmi = c1113a.qmi;
        this.qmj = c1113a.qmj;
        this.qmk = c1113a.qmk;
        this.strokeWidth = c1113a.strokeWidth;
        this.qml = c1113a.qml;
        this.isFullScreen = c1113a.isFullScreen;
        this.borderColor = c1113a.borderColor;
    }

    /* renamed from: tv.chushou.apollo.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1113a {
        public int borderColor;
        public boolean isFullScreen;
        public int qmi;
        public int qmj;
        public boolean qmk;
        public int qml;
        public int strokeWidth;

        public C1113a Bv(boolean z) {
            this.qmk = z;
            return this;
        }

        public C1113a Ss(int i) {
            this.strokeWidth = i;
            return this;
        }

        public C1113a St(int i) {
            this.qml = i;
            return this;
        }

        public C1113a Bw(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public C1113a Su(int i) {
            this.borderColor = i;
            return this;
        }

        public a eHa() {
            return new a(this);
        }
    }
}
