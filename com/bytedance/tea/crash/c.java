package com.bytedance.tea.crash;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final c f32565a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f32566b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f32567c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f32568d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f32569e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f32570f;

    /* renamed from: g  reason: collision with root package name */
    public static final c f32571g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f32572h;

    /* renamed from: i  reason: collision with root package name */
    public static final c f32573i;
    public static final /* synthetic */ c[] k;
    public transient /* synthetic */ FieldHolder $fh;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-619684803, "Lcom/bytedance/tea/crash/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-619684803, "Lcom/bytedance/tea/crash/c;");
                return;
            }
        }
        f32565a = new c("LAUNCH", 0, "launch");
        f32566b = new c(Constant.TYPE_JAVA, 1, "java");
        f32567c = new c(Constant.TYPE_NATIVE, 2, "native");
        f32568d = new c("ANR", 3, "anr");
        f32569e = new c("BLOCK", 4, BreakpointSQLiteHelper.BLOCK_TABLE_NAME);
        f32570f = new c("ENSURE", 5, "ensure");
        f32571g = new c("DART", 6, "dart");
        f32572h = new c("CUSTOM_JAVA", 7, "custom_java");
        c cVar = new c("ALL", 8, "all");
        f32573i = cVar;
        k = new c[]{f32565a, f32566b, f32567c, f32568d, f32569e, f32570f, f32571g, f32572h, cVar};
    }

    public c(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = str2;
    }

    public static c valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (c) Enum.valueOf(c.class, str) : (c) invokeL.objValue;
    }

    public static c[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (c[]) k.clone() : (c[]) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (String) invokeV.objValue;
    }
}
