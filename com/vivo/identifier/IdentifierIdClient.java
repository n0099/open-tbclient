package com.vivo.identifier;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class IdentifierIdClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AAID_FLAG = "AAID";
    public static final String ID_APPID = "appid";
    public static final String ID_TYPE = "type";
    public static final String OAID_FLAG = "OAID";
    public static final String SYS_IDENTIFIERID_SUPPORTED = "persist.sys.identifierid.supported";
    public static final String TAG = "VMS_SDK_Client";
    public static final int TIME_FOR_QUERY = 2000;
    public static final int TYPE_AAID = 2;
    public static final int TYPE_OAID = 0;
    public static final int TYPE_OAIDSTATUS = 4;
    public static final int TYPE_QUERY = 11;
    public static final int TYPE_VAID = 1;
    public static final String URI_BASE = "content://com.vivo.vms.IdProvider/IdentifierId";
    public static final String VAID_FLAG = "VAID";
    public static final int VERSION_P = 28;
    public static final int VERSION_Q = 29;
    public static String mAAID;
    public static IdentifierIdObserver mAAIDObserver;
    public static Context mContext;
    public static volatile DataBaseOperation mDatabase;
    public static volatile IdentifierIdClient mInstance;
    public static boolean mIsSupported;
    public static Object mLock;
    public static String mOAID;
    public static IdentifierIdObserver mOAIDObserver;
    public static String mOAIDStatus;
    public static Handler mSqlHandler;
    public static HandlerThread mSqlThread;
    public static String mVAID;
    public static IdentifierIdObserver mVAIDObserver;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1157688977, "Lcom/vivo/identifier/IdentifierIdClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1157688977, "Lcom/vivo/identifier/IdentifierIdClient;");
                return;
            }
        }
        mLock = new Object();
    }

    public IdentifierIdClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        initSqlThread();
        mDatabase = new DataBaseOperation(mContext);
    }

    public static void checkSupported() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        mIsSupported = "1".equals(getProperty(SYS_IDENTIFIERID_SUPPORTED, "0"));
    }

    public static IdentifierIdClient getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (isSupported()) {
                if (mContext == null) {
                    if (context == null) {
                        return null;
                    }
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    mContext = context;
                }
                if (mInstance == null) {
                    synchronized (IdentifierIdClient.class) {
                        if (mInstance == null) {
                            mInstance = new IdentifierIdClient();
                        }
                    }
                }
                return mInstance;
            }
            return null;
        }
        return (IdentifierIdClient) invokeL.objValue;
    }

    public static String getProperty(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            try {
                try {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    return (String) cls.getMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class, String.class).invoke(cls, str, "0");
                } catch (Exception unused) {
                    IdentifierIdLog.e(TAG, "getProperty: invoke is error");
                    return str2;
                }
            } catch (Throwable unused2) {
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static synchronized void initObserver(Context context, int i, String str) {
        ContentResolver contentResolver;
        Uri parse;
        IdentifierIdObserver identifierIdObserver;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65547, null, context, i, str) == null) {
            synchronized (IdentifierIdClient.class) {
                String packageName = context.getPackageName();
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2 && mAAIDObserver == null) {
                            int i2 = Build.VERSION.SDK_INT;
                            if (i2 >= 29) {
                                mAAIDObserver = new IdentifierIdObserver(mInstance, 2, packageName);
                                contentResolver = context.getContentResolver();
                                parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + packageName);
                                identifierIdObserver = mAAIDObserver;
                            } else if (i2 == 28) {
                                mAAIDObserver = new IdentifierIdObserver(mInstance, 2, str);
                                contentResolver = context.getContentResolver();
                                parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
                                identifierIdObserver = mAAIDObserver;
                            }
                            contentResolver.registerContentObserver(parse, false, identifierIdObserver);
                        }
                    } else if (mVAIDObserver == null) {
                        int i3 = Build.VERSION.SDK_INT;
                        if (i3 >= 29) {
                            mVAIDObserver = new IdentifierIdObserver(mInstance, 1, packageName);
                            contentResolver = context.getContentResolver();
                            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + packageName);
                            identifierIdObserver = mVAIDObserver;
                        } else if (i3 == 28) {
                            mVAIDObserver = new IdentifierIdObserver(mInstance, 1, str);
                            contentResolver = context.getContentResolver();
                            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
                            identifierIdObserver = mVAIDObserver;
                        }
                        contentResolver.registerContentObserver(parse, false, identifierIdObserver);
                    }
                } else if (mOAIDObserver == null) {
                    mOAIDObserver = new IdentifierIdObserver(mInstance, 0, null);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, mOAIDObserver);
                }
            }
        }
    }

    public static void initSqlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
            mSqlThread = handlerThread;
            handlerThread.start();
            mSqlHandler = new Handler(mSqlThread.getLooper()) { // from class: com.vivo.identifier.IdentifierIdClient.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                        if (message.what != 11) {
                            IdentifierIdLog.e(IdentifierIdClient.TAG, "message type valid");
                            return;
                        }
                        int i = message.getData().getInt("type");
                        try {
                            String query = IdentifierIdClient.mDatabase.query(i, message.getData().getString("appid"));
                            if (i == 0) {
                                String unused = IdentifierIdClient.mOAID = query;
                            } else if (i != 1) {
                                if (i != 2) {
                                    if (i != 4) {
                                    }
                                } else if (query != null) {
                                    String unused2 = IdentifierIdClient.mAAID = query;
                                } else {
                                    IdentifierIdLog.e(IdentifierIdClient.TAG, "get aaid failed");
                                }
                                String unused3 = IdentifierIdClient.mOAIDStatus = query;
                            } else if (query != null) {
                                String unused4 = IdentifierIdClient.mVAID = query;
                            } else {
                                IdentifierIdLog.e(IdentifierIdClient.TAG, "get vaid failed");
                            }
                        } catch (Exception e) {
                            IdentifierIdLog.e(IdentifierIdClient.TAG, "readException:" + e.toString());
                        }
                        synchronized (IdentifierIdClient.mLock) {
                            IdentifierIdClient.mLock.notify();
                        }
                    }
                }
            };
        }
    }

    public static boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (!mIsSupported) {
                checkSupported();
            }
            return mIsSupported;
        }
        return invokeV.booleanValue;
    }

    private void queryId(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65550, this, i, str) == null) {
            synchronized (mLock) {
                sendMessageToDataBase(i, str);
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    mLock.wait(2000L);
                } catch (InterruptedException unused) {
                    IdentifierIdLog.e(TAG, "queryId: lock error");
                }
                if (SystemClock.uptimeMillis() - uptimeMillis > 2000) {
                    IdentifierIdLog.d(TAG, "query timeout");
                }
            }
        }
    }

    public String getAAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Build.VERSION.SDK_INT == 28) {
                return null;
            }
            String str = mAAID;
            if (str != null) {
                return str;
            }
            String packageName = mContext.getPackageName();
            queryId(2, packageName);
            if (mAAIDObserver == null && mAAID != null) {
                initObserver(mContext, 2, packageName);
            }
            return mAAID;
        }
        return (String) invokeV.objValue;
    }

    public String getAAID(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String str2 = mAAID;
            if (str2 != null) {
                return str2;
            }
            queryId(2, str);
            if (mAAIDObserver == null && mAAID != null) {
                initObserver(mContext, 2, str);
            }
            return mAAID;
        }
        return (String) invokeL.objValue;
    }

    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String str = mOAID;
            if (str != null) {
                return str;
            }
            queryId(0, null);
            if (mOAIDObserver == null) {
                initObserver(mContext, 0, null);
            }
            return mOAID;
        }
        return (String) invokeV.objValue;
    }

    public String getOAIDSTATUS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            queryId(4, null);
            return mOAIDStatus;
        }
        return (String) invokeV.objValue;
    }

    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT == 28) {
                return null;
            }
            String str = mVAID;
            if (str != null) {
                return str;
            }
            String packageName = mContext.getPackageName();
            queryId(1, packageName);
            if (mVAIDObserver == null && mVAID != null) {
                initObserver(mContext, 1, packageName);
            }
            return mVAID;
        }
        return (String) invokeV.objValue;
    }

    public String getVAID(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            String str2 = mVAID;
            if (str2 != null) {
                return str2;
            }
            queryId(1, str);
            if (mVAIDObserver == null && mVAID != null) {
                initObserver(mContext, 1, str);
            }
            return mVAID;
        }
        return (String) invokeL.objValue;
    }

    public void sendMessageToDataBase(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) {
            Message obtainMessage = mSqlHandler.obtainMessage();
            obtainMessage.what = 11;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            if (i == 1 || i == 2) {
                bundle.putString("appid", str);
            }
            obtainMessage.setData(bundle);
            mSqlHandler.sendMessage(obtainMessage);
        }
    }
}
