package com.yy.hiidostatis.inner.util.hdid;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
/* loaded from: classes8.dex */
public class ClientIdHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BI_CLIENT_ID_FILE_NAME = "hdcltid.ini";
    public static final String BI_CLIENT_ID_FILE_SUFFIX = ".ini";
    public static final String BI_CLIENT_ID_PREF_FILE_NAME = "hdcltid";
    public static final String PREFIX_BUILD = "bp_";
    public static final String PREFIX_CUSTOM = "bc_";
    public static final String PREFIX_NORMAL = "bi_";
    public static final String PREFIX_SERIAL = "bs_";
    public static final String SP_BI_CLIENT_ID_KEY = "hdcltid";
    public static final String TAG = "ClientIdHelper";
    public static String mClientID = "";
    public static volatile ClientIdHelper mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final int boardDigit;
    public final int brandDigit;
    public final int cpuAbiDigit;
    public final int deviceDigit;
    public IClientIdConfig mConfig;
    public final int manufacturerDigit;
    public final int modelDigit;
    public final int productDigit;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1168511728, "Lcom/yy/hiidostatis/inner/util/hdid/ClientIdHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1168511728, "Lcom/yy/hiidostatis/inner/util/hdid/ClientIdHelper;");
        }
    }

    public ClientIdHelper(IClientIdConfig iClientIdConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iClientIdConfig};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.boardDigit = boardDigit();
        this.brandDigit = brandDigit();
        this.cpuAbiDigit = cpuAbiDigit();
        this.deviceDigit = deviceDigit();
        this.manufacturerDigit = manufacturerDigit();
        this.modelDigit = modelDigit();
        this.productDigit = productDigit();
        this.mConfig = iClientIdConfig;
        checkConfig();
        initClientId();
        if (this.mConfig.logEnable()) {
            Log.d(TAG, "boardDigit = " + this.boardDigit);
            Log.d(TAG, "brandDigit = " + this.brandDigit);
            Log.d(TAG, "cpuAbiDigit = " + this.cpuAbiDigit);
            Log.d(TAG, "deviceDigit = " + this.deviceDigit);
            Log.d(TAG, "manufacturerDigit = " + this.manufacturerDigit);
            Log.d(TAG, "modelDigit = " + this.modelDigit);
            Log.d(TAG, "productDigit = " + this.productDigit);
        }
    }

    private int boardDigit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (!TextUtils.isEmpty(Build.BOARD)) {
                return Build.BOARD.length() % 10;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int brandDigit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (!TextUtils.isEmpty(Build.BRAND)) {
                return Build.BRAND.length() % 10;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private boolean checkBuild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.boardDigit + this.brandDigit + this.cpuAbiDigit + this.deviceDigit + this.manufacturerDigit + this.modelDigit + this.productDigit != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void checkConfig() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65541, this) != null) || this.mConfig != null) {
            return;
        }
        throw new RuntimeException("IConfig must be initialized !!");
    }

    private int cpuAbiDigit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (!TextUtils.isEmpty(Build.CPU_ABI)) {
                return Build.CPU_ABI.length() % 10;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private String createPsuedoID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            return UUID.randomUUID().toString();
        }
        return (String) invokeV.objValue;
    }

    private int deviceDigit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (!TextUtils.isEmpty(Build.DEVICE)) {
                return Build.DEVICE.length() % 10;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static ClientIdHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (mInstance != null) {
                return mInstance;
            }
            throw new RuntimeException("ClientIdHelper must be initialized ! init should be called Firstly !");
        }
        return (ClientIdHelper) invokeV.objValue;
    }

    private boolean initClientId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            String readFromSp = readFromSp();
            if (!TextUtils.isEmpty(readFromSp)) {
                setMemoryClientId(readFromSp);
                return true;
            }
            String createUniquePsuedoID = createUniquePsuedoID();
            if (!TextUtils.isEmpty(createUniquePsuedoID)) {
                setClientId(createUniquePsuedoID);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private int manufacturerDigit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
                return Build.MANUFACTURER.length() % 10;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int modelDigit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            if (!TextUtils.isEmpty(Build.MODEL)) {
                return Build.MODEL.length() % 10;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int productDigit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            if (!TextUtils.isEmpty(Build.PRODUCT)) {
                return Build.PRODUCT.length() % 10;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private String readFromSp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if (this.mConfig.logEnable()) {
                Log.d(TAG, "readFromSp");
            }
            return sharedPref().getString("hdcltid", null);
        }
        return (String) invokeV.objValue;
    }

    private SharedPreferences sharedPref() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            return this.mConfig.getAppContext().getSharedPreferences("hdcltid", 0);
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public byte[] getByteClientId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = mClientID;
            if (str != null) {
                return str.getBytes();
            }
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public String getClientId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return mClientID;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        if (r3.isEmpty() != false) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String createUniquePsuedoID() {
        InterceptResult invokeV;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            boolean checkBuild = checkBuild();
            boolean z = false;
            try {
                if (Build.VERSION.SDK_INT < 26) {
                    str2 = "";
                } else {
                    str2 = Build.getSerial();
                }
                if (str2 != null) {
                    try {
                    } catch (Throwable th) {
                        str = str2;
                        th = th;
                        if (this.mConfig.logEnable()) {
                            th.printStackTrace();
                        }
                        str2 = str;
                        if (this.mConfig.logEnable()) {
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            z = true;
                        }
                        if (!z) {
                        }
                        String str4 = "35" + this.boardDigit + this.brandDigit + this.cpuAbiDigit + this.deviceDigit + this.manufacturerDigit + this.modelDigit + this.productDigit;
                        if (!checkBuild) {
                        }
                        if (!checkBuild) {
                        }
                        if (TextUtils.isEmpty(str3)) {
                        }
                        return str3.replaceAll("_", "").replaceAll("-", "");
                    }
                }
                str2 = Build.class.getField("SERIAL").get(null).toString();
            } catch (Throwable th2) {
                th = th2;
                str = "";
            }
            if (this.mConfig.logEnable()) {
                Log.e(TAG, "serial = " + str2);
                Log.e(TAG, "buildParamOk = " + checkBuild);
            }
            if (!TextUtils.isEmpty(str2) && !str2.equalsIgnoreCase("unKnown")) {
                z = true;
            }
            if (!z) {
                str2 = "";
            }
            String str42 = "35" + this.boardDigit + this.brandDigit + this.cpuAbiDigit + this.deviceDigit + this.manufacturerDigit + this.modelDigit + this.productDigit;
            if (!checkBuild && !TextUtils.isEmpty(str2)) {
                str3 = PREFIX_NORMAL + new UUID(str42.hashCode(), str2.hashCode()).toString();
            } else if (!checkBuild) {
                str3 = PREFIX_BUILD + new UUID(str42.hashCode(), str2.hashCode()).toString();
            } else if (!TextUtils.isEmpty(str2)) {
                str3 = PREFIX_SERIAL + new UUID(str42.hashCode(), str2.hashCode()).toString();
            } else {
                str3 = PREFIX_CUSTOM + createPsuedoID();
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = createPsuedoID();
            }
            return str3.replaceAll("_", "").replaceAll("-", "");
        }
        return (String) invokeV.objValue;
    }

    public static void init(IClientIdConfig iClientIdConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, iClientIdConfig) == null) && mInstance == null) {
            synchronized (ClientIdHelper.class) {
                if (mInstance == null) {
                    mInstance = new ClientIdHelper(iClientIdConfig);
                }
            }
        }
    }

    private void setClientId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, str) == null) {
            setMemoryClientId(str);
            writeIntoSp();
        }
    }

    private void setMemoryClientId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, str) == null) {
            mClientID = str;
        }
    }

    private boolean writeIntoSp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            if (this.mConfig.logEnable()) {
                Log.d(TAG, "writeIntoSp" + mClientID);
            }
            return sharedPref().edit().putString("hdcltid", mClientID).commit();
        }
        return invokeV.booleanValue;
    }
}
