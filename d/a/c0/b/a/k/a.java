package d.a.c0.b.a.k;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectKeyData;
import com.baidu.minivideo.effect.core.vlogedit.MediaOneAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c0.b.a.g;
import d.a.y0.t.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.c0.b.a.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0609a implements d<MediaTransition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MediaTrack f45160a;

        public C0609a(MediaTrack mediaTrack) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaTrack};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45160a = mediaTrack;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.b.a.k.a.d
        /* renamed from: d */
        public boolean b(MediaTransition mediaTransition) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mediaTransition)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.b.a.k.a.d
        /* renamed from: e */
        public MediaTransition a(MediaTransition mediaTransition) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mediaTransition)) == null) {
                MediaTrack mediaTrack = this.f45160a;
                if (mediaTrack != null && TextUtils.equals("no", mediaTrack.transitionMode)) {
                    return new MediaTransition();
                }
                return (MediaTransition) mediaTransition.clone();
            }
            return (MediaTransition) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.b.a.k.a.d
        /* renamed from: f */
        public MediaTransition c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new MediaTransition() : (MediaTransition) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements d<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MediaTrackConfig f45161a;

        public b(MediaTrackConfig mediaTrackConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaTrackConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45161a = mediaTrackConfig;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c0.b.a.k.a.d
        public /* bridge */ /* synthetic */ String a(String str) {
            String str2 = str;
            e(str2);
            return str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.b.a.k.a.d
        /* renamed from: d */
        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                MediaAEffect mediaAEffect = this.f45161a.effectConfigMap.get(str);
                return (mediaAEffect == null || mediaAEffect.isRandomModeOnce()) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public String e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? str : (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.b.a.k.a.d
        /* renamed from: f */
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements d<MediaAEffect> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.b.a.k.a.d
        /* renamed from: d */
        public boolean b(MediaAEffect mediaAEffect) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mediaAEffect)) == null) ? (mediaAEffect == null || mediaAEffect.isRandomModeOnce()) ? false : true : invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.b.a.k.a.d
        /* renamed from: e */
        public MediaAEffect a(MediaAEffect mediaAEffect) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mediaAEffect)) == null) ? mediaAEffect.m15clone() : (MediaAEffect) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.b.a.k.a.d
        /* renamed from: f */
        public MediaAEffect c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return null;
            }
            return (MediaAEffect) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface d<T> {
        T a(T t);

        boolean b(T t);

        T c();
    }

    public static void A(long j, MediaAEffect mediaAEffect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65536, null, j, mediaAEffect) == null) {
            float f2 = (((float) j) * 1.0f) / ((float) mediaAEffect.duration);
            mediaAEffect.duration = j;
            for (MediaOneAEffect mediaOneAEffect : mediaAEffect.mediaOneAEffects) {
                long j2 = mediaOneAEffect.end;
                long j3 = mediaOneAEffect.start;
                if (j2 - j3 == 0) {
                    mediaOneAEffect.start = 0L;
                    mediaOneAEffect.end = 0L;
                } else {
                    mediaOneAEffect.start = ((float) j3) * f2;
                    mediaOneAEffect.end = ((float) j2) * f2;
                }
            }
        }
    }

    public static void B(long j, MediaAEffect mediaAEffect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65537, null, j, mediaAEffect) == null) {
            ArrayList<MediaOneAEffect> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<MediaOneAEffect> it = mediaAEffect.mediaOneAEffects.iterator();
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            while (it.hasNext()) {
                MediaOneAEffect next = it.next();
                long j5 = j2;
                long j6 = next.end;
                ArrayList arrayList3 = arrayList2;
                Iterator<MediaOneAEffect> it2 = it;
                long j7 = next.start;
                if (j6 - j7 != 0) {
                    if (j4 != 0) {
                        next.start = j4;
                        next.end = j4 + (j6 - j7);
                    }
                    d.a.y0.t.c.c("zmy", "aEffect start : " + next.start + " end : " + next.end);
                    j4 = next.end;
                } else if (j7 == 0) {
                    if (h.e(arrayList)) {
                        next.start = j4;
                        long j8 = (j4 + j) - mediaAEffect.duration;
                        next.end = j8;
                        j2 = j8 - j4;
                        d.a.y0.t.c.c("zmy", "aCenters 0 start : " + next.start + " end : " + next.end + " preSegmentDuration ： " + j);
                        j4 = j8;
                    } else {
                        j2 = j5;
                    }
                    arrayList.add(next);
                    arrayList2 = arrayList3;
                    it = it2;
                } else {
                    j3 += j7;
                    arrayList3.add(next);
                }
                arrayList2 = arrayList3;
                j2 = j5;
                it = it2;
            }
            ArrayList<MediaOneAEffect> arrayList4 = arrayList2;
            long j9 = j2;
            if (h.b(arrayList) > 1) {
                long j10 = 0;
                if (j9 - j3 > 0) {
                    long j11 = 0;
                    long j12 = 0;
                    for (MediaOneAEffect mediaOneAEffect : arrayList) {
                        long j13 = mediaOneAEffect.start;
                        if (j13 != j10) {
                            long j14 = mediaOneAEffect.end;
                            if (j14 != j10) {
                                long j15 = (j13 + ((j14 - j13) / 2)) - (j3 / 2);
                                mediaOneAEffect.end = j15;
                                d.a.y0.t.c.c("zmy", "aCenters 0 after start : " + mediaOneAEffect.start + " end : " + mediaOneAEffect.end + " centerEffectDuration : " + j3);
                                for (MediaOneAEffect mediaOneAEffect2 : arrayList4) {
                                    mediaOneAEffect2.start = j15;
                                    j15 += mediaOneAEffect2.end;
                                    mediaOneAEffect2.end = j15;
                                    d.a.y0.t.c.c("zmy", "aCenterEffects after start : " + mediaOneAEffect2.start + " end : " + mediaOneAEffect2.end);
                                }
                                j12 = j14;
                                j11 = j15;
                                j10 = 0;
                            }
                        }
                        if (j11 != 0) {
                            mediaOneAEffect.start = j11;
                            mediaOneAEffect.end = j12;
                            d.a.y0.t.c.c("zmy", "aCenters 1 after start : " + mediaOneAEffect.start + " end : " + mediaOneAEffect.end);
                        }
                        j10 = 0;
                    }
                } else {
                    MediaOneAEffect mediaOneAEffect3 = (MediaOneAEffect) h.c(arrayList, 1);
                    if (mediaOneAEffect3 != null) {
                        mediaAEffect.mediaOneAEffects.remove(mediaOneAEffect3);
                    }
                }
            }
            mediaAEffect.duration = j;
        }
    }

    public static boolean C(List<MediaSegment> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (h.e(list)) {
                return true;
            }
            return list != null && list.size() == 1 && list.get(0).start == 0 && list.get(0).end == 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean D(MediaTrack mediaTrack, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, mediaTrack, str)) == null) {
            if (mediaTrack != null && !TextUtils.isEmpty(str)) {
                if (TextUtils.equals(mediaTrack.trackType, str)) {
                    return true;
                }
                List<MediaSegment> list = mediaTrack.mediaSegments;
                if (list != null) {
                    for (MediaSegment mediaSegment : list) {
                        if (TextUtils.equals(mediaSegment.type, str)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void E(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, List<MediaTrack> list, MediaSegment mediaSegment, MediaSegment mediaSegment2, MediaTrack mediaTrack2, List<MediaSegment> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{mediaTrack, mediaTrackConfig, list, mediaSegment, mediaSegment2, mediaTrack2, list2}) == null) {
            if (C(list2) && h.b(list2) > 0) {
                MediaSegment mediaSegment3 = list2.get(0);
                for (MediaSegment mediaSegment4 : mediaTrack.mediaSegments) {
                    if (!TextUtils.isEmpty(mediaSegment3.lutConfigKey)) {
                        mediaSegment4.lutConfigKey = mediaSegment3.lutConfigKey;
                    }
                    mediaSegment4.shaderConfigKey = mediaSegment3.shaderConfigKey;
                    mediaSegment4.effectConfigKey = mediaSegment3.effectConfigKey;
                }
            } else if (list2.size() > 0) {
                int min = Math.min(mediaTrack.mediaSegments.size(), list2.size());
                for (int i2 = 0; i2 < min; i2++) {
                    MediaSegment mediaSegment5 = mediaTrack.mediaSegments.get(i2);
                    MediaSegment mediaSegment6 = list2.get(i2);
                    mediaSegment5.lutConfigKey = mediaSegment6.lutConfigKey;
                    mediaSegment5.shaderConfigKey = mediaSegment6.shaderConfigKey;
                    mediaSegment5.effectConfigKey = mediaSegment6.effectConfigKey;
                }
            }
            if (mediaTrack2 != null) {
                list.remove(mediaTrack2);
                mediaTrack.headerTransitionName = mediaTrack2.headerTransitionName;
                mediaTrack.footerTransitionName = mediaTrack2.footerTransitionName;
                mediaTrack.transitionMode = mediaTrack2.transitionMode;
                mediaTrack.mediaAEffectKeyData = mediaTrack2.mediaAEffectKeyData;
                mediaTrack.glClearColor = mediaTrack2.glClearColor;
            }
            if (mediaSegment != null) {
                mediaTrack.mediaSegments.add(0, mediaSegment.m17clone());
            }
            if (mediaSegment2 != null) {
                mediaTrack.mediaSegments.add(mediaSegment2.m17clone());
            }
            mediaTrack.trackType = "input";
            list.add(0, mediaTrack);
            String str = list2.size() > 0 ? list2.get(0).effectConfigKey : null;
            if (!C(list2) && list2.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (MediaSegment mediaSegment7 : list2) {
                    if ("input".equals(mediaSegment7.type)) {
                        arrayList.add(mediaSegment7);
                    }
                }
                int min2 = Math.min(list2.size(), arrayList.size());
                for (int i3 = 0; i3 < min2; i3++) {
                    ((MediaSegment) arrayList.get(i3)).effectConfigKey = list2.get(i3).effectConfigKey;
                }
            }
            c(mediaTrack, mediaTrackConfig, str, C(list2));
            e(mediaTrackConfig, mediaSegment, mediaSegment2);
            g(mediaTrack, mediaTrackConfig);
            i(mediaTrack, mediaTrackConfig, mediaTrack2);
            if (mediaTrackConfig != null && mediaTrack2 != null && !C(list2) && TextUtils.equals(mediaTrackConfig.importType, MediaTrackConfig.AE_IMPORT_TEMPLATE)) {
                h(mediaTrack, mediaTrack2.mediaSegments, mediaTrackConfig);
            }
            b(mediaTrack, mediaTrackConfig == null ? 0L : mediaTrackConfig.maxVideoDuration);
        }
    }

    public static void a(ShaderConfig shaderConfig, d.a.c0.b.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, shaderConfig, aVar) == null) {
            try {
                if (shaderConfig.vParams != null && shaderConfig.vParams.size() > 0) {
                    aVar.l();
                    for (ShaderParams shaderParams : shaderConfig.vParams) {
                        aVar.e(GLES20.glGetUniformLocation(aVar.j(), shaderParams.name), shaderParams.name, shaderParams);
                    }
                }
                if (shaderConfig.fParams == null || shaderConfig.fParams.size() <= 0) {
                    return;
                }
                aVar.l();
                for (ShaderParams shaderParams2 : shaderConfig.fParams) {
                    aVar.e(GLES20.glGetUniformLocation(aVar.j(), shaderParams2.name), shaderParams2.name, shaderParams2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void b(MediaTrack mediaTrack, long j) {
        MediaTrack mediaTrack2;
        List<MediaTransition> list;
        List<MediaTransition> list2;
        List<MediaTransition> list3;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.BAIDU_LOGO_ID, null, mediaTrack, j) == null) {
            MediaTrack mediaTrack3 = mediaTrack;
            long j3 = j;
            MediaSegment mediaSegment = (MediaSegment) h.d(mediaTrack3.mediaSegments);
            boolean z = mediaSegment != null && TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_FOOTER, mediaSegment.type);
            int i2 = 0;
            long j4 = 0;
            int i3 = 0;
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            while (i2 < mediaTrack3.mediaSegments.size()) {
                MediaSegment mediaSegment2 = (MediaSegment) o(mediaTrack3.mediaSegments, i2);
                if (mediaSegment2 != null) {
                    List<MediaTransition> list4 = mediaTrack3.mediaTransitions;
                    if (list4 != null && i2 > 0) {
                        MediaTransition mediaTransition = (MediaTransition) o(list4, i2 - 1);
                        if (mediaTransition != null) {
                            long j8 = mediaTransition.duration;
                            if (j8 > j4 || j8 > mediaSegment2.end - mediaSegment2.start) {
                                mediaTransition.duration = 0L;
                                mediaTransition.start = 0L;
                                mediaTransition.end = 0L;
                            } else {
                                long j9 = j5 - j8;
                                if (j6 > 0 && j7 > j9) {
                                    mediaTransition.duration = 0L;
                                    mediaTransition.start = 0L;
                                    mediaTransition.end = 0L;
                                } else {
                                    mediaTransition.start = j9;
                                    mediaTransition.end = j5;
                                    j7 = j5;
                                }
                            }
                            j6 = mediaTransition.duration;
                        }
                    }
                    j4 = mediaSegment2.end - mediaSegment2.start;
                    long j10 = j5 - j6;
                    mediaSegment2.start = j10;
                    j2 = j;
                    if (j2 > 0 && j10 + j4 >= j2) {
                        mediaSegment2.end = j2;
                        i3 = i2;
                    } else {
                        mediaSegment2.end = mediaSegment2.start + j4;
                    }
                    j5 = mediaSegment2.end;
                    MediaAEffect mediaAEffect = mediaSegment2.mediaAEffect;
                    if (mediaAEffect != null && mediaAEffect.mediaOneAEffects != null && !"camera".equals(mediaSegment2.type)) {
                        y(j4, mediaSegment2.mediaAEffect);
                    }
                    if (i3 != 0) {
                        break;
                    }
                    i2++;
                    j3 = j2;
                    mediaTrack3 = mediaTrack;
                }
                j2 = j3;
                i2++;
                j3 = j2;
                mediaTrack3 = mediaTrack;
            }
            if (i3 > 0) {
                int i4 = i3 + 1;
                mediaTrack2 = mediaTrack;
                if (i4 < mediaTrack2.mediaSegments.size()) {
                    List<MediaSegment> subList = mediaTrack2.mediaSegments.subList(0, i4);
                    mediaTrack2.mediaSegments = subList;
                    if (z) {
                        long j11 = mediaSegment.end - mediaSegment.start;
                        MediaSegment mediaSegment3 = (MediaSegment) h.d(subList);
                        long j12 = mediaSegment3.start;
                        mediaSegment.start = j12;
                        mediaSegment.end = j12 + j11;
                        mediaTrack2.mediaSegments.remove(mediaSegment3);
                        mediaTrack2.mediaSegments.add(mediaSegment);
                    }
                }
            } else {
                mediaTrack2 = mediaTrack;
            }
            if (i3 > 0 && (list3 = mediaTrack2.mediaTransitions) != null && list3.size() >= mediaTrack2.mediaSegments.size()) {
                mediaTrack2.mediaTransitions = mediaTrack2.mediaTransitions.subList(0, mediaTrack2.mediaSegments.size() - 1);
            }
            MediaSegment mediaSegment4 = mediaTrack2.superpositionHeader;
            if (mediaSegment4 != null) {
                if (TextUtils.isEmpty(mediaSegment4.superpositionType)) {
                    MediaSegment mediaSegment5 = mediaTrack2.superpositionHeader;
                    long j13 = mediaSegment5.start;
                    long j14 = mediaSegment5.end;
                    if (j13 != j14 && j14 != 0) {
                        mediaSegment5.superpositionType = "self";
                    } else {
                        mediaTrack2.superpositionHeader.superpositionType = "without_trans";
                    }
                }
                List<MediaSegment> list5 = mediaTrack2.mediaSegments;
                if (list5 != null && list5.size() > 0) {
                    MediaSegment mediaSegment6 = mediaTrack2.superpositionHeader;
                    mediaSegment6.start = 0L;
                    mediaSegment6.end = (mediaSegment6.end - mediaSegment6.start) + 0;
                    if ("all".equals(mediaSegment6.superpositionType) || mediaTrack2.superpositionHeader.end == 0) {
                        mediaTrack2.superpositionHeader.end = mediaTrack2.mediaSegments.get(0).end;
                    }
                    if ("without_trans".equals(mediaTrack2.superpositionHeader.superpositionType) && (list2 = mediaTrack2.mediaTransitions) != null && list2.size() > 0) {
                        mediaTrack2.superpositionHeader.end = mediaTrack2.mediaTransitions.get(0).start;
                    }
                }
            }
            MediaSegment mediaSegment7 = mediaTrack2.superpositionFooter;
            if (mediaSegment7 != null) {
                if (TextUtils.isEmpty(mediaSegment7.superpositionType)) {
                    MediaSegment mediaSegment8 = mediaTrack2.superpositionFooter;
                    long j15 = mediaSegment8.start;
                    long j16 = mediaSegment8.end;
                    if (j15 != j16 && j16 != 0) {
                        mediaSegment8.superpositionType = "self";
                    } else {
                        mediaTrack2.superpositionFooter.superpositionType = "without_trans";
                    }
                }
                List<MediaSegment> list6 = mediaTrack2.mediaSegments;
                if (list6 == null || list6.size() <= 0) {
                    return;
                }
                int size = mediaTrack2.mediaSegments.size() - 1;
                if ("all".equals(mediaTrack2.superpositionFooter.superpositionType)) {
                    mediaTrack2.superpositionFooter.start = mediaTrack2.mediaSegments.get(size).start;
                } else {
                    MediaSegment mediaSegment9 = mediaTrack2.superpositionFooter;
                    long j17 = mediaTrack2.mediaSegments.get(size).end;
                    MediaSegment mediaSegment10 = mediaTrack2.superpositionFooter;
                    mediaSegment9.start = j17 - (mediaSegment10.end - mediaSegment10.start);
                }
                if ("without_trans".equals(mediaTrack2.superpositionFooter.superpositionType) && (list = mediaTrack2.mediaTransitions) != null && list.size() > 0) {
                    MediaSegment mediaSegment11 = mediaTrack2.superpositionFooter;
                    long j18 = mediaSegment11.start;
                    List<MediaTransition> list7 = mediaTrack2.mediaTransitions;
                    mediaSegment11.start = j18 + list7.get(list7.size() - 1).duration;
                }
                mediaTrack2.superpositionFooter.end = mediaTrack2.mediaSegments.get(size).end;
            }
        }
    }

    public static void c(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, String str, boolean z) {
        List<MediaSegment> list;
        Map<String, MediaAEffect> map;
        int size;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{mediaTrack, mediaTrackConfig, str, Boolean.valueOf(z)}) == null) {
            String str5 = "";
            if (mediaTrackConfig != null && (map = mediaTrackConfig.effectConfigMap) != null && (size = map.size()) != 0) {
                if (!d(mediaTrack, mediaTrackConfig, z)) {
                    if (z && !TextUtils.isEmpty(str)) {
                        int size2 = mediaTrack.mediaSegments.size();
                        ArrayList arrayList = new ArrayList();
                        if (!str.contains("random") && !str.contains(IMConstants.SERVICE_TYPE_ORDER)) {
                            Boolean valueOf = Boolean.valueOf(mediaTrackConfig.effectConfigMap.containsKey(str));
                            for (int i2 = 0; i2 < size2; i2++) {
                                if (!z && i2 != 0) {
                                    valueOf = Boolean.FALSE;
                                }
                                arrayList.add(valueOf.booleanValue() ? str : null);
                            }
                            str2 = "";
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<Map.Entry<String, MediaAEffect>> it = mediaTrackConfig.effectConfigMap.entrySet().iterator();
                            String str6 = null;
                            String str7 = null;
                            while (it.hasNext()) {
                                Map.Entry<String, MediaAEffect> next = it.next();
                                String key = next.getKey();
                                MediaAEffect value = next.getValue();
                                boolean equals = "header".equals(key);
                                Iterator<Map.Entry<String, MediaAEffect>> it2 = it;
                                boolean equals2 = "footer".equals(key);
                                String str8 = str5;
                                if (TextUtils.isEmpty(value.shaderConfigKey)) {
                                    value.shaderConfigKey = d.a.c0.b.a.k.c.f45163b;
                                }
                                if (equals) {
                                    str6 = key;
                                }
                                if (equals2) {
                                    str7 = key;
                                }
                                if (!equals && !equals2 && (!str.contains("random") || size2 >= size || !value.isRandomModeOnce())) {
                                    arrayList2.add(key);
                                }
                                it = it2;
                                str5 = str8;
                            }
                            str2 = str5;
                            int i3 = size2 - ((str6 == null ? 0 : 1) + (str7 == null ? 0 : 1));
                            if (str6 != null && arrayList.size() < size2) {
                                arrayList.add(str6);
                            }
                            if (i3 > 0) {
                                arrayList.addAll(m(arrayList2, i3, new b(mediaTrackConfig), str.contains("random")));
                            }
                            if (str7 != null && arrayList.size() < size2) {
                                arrayList.add(str7);
                            }
                        }
                        if (size2 == arrayList.size()) {
                            int i4 = 0;
                            while (i4 < size2) {
                                MediaSegment mediaSegment = (MediaSegment) o(mediaTrack.mediaSegments, i4);
                                if (mediaSegment != null) {
                                    if (!TextUtils.isEmpty(mediaSegment.effectConfigKey) && !mediaSegment.effectConfigKey.contains("random") && !mediaSegment.effectConfigKey.contains(IMConstants.SERVICE_TYPE_ORDER)) {
                                        str3 = mediaSegment.effectConfigKey;
                                    } else {
                                        str3 = (o(arrayList, i4) == null || TextUtils.isEmpty((CharSequence) o(arrayList, i4))) ? null : (String) o(arrayList, i4);
                                    }
                                    if (!TextUtils.isEmpty(str3) && mediaTrackConfig.effectConfigMap.get(str3) != null) {
                                        MediaAEffect m15clone = mediaTrackConfig.effectConfigMap.get(str3).m15clone();
                                        mediaSegment.mediaAEffect = m15clone;
                                        if (TextUtils.isEmpty(m15clone.shaderConfigKey)) {
                                            mediaSegment.mediaAEffect.shaderConfigKey = d.a.c0.b.a.k.c.f45163b;
                                        }
                                        mediaSegment.effectConfigKey = str3;
                                        if (!TextUtils.equals(str, "random_with_video") && !TextUtils.equals(str, "order_with_video") && TextUtils.equals(mediaSegment.type, "video") && mediaSegment.mediaAEffect.isSceneEffect()) {
                                            mediaSegment.mediaAEffect = null;
                                            str4 = str2;
                                            mediaSegment.effectConfigKey = str4;
                                            i4++;
                                            str2 = str4;
                                        }
                                    }
                                }
                                str4 = str2;
                                i4++;
                                str2 = str4;
                            }
                        }
                    } else if (mediaTrack.mediaSegments != null) {
                        for (int i5 = 0; i5 < mediaTrack.mediaSegments.size(); i5++) {
                            MediaSegment mediaSegment2 = mediaTrack.mediaSegments.get(i5);
                            if (mediaTrackConfig.effectConfigMap.containsKey(mediaSegment2.effectConfigKey)) {
                                MediaAEffect m15clone2 = mediaTrackConfig.effectConfigMap.get(mediaSegment2.effectConfigKey).m15clone();
                                mediaSegment2.mediaAEffect = m15clone2;
                                if (TextUtils.isEmpty(m15clone2.shaderConfigKey)) {
                                    mediaSegment2.mediaAEffect.shaderConfigKey = d.a.c0.b.a.k.c.f45163b;
                                }
                            }
                        }
                    }
                }
            } else {
                if (mediaTrack == null || (list = mediaTrack.mediaSegments) == null) {
                    return;
                }
                for (MediaSegment mediaSegment3 : list) {
                    if (mediaSegment3 != null) {
                        mediaSegment3.mediaAEffect = null;
                        mediaSegment3.effectConfigKey = "";
                    }
                }
            }
        }
    }

    public static boolean d(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, null, mediaTrack, mediaTrackConfig, z)) == null) {
            int i2 = 0;
            if (mediaTrack != null && !h.e(mediaTrack.mediaAEffectKeyData) && mediaTrackConfig != null && mediaTrackConfig.effectConfigMap != null) {
                MediaAEffectKeyData mediaAEffectKeyData = null;
                Iterator<MediaAEffectKeyData> it = mediaTrack.mediaAEffectKeyData.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MediaAEffectKeyData next = it.next();
                    if (TextUtils.equals(next.type, "input")) {
                        mediaAEffectKeyData = next;
                        break;
                    }
                }
                if (mediaAEffectKeyData != null && !h.e(mediaAEffectKeyData.effectConfigKeys)) {
                    if (z) {
                        k(mediaAEffectKeyData, mediaTrackConfig);
                        int size = mediaTrack.mediaSegments.size();
                        int i3 = size - ((mediaAEffectKeyData.headerEffectKey == null ? 0 : 1) + (mediaAEffectKeyData.footerEffectKey == null ? 0 : 1));
                        ArrayList arrayList = new ArrayList();
                        if (i3 > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            if (!h.e(mediaAEffectKeyData.calculateEffectKeys)) {
                                for (String str : mediaAEffectKeyData.calculateEffectKeys) {
                                    MediaAEffect mediaAEffect = mediaTrackConfig.effectConfigMap.get(str);
                                    if (mediaAEffect != null) {
                                        mediaAEffect.name = str;
                                        arrayList2.add(mediaAEffect);
                                    }
                                }
                            }
                            arrayList.addAll(m(arrayList2, i3, new c(), mediaAEffectKeyData.keyMode.contains("random")));
                        }
                        while (i2 < size) {
                            MediaSegment mediaSegment = (MediaSegment) o(mediaTrack.mediaSegments, i2);
                            if (mediaSegment != null) {
                                String str2 = "";
                                if (i2 == 0 && !TextUtils.isEmpty(mediaAEffectKeyData.headerEffectKey)) {
                                    str2 = mediaAEffectKeyData.headerEffectKey;
                                } else if (i2 == size - 1 && !TextUtils.isEmpty(mediaAEffectKeyData.footerEffectKey)) {
                                    str2 = mediaAEffectKeyData.footerEffectKey;
                                } else {
                                    MediaAEffect mediaAEffect2 = (MediaAEffect) h.c(arrayList, TextUtils.isEmpty(mediaAEffectKeyData.headerEffectKey) ? i2 : i2 - 1);
                                    String str3 = mediaAEffect2 != null ? mediaAEffect2.name : "";
                                    if (TextUtils.equals(mediaAEffectKeyData.keyMode, "random_with_video") || TextUtils.equals(mediaAEffectKeyData.keyMode, "order_with_video") || !TextUtils.equals(mediaSegment.type, "video") || !mediaSegment.mediaAEffect.isSceneEffect()) {
                                        str2 = str3;
                                    }
                                }
                                MediaAEffect mediaAEffect3 = mediaTrackConfig.effectConfigMap.get(str2);
                                if (mediaAEffect3 != null) {
                                    mediaAEffect3.name = str2;
                                    MediaAEffect m15clone = mediaAEffect3.m15clone();
                                    mediaSegment.mediaAEffect = m15clone;
                                    if (TextUtils.isEmpty(m15clone.shaderConfigKey)) {
                                        mediaSegment.mediaAEffect.shaderConfigKey = d.a.c0.b.a.k.c.f45163b;
                                    }
                                }
                                mediaSegment.effectConfigKey = str2;
                            }
                            i2++;
                        }
                    } else if (mediaTrack.mediaSegments != null) {
                        while (i2 < mediaTrack.mediaSegments.size()) {
                            MediaSegment mediaSegment2 = mediaTrack.mediaSegments.get(i2);
                            if (mediaTrackConfig.effectConfigMap.containsKey(mediaSegment2.effectConfigKey)) {
                                MediaAEffect m15clone2 = mediaTrackConfig.effectConfigMap.get(mediaSegment2.effectConfigKey).m15clone();
                                mediaSegment2.mediaAEffect = m15clone2;
                                if (TextUtils.isEmpty(m15clone2.shaderConfigKey)) {
                                    mediaSegment2.mediaAEffect.shaderConfigKey = d.a.c0.b.a.k.c.f45163b;
                                }
                            }
                            i2++;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static void e(MediaTrackConfig mediaTrackConfig, MediaSegment mediaSegment, MediaSegment mediaSegment2) {
        Map<String, MediaAEffect> map;
        Map<String, MediaAEffect> map2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, mediaTrackConfig, mediaSegment, mediaSegment2) == null) || mediaTrackConfig == null) {
            return;
        }
        if (mediaSegment != null) {
            if (!TextUtils.isEmpty(mediaSegment.effectConfigKey) && (map2 = mediaTrackConfig.effectConfigMap) != null && map2.containsKey(mediaSegment.effectConfigKey)) {
                mediaSegment.mediaAEffect = mediaTrackConfig.effectConfigMap.get(mediaSegment.effectConfigKey).m15clone();
            } else {
                mediaSegment.mediaAEffect = null;
            }
        }
        if (mediaSegment2 != null) {
            if (!TextUtils.isEmpty(mediaSegment2.effectConfigKey) && (map = mediaTrackConfig.effectConfigMap) != null && map.containsKey(mediaSegment2.effectConfigKey)) {
                mediaSegment2.mediaAEffect = mediaTrackConfig.effectConfigMap.get(mediaSegment2.effectConfigKey).m15clone();
            } else {
                mediaSegment2.mediaAEffect = null;
            }
        }
    }

    public static void f(MediaTrack mediaTrack, Map<String, ShaderConfig> map, MediaTrack mediaTrack2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, mediaTrack, map, mediaTrack2) == null) || mediaTrack.mediaSegments.size() < d.a.c0.b.a.k.c.f45168g) {
            return;
        }
        MediaSegment mediaSegment = mediaTrack2.superpositionHeader;
        if (mediaSegment != null) {
            mediaTrack.superpositionHeader = mediaSegment;
            mediaSegment.start = 0L;
            long j = mediaSegment.end;
            if (j == 0) {
                j = v(map, mediaSegment);
            }
            mediaSegment.end = j;
        }
        MediaSegment mediaSegment2 = mediaTrack2.superpositionFooter;
        if (mediaSegment2 != null) {
            mediaTrack.superpositionFooter = mediaSegment2;
            mediaSegment2.start = mediaTrack2.superpositionFooter.start;
            long j2 = mediaSegment2.end;
            if (j2 == 0) {
                j2 = v(map, mediaSegment2);
            }
            mediaSegment2.end = j2;
        }
    }

    public static void g(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig) {
        Map<String, MediaAEffect> map;
        Map<String, MediaAEffect> map2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, mediaTrack, mediaTrackConfig) == null) || mediaTrackConfig == null) {
            return;
        }
        MediaSegment mediaSegment = mediaTrack.superpositionHeader;
        if (mediaSegment != null && !TextUtils.isEmpty(mediaSegment.effectConfigKey) && (map2 = mediaTrackConfig.effectConfigMap) != null && map2.containsKey(mediaTrack.superpositionHeader.effectConfigKey)) {
            MediaSegment mediaSegment2 = mediaTrack.superpositionHeader;
            mediaSegment2.mediaAEffect = mediaTrackConfig.effectConfigMap.get(mediaSegment2.effectConfigKey).m15clone();
        }
        MediaSegment mediaSegment3 = mediaTrack.superpositionFooter;
        if (mediaSegment3 == null || TextUtils.isEmpty(mediaSegment3.effectConfigKey) || (map = mediaTrackConfig.effectConfigMap) == null || !map.containsKey(mediaTrack.superpositionFooter.effectConfigKey)) {
            return;
        }
        MediaSegment mediaSegment4 = mediaTrack.superpositionFooter;
        mediaSegment4.mediaAEffect = mediaTrackConfig.effectConfigMap.get(mediaSegment4.effectConfigKey).m15clone();
    }

    public static void h(MediaTrack mediaTrack, List<MediaSegment> list, MediaTrackConfig mediaTrackConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65548, null, mediaTrack, list, mediaTrackConfig) == null) || mediaTrack == null || mediaTrack.mediaSegments == null || list == null || mediaTrackConfig == null) {
            return;
        }
        boolean z = false;
        if (TextUtils.equals(MediaTrackConfig.AE_TEMPLATE_TYPE_MUSIC, mediaTrackConfig.templateType)) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                MediaSegment mediaSegment = list.get(i2);
                mediaSegment.start = r(mediaSegment, true);
                mediaSegment.end = r(mediaSegment, z);
                long j = mediaSegment.effectStart;
                int i3 = i2;
                if (j != 0) {
                    mediaSegment.effectStart = ((j / 1000) * 1000) + (((((float) (j % 1000)) * 1.0f) / 30.0f) * 1000.0f);
                }
                long j2 = mediaSegment.effectEnd;
                if (j2 != 0) {
                    mediaSegment.effectEnd = ((j2 / 1000) * 1000) + (((((float) (j2 % 1000)) * 1.0f) / 30.0f) * 1000.0f);
                }
                i2 = i3 + 1;
                MediaTransition mediaTransition = (MediaTransition) o(mediaTrack.mediaTransitions, i2);
                if (mediaTransition != null && i3 != size - 1) {
                    mediaSegment.end += mediaTransition.duration;
                }
                z = false;
            }
            mediaTrackConfig.maxVideoDuration = ((MediaSegment) p(list)).end;
        }
        List<MediaSegment> list2 = mediaTrack.mediaSegments;
        int min = Math.min(list2.size(), list.size());
        for (int i4 = 0; i4 < min; i4++) {
            MediaSegment mediaSegment2 = list2.get(i4);
            MediaSegment mediaSegment3 = list.get(i4);
            mediaSegment2.type = mediaSegment3.type;
            mediaSegment2.start = mediaSegment3.start;
            mediaSegment2.end = mediaSegment3.end;
            mediaSegment2.effectStart = mediaSegment3.effectStart;
            mediaSegment2.effectEnd = mediaSegment3.effectEnd;
            mediaSegment2.scaleType = mediaSegment3.scaleType;
        }
        if (h.b(list2) > min) {
            mediaTrack.mediaSegments = mediaTrack.mediaSegments.subList(0, min);
        }
        mediaTrackConfig.templateType = "normal";
    }

    public static void i(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, MediaTrack mediaTrack2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, mediaTrack, mediaTrackConfig, mediaTrack2) == null) {
            if (mediaTrackConfig == null) {
                List<MediaTransition> list = mediaTrack.mediaTransitions;
                if (list != null) {
                    list.clear();
                }
            } else if (mediaTrack.mediaSegments != null) {
                mediaTrack.mediaTransitions = new ArrayList();
                List<MediaTransition> list2 = mediaTrackConfig.transitionConfigs;
                int i2 = 0;
                boolean z = true;
                if (list2 != null && list2.size() > 0) {
                    MediaTransition mediaTransition = null;
                    String str = mediaTrack2 != null ? mediaTrack2.headerTransitionName : null;
                    String str2 = mediaTrack2 != null ? mediaTrack2.footerTransitionName : null;
                    ArrayList arrayList = new ArrayList();
                    MediaTransition mediaTransition2 = null;
                    for (MediaTransition mediaTransition3 : mediaTrackConfig.transitionConfigs) {
                        boolean z2 = str != null && str.equals(mediaTransition3.name);
                        boolean z3 = str2 != null && str2.equals(mediaTransition3.name);
                        if (z2) {
                            mediaTransition = mediaTransition3;
                        }
                        if (z3) {
                            mediaTransition2 = mediaTransition3;
                        }
                        if (!z2 && !z3) {
                            arrayList.add(mediaTransition3);
                        }
                    }
                    int size = mediaTrack.mediaSegments.size() - 1;
                    int i3 = size - ((mediaTransition == null ? 0 : 1) + (mediaTransition2 == null ? 0 : 1));
                    ArrayList arrayList2 = new ArrayList();
                    if (mediaTransition != null && arrayList2.size() < size) {
                        arrayList2.add((MediaTransition) mediaTransition.clone());
                    }
                    if (i3 > 0) {
                        arrayList2.addAll(m(arrayList, i3, new C0609a(mediaTrack2), (mediaTrack2 == null || TextUtils.isEmpty(mediaTrack2.transitionMode) || !mediaTrack2.transitionMode.contains("random")) ? false : false));
                    }
                    if (mediaTransition2 != null && arrayList2.size() < size) {
                        arrayList2.add((MediaTransition) mediaTransition2.clone());
                    }
                    mediaTrack.mediaTransitions.addAll(arrayList2);
                    while (i2 < size) {
                        if (mediaTrack.mediaSegments.get(i2) != null && mediaTrack.mediaSegments.get(i2).mediaAEffect != null && mediaTrack.mediaSegments.get(i2).mediaAEffect.isSceneEffect() && !TextUtils.isEmpty(mediaTrack.mediaSegments.get(i2).mediaAEffect.sceneTransitionName)) {
                            mediaTrack.mediaTransitions.set(i2, t(mediaTrackConfig.transitionConfigs, mediaTrack.mediaSegments.get(i2).mediaAEffect.sceneTransitionName));
                        }
                        i2++;
                    }
                    return;
                }
                while (i2 < mediaTrack.mediaSegments.size() - 1) {
                    mediaTrack.mediaTransitions.add(new MediaTransition());
                    i2++;
                }
            }
        }
    }

    public static List<MediaTrack> j(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, Map<String, ShaderConfig> map) {
        InterceptResult invokeLLL;
        MediaSegment mediaSegment;
        MediaTrack mediaTrack2;
        Map<String, MediaAEffect> map2;
        Iterator it;
        Iterator<MediaSegment> it2;
        List<MediaTrack> list;
        List<MediaTrack> list2;
        Map<String, ShaderConfig> map3;
        ShaderConfig shaderConfig;
        List<MediaTextureData> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, mediaTrack, mediaTrackConfig, map)) == null) {
            MediaSegment mediaSegment2 = null;
            if (mediaTrack == null) {
                return null;
            }
            if (mediaTrackConfig != null && (list2 = mediaTrackConfig.mediaTracks) != null) {
                for (MediaTrack mediaTrack3 : list2) {
                    List<MediaSegment> list4 = mediaTrack3.mediaSegments;
                    if (list4 != null) {
                        for (MediaSegment mediaSegment3 : list4) {
                            if (!TextUtils.isEmpty(mediaSegment3.lutConfigKey) && (map3 = mediaTrackConfig.shaderConfigMapDebug) != null && (shaderConfig = map3.get(mediaSegment3.lutConfigKey)) != null && (list3 = shaderConfig.textures) != null) {
                                for (MediaTextureData mediaTextureData : list3) {
                                    mediaTextureData.type = MediaTextureData.TEXTURE_LUT;
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            if (mediaTrackConfig != null && (list = mediaTrackConfig.mediaTracks) != null) {
                arrayList.addAll(list);
            }
            Iterator<MediaSegment> it3 = mediaTrack.mediaSegments.iterator();
            while (it3.hasNext()) {
                MediaSegment next = it3.next();
                if (!TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_HEADER, next.type) && !TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_FOOTER, next.type)) {
                    if (TextUtils.isEmpty(next.lutConfigKey) || (!TextUtils.equals(next.lutConfigKey, d.a.c0.b.a.k.c.f45164c) && !next.lutConfigKey.contains(d.a.c0.b.a.k.c.f45165d))) {
                        next.lutConfigKey = null;
                    }
                    next.shaderConfigKey = null;
                    next.effectConfigKey = null;
                    next.mediaAEffect = null;
                } else {
                    it3.remove();
                }
            }
            if (mediaTrack.superpositionHeader != null) {
                mediaTrack.superpositionHeader = null;
            }
            if (mediaTrack.superpositionFooter != null) {
                mediaTrack.superpositionFooter = null;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it4 = arrayList.iterator();
            MediaSegment mediaSegment4 = null;
            MediaTrack mediaTrack4 = null;
            ArrayList arrayList3 = null;
            while (true) {
                if (!it4.hasNext()) {
                    mediaSegment = mediaSegment2;
                    mediaTrack2 = mediaTrack4;
                    break;
                }
                MediaTrack mediaTrack5 = (MediaTrack) it4.next();
                if (mediaTrack5 != null) {
                    if (!h.e(mediaTrack5.mediaSegments)) {
                        Iterator<MediaSegment> it5 = mediaTrack5.mediaSegments.iterator();
                        while (it5.hasNext()) {
                            MediaSegment next2 = it5.next();
                            if (TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_HEADER, next2.type)) {
                                next2.start = 0L;
                                it = it4;
                                it2 = it5;
                                long j = next2.end;
                                if (j == 0) {
                                    j = v(map, next2);
                                }
                                next2.end = j;
                                mediaSegment2 = next2;
                            } else {
                                MediaSegment mediaSegment5 = mediaSegment2;
                                it = it4;
                                it2 = it5;
                                if (TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_FOOTER, next2.type)) {
                                    next2.start = next2.start;
                                    long j2 = next2.end;
                                    if (j2 == 0) {
                                        j2 = v(map, next2);
                                    }
                                    next2.end = j2;
                                    mediaSegment4 = next2;
                                }
                                mediaSegment2 = mediaSegment5;
                            }
                            it5 = it2;
                            it4 = it;
                        }
                    }
                    Iterator it6 = it4;
                    if (TextUtils.equals("input", mediaTrack5.trackType)) {
                        f(mediaTrack, map, mediaTrack5);
                        if (!h.e(mediaTrack5.mediaSegments)) {
                            for (MediaSegment mediaSegment6 : mediaTrack5.mediaSegments) {
                                if (!TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_HEADER, mediaSegment6.type) && !TextUtils.equals(MediaSegment.SEG_TYPE_INPUT_FOOTER, mediaSegment6.type)) {
                                    arrayList2.add(mediaSegment6);
                                }
                            }
                        }
                        mediaSegment = mediaSegment2;
                        mediaTrack2 = mediaTrack5;
                    } else {
                        if (TextUtils.equals("multi_input", mediaTrack5.trackType)) {
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                            }
                            f(mediaTrack, map, mediaTrack5);
                            arrayList3.add(mediaTrack5);
                        } else {
                            List<MediaSegment> list5 = mediaTrack5.mediaSegments;
                            if (list5 != null) {
                                for (MediaSegment mediaSegment7 : list5) {
                                    MediaSegment mediaSegment8 = mediaSegment2;
                                    if ((mediaSegment7 == null || (!"input".equals(mediaSegment7.type) && !MediaSegment.SEG_TYPE_INPUT_HEADER.equals(mediaSegment7.type) && !MediaSegment.SEG_TYPE_INPUT_FOOTER.equals(mediaSegment7.type))) && mediaTrack5.superpositionFooter == null && mediaTrack5.superpositionHeader == null) {
                                        if (mediaSegment7 != null && "multi_input".equals(mediaSegment7.type)) {
                                            if (arrayList3 == null) {
                                                arrayList3 = new ArrayList();
                                            }
                                            f(mediaTrack, map, mediaTrack5);
                                            arrayList3.add(mediaTrack5);
                                        }
                                    } else {
                                        f(mediaTrack, map, mediaTrack5);
                                        if (mediaSegment7 != null && "input".equals(mediaSegment7.type)) {
                                            arrayList2.add(mediaSegment7);
                                        }
                                        mediaTrack4 = mediaTrack5;
                                    }
                                    mediaSegment2 = mediaSegment8;
                                }
                            }
                            it4 = it6;
                        }
                        mediaSegment2 = mediaSegment2;
                        it4 = it6;
                    }
                }
            }
            if (arrayList3 != null && arrayList3.size() > 0) {
                MediaTrack mediaTrack6 = new MediaTrack();
                ArrayList arrayList4 = new ArrayList();
                MediaSegment mediaSegment9 = new MediaSegment();
                mediaSegment9.type = "input_blank";
                mediaSegment9.start = 0L;
                mediaSegment9.end = mediaTrackConfig == null ? 0L : mediaTrackConfig.maxVideoDuration;
                arrayList4.add(mediaSegment9);
                mediaTrack6.mediaSegments = arrayList4;
                mediaTrack6.trackType = "input_blank";
                arrayList.add(0, mediaTrack6);
            } else {
                E(mediaTrack, mediaTrackConfig, arrayList, mediaSegment, mediaSegment4, mediaTrack2, arrayList2);
            }
            if (mediaTrackConfig != null) {
                for (int i2 = 1; i2 < arrayList.size(); i2++) {
                    List<MediaSegment> list6 = ((MediaTrack) arrayList.get(i2)).mediaSegments;
                    if (list6 != null) {
                        for (MediaSegment mediaSegment10 : list6) {
                            if (!TextUtils.isEmpty(mediaSegment10.effectConfigKey) && (map2 = mediaTrackConfig.effectConfigMap) != null) {
                                MediaAEffect mediaAEffect = map2.get(mediaSegment10.effectConfigKey);
                                mediaSegment10.mediaAEffect = mediaAEffect;
                                if (mediaAEffect != null && TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                                    mediaSegment10.mediaAEffect.shaderConfigKey = d.a.c0.b.a.k.c.f45163b;
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }

    public static void k(MediaAEffectKeyData mediaAEffectKeyData, MediaTrackConfig mediaTrackConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, mediaAEffectKeyData, mediaTrackConfig) == null) || mediaAEffectKeyData == null || h.e(mediaAEffectKeyData.effectConfigKeys) || mediaTrackConfig == null || mediaTrackConfig.effectConfigMap == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : mediaAEffectKeyData.effectConfigKeys) {
            MediaAEffect mediaAEffect = mediaTrackConfig.effectConfigMap.get(str);
            if (mediaAEffect != null) {
                if (TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                    mediaAEffect.shaderConfigKey = d.a.c0.b.a.k.c.f45163b;
                }
                arrayList.add(str);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        String str2 = mediaAEffectKeyData.keyMode;
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -1011358530:
                if (str2.equals("random_with_video")) {
                    c2 = 2;
                    break;
                }
                break;
            case -938285885:
                if (str2.equals("random")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3521:
                if (str2.equals("no")) {
                    c2 = 5;
                    break;
                }
                break;
            case 97445748:
                if (str2.equals("fixed")) {
                    c2 = 0;
                    break;
                }
                break;
            case 106006350:
                if (str2.equals(IMConstants.SERVICE_TYPE_ORDER)) {
                    c2 = 3;
                    break;
                }
                break;
            case 1792331091:
                if (str2.equals("order_with_video")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            arrayList2.add(mediaAEffectKeyData.effectConfigKeys.get(0));
        } else if (c2 == 1 || c2 == 2) {
            arrayList2.addAll(arrayList);
            Collections.shuffle(arrayList2);
        } else if (c2 == 3 || c2 == 4) {
            arrayList2.addAll(arrayList);
        }
        mediaAEffectKeyData.calculateEffectKeys = arrayList2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x00e9 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [d.a.c0.b.a.d] */
    /* JADX WARN: Type inference failed for: r4v4, types: [d.a.c0.b.a.c] */
    /* JADX WARN: Type inference failed for: r4v5, types: [d.a.c0.b.a.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v7, types: [d.a.c0.b.a.d] */
    public static Map<String, d.a.c0.b.a.a> l(Context context, Map<String, ShaderConfig> map) {
        InterceptResult invokeLL;
        ?? dVar;
        String u;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, map)) == null) {
            x(context, map);
            HashMap hashMap = new HashMap();
            if (map != null) {
                for (Map.Entry<String, ShaderConfig> entry : map.entrySet()) {
                    ShaderConfig value = entry.getValue();
                    List<MediaTextureData> list = value.textures;
                    if (list != null && list.size() > 0) {
                        if (TextUtils.isEmpty(value.vertexShader)) {
                            u = d.a.c0.b.a.d.W(value.textures.size());
                        } else {
                            u = u(context, value.resourcePath, value.vertexShader);
                        }
                        dVar = new d.a.c0.b.a.d(u, n(context, value.resourcePath, value.fragmentShader, entry.getKey()));
                        ArrayList arrayList = new ArrayList();
                        for (MediaTextureData mediaTextureData : value.textures) {
                            int i2 = mediaTextureData.textureId;
                            if (i2 != 0) {
                                arrayList.add(Integer.valueOf(i2));
                            }
                        }
                        if (arrayList.size() > 0) {
                            dVar.Y(arrayList);
                        }
                    } else if (!TextUtils.equals(entry.getKey(), d.a.c0.b.a.k.c.f45164c) && !TextUtils.equals(entry.getKey(), d.a.c0.b.a.k.c.f45166e)) {
                        dVar = new d.a.c0.b.a.c(TextUtils.isEmpty(value.vertexShader) ? "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = uMVPMatrix * position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}" : u(context, value.resourcePath, value.vertexShader), n(context, value.resourcePath, value.fragmentShader, entry.getKey()));
                    } else {
                        dVar = new d.a.c0.b.a.d(d.a.c0.b.a.d.W(1), n(context, value.resourcePath, value.fragmentShader, entry.getKey()));
                    }
                    a(value, dVar);
                    hashMap.put(entry.getKey(), dVar);
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static <T> List<T> m(List<T> list, int i2, d<T> dVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{list, Integer.valueOf(i2), dVar, Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            if (i2 <= 0) {
                return arrayList;
            }
            int i3 = 0;
            if (list == null || list.size() == 0) {
                while (i3 < i2) {
                    arrayList.add(dVar.c());
                    i3++;
                }
                return arrayList;
            }
            int size = list.size();
            if (size != i2) {
                while (i3 < i2) {
                    T t = list.get(i3 % size);
                    arrayList.add(dVar.a(t));
                    if (!dVar.b(t)) {
                        list.remove(t);
                        size = list.size();
                    }
                    i3++;
                }
            } else {
                arrayList.addAll(list);
            }
            if (z) {
                Collections.shuffle(arrayList);
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public static String n(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65554, null, context, str, str2, str3)) == null) {
            if (TextUtils.equals("default", str2)) {
                return "precision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     vec4 inputColor = texture2D(inputImageTexture, textureCoordinate);\n     gl_FragColor = vec4(inputColor.rgb, inputColor.a * alpha);\n}";
            }
            if (TextUtils.equals("default_oes", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     vec4 inputColor = texture2D(inputImageTexture, textureCoordinate);\n     gl_FragColor = vec4(inputColor.rgb, inputColor.a * alpha);\n}";
            }
            if (TextUtils.equals("defaultLut", str2)) {
                return "precision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform float non_level;\n\n//使用LUT获取新的颜色：参考https://www.jianshu.com/p/96a61110a5ae\nvec4 applyFilterOnColor(vec4 inputColor, sampler2D inputLut, float saturation)\n{\n    // 根据B通道获取小正方形（64x64)格子的位置\n    highp float blueColor = inputColor.b * 63.0;\n    //向下取值：获取第一个格子的坐标\n    highp vec2 quad1;\n    //确定所在行\n    quad1.y = floor(floor(blueColor) / 8.0);\n    //确定所在列\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n\n    //向上取值：获取第二个格子的坐标\n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n\n    // 根据小正方形格子和RG通道，获取纹理坐标；LUT图片的大小为512*512，每个格子的大小为64*64\n    //quad1是正方形的坐标，每个正方形占纹理大小的1/8，即是0.125，所以quad1.x * 0.125是算出正方形的左下角x坐标，\n    //每个小格子在整个图片的纹理宽度为 0.125，由于纹理坐标是从0开始的(即0 - 63)\n\n    //**确定第一个格子的纹理坐标**\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((63.0/512.0) * inputColor.r);\n    texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((63.0/512.0) * inputColor.g);\n\n    //确定第二个格子的纹理坐标\n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((63.0/512.0) * inputColor.r);\n    texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((63.0/512.0) * inputColor.g);\n\n    //根据纹理坐标获取两个颜色\n    lowp vec4 newColor1 = texture2D(inputLut, texPos1);\n    lowp vec4 newColor2 = texture2D(inputLut, texPos2);\n\n    //两个颜色进行混合，返回其小数部分\n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    vec4 tempColor = vec4(newColor.rgb, inputColor.w);\n    vec4 outputColor = mix(inputColor, tempColor, saturation);\n    return outputColor;\n}\n\nvoid main()\n{\n    vec4 inputColor = texture2D(inputImageTexture, textureCoordinate);\n    vec4 outColor = applyFilterOnColor(inputColor, inputImageTexture2, 1.0 - non_level);\n    gl_FragColor = mix(inputColor, vec4(outColor.rgb, inputColor.w), inputColor.a);\n}";
            }
            if (TextUtils.equals("defaultSticker", str2)) {
                return "precision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvoid main()\n{\n    vec4 inputImage = texture2D(inputImageTexture, textureCoordinate);\n    vec4 inputImage2 = texture2D(inputImageTexture2, textureCoordinate2);\n    gl_FragColor = mix(inputImage, inputImage2, inputImage2.a);\n}";
            }
            if (TextUtils.equals("defaultAnimator", str2)) {
                return "precision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     vec4 inputColor = texture2D(inputImageTexture, textureCoordinate);\n     gl_FragColor = vec4(inputColor.rgb, inputColor.a * alpha);\n}";
            }
            if (TextUtils.equals("defaultBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = mix(baseColor, blendColor, blendColor.a);\n}\n";
            }
            if (TextUtils.equals("defaultVerticalBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2(textureCoordinate2.x, (1.0 - textureCoordinate2.y) / 2.0);\n    vec2 coloursCoor = vec2(textureCoordinate2.x, (1.0 - textureCoordinate2.y) / 2.0 + 0.5);\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n    \n    gl_FragColor = mix(baseColor, blendColor, blendColor.a);\n}\n";
            }
            if (TextUtils.equals("addedBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = min(baseColor + blendColor, vec4(1.0));\n}\n";
            }
            if (TextUtils.equals("overlayBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    float r = baseColor.r < 0.5 ? (2.0 * baseColor.r * blendColor.r)                : (1.0 - 2.0 * (1.0 - baseColor.r) * (1.0 - blendColor.r));\n    float g = baseColor.g < 0.5 ? (2.0 * baseColor.g * blendColor.g)                : (1.0 - 2.0 * (1.0 - baseColor.g) * (1.0 - blendColor.g));\n    float b = baseColor.b < 0.5 ? (2.0 * baseColor.b * blendColor.b)                : (1.0 - 2.0 * (1.0 - baseColor.b) * (1.0 - blendColor.b));\n    float a = baseColor.a < 0.5 ? (2.0 * baseColor.a * blendColor.a)                : (1.0 - 2.0 * (1.0 - baseColor.a) * (1.0 - blendColor.a));\n    gl_FragColor = vec4(r, g, b, a);\n}\n";
            }
            if (TextUtils.equals("screenBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = vec4(1.0) - ((vec4(1.0) - baseColor) * (vec4(1.0) - blendColor));\n}\n";
            }
            if (TextUtils.equals("multiplyBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = baseColor * blendColor;\n}\n";
            }
            if (TextUtils.equals("colorBurnBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = vec4(1.0) - (vec4(1.0) - baseColor) / blendColor;\n}\n";
            }
            if (TextUtils.equals("averageBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = (baseColor + blendColor) / 2.0;\n}\n";
            }
            if (TextUtils.equals("darkenBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = min(baseColor, blendColor);\n}\n";
            }
            if (TextUtils.equals("linearBurnBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = baseColor + blendColor - vec4(1.0);\n}\n";
            }
            if (TextUtils.equals("differenceBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = abs(baseColor - blendColor);\n}\n";
            }
            if (TextUtils.equals("lightenBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = max(baseColor, blendColor);\n}\n";
            }
            if (TextUtils.equals("colorDodgeBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = baseColor / (vec4(1.0) - blendColor);\n}\n";
            }
            if (TextUtils.equals("linearDodgeBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = min(baseColor + blendColor, vec4(1.0));\n}\n";
            }
            if (TextUtils.equals("softLightBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = 2.0 * baseColor * blendColor + baseColor * baseColor\n                    - 2.0 * baseColor * baseColor * blendColor;\n}\n";
            }
            if (TextUtils.equals("hardLightBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    float r = blendColor.r < 0.5 ? (2.0 * baseColor.r * blendColor.r)\n                : (1.0 - 2.0 * (1.0 - baseColor.r) * (1.0 - blendColor.r));\n    float g = blendColor.g < 0.5 ? (2.0 * baseColor.g * blendColor.g)\n                : (1.0 - 2.0 * (1.0 - baseColor.g) * (1.0 - blendColor.g));\n    float b = blendColor.b < 0.5 ? (2.0 * baseColor.b * blendColor.b)\n                : (1.0 - 2.0 * (1.0 - baseColor.b) * (1.0 - blendColor.b));\n    float a = blendColor.a < 0.5 ? (2.0 * baseColor.a * blendColor.a)\n                : (1.0 - 2.0 * (1.0 - baseColor.a) * (1.0 - blendColor.a));\n    gl_FragColor = vec4(r, g, b, a);\n}\n";
            }
            if (TextUtils.equals("linearLightBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = baseColor + 2.0 * blendColor - vec4(1.0);\n}\n";
            }
            if (TextUtils.equals("pinLightBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = min(baseColor, 2.0 * blendColor - vec4(1.0));\n}\n";
            }
            if (TextUtils.equals("hardMixBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    float r = blendColor.r < 1.0 - baseColor.r ? 0.0 : 1.0;\n    float g = blendColor.g < 1.0 - baseColor.g ? 0.0 : 1.0;\n    float b = blendColor.b < 1.0 - baseColor.b ? 0.0 : 1.0;\n    float a = blendColor.a < 1.0 - baseColor.a ? 0.0 : 1.0;\n    gl_FragColor = vec4(r, g, b, a);\n}\n";
            }
            if (TextUtils.equals("vividLightBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    float r = blendColor.r <= 0.5 ? 1.0 - (1.0 - baseColor.r) / 2.0 * blendColor.r\n                : baseColor.r / (2.0 * (1.0 - blendColor.r));\n    float g = blendColor.g <= 0.5 ? 1.0 - (1.0 - baseColor.g) / 2.0 * blendColor.g\n                : baseColor.g / (2.0 * (1.0 - blendColor.g));\n    float b = blendColor.b <= 0.5 ? 1.0 - (1.0 - baseColor.b) / 2.0 * blendColor.b\n                : baseColor.b / (2.0 * (1.0 - blendColor.b));\n    float a = blendColor.a <= 0.5 ? 1.0 - (1.0 - baseColor.a) / 2.0 * blendColor.a\n                : baseColor.a / (2.0 * (1.0 - blendColor.a));\n    gl_FragColor = vec4(r, g, b, a);\n}\n";
            }
            if (TextUtils.equals("exclusionBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = blendColor + baseColor - 2.0 * blendColor * baseColor;\n}\n";
            }
            if (TextUtils.equals("reflectBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    float r = blendColor.r > 0.99 ? blendColor.r\n                : min(baseColor.r * baseColor.r / (1.0 - blendColor.r), 1.0);\n    float g = blendColor.g > 0.99 ? blendColor.g\n                : min(baseColor.g * baseColor.g / (1.0 - blendColor.g), 1.0);\n    float b = blendColor.b > 0.99 ? blendColor.b\n                : min(baseColor.b * baseColor.b / (1.0 - blendColor.b), 1.0);\n    float a = blendColor.a > 0.99 ? blendColor.a\n                : min(baseColor.a * baseColor.a / (1.0 - blendColor.a), 1.0);\n    gl_FragColor = vec4(r, g, b, a);\n}\n";
            }
            if (TextUtils.equals("glowBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    float r = baseColor.r > 0.99 ? baseColor.r\n                : min(blendColor.r * blendColor.r / (1.0 - baseColor.r), 1.0);\n    float g = baseColor.g > 0.99 ? baseColor.g\n                : min(blendColor.g * blendColor.g / (1.0 - baseColor.g), 1.0);\n    float b = baseColor.b > 0.99 ? baseColor.b\n                : min(blendColor.b * blendColor.b / (1.0 - baseColor.b), 1.0);\n    float a = baseColor.a > 0.99 ? baseColor.a\n                : min(blendColor.a * blendColor.a / (1.0 - baseColor.a), 1.0);\n    gl_FragColor = vec4(r, g, b, a);\n}\n";
            }
            if (TextUtils.equals("negationBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = vec4(1.0) - abs(vec4(1.0) - baseColor - blendColor);\n}\n";
            }
            if (TextUtils.equals("phoenixBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = min(baseColor, blendColor) - max(baseColor, blendColor) + vec4(1.0);\n}\n";
            }
            if (TextUtils.equals("snowColorBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\nvec3 rgb2hsl(in vec3 color){\n    vec3 hsl = vec3(0.0);\n    float fmin = min(min(color.r, color.g), color.b);\n    float fmax = max(max(color.r, color.g), color.b);\n    float delta = fmax - fmin;\n\n    hsl.z = (fmax + fmin) / 2.0;\n\n    if (delta == 0.0) {\n        hsl.x = 0.0;\n        hsl.y = 0.0;\n    } else {\n        if (hsl.z < 0.5)\n        hsl.y = delta / (fmax + fmin);\n        else\n        hsl.y = delta / (2.0 - fmax - fmin);\n\n        float deltaR = (((fmax - color.r) / 6.0) + (delta / 2.0)) / delta;\n        float deltaG = (((fmax - color.g) / 6.0) + (delta / 2.0)) / delta;\n        float deltaB = (((fmax - color.b) / 6.0) + (delta / 2.0)) / delta;\n\n        if (color.r == fmax)\n        hsl.x = deltaB - deltaG;\n        else if (color.g == fmax)\n        hsl.x = (1.0 / 3.0) + deltaR - deltaB;\n        else if (color.b == fmax)\n        hsl.x = (2.0 / 3.0) + deltaG - deltaR;\n\n        if (hsl.x < 0.0)\n        hsl.x += 1.0;\n        else if (hsl.x > 1.0)\n        hsl.x -= 1.0;\n    }\n    return hsl;\n}vec3 hsl2rgb( in vec3 c )\n{\n    vec3 rgb = clamp( abs(mod(c.x*6.0+vec3(0.0,4.0,2.0),6.0)-3.0)-1.0, 0.0, 1.0 );\n    return c.z + c.y * (rgb-0.5)*(1.0-abs(2.0*c.z-1.0));\n}void main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);    vec3 baseHsl = rgb2hsl(baseColor.rgb);\n    vec3 blendHsl = rgb2hsl(blendColor.rgb);\n    gl_FragColor = vec4(hsl2rgb(vec3(baseHsl.r, baseHsl.g, blendHsl.b)).rgb, 1.0);\n}\n";
            }
            if (TextUtils.equals("snowHueBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\nvec3 rgb2hsl(in vec3 color){\n    vec3 hsl = vec3(0.0);\n    float fmin = min(min(color.r, color.g), color.b);\n    float fmax = max(max(color.r, color.g), color.b);\n    float delta = fmax - fmin;\n\n    hsl.z = (fmax + fmin) / 2.0;\n\n    if (delta == 0.0) {\n        hsl.x = 0.0;\n        hsl.y = 0.0;\n    } else {\n        if (hsl.z < 0.5)\n        hsl.y = delta / (fmax + fmin);\n        else\n        hsl.y = delta / (2.0 - fmax - fmin);\n\n        float deltaR = (((fmax - color.r) / 6.0) + (delta / 2.0)) / delta;\n        float deltaG = (((fmax - color.g) / 6.0) + (delta / 2.0)) / delta;\n        float deltaB = (((fmax - color.b) / 6.0) + (delta / 2.0)) / delta;\n\n        if (color.r == fmax)\n        hsl.x = deltaB - deltaG;\n        else if (color.g == fmax)\n        hsl.x = (1.0 / 3.0) + deltaR - deltaB;\n        else if (color.b == fmax)\n        hsl.x = (2.0 / 3.0) + deltaG - deltaR;\n\n        if (hsl.x < 0.0)\n        hsl.x += 1.0;\n        else if (hsl.x > 1.0)\n        hsl.x -= 1.0;\n    }\n    return hsl;\n}vec3 hsl2rgb( in vec3 c )\n{\n    vec3 rgb = clamp( abs(mod(c.x*6.0+vec3(0.0,4.0,2.0),6.0)-3.0)-1.0, 0.0, 1.0 );\n    return c.z + c.y * (rgb-0.5)*(1.0-abs(2.0*c.z-1.0));\n}void main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);    vec3 baseHsl = rgb2hsl(baseColor.rgb);\n    vec3 blendHsl = rgb2hsl(blendColor.rgb);\n    gl_FragColor = vec4(hsl2rgb(vec3(baseHsl.r, blendHsl.g, blendHsl.b)).rgb, 1.0);\n}\n";
            }
            if (TextUtils.equals("subtractBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = max(vec4(baseColor.rgb - blendColor.rgb, 1.0), vec4(0.0));\n}\n";
            }
            if (TextUtils.equals("divideBlend", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = baseColor / blendColor;\n}\n";
            }
            if (TextUtils.equals("f_calculate_blend_video_rose", str2) || TextUtils.equals("f_calculate_blend_video_rose.glsl", str2)) {
                return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nconst vec4 black = vec4(0.0, 0.0, 0.0, 1.0);\nconst vec2 boundMin = vec2(0.0, 0.0);\nconst vec2 boundMax = vec2(1.0, 1.0);\n\nbool inBounds (vec2 p) {\n  return all(lessThan(boundMin, p)) && all(lessThan(p, boundMax));\n}\n\nvoid main()\n{\n    vec2 coordinate = textureCoordinate;\n    coordinate.x = (coordinate.x);\n    coordinate.y = (coordinate.y - 0.0659);\n    vec4 inputImage;\n    if (inBounds(coordinate)) {\n        inputImage = texture2D(inputImageTexture, coordinate);\n    } else {\n        inputImage = black;\n    }\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n    gl_FragColor = mix(inputImage, texture2D(inputImageTexture2, coloursCoor),    texture2D(inputImageTexture2, blackCoor).r);\n}\n";
            }
            if (TextUtils.equals("shader_header", str3) || TextUtils.equals("shader_footer", str3) || !(TextUtils.equals("f_calculate_blend_video", str2) || TextUtils.equals("f_calculate_blend_video.glsl", str2))) {
                if (TextUtils.isEmpty(str)) {
                    return d.a.c0.b.a.a.n(context, q(context, str2));
                }
                return d.a.c0.b.a.a.m(str + File.separator + str2);
            }
            return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform samplerExternalOES inputImageTexture2;\n\nvoid main()\n{\n    vec4 baseColor = texture2D(inputImageTexture, textureCoordinate);\n    vec2 blackCoor = vec2((textureCoordinate2.x) / 2.0, (1.0 - textureCoordinate2.y));\n    vec2 coloursCoor = vec2((textureCoordinate2.x + 1.0) / 2.0, (1.0 - textureCoordinate2.y));\n\n    vec4 alphaColor = texture2D(inputImageTexture2, blackCoor);\n    vec4 blendColor = vec4(texture2D(inputImageTexture2, coloursCoor).rgb, alphaColor.r);\n\n    gl_FragColor = mix(baseColor, blendColor, blendColor.a);\n}\n";
        }
        return (String) invokeLLLL.objValue;
    }

    public static <T> T o(List<T> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65555, null, list, i2)) == null) {
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return list.get(i2);
        }
        return (T) invokeLI.objValue;
    }

    public static <T> T p(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (T) o(list, list.size() - 1);
        }
        return (T) invokeL.objValue;
    }

    public static int q(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, str)) == null) {
            try {
                return context.getResources().getIdentifier(str, "raw", context.getApplicationInfo().packageName);
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static long r(MediaSegment mediaSegment, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65558, null, mediaSegment, z)) == null) {
            if (mediaSegment == null) {
                return 0L;
            }
            long j = z ? mediaSegment.start : mediaSegment.end;
            return ((j / 1000) * 1000) + (((((float) (j % 1000)) * 1.0f) / 30.0f) * 1000.0f);
        }
        return invokeLZ.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaAEffect s(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, String str, int i2, int i3, long j) {
        InterceptResult invokeCommon;
        List<MediaAEffectKeyData> list;
        MediaAEffectKeyData mediaAEffectKeyData;
        MediaAEffect mediaAEffect;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{mediaTrack, mediaTrackConfig, str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)})) != null) {
            return (MediaAEffect) invokeCommon.objValue;
        }
        MediaAEffect mediaAEffect2 = null;
        if (mediaTrack == null || (list = mediaTrack.mediaAEffectKeyData) == null || mediaTrackConfig == null || mediaTrackConfig.effectConfigMap == null || j == 0) {
            return null;
        }
        Iterator<MediaAEffectKeyData> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                mediaAEffectKeyData = null;
                break;
            }
            mediaAEffectKeyData = it.next();
            if (TextUtils.equals(mediaAEffectKeyData.type, str)) {
                break;
            }
        }
        if (mediaAEffectKeyData == null || h.e(mediaAEffectKeyData.effectConfigKeys)) {
            return null;
        }
        if (mediaAEffectKeyData.calculateEffectKeys == null) {
            k(mediaAEffectKeyData, mediaTrackConfig);
        }
        if (i2 == 0) {
            mediaAEffect = mediaTrackConfig.effectConfigMap.get(mediaAEffectKeyData.headerEffectKey);
            if (mediaAEffect != null) {
                if (TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                    mediaAEffect.shaderConfigKey = d.a.c0.b.a.k.c.f45163b;
                }
                mediaAEffect.name = mediaAEffectKeyData.headerEffectKey;
                mediaAEffect2 = mediaAEffect;
            }
            if (mediaAEffect2 == null && !h.e(mediaAEffectKeyData.calculateEffectKeys)) {
                List<String> list2 = mediaAEffectKeyData.calculateEffectKeys;
                mediaAEffect2 = mediaTrackConfig.effectConfigMap.get((String) h.c(list2, i2 % h.b(list2)));
            }
            if (mediaAEffect2 == null) {
                MediaAEffect m15clone = mediaAEffect2.m15clone();
                y(j, m15clone);
                return m15clone;
            }
            return mediaAEffect2;
        }
        if (i2 == i3 - 1 && (mediaAEffect = mediaTrackConfig.effectConfigMap.get(mediaAEffectKeyData.footerEffectKey)) != null) {
            if (TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                mediaAEffect.shaderConfigKey = d.a.c0.b.a.k.c.f45163b;
            }
            mediaAEffect.name = mediaAEffectKeyData.footerEffectKey;
            mediaAEffect2 = mediaAEffect;
        }
        if (mediaAEffect2 == null) {
            List<String> list22 = mediaAEffectKeyData.calculateEffectKeys;
            mediaAEffect2 = mediaTrackConfig.effectConfigMap.get((String) h.c(list22, i2 % h.b(list22)));
        }
        if (mediaAEffect2 == null) {
        }
    }

    public static MediaTransition t(List<MediaTransition> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, list, str)) == null) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
                for (MediaTransition mediaTransition : list) {
                    if (mediaTransition != null && str.equals(mediaTransition.name)) {
                        return (MediaTransition) mediaTransition.clone();
                    }
                }
                return new MediaTransition();
            }
            return new MediaTransition();
        }
        return (MediaTransition) invokeLL.objValue;
    }

    public static String u(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65561, null, context, str, str2)) == null) {
            if (TextUtils.equals("default", str2)) {
                return "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = uMVPMatrix * position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}";
            }
            if (TextUtils.isEmpty(str)) {
                return d.a.c0.b.a.a.n(context, q(context, str2));
            }
            return d.a.c0.b.a.a.m(str + File.separator + str2);
        }
        return (String) invokeLLL.objValue;
    }

    public static long v(Map<String, ShaderConfig> map, MediaSegment mediaSegment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, map, mediaSegment)) == null) {
            if (map == null) {
                return 0L;
            }
            if (map.get(mediaSegment.shaderConfigKey) == null || map.get(mediaSegment.shaderConfigKey).textures == null || map.get(mediaSegment.shaderConfigKey).textures.size() <= 0 || !map.get(mediaSegment.shaderConfigKey).textures.get(0).type.equals(MediaTextureData.TEXTURE_VIDEO)) {
                return 2000L;
            }
            try {
                String str = map.get(mediaSegment.shaderConfigKey).textures.get(0).path;
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                long longValue = Long.valueOf(mediaMetadataRetriever.extractMetadata(9)).longValue();
                mediaMetadataRetriever.release();
                return longValue;
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeLL.longValue;
    }

    public static boolean w(List<MediaTrack> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, list, str)) == null) {
            if (list != null && !TextUtils.isEmpty(str)) {
                for (MediaTrack mediaTrack : list) {
                    if (mediaTrack != null && mediaTrack.mediaSegments != null) {
                        if (TextUtils.equals(mediaTrack.trackType, str)) {
                            return true;
                        }
                        for (MediaSegment mediaSegment : mediaTrack.mediaSegments) {
                            if (TextUtils.equals(mediaSegment.type, str)) {
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void x(Context context, Map<String, ShaderConfig> map) {
        Bitmap g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65564, null, context, map) == null) || map == null) {
            return;
        }
        for (Map.Entry<String, ShaderConfig> entry : map.entrySet()) {
            ShaderConfig value = entry.getValue();
            List<MediaTextureData> list = value.textures;
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (MediaTextureData mediaTextureData : value.textures) {
                    if (mediaTextureData.textureId == 0 && TextUtils.equals(MediaTextureData.TEXTURE_LUT, mediaTextureData.type) && (g2 = d.a.c0.b.a.k.c.g(context, mediaTextureData.path)) != null) {
                        int g3 = g.g(g2, -1, true);
                        mediaTextureData.textureId = g3;
                        arrayList.add(Integer.valueOf(g3));
                    }
                }
            }
        }
    }

    public static void y(long j, MediaAEffect mediaAEffect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(65565, null, j, mediaAEffect) == null) || mediaAEffect == null || mediaAEffect.duration == 0) {
            return;
        }
        if (mediaAEffect.isSceneEffect()) {
            A(j, mediaAEffect);
        } else if (mediaAEffect.isStartEndEffect()) {
            B(j, mediaAEffect);
        } else if (mediaAEffect.isEqualityEffect()) {
            z(j, mediaAEffect);
        }
    }

    public static void z(long j, MediaAEffect mediaAEffect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65566, null, j, mediaAEffect) == null) {
            if (!TextUtils.equals(MediaAEffect.AE_ANIM_ONCE, mediaAEffect.repeatMode)) {
                long j2 = mediaAEffect.duration;
                int i2 = (int) (j / j2);
                if (((int) (j % j2)) != 0) {
                    i2++;
                }
                j /= i2;
            }
            A(j, mediaAEffect);
        }
    }
}
