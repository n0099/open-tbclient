package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yxcorp.kuaishou.addfp.android.Orange;
import com.yxcorp.kuaishou.addfp.android.a.c;
import com.yxcorp.kuaishou.addfp.android.a.d;
import com.yxcorp.kuaishou.addfp.android.a.e;
import com.yxcorp.kuaishou.addfp.android.b.g;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class KWEGIDDFP {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EGID_LENGTH = 64;
    public static final int ERROR_TYPE_ACCESS_EXPTION = -1;
    public static final int ERROR_TYPE_NULL = -3;
    public static final int ERROR_TYPE_PROCESS = -4;
    public static final int ERROR_TYPE_UNKNOW = -2;
    public static int PROCESSALLOW = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public ResponseDfpCallback mCallBack;
    public String mEgid;
    public String mLocal;
    public Context mParamContext;
    public String mPkgName;
    public boolean mUserAgree;

    public KWEGIDDFP() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPkgName = "";
        this.mEgid = "";
        this.mLocal = "";
        this.mUserAgree = false;
    }

    public /* synthetic */ KWEGIDDFP(a aVar) {
        this();
    }

    public static String doSign(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) ? Orange.getInstance().getClockWrapper(context, str.getBytes(), 20) : (String) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getEGid(ResponseDfpCallback responseDfpCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, responseDfpCallback) == null) {
            try {
                getEGidImpl(new e(this.mParamContext).a());
                this.mLocal = c.c().a(this.mParamContext, responseDfpCallback, TextUtils.isEmpty(this.mEgid));
                if (responseDfpCallback == null) {
                    return;
                }
                if (!TextUtils.isEmpty(this.mEgid) || (!TextUtils.isEmpty(this.mLocal) && !this.mLocal.startsWith("KWE"))) {
                    responseDfpCallback.onSuccess(this.mEgid, this.mLocal);
                } else if (this.mLocal.equals("KWE_PE")) {
                } else {
                    responseDfpCallback.onFailed(-2, "need check");
                }
            } catch (Throwable th) {
                if (responseDfpCallback != null) {
                    try {
                        responseDfpCallback.onFailed(-1, g.a(th));
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
        }
    }

    private void getEGidImpl(boolean z) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, this, z) == null) {
            try {
                Pair a = d.a(this.mParamContext).a();
                if (a != null && (obj = a.second) != null) {
                    String str = (String) ((ConcurrentHashMap) obj).get("cache_e");
                    if (!TextUtils.isEmpty(str)) {
                        this.mEgid = str;
                    }
                }
                if (TextUtils.isEmpty(this.mEgid)) {
                    String a2 = Build.VERSION.SDK_INT < 29 ? com.yxcorp.kuaishou.addfp.c.a.a.a(this.mParamContext, "k_w_o_d_out_dtt") : null;
                    String a3 = (TextUtils.isEmpty(a2) && g.a(this.mParamContext, new String[]{com.kuaishou.weapon.p0.g.i, "android.permission.WRITE_EXTERNAL_STORAGE"})) ? d.a(this.mParamContext).a("Lm91a2R0ZnQ=") : "";
                    if (TextUtils.isEmpty(a2) && TextUtils.isEmpty(a3)) {
                        return;
                    }
                    LinkedHashMap b = d.a(this.mParamContext).b(a2);
                    if (b == null || b.size() == 0) {
                        b = d.a(this.mParamContext).b(a3);
                    }
                    if (b == null || b.size() <= 0) {
                        return;
                    }
                    String str2 = (String) b.get(c.c().a());
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    this.mEgid = str2;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void handlePolicy(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, jSONObject) == null) {
            c.a(jSONObject);
        }
    }

    public static KWEGIDDFP instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? b.a() : (KWEGIDDFP) invokeV.objValue;
    }

    public void getEGidByCallback(Context context, boolean z, ResponseDfpCallback responseDfpCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), responseDfpCallback}) == null) {
            try {
                this.mCallBack = responseDfpCallback;
                this.mParamContext = context;
                this.mUserAgree = z;
                Thread thread = new Thread(new a(this));
                thread.setName("adsence-dfp");
                thread.start();
            } catch (Throwable th) {
                String a = g.a(th);
                if (responseDfpCallback != null) {
                    responseDfpCallback.onFailed(-1, a);
                }
            }
        }
    }

    public String getEGidLocal(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, z)) == null) {
            if (TextUtils.isEmpty(this.mEgid)) {
                return null;
            }
            return this.mEgid;
        }
        return (String) invokeLLZ.objValue;
    }

    public Context getParamContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mParamContext : (Context) invokeV.objValue;
    }

    public boolean setEgid(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("DFP") && str.length() == 64) {
                d.a(context).a(str, "");
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void setLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            g.a(z);
        }
    }
}
