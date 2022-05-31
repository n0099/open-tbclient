package com.repackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.jb;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes6.dex */
public class ql7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Bitmap bitmap = null;
            try {
                File file = new File(str);
                if (file.exists()) {
                    if (c(file)) {
                        um umVar = jb.a.b().get(str);
                        if (umVar != null) {
                            bitmap = umVar.p();
                        }
                    } else {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(str, options);
                        bitmap = BitmapHelper.loadResizedBitmap(str, options.outWidth, options.outHeight);
                    }
                }
            } catch (OutOfMemoryError unused) {
            }
            return bitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap b(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, imageFileInfo)) == null) {
            x25 x25Var = new x25();
            um c = x25Var.c(imageFileInfo, true);
            if (c != null) {
                f = c.p();
            } else {
                f = x25Var.f(imageFileInfo, true);
            }
            return f == null ? a(imageFileInfo.getFilePath()) : f;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static boolean c(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                byte[] bArr = new byte[7];
                r1 = fileInputStream.read(bArr, 0, 6) == 6 ? li.B(bArr) : false;
                fileInputStream.close();
            } catch (FileNotFoundException e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return r1;
            } catch (IOException e5) {
                e = e5;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return r1;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
            if (0 != 0) {
                fileInputStream2.close();
            }
            return r1;
        }
        return invokeL.booleanValue;
    }
}
