package org.chromium.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class FileUtils {
    public static Function<String, Boolean> DELETE_ALL = new Function() { // from class: com.baidu.tieba.zlc
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // org.chromium.base.Function
        public final Object apply(Object obj) {
            InterceptResult invokeL;
            Boolean bool;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                String str = (String) obj;
                bool = Boolean.TRUE;
                return bool;
            }
            return invokeL.objValue;
        }
    };
    public static final String TAG = "FileUtils";

    public static String getExtension(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        int lastIndexOf2 = str.lastIndexOf(46);
        if (lastIndexOf >= lastIndexOf2) {
            return "";
        }
        return str.substring(lastIndexOf2 + 1).toLowerCase(Locale.US);
    }

    public static Uri getUriForFile(File file) {
        Uri uri;
        try {
            uri = ContentUriUtils.getContentUriFromFile(file);
        } catch (IllegalArgumentException e) {
            Log.e("FileUtils", "Could not create content uri: " + e, new Object[0]);
            uri = null;
        }
        if (uri == null) {
            return Uri.fromFile(file);
        }
        return uri;
    }

    @NonNull
    public static byte[] readStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyStream(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void batchDeleteFiles(List<String> list, Function<String, Boolean> function) {
        for (String str : list) {
            if (function == null || function.apply(str).booleanValue()) {
                if (ContentUriUtils.isContentUri(str)) {
                    ContentUriUtils.delete(str);
                } else {
                    File file = new File(str);
                    if (file.exists()) {
                        recursivelyDeleteFile(file, function);
                    }
                }
            }
        }
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void copyStreamToFile(InputStream inputStream, File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            Log.i("FileUtils", "Writing to %s", file);
            copyStream(inputStream, fileOutputStream);
            fileOutputStream.close();
            if (file2.renameTo(file)) {
                return;
            }
            throw new IOException();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static boolean recursivelyDeleteFile(File file, Function<String, Boolean> function) {
        File[] listFiles;
        if (!file.exists()) {
            file.delete();
            return true;
        } else if (function != null && !function.apply(file.getPath()).booleanValue()) {
            return true;
        } else {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    recursivelyDeleteFile(file2, function);
                }
            }
            boolean delete = file.delete();
            if (!delete) {
                Log.e("FileUtils", "Failed to delete: %s", file);
            }
            return delete;
        }
    }

    public static boolean extractAsset(Context context, String str, File file) {
        try {
            InputStream open = context.getAssets().open(str);
            copyStreamToFile(open, file);
            if (open != null) {
                open.close();
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @Nullable
    public static Bitmap queryBitmapFromContentProvider(Context context, Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            if (openFileDescriptor == null) {
                Log.w("FileUtils", "Null ParcelFileDescriptor from uri " + uri, new Object[0]);
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            FileDescriptor fileDescriptor = openFileDescriptor.getFileDescriptor();
            if (fileDescriptor == null) {
                Log.w("FileUtils", "Null FileDescriptor from uri " + uri, new Object[0]);
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor);
            if (decodeFileDescriptor == null) {
                Log.w("FileUtils", "Failed to decode image from uri " + uri, new Object[0]);
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            if (openFileDescriptor != null) {
                openFileDescriptor.close();
            }
            return decodeFileDescriptor;
        } catch (IOException unused) {
            Log.w("FileUtils", "IO exception when reading uri " + uri, new Object[0]);
            return null;
        }
    }
}
