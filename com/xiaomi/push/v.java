package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
/* loaded from: classes10.dex */
public abstract class v implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f78065a;

    /* renamed from: a  reason: collision with other field name */
    public File f994a;

    /* renamed from: a  reason: collision with other field name */
    public Runnable f995a;

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
        this.f78065a = context;
        this.f994a = file;
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
                    if (this.f994a == null) {
                        this.f994a = new File(this.f78065a.getFilesDir(), "default_locker");
                    }
                    uVar = u.a(this.f78065a, this.f994a);
                    if (this.f995a != null) {
                        this.f995a.run();
                    }
                    a(this.f78065a);
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
