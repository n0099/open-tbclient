package master.flame.danmaku.danmaku.c;

import android.app.ActivityManager;
import android.content.Context;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes6.dex */
public class a {
    public static int getMemoryClass(Context context) {
        return ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryClass();
    }
}
