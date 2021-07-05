package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
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
import com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.LaunchFromWX;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class BaseWXApiImplV10 implements IWXAPI {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    public static String wxappPayEntryClassname;
    public transient /* synthetic */ FieldHolder $fh;
    public String appId;
    public boolean checkSignature;
    public Context context;
    public boolean detached;
    public int wxSdkVersion;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1963137253, "Lcom/tencent/mm/opensdk/openapi/BaseWXApiImplV10;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1963137253, "Lcom/tencent/mm/opensdk/openapi/BaseWXApiImplV10;");
        }
    }

    public BaseWXApiImplV10(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.checkSignature = false;
        this.detached = false;
        Log.d("MicroMsg.SDK.WXApiImplV10", "<init>, appId = " + str + ", checkSignature = " + z);
        this.context = context;
        this.appId = str;
        this.checkSignature = z;
        d.D = context.getApplicationContext();
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, bArr, bArr2)) == null) {
            if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
                str = "checkSumConsistent fail, invalid arguments";
            } else if (bArr.length == bArr2.length) {
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    if (bArr[i2] != bArr2[i2]) {
                        return false;
                    }
                }
                return true;
            } else {
                str = "checkSumConsistent fail, length is different";
            }
            Log.e("MicroMsg.SDK.WXApiImplV10", str);
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean createChatroom(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, this, context, bundle)) == null) {
            launchWXIfNeed();
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_create_chatroom_group_id", ""), bundle.getString("_wxapi_create_chatroom_chatroom_name", ""), bundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_create_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private String getTokenFromWX(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk"), null, null, new String[]{this.appId, "621086720"}, null);
            if (query == null || !query.moveToFirst()) {
                return null;
            }
            String string = query.getString(0);
            Log.i("MicroMsg.SDK.WXApiImplV10", "getTokenFromWX token is " + string);
            query.close();
            return string;
        }
        return (String) invokeL.objValue;
    }

    private boolean handleWxInternalRespType(String str, IWXAPIEventHandler iWXAPIEventHandler) {
        InterceptResult invokeLL;
        Uri parse;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, str, iWXAPIEventHandler)) == null) {
            Log.i("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType, extInfo = " + str);
            try {
                parse = Uri.parse(str);
                queryParameter = parse.getQueryParameter("wx_internal_resptype");
                Log.i("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType, respType = " + queryParameter);
            } catch (Exception e2) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType fail, ex = " + e2.getMessage());
            }
            if (d.b(queryParameter)) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType fail, respType is null");
                return false;
            } else if (queryParameter.equals("subscribemessage")) {
                SubscribeMessage.Resp resp = new SubscribeMessage.Resp();
                String queryParameter2 = parse.getQueryParameter(Constants.KEYS.RET);
                if (queryParameter2 != null && queryParameter2.length() > 0) {
                    resp.errCode = d.c(queryParameter2);
                }
                resp.openId = parse.getQueryParameter("openid");
                resp.templateID = parse.getQueryParameter("template_id");
                resp.scene = d.c(parse.getQueryParameter("scene"));
                resp.action = parse.getQueryParameter("action");
                resp.reserved = parse.getQueryParameter(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED);
                iWXAPIEventHandler.onResp(resp);
                return true;
            } else if (queryParameter.contains("invoice_auth_insert")) {
                WXInvoiceAuthInsert.Resp resp2 = new WXInvoiceAuthInsert.Resp();
                String queryParameter3 = parse.getQueryParameter(Constants.KEYS.RET);
                if (queryParameter3 != null && queryParameter3.length() > 0) {
                    resp2.errCode = d.c(queryParameter3);
                }
                resp2.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp2);
                return true;
            } else if (queryParameter.contains("payinsurance")) {
                WXPayInsurance.Resp resp3 = new WXPayInsurance.Resp();
                String queryParameter4 = parse.getQueryParameter(Constants.KEYS.RET);
                if (queryParameter4 != null && queryParameter4.length() > 0) {
                    resp3.errCode = d.c(queryParameter4);
                }
                resp3.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp3);
                return true;
            } else if (queryParameter.contains("nontaxpay")) {
                WXNontaxPay.Resp resp4 = new WXNontaxPay.Resp();
                String queryParameter5 = parse.getQueryParameter(Constants.KEYS.RET);
                if (queryParameter5 != null && queryParameter5.length() > 0) {
                    resp4.errCode = d.c(queryParameter5);
                }
                resp4.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp4);
                return true;
            } else {
                if (!"subscribeminiprogrammsg".equals(queryParameter) && !"5".equals(queryParameter)) {
                    Log.e("MicroMsg.SDK.WXApiImplV10", "this open sdk version not support the request type");
                    return false;
                }
                SubscribeMiniProgramMsg.Resp resp5 = new SubscribeMiniProgramMsg.Resp();
                String queryParameter6 = parse.getQueryParameter(Constants.KEYS.RET);
                if (queryParameter6 != null && queryParameter6.length() > 0) {
                    resp5.errCode = d.c(queryParameter6);
                }
                resp5.openId = parse.getQueryParameter("openid");
                resp5.unionId = parse.getQueryParameter("unionid");
                resp5.nickname = parse.getQueryParameter("nickname");
                resp5.errStr = parse.getQueryParameter("errmsg");
                iWXAPIEventHandler.onResp(resp5);
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    private boolean joinChatroom(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, context, bundle)) == null) {
            launchWXIfNeed();
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_join_chatroom_group_id", ""), bundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_join_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private void launchWXIfNeed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        Log.i("MicroMsg.SDK.WXApiImplV10", "openWXApp before api call");
        openWXApp();
    }

    private boolean sendAddCardToWX(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, context, bundle)) == null) {
            launchWXIfNeed();
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean sendChooseCardFromWX(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, context, bundle)) == null) {
            launchWXIfNeed();
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[]{bundle.getString("_wxapi_choose_card_from_wx_card_app_id"), bundle.getString("_wxapi_choose_card_from_wx_card_location_id"), bundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), bundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), bundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), bundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), bundle.getString("_wxapi_choose_card_from_wx_card_card_id"), bundle.getString("_wxapi_choose_card_from_wx_card_card_type"), bundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), bundle.getString("_wxapi_basereq_transaction")}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean sendHandleScanResult(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, context, bundle)) == null) {
            launchWXIfNeed();
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[]{this.appId, bundle.getString("_wxapi_scan_qrcode_result")}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean sendInvoiceAuthInsert(Context context, BaseReq baseReq) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, context, baseReq)) == null) {
            launchWXIfNeed();
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "2", URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXInvoiceAuthInsert.Req) baseReq).url)))}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean sendJumpToOfflinePayReq(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, context, bundle)) == null) {
            launchWXIfNeed();
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToOfflinePay"), null, null, new String[]{this.appId}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x002a: IGET  (r2v2 int A[REMOVE]) = (r9v1 com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req) com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req.miniprogramType int)] */
    private boolean sendLaunchWXMiniprogram(Context context, BaseReq baseReq) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, context, baseReq)) == null) {
            launchWXIfNeed();
            WXLaunchMiniProgram.Req req = (WXLaunchMiniProgram.Req) baseReq;
            ContentResolver contentResolver = context.getContentResolver();
            Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram");
            StringBuilder sb = new StringBuilder();
            sb.append(req.miniprogramType);
            Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, req.userName, req.path, sb.toString(), req.extData}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean sendLaunchWXMiniprogramWithToken(Context context, BaseReq baseReq) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, this, context, baseReq)) == null) {
            launchWXIfNeed();
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogramWithToken"), null, null, new String[]{this.appId, ((WXLaunchMiniProgramWithToken.Req) baseReq).token}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean sendNonTaxPay(Context context, BaseReq baseReq) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, context, baseReq)) == null) {
            launchWXIfNeed();
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "3", URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXNontaxPay.Req) baseReq).url)))}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean sendOpenBusiLuckyMoney(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, this, context, bundle)) == null) {
            launchWXIfNeed();
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[]{this.appId, bundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), bundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), bundle.getString("_wxapi_open_busi_lucky_money_signType"), bundle.getString("_wxapi_open_busi_lucky_money_signature"), bundle.getString("_wxapi_open_busi_lucky_money_package")}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean sendOpenBusinessView(Context context, BaseReq baseReq) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, this, context, baseReq)) == null) {
            launchWXIfNeed();
            WXOpenBusinessView.Req req = (WXOpenBusinessView.Req) baseReq;
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessView"), null, null, new String[]{this.appId, req.businessType, req.query, req.extInfo, req.transaction}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0038: IGET  (r9v2 int A[REMOVE]) = (r9v1 com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview$Req) com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview.Req.businessType int)] */
    private boolean sendOpenBusinessWebview(Context context, BaseReq baseReq) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, this, context, baseReq)) == null) {
            launchWXIfNeed();
            WXOpenBusinessWebview.Req req = (WXOpenBusinessWebview.Req) baseReq;
            ContentResolver contentResolver = context.getContentResolver();
            Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessWebview");
            HashMap<String, String> hashMap = req.queryInfo;
            String jSONObject = (hashMap == null || hashMap.size() <= 0) ? "" : new JSONObject(req.queryInfo).toString();
            StringBuilder sb = new StringBuilder();
            sb.append(req.businessType);
            Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, sb.toString(), jSONObject}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean sendOpenRankListReq(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, this, context, bundle)) == null) {
            launchWXIfNeed();
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
            if (query != null) {
                query.close();
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean sendOpenWebview(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, this, context, bundle)) == null) {
            launchWXIfNeed();
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_webview_url"), bundle.getString("_wxapi_basereq_transaction")}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean sendPayInSurance(Context context, BaseReq baseReq) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, this, context, baseReq)) == null) {
            launchWXIfNeed();
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "4", URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXPayInsurance.Req) baseReq).url)))}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean sendPayReq(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, this, context, bundle)) == null) {
            if (wxappPayEntryClassname == null) {
                wxappPayEntryClassname = new MMSharedPreferences(context).getString("_wxapp_pay_entry_classname_", null);
                Log.d("MicroMsg.SDK.WXApiImplV10", "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
                if (wxappPayEntryClassname == null) {
                    try {
                        wxappPayEntryClassname = context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.SDK.WXApiImplV10", "get from metaData failed : " + e2.getMessage());
                    }
                }
                if (wxappPayEntryClassname == null) {
                    Log.e("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
                    return false;
                }
            }
            MMessageActV2.Args args = new MMessageActV2.Args();
            args.bundle = bundle;
            args.targetPkgName = "com.tencent.mm";
            args.targetClassName = wxappPayEntryClassname;
            return MMessageActV2.send(context, args);
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0027: IGET  (r2v2 int A[REMOVE]) = (r9v1 com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram$Req) com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram.Req.miniprogramType int)] */
    private boolean sendPreloadWXMiniprogram(Context context, BaseReq baseReq) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, this, context, baseReq)) == null) {
            WXPreloadMiniProgram.Req req = (WXPreloadMiniProgram.Req) baseReq;
            ContentResolver contentResolver = context.getContentResolver();
            Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogram");
            StringBuilder sb = new StringBuilder();
            sb.append(req.miniprogramType);
            Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, req.userName, req.path, sb.toString(), req.extData}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean sendSubscribeMessage(Context context, BaseReq baseReq) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, this, context, baseReq)) == null) {
            launchWXIfNeed();
            SubscribeMessage.Req req = (SubscribeMessage.Req) baseReq;
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "1", String.valueOf(req.scene), req.templateID, req.reserved}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean sendSubscribeMiniProgramMsg(Context context, BaseReq baseReq) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, this, context, baseReq)) == null) {
            launchWXIfNeed();
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "5", ((SubscribeMiniProgramMsg.Req) baseReq).miniProgramAppId}, null);
            if (query != null) {
                query.close();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void detach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.d("MicroMsg.SDK.WXApiImplV10", "detach");
            this.detached = true;
            this.context = null;
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public int getWXAppSupportAPI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.detached) {
                throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
            }
            if (!isWXAppInstalled()) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
                return 0;
            }
            this.wxSdkVersion = 0;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            d.H.submit(new Runnable(this, countDownLatch) { // from class: com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseWXApiImplV10 this$0;
                public final /* synthetic */ CountDownLatch val$countDownWait;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, countDownLatch};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$countDownWait = countDownLatch;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            MMSharedPreferences mMSharedPreferences = new MMSharedPreferences(this.this$0.context);
                            this.this$0.wxSdkVersion = mMSharedPreferences.getInt("_build_info_sdk_int_", 0);
                        } catch (Exception e2) {
                            Log.w("MicroMsg.SDK.WXApiImplV10", e2.getMessage());
                        }
                        this.val$countDownWait.countDown();
                    }
                }
            });
            try {
                countDownLatch.await(1000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                Log.w("MicroMsg.SDK.WXApiImplV10", e2.getMessage());
            }
            Log.d("MicroMsg.SDK.WXApiImplV10", "wxSdkVersion = " + this.wxSdkVersion);
            if (this.wxSdkVersion == 0) {
                try {
                    this.wxSdkVersion = this.context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
                    Log.d("MicroMsg.SDK.WXApiImplV10", "OPEN_SDK_VERSION = " + this.wxSdkVersion);
                } catch (Exception e3) {
                    Log.e("MicroMsg.SDK.WXApiImplV10", "get from metaData failed : " + e3.getMessage());
                }
            }
            return this.wxSdkVersion;
        }
        return invokeV.intValue;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, intent, iWXAPIEventHandler)) == null) {
            try {
            } catch (Exception e2) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, ex = " + e2.getMessage());
            }
            if (!WXApiImplComm.isIntentFromWx(intent, "com.tencent.mm.openapi.token")) {
                Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
                return false;
            } else if (this.detached) {
                throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
            } else {
                String stringExtra = intent.getStringExtra("_mmessage_content");
                int intExtra = intent.getIntExtra("_mmessage_sdkVersion", 0);
                String stringExtra2 = intent.getStringExtra("_mmessage_appPackage");
                if (stringExtra2 != null && stringExtra2.length() != 0) {
                    if (!checkSumConsistent(intent.getByteArrayExtra("_mmessage_checksum"), b.a(stringExtra, intExtra, stringExtra2))) {
                        Log.e("MicroMsg.SDK.WXApiImplV10", "checksum fail");
                        return false;
                    }
                    int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
                    Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent, cmd = " + intExtra2);
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
                            if (str != null && str.contains("wx_internal_resptype")) {
                                boolean handleWxInternalRespType = handleWxInternalRespType(str, iWXAPIEventHandler);
                                Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent, extInfo contains wx_internal_resptype, ret = " + handleWxInternalRespType);
                                return handleWxInternalRespType;
                            }
                            if (str != null && str.contains("openbusinesswebview")) {
                                try {
                                    Uri parse = Uri.parse(str);
                                    if (parse != null && "openbusinesswebview".equals(parse.getHost())) {
                                        WXOpenBusinessWebview.Resp resp = new WXOpenBusinessWebview.Resp();
                                        String queryParameter = parse.getQueryParameter(Constants.KEYS.RET);
                                        if (queryParameter != null && queryParameter.length() > 0) {
                                            resp.errCode = d.c(queryParameter);
                                        }
                                        resp.resultInfo = parse.getQueryParameter("resultInfo");
                                        resp.errStr = parse.getQueryParameter("errmsg");
                                        String queryParameter2 = parse.getQueryParameter("type");
                                        if (queryParameter2 != null && queryParameter2.length() > 0) {
                                            resp.businessType = d.c(queryParameter2);
                                        }
                                        iWXAPIEventHandler.onResp(resp);
                                        return true;
                                    }
                                    Log.d("MicroMsg.SDK.WXApiImplV10", "not openbusinesswebview %" + str);
                                } catch (Exception e3) {
                                    Log.e("MicroMsg.SDK.WXApiImplV10", "parse fail, ex = " + e3.getMessage());
                                }
                            }
                            iWXAPIEventHandler.onReq(req);
                            return true;
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
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        default:
                            Log.e("MicroMsg.SDK.WXApiImplV10", "unknown cmd = " + intExtra2);
                            break;
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
                        case 24:
                            iWXAPIEventHandler.onResp(new JumpToOfflinePay.Resp(intent.getExtras()));
                            return true;
                        case 25:
                            iWXAPIEventHandler.onResp(new WXOpenBusinessWebview.Resp(intent.getExtras()));
                            return true;
                        case 26:
                            iWXAPIEventHandler.onResp(new WXOpenBusinessView.Resp(intent.getExtras()));
                            return true;
                        case 27:
                            iWXAPIEventHandler.onResp(new WXJointPay.JointPayResp(intent.getExtras()));
                            return true;
                        case 28:
                            iWXAPIEventHandler.onResp(new WXPreloadMiniProgram.Resp(intent.getExtras()));
                            return true;
                        case 29:
                            iWXAPIEventHandler.onResp(new WXLaunchMiniProgramWithToken.Resp(intent.getExtras()));
                            return true;
                    }
                    return false;
                }
                Log.e("MicroMsg.SDK.WXApiImplV10", "invalid argument");
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean isWXAppInstalled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.detached) {
                throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
            }
            try {
                PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
                if (packageInfo == null) {
                    return false;
                }
                return WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean openWXApp() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.detached) {
                throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
            }
            if (isWXAppInstalled()) {
                try {
                    this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
                    return true;
                } catch (Exception e2) {
                    str = "startActivity fail, exception = " + e2.getMessage();
                }
            } else {
                str = "open wx app failed, not installed or signature check failed";
            }
            Log.e("MicroMsg.SDK.WXApiImplV10", str);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean registerApp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? registerApp(str, 0L) : invokeL.booleanValue;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean registerApp(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j)) == null) {
            if (this.detached) {
                throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
            }
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
                return false;
            }
            Log.d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = " + str);
            if (str != null) {
                this.appId = str;
            }
            Log.d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = " + str);
            if (str != null) {
                this.appId = str;
            }
            Log.d("MicroMsg.SDK.WXApiImplV10", "register app " + this.context.getPackageName());
            a.C0557a c0557a = new a.C0557a();
            c0557a.f41818a = "com.tencent.mm";
            c0557a.action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
            c0557a.content = "weixin://registerapp?appid=" + this.appId;
            c0557a.f41819b = j;
            return a.a(this.context, c0557a);
        }
        return invokeLJ.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x020e  */
    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean sendReq(BaseReq baseReq) {
        InterceptResult invokeL;
        StringBuilder sb;
        String str;
        WXWebpageObject wXWebpageObject;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, baseReq)) == null) {
            if (this.detached) {
                throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
            }
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
                str2 = "sendReq failed for wechat app signature check failed";
            } else if (baseReq.checkArgs()) {
                Log.i("MicroMsg.SDK.WXApiImplV10", "sendReq, req type = " + baseReq.getType());
                Bundle bundle = new Bundle();
                baseReq.toBundle(bundle);
                if (baseReq.getType() == 5 || baseReq.getType() == 27) {
                    return sendPayReq(this.context, bundle);
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
                if (baseReq.getType() == 25) {
                    return sendOpenBusinessWebview(this.context, baseReq);
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
                if (baseReq.getType() == 28) {
                    return sendPreloadWXMiniprogram(this.context, baseReq);
                }
                if (baseReq.getType() == 29) {
                    return sendLaunchWXMiniprogramWithToken(this.context, baseReq);
                }
                if (baseReq.getType() == 23) {
                    return sendSubscribeMiniProgramMsg(this.context, baseReq);
                }
                if (baseReq.getType() == 19) {
                    return sendLaunchWXMiniprogram(this.context, baseReq);
                }
                if (baseReq.getType() == 26) {
                    return sendOpenBusinessView(this.context, baseReq);
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
                if (baseReq.getType() == 24) {
                    return sendJumpToOfflinePayReq(this.context, bundle);
                }
                if (baseReq.getType() == 2) {
                    SendMessageToWX.Req req = (SendMessageToWX.Req) baseReq;
                    int type = req.message.getType();
                    if (d.a(type)) {
                        if (getWXAppSupportAPI() < 620756993) {
                            wXWebpageObject = new WXWebpageObject();
                        } else if (type != 46 || getWXAppSupportAPI() >= 620953856) {
                            WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) req.message.mediaObject;
                            wXMiniProgramObject.userName += "@app";
                            String str3 = wXMiniProgramObject.path;
                            if (!d.b(str3)) {
                                String[] split = str3.split("\\?");
                                if (split.length > 1) {
                                    sb = new StringBuilder();
                                    sb.append(split[0]);
                                    sb.append(".html?");
                                    str = split[1];
                                } else {
                                    sb = new StringBuilder();
                                    sb.append(split[0]);
                                    str = DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                                }
                                sb.append(str);
                                wXMiniProgramObject.path = sb.toString();
                            }
                            if (req.scene != 3) {
                                req.scene = 0;
                            }
                            baseReq.toBundle(bundle);
                        } else {
                            wXWebpageObject = new WXWebpageObject();
                        }
                        wXWebpageObject.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
                        req.message.mediaObject = wXWebpageObject;
                        if (req.scene != 3) {
                        }
                        baseReq.toBundle(bundle);
                    }
                }
                MMessageActV2.Args args = new MMessageActV2.Args();
                args.bundle = bundle;
                args.content = "weixin://sendreq?appid=" + this.appId;
                args.targetPkgName = "com.tencent.mm";
                args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                if (baseReq.getType() == 2) {
                    try {
                        args.token = getTokenFromWX(this.context);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.SDK.WXApiImplV10", "getTokenFromWX fail, exception = " + e2.getMessage());
                    }
                }
                return MMessageActV2.send(this.context, args);
            } else {
                str2 = "sendReq checkArgs fail";
            }
            Log.e("MicroMsg.SDK.WXApiImplV10", str2);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean sendResp(BaseResp baseResp) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, baseResp)) == null) {
            if (this.detached) {
                throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
            }
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
                str = "sendResp failed for wechat app signature check failed";
            } else if (baseResp.checkArgs()) {
                Bundle bundle = new Bundle();
                baseResp.toBundle(bundle);
                MMessageActV2.Args args = new MMessageActV2.Args();
                args.bundle = bundle;
                args.content = "weixin://sendresp?appid=" + this.appId;
                args.targetPkgName = "com.tencent.mm";
                args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                return MMessageActV2.send(this.context, args);
            } else {
                str = "sendResp checkArgs fail";
            }
            Log.e("MicroMsg.SDK.WXApiImplV10", str);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void setLogImpl(ILog iLog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iLog) == null) {
            Log.setLogImpl(iLog);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void unregisterApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.detached) {
                throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
            }
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
                return;
            }
            Log.d("MicroMsg.SDK.WXApiImplV10", "unregisterApp, appId = " + this.appId);
            String str = this.appId;
            if (str == null || str.length() == 0) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
                return;
            }
            Log.d("MicroMsg.SDK.WXApiImplV10", "unregister app " + this.context.getPackageName());
            a.C0557a c0557a = new a.C0557a();
            c0557a.f41818a = "com.tencent.mm";
            c0557a.action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
            c0557a.content = "weixin://unregisterapp?appid=" + this.appId;
            a.a(this.context, c0557a);
        }
    }
}
