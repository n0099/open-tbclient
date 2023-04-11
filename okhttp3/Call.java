package okhttp3;

import java.io.IOException;
import okio.Timeout;
/* loaded from: classes9.dex */
public interface Call extends Cloneable {

    /* loaded from: classes9.dex */
    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    /* renamed from: clone */
    Call mo2244clone();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    Timeout timeout();
}
