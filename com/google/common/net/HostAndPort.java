package com.google.common.net;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.google.android.material.badge.BadgeDrawable;
import d.g.c.a.k;
import d.g.c.a.n;
import d.g.c.a.q;
import java.io.Serializable;
/* loaded from: classes6.dex */
public final class HostAndPort implements Serializable {
    public static final int NO_PORT = -1;
    public static final long serialVersionUID = 0;
    public final boolean hasBracketlessColons;
    public final String host;
    public final int port;

    public HostAndPort(String str, int i2, boolean z) {
        this.host = str;
        this.port = i2;
        this.hasBracketlessColons = z;
    }

    public static HostAndPort fromHost(String str) {
        HostAndPort fromString = fromString(str);
        n.k(!fromString.hasPort(), "Host has a port: %s", str);
        return fromString;
    }

    public static HostAndPort fromParts(String str, int i2) {
        n.f(isValidPort(i2), "Port out of range: %s", i2);
        HostAndPort fromString = fromString(str);
        n.k(!fromString.hasPort(), "Host has a port: %s", str);
        return new HostAndPort(fromString.host, i2, fromString.hasBracketlessColons);
    }

    public static HostAndPort fromString(String str) {
        String str2;
        String str3;
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

    public static String[] getHostAndPortFromBracketedHost(String str) {
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

    public static boolean isValidPort(int i2) {
        return i2 >= 0 && i2 <= 65535;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HostAndPort) {
            HostAndPort hostAndPort = (HostAndPort) obj;
            return k.a(this.host, hostAndPort.host) && this.port == hostAndPort.port;
        }
        return false;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        n.w(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int i2) {
        return hasPort() ? this.port : i2;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int hashCode() {
        return k.b(this.host, Integer.valueOf(this.port));
    }

    public HostAndPort requireBracketsForIPv6() {
        n.k(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public String toString() {
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

    public HostAndPort withDefaultPort(int i2) {
        n.d(isValidPort(i2));
        return hasPort() ? this : new HostAndPort(this.host, i2, this.hasBracketlessColons);
    }
}
