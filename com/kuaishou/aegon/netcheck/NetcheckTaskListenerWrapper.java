package com.kuaishou.aegon.netcheck;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.aegon.netcheck.a;
import java.util.EnumSet;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public class NetcheckTaskListenerWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a.b f34026a;

    /* renamed from: b  reason: collision with root package name */
    public Executor f34027b;

    @Keep
    public void OnFinish(long j, String str) {
        a.EnumC0401a[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j, str) == null) {
            EnumSet noneOf = EnumSet.noneOf(a.EnumC0401a.class);
            for (a.EnumC0401a enumC0401a : a.EnumC0401a.values()) {
                if (((1 << enumC0401a.a()) & j) != 0) {
                    noneOf.add(enumC0401a);
                }
            }
            this.f34027b.execute(c.a(this, noneOf, str));
        }
    }

    @Keep
    public void OnProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f34027b.execute(b.a(this, i2));
        }
    }
}
