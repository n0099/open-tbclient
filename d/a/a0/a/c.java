package d.a.a0.a;

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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f41084a;

    /* renamed from: b  reason: collision with root package name */
    public static String f41085b;

    /* renamed from: c  reason: collision with root package name */
    public static String f41086c;

    /* renamed from: d  reason: collision with root package name */
    public static String f41087d;

    /* renamed from: e  reason: collision with root package name */
    public static Sticker f41088e;

    /* renamed from: f  reason: collision with root package name */
    public static String f41089f;

    /* renamed from: g  reason: collision with root package name */
    public static String f41090g;

    /* renamed from: h  reason: collision with root package name */
    public static String f41091h;

    /* renamed from: i  reason: collision with root package name */
    public static String f41092i;
    public static String j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-339987615, "Ld/a/a0/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-339987615, "Ld/a/a0/a/c;");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f41084a : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "/filter_config.json" : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f41089f : (String) invokeV.objValue;
    }

    public static String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z)) == null) ? z ? f41092i : j : (String) invokeZ.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f41090g : (String) invokeV.objValue;
    }

    public static Sticker f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f41088e : (Sticker) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f41086c : (String) invokeV.objValue;
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            if (b.n()) {
                Log.d("DuAr_DuArResConfig", "setPath: " + str);
            }
            String str2 = str + "/";
            f41084a = str2;
            f41085b = str2;
            r0 = f41084a + "ext/";
            f41086c = f41085b + "faceModels/";
            if (TextUtils.isEmpty(str)) {
                f41089f = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
                f41086c = "file:///android_asset/arsource/faceModels/";
                String str3 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
                f41090g = str3 + "/makeup";
                f41091h = str3 + "/beauty";
                f41092i = str3 + "/arFilterInit";
                j = str3 + "/arFilterEditInit";
                String str4 = f41091h + "/liveVideoFace/live_face_knead.json";
                String str5 = f41091h + "/liveVideoFace/goddess_face_knead.json";
                String str6 = f41091h + "/liveVideoFace/baby_face_knead.json";
            } else {
                f41089f = f41085b + "filters/yuantu/yuantu.png";
                String str7 = f41085b + "filter/beauty_skin_stream.png";
                String str8 = f41085b + "filter/beauty_skin_small_video.png";
                f41090g = f41084a + "makeup/";
                f41091h = f41084a + "beauty/";
                f41092i = f41084a + "arFilterInit/";
                j = f41084a + "arFilterEditInit/";
                r0 = f41091h + "liveVideoFace/live_face_knead.json";
                String str9 = f41091h + "liveVideoFace/goddess_face_knead.json";
                String str10 = f41091h + "liveVideoFace/baby_face_knead.json";
                if (f41088e == null) {
                    Sticker sticker = new Sticker();
                    sticker.setArTyp(10);
                    sticker.setFile(new File(f41084a + "sticker/none_effect"));
                    sticker.setId("-1");
                    sticker.setMiniVersion(480);
                    sticker.setMaxVersion(Integer.MAX_VALUE);
                    f41088e = sticker;
                }
            }
            r0 = f41085b + "global";
            String str11 = f41085b + "vip_list.json";
            f41087d = f41085b + "filters";
            r0 = f41085b + "dlModels/";
            String str12 = f41087d + "/all";
            r0 = f41085b + "global/res/filter";
        }
    }
}
