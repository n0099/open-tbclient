package com.sina.weibo.sdk.component;

import android.content.Context;
import android.content.Intent;
import android.net.http.Headers;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.exception.WeiboHttpException;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.NetStateManager;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.ByteArrayEntity;
/* loaded from: classes3.dex */
public class GameManager {
    public static final String DEFAULT_CHARSET = "UTF-8";
    private static final String HTTP_METHOD_GET = "GET";
    private static final String HTTP_METHOD_POST = "POST";
    private static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private static final String TAG = "GameManager";
    private static StringBuffer URL = new StringBuffer("https://api.weibo.com/2/proxy/darwin/graph/game/");
    private static final String BOUNDARY = HttpManager.getBoundry();
    private static String URL_ACHIEVEMENT_ADD_UPDATE = ((Object) URL) + "achievement/add.json";
    private static String URL_ACHIEVEMENT_RELATION_ADD_UPDATE = ((Object) URL) + "achievement/gain/add.json";
    private static String URL_ACHIEVEMENT_SCORE_ADD_UPDATE = ((Object) URL) + "score/add.json";
    private static String URL_ACHIEVEMENT_READ_PLAYER_SCORE = ((Object) URL) + "score/read_player.json";
    private static String URL_ACHIEVEMENT_READ_PLAYER_FRIENDS = ((Object) URL) + "score/read_player_friends.json";
    private static String URL_ACHIEVEMENT_USER_GAIN = ((Object) URL) + "achievement/user_gain.json";
    private static String INVITATION_URL = "http://widget.weibo.com/invitation/app.php?";
    private static String INVITATION_ONE_FRINED_URL = "http://widget.weibo.com/invitation/appinfo.php?";

