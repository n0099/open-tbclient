package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom;
import com.tencent.mm.opensdk.modelbiz.HandleScanResult;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.opensdk.modelbiz.OpenWebview;
import com.tencent.mm.opensdk.modelbiz.SubscribeMessage;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.LaunchFromWX;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
final class WXApiImplV10 implements IWXAPI {
    private static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    private static String wxappPayEntryClassname = null;
    private String appId;
    private boolean checkSignature;
    private Context context;
    private boolean detached = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WXApiImplV10(Context context, String str, boolean z) {
        this.checkSignature = false;
        Log.d(TAG, "<init>, appId = " + str + ", checkSignature = " + z);
        this.context = context;
        this.appId = str;
        this.checkSignature = z;
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            Log.e(TAG, "checkSumConsistent fail, invalid arguments");
            return false;
        } else if (bArr.length != bArr2.length) {
            Log.e(TAG, "checkSumConsistent fail, length is different");
            return false;
        } else {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean createChatroom(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_create_chatroom_group_id", ""), bundle.getString("_wxapi_create_chatroom_chatroom_name", ""), bundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_create_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean handleWxInternalRespType(String str, IWXAPIEventHandler iWXAPIEventHandler) {
        boolean z = false;
        Log.i(TAG, "handleWxInternalRespType, extInfo = " + str);
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("wx_internal_resptype");
            Log.i(TAG, "handleWxInternalRespType, respType = " + queryParameter);
            if (d.a(queryParameter)) {
                Log.e(TAG, "handleWxInternalRespType fail, respType is null");
            } else if (queryParameter.equals("subscribemessage")) {
                SubscribeMessage.Resp resp = new SubscribeMessage.Resp();
                resp.openId = parse.getQueryParameter("openid");
                resp.templateID = parse.getQueryParameter("template_id");
                resp.scene = d.b(parse.getQueryParameter(FaceBaseDTO.KEY_BUSINESS_SCENE));
                resp.action = parse.getQueryParameter("action");
                resp.reserved = parse.getQueryParameter("reserved");
                iWXAPIEventHandler.onResp(resp);
                z = true;
            } else if (queryParameter.contains("invoice_auth_insert")) {
                WXInvoiceAuthInsert.Resp resp2 = new WXInvoiceAuthInsert.Resp();
                resp2.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp2);
                z = true;
            } else if (queryParameter.contains("payinsurance")) {
                WXPayInsurance.Resp resp3 = new WXPayInsurance.Resp();
                resp3.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp3);
                z = true;
            } else if (queryParameter.contains("nontaxpay")) {
                WXNontaxPay.Resp resp4 = new WXNontaxPay.Resp();
                resp4.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp4);
                z = true;
            } else {
                Log.e(TAG, "this open sdk version not support the request type");
            }
        } catch (Exception e) {
            Log.e(TAG, "handleWxInternalRespType fail, ex = " + e.getMessage());
        }
        return z;
    }

    private boolean joinChatroom(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_join_chatroom_group_id", ""), bundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_join_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendAddCardToWX(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendChooseCardFromWX(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[]{bundle.getString("_wxapi_choose_card_from_wx_card_app_id"), bundle.getString("_wxapi_choose_card_from_wx_card_location_id"), bundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), bundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), bundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), bundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), bundle.getString("_wxapi_choose_card_from_wx_card_card_id"), bundle.getString("_wxapi_choose_card_from_wx_card_card_type"), bundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendHandleScanResult(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[]{this.appId, bundle.getString("_wxapi_scan_qrcode_result")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendInvoiceAuthInsert(Context context, BaseReq baseReq) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "2", URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXInvoiceAuthInsert.Req) baseReq).url)))}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0031: INVOKE  (r10v0 android.os.Bundle), ("_wxapi_jump_to_biz_profile_req_scene") type: VIRTUAL call: android.os.Bundle.getInt(java.lang.String):int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0048: INVOKE  (r10v0 android.os.Bundle), ("_wxapi_jump_to_biz_profile_req_profile_type") type: VIRTUAL call: android.os.Bundle.getInt(java.lang.String):int)] */
    private boolean sendJumpToBizProfileReq(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg"), new StringBuilder().append(bundle.getInt("_wxapi_jump_to_biz_profile_req_scene")).toString(), new StringBuilder().append(bundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type")).toString()}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0031: INVOKE  (r10v0 android.os.Bundle), ("_wxapi_jump_to_biz_webview_req_show_type") type: VIRTUAL call: android.os.Bundle.getInt(java.lang.String):int)] */
    private boolean sendJumpToBizTempSessionReq(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizTempSession"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_webview_req_session_from"), new StringBuilder().append(bundle.getInt("_wxapi_jump_to_biz_webview_req_show_type")).toString()}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0031: INVOKE  (r10v0 android.os.Bundle), ("_wxapi_jump_to_biz_webview_req_scene") type: VIRTUAL call: android.os.Bundle.getInt(java.lang.String):int)] */
    private boolean sendJumpToBizWebviewReq(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg"), new StringBuilder().append(bundle.getInt("_wxapi_jump_to_biz_webview_req_scene")).toString()}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0026: IGET  (r10v1 com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req) com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req.miniprogramType int)] */
    private boolean sendLaunchWXMiniprogram(Context context, BaseReq baseReq) {
        WXLaunchMiniProgram.Req req = (WXLaunchMiniProgram.Req) baseReq;
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{this.appId, req.userName, req.path, new StringBuilder().append(req.miniprogramType).toString()}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendNonTaxPay(Context context, BaseReq baseReq) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "3", URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXNontaxPay.Req) baseReq).url)))}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusiLuckyMoney(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[]{this.appId, bundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), bundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), bundle.getString("_wxapi_open_busi_lucky_money_signType"), bundle.getString("_wxapi_open_busi_lucky_money_signature"), bundle.getString("_wxapi_open_busi_lucky_money_package")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenRankListReq(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
        if (query != null) {
            query.close();
            return true;
        }
        return true;
    }

    private boolean sendOpenWebview(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_webview_url"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayInSurance(Context context, BaseReq baseReq) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "4", URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXPayInsurance.Req) baseReq).url)))}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayReq(Context context, Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new MMSharedPreferences(context).getString("_wxapp_pay_entry_classname_", null);
            Log.d(TAG, "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
            if (wxappPayEntryClassname == null) {
                try {
                    wxappPayEntryClassname = context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
                } catch (Exception e) {
                    Log.e(TAG, "get from metaData failed : " + e.getMessage());
                }
            }
            if (wxappPayEntryClassname == null) {
                Log.e(TAG, "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.bundle = bundle;
        args.targetPkgName = "com.tencent.mm";
        args.targetClassName = wxappPayEntryClassname;
        return MMessageActV2.send(context, args);
    }

    private boolean sendSubscribeMessage(Context context, BaseReq baseReq) {
        SubscribeMessage.Req req = (SubscribeMessage.Req) baseReq;
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "1", String.valueOf(req.scene), req.templateID, req.reserved}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public final void detach() {
        Log.d(TAG, "detach");
        this.detached = true;
        this.context = null;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public final int getWXAppSupportAPI() {
        if (this.detached) {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
        if (!isWXAppInstalled()) {
            Log.e(TAG, "open wx app failed, not installed or signature check failed");
            return 0;
        }
        int i = new MMSharedPreferences(this.context).getInt("_build_info_sdk_int_", 0);
        if (i == 0) {
            try {
                return this.context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
            } catch (Exception e) {
                Log.e(TAG, "get from metaData failed : " + e.getMessage());
                return i;
            }
        }
        return i;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public final boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        try {
            if (!WXApiImplComm.isIntentFromWx(intent, "com.tencent.mm.openapi.token")) {
                Log.i(TAG, "handleIntent fail, intent not from weixin msg");
                return false;
            } else if (this.detached) {
                throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
            } else {
                String stringExtra = intent.getStringExtra("_mmessage_content");
                int intExtra = intent.getIntExtra("_mmessage_sdkVersion", 0);
                String stringExtra2 = intent.getStringExtra("_mmessage_appPackage");
                if (stringExtra2 == null || stringExtra2.length() == 0) {
                    Log.e(TAG, "invalid argument");
                    return false;
                } else if (!checkSumConsistent(intent.getByteArrayExtra("_mmessage_checksum"), b.a(stringExtra, intExtra, stringExtra2))) {
                    Log.e(TAG, "checksum fail");
                    return false;
                } else {
                    int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
                    Log.i(TAG, "handleIntent, cmd = " + intExtra2);
                    switch (intExtra2) {
                        case 1:
                            iWXAPIEventHandler.onResp(new SendAuth.Resp(intent.getExtras()));
                            return true;
                        case 2:
                            iWXAPIEventHandler.onResp(new SendMessageToWX.Resp(intent.getExtras()));
                            return true;
                        case 3:
                            iWXAPIEventHandler.onReq(new GetMessageFromWX.Req(intent.getExtras()));
                            return true;
                        case 4:
                            ShowMessageFromWX.Req req = new ShowMessageFromWX.Req(intent.getExtras());
                            String str = req.message.messageExt;
                            if (str == null || !str.contains("wx_internal_resptype")) {
                                iWXAPIEventHandler.onReq(req);
                                return true;
                            }
                            boolean handleWxInternalRespType = handleWxInternalRespType(str, iWXAPIEventHandler);
                            Log.i(TAG, "handleIntent, extInfo contains wx_internal_resptype, ret = " + handleWxInternalRespType);
                            return handleWxInternalRespType;
                        case 5:
                            iWXAPIEventHandler.onResp(new PayResp(intent.getExtras()));
                            return true;
                        case 6:
                            iWXAPIEventHandler.onReq(new LaunchFromWX.Req(intent.getExtras()));
                            return true;
                        case 7:
                        case 8:
                        case 10:
                        case 11:
                        case 13:
                        case 18:
                        default:
                            Log.e(TAG, "unknown cmd = " + intExtra2);
                            return false;
                        case 9:
                            iWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(intent.getExtras()));
                            return true;
                        case 12:
                            iWXAPIEventHandler.onResp(new OpenWebview.Resp(intent.getExtras()));
                            return true;
                        case 14:
                            iWXAPIEventHandler.onResp(new CreateChatroom.Resp(intent.getExtras()));
                            return true;
                        case 15:
                            iWXAPIEventHandler.onResp(new JoinChatroom.Resp(intent.getExtras()));
                            return true;
                        case 16:
                            iWXAPIEventHandler.onResp(new ChooseCardFromWXCardPackage.Resp(intent.getExtras()));
                            return true;
                        case 17:
                            iWXAPIEventHandler.onResp(new HandleScanResult.Resp(intent.getExtras()));
                            return true;
                        case 19:
                            iWXAPIEventHandler.onResp(new WXLaunchMiniProgram.Resp(intent.getExtras()));
                            return true;
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "handleIntent fail, ex = " + e.getMessage());
            return false;
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public final boolean isWXAppInstalled() {
        if (this.detached) {
            throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
            if (packageInfo == null) {
                return false;
            }
            return WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public final boolean isWXAppSupportAPI() {
        if (this.detached) {
            throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
        return getWXAppSupportAPI() >= 620823552;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public final boolean openWXApp() {
        if (this.detached) {
            throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        }
        if (!isWXAppInstalled()) {
            Log.e(TAG, "open wx app failed, not installed or signature check failed");
            return false;
        }
        try {
            this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
            return true;
        } catch (Exception e) {
            Log.e(TAG, "startActivity fail, exception = " + e.getMessage());
            return false;
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public final boolean registerApp(String str) {
        return registerApp(str, 0L);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public final boolean registerApp(String str, long j) {
        if (this.detached) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            Log.e(TAG, "register app failed for wechat app signature check failed");
            return false;
        }
        Log.d(TAG, "registerApp, appId = " + str);
        if (str != null) {
            this.appId = str;
        }
        Log.d(TAG, "registerApp, appId = " + str);
        if (str != null) {
            this.appId = str;
        }
        Log.d(TAG, "register app " + this.context.getPackageName());
        a.C0733a c0733a = new a.C0733a();
        c0733a.a = "com.tencent.mm";
        c0733a.action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
        c0733a.content = "weixin://registerapp?appid=" + this.appId;
        c0733a.b = j;
        return a.a(this.context, c0733a);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public final boolean sendReq(BaseReq baseReq) {
        String[] split;
        if (this.detached) {
            throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            Log.e(TAG, "sendReq failed for wechat app signature check failed");
            return false;
        } else if (!baseReq.checkArgs()) {
            Log.e(TAG, "sendReq checkArgs fail");
            return false;
        } else {
            Log.i(TAG, "sendReq, req type = " + baseReq.getType());
            Bundle bundle = new Bundle();
            baseReq.toBundle(bundle);
            if (baseReq.getType() == 5) {
                return sendPayReq(this.context, bundle);
            }
            if (baseReq.getType() == 7) {
                return sendJumpToBizProfileReq(this.context, bundle);
            }
            if (baseReq.getType() == 8) {
                return sendJumpToBizWebviewReq(this.context, bundle);
            }
            if (baseReq.getType() == 10) {
                return sendJumpToBizTempSessionReq(this.context, bundle);
            }
            if (baseReq.getType() == 9) {
                return sendAddCardToWX(this.context, bundle);
            }
            if (baseReq.getType() == 16) {
                return sendChooseCardFromWX(this.context, bundle);
            }
            if (baseReq.getType() == 11) {
                return sendOpenRankListReq(this.context, bundle);
            }
            if (baseReq.getType() == 12) {
                return sendOpenWebview(this.context, bundle);
            }
            if (baseReq.getType() == 13) {
                return sendOpenBusiLuckyMoney(this.context, bundle);
            }
            if (baseReq.getType() == 14) {
                return createChatroom(this.context, bundle);
            }
            if (baseReq.getType() == 15) {
                return joinChatroom(this.context, bundle);
            }
            if (baseReq.getType() == 17) {
                return sendHandleScanResult(this.context, bundle);
            }
            if (baseReq.getType() == 18) {
                return sendSubscribeMessage(this.context, baseReq);
            }
            if (baseReq.getType() == 19) {
                return sendLaunchWXMiniprogram(this.context, baseReq);
            }
            if (baseReq.getType() == 20) {
                return sendInvoiceAuthInsert(this.context, baseReq);
            }
            if (baseReq.getType() == 21) {
                return sendNonTaxPay(this.context, baseReq);
            }
            if (baseReq.getType() == 22) {
                return sendPayInSurance(this.context, baseReq);
            }
            if (baseReq.getType() == 2 && bundle.getInt("_wxapi_sendmessagetowx_req_media_type") == 36) {
                SendMessageToWX.Req req = (SendMessageToWX.Req) baseReq;
                if (getWXAppSupportAPI() < 620756993) {
                    WXWebpageObject wXWebpageObject = new WXWebpageObject();
                    wXWebpageObject.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
                    req.message.mediaObject = wXWebpageObject;
                } else {
                    WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) req.message.mediaObject;
                    wXMiniProgramObject.userName += "@app";
                    String str = wXMiniProgramObject.path;
                    if (!d.a(str)) {
                        wXMiniProgramObject.path = str.split("\\?").length > 1 ? split[0] + ".html?" + split[1] : split[0] + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                    }
                }
                req.scene = 0;
                baseReq.toBundle(bundle);
            }
            MMessageActV2.Args args = new MMessageActV2.Args();
            args.bundle = bundle;
            args.content = "weixin://sendreq?appid=" + this.appId;
            args.targetPkgName = "com.tencent.mm";
            args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return MMessageActV2.send(this.context, args);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public final boolean sendResp(BaseResp baseResp) {
        if (this.detached) {
            throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            Log.e(TAG, "sendResp failed for wechat app signature check failed");
            return false;
        } else if (!baseResp.checkArgs()) {
            Log.e(TAG, "sendResp checkArgs fail");
            return false;
        } else {
            Bundle bundle = new Bundle();
            baseResp.toBundle(bundle);
            MMessageActV2.Args args = new MMessageActV2.Args();
            args.bundle = bundle;
            args.content = "weixin://sendresp?appid=" + this.appId;
            args.targetPkgName = "com.tencent.mm";
            args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return MMessageActV2.send(this.context, args);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public final void setLogImpl(ILog iLog) {
        Log.setLogImpl(iLog);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public final void unregisterApp() {
        if (this.detached) {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            Log.e(TAG, "unregister app failed for wechat app signature check failed");
            return;
        }
        Log.d(TAG, "unregisterApp, appId = " + this.appId);
        if (this.appId == null || this.appId.length() == 0) {
            Log.e(TAG, "unregisterApp fail, appId is empty");
            return;
        }
        Log.d(TAG, "unregister app " + this.context.getPackageName());
        a.C0733a c0733a = new a.C0733a();
        c0733a.a = "com.tencent.mm";
        c0733a.action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
        c0733a.content = "weixin://unregisterapp?appid=" + this.appId;
        a.a(this.context, c0733a);
    }
}
