package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes7.dex */
public class sv0 extends lv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sv0(String kernelType) {
        super(kernelType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kernelType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(kernelType, "kernelType");
        this.h = "";
    }

    public final void A0(BdVideoSeries bdVideoSeries, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, bdVideoSeries, i) == null) {
            l0(CyberPlayerManager.OPT_FEED_VIDEO, ArraysKt___ArraysKt.contains(new Integer[]{1, 22, 6}, Integer.valueOf(i)) ? "1" : "0");
            l0(CyberPlayerManager.OPT_ENABLE_SEI_DATA_NOTIFICATION, "1");
            l0(CyberPlayerManager.OPT_VIDEO_BPS, String.valueOf(bdVideoSeries.getVideoBps()));
            l0(CyberPlayerManager.OPT_VIDEO_MOOV_SIZE, String.valueOf(bdVideoSeries.getMoovSize()));
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dt0 a = dt0.a();
            Intrinsics.checkNotNullExpressionValue(a, "PlayerExperimentManager.get()");
            float b = a.b();
            dt0 a2 = dt0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "PlayerExperimentManager.get()");
            float c = a2.c();
            float f = 0;
            if (b >= f) {
                l0("device_dynamic_score", String.valueOf(b));
            }
            if (c >= f) {
                l0("device_static_score", String.valueOf(c));
            }
        }
    }

    @Override // com.repackage.lv0, com.repackage.ev0
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.C();
            this.e.M(ki0.e());
        }
    }

    public final void C0(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            ay0.a("pcdn is close");
            l0(CyberPlayerManager.OPT_ENABLE_PCDN, "0");
            l0(CyberPlayerManager.OPT_ENABLE_P2P, "0");
        }
    }

    public final void D0(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdVideoSeries) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_STAGE_INFO));
            String from = bdVideoSeries.getFrom();
            Intrinsics.checkNotNullExpressionValue(from, "series.from");
            hashMap.put("video_from", from);
            String page = bdVideoSeries.getPage();
            Intrinsics.checkNotNullExpressionValue(page, "series.page");
            hashMap.put("video_page", page);
            String pd = bdVideoSeries.getPd();
            Intrinsics.checkNotNullExpressionValue(pd, "series.pd");
            hashMap.put("video_source", pd);
            if (Intrinsics.areEqual(bdVideoSeries.getFormat(), BdVideoSeries.FORMAT_FLV)) {
                hashMap.put("bd_live", "1");
            } else if (Intrinsics.areEqual(bdVideoSeries.getFormat(), "yy")) {
                hashMap.put("yy_live", "1");
            }
            h0(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l0(CyberPlayerManager.OPT_SR_OPTION, String.valueOf(oq0.c()));
        }
    }

    public final void F0(BdVideo bdVideo, int i) {
        String title;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, bdVideo, i) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, String.valueOf(i));
            String str = "";
            hashMap.put(CyberPlayerManager.STAGE_INFO_SOURCE, (bdVideo == null || (r1 = bdVideo.getSourceUrl()) == null) ? "" : "");
            if (bdVideo != null && (title = bdVideo.getTitle()) != null) {
                str = title;
            }
            hashMap.put(CyberPlayerManager.STAGE_INFO_TITLE, str);
            h0(CyberPlayerManager.STR_STAGE_INFO, hashMap);
        }
    }

    public final void G0(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdVideoSeries) == null) {
            l0(CyberPlayerManager.OPT_VIDEO_BPS, String.valueOf(bdVideoSeries.getVideoBps()));
            l0(CyberPlayerManager.OPT_VIDEO_MOOV_SIZE, String.valueOf(bdVideoSeries.getMoovSize()));
        }
    }

    public final void H0(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdVideoSeries) == null) {
            ClarityUrlList clarityList = bdVideoSeries.getClarityList();
            String format = bdVideoSeries.getFormat();
            p0(format, z0(format, clarityList));
        }
    }

    public void I0(BdVideoSeries series, mw0 mw0Var) {
        ClarityUrlList.c currentClarityUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, series, mw0Var) == null) {
            Intrinsics.checkNotNullParameter(series, "series");
            int i = mw0Var != null ? mw0Var.d : -1;
            ClarityUrlList clarityList = series.getClarityList();
            if (clarityList != null && (currentClarityUrl = clarityList.getCurrentClarityUrl()) != null) {
                currentClarityUrl.b();
            }
            String str = (mw0Var == null || (str = mw0Var.a) == null) ? "" : "";
            n0(series.getProxy());
            i0(x0(series.getHttpHeader()));
            F0(series.getSelectedVideo(), i);
            D0(series);
            H0(series);
            A0(series, i);
            C0(i, str);
            E0();
            B0();
            G0(series);
        }
    }

    @Override // com.repackage.lv0
    public pt0 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ru0 ru0Var = this.e;
            if (ru0Var instanceof tu0) {
                if (ru0Var != null) {
                    return ((tu0) ru0Var).X();
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.nadcore.player.kernel.CyberVideoKernel");
            }
            return null;
        }
        return (pt0) invokeV.objValue;
    }

    @Override // com.repackage.lv0, com.repackage.ev0, com.repackage.st0
    public void d(rs0 event) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            String c = event.c();
            int hashCode = c.hashCode();
            if (hashCode != -882902390) {
                if (hashCode == 1370689931 && c.equals(PlayerEvent.ACTION_ON_INFO)) {
                    event.g(1);
                }
            } else if (c.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                Object f = event.f(3);
                if (!(f instanceof mw0)) {
                    f = null;
                }
                mw0 mw0Var = (mw0) f;
                yp0 v = v();
                if (v != null && (o1 = v.o1()) != null) {
                    String vid = o1.getVid();
                    Intrinsics.checkNotNullExpressionValue(vid, "vid");
                    this.h = vid;
                    Intrinsics.checkNotNullExpressionValue(o1, "this");
                    I0(o1, mw0Var);
                }
            }
            super.d(event);
        }
    }

    @Override // com.repackage.lv0, com.repackage.ev0, com.repackage.st0
    public void k(rs0 event) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(LayerEvent.ACTION_CHANGE_CLARITY, event.c())) {
                Object f = event.f(31);
                if (!(f instanceof mw0)) {
                    f = null;
                }
                mw0 mw0Var = (mw0) f;
                yp0 v = v();
                if (v != null && (o1 = v.o1()) != null) {
                    Intrinsics.checkNotNullExpressionValue(o1, "this");
                    I0(o1, mw0Var);
                }
            }
            super.k(event);
        }
    }

    @Override // com.repackage.ev0, com.repackage.rv0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onLayerRelease();
        }
    }

    @Override // com.repackage.lv0
    public void r0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) {
            super.r0(str, z);
        }
    }

    @Override // com.repackage.lv0
    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.t0();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ev0
    /* renamed from: w0 */
    public yp0 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            xp0 v = super.v();
            if (!(v instanceof yp0)) {
                v = null;
            }
            return (yp0) v;
        }
        return (yp0) invokeV.objValue;
    }

    public final HashMap<String, String> x0(String str) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (str != null) {
                if (str.length() > 0) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    Object[] array = new Regex("\r\n").split(str, 0).toArray(new String[0]);
                    if (array != null) {
                        for (String str2 : (String[]) array) {
                            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, ":", 0, false, 6, (Object) null);
                            if (indexOf$default > 0 && indexOf$default < str2.length()) {
                                if (str2 != null) {
                                    String substring = str2.substring(0, indexOf$default);
                                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    int i = indexOf$default + 1;
                                    if (str2 != null) {
                                        String substring2 = str2.substring(i);
                                        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                                        hashMap.put(substring, substring2);
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                        }
                        return hashMap;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                return null;
            }
            return null;
        }
        return (HashMap) invokeL.objValue;
    }

    public final String y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public final HashMap<String, String> z0(String str, ClarityUrlList clarityUrlList) {
        InterceptResult invokeLL;
        ClarityUrlList.c currentClarityUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, clarityUrlList)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (((clarityUrlList == null || (currentClarityUrl = clarityUrlList.getCurrentClarityUrl()) == null) ? null : currentClarityUrl.j()) != null) {
                ClarityUrlList.c currentClarityUrl2 = clarityUrlList.getCurrentClarityUrl();
                Intrinsics.checkNotNullExpressionValue(currentClarityUrl2, "clarityUrlList.currentClarityUrl");
                hashMap.putAll(currentClarityUrl2.j());
            }
            if (!Intrinsics.areEqual(str, BdVideoSeries.FORMAT_FLV) && !Intrinsics.areEqual(str, "yy")) {
                hashMap.put(CyberPlayerManager.OPT_IS_LIVE_VIDEO, "false");
            } else {
                hashMap.put(CyberPlayerManager.OPT_IS_LIVE_VIDEO, "true");
            }
            return hashMap;
        }
        return (HashMap) invokeLL.objValue;
    }
}
