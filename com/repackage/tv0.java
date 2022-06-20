package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.model.HistoryCache;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qk0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes7.dex */
public class tv0 extends pv0 {
    public static /* synthetic */ Interceptable $ic;
    public static final HistoryCache e;
    public transient /* synthetic */ FieldHolder $fh;
    public bv0 d;

    /* loaded from: classes7.dex */
    public static final class a implements qk0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdVideoSeries a;
        public final /* synthetic */ BdVideoSeries b;

        public a(BdVideoSeries bdVideoSeries, tv0 tv0Var, BdVideoSeries bdVideoSeries2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdVideoSeries, tv0Var, bdVideoSeries2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdVideoSeries;
            this.b = bdVideoSeries2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755277437, "Lcom/repackage/tv0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755277437, "Lcom/repackage/tv0;");
                return;
            }
        }
        e = new HistoryCache();
    }

    public tv0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void A(BdVideoSeries bdVideoSeries) {
        po0 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdVideoSeries) == null) || (i = i()) == null) {
            return;
        }
        ev0 videoTask = i.K();
        Intrinsics.checkNotNullExpressionValue(videoTask, "videoTask");
        p(videoTask, bdVideoSeries);
        if (i.Z() || i.Y() || i.W()) {
            z(i);
        }
    }

    @Override // com.repackage.pv0, com.repackage.rv0
    public void g(ir0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.g(event);
            String c = event.c();
            int hashCode = c.hashCode();
            if (hashCode != -1026415353) {
                if (hashCode == 1671611006 && c.equals("plugin_event_load_player_history")) {
                    Object f = event.f(1);
                    w((BdVideoSeries) (f instanceof BdVideoSeries ? f : null));
                }
            } else if (c.equals("plugin_event_save_player_history")) {
                Object f2 = event.f(1);
                BdVideoSeries bdVideoSeries = (BdVideoSeries) (f2 instanceof BdVideoSeries ? f2 : null);
                if (bdVideoSeries != null) {
                    y(bdVideoSeries);
                }
            }
        }
    }

    @Override // com.repackage.js0
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new int[]{4, 5, 7} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.pv0, com.repackage.js0
    public void h(PlayerStatus status, PlayerStatus old) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, status, old) == null) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(old, "old");
            super.h(status, old);
            int i = sv0.$EnumSwitchMapping$0[status.ordinal()];
            if (i == 1) {
                z(i());
            } else if (i != 2) {
            } else {
                r();
            }
        }
    }

    @Override // com.repackage.pv0
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.m();
            this.d = null;
        }
    }

    public final void p(ev0 ev0Var, BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, ev0Var, bdVideoSeries) == null) {
            ev0Var.d = Math.max(0, bdVideoSeries.getPosition());
            ev0Var.f = Math.max(0, bdVideoSeries.getPositionMs());
            int max = Math.max(0, bdVideoSeries.getDuration());
            ev0Var.e = max;
            if (ev0Var.d > max) {
                ev0Var.e = 0;
                ev0Var.d = 0;
                ev0Var.f = 0;
            }
        }
    }

    public final void r() {
        po0 i;
        BdVideoSeries videoSeries;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (i = i()) == null || (videoSeries = i.o1()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(videoSeries, "videoSeries");
        av0.b(videoSeries, 0, videoSeries.getDurationMs());
        y(videoSeries);
    }

    public final boolean s(BdVideoSeries bdVideoSeries, String str) {
        InterceptResult invokeLL;
        bv0 bv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdVideoSeries, str)) == null) {
            bv0 findCache = e.findCache(str, bdVideoSeries.getVid());
            int positionMs = bdVideoSeries.getPositionMs();
            if (findCache == null || positionMs != findCache.g()) {
                bv0 bv0Var2 = this.d;
                return Intrinsics.areEqual(bv0Var2 != null ? bv0Var2.e() : null, bdVideoSeries.getVid()) && (bv0Var = this.d) != null && bv0Var.g() == bdVideoSeries.getPositionMs();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pv0
    /* renamed from: t */
    public po0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            oo0 i = super.i();
            if (!(i instanceof po0)) {
                i = null;
            }
            return (po0) i;
        }
        return (po0) invokeV.objValue;
    }

    public String u(BdVideoSeries videoSeries) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, videoSeries)) == null) {
            Intrinsics.checkNotNullParameter(videoSeries, "videoSeries");
            BdVideo selectedVideo = videoSeries.getSelectedVideo();
            String a2 = bv0.a(selectedVideo != null ? selectedVideo.getSourceUrl() : null);
            return a2 != null ? a2 : "";
        }
        return (String) invokeL.objValue;
    }

    public final boolean v(BdVideoSeries bdVideoSeries) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdVideoSeries)) == null) ? bdVideoSeries.getStartPosition() >= 0 : invokeL.booleanValue;
    }

    public final void w(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bdVideoSeries) == null) || i() == null || bdVideoSeries == null) {
            return;
        }
        if (v(bdVideoSeries)) {
            bdVideoSeries.setPosition(bdVideoSeries.getStartPosition());
            bdVideoSeries.setStartPosition(-1);
            A(bdVideoSeries);
            return;
        }
        String u = u(bdVideoSeries);
        bv0 findCache = e.findCache(u, bdVideoSeries.getVid());
        if (findCache != null) {
            x(findCache, bdVideoSeries);
            A(bdVideoSeries);
            return;
        }
        qk0.b.a().a(u, bdVideoSeries.getVid(), new a(bdVideoSeries, this, bdVideoSeries));
    }

    public void x(bv0 info, BdVideoSeries videoSeries) {
        Integer intOrNull;
        Integer intOrNull2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, info, videoSeries) == null) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(videoSeries, "videoSeries");
            String f = info.f();
            int i = 0;
            int intValue = (f == null || (intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(f)) == null) ? 0 : intOrNull2.intValue();
            String h = info.h();
            int intValue2 = (h == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(h)) == null) ? 0 : intOrNull.intValue();
            if (videoSeries.getDuration() <= 0) {
                videoSeries.setDurationMs(intValue2 * 1000);
            }
            if (intValue <= 0 || intValue != intValue2) {
                i = intValue;
            } else {
                info.q("0");
            }
            if (info.g() > 0) {
                videoSeries.setPositionMs(info.g());
            } else {
                videoSeries.setPositionMs(i * 1000);
            }
            BdVideo selectedVideo = videoSeries.getSelectedVideo();
            if (selectedVideo != null) {
                selectedVideo.setCurrentLength(info.f());
            }
            BdVideo selectedVideo2 = videoSeries.getSelectedVideo();
            if (selectedVideo2 != null) {
                selectedVideo2.setTotalLength(String.valueOf(videoSeries.getDuration()));
            }
        }
    }

    public final void y(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdVideoSeries) == null) {
            rw0.a("savePlayProgress(series@" + System.identityHashCode(bdVideoSeries) + ") begin, save history" + bdVideoSeries + ".[" + this + ']');
            BdVideo selectedVideo = bdVideoSeries.getSelectedVideo();
            if (selectedVideo != null) {
                Intrinsics.checkNotNullExpressionValue(selectedVideo, "videoSeries.selectedVideo ?: return");
                String u = u(bdVideoSeries);
                if (Intrinsics.areEqual(selectedVideo.getCurrentLength(), "0")) {
                    rw0.a("savePlayProgress(series@" + System.identityHashCode(bdVideoSeries) + "), del when currentLength is 0,  history" + bdVideoSeries + ".[" + this + ']');
                    a11.b().b(u, bdVideoSeries.getVid());
                    e.removeCache(u, bdVideoSeries.getVid());
                } else if (s(bdVideoSeries, u)) {
                } else {
                    bv0 info = nr0.a(bdVideoSeries, selectedVideo, selectedVideo.getSourceUrl(), u);
                    Intrinsics.checkNotNullExpressionValue(info, "info");
                    if (info.i()) {
                        this.d = info;
                        String vid = bdVideoSeries.getVid();
                        Intrinsics.checkNotNullExpressionValue(vid, "videoSeries.vid");
                        if ((!StringsKt__StringsJVMKt.isBlank(vid)) || (!StringsKt__StringsJVMKt.isBlank(u))) {
                            e.add(info);
                        }
                        rw0.a("savePlayProgress(series@" + System.identityHashCode(bdVideoSeries) + "), info is {" + info + "}.[" + this + ']');
                        a11.b().a(bh0.b(), info, false);
                    }
                }
            }
        }
    }

    public final void z(po0 po0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, po0Var) == null) || po0Var == null) {
            return;
        }
        rw0.a("seekToTarget(player@" + System.identityHashCode(po0Var) + "),  position is " + po0Var.K().f + " ms .[" + this + ']');
        if (po0Var.K().f > 0) {
            po0Var.p0(po0Var.K().f);
        }
    }
}
