package d.b.i0.z;

import com.baidu.browser.core.util.BdLog;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: d.b.i0.z.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1730a {
        public void a(int i, int i2) {
            if (i != 1 && i != 2 && i != 3 && BdLog.e()) {
                throw new IllegalArgumentException("invalid source code");
            }
        }

        public void b(int i) {
            if (i != 1 && i != 2 && i != 3 && BdLog.e()) {
                throw new IllegalArgumentException("invalid source code");
            }
        }
    }

    void a(int i, C1730a c1730a);

    void b(int i, String str, C1730a c1730a);
}
