package com.oversketch.progresshud;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.bigkoo.svprogresshud.SVProgressHUD;
import d.b.b.a.h;
import d.b.b.e.p.l;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/oversketch/progresshud/ProgresshudPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "io/flutter/plugin/common/MethodChannel$MethodCallHandler", "", "key", "getAndroidNameFromIos", "(Ljava/lang/String;)Ljava/lang/String;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "binding", "", "onAttachedToEngine", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;)V", "onDetachedFromEngine", "Lio/flutter/plugin/common/MethodCall;", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodChannel$Result;", "result", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "<init>", "()V", "Companion", "ovprogresshud_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes6.dex */
public final class ProgresshudPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public final String getAndroidNameFromIos(String str) {
        return str;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "progresshud").setMethodCallHandler(new ProgresshudPlugin());
        ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.None);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        Activity activity5;
        activity = ProgresshudPluginKt.mCurrentActivity;
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
        if (!Intrinsics.areEqual(activity, inst.getCurrentActivity())) {
            TbadkCoreApplication inst2 = TbadkCoreApplication.getInst();
            Intrinsics.checkExpressionValueIsNotNull(inst2, "TbadkCoreApplication.getInst()");
            ProgresshudPluginKt.mCurrentActivity = inst2.getCurrentActivity();
            TbadkCoreApplication inst3 = TbadkCoreApplication.getInst();
            Intrinsics.checkExpressionValueIsNotNull(inst3, "TbadkCoreApplication.getInst()");
            ProgresshudPluginKt.setDialog(new SVProgressHUD(inst3.getCurrentActivity()));
        }
        if (Intrinsics.areEqual(methodCall.method, "getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (Intrinsics.areEqual(methodCall.method, "show")) {
            ProgresshudPluginKt.getDialog().showWithMaskType(ProgresshudPluginKt.getMaskType());
        } else if (Intrinsics.areEqual(methodCall.method, "showWithImg")) {
            if (methodCall.hasArgument("image")) {
                String valueOf = String.valueOf(methodCall.argument("image"));
                String valueOf2 = String.valueOf(methodCall.argument("text"));
                boolean areEqual = Intrinsics.areEqual((String) methodCall.argument("isSvg"), "1");
                getAndroidNameFromIos(valueOf);
                h a2 = h.a();
                Intrinsics.checkExpressionValueIsNotNull(a2, "BdResources.getInstance()");
                Resources b2 = a2.b();
                BdBaseApplication inst4 = BdBaseApplication.getInst();
                Intrinsics.checkExpressionValueIsNotNull(inst4, "BdBaseApplication.getInst()");
                int identifier = b2.getIdentifier(valueOf, "drawable", inst4.getPackageName());
                activity5 = ProgresshudPluginKt.mCurrentActivity;
                BdToast.i(activity5, valueOf2, identifier, areEqual).q();
            }
        } else if (Intrinsics.areEqual(methodCall.method, "showWithStatus")) {
            ProgresshudPluginKt.getDialog().showWithStatus(methodCall.arguments.toString(), ProgresshudPluginKt.getMaskType());
        } else if (Intrinsics.areEqual(methodCall.method, "showInfoWithStatus")) {
            ProgresshudPluginKt.getDialog().showInfoWithStatus(methodCall.arguments.toString(), ProgresshudPluginKt.getMaskType());
        } else if (Intrinsics.areEqual(methodCall.method, "showErrorWithStatus")) {
            activity4 = ProgresshudPluginKt.mCurrentActivity;
            l.L(activity4, methodCall.arguments.toString());
        } else if (Intrinsics.areEqual(methodCall.method, "showSuccessWithStatus")) {
            activity3 = ProgresshudPluginKt.mCurrentActivity;
            l.L(activity3, methodCall.arguments.toString());
        } else if (Intrinsics.areEqual(methodCall.method, "showAttentionWithStatusForTime")) {
            String str = (String) methodCall.argument("status");
            Object argument = methodCall.argument("time");
            if (argument == null) {
                Intrinsics.throwNpe();
            }
            double doubleValue = ((Number) argument).doubleValue();
            activity2 = ProgresshudPluginKt.mCurrentActivity;
            l.M(activity2, str, ((int) doubleValue) * 1000);
        } else if (Intrinsics.areEqual(methodCall.method, "setDefaultMaskTypeNone")) {
            ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.None);
        } else if (Intrinsics.areEqual(methodCall.method, "setDefaultMaskTypeBlack")) {
            ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.Black);
        } else if (Intrinsics.areEqual(methodCall.method, "setDefaultMaskTypeClear")) {
            ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.Clear);
        } else if (Intrinsics.areEqual(methodCall.method, "setDefaultMaskTypeGradient")) {
            ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.Gradient);
        } else if (Intrinsics.areEqual(methodCall.method, "dismiss")) {
            ProgresshudPluginKt.getDialog().dismiss();
        } else if (Intrinsics.areEqual(methodCall.method, "isVisible")) {
            if (ProgresshudPluginKt.getDialog().isShowing()) {
                result.success(Boolean.TRUE);
            } else {
                result.success(Boolean.FALSE);
            }
        } else {
            result.notImplemented();
        }
    }
}
