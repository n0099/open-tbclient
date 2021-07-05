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
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final c f32268a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f32269b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f32270c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f32271d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f32272e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f32273f;

    /* renamed from: g  reason: collision with root package name */
    public static final c f32274g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f32275h;

    /* renamed from: i  reason: collision with root package name */
    public static final c f32276i;
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
        f32268a = new c("LAUNCH", 0, "launch");
        f32269b = new c(Constant.TYPE_JAVA, 1, "java");
        f32270c = new c(Constant.TYPE_NATIVE, 2, "native");
        f32271d = new c("ANR", 3, "anr");
        f32272e = new c("BLOCK", 4, BreakpointSQLiteHelper.BLOCK_TABLE_NAME);
        f32273f = new c("ENSURE", 5, "ensure");
        f32274g = new c("DART", 6, "dart");
        f32275h = new c("CUSTOM_JAVA", 7, "custom_java");
        c cVar = new c("ALL", 8, "all");
        f32276i = cVar;
        k = new c[]{f32268a, f32269b, f32270c, f32271d, f32272e, f32273f, f32274g, f32275h, cVar};
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
