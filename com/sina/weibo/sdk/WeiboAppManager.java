package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class WeiboAppManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SDK_INT_FILE_NAME = "weibo_for_sdk.json";
    public static final String TAG = "com.sina.weibo.sdk.WeiboAppManager";
    public static final String WEIBO_4G_PACKAGENAME = "com.sina.weibog3";
    public static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
    public static final String WEIBO_PACKAGENAME = "com.sina.weibo";
    public static WeiboAppManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public WbAppInfo wbAppInfo;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1387467887, "Lcom/sina/weibo/sdk/WeiboAppManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1387467887, "Lcom/sina/weibo/sdk/WeiboAppManager;");
        }
    }

    public WeiboAppManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
    }

    public static synchronized WeiboAppManager getInstance(Context context) {
        InterceptResult invokeL;
        WeiboAppManager weiboAppManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (WeiboAppManager.class) {
                if (sInstance == null) {
                    sInstance = new WeiboAppManager(context);
                }
                weiboAppManager = sInstance;
            }
            return weiboAppManager;
        }
        return (WeiboAppManager) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0080, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static WbAppInfo parseWbInfoByAsset(Context context, String str) {
        InterceptResult invokeLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65539, null, context, str)) != null) {
            return (WbAppInfo) invokeLL.objValue;
        }
        InputStream inputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArr = new byte[4096];
            inputStream = context.createPackageContext(str, 2).getAssets().open(SDK_INT_FILE_NAME);
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int read = inputStream.read(bArr, 0, 4096);
                        if (read == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    if (!TextUtils.isEmpty(sb.toString())) {
                        ApiUtils.validateWeiboSign(context, str);
                    }
                    JSONObject jSONObject = new JSONObject(sb.toString());
                    int optInt = jSONObject.optInt("support_api", -1);
                    String optString = jSONObject.optString("authActivityName", null);
                    if (optInt != -1 && !TextUtils.isEmpty(optString)) {
                        WbAppInfo wbAppInfo = new WbAppInfo();
                        wbAppInfo.setPackageName(str);
                        wbAppInfo.setSupportVersion(optInt);
                        wbAppInfo.setAuthActivityName(optString);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return wbAppInfo;
                    }
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    LogUtil.e(TAG, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
            }
            throw th;
        }
    }

    public static WbAppInfo queryWbInfoByAsset(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
            intent.addCategory("android.intent.category.DEFAULT");
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            WbAppInfo wbAppInfo = null;
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    if (serviceInfo != null && serviceInfo.applicationInfo != null && !TextUtils.isEmpty(serviceInfo.packageName)) {
                        String str = resolveInfo.serviceInfo.packageName;
                        WbAppInfo parseWbInfoByAsset = parseWbInfoByAsset(context, str);
                        if (parseWbInfoByAsset != null) {
                            wbAppInfo = parseWbInfoByAsset;
                        }
                        if ("com.sina.weibo".equals(str) || WEIBO_4G_PACKAGENAME.equals(str)) {
                            break;
                        }
                    }
                }
            }
            return wbAppInfo;
        }
        return (WbAppInfo) invokeL.objValue;
    }

    public static WbAppInfo queryWbInfoInternal(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? queryWbInfoByAsset(context) : (WbAppInfo) invokeL.objValue;
    }

    public synchronized WbAppInfo getWbAppInfo() {
        InterceptResult invokeV;
        WbAppInfo queryWbInfoInternal;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                queryWbInfoInternal = queryWbInfoInternal(this.mContext);
            }
            return queryWbInfoInternal;
        }
        return (WbAppInfo) invokeV.objValue;
    }

    @Deprecated
    public boolean hasWbInstall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
            intent.addCategory("android.intent.category.DEFAULT");
            List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(intent, 0);
            return (queryIntentServices == null || queryIntentServices.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
