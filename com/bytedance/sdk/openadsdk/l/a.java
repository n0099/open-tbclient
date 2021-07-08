package com.bytedance.sdk.openadsdk.l;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.core.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public class a extends com.bytedance.sdk.component.adnet.b.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static String f31394b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public WeakHashMap<String, String> f31395c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.d.a f31396d;

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
        this.f31395c = new WeakHashMap<>();
        this.f31396d = new com.bytedance.sdk.openadsdk.d.d();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.b.a, com.bytedance.sdk.component.adnet.b.d.b
    public Bitmap b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Bitmap b2 = super.b(str);
            if (b2 == null) {
                File file = new File(b(), str);
                if (file.exists()) {
                    FileInputStream fileInputStream = null;
                    try {
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream(file);
                            try {
                                b2 = BitmapFactory.decodeFileDescriptor(fileInputStream2.getFD(), null, null);
                                if (b2 != null) {
                                    super.a(str, b2, new byte[0]);
                                }
                                fileInputStream2.close();
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                try {
                                    j.c("DiskImageCache", "diskImageCache getBitmap error ", th);
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    return b2;
                                } catch (Throwable th2) {
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException unused) {
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (IOException unused2) {
                    }
                }
            }
            return b2;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.b.a, com.bytedance.sdk.component.adnet.b.d.b
    public void a(String str, Bitmap bitmap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bitmap, bArr) == null) || bitmap == null) {
            return;
        }
        super.a(str, bitmap, bArr);
        File file = new File(b(), str);
        if (file.exists() && file.isFile() && file.length() > 0) {
            return;
        }
        File file2 = new File(file + ".tmp");
        file2.delete();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                file2.createNewFile();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                    fileOutputStream2.flush();
                    if (file2.exists() && file2.length() > 0) {
                        file2.renameTo(file);
                    }
                    this.f31396d.a(file);
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        j.c("DiskImageCache", "diskImageCache putBitmap error ", th);
                        file2.delete();
                        file.delete();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException unused2) {
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (TextUtils.isEmpty(f31394b)) {
                File file = new File(com.bytedance.sdk.component.adnet.a.b(o.a()), "diskImage");
                file.mkdirs();
                f31394b = file.getAbsolutePath();
            }
            return f31394b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.b.a, com.bytedance.sdk.component.adnet.b.d.b
    public String a(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), scaleType})) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = this.f31395c.get(str);
            if (TextUtils.isEmpty(str2)) {
                String a2 = com.bytedance.sdk.component.utils.e.a(str);
                this.f31395c.put(str, a2);
                return a2;
            }
            return str2;
        }
        return (String) invokeCommon.objValue;
    }
}
