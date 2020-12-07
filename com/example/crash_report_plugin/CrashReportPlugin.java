package com.example.crash_report_plugin;

import android.support.annotation.NonNull;
import com.baidu.searchbox.perfframe.PerfFrame;
import com.baidu.searchbox.track.ui.TraceManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u.a;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
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
            String str = (String) methodCall.argument("message");
            String str2 = (String) methodCall.argument("page");
            String str3 = (String) methodCall.argument("type");
            long longValue = ((Long) methodCall.argument("excTime")).longValue();
            HashMap hashMap = (HashMap) methodCall.argument("custom");
            ArrayList arrayList = (ArrayList) methodCall.argument("stackframes");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("flutterpage", str2);
                jSONObject.put("message", str);
                jSONObject.put("type", str3);
                if (hashMap != null) {
                    jSONObject.put("custom", hashMap.toString());
                }
                if (arrayList != null && arrayList.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i = 0; i < arrayList.size(); i++) {
                        stringBuffer.append(((String) arrayList.get(i)) + "\n");
                    }
                    jSONObject.put("fluttertrace", stringBuffer.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            long j = TbadkCoreApplication.getInst().processCreateTime;
            PerfFrame create = new PerfFrame.Builder().setNeedStaticperf(true).setNeedPageTrace(true).setNeedMainStackTrace(true).setNeedDynamicperf(true).create();
            if (create != null) {
                create.submitPerformanceData("2301", "flutter", longValue, j, str, str2, jSONObject.toString());
            }
            a.getInstance().uploadException(new Exception(jSONObject.toString()));
            result.success(true);
        } else if (methodCall.method.equals("reportPageTrace")) {
            String str4 = (String) methodCall.argument("tag");
            ((Long) methodCall.argument("timeStamp")).longValue();
            TraceManager.getInstance().saveTraceInfo(TbadkCoreApplication.getInst().getCurrentActivity(), null, (String) methodCall.argument("page"), str4, "flutter", (String) methodCall.argument("event"));
        } else {
            result.notImplemented();
        }
    }
}
