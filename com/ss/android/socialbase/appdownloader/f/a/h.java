package com.ss.android.socialbase.appdownloader.f.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
/* loaded from: classes2.dex */
public class h extends Exception {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable a;

    /* renamed from: b  reason: collision with root package name */
    public int f61556b;

    /* renamed from: c  reason: collision with root package name */
    public int f61557c;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h(String str, g gVar, Throwable th) {
        super(r0.toString());
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, gVar, th};
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
        if (gVar == null) {
            str3 = "";
        } else {
            str3 = "(position:" + gVar.d() + ") ";
        }
        sb.append(str3);
        if (th != null) {
            str4 = "caused by: " + th;
        }
        sb.append(str4);
        this.f61556b = -1;
        this.f61557c = -1;
        if (gVar != null) {
            this.f61556b = gVar.c();
            this.f61557c = gVar.f();
        }
        this.a = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a == null) {
                super.printStackTrace();
                return;
            }
            synchronized (System.err) {
                PrintStream printStream = System.err;
                printStream.println(super.getMessage() + "; nested exception is:");
                this.a.printStackTrace();
            }
        }
    }
}
