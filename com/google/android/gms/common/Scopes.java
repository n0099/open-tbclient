package com.google.android.gms.common;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
/* loaded from: classes7.dex */
public final class Scopes {
    public static /* synthetic */ Interceptable $ic = null;
    @NonNull
    public static final String APP_STATE = "https://www.googleapis.com/auth/appstate";
    @NonNull
    public static final String CLOUD_SAVE = "https://www.googleapis.com/auth/datastoremobile";
    @NonNull
    public static final String DRIVE_APPFOLDER = "https://www.googleapis.com/auth/drive.appdata";
    @NonNull
    @KeepForSdk
    public static final String DRIVE_APPS = "https://www.googleapis.com/auth/drive.apps";
    @NonNull
    public static final String DRIVE_FILE = "https://www.googleapis.com/auth/drive.file";
    @NonNull
    @KeepForSdk
    public static final String DRIVE_FULL = "https://www.googleapis.com/auth/drive";
    @NonNull
    public static final String EMAIL = "email";
    @NonNull
    public static final String GAMES = "https://www.googleapis.com/auth/games";
    @NonNull
    @KeepForSdk
    public static final String GAMES_LITE = "https://www.googleapis.com/auth/games_lite";
    @NonNull
    @KeepForSdk
    public static final String OPEN_ID = "openid";
    @NonNull
    @Deprecated
    public static final String PLUS_LOGIN = "https://www.googleapis.com/auth/plus.login";
    @NonNull
    public static final String PLUS_ME = "https://www.googleapis.com/auth/plus.me";
    @NonNull
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
