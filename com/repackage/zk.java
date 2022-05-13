package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zk implements IBundleInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PackageInfo a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    public zk(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {packageInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = true;
        this.f = false;
        this.a = packageInfo;
        String str = packageInfo.extraServer;
        if (packageInfo.isAllowSilence()) {
            this.j = 1;
        }
        if (this.a.isOnlyWifi()) {
            this.l = 1;
        }
        if (this.a.isAllowSilenceUpdate()) {
            this.k = 1;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            BdLog.e("LiveNPSPluginManager=" + str);
            JSONObject jSONObject = new JSONObject(str);
            this.b = jSONObject.optString("description");
            this.c = jSONObject.optString("icon_url");
            this.g = jSONObject.optInt("force_update");
            this.h = jSONObject.optInt("min_version");
            this.i = jSONObject.optInt(PackageTable.ABI);
        } catch (JSONException unused) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getAbi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getApkPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.filePath : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDependence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDownloadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.downloadUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.extraServer : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.md5 : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getMinVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.name : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.packageName : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.sign : (String) invokeV.objValue;
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
        int i;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            try {
                i = Integer.parseInt(this.a.size);
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
            return i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.a.updateVersion : invokeV.longValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (int) this.a.version : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.a.disable == 1 : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f : invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.e : invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean needForceUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.g == 1 : invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setAbi(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setApkPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.a.filePath = str;
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
            this.b = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.b = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDownloadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.a.downloadUrl = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.a.extraServer = str;
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
            this.c = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.a.md5 = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMinVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.a.name = str;
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
            this.a.packageName = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setRemovable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.f = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSignature(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.a.sign = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSilence(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.j = i;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSilenceUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.k = i;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j) == null) {
            PackageInfo packageInfo = this.a;
            packageInfo.size = j + "";
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setUpdateV(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048622, this, j) == null) {
            this.a.updateVersion = j;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVersionCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.a.version = i;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.e = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setWifiOnly(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.l = i;
        }
    }
}
