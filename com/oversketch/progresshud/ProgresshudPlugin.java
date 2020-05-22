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
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes6.dex */
public final class ProgresshudPlugin implements MethodChannel.MethodCallHandler {
    public static final Companion Companion = new Companion(null);

    public static final void registerWith(PluginRegistry.Registrar registrar) {
        Companion.registerWith(registrar);
    }

    @h
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        public final void registerWith(PluginRegistry.Registrar registrar) {
            q.m(registrar, "registrar");
            new MethodChannel(registrar.messenger(), "progresshud").setMethodCallHandler(new ProgresshudPlugin());
            ProgresshudPluginKt.setMaskType(SVProgressHUD.SVProgressHUDMaskType.None);
        }
    }

    private final String getAndroidNameFromIos(String str) {
        return str;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
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
                String valueOf = String.valueOf(methodCall.argument("image"));
                String valueOf2 = String.valueOf(methodCall.argument("text"));
                String androidNameFromIos = getAndroidNameFromIos(valueOf);
                g jo = g.jo();
                q.l((Object) jo, "BdResources.getInstance()");
                Resources resources = jo.getResources();
                BdBaseApplication inst4 = BdBaseApplication.getInst();
                q.l((Object) inst4, "BdBaseApplication.getInst()");
                int identifier = resources.getIdentifier(androidNameFromIos, "drawable", inst4.getPackageName());
                activity4 = ProgresshudPluginKt.mCurrentActivity;
                BdToast.a((Context) activity4, (CharSequence) valueOf2, identifier, false).aSY();
            }
        } else if (q.l((Object) methodCall.method, (Object) "showWithStatus")) {
            ProgresshudPluginKt.getDialog().showWithStatus(methodCall.arguments.toString(), ProgresshudPluginKt.getMaskType());
        } else if (q.l((Object) methodCall.method, (Object) "showInfoWithStatus")) {
            ProgresshudPluginKt.getDialog().showInfoWithStatus(methodCall.arguments.toString(), ProgresshudPluginKt.getMaskType());
        } else if (q.l((Object) methodCall.method, (Object) "showErrorWithStatus")) {
            activity3 = ProgresshudPluginKt.mCurrentActivity;
            l.showToast(activity3, methodCall.arguments.toString());
        } else if (q.l((Object) methodCall.method, (Object) "showSuccessWithStatus")) {
            activity2 = ProgresshudPluginKt.mCurrentActivity;
            l.showToast(activity2, methodCall.arguments.toString());
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
