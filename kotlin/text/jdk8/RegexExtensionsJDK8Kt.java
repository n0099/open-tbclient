package kotlin.text.jdk8;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchNamedGroupCollection;
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0002¨\u0006\u0005"}, d2 = {CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "Lkotlin/text/MatchGroup;", "Lkotlin/text/MatchGroupCollection;", "name", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 6, 0}, pn = "kotlin.text", xi = 48)
@JvmName(name = "RegexExtensionsJDK8Kt")
/* loaded from: classes2.dex */
public final class RegexExtensionsJDK8Kt {
    @SinceKotlin(version = "1.2")
    public static final MatchGroup get(MatchGroupCollection matchGroupCollection, String name) {
        MatchNamedGroupCollection matchNamedGroupCollection;
        Intrinsics.checkNotNullParameter(matchGroupCollection, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (matchGroupCollection instanceof MatchNamedGroupCollection) {
            matchNamedGroupCollection = (MatchNamedGroupCollection) matchGroupCollection;
        } else {
            matchNamedGroupCollection = null;
        }
        if (matchNamedGroupCollection != null) {
            return matchNamedGroupCollection.get(name);
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
