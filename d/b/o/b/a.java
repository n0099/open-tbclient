package d.b.o.b;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.searchbox.perfframe.PerfFrame;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.track.ui.TraceManager;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes2.dex */
public class a implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {

    /* renamed from: f  reason: collision with root package name */
    public static Activity f64887f;

    /* renamed from: g  reason: collision with root package name */
    public static final long f64888g = System.currentTimeMillis();

    /* renamed from: e  reason: collision with root package name */
    public MethodChannel f64889e;

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        f64887f = activityPluginBinding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "flutter_exception_perf_plugin");
        this.f64889e = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        f64887f = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        f64887f = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f64889e.setMethodCallHandler(null);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if (methodCall.method.equals("reportException")) {
            String str = (String) methodCall.argument("page");
            String str2 = (String) methodCall.argument("message");
            long longValue = ((Long) methodCall.argument("excTime")).longValue();
            String str3 = (String) methodCall.argument(Constant.KEY_BUSINESS);
            PerfFrame create = new PerfFrame.Builder().setNeedStaticperf(true).setNeedPageTrace(true).setNeedMainStackTrace(true).setNeedDynamicperf(true).create();
            if (create != null) {
                create.submitPerformanceData("2301", "flutter", longValue, f64888g, str2, str, str3);
                result.success(Boolean.TRUE);
                return;
            }
            result.success(Boolean.FALSE);
        } else if (methodCall.method.equals("reportPageTrace")) {
            String str4 = (String) methodCall.argument("page");
            String str5 = (String) methodCall.argument("event");
            ((Long) methodCall.argument(PmsConstant.Statistic.Key.REV_TIMESTAMP)).longValue();
            TraceManager.getInstance().saveTraceInfo(f64887f, null, str4, (String) methodCall.argument("tag"), "flutter", str5);
            result.success(Boolean.TRUE);
        } else {
            result.notImplemented();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        f64887f = activityPluginBinding.getActivity();
    }
}
