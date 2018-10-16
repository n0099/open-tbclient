package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* loaded from: classes2.dex */
public final class j {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(Iterable<? extends d> iterable) {
        int i = 0;
        Iterator<? extends d> it = iterable.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().getValue() | i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h a(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new i(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h a(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new i(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.b.c a(MatchResult matchResult) {
        return new kotlin.b.c(matchResult.start(), matchResult.end() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.b.c a(MatchResult matchResult, int i) {
        return new kotlin.b.c(matchResult.start(i), matchResult.end(i) - 1);
    }
}
