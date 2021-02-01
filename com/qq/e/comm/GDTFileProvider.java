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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes15.dex */
public class GDTFileProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f11533a = {"_display_name", "_size"};

    /* renamed from: b  reason: collision with root package name */
    private static final File f11534b = new File("/");
    private static HashMap<String, a> c = new HashMap<>();
    private a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public interface a {
        Uri a(File file);

        File a(Uri uri);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final String f11535a;

        /* renamed from: b  reason: collision with root package name */
        private final HashMap<String, File> f11536b = new HashMap<>();

        b(String str) {
            this.f11535a = str;
        }

        @Override // com.qq.e.comm.GDTFileProvider.a
        public final Uri a(File file) {
            Map.Entry<String, File> entry;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry2 = null;
                Iterator<Map.Entry<String, File>> it = this.f11536b.entrySet().iterator();
                while (true) {
                    entry = entry2;
                    if (!it.hasNext()) {
                        break;
                    }
                    entry2 = it.next();
                    String path = entry2.getValue().getPath();
                    if (!canonicalPath.startsWith(path) || (entry != null && path.length() <= entry.getValue().getPath().length())) {
                        entry2 = entry;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = entry.getValue().getPath();
                return new Uri.Builder().scheme("content").authority(this.f11535a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // com.qq.e.comm.GDTFileProvider.a
        public final File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f11536b.get(decode);
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
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }

        final void a(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.f11536b.put(str, file.getCanonicalFile());
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
            }
        }
    }

    private static a a(Context context, String str) {
        File file;
        b bVar;
        synchronized (c) {
            a aVar = c.get(str);
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
                            String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                            String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                            if ("root-path".equals(name)) {
                                file = f11534b;
                            } else if ("files-path".equals(name)) {
                                file = context.getFilesDir();
                            } else if (CyberPlayerManager.OPT_CHCHE_PATH.equals(name)) {
                                file = context.getCacheDir();
                            } else if ("external-path".equals(name)) {
                                file = Environment.getExternalStorageDirectory();
                            } else if ("external-files-path".equals(name)) {
                                File[] externalFilesDirs = Build.VERSION.SDK_INT >= 19 ? context.getExternalFilesDirs(null) : new File[]{context.getExternalFilesDir(null)};
                                if (externalFilesDirs.length > 0) {
                                    file = externalFilesDirs[0];
                                }
                                file = null;
                            } else if ("external-cache-path".equals(name)) {
                                File[] externalCacheDirs = getExternalCacheDirs(context);
                                if (externalCacheDirs.length > 0) {
                                    file = externalCacheDirs[0];
                                }
                                file = null;
                            } else {
                                if (Build.VERSION.SDK_INT >= 21 && "external-media-path".equals(name)) {
                                    File[] externalMediaDirs = context.getExternalMediaDirs();
                                    if (externalMediaDirs.length > 0) {
                                        file = externalMediaDirs[0];
                                    }
                                }
                                file = null;
                            }
                            if (file != null) {
                                bVar2.a(attributeValue, a(file, attributeValue2));
                            }
                        }
                    }
                    loadXmlMetaData.close();
                    c.put(str, bVar2);
                    bVar = bVar2;
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (XmlPullParserException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return bVar;
    }

    private static File a(File file, String... strArr) {
        int i = 0;
        File file2 = file;
        while (i <= 0) {
            String str = strArr[0];
            i++;
            file2 = str != null ? new File(file2, str) : file2;
        }
        return file2;
    }

    public static File[] getExternalCacheDirs(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalCacheDirs() : new File[]{context.getExternalCacheDir()};
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        return a(context, str).a(file);
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
        this.d = a(context, providerInfo.authority);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.d.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File a2 = this.d.a(uri);
        int lastIndexOf = a2.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a2.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
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
        int i;
        File a2 = this.d.a(uri);
        if ("r".equals(str)) {
            i = 268435456;
        } else if ("w".equals(str) || "wt".equals(str)) {
            i = 738197504;
        } else if ("wa".equals(str)) {
            i = 704643072;
        } else if (VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth.equals(str)) {
            i = 939524096;
        } else if (!"rwt".equals(str)) {
            throw new IllegalArgumentException("Invalid mode: " + str);
        } else {
            i = 1006632960;
        }
        return ParcelFileDescriptor.open(a2, i);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File a2 = this.d.a(uri);
        if (strArr == null) {
            strArr = f11533a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            String str3 = strArr[i3];
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = a2.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(a2.length());
            } else {
                i = i2;
            }
            i3++;
            i2 = i;
        }
        String[] strArr4 = new String[i2];
        System.arraycopy(strArr3, 0, strArr4, 0, i2);
        Object[] objArr2 = new Object[i2];
        System.arraycopy(objArr, 0, objArr2, 0, i2);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
