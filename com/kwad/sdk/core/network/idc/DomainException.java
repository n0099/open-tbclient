package com.kwad.sdk.core.network.idc;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.regex.Pattern;
import org.apache.http.conn.ConnectTimeoutException;
/* loaded from: classes8.dex */
public class DomainException extends Exception {
    public final Pattern CONNECT_ERR_PATTERN;
    public final int httpCode;

    public DomainException(int i) {
        this(i, null);
    }

    public DomainException(int i, Throwable th) {
        super(th);
        this.CONNECT_ERR_PATTERN = Pattern.compile(".*(ECONN(RESET|REFUSED|ABORTED)|ETIMEDOUT|ENETUNREACH|EHOSTUNREACH).*", 2);
        this.httpCode = i;
    }

    public DomainException(Throwable th) {
        this(-1, th);
    }

    private Exception getInternal() {
        Throwable cause = getCause();
        if (cause instanceof Exception) {
            return (Exception) cause;
        }
        return null;
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    public boolean isConnectException() {
        String message;
        Exception internal = getInternal();
        if (internal == null) {
            return false;
        }
        if ((internal instanceof SocketTimeoutException) || (internal instanceof ConnectTimeoutException) || (internal instanceof SocketException) || (internal instanceof UnknownHostException)) {
            return true;
        }
        if (!internal.getClass().getSimpleName().equalsIgnoreCase("ErrnoException") || (message = internal.getMessage()) == null) {
            return false;
        }
        return this.CONNECT_ERR_PATTERN.matcher(message).find();
    }
}
