package d.a.n0.v.i.a.c;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.davemorrissey.labs.subscaleview.ImageSource;
import d.a.n0.a.v2.d0;
import d.a.n0.a.v2.q0;
import d.a.n0.a.y0.d;
import d.a.n0.a.y0.k.g.a;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes7.dex */
public abstract class a implements d.a.n0.a.y0.k.g.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean x;
    public static boolean y;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f51141a;

    /* renamed from: b  reason: collision with root package name */
    public String f51142b;

    /* renamed from: c  reason: collision with root package name */
    public Context f51143c;

    /* renamed from: d  reason: collision with root package name */
    public ZeusPluginFactory.Invoker f51144d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayer f51145e;

    /* renamed from: f  reason: collision with root package name */
    public String f51146f;

    /* renamed from: g  reason: collision with root package name */
    public AudioManager f51147g;

    /* renamed from: h  reason: collision with root package name */
    public String f51148h;

    /* renamed from: i  reason: collision with root package name */
    public a.InterfaceC0988a f51149i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public d.a.n0.v.j.a.c.a o;
    public final CyberPlayerManager.OnPreparedListener p;
    public final CyberPlayerManager.OnErrorListener q;
    public final CyberPlayerManager.OnCompletionListener r;
    public final CyberPlayerManager.OnInfoListener s;
    public final CyberPlayerManager.OnBufferingUpdateListener t;
    public final CyberPlayerManager.OnSeekCompleteListener u;
    public final CyberPlayerManager.OnVideoSizeChangedListener v;
    public final AudioManager.OnAudioFocusChangeListener w;

    /* renamed from: d.a.n0.v.i.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1156a implements CyberPlayerManager.OnSeekCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f51150e;

        public C1156a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51150e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && a.x) {
                Log.d("【CyberCallback】", "CyberPlayer" + this.f51150e.hashCode() + " - onSeekComplete()");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements CyberPlayerManager.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f51151e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51151e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                if (a.x) {
                    Log.d("【CyberCallback】", "CyberPlayer" + this.f51151e.hashCode() + " - onVideoSizeChanged(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i5 + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.f51151e.o.f51178e = i2;
                this.f51151e.o.f51179f = i3;
                if (i4 == 0 || i5 == 0) {
                    this.f51151e.m = 1;
                    this.f51151e.n = 1;
                } else {
                    this.f51151e.m = i4;
                    this.f51151e.n = i5;
                }
                a.InterfaceC0988a interfaceC0988a = this.f51151e.f51149i;
                if (interfaceC0988a != null) {
                    interfaceC0988a.f();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (a.x) {
                    Log.i("SwanInlineCyberWidget", "onAudioFocusChange: focusChange " + i2);
                }
                if (i2 == -1 && a.x) {
                    Log.i("SwanInlineCyberWidget", "onAudioFocusChange: focusChange = AudioManager.AUDIOFOCUS_LOSS");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f51152a;

        public d(a aVar, d.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51152a = aVar2;
        }

        @Override // d.a.n0.v.i.a.c.a.m
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f51152a.a(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a.n0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f51153e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f51154f;

        public e(a aVar, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51154f = aVar;
            this.f51153e = hashMap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.f51154f.w0().setDataSource(this.f51154f.f51143c, Uri.parse(str), this.f51153e);
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements CyberPlayerManager.InstallListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f51155a;

        public f(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51155a = mVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                if (a.x) {
                    Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
                }
                boolean unused = a.y = false;
                m mVar = this.f51155a;
                if (mVar != null) {
                    mVar.a(false);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
                if (a.x) {
                    Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
                }
                boolean unused = a.y = false;
                m mVar = this.f51155a;
                if (mVar != null) {
                    mVar.a(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f51156e;

        public g(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51156e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.n0.a.a2.e i2;
            SwanAppActivity x;
            Window window;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = d.a.n0.a.a2.e.i()) == null || (x = i2.x()) == null || (window = x.getWindow()) == null) {
                return;
            }
            try {
                if (this.f51156e) {
                    window.addFlags(128);
                } else {
                    window.clearFlags(128);
                }
            } catch (Exception e2) {
                if (a.x) {
                    throw new RuntimeException("inline video set screenOn/Off in wrong thread", e2);
                }
            }
            if (a.x) {
                Log.d("SwanInlineCyberWidget", "setKeepScreenOn: " + this.f51156e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f51157e;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51157e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a.x) {
                    Log.d("【CyberCallback】", "CyberPlayer" + this.f51157e.hashCode() + " - onPrepared()");
                }
                this.f51157e.o.f51178e = this.f51157e.getVideoWidth();
                this.f51157e.o.f51179f = this.f51157e.getVideoHeight();
                a.InterfaceC0988a interfaceC0988a = this.f51157e.f51149i;
                if (interfaceC0988a != null) {
                    interfaceC0988a.onPrepared();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f51158e;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51158e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                String obj2 = obj != null ? obj.toString() : StringUtil.NULL_STRING;
                if (a.x) {
                    Log.d("【CyberCallback】", "CyberPlayer" + this.f51158e.hashCode() + " - onError(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.f51158e.n0();
                this.f51158e.z0(i2);
                int i4 = i2 == -10000 ? 0 : i2;
                a.InterfaceC0988a interfaceC0988a = this.f51158e.f51149i;
                if (interfaceC0988a != null) {
                    interfaceC0988a.onError(i4);
                }
                this.f51158e.B0(i2, i3, obj2);
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f51159e;

        public j(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51159e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = this.f51159e.getDuration() != 0 && this.f51159e.getCurrentPosition() >= this.f51159e.getDuration();
                if (a.x) {
                    Log.d("【CyberCallback】", "CyberPlayer" + this.f51159e.hashCode() + " - onCompletion:(" + z + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.f51159e.n0();
                a aVar = this.f51159e;
                a.InterfaceC0988a interfaceC0988a = aVar.f51149i;
                if (interfaceC0988a != null) {
                    if (z) {
                        interfaceC0988a.onEnded();
                    } else {
                        interfaceC0988a.c(aVar.c());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f51160e;

        public k(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51160e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (a.x) {
                    String obj2 = obj != null ? obj.toString() : StringUtil.NULL_STRING;
                    Log.d("【CyberCallback】", "CyberPlayer" + this.f51160e.hashCode() + " - onInfo(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                switch (i2) {
                    case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                        this.f51160e.o.f51175b = i3;
                        break;
                    case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                        this.f51160e.o.f51174a = i3;
                        break;
                    case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                        this.f51160e.o.f51176c = i3;
                        break;
                }
                this.f51160e.z0(i2);
                this.f51160e.f51149i.b(i2);
                if (i2 == 904) {
                    this.f51160e.C0();
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class l implements CyberPlayerManager.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f51161e;

        public l(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51161e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && a.x) {
                Log.d("【CyberCallback】", "CyberPlayer" + this.f51161e.hashCode() + " - onBufferingUpdate(" + i2 + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface m {
        void a(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-616928517, "Ld/a/n0/v/i/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-616928517, "Ld/a/n0/v/i/a/c/a;");
                return;
            }
        }
        x = d.a.n0.a.k.f45831a;
        y = true;
    }

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51141a = -1;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = 1;
        this.n = 1;
        this.o = new d.a.n0.v.j.a.c.a();
        this.p = new h(this);
        this.q = new i(this);
        this.r = new j(this);
        this.s = new k(this);
        this.t = new l(this);
        this.u = new C1156a(this);
        this.v = new b(this);
        this.w = new c(this);
        this.f51144d = invoker;
        if (invoker != null) {
            Object obj = invoker.get("id");
            if (obj instanceof String) {
                this.f51146f = (String) obj;
            }
        }
        this.f51143c = d.a.n0.a.c1.a.b();
        this.f51148h = str;
    }

    public static String A0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            d.a.n0.a.a2.e i2 = d.a.n0.a.a2.e.i();
            return (!d.a.n0.a.k2.b.E(str) || i2 == null) ? str : d.a.n0.a.k2.b.H(str, i2);
        }
        return (String) invokeL.objValue;
    }

    public static void H0(@NonNull Context context, @Nullable m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, mVar) == null) {
            if (y) {
                if (x) {
                    Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
                }
                CyberPlayerManager.install(context.getApplicationContext(), d.a.n0.a.c1.a.a0().i(context), null, 7, null, null, new f(mVar));
                return;
            }
            if (x) {
                Log.v("【CyberCallback】", "CyberPlayer播放内核已安装，无需重复安装");
            }
            if (mVar != null) {
                mVar.a(true);
            }
        }
    }

    @Override // d.a.n0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            H0(d.a.n0.a.c1.a.b(), new d(this, aVar));
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                ZeusPluginFactory.Invoker invoker = this.f51144d;
                if (invoker != null) {
                    w0().changeProxyDynamic((String) invoker.get("Proxy"), true);
                    return;
                }
                return;
            }
            w0().changeProxyDynamic(null, false);
        }
    }

    public abstract void B0(int i2, int i3, String str);

    @Override // d.a.n0.a.y0.k.g.a
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public abstract void C0();

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.k) {
                if (x) {
                    Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                    return;
                }
                return;
            }
            if (this.f51147g == null) {
                this.f51147g = (AudioManager) this.f51143c.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            AudioManager audioManager = this.f51147g;
            if (audioManager == null) {
                return;
            }
            try {
                audioManager.requestAudioFocus(this.w, 3, 1);
            } catch (Exception e2) {
                if (x) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void E0(String str, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, hashMap) == null) {
            d.a.n0.a.c1.a.k().b(getContext(), str, new e(this, hashMap));
        }
    }

    public final void F0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            q0.X(new g(this, z));
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void G(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && x) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i2);
        }
    }

    public final void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.j = z;
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void L(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048587, this, i2, i3, i4, i5) == null) {
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public boolean O(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (x) {
                Log.d("SwanInlineCyberWidget", "setDataSource: " + str + " ;userAgent: " + str3 + " ;cookies: " + str2);
            }
            this.l = true;
            this.f51142b = str;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.startsWith(ImageSource.FILE_SCHEME)) {
                str = str.substring(8);
            }
            String A0 = A0(str);
            ZeusPluginFactory.Invoker invoker = this.f51144d;
            if (invoker != null) {
                String str4 = (String) invoker.get("Proxy");
                if (!TextUtils.isEmpty(str4)) {
                    w0().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
                    w0().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
                } else {
                    w0().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                    w0().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
                }
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("Cookie", str2);
            }
            if (z) {
                hashMap.put("x-hide-urls-from-log", "true");
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("User-Agent", str3);
            }
            String b2 = d0.b();
            if (!TextUtils.isEmpty(b2) && d0.c(A0)) {
                if (x) {
                    Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + b2);
                }
                hashMap.put("Referer", b2);
            }
            if (d.a.n0.a.k2.b.s(A0) == PathType.CLOUD) {
                E0(A0, hashMap);
            } else {
                w0().setDataSource(this.f51143c, Uri.parse(A0), hashMap);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.a.n0.a.y0.k.g.a
    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // d.a.n0.a.y0.k.g.a
    public a.InterfaceC0988a Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f51149i : (a.InterfaceC0988a) invokeV.objValue;
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void T(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, map) == null) {
            w0().setExternalInfo(CyberPlayerManager.STR_STAGE_INFO, map);
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    @CallSuper
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f51141a = 0;
            boolean isPlaying = isPlaying();
            pause();
            if (isPlaying) {
                G0(true);
            }
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.n0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f51148h : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            d.a.n0.a.y0.k.f.b.b().a(c(), str);
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.f51146f + "-" + hashCode();
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.y0.k.g.a
    @CallSuper
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f51141a = 1;
            if (isPlaying() || !v0()) {
                return;
            }
            G0(false);
            start();
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i2) == null) && x) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i2);
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f51143c : (Context) invokeV.objValue;
    }

    @Override // d.a.n0.a.y0.k.g.a
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? w0().getCurrentPosition() : invokeV.intValue;
    }

    @Override // d.a.n0.a.y0.k.g.a
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? w0().getDuration() : invokeV.intValue;
    }

    @Override // d.a.n0.a.y0.k.g.a
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? w0().getVideoHeight() : invokeV.intValue;
    }

    @Override // d.a.n0.a.y0.k.g.a
    public int getVideoSarDen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.n : invokeV.intValue;
    }

    @Override // d.a.n0.a.y0.k.g.a
    public int getVideoSarNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // d.a.n0.a.y0.k.g.a
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? w0().getVideoWidth() : invokeV.intValue;
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void h0(@NonNull a.InterfaceC0988a interfaceC0988a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, interfaceC0988a) == null) {
            this.f51149i = interfaceC0988a;
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? w0().isPlaying() : invokeV.booleanValue;
    }

    @Override // d.a.n0.a.y0.d
    @Nullable
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f51146f : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            if (x) {
                Log.i("SwanInlineCyberWidget", "setMuted: " + z);
            }
            this.k = z;
            if (z) {
                n0();
            } else {
                D0();
            }
            w0().muteOrUnmuteAudio(z);
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (this.f51147g == null) {
                this.f51147g = (AudioManager) this.f51143c.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            AudioManager audioManager = this.f51147g;
            if (audioManager == null) {
                return;
            }
            audioManager.abandonAudioFocus(this.w);
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (x) {
                Log.d("SwanInlineCyberWidget", this.f51146f + "-" + hashCode() + " pause()");
            }
            w0().pause();
            F0(false);
            G0(false);
            a.InterfaceC0988a interfaceC0988a = this.f51149i;
            if (interfaceC0988a != null) {
                interfaceC0988a.c(c());
            }
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public boolean prepareAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            D0();
            w0().prepareAsync();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (x) {
                Log.d("SwanInlineCyberWidget", this.f51146f + " release()");
            }
            a.InterfaceC0988a interfaceC0988a = this.f51149i;
            if (interfaceC0988a != null) {
                interfaceC0988a.onRelease(c());
            }
            n0();
            d.a.n0.a.u.e.o.k.e().q(c());
            w0().release();
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            w0().seekTo(i2);
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048616, this, f2) == null) {
            w0().setSpeed(f2);
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, surface) == null) {
            w0().setSurface(surface);
        }
    }

    @Override // d.a.n0.a.y0.k.g.a
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (x) {
                Log.d("SwanInlineCyberWidget", this.f51146f + "-" + hashCode() + " start()");
            }
            if (x0()) {
                if (x) {
                    Log.e("SwanInlineCyberWidget", this.f51146f + "-" + hashCode() + " start ignored, widget is in background");
                }
                G0(true);
                a.InterfaceC0988a interfaceC0988a = this.f51149i;
                if (interfaceC0988a != null) {
                    interfaceC0988a.c(c());
                    return;
                }
                return;
            }
            D0();
            w0().start();
            F0(true);
            a.InterfaceC0988a interfaceC0988a2 = this.f51149i;
            if (interfaceC0988a2 != null) {
                interfaceC0988a2.e(c());
            }
        }
    }

    public final boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final synchronized CyberPlayer w0() {
        InterceptResult invokeV;
        CyberPlayer cyberPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            synchronized (this) {
                if (this.f51145e == null) {
                    if (d.a.n0.a.c1.a.Z().D()) {
                        if (x) {
                            Log.d("SwanInlineCyberWidget", "getPlayer: same process");
                        }
                        this.f51145e = new CyberPlayer(0);
                    } else {
                        if (x) {
                            Log.d("SwanInlineCyberWidget", "getPlayer: self process");
                        }
                        this.f51145e = new CyberPlayer(0);
                    }
                    this.f51145e.setOnPreparedListener(this.p);
                    this.f51145e.setOnVideoSizeChangedListener(this.v);
                    this.f51145e.setOnCompletionListener(this.r);
                    this.f51145e.setOnErrorListener(this.q);
                    this.f51145e.setOnInfoListener(this.s);
                    this.f51145e.setOnBufferingUpdateListener(this.t);
                    this.f51145e.setOnSeekCompleteListener(this.u);
                    if (x) {
                        Log.d("SwanInlineCyberWidget", "create " + this.f51145e.hashCode() + " player");
                    }
                }
                cyberPlayer = this.f51145e;
            }
            return cyberPlayer;
        }
        return (CyberPlayer) invokeV.objValue;
    }

    public final boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (this.f51141a == -1) {
                SwanAppActivity x2 = d.a.n0.a.a2.d.g().x();
                if (x2 == null) {
                    if (x) {
                        Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                    }
                    return true;
                }
                d.a.n0.a.t0.c frame = x2.getFrame();
                if (frame == null) {
                    if (x) {
                        Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                    }
                    return true;
                }
                if (x) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("check background by frame lifeState, background ? ");
                    sb.append(!frame.P().hasStarted());
                    Log.v("SwanInlineCyberWidget", sb.toString());
                }
                return !frame.P().hasStarted();
            }
            if (x) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("check background by kernel state, background ? ");
                sb2.append(this.f51141a == 0);
                Log.v("SwanInlineCyberWidget", sb2.toString());
            }
            return this.f51141a == 0;
        }
        return invokeV.booleanValue;
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            String a2 = this.o.a();
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            if (x) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + a2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            a.InterfaceC0988a interfaceC0988a = this.f51149i;
            if (interfaceC0988a != null) {
                interfaceC0988a.d(a2);
            }
        }
    }

    public final void z0(int i2) {
        a.InterfaceC0988a interfaceC0988a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            int b2 = d.a.n0.v.j.a.b.a.b(i2);
            if (x) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i2 + ", statusCode " + b2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            if (b2 != 100) {
                if (b2 == 2101 && (interfaceC0988a = this.f51149i) != null) {
                    interfaceC0988a.a(2102);
                }
                a.InterfaceC0988a interfaceC0988a2 = this.f51149i;
                if (interfaceC0988a2 != null) {
                    interfaceC0988a2.a(b2);
                }
            }
        }
    }
}
