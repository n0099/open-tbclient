package d.a.c0.a;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
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
    public static String f44974a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44975b;

    /* renamed from: c  reason: collision with root package name */
    public static String f44976c;

    /* renamed from: d  reason: collision with root package name */
    public static String f44977d;

    /* renamed from: e  reason: collision with root package name */
    public static Sticker f44978e;

    /* renamed from: f  reason: collision with root package name */
    public static String f44979f;

    /* renamed from: g  reason: collision with root package name */
    public static String f44980g;

    /* renamed from: h  reason: collision with root package name */
    public static String f44981h;

    /* renamed from: i  reason: collision with root package name */
    public static String f44982i;
    public static String j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1435019747, "Ld/a/c0/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1435019747, "Ld/a/c0/a/c;");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f44974a : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "/filter_config.json" : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? f44979f : (String) invokeV.objValue;
    }

    public static String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z)) == null) ? z ? f44982i : j : (String) invokeZ.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f44980g : (String) invokeV.objValue;
    }

    public static Sticker f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f44978e : (Sticker) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f44976c : (String) invokeV.objValue;
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            if (b.n()) {
                Log.d("DuAr_DuArResConfig", "setPath: " + str);
            }
            String str2 = str + "/";
            f44974a = str2;
            f44975b = str2;
            r0 = f44974a + "ext/";
            f44976c = f44975b + "faceModels/";
            if (TextUtils.isEmpty(str)) {
                f44979f = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
                f44976c = "file:///android_asset/arsource/faceModels/";
                String str3 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
                f44980g = str3 + "/makeup";
                f44981h = str3 + "/beauty";
                f44982i = str3 + "/arFilterInit";
                j = str3 + "/arFilterEditInit";
                String str4 = f44981h + "/liveVideoFace/live_face_knead.json";
                String str5 = f44981h + "/liveVideoFace/goddess_face_knead.json";
                String str6 = f44981h + "/liveVideoFace/baby_face_knead.json";
            } else {
                f44979f = f44975b + "filters/yuantu/yuantu.png";
                String str7 = f44975b + "filter/beauty_skin_stream.png";
                String str8 = f44975b + "filter/beauty_skin_small_video.png";
                f44980g = f44974a + "makeup/";
                f44981h = f44974a + "beauty/";
                f44982i = f44974a + "arFilterInit/";
                j = f44974a + "arFilterEditInit/";
                r0 = f44981h + "liveVideoFace/live_face_knead.json";
                String str9 = f44981h + "liveVideoFace/goddess_face_knead.json";
                String str10 = f44981h + "liveVideoFace/baby_face_knead.json";
                if (f44978e == null) {
                    Sticker sticker = new Sticker();
                    sticker.setArTyp(10);
                    sticker.setFile(new File(f44974a + "sticker/none_effect"));
                    sticker.setId("-1");
                    sticker.setMiniVersion(480);
                    sticker.setMaxVersion(Integer.MAX_VALUE);
                    f44978e = sticker;
                }
            }
            r0 = f44975b + "global";
            String str11 = f44975b + "vip_list.json";
            f44977d = f44975b + "filters";
            r0 = f44975b + "dlModels/";
            String str12 = f44977d + "/all";
            r0 = f44975b + "global/res/filter";
        }
    }
}
