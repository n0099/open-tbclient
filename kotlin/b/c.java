package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes20.dex */
public final class c extends kotlin.b.a {
    public static final a osP = new a(null);
    private static final c osO = new c((char) 1, (char) 0);

    public c(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.b.a
    public boolean isEmpty() {
        return egq() > egr();
    }

    @Override // kotlin.b.a
    public boolean equals(Object obj) {
        return (obj instanceof c) && ((isEmpty() && ((c) obj).isEmpty()) || (egq() == ((c) obj).egq() && egr() == ((c) obj).egr()));
    }

    @Override // kotlin.b.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (egq() * 31) + egr();
    }

    @Override // kotlin.b.a
    public String toString() {
        return egq() + IStringUtil.TOP_PATH + egr();
    }

    @kotlin.h
    /* loaded from: classes20.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
