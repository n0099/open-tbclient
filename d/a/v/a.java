package d.a.v;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.IMManager;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.request.IMSendMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.internal.NotifyMessageHandler;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.MessageUbc;
import com.baidu.android.imsdk.ubc.UBCConstants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f70710c;

    /* renamed from: d  reason: collision with root package name */
    public static final HandlerThread f70711d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f70712e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile Map<Long, Message> f70713f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile Map<Long, MessageUbc> f70714g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f70715h;

    /* renamed from: i  reason: collision with root package name */
    public static Context f70716i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AtomicInteger f70717a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.w.a.b.d.b f70718b;

    /* renamed from: d.a.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1953a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f70719e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f70720f;

        public RunnableC1953a(a aVar, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70720f = aVar;
            this.f70719e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70720f.j(this.f70719e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.a.w.a.b.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f70721a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70721a = aVar;
        }

        @Override // d.a.w.a.b.d.b
        public void onResponse(int i2, String str, long j, long j2, long j3, byte[] bArr) {
            MessageUbc messageUbc;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), bArr}) == null) {
                LogUtils.i("IMServiceImpl", "IMService err :" + i2 + ", methodId :" + j2 + ", data :" + bArr.length + ", Response :" + new String(bArr));
                int i3 = (j2 > 231L ? 1 : (j2 == 231L ? 0 : -1));
                if (i3 == 0) {
                    NotifyMessageHandler.handleRtcReport(ProgressInfo.JSON_KEY_BEGIN, new String(bArr));
                }
                if (i2 != 0) {
                    synchronized (a.f70713f) {
                        if (a.f70713f != null && a.f70713f.containsKey(Long.valueOf(j3))) {
                            ((Message) a.f70713f.get(Long.valueOf(j3))).handleMessageResult(a.f70716i, null, i2, str);
                            a.f70713f.remove(Long.valueOf(j3));
                        }
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    int optInt = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE, -1);
                    String optString = jSONObject.optString("msg", "");
                    if (this.f70721a.i((int) j2)) {
                        synchronized (a.f70713f) {
                            messageUbc = (MessageUbc) a.f70714g.get(Long.valueOf(j3));
                            a.f70714g.remove(Long.valueOf(j3));
                        }
                        if (messageUbc != null) {
                            d.a.u.a.a.d().f(messageUbc.generateUBCData(String.valueOf(optInt), optString), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
                        }
                    }
                    if (j2 == 96) {
                        NotifyMessageHandler.handleDeliverMessage(a.f70716i.getApplicationContext(), jSONObject);
                    } else if (j2 == 196) {
                        NotifyMessageHandler.handleMcastMessage(a.f70716i.getApplicationContext(), jSONObject);
                    } else if (j2 == 197) {
                        NotifyMessageHandler.handleConfigMessage(a.f70716i.getApplicationContext(), jSONObject);
                    } else if (j2 == 226) {
                        NotifyMessageHandler.handleMediaNotifyMessage(a.f70716i.getApplicationContext(), jSONObject);
                    } else if (i3 == 0) {
                        NotifyMessageHandler.handleRtcNotifyMessage(a.f70716i, jSONObject);
                    } else {
                        LogUtils.d("IMServiceImpl", "key :" + j3 + "response :" + jSONObject.toString());
                        synchronized (a.f70713f) {
                            if (a.f70713f != null && a.f70713f.containsKey(Long.valueOf(j3))) {
                                ((Message) a.f70713f.get(Long.valueOf(j3))).handleMessageResult(a.f70716i, jSONObject, optInt, optString);
                                a.f70713f.remove(Long.valueOf(j3));
                            }
                        }
                    }
                } catch (JSONException e2) {
                    LogUtils.e("IMServiceImpl", "handle response e :", e2);
                    synchronized (a.f70713f) {
                        if (a.f70713f != null && a.f70713f.containsKey(Long.valueOf(j3))) {
                            ((Message) a.f70713f.get(Long.valueOf(j3))).handleMessageResult(a.f70716i, null, -1, "");
                            a.f70713f.remove(Long.valueOf(j3));
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-153214600, "Ld/a/v/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-153214600, "Ld/a/v/a;");
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("IMServiceImpl HandlerThread");
        f70711d = handlerThread;
        handlerThread.start();
        f70710c = new Handler(f70711d.getLooper());
        f70712e = true;
        f70713f = new LinkedHashMap();
        f70714g = new LinkedHashMap();
    }

    public a() {
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
        this.f70717a = new AtomicInteger();
        this.f70718b = new b(this);
        h();
    }

    public static void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            synchronized (f70713f) {
                if (f70713f == null) {
                    return;
                }
                for (Message message : f70713f.values()) {
                    if (message != null) {
                        message.handleMessageResult(context, null, -1, "");
                    }
                }
            }
        }
    }

    public static a g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (f70715h == null) {
                synchronized (a.class) {
                    if (f70715h == null) {
                        f70716i = context.getApplicationContext();
                        f70715h = new a();
                    }
                }
            }
            return f70715h;
        }
        return (a) invokeL.objValue;
    }

    public void f(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            LogUtils.e("IMServiceImpl", "IMServiceImpl.getInstance(context).enqueueWork");
            TaskManager.getInstance(context).submitForNetWork(new RunnableC1953a(this, intent));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                LogUtils.d("IMServiceImpl", "isSmallFlow :" + f70712e);
                IMManager.init(f70716i.getApplicationContext(), IMConfigInternal.getInstance().getProductLine(f70716i.getApplicationContext()));
                if (f70712e) {
                    k();
                } else if (IMSDK.getInstance(f70716i.getApplicationContext()).init()) {
                } else {
                    IMConnection.getInstance(f70716i).disconnectedByPeer();
                }
            } catch (Exception unused) {
            }
        }
    }

    public final boolean i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 == 55 : invokeI.booleanValue;
    }

    public void j(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            LogUtils.d("IMServiceImpl", "-- onHandleWork -- " + intent + ", isSmallFlow :" + f70712e);
            if (intent == null) {
                intent = new Intent();
                LogUtils.i("IMServiceImpl", "--- onStart by null intent!");
            }
            if (f70712e) {
                try {
                    int intExtra = intent.getIntExtra("method", -1);
                    int intExtra2 = intent.getIntExtra("service_id", -1);
                    if (intExtra != -1 && intExtra2 != -1) {
                        if (intExtra == 50 || intExtra == 201) {
                            k();
                        }
                        Message createNewMessage = MessageFactory.getInstance().createNewMessage(f70716i, intExtra, intent);
                        if (createNewMessage != null) {
                            if (intExtra == 50) {
                                boolean z = false;
                                synchronized (f70713f) {
                                    LogUtils.d("IMServiceImpl", "cur method :50, cur msgList :" + f70713f.keySet());
                                    Iterator<Long> it = f70713f.keySet().iterator();
                                    while (it.hasNext()) {
                                        if (it.next().longValue() % 100 == 50) {
                                            z = true;
                                        }
                                    }
                                }
                                if (z || LoginManager.getInstance(f70716i.getApplicationContext()).isIMLogined()) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("cur state is ");
                                    sb.append(z ? "logining" : "loggined");
                                    sb.append(" , abandon other 50");
                                    LogUtils.d("IMServiceImpl", sb.toString());
                                    return;
                                }
                            }
                            createNewMessage.isSending(true);
                            BLCPRequest bLCPRequest = new BLCPRequest();
                            bLCPRequest.f6395a = intExtra2;
                            long type = createNewMessage.getType();
                            bLCPRequest.f6396b = type;
                            if (intExtra2 == 3 && type == 55) {
                                bLCPRequest.f6396b = 185L;
                            }
                            bLCPRequest.f6397c = createNewMessage.getBody().getBytes();
                            bLCPRequest.f6399e = BLCPRequest.SendTimeoutSecond.TIMEOUT_30s;
                            long j = (bLCPRequest.f6395a * 1000000000000000L) + bLCPRequest.f6396b;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append((System.currentTimeMillis() + "").substring((System.currentTimeMillis() + "").length() - 6));
                            sb2.append(this.f70717a.incrementAndGet());
                            bLCPRequest.f6398d = j + (Long.valueOf(sb2.toString()).longValue() * 1000);
                            synchronized (f70713f) {
                                if (i((int) bLCPRequest.f6396b) && (createNewMessage instanceof IMSendMsg)) {
                                    f70714g.put(Long.valueOf(bLCPRequest.f6398d), new MessageUbc(f70716i, ((IMSendMsg) createNewMessage).getChatMsg(), UBCConstants.BCSEND_UBCID));
                                }
                                f70713f.put(Long.valueOf(bLCPRequest.f6398d), createNewMessage);
                                LogUtils.d("IMServiceImpl", "requestTaskManager msg Id:" + bLCPRequest.f6398d + ". msg :" + f70713f.keySet().toString());
                            }
                            if (intExtra == 50) {
                                new IMTrack.RequestBuilder(f70716i.getApplicationContext()).method("send").requestId("2").errorCode(50L).ext("" + bLCPRequest.f6398d).aliasId(501112L).build();
                            }
                            d.a.w.a.b.a.c(bLCPRequest, this.f70718b);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    LogUtils.e("IMServiceImpl", "onStartCommand isSmallFlow Exception", e2);
                    return;
                }
            }
            try {
                if (IMSDK.getInstance(f70716i.getApplicationContext()).handleOnStart(intent)) {
                    return;
                }
                IMConnection.getInstance(f70716i).disconnectedByPeer();
            } catch (Exception e3) {
                LogUtils.e(LogUtils.TAG, "onStartCommand", e3);
                if (intent.hasExtra(Constants.EXTRA_LISTENER_ID) && ((intent.hasExtra("method") && intent.getIntExtra("method", -1) == 52) || intent.hasExtra(Constants.EXTRA_DISCONNECT))) {
                    IMListener removeListener = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                    if (removeListener instanceof ILoginListener) {
                        ((ILoginListener) removeListener).onLogoutResult(6, "IMService onStartCommand Exception", BIMManager.getLoginType(f70716i));
                    }
                } else if (intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                    ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                }
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int[] iArr = {96, Constants.METHOD_MEDIA_NOTIFY, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 231};
            for (int i2 = 0; i2 < 5; i2++) {
                l(2, Integer.valueOf(iArr[i2]).intValue());
            }
            l(3, 196);
        }
    }

    public final void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            d.a.w.a.b.d.a aVar = new d.a.w.a.b.d.a();
            aVar.f6395a = i2;
            aVar.f6396b = i3;
            d.a.w.a.b.a.c(aVar, this.f70718b);
        }
    }
}
