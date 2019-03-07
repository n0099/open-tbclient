package kotlin.text;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class o extends n {
    public static final <T> void a(Appendable appendable, T t, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.p.k(appendable, "$receiver");
        if (bVar == null) {
            if (!(t != null ? t instanceof CharSequence : true)) {
                if (!(t instanceof Character)) {
                    appendable.append(String.valueOf(t));
                    return;
                } else {
                    appendable.append(((Character) t).charValue());
                    return;
                }
            }
            appendable.append((CharSequence) t);
            return;
        }
        appendable.append(bVar.invoke(t));
    }
}
