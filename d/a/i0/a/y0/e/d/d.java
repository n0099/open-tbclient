package d.a.i0.a.y0.e.d;

import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.i0.a.v2.n0;
/* loaded from: classes.dex */
public class d extends d.a.i0.a.y0.a<d.a.i0.a.y0.e.c> {
    @Override // d.a.i0.a.y0.a
    @NonNull
    public String b() {
        return "pageScrollUp";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.i0.a.y0.e.c cVar) {
        int i2 = command.arg1;
        int g2 = n0.g(command.arg2);
        int i3 = command.arg3;
        int g3 = n0.g(command.arg4);
        String str = command.what;
        d(cVar, str, "(top, inputHeight, keyboardHeight, cursorSpacing) " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + g2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + g3, false);
        cVar.C0(i2, g2, i3, g3);
    }
}
