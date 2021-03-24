package d.b.x;

import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.network_service_plugin.FlutterNetModelAuto;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.b.h0.g0.b.g;
import d.b.x.a;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, d> f64842e = new HashMap<>();

    /* loaded from: classes2.dex */
    public class a implements FlutterNetModelAuto.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f64843a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f64844b;

        public a(long j, MethodChannel.Result result) {
            this.f64843a = j;
            this.f64844b = result;
        }

        @Override // com.baidu.network_service_plugin.FlutterNetModelAuto.i
        public void a(String str, HashMap hashMap, MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
            b.this.f64842e.remove(str);
            if (hashMap != null) {
                hashMap.put("start_time", String.valueOf(this.f64843a));
            }
            this.f64844b.success(b.this.c(hashMap, null, mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString(), str));
        }
    }

    /* renamed from: d.b.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1777b implements a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f64846a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HashMap f64847b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f64848c;

        public C1777b(long j, HashMap hashMap, MethodChannel.Result result) {
            this.f64846a = j;
            this.f64847b = hashMap;
            this.f64848c = result;
        }

        @Override // d.b.x.a.d
        public void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2) {
            b.this.f64842e.remove(str2);
            if (hashMap != null) {
                hashMap.put("start_time", String.valueOf(this.f64846a));
            }
            HashMap c2 = b.this.c(hashMap, obj, i, str, str2);
            HashMap hashMap3 = this.f64847b;
            if (hashMap3 != null && (hashMap3.get("performance") instanceof Boolean) && ((Boolean) this.f64847b.get("performance")).booleanValue()) {
                HashMap hashMap4 = new HashMap();
                hashMap4.put("network", hashMap2);
                hashMap4.put("send_time", Long.valueOf(System.currentTimeMillis()));
                c2.put("performInfo", hashMap4);
            }
            this.f64848c.success(c2);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements FlutterNetModelAuto.j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FlutterNetModelAuto f64850a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f64851b;

        public c(FlutterNetModelAuto flutterNetModelAuto, MethodChannel.Result result) {
            this.f64850a = flutterNetModelAuto;
            this.f64851b = result;
        }

        @Override // com.baidu.network_service_plugin.FlutterNetModelAuto.j
        public void a(String str, HashMap hashMap, SocketResponsedMessage socketResponsedMessage, SocketMessage socketMessage, NetMessage netMessage) {
            b.this.f64842e.remove(str);
            this.f64850a.O(null);
            this.f64851b.success(b.this.c(hashMap, d.b.x.c.f(socketResponsedMessage), socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), str));
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        boolean a();
    }

    public final HashMap c(HashMap<String, String> hashMap, Object obj, int i, String str, String str2) {
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap3.put("errno", Integer.valueOf(i));
        hashMap3.put("errmsg", str);
        if (i == -1 && "cancle".equals(str)) {
            hashMap3.put("canceled", Boolean.TRUE);
        }
        hashMap2.put("requestInfo", hashMap);
        hashMap2.put("identifier", str2);
        hashMap2.put("errorInfo", hashMap3);
        if (i == 0) {
            hashMap2.put("data", obj);
        }
        return hashMap2;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "network_service_plugin").setMethodCallHandler(new b());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Object obj;
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
            return;
        }
        if (methodCall.method.equals("loadData")) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = (String) methodCall.argument("host");
            String str2 = (String) methodCall.argument("address");
            ((Integer) methodCall.argument("cmd")).intValue();
            HashMap hashMap = (HashMap) methodCall.argument("headers");
            HashMap<String, Object> hashMap2 = (HashMap) methodCall.argument("params");
            HashMap hashMap3 = (HashMap) methodCall.argument("fileParams");
            String str3 = (String) methodCall.argument("identifier");
            HashMap hashMap4 = (HashMap) methodCall.argument("extra");
            boolean booleanValue = methodCall.hasArgument("useProto") ? ((Boolean) methodCall.argument("useProto")).booleanValue() : false;
            if (str2.startsWith("/")) {
                str2 = str2.substring(1);
            }
            if (!str2.startsWith("http")) {
                str2 = str + "/" + str2;
            }
            hashMap2.put(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
            hashMap2.put("sdk_ver", TbadkCoreApplication.getInst().getSdk_ver());
            hashMap2.put("framework_ver", TbadkCoreApplication.getInst().getFramework_ver());
            hashMap2.put("swan_game_ver", TbadkCoreApplication.getInst().getSwan_game_ver());
            if (booleanValue) {
                BdUniqueId gen = BdUniqueId.gen();
                int a2 = d.b.x.c.a(str2);
                g d2 = d.b.x.c.d(a2, hashMap, hashMap2);
                if (a2 == 0 || d2 == null) {
                    return;
                }
                FlutterNetModelAuto c2 = d.b.x.c.c(str3, a2);
                c2.R(gen);
                c2.J(str2);
                c2.H(new a(currentTimeMillis, result));
                this.f64842e.put(str3, c2);
                try {
                    c2.A();
                    return;
                } catch (Exception e2) {
                    BdLog.e("netModel loadData exception" + e2.toString());
                    return;
                }
            }
            d.b.x.a aVar = new d.b.x.a(str3);
            aVar.q(str2);
            aVar.t(currentTimeMillis);
            aVar.p(new C1777b(currentTimeMillis, hashMap4, result));
            if (hashMap3 != null && (hashMap3 instanceof Map) && (obj = hashMap3.get("debugfile")) != null && (obj instanceof byte[])) {
                byte[] bArr = (byte[]) obj;
                if (bArr.length > 3145728) {
                    result.error("file is too big", "", null);
                    return;
                }
                hashMap2.put("debugfile", bArr);
                hashMap2.put("type", "android");
                aVar.r(true);
            }
            aVar.s(hashMap2);
            this.f64842e.put(str3, aVar);
            try {
                aVar.m();
            } catch (Exception e3) {
                BdLog.e("netModel loadData exception" + e3.toString());
            }
        } else if (methodCall.method.equals(QueryResponse.Options.CANCEL)) {
            List list = (List) methodCall.arguments;
            for (int i = 0; i < list.size(); i++) {
                Map map = (Map) list.get(i);
                String str4 = (String) map.get(RetrieveTaskManager.KEY);
                ((Integer) map.get("cmd")).intValue();
                d dVar = this.f64842e.get((String) map.get("identifier"));
                if (dVar != null) {
                    dVar.a();
                }
            }
        } else if (methodCall.method.equals("sendImMessage")) {
            int intValue = ((Integer) methodCall.argument("msgId")).intValue();
            String str5 = (String) methodCall.argument("identifier");
            FlutterNetModelAuto b2 = d.b.x.c.b(str5, intValue, (HashMap) methodCall.argument("params"));
            if (b2 == null) {
                result.error("-1", "ImNetModel init fail :" + intValue, null);
                return;
            }
            b2.O(new c(b2, result));
            b2.R(BdUniqueId.gen());
            this.f64842e.put(str5, b2);
            if (b2 != null) {
                try {
                    b2.A();
                } catch (Exception e4) {
                    BdLog.e("netModel loadData exception" + e4.toString());
                }
            }
        } else {
            result.notImplemented();
        }
    }
}
