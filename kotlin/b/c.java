package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes10.dex */
public final class c extends kotlin.b.a {
    public static final a pSU = new a(null);
    private static final c pST = new c((char) 1, (char) 0);

    public c(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.b.a
    public boolean isEmpty() {
        return eBW() > eBX();
    }

    @Override // kotlin.b.a
    public boolean equals(Object obj) {
        return (obj instanceof c) && ((isEmpty() && ((c) obj).isEmpty()) || (eBW() == ((c) obj).eBW() && eBX() == ((c) obj).eBX()));
    }

    @Override // kotlin.b.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (eBW() * 31) + eBX();
    }

    @Override // kotlin.b.a
    public String toString() {
        return eBW() + IStringUtil.TOP_PATH + eBX();
    }

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
