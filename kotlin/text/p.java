package kotlin.text;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class p extends o {
    public static final <T> void a(Appendable appendable, T t, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.p.j(appendable, "$receiver");
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
