package com.yy.hiidostatis.inner.util.hdid;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.FileUtil;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import java.io.FileFilter;
import java.util.UUID;
/* loaded from: classes6.dex */
public class UuidManager {
    public static /* synthetic */ Interceptable $ic;
    public static Object LOCK_KEY;
    public static String MAGIC_KEY;
    public static String SETTING_KEY;
    public static String mDataPath;
    public static String mUuid;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1522464288, "Lcom/yy/hiidostatis/inner/util/hdid/UuidManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1522464288, "Lcom/yy/hiidostatis/inner/util/hdid/UuidManager;");
                return;
            }
        }
        LOCK_KEY = FileFilter.class;
        MAGIC_KEY = "!QAZXSW@#E";
        SETTING_KEY = "HdSdkBBAUuid";
        mUuid = null;
    }

    public UuidManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String fetchUUid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String str = mUuid;
            if (str != null) {
                return str;
            }
            synchronized (LOCK_KEY) {
                if (mUuid != null) {
                    return mUuid;
                }
                String readUUid = readUUid(getDataPath(context));
                String setting = getSetting(context);
                if (readUUid != null) {
                    L.debug("UuidManager", "uuid from data", new Object[0]);
                    mUuid = readUUid;
                    if (setting == null) {
                        saveSetting(context, readUUid);
                    }
                    return mUuid;
                } else if (setting != null) {
                    L.debug("UuidManager", "uuid from setting", new Object[0]);
                    mUuid = setting;
                    saveUUid(getDataPath(context), mUuid);
                    return mUuid;
                } else {
                    L.debug("UuidManager", "uuid createNew", new Object[0]);
                    mUuid = UUID.randomUUID().toString().replace("-", "");
                    saveUUid(getDataPath(context), mUuid);
                    saveSetting(context, mUuid);
                    return mUuid;
                }
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getDataPath(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (mDataPath == null) {
                mDataPath = String.format("%s%s%s", context.getFilesDir().getAbsolutePath(), File.separator, "hduuid_v1");
            }
            L.verbose("UuidManager", "data uuid path:%s", mDataPath);
            return mDataPath;
        }
        return (String) invokeL.objValue;
    }

    public static String getSetting(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
                String string = Settings.System.getString(context.getContentResolver(), SETTING_KEY);
                if (string != null) {
                    return Coder.decryptDES(string, MAGIC_KEY);
                }
                return null;
            } catch (Throwable th) {
                L.debug("UuidManager", "getSetting throwable %s", th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String readUUid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                return Coder.decryptDES(FileUtil.readFile(str), MAGIC_KEY);
            } catch (Throwable th) {
                th.printStackTrace();
                L.debug("UuidManager", "readUUid throwable %s", th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void saveSetting(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str) == null) && ArdUtil.checkPermissions(context, "android.permission.WRITE_SETTINGS")) {
            try {
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
                Settings.System.putString(context.getContentResolver(), SETTING_KEY, Coder.encryptDES(str, MAGIC_KEY));
            } catch (Throwable th) {
                L.debug("UuidManager", "saveSetting throwable %s", th);
            }
        }
    }

    public static void saveUUid(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            try {
                FileUtil.saveFile(str, Coder.encryptDES(str2, MAGIC_KEY));
            } catch (Throwable th) {
                L.debug("UuidManager", "saveUUid throwable %s", th);
            }
        }
    }
}
