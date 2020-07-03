package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public final class c extends kotlin.b.a {
    public static final a nQd = new a(null);
    private static final c nQc = new c((char) 1, (char) 0);

    public c(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.b.a
    public boolean isEmpty() {
        return dQN() > dQO();
    }

    @Override // kotlin.b.a
    public boolean equals(Object obj) {
        return (obj instanceof c) && ((isEmpty() && ((c) obj).isEmpty()) || (dQN() == ((c) obj).dQN() && dQO() == ((c) obj).dQO()));
    }

    @Override // kotlin.b.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (dQN() * 31) + dQO();
    }

    @Override // kotlin.b.a
    public String toString() {
        return dQN() + IStringUtil.TOP_PATH + dQO();
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
