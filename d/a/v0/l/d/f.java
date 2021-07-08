package d.a.v0.l.d;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer;
import com.baidu.ugc.utils.FileUtils;
import d.a.v0.s.a;
import d.a.v0.t.s;
import d.a.v0.t.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f68035a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements a.InterfaceC1944a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1944a f68036a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.v0.s.a f68037b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f68038c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f68039d;

        public a(a.InterfaceC1944a interfaceC1944a, d.a.v0.s.a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1944a, aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68036a = interfaceC1944a;
            this.f68037b = aVar;
            this.f68038c = str;
            this.f68039d = str2;
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.v0.t.c.e("FFmpegCmdExecutor-modifyAudioProperty", "onCompletion:src:" + this.f68038c + ",:dest:" + this.f68039d);
                a.InterfaceC1944a interfaceC1944a = this.f68036a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onCompletion();
                }
                this.f68037b.release();
            }
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                d.a.v0.t.c.e("FFmpegCmdExecutor-modifyAudioProperty", sb.toString());
                a.InterfaceC1944a interfaceC1944a = this.f68036a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onError(i2, i3, obj);
                }
                this.f68037b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                d.a.v0.t.c.j("FFmpegCmdExecutor-modifyAudioProperty", sb.toString());
                a.InterfaceC1944a interfaceC1944a = this.f68036a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements a.InterfaceC1944a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1944a f68040a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.v0.s.a f68041b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f68042c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f68043d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f68044e;

        public b(a.InterfaceC1944a interfaceC1944a, d.a.v0.s.a aVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1944a, aVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68040a = interfaceC1944a;
            this.f68041b = aVar;
            this.f68042c = str;
            this.f68043d = str2;
            this.f68044e = str3;
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.v0.t.c.e("FFmpegCmdExecutor-mixAudio", "onCompletion:src:" + this.f68042c + "," + this.f68043d + ",:dest:" + this.f68044e);
                a.InterfaceC1944a interfaceC1944a = this.f68040a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onCompletion();
                }
                this.f68041b.release();
            }
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                d.a.v0.t.c.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1944a interfaceC1944a = this.f68040a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onError(i2, i3, obj);
                }
                this.f68041b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                d.a.v0.t.c.j("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1944a interfaceC1944a = this.f68040a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements a.InterfaceC1944a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1944a f68045a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.v0.s.a f68046b;

        public c(a.InterfaceC1944a interfaceC1944a, d.a.v0.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1944a, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68045a = interfaceC1944a;
            this.f68046b = aVar;
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.InterfaceC1944a interfaceC1944a = this.f68045a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onCompletion();
                }
                this.f68046b.release();
            }
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                d.a.v0.t.c.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1944a interfaceC1944a = this.f68045a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onError(i2, i3, obj);
                }
                this.f68046b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                d.a.v0.t.c.j("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1944a interfaceC1944a = this.f68045a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements a.InterfaceC1944a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1944a f68047a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.v0.s.a f68048b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f68049c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f68050d;

        public d(a.InterfaceC1944a interfaceC1944a, d.a.v0.s.a aVar, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1944a, aVar, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68047a = interfaceC1944a;
            this.f68048b = aVar;
            this.f68049c = list;
            this.f68050d = str;
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.v0.t.c.j("FFmpegCmdExecutor-concat", "onCompletion:inputsize:" + this.f68049c.size() + ",dest:" + this.f68050d);
                a.InterfaceC1944a interfaceC1944a = this.f68047a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onCompletion();
                }
                this.f68048b.release();
            }
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                d.a.v0.t.c.j("FFmpegCmdExecutor-concat", sb.toString());
                a.InterfaceC1944a interfaceC1944a = this.f68047a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onError(i2, i3, obj);
                }
                this.f68048b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                d.a.v0.t.c.j("FFmpegCmdExecutor-concat", sb.toString());
                a.InterfaceC1944a interfaceC1944a = this.f68047a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements a.InterfaceC1944a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1944a f68051a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.v0.s.a f68052b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f68053c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f68054d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f68055e;

        public e(a.InterfaceC1944a interfaceC1944a, d.a.v0.s.a aVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1944a, aVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68051a = interfaceC1944a;
            this.f68052b = aVar;
            this.f68053c = str;
            this.f68054d = str2;
            this.f68055e = str3;
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.v0.t.c.e("FFmpegCmdExecutor-mixAudio", "onCompletion:video:" + this.f68053c + ",audio" + this.f68054d + ",:dest:" + this.f68055e);
                a.InterfaceC1944a interfaceC1944a = this.f68051a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onCompletion();
                }
                this.f68052b.release();
            }
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                d.a.v0.t.c.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1944a interfaceC1944a = this.f68051a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onError(i2, i3, obj);
                }
                this.f68052b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // d.a.v0.s.a.InterfaceC1944a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                d.a.v0.t.c.j("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1944a interfaceC1944a = this.f68051a;
                if (interfaceC1944a != null) {
                    interfaceC1944a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* renamed from: d.a.v0.l.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1933f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f68056a;

        /* renamed from: b  reason: collision with root package name */
        public int f68057b;

        /* renamed from: c  reason: collision with root package name */
        public int f68058c;

        /* renamed from: d  reason: collision with root package name */
        public String f68059d;

        /* renamed from: e  reason: collision with root package name */
        public int f68060e;

        public C1933f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68056a = MediaEncodeParams.AUDIO_SAMPLE_RATE;
            this.f68057b = 1;
            this.f68058c = 16;
            this.f68060e = 0;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f68060e;
                return i2 == 5 || i2 == 6 || i2 == 8 || i2 == 9;
            }
            return invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.f68060e;
                return i2 == 3 || i2 == 4 || i2 == 8 || i2 == 9;
            }
            return invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f68060e;
                return i2 == 1 || i2 == 4 || i2 == 6 || i2 == 9;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(702520563, "Ld/a/v0/l/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(702520563, "Ld/a/v0/l/d/f;");
                return;
            }
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            f68035a = true;
        } else {
            f68035a = false;
        }
    }

    public static byte[] a(byte b2, byte b3, byte b4, byte b5, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3), Byte.valueOf(b4), Byte.valueOf(b5), Boolean.valueOf(z)})) == null) ? f((short) ((h(b2, b3, z) / 2) + (h(b4, b5, z) / 2)), z) : (byte[]) invokeCommon.objValue;
    }

    public static void b(List<String> list, String str, String str2, a.InterfaceC1944a interfaceC1944a, boolean z, boolean z2) {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{list, str, str2, interfaceC1944a, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            d.a.v0.s.a aVar = (d.a.v0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (d.a.v0.t.h.e(list)) {
                if (interfaceC1944a != null) {
                    interfaceC1944a.onError(-1, -1, "input list null");
                }
            } else if (aVar == null) {
                if (interfaceC1944a != null) {
                    interfaceC1944a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                }
            } else {
                aVar.setListener(new d(interfaceC1944a, aVar, list, str));
                if (TextUtils.isEmpty(str2)) {
                    file = new File(FileUtils.removeExtention(str) + System.currentTimeMillis() + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
                } else {
                    String fileNameWithOutExtention = FileUtils.getFileNameWithOutExtention(str);
                    file = new File(str2 + fileNameWithOutExtention + System.currentTimeMillis() + "concat.txt");
                }
                d.a.v0.t.c.j("FFmpegCmdExecutor-concat", "inputfilename:" + file.getPath());
                StringBuilder sb = new StringBuilder();
                for (String str3 : list) {
                    sb.append("file '");
                    sb.append(str3);
                    sb.append("'\n");
                }
                FileUtils.writeFile(file, sb.toString(), false);
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("-f");
                arrayList.add("concat");
                arrayList.add("-safe");
                arrayList.add("0");
                arrayList.add("-i");
                arrayList.add(file.getPath());
                if (!z) {
                    arrayList.add("-vn");
                }
                arrayList.add("-c");
                if (z2) {
                    arrayList.add("aac");
                } else {
                    arrayList.add("copy");
                }
                arrayList.add(str);
                aVar.setSource(arrayList);
                aVar.start();
            }
        }
    }

    public static byte[] c(int i2, int i3, byte[] bArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i2, i3, bArr)) == null) {
            d.a.v0.t.c.b("convertByteWidth sourceByteWidth = " + i2 + " outputByteWidth = " + i3);
            if (i2 == i3) {
                return bArr;
            }
            int length = bArr.length;
            if (i2 != 1) {
                if (i2 == 2 && i3 == 1) {
                    int i4 = length / 2;
                    byte[] bArr2 = new byte[i4];
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = i5 * 2;
                        bArr2[i5] = (byte) (h(bArr[i6], bArr[i6 + 1], f68035a) / 256);
                    }
                    return bArr2;
                }
            } else if (i3 == 2) {
                byte[] bArr3 = new byte[length * 2];
                for (int i7 = 0; i7 < length; i7++) {
                    byte[] f2 = f((short) (bArr[i7] * 256), f68035a);
                    int i8 = i7 * 2;
                    bArr3[i8] = f2[0];
                    bArr3[i8 + 1] = f2[1];
                }
                return bArr3;
            }
            return bArr;
        }
        return (byte[]) invokeIIL.objValue;
    }

    public static byte[] d(int i2, int i3, int i4, byte[] bArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bArr})) == null) {
            d.a.v0.t.c.b("convertChannelCount sourceChannelCount = " + i2 + " outputChannelCount = " + i3);
            if (i2 == i3) {
                return bArr;
            }
            if (i4 == 1 || i4 == 2) {
                int length = bArr.length;
                int i5 = 0;
                if (i2 != 1) {
                    if (i2 == 2 && i3 == 1) {
                        int i6 = length / 2;
                        byte[] bArr2 = new byte[i6];
                        if (i4 == 1) {
                            while (i5 < i6) {
                                int i7 = i5 * 2;
                                bArr2[i5] = (byte) (((short) (bArr[i7] + bArr[i7 + 1])) >> 1);
                                i5 += 2;
                            }
                        } else if (i4 == 2) {
                            for (int i8 = 0; i8 < i6; i8 += 2) {
                                int i9 = i8 * 2;
                                byte[] a2 = a(bArr[i9], bArr[i9 + 1], bArr[i9 + 2], bArr[i9 + 3], f68035a);
                                bArr2[i8] = a2[0];
                                bArr2[i8 + 1] = a2[1];
                            }
                        }
                        return bArr2;
                    }
                } else if (i3 == 2) {
                    byte[] bArr3 = new byte[length * 2];
                    if (i4 == 1) {
                        while (i5 < length) {
                            byte b2 = bArr[i5];
                            int i10 = i5 * 2;
                            bArr3[i10] = b2;
                            bArr3[i10 + 1] = b2;
                            i5++;
                        }
                    } else if (i4 == 2) {
                        while (i5 < length) {
                            byte b3 = bArr[i5];
                            byte b4 = bArr[i5 + 1];
                            int i11 = i5 * 2;
                            bArr3[i11] = b3;
                            bArr3[i11 + 1] = b4;
                            bArr3[i11 + 2] = b3;
                            bArr3[i11 + 3] = b4;
                            i5 += 2;
                        }
                    }
                    return bArr3;
                }
                return bArr;
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    @TargetApi(16)
    public static C1933f e(String str) {
        InterceptResult invokeL;
        MediaFormat mediaFormat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(str);
                int i2 = 0;
                while (true) {
                    if (i2 >= mediaExtractor.getTrackCount()) {
                        mediaFormat = null;
                        break;
                    }
                    mediaFormat = mediaExtractor.getTrackFormat(i2);
                    if (mediaFormat.getString("mime").startsWith("audio/")) {
                        mediaExtractor.selectTrack(i2);
                        break;
                    }
                    i2++;
                }
                if (mediaFormat == null) {
                    mediaExtractor.release();
                    return null;
                }
                C1933f c1933f = new C1933f();
                c1933f.f68059d = mediaFormat.getString("mime");
                c1933f.f68056a = mediaFormat.containsKey("sample-rate") ? mediaFormat.getInteger("sample-rate") : MediaEncodeParams.AUDIO_SAMPLE_RATE;
                c1933f.f68057b = mediaFormat.containsKey("channel-count") ? mediaFormat.getInteger("channel-count") : 1;
                c1933f.f68058c = mediaFormat.containsKey("bit-width") ? mediaFormat.getInteger("bit-width") : 16;
                mediaExtractor.release();
                return c1933f;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1933f) invokeL.objValue;
    }

    public static byte[] f(short s, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Short.valueOf(s), Boolean.valueOf(z)})) == null) {
            byte[] bArr = new byte[2];
            if (z) {
                bArr[1] = (byte) (s & 255);
                bArr[0] = (byte) (((short) (s >> 8)) & 255);
            } else {
                bArr[0] = (byte) (s & 255);
                bArr[1] = (byte) (((short) (s >> 8)) & 255);
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static int g(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, mediaFormat)) == null) {
            String string = mediaFormat.getString("mime");
            if (string.startsWith(com.sina.weibo.sdk.utils.FileUtils.VIDEO_FILE_START)) {
                return 1;
            }
            return string.startsWith("audio/") ? 2 : 0;
        }
        return invokeL.intValue;
    }

    public static short h(byte b2, byte b3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3), Boolean.valueOf(z)})) == null) {
            return (short) (z ? ((short) (((short) ((b2 & 255) | 0)) << 8)) | (b3 & 255) : (b2 & 255) | ((short) (((short) ((b3 & 255) | 0)) << 8)));
        }
        return invokeCommon.shortValue;
    }

    public static boolean i(C1933f... c1933fArr) {
        InterceptResult invokeL;
        C1933f c1933f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, c1933fArr)) == null) {
            if (c1933fArr == null || c1933fArr.length < 2 || (c1933f = c1933fArr[0]) == null) {
                return false;
            }
            boolean z = true;
            for (int i2 = 1; i2 < c1933fArr.length; i2++) {
                if (c1933f.f68056a != c1933fArr[i2].f68056a) {
                    c1933fArr[i2].f68060e++;
                    z = false;
                }
                if (c1933f.f68057b != c1933fArr[i2].f68057b) {
                    c1933fArr[i2].f68060e += 3;
                    z = false;
                }
                if (c1933f.f68058c != c1933fArr[i2].f68058c) {
                    c1933fArr[i2].f68060e += 5;
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void j(String str, String str2, String str3, int i2, a.InterfaceC1944a interfaceC1944a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, str2, str3, Integer.valueOf(i2), interfaceC1944a}) == null) {
            d.a.v0.s.a aVar = (d.a.v0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (aVar == null) {
                if (interfaceC1944a != null) {
                    interfaceC1944a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            aVar.setListener(new b(interfaceC1944a, aVar, str, str2, str3));
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("-i");
            arrayList.add(str);
            arrayList.add("-i");
            arrayList.add(str2);
            arrayList.add("-filter_complex");
            arrayList.add("[0:a] [1:a]amerge=inputs=2[aout]");
            arrayList.add("-map");
            arrayList.add("[aout]");
            if (i2 > 0) {
                arrayList.add("-ac");
                arrayList.add(String.valueOf(i2));
            }
            arrayList.add(str3);
            aVar.setSource(arrayList);
            aVar.start();
        }
    }

    public static void k(List<String> list, String str, int i2, a.InterfaceC1944a interfaceC1944a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65547, null, list, str, i2, interfaceC1944a) == null) {
            if (d.a.v0.t.h.b(list) == 2) {
                j(list.get(0), list.get(1), str, i2, interfaceC1944a);
                return;
            }
            d.a.v0.s.a aVar = (d.a.v0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (aVar == null) {
                if (interfaceC1944a != null) {
                    interfaceC1944a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            aVar.setListener(new c(interfaceC1944a, aVar));
            ArrayList<String> arrayList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int i3 = 0;
            for (String str2 : list) {
                arrayList.add("-i");
                arrayList.add(str2);
                sb.append(PreferencesUtil.LEFT_MOUNT);
                sb.append(i3);
                if (i3 == 0) {
                    sb.append(":a]volume=10");
                } else {
                    sb.append(":a]volume=1");
                }
                sb.append(PreferencesUtil.LEFT_MOUNT);
                sb.append("a");
                i3++;
                sb.append(i3);
                sb.append("];");
                sb2.append(PreferencesUtil.LEFT_MOUNT);
                sb2.append("a");
                sb2.append(i3);
                sb2.append(PreferencesUtil.RIGHT_MOUNT);
            }
            arrayList.add("-filter_complex");
            arrayList.add(String.format("%s%samix=inputs=%s[aout]", sb.toString(), sb2.toString(), Integer.valueOf(list.size())));
            arrayList.add("-map");
            arrayList.add("[aout]");
            if (i2 > 0) {
                arrayList.add("-ac");
                arrayList.add(String.valueOf(i2));
            }
            arrayList.add(str);
            aVar.setSource(arrayList);
            aVar.start();
        }
    }

    public static void l(String str, String str2, int i2, int i3, float f2, int i4, float f3, float f4, boolean z, a.InterfaceC1944a interfaceC1944a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z), interfaceC1944a}) == null) {
            float f5 = f3 * 1000.0f;
            if (r9 < (f4 * 1000.0f) + f5 || f4 <= 0.0f) {
                f4 = (r9 - f5) / 1000.0f;
            }
            d.a.v0.t.c.c(VLogMultiAudioMixer.TAG, "modifyAudioProperty - duration" + f4);
            d.a.v0.s.a aVar = (d.a.v0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (aVar == null) {
                if (interfaceC1944a != null) {
                    interfaceC1944a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            aVar.setListener(new a(interfaceC1944a, aVar, str, str2));
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("-i");
            arrayList.add(str);
            if (f4 > 0.0f) {
                arrayList.add("-ss");
                arrayList.add(String.valueOf(f3));
                arrayList.add("-t");
                arrayList.add(String.valueOf(f4));
            }
            if (i2 > 0) {
                arrayList.add("-ar");
                arrayList.add(String.valueOf(i2));
            }
            if (i3 > 0) {
                arrayList.add("-ac");
                arrayList.add(String.valueOf(i3));
            }
            if (f2 >= 0.0f) {
                arrayList.add("-af");
                arrayList.add("volume=" + f2);
            }
            arrayList.add("-acodec");
            arrayList.add("aac");
            arrayList.add(str2);
            aVar.setSource(arrayList);
            aVar.start();
        }
    }

    public static void m(String str, String str2, String str3, a.InterfaceC1944a interfaceC1944a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, str, str2, str3, interfaceC1944a) == null) {
            d.a.v0.s.a aVar = (d.a.v0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (aVar == null) {
                if (interfaceC1944a != null) {
                    interfaceC1944a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            aVar.setListener(new e(interfaceC1944a, aVar, str, str2, str3));
            long b2 = x.b(str2);
            long f2 = x.f(str);
            d.a.v0.t.c.j("VideoMuxer", "muxAudioVideo,audioduration:" + b2 + ",videoDuration:" + f2);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("-i");
            arrayList.add(str);
            arrayList.add("-i");
            arrayList.add(str2);
            if (Math.abs(f2 - b2) >= 100 && b2 <= f2) {
                arrayList.add("-filter_complex");
                arrayList.add("[1:a]aloop=loop=-1:size=2e+09[aout]");
                arrayList.add("-map");
                arrayList.add("0:v");
                arrayList.add("-map");
                arrayList.add("[aout]");
                arrayList.add("-c:v");
                arrayList.add("copy");
            } else {
                arrayList.add("-c");
                arrayList.add("copy");
                arrayList.add("-map");
                arrayList.add("0:v");
                arrayList.add("-map");
                arrayList.add("1:a");
            }
            arrayList.add("-shortest");
            arrayList.add(str3);
            aVar.setSource(arrayList);
            aVar.start();
        }
    }

    public static boolean n(String str, String str2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65550, null, str, str2, i2, i3)) == null) {
            if (i3 == i2) {
                return false;
            }
            File file = new File(str);
            File file2 = new File(str2);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                new h(fileInputStream, fileOutputStream, i2, i3, 2, 2, 1, Integer.MAX_VALUE, 0.0d, 0, true);
                fileInputStream.close();
                fileOutputStream.close();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.v0.t.c.e("MediaUtils", "resamplefail:" + e2.getMessage());
                return false;
            }
        }
        return invokeLLII.booleanValue;
    }
}
