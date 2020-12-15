package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes17.dex */
public final class c extends kotlin.b.a {
    public static final a pKN = new a(null);
    private static final c pKM = new c((char) 1, (char) 0);

    public c(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.b.a
    public boolean isEmpty() {
        return eEe() > eEf();
    }

    @Override // kotlin.b.a
    public boolean equals(Object obj) {
        return (obj instanceof c) && ((isEmpty() && ((c) obj).isEmpty()) || (eEe() == ((c) obj).eEe() && eEf() == ((c) obj).eEf()));
    }

    @Override // kotlin.b.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (eEe() * 31) + eEf();
    }

    @Override // kotlin.b.a
    public String toString() {
        return "" + eEe() + IStringUtil.TOP_PATH + eEf();
    }

    @kotlin.e
    /* loaded from: classes17.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
