package d.a.e0.n;

import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        byte[] hardwareAddress;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                NetworkInterface byName = NetworkInterface.getByName(NetworkInfoUtils.NETWORK_NAME);
                if (byName != null && (hardwareAddress = byName.getHardwareAddress()) != null) {
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        byte[] hardwareAddress;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                InetAddress f2 = f();
                if (f2 == null || (hardwareAddress = NetworkInterface.getByInetAddress(f2).getHardwareAddress()) == null) {
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < hardwareAddress.length; i2++) {
                    if (i2 != 0) {
                        sb.append(':');
                    }
                    String hexString = Integer.toHexString(hardwareAddress[i2] & 255);
                    if (hexString.length() == 1) {
                        hexString = 0 + hexString;
                    }
                    sb.append(hexString);
                }
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? ((WifiManager) g.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress() : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                a2 = c();
            } else {
                a2 = a();
            }
            if (!e(a2)) {
                a2 = b();
            }
            return !TextUtils.isEmpty(a2) ? a2.toUpperCase() : a2;
        }
        return (String) invokeV.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (TextUtils.isEmpty(str) || str.equals(Config.DEF_MAC_ID)) ? false : true : invokeL.booleanValue;
    }

    public static InetAddress f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) != null) {
            return (InetAddress) invokeV.objValue;
        }
        InetAddress inetAddress = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return null;
            }
            InetAddress inetAddress2 = null;
            do {
                try {
                    if (!networkInterfaces.hasMoreElements()) {
                        return inetAddress2;
                    }
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            try {
                                if (!nextElement.isLoopbackAddress() && !nextElement.getHostAddress().contains(":")) {
                                    inetAddress2 = nextElement;
                                    continue;
                                    break;
                                }
                                inetAddress2 = null;
                            } catch (Exception unused) {
                                return nextElement;
                            }
                        }
                    }
                } catch (Exception unused2) {
                    inetAddress = inetAddress2;
                    return inetAddress;
                }
            } while (inetAddress2 == null);
            return inetAddress2;
        } catch (Exception unused3) {
        }
    }
}
