package com.bytedance.sdk.openadsdk.img;

import com.alipay.sdk.util.e;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.IStepTracker;
import com.bytedance.sdk.component.utils.k;
/* loaded from: classes9.dex */
public class a implements IStepTracker {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f67745a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f67746b;

    /* renamed from: c  reason: collision with root package name */
    public long f67747c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67748d;

    /* renamed from: e  reason: collision with root package name */
    public String f67749e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-377854565, "Lcom/bytedance/sdk/openadsdk/img/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-377854565, "Lcom/bytedance/sdk/openadsdk/img/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f67746b = 0L;
        f67745a++;
        this.f67749e = "image_request_" + f67745a;
    }

    private String a(String str, com.bytedance.sdk.component.image.c.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, aVar)) == null) {
            if (str != null) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1867169789:
                        if (str.equals("success")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case -1584526165:
                        if (str.equals("raw_cache")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -1428113824:
                        if (str.equals("disk_cache")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -1335717394:
                        if (str.equals("decode")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1281977283:
                        if (str.equals(e.f35961a)) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case -1076854124:
                        if (str.equals("check_duplicate")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1017400004:
                        if (str.equals("memory_cache")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1478448621:
                        if (str.equals("net_request")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 1718821013:
                        if (str.equals("generate_key")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 2067979407:
                        if (str.equals("cache_policy")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        return "查询缓存策略";
                    case 1:
                        return "解码";
                    case 2:
                        return "检查重复请求";
                    case 3:
                        return "查询Bitmap内存缓存";
                    case 4:
                        return "查询RAW内存缓存";
                    case 5:
                        return "查询文件缓存";
                    case 6:
                        return "生成KEY:" + aVar.e();
                    case 7:
                        return "请求网络";
                    case '\b':
                        return "成功";
                    case '\t':
                        return "失败";
                    default:
                        return str;
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.component.image.IStepTracker
    public void onStepEnd(String str, com.bytedance.sdk.component.image.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f67746b;
            this.f67747c += currentTimeMillis;
            k.b("ImageLoaderStep", this.f67749e + " 结束:" + a(str, aVar) + ",耗时：" + currentTimeMillis + " ms， 总计：" + this.f67747c + " ms. url" + Part.CRLF);
        }
    }

    @Override // com.bytedance.sdk.component.image.IStepTracker
    public void onStepStart(String str, com.bytedance.sdk.component.image.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
            if (!this.f67748d) {
                k.b("ImageLoaderStep", "start " + this.f67749e + " request:" + aVar.a() + ", width:" + aVar.h() + ",height:" + aVar.i());
                this.f67748d = true;
            }
            this.f67746b = System.currentTimeMillis();
            k.b("ImageLoaderStep", this.f67749e + " 开始:" + a(str, aVar));
        }
    }
}
