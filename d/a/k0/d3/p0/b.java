package d.a.k0.d3.p0;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.voice.VoiceManager;
import d.a.c.a.f;
import d.a.c.a.j;
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
