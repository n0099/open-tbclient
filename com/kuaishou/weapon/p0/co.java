package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class co {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public co(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    private JSONObject a() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            try {
                System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                h a = h.a(this.a, "re_po_rt");
                a.e("a1_p_s_p_s");
                a.e("a1_p_s_p_s_c_b");
                aj ajVar = new aj(this.a);
                jSONObject.put("0", ajVar.d());
                jSONObject.put("1", ajVar.a());
                jSONObject.put("2", ajVar.c());
                jSONObject.put("3", ajVar.f());
                jSONObject.put("24", ajVar.e());
                int i13 = 1;
                if (ab.b()) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_LINK_ITME_CLICK, i);
                if (ab.a(this.a)) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("36", i2);
                JSONObject a2 = ai.a(this.a);
                if (a2 != null) {
                    jSONObject.put("4", a2);
                }
                a.b(df.ac, 0);
                ac acVar = new ac();
                if (acVar.a()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                jSONObject.put("7", i3);
                boolean a3 = acVar.a(this.a);
                if (a3) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                jSONObject.put("8", i4);
                if (a3) {
                    jSONObject.put(PayUVEventType.PAY_SIGN_DIALOG_SHOW, acVar.b(this.a));
                }
                jSONObject.put("10", acVar.e(this.a));
                jSONObject.put("11", acVar.c(this.a));
                ae aeVar = new ae();
                if (aeVar.a("cpuinfo")) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                jSONObject.put("26", i5);
                if (aeVar.a("meminfo")) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                jSONObject.put(PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK, i6);
                ao aoVar = new ao();
                if (aoVar.d()) {
                    i7 = 1;
                } else {
                    i7 = 0;
                }
                jSONObject.put(PayUVEventType.PAY_WALLET_RIGHT_SET_BTN_CLICK, i7);
                boolean b = aoVar.b();
                if (b) {
                    i8 = 1;
                } else {
                    i8 = 0;
                }
                jSONObject.put(PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW, i8);
                if (b) {
                    if (aoVar.a()) {
                        i12 = 1;
                    } else {
                        i12 = 0;
                    }
                    jSONObject.put(PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_CLICK, i12);
                }
                if (aoVar.f()) {
                    i9 = 1;
                } else {
                    i9 = 0;
                }
                jSONObject.put(PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, i9);
                jSONObject.put(PayUVEventType.PAY_AMOUNT_FULL_PAGE_CHANNEL_CLICK, aoVar.e());
                if (aoVar.c()) {
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                jSONObject.put(ADConfigError.REQUEST_HAS_SUCCESS_BEFORE, i10);
                if (aoVar.g()) {
                    i11 = 1;
                } else {
                    i11 = 0;
                }
                jSONObject.put(WorkPostNotifyFlutterData.FAIL_POST, i11);
                jSONObject.put("99", new af().a());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("03007", bv.a(this.a));
                jSONObject2.put("03014", bh.g(this.a));
                jSONObject2.put("03020", bv.b(this.a));
                jSONObject2.put("03030", bg.d(this.a));
                jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_LINK_ITEM_CLICK, jSONObject2);
                jSONObject.put("107", new an().d());
                if (!ab.b(this.a)) {
                    i13 = 0;
                }
                jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, i13);
                try {
                    jSONObject.put("11028", WeaponHI.sKSSdkver);
                    jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Hj().Hi()));
                    jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Hj().getSdkVersion()));
                    jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Hj().getAppId()));
                    jSONObject.put("11002", Engine.soVersion);
                } catch (Throwable unused) {
                }
                return jSONObject;
            } catch (Throwable unused2) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        JSONObject a;
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                cm cmVar = new cm(str, ck.l);
                String a3 = dl.a(cu.a);
                String b = b(a3);
                if (TextUtils.isEmpty(b) || (a = cmVar.a(this.a)) == null) {
                    return null;
                }
                String str2 = cu.h + "?" + cv.a(this.a);
                if (cu.a() && cu.a.contains("api")) {
                    str2 = "/api" + str2;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ip", b);
                jSONObject.put("host", a3);
                jSONObject.put("path", str2);
                String str3 = WeaponHI.cookieData;
                if (!TextUtils.isEmpty(str3) && str3.length() > 10) {
                    jSONObject.put("cookie", str3);
                }
                jSONObject.put("head", a);
                StringBuilder sb = new StringBuilder();
                sb.append("sdk=" + Build.VERSION.SDK_INT);
                jSONObject.put("parame", sb.toString());
                if (str.equals(ck.h) && (a2 = a()) != null) {
                    jSONObject.put("sjd", a2);
                }
                return jSONObject.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String hostAddress = InetAddress.getByName(dl.a(str)).getHostAddress();
                try {
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (hostAddress.contains(".")) {
                            return hostAddress;
                        }
                    }
                    return "";
                } catch (UnknownHostException unused) {
                    return hostAddress;
                }
            } catch (UnknownHostException unused2) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
