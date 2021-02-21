package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes6.dex */
public final class c extends kotlin.b.a {
    public static final a qub = new a(null);
    private static final c qua = new c((char) 1, (char) 0);

    public c(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.b.a
    public boolean isEmpty() {
        return eLy() > eLz();
    }

    @Override // kotlin.b.a
    public boolean equals(Object obj) {
        return (obj instanceof c) && ((isEmpty() && ((c) obj).isEmpty()) || (eLy() == ((c) obj).eLy() && eLz() == ((c) obj).eLz()));
    }

    @Override // kotlin.b.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (eLy() * 31) + eLz();
    }

    @Override // kotlin.b.a
    public String toString() {
        return "" + eLy() + IStringUtil.TOP_PATH + eLz();
    }

    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