    public static String AddOrUpdateGameAchievement(Context context, WeiboParameters weiboParameters) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        weiboParameters.put("updated_time", simpleDateFormat.format(date));
        if (TextUtils.isEmpty((String) weiboParameters.get(WBConstants.GAME_PARAMS_GAME_CREATE_TIME))) {
            weiboParameters.put(WBConstants.GAME_PARAMS_GAME_CREATE_TIME, simpleDateFormat.format(date));
        }
        String readRsponse = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_ADD_UPDATE, "POST", weiboParameters));
        LogUtil.d(TAG, "Response : " + readRsponse);
        return readRsponse;
    }

    public static String addOrUpdateGameAchievementRelation(Context context, WeiboParameters weiboParameters) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        weiboParameters.put("updated_time", simpleDateFormat.format(date));
        if (TextUtils.isEmpty((String) weiboParameters.get(WBConstants.GAME_PARAMS_GAME_CREATE_TIME))) {
            weiboParameters.put(WBConstants.GAME_PARAMS_GAME_CREATE_TIME, simpleDateFormat.format(date));
        }
        String readRsponse = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_RELATION_ADD_UPDATE, "POST", weiboParameters));
        LogUtil.d(TAG, "Response : " + readRsponse);
        return readRsponse;
    }

    public static String addOrUpdateAchievementScore(Context context, String str, String str2, String str3, String str4, String str5) {
        WeiboParameters weiboParameters = new WeiboParameters("");
        if (!TextUtils.isEmpty(str)) {
            weiboParameters.put("access_token", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            weiboParameters.put("source", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            weiboParameters.put(WBConstants.GAME_PARAMS_GAME_ID, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            weiboParameters.put("uid", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            weiboParameters.put(WBConstants.GAME_PARAMS_SCORE, str5);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        weiboParameters.put("updated_time", simpleDateFormat.format(date));
        if (TextUtils.isEmpty((String) weiboParameters.get(WBConstants.GAME_PARAMS_GAME_CREATE_TIME))) {
            weiboParameters.put(WBConstants.GAME_PARAMS_GAME_CREATE_TIME, simpleDateFormat.format(date));
        }
        String readRsponse = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_SCORE_ADD_UPDATE, "POST", weiboParameters));
        LogUtil.d(TAG, "Response : " + readRsponse);
        return readRsponse;
    }

    public static String readPlayerScoreInfo(Context context, String str, String str2, String str3, String str4) {
        WeiboParameters weiboParameters = new WeiboParameters("");
        if (!TextUtils.isEmpty(str)) {
            weiboParameters.put("access_token", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            weiboParameters.put("source", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            weiboParameters.put(WBConstants.GAME_PARAMS_GAME_ID, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            weiboParameters.put("uid", str4);
        }
        String readRsponse = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_READ_PLAYER_SCORE, "GET", weiboParameters));
        LogUtil.d(TAG, "Response : " + readRsponse);
        return readRsponse;
    }

    public static String readPlayerFriendsScoreInfo(Context context, String str, String str2, String str3, String str4) {
        WeiboParameters weiboParameters = new WeiboParameters("");
        if (!TextUtils.isEmpty(str)) {
            weiboParameters.put("access_token", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            weiboParameters.put("source", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            weiboParameters.put(WBConstants.GAME_PARAMS_GAME_ID, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            weiboParameters.put("uid", str4);
        }
        weiboParameters.put(WBConstants.GAME_PARAMS_GAME_CREATE_TIME, new Timestamp(new Date().getTime()));
        String readRsponse = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_READ_PLAYER_FRIENDS, "GET", weiboParameters));
        LogUtil.d(TAG, "Response : " + readRsponse);
        return readRsponse;
    }

    public static String readPlayerAchievementGain(Context context, String str, String str2, String str3, String str4) {
        WeiboParameters weiboParameters = new WeiboParameters("");
        if (!TextUtils.isEmpty(str)) {
            weiboParameters.put("access_token", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            weiboParameters.put("source", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            weiboParameters.put(WBConstants.GAME_PARAMS_GAME_ID, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            weiboParameters.put("uid", str4);
        }
        weiboParameters.put(WBConstants.GAME_PARAMS_GAME_CREATE_TIME, new Timestamp(new Date().getTime()));
        String readRsponse = HttpManager.readRsponse(requestHttpExecute(context, URL_ACHIEVEMENT_USER_GAIN, "GET", weiboParameters));
        LogUtil.d(TAG, "Response : " + readRsponse);
        return readRsponse;
    }

    public void invatationWeiboFriendsByList(Context context, String str, String str2, String str3, WeiboAuthListener weiboAuthListener) {
        WeiboParameters weiboParameters = new WeiboParameters(str2);
        weiboParameters.put("access_token", str);
        weiboParameters.put("source", str2);
        GameRequestParam gameRequestParam = new GameRequestParam(context);
        gameRequestParam.setAppKey(str2);
        gameRequestParam.setToken(str);
        gameRequestParam.setLauncher(BrowserLauncher.GAME);
        gameRequestParam.setUrl(String.valueOf(INVITATION_URL.toString()) + weiboParameters.encodeUrl());
        gameRequestParam.setAuthListener(weiboAuthListener);
        Intent intent = new Intent(context, WeiboSdkBrowser.class);
        Bundle createRequestParamBundle = gameRequestParam.createRequestParamBundle();
        createRequestParamBundle.putString("key_specify_title", str3);
        intent.putExtras(createRequestParamBundle);
        context.startActivity(intent);
    }

    public void invatationWeiboFriendsInOnePage(Context context, String str, String str2, String str3, WeiboAuthListener weiboAuthListener, ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                String str4 = arrayList.get(i2);
                if (i2 == 0) {
                    stringBuffer.append(str4);
                } else {
                    stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP + str4);
                }
                i = i2 + 1;
            }
        }
        WeiboParameters weiboParameters = new WeiboParameters(str2);
        weiboParameters.put("access_token", str);
        weiboParameters.put("source", str2);
        GameRequestParam gameRequestParam = new GameRequestParam(context);
        gameRequestParam.setAppKey(str2);
        gameRequestParam.setToken(str);
        gameRequestParam.setLauncher(BrowserLauncher.GAME);
        gameRequestParam.setUrl(String.valueOf(INVITATION_ONE_FRINED_URL.toString()) + weiboParameters.encodeUrl() + "&uids=" + stringBuffer.toString());
        gameRequestParam.setAuthListener(weiboAuthListener);
        Intent intent = new Intent(context, WeiboSdkBrowser.class);
        Bundle createRequestParamBundle = gameRequestParam.createRequestParamBundle();
        createRequestParamBundle.putString("key_specify_title", str3);
        intent.putExtras(createRequestParamBundle);
        context.startActivity(intent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [442=4] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static HttpResponse requestHttpExecute(Context context, String str, String str2, WeiboParameters weiboParameters) {
        HttpClient httpClient;
        HttpClient httpClient2;
        HttpUriRequest httpDelete;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            httpClient = HttpManager.getNewHttpClient();
            try {
                httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, NetStateManager.getAPN());
                if (str2.equals("GET")) {
                    String str3 = String.valueOf(str) + "?" + weiboParameters.encodeUrl();
                    httpDelete = new HttpGet(str3);
                    LogUtil.d(TAG, "requestHttpExecute GET Url : " + str3);
                } else if (str2.equals("POST")) {
                    LogUtil.d(TAG, "requestHttpExecute POST Url : " + str);
                    HttpPost httpPost = new HttpPost(str);
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        if (weiboParameters.hasBinaryData()) {
                            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
                            HttpManager.buildParams(byteArrayOutputStream2, weiboParameters);
                        } else {
                            Object obj = weiboParameters.get(Headers.CONTENT_TYPE);
                            if (obj == null || !(obj instanceof String)) {
                                httpPost.setHeader("Content-Type", URLEncodedUtils.CONTENT_TYPE);
                            } else {
                                weiboParameters.remove(Headers.CONTENT_TYPE);
                                httpPost.setHeader("Content-Type", (String) obj);
                            }
                            String encodeUrl = weiboParameters.encodeUrl();
                            LogUtil.d(TAG, "requestHttpExecute POST postParam : " + encodeUrl);
                            byteArrayOutputStream2.write(encodeUrl.getBytes("UTF-8"));
                        }
                        httpPost.setEntity(new ByteArrayEntity(byteArrayOutputStream2.toByteArray()));
                        httpDelete = httpPost;
                        byteArrayOutputStream = byteArrayOutputStream2;
                    } catch (IOException e) {
                        e = e;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        httpClient2 = httpClient;
                        try {
                            throw new WeiboException(e);
                        } catch (Throwable th) {
                            th = th;
                            httpClient = httpClient2;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                            HttpManager.shutdownHttpClient(httpClient);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        if (byteArrayOutputStream != null) {
                        }
                        HttpManager.shutdownHttpClient(httpClient);
                        throw th;
                    }
                } else {
                    httpDelete = str2.equals(HttpDelete.METHOD_NAME) ? new HttpDelete(str) : null;
                }
                HttpResponse execute = httpClient.execute(httpDelete);
                int statusCode = execute.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    throw new WeiboHttpException(HttpManager.readRsponse(execute), statusCode);
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                HttpManager.shutdownHttpClient(httpClient);
                return execute;
            } catch (IOException e4) {
                e = e4;
                httpClient2 = httpClient;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e5) {
            e = e5;
            httpClient2 = null;
        } catch (Throwable th4) {
            th = th4;
            httpClient = null;
        }
    }
}
