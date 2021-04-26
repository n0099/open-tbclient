package d.a.r;

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
    public static Handler f63829c;

    /* renamed from: d  reason: collision with root package name */
    public static final HandlerThread f63830d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f63831e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile Map<Long, Message> f63832f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f63833g;

    /* renamed from: h  reason: collision with root package name */
    public static Context f63834h;

    /* renamed from: a  reason: collision with root package name */
    public AtomicInteger f63835a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    public d.a.s.a.b.d.b f63836b = new b(this);

    /* renamed from: d.a.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1733a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f63837e;

        public RunnableC1733a(Intent intent) {
            this.f63837e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g(this.f63837e);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.s.a.b.d.b {
        public b(a aVar) {
        }

        @Override // d.a.s.a.b.d.b
        public void onResponse(int i2, String str, long j, long j2, long j3, byte[] bArr) {
            LogUtils.i("IMServiceImpl", "IMService err :" + i2 + ", methodId :" + j2 + ", data :" + bArr.length + ", Response :" + new String(bArr));
            if (i2 != 0) {
                synchronized (a.f63832f) {
                    if (a.f63832f != null && a.f63832f.containsKey(Long.valueOf(j3))) {
                        ((Message) a.f63832f.get(Long.valueOf(j3))).handleMessageResult(a.f63834h, null, i2, str);
                        a.f63832f.remove(Long.valueOf(j3));
                    }
                }
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                int optInt = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE, -1);
                String optString = jSONObject.optString("msg", "");
                if (j2 == 96) {
                    NotifyMessageHandler.handleDeliverMessage(a.f63834h.getApplicationContext(), jSONObject);
                } else if (j2 == 196) {
                    NotifyMessageHandler.handleMcastMessage(a.f63834h.getApplicationContext(), jSONObject);
                } else if (j2 == 197) {
                    NotifyMessageHandler.handleConfigMessage(a.f63834h.getApplicationContext(), jSONObject);
                } else if (j2 == 226) {
                    NotifyMessageHandler.handleMediaNotifyMessage(a.f63834h.getApplicationContext(), jSONObject);
                } else if (j2 == 231) {
                    NotifyMessageHandler.handleRtcNotifyMessage(a.f63834h, jSONObject);
                } else {
                    LogUtils.d("IMServiceImpl", "key :" + j3 + "response :" + jSONObject.toString());
                    synchronized (a.f63832f) {
                        if (a.f63832f != null && a.f63832f.containsKey(Long.valueOf(j3))) {
                            ((Message) a.f63832f.get(Long.valueOf(j3))).handleMessageResult(a.f63834h, jSONObject, optInt, optString);
                            a.f63832f.remove(Long.valueOf(j3));
                        }
                    }
                }
            } catch (JSONException e2) {
                LogUtils.e("IMServiceImpl", "handle response e :", e2);
                synchronized (a.f63832f) {
                    if (a.f63832f != null && a.f63832f.containsKey(Long.valueOf(j3))) {
                        ((Message) a.f63832f.get(Long.valueOf(j3))).handleMessageResult(a.f63834h, null, -1, "");
                        a.f63832f.remove(Long.valueOf(j3));
                    }
                }
            }
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("IMServiceImpl HandlerThread");
        f63830d = handlerThread;
        handlerThread.start();
        f63829c = new Handler(f63830d.getLooper());
        f63831e = true;
        f63832f = new LinkedHashMap();
    }

    public a() {
        f();
    }

    public static void c(Context context) {
        synchronized (f63832f) {
            if (f63832f == null) {
                return;
            }
            for (Message message : f63832f.values()) {
                if (message != null) {
                    message.handleMessageResult(context, null, -1, "");
                }
            }
        }
    }

    public static a e(Context context) {
        if (f63833g == null) {
            synchronized (a.class) {
                if (f63833g == null) {
                    f63834h = context.getApplicationContext();
                    f63833g = new a();
                }
            }
        }
        return f63833g;
    }

    public void d(Context context, Intent intent) {
        LogUtils.e("IMServiceImpl", "IMServiceImpl.getInstance(context).enqueueWork");
        TaskManager.getInstance(context).submitForNetWork(new RunnableC1733a(intent));
    }

    public final void f() {
        try {
            LogUtils.d("IMServiceImpl", "isSmallFlow :" + f63831e);
            IMManager.init(f63834h.getApplicationContext(), IMConfigInternal.getInstance().getProductLine(f63834h.getApplicationContext()));
            if (f63831e) {
                h();
            } else if (!IMSDK.getInstance(f63834h.getApplicationContext()).init()) {
                IMConnection.getInstance(f63834h).disconnectedByPeer();
            }
        } catch (Exception unused) {
        }
    }

    public void g(@NonNull Intent intent) {
        LogUtils.d("IMServiceImpl", "-- onHandleWork -- " + intent + ", isSmallFlow :" + f63831e);
        if (intent == null) {
            intent = new Intent();
            LogUtils.i("IMServiceImpl", "--- onStart by null intent!");
        }
        if (f63831e) {
            try {
                int intExtra = intent.getIntExtra("method", -1);
                int intExtra2 = intent.getIntExtra("service_id", -1);
                if (intExtra != -1 && intExtra2 != -1) {
                    if (intExtra == 50 || intExtra == 201) {
                        h();
                    }
                    Message createNewMessage = MessageFactory.getInstance().createNewMessage(f63834h, intExtra, intent);
                    if (createNewMessage != null) {
                        if (intExtra == 50) {
                            boolean z = false;
                            synchronized (f63832f) {
                                LogUtils.d("IMServiceImpl", "cur method :50, cur msgList :" + f63832f.keySet());
                                Iterator<Long> it = f63832f.keySet().iterator();
                                while (it.hasNext()) {
                                    if (it.next().longValue() % 100 == 50) {
                                        z = true;
                                    }
                                }
                            }
                            if (z || LoginManager.getInstance(f63834h.getApplicationContext()).isIMLogined()) {
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
                        bLCPRequest.f6598a = intExtra2;
                        long type = createNewMessage.getType();
                        bLCPRequest.f6599b = type;
                        if (intExtra2 == 3 && type == 55) {
                            bLCPRequest.f6599b = 185L;
                        }
                        bLCPRequest.f6600c = createNewMessage.getBody().getBytes();
                        bLCPRequest.f6602e = BLCPRequest.SendTimeoutSecond.TIMEOUT_30s;
                        long j = (bLCPRequest.f6598a * 1000000000000000L) + bLCPRequest.f6599b;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append((System.currentTimeMillis() + "").substring((System.currentTimeMillis() + "").length() - 6));
                        sb2.append(this.f63835a.incrementAndGet());
                        bLCPRequest.f6601d = j + (Long.valueOf(sb2.toString()).longValue() * 1000);
                        synchronized (f63832f) {
                            f63832f.put(Long.valueOf(bLCPRequest.f6601d), createNewMessage);
                            LogUtils.d("IMServiceImpl", "requestTaskManager msg Id:" + bLCPRequest.f6601d + ". msg :" + f63832f.keySet().toString());
                        }
                        if (intExtra == 50) {
                            new IMTrack.RequestBuilder(f63834h.getApplicationContext()).method("send").requestId("2").errorCode(50L).ext("" + bLCPRequest.f6601d).aliasId(501112L).build();
                        }
                        d.a.s.a.b.a.c(bLCPRequest, this.f63836b);
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
            if (IMSDK.getInstance(f63834h.getApplicationContext()).handleOnStart(intent)) {
                return;
            }
            IMConnection.getInstance(f63834h).disconnectedByPeer();
        } catch (Exception e3) {
            LogUtils.e(LogUtils.TAG, "onStartCommand", e3);
            if (intent.hasExtra(Constants.EXTRA_LISTENER_ID) && ((intent.hasExtra("method") && intent.getIntExtra("method", -1) == 52) || intent.hasExtra(Constants.EXTRA_DISCONNECT))) {
                IMListener removeListener = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                if (removeListener instanceof ILoginListener) {
                    ((ILoginListener) removeListener).onLogoutResult(6, "IMService onStartCommand Exception", BIMManager.getLoginType(f63834h));
                }
            } else if (intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            }
        }
    }

    public final void h() {
        int[] iArr = {96, Constants.METHOD_MEDIA_NOTIFY, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 231};
        for (int i2 = 0; i2 < 5; i2++) {
            i(2, Integer.valueOf(iArr[i2]).intValue());
        }
        i(3, 196);
    }

    public final void i(int i2, int i3) {
        d.a.s.a.b.d.a aVar = new d.a.s.a.b.d.a();
        aVar.f6598a = i2;
        aVar.f6599b = i3;
        d.a.s.a.b.a.c(aVar, this.f63836b);
    }
}
