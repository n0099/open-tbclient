package d.a.o0.b0;

import com.baidu.browser.core.util.BdLog;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: d.a.o0.b0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1242a {
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

    void a(int i2, C1242a c1242a);

    void b(int i2, String str, C1242a c1242a);
}
