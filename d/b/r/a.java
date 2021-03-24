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
    public static Handler f64549c;

    /* renamed from: d  reason: collision with root package name */
    public static final HandlerThread f64550d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f64551e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile Map<Long, Message> f64552f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f64553g;

    /* renamed from: h  reason: collision with root package name */
    public static Context f64554h;

    /* renamed from: a  reason: collision with root package name */
    public AtomicInteger f64555a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    public d.b.s.a.b.d.b f64556b = new b(this);

    /* renamed from: d.b.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1763a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f64557e;

        public RunnableC1763a(Intent intent) {
            this.f64557e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g(this.f64557e);
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
                synchronized (a.f64552f) {
                    if (a.f64552f != null && a.f64552f.containsKey(Long.valueOf(j3))) {
                        ((Message) a.f64552f.get(Long.valueOf(j3))).handleMessageResult(a.f64554h, null, i, str);
                        a.f64552f.remove(Long.valueOf(j3));
                    }
                }
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                int optInt = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE, -1);
                String optString = jSONObject.optString("msg", "");
                if (j2 == 96) {
                    NotifyMessageHandler.handleDeliverMessage(a.f64554h.getApplicationContext(), jSONObject);
                } else if (j2 == 196) {
                    NotifyMessageHandler.handleMcastMessage(a.f64554h.getApplicationContext(), jSONObject);
                } else if (j2 == 197) {
                    NotifyMessageHandler.handleConfigMessage(a.f64554h.getApplicationContext(), jSONObject);
                } else if (j2 == 226) {
                    NotifyMessageHandler.handleMediaNotifyMessage(a.f64554h.getApplicationContext(), jSONObject);
                } else if (j2 == 231) {
                    NotifyMessageHandler.handleRtcNotifyMessage(a.f64554h, jSONObject);
                } else {
                    LogUtils.d("IMServiceImpl", "key :" + j3 + "response :" + jSONObject.toString());
                    synchronized (a.f64552f) {
                        if (a.f64552f != null && a.f64552f.containsKey(Long.valueOf(j3))) {
                            ((Message) a.f64552f.get(Long.valueOf(j3))).handleMessageResult(a.f64554h, jSONObject, optInt, optString);
                            a.f64552f.remove(Long.valueOf(j3));
                        }
                    }
                }
            } catch (JSONException e2) {
                LogUtils.e("IMServiceImpl", "handle response e :", e2);
                synchronized (a.f64552f) {
                    if (a.f64552f != null && a.f64552f.containsKey(Long.valueOf(j3))) {
                        ((Message) a.f64552f.get(Long.valueOf(j3))).handleMessageResult(a.f64554h, null, -1, "");
                        a.f64552f.remove(Long.valueOf(j3));
                    }
                }
            }
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("IMServiceImpl HandlerThread");
        f64550d = handlerThread;
        handlerThread.start();
        f64549c = new Handler(f64550d.getLooper());
        f64551e = true;
        f64552f = new LinkedHashMap();
    }

    public a() {
        f();
    }

    public static void c(Context context) {
        synchronized (f64552f) {
            if (f64552f == null) {
                return;
            }
            for (Message message : f64552f.values()) {
                if (message != null) {
                    message.handleMessageResult(context, null, -1, "");
                }
            }
        }
    }

    public static a e(Context context) {
        if (f64553g == null) {
            synchronized (a.class) {
                if (f64553g == null) {
                    f64554h = context.getApplicationContext();
                    f64553g = new a();
                }
            }
        }
        return f64553g;
    }

    public void d(Context context, Intent intent) {
        LogUtils.e("IMServiceImpl", "IMServiceImpl.getInstance(context).enqueueWork");
        TaskManager.getInstance(context).submitForNetWork(new RunnableC1763a(intent));
    }

    public final void f() {
        try {
            LogUtils.d("IMServiceImpl", "isSmallFlow :" + f64551e);
            IMManager.init(f64554h.getApplicationContext(), IMConfigInternal.getInstance().getProductLine(f64554h.getApplicationContext()));
            if (f64551e) {
                h();
            } else if (!IMSDK.getInstance(f64554h.getApplicationContext()).init()) {
                IMConnection.getInstance(f64554h).disconnectedByPeer();
            }
        } catch (Exception unused) {
        }
    }

    public void g(@NonNull Intent intent) {
        LogUtils.d("IMServiceImpl", "-- onHandleWork -- " + intent + ", isSmallFlow :" + f64551e);
        if (intent == null) {
            intent = new Intent();
            LogUtils.i("IMServiceImpl", "--- onStart by null intent!");
        }
        if (f64551e) {
            try {
                int intExtra = intent.getIntExtra("method", -1);
                int intExtra2 = intent.getIntExtra("service_id", -1);
                if (intExtra != -1 && intExtra2 != -1) {
                    if (intExtra == 50 || intExtra == 201) {
                        h();
                    }
                    Message createNewMessage = MessageFactory.getInstance().createNewMessage(f64554h, intExtra, intent);
                    if (createNewMessage != null) {
                        if (intExtra == 50) {
                            boolean z = false;
                            synchronized (f64552f) {
                                LogUtils.d("IMServiceImpl", "cur method :50, cur msgList :" + f64552f.keySet());
                                Iterator<Long> it = f64552f.keySet().iterator();
                                while (it.hasNext()) {
                                    if (it.next().longValue() % 100 == 50) {
                                        z = true;
                                    }
                                }
                            }
                            if (z || LoginManager.getInstance(f64554h.getApplicationContext()).isIMLogined()) {
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
                        bLCPRequest.f6377a = intExtra2;
                        long type = createNewMessage.getType();
                        bLCPRequest.f6378b = type;
                        if (intExtra2 == 3 && type == 55) {
                            bLCPRequest.f6378b = 185L;
                        }
                        bLCPRequest.f6379c = createNewMessage.getBody().getBytes();
                        bLCPRequest.f6381e = BLCPRequest.SendTimeoutSecond.TIMEOUT_30s;
                        long j = (bLCPRequest.f6377a * 1000000000000000L) + bLCPRequest.f6378b;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append((System.currentTimeMillis() + "").substring((System.currentTimeMillis() + "").length() - 6));
                        sb2.append(this.f64555a.incrementAndGet());
                        bLCPRequest.f6380d = j + (Long.valueOf(sb2.toString()).longValue() * 1000);
                        synchronized (f64552f) {
                            f64552f.put(Long.valueOf(bLCPRequest.f6380d), createNewMessage);
                            LogUtils.d("IMServiceImpl", "requestTaskManager msg Id:" + bLCPRequest.f6380d + ". msg :" + f64552f.keySet().toString());
                        }
                        if (intExtra == 50) {
                            new IMTrack.RequestBuilder(f64554h.getApplicationContext()).method("send").requestId("2").errorCode(50L).ext("" + bLCPRequest.f6380d).aliasId(501112L).build();
                        }
                        d.b.s.a.b.a.c(bLCPRequest, this.f64556b);
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
            if (IMSDK.getInstance(f64554h.getApplicationContext()).handleOnStart(intent)) {
                return;
            }
            IMConnection.getInstance(f64554h).disconnectedByPeer();
        } catch (Exception e3) {
            LogUtils.e(LogUtils.TAG, "onStartCommand", e3);
            if (intent.hasExtra(Constants.EXTRA_LISTENER_ID) && ((intent.hasExtra("method") && intent.getIntExtra("method", -1) == 52) || intent.hasExtra(Constants.EXTRA_DISCONNECT))) {
                IMListener removeListener = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                if (removeListener instanceof ILoginListener) {
                    ((ILoginListener) removeListener).onLogoutResult(6, "IMService onStartCommand Exception", BIMManager.getLoginType(f64554h));
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
        aVar.f6377a = i;
        aVar.f6378b = i2;
        d.b.s.a.b.a.c(aVar, this.f64556b);
    }
}
