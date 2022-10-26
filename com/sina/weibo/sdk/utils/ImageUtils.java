package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes8.dex */
public class ImageUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ImageUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void delete(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, file) == null) && file != null && file.exists() && !file.delete()) {
            throw new RuntimeException(file.getAbsolutePath() + " doesn't be deleted!");
        }
    }

    public static boolean deleteDependon(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            int i = 1;
            while (!z && i <= 5 && file.isFile() && file.exists()) {
                z = file.delete();
                if (!z) {
                    i++;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static long getVideoDuring(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!new File(str).exists()) {
                return 0L;
            }
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static boolean isParentExist(File file) {
        InterceptResult invokeL;
        File parentFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) {
            if (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
                return false;
            }
            if (!file.exists() && !file.mkdirs()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void makesureFileExist(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, str) != null) || str == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists() && isParentExist(file)) {
            if (file.exists()) {
                delete(file);
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isFileExisted(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isWifi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void revitionImageSize(String str, int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65544, null, str, i, i2) == null) {
            if (i > 0) {
                if (!isFileExisted(str)) {
                    if (str == null) {
                        str = StringUtil.NULL_STRING;
                    }
                    throw new FileNotFoundException(str);
                } else if (BitmapHelper.verifyBitmap(str)) {
                    FileInputStream fileInputStream = new FileInputStream(str);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(fileInputStream, null, options);
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int i3 = 0;
                    while (true) {
                        if ((options.outWidth >> i3) <= i && (options.outHeight >> i3) <= i) {
                            break;
                        }
                        i3++;
                    }
                    options.inSampleSize = (int) Math.pow(2.0d, i3);
                    options.inJustDecodeBounds = false;
                    Bitmap safeDecodeBimtapFile = safeDecodeBimtapFile(str, options);
                    if (safeDecodeBimtapFile != null) {
                        deleteDependon(str);
                        makesureFileExist(str);
                        FileOutputStream fileOutputStream = new FileOutputStream(str);
                        String str2 = options.outMimeType;
                        if (str2 != null && str2.contains("png")) {
                            safeDecodeBimtapFile.compress(Bitmap.CompressFormat.PNG, i2, fileOutputStream);
                        } else {
                            safeDecodeBimtapFile.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        safeDecodeBimtapFile.recycle();
                        return;
                    }
                    throw new IOException("Bitmap decode error!");
                } else {
                    throw new IOException("");
                }
            }
            throw new IllegalArgumentException("size must be greater than 0!");
        }
    }

    public static void revitionImageSizeHD(String str, int i, int i2) throws IOException {
        int height;
        Bitmap createBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65545, null, str, i, i2) == null) {
            if (i > 0) {
                if (!isFileExisted(str)) {
                    if (str == null) {
                        str = StringUtil.NULL_STRING;
                    }
                    throw new FileNotFoundException(str);
                } else if (BitmapHelper.verifyBitmap(str)) {
                    int i3 = i * 2;
                    FileInputStream fileInputStream = new FileInputStream(str);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(fileInputStream, null, options);
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int i4 = 0;
                    while (true) {
                        if ((options.outWidth >> i4) <= i3 && (options.outHeight >> i4) <= i3) {
                            break;
                        }
                        i4++;
                    }
                    options.inSampleSize = (int) Math.pow(2.0d, i4);
                    options.inJustDecodeBounds = false;
                    Bitmap safeDecodeBimtapFile = safeDecodeBimtapFile(str, options);
                    if (safeDecodeBimtapFile != null) {
                        deleteDependon(str);
                        makesureFileExist(str);
                        if (safeDecodeBimtapFile.getWidth() > safeDecodeBimtapFile.getHeight()) {
                            height = safeDecodeBimtapFile.getWidth();
                        } else {
                            height = safeDecodeBimtapFile.getHeight();
                        }
                        float f = i / height;
                        if (f < 1.0f) {
                            while (true) {
                                try {
                                    createBitmap = Bitmap.createBitmap((int) (safeDecodeBimtapFile.getWidth() * f), (int) (safeDecodeBimtapFile.getHeight() * f), Bitmap.Config.ARGB_8888);
                                    break;
                                } catch (OutOfMemoryError unused) {
                                    System.gc();
                                    f = (float) (f * 0.8d);
                                }
                            }
                            if (createBitmap == null) {
                                safeDecodeBimtapFile.recycle();
                            }
                            Canvas canvas = new Canvas(createBitmap);
                            Matrix matrix = new Matrix();
                            matrix.setScale(f, f);
                            canvas.drawBitmap(safeDecodeBimtapFile, matrix, new Paint());
                            safeDecodeBimtapFile.recycle();
                            safeDecodeBimtapFile = createBitmap;
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(str);
                        String str2 = options.outMimeType;
                        if (str2 != null && str2.contains("png")) {
                            safeDecodeBimtapFile.compress(Bitmap.CompressFormat.PNG, i2, fileOutputStream);
                        } else {
                            safeDecodeBimtapFile.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        safeDecodeBimtapFile.recycle();
                        return;
                    }
                    throw new IOException("Bitmap decode error!");
                } else {
                    throw new IOException("");
                }
            }
            throw new IllegalArgumentException("size must be greater than 0!");
        }
    }

    public static Bitmap safeDecodeBimtapFile(String str, BitmapFactory.Options options) {
        InterceptResult invokeLL;
        BitmapFactory.Options options2;
        FileInputStream fileInputStream;
        OutOfMemoryError e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, options)) == null) {
            if (options == null) {
                options2 = new BitmapFactory.Options();
                options2.inSampleSize = 1;
            } else {
                options2 = options;
            }
            int i = 0;
            Bitmap bitmap = null;
            FileInputStream fileInputStream2 = null;
            while (i < 5) {
                try {
                    try {
                        fileInputStream = new FileInputStream(str);
                    } catch (FileNotFoundException unused) {
                    }
                    try {
                        bitmap = BitmapFactory.decodeStream(fileInputStream, null, options);
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return bitmap;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        e.printStackTrace();
                        options2.inSampleSize *= 2;
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        i++;
                        fileInputStream2 = fileInputStream;
                    }
                } catch (OutOfMemoryError e5) {
                    fileInputStream = fileInputStream2;
                    e = e5;
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLL.objValue;
    }
}
