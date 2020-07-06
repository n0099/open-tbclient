package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public final class c extends kotlin.b.a {
    public static final a nQg = new a(null);
    private static final c nQf = new c((char) 1, (char) 0);

    public c(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.b.a
    public boolean isEmpty() {
        return dQR() > dQS();
    }

    @Override // kotlin.b.a
    public boolean equals(Object obj) {
        return (obj instanceof c) && ((isEmpty() && ((c) obj).isEmpty()) || (dQR() == ((c) obj).dQR() && dQS() == ((c) obj).dQS()));
    }

    @Override // kotlin.b.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (dQR() * 31) + dQS();
    }

    @Override // kotlin.b.a
    public String toString() {
        return dQR() + IStringUtil.TOP_PATH + dQS();
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
