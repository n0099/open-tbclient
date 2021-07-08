package com.facebook.common.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class UriUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DATA_SCHEME = "data";
    public static final String HTTPS_SCHEME = "https";
    public static final String HTTP_SCHEME = "http";
    public static final String LOCAL_ASSET_SCHEME = "asset";
    public static final Uri LOCAL_CONTACT_IMAGE_URI;
    public static final String LOCAL_CONTENT_SCHEME = "content";
    public static final String LOCAL_FILE_SCHEME = "file";
    public static final String LOCAL_RESOURCE_SCHEME = "res";
    public static final String QUALIFIED_RESOURCE_SCHEME = "android.resource";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1536819621, "Lcom/facebook/common/util/UriUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1536819621, "Lcom/facebook/common/util/UriUtil;");
                return;
            }
        }
        LOCAL_CONTACT_IMAGE_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");
    }

    public UriUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Nullable
    public static String getRealPathFromUri(ContentResolver contentResolver, Uri uri) {
        InterceptResult invokeLL;
        int columnIndex;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65538, null, contentResolver, uri)) != null) {
            return (String) invokeLL.objValue;
        }
        Cursor cursor = null;
        r1 = null;
        r1 = null;
        String string = null;
        if (isLocalContentUri(uri)) {
            try {
                Cursor query = contentResolver.query(uri, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) != -1) {
                            string = query.getString(columnIndex);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                    return string;
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
            }
        } else if (isLocalFileUri(uri)) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    @Nullable
    public static String getSchemeOrNull(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            return uri.getScheme();
        }
        return (String) invokeL.objValue;
    }

    public static Uri getUriForFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) ? Uri.fromFile(file) : (Uri) invokeL.objValue;
    }

    public static Uri getUriForQualifiedResource(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, str, i2)) == null) ? new Uri.Builder().scheme(QUALIFIED_RESOURCE_SCHEME).authority(str).path(String.valueOf(i2)).build() : (Uri) invokeLI.objValue;
    }

    public static Uri getUriForResourceId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? new Uri.Builder().scheme(LOCAL_RESOURCE_SCHEME).path(String.valueOf(i2)).build() : (Uri) invokeI.objValue;
    }

    public static boolean isDataUri(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, uri)) == null) ? "data".equals(getSchemeOrNull(uri)) : invokeL.booleanValue;
    }

    public static boolean isLocalAssetUri(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, uri)) == null) ? LOCAL_ASSET_SCHEME.equals(getSchemeOrNull(uri)) : invokeL.booleanValue;
    }

    public static boolean isLocalCameraUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, uri)) == null) {
            String uri2 = uri.toString();
            return uri2.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
        }
        return invokeL.booleanValue;
    }

    public static boolean isLocalContactUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, uri)) == null) ? isLocalContentUri(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(LOCAL_CONTACT_IMAGE_URI.getPath()) : invokeL.booleanValue;
    }

    public static boolean isLocalContentUri(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, uri)) == null) ? "content".equals(getSchemeOrNull(uri)) : invokeL.booleanValue;
    }

    public static boolean isLocalFileUri(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, uri)) == null) ? "file".equals(getSchemeOrNull(uri)) : invokeL.booleanValue;
    }

    public static boolean isLocalResourceUri(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, uri)) == null) ? LOCAL_RESOURCE_SCHEME.equals(getSchemeOrNull(uri)) : invokeL.booleanValue;
    }

    public static boolean isNetworkUri(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, uri)) == null) {
            String schemeOrNull = getSchemeOrNull(uri);
            return "https".equals(schemeOrNull) || "http".equals(schemeOrNull);
        }
        return invokeL.booleanValue;
    }

    public static boolean isQualifiedResourceUri(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, uri)) == null) ? QUALIFIED_RESOURCE_SCHEME.equals(getSchemeOrNull(uri)) : invokeL.booleanValue;
    }

    @Nullable
    public static Uri parseUriOrNull(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }
        return (Uri) invokeL.objValue;
    }

    @Nullable
    public static URL uriToUrl(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            try {
                return new URL(uri.toString());
            } catch (MalformedURLException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (URL) invokeL.objValue;
    }
}
