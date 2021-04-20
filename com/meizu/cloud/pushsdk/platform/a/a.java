package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.heytap.mcssdk.mode.CommandMessage;
import com.meizu.cloud.pushsdk.b.a.c;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.io.File;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f38160a;

    /* renamed from: b  reason: collision with root package name */
    public String f38161b;

    /* renamed from: c  reason: collision with root package name */
    public String f38162c;

    /* renamed from: d  reason: collision with root package name */
    public String f38163d;

    /* renamed from: e  reason: collision with root package name */
    public String f38164e;

    /* renamed from: f  reason: collision with root package name */
    public String f38165f;

    /* renamed from: g  reason: collision with root package name */
    public String f38166g;

    /* renamed from: h  reason: collision with root package name */
    public String f38167h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;

    public a(Context context) {
        this.f38160a = "https://api-push.meizu.com/garcia/api/client/";
        this.f38161b = this.f38160a + "message/registerPush";
        this.f38162c = this.f38160a + "message/unRegisterPush";
        this.f38163d = this.f38160a + "advance/unRegisterPush";
        this.f38164e = this.f38160a + "message/getRegisterSwitch";
        this.f38165f = this.f38160a + "message/changeRegisterSwitch";
        this.f38166g = this.f38160a + "message/changeAllSwitch";
        this.f38167h = this.f38160a + "message/subscribeTags";
        this.i = this.f38160a + "message/unSubscribeTags";
        this.j = this.f38160a + "message/unSubAllTags";
        this.k = this.f38160a + "message/getSubTags";
        this.l = this.f38160a + "message/subscribeAlias";
        this.m = this.f38160a + "message/unSubscribeAlias";
        this.n = this.f38160a + "message/getSubAlias";
        this.o = this.f38160a + "log/upload";
        this.p = this.f38160a + "advance/changeRegisterSwitch";
        com.meizu.cloud.pushsdk.b.a.a();
        if (MzSystemUtils.isInternational() || MzSystemUtils.isIndiaLocal()) {
            this.f38160a = "https://api-push.in.meizu.com/garcia/api/client/";
            this.f38161b = this.f38160a + "message/registerPush";
            this.f38162c = this.f38160a + "message/unRegisterPush";
            this.f38163d = this.f38160a + "advance/unRegisterPush";
            this.f38164e = this.f38160a + "message/getRegisterSwitch";
            this.f38165f = this.f38160a + "message/changeRegisterSwitch";
            this.f38166g = this.f38160a + "message/changeAllSwitch";
            this.f38167h = this.f38160a + "message/subscribeTags";
            this.i = this.f38160a + "message/unSubscribeTags";
            this.j = this.f38160a + "message/unSubAllTags";
            this.k = this.f38160a + "message/getSubTags";
            this.l = this.f38160a + "message/subscribeAlias";
            this.m = this.f38160a + "message/unSubscribeAlias";
            this.n = this.f38160a + "message/getSubAlias";
            this.p = this.f38160a + "advance/changeRegisterSwitch";
        }
    }

    public c a(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.j.a.a.a.d("PushAPI", "register post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f38161b).a(linkedHashMap2).a().a();
    }

    public c a(String str, String str2, String str3, int i, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        linkedHashMap.put("msgType", String.valueOf(i));
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.j.a.a.a.d("PushAPI", this.f38165f + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f38165f).a(linkedHashMap2).a().a();
    }

    public c<String> a(String str, String str2, String str3, File file) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("msgId", str);
        linkedHashMap.put("deviceId", str2);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, "4a2ca769d79f4856bb3bd982d30de790"));
        if (!TextUtils.isEmpty(str3)) {
            linkedHashMap2.put("errorMsg", str3);
        }
        d.j.a.a.a.d("PushAPI", "uploadLogFile post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.c(this.o).a(linkedHashMap2).a(ZeusCrashHandler.LOG_FILE_NAME, file).a().a();
    }

    public c a(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        linkedHashMap.put(CommandMessage.TYPE_TAGS, str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.j.a.a.a.d("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f38167h).a(linkedHashMap2).a().a();
    }

    public c a(String str, String str2, String str3, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.j.a.a.a.d("PushAPI", this.f38166g + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f38166g).a(linkedHashMap2).a().a();
    }

    public c b(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.j.a.a.a.d("PushAPI", "unregister post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.a(this.f38162c).a(linkedHashMap2).a().a();
    }

    public c b(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        linkedHashMap.put(CommandMessage.TYPE_TAGS, str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.j.a.a.a.d("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.i).a(linkedHashMap2).a().a();
    }

    public c c(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.j.a.a.a.d("PushAPI", "checkPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.a(this.f38164e).a(linkedHashMap2).a().a();
    }

    public c c(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("appKey", str2);
        linkedHashMap.put("pushId", str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.j.a.a.a.d("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.l).a(linkedHashMap2).a().a();
    }

    public c d(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.j.a.a.a.d("PushAPI", "subScribeAllTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.j).a(linkedHashMap2).a().a();
    }

    public c d(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.j.a.a.a.d("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.m).a(linkedHashMap2).a().a();
    }

    public c e(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.j.a.a.a.d("PushAPI", "checkPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.a(this.k).a(linkedHashMap2).a().a();
    }
}
