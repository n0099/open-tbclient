package d.b.b.e.d;

import com.baidu.adp.lib.util.BdLog;
import d.b.b.e.d.l;
/* loaded from: classes.dex */
public class n<T> extends m<T> {
    public n(String str, k<T> kVar) {
        super(str, kVar);
    }

    @Override // d.b.b.e.d.m, d.b.b.e.d.l
    public void e(String str, T t, long j) {
        try {
            super.e(str, t, j);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
        }
    }

    @Override // d.b.b.e.d.m, d.b.b.e.d.l
    public T get(String str) {
        try {
            return (T) super.get(str);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
                return null;
            }
            return null;
        }
    }

    @Override // d.b.b.e.d.m, d.b.b.e.d.l
    public l.b<T> h(String str) {
        try {
            return super.h(str);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
                return null;
            }
            return null;
        }
    }

    @Override // d.b.b.e.d.m, d.b.b.e.d.l
    public void remove(String str) {
        try {
            super.remove(str);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
        }
    }
}
