package com.huawei.hms.ads.identifier;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes10.dex */
public class AdvertisingIdClient {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static final String SETTINGS_AD_ID = "pps_oaid";
    @Keep
    public static final String SETTINGS_TRACK_LIMIT = "pps_track_limit";
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* renamed from: com.huawei.hms.ads.identifier.AdvertisingIdClient$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static class AnonymousClass1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Keep
        public final /* synthetic */ Context a;

        public AnonymousClass1(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // java.lang.Runnable
        @Keep
        public native void run();
    }

    @Keep
    /* loaded from: classes10.dex */
    public static final class Info {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Keep
        public final String advertisingId;
        @Keep
        public final boolean limitAdTrackingEnabled;

        @Keep
        public Info(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        @Keep
        public native String getId();

        @Keep
        public native boolean isLimitAdTrackingEnabled();
    }

    public AdvertisingIdClient() {
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

    @Keep
    public static native Info getAdvertisingIdInfo(Context context);

    @Keep
    public static native boolean isAdvertisingIdAvailable(Context context);

    @Keep
    public static native Info requestAdvertisingIdInfo(Context context);

    @Keep
    public static native void updateAdvertisingIdInfo(Context context);

    @Keep
    public static native boolean verifyAdId(Context context, String str, boolean z);
}
