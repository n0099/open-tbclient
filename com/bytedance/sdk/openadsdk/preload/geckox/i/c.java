package com.bytedance.sdk.openadsdk.preload.geckox.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, String> f69115a;

    /* renamed from: b  reason: collision with root package name */
    public final String f69116b;

    /* renamed from: c  reason: collision with root package name */
    public final int f69117c;

    /* renamed from: d  reason: collision with root package name */
    public final String f69118d;

    public c(Map<String, String> map, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69115a = map;
        this.f69116b = str;
        this.f69117c = i2;
        this.f69118d = str2;
    }
}
