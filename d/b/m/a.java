package d.b.m;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;
import java.util.Map;
/* loaded from: classes2.dex */
public class a implements PlatformView, MethodChannel.MethodCallHandler {

    /* renamed from: e  reason: collision with root package name */
    public final MethodChannel f64022e;

    /* renamed from: f  reason: collision with root package name */
    public View f64023f;

    /* renamed from: g  reason: collision with root package name */
    public int f64024g;

    /* renamed from: h  reason: collision with root package name */
    public String f64025h = "-1";
    public d.b.i0.z2.a i;

    @TargetApi(17)
    public a(Context context, BinaryMessenger binaryMessenger, int i, Map<String, Object> map) {
        a(context, map);
        this.f64024g = i;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "common_platform_view_" + this.f64025h);
        this.f64022e = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public final void a(Context context, Map<String, Object> map) {
        if (map == null || !(map instanceof Map)) {
            return;
        }
        Object obj = map.get("x");
        if (obj != null) {
            Double.valueOf(obj.toString()).doubleValue();
        }
        Object obj2 = map.get("y");
        if (obj2 != null) {
            Double.valueOf(obj2.toString()).doubleValue();
        }
        Object obj3 = map.get("width");
        if (obj3 != null) {
            Double.valueOf(obj3.toString()).doubleValue();
        }
        Object obj4 = map.get("height");
        if (obj4 != null) {
            Double.valueOf(obj4.toString()).doubleValue();
        }
        this.f64025h = String.valueOf(map.get("persistentViewId"));
        if ("BarSquare".equals(String.valueOf(map.get("nativeViewType")))) {
            d.b.i0.z2.a aVar = new d.b.i0.z2.a(TbadkApplication.getInst().getCurrentActivity(), ((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext());
            this.i = aVar;
            aVar.e();
            this.i.m();
            this.f64023f = this.i.f63441d.d();
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void dispose() {
        Log.d("CommonPlatformView", "dispose() called");
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public View getView() {
        return this.f64023f;
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onFlutterViewAttached(@NonNull View view) {
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onFlutterViewDetached() {
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onInputConnectionLocked() {
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onInputConnectionUnlocked() {
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (methodCall.method.equals("removePlatformView")) {
            b.a(this.f64024g);
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("selectForumCategory")) {
            String str = (String) methodCall.arguments;
            if (this.i != null && !TextUtils.isEmpty(str)) {
                this.i.l(str);
            }
            result.success(null);
        } else {
            result.notImplemented();
        }
    }
}
