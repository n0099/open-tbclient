package com.sina.weibo.sdk.network.intercept;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.network.IRequestIntercept;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.network.IRequestService;
import com.sina.weibo.sdk.network.exception.InterceptException;
import com.sina.weibo.sdk.network.impl.RequestParam;
import com.sina.weibo.sdk.network.impl.RequestService;
import org.apache.http.auth.AUTH;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RequestTokenInterception implements IRequestIntercept {
    private static String token;
    private final String REFRESH_ACTION = "refresh_action";
    private final String WEIBO_SDK_REFRESH_TOKEN_FILE = "weibo_sdk_refresh_token_done";
    private final String WEIBO_SDK_TOKEN_KEY = "weibo_sdk_token_key_done";
    private final String WEIBO_SDK_TOKEN_TIME = "video_refresh_token_time_done";

    @Override // com.sina.weibo.sdk.network.IRequestIntercept
    public boolean needIntercept(IRequestParam iRequestParam, Bundle bundle) {
        if (iRequestParam.getUrl().equals("https://ug.edm.weibo.cn/api/gettoken") || iRequestParam.getUrl().equals("https://ug.edm.weibo.cn/api/refreshtoken")) {
            return false;
        }
        if (iRequestParam.getContext() != null) {
            SharedPreferences sharedPreferences = iRequestParam.getContext().getSharedPreferences("weibo_sdk_refresh_token_done", 0);
            if (TextUtils.isEmpty(token)) {
                token = sharedPreferences.getString("weibo_sdk_token_key_done", null);
            }
            if (TextUtils.isEmpty(token)) {
                iRequestParam.addInterceptResult("refresh_action", 0);
                return true;
            }
            long j = sharedPreferences.getLong("video_refresh_token_time_done", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (j > currentTimeMillis + 1209600 || j == 0) {
                iRequestParam.addInterceptResult("refresh_action", 0);
                return true;
            } else if (j > 604800 + currentTimeMillis && j < currentTimeMillis + 1209600) {
                iRequestParam.addInterceptResult("refresh_action", 1);
                return true;
            } else {
                iRequestParam.getHeader().putString(AUTH.WWW_AUTH_RESP, "Bearer {" + token + "}");
                return false;
            }
        }
        return true;
    }

    @Override // com.sina.weibo.sdk.network.IRequestIntercept
    public boolean doIntercept(IRequestParam iRequestParam, Bundle bundle) throws InterceptException {
        int i;
        if (iRequestParam.getContext() == null) {
            throw new InterceptException("上下文设置为null");
        }
        try {
            i = ((Integer) iRequestParam.getInterceptResult("refresh_action")).intValue();
        } catch (Exception e) {
            i = 0;
        }
        IRequestService requestService = RequestService.getInstance();
        RequestParam.Builder builder = new RequestParam.Builder(iRequestParam.getContext());
        SharedPreferences sharedPreferences = iRequestParam.getContext().getSharedPreferences("weibo_sdk_refresh_token_done", 0);
        builder.addPostParam("email", "liwei31@staff.weibo.com");
        builder.addPostParam("password", "8eVZQVioD11DiZoZ5saqmttJJfqgHBockRY4GBXsbfc");
        builder.setNeedIntercept(false);
        if (i == 0) {
            builder.setShortUrl("https://ug.edm.weibo.cn/api/gettoken");
        } else {
            token = sharedPreferences.getString("weibo_sdk_token_key_done", null);
            iRequestParam.getHeader().putString(AUTH.WWW_AUTH_RESP, "Bearer {" + token + "}");
            builder.setShortUrl("https://ug.edm.weibo.cn/api/refreshtoken");
        }
        builder.setRequestType(IRequestParam.RequestType.POST);
        try {
            String valueOf = String.valueOf(requestService.request(builder.build()).getResponse());
            JSONObject jSONObject = new JSONObject(valueOf);
            if ("1".equals(jSONObject.optString("status"))) {
                String optString = jSONObject.optString("data");
                long optLong = jSONObject.optLong("expire", 0L);
                if (!TextUtils.isEmpty(optString)) {
                    token = optString;
                    sharedPreferences.edit().putString("weibo_sdk_token_key_done", token).commit();
                    sharedPreferences.edit().putLong("video_refresh_token_time_done", optLong).commit();
                    return false;
                }
                throw new InterceptException("刷新token接口请求异常 action = " + i + "  result = " + valueOf);
            }
            throw new InterceptException("刷新token接口请求异常 action = " + i + "  result = " + valueOf);
        } catch (Exception e2) {
            throw new InterceptException("刷新token接口请求异常 action = " + i + "  error = " + e2.toString());
        }
    }
}
