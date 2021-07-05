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
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f40528a;

    /* renamed from: b  reason: collision with root package name */
    public String f40529b;

    /* renamed from: c  reason: collision with root package name */
    public String f40530c;

    /* renamed from: d  reason: collision with root package name */
    public String f40531d;

    /* renamed from: e  reason: collision with root package name */
    public String f40532e;

    /* renamed from: f  reason: collision with root package name */
    public String f40533f;

    /* renamed from: g  reason: collision with root package name */
    public String f40534g;

    /* renamed from: h  reason: collision with root package name */
    public String f40535h;

    /* renamed from: i  reason: collision with root package name */
    public String f40536i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;

    public a(Context context) {
        this.f40528a = "https://api-push.meizu.com/garcia/api/client/";
        this.f40529b = this.f40528a + "message/registerPush";
        this.f40530c = this.f40528a + "message/unRegisterPush";
        this.f40531d = this.f40528a + "advance/unRegisterPush";
        this.f40532e = this.f40528a + "message/getRegisterSwitch";
        this.f40533f = this.f40528a + "message/changeRegisterSwitch";
        this.f40534g = this.f40528a + "message/changeAllSwitch";
        this.f40535h = this.f40528a + "message/subscribeTags";
        this.f40536i = this.f40528a + "message/unSubscribeTags";
        this.j = this.f40528a + "message/unSubAllTags";
        this.k = this.f40528a + "message/getSubTags";
        this.l = this.f40528a + "message/subscribeAlias";
        this.m = this.f40528a + "message/unSubscribeAlias";
        this.n = this.f40528a + "message/getSubAlias";
        this.o = this.f40528a + "log/upload";
        this.p = this.f40528a + "advance/changeRegisterSwitch";
        com.meizu.cloud.pushsdk.b.a.a();
        if (MzSystemUtils.isInternational() || MzSystemUtils.isIndiaLocal()) {
            this.f40528a = "https://api-push.in.meizu.com/garcia/api/client/";
            this.f40529b = this.f40528a + "message/registerPush";
            this.f40530c = this.f40528a + "message/unRegisterPush";
            this.f40531d = this.f40528a + "advance/unRegisterPush";
            this.f40532e = this.f40528a + "message/getRegisterSwitch";
            this.f40533f = this.f40528a + "message/changeRegisterSwitch";
            this.f40534g = this.f40528a + "message/changeAllSwitch";
            this.f40535h = this.f40528a + "message/subscribeTags";
            this.f40536i = this.f40528a + "message/unSubscribeTags";
            this.j = this.f40528a + "message/unSubAllTags";
            this.k = this.f40528a + "message/getSubTags";
            this.l = this.f40528a + "message/subscribeAlias";
            this.m = this.f40528a + "message/unSubscribeAlias";
            this.n = this.f40528a + "message/getSubAlias";
            this.p = this.f40528a + "advance/changeRegisterSwitch";
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
        return com.meizu.cloud.pushsdk.b.a.b(this.f40529b).a(linkedHashMap2).a().a();
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
        d.h.a.a.a.d("PushAPI", this.f40533f + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f40533f).a(linkedHashMap2).a().a();
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
        return com.meizu.cloud.pushsdk.b.a.b(this.f40535h).a(linkedHashMap2).a().a();
    }

    public c a(String str, String str2, String str3, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.h.a.a.a.d("PushAPI", this.f40534g + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.b(this.f40534g).a(linkedHashMap2).a().a();
    }

    public c b(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.h.a.a.a.d("PushAPI", "unregister post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.a(this.f40530c).a(linkedHashMap2).a().a();
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
        return com.meizu.cloud.pushsdk.b.a.b(this.f40536i).a(linkedHashMap2).a().a();
    }

    public c c(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        linkedHashMap.put("pushId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        d.h.a.a.a.d("PushAPI", "checkPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.b.a.a(this.f40532e).a(linkedHashMap2).a().a();
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
