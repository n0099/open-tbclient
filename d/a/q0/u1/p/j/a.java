package d.a.q0.u1.p.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.searchbox.player.context.IPlayerContext;
import com.baidu.searchbox.player.helper.OrientationHelper;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.utils.BdActivityUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Class, IPlayerContext> f64745e;

    /* renamed from: f  reason: collision with root package name */
    public IVideoPlayerCallback f64746f;

    /* renamed from: g  reason: collision with root package name */
    public List<LivePlayer.OnInfoListener> f64747g;

    /* renamed from: h  reason: collision with root package name */
    public List<LivePlayer.OnProgressChangeListener> f64748h;

    /* renamed from: i  reason: collision with root package name */
    public String f64749i;
    public ViewGroup j;
    public OrientationHelper k;
    public boolean l;
    public BaseKernelLayer m;
    public Button n;

    /* renamed from: d.a.q0.u1.p.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1745a implements OrientationHelper.IOrientationChange {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Activity f64750a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64751b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f64752c;

        /* renamed from: d  reason: collision with root package name */
        public long f64753d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64754e;

        public C1745a(a aVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64754e = aVar;
            this.f64753d = 0L;
            this.f64750a = activity;
        }

        @Override // com.baidu.searchbox.player.helper.OrientationHelper.IOrientationChange
        public void onOrientationChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || !this.f64754e.l || a.o || OrientationHelper.isSystemOrientationLocked(this.f64750a)) {
                return;
            }
            if (!this.f64754e.c()) {
                this.f64751b = false;
                if (OrientationHelper.isPortrait(i2)) {
                    this.f64752c = true;
                }
                if (!this.f64752c || System.currentTimeMillis() - this.f64753d <= 1000) {
                    return;
                }
                if (OrientationHelper.isReverseLandscape(i2)) {
                    this.f64751b = true;
                    BdActivityUtils.requestLandscape(this.f64750a, true);
                    return;
                } else if (OrientationHelper.isLandscape(i2)) {
                    this.f64751b = true;
                    BdActivityUtils.requestLandscape(this.f64750a, false);
                    return;
                } else {
                    return;
                }
            }
            this.f64752c = false;
            if (OrientationHelper.isReverseLandscape(i2)) {
                this.f64751b = true;
                BdActivityUtils.requestLandscape(this.f64750a, true);
            } else if (OrientationHelper.isLandscape(i2)) {
                this.f64751b = true;
                BdActivityUtils.requestLandscape(this.f64750a, false);
            } else if (OrientationHelper.isPortrait(i2) && this.f64751b && System.currentTimeMillis() - this.f64753d > 1000) {
                this.f64753d = System.currentTimeMillis();
                this.f64751b = false;
                BdActivityUtils.requestPortrait(this.f64750a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(890972454, "Ld/a/q0/u1/p/j/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(890972454, "Ld/a/q0/u1/p/j/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64745e = new HashMap<>();
        this.f64747g = new ArrayList();
        this.f64748h = new ArrayList();
        this.f64749i = PlayerConstant.HALF_MODE;
        this.l = true;
        this.m = null;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && AppConfig.isDebug()) {
            Log.d("lp_bdrtc", str);
        }
    }

    public void addOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onInfoListener) == null) || onInfoListener == null || this.f64747g.contains(onInfoListener)) {
            return;
        }
        this.f64747g.add(onInfoListener);
    }

    public void addProgressListener(LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onProgressChangeListener) == null) || onProgressChangeListener == null || this.f64748h.contains(onProgressChangeListener)) {
            return;
        }
        this.f64748h.add(onProgressChangeListener);
    }

    public void attachKernelLayer(BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, baseKernelLayer) == null) {
            a("attachKernelLayer " + baseKernelLayer);
            this.m = baseKernelLayer;
            detachKernelLayer();
        }
    }

    public void attachToContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, viewGroup) == null) {
            this.j = viewGroup;
        }
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            a("initHelper");
            OrientationHelper orientationHelper = new OrientationHelper(context, 3);
            this.k = orientationHelper;
            if (orientationHelper.canDetectOrientation()) {
                this.k.enableSensor();
                this.k.setListener(new C1745a(this, (Activity) context));
            }
        }
    }

    @PublicMethod
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? TextUtils.equals(this.f64749i, PlayerConstant.FULL_MODE) : invokeV.booleanValue;
    }

    public boolean checkMode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(this.f64749i, str) : invokeL.booleanValue;
    }

    public void d(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, obj) == null) || this.f64747g == null) {
            return;
        }
        for (int i4 = 0; i4 < this.f64747g.size(); i4++) {
            this.f64747g.get(i4).onInfo(i2, i3, obj);
        }
    }

    public BaseKernelLayer detachKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            a("detachKernelLayer ");
            getPlayerKernelLayer();
            Button button = this.n;
            if (button != null) {
                ((ViewGroup) button.getParent()).removeView(this.n);
            }
            return this.m;
        }
        return (BaseKernelLayer) invokeV.objValue;
    }

    public void disableOrientationEventHelper() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (orientationHelper = this.k) == null) {
            return;
        }
        this.l = false;
        orientationHelper.disable();
    }

    public void enableOrientationEventHelper() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (orientationHelper = this.k) != null && orientationHelper.canDetectOrientation()) {
            this.l = this.k.enableSensor();
        }
    }

    @PublicMethod
    public String getCurrentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f64749i : (String) invokeV.objValue;
    }

    public <T extends IPlayerContext> T getPlayerContext(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, cls)) == null) {
            a("getPlayerContext " + cls);
            T t = (T) this.f64745e.get(cls);
            if (t != null) {
                return t;
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public BaseKernelLayer getPlayerKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            a("getPlayerKernelLayer ");
            if (this.m == null && this.j != null) {
                this.n = new Button(this.j.getContext());
                this.m = new BaseKernelLayer("NormalVideoKernel");
            }
            return this.m;
        }
        return (BaseKernelLayer) invokeV.objValue;
    }

    public void goBackOrForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (z) {
                enableOrientationEventHelper();
            } else {
                disableOrientationEventHelper();
            }
            ViewGroup viewGroup = this.j;
            if (viewGroup == null || !(viewGroup.getContext() instanceof Activity)) {
                return;
            }
            VideoSystemHelper.setKeepScreenOnOff((Activity) this.j.getContext(), z);
        }
    }

    @PublicMethod
    public boolean isFloatingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TextUtils.equals(this.f64749i, PlayerConstant.FLOATING_MODE) : invokeV.booleanValue;
    }

    public void registerContext(Class<? extends IPlayerContext> cls, IPlayerContext iPlayerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, cls, iPlayerContext) == null) {
            a("registerContext " + iPlayerContext);
            this.f64745e.put(cls, iPlayerContext);
        }
    }

    public void release() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (orientationHelper = this.k) == null) {
            return;
        }
        orientationHelper.disable();
    }

    public void removeOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, onInfoListener) == null) || onInfoListener == null) {
            return;
        }
        this.f64747g.remove(onInfoListener);
    }

    public void removeProgressListener(LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, onProgressChangeListener) == null) || onProgressChangeListener == null) {
            return;
        }
        this.f64748h.remove(onProgressChangeListener);
    }

    public void setMode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            a("setMode mode= " + str);
            this.f64749i = str;
        }
    }

    public void setOrientationLock(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            o = z;
            if (z) {
                return;
            }
            enableOrientationEventHelper();
        }
    }

    public void setPlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iVideoPlayerCallback) == null) {
            this.f64746f = iVideoPlayerCallback;
        }
    }

    public void switchToHalf() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.j != null && c() && (this.j.getContext() instanceof Activity)) {
            BdActivityUtils.requestPortrait((Activity) this.j.getContext());
        }
    }
}
