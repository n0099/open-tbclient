package com.kwai.sodler.lib.a;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements Comparable<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f58413b;

    /* renamed from: c  reason: collision with root package name */
    public String f58414c;

    /* renamed from: d  reason: collision with root package name */
    public long f58415d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58416e;

    /* renamed from: f  reason: collision with root package name */
    public String f58417f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58418g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, String> f58419h;

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
                return;
            }
        }
        this.f58418g = false;
        this.f58419h = new HashMap<>(10);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) ? -this.f58413b.compareTo(bVar.f58413b) : invokeL.intValue;
    }
}
