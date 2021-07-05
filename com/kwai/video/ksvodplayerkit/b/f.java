package com.kwai.video.ksvodplayerkit.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f39869a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f39870b;

    /* renamed from: c  reason: collision with root package name */
    public String f39871c;

    /* renamed from: d  reason: collision with root package name */
    public String f39872d;

    /* renamed from: e  reason: collision with root package name */
    public double f39873e;

    /* renamed from: f  reason: collision with root package name */
    public String f39874f;

    /* renamed from: g  reason: collision with root package name */
    public int f39875g;

    /* renamed from: h  reason: collision with root package name */
    public String f39876h;

    /* renamed from: i  reason: collision with root package name */
    public int f39877i;
    public int j;
    public double k;
    public String l;
    public transient String m;
    public transient com.kwai.video.ksvodplayerkit.HttpDns.g<com.kwai.video.ksvodplayerkit.HttpDns.a> n;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
