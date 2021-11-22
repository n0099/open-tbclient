package com.vivo.identifier;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class DataBaseOperation {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AAID_FLAG = "AAID";
    public static final String ID_VALUE = "value";
    public static final String OAIDSTATUS_FLAG = "OAIDSTATUS";
    public static final String OAID_FLAG = "OAID";
    public static final String TAG = "VMS_SDK_DB";
    public static final int TYPE_AAID = 2;
    public static final int TYPE_OAID = 0;
    public static final int TYPE_OAIDSTATUS = 4;
    public static final int TYPE_VAID = 1;
    public static final String URI_BASE = "content://com.vivo.vms.IdProvider/IdentifierId";
    public static final String VAID_FLAG = "VAID";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public DataBaseOperation(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:3|(3:5|(2:7|(2:9|(8:11|12|13|15|(3:17|(1:19)|20)(1:26)|(1:25)|22|23)(1:41))(1:43))(1:45)|44)(1:46)|42|12|13|15|(0)(0)|(0)|22|23) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:(3:5|(2:7|(2:9|(8:11|12|13|15|(3:17|(1:19)|20)(1:26)|(1:25)|22|23)(1:41))(1:43))(1:45)|44)(1:46)|12|13|15|(0)(0)|(0)|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
        r11 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
        r1 = r10;
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006f, code lost:
        com.vivo.identifier.IdentifierIdLog.e(com.vivo.identifier.DataBaseOperation.TAG, "return cursor is error");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0074, code lost:
        if (r1 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0076, code lost:
        r8 = r1;
        r1 = r10;
        r10 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007e, code lost:
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007f, code lost:
        if (r1 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0081, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0084, code lost:
        throw r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048 A[Catch: all -> 0x005d, Exception -> 0x0068, TRY_ENTER, TryCatch #4 {Exception -> 0x0068, all -> 0x005d, blocks: (B:21:0x0048, B:23:0x004e, B:24:0x0059, B:27:0x0060), top: B:50:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0060 A[Catch: all -> 0x005d, Exception -> 0x0068, TRY_LEAVE, TryCatch #4 {Exception -> 0x0068, all -> 0x005d, blocks: (B:21:0x0048, B:23:0x004e, B:24:0x0059, B:27:0x0060), top: B:50:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String query(int i2, String str) {
        InterceptResult invokeIL;
        String str2;
        Uri parse;
        Cursor cursor;
        StringBuilder sb;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIL = interceptable.invokeIL(1048576, this, i2, str)) != null) {
            return (String) invokeIL.objValue;
        }
        Cursor cursor2 = null;
        String str4 = null;
        cursor2 = null;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    sb = new StringBuilder();
                    str3 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
                } else if (i2 == 2) {
                    sb = new StringBuilder();
                    str3 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
                } else if (i2 != 4) {
                    parse = null;
                    cursor = this.mContext.getContentResolver().query(parse, null, null, null, null);
                    if (cursor == null) {
                        str4 = cursor.moveToNext() ? cursor.getString(cursor.getColumnIndex("value")) : null;
                        cursor.close();
                    } else {
                        IdentifierIdLog.d(TAG, "return cursor is null,return");
                    }
                    if (cursor == null) {
                        return str4;
                    }
                    cursor.close();
                    return str4;
                } else {
                    str2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS";
                }
                sb.append(str3);
                sb.append(str);
                str2 = sb.toString();
            } else {
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
            }
            cursor = this.mContext.getContentResolver().query(parse, null, null, null, null);
            if (cursor == null) {
            }
            if (cursor == null) {
            }
            cursor.close();
            return str4;
        } catch (Throwable th) {
            th = th;
        }
        parse = Uri.parse(str2);
    }
}
