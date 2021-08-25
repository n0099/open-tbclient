package com.kwai.sodler.lib.b;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b implements Comparable<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f74199a;

    /* renamed from: b  reason: collision with root package name */
    public String f74200b;

    /* renamed from: c  reason: collision with root package name */
    public String f74201c;

    /* renamed from: d  reason: collision with root package name */
    public long f74202d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f74203e;

    /* renamed from: f  reason: collision with root package name */
    public String f74204f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f74205g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, String> f74206h;

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
        this.f74205g = false;
        this.f74206h = new HashMap<>(10);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) ? -this.f74200b.compareTo(bVar.f74200b) : invokeL.intValue;
    }
}
