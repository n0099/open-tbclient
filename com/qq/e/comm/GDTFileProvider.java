package com.qq.e.comm;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes10.dex */
public class GDTFileProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f74896a;

    /* renamed from: b  reason: collision with root package name */
    public static final File f74897b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, a> f74898c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a f74899d;

    /* loaded from: classes10.dex */
    public interface a {
        Uri a(File file);

        File a(Uri uri);
    }

    /* loaded from: classes10.dex */
    public static class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f74900a;

        /* renamed from: b  reason: collision with root package name */
        public final HashMap<String, File> f74901b;

        public b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74901b = new HashMap<>();
            this.f74900a = str;
        }

        @Override // com.qq.e.comm.GDTFileProvider.a
        public final Uri a(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                try {
                    String canonicalPath = file.getCanonicalPath();
                    Map.Entry<String, File> entry = null;
                    for (Map.Entry<String, File> entry2 : this.f74901b.entrySet()) {
                        String path = entry2.getValue().getPath();
                        if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                            entry = entry2;
                        }
                    }
                    if (entry == null) {
                        throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                    }
                    String path2 = entry.getValue().getPath();
                    boolean endsWith = path2.endsWith("/");
                    int length = path2.length();
                    if (!endsWith) {
                        length++;
                    }
                    String substring = canonicalPath.substring(length);
                    return new Uri.Builder().scheme("content").authority(this.f74900a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
                }
            }
            return (Uri) invokeL.objValue;
        }

        @Override // com.qq.e.comm.GDTFileProvider.a
        public final File a(Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
                String encodedPath = uri.getEncodedPath();
                int indexOf = encodedPath.indexOf(47, 1);
                String decode = Uri.decode(encodedPath.substring(1, indexOf));
                String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
                File file = this.f74901b.get(decode);
                if (file == null) {
                    throw new IllegalArgumentException("Unable to find configured root for " + uri);
                }
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
                }
            }
            return (File) invokeL.objValue;
        }

        public final void a(String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, file) == null) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("Name must not be empty");
                }
                try {
                    this.f74901b.put(str, file.getCanonicalFile());
                } catch (IOException e2) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1431128933, "Lcom/qq/e/comm/GDTFileProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1431128933, "Lcom/qq/e/comm/GDTFileProvider;");
                return;
            }
        }
        f74896a = new String[]{"_display_name", "_size"};
        f74897b = new File("/");
        f74898c = new HashMap<>();
    }

    public GDTFileProvider() {
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

    public static a a(Context context, String str) {
        InterceptResult invokeLL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            synchronized (f74898c) {
                a aVar = f74898c.get(str);
                bVar = aVar;
                if (aVar == null) {
                    try {
                        try {
                            b bVar2 = new b(str);
                            XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
                            if (loadXmlMetaData == null) {
                                throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
                            }
                            while (true) {
                                int next = loadXmlMetaData.next();
                                if (next == 1) {
                                    break;
                                } else if (next == 2) {
                                    String name = loadXmlMetaData.getName();
                                    File file = null;
                                    String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                                    String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                                    if ("root-path".equals(name)) {
                                        file = f74897b;
                                    } else if ("files-path".equals(name)) {
                                        file = context.getFilesDir();
                                    } else if ("cache-path".equals(name)) {
                                        file = context.getCacheDir();
                                    } else if ("external-path".equals(name)) {
                                        file = Environment.getExternalStorageDirectory();
                                    } else if ("external-files-path".equals(name)) {
                                        File[] externalFilesDirs = Build.VERSION.SDK_INT >= 19 ? context.getExternalFilesDirs(null) : new File[]{context.getExternalFilesDir(null)};
                                        if (externalFilesDirs.length > 0) {
                                            file = externalFilesDirs[0];
                                        }
                                    } else if ("external-cache-path".equals(name)) {
                                        File[] externalCacheDirs = getExternalCacheDirs(context);
                                        if (externalCacheDirs.length > 0) {
                                            file = externalCacheDirs[0];
                                        }
                                    } else if (Build.VERSION.SDK_INT >= 21 && FileProvider.TAG_EXTERNAL_MEDIA.equals(name)) {
                                        File[] externalMediaDirs = context.getExternalMediaDirs();
                                        if (externalMediaDirs.length > 0) {
                                            file = externalMediaDirs[0];
                                        }
                                    }
                                    if (file != null) {
                                        bVar2.a(attributeValue, a(file, attributeValue2));
                                    }
                                }
                            }
                            loadXmlMetaData.close();
                            f74898c.put(str, bVar2);
                            bVar = bVar2;
                        } catch (IOException e2) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                        }
                    } catch (XmlPullParserException e3) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e3);
                    }
                }
            }
            return bVar;
        }
        return (a) invokeLL.objValue;
    }

    public static File a(File file, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, file, strArr)) == null) {
            for (int i2 = 0; i2 <= 0; i2++) {
                String str = strArr[0];
                if (str != null) {
                    file = new File(file, str);
                }
            }
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public static File[] getExternalCacheDirs(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? Build.VERSION.SDK_INT >= 19 ? context.getExternalCacheDirs() : new File[]{context.getExternalCacheDir()} : (File[]) invokeL.objValue;
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, str, file)) == null) {
            Uri uri = Uri.EMPTY;
            try {
                return a(context, str).a(file);
            } catch (Throwable unused) {
                return uri;
            }
        }
        return (Uri) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, providerInfo) == null) {
            super.attachInfo(context, providerInfo);
            if (providerInfo.exported) {
                throw new SecurityException("Provider must not be exported");
            }
            if (!providerInfo.grantUriPermissions) {
                throw new SecurityException("Provider must grant uri permissions");
            }
            this.f74899d = a(context, providerInfo.authority);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) ? this.f74899d.a(uri).delete() ? 1 : 0 : invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri)) == null) {
            File a2 = this.f74899d.a(uri);
            int lastIndexOf = a2.getName().lastIndexOf(46);
            if (lastIndexOf >= 0) {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a2.getName().substring(lastIndexOf + 1));
                return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
            }
            return "application/octet-stream";
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, uri, contentValues)) == null) {
            throw new UnsupportedOperationException("No external inserts");
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, uri, str)) == null) {
            File a2 = this.f74899d.a(uri);
            if (r.f42062a.equals(str)) {
                i2 = 268435456;
            } else if ("w".equals(str) || "wt".equals(str)) {
                i2 = 738197504;
            } else if ("wa".equals(str)) {
                i2 = 704643072;
            } else if ("rw".equals(str)) {
                i2 = 939524096;
            } else if (!"rwt".equals(str)) {
                throw new IllegalArgumentException("Invalid mode: " + str);
            } else {
                i2 = 1006632960;
            }
            return ParcelFileDescriptor.open(a2, i2);
        }
        return (ParcelFileDescriptor) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, uri, strArr, str, strArr2, str2)) == null) {
            File a2 = this.f74899d.a(uri);
            if (strArr == null) {
                strArr = f74896a;
            }
            String[] strArr3 = new String[strArr.length];
            Object[] objArr = new Object[strArr.length];
            int i3 = 0;
            for (String str3 : strArr) {
                if ("_display_name".equals(str3)) {
                    strArr3[i3] = "_display_name";
                    i2 = i3 + 1;
                    objArr[i3] = a2.getName();
                } else if ("_size".equals(str3)) {
                    strArr3[i3] = "_size";
                    i2 = i3 + 1;
                    objArr[i3] = Long.valueOf(a2.length());
                }
                i3 = i2;
            }
            String[] strArr4 = new String[i3];
            System.arraycopy(strArr3, 0, strArr4, 0, i3);
            Object[] objArr2 = new Object[i3];
            System.arraycopy(objArr, 0, objArr2, 0, i3);
            MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
            matrixCursor.addRow(objArr2);
            return matrixCursor;
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, uri, contentValues, str, strArr)) == null) {
            throw new UnsupportedOperationException("No external updates");
        }
        return invokeLLLL.intValue;
    }
}
