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
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f75313a;

    /* renamed from: b  reason: collision with root package name */
    public String f75314b;

    /* renamed from: c  reason: collision with root package name */
    public String f75315c;

    /* renamed from: d  reason: collision with root package name */
    public String f75316d;

    /* renamed from: e  reason: collision with root package name */
    public String f75317e;

    /* renamed from: f  reason: collision with root package name */
    public String f75318f;

    /* renamed from: g  reason: collision with root package name */
    public String f75319g;

    /* renamed from: h  reason: collision with root package name */
    public String f75320h;

    /* renamed from: i  reason: collision with root package name */
    public String f75321i;

    /* renamed from: j  reason: collision with root package name */
    public String f75322j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;

    public a(Context context) {
        this.f75313a = "https://api-push.meizu.com/garcia/api/client/";
        this.f75314b = this.f75313a + "message/registerPush";
        this.f75315c = this.f75313a + "message/unRegisterPush";
        this.f75316d = this.f75313a + "advance/unRegisterPush";
        this.f75317e = this.f75313a + "message/getRegisterSwitch";
        this.f75318f = this.f75313a + "message/changeRegisterSwitch";
        this.f75319g = this.f75313a + "message/changeAllSwitch";
        this.f75320h = this.f75313a + "message/subscribeTags";
        this.f75321i = this.f75313a + "message/unSubscribeTags";
        this.f75322j = this.f75313a + "message/unSubAllTags";
        this.k = this.f75313a + "message/getSubTags";
        this.l = this.f75313a + "message/subscribeAlias";
        this.m = this.f75313a + "message/unSubscribeAlias";
        this.n = this.f75313a + "message/getSubAlias";
        this.o = this.f75313a + "log/upload";
        this.p = this.f75313a + "advance/changeRegisterSwitch";
        com.meizu.cloud.pushsdk.b.a.a();
        if (MzSystemUtils.isInternational() || MzSystemUtils.isIndiaLocal()) {
            this.f75313a = "https://api-push.in.meizu.com/garcia/api/client/";
            this.f75314b = this.f75313a + "message/registerPush";
            this.f75315c = this.f75313a + "message/unRegisterPush";
            this.f75316d = this.f75313a + "advance/unRegisterPush";
            this.f75317e = this.f75313a + "message/getRegisterSwitch";
            this.f75318f = this.f75313a + "message/changeRegisterSwitch";
            this.f75319g = this.f75313a + "message/changeAllSwitch";
            this.f75320h = this.f75313a + "message/subscribeTags";
            this.f75321i = this.f75313a + "message/unSubscribeTags";
            this.f75322j = this.f75313a + "message/unSubAllTags";
            this.k = this.f75313a + "message/getSubTags";
            this.l = this.f75313a + "message/subscribeAlias";
            this.m = this.f75313a + "message/unSubscribeAlias";
            this.n = this.f75313a + "message/getSubAlias";
            this.p = this.f75313a + "advance/changeRegisterSwitch";
        }
    }

    public c a(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        c.l.a.a.a.d("PushAPI", "register post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f75314b).a(linkedHashMap2).a().a();
    }

    public c a(String str, String str2, String str3, int i2, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        linkedHashMap.put("msgType", String.valueOf(i2));
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        c.l.a.a.a.d("PushAPI", this.f75318f + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f75318f).a(linkedHashMap2).a().a();
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
        c.l.a.a.a.d("PushAPI", "uploadLogFile post map " + linkedHashMap2);
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
        c.l.a.a.a.d("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f75320h).a(linkedHashMap2).a().a();
    }

    public c a(String str, String str2, String str3, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        c.l.a.a.a.d("PushAPI", this.f75319g + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f75319g).a(linkedHashMap2).a().a();
    }

    public c b(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        c.l.a.a.a.d("PushAPI", "unregister post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.a(this.f75315c).a(linkedHashMap2).a().a();
    }

    public c b(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        linkedHashMap.put(CommandMessage.TYPE_TAGS, str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        c.l.a.a.a.d("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f75321i).a(linkedHashMap2).a().a();
    }

    public c c(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        c.l.a.a.a.d("PushAPI", "checkPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.a(this.f75317e).a(linkedHashMap2).a().a();
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
        c.l.a.a.a.d("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.l).a(linkedHashMap2).a().a();
    }

    public c d(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        c.l.a.a.a.d("PushAPI", "subScribeAllTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f75322j).a(linkedHashMap2).a().a();
    }

    public c d(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        c.l.a.a.a.d("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.m).a(linkedHashMap2).a().a();
    }

    public c e(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        c.l.a.a.a.d("PushAPI", "checkPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.a(this.k).a(linkedHashMap2).a().a();
    }
}
