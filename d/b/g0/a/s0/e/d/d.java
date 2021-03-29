package d.b.g0.a.s0.e.d;

import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.b.g0.a.i2.h0;
/* loaded from: classes2.dex */
public class d extends d.b.g0.a.s0.a<d.b.g0.a.s0.e.c> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "pageScrollUp";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.e.c cVar) {
        int i = command.arg1;
        int f2 = h0.f(command.arg2);
        int i2 = command.arg3;
        int i3 = command.arg4;
        String str = command.what;
        d(cVar, str, "(top, inputHeight, keyboardHeight, cursorSpacing) " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3, false);
        cVar.r0(i, f2, i2, i3);
    }
}
