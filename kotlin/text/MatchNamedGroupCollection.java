package kotlin.text;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.Metadata;
import kotlin.SinceKotlin;
@SinceKotlin(version = "1.1")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002¨\u0006\u0006"}, d2 = {"Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/text/MatchGroupCollection;", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "Lkotlin/text/MatchGroup;", "name", "", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MatchNamedGroupCollection extends MatchGroupCollection {
    MatchGroup get(String str);
}
