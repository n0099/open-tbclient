package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;
/* loaded from: classes9.dex */
public interface WebSocket {

    /* loaded from: classes9.dex */
    public interface Factory {
        WebSocket newWebSocket(Request request, WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i2, @Nullable String str);

    long queueSize();

    Request request();

    boolean send(String str);

    boolean send(ByteString byteString);
}
