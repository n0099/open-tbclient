package com.example.crash_report_plugin;

import android.support.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.u.a;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes19.dex */
public class CrashReportPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "crash_report_plugin").setMethodCallHandler(new CrashReportPlugin());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("reportCrash")) {
            HashMap hashMap = (HashMap) methodCall.argument("custom");
            ArrayList arrayList = (ArrayList) methodCall.argument("stackframes");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("TbAndroidFlutter page:" + ((String) methodCall.argument("page")) + "\n  message:" + ((String) methodCall.argument("message")) + "\n");
            if (hashMap != null) {
                stringBuffer.append("custom:" + hashMap.toString() + "\n");
            }
            BdLog.e(stringBuffer.toString());
            Exception exc = new Exception(stringBuffer.toString());
            if (arrayList != null && arrayList.size() > 0) {
                StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    StackTraceElement stackTraceElement = new StackTraceElement("TbAndroidFlutter", (String) arrayList.get(i), "", 0);
                    stackTraceElementArr[i] = stackTraceElement;
                    BdLog.e(stackTraceElement.toString());
                }
                exc.setStackTrace(stackTraceElementArr);
            }
            a.getInstance().uploadException(exc);
            result.success(true);
            return;
        }
        result.notImplemented();
    }
}
