package com.kwad.sdk.crash.report;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C1961a> f66388a;

    /* renamed from: com.kwad.sdk.crash.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1961a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ExceptionMessage f66389a;

        /* renamed from: b  reason: collision with root package name */
        public int f66390b;

        public C1961a(ExceptionMessage exceptionMessage, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {exceptionMessage, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66389a = exceptionMessage;
            this.f66390b = i2;
        }
    }

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
        this.f66388a = new ArrayList<>();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.f66388a.isEmpty()) {
            return;
        }
        try {
            Iterator<C1961a> it = this.f66388a.iterator();
            while (it.hasNext()) {
                C1961a next = it.next();
                b(next.f66389a, next.f66390b);
                it.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    private void b(ExceptionMessage exceptionMessage, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, exceptionMessage, i2) == null) {
            com.kwad.sdk.core.d.a.a("ExceptionCollector", "upload msg=" + exceptionMessage);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(com.kwad.sdk.crash.report.request.c.a(exceptionMessage));
            new com.kwad.sdk.crash.report.request.b().a(arrayList);
        }
    }

    public void a(ExceptionMessage exceptionMessage, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, exceptionMessage, i2) == null) {
            try {
                a();
                b(exceptionMessage, i2);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
                this.f66388a.add(new C1961a(exceptionMessage, i2));
            }
        }
    }

    @Override // com.kwad.sdk.crash.report.c
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
        }
    }

    @Override // com.kwad.sdk.crash.report.c
    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
        }
    }
}
