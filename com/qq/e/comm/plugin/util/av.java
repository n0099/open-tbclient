package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
public class av {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f12863a = e();

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f12864b = f();

    /* renamed from: com.qq.e.comm.plugin.util.av$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass1 implements com.tencent.turingfd.sdk.ams.au.s {
        AnonymousClass1() {
        }

        @Override // com.tencent.turingfd.sdk.ams.au.s
        public boolean a() {
            Boolean isAgreePrivacyStrategy = SDKStatus.getSDKVersionCode() >= 90 ? GlobalSetting.isAgreePrivacyStrategy() : null;
            return isAgreePrivacyStrategy != null ? isAgreePrivacyStrategy.booleanValue() : GDTADManager.getInstance().getSM().getInteger("turingPrivacy", 1) == 1;
        }
    }

    /* renamed from: com.qq.e.comm.plugin.util.av$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ai.a("update TuringID in %s: ", Thread.currentThread().getName());
            av.b();
        }
    }

    public static Pair<String, String> a() {
        return (Pair) gdtadv.getobjresult(217, 1, new Object[0]);
    }

    public static void a(Context context) {
        gdtadv.getVresult(218, 1, context);
    }

    public static void a(u uVar, String str) {
        gdtadv.getVresult(219, 1, uVar, str);
    }

    private static void a(com.tencent.turingfd.sdk.ams.au.r rVar) {
        gdtadv.getVresult(220, 1, rVar);
    }

    private static void a(String str) {
        gdtadv.getVresult(221, 1, str);
    }

    public static void a(JSONObject jSONObject, String str) {
        gdtadv.getVresult(222, 1, jSONObject, str);
    }

    public static void a(boolean z, JSONObject jSONObject, String str) {
        gdtadv.getVresult(223, 1, Boolean.valueOf(z), jSONObject, str);
    }

    static /* synthetic */ void b() {
        gdtadv.getVresult(224, 1, new Object[0]);
    }

    private static void b(String str) {
        gdtadv.getVresult(225, 1, str);
    }

    private static void c() {
        gdtadv.getVresult(Constants.METHOD_MEDIA_NOTIFY, 1, new Object[0]);
    }

    private static void d() {
        gdtadv.getVresult(227, 1, new Object[0]);
    }

    private static String e() {
        return (String) gdtadv.getobjresult(228, 1, new Object[0]);
    }

    private static String f() {
        return (String) gdtadv.getobjresult(229, 1, new Object[0]);
    }
}
