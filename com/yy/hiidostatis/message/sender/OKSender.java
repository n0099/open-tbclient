package com.yy.hiidostatis.message.sender;

import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.AppInfo;
import com.yy.hiidostatis.message.HostManager;
import com.yy.hiidostatis.message.MessageSender;
import com.yy.hiidostatis.message.bean.Message;
import com.yy.hiidostatis.message.utils.NoNull;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dns;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes10.dex */
public class OKSender implements MessageSender {
    public AppInfo appInfo;
    public HostManager host;
    public MessageSender.ResultListener listener;
    public MediaType mediaType;
    public MyDns dns = new MyDns();
    public MyCallback callback = new MyCallback();
    public OkHttpClient client = new OkHttpClient.Builder().protocols(Collections.unmodifiableList(Arrays.asList(Protocol.HTTP_1_1, Protocol.HTTP_2))).connectTimeout(5, TimeUnit.SECONDS).retryOnConnectionFailure(true).dns(this.dns).readTimeout(30, TimeUnit.SECONDS).build();

    /* loaded from: classes10.dex */
    public class MyCallback implements Callback {
        public static final /* synthetic */ boolean $assertionsDisabled = false;

        public MyCallback() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            OKSender.this.host.onFailure(call, iOException);
            ReqTag reqTag = (ReqTag) call.request().tag();
            if (reqTag != null) {
                OKSender.this.listener.onResult(1000, reqTag.getMsg(), iOException.getMessage());
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            try {
                try {
                    try {
                        ReqTag reqTag = (ReqTag) call.request().tag();
                        if (response.isSuccessful()) {
                            OKSender.this.host.onSuccess(call);
                            if (OKSender.this.listener != null) {
                                OKSender.this.listener.onResult(0, reqTag.getMsg(), null);
                            }
                        } else {
                            OKSender.this.listener.onResult(response.code(), reqTag.getMsg(), response.message());
                            OKSender.this.host.onFailure(call, null);
                        }
                        response.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    response.close();
                }
            } catch (Throwable th) {
                try {
                    response.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        }
    }

    /* loaded from: classes10.dex */
    public class MyDns implements Dns {
        public MyDns() {
        }

        @Override // okhttp3.Dns
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            return OKSender.this.host.lookup(str);
        }
    }

    /* loaded from: classes10.dex */
    public static class ReqTag {
        public Message msg;

        public ReqTag(Message message) {
            this.msg = message;
        }

        public Message getMsg() {
            return this.msg;
        }
    }

    public OKSender(HostManager hostManager, AppInfo appInfo) {
        this.host = hostManager;
        this.appInfo = appInfo;
    }

    @Override // com.yy.hiidostatis.message.MessageSender
    public void setResultListener(MessageSender.ResultListener resultListener) {
        this.listener = resultListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String smartUrl(Message message) {
        String str;
        String str2 = "";
        try {
            str = URLEncoder.encode(NoNull.noNull(this.appInfo.getAppAppkey()), "UTF-8");
        } catch (Exception e) {
            e = e;
            str = "";
        }
        try {
            str2 = URLEncoder.encode(NoNull.noNull(this.appInfo.getAppVer()), "UTF-8");
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            if (!message.isSingle()) {
            }
        }
        if (!message.isSingle()) {
            return String.format("https://%s/c.gif?%s&host_appkey=%s&host_ver=%s", this.host.getHost(message), message.getUrlParams(), str, str2);
        }
        return String.format("https://%s/x.gif?%s&host_appkey=%s&host_ver=%s", this.host.getHost(message), message.getUrlParams(), str, str2);
    }

    @Override // com.yy.hiidostatis.message.MessageSender
    public void asyncSend(Message message) {
        if (this.mediaType == null) {
            try {
                this.mediaType = MediaType.parse("text/plain");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        RequestBody create = RequestBody.create(this.mediaType, message.toBody());
        String smartUrl = smartUrl(message);
        L.debug(this, "send url: %s", smartUrl);
        this.client.newCall(new Request.Builder().url(smartUrl).post(create).tag(new ReqTag(message)).build()).enqueue(this.callback);
    }
}
