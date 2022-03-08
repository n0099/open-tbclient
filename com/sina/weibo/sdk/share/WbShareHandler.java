package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.FileUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.utils.WbSdkVersion;
import com.sina.weibo.sdk.web.WebRequestType;
import com.sina.weibo.sdk.web.param.ShareWebViewRequestParam;
/* loaded from: classes8.dex */
public class WbShareHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int WB_SHARE_REQUEST = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity context;
    public boolean hasRegister;
    public int progressColor;
    public int progressId;

    public WbShareHandler(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hasRegister = false;
        this.progressColor = -1;
        this.progressId = -1;
        this.context = activity;
    }

    private void sendBroadcast(Context context, String str, String str2, String str3, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, this, context, str, str2, str3, bundle) == null) {
            Intent intent = new Intent(str);
            String packageName = context.getPackageName();
            intent.putExtra(WBConstants.Base.SDK_VER, WbSdkVersion.WEIBO_SDK_VERSION_CODE);
            intent.putExtra(WBConstants.Base.APP_PKG, packageName);
            intent.putExtra(WBConstants.Base.APP_KEY, str2);
            intent.putExtra(WBConstants.SDK.FLAG, WBConstants.WEIBO_FLAG_SDK);
            intent.putExtra(WBConstants.SIGN, MD5.hexdigest(Utility.getSign(context, packageName)));
            if (!TextUtils.isEmpty(str3)) {
                intent.setPackage(str3);
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            context.sendBroadcast(intent, WBConstants.ACTION_WEIBO_SDK_PERMISSION);
        }
    }

    private void startClientShare(WeiboMultiMessage weiboMultiMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, weiboMultiMessage) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(WBConstants.COMMAND_TYPE_KEY, 1);
            bundle.putString(WBConstants.TRAN, String.valueOf(System.currentTimeMillis()));
            bundle.putLong(WBConstants.SHARE_CALLBACK_ID, 0L);
            bundle.putAll(weiboMultiMessage.toBundle(bundle));
            Intent intent = new Intent();
            intent.setClass(this.context, WbShareTransActivity.class);
            intent.putExtra(WBConstants.SHARE_START_FLAG, 0);
            intent.putExtra(WBConstants.SHARE_START_ACTIVITY, this.context.getClass().getName());
            intent.putExtra(WBConstants.TRANS_PROGRESS_COLOR, this.progressColor);
            intent.putExtra(WBConstants.TRANS_PROGRESS_ID, this.progressId);
            intent.putExtras(bundle);
            try {
                this.context.startActivityForResult(intent, 1);
            } catch (Exception e2) {
                LogUtil.v("weibo sdk error ", e2.toString());
            }
        }
    }

    private void startWebShare(WeiboMultiMessage weiboMultiMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, weiboMultiMessage) == null) {
            LogUtil.i("Share", "startWebShare");
            Intent intent = new Intent(this.context, WbShareTransActivity.class);
            String packageName = this.context.getPackageName();
            ShareWebViewRequestParam shareWebViewRequestParam = new ShareWebViewRequestParam(WbSdk.getAuthInfo(), WebRequestType.SHARE, "", 1, "微博分享", null, this.context);
            shareWebViewRequestParam.setContext(this.context);
            shareWebViewRequestParam.setHashKey("");
            shareWebViewRequestParam.setPackageName(packageName);
            Oauth2AccessToken readAccessToken = AccessTokenKeeper.readAccessToken(this.context);
            if (readAccessToken != null && !TextUtils.isEmpty(readAccessToken.getToken())) {
                shareWebViewRequestParam.setToken(readAccessToken.getToken());
            }
            shareWebViewRequestParam.setMultiMessage(weiboMultiMessage);
            Bundle bundle = new Bundle();
            shareWebViewRequestParam.fillBundle(bundle);
            intent.putExtras(bundle);
            intent.putExtra(WBConstants.SHARE_START_FLAG, 0);
            intent.putExtra(WBConstants.SHARE_START_ACTIVITY, this.context.getClass().getName());
            intent.putExtra(WBConstants.SHARE_START_ACTION, WBConstants.ACTIVITY_WEIBO);
            intent.putExtra(WBConstants.SHARE_START_GOTO_ACTIVITY, "com.sina.weibo.sdk.web.WeiboSdkWebActivity");
            this.context.startActivityForResult(intent, 1);
        }
    }

    public void doResultIntent(Intent intent, WbShareCallback wbShareCallback) {
        Bundle extras;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, intent, wbShareCallback) == null) || wbShareCallback == null || intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        int i2 = extras.getInt(WBConstants.Response.ERRCODE, -1);
        if (i2 == 0) {
            wbShareCallback.onWbShareSuccess();
        } else if (i2 == 1) {
            wbShareCallback.onWbShareCancel();
        } else if (i2 != 2) {
        } else {
            wbShareCallback.onWbShareFail();
        }
    }

    @Deprecated
    public boolean isWbAppInstalled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? WbSdk.isWbInstall(this.context) : invokeV.booleanValue;
    }

    public boolean registerApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            sendBroadcast(this.context, WBConstants.ACTION_WEIBO_REGISTER, WbSdk.getAuthInfo().getAppKey(), null, null);
            this.hasRegister = true;
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.progressColor = i2;
        }
    }

    public void setProgressId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.progressId = i2;
        }
    }

    public void shareMessage(WeiboMultiMessage weiboMultiMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, weiboMultiMessage, z) == null) {
            if (this.hasRegister) {
                if (WbSdk.isWbInstall(this.context) || !z) {
                    if (z) {
                        startClientShare(weiboMultiMessage);
                        return;
                    }
                    WbAppInfo wbAppInfo = WeiboAppManager.getInstance(this.context).getWbAppInfo();
                    if (WbSdk.isWbInstall(this.context) && wbAppInfo != null && wbAppInfo.getSupportVersion() > 10000) {
                        startClientShare(weiboMultiMessage);
                        return;
                    } else {
                        startWebShare(weiboMultiMessage);
                        return;
                    }
                }
                return;
            }
            throw new RuntimeException("please call WbShareHandler.registerApp(),before use share function");
        }
    }

    public void shareToStory(StoryMessage storyMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, storyMessage) == null) {
            Uri imageUri = storyMessage.getImageUri();
            Uri videoUri = storyMessage.getVideoUri();
            if ((imageUri != null && FileUtils.isImageFile(this.context, imageUri)) || (videoUri != null && FileUtils.isVideoFile(this.context, videoUri))) {
                Intent intent = new Intent();
                intent.putExtra(WBConstants.Msg.STORY, storyMessage);
                intent.putExtra(WBConstants.SHARE_START_ACTIVITY, this.context.getClass().getName());
                intent.putExtra(WBConstants.SHARE_START_PACKAGE, WeiboAppManager.getInstance(this.context).getWbAppInfo().getPackageName());
                intent.putExtra(WBConstants.TRANS_PROGRESS_COLOR, this.progressColor);
                intent.putExtra(WBConstants.TRANS_PROGRESS_ID, this.progressId);
                intent.putExtra(WBConstants.SHARE_START_FLAG, 0);
                intent.setClass(this.context, WbShareToStoryActivity.class);
                this.context.startActivityForResult(intent, 1);
                return;
            }
            throw new IllegalStateException("File only can be Image or Video. ");
        }
    }

    public boolean supportMulti() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
