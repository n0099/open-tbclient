package tv.chushou.basis.http;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes4.dex */
public class HttpException extends RuntimeException {
    public static final int TYPE_CODE_ERROR = 3;
    public static final int TYPE_EXECUTE_ERROR = 2;
    public static final int TYPE_PARSE_ERROR = 5;
    public static final int TYPE_STRINGIFY_ERROR = 4;
    public static final int TYPE_TIMESTAMP_ERROR = 6;
    public static final int TYPE_URL_ERROR = 1;
    private static final long serialVersionUID = 3309950752377255580L;
    private int errorType;

    public HttpException(int i) {
        this.errorType = i;
    }

    public HttpException(int i, String str) {
        super(str);
        this.errorType = i;
    }

    public HttpException(int i, String str, Throwable th) {
        super(str);
        initCause(th);
        this.errorType = i;
    }

    public int errorCode() {
        return this.errorType;
    }
}
