package d.b.i0.c3.p0;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.voice.VoiceManager;
import d.b.b.a.f;
import d.b.b.a.j;
/* loaded from: classes5.dex */
public class b {
    public static VoiceManager a(Context context) {
        TbPageContext tbPageContext;
        if (context instanceof VoiceManager.j) {
            return ((VoiceManager.j) context).getVoiceManager();
        }
        if ((j.a(context) instanceof f) && (tbPageContext = (TbPageContext) j.a(context)) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
            return ((VoiceManager.j) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return null;
    }
}
