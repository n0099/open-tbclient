package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes14.dex */
public final class c extends kotlin.b.a {
    public static final a quD = new a(null);
    private static final c quC = new c((char) 1, (char) 0);

    public c(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.b.a
    public boolean isEmpty() {
        return eLg() > eLh();
    }

    @Override // kotlin.b.a
    public boolean equals(Object obj) {
        return (obj instanceof c) && ((isEmpty() && ((c) obj).isEmpty()) || (eLg() == ((c) obj).eLg() && eLh() == ((c) obj).eLh()));
    }

    @Override // kotlin.b.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (eLg() * 31) + eLh();
    }

    @Override // kotlin.b.a
    public String toString() {
        return "" + eLg() + IStringUtil.TOP_PATH + eLh();
    }

    @kotlin.e
    /* loaded from: classes14.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
