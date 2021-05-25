package d.g.c.a;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final String f66230a;

    /* loaded from: classes6.dex */
    public class a extends i {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f66231b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, String str) {
            super(iVar, null);
            this.f66231b = str;
        }

        @Override // d.g.c.a.i
        public CharSequence h(Object obj) {
            return obj == null ? this.f66231b : i.this.h(obj);
        }

        @Override // d.g.c.a.i
        public i i(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    public /* synthetic */ i(i iVar, a aVar) {
        this(iVar);
    }

    public static i f(char c2) {
        return new i(String.valueOf(c2));
    }

    public static i g(String str) {
        return new i(str);
    }

    public <A extends Appendable> A a(A a2, Iterator<?> it) throws IOException {
        n.p(a2);
        if (it.hasNext()) {
            a2.append(h(it.next()));
            while (it.hasNext()) {
                a2.append(this.f66230a);
                a2.append(h(it.next()));
            }
        }
        return a2;
    }

    public final StringBuilder b(StringBuilder sb, Iterator<?> it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final String c(Iterable<?> iterable) {
        return d(iterable.iterator());
    }

    public final String d(Iterator<?> it) {
        StringBuilder sb = new StringBuilder();
        b(sb, it);
        return sb.toString();
    }

    public final String e(Object[] objArr) {
        return c(Arrays.asList(objArr));
    }

    public CharSequence h(Object obj) {
        n.p(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public i i(String str) {
        n.p(str);
        return new a(this, str);
    }

    public i(String str) {
        n.p(str);
        this.f66230a = str;
    }

    public i(i iVar) {
        this.f66230a = iVar.f66230a;
    }
}
