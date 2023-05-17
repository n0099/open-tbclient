package com.yy.hiidostatis.message;

import com.yy.hiidostatis.message.bean.Message;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import okhttp3.Call;
/* loaded from: classes10.dex */
public interface HostManager {
    String getHost(Message message);

    List<InetAddress> lookup(String str) throws UnknownHostException;

    void onFailure(Call call, IOException iOException);

    void onSuccess(Call call);
}
