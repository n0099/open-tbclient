package com.kwai.video.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AwesomeCache;
import com.kwai.video.hodor.util.Timber;
/* loaded from: classes7.dex */
public class PlayerPreferrenceUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String VOD_ADAPTIVE_PREFERENCE_HISTORY_DATA_KEY_NAME = "history_data";
    public static final String VOD_ADAPTIVE_PREFERENCE_NAME = "vod_adaptive_data";
    public static PlayerPreferrenceUtil instance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Boolean mInited;
    public String vodAdaptiveHisData;

    public PlayerPreferrenceUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.vodAdaptiveHisData = "";
        this.mInited = Boolean.FALSE;
    }

    public static PlayerPreferrenceUtil getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (instance == null) {
                instance = new PlayerPreferrenceUtil();
            }
            return instance;
        }
        return (PlayerPreferrenceUtil) invokeV.objValue;
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, context) == null) || this.mInited.booleanValue() || context == null) {
            return;
        }
        this.mContext = context.getApplicationContext();
        this.mInited = Boolean.TRUE;
        Timber.d("PlayerPreferrenceUtil init", new Object[0]);
    }

    public String getVodAdaptiveData(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            init(context);
            if (this.mInited.booleanValue()) {
                this.vodAdaptiveHisData = this.mContext.getSharedPreferences(VOD_ADAPTIVE_PREFERENCE_NAME, 0).getString(VOD_ADAPTIVE_PREFERENCE_HISTORY_DATA_KEY_NAME, "");
            }
            Timber.d("PlayerPreferrenceUtil getVodAdaptiveData mInited:" + this.mInited + ", historyData: " + this.vodAdaptiveHisData, new Object[0]);
            return this.vodAdaptiveHisData;
        }
        return (String) invokeL.objValue;
    }

    public void saveVodAdaptiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String historyData = AwesomeCache.VodAdaptive.getHistoryData();
            if (!this.mInited.booleanValue() || TextUtils.isEmpty(historyData)) {
                return;
            }
            SharedPreferences.Editor edit = this.mContext.getSharedPreferences(VOD_ADAPTIVE_PREFERENCE_NAME, 0).edit();
            edit.putString(VOD_ADAPTIVE_PREFERENCE_HISTORY_DATA_KEY_NAME, historyData);
            edit.apply();
        }
    }
}
