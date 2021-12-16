package com.sdk.base.framework.bean;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.f.c.a;
import java.io.File;
/* loaded from: classes3.dex */
public class ApkItemInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String apkfile;
    public Drawable icon;
    public int isSystemApp;
    public CharSequence lable;
    public PackageInfo packageInfo;
    public String pkName;
    public int versionCode;
    public String versionName;

    public ApkItemInfo(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isSystemApp = -1;
        if (file != null) {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getPath(), 0);
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = file.getPath();
            applicationInfo.publicSourceDir = file.getPath();
            getApkItemInfo(packageManager, packageArchiveInfo, applicationInfo);
        }
    }

    public ApkItemInfo(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isSystemApp = -1;
        PackageManager packageManager = context.getPackageManager();
        getApkItemInfo(packageManager, packageManager.getPackageInfo(str, 0), packageManager.getApplicationInfo(str, 128));
    }

    public void getApkItemInfo(PackageManager packageManager, PackageInfo packageInfo, ApplicationInfo applicationInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, packageManager, packageInfo, applicationInfo) == null) {
            try {
                this.icon = packageManager.getApplicationIcon(packageInfo.applicationInfo);
            } catch (Exception unused) {
                this.icon = packageManager.getDefaultActivityIcon();
            }
            try {
                this.lable = packageManager.getApplicationLabel(packageInfo.applicationInfo);
            } catch (Exception unused2) {
            }
            try {
                this.isSystemApp = (packageInfo.applicationInfo.flags & 1) == 0 ? 0 : 1;
            } catch (Exception unused3) {
            }
            this.pkName = applicationInfo.packageName;
            this.versionName = packageInfo.versionName;
            this.versionCode = packageInfo.versionCode;
            this.apkfile = applicationInfo.sourceDir;
            this.packageInfo = packageInfo;
        }
    }

    public String getApkfile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.apkfile : (String) invokeV.objValue;
    }

    public Drawable getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.icon : (Drawable) invokeV.objValue;
    }

    public int getIsSystemApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isSystemApp : invokeV.intValue;
    }

    public CharSequence getLable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.lable : (CharSequence) invokeV.objValue;
    }

    public PackageInfo getPackageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.packageInfo : (PackageInfo) invokeV.objValue;
    }

    public String getPkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.pkName : (String) invokeV.objValue;
    }

    public int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.versionCode : invokeV.intValue;
    }

    public String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.versionName : (String) invokeV.objValue;
    }

    public void setApkfile(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.apkfile = str;
        }
    }

    public void setIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) {
            this.icon = drawable;
        }
    }

    public void setIsSystemApp(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.isSystemApp = i2;
        }
    }

    public void setLable(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, charSequence) == null) {
            this.lable = charSequence;
        }
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, packageInfo) == null) {
            this.packageInfo = packageInfo;
        }
    }

    public void setPkName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.pkName = str;
        }
    }

    public void setVersionCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.versionCode = i2;
        }
    }

    public void setVersionName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.versionName = str;
        }
    }

    public String toJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? a.a(this) : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return "ApkItemInfo [icon=" + this.icon + ", pkName=" + this.pkName + ", lable=" + ((Object) this.lable) + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", apkfile=" + this.apkfile + ", packageInfo=" + this.packageInfo + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
