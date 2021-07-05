package com.yy.mobile.framework.revenuesdk.payapi;

import android.app.Activity;
import android.app.Application;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseStatusInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class PurchaseStatusImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PURCHASE_CHORDERID = "chorderid";
    public static final String PURCHASE_DATA = "data";
    public static final String PURCHASE_ORDERID = "orderid";
    public static final String PURCHASE_PRODUCTID = "productid";
    public static final String PURCHASE_SIGN = "sign";
    public static final String PURCHASE_STATUS = "status";
    public static final String PURCHASE_UID = "uid";
    public static final String SAVE_FILE_DIR = "PurchaseStatus";
    public static final String TAG = "PurchaseStatusUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public PurchaseStatusImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void deleteAllPurchaseStatus(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, activity) == null) {
            if (activity == null) {
                RLog.error(TAG, "delete all purchaseStatus fail err: %d", "activity == null");
                return;
            }
            Application application = activity.getApplication();
            if (application != null && application.getCacheDir() != null) {
                ThreadPool.getDefault().diskIO().execute(new Runnable(application) { // from class: com.yy.mobile.framework.revenuesdk.payapi.PurchaseStatusImpl.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Application val$application;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {application};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$application = application;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        File[] listFiles;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            File file = new File(this.val$application.getCacheDir().getAbsolutePath() + File.separator + PurchaseStatusImpl.SAVE_FILE_DIR + File.separator);
                            if (!file.isDirectory()) {
                                RLog.error(PurchaseStatusImpl.TAG, "delete all purchaseStatus fail, err: %d", "pathDir is null path");
                                return;
                            }
                            for (File file2 : file.listFiles()) {
                                if (file2.exists()) {
                                    if (file2.delete()) {
                                        RLog.info(PurchaseStatusImpl.TAG, "delete all purchaseStatus info success");
                                    } else {
                                        RLog.info(PurchaseStatusImpl.TAG, "delete all purchaseStatus info fail");
                                    }
                                } else {
                                    RLog.info(PurchaseStatusImpl.TAG, "delete all purchaseStatus info fail, file not found");
                                }
                            }
                        }
                    }
                });
            } else {
                RLog.error(TAG, "delete all purchaseStatus fail err: %d", "application == null || application.getCacheDir() == null");
            }
        }
    }

    public static void deletePurchaseStatus(Activity activity, String str, long j, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{activity, str, Long.valueOf(j), str2}) == null) {
            if (activity == null) {
                RLog.error(TAG, "delete purchaseStatus fai, err: %d", "activity == null");
                return;
            }
            Application application = activity.getApplication();
            if (application != null && application.getCacheDir() != null) {
                ThreadPool.getDefault().diskIO().execute(new Runnable(str, str2, j, application) { // from class: com.yy.mobile.framework.revenuesdk.payapi.PurchaseStatusImpl.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Application val$application;
                    public final /* synthetic */ String val$orderId;
                    public final /* synthetic */ String val$productId;
                    public final /* synthetic */ long val$uid;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str, str2, Long.valueOf(j), application};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$productId = str;
                        this.val$orderId = str2;
                        this.val$uid = j;
                        this.val$application = application;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            String str3 = this.val$application.getCacheDir().getAbsolutePath() + File.separator + PurchaseStatusImpl.SAVE_FILE_DIR + File.separator;
                            File file = new File(str3 + (this.val$productId + this.val$orderId + this.val$uid + ".info"));
                            if (file.exists()) {
                                if (file.delete()) {
                                    RLog.info(PurchaseStatusImpl.TAG, "delete PurchaseStatus info success");
                                    return;
                                } else {
                                    RLog.info(PurchaseStatusImpl.TAG, "delete PurchaseStatus info fail");
                                    return;
                                }
                            }
                            RLog.info(PurchaseStatusImpl.TAG, "delete PurchaseStatus info fail, file not found");
                        }
                    }
                });
            } else {
                RLog.error(TAG, "delete purchaseStatus fail, err: %d", "application == null || application.getCacheDir() == null");
            }
        }
    }

    public static String getCHOrderId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                return new JSONObject(str).optString("chOrderId");
            } catch (JSONException e2) {
                RLog.error(TAG, "getOrderId fail raw str: %s, err msg: %s", str, e2.getMessage());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void readAllPurchaseStatus(Activity activity, IResult<List<PurchaseStatusInfo>> iResult) {
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, null, activity, iResult) == null) {
            FileInputStream fileInputStream2 = null;
            if (activity == null) {
                RLog.error(TAG, "read purchaseStatus fail err: %d", "activity == null");
                iResult.onFail(-1, "read purchaseStatus fail err: activity == null", null);
                return;
            }
            Application application = activity.getApplication();
            if (application != null && application.getCacheDir() != null) {
                File file = new File(application.getCacheDir().getAbsolutePath() + File.separator + SAVE_FILE_DIR + File.separator);
                if (!file.isDirectory()) {
                    RLog.error(TAG, "read all purchaseStatus fail， err: %d", "pathDir is null path");
                    iResult.onFail(-1, "read all purchaseStatus fail，err: pathDir is not path", null);
                    return;
                }
                File[] listFiles = file.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles == null) {
                    iResult.onSuccess(arrayList, null);
                    return;
                }
                for (File file2 : listFiles) {
                    if (!file2.isDirectory() && file2.exists() && file2.canRead()) {
                        Properties properties = new Properties();
                        try {
                            fileInputStream = new FileInputStream(file2);
                            try {
                                try {
                                    properties.load(fileInputStream);
                                    PurchaseStatusInfo purchaseStatusInfo = new PurchaseStatusInfo();
                                    purchaseStatusInfo.productId = properties.getProperty("productid");
                                    purchaseStatusInfo.uid = Long.valueOf(properties.getProperty("uid")).longValue();
                                    purchaseStatusInfo.orderId = properties.getProperty("orderid");
                                    purchaseStatusInfo.chorderid = properties.getProperty(PURCHASE_CHORDERID);
                                    purchaseStatusInfo.status = Integer.valueOf(properties.getProperty("status")).intValue();
                                    purchaseStatusInfo.purchaseData = properties.getProperty("data");
                                    purchaseStatusInfo.purchaseSign = properties.getProperty("sign");
                                    arrayList.add(purchaseStatusInfo);
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e2) {
                                        RLog.error(TAG, "read all PurchaseStatus fail， fail err: %d", e2.getMessage());
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    fileInputStream2 = fileInputStream;
                                    if (fileInputStream2 != null) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e3) {
                                            RLog.error(TAG, "read all PurchaseStatus fail， fail err: %d", e3.getMessage());
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                RLog.error(TAG, "read all PurchaseStatus fail， err: %d", e.getMessage());
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e5) {
                                        RLog.error(TAG, "read all PurchaseStatus fail， fail err: %d", e5.getMessage());
                                    }
                                }
                            }
                        } catch (Exception e6) {
                            e = e6;
                            fileInputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        RLog.error(TAG, "read all PurchaseStatus fail， file no exist or file can't read", new Object[0]);
                    }
                }
                iResult.onSuccess(arrayList, null);
                return;
            }
            RLog.error(TAG, "read purchaseStatus fail err: %d", "application == null || application.getCacheDir() == null");
            iResult.onFail(-1, "read purchaseStatus fail err: application == null || application.getCacheDir() == null", null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void readPurchaseStatus(Activity activity, String str, String str2, String str3, IResult<PurchaseStatusInfo> iResult) {
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLLL(AdIconUtil.AD_TEXT_ID, null, activity, str, str2, str3, iResult) != null) {
            return;
        }
        if (activity == null) {
            RLog.error(TAG, "read purchaseStatus fail err: %d", "activity == null");
            iResult.onFail(-1, "read purchaseStatus fail err: activity == null", null);
            return;
        }
        Application application = activity.getApplication();
        if (application != null && application.getCacheDir() != null) {
            String str4 = application.getCacheDir().getAbsolutePath() + File.separator + SAVE_FILE_DIR + File.separator;
            File file = new File(str4 + (str + str3 + str2 + ".info"));
            if (file.exists() && file.canRead()) {
                Properties properties = new Properties();
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            properties.load(fileInputStream);
                            PurchaseStatusInfo purchaseStatusInfo = new PurchaseStatusInfo();
                            purchaseStatusInfo.productId = properties.getProperty("productid");
                            purchaseStatusInfo.uid = Long.valueOf(properties.getProperty("uid")).longValue();
                            purchaseStatusInfo.orderId = properties.getProperty("orderid");
                            purchaseStatusInfo.chorderid = properties.getProperty(PURCHASE_CHORDERID);
                            purchaseStatusInfo.status = Integer.valueOf(properties.getProperty("status")).intValue();
                            purchaseStatusInfo.purchaseData = properties.getProperty("data");
                            purchaseStatusInfo.purchaseSign = properties.getProperty("sign");
                            iResult.onSuccess(purchaseStatusInfo, null);
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                RLog.error(TAG, "close PurchaseStatus fail err: %d", e2.getMessage());
                                iResult.onFail(-1, "close PurchaseStatus fail", null);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            RLog.error(TAG, "read PurchaseStatus fail err: %d", e.getMessage());
                            iResult.onFail(-1, "close PurchaseStatus fail:" + e.getMessage(), null);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    RLog.error(TAG, "close PurchaseStatus fail err: %d", e4.getMessage());
                                    iResult.onFail(-1, "close PurchaseStatus fail", null);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                RLog.error(TAG, "close PurchaseStatus fail err: %d", e5.getMessage());
                                iResult.onFail(-1, "close PurchaseStatus fail", null);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    e = e6;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } else {
                RLog.error(TAG, "read PurchaseStatus fail， file not exist or file can't read", new Object[0]);
                iResult.onFail(-1, "read PurchaseStatus fail ，file exist or file can't read", null);
            }
        } else {
            RLog.error(TAG, "read purchaseStatus fail err: %d", "application == null || application.getCacheDir() == null");
            iResult.onFail(-1, "read purchaseStatus fail err: application == null || application.getCacheDir() == null", null);
        }
    }

    public static void savePurchaseStatus(Activity activity, PurchaseStatusInfo purchaseStatusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, activity, purchaseStatusInfo) == null) {
            if (activity == null) {
                RLog.error(TAG, "save purchaseStatus fail err: %d", "activity == null");
                return;
            }
            Application application = activity.getApplication();
            if (application != null && application.getCacheDir() != null) {
                if (purchaseStatusInfo.productId != null && purchaseStatusInfo.orderId != null) {
                    ThreadPool.getDefault().diskIO().execute(new Runnable(purchaseStatusInfo, application) { // from class: com.yy.mobile.framework.revenuesdk.payapi.PurchaseStatusImpl.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Application val$application;
                        public final /* synthetic */ PurchaseStatusInfo val$purchaseStatusInfo;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {purchaseStatusInfo, application};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$purchaseStatusInfo = purchaseStatusInfo;
                            this.val$application = application;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            FileOutputStream fileOutputStream;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                String str = this.val$purchaseStatusInfo.productId + this.val$purchaseStatusInfo.orderId + this.val$purchaseStatusInfo.uid + ".info";
                                String str2 = this.val$application.getCacheDir().getAbsolutePath() + File.separator + PurchaseStatusImpl.SAVE_FILE_DIR + File.separator;
                                File file = new File(str2);
                                if (!file.exists()) {
                                    file.mkdir();
                                    try {
                                        file.createNewFile();
                                    } catch (IOException e2) {
                                        RLog.info(PurchaseStatusImpl.TAG, "save purchaseStatus--filedir---createNewFile fail: " + e2.getMessage());
                                        e2.printStackTrace();
                                    }
                                }
                                File file2 = new File(str2 + str);
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                if (!file2.isFile()) {
                                    try {
                                        file2.createNewFile();
                                    } catch (IOException e3) {
                                        RLog.info(PurchaseStatusImpl.TAG, "save purchaseStatus--file --- createNewFile fial: " + e3.getMessage());
                                        e3.printStackTrace();
                                    }
                                }
                                Properties properties = new Properties();
                                properties.setProperty("productid", this.val$purchaseStatusInfo.productId);
                                properties.setProperty("orderid", this.val$purchaseStatusInfo.orderId);
                                String str3 = this.val$purchaseStatusInfo.chorderid;
                                if (str3 != null) {
                                    properties.setProperty(PurchaseStatusImpl.PURCHASE_CHORDERID, str3);
                                } else {
                                    properties.setProperty(PurchaseStatusImpl.PURCHASE_CHORDERID, "");
                                }
                                properties.setProperty("status", String.valueOf(this.val$purchaseStatusInfo.status));
                                properties.setProperty("uid", String.valueOf(this.val$purchaseStatusInfo.uid));
                                String str4 = this.val$purchaseStatusInfo.purchaseData;
                                if (str4 != null) {
                                    properties.setProperty("data", str4);
                                } else {
                                    properties.setProperty("data", "");
                                }
                                String str5 = this.val$purchaseStatusInfo.purchaseSign;
                                if (str5 != null) {
                                    properties.setProperty("sign", str5);
                                } else {
                                    properties.setProperty("sign", "");
                                }
                                FileOutputStream fileOutputStream2 = null;
                                try {
                                    try {
                                        fileOutputStream = new FileOutputStream(file2);
                                    } catch (Exception e4) {
                                        e = e4;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                }
                                try {
                                    properties.store(fileOutputStream, PurchaseStatusImpl.TAG);
                                    RLog.info(PurchaseStatusImpl.TAG, "purchaseStatus -- save purchaseStatus success ");
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e5) {
                                        RLog.error(PurchaseStatusImpl.TAG, "purchaseStatus -- close FileOutputStream fail err: %d", e5.getMessage());
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    fileOutputStream2 = fileOutputStream;
                                    RLog.error(PurchaseStatusImpl.TAG, "purchaseStatus --  save purchaseStatus fail err: %d", e.getMessage());
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e7) {
                                            RLog.error(PurchaseStatusImpl.TAG, "purchaseStatus -- close FileOutputStream fail err: %d", e7.getMessage());
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream2 = fileOutputStream;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e8) {
                                            RLog.error(PurchaseStatusImpl.TAG, "purchaseStatus -- close FileOutputStream fail err: %d", e8.getMessage());
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    });
                    return;
                } else {
                    RLog.error(TAG, "save purchaseStatus fail err: %d", "productId == null || orderId == null");
                    return;
                }
            }
            RLog.error(TAG, "save purchaseStatus fail err: %d", "application == null || application.getCacheDir() == null");
        }
    }
}
