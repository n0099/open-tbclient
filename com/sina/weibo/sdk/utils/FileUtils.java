package com.sina.weibo.sdk.utils;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.activity.ImageClipActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class FileUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IMAGE_FILE_START = "image/";
    public static final String VIDEO_FILE_START = "video/";
    public transient /* synthetic */ FieldHolder $fh;

    public FileUtils() {
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

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        if (r8 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        if (r8 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(65537, null, context, uri, str, strArr)) != null) {
            return (String) invokeLLLL.objValue;
        }
        Cursor cursor2 = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                            if (cursor != null) {
                                cursor.close();
                            }
                            return string;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public static String getMIMEType(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(".");
            if (lastIndexOf < 0) {
                return "*/*";
            }
            String substring = name.substring(lastIndexOf, name.length());
            return (!TextUtils.isEmpty(substring) || substring.length() >= 2) ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring.substring(1, substring.length()).toLowerCase()) : "*/*";
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static String getPath(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, uri)) == null) {
            Uri uri2 = null;
            if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
                if (isExternalStorageDocument(uri)) {
                    String[] split = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(split[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + split[1];
                    }
                } else if (isDownloadsDocument(uri)) {
                    return getDataColumn(context, ContentUris.withAppendedId(Uri.parse(ImageClipActivity.n), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                } else {
                    if (isMediaDocument(uri)) {
                        String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = split2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if ("video".equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else if ("audio".equals(str)) {
                            uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        }
                        return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
                    }
                }
            } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return getDataColumn(context, uri, null, null);
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri)) == null) ? ImageClipActivity.l.equals(uri.getAuthority()) : invokeL.booleanValue;
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, uri)) == null) ? ImageClipActivity.m.equals(uri.getAuthority()) : invokeL.booleanValue;
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, uri)) == null) ? "com.google.android.apps.photos.content".equals(uri.getAuthority()) : invokeL.booleanValue;
    }

    public static boolean isImageFile(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, uri)) == null) ? getMIMEType(new File(getPath(context, uri))).startsWith(IMAGE_FILE_START) : invokeLL.booleanValue;
    }

    public static boolean isMediaDocument(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, uri)) == null) ? ImageClipActivity.k.equals(uri.getAuthority()) : invokeL.booleanValue;
    }

    public static boolean isVideoFile(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, uri)) == null) ? getMIMEType(new File(getPath(context, uri))).startsWith(VIDEO_FILE_START) : invokeLL.booleanValue;
    }
}
