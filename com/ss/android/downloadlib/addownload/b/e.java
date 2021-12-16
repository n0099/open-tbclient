package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements com.ss.android.downloadad.api.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadModel f61804b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadEventConfig f61805c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadController f61806d;

    public e() {
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

    @Override // com.ss.android.downloadad.api.a.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61804b.getDownloadUrl() : (String) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61804b.getId() : invokeV.longValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61804b.isAd() : invokeV.booleanValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f61804b.getLogExtra() : (String) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f61804b.getPackageName() : (String) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f61804b.getDeepLink() != null) {
                return this.f61804b.getDeepLink().getOpenUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f61804b.getExtra() : (JSONObject) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f61806d.getDownloadMode() == 2) {
                return 2;
            }
            return this.f61804b.getFunnelType();
        }
        return invokeV.intValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f61805c.getRefer() : (String) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f61805c.getClickButtonTag() : (String) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f61805c.getParamsJson() : (JSONObject) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f61804b.getExtraValue() : invokeV.longValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f61805c.isEnableV3Event() : invokeV.booleanValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public List<String> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f61804b.getClickTrackUrl() : (List) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public Object o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f61805c.getExtraEventObject() : invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f61805c.getExtraJson() : (JSONObject) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f61806d.enableNewActivity() : invokeV.booleanValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f61804b.getDownloadSettings() : (JSONObject) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f61805c.getDownloadScene() : invokeV.intValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadModel u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f61804b : (DownloadModel) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadEventConfig v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f61805c : (DownloadEventConfig) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadController w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f61806d : (DownloadController) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        DownloadModel downloadModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.a == 0 || (downloadModel = this.f61804b) == null || this.f61805c == null || this.f61806d == null) {
                return true;
            }
            return downloadModel.isAd() && this.a <= 0;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (x()) {
                return false;
            }
            if (this.f61804b.isAd()) {
                DownloadModel downloadModel = this.f61804b;
                return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.f61805c instanceof AdDownloadEventConfig) && (this.f61806d instanceof AdDownloadController);
            }
            return this.f61804b instanceof AdDownloadModel;
        }
        return invokeV.booleanValue;
    }

    public e(long j2, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), downloadModel, downloadEventConfig, downloadController};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = j2;
        this.f61804b = downloadModel;
        this.f61805c = downloadEventConfig;
        this.f61806d = downloadController;
    }
}
