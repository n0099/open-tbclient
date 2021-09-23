package com.ss.android.socialbase.appdownloader.f.a;

import c.p.a.e.a.h.a.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
/* loaded from: classes10.dex */
public class h extends Exception {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Throwable f76062a;

    /* renamed from: b  reason: collision with root package name */
    public int f76063b;

    /* renamed from: c  reason: collision with root package name */
    public int f76064c;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h(String str, f fVar, Throwable th) {
        super(r0.toString());
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, fVar, th};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        if (str == null) {
            str2 = "";
        } else {
            str2 = str + " ";
        }
        sb.append(str2);
        if (fVar == null) {
            str3 = "";
        } else {
            str3 = "(position:" + fVar.d() + ") ";
        }
        sb.append(str3);
        if (th != null) {
            str4 = "caused by: " + th;
        }
        sb.append(str4);
        this.f76063b = -1;
        this.f76064c = -1;
        if (fVar != null) {
            this.f76063b = fVar.c();
            this.f76064c = fVar.f();
        }
        this.f76062a = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f76062a == null) {
                super.printStackTrace();
                return;
            }
            synchronized (System.err) {
                PrintStream printStream = System.err;
                printStream.println(super.getMessage() + "; nested exception is:");
                this.f76062a.printStackTrace();
            }
        }
    }
}
