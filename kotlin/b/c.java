package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes9.dex */
public final class c extends kotlin.b.a {
    public static final a pUx = new a(null);
    private static final c pUw = new c((char) 1, (char) 0);

    public c(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.b.a
    public boolean isEmpty() {
        return eBX() > eBY();
    }

    @Override // kotlin.b.a
    public boolean equals(Object obj) {
        return (obj instanceof c) && ((isEmpty() && ((c) obj).isEmpty()) || (eBX() == ((c) obj).eBX() && eBY() == ((c) obj).eBY()));
    }

    @Override // kotlin.b.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (eBX() * 31) + eBY();
    }

    @Override // kotlin.b.a
    public String toString() {
        return eBX() + IStringUtil.TOP_PATH + eBY();
    }

    @kotlin.h
    /* loaded from: classes9.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
