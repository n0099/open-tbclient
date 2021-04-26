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
import com.alibaba.fastjson.asm.Label;
import com.baidu.mapsdkplatform.comapi.map.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes6.dex */
public class GDTFileProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f36211a = {"_display_name", "_size"};

    /* renamed from: b  reason: collision with root package name */
    public static final File f36212b = new File("/");

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, a> f36213c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public a f36214d;

    /* loaded from: classes6.dex */
    public interface a {
        Uri a(File file);

        File a(Uri uri);
    }

    /* loaded from: classes6.dex */
    public static class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public final String f36215a;

        /* renamed from: b  reason: collision with root package name */
        public final HashMap<String, File> f36216b = new HashMap<>();

        public b(String str) {
            this.f36215a = str;
        }

        @Override // com.qq.e.comm.GDTFileProvider.a
        public final Uri a(File file) {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f36216b.entrySet()) {
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
                return new Uri.Builder().scheme("content").authority(this.f36215a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // com.qq.e.comm.GDTFileProvider.a
        public final File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f36216b.get(decode);
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

        public final void a(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.f36216b.put(str, file.getCanonicalFile());
            } catch (IOException e2) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e2);
            }
        }
    }

    public static a a(Context context, String str) {
        b bVar;
        synchronized (f36213c) {
            a aVar = f36213c.get(str);
            bVar = aVar;
            if (aVar == null) {
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
                                file = f36212b;
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
                    f36213c.put(str, bVar2);
                    bVar = bVar2;
                } catch (IOException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                } catch (XmlPullParserException e3) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e3);
                }
            }
        }
        return bVar;
    }

    public static File a(File file, String... strArr) {
        for (int i2 = 0; i2 <= 0; i2++) {
            String str = strArr[0];
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    public static File[] getExternalCacheDirs(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalCacheDirs() : new File[]{context.getExternalCacheDir()};
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        Uri uri = Uri.EMPTY;
        try {
            return a(context, str).a(file);
        } catch (Throwable unused) {
            return uri;
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        this.f36214d = a(context, providerInfo.authority);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f36214d.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File a2 = this.f36214d.a(uri);
        int lastIndexOf = a2.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a2.getName().substring(lastIndexOf + 1));
            return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        int i2;
        File a2 = this.f36214d.a(uri);
        if (r.f7975a.equals(str)) {
            i2 = Label.FORWARD_REFERENCE_TYPE_SHORT;
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

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i2;
        File a2 = this.f36214d.a(uri);
        if (strArr == null) {
            strArr = f36211a;
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

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
