package com.xiaomi.push;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public final class x {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f1038a;

    /* renamed from: a  reason: collision with other field name */
    public RandomAccessFile f1039a;

    /* renamed from: a  reason: collision with other field name */
    public String f1040a;

    /* renamed from: a  reason: collision with other field name */
    public FileLock f1041a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1664386018, "Lcom/xiaomi/push/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1664386018, "Lcom/xiaomi/push/x;");
                return;
            }
        }
        a = Collections.synchronizedSet(new HashSet());
    }

    public x(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1038a = context;
    }

    public static x a(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, file)) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
            String str = file.getAbsolutePath() + ".LOCK";
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.getParentFile().mkdirs();
                file2.createNewFile();
            }
            if (a.add(str)) {
                x xVar = new x(context);
                xVar.f1040a = str;
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                    xVar.f1039a = randomAccessFile;
                    xVar.f1041a = randomAccessFile.getChannel().lock();
                    com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + xVar.f1041a);
                    return xVar;
                } finally {
                    if (xVar.f1041a == null) {
                        RandomAccessFile randomAccessFile2 = xVar.f1039a;
                        if (randomAccessFile2 != null) {
                            ab.a(randomAccessFile2);
                        }
                        a.remove(xVar.f1040a);
                    }
                }
            }
            throw new IOException("abtain lock failure");
        }
        return (x) invokeLL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f1041a);
            FileLock fileLock = this.f1041a;
            if (fileLock != null && fileLock.isValid()) {
                try {
                    this.f1041a.release();
                } catch (IOException unused) {
                }
                this.f1041a = null;
            }
            RandomAccessFile randomAccessFile = this.f1039a;
            if (randomAccessFile != null) {
                ab.a(randomAccessFile);
            }
            a.remove(this.f1040a);
        }
    }
}
