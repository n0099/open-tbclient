package d.a.y.b;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
/* loaded from: classes9.dex */
public interface a<T> {
    void onNetResponse(NetResponse netResponse, T t);

    T onParseResponseInBackground(NetResponse netResponse);
}
