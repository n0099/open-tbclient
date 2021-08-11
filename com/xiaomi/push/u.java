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
/* loaded from: classes10.dex */
public final class u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f77863a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f990a;

    /* renamed from: a  reason: collision with other field name */
    public RandomAccessFile f991a;

    /* renamed from: a  reason: collision with other field name */
    public String f992a;

    /* renamed from: a  reason: collision with other field name */
    public FileLock f993a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1664386111, "Lcom/xiaomi/push/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1664386111, "Lcom/xiaomi/push/u;");
                return;
            }
        }
        f77863a = Collections.synchronizedSet(new HashSet());
    }

    public u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f990a = context;
    }

    public static u a(Context context, File file) {
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
            if (f77863a.add(str)) {
                u uVar = new u(context);
                uVar.f992a = str;
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                    uVar.f991a = randomAccessFile;
                    uVar.f993a = randomAccessFile.getChannel().lock();
                    com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f993a);
                    return uVar;
                } finally {
                    if (uVar.f993a == null) {
                        RandomAccessFile randomAccessFile2 = uVar.f991a;
                        if (randomAccessFile2 != null) {
                            y.a(randomAccessFile2);
                        }
                        f77863a.remove(uVar.f992a);
                    }
                }
            }
            throw new IOException("abtain lock failure");
        }
        return (u) invokeLL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f993a);
            FileLock fileLock = this.f993a;
            if (fileLock != null && fileLock.isValid()) {
                try {
                    this.f993a.release();
                } catch (IOException unused) {
                }
                this.f993a = null;
            }
            RandomAccessFile randomAccessFile = this.f991a;
            if (randomAccessFile != null) {
                y.a(randomAccessFile);
            }
            f77863a.remove(this.f992a);
        }
    }
}
