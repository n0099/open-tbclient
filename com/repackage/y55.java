package com.repackage;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nps.utils.Constant;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.itemcard.download.ItemDownloadExtraData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes7.dex */
public class y55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, downloadData) == null) {
            bw4.a(downloadData, 400);
            pc8.l().g(downloadData.getUrl(), downloadData.getId());
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? pc8.l().p(str) : invokeL.booleanValue;
    }

    public static int c(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, downloadData)) == null) {
            if (pc8.l().o(downloadData.getId())) {
                return 5;
            }
            if (pc8.l().q(downloadData.getId())) {
                return 1;
            }
            return pc8.l().n(downloadData.getId(), downloadData.getName()) ? 7 : 6;
        }
        return invokeL.intValue;
    }

    public static int d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (a25.q().t(str)) {
                return 1;
            }
            if (a25.q().r(str)) {
                return 5;
            }
            File m = a25.q().m(str, str2);
            return (m == null || !m.exists()) ? 6 : 7;
        }
        return invokeLL.intValue;
    }

    public static PackageInfo e(String str) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                packageInfo = TbadkApplication.getInst().getPackageManager().getPackageInfo(str, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (str.equals(packageInfo.packageName)) {
                return packageInfo;
            }
            return null;
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static Intent f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            try {
                return context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Intent) invokeLL.objValue;
    }

    public static String g(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, intent)) == null) {
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                return null;
            }
            String[] split = dataString.split(":");
            return split.length == 2 ? split[1] : dataString;
        }
        return (String) invokeL.objValue;
    }

    public static int h(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, downloadData)) == null) {
            int i = pc8.l().i(downloadData.getId(), downloadData.getName());
            if (i < 0 || i > 100) {
                return 0;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static void i(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, downloadData) == null) {
            bw4.a(downloadData, 800);
            Application app = TbadkCoreApplication.getInst().getApp();
            UtilHelper.install_apk(app, downloadData.getId().replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
        }
    }

    public static DownloadData j(ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, itemData)) == null) {
            String str = itemData.pkgName + ".v" + itemData.apkDetail.version;
            DownloadData downloadData = new DownloadData();
            downloadData.setType(12);
            downloadData.setId(str);
            downloadData.setName(itemData.mTitle);
            downloadData.setUrl(itemData.buttonLink);
            downloadData.setNotifyId(pc8.m(str).intValue());
            downloadData.setNeedInvokeApk(true);
            downloadData.setNeedNotify(false);
            ItemDownloadExtraData itemDownloadExtraData = new ItemDownloadExtraData(itemData.apkDetail.pkg_source.intValue());
            itemDownloadExtraData.appName = itemData.mTitle;
            itemDownloadExtraData.pkgName = itemData.pkgName;
            downloadData.setExtra(itemDownloadExtraData);
            return downloadData;
        }
        return (DownloadData) invokeL.objValue;
    }

    public static void k(String str) {
        Context context;
        Intent f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, str) == null) || TextUtils.isEmpty(str) || (f = f((context = TbadkCoreApplication.getInst().getContext()), str)) == null) {
            return;
        }
        try {
            context.startActivity(f);
        } catch (Exception unused) {
        }
    }

    public static boolean l(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, downloadData)) == null) {
            if (qi.D()) {
                return pc8.l().s(downloadData);
            }
            z15.b(downloadData);
            return false;
        }
        return invokeL.booleanValue;
    }
}
