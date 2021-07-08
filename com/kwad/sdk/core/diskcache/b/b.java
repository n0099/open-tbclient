package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f34268a;

    /* renamed from: b  reason: collision with root package name */
    public int f34269b;

    /* renamed from: c  reason: collision with root package name */
    public long f34270c;

    /* renamed from: d  reason: collision with root package name */
    public File f34271d;

    /* renamed from: com.kwad.sdk.core.diskcache.b.b$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f34272a;

        /* renamed from: b  reason: collision with root package name */
        public int f34273b;

        /* renamed from: c  reason: collision with root package name */
        public long f34274c;

        /* renamed from: d  reason: collision with root package name */
        public File f34275d;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34273b = 1;
            this.f34274c = 100L;
            this.f34272a = context.getApplicationContext();
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 > 0) {
                    this.f34273b = i2;
                    return this;
                }
                throw new IllegalArgumentException("appVersion <= 0");
            }
            return (a) invokeI.objValue;
        }

        public a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                if (j > 0) {
                    this.f34274c = j;
                    return this;
                }
                throw new IllegalArgumentException("maxSize <= 0");
            }
            return (a) invokeJ.objValue;
        }

        public a a(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) {
                d.a(file, "directory is not allow null");
                this.f34275d = file;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                b bVar = new b(null);
                bVar.f34268a = this.f34272a;
                bVar.f34269b = this.f34273b;
                bVar.f34270c = this.f34274c;
                bVar.f34271d = this.f34275d;
                return bVar;
            }
            return (b) invokeV.objValue;
        }
    }

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
            }
        }
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }
}
