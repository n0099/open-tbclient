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
    public String f74779a;

    /* renamed from: b  reason: collision with root package name */
    public String f74780b;

    /* renamed from: c  reason: collision with root package name */
    public String f74781c;

    /* renamed from: d  reason: collision with root package name */
    public String f74782d;

    /* renamed from: e  reason: collision with root package name */
    public String f74783e;

    /* renamed from: f  reason: collision with root package name */
    public String f74784f;

    /* renamed from: g  reason: collision with root package name */
    public String f74785g;

    /* renamed from: h  reason: collision with root package name */
    public String f74786h;

    /* renamed from: i  reason: collision with root package name */
    public String f74787i;

    /* renamed from: j  reason: collision with root package name */
    public String f74788j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;

    public a(Context context) {
        this.f74779a = "https://api-push.meizu.com/garcia/api/client/";
        this.f74780b = this.f74779a + "message/registerPush";
        this.f74781c = this.f74779a + "message/unRegisterPush";
        this.f74782d = this.f74779a + "advance/unRegisterPush";
        this.f74783e = this.f74779a + "message/getRegisterSwitch";
        this.f74784f = this.f74779a + "message/changeRegisterSwitch";
        this.f74785g = this.f74779a + "message/changeAllSwitch";
        this.f74786h = this.f74779a + "message/subscribeTags";
        this.f74787i = this.f74779a + "message/unSubscribeTags";
        this.f74788j = this.f74779a + "message/unSubAllTags";
        this.k = this.f74779a + "message/getSubTags";
        this.l = this.f74779a + "message/subscribeAlias";
        this.m = this.f74779a + "message/unSubscribeAlias";
        this.n = this.f74779a + "message/getSubAlias";
        this.o = this.f74779a + "log/upload";
        this.p = this.f74779a + "advance/changeRegisterSwitch";
        com.meizu.cloud.pushsdk.b.a.a();
        if (MzSystemUtils.isInternational() || MzSystemUtils.isIndiaLocal()) {
            this.f74779a = "https://api-push.in.meizu.com/garcia/api/client/";
            this.f74780b = this.f74779a + "message/registerPush";
            this.f74781c = this.f74779a + "message/unRegisterPush";
            this.f74782d = this.f74779a + "advance/unRegisterPush";
            this.f74783e = this.f74779a + "message/getRegisterSwitch";
            this.f74784f = this.f74779a + "message/changeRegisterSwitch";
            this.f74785g = this.f74779a + "message/changeAllSwitch";
            this.f74786h = this.f74779a + "message/subscribeTags";
            this.f74787i = this.f74779a + "message/unSubscribeTags";
            this.f74788j = this.f74779a + "message/unSubAllTags";
            this.k = this.f74779a + "message/getSubTags";
            this.l = this.f74779a + "message/subscribeAlias";
            this.m = this.f74779a + "message/unSubscribeAlias";
            this.n = this.f74779a + "message/getSubAlias";
            this.p = this.f74779a + "advance/changeRegisterSwitch";
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
        return com.meizu.cloud.pushsdk.b.a.b(this.f74780b).a(linkedHashMap2).a().a();
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
        c.l.a.a.a.d("PushAPI", this.f74784f + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f74784f).a(linkedHashMap2).a().a();
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
        return com.meizu.cloud.pushsdk.b.a.b(this.f74786h).a(linkedHashMap2).a().a();
    }

    public c a(String str, String str2, String str3, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        c.l.a.a.a.d("PushAPI", this.f74785g + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f74785g).a(linkedHashMap2).a().a();
    }

    public c b(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        c.l.a.a.a.d("PushAPI", "unregister post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.a(this.f74781c).a(linkedHashMap2).a().a();
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
        return com.meizu.cloud.pushsdk.b.a.b(this.f74787i).a(linkedHashMap2).a().a();
    }

    public c c(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        c.l.a.a.a.d("PushAPI", "checkPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.a(this.f74783e).a(linkedHashMap2).a().a();
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
        return com.meizu.cloud.pushsdk.b.a.b(this.f74788j).a(linkedHashMap2).a().a();
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
