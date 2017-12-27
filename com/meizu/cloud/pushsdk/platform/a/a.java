package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import com.baidu.sapi2.utils.SapiUtils;
import com.meizu.cloud.pushsdk.a.e.k;
import com.meizu.cloud.pushsdk.common.b.h;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class a {
    public String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    public a(Context context) {
        this.a = "https://api-push.meizu.com/garcia/api/client/";
        this.b = this.a + "message/registerPush";
        this.c = this.a + "message/unRegisterPush";
        this.d = this.a + "advance/unRegisterPush";
        this.e = this.a + "message/getRegisterSwitch";
        this.f = this.a + "message/changeRegisterSwitch";
        this.g = this.a + "message/subscribeTags";
        this.h = this.a + "message/unSubscribeTags";
        this.i = this.a + "message/getSubTags";
        this.j = this.a + "message/subscribeAlias";
        this.k = this.a + "message/unSubscribeAlias";
        this.l = this.a + "message/getSubAlias";
        com.meizu.cloud.pushsdk.a.a.a();
        if (h.b() || h.c()) {
            this.a = "https://api-push.in.meizu.com/garcia/api/client/";
            this.b = this.a + "message/registerPush";
            this.c = this.a + "message/unRegisterPush";
            this.d = this.a + "advance/unRegisterPush";
            this.e = this.a + "message/getRegisterSwitch";
            this.f = this.a + "message/changeRegisterSwitch";
            this.g = this.a + "message/subscribeTags";
            this.h = this.a + "message/unSubscribeTags";
            this.i = this.a + "message/getSubTags";
            this.j = this.a + "message/subscribeAlias";
            this.k = this.a + "message/unSubscribeAlias";
            this.l = this.a + "message/getSubAlias";
        }
    }

    public void a(String str, String str2, String str3, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put(SapiUtils.KEY_QR_LOGIN_SIGN, com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.a.a.i("PushAPI", "register post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.b(this.b).a(linkedHashMap2).a().a(kVar);
    }

    public void b(String str, String str2, String str3, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put(SapiUtils.KEY_QR_LOGIN_SIGN, com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.a.a.i("PushAPI", "unregister post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.a(this.c).a(linkedHashMap2).a().a(kVar);
    }

    public void a(String str, String str2, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("packageName", str);
        linkedHashMap.put("deviceId", str2);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put(SapiUtils.KEY_QR_LOGIN_SIGN, com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, "4a2ca769d79f4856bb3bd982d30de790"));
        com.meizu.cloud.a.a.i("PushAPI", "advance unregister post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.b(this.d).a(linkedHashMap2).a().a(kVar);
    }

    public void c(String str, String str2, String str3, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put(SapiUtils.KEY_QR_LOGIN_SIGN, com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.a.a.i("PushAPI", "checkPush post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.a(this.e).a(linkedHashMap2).a().a(kVar);
    }

    public void a(String str, String str2, String str3, int i, boolean z, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("msgType", String.valueOf(i));
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put(SapiUtils.KEY_QR_LOGIN_SIGN, com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.a.a.i("PushAPI", "swithPush post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.b(this.f).a(linkedHashMap2).a().a(kVar);
    }

    public void a(String str, String str2, String str3, String str4, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("tags", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put(SapiUtils.KEY_QR_LOGIN_SIGN, com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.a.a.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.b(this.g).a(linkedHashMap2).a().a(kVar);
    }

    public void b(String str, String str2, String str3, String str4, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("tags", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put(SapiUtils.KEY_QR_LOGIN_SIGN, com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.a.a.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.b(this.h).a(linkedHashMap2).a().a(kVar);
    }

    public void d(String str, String str2, String str3, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put(SapiUtils.KEY_QR_LOGIN_SIGN, com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.a.a.i("PushAPI", "checkPush post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.a(this.i).a(linkedHashMap2).a().a(kVar);
    }

    public void c(String str, String str2, String str3, String str4, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put("appKey", str2);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put(SapiUtils.KEY_QR_LOGIN_SIGN, com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.a.a.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.b(this.j).a(linkedHashMap2).a().a(kVar);
    }

    public void d(String str, String str2, String str3, String str4, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put(SapiUtils.KEY_QR_LOGIN_SIGN, com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.a.a.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.b(this.k).a(linkedHashMap2).a().a(kVar);
    }

    public void e(String str, String str2, String str3, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put(SapiUtils.KEY_QR_LOGIN_SIGN, com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        com.meizu.cloud.a.a.i("PushAPI", "checkPush post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.a(this.l).a(linkedHashMap2).a().a(kVar);
    }
}
