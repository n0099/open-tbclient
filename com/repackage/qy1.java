package com.repackage;

import android.content.ContentValues;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public qy1() {
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

    public static qy1 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            qy1 qy1Var = new qy1();
            if (jSONObject != null) {
                jSONObject.optString("photoFilePath");
                qy1Var.a = jSONObject.optString("nickName");
                qy1Var.b = jSONObject.optString("lastName");
                qy1Var.c = jSONObject.optString("middleName");
                qy1Var.d = jSONObject.optString("firstName");
                qy1Var.e = jSONObject.optString("remark");
                qy1Var.f = jSONObject.optString("mobilePhoneNumber");
                qy1Var.g = jSONObject.optString("weChatNumber");
                qy1Var.h = jSONObject.optString("addressCountry");
                qy1Var.i = jSONObject.optString("addressState");
                qy1Var.j = jSONObject.optString("addressCity");
                qy1Var.k = jSONObject.optString("addressStreet");
                qy1Var.l = jSONObject.optString("addressPostalCode");
                qy1Var.m = jSONObject.optString("organization");
                qy1Var.n = jSONObject.optString("title");
                qy1Var.o = jSONObject.optString("workFaxNumber");
                qy1Var.p = jSONObject.optString("workPhoneNumber");
                qy1Var.q = jSONObject.optString("hostNumber");
                qy1Var.r = jSONObject.optString("email");
                qy1Var.s = jSONObject.optString("url");
                qy1Var.t = jSONObject.optString("workAddressCountry");
                qy1Var.u = jSONObject.optString("workAddressState");
                qy1Var.v = jSONObject.optString("workAddressCity");
                qy1Var.w = jSONObject.optString("workAddressStreet");
                qy1Var.x = jSONObject.optString("workAddressPostalCode");
                qy1Var.y = jSONObject.optString("homeFaxNumber");
                qy1Var.z = jSONObject.optString("homePhoneNumber");
                qy1Var.A = jSONObject.optString("homeAddressCountry");
                qy1Var.B = jSONObject.optString("homeAddressState");
                qy1Var.C = jSONObject.optString("homeAddressCity");
                qy1Var.D = jSONObject.optString("homeAddressStreet");
                qy1Var.E = jSONObject.optString("homeAddressPostalCode");
            }
            return qy1Var;
        }
        return (qy1) invokeL.objValue;
    }

    public ContentValues b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data2", (Integer) 3);
            contentValues.put("data1", c());
            contentValues.put("data9", this.l);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.h)) {
                sb.append(this.h);
            }
            if (!TextUtils.isEmpty(this.i)) {
                sb.append(this.i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                sb.append(this.j);
            }
            if (!TextUtils.isEmpty(this.k)) {
                sb.append(this.k);
            }
            if (!TextUtils.isEmpty(this.l)) {
                sb.append(" ");
                sb.append(this.l);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.b)) {
                sb.append(this.b);
            }
            if (!TextUtils.isEmpty(this.c)) {
                sb.append(this.c);
            }
            if (!TextUtils.isEmpty(this.d)) {
                sb.append(this.d);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public ContentValues e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", f());
            contentValues.put("data9", this.E);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.A)) {
                sb.append(this.A);
            }
            if (!TextUtils.isEmpty(this.B)) {
                sb.append(this.B);
            }
            if (!TextUtils.isEmpty(this.C)) {
                sb.append(this.C);
            }
            if (!TextUtils.isEmpty(this.D)) {
                sb.append(this.D);
            }
            if (!TextUtils.isEmpty(this.E)) {
                sb.append(" ");
                sb.append(this.E);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public ContentValues g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 5);
            contentValues.put("data1", this.y);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", this.z);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 10);
            contentValues.put("data1", this.q);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 2);
            contentValues.put("data1", this.f);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", this.a);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", this.m);
            contentValues.put("data4", this.n);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
            contentValues.put("data1", this.e);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
            contentValues.put("data2", (Integer) 1);
            contentValues.put("data1", this.s);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
            contentValues.put("data5", (Integer) (-1));
            contentValues.put("data6", AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0110));
            contentValues.put("data1", this.g);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data2", (Integer) 2);
            contentValues.put("data1", q());
            contentValues.put("data9", this.x);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.t)) {
                sb.append(this.t);
            }
            if (!TextUtils.isEmpty(this.u)) {
                sb.append(this.u);
            }
            if (!TextUtils.isEmpty(this.v)) {
                sb.append(this.v);
            }
            if (!TextUtils.isEmpty(this.w)) {
                sb.append(this.w);
            }
            if (!TextUtils.isEmpty(this.x)) {
                sb.append(" ");
                sb.append(this.x);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public ContentValues r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 4);
            contentValues.put("data1", this.o);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public ContentValues s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
            contentValues.put("data2", (Integer) 3);
            contentValues.put("data1", this.p);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? !TextUtils.isEmpty(this.d) : invokeV.booleanValue;
    }
}
