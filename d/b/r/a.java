package d.b.r;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.internal.NotifyMessageHandler;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.pms.constants.PmsConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static Handler f65508c;

    /* renamed from: d  reason: collision with root package name */
    public static final HandlerThread f65509d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f65510e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile Map<Long, Message> f65511f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f65512g;

    /* renamed from: h  reason: collision with root package name */
    public static Context f65513h;

    /* renamed from: a  reason: collision with root package name */
    public AtomicInteger f65514a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    public d.b.s.a.b.d.b f65515b = new b(this);

    /* renamed from: d.b.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1795a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f65516e;

        public RunnableC1795a(Intent intent) {
            this.f65516e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g(this.f65516e);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.s.a.b.d.b {
        public b(a aVar) {
        }

        @Override // d.b.s.a.b.d.b
        public void onResponse(int i, String str, long j, long j2, long j3, byte[] bArr) {
            LogUtils.i("IMServiceImpl", "IMService err :" + i + ", methodId :" + j2 + ", data :" + bArr.length + ", Response :" + new String(bArr));
            if (i != 0) {
                synchronized (a.f65511f) {
                    if (a.f65511f != null && a.f65511f.containsKey(Long.valueOf(j3))) {
                        ((Message) a.f65511f.get(Long.valueOf(j3))).handleMessageResult(a.f65513h, null, i, str);
                        a.f65511f.remove(Long.valueOf(j3));
                    }
                }
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                int optInt = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE, -1);
                String optString = jSONObject.optString("msg", "");
                if (j2 == 96) {
                    NotifyMessageHandler.handleDeliverMessage(a.f65513h.getApplicationContext(), jSONObject);
                } else if (j2 == 196) {
                    NotifyMessageHandler.handleMcastMessage(a.f65513h.getApplicationContext(), jSONObject);
                } else if (j2 == 197) {
                    NotifyMessageHandler.handleConfigMessage(a.f65513h.getApplicationContext(), jSONObject);
                } else if (j2 == 226) {
                    NotifyMessageHandler.handleMediaNotifyMessage(a.f65513h.getApplicationContext(), jSONObject);
                } else if (j2 == 231) {
                    NotifyMessageHandler.handleRtcNotifyMessage(a.f65513h, jSONObject);
                } else {
                    LogUtils.d("IMServiceImpl", "key :" + j3 + "response :" + jSONObject.toString());
                    synchronized (a.f65511f) {
                        if (a.f65511f != null && a.f65511f.containsKey(Long.valueOf(j3))) {
                            ((Message) a.f65511f.get(Long.valueOf(j3))).handleMessageResult(a.f65513h, jSONObject, optInt, optString);
                            a.f65511f.remove(Long.valueOf(j3));
                        }
                    }
                }
            } catch (JSONException e2) {
                LogUtils.e("IMServiceImpl", "handle response e :", e2);
                synchronized (a.f65511f) {
                    if (a.f65511f != null && a.f65511f.containsKey(Long.valueOf(j3))) {
                        ((Message) a.f65511f.get(Long.valueOf(j3))).handleMessageResult(a.f65513h, null, -1, "");
                        a.f65511f.remove(Long.valueOf(j3));
                    }
                }
            }
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("IMServiceImpl HandlerThread");
        f65509d = handlerThread;
        handlerThread.start();
        f65508c = new Handler(f65509d.getLooper());
        f65510e = true;
        f65511f = new LinkedHashMap();
    }

    public a() {
        f();
    }

    public static void c(Context context) {
        synchronized (f65511f) {
            if (f65511f == null) {
                return;
            }
            for (Message message : f65511f.values()) {
                if (message != null) {
                    message.handleMessageResult(context, null, -1, "");
                }
            }
        }
    }

    public static a e(Context context) {
        if (f65512g == null) {
            synchronized (a.class) {
                if (f65512g == null) {
                    f65513h = context.getApplicationContext();
                    f65512g = new a();
                }
            }
        }
        return f65512g;
    }

    public void d(Context context, Intent intent) {
        LogUtils.e("IMServiceImpl", "IMServiceImpl.getInstance(context).enqueueWork");
        TaskManager.getInstance(context).submitForNetWork(new RunnableC1795a(intent));
    }

    public final void f() {
        try {
            LogUtils.d("IMServiceImpl", "isSmallFlow :" + f65510e);
            IMManager.init(f65513h.getApplicationContext(), IMConfigInternal.getInstance().getProductLine(f65513h.getApplicationContext()));
            if (f65510e) {
                h();
            } else if (!IMSDK.getInstance(f65513h.getApplicationContext()).init()) {
                IMConnection.getInstance(f65513h).disconnectedByPeer();
            }
        } catch (Exception unused) {
        }
    }

    public void g(@NonNull Intent intent) {
        LogUtils.d("IMServiceImpl", "-- onHandleWork -- " + intent + ", isSmallFlow :" + f65510e);
        if (intent == null) {
            intent = new Intent();
            LogUtils.i("IMServiceImpl", "--- onStart by null intent!");
        }
        if (f65510e) {
            try {
                int intExtra = intent.getIntExtra("method", -1);
                int intExtra2 = intent.getIntExtra("service_id", -1);
                if (intExtra != -1 && intExtra2 != -1) {
                    if (intExtra == 50 || intExtra == 201) {
                        h();
                    }
                    Message createNewMessage = MessageFactory.getInstance().createNewMessage(f65513h, intExtra, intent);
                    if (createNewMessage != null) {
                        if (intExtra == 50) {
                            boolean z = false;
                            synchronized (f65511f) {
                                LogUtils.d("IMServiceImpl", "cur method :50, cur msgList :" + f65511f.keySet());
                                Iterator<Long> it = f65511f.keySet().iterator();
                                while (it.hasNext()) {
                                    if (it.next().longValue() % 100 == 50) {
                                        z = true;
                                    }
                                }
                            }
                            if (z || LoginManager.getInstance(f65513h.getApplicationContext()).isIMLogined()) {
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
                        bLCPRequest.f6413a = intExtra2;
                        long type = createNewMessage.getType();
                        bLCPRequest.f6414b = type;
                        if (intExtra2 == 3 && type == 55) {
                            bLCPRequest.f6414b = 185L;
                        }
                        bLCPRequest.f6415c = createNewMessage.getBody().getBytes();
                        bLCPRequest.f6417e = BLCPRequest.SendTimeoutSecond.TIMEOUT_30s;
                        long j = (bLCPRequest.f6413a * 1000000000000000L) + bLCPRequest.f6414b;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append((System.currentTimeMillis() + "").substring((System.currentTimeMillis() + "").length() - 6));
                        sb2.append(this.f65514a.incrementAndGet());
                        bLCPRequest.f6416d = j + (Long.valueOf(sb2.toString()).longValue() * 1000);
                        synchronized (f65511f) {
                            f65511f.put(Long.valueOf(bLCPRequest.f6416d), createNewMessage);
                            LogUtils.d("IMServiceImpl", "requestTaskManager msg Id:" + bLCPRequest.f6416d + ". msg :" + f65511f.keySet().toString());
                        }
                        if (intExtra == 50) {
                            new IMTrack.RequestBuilder(f65513h.getApplicationContext()).method("send").requestId("2").errorCode(50L).ext("" + bLCPRequest.f6416d).aliasId(501112L).build();
                        }
                        d.b.s.a.b.a.c(bLCPRequest, this.f65515b);
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
            if (IMSDK.getInstance(f65513h.getApplicationContext()).handleOnStart(intent)) {
                return;
            }
            IMConnection.getInstance(f65513h).disconnectedByPeer();
        } catch (Exception e3) {
            LogUtils.e(LogUtils.TAG, "onStartCommand", e3);
            if (intent.hasExtra(Constants.EXTRA_LISTENER_ID) && ((intent.hasExtra("method") && intent.getIntExtra("method", -1) == 52) || intent.hasExtra(Constants.EXTRA_DISCONNECT))) {
                IMListener removeListener = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                if (removeListener instanceof ILoginListener) {
                    ((ILoginListener) removeListener).onLogoutResult(6, "IMService onStartCommand Exception", BIMManager.getLoginType(f65513h));
                }
            } else if (intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            }
        }
    }

    public final void h() {
        int[] iArr = {96, Constants.METHOD_MEDIA_NOTIFY, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 231};
        for (int i = 0; i < 5; i++) {
            i(2, Integer.valueOf(iArr[i]).intValue());
        }
        i(3, 196);
    }

    public final void i(int i, int i2) {
        d.b.s.a.b.d.a aVar = new d.b.s.a.b.d.a();
        aVar.f6413a = i;
        aVar.f6414b = i2;
        d.b.s.a.b.a.c(aVar, this.f65515b);
    }
}
