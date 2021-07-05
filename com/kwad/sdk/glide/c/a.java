package com.kwad.sdk.glide.c;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes7.dex */
public class a implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<i> f37635a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37636b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37637c;

    public a() {
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
        this.f37635a = Collections.newSetFromMap(new WeakHashMap());
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f37636b = true;
            for (i iVar : com.kwad.sdk.glide.g.k.a(this.f37635a)) {
                iVar.c();
            }
        }
    }

    @Override // com.kwad.sdk.glide.c.h
    public void a(@NonNull i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar) == null) {
            this.f37635a.add(iVar);
            if (this.f37637c) {
                iVar.e();
            } else if (this.f37636b) {
                iVar.c();
            } else {
                iVar.d();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f37636b = false;
            for (i iVar : com.kwad.sdk.glide.g.k.a(this.f37635a)) {
                iVar.d();
            }
        }
    }

    @Override // com.kwad.sdk.glide.c.h
    public void b(@NonNull i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f37635a.remove(iVar);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f37637c = true;
            for (i iVar : com.kwad.sdk.glide.g.k.a(this.f37635a)) {
                iVar.e();
            }
        }
    }
}
