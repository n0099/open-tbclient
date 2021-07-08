package com.bytedance.sdk.openadsdk.preload.geckox.statistic.model;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f32263a;

    /* renamed from: b  reason: collision with root package name */
    public String f32264b;

    /* renamed from: c  reason: collision with root package name */
    public String f32265c;

    /* renamed from: d  reason: collision with root package name */
    public String f32266d;

    /* renamed from: e  reason: collision with root package name */
    public String f32267e;

    /* renamed from: f  reason: collision with root package name */
    public String f32268f;

    /* renamed from: g  reason: collision with root package name */
    public int f32269g;

    public b() {
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

    public static String a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, map)) == null) {
            if (map != null && !map.isEmpty()) {
                String str = map.get("x-tt-logid");
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                String str2 = map.get("X-Tt-Logid");
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
                String str3 = map.get("X-TT-LOGID");
                if (!TextUtils.isEmpty(str3)) {
                    return str3;
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
