package d.a.z.a;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f68552a;

    /* renamed from: b  reason: collision with root package name */
    public static String f68553b;

    /* renamed from: c  reason: collision with root package name */
    public static String f68554c;

    /* renamed from: d  reason: collision with root package name */
    public static String f68555d;

    /* renamed from: e  reason: collision with root package name */
    public static Sticker f68556e;

    /* renamed from: f  reason: collision with root package name */
    public static String f68557f;

    /* renamed from: g  reason: collision with root package name */
    public static String f68558g;

    /* renamed from: h  reason: collision with root package name */
    public static String f68559h;

    /* renamed from: i  reason: collision with root package name */
    public static String f68560i;
    public static String j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1095834336, "Ld/a/z/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1095834336, "Ld/a/z/a/c;");
        }
    }

    public c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        h(str);
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f68552a : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "/filter_config.json" : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f68557f : (String) invokeV.objValue;
    }

    public static String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z)) == null) ? z ? f68560i : j : (String) invokeZ.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f68558g : (String) invokeV.objValue;
    }

    public static Sticker f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f68556e : (Sticker) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f68554c : (String) invokeV.objValue;
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            if (b.n()) {
                Log.d("DuAr_DuArResConfig", "setPath: " + str);
            }
            String str2 = str + "/";
            f68552a = str2;
            f68553b = str2;
            r0 = f68552a + "ext/";
            f68554c = f68553b + "faceModels/";
            if (TextUtils.isEmpty(str)) {
                f68557f = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
                f68554c = "file:///android_asset/arsource/faceModels/";
                String str3 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
                f68558g = str3 + "/makeup";
                f68559h = str3 + "/beauty";
                f68560i = str3 + "/arFilterInit";
                j = str3 + "/arFilterEditInit";
                String str4 = f68559h + "/liveVideoFace/live_face_knead.json";
                String str5 = f68559h + "/liveVideoFace/goddess_face_knead.json";
                String str6 = f68559h + "/liveVideoFace/baby_face_knead.json";
            } else {
                f68557f = f68553b + "filters/yuantu/yuantu.png";
                String str7 = f68553b + "filter/beauty_skin_stream.png";
                String str8 = f68553b + "filter/beauty_skin_small_video.png";
                f68558g = f68552a + "makeup/";
                f68559h = f68552a + "beauty/";
                f68560i = f68552a + "arFilterInit/";
                j = f68552a + "arFilterEditInit/";
                r0 = f68559h + "liveVideoFace/live_face_knead.json";
                String str9 = f68559h + "liveVideoFace/goddess_face_knead.json";
                String str10 = f68559h + "liveVideoFace/baby_face_knead.json";
                if (f68556e == null) {
                    Sticker sticker = new Sticker();
                    sticker.setArTyp(10);
                    sticker.setFile(new File(f68552a + "sticker/none_effect"));
                    sticker.setId("-1");
                    sticker.setMiniVersion(480);
                    sticker.setMaxVersion(Integer.MAX_VALUE);
                    f68556e = sticker;
                }
            }
            r0 = f68553b + "global";
            String str11 = f68553b + "vip_list.json";
            f68555d = f68553b + "filters";
            r0 = f68553b + "dlModels/";
            String str12 = f68555d + "/all";
            r0 = f68553b + "global/res/filter";
        }
    }
}
