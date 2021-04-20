package d.b.q;

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
    public static Handler f65244c;

    /* renamed from: d  reason: collision with root package name */
    public static final HandlerThread f65245d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f65246e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile Map<Long, Message> f65247f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f65248g;

    /* renamed from: h  reason: collision with root package name */
    public static Context f65249h;

    /* renamed from: a  reason: collision with root package name */
    public AtomicInteger f65250a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    public d.b.r.a.b.d.b f65251b = new b(this);

    /* renamed from: d.b.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1776a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f65252e;

        public RunnableC1776a(Intent intent) {
            this.f65252e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g(this.f65252e);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.r.a.b.d.b {
        public b(a aVar) {
        }

        @Override // d.b.r.a.b.d.b
        public void onResponse(int i, String str, long j, long j2, long j3, byte[] bArr) {
            LogUtils.i("IMServiceImpl", "IMService err :" + i + ", methodId :" + j2 + ", data :" + bArr.length + ", Response :" + new String(bArr));
            if (i != 0) {
                synchronized (a.f65247f) {
                    if (a.f65247f != null && a.f65247f.containsKey(Long.valueOf(j3))) {
                        ((Message) a.f65247f.get(Long.valueOf(j3))).handleMessageResult(a.f65249h, null, i, str);
                        a.f65247f.remove(Long.valueOf(j3));
                    }
                }
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                int optInt = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE, -1);
                String optString = jSONObject.optString("msg", "");
                if (j2 == 96) {
                    NotifyMessageHandler.handleDeliverMessage(a.f65249h.getApplicationContext(), jSONObject);
                } else if (j2 == 196) {
                    NotifyMessageHandler.handleMcastMessage(a.f65249h.getApplicationContext(), jSONObject);
                } else if (j2 == 197) {
                    NotifyMessageHandler.handleConfigMessage(a.f65249h.getApplicationContext(), jSONObject);
                } else if (j2 == 226) {
                    NotifyMessageHandler.handleMediaNotifyMessage(a.f65249h.getApplicationContext(), jSONObject);
                } else if (j2 == 231) {
                    NotifyMessageHandler.handleRtcNotifyMessage(a.f65249h, jSONObject);
                } else {
                    LogUtils.d("IMServiceImpl", "key :" + j3 + "response :" + jSONObject.toString());
                    synchronized (a.f65247f) {
                        if (a.f65247f != null && a.f65247f.containsKey(Long.valueOf(j3))) {
                            ((Message) a.f65247f.get(Long.valueOf(j3))).handleMessageResult(a.f65249h, jSONObject, optInt, optString);
                            a.f65247f.remove(Long.valueOf(j3));
                        }
                    }
                }
            } catch (JSONException e2) {
                LogUtils.e("IMServiceImpl", "handle response e :", e2);
                synchronized (a.f65247f) {
                    if (a.f65247f != null && a.f65247f.containsKey(Long.valueOf(j3))) {
                        ((Message) a.f65247f.get(Long.valueOf(j3))).handleMessageResult(a.f65249h, null, -1, "");
                        a.f65247f.remove(Long.valueOf(j3));
                    }
                }
            }
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("IMServiceImpl HandlerThread");
        f65245d = handlerThread;
        handlerThread.start();
        f65244c = new Handler(f65245d.getLooper());
        f65246e = true;
        f65247f = new LinkedHashMap();
    }

    public a() {
        f();
    }

    public static void c(Context context) {
        synchronized (f65247f) {
            if (f65247f == null) {
                return;
            }
            for (Message message : f65247f.values()) {
                if (message != null) {
                    message.handleMessageResult(context, null, -1, "");
                }
            }
        }
    }

    public static a e(Context context) {
        if (f65248g == null) {
            synchronized (a.class) {
                if (f65248g == null) {
                    f65249h = context.getApplicationContext();
                    f65248g = new a();
                }
            }
        }
        return f65248g;
    }

    public void d(Context context, Intent intent) {
        LogUtils.e("IMServiceImpl", "IMServiceImpl.getInstance(context).enqueueWork");
        TaskManager.getInstance(context).submitForNetWork(new RunnableC1776a(intent));
    }

    public final void f() {
        try {
            LogUtils.d("IMServiceImpl", "isSmallFlow :" + f65246e);
            IMManager.init(f65249h.getApplicationContext(), IMConfigInternal.getInstance().getProductLine(f65249h.getApplicationContext()));
            if (f65246e) {
                h();
            } else if (!IMSDK.getInstance(f65249h.getApplicationContext()).init()) {
                IMConnection.getInstance(f65249h).disconnectedByPeer();
            }
        } catch (Exception unused) {
        }
    }

    public void g(@NonNull Intent intent) {
        LogUtils.d("IMServiceImpl", "-- onHandleWork -- " + intent + ", isSmallFlow :" + f65246e);
        if (intent == null) {
            intent = new Intent();
            LogUtils.i("IMServiceImpl", "--- onStart by null intent!");
        }
        if (f65246e) {
            try {
                int intExtra = intent.getIntExtra("method", -1);
                int intExtra2 = intent.getIntExtra("service_id", -1);
                if (intExtra != -1 && intExtra2 != -1) {
                    if (intExtra == 50 || intExtra == 201) {
                        h();
                    }
                    Message createNewMessage = MessageFactory.getInstance().createNewMessage(f65249h, intExtra, intent);
                    if (createNewMessage != null) {
                        if (intExtra == 50) {
                            boolean z = false;
                            synchronized (f65247f) {
                                LogUtils.d("IMServiceImpl", "cur method :50, cur msgList :" + f65247f.keySet());
                                Iterator<Long> it = f65247f.keySet().iterator();
                                while (it.hasNext()) {
                                    if (it.next().longValue() % 100 == 50) {
                                        z = true;
                                    }
                                }
                            }
                            if (z || LoginManager.getInstance(f65249h.getApplicationContext()).isIMLogined()) {
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
                        sb2.append(this.f65250a.incrementAndGet());
                        bLCPRequest.f6416d = j + (Long.valueOf(sb2.toString()).longValue() * 1000);
                        synchronized (f65247f) {
                            f65247f.put(Long.valueOf(bLCPRequest.f6416d), createNewMessage);
                            LogUtils.d("IMServiceImpl", "requestTaskManager msg Id:" + bLCPRequest.f6416d + ". msg :" + f65247f.keySet().toString());
                        }
                        if (intExtra == 50) {
                            new IMTrack.RequestBuilder(f65249h.getApplicationContext()).method("send").requestId("2").errorCode(50L).ext("" + bLCPRequest.f6416d).aliasId(501112L).build();
                        }
                        d.b.r.a.b.a.c(bLCPRequest, this.f65251b);
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
            if (IMSDK.getInstance(f65249h.getApplicationContext()).handleOnStart(intent)) {
                return;
            }
            IMConnection.getInstance(f65249h).disconnectedByPeer();
        } catch (Exception e3) {
            LogUtils.e(LogUtils.TAG, "onStartCommand", e3);
            if (intent.hasExtra(Constants.EXTRA_LISTENER_ID) && ((intent.hasExtra("method") && intent.getIntExtra("method", -1) == 52) || intent.hasExtra(Constants.EXTRA_DISCONNECT))) {
                IMListener removeListener = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                if (removeListener instanceof ILoginListener) {
                    ((ILoginListener) removeListener).onLogoutResult(6, "IMService onStartCommand Exception", BIMManager.getLoginType(f65249h));
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
        d.b.r.a.b.d.a aVar = new d.b.r.a.b.d.a();
        aVar.f6413a = i;
        aVar.f6414b = i2;
        d.b.r.a.b.a.c(aVar, this.f65251b);
    }
}
