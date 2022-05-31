package com.repackage;

import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class v67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65536, null, j) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            t67.a("私信链路耗时监控 Tb = " + j + "-x-" + currentTimeMillis);
            TiebaStatic.log(new StatisticItem("c14673").param("obj_id", j).param("obj_param1", currentTimeMillis));
        }
    }

    public static void b(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            t67.a("私信链路耗时监控 Tc = " + j + "-" + i + "-" + currentTimeMillis);
            TiebaStatic.log(new StatisticItem("c14674").param("obj_id", j).param("obj_type", i).param("obj_param1", currentTimeMillis));
        }
    }

    public static void c(long j, int i, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)}) == null) {
            long c = x67.c(j);
            t67.a("私信链路耗时监控 Ta = " + c + "-" + i + "-" + j2);
            TiebaStatic.log(new StatisticItem("c14672").param("obj_id", c).param("obj_type", i).param("obj_param1", j2));
        }
    }
}
