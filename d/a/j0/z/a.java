package d.a.j0.z;

import com.baidu.browser.core.util.BdLog;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: d.a.j0.z.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1690a {
        public void a(int i2, int i3) {
            if (i2 != 1 && i2 != 2 && i2 != 3 && BdLog.e()) {
                throw new IllegalArgumentException("invalid source code");
            }
        }

        public void b(int i2) {
            if (i2 != 1 && i2 != 2 && i2 != 3 && BdLog.e()) {
                throw new IllegalArgumentException("invalid source code");
            }
        }
    }

    void a(int i2, C1690a c1690a);

    void b(int i2, String str, C1690a c1690a);
}
