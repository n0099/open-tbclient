package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f40839a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f867a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f868a;

    /* renamed from: a  reason: collision with other field name */
    public final String f869a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f40840b;

    /* renamed from: b  reason: collision with other field name */
    public final String f870b;

    /* renamed from: c  reason: collision with root package name */
    public final String f40841c;

    /* renamed from: d  reason: collision with root package name */
    public final String f40842d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f40843e;

    /* renamed from: f  reason: collision with root package name */
    public volatile String f40844f;

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
        this.f868a = new Object();
        this.f40840b = new Object();
        this.f869a = "mipush_region";
        this.f870b = "mipush_country_code";
        this.f40841c = "mipush_region.lock";
        this.f40842d = "mipush_country_code.lock";
        this.f867a = context;
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f40839a == null) {
                synchronized (a.class) {
                    if (f40839a == null) {
                        f40839a = new a(context);
                    }
                }
            }
            return f40839a;
        }
        return (a) invokeL.objValue;
    }

    private String a(Context context, String str, String str2, Object obj) {
        InterceptResult invokeLLLL;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(65538, this, context, str, str2, obj)) != null) {
            return (String) invokeLLLL.objValue;
        }
        File file = new File(context.getFilesDir(), str);
        FileLock fileLock2 = null;
        if (!file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.m70a("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                File file2 = new File(context.getFilesDir(), str2);
                com.xiaomi.push.y.m643a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    try {
                        try {
                            String a2 = com.xiaomi.push.y.a(file);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e2) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                                }
                            }
                            com.xiaomi.push.y.a(randomAccessFile);
                            return a2;
                        } catch (Exception e3) {
                            e = e3;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e4) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                                }
                            }
                            com.xiaomi.push.y.a(randomAccessFile);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileLock2 = fileLock;
                        if (fileLock2 != null && fileLock2.isValid()) {
                            try {
                                fileLock2.release();
                            } catch (IOException e5) {
                                com.xiaomi.channel.commonutils.logger.b.a(e5);
                            }
                        }
                        com.xiaomi.push.y.a(randomAccessFile);
                        throw th;
                    }
                } catch (Exception e6) {
                    e = e6;
                    fileLock = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileLock2 != null) {
                        fileLock2.release();
                    }
                    com.xiaomi.push.y.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                randomAccessFile = null;
                fileLock = null;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0041 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0060 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x0006 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    private void a(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, this, context, str, str2, str3, obj) == null) {
            synchronized (obj) {
                FileLock fileLock = null;
                try {
                    try {
                        try {
                            File file = new File(context.getFilesDir(), (String) str3);
                            com.xiaomi.push.y.m643a(file);
                            randomAccessFile = new RandomAccessFile(file, "rw");
                            try {
                                fileLock = randomAccessFile.getChannel().lock();
                                com.xiaomi.push.y.a(new File(context.getFilesDir(), str2), str);
                                str3 = randomAccessFile;
                                if (fileLock != null) {
                                    str3 = randomAccessFile;
                                    if (fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                            str3 = randomAccessFile;
                                        } catch (IOException e2) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                                            str3 = randomAccessFile;
                                        }
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                str3 = randomAccessFile;
                                if (fileLock != null) {
                                    str3 = randomAccessFile;
                                    if (fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                            str3 = randomAccessFile;
                                        } catch (IOException e4) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                                            str3 = randomAccessFile;
                                        }
                                    }
                                }
                                com.xiaomi.push.y.a((Closeable) str3);
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e5) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e5);
                                }
                            }
                            com.xiaomi.push.y.a((Closeable) str3);
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        randomAccessFile = null;
                    } catch (Throwable th2) {
                        th = th2;
                        str3 = 0;
                        if (fileLock != null) {
                            fileLock.release();
                        }
                        com.xiaomi.push.y.a((Closeable) str3);
                        throw th;
                    }
                    com.xiaomi.push.y.a((Closeable) str3);
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f40843e)) {
                this.f40843e = a(this.f867a, "mipush_region", "mipush_region.lock", this.f868a);
            }
            return this.f40843e;
        }
        return (String) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.equals(str, this.f40843e)) {
            return;
        }
        this.f40843e = str;
        a(this.f867a, this.f40843e, "mipush_region", "mipush_region.lock", this.f868a);
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(this.f40844f)) {
                this.f40844f = a(this.f867a, "mipush_country_code", "mipush_country_code.lock", this.f40840b);
            }
            return this.f40844f;
        }
        return (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.equals(str, this.f40844f)) {
            return;
        }
        this.f40844f = str;
        a(this.f867a, this.f40844f, "mipush_country_code", "mipush_country_code.lock", this.f40840b);
    }
}
