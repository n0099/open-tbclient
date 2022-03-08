package com.sina.weibo.sdk.share;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
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
import java.util.Calendar;
/* loaded from: classes8.dex */
public final class ShareUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ShareUtils() {
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

    /* JADX WARN: Removed duplicated region for block: B:102:0x0127 A[EDGE_INSN: B:102:0x0127->B:49:0x0127 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b4 A[Catch: all -> 0x0141, Exception -> 0x0144, TryCatch #13 {Exception -> 0x0144, all -> 0x0141, blocks: (B:5:0x0007, B:8:0x0017, B:22:0x009b, B:32:0x00ae, B:34:0x00b4, B:38:0x00cb, B:39:0x00d2, B:30:0x00aa, B:60:0x013d, B:61:0x0140), top: B:98:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010f A[Catch: all -> 0x0134, Exception -> 0x0137, TryCatch #12 {Exception -> 0x0137, all -> 0x0134, blocks: (B:40:0x00ea, B:42:0x010f, B:43:0x0112), top: B:99:0x00ea }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0122 A[Catch: Exception -> 0x0132, all -> 0x015b, LOOP:0: B:46:0x011b->B:48:0x0122, LOOP_END, TryCatch #3 {Exception -> 0x0132, blocks: (B:45:0x0119, B:46:0x011b, B:48:0x0122, B:49:0x0127), top: B:88:0x0119 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013d A[Catch: all -> 0x0141, Exception -> 0x0144, TRY_ENTER, TryCatch #13 {Exception -> 0x0144, all -> 0x0141, blocks: (B:5:0x0007, B:8:0x0017, B:22:0x009b, B:32:0x00ae, B:34:0x00b4, B:38:0x00cb, B:39:0x00d2, B:30:0x00aa, B:60:0x013d, B:61:0x0140), top: B:98:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0164 A[Catch: Exception -> 0x0167, TRY_LEAVE, TryCatch #7 {Exception -> 0x0167, blocks: (B:75:0x015f, B:77:0x0164), top: B:94:0x015f }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String copyFileToWeiboTem(Context context, Uri uri, int i2) {
        InterceptResult invokeLLI;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        String str;
        Cursor cursor;
        String str2;
        File file;
        byte[] bArr;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLI = interceptable.invokeLLI(65537, null, context, uri, i2)) != null) {
            return (String) invokeLLI.objValue;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            String packageName = WeiboAppManager.queryWbInfoInternal(context).getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                packageName = "com.sina.weibo";
            }
            str = "/Android/data/" + packageName + "/files/.composerTem/";
            new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str).mkdirs();
            Calendar calendar = Calendar.getInstance();
            try {
                if (uri.getScheme().equals("file")) {
                    str2 = calendar.getTimeInMillis() + uri.getLastPathSegment();
                    cursor = null;
                } else {
                    cursor = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                    if (cursor != null) {
                        try {
                            try {
                                if (cursor.moveToFirst()) {
                                    str2 = cursor.getString(cursor.getColumnIndex("_display_name"));
                                }
                            } catch (Exception e2) {
                                e = e2;
                                e.toString();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                str2 = null;
                                if (TextUtils.isEmpty(str2)) {
                                }
                                bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
                                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str + str2);
                                if (file.exists()) {
                                }
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    try {
                                        bArr = new byte[1444];
                                        while (true) {
                                            read = bufferedInputStream.read(bArr);
                                            if (read != -1) {
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                        }
                                        String path = file.getPath();
                                        try {
                                            bufferedInputStream.close();
                                            fileOutputStream.close();
                                        } catch (Exception unused) {
                                        }
                                        return path;
                                    } catch (Exception e3) {
                                        e = e3;
                                        LogUtil.e("weibo sdk copy", e.toString());
                                        if (bufferedInputStream != null) {
                                            try {
                                                bufferedInputStream.close();
                                            } catch (Exception unused2) {
                                                return null;
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        return null;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedInputStream2 = bufferedInputStream;
                                    if (bufferedInputStream2 != null) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (Exception unused3) {
                                            throw th;
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    str2 = null;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
            if (TextUtils.isEmpty(str2)) {
                StringBuilder sb = new StringBuilder();
                sb.append(Calendar.getInstance().getTimeInMillis());
                sb.append(i2 == 0 ? "_sdk_temp.mp4" : "_sdk_temp.jpg");
                str2 = sb.toString();
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
        } catch (Exception e5) {
            e = e5;
            bufferedInputStream = null;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (bufferedInputStream2 != null) {
            }
            if (fileOutputStream != null) {
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
                read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            String path2 = file.getPath();
            bufferedInputStream.close();
            fileOutputStream.close();
            return path2;
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }
}
