package d.b.i0.z0;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.FrsHeadVideoAutoPlaySwitch;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class m0 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f52487a = false;

    public static boolean a(int i) {
        if (i == 2) {
            int frsAutoPlay = TbadkCoreApplication.getInst().getFrsAutoPlay();
            if ((frsAutoPlay == 1 || !d.b.c.e.p.j.H()) && (frsAutoPlay != 2 || !d.b.c.e.p.j.x())) {
                return false;
            }
        } else if (i == 3 || i == 4) {
            return d.b.c.e.p.j.H();
        } else {
            if (i != 5) {
                int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
                if ((homePageAutoPlay == 1 || !d.b.c.e.p.j.H()) && (homePageAutoPlay != 2 || !d.b.c.e.p.j.x())) {
                    return false;
                }
            } else if (TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 2 && (!FrsHeadVideoAutoPlaySwitch.getIsOn() || !d.b.c.e.p.j.H() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 0)) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(int i, String str) {
        return a(i);
    }

    public static boolean c() {
        return f52487a;
    }

    public static boolean d() {
        if (!d.b.c.e.p.j.H() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 1) {
            return d.b.c.e.p.j.x() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2;
        }
        return true;
    }

    public static boolean e(WeakReference<Context> weakReference, boolean z) {
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

    public static void f(WeakReference<Context> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        f52487a = ((AudioManager) weakReference.get().getSystemService("audio")).isMusicActive();
    }
}
