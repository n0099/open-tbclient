package d.b.g0.a.s0.k.e;

import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class t extends d.b.g0.a.s0.a<d.b.g0.a.s0.k.g.a> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "updateVideoRect";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.k.g.a aVar) {
        aVar.k(command.arg1, command.arg2, command.arg3, command.arg4);
        String str = command.what;
        d(aVar, str, "Rect: (" + command.arg1 + StringUtil.ARRAY_ELEMENT_SEPARATOR + command.arg2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + command.arg3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + command.arg4 + SmallTailInfo.EMOTION_SUFFIX, false);
    }
}
