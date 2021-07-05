package com.kwai.video.ksvodplayerkit.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f39880a;

    /* renamed from: b  reason: collision with root package name */
    public int f39881b;

    /* renamed from: c  reason: collision with root package name */
    public float f39882c;

    /* renamed from: d  reason: collision with root package name */
    public int f39883d;

    /* renamed from: e  reason: collision with root package name */
    public int f39884e;

    /* renamed from: f  reason: collision with root package name */
    public int f39885f;

    public i() {
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
