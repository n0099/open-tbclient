package d.a.o0.z0;

import android.content.Context;
import android.media.AudioManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.FrsHeadVideoAutoPlaySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes7.dex */
public class o0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f53707a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(870012458, "Ld/a/o0/z0/o0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(870012458, "Ld/a/o0/z0/o0;");
        }
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 == 2) {
                int frsAutoPlay = TbadkCoreApplication.getInst().getFrsAutoPlay();
                if ((frsAutoPlay == 1 || !d.a.c.e.p.j.H()) && (frsAutoPlay != 2 || !d.a.c.e.p.j.x())) {
                    return false;
                }
            } else if (i2 == 3 || i2 == 4) {
                return d.a.c.e.p.j.H();
            } else {
                if (i2 != 5) {
                    int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
                    if ((homePageAutoPlay == 1 || !d.a.c.e.p.j.H()) && (homePageAutoPlay != 2 || !d.a.c.e.p.j.x())) {
                        return false;
                    }
                } else if (TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 2 && (!FrsHeadVideoAutoPlaySwitch.getIsOn() || !d.a.c.e.p.j.H() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 0)) {
                    return false;
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public static boolean b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, str)) == null) ? a(i2) : invokeIL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f53707a : invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!d.a.c.e.p.j.H() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 1) {
                return d.a.c.e.p.j.x() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean e(WeakReference<Context> weakReference, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, weakReference, z)) == null) {
            if (weakReference == null || weakReference.get() == null) {
                return false;
            }
            AudioManager audioManager = (AudioManager) weakReference.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (z) {
                if (audioManager.requestAudioFocus(null, 3, 2) != 1) {
                    return false;
                }
            } else if (audioManager.abandonAudioFocus(null) != 1) {
                return false;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static void f(WeakReference<Context> weakReference) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, weakReference) == null) || weakReference == null || weakReference.get() == null) {
            return;
        }
        f53707a = ((AudioManager) weakReference.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).isMusicActive();
    }
}
