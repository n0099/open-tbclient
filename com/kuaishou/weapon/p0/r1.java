package com.kuaishou.weapon.p0;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.provider.MediaStore;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.zip.CRC32;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class r1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "7";
    public static final String b = "6";
    public static final String c = "5";
    public static final String d = "4";
    public static final String e = "3";
    public static final String f = "2";
    public static final String g = "1";
    public transient /* synthetic */ FieldHolder $fh;

    public r1() {
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

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0266, code lost:
        if (r3 != null) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0289  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONArray a(Context context) {
        InterceptResult invokeL;
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        String str;
        Object obj;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, context)) != null) {
            return (JSONArray) invokeL.objValue;
        }
        JSONArray jSONArray3 = new JSONArray();
        try {
            try {
                CRC32 crc32 = new CRC32();
                ContentResolver contentResolver = context.getContentResolver();
                Cursor query = contentResolver.query(RingtoneManager.getActualDefaultRingtoneUri(context.getApplicationContext(), 1), null, null, null, null);
                try {
                    try {
                        if (query.moveToNext()) {
                            JSONObject jSONObject = new JSONObject();
                            crc32.update(query.getString(query.getColumnIndexOrThrow("_data")).getBytes());
                            jSONObject.put("5", Long.toHexString(crc32.getValue()));
                            jSONObject.put("4", query.getInt(query.getColumnIndexOrThrow("date_added")));
                            jSONObject.put("3", query.getInt(query.getColumnIndexOrThrow("date_modified")));
                            jSONObject.put("2", "1");
                            jSONObject.put("1", "0");
                            jSONArray3.put(jSONObject);
                        }
                        query.close();
                        Cursor query2 = contentResolver.query(RingtoneManager.getActualDefaultRingtoneUri(context.getApplicationContext(), 2), null, null, null, null);
                        if (query2.moveToNext()) {
                            JSONObject jSONObject2 = new JSONObject();
                            crc32.update(query2.getString(query2.getColumnIndexOrThrow("_data")).getBytes());
                            jSONObject2.put("5", Long.toHexString(crc32.getValue()));
                            jSONObject2.put("4", query2.getInt(query2.getColumnIndexOrThrow("date_added")));
                            jSONObject2.put("3", query2.getInt(query2.getColumnIndexOrThrow("date_modified")));
                            str = "2";
                            jSONObject2.put(str, "1");
                            jSONObject2.put("1", "1");
                            jSONArray3.put(jSONObject2);
                        } else {
                            str = "2";
                        }
                        query2.close();
                        String str2 = str;
                        Cursor query3 = contentResolver.query(RingtoneManager.getActualDefaultRingtoneUri(context.getApplicationContext(), 4), null, null, null, null);
                        if (query3.moveToNext()) {
                            JSONObject jSONObject3 = new JSONObject();
                            crc32.update(query3.getString(query3.getColumnIndexOrThrow("_data")).getBytes());
                            jSONObject3.put("5", Long.toHexString(crc32.getValue()));
                            jSONObject3.put("4", query3.getInt(query3.getColumnIndexOrThrow("date_added")));
                            jSONObject3.put("3", query3.getInt(query3.getColumnIndexOrThrow("date_modified")));
                            jSONObject3.put(str2, "1");
                            jSONObject3.put("1", str2);
                            jSONArray3.put(jSONObject3);
                        }
                        query3.close();
                        Cursor query4 = contentResolver.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, null, "is_ringtone= ? ", new String[]{"1"}, "date_added");
                        if (query4.moveToNext()) {
                            JSONObject jSONObject4 = new JSONObject();
                            crc32.update(query4.getString(query4.getColumnIndexOrThrow("_data")).getBytes());
                            jSONObject4.put("5", Long.toHexString(crc32.getValue()));
                            jSONObject4.put("4", query4.getInt(query4.getColumnIndexOrThrow("date_added")));
                            jSONObject4.put("3", query4.getInt(query4.getColumnIndexOrThrow("date_modified")));
                            obj = "0";
                            jSONObject4.put(str2, obj);
                            jSONObject4.put("1", obj);
                            jSONArray3.put(jSONObject4);
                        } else {
                            obj = "0";
                        }
                        query4.close();
                        Object obj2 = obj;
                        try {
                            Cursor cursor4 = contentResolver.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, null, "is_notification= ? ", new String[]{"1"}, "date_added");
                            try {
                                if (cursor4.moveToNext()) {
                                    JSONObject jSONObject5 = new JSONObject();
                                    crc32.update(cursor4.getString(cursor4.getColumnIndexOrThrow("_data")).getBytes());
                                    jSONObject5.put("5", Long.toHexString(crc32.getValue()));
                                    jSONObject5.put("4", cursor4.getInt(cursor4.getColumnIndexOrThrow("date_added")));
                                    jSONObject5.put("3", cursor4.getInt(cursor4.getColumnIndexOrThrow("date_modified")));
                                    jSONObject5.put(str2, obj2);
                                    jSONObject5.put("1", "1");
                                    jSONArray = jSONArray3;
                                    try {
                                        jSONArray.put(jSONObject5);
                                    } catch (Exception unused) {
                                        jSONArray3 = jSONArray;
                                        cursor2 = cursor4;
                                        if (cursor2 != null) {
                                        }
                                        return jSONArray3;
                                    }
                                } else {
                                    jSONArray = jSONArray3;
                                }
                                cursor4.close();
                                try {
                                    jSONArray2 = jSONArray;
                                } catch (Exception unused2) {
                                    jSONArray3 = jSONArray;
                                }
                                try {
                                    cursor4 = contentResolver.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, null, "is_alarm= ? ", new String[]{"1"}, "date_added");
                                } catch (Exception unused3) {
                                    jSONArray3 = jSONArray2;
                                    cursor2 = null;
                                    if (cursor2 != null) {
                                        cursor4 = cursor2;
                                        cursor4.close();
                                    }
                                    return jSONArray3;
                                }
                                try {
                                    if (cursor4.moveToNext()) {
                                        JSONObject jSONObject6 = new JSONObject();
                                        crc32.update(cursor4.getString(cursor4.getColumnIndexOrThrow("_data")).getBytes());
                                        jSONObject6.put("5", Long.toHexString(crc32.getValue()));
                                        jSONObject6.put("4", cursor4.getInt(cursor4.getColumnIndexOrThrow("date_added")));
                                        jSONObject6.put("3", cursor4.getInt(cursor4.getColumnIndexOrThrow("date_modified")));
                                        jSONObject6.put(str2, obj2);
                                        jSONObject6.put("1", str2);
                                        jSONArray3 = jSONArray2;
                                        jSONArray3.put(jSONObject6);
                                    } else {
                                        jSONArray3 = jSONArray2;
                                    }
                                } catch (Exception unused4) {
                                    jSONArray3 = jSONArray2;
                                    cursor2 = cursor4;
                                    if (cursor2 != null) {
                                    }
                                    return jSONArray3;
                                }
                            } catch (Exception unused5) {
                                jSONArray3 = jSONArray3;
                            }
                        } catch (Exception unused6) {
                            jSONArray3 = jSONArray3;
                        }
                    } catch (Exception unused7) {
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursor3;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception unused8) {
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }
}
