package com.yy.hiidostatis.message.sender;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public class OKSender implements MessageSender {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AppInfo appInfo;
    public MyCallback callback;
    public OkHttpClient client;
    public MyDns dns;
    public HostManager host;
    public MessageSender.ResultListener listener;
    public MediaType mediaType;

    /* renamed from: com.yy.hiidostatis.message.sender.OKSender$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class MyCallback implements Callback {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OKSender this$0;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-685358666, "Lcom/yy/hiidostatis/message/sender/OKSender$MyCallback;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-685358666, "Lcom/yy/hiidostatis/message/sender/OKSender$MyCallback;");
            }
        }

        public MyCallback(OKSender oKSender) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oKSender};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = oKSender;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.this$0.host.onFailure(call, iOException);
                ReqTag reqTag = (ReqTag) call.request().tag();
                if (reqTag != null) {
                    this.this$0.listener.onResult(1000, reqTag.getMsg(), iOException.getMessage());
                }
            }
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0062 -> B:20:0x0065). Please submit an issue!!! */
        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    try {
                        try {
                            ReqTag reqTag = (ReqTag) call.request().tag();
                            if (response.isSuccessful()) {
                                this.this$0.host.onSuccess(call);
                                if (this.this$0.listener != null) {
                                    this.this$0.listener.onResult(0, reqTag.getMsg(), null);
                                }
                            } else {
                                this.this$0.listener.onResult(response.code(), reqTag.getMsg(), response.message());
                                this.this$0.host.onFailure(call, null);
                            }
                            response.close();
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
                } catch (Exception e4) {
                    while (true) {
                        e4.printStackTrace();
                        return;
                    }
                }
            }
        }

        public /* synthetic */ MyCallback(OKSender oKSender, AnonymousClass1 anonymousClass1) {
            this(oKSender);
        }
    }

    /* loaded from: classes2.dex */
    public class MyDns implements Dns {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OKSender this$0;

        public MyDns(OKSender oKSender) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oKSender};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = oKSender;
        }

        @Override // okhttp3.Dns
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.this$0.host.lookup(str) : (List) invokeL.objValue;
        }

        public /* synthetic */ MyDns(OKSender oKSender, AnonymousClass1 anonymousClass1) {
            this(oKSender);
        }
    }

    /* loaded from: classes2.dex */
    public static class ReqTag {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Message msg;

        public ReqTag(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {message};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.msg = message;
        }

        public Message getMsg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.msg : (Message) invokeV.objValue;
        }
    }

    public OKSender(HostManager hostManager, AppInfo appInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hostManager, appInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dns = new MyDns(this, null);
        this.callback = new MyCallback(this, null);
        this.client = new OkHttpClient.Builder().protocols(Collections.unmodifiableList(Arrays.asList(Protocol.HTTP_1_1, Protocol.HTTP_2))).connectTimeout(5L, TimeUnit.SECONDS).retryOnConnectionFailure(true).dns(this.dns).readTimeout(30L, TimeUnit.SECONDS).build();
        this.host = hostManager;
        this.appInfo = appInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String smartUrl(Message message) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, message)) == null) {
            String str2 = "";
            try {
                str = URLEncoder.encode(NoNull.noNull(this.appInfo.getAppAppkey()), "UTF-8");
            } catch (Exception e2) {
                e = e2;
                str = "";
            }
            try {
                str2 = URLEncoder.encode(NoNull.noNull(this.appInfo.getAppVer()), "UTF-8");
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                if (!message.isSingle()) {
                }
            }
            return !message.isSingle() ? String.format("https://%s/c.gif?%s&host_appkey=%s&host_ver=%s", this.host.getHost(message), message.getUrlParams(), str, str2) : String.format("https://%s/x.gif?%s&host_appkey=%s&host_ver=%s", this.host.getHost(message), message.getUrlParams(), str, str2);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.yy.hiidostatis.message.MessageSender
    public void asyncSend(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            if (this.mediaType == null) {
                try {
                    this.mediaType = MediaType.parse("text/plain");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            RequestBody create = RequestBody.create(this.mediaType, message.toBody());
            String smartUrl = smartUrl(message);
            L.debug(this, "send url: %s", smartUrl);
            this.client.newCall(new Request.Builder().url(smartUrl).post(create).tag(new ReqTag(message)).build()).enqueue(this.callback);
        }
    }

    @Override // com.yy.hiidostatis.message.MessageSender
    public void setResultListener(MessageSender.ResultListener resultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, resultListener) == null) {
            this.listener = resultListener;
        }
    }
}
