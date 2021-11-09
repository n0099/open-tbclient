package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f68897a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.g.a f68898b;

    /* renamed from: c  reason: collision with root package name */
    public final String f68899c;

    public a(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68897a = context;
        this.f68898b = aVar;
        this.f68899c = str;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f68897a == null) {
                return false;
            }
            try {
            } catch (Throwable unused) {
                com.ss.android.socialbase.downloader.c.a.a();
            }
            return b().resolveActivity(this.f68897a.getPackageManager()) != null;
        }
        return invokeV.booleanValue;
    }
}
