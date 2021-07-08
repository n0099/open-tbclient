package com.vivo.push.cache;

import android.content.Context;
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
import com.baidu.webkit.internal.Base64;
import com.vivo.push.util.g;
import com.vivo.push.util.h;
import com.vivo.push.util.p;
import com.vivo.push.util.w;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes6.dex */
public abstract class c<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte[] CRPYT_IV_BYTE;
    public static final byte[] CRPYT_KEY_BYTE;
    public static int MAX_CLIENT_SAVE_LENGTH = 0;
    public static final String TAG = "IAppManager";
    public static final Object sAppLock;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<T> mAppDatas;
    public Context mContext;
    public w mSharePreferenceManager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(432263089, "Lcom/vivo/push/cache/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(432263089, "Lcom/vivo/push/cache/c;");
                return;
            }
        }
        CRPYT_IV_BYTE = new byte[]{34, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 37, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 32, PublicSuffixDatabase.EXCEPTION_MARKER, PublicSuffixDatabase.EXCEPTION_MARKER, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 41, Base64.INTERNAL_PADDING, Base64.INTERNAL_PADDING, 32, 32};
        CRPYT_KEY_BYTE = new byte[]{PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 32, 38, 37, PublicSuffixDatabase.EXCEPTION_MARKER, Base64.INTERNAL_PADDING, 34, PublicSuffixDatabase.EXCEPTION_MARKER};
        sAppLock = new Object();
        MAX_CLIENT_SAVE_LENGTH = 10000;
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAppDatas = new HashSet();
        this.mContext = context.getApplicationContext();
        w b2 = w.b();
        this.mSharePreferenceManager = b2;
        b2.a(this.mContext);
        loadData();
    }

    public void addData(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
            synchronized (sAppLock) {
                Iterator<T> it = this.mAppDatas.iterator();
                while (it.hasNext()) {
                    if (t.equals(it.next())) {
                        it.remove();
                    }
                }
                this.mAppDatas.add(t);
                updateDataToSP(this.mAppDatas);
            }
        }
    }

    public void addDatas(Set<T> set) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set) == null) || set == null) {
            return;
        }
        synchronized (sAppLock) {
            Iterator<T> it = this.mAppDatas.iterator();
            while (it.hasNext()) {
                if (set.contains(it.next())) {
                    it.remove();
                }
            }
            this.mAppDatas.addAll(set);
            updateDataToSP(this.mAppDatas);
        }
    }

    public void clearData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (sAppLock) {
                this.mAppDatas.clear();
                this.mSharePreferenceManager.c(generateStrByType());
            }
        }
    }

    public abstract String generateStrByType();

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Set<T> set = this.mAppDatas;
            return set == null || set.size() == 0;
        }
        return invokeV.booleanValue;
    }

    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (sAppLock) {
                h.a(generateStrByType());
                this.mAppDatas.clear();
                String a2 = this.mSharePreferenceManager.a(generateStrByType());
                if (TextUtils.isEmpty(a2)) {
                    p.d(TAG, "AppManager init strApps empty.");
                } else if (a2.length() > MAX_CLIENT_SAVE_LENGTH) {
                    p.d(TAG, "sync  strApps lenght too large");
                    clearData();
                } else {
                    try {
                        String str = new String(g.a(g.a(CRPYT_IV_BYTE), g.a(CRPYT_KEY_BYTE), android.util.Base64.decode(a2, 2)), "utf-8");
                        p.d(TAG, "AppManager init strApps : " + str);
                        Set<T> parseAppStr = parseAppStr(str);
                        if (parseAppStr != null) {
                            this.mAppDatas.addAll(parseAppStr);
                        }
                    } catch (Exception e2) {
                        clearData();
                        p.d(TAG, p.a(e2));
                    }
                }
            }
        }
    }

    public abstract Set<T> parseAppStr(String str);

    public void removeData(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
            synchronized (sAppLock) {
                boolean z = false;
                Iterator<T> it = this.mAppDatas.iterator();
                while (it.hasNext()) {
                    if (t.equals(it.next())) {
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    updateDataToSP(this.mAppDatas);
                }
            }
        }
    }

    public void removeDatas(Set<T> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, set) == null) {
            synchronized (sAppLock) {
                Iterator<T> it = this.mAppDatas.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    if (set.contains(it.next())) {
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    updateDataToSP(this.mAppDatas);
                }
            }
        }
    }

    public abstract String toAppStr(Set<T> set);

    public String updateDataToSP(Set<T> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, set)) == null) {
            String appStr = toAppStr(set);
            try {
                String a2 = g.a(CRPYT_IV_BYTE);
                String a3 = g.a(CRPYT_KEY_BYTE);
                byte[] bytes = appStr.getBytes("utf-8");
                SecretKeySpec secretKeySpec = new SecretKeySpec(a3.getBytes("utf-8"), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, new IvParameterSpec(a2.getBytes("utf-8")));
                String encodeToString = android.util.Base64.encodeToString(cipher.doFinal(bytes), 2);
                if (!TextUtils.isEmpty(encodeToString) && encodeToString.length() > MAX_CLIENT_SAVE_LENGTH) {
                    p.d(TAG, "sync  strApps lenght too large");
                    clearData();
                    return null;
                }
                p.d(TAG, "sync  strApps: " + encodeToString);
                this.mSharePreferenceManager.a(generateStrByType(), encodeToString);
                return appStr;
            } catch (Exception e2) {
                p.d(TAG, p.a(e2));
                clearData();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
