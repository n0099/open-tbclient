package com.qq.e.comm.services;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Random;
/* loaded from: classes6.dex */
public class RetCodeService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f38058a;

    /* renamed from: b  reason: collision with root package name */
    public final String f38059b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f38060c;

    /* renamed from: com.qq.e.comm.services.RetCodeService$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class Holder {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final RetCodeService f38061a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(299458879, "Lcom/qq/e/comm/services/RetCodeService$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(299458879, "Lcom/qq/e/comm/services/RetCodeService$Holder;");
                    return;
                }
            }
            f38061a = new RetCodeService((byte) 0);
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class RetCodeInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f38062a;

        /* renamed from: b  reason: collision with root package name */
        public final String f38063b;

        /* renamed from: c  reason: collision with root package name */
        public final String f38064c;

        /* renamed from: d  reason: collision with root package name */
        public final int f38065d;

        /* renamed from: e  reason: collision with root package name */
        public final int f38066e;

        /* renamed from: f  reason: collision with root package name */
        public final int f38067f;

        /* renamed from: g  reason: collision with root package name */
        public final int f38068g;

        /* renamed from: h  reason: collision with root package name */
        public final int f38069h;

        public RetCodeInfo(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38062a = str;
            this.f38063b = str2;
            this.f38064c = str3;
            this.f38065d = i2;
            this.f38066e = i3;
            this.f38067f = i4;
            this.f38068g = i5;
            this.f38069h = i6;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "RetCodeInfo [host=" + this.f38062a + ", commandid=" + this.f38063b + ", releaseversion=" + this.f38064c + ", resultcode=" + this.f38065d + ", tmcost=" + this.f38066e + ", reqsize=" + this.f38067f + ", rspsize=" + this.f38068g + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class SendTask implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RetCodeInfo f38070a;

        /* renamed from: b  reason: collision with root package name */
        public int f38071b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ RetCodeService f38072c;

        public SendTask(RetCodeService retCodeService, RetCodeInfo retCodeInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {retCodeService, retCodeInfo, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38072c = retCodeService;
            this.f38070a = retCodeInfo;
            this.f38071b = 100;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RetCodeService.a(this.f38072c, this.f38070a, this.f38071b);
            }
        }
    }

    public RetCodeService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38058a = "1000162";
        this.f38059b = "http://wspeed.qq.com/w.cgi";
        this.f38060c = new Random(System.currentTimeMillis());
    }

    public /* synthetic */ RetCodeService(byte b2) {
        this();
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return InetAddress.getByName(str).getHostAddress();
            } catch (UnknownHostException unused) {
                return "0.0.0.0";
            }
        }
        return (String) invokeL.objValue;
    }

    public static /* synthetic */ void a(RetCodeService retCodeService, RetCodeInfo retCodeInfo, int i2) {
        if (retCodeService.a(i2)) {
            PlainRequest plainRequest = new PlainRequest("http://wspeed.qq.com/w.cgi", Request.Method.GET, (byte[]) null);
            plainRequest.addQuery("appid", "1000162");
            plainRequest.addQuery("resultcode", String.valueOf(retCodeInfo.f38065d));
            plainRequest.addQuery("sdkversion", SDKStatus.getSDKVersion());
            plainRequest.addQuery("touin", "");
            plainRequest.addQuery("tmcost", String.valueOf(retCodeInfo.f38066e));
            plainRequest.addQuery("reqsize", String.valueOf(retCodeInfo.f38067f));
            plainRequest.addQuery("rspsize", String.valueOf(retCodeInfo.f38068g));
            plainRequest.addQuery("frequency", String.valueOf(i2));
            try {
                plainRequest.addQuery("commandid", URLEncoder.encode(retCodeInfo.f38063b, "utf-8"));
                plainRequest.addQuery("releaseversion", URLEncoder.encode(retCodeInfo.f38064c, "utf-8"));
                plainRequest.addQuery("serverip", URLEncoder.encode(a(retCodeInfo.f38062a), "utf-8"));
                NetworkClientImpl.getInstance().submit(plainRequest, NetworkClient.Priority.Low);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (retCodeService.a(i2)) {
            PlainRequest plainRequest2 = new PlainRequest("http://c.isdspeed.qq.com/code.cgi", Request.Method.GET, (byte[]) null);
            plainRequest2.addQuery("domain", retCodeInfo.f38062a);
            plainRequest2.addQuery("cgi", retCodeInfo.f38063b);
            plainRequest2.addQuery("type", String.valueOf(retCodeInfo.f38069h));
            plainRequest2.addQuery("code", String.valueOf(retCodeInfo.f38065d));
            plainRequest2.addQuery("time", String.valueOf(retCodeInfo.f38066e));
            plainRequest2.addQuery("rate", String.valueOf(i2));
            NetworkClientImpl.getInstance().submit(plainRequest2, NetworkClient.Priority.Low);
        }
    }

    private boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) ? this.f38060c.nextDouble() < 1.0d / ((double) i2) : invokeI.booleanValue;
    }

    public static RetCodeService getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? Holder.f38061a : (RetCodeService) invokeV.objValue;
    }

    public void send(RetCodeInfo retCodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, retCodeInfo) == null) {
            new Thread(new SendTask(this, retCodeInfo, 100)).start();
        }
    }
}
