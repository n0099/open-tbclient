package com.kwad.sdk.glide.load.engine.a;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.g.a.a;
import com.kwad.sdk.glide.g.k;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.g<com.kwad.sdk.glide.load.c, String> f37992a;

    /* renamed from: b  reason: collision with root package name */
    public final Pools.Pool<a> f37993b;

    /* loaded from: classes7.dex */
    public static final class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final MessageDigest f37995a;

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.g.a.c f37996b;

        public a(MessageDigest messageDigest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {messageDigest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37996b = com.kwad.sdk.glide.g.a.c.a();
            this.f37995a = messageDigest;
        }

        @Override // com.kwad.sdk.glide.g.a.a.c
        @NonNull
        public com.kwad.sdk.glide.g.a.c d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37996b : (com.kwad.sdk.glide.g.a.c) invokeV.objValue;
        }
    }

    public j() {
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
        this.f37992a = new com.kwad.sdk.glide.g.g<>(1000L);
        this.f37993b = com.kwad.sdk.glide.g.a.a.a(10, new a.InterfaceC0457a<a>(this) { // from class: com.kwad.sdk.glide.load.engine.a.j.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ j f37994a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37994a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0457a
            /* renamed from: a */
            public a b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    try {
                        return new a(MessageDigest.getInstance("SHA-256"));
                    } catch (NoSuchAlgorithmException e2) {
                        throw new RuntimeException(e2);
                    }
                }
                return (a) invokeV.objValue;
            }
        });
    }

    private String b(com.kwad.sdk.glide.load.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cVar)) == null) {
            a aVar = (a) com.kwad.sdk.glide.g.j.a(this.f37993b.acquire());
            try {
                cVar.a(aVar.f37995a);
                return k.a(aVar.f37995a.digest());
            } finally {
                this.f37993b.release(aVar);
            }
        }
        return (String) invokeL.objValue;
    }

    public String a(com.kwad.sdk.glide.load.c cVar) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            synchronized (this.f37992a) {
                b2 = this.f37992a.b(cVar);
            }
            if (b2 == null) {
                b2 = b(cVar);
            }
            synchronized (this.f37992a) {
                this.f37992a.b(cVar, b2);
            }
            return b2;
        }
        return (String) invokeL.objValue;
    }
}
