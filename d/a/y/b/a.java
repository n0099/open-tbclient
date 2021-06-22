package d.a.y.b;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.rtc.CaptureManagerProvider;
import com.baidu.cyberplayer.sdk.rtc.CyberMediaExtProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCVideoViewProvider;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static CyberMediaExtProvider f68698a;

    public static CaptureManagerProvider a(Context context, int i2, int i3, int i4, int i5, int i6) {
        CaptureManagerProvider createCaptureManagerProvider = d() ? f68698a.createCaptureManagerProvider(context, i2, i3, i4, i5, i6) : null;
        CyberLog.i("CyberExtRTCInvoker", "createCaptureManager provider = " + createCaptureManagerProvider + " isExtJarLoader = " + d());
        return createCaptureManagerProvider;
    }

    public static RTCVideoViewProvider b(Context context, AttributeSet attributeSet) {
        RTCVideoViewProvider createRTCVideoView = d() ? f68698a.createRTCVideoView(context, attributeSet) : null;
        CyberLog.i("CyberExtRTCInvoker", "createRTCVideoView provider = " + createRTCVideoView + " isExtJarLoader = " + d());
        return createRTCVideoView;
    }

    public static void c(boolean z) {
        if (d()) {
            f68698a.setRTCVerbose(z);
        }
    }

    public static boolean d() {
        return f68698a != null;
    }

    public static boolean e(ClassLoader classLoader) {
        if (classLoader != null && !d() && h()) {
            try {
                f68698a = (CyberMediaExtProvider) Class.forName("com.baidu.cybermedia.ext.rtc.CyberMediaExtProviderImpl", true, classLoader).newInstance();
            } catch (Exception unused) {
                f68698a = null;
                CyberLog.e("CyberExtRTCInvoker", "CyberMediaExtProviderImpl not found");
            }
        }
        return d();
    }

    public static RTCRoomProvider f() {
        RTCRoomProvider createRtcRoom = d() ? f68698a.createRtcRoom() : null;
        CyberLog.i("CyberExtRTCInvoker", "createRtcRoom provider = " + createRtcRoom + " isExtJarLoader = " + d());
        return createRtcRoom;
    }

    public static void g(boolean z) {
        if (d()) {
            f68698a.enableRTCCaptureDebug(z);
        }
    }

    public static boolean h() {
        return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false);
    }
}
