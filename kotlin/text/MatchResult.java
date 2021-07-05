package kotlin.text;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0000H&¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lkotlin/text/MatchResult;", "Lkotlin/Any;", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()Lkotlin/text/MatchResult;", "Lkotlin/text/MatchResult$Destructured;", "getDestructured", "()Lkotlin/text/MatchResult$Destructured;", "destructured", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "groups", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "range", "getValue", "()Ljava/lang/String;", "value", "Destructured", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public interface MatchResult {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class DefaultImpls {
        public static Destructured getDestructured(MatchResult matchResult) {
            return new Destructured(matchResult);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000B\u0011\b\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0002\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u0004\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u0005\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u0006\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u0007\u0010\u0003J\u0010\u0010\b\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\b\u0010\u0003J\u0010\u0010\t\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\t\u0010\u0003J\u0010\u0010\n\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\n\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u000b\u0010\u0003J\u0010\u0010\f\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\f\u0010\u0003J\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lkotlin/text/MatchResult$Destructured;", "", "component1", "()Ljava/lang/String;", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "", "toList", "()Ljava/util/List;", "Lkotlin/text/MatchResult;", "match", "Lkotlin/text/MatchResult;", "getMatch", "()Lkotlin/text/MatchResult;", "<init>", "(Lkotlin/text/MatchResult;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class Destructured {
        public final MatchResult match;

        public Destructured(MatchResult match) {
            Intrinsics.checkNotNullParameter(match, "match");
            this.match = match;
        }

        @InlineOnly
        private final String component1() {
            return getMatch().getGroupValues().get(1);
        }

        @InlineOnly
        private final String component10() {
            return getMatch().getGroupValues().get(10);
        }

        @InlineOnly
        private final String component2() {
            return getMatch().getGroupValues().get(2);
        }

        @InlineOnly
        private final String component3() {
            return getMatch().getGroupValues().get(3);
        }

        @InlineOnly
        private final String component4() {
            return getMatch().getGroupValues().get(4);
        }

        @InlineOnly
        private final String component5() {
            return getMatch().getGroupValues().get(5);
        }

        @InlineOnly
        private final String component6() {
            return getMatch().getGroupValues().get(6);
        }

        @InlineOnly
        private final String component7() {
            return getMatch().getGroupValues().get(7);
        }

        @InlineOnly
        private final String component8() {
            return getMatch().getGroupValues().get(8);
        }

        @InlineOnly
        private final String component9() {
            return getMatch().getGroupValues().get(9);
        }

        public final MatchResult getMatch() {
            return this.match;
        }

        public final List<String> toList() {
            return this.match.getGroupValues().subList(1, this.match.getGroupValues().size());
        }
    }

    Destructured getDestructured();

    List<String> getGroupValues();

    MatchGroupCollection getGroups();

    IntRange getRange();

    String getValue();

    MatchResult next();
}
