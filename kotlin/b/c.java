package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes5.dex */
public final class c extends kotlin.b.a {
    public static final a oCO = new a(null);
    private static final c oCN = new c((char) 1, (char) 0);

    public c(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.b.a
    public boolean isEmpty() {
        return ekw() > ekx();
    }

    @Override // kotlin.b.a
    public boolean equals(Object obj) {
        return (obj instanceof c) && ((isEmpty() && ((c) obj).isEmpty()) || (ekw() == ((c) obj).ekw() && ekx() == ((c) obj).ekx()));
    }

    @Override // kotlin.b.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (ekw() * 31) + ekx();
    }

    @Override // kotlin.b.a
    public String toString() {
        return ekw() + IStringUtil.TOP_PATH + ekx();
    }

    @kotlin.h
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
