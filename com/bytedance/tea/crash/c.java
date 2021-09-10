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
/* loaded from: classes9.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final c f68907a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f68908b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f68909c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f68910d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f68911e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f68912f;

    /* renamed from: g  reason: collision with root package name */
    public static final c f68913g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f68914h;

    /* renamed from: i  reason: collision with root package name */
    public static final c f68915i;
    public static final /* synthetic */ c[] k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public String f68916j;

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
        f68907a = new c("LAUNCH", 0, "launch");
        f68908b = new c(Constant.TYPE_JAVA, 1, "java");
        f68909c = new c(Constant.TYPE_NATIVE, 2, "native");
        f68910d = new c("ANR", 3, "anr");
        f68911e = new c("BLOCK", 4, BreakpointSQLiteHelper.BLOCK_TABLE_NAME);
        f68912f = new c("ENSURE", 5, "ensure");
        f68913g = new c("DART", 6, "dart");
        f68914h = new c("CUSTOM_JAVA", 7, "custom_java");
        c cVar = new c("ALL", 8, "all");
        f68915i = cVar;
        k = new c[]{f68907a, f68908b, f68909c, f68910d, f68911e, f68912f, f68913g, f68914h, cVar};
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
        this.f68916j = str2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68916j : (String) invokeV.objValue;
    }
}
