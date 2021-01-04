package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes5.dex */
public final class c extends kotlin.b.a {
    public static final a qmq = new a(null);
    private static final c qmp = new c((char) 1, (char) 0);

    public c(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.b.a
    public boolean isEmpty() {
        return eMm() > eMn();
    }

    @Override // kotlin.b.a
    public boolean equals(Object obj) {
        return (obj instanceof c) && ((isEmpty() && ((c) obj).isEmpty()) || (eMm() == ((c) obj).eMm() && eMn() == ((c) obj).eMn()));
    }

    @Override // kotlin.b.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (eMm() * 31) + eMn();
    }

    @Override // kotlin.b.a
    public String toString() {
        return "" + eMm() + IStringUtil.TOP_PATH + eMn();
    }

    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
