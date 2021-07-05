package com.xiaomi.push;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class aw {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f42850a;
    public transient /* synthetic */ FieldHolder $fh;

    public static ar a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (av.m152a(context)) {
                f42850a = 1;
                return new av(context);
            } else if (ap.m148a(context)) {
                f42850a = 2;
                return new ap(context);
            } else if (ay.a(context)) {
                f42850a = 4;
                return new ay(context);
            } else if (bc.a(context)) {
                f42850a = 5;
                return new bc(context);
            } else if (au.a(context)) {
                f42850a = 3;
                return new as(context);
            } else {
                f42850a = 0;
                return new bb();
            }
        }
        return (ar) invokeL.objValue;
    }
}
