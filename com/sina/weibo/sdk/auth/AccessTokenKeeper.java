package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.network.IRequestService;
import com.sina.weibo.sdk.network.impl.RequestParam;
import com.sina.weibo.sdk.network.impl.RequestService;
import com.sina.weibo.sdk.network.target.SimpleTarget;
/* loaded from: classes2.dex */
public class AccessTokenKeeper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_EXPIRES_IN = "expires_in";
    public static final String KEY_REFRESH_TOKEN = "refresh_token";
    public static final String KEY_UID = "uid";
    public static final String PREFERENCES_NAME = "com_weibo_sdk_android";
    public transient /* synthetic */ FieldHolder $fh;

    public AccessTokenKeeper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void clear(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, context) == null) || context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES_NAME, 32768).edit();
        edit.clear();
        edit.commit();
    }

    public static Oauth2AccessToken readAccessToken(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, 32768);
            oauth2AccessToken.setUid(sharedPreferences.getString("uid", ""));
            oauth2AccessToken.setToken(sharedPreferences.getString("access_token", ""));
            oauth2AccessToken.setRefreshToken(sharedPreferences.getString("refresh_token", ""));
            oauth2AccessToken.setExpiresTime(sharedPreferences.getLong("expires_in", 0L));
            return oauth2AccessToken;
        }
        return (Oauth2AccessToken) invokeL.objValue;
    }

    public static void refreshToken(String str, Context context, RequestListener requestListener) {
        Oauth2AccessToken readAccessToken;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, str, context, requestListener) == null) || (readAccessToken = readAccessToken(context)) == null) {
            return;
        }
        IRequestService requestService = RequestService.getInstance();
        RequestParam.Builder builder = new RequestParam.Builder(context);
        builder.setShortUrl("https://api.weibo.com/oauth2/access_token");
        builder.addPostParam("client_id", str);
        builder.addPostParam("appKey", str);
        builder.addPostParam("grant_type", "refresh_token");
        builder.addPostParam("refresh_token", readAccessToken.getRefreshToken());
        requestService.asyncRequest(builder.build(), new SimpleTarget(context, requestListener) { // from class: com.sina.weibo.sdk.auth.AccessTokenKeeper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context val$context;
            public final /* synthetic */ RequestListener val$listener;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context, requestListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$context = context;
                this.val$listener = requestListener;
            }

            @Override // com.sina.weibo.sdk.network.target.Target
            public void onFailure(Exception exc) {
                RequestListener requestListener2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, exc) == null) || (requestListener2 = this.val$listener) == null) {
                    return;
                }
                requestListener2.onWeiboException(new WeiboException(exc));
            }

            @Override // com.sina.weibo.sdk.network.target.SimpleTarget
            public void onSuccess(String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                    AccessTokenKeeper.writeAccessToken(this.val$context, Oauth2AccessToken.parseAccessToken(str2));
                    RequestListener requestListener2 = this.val$listener;
                    if (requestListener2 != null) {
                        requestListener2.onComplete(str2);
                    }
                }
            }
        });
    }

    public static void writeAccessToken(Context context, Oauth2AccessToken oauth2AccessToken) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, oauth2AccessToken) == null) || context == null || oauth2AccessToken == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES_NAME, 32768).edit();
        edit.putString("uid", oauth2AccessToken.getUid());
        edit.putString("access_token", oauth2AccessToken.getToken());
        edit.putString("refresh_token", oauth2AccessToken.getRefreshToken());
        edit.putLong("expires_in", oauth2AccessToken.getExpiresTime());
        edit.commit();
    }
}
