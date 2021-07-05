package d.a.s0.u1.p.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Class, IPlayerContext> f67317e;

    /* renamed from: f  reason: collision with root package name */
    public IVideoPlayerCallback f67318f;

    /* renamed from: g  reason: collision with root package name */
    public List<LivePlayer.OnInfoListener> f67319g;

    /* renamed from: h  reason: collision with root package name */
    public List<LivePlayer.OnProgressChangeListener> f67320h;

    /* renamed from: i  reason: collision with root package name */
    public String f67321i;
    public ViewGroup j;
    public OrientationHelper k;
    public boolean l;
    public BaseKernelLayer m;
    public Button n;

    /* renamed from: d.a.s0.u1.p.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1783a implements OrientationHelper.IOrientationChange {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Activity f67322a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f67323b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f67324c;

        /* renamed from: d  reason: collision with root package name */
        public long f67325d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67326e;

        public C1783a(a aVar, Activity activity) {
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
            this.f67326e = aVar;
            this.f67325d = 0L;
            this.f67322a = activity;
        }

        @Override // com.baidu.searchbox.player.helper.OrientationHelper.IOrientationChange
        public void onOrientationChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || !this.f67326e.l || a.o || OrientationHelper.isSystemOrientationLocked(this.f67322a)) {
                return;
            }
            if (!this.f67326e.c()) {
                this.f67323b = false;
                if (OrientationHelper.isPortrait(i2)) {
                    this.f67324c = true;
                }
                if (!this.f67324c || System.currentTimeMillis() - this.f67325d <= 1000) {
                    return;
                }
                if (OrientationHelper.isReverseLandscape(i2)) {
                    this.f67323b = true;
                    BdActivityUtils.requestLandscape(this.f67322a, true);
                    return;
                } else if (OrientationHelper.isLandscape(i2)) {
                    this.f67323b = true;
                    BdActivityUtils.requestLandscape(this.f67322a, false);
                    return;
                } else {
                    return;
                }
            }
            this.f67324c = false;
            if (OrientationHelper.isReverseLandscape(i2)) {
                this.f67323b = true;
                BdActivityUtils.requestLandscape(this.f67322a, true);
            } else if (OrientationHelper.isLandscape(i2)) {
                this.f67323b = true;
                BdActivityUtils.requestLandscape(this.f67322a, false);
            } else if (OrientationHelper.isPortrait(i2) && this.f67323b && System.currentTimeMillis() - this.f67325d > 1000) {
                this.f67325d = System.currentTimeMillis();
                this.f67323b = false;
                BdActivityUtils.requestPortrait(this.f67322a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1149137892, "Ld/a/s0/u1/p/j/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1149137892, "Ld/a/s0/u1/p/j/a;");
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
        this.f67317e = new HashMap<>();
        this.f67319g = new ArrayList();
        this.f67320h = new ArrayList();
        this.f67321i = PlayerConstant.HALF_MODE;
        this.l = true;
        this.m = null;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            Log.d("lp-media", str);
        }
    }

    public void addOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onInfoListener) == null) || onInfoListener == null || this.f67319g.contains(onInfoListener)) {
            return;
        }
        this.f67319g.add(onInfoListener);
    }

    public void addProgressListener(LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onProgressChangeListener) == null) || onProgressChangeListener == null || this.f67320h.contains(onProgressChangeListener)) {
            return;
        }
        this.f67320h.add(onProgressChangeListener);
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
            a("initHelper ");
            OrientationHelper orientationHelper = new OrientationHelper(context, 3);
            this.k = orientationHelper;
            if (orientationHelper.canDetectOrientation()) {
                this.k.enableSensor();
                this.k.setListener(new C1783a(this, (Activity) context));
            }
        }
    }

    @PublicMethod
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? TextUtils.equals(this.f67321i, PlayerConstant.FULL_MODE) : invokeV.booleanValue;
    }

    public boolean checkMode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(this.f67321i, str) : invokeL.booleanValue;
    }

    public BaseKernelLayer detachKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (orientationHelper = this.k) == null) {
            return;
        }
        this.l = false;
        orientationHelper.disable();
    }

    public void enableOrientationEventHelper() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (orientationHelper = this.k) != null && orientationHelper.canDetectOrientation()) {
            this.l = this.k.enableSensor();
        }
    }

    @PublicMethod
    public String getCurrentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f67321i : (String) invokeV.objValue;
    }

    public <T extends IPlayerContext> T getPlayerContext(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, cls)) == null) {
            a("getPlayerContext " + cls);
            T t = (T) this.f67317e.get(cls);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TextUtils.equals(this.f67321i, PlayerConstant.FLOATING_MODE) : invokeV.booleanValue;
    }

    public void registerContext(Class<? extends IPlayerContext> cls, IPlayerContext iPlayerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, cls, iPlayerContext) == null) {
            a("registerContext " + iPlayerContext);
            this.f67317e.put(cls, iPlayerContext);
        }
    }

    public void release() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (orientationHelper = this.k) == null) {
            return;
        }
        orientationHelper.disable();
    }

    public void removeOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onInfoListener) == null) || onInfoListener == null) {
            return;
        }
        this.f67319g.remove(onInfoListener);
    }

    public void removeProgressListener(LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, onProgressChangeListener) == null) || onProgressChangeListener == null) {
            return;
        }
        this.f67320h.remove(onProgressChangeListener);
    }

    public void setMode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            a("setMode mode= " + str);
            this.f67321i = str;
        }
    }

    public void setOrientationLock(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            o = z;
            if (z) {
                return;
            }
            enableOrientationEventHelper();
        }
    }

    public void setPlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, iVideoPlayerCallback) == null) {
            this.f67318f = iVideoPlayerCallback;
        }
    }

    public void switchToHalf() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.j != null && c() && (this.j.getContext() instanceof Activity)) {
            BdActivityUtils.requestPortrait((Activity) this.j.getContext());
        }
    }
}
