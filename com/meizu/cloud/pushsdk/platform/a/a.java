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
    public String f37731a;

    /* renamed from: b  reason: collision with root package name */
    public String f37732b;

    /* renamed from: c  reason: collision with root package name */
    public String f37733c;

    /* renamed from: d  reason: collision with root package name */
    public String f37734d;

    /* renamed from: e  reason: collision with root package name */
    public String f37735e;

    /* renamed from: f  reason: collision with root package name */
    public String f37736f;

    /* renamed from: g  reason: collision with root package name */
    public String f37737g;

    /* renamed from: h  reason: collision with root package name */
    public String f37738h;

    /* renamed from: i  reason: collision with root package name */
    public String f37739i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;

    public a(Context context) {
        this.f37731a = "https://api-push.meizu.com/garcia/api/client/";
        this.f37732b = this.f37731a + "message/registerPush";
        this.f37733c = this.f37731a + "message/unRegisterPush";
        this.f37734d = this.f37731a + "advance/unRegisterPush";
        this.f37735e = this.f37731a + "message/getRegisterSwitch";
        this.f37736f = this.f37731a + "message/changeRegisterSwitch";
        this.f37737g = this.f37731a + "message/changeAllSwitch";
        this.f37738h = this.f37731a + "message/subscribeTags";
        this.f37739i = this.f37731a + "message/unSubscribeTags";
        this.j = this.f37731a + "message/unSubAllTags";
        this.k = this.f37731a + "message/getSubTags";
        this.l = this.f37731a + "message/subscribeAlias";
        this.m = this.f37731a + "message/unSubscribeAlias";
        this.n = this.f37731a + "message/getSubAlias";
        this.o = this.f37731a + "log/upload";
        this.p = this.f37731a + "advance/changeRegisterSwitch";
        com.meizu.cloud.pushsdk.b.a.a();
        if (MzSystemUtils.isInternational() || MzSystemUtils.isIndiaLocal()) {
            this.f37731a = "https://api-push.in.meizu.com/garcia/api/client/";
            this.f37732b = this.f37731a + "message/registerPush";
            this.f37733c = this.f37731a + "message/unRegisterPush";
            this.f37734d = this.f37731a + "advance/unRegisterPush";
            this.f37735e = this.f37731a + "message/getRegisterSwitch";
            this.f37736f = this.f37731a + "message/changeRegisterSwitch";
            this.f37737g = this.f37731a + "message/changeAllSwitch";
            this.f37738h = this.f37731a + "message/subscribeTags";
            this.f37739i = this.f37731a + "message/unSubscribeTags";
            this.j = this.f37731a + "message/unSubAllTags";
            this.k = this.f37731a + "message/getSubTags";
            this.l = this.f37731a + "message/subscribeAlias";
            this.m = this.f37731a + "message/unSubscribeAlias";
            this.n = this.f37731a + "message/getSubAlias";
            this.p = this.f37731a + "advance/changeRegisterSwitch";
        }
    }

    public c a(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.h.a.a.a.d("PushAPI", "register post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f37732b).a(linkedHashMap2).a().a();
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
        d.h.a.a.a.d("PushAPI", this.f37736f + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f37736f).a(linkedHashMap2).a().a();
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
        d.h.a.a.a.d("PushAPI", "uploadLogFile post map " + linkedHashMap2);
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
        d.h.a.a.a.d("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f37738h).a(linkedHashMap2).a().a();
    }

    public c a(String str, String str2, String str3, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.h.a.a.a.d("PushAPI", this.f37737g + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f37737g).a(linkedHashMap2).a().a();
    }

    public c b(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.h.a.a.a.d("PushAPI", "unregister post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.a(this.f37733c).a(linkedHashMap2).a().a();
    }

    public c b(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        linkedHashMap.put(CommandMessage.TYPE_TAGS, str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.h.a.a.a.d("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f37739i).a(linkedHashMap2).a().a();
    }

    public c c(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.h.a.a.a.d("PushAPI", "checkPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.a(this.f37735e).a(linkedHashMap2).a().a();
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
        d.h.a.a.a.d("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.l).a(linkedHashMap2).a().a();
    }

    public c d(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.h.a.a.a.d("PushAPI", "subScribeAllTags post map " + linkedHashMap2);
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
        d.h.a.a.a.d("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.m).a(linkedHashMap2).a().a();
    }

    public c e(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.h.a.a.a.d("PushAPI", "checkPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.a(this.k).a(linkedHashMap2).a().a();
    }
}
