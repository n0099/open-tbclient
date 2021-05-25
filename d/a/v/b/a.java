package d.a.v.b;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
/* loaded from: classes2.dex */
public interface a<T> {
    void onNetResponse(NetResponse netResponse, T t);

    T onParseResponseInBackground(NetResponse netResponse);
}
