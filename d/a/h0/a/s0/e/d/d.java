package d.a.h0.a.s0.e.d;

import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.h0.a.i2.h0;
/* loaded from: classes2.dex */
public class d extends d.a.h0.a.s0.a<d.a.h0.a.s0.e.c> {
    @Override // d.a.h0.a.s0.a
    @NonNull
    public String b() {
        return "pageScrollUp";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.h0.a.s0.e.c cVar) {
        int i2 = command.arg1;
        int f2 = h0.f(command.arg2);
        int i3 = command.arg3;
        int i4 = command.arg4;
        String str = command.what;
        d(cVar, str, "(top, inputHeight, keyboardHeight, cursorSpacing) " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4, false);
        cVar.s0(i2, f2, i3, i4);
    }
}
