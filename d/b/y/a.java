package d.b.y;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.httpNet.NetWorkUtil;
import d.b.b.e.p.j;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: e  reason: collision with root package name */
    public static MethodChannel f64854e;

    /* renamed from: f  reason: collision with root package name */
    public static CustomMessageListener f64855f = new C1778a(2000994);

    /* renamed from: d.b.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1778a extends CustomMessageListener {
        public C1778a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                try {
                    j.z();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                a.f64854e.invokeMethod("setNetInfo", a.c());
            }
        }
    }

    public static HashMap c() {
        HashMap hashMap = new HashMap();
        hashMap.put("isNetWorkAvailable", Boolean.valueOf(j.z()));
        hashMap.put("netType", Integer.valueOf(j.I()));
        String netType = NetWorkUtil.getNetType();
        if (netType != null) {
            hashMap.put("getNetTypeString", netType);
        }
        return hashMap;
    }

    public static void d() {
        MessageManager.getInstance().registerListener(f64855f);
    }

    public final HashMap b(String str) throws Exception {
        String str2 = "hiphotos.baidu.com";
        HashMap hashMap = new HashMap();
        URL url = new URL(str);
        if (!TextUtils.isEmpty(str)) {
            try {
                String host = url.getHost();
                if (!TextUtils.isEmpty(host)) {
                    if (!host.contains("hiphotos.baidu.com")) {
                        str2 = host;
                    }
                    BDHttpDnsResult r = BDHttpDns.j(BdBaseApplication.getInst().getApplicationContext()).r(str2, true);
                    if (r != null) {
                        hashMap.put("dnsResolveType", g(r.d()));
                        hashMap.put("dnsResolveStatus", f(r.c()));
                        ArrayList<String> a2 = r.a();
                        if (a2 != null && a2.size() > 0) {
                            hashMap.put("dnsIpList", a2);
                            return hashMap;
                        }
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
        d.b.b.e.j.a.a b2 = d.b.b.e.j.a.a.b();
        if (b2 != null) {
            String a3 = b2.a(str);
            if (!TextUtils.isEmpty(a3)) {
                hashMap.put("dnsIp", a3);
            }
        }
        return hashMap;
    }

    public final void e() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        d.b.h0.l.a.q(applicationContext, "", UrlSchemaHelper.REAL_NAME_AUTH_URL + "&u=" + URLEncoder.encode(UrlSchemaHelper.FINISH_THIS_WEBVIEW), true, true, true, true, true, false);
    }

    public String f(BDHttpDnsResult.ResolveStatus resolveStatus) {
        return resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK ? "BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK" : resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsInputError ? "BDHttpDnsResult.ResolveStatus.BDHttpDnsInputError" : resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss ? "BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss" : resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve ? "BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve" : "";
    }

    public String g(BDHttpDnsResult.ResolveType resolveType) {
        return resolveType == BDHttpDnsResult.ResolveType.RESOLVE_NONE ? "BDHttpDnsResult.ResolveType.RESOLVE_NONE" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_NONEED ? "BDHttpDnsResult.ResolveType.RESOLVE_NONEED" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE ? "BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE ? "BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE ? "BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS ? "BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS" : "";
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "network_info");
        f64854e = methodChannel;
        methodChannel.setMethodCallHandler(new a());
        d();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("isNetWorkAvailable")) {
            result.success(Boolean.valueOf(j.z()));
        } else if (methodCall.method.equals("isNetworkAvailableForImmediately")) {
            result.success(Boolean.valueOf(j.A()));
        } else if (methodCall.method.equals("getNetInfo")) {
            result.success(c());
        } else if (methodCall.method.equals("getDnsIp")) {
            String str = (String) methodCall.argument("url");
            HashMap hashMap = new HashMap();
            try {
                hashMap = b(str);
            } catch (Exception unused) {
            }
            result.success(hashMap);
        } else if (methodCall.method.equals("jumpRealNameAuthWebActivity")) {
            e();
        }
    }
}
