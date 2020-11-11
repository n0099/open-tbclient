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
/* loaded from: classes19.dex */
public final class ProgresshudPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static final Companion Companion = new Companion(null);

    @h
    /* loaded from: classes19.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        q.n(flutterPluginBinding, "binding");
        new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "progresshud").setMethodCallHandler(new ProgresshudPlugin());
        ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.None);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        q.n(flutterPluginBinding, "binding");
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
        q.n(methodCall, NotificationCompat.CATEGORY_CALL);
        q.n(result, "result");
        activity = ProgresshudPluginKt.mCurrentActivity;
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        q.m(inst, "TbadkCoreApplication.getInst()");
        if (!q.l(activity, inst.getCurrentActivity())) {
            TbadkCoreApplication inst2 = TbadkCoreApplication.getInst();
            q.m(inst2, "TbadkCoreApplication.getInst()");
            ProgresshudPluginKt.mCurrentActivity = inst2.getCurrentActivity();
            TbadkCoreApplication inst3 = TbadkCoreApplication.getInst();
            q.m(inst3, "TbadkCoreApplication.getInst()");
            ProgresshudPluginKt.setDialog(new SVProgressHUD(inst3.getCurrentActivity()));
        }
        if (q.l(methodCall.method, "getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (q.l(methodCall.method, "show")) {
            ProgresshudPluginKt.getDialog().showWithMaskType(ProgresshudPluginKt.getMaskType());
        } else if (q.l(methodCall.method, "showWithImg")) {
            if (methodCall.hasArgument("image")) {
                String str = ((String) methodCall.argument("image")).toString();
                String str2 = ((String) methodCall.argument("text")).toString();
                String androidNameFromIos = getAndroidNameFromIos(str);
                g li = g.li();
                q.m(li, "BdResources.getInstance()");
                Resources resources = li.getResources();
                BdBaseApplication inst4 = BdBaseApplication.getInst();
                q.m(inst4, "BdBaseApplication.getInst()");
                int identifier = resources.getIdentifier(androidNameFromIos, "drawable", inst4.getPackageName());
                activity5 = ProgresshudPluginKt.mCurrentActivity;
                BdToast.a((Context) activity5, (CharSequence) str2, identifier, false).bpi();
            }
        } else if (q.l(methodCall.method, "showWithStatus")) {
            ProgresshudPluginKt.getDialog().showWithStatus(methodCall.arguments.toString(), ProgresshudPluginKt.getMaskType());
        } else if (q.l(methodCall.method, "showInfoWithStatus")) {
            ProgresshudPluginKt.getDialog().showInfoWithStatus(methodCall.arguments.toString(), ProgresshudPluginKt.getMaskType());
        } else if (q.l(methodCall.method, "showErrorWithStatus")) {
            activity4 = ProgresshudPluginKt.mCurrentActivity;
            l.showToast(activity4, methodCall.arguments.toString());
        } else if (q.l(methodCall.method, "showSuccessWithStatus")) {
            activity3 = ProgresshudPluginKt.mCurrentActivity;
            l.showToast(activity3, methodCall.arguments.toString());
        } else if (q.l(methodCall.method, "showAttentionWithStatusForTime")) {
            String str3 = (String) methodCall.argument("status");
            Object argument = methodCall.argument("time");
            if (argument == null) {
                q.eBP();
            }
            double doubleValue = ((Number) argument).doubleValue();
            activity2 = ProgresshudPluginKt.mCurrentActivity;
            l.showToast(activity2, str3, ((int) doubleValue) * 1000);
        } else if (q.l(methodCall.method, "setDefaultMaskTypeNone")) {
            ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.None);
        } else if (q.l(methodCall.method, "setDefaultMaskTypeBlack")) {
            ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.Black);
        } else if (q.l(methodCall.method, "setDefaultMaskTypeClear")) {
            ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.Clear);
        } else if (q.l(methodCall.method, "setDefaultMaskTypeGradient")) {
            ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.Gradient);
        } else if (q.l(methodCall.method, "dismiss")) {
            ProgresshudPluginKt.getDialog().dismiss();
        } else if (q.l(methodCall.method, "isVisible")) {
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
