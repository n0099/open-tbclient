package d.a.s;

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
    public static Handler f68193c;

    /* renamed from: d  reason: collision with root package name */
    public static final HandlerThread f68194d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f68195e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile Map<Long, Message> f68196f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile Map<Long, MessageUbc> f68197g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f68198h;

    /* renamed from: i  reason: collision with root package name */
    public static Context f68199i;

    /* renamed from: a  reason: collision with root package name */
    public AtomicInteger f68200a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    public d.a.t.a.b.d.b f68201b = new b();

    /* renamed from: d.a.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1861a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f68202e;

        public RunnableC1861a(Intent intent) {
            this.f68202e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.j(this.f68202e);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.t.a.b.d.b {
        public b() {
        }

        @Override // d.a.t.a.b.d.b
        public void onResponse(int i2, String str, long j, long j2, long j3, byte[] bArr) {
            MessageUbc messageUbc;
            LogUtils.i("IMServiceImpl", "IMService err :" + i2 + ", methodId :" + j2 + ", data :" + bArr.length + ", Response :" + new String(bArr));
            int i3 = (j2 > 231L ? 1 : (j2 == 231L ? 0 : -1));
            if (i3 == 0) {
                NotifyMessageHandler.handleRtcReport(ProgressInfo.JSON_KEY_BEGIN, new String(bArr));
            }
            if (i2 != 0) {
                synchronized (a.f68196f) {
                    if (a.f68196f != null && a.f68196f.containsKey(Long.valueOf(j3))) {
                        ((Message) a.f68196f.get(Long.valueOf(j3))).handleMessageResult(a.f68199i, null, i2, str);
                        a.f68196f.remove(Long.valueOf(j3));
                    }
                }
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                int optInt = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE, -1);
                String optString = jSONObject.optString("msg", "");
                if (a.this.i((int) j2)) {
                    synchronized (a.f68196f) {
                        messageUbc = (MessageUbc) a.f68197g.get(Long.valueOf(j3));
                        a.f68197g.remove(Long.valueOf(j3));
                    }
                    if (messageUbc != null) {
                        d.a.r.a.a.d().f(messageUbc.generateUBCData(String.valueOf(optInt), optString), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
                    }
                }
                if (j2 == 96) {
                    NotifyMessageHandler.handleDeliverMessage(a.f68199i.getApplicationContext(), jSONObject);
                } else if (j2 == 196) {
                    NotifyMessageHandler.handleMcastMessage(a.f68199i.getApplicationContext(), jSONObject);
                } else if (j2 == 197) {
                    NotifyMessageHandler.handleConfigMessage(a.f68199i.getApplicationContext(), jSONObject);
                } else if (j2 == 226) {
                    NotifyMessageHandler.handleMediaNotifyMessage(a.f68199i.getApplicationContext(), jSONObject);
                } else if (i3 == 0) {
                    NotifyMessageHandler.handleRtcNotifyMessage(a.f68199i, jSONObject);
                } else {
                    LogUtils.d("IMServiceImpl", "key :" + j3 + "response :" + jSONObject.toString());
                    synchronized (a.f68196f) {
                        if (a.f68196f != null && a.f68196f.containsKey(Long.valueOf(j3))) {
                            ((Message) a.f68196f.get(Long.valueOf(j3))).handleMessageResult(a.f68199i, jSONObject, optInt, optString);
                            a.f68196f.remove(Long.valueOf(j3));
                        }
                    }
                }
            } catch (JSONException e2) {
                LogUtils.e("IMServiceImpl", "handle response e :", e2);
                synchronized (a.f68196f) {
                    if (a.f68196f != null && a.f68196f.containsKey(Long.valueOf(j3))) {
                        ((Message) a.f68196f.get(Long.valueOf(j3))).handleMessageResult(a.f68199i, null, -1, "");
                        a.f68196f.remove(Long.valueOf(j3));
                    }
                }
            }
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("IMServiceImpl HandlerThread");
        f68194d = handlerThread;
        handlerThread.start();
        f68193c = new Handler(f68194d.getLooper());
        f68195e = true;
        f68196f = new LinkedHashMap();
        f68197g = new LinkedHashMap();
    }

    public a() {
        h();
    }

    public static void e(Context context) {
        synchronized (f68196f) {
            if (f68196f == null) {
                return;
            }
            for (Message message : f68196f.values()) {
                if (message != null) {
                    message.handleMessageResult(context, null, -1, "");
                }
            }
        }
    }

    public static a g(Context context) {
        if (f68198h == null) {
            synchronized (a.class) {
                if (f68198h == null) {
                    f68199i = context.getApplicationContext();
                    f68198h = new a();
                }
            }
        }
        return f68198h;
    }

    public void f(Context context, Intent intent) {
        LogUtils.e("IMServiceImpl", "IMServiceImpl.getInstance(context).enqueueWork");
        TaskManager.getInstance(context).submitForNetWork(new RunnableC1861a(intent));
    }

    public final void h() {
        try {
            LogUtils.d("IMServiceImpl", "isSmallFlow :" + f68195e);
            IMManager.init(f68199i.getApplicationContext(), IMConfigInternal.getInstance().getProductLine(f68199i.getApplicationContext()));
            if (f68195e) {
                k();
            } else if (!IMSDK.getInstance(f68199i.getApplicationContext()).init()) {
                IMConnection.getInstance(f68199i).disconnectedByPeer();
            }
        } catch (Exception unused) {
        }
    }

    public final boolean i(int i2) {
        return i2 == 55;
    }

    public void j(@NonNull Intent intent) {
        LogUtils.d("IMServiceImpl", "-- onHandleWork -- " + intent + ", isSmallFlow :" + f68195e);
        if (intent == null) {
            intent = new Intent();
            LogUtils.i("IMServiceImpl", "--- onStart by null intent!");
        }
        if (f68195e) {
            try {
                int intExtra = intent.getIntExtra("method", -1);
                int intExtra2 = intent.getIntExtra("service_id", -1);
                if (intExtra != -1 && intExtra2 != -1) {
                    if (intExtra == 50 || intExtra == 201) {
                        k();
                    }
                    Message createNewMessage = MessageFactory.getInstance().createNewMessage(f68199i, intExtra, intent);
                    if (createNewMessage != null) {
                        if (intExtra == 50) {
                            boolean z = false;
                            synchronized (f68196f) {
                                LogUtils.d("IMServiceImpl", "cur method :50, cur msgList :" + f68196f.keySet());
                                Iterator<Long> it = f68196f.keySet().iterator();
                                while (it.hasNext()) {
                                    if (it.next().longValue() % 100 == 50) {
                                        z = true;
                                    }
                                }
                            }
                            if (z || LoginManager.getInstance(f68199i.getApplicationContext()).isIMLogined()) {
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
                        bLCPRequest.f6365a = intExtra2;
                        long type = createNewMessage.getType();
                        bLCPRequest.f6366b = type;
                        if (intExtra2 == 3 && type == 55) {
                            bLCPRequest.f6366b = 185L;
                        }
                        bLCPRequest.f6367c = createNewMessage.getBody().getBytes();
                        bLCPRequest.f6369e = BLCPRequest.SendTimeoutSecond.TIMEOUT_30s;
                        long j = (bLCPRequest.f6365a * 1000000000000000L) + bLCPRequest.f6366b;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append((System.currentTimeMillis() + "").substring((System.currentTimeMillis() + "").length() - 6));
                        sb2.append(this.f68200a.incrementAndGet());
                        bLCPRequest.f6368d = j + (Long.valueOf(sb2.toString()).longValue() * 1000);
                        synchronized (f68196f) {
                            if (i((int) bLCPRequest.f6366b) && (createNewMessage instanceof IMSendMsg)) {
                                f68197g.put(Long.valueOf(bLCPRequest.f6368d), new MessageUbc(f68199i, ((IMSendMsg) createNewMessage).getChatMsg(), UBCConstants.BCSEND_UBCID));
                            }
                            f68196f.put(Long.valueOf(bLCPRequest.f6368d), createNewMessage);
                            LogUtils.d("IMServiceImpl", "requestTaskManager msg Id:" + bLCPRequest.f6368d + ". msg :" + f68196f.keySet().toString());
                        }
                        if (intExtra == 50) {
                            new IMTrack.RequestBuilder(f68199i.getApplicationContext()).method("send").requestId("2").errorCode(50L).ext("" + bLCPRequest.f6368d).aliasId(501112L).build();
                        }
                        d.a.t.a.b.a.c(bLCPRequest, this.f68201b);
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
            if (IMSDK.getInstance(f68199i.getApplicationContext()).handleOnStart(intent)) {
                return;
            }
            IMConnection.getInstance(f68199i).disconnectedByPeer();
        } catch (Exception e3) {
            LogUtils.e(LogUtils.TAG, "onStartCommand", e3);
            if (intent.hasExtra(Constants.EXTRA_LISTENER_ID) && ((intent.hasExtra("method") && intent.getIntExtra("method", -1) == 52) || intent.hasExtra(Constants.EXTRA_DISCONNECT))) {
                IMListener removeListener = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                if (removeListener instanceof ILoginListener) {
                    ((ILoginListener) removeListener).onLogoutResult(6, "IMService onStartCommand Exception", BIMManager.getLoginType(f68199i));
                }
            } else if (intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            }
        }
    }

    public final void k() {
        int[] iArr = {96, Constants.METHOD_MEDIA_NOTIFY, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 231};
        for (int i2 = 0; i2 < 5; i2++) {
            l(2, Integer.valueOf(iArr[i2]).intValue());
        }
        l(3, 196);
    }

    public final void l(int i2, int i3) {
        d.a.t.a.b.d.a aVar = new d.a.t.a.b.d.a();
        aVar.f6365a = i2;
        aVar.f6366b = i3;
        d.a.t.a.b.a.c(aVar, this.f68201b);
    }
}
