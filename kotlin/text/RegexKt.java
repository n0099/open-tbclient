package kotlin.text;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0003\u001a4\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0082\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a%\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u000f\u001a\u0004\u0018\u00010\f*\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0013\u001a\u00020\u0012*\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001b\u0010\u0013\u001a\u00020\u0012*\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0016\u001a\u0019\u0010\u0018\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00000\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lkotlin/text/FlagEnum;", "", "T", "", "value", "", "fromInt", "(I)Ljava/util/Set;", "Ljava/util/regex/Matcher;", "from", "", "input", "Lkotlin/text/MatchResult;", "findNext", "(Ljava/util/regex/Matcher;ILjava/lang/CharSequence;)Lkotlin/text/MatchResult;", "matchEntire", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)Lkotlin/text/MatchResult;", "Ljava/util/regex/MatchResult;", "Lkotlin/ranges/IntRange;", "range", "(Ljava/util/regex/MatchResult;)Lkotlin/ranges/IntRange;", "groupIndex", "(Ljava/util/regex/MatchResult;I)Lkotlin/ranges/IntRange;", "", "toInt", "(Ljava/lang/Iterable;)I", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class RegexKt {
    public static final MatchResult findNext(Matcher matcher, int i2, CharSequence charSequence) {
        if (matcher.find(i2)) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    public static final /* synthetic */ <T extends Enum<T> & FlagEnum> Set<T> fromInt(int i2) {
        Intrinsics.reifiedOperationMarker(4, "T");
        EnumSet allOf = EnumSet.allOf(Enum.class);
        CollectionsKt__MutableCollectionsKt.retainAll(allOf, new RegexKt$fromInt$$inlined$apply$lambda$1(i2));
        Set<T> unmodifiableSet = Collections.unmodifiableSet(allOf);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        return unmodifiableSet;
    }

    public static final MatchResult matchEntire(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    public static final IntRange range(java.util.regex.MatchResult matchResult) {
        return RangesKt___RangesKt.until(matchResult.start(), matchResult.end());
    }

    public static final int toInt(Iterable<? extends FlagEnum> iterable) {
        int i2 = 0;
        for (FlagEnum flagEnum : iterable) {
            i2 |= flagEnum.getValue();
        }
        return i2;
    }

    public static final IntRange range(java.util.regex.MatchResult matchResult, int i2) {
        return RangesKt___RangesKt.until(matchResult.start(i2), matchResult.end(i2));
    }
}
