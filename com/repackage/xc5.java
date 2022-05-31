package com.repackage;

import android.content.Context;
import android.media.AudioManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.switchs.FrsHeadVideoAutoPlaySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class xc5 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755176377, "Lcom/repackage/xc5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755176377, "Lcom/repackage/xc5;");
        }
    }

    public static boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i == 3 || i == 4) {
                return ji.H();
            }
            if (i != 5) {
                int autoPlaySwitch = TbadkCoreApplication.getInst().getAutoPlaySwitch();
                if ((autoPlaySwitch == 3 || !ji.H()) && (autoPlaySwitch != 2 || !ji.x())) {
                    return false;
                }
            } else if (TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 2 && (!FrsHeadVideoAutoPlaySwitch.getIsOn() || !ji.H() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 1)) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public static boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, str)) == null) ? a(i) : invokeIL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a : invokeV.booleanValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? (context instanceof IVideoNeedPreload) && ((IVideoNeedPreload) context).videoNeedPreload() && UbsABTestHelper.isLiveAutoPlay() : invokeL.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (ji.H() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 3) || (ji.x() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2) : invokeV.booleanValue;
    }

    public static boolean f(WeakReference<Context> weakReference, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, weakReference, z)) == null) {
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
        return invokeLZ.booleanValue;
    }

    public static void g(WeakReference<Context> weakReference) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, weakReference) == null) || weakReference == null || weakReference.get() == null) {
            return;
        }
        a = ((AudioManager) weakReference.get().getSystemService("audio")).isMusicActive();
    }
}
