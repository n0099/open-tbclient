package com.oversketch.progresshud;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.bigkoo.svprogresshud.SVProgressHUD;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.NotImplementedError;
import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes4.dex */
public final class ProgresshudPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static final Companion Companion = new Companion(null);

    @h
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        q.m(flutterPluginBinding, "binding");
        new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "progresshud").setMethodCallHandler(new ProgresshudPlugin());
        ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.None);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        q.m(flutterPluginBinding, "binding");
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    private final String getAndroidNameFromIos(String str) {
        return str;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        Activity activity5;
        q.m(methodCall, NotificationCompat.CATEGORY_CALL);
        q.m(result, "result");
        activity = ProgresshudPluginKt.mCurrentActivity;
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        q.l((Object) inst, "TbadkCoreApplication.getInst()");
        if (!q.l(activity, inst.getCurrentActivity())) {
            TbadkCoreApplication inst2 = TbadkCoreApplication.getInst();
            q.l((Object) inst2, "TbadkCoreApplication.getInst()");
            ProgresshudPluginKt.mCurrentActivity = inst2.getCurrentActivity();
            TbadkCoreApplication inst3 = TbadkCoreApplication.getInst();
            q.l((Object) inst3, "TbadkCoreApplication.getInst()");
            ProgresshudPluginKt.setDialog(new SVProgressHUD(inst3.getCurrentActivity()));
        }
        if (q.l((Object) methodCall.method, (Object) "getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (q.l((Object) methodCall.method, (Object) "show")) {
            ProgresshudPluginKt.getDialog().showWithMaskType(ProgresshudPluginKt.getMaskType());
        } else if (q.l((Object) methodCall.method, (Object) "showWithImg")) {
            if (methodCall.hasArgument("image")) {
                String str = ((String) methodCall.argument("image")).toString();
                String str2 = ((String) methodCall.argument("text")).toString();
                String androidNameFromIos = getAndroidNameFromIos(str);
                g jE = g.jE();
                q.l((Object) jE, "BdResources.getInstance()");
                Resources resources = jE.getResources();
                BdBaseApplication inst4 = BdBaseApplication.getInst();
                q.l((Object) inst4, "BdBaseApplication.getInst()");
                int identifier = resources.getIdentifier(androidNameFromIos, "drawable", inst4.getPackageName());
                activity5 = ProgresshudPluginKt.mCurrentActivity;
                BdToast.a((Context) activity5, (CharSequence) str2, identifier, false).aYR();
            }
        } else if (q.l((Object) methodCall.method, (Object) "showWithStatus")) {
            ProgresshudPluginKt.getDialog().showWithStatus(methodCall.arguments.toString(), ProgresshudPluginKt.getMaskType());
        } else if (q.l((Object) methodCall.method, (Object) "showInfoWithStatus")) {
            ProgresshudPluginKt.getDialog().showInfoWithStatus(methodCall.arguments.toString(), ProgresshudPluginKt.getMaskType());
        } else if (q.l((Object) methodCall.method, (Object) "showErrorWithStatus")) {
            activity4 = ProgresshudPluginKt.mCurrentActivity;
            l.showToast(activity4, methodCall.arguments.toString());
        } else if (q.l((Object) methodCall.method, (Object) "showSuccessWithStatus")) {
            activity3 = ProgresshudPluginKt.mCurrentActivity;
            l.showToast(activity3, methodCall.arguments.toString());
        } else if (q.l((Object) methodCall.method, (Object) "showAttentionWithStatusForTime")) {
            String str3 = (String) methodCall.argument("status");
            Object argument = methodCall.argument("time");
            if (argument == null) {
                q.dUg();
            }
            double doubleValue = ((Number) argument).doubleValue();
            activity2 = ProgresshudPluginKt.mCurrentActivity;
            l.showToast(activity2, str3, ((int) doubleValue) * 1000);
        } else if (q.l((Object) methodCall.method, (Object) "setDefaultMaskTypeNone")) {
            ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.None);
        } else if (q.l((Object) methodCall.method, (Object) "setDefaultMaskTypeBlack")) {
            ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.Black);
        } else if (q.l((Object) methodCall.method, (Object) "setDefaultMaskTypeClear")) {
            ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.Clear);
        } else if (q.l((Object) methodCall.method, (Object) "setDefaultMaskTypeGradient")) {
            ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.Gradient);
        } else if (q.l((Object) methodCall.method, (Object) "dismiss")) {
            ProgresshudPluginKt.getDialog().dismiss();
        } else if (q.l((Object) methodCall.method, (Object) "isVisible")) {
            if (ProgresshudPluginKt.getDialog().isShowing()) {
                result.success(true);
            } else {
                result.success(false);
            }
        } else {
            result.notImplemented();
        }
    }
}
