package com.bytedance.sdk.openadsdk.o;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f68155a = "SettingRitRepertoryImpl";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f68156b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(98049711, "Lcom/bytedance/sdk/openadsdk/o/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(98049711, "Lcom/bytedance/sdk/openadsdk/o/a;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f68156b : invokeV.booleanValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            f68156b = true;
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? "CREATE TABLE IF NOT EXISTS setting_rit (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT UNIQUE,value TEXT,slot TEXT,config TEXT)" : (String) invokeV.objValue;
    }

    public static void a(JSONObject jSONObject, String str) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, str) == null) && a()) {
            k.b(f68155a, "queryConfig start");
            Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
            if (a2 == null || a2.getCount() <= 0) {
                if (a2 != null) {
                    a2.close();
                    return;
                }
                return;
            }
            String string = a2.moveToNext() ? a2.getString(a2.getColumnIndex("config")) : "";
            if (TextUtils.isEmpty(string)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(com.bytedance.sdk.component.utils.a.b(string));
            String optString = jSONObject2.optString("aid");
            String optString2 = jSONObject2.optString(IAdRequestParam.CELL_ID);
            String optString3 = jSONObject2.optString("ext");
            if (!TextUtils.isEmpty(optString)) {
                jSONObject.put(LegoListActivityConfig.AD_ID, optString);
            }
            if (!TextUtils.isEmpty(optString2)) {
                jSONObject.put("creative_id", optString2);
            }
            if (TextUtils.isEmpty(optString3)) {
                return;
            }
            jSONObject.put("ext", optString3);
        }
    }

    public static void b(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65544, null, i2, str) == null) && a()) {
            String str2 = f68155a;
            k.b(str2, "insertOrUpdateGlobalInfo -- key:" + i2 + "; value:" + str);
            if (TextUtils.isEmpty(str)) {
                str = StringUtil.NULL_STRING;
            }
            Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "setting_global_info", null, "_id=?", new String[]{String.valueOf(i2)}, null, null, null);
            boolean z = a2 != null && a2.getCount() > 0;
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Exception unused) {
                }
            }
            String a3 = com.bytedance.sdk.component.utils.a.a(str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Integer.valueOf(i2));
            contentValues.put("value", a3);
            if (z) {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "setting_global_info", contentValues, "_id=?", new String[]{String.valueOf(i2)});
            } else {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "setting_global_info", contentValues);
            }
        }
    }

    public static void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, jSONObject) == null) && a()) {
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                k.b(f68155a, "insertOrUpdate start");
                Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
                boolean z = a2 != null && a2.getCount() > 0;
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Throwable unused) {
                    }
                }
                JSONObject a3 = com.bytedance.sdk.component.utils.a.a(jSONObject);
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", str);
                contentValues.put("value", a3.toString());
                if (z) {
                    com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "setting_rit", contentValues, "rit=?", new String[]{str});
                    return;
                } else {
                    com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "setting_rit", contentValues);
                    return;
                }
            }
            String str2 = f68155a;
            k.b(str2, "insert -- key:" + str + "; value:" + jSONObject);
        }
    }

    public static void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, adSlot) == null) && a()) {
            String codeId = adSlot.getCodeId();
            if (a(codeId)) {
                k.b(f68155a, "updateSlot start");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("img_width", adSlot.getImgAcceptedWidth());
                    jSONObject.put("img_height", adSlot.getImgAcceptedHeight());
                    jSONObject.put("express_width", adSlot.getExpressViewAcceptedWidth());
                    jSONObject.put("express_height", adSlot.getExpressViewAcceptedHeight());
                    jSONObject.put("ad_count", adSlot.getAdCount());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", codeId);
                contentValues.put("slot", com.bytedance.sdk.component.utils.a.a(jSONObject.toString()));
                com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "setting_rit", contentValues, "rit=?", new String[]{codeId});
            }
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
            if (a2 == null || a2.getCount() <= 0) {
                if (a2 != null) {
                    a2.close();
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65537, null, i2, str) == null) && a()) {
            if (TextUtils.isEmpty(str)) {
                str = StringUtil.NULL_STRING;
            }
            Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "setting_base_info", null, "_id=?", new String[]{String.valueOf(i2)}, null, null, null);
            boolean z = a2 != null && a2.getCount() > 0;
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Exception unused) {
                }
            }
            String a3 = com.bytedance.sdk.component.utils.a.a(str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Integer.valueOf(i2));
            contentValues.put("value", a3);
            if (z) {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "setting_base_info", contentValues, "_id=?", new String[]{String.valueOf(i2)});
            } else {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "setting_base_info", contentValues);
            }
        }
    }
}
