package d.b.h0.w;

import android.content.Context;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.DLauncher;
/* loaded from: classes3.dex */
public class g {
    public static h a(Context context, m mVar, int i) {
        if (i != 1) {
            return new DLauncher(context, mVar);
        }
        return new BLauncher(context, mVar);
    }
}
