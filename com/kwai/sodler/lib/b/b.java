package com.kwai.sodler.lib.b;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b implements Comparable<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f37168a;

    /* renamed from: b  reason: collision with root package name */
    public String f37169b;

    /* renamed from: c  reason: collision with root package name */
    public String f37170c;

    /* renamed from: d  reason: collision with root package name */
    public long f37171d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37172e;

    /* renamed from: f  reason: collision with root package name */
    public String f37173f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37174g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, String> f37175h;

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
        this.f37174g = false;
        this.f37175h = new HashMap<>(10);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) ? -this.f37169b.compareTo(bVar.f37169b) : invokeL.intValue;
    }
}
