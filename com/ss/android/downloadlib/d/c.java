package com.ss.android.downloadlib.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f69687b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SQLiteDatabase f69688a;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            this.f69688a = new b(j.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.e.c.a().a(th, "ClickEventHelper");
        }
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f69687b == null) {
                synchronized (c.class) {
                    if (f69687b == null) {
                        f69687b = new c();
                    }
                }
            }
            return f69687b;
        }
        return (c) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.ss.android.socialbase.downloader.g.a.c().a("click_event_switch", 0) == 1 : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.ss.android.socialbase.downloader.g.a.c().a("click_event_switch", 0) == 2 : invokeV.booleanValue;
    }

    private void c(long j, String str) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(65538, this, j, str) == null) || (sQLiteDatabase = this.f69688a) == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString(IAdRequestParam.REQ_ID);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.f69688a.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), optString});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public boolean b(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, str)) == null) {
            SQLiteDatabase sQLiteDatabase = this.f69688a;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
                return false;
            }
            Cursor cursor = null;
            try {
                try {
                    String optString = new JSONObject(str).optString(IAdRequestParam.REQ_ID);
                    if (TextUtils.isEmpty(optString)) {
                        return false;
                    }
                    cursor = this.f69688a.query("click_event", b.f69686a, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), optString}, null, null, null, null);
                    boolean z = cursor.getCount() > 0;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return z;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return invokeJL.booleanValue;
    }

    public void a(long j, String str) {
        SQLiteDatabase sQLiteDatabase;
        String optString;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048576, this, j, str) == null) || (sQLiteDatabase = this.f69688a) == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            optString = new JSONObject(str).optString(IAdRequestParam.REQ_ID);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(LegoListActivityConfig.AD_ID, Long.valueOf(j));
        contentValues.put(IAdRequestParam.REQ_ID, optString);
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        this.f69688a.insert("click_event", null, contentValues);
        c(j, str);
    }
}
