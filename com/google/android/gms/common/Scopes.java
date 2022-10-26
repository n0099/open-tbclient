package com.google.android.gms.common;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class Scopes {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP_STATE = "https://www.googleapis.com/auth/appstate";
    public static final String CLOUD_SAVE = "https://www.googleapis.com/auth/datastoremobile";
    public static final String DRIVE_APPFOLDER = "https://www.googleapis.com/auth/drive.appdata";
    public static final String DRIVE_APPS = "https://www.googleapis.com/auth/drive.apps";
    public static final String DRIVE_FILE = "https://www.googleapis.com/auth/drive.file";
    public static final String DRIVE_FULL = "https://www.googleapis.com/auth/drive";
    public static final String EMAIL = "email";
    public static final String GAMES = "https://www.googleapis.com/auth/games";
    public static final String GAMES_LITE = "https://www.googleapis.com/auth/games_lite";
    public static final String OPEN_ID = "openid";
    @Deprecated
    public static final String PLUS_LOGIN = "https://www.googleapis.com/auth/plus.login";
    public static final String PLUS_ME = "https://www.googleapis.com/auth/plus.me";
    public static final String PROFILE = "profile";
    public transient /* synthetic */ FieldHolder $fh;

    public Scopes() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
