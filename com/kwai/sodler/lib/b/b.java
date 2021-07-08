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
    public String f36979a;

    /* renamed from: b  reason: collision with root package name */
    public String f36980b;

    /* renamed from: c  reason: collision with root package name */
    public String f36981c;

    /* renamed from: d  reason: collision with root package name */
    public long f36982d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36983e;

    /* renamed from: f  reason: collision with root package name */
    public String f36984f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36985g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, String> f36986h;

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
        this.f36985g = false;
        this.f36986h = new HashMap<>(10);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) ? -this.f36980b.compareTo(bVar.f36980b) : invokeL.intValue;
    }
}
