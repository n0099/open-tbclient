package com.google.common.net;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import d.f.d.a.k;
import d.f.d.a.n;
import d.f.d.a.q;
import java.io.Serializable;
/* loaded from: classes6.dex */
public final class HostAndPort implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NO_PORT = -1;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean hasBracketlessColons;
    public final String host;
    public final int port;

    public HostAndPort(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.host = str;
        this.port = i2;
        this.hasBracketlessColons = z;
    }

    public static HostAndPort fromHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            HostAndPort fromString = fromString(str);
            n.k(!fromString.hasPort(), "Host has a port: %s", str);
            return fromString;
        }
        return (HostAndPort) invokeL.objValue;
    }

    public static HostAndPort fromParts(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            n.f(isValidPort(i2), "Port out of range: %s", i2);
            HostAndPort fromString = fromString(str);
            n.k(!fromString.hasPort(), "Host has a port: %s", str);
            return new HostAndPort(fromString.host, i2, fromString.hasBracketlessColons);
        }
        return (HostAndPort) invokeLI.objValue;
    }

    public static HostAndPort fromString(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            n.p(str);
            int i2 = -1;
            if (str.startsWith(PreferencesUtil.LEFT_MOUNT)) {
                String[] hostAndPortFromBracketedHost = getHostAndPortFromBracketedHost(str);
                str3 = hostAndPortFromBracketedHost[0];
                str2 = hostAndPortFromBracketedHost[1];
            } else {
                int indexOf = str.indexOf(58);
                if (indexOf >= 0) {
                    int i3 = indexOf + 1;
                    if (str.indexOf(58, i3) == -1) {
                        str3 = str.substring(0, indexOf);
                        str2 = str.substring(i3);
                    }
                }
                r3 = indexOf >= 0;
                str2 = null;
                str3 = str;
            }
            if (!q.a(str2)) {
                n.k(!str2.startsWith(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX), "Unparseable port number: %s", str);
                try {
                    i2 = Integer.parseInt(str2);
                    n.k(isValidPort(i2), "Port number out of range: %s", str);
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException("Unparseable port number: " + str);
                }
            }
            return new HostAndPort(str3, i2, r3);
        }
        return (HostAndPort) invokeL.objValue;
    }

    public static String[] getHostAndPortFromBracketedHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            n.k(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", str);
            int indexOf = str.indexOf(58);
            int lastIndexOf = str.lastIndexOf(93);
            n.k(indexOf > -1 && lastIndexOf > indexOf, "Invalid bracketed host/port: %s", str);
            String substring = str.substring(1, lastIndexOf);
            int i2 = lastIndexOf + 1;
            if (i2 == str.length()) {
                return new String[]{substring, ""};
            }
            n.k(str.charAt(i2) == ':', "Only a colon may follow a close bracket: %s", str);
            int i3 = lastIndexOf + 2;
            for (int i4 = i3; i4 < str.length(); i4++) {
                n.k(Character.isDigit(str.charAt(i4)), "Port must be numeric: %s", str);
            }
            return new String[]{substring, str.substring(i3)};
        }
        return (String[]) invokeL.objValue;
    }

    public static boolean isValidPort(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? i2 >= 0 && i2 <= 65535 : invokeI.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HostAndPort) {
                HostAndPort hostAndPort = (HostAndPort) obj;
                return k.a(this.host, hostAndPort.host) && this.port == hostAndPort.port;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.host : (String) invokeV.objValue;
    }

    public int getPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            n.w(hasPort());
            return this.port;
        }
        return invokeV.intValue;
    }

    public int getPortOrDefault(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? hasPort() ? this.port : i2 : invokeI.intValue;
    }

    public boolean hasPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.port >= 0 : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k.b(this.host, Integer.valueOf(this.port)) : invokeV.intValue;
    }

    public HostAndPort requireBracketsForIPv6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            n.k(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
            return this;
        }
        return (HostAndPort) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder(this.host.length() + 8);
            if (this.host.indexOf(58) >= 0) {
                sb.append('[');
                sb.append(this.host);
                sb.append(']');
            } else {
                sb.append(this.host);
            }
            if (hasPort()) {
                sb.append(':');
                sb.append(this.port);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public HostAndPort withDefaultPort(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            n.d(isValidPort(i2));
            return hasPort() ? this : new HostAndPort(this.host, i2, this.hasBracketlessColons);
        }
        return (HostAndPort) invokeI.objValue;
    }
}
