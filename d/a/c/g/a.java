package d.a.c.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a implements IBundleInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PackageInfo f44596a;

    /* renamed from: b  reason: collision with root package name */
    public String f44597b;

    /* renamed from: c  reason: collision with root package name */
    public String f44598c;

    /* renamed from: d  reason: collision with root package name */
    public String f44599d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44600e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44601f;

    /* renamed from: g  reason: collision with root package name */
    public int f44602g;

    /* renamed from: h  reason: collision with root package name */
    public int f44603h;

    /* renamed from: i  reason: collision with root package name */
    public int f44604i;
    public int j;
    public int k;
    public int l;

    public a(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {packageInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44600e = true;
        this.f44601f = false;
        this.f44596a = packageInfo;
        String str = packageInfo.extraServer;
        if (packageInfo.isAllowSilence()) {
            this.j = 1;
        }
        if (this.f44596a.isOnlyWifi()) {
            this.l = 1;
        }
        if (this.f44596a.isAllowSilenceUpdate()) {
            this.k = 1;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            BdLog.e("LiveNPSPluginManager=" + str);
            JSONObject jSONObject = new JSONObject(str);
            this.f44597b = jSONObject.optString("description");
            this.f44598c = jSONObject.optString("icon_url");
            this.f44602g = jSONObject.optInt("force_update");
            this.f44603h = jSONObject.optInt("min_version");
            this.f44604i = jSONObject.optInt("abi");
        } catch (JSONException unused) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getAbi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f44604i : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getApkPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f44596a.filePath : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDependence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44599d : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f44597b : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDownloadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f44596a.downloadUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f44596a.extraServer : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f44598c : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f44596a.md5 : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getMinVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f44603h : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f44596a.name : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f44596a.packageName : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f44596a.sign : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getSilence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getSilenceUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public long getSize() {
        int i2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            try {
                i2 = Integer.parseInt(this.f44596a.size);
            } catch (Exception e2) {
                e2.printStackTrace();
                i2 = 0;
            }
            return i2;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public long getUpdateV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f44596a.updateVersion : invokeV.longValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (int) this.f44596a.version : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getWifiOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.l : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isBroken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isForbidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f44596a.disable == 1 : invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isNeedRemove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isRemovable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f44601f : invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f44600e : invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean needForceUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f44602g == 1 : invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setAbi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setApkPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.f44596a.filePath = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setBroken(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDependence(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.f44597b = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.f44597b = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDownloadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.f44596a.downloadUrl = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.f44596a.extraServer = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForbidden(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForceUpdate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.f44598c = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.f44596a.md5 = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMinVersion(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.f44596a.name = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setNeedRemove(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.f44596a.packageName = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setRemovable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.f44601f = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSignature(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.f44596a.sign = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSilence(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.j = i2;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSilenceUpdate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.k = i2;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j) == null) {
            PackageInfo packageInfo = this.f44596a;
            packageInfo.size = j + "";
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setUpdateV(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048622, this, j) == null) {
            this.f44596a.updateVersion = j;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVersionCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.f44596a.version = i2;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.f44600e = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setWifiOnly(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.l = i2;
        }
    }
}
