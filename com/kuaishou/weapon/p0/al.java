package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class al {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public al() {
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

    public static JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                String[] strArr = {"persist.sys.virtual_camera_flag", "persist.sys.camera_type", "persist.sys.camera_rotation"};
                int i = 0;
                for (int i2 = 0; i2 < 3; i2++) {
                    String a = aa.a().a(strArr[i2]);
                    if (!TextUtils.isEmpty(a)) {
                        jSONObject.put(strArr[i2].substring(strArr[i2].lastIndexOf(46) + 1), a);
                    }
                }
                try {
                    Class.forName("android.hardware.mockcamera.MockCamera");
                    jSONObject.put("MockCamera", 1);
                } catch (ClassNotFoundException unused) {
                }
                String[] strArr2 = {"/sdcard/.imei.txt", "/sdcard/key.txt", "/sdcard/video/1.mp4", "/sdcard/video/test.txt", "/sdcard/video/.aa", "/sdcard/video/.new", "/sdcard/video/.old"};
                for (int i3 = 2; i3 < 7; i3++) {
                    if (new File(strArr2[i3]).exists()) {
                        i |= 1 << i3;
                    }
                }
                if (i > 0) {
                    jSONObject.put(NetDiskFileMsg.JSON_KEY_FILES, i);
                }
            } catch (Exception unused2) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                String[] strArr = {"/storage/emulated/0/DCIM/Camera/virtual.mp4", "/storage/emulated/0/DCIM/Camera1/virtual.mp4", "/storage/emulated/0/DCIM/Camera1/no-silent.jpg", "/storage/emulated/0/DCIM/Camera1/disable.jpg", "/storage/emulated/0/DCIM/Camera1/no_toast.jpg"};
                for (int i = 0; i < 5; i++) {
                    if (new File(strArr[i]).exists()) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                String[] strArr = {"/system/lib/.aa", "/sdcard/my/34.png", "/sdcard/my/do_not_change.txt", "/sdcard/my/34.mp4", "/sdcard/my/44.mp4", "/sdcard/QQ=99932701/", "/sdcard/QQ=99932701/Dict.txt"};
                int i = 0;
                for (int i2 = 0; i2 < 7; i2++) {
                    if (new File(strArr[i2]).exists()) {
                        i |= 1 << i2;
                    }
                }
                if (i > 0) {
                    jSONObject.put(NetDiskFileMsg.JSON_KEY_FILES, i);
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String[] strArr = {"/sdcard/my/44.mp4", "/system/lib/lic"};
            String[] strArr2 = {"com.yky"};
            JSONObject jSONObject = new JSONObject();
            try {
                int a = bp.a(strArr);
                if (a > 0) {
                    jSONObject.put("f", a);
                }
                PackageManager packageManager = context.getPackageManager();
                for (int i = 0; i <= 0; i++) {
                    try {
                        packageManager.getApplicationInfo(strArr2[0], 0);
                        jSONObject.put(strArr2[0], 1);
                    } catch (PackageManager.NameNotFoundException | JSONException unused) {
                    }
                }
            } catch (Exception unused2) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String[] strArr = {"/system/lib.aa", "/system/lib/ccc"};
            int i = 0;
            for (int i2 = 0; i2 < 2; i2++) {
                try {
                    if (new File(strArr[i2]).exists()) {
                        i |= 1 << i2;
                    }
                } catch (Exception unused) {
                }
            }
            return i;
        }
        return invokeV.intValue;
    }
}
