package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
/* loaded from: classes8.dex */
public abstract class y implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public File f1018a;

    /* renamed from: a  reason: collision with other field name */
    public Runnable f1019a;

    public y(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f1018a = file;
    }

    public /* synthetic */ y(Context context, File file, z zVar) {
        this(context, file);
    }

    public static void a(Context context, File file, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, file, runnable) == null) {
            new z(context, file, runnable).run();
        }
    }

    public abstract void a(Context context);

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            x xVar = null;
            try {
                try {
                    if (this.f1018a == null) {
                        this.f1018a = new File(this.a.getFilesDir(), "default_locker");
                    }
                    xVar = x.a(this.a, this.f1018a);
                    if (this.f1019a != null) {
                        this.f1019a.run();
                    }
                    a(this.a);
                    if (xVar == null) {
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    if (xVar == null) {
                        return;
                    }
                }
                xVar.a();
            } catch (Throwable th) {
                if (xVar != null) {
                    xVar.a();
                }
                throw th;
            }
        }
    }
}
