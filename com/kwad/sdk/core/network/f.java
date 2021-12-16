package com.kwad.sdk.core.network;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.CustomerServiceMenu;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static f a;

    /* renamed from: b  reason: collision with root package name */
    public static f f58088b;

    /* renamed from: c  reason: collision with root package name */
    public static f f58089c;

    /* renamed from: d  reason: collision with root package name */
    public static f f58090d;

    /* renamed from: e  reason: collision with root package name */
    public static f f58091e;

    /* renamed from: f  reason: collision with root package name */
    public static f f58092f;

    /* renamed from: g  reason: collision with root package name */
    public static f f58093g;

    /* renamed from: h  reason: collision with root package name */
    public static f f58094h;

    /* renamed from: i  reason: collision with root package name */
    public static f f58095i;

    /* renamed from: j  reason: collision with root package name */
    public static f f58096j;

    /* renamed from: k  reason: collision with root package name */
    public static f f58097k;
    public static f l;
    public static f m;
    public transient /* synthetic */ FieldHolder $fh;
    public int n;
    public String o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-13782965, "Lcom/kwad/sdk/core/network/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-13782965, "Lcom/kwad/sdk/core/network/f;");
                return;
            }
        }
        a = new f(-1, "请求超事件");
        f58088b = new f(-2, "请求异常");
        f58089c = new f(40001, "网络错误");
        f58090d = new f(40002, "数据解析错误");
        f58091e = new f(40003, "广告数据为空");
        f58092f = new f(40004, "视频资源缓存失败");
        f58093g = new f(40005, "网络超时");
        f58094h = new f(40007, "图片下载失败");
        f58095i = new f(CustomerServiceMenu.WITHDRAW_SERVICE, "更多视频请前往快手App查看");
        f58096j = new f(100007, "复制链接失败，请稍后重试");
        f58097k = new f(100008, "内容有点敏感，不可以发送哦");
        l = new f(130001, "数据不存在");
        m = new f(0, "网络超时");
    }

    public f(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = i2;
        this.o = str;
    }
}
