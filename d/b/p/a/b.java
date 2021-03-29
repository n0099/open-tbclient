package d.b.p.a;

import android.content.Context;
import android.media.AudioManager;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    public static boolean a(WeakReference<Context> weakReference, boolean z) {
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        AudioManager audioManager = (AudioManager) weakReference.get().getSystemService("audio");
        if (z) {
            if (audioManager.requestAudioFocus(null, 3, 2) != 1) {
                return false;
            }
        } else if (audioManager.abandonAudioFocus(null) != 1) {
            return false;
        }
        return true;
    }
}
