package com.kascend.chushou.constants;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.i;
import com.kascend.chushou.b.a.a.m;
import com.kascend.chushou.c.c;
import com.kascend.chushou.player.ui.h5.redpacket.a;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.toolkit.b;
import com.kascend.chushou.widget.cswebview.d;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.http.Http;
import tv.chushou.basis.http.model.RequestTag;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.fresco.a;
import tv.chushou.zues.widget.sweetalert.b;
/* loaded from: classes6.dex */
public class JSInterface {
    private static final String TAG = "JSInterface";
    private boolean canScrollHorizontally;
    private d mCloseListener;
    private Context mContext;
    private Object mExtraData;
    private b mJsCallNative;
    private a mRedpacketController;

    public JSInterface(Context context) {
        this.mContext = context;
    }

    public JSInterface(Context context, a aVar) {
        this.mContext = context;
        this.mRedpacketController = aVar;
    }

    public JSInterface setCloseListener(d dVar) {
        this.mCloseListener = dVar;
        return this;
    }

    public JSInterface setExtraData(Object obj) {
        this.mExtraData = obj;
        return this;
    }

    public JSInterface setJsToNative(b bVar) {
        this.mJsCallNative = bVar;
        return this;
    }

    @JavascriptInterface
    public boolean isSupported() {
        return true;
    }

    @JavascriptInterface
    public void pay(String str) {
        com.kascend.chushou.d.a.c(this.mContext, null);
    }

    @JavascriptInterface
    public String getToken() {
        return com.kascend.chushou.d.b.d();
    }

    @JavascriptInterface
    public String getApkSource() {
        return com.kascend.chushou.d.b.b();
    }

