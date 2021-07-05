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
public abstract class v implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f43702a;

    /* renamed from: a  reason: collision with other field name */
    public File f990a;

    /* renamed from: a  reason: collision with other field name */
    public Runnable f991a;

    public v(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43702a = context;
        this.f990a = file;
    }

    public /* synthetic */ v(Context context, File file, w wVar) {
        this(context, file);
    }

    public static void a(Context context, File file, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, file, runnable) == null) {
            new w(context, file, runnable).run();
        }
    }

    public abstract void a(Context context);

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            u uVar = null;
            try {
                try {
                    if (this.f990a == null) {
                        this.f990a = new File(this.f43702a.getFilesDir(), "default_locker");
                    }
                    uVar = u.a(this.f43702a, this.f990a);
                    if (this.f991a != null) {
                        this.f991a.run();
                    }
                    a(this.f43702a);
                    if (uVar == null) {
                        return;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    if (uVar == null) {
                        return;
                    }
                }
                uVar.a();
            } catch (Throwable th) {
                if (uVar != null) {
                    uVar.a();
                }
                throw th;
            }
        }
    }
}
