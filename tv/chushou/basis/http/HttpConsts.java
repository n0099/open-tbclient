package tv.chushou.basis.http;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes5.dex */
public class HttpConsts {
    public static final String FILE_BACKUP_SUFFIX = ".bak";
    public static final String TAG = "Http";

    @Keep
    /* loaded from: classes5.dex */
    public static final class Error {
        public static final int TIMESTAMP = 602;
        public static final int UNKNOWN = -1;
    }

    @Keep
    /* loaded from: classes5.dex */
    public static final class Header {
        public static final String RESPONSE_IP = "chushou_host_ip";
    }

    @Keep
    /* loaded from: classes5.dex */
    public static final class Timeout {
        public static final int DEFAULT_CONNECT_TIMEOUT = 10;
        public static final int DEFAULT_READ_TIMEOUT = 10;
        public static final int DEFAULT_TIMESTAMP_EXPIRES = 300;
        public static final int DEFAULT_WRITE_TIMEOUT = 10;
    }
}
