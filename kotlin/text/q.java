package kotlin.text;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes10.dex */
public class q extends p {
    public static final <T> void a(Appendable appendable, T t, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.q.n(appendable, "receiver$0");
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
