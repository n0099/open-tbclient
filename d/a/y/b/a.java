package d.a.y.b;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.rtc.CaptureManagerProvider;
import com.baidu.cyberplayer.sdk.rtc.CyberMediaExtProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCVideoViewProvider;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static CyberMediaExtProvider f68481a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1124433758, "Ld/a/y/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1124433758, "Ld/a/y/b/a;");
        }
    }

    public static CaptureManagerProvider a(Context context, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            CaptureManagerProvider createCaptureManagerProvider = d() ? f68481a.createCaptureManagerProvider(context, i2, i3, i4, i5, i6) : null;
            CyberLog.i("CyberExtRTCInvoker", "createCaptureManager provider = " + createCaptureManagerProvider + " isExtJarLoader = " + d());
            return createCaptureManagerProvider;
        }
        return (CaptureManagerProvider) invokeCommon.objValue;
    }

    public static RTCVideoViewProvider b(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, attributeSet)) == null) {
            RTCVideoViewProvider createRTCVideoView = d() ? f68481a.createRTCVideoView(context, attributeSet) : null;
            CyberLog.i("CyberExtRTCInvoker", "createRTCVideoView provider = " + createRTCVideoView + " isExtJarLoader = " + d());
            return createRTCVideoView;
        }
        return (RTCVideoViewProvider) invokeLL.objValue;
    }

    public static void c(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65539, null, z) == null) && d()) {
            f68481a.setRTCVerbose(z);
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f68481a != null : invokeV.booleanValue;
    }

    public static boolean e(ClassLoader classLoader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, classLoader)) == null) {
            if (classLoader != null && !d() && h()) {
                try {
                    f68481a = (CyberMediaExtProvider) Class.forName("com.baidu.cybermedia.ext.rtc.CyberMediaExtProviderImpl", true, classLoader).newInstance();
                } catch (Exception unused) {
                    f68481a = null;
                    CyberLog.e("CyberExtRTCInvoker", "CyberMediaExtProviderImpl not found");
                }
            }
            return d();
        }
        return invokeL.booleanValue;
    }

    public static RTCRoomProvider f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            RTCRoomProvider createRtcRoom = d() ? f68481a.createRtcRoom() : null;
            CyberLog.i("CyberExtRTCInvoker", "createRtcRoom provider = " + createRtcRoom + " isExtJarLoader = " + d());
            return createRtcRoom;
        }
        return (RTCRoomProvider) invokeV.objValue;
    }

    public static void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65543, null, z) == null) && d()) {
            f68481a.enableRTCCaptureDebug(z);
        }
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false) : invokeV.booleanValue;
    }
}
