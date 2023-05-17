package com.vivo.identifier;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes10.dex */
public class IdentifierIdClient {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static final String AAID_FLAG = "AAID";
    @Keep
    public static final String ID_APPID = "appid";
    @Keep
    public static final String ID_TYPE = "type";
    @Keep
    public static final String OAID_FLAG = "OAID";
    @Keep
    public static final String SYS_IDENTIFIERID = "persist.sys.identifierid";
    @Keep
    public static final String SYS_IDENTIFIERID_SUPPORTED = "persist.sys.identifierid.supported";
    @Keep
    public static final String TAG = "VMS_SDK_Client";
    @Keep
    public static final int TIME_FOR_QUERY = 2000;
    @Keep
    public static final int TYPE_AAID = 2;
    @Keep
    public static final int TYPE_OAID = 0;
    @Keep
    public static final int TYPE_OAIDSTATUS = 4;
    @Keep
    public static final int TYPE_QUERY = 11;
    @Keep
    public static final int TYPE_VAID = 1;
    @Keep
    public static final String URI_BASE = "content://com.vivo.vms.IdProvider/IdentifierId";
    @Keep
    public static final String VAID_FLAG = "VAID";
    @Keep
    public static final int VERSION_P = 28;
    @Keep
    public static final int VERSION_Q = 29;
    @Keep
    public static String mAAID;
    @Keep
    public static IdentifierIdObserver mAAIDObserver;
    @Keep
    public static Context mContext;
    @Keep
    public static volatile DataBaseOperation mDatabase;
    @Keep
    public static volatile IdentifierIdClient mInstance;
    @Keep
    public static boolean mIsSupported;
    @Keep
    public static Object mLock;
    @Keep
    public static String mOAID;
    @Keep
    public static IdentifierIdObserver mOAIDObserver;
    @Keep
    public static String mOAIDStatus;
    @Keep
    public static Handler mSqlHandler;
    @Keep
    public static HandlerThread mSqlThread;
    @Keep
    public static String mVAID;
    @Keep
    public static IdentifierIdObserver mVAIDObserver;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* renamed from: com.vivo.identifier.IdentifierIdClient$1  reason: invalid class name */
    /* loaded from: classes10.dex */
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
        @Keep
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

    @Keep
    public static native void checkSupported();

    @Keep
    public static native IdentifierIdClient getInstance(Context context);

    @Keep
    public static native String getProperty(String str, String str2);

    @Keep
    public static native synchronized void initObserver(Context context, int i, String str);

    @Keep
    public static native void initSqlThread();

    @Keep
    public static native boolean isSupported();

    @Keep
    private native void queryId(int i, String str);

    @Keep
    public native String getAAID();

    @Keep
    public native String getAAID(String str);

    @Keep
    public native String getOAID();

    @Keep
    public native String getOAIDSTATUS();

    @Keep
    public native String getVAID();

    @Keep
    public native String getVAID(String str);

    @Keep
    public native void sendMessageToDataBase(int i, String str);
}