    @JavascriptInterface
    public String getVersion() {
        return com.kascend.chushou.d.b.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isLogin() {
        int i;
        Http.Resp sync;
        e.d(TAG, "isLogin()");
        final String a2 = com.kascend.chushou.d.e.a("_fromView", "9");
        if (!tv.chushou.zues.utils.a.eHM()) {
            g.O(this.mContext, a.i.s_no_available_network);
            return false;
        } else if (LoginManager.Instance().islogined()) {
            Http http = (Http) tv.chushou.basis.d.b.eHq().S(Http.class);
            if (http == null) {
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.constants.JSInterface.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kascend.chushou.d.a.b(JSInterface.this.mContext, a2);
                    }
                });
                return false;
            }
            try {
                sync = http.getSync(tv.chushou.common.a.eHr(), "api/token/verify.htm?", null, RequestTag.normal());
            } catch (Exception e) {
                e.e(TAG, "verfify token sync failed", e);
            }
            if (sync != null && sync.respJson != null) {
                i = sync.respJson.optInt("code", -1);
                if (i != 0) {
                    return true;
                }
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.constants.JSInterface.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kascend.chushou.d.a.b(JSInterface.this.mContext, a2);
                    }
                });
                return false;
            }
            i = -1;
            if (i != 0) {
            }
        } else {
            RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.constants.JSInterface.3
                @Override // java.lang.Runnable
                public void run() {
                    com.kascend.chushou.d.a.b(JSInterface.this.mContext, a2);
                }
            });
            return false;
        }
    }

    @JavascriptInterface
    public void switchView(String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6 = null;
        if (!h.isEmpty(str)) {
            e.d(TAG, "switchView name=" + str + "  data=" + str2);
            char c = 65535;
            switch (str.hashCode()) {
                case -1677105050:
                    if (str.equals("qqauthlist")) {
                        c = 19;
                        break;
                    }
                    break;
                case -1097329270:
                    if (str.equals("logout")) {
                        c = 1;
                        break;
                    }
                    break;
                case -982336280:
                    if (str.equals("openFansList")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -838595071:
                    if (str.equals("upload")) {
                        c = 5;
                        break;
                    }
                    break;
                case -794191620:
                    if (str.equals("uploadRevision")) {
                        c = 6;
                        break;
                    }
                    break;
                case -731282396:
                    if (str.equals("myVideos")) {
                        c = 17;
                        break;
                    }
                    break;
                case -611292322:
                    if (str.equals("userProfile")) {
                        c = 7;
                        break;
                    }
                    break;
                case -354578024:
                    if (str.equals("startAccountSafe")) {
                        c = 14;
                        break;
                    }
                    break;
                case 3277:
                    if (str.equals("h5")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3506395:
                    if (str.equals(UbcStatConstant.KEY_CONTENT_ROOM)) {
                        c = 2;
                        break;
                    }
                    break;
                case 6799390:
                    if (str.equals("openGamemateOrderDetail")) {
                        c = 11;
                        break;
                    }
                    break;
                case 103149417:
                    if (str.equals(OneKeyLoginSdkCall.k)) {
                        c = 0;
                        break;
                    }
                    break;
                case 112202875:
                    if (str.equals("video")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 245766548:
                    if (str.equals("openNewFansList")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 542424159:
                    if (str.equals("qqgroup")) {
                        c = 18;
                        break;
                    }
                    break;
                case 835260333:
                    if (str.equals(Config.BAWU_TYPE_MANAGER)) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1054464947:
                    if (str.equals("miclive")) {
                        c = 20;
                        break;
                    }
                    break;
                case 1486348405:
                    if (str.equals("myGames")) {
                        c = 16;
                        break;
                    }
                    break;
                case 1643599610:
                    if (str.equals("autoLogin")) {
                        c = 15;
                        break;
                    }
                    break;
                case 1730482241:
                    if (str.equals("navlist")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1952520643:
                    if (str.equals("innerH5")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    final String a2 = com.kascend.chushou.d.e.a("_fromView", "9");
                    RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.constants.JSInterface.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.kascend.chushou.d.a.b(JSInterface.this.mContext, a2);
                        }
                    });
                    return;
                case 1:
                    LoginManager.Instance().openLogout(null);
                    return;
                case 2:
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        str4 = jSONObject.optString("roomId");
                        try {
                            str3 = jSONObject.optString("liveType");
                            try {
                                str6 = jSONObject.optString("urlSearchJson");
                            } catch (Exception e) {
                            }
                        } catch (Exception e2) {
                            str3 = null;
                        }
                    } catch (Exception e3) {
                        str3 = null;
                        str4 = null;
                    }
                    if (str4 != null) {
                        ListItem listItem = new ListItem();
                        listItem.mTargetKey = str4;
                        listItem.mLiveType = str3;
                        listItem.mType = "1";
                        HashMap hashMap = new HashMap();
                        hashMap.put("_fromView", "9");
                        if (str6 != null) {
                            hashMap.putAll(tv.chushou.zues.utils.d.aaC(str6));
                        }
                        com.kascend.chushou.d.e.a(this.mContext, listItem, com.kascend.chushou.d.e.a(hashMap));
                        return;
                    }
                    return;
                case 3:
                    try {
                        str6 = new JSONObject(str2).optString("url");
                    } catch (Exception e4) {
                    }
                    if (str6 != null) {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str6));
                        if (tv.chushou.zues.utils.a.isIntentAvailable(this.mContext, intent)) {
                            this.mContext.startActivity(intent);
                            return;
                        }
                        return;
                    }
                    return;
                case 4:
                    String str7 = "99";
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        str6 = jSONObject2.optString("url");
                        str7 = jSONObject2.optString("type", "99");
                    } catch (Exception e5) {
                    }
                    if (!TextUtils.isEmpty(str6)) {
                        ListItem listItem2 = new ListItem();
                        if (!"98".equals(str7) && !"96".equals(str7)) {
                            str7 = "99";
                        }
                        listItem2.mType = str7;
                        listItem2.mUrl = str6;
                        com.kascend.chushou.d.e.a(this.mContext, listItem2, com.kascend.chushou.d.e.O("_fromView", "9"));
                        return;
                    }
                    return;
                case 5:
                    if (!h.isEmpty(str2)) {
                        com.kascend.chushou.d.a.b(this.mContext, "upload", str2);
                        return;
                    }
                    return;
                case 6:
                    if (!h.isEmpty(str2)) {
                        com.kascend.chushou.d.a.b(this.mContext, "uploadRevision", str2);
                        return;
                    }
                    return;
                case 7:
                    try {
                        str5 = new JSONObject(str2).optString("uid");
                    } catch (Exception e6) {
                        str5 = null;
                    }
                    if (!h.isEmpty(str5)) {
                        ListItem listItem3 = new ListItem();
                        listItem3.mTargetKey = str5;
                        listItem3.mType = "5";
                        com.kascend.chushou.d.e.a(this.mContext, listItem3, com.kascend.chushou.d.e.O("_fromView", "9"));
                        return;
                    }
                    return;
                case '\b':
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                    unsupport("switchView:" + str);
                    return;
                default:
                    return;
            }
        }
    }

    @JavascriptInterface
    public void updatePoint() {
        if (tv.chushou.zues.utils.a.eHM() && LoginManager.Instance().islogined()) {
            c.etT().c((com.kascend.chushou.c.b) null, "");
        }
    }

    @JavascriptInterface
    public void share(String str) {
        e.d(TAG, "share data=" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("source");
            ShareInfo shareInfo = new ShareInfo();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    shareInfo.mShowPlatform.add(Integer.valueOf(optJSONArray.optInt(i)));
                }
            }
            shareInfo.mTitle = jSONObject.optString("title");
            shareInfo.mContent = jSONObject.optString("content");
            shareInfo.mThumbnail = jSONObject.optString("thumbnail");
            shareInfo.mUrl = jSONObject.optString("url");
            shareInfo.mMiniProgramUrl = jSONObject.optString("miniprogramUrl");
            shareInfo.mMiniProgramThumbnail = jSONObject.optString("miniprogramThumbnail", "");
            shareInfo.mTargetKey = shareInfo.mUrl;
            shareInfo.mShareType = "99";
            shareInfo.mPic = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            com.kascend.cstvsdk.utils.b.pCR.a(this.mContext, shareInfo, com.kascend.chushou.d.e.a("_fromView", "9"));
        } catch (Exception e) {
        }
    }

    @JavascriptInterface
    public void closeView() {
        e.d(TAG, "closeView()");
        if (this.mCloseListener != null) {
            RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.constants.JSInterface.5
                @Override // java.lang.Runnable
                public void run() {
                    if (JSInterface.this.mCloseListener != null) {
                        JSInterface.this.mCloseListener.a(JSInterface.this.mExtraData);
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void refreshLocalInfo(String str) {
        unsupport("refreshLocalInfo");
    }

    @JavascriptInterface
    public void openGame(String str) {
        unsupport("openGame");
    }

    @JavascriptInterface
    public void packageState(String str) {
        unsupport("packageState");
    }

    @JavascriptInterface
    public void copyBoard(String str) {
        e.d(TAG, "copyBoard " + str);
        if (!h.isEmpty(str)) {
            ((ClipboardManager) this.mContext.getSystemService("clipboard")).setText(str);
            g.Sc(a.i.str_copy_success);
        }
    }

    @JavascriptInterface
    public boolean isInstall(String str) {
        e.d(TAG, "isInstall " + str);
        return tv.chushou.zues.utils.a.isAppInstalled(this.mContext, str);
    }

    @JavascriptInterface
    public void userProfile(String str) {
        e.d(TAG, "userProfile " + str);
        try {
            com.kascend.chushou.d.a.a(this.mContext, com.kascend.chushou.d.e.O("_fromView", "9"), (String) null, new JSONObject(str).optString("uid"), (String) null, false);
        } catch (Exception e) {
            e.e(TAG, "userProfile fail e=" + e.toString(), e);
        }
    }

    @JavascriptInterface
    public void downloadGame(String str) {
        unsupport("downloadGame");
    }

    @JavascriptInterface
    public void broadcast() {
        unsupport("broadcast");
    }

    @JavascriptInterface
    public void startALCert(String str) {
        unsupport("startALCert");
    }

    @JavascriptInterface
    public void redEnvelopesGeted(final String str) {
        e.d(TAG, "redEnvelopesGeted:" + str);
        RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.constants.JSInterface.6
            @Override // java.lang.Runnable
            public void run() {
                if (JSInterface.this.mRedpacketController != null) {
                    JSInterface.this.mRedpacketController.a(str);
                }
            }
        });
    }

    @JavascriptInterface
    public void sendBarrage(String str) {
        e.d(TAG, "sendBarrage:" + str);
        tv.chushou.zues.a.a.post(new i(46, str));
    }

    @JavascriptInterface
    public void balanceLess() {
        e.d(TAG, "balanceLess");
        RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.constants.JSInterface.7
            @Override // java.lang.Runnable
            public void run() {
                if (JSInterface.this.mContext instanceof FragmentActivity) {
                    com.kascend.chushou.d.e.a((FragmentActivity) JSInterface.this.mContext, (String) null);
                }
            }
        });
    }

    @JavascriptInterface
    public void swipeEnable(boolean z) {
        tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.e(z));
    }

    @JavascriptInterface
    public void enableHardware(boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.d(z));
        }
    }

    @JavascriptInterface
    public void confirmCloseEvent(final String str) {
        if (!h.isEmpty(str) && this.mCloseListener != null) {
            RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.constants.JSInterface.8
                @Override // java.lang.Runnable
                public void run() {
                    if (JSInterface.this.mCloseListener != null) {
                        JSInterface.this.mCloseListener.a(str);
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void confirmCloseEvent2(String str) {
        JSONException jSONException;
        String str2;
        final String str3;
        final String str4;
        JSONObject jSONObject;
        if (!h.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
                str3 = jSONObject.optString("targetKey");
            } catch (JSONException e) {
                jSONException = e;
                str2 = null;
            }
            try {
                str4 = jSONObject.optString("confirmText");
            } catch (JSONException e2) {
                str2 = str3;
                jSONException = e2;
                jSONException.printStackTrace();
                str3 = str2;
                str4 = null;
                if (!h.isEmpty(str4)) {
                }
            }
            if (!h.isEmpty(str4)) {
                com.kascend.chushou.d.h.etY().b(str3);
                closeView();
                return;
            }
            RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.constants.JSInterface.9
                @Override // java.lang.Runnable
                public void run() {
                    if (JSInterface.this.mContext != null) {
                        new tv.chushou.zues.widget.sweetalert.b(JSInterface.this.mContext, 0).a(new b.a() { // from class: com.kascend.chushou.constants.JSInterface.9.2
                            @Override // tv.chushou.zues.widget.sweetalert.b.a
                            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                                bVar.dismiss();
                            }
                        }).b(new b.a() { // from class: com.kascend.chushou.constants.JSInterface.9.1
                            @Override // tv.chushou.zues.widget.sweetalert.b.a
                            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                                com.kascend.chushou.d.h.etY().b(str3);
                                bVar.dismiss();
                                JSInterface.this.closeView();
                            }
                        }).aaL(JSInterface.this.mContext.getString(a.i.cancel)).aaN(JSInterface.this.mContext.getString(a.i.cs_confirm)).aaK(JSInterface.this.mContext.getString(a.i.cs_info_title)).D(str4).show();
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void shareImages(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("source");
            ShareInfo shareInfo = new ShareInfo();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    shareInfo.mShowPlatform.add(Integer.valueOf(optJSONArray.optInt(i)));
                }
            }
            shareInfo.mUrl = jSONObject.optString("targetKey");
            shareInfo.mPic = jSONObject.optString("imageUrl");
            shareInfo.mContent = jSONObject.optString("content");
            com.kascend.cstvsdk.utils.b.pCR.a(this.mContext, shareInfo, com.kascend.chushou.d.e.a("_fromView", "9"));
        } catch (Exception e) {
            e.e(TAG, "share fail e=" + e.toString());
        }
    }

    @JavascriptInterface
    public void subscribe(String str) {
        String str2;
        String str3 = null;
        e.d(TAG, "subscribe:" + str);
        if (!h.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                str2 = jSONObject.optString("roomId", "");
                try {
                    str3 = jSONObject.optString("uid", "");
                } catch (JSONException e) {
                }
            } catch (JSONException e2) {
                str2 = null;
            }
            tv.chushou.zues.a.a.post(new m(str3, str2, true));
        }
    }

    @JavascriptInterface
    public void reserveActiveRoom(String str) {
        unsupport("reserveActiveRoom");
    }

    @JavascriptInterface
    public void setCanScrollHorizontally(boolean z) {
        this.canScrollHorizontally = z;
    }

    public boolean isCanScrollHorizontally() {
        return this.canScrollHorizontally;
    }

    @JavascriptInterface
    public void adsCallback(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("type");
            ListItem eK = com.kascend.chushou.c.a.eK(jSONObject.optJSONObject("listItem"));
            if ("1".equals(optString)) {
                com.kascend.chushou.a.a.etR().a(eK);
            } else if ("2".equals(optString)) {
                JSONObject optJSONObject = jSONObject.optJSONObject("dataInfo");
                if (this.mContext != null) {
                    com.kascend.chushou.d.e.a(this.mContext, eK, optJSONObject);
                }
            } else if ("3".equals(optString)) {
                com.kascend.chushou.a.a.etR().c(eK);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public void guessDetail(String str) {
        String str2;
        String str3 = null;
        e.d(TAG, "guessDetail:" + str);
        if (!h.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                str2 = jSONObject.optString("roomId");
                try {
                    str3 = jSONObject.optString("mappingId");
                } catch (JSONException e) {
                }
            } catch (JSONException e2) {
                str2 = null;
            }
            com.kascend.chushou.b.a.a.h hVar = new com.kascend.chushou.b.a.a.h(1);
            hVar.a("roomId", str2);
            hVar.a("mappingId", str3);
            tv.chushou.zues.a.a.post(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toDealSave(String str) {
        e.d(TAG, "savePicture: " + str);
        if (!h.isEmpty(str)) {
            final String str2 = "";
            final String str3 = "";
            final String str4 = "";
            try {
                JSONObject jSONObject = new JSONObject(str);
                str2 = jSONObject.optString("picUrl");
                str3 = jSONObject.optString("imageBase64");
                str4 = jSONObject.optString("toastMessage");
            } catch (JSONException e) {
            }
            if (!h.isEmpty(str2) || !h.isEmpty(str3)) {
                final File etW = com.kascend.chushou.d.c.phK.etW();
                new tv.chushou.zues.widget.sweetalert.b(this.mContext).a(new b.a() { // from class: com.kascend.chushou.constants.JSInterface.11
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dismiss();
                    }
                }).b(new b.a() { // from class: com.kascend.chushou.constants.JSInterface.10
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dismiss();
                        if (!h.isEmpty(str2)) {
                            tv.chushou.zues.widget.fresco.a.a(str2, etW.getAbsolutePath(), new a.InterfaceC1123a() { // from class: com.kascend.chushou.constants.JSInterface.10.1
                                @Override // tv.chushou.zues.widget.fresco.a.InterfaceC1123a
                                public void onComplete(boolean z, String str5) {
                                    if (z) {
                                        if (!h.isEmpty(str4)) {
                                            g.A(str4);
                                            return;
                                        } else {
                                            g.A(tv.chushou.widget.a.c.getString(a.i.str_img_already_download, str5));
                                            return;
                                        }
                                    }
                                    g.Sc(a.i.str_download_fail);
                                }
                            });
                            return;
                        }
                        File o = com.kascend.chushou.d.d.phL.o(str3, new File(etW, System.currentTimeMillis() + ".jpg"));
                        if (o != null) {
                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                            intent.setData(Uri.fromFile(o));
                            tv.chushou.basis.d.b.eHo().sendBroadcast(intent);
                            if (!h.isEmpty(str4)) {
                                g.A(str4);
                                return;
                            } else {
                                g.A(tv.chushou.widget.a.c.getString(a.i.str_img_already_download, o.getAbsolutePath()));
                                return;
                            }
                        }
                        g.Sc(a.i.str_download_fail);
                    }
                }).aaL(this.mContext.getString(a.i.alert_dialog_cancel)).aaN(this.mContext.getString(a.i.alert_dialog_ok)).D(this.mContext.getString(a.i.str_download_img)).show();
                return;
            }
            g.A(tv.chushou.widget.a.c.getString(a.i.str_download_fail));
        }
    }

    @JavascriptInterface
    public void savePicture(final String str) {
        if (!new com.yanzhenjie.permission.a.b().e(this.mContext, "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE")) {
            com.yanzhenjie.permission.b.hs(this.mContext).ab("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").a(new com.yanzhenjie.permission.g() { // from class: com.kascend.chushou.constants.JSInterface.12
                @Override // com.yanzhenjie.permission.g
                public void showRationale(Context context, List<String> list, final com.yanzhenjie.permission.i iVar) {
                    List<String> d = com.yanzhenjie.permission.e.d(context, list);
                    final tv.chushou.zues.widget.sweetalert.b bVar = new tv.chushou.zues.widget.sweetalert.b(context);
                    bVar.a(new b.a() { // from class: com.kascend.chushou.constants.JSInterface.12.2
                        @Override // tv.chushou.zues.widget.sweetalert.b.a
                        public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                            bVar.eIp();
                            iVar.cancel();
                        }
                    }).b(new b.a() { // from class: com.kascend.chushou.constants.JSInterface.12.1
                        @Override // tv.chushou.zues.widget.sweetalert.b.a
                        public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                            bVar.eIp();
                            iVar.execute();
                        }
                    }).aaL(context.getString(a.i.alert_dialog_cancel)).aaN(context.getString(a.i.gallery_permissions_continue)).D(context.getString(a.i.gallery_permissions_rationale, d)).setCanceledOnTouchOutside(false);
                    bVar.show();
                }
            }).b(new com.yanzhenjie.permission.a() { // from class: com.kascend.chushou.constants.JSInterface.14
                @Override // com.yanzhenjie.permission.a
                public void onAction(List<String> list) {
                    g.Sc(a.i.gallery_sdcard_permission_denied);
                }
            }).a(new com.yanzhenjie.permission.a() { // from class: com.kascend.chushou.constants.JSInterface.13
                @Override // com.yanzhenjie.permission.a
                public void onAction(List<String> list) {
                    JSInterface.this.toDealSave(str);
                }
            }).start();
        } else {
            toDealSave(str);
        }
    }

    @JavascriptInterface
    public void authorizeTB() {
        unsupport("authorizeTB");
    }

    @JavascriptInterface
    public void lotteryGeted(String str) {
        e.d(TAG, "lotteryGeted: " + str);
        if (!h.isEmpty(str)) {
            String str2 = null;
            try {
                str2 = new JSONObject(str).optString("key", "");
            } catch (JSONException e) {
            }
            if (!h.isEmpty(str2)) {
                tv.chushou.zues.a.a.post(new i(54, str2));
            }
        }
    }

    @JavascriptInterface
    public void wmAdShow(String str) {
    }

    @JavascriptInterface
    public void startWmAdVideo(String str) {
    }

    @JavascriptInterface
    public void popupBarragePanel() {
        RxExecutor.postDelayed(null, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.constants.JSInterface.15
            @Override // java.lang.Runnable
            public void run() {
                tv.chushou.zues.a.a.post(new i(55, null));
            }
        });
    }

    @JavascriptInterface
    public void popupGiftPanel() {
        RxExecutor.postDelayed(null, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.constants.JSInterface.16
            @Override // java.lang.Runnable
            public void run() {
                tv.chushou.zues.a.a.post(new i(56, null));
            }
        });
    }

    @JavascriptInterface
    public void getCaptchaState(String str) {
        unsupport("getCaptchaState");
    }

    @JavascriptInterface
    public void beNoble(String str) {
        unsupport("beNoble");
    }

    private void unsupport(String str) {
        e.d(TAG, "unsupport method:" + str);
    }
}
