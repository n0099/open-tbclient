package com.bytedance.sdk.openadsdk.l.a;

import android.os.Environment;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.core.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f31397a;

    /* renamed from: b  reason: collision with root package name */
    public static String f31398b;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f31399g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public WeakHashMap<String, String> f31400c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.d.a f31401d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.d.a f31402e;

    /* renamed from: f  reason: collision with root package name */
    public final LruCache<String, C0353a> f31403f;

    /* renamed from: com.bytedance.sdk.openadsdk.l.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0353a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public byte[] f31405a;

        public C0353a(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31405a = bArr;
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
        this.f31400c = new WeakHashMap<>();
        this.f31403f = new LruCache<String, C0353a>(this, 5242880) { // from class: com.bytedance.sdk.openadsdk.l.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f31404a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f31404a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.LruCache
            /* renamed from: a */
            public int sizeOf(String str, C0353a c0353a) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, c0353a)) == null) {
                    byte[] bArr = c0353a.f31405a;
                    int length = bArr != null ? 0 + bArr.length : 0;
                    return length == 0 ? super.sizeOf(str, c0353a) : length;
                }
                return invokeLL.intValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.LruCache
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, C0353a c0353a, C0353a c0353a2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, c0353a, c0353a2}) == null) {
                    super.entryRemoved(z, str, c0353a, c0353a2);
                    if (!z || c0353a == null) {
                        return;
                    }
                    c0353a.f31405a = null;
                }
            }
        };
        this.f31401d = new com.bytedance.sdk.openadsdk.d.d();
        this.f31402e = new com.bytedance.sdk.openadsdk.d.d(DownloadManager.MIN_LEFT_SIZE, true);
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f31399g == null) {
                synchronized (a.class) {
                    if (f31399g == null) {
                        f31399g = new a();
                    }
                }
            }
            return f31399g;
        }
        return (a) invokeV.objValue;
    }

    public synchronized void b(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, bArr) == null) {
            synchronized (this) {
                j.f("splashLoadAd", " GifCache put 将图片素材保存到本地 key " + str);
                if (!TextUtils.isEmpty(str) && bArr != null) {
                    if (!a(bArr)) {
                        this.f31403f.put(str, new C0353a(bArr));
                    }
                    File file = new File(c(), str);
                    if (file.exists() && file.isFile() && file.length() > 0) {
                        return;
                    }
                    j.f("splashLoadAd", " GifCache put 将图片素材保存到本地 target " + file.getPath());
                    File file2 = new File(file + ".tmp");
                    file2.delete();
                    FileOutputStream fileOutputStream = null;
                    try {
                        try {
                            file2.createNewFile();
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                            try {
                                fileOutputStream2.write(bArr);
                                fileOutputStream2.flush();
                                if (file2.exists() && file2.length() > 0) {
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    file2.renameTo(file);
                                }
                                this.f31401d.a(file);
                                fileOutputStream2.close();
                            } catch (Throwable unused) {
                                fileOutputStream = fileOutputStream2;
                                file2.delete();
                                file.delete();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            }
                        } catch (Throwable unused2) {
                        }
                    } catch (IOException unused3) {
                    }
                }
            }
        }
    }

    public synchronized void c(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, bArr) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str) && bArr != null) {
                    if (!a(bArr)) {
                        this.f31403f.put(str, new C0353a(bArr));
                    }
                    j.f("splashLoadAd", " GifCache put 保存到本地图片的素材路径 getCacheDir() " + b());
                    File file = new File(b(), str);
                    if (file.exists() && file.isFile() && file.length() > 0) {
                        j.f("splashLoadAd", " GifCache put 本地的gif素材以及存在 key " + str);
                        return;
                    }
                    File file2 = new File(file + ".tmp");
                    file2.delete();
                    FileOutputStream fileOutputStream2 = null;
                    try {
                        try {
                            file2.createNewFile();
                            fileOutputStream = new FileOutputStream(file2);
                        } catch (IOException unused) {
                        }
                        try {
                            fileOutputStream.write(bArr);
                            fileOutputStream.flush();
                            if (file2.exists() && file2.length() > 0) {
                                if (file.exists()) {
                                    file.delete();
                                }
                                file2.renameTo(file);
                            }
                            if (this.f31402e != null) {
                                this.f31402e.a(file);
                            }
                            fileOutputStream.close();
                        } catch (Throwable unused2) {
                            fileOutputStream2 = fileOutputStream;
                            file2.delete();
                            file.delete();
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                }
            }
        }
    }

    public synchronized void a(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, bArr) == null) {
            synchronized (this) {
                j.f("splashLoadAd", " put GifLoader.mIsSpalsh " + b.f31407b);
                if (b.f31407b) {
                    c(str, bArr);
                } else {
                    b(str, bArr);
                }
            }
        }
    }

    private boolean a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bArr)) == null) ? bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 : invokeL.booleanValue;
    }

    public synchronized File a(String str, boolean z) {
        InterceptResult invokeLZ;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                if (z) {
                    file = new File(b(), str);
                } else {
                    file = new File(c(), str);
                }
                if (file.exists()) {
                    if (file.length() > 0) {
                        return file;
                    }
                }
                return null;
            }
        }
        return (File) invokeLZ.objValue;
    }

    public synchronized C0353a a(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                C0353a c0353a = this.f31403f.get(str);
                if (c0353a != null) {
                    return c0353a;
                }
                File file = new File(c(), str);
                if (file.exists()) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            ByteBuffer allocate = ByteBuffer.allocate(Long.valueOf(file.length()).intValue());
                            fileInputStream.getChannel().read(allocate);
                            C0353a c0353a2 = new C0353a(allocate.array());
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                            return c0353a2;
                        } catch (Throwable th) {
                            th = th;
                            j.c("GifCache", "gifCache get error ", th);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                    }
                }
                return null;
            }
        }
        return (C0353a) invokeL.objValue;
    }

    public synchronized C0353a b(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                j.f("splashLoadAd", " GifCache get  key " + str);
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                C0353a c0353a = this.f31403f.get(str);
                if (c0353a != null) {
                    return c0353a;
                }
                j.f("splashLoadAd", " GifCache 从缓存文件中获取图片素材，图片路径为" + b() + " key " + str);
                File file = new File(b(), str);
                try {
                    f.b(file);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (file.exists()) {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = null;
                    }
                    try {
                        ByteBuffer allocate = ByteBuffer.allocate(Long.valueOf(file.length()).intValue());
                        fileInputStream.getChannel().read(allocate);
                        C0353a c0353a2 = new C0353a(allocate.array());
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        return c0353a2;
                    } catch (Throwable th2) {
                        th = th2;
                        j.c("GifCache", "gifCache get error ", th);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        j.f("splashLoadAd", " GifCache 缓存文件中不存在该图片素材  key " + str);
                        return null;
                    }
                }
                j.f("splashLoadAd", " GifCache 缓存文件中不存在该图片素材  key " + str);
                return null;
            }
        }
        return (C0353a) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (TextUtils.isEmpty(f31397a)) {
                f31397a = c("diskGif");
            }
            return f31397a;
        }
        return (String) invokeV.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            String str2 = "";
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            boolean z = true;
            if (o.h().C() == 1) {
                File file = new File(com.bytedance.sdk.component.adnet.a.b(o.a()), str);
                file.mkdirs();
                return file.getAbsolutePath();
            }
            if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
                z = false;
            }
            File file2 = null;
            if (z) {
                try {
                    j.f("splashLoadAd", "当存在外部存储并且开屏支持外部存储");
                    file2 = new File(o.a().getExternalCacheDir(), str);
                    file2.mkdirs();
                    str2 = file2.getAbsolutePath();
                } catch (Throwable unused) {
                    return "";
                }
            }
            if (file2 == null) {
                File file3 = new File(com.bytedance.sdk.component.adnet.a.b(o.a()), str);
                file3.mkdirs();
                return file3.getAbsolutePath();
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public synchronized String a(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), scaleType})) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                if (str.startsWith("https")) {
                    str = str.replaceFirst("https", "http");
                }
                String str2 = this.f31400c.get(str);
                if (TextUtils.isEmpty(str2)) {
                    String a2 = e.a(str);
                    this.f31400c.put(str, a2);
                    return a2;
                }
                return str2;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (TextUtils.isEmpty(f31398b)) {
                f31398b = c("splash_image");
            }
            return f31398b;
        }
        return (String) invokeV.objValue;
    }
}
