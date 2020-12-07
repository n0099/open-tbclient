package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
@kotlin.e
/* loaded from: classes17.dex */
public final class k {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(Iterable<? extends e> iterable) {
        int i = 0;
        Iterator<? extends e> it = iterable.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().getValue() | i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i a(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new j(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i a(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new j(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.b.h a(MatchResult matchResult) {
        return new kotlin.b.h(matchResult.start(), matchResult.end() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.b.h a(MatchResult matchResult, int i) {
        return new kotlin.b.h(matchResult.start(i), matchResult.end(i) - 1);
    }
}
