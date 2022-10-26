package com.vivo.identifier;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
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
    public static final String SYS_IDENTIFIERID = "persist.sys.identifierid";
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

    /* renamed from: com.vivo.identifier.IdentifierIdClient$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass1 extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public native void handleMessage(Message message);
    }

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

    public static native void checkSupported();

    public static native IdentifierIdClient getInstance(Context context);

    public static native String getProperty(String str, String str2);

    public static native synchronized void initObserver(Context context, int i, String str);

    public static native void initSqlThread();

    public static native boolean isSupported();

    private native void queryId(int i, String str);

    public native String getAAID();

    public native String getAAID(String str);

    public native String getOAID();

    public native String getOAIDSTATUS();

    public native String getVAID();

    public native String getVAID(String str);

    public native void sendMessageToDataBase(int i, String str);
}
