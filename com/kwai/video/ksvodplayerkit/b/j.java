package com.kwai.video.ksvodplayerkit.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f39886a;

    /* renamed from: b  reason: collision with root package name */
    public String f39887b;

    /* renamed from: c  reason: collision with root package name */
    public String f39888c;

    /* renamed from: d  reason: collision with root package name */
    public int f39889d;

    /* renamed from: e  reason: collision with root package name */
    public int f39890e;

    /* renamed from: f  reason: collision with root package name */
    public int f39891f;

    /* renamed from: g  reason: collision with root package name */
    public String f39892g;

    /* renamed from: h  reason: collision with root package name */
    public float f39893h;

    /* renamed from: i  reason: collision with root package name */
    public transient com.kwai.video.ksvodplayerkit.HttpDns.g<com.kwai.video.ksvodplayerkit.HttpDns.a> f39894i;

    public j() {
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
