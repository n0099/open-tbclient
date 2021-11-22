package com.dxmpay.wallet.base.camera.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.imagemanager.ImageProcessor;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes11.dex */
public abstract class ImageUtils implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = true;
    public static final String TAG = "ImageUtils";
    public static final int UNCONSTRAINED = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public ImageUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int calSampleSize(Context context, Uri uri) {
        InterceptResult invokeLL;
        int i2;
        int[] screenSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, uri)) == null) {
            if (context != null && uri != null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                ParcelFileDescriptor parcelFileDescriptor = null;
                try {
                    ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, r.f41000a);
                    if (openFileDescriptor != null) {
                        try {
                            BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
                            i2 = options.outWidth * options.outHeight;
                        } catch (Exception unused) {
                            parcelFileDescriptor = openFileDescriptor;
                            if (parcelFileDescriptor != null) {
                                try {
                                    parcelFileDescriptor.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            return 1;
                        } catch (Throwable th) {
                            th = th;
                            parcelFileDescriptor = openFileDescriptor;
                            if (parcelFileDescriptor != null) {
                                try {
                                    parcelFileDescriptor.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        i2 = 0;
                    }
                    if (openFileDescriptor != null) {
                        try {
                            openFileDescriptor.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (i2 == 0 || (screenSize = getScreenSize(context)) == null) {
                        return 1;
                    }
                    return (int) Math.ceil(Math.sqrt(i2 / (screenSize[0] * screenSize[1])));
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return 1;
        }
        return invokeLL.intValue;
    }

    public static synchronized String createFileName(String str) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (ImageUtils.class) {
                format = String.format("%s.%s", new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss-SSS").format(new Date()), str);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static Bitmap getBPfromsdcard(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = ImageProcessor.a(options, SDKLogTypeConstants.DZZB_ALERTDIALOG_NEGATIVE_CLICKED, -1);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap getBitmapFromRGB888(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2, i3)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            int i4 = i2 * i3;
            int[] iArr = new int[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5 * 3;
                iArr[i5] = Color.rgb(bArr[i6] & 255, bArr[i6 + 1] & 255, bArr[i6 + 2] & 255);
            }
            createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0027 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: android.os.ParcelFileDescriptor */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: android.os.ParcelFileDescriptor */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: android.os.ParcelFileDescriptor */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap getBitmapFromUri(Context context, Uri uri, BitmapFactory.Options options) {
        InterceptResult invokeLLL;
        ParcelFileDescriptor parcelFileDescriptor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, uri, options)) == null) {
            Bitmap bitmap = null;
            bitmap = null;
            bitmap = null;
            bitmap = null;
            ParcelFileDescriptor parcelFileDescriptor2 = 0;
            try {
                try {
                    try {
                        parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, r.f41000a);
                        if (parcelFileDescriptor != null) {
                            try {
                                bitmap = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                if (parcelFileDescriptor != null) {
                                    parcelFileDescriptor.close();
                                }
                                return bitmap;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelFileDescriptor2 = context;
                        if (parcelFileDescriptor2 != 0) {
                            try {
                                parcelFileDescriptor2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    parcelFileDescriptor = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (parcelFileDescriptor2 != 0) {
                    }
                    throw th;
                }
                if (parcelFileDescriptor != null) {
                    parcelFileDescriptor.close();
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return bitmap;
        }
        return (Bitmap) invokeLLL.objValue;
    }

    public static int[] getScreenSize(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (context != null) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
            }
            return null;
        }
        return (int[]) invokeL.objValue;
    }

    public static Bitmap rotateAReversalBitmap(int i2, Bitmap bitmap) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65543, null, i2, bitmap)) == null) {
            if (bitmap == null) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(i2);
            matrix.postScale(-1.0f, 1.0f);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return (Bitmap) invokeIL.objValue;
    }

    public static Bitmap rotateBitmap(int i2, Bitmap bitmap) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i2, bitmap)) == null) {
            if (bitmap == null) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(i2);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return (Bitmap) invokeIL.objValue;
    }

    public static String saveBitmapToCache(Context context, Bitmap bitmap, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, context, bitmap, str)) == null) ? saveBitmapToCache(context, bitmap, str, 100) : (String) invokeLLL.objValue;
    }

    public static String saveBitmapToSdcard(Context context, Bitmap bitmap, String str) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, context, bitmap, str)) == null) {
            if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
                if (TextUtils.isEmpty(str)) {
                    str = "jpg";
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("_display_name", str);
                contentValues.put("mime_type", "image/jpeg");
                ContentResolver contentResolver = context.getContentResolver();
                Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                try {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(insert, "w", null);
                    if (openFileDescriptor != null) {
                        if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(openFileDescriptor.getFileDescriptor()))) {
                            str2 = insert.toString();
                            contentValues.clear();
                            contentResolver.update(insert, contentValues, null, null);
                            openFileDescriptor.close();
                            return str2;
                        }
                    }
                    str2 = "";
                    contentValues.clear();
                    contentResolver.update(insert, contentValues, null, null);
                    openFileDescriptor.close();
                    return str2;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
            try {
                File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                if (TextUtils.isEmpty(str)) {
                    str = createFileName("jpg");
                }
                File file = new File(externalStoragePublicDirectory, str);
                return bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(file)) ? file.getAbsolutePath() : "";
            } catch (Throwable th) {
                LogUtil.e("ImageUtils", "FileNotFoundException", th);
                return "";
            }
        }
        return (String) invokeLLL.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x004d -> B:51:0x0061). Please submit an issue!!! */
    public static String saveBitmapToCache(Context context, Bitmap bitmap, String str, int i2) {
        InterceptResult invokeLLLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65546, null, context, bitmap, str, i2)) == null) {
            str2 = "";
            if (i2 < 0 || i2 > 100) {
                return "";
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    File file = new File(context.getCacheDir().getAbsolutePath(), "image_cache");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = createFileName("jpg");
                    }
                    File file2 = new File(file, str);
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        str2 = bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream2) ? file2.getAbsolutePath() : "";
                        fileOutputStream2.close();
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        try {
                            LogUtil.e("ImageUtils", "FileNotFoundException", th);
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return str2;
                        } catch (Throwable th2) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return str2;
        }
        return (String) invokeLLLI.objValue;
    }
}
