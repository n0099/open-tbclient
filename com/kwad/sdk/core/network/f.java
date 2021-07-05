package com.kwad.sdk.core.network;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.CustomerServiceMenu;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static f f36358a;

    /* renamed from: b  reason: collision with root package name */
    public static f f36359b;

    /* renamed from: c  reason: collision with root package name */
    public static f f36360c;

    /* renamed from: d  reason: collision with root package name */
    public static f f36361d;

    /* renamed from: e  reason: collision with root package name */
    public static f f36362e;

    /* renamed from: f  reason: collision with root package name */
    public static f f36363f;

    /* renamed from: g  reason: collision with root package name */
    public static f f36364g;

    /* renamed from: h  reason: collision with root package name */
    public static f f36365h;

    /* renamed from: i  reason: collision with root package name */
    public static f f36366i;
    public static f j;
    public transient /* synthetic */ FieldHolder $fh;
    public int k;
    public String l;

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
        f36358a = new f(40001, "网络错误");
        f36359b = new f(40002, "数据解析错误");
        f36360c = new f(40003, "广告数据为空");
        f36361d = new f(40004, "视频资源缓存失败");
        f36362e = new f(40005, "网络超时");
        f36363f = new f(40007, "图片下载失败");
        f36364g = new f(CustomerServiceMenu.WITHDRAW_SERVICE, "更多视频请前往快手App查看");
        f36365h = new f(100007, "复制链接失败，请稍后重试");
        f36366i = new f(100008, "内容有点敏感，不可以发送哦");
        j = new f(130001, "数据不存在");
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
        this.k = i2;
        this.l = str;
    }
}
