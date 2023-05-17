package com.sina.weibo.sdk.share;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
/* loaded from: classes9.dex */
public final class ShareUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ShareUtils() {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x0138 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x0140 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x0161 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x012d A[EDGE_INSN: B:101:0x012d->B:49:0x012d ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba A[Catch: all -> 0x0147, Exception -> 0x014a, TryCatch #13 {Exception -> 0x014a, all -> 0x0147, blocks: (B:5:0x0007, B:8:0x0017, B:22:0x009b, B:32:0x00b4, B:34:0x00ba, B:38:0x00d1, B:39:0x00d8, B:30:0x00b0, B:60:0x0143, B:61:0x0146), top: B:87:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0115 A[Catch: all -> 0x013a, Exception -> 0x013d, TryCatch #12 {Exception -> 0x013d, all -> 0x013a, blocks: (B:40:0x00f0, B:42:0x0115, B:43:0x0118), top: B:98:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0128 A[Catch: Exception -> 0x0138, all -> 0x0161, LOOP:0: B:46:0x0121->B:48:0x0128, LOOP_END, TryCatch #1 {all -> 0x0161, blocks: (B:45:0x011f, B:46:0x0121, B:48:0x0128, B:49:0x012d, B:66:0x014d), top: B:87:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x016a A[Catch: Exception -> 0x016d, TRY_LEAVE, TryCatch #2 {Exception -> 0x016d, blocks: (B:75:0x0165, B:77:0x016a), top: B:88:0x0165 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.net.Uri, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v0, types: [int] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String copyFileToWeiboTem(Context context, Uri uri, int i) {
        InterceptResult invokeLLI;
        OutputStream outputStream;
        FileOutputStream fileOutputStream;
        String str;
        Calendar calendar;
        Cursor cursor;
        String str2;
        File file;
        byte[] bArr;
        int read;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, uri, i)) == null) {
            InputStream inputStream = null;
            try {
                try {
                    String packageName = WeiboAppManager.queryWbInfoInternal(context).getPackageName();
                    ?? isEmpty = TextUtils.isEmpty(packageName);
                    if (isEmpty != 0) {
                        packageName = "com.sina.weibo";
                    }
                    try {
                        str = "/Android/data/" + packageName + "/files/.composerTem/";
                        new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str).mkdirs();
                        calendar = Calendar.getInstance();
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        if (uri.getScheme().equals("file")) {
                            str2 = calendar.getTimeInMillis() + uri.getLastPathSegment();
                            cursor = null;
                        } else {
                            cursor = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                            if (cursor != null) {
                                try {
                                    if (cursor.moveToFirst()) {
                                        str2 = cursor.getString(cursor.getColumnIndex("_display_name"));
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    Log.v("weibo sdk rename", e.toString());
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    str2 = null;
                                    if (TextUtils.isEmpty(str2)) {
                                    }
                                    uri = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
                                    file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str + str2);
                                    if (file.exists()) {
                                    }
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        bArr = new byte[1444];
                                        while (true) {
                                            read = uri.read(bArr);
                                            if (read != -1) {
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                        }
                                        String path = file.getPath();
                                        try {
                                            uri.close();
                                            fileOutputStream.close();
                                        } catch (Exception unused) {
                                        }
                                        return path;
                                    } catch (Exception e2) {
                                        e = e2;
                                        LogUtil.e("weibo sdk copy", e.toString());
                                        if (uri != 0) {
                                            try {
                                                uri.close();
                                            } catch (Exception unused2) {
                                                return null;
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        return null;
                                    }
                                }
                            }
                            str2 = null;
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        isEmpty = 0;
                        if (isEmpty != 0) {
                            isEmpty.close();
                        }
                        throw th;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(Calendar.getInstance().getTimeInMillis());
                        if (i == 0) {
                            str3 = "_sdk_temp.mp4";
                        } else {
                            str3 = "_sdk_temp.jpg";
                        }
                        sb.append(str3);
                        str2 = sb.toString();
                    }
                    uri = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e4) {
                e = e4;
                uri = 0;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                outputStream = null;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused3) {
                        throw th;
                    }
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
            try {
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str + str2);
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new FileOutputStream(file);
                bArr = new byte[1444];
                while (true) {
                    read = uri.read(bArr);
                    if (read != -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                String path2 = file.getPath();
                uri.close();
                fileOutputStream.close();
                return path2;
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                i = 0;
                inputStream = uri;
                outputStream = i;
                if (inputStream != null) {
                }
                if (outputStream != null) {
                }
                throw th;
            }
        } else {
            return (String) invokeLLI.objValue;
        }
    }
}
