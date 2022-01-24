package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
import com.yxcorp.kuaishou.addfp.android.Orange;
import com.yxcorp.kuaishou.addfp.android.a.c;
import com.yxcorp.kuaishou.addfp.android.a.d;
import com.yxcorp.kuaishou.addfp.android.a.e;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class KWEGIDDFP {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EGID_LENGTH = 64;
    public static final int ERROR_TYPE_ACCESS_EXPTION = -1;
    public static final int ERROR_TYPE_NULL = -3;
    public static final int ERROR_TYPE_PROCESS = -4;
    public static final int ERROR_TYPE_UNKNOW = -2;
    public static int PROCESSALLOW = -1;
    public static String mOAID = "KWE_NS";
    public transient /* synthetic */ FieldHolder $fh;
    public ResponseDfpCallback mCallBack;
    public String mEgid;
    public String mLocal;
    public Context mParamContext;
    public String mPkgName;
    public boolean mUserAgree;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2016514064, "Lcom/yxcorp/kuaishou/addfp/KWEGIDDFP;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2016514064, "Lcom/yxcorp/kuaishou/addfp/KWEGIDDFP;");
        }
    }

    public KWEGIDDFP() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) ? Orange.getInstance().getClockWrapper(context, str.getBytes(), 20) : (String) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getEGid(ResponseDfpCallback responseDfpCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, responseDfpCallback) == null) {
            try {
                boolean a = new e(this.mParamContext).a();
                initOAIDImpl(this.mParamContext);
                getEGidImpl(a);
                this.mLocal = com.yxcorp.kuaishou.addfp.android.a.a.a().a(this.mParamContext, responseDfpCallback, this.mUserAgree, TextUtils.isEmpty(this.mEgid));
                if (responseDfpCallback == null) {
                    return;
                }
                if (TextUtils.isEmpty(this.mEgid) && (TextUtils.isEmpty(this.mLocal) || this.mLocal.startsWith("KWE"))) {
                    if (this.mLocal.equals("KWE_PE")) {
                        return;
                    }
                    responseDfpCallback.onFailed(-2, "need check");
                    return;
                }
                responseDfpCallback.onSuccess(this.mEgid, this.mLocal);
            } catch (Throwable th) {
                if (responseDfpCallback != null) {
                    try {
                        responseDfpCallback.onFailed(-1, com.yxcorp.kuaishou.addfp.android.b.e.a(th));
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
        }
    }

    private void getEGidImpl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            try {
                Pair a = c.a(this.mParamContext).a();
                if (a != null && a.second != null) {
                    String str = (String) ((ConcurrentHashMap) a.second).get("cache_e");
                    if (!TextUtils.isEmpty(str)) {
                        this.mEgid = str;
                    }
                }
                if (TextUtils.isEmpty(this.mEgid)) {
                    String a2 = Build.VERSION.SDK_INT < 29 ? d.a(this.mParamContext, "k_w_o_d_out_dtt") : null;
                    String str2 = "";
                    if (TextUtils.isEmpty(a2)) {
                        com.yxcorp.kuaishou.addfp.android.b.b.a();
                        if (com.yxcorp.kuaishou.addfp.android.b.e.b(this.mParamContext, new String[]{s.f55293i, "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                            str2 = c.a(this.mParamContext).b("Lm91a2R0ZnQ=");
                        }
                    }
                    if (TextUtils.isEmpty(a2) && TextUtils.isEmpty(str2)) {
                        return;
                    }
                    LinkedHashMap a3 = c.a(this.mParamContext).a(a2);
                    if (a3 == null || a3.size() == 0) {
                        a3 = c.a(this.mParamContext).a(str2);
                    }
                    if (a3 == null || a3.size() <= 0) {
                        return;
                    }
                    String str3 = (String) a3.get(com.yxcorp.kuaishou.addfp.android.a.a.a().b());
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    this.mEgid = str3;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void initOAIDImpl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, context) == null) {
            try {
                com.yxcorp.kuaishou.addfp.a.a.b.a().a(context);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static KWEGIDDFP instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? b.a() : (KWEGIDDFP) invokeV.objValue;
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
                String a = com.yxcorp.kuaishou.addfp.android.b.e.a(th);
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

    public boolean setEgid(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("DFP") && str.length() == 64) {
                c.a(context).a(str, "");
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void setLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
        }
    }
}
