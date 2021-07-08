package d.a.z.b.a.k;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaOneAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f68740a = "MediaTrackUtils";

    /* renamed from: b  reason: collision with root package name */
    public static String f68741b = "FILTER_MATRIX";

    /* renamed from: c  reason: collision with root package name */
    public static String f68742c = "FILTER_LUT";

    /* renamed from: d  reason: collision with root package name */
    public static String f68743d = "FILTER_SUB_LUT";

    /* renamed from: e  reason: collision with root package name */
    public static String f68744e = "FILTER_SUBTITLE";

    /* renamed from: f  reason: collision with root package name */
    public static boolean f68745f = false;

    /* renamed from: g  reason: collision with root package name */
    public static int f68746g = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1200154863, "Ld/a/z/b/a/k/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1200154863, "Ld/a/z/b/a/k/c;");
        }
    }

    public static void a(MediaTrack mediaTrack, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65537, null, mediaTrack, j) == null) {
            a.b(mediaTrack, j);
            m(mediaTrack);
        }
    }

    public static void b(MediaTrack mediaTrack, Map<String, ShaderConfig> map, MediaTrack mediaTrack2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, mediaTrack, map, mediaTrack2) == null) {
            a.f(mediaTrack, map, mediaTrack2);
        }
    }

    public static void c(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, mediaTrack, mediaTrackConfig) == null) {
            a.g(mediaTrack, mediaTrackConfig);
        }
    }

    public static void d(MediaTrack mediaTrack, List<MediaSegment> list, MediaTrackConfig mediaTrackConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mediaTrack, list, mediaTrackConfig) == null) {
            a.h(mediaTrack, list, mediaTrackConfig);
        }
    }

    public static List<MediaTrack> e(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, Map<String, ShaderConfig> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, mediaTrack, mediaTrackConfig, map)) == null) {
            List<MediaTrack> j = a.j(mediaTrack, mediaTrackConfig, map);
            for (MediaTrack mediaTrack2 : j) {
                m(mediaTrack2);
            }
            return j;
        }
        return (List) invokeLLL.objValue;
    }

    public static String f(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, str2, str3)) == null) ? a.n(context, str, str2, str3) : (String) invokeLLLL.objValue;
    }

    public static Bitmap g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.contains(File.separator)) {
                return BitmapFactory.decodeResource(context.getResources(), h(str, context));
            }
            return BitmapFactory.decodeFile(str);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static int h(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, context)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                int identifier = context.getResources().getIdentifier(str, "drawable", applicationInfo.packageName);
                return identifier == 0 ? context.getResources().getIdentifier(str, "mipmap", applicationInfo.packageName) : identifier;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static MediaAEffect i(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, String str, int i2, int i3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{mediaTrack, mediaTrackConfig, str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)})) == null) ? a.s(mediaTrack, mediaTrackConfig, str, i2, i3, j) : (MediaAEffect) invokeCommon.objValue;
    }

    public static String j(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, str, str2)) == null) ? a.u(context, str, str2) : (String) invokeLLL.objValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f68745f : invokeV.booleanValue;
    }

    public static boolean l(MediaTrack mediaTrack, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, mediaTrack, str)) == null) ? a.D(mediaTrack, str) : invokeLL.booleanValue;
    }

    public static void m(MediaTrack mediaTrack) {
        String str;
        String str2;
        ShaderParams next;
        Iterator<ShaderParams> it;
        String str3;
        MediaSegment mediaSegment;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, mediaTrack) == null) && f68745f) {
            Log.d(f68740a, "---------------------start----------------------------");
            List<MediaSegment> list = mediaTrack.mediaSegments;
            String str5 = PreferencesUtil.LEFT_MOUNT;
            String str6 = ": ";
            if (list != null) {
                int i2 = 0;
                while (i2 < mediaTrack.mediaSegments.size()) {
                    MediaSegment mediaSegment2 = mediaTrack.mediaSegments.get(i2);
                    Log.d(f68740a, " --> segment : " + i2 + str6 + mediaSegment2.type + "--->" + mediaSegment2.start + "----" + mediaSegment2.end + "---> scaleType --->" + mediaSegment2.scaleType + " shaderConfigKey --->" + mediaSegment2.shaderConfigKey + " effectConfigKey --->" + mediaSegment2.effectConfigKey);
                    MediaAEffect mediaAEffect = mediaSegment2.mediaAEffect;
                    if (mediaAEffect != null && mediaAEffect.mediaOneAEffects != null) {
                        int i3 = 0;
                        while (i3 < mediaSegment2.mediaAEffect.mediaOneAEffects.size()) {
                            MediaOneAEffect mediaOneAEffect = mediaSegment2.mediaAEffect.mediaOneAEffects.get(i3);
                            String str7 = f68740a;
                            StringBuilder sb = new StringBuilder();
                            sb.append("effect : ");
                            sb.append(i2);
                            sb.append("->");
                            sb.append(i3);
                            sb.append(str6);
                            String str8 = str5;
                            String str9 = str6;
                            sb.append(mediaOneAEffect.start);
                            sb.append("----");
                            sb.append(mediaOneAEffect.end);
                            sb.append(" shaderConfigKey --->");
                            sb.append(mediaSegment2.mediaAEffect.shaderConfigKey);
                            Log.d(str7, sb.toString());
                            List<ShaderParams> list2 = mediaOneAEffect.aParams;
                            if (list2 != null) {
                                Iterator<ShaderParams> it2 = list2.iterator();
                                while (it2.hasNext()) {
                                    float[] fArr = it2.next().values;
                                    if (fArr != null) {
                                        int length = fArr.length;
                                        it = it2;
                                        str4 = str8;
                                        int i4 = 0;
                                        while (true) {
                                            str3 = str8;
                                            if (i4 >= length) {
                                                break;
                                            }
                                            str4 = str4 + fArr[i4] + "---";
                                            i4++;
                                            str8 = str3;
                                            mediaSegment2 = mediaSegment2;
                                        }
                                        mediaSegment = mediaSegment2;
                                    } else {
                                        it = it2;
                                        str3 = str8;
                                        mediaSegment = mediaSegment2;
                                        str4 = str3;
                                    }
                                    Log.d(f68740a, "ShaderParams ------> type: " + next.type + " name: " + next.name + " values: " + (str4 + PreferencesUtil.RIGHT_MOUNT));
                                    it2 = it;
                                    str8 = str3;
                                    mediaSegment2 = mediaSegment;
                                }
                            }
                            i3++;
                            str6 = str9;
                            str5 = str8;
                            mediaSegment2 = mediaSegment2;
                        }
                    }
                    i2++;
                    str6 = str6;
                    str5 = str5;
                }
            }
            String str10 = str5;
            String str11 = str6;
            if (mediaTrack.mediaTransitions != null) {
                for (int i5 = 0; i5 < mediaTrack.mediaTransitions.size(); i5++) {
                    MediaTransition mediaTransition = mediaTrack.mediaTransitions.get(i5);
                    Log.d(f68740a, " --> transition : " + i5 + " ---> " + i5 + str11 + mediaTransition.start + "----" + mediaTransition.end + "---- duration : " + mediaTransition.duration);
                }
            }
            if (mediaTrack.superpositionHeader != null) {
                Log.d(f68740a, " --> superposition header : " + mediaTrack.superpositionHeader.start + "----" + mediaTrack.superpositionHeader.end + "----" + mediaTrack.superpositionHeader.superpositionType);
                MediaAEffect mediaAEffect2 = mediaTrack.superpositionHeader.mediaAEffect;
                if (mediaAEffect2 != null && mediaAEffect2.mediaOneAEffects != null) {
                    for (int i6 = 0; i6 < mediaTrack.superpositionHeader.mediaAEffect.mediaOneAEffects.size(); i6++) {
                        MediaOneAEffect mediaOneAEffect2 = mediaTrack.superpositionHeader.mediaAEffect.mediaOneAEffects.get(i6);
                        Log.d(f68740a, "superposition header effect : + ->" + i6 + str11 + mediaOneAEffect2.start + "----" + mediaOneAEffect2.end);
                        List<ShaderParams> list3 = mediaOneAEffect2.aParams;
                        if (list3 != null) {
                            for (ShaderParams shaderParams : list3) {
                                float[] fArr2 = shaderParams.values;
                                if (fArr2 != null) {
                                    str2 = str10;
                                    for (float f2 : fArr2) {
                                        str2 = str2 + f2 + "---";
                                    }
                                } else {
                                    str2 = str10;
                                }
                                Log.d(f68740a, "superposition header ShaderParams ------> type: " + shaderParams.type + " name: " + shaderParams.name + " values: " + (str2 + PreferencesUtil.RIGHT_MOUNT));
                            }
                        }
                    }
                }
            }
            if (mediaTrack.superpositionFooter != null) {
                Log.d(f68740a, " --> superposition footer : " + mediaTrack.superpositionFooter.start + "----" + mediaTrack.superpositionFooter.end + "----" + mediaTrack.superpositionFooter.superpositionType);
                MediaAEffect mediaAEffect3 = mediaTrack.superpositionFooter.mediaAEffect;
                if (mediaAEffect3 != null && mediaAEffect3.mediaOneAEffects != null) {
                    for (int i7 = 0; i7 < mediaTrack.superpositionFooter.mediaAEffect.mediaOneAEffects.size(); i7++) {
                        MediaOneAEffect mediaOneAEffect3 = mediaTrack.superpositionFooter.mediaAEffect.mediaOneAEffects.get(i7);
                        Log.d(f68740a, "superposition footer effect : + ->" + i7 + str11 + mediaOneAEffect3.start + "----" + mediaOneAEffect3.end);
                        List<ShaderParams> list4 = mediaOneAEffect3.aParams;
                        if (list4 != null) {
                            for (ShaderParams shaderParams2 : list4) {
                                float[] fArr3 = shaderParams2.values;
                                if (fArr3 != null) {
                                    str = str10;
                                    for (float f3 : fArr3) {
                                        str = str + f3 + "---";
                                    }
                                } else {
                                    str = str10;
                                }
                                Log.d(f68740a, "superposition footer ShaderParams ------> type: " + shaderParams2.type + " name: " + shaderParams2.name + " values: " + (str + PreferencesUtil.RIGHT_MOUNT));
                            }
                        }
                    }
                }
            }
            Log.d(f68740a, "--------------------end-----------------------------");
        }
    }
}
