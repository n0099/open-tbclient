package org.chromium.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import org.chromium.base.annotations.CalledByNative;
/* loaded from: classes2.dex */
public abstract class ContentUriUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "ContentUriUtils";
    public static FileProviderUtil sFileProviderUtil;
    public static final Object sLock = new Object();

    /* loaded from: classes2.dex */
    public interface FileProviderUtil {
        Uri getContentUriFromFile(File file);
    }

    @CalledByNative
    public static boolean contentUriExists(String str) {
        boolean z;
        AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(str);
        if (assetFileDescriptor != null) {
            z = true;
        } else {
            z = false;
        }
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
        return z;
    }

    @CalledByNative
    public static boolean delete(String str) {
        if (ContextUtils.getApplicationContext().getContentResolver().delete(Uri.parse(str), null, null) > 0) {
            return true;
        }
        return false;
    }

    public static Uri getContentUriFromFile(File file) {
        synchronized (sLock) {
            if (sFileProviderUtil != null) {
                return sFileProviderUtil.getContentUriFromFile(file);
            }
            return null;
        }
    }

    @CalledByNative
    public static String getContentUriFromFilePath(String str) {
        try {
            Uri contentUriFromFile = getContentUriFromFile(new File(str));
            if (contentUriFromFile != null) {
                return contentUriFromFile.toString();
            }
            return null;
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Cannot retrieve content uri from file: %s", str, e);
            return null;
        }
    }

    @CalledByNative
    public static String getMimeType(String str) {
        ContentResolver contentResolver = ContextUtils.getApplicationContext().getContentResolver();
        Uri parse = Uri.parse(str);
        if (isVirtualDocument(parse)) {
            String[] streamTypes = contentResolver.getStreamTypes(parse, "*/*");
            if (streamTypes != null && streamTypes.length > 0) {
                return streamTypes[0];
            }
            return null;
        }
        return contentResolver.getType(parse);
    }

    public static boolean hasVirtualFlag(Cursor cursor) {
        int columnIndex;
        if (Build.VERSION.SDK_INT < 24 || (columnIndex = cursor.getColumnIndex("flags")) <= -1 || (cursor.getLong(columnIndex) & 512) == 0) {
            return false;
        }
        return true;
    }

    public static boolean isContentUri(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null || !"content".equals(parse.getScheme())) {
            return false;
        }
        return true;
    }

    @Nullable
    @CalledByNative
    public static String maybeGetDisplayName(String str) {
        try {
            String displayName = getDisplayName(Uri.parse(str), ContextUtils.getApplicationContext(), "_display_name");
            if (TextUtils.isEmpty(displayName)) {
                return null;
            }
            return displayName;
        } catch (Exception e) {
            Log.w(TAG, "Cannot open content uri: %s", str, e);
            return null;
        }
    }

    @CalledByNative
    public static int openContentUriForRead(String str) {
        AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(str);
        if (assetFileDescriptor != null) {
            return assetFileDescriptor.getParcelFileDescriptor().detachFd();
        }
        return -1;
    }

    public static void setFileProviderUtil(FileProviderUtil fileProviderUtil) {
        synchronized (sLock) {
            sFileProviderUtil = fileProviderUtil;
        }
    }

    public static AssetFileDescriptor getAssetFileDescriptor(String str) {
        ContentResolver contentResolver = ContextUtils.getApplicationContext().getContentResolver();
        Uri parse = Uri.parse(str);
        try {
            if (isVirtualDocument(parse)) {
                String[] streamTypes = contentResolver.getStreamTypes(parse, "*/*");
                if (streamTypes != null && streamTypes.length > 0) {
                    AssetFileDescriptor openTypedAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(parse, streamTypes[0], null);
                    if (openTypedAssetFileDescriptor != null && openTypedAssetFileDescriptor.getStartOffset() != 0) {
                        try {
                            openTypedAssetFileDescriptor.close();
                        } catch (IOException unused) {
                        }
                        throw new SecurityException("Cannot open files with non-zero offset type.");
                    }
                    return openTypedAssetFileDescriptor;
                }
            } else {
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(parse, "r");
                if (openFileDescriptor != null) {
                    return new AssetFileDescriptor(openFileDescriptor, 0L, -1L);
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "Cannot open content uri: %s", str, e);
        }
        return null;
    }

    public static boolean isVirtualDocument(Uri uri) {
        Cursor query;
        if (Build.VERSION.SDK_INT < 19 || uri == null || !DocumentsContract.isDocumentUri(ContextUtils.getApplicationContext(), uri)) {
            return false;
        }
        try {
            query = ContextUtils.getApplicationContext().getContentResolver().query(uri, null, null, null, null);
        } catch (NullPointerException unused) {
        }
        if (query != null && query.getCount() >= 1) {
            query.moveToFirst();
            boolean hasVirtualFlag = hasVirtualFlag(query);
            if (query != null) {
                query.close();
            }
            return hasVirtualFlag;
        }
        if (query != null) {
            query.close();
        }
        return false;
    }

    public static String getDisplayName(Uri uri, Context context, String str) {
        Cursor query;
        String[] streamTypes;
        String extensionFromMimeType;
        if (uri == null) {
            return "";
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            query = contentResolver.query(uri, null, null, null, null);
        } catch (NullPointerException unused) {
        }
        if (query != null && query.getCount() >= 1) {
            query.moveToFirst();
            int columnIndex = query.getColumnIndex(str);
            if (columnIndex == -1) {
                if (query != null) {
                    query.close();
                }
                return "";
            }
            String string = query.getString(columnIndex);
            if (hasVirtualFlag(query) && (streamTypes = contentResolver.getStreamTypes(uri, "*/*")) != null && streamTypes.length > 0 && (extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(streamTypes[0])) != null) {
                string = string + "." + extensionFromMimeType;
            }
            if (query != null) {
                query.close();
            }
            return string;
        }
        if (query != null) {
            query.close();
        }
        return "";
    }
}
