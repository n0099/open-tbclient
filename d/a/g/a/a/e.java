package d.a.g.a.a;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.q.g;
import d.a.c.e.q.h;
/* loaded from: classes8.dex */
public class e implements d.a.s0.h3.p0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.q.f f45337a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f45338b;

    /* renamed from: c  reason: collision with root package name */
    public String f45339c;

    /* renamed from: d  reason: collision with root package name */
    public g f45340d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f45341e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f45342f;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45343e;

        public a(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45343e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.r0.r.g0.a.a(d.a.r0.r.g0.a.b(this.f45343e));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45344e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45345f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f45346g;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f45347e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45347e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f45347e.f45346g;
                    eVar.f45337a.onShowErr(4, eVar.f45342f.getString(R.string.voice_error_file_md5));
                    h.f44475a = 1;
                }
            }
        }

        /* renamed from: d.a.g.a.a.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0621b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f45348e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f45349f;

            public RunnableC0621b(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45349f = bVar;
                this.f45348e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    h.f44475a = 1;
                    b bVar = this.f45349f;
                    bVar.f45346g.f45337a.onSendVoice(this.f45348e, bVar.f45345f);
                }
            }
        }

        public b(e eVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45346g = eVar;
            this.f45344e = str;
            this.f45345f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = d.a.r0.r.g0.b.b.c(d.a.r0.r.g0.a.d(this.f45344e)).f55740a;
                if (this.f45346g.f45338b != null) {
                    this.f45346g.f45338b.removeCallbacks(this.f45346g.f45341e);
                    if (StringUtils.isNull(str)) {
                        this.f45346g.f45338b.post(new a(this));
                    } else {
                        this.f45346g.f45338b.post(new RunnableC0621b(this, str));
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f45350e;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45350e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.c.e.q.f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (fVar = this.f45350e.f45337a) != null && h.f44475a == 2) {
                fVar.onStopingRecorder();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f45351a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45351a = eVar;
        }

        @Override // d.a.c.e.q.g
        public void a(int i2) {
            d.a.c.e.q.f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (fVar = this.f45351a.f45337a) == null) {
                return;
            }
            fVar.onShowRecordTime(i2 / 1000);
        }

        @Override // d.a.c.e.q.e
        public void b(int i2) {
            d.a.c.e.q.f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (fVar = this.f45351a.f45337a) == null) {
                return;
            }
            fVar.onShowRecording(i2);
        }

        @Override // d.a.c.e.q.e
        public void c(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
                this.f45351a.o();
                h.f44475a = 1;
                if (this.f45351a.f45339c != null && str != null) {
                    e eVar = this.f45351a;
                    d.a.c.e.q.f fVar = eVar.f45337a;
                    if (fVar == null) {
                        return;
                    }
                    if (i2 > 1000) {
                        if (!str.endsWith(eVar.f45339c)) {
                            FieldBuilder fieldBuilder = new FieldBuilder();
                            fieldBuilder.append("file", str);
                            fieldBuilder.append("dur", Integer.valueOf(i2));
                            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", fieldBuilder.toString());
                            return;
                        }
                        e eVar2 = this.f45351a;
                        eVar2.m(eVar2.f45339c, (int) Math.round((i2 * 1.0d) / 1000.0d));
                        this.f45351a.f45339c = null;
                        return;
                    }
                    fVar.onShowErr(2, h.a(R.string.voice_record_short_tip));
                    FieldBuilder fieldBuilder2 = new FieldBuilder();
                    fieldBuilder2.append("file", str);
                    fieldBuilder2.append("dur", Integer.valueOf(i2));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", fieldBuilder2.toString());
                    return;
                }
                FieldBuilder fieldBuilder3 = new FieldBuilder();
                fieldBuilder3.append("file", str);
                fieldBuilder3.append("dur", Integer.valueOf(i2));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", fieldBuilder3.toString());
            }
        }

        @Override // d.a.c.e.q.g
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                h.f44475a = 1;
            }
        }

        @Override // d.a.c.e.q.e
        public void error(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                this.f45351a.o();
                TiebaStatic.voiceError(i2, "RecoreCallback.error: " + str, "");
                e eVar = this.f45351a;
                if (eVar.f45337a == null) {
                    h.f44475a = 1;
                } else if (i2 == 7) {
                    if (eVar.f45339c == null) {
                        TiebaStatic.voiceError(i2, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                        return;
                    }
                    e eVar2 = this.f45351a;
                    eVar2.m(eVar2.f45339c, d.a.c.e.q.d.f44474a / 1000);
                    this.f45351a.f45339c = null;
                    e eVar3 = this.f45351a;
                    eVar3.f45337a.onShowErr(3, eVar3.f45342f.getString(R.string.voice_record_timeout_tip));
                } else {
                    h.f44475a = 1;
                    if (i2 == 8) {
                        i2 = 2;
                    }
                    this.f45351a.f45337a.onShowErr(i2, str);
                    TiebaStatic.voiceError(i2, "RecoreCallback.err: " + str, "");
                }
            }
        }

        public /* synthetic */ d(e eVar, a aVar) {
            this(eVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(416464703, "Ld/a/g/a/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(416464703, "Ld/a/g/a/a/e;");
                return;
            }
        }
        h.f44475a = 1;
    }

    public e() {
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
        this.f45339c = null;
        this.f45340d = null;
        this.f45341e = new c(this);
        this.f45338b = new Handler();
    }

    public static e n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new e() : (e) invokeV.objValue;
    }

    @Override // d.a.s0.h3.p0.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            stopRecord();
            q(false);
            d.a.c.e.q.f fVar = this.f45337a;
            if (fVar != null) {
                fVar.onDeletedVoice(str);
            }
            Handler handler = this.f45338b;
            if (handler == null) {
                return;
            }
            handler.postDelayed(new a(this, str), 200L);
        }
    }

    @Override // d.a.s0.h3.p0.a
    public boolean b(d.a.c.e.q.f fVar, int i2) {
        InterceptResult invokeLI;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, i2)) == null) {
            if (fVar == null || (tbPageContext = this.f45342f) == null || !PermissionUtil.checkWriteExternalStorage(tbPageContext.getPageActivity())) {
                return false;
            }
            this.f45337a = fVar;
            if (!FileHelper.checkSD()) {
                String sdErrorString = FileHelper.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = h.a(R.string.voice_error_sdcard);
                }
                this.f45337a.onShowErr(0, sdErrorString);
                return false;
            }
            q(true);
            String e2 = d.a.r0.r.g0.a.e();
            this.f45339c = e2;
            String c2 = d.a.r0.r.g0.a.c(e2);
            if (this.f45340d == null) {
                this.f45340d = new d(this, null);
            }
            d.a.g.a.a.a.g();
            o();
            boolean f2 = d.a.g.a.a.a.f(c2, i2, this.f45340d);
            if (f2) {
                this.f45337a.onStartedRecorder(true);
                h.f44475a = 2;
            } else {
                h.f44475a = 1;
                d.a.g.a.a.a.g();
                FieldBuilder fieldBuilder = new FieldBuilder();
                fieldBuilder.append("voiceType", Integer.valueOf(i2));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", fieldBuilder.toString());
                this.f45337a.onStartedRecorder(false);
            }
            return f2;
        }
        return invokeLI.booleanValue;
    }

    @Override // d.a.s0.h3.p0.a
    public void c(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext) == null) {
            this.f45342f = tbPageContext;
        }
    }

    @Override // d.a.s0.h3.p0.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.g.a.a.a.e();
        }
    }

    @Override // d.a.s0.h3.p0.a
    public void e(d.a.c.e.q.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f45337a = fVar;
        }
    }

    @Override // d.a.s0.h3.p0.a
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h.f44475a == 1 : invokeV.booleanValue;
    }

    public final void m(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) || str == null || i2 < 1) {
            return;
        }
        h.f44475a = 3;
        new Thread(new b(this, str, i2)).start();
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            p();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, Boolean.valueOf(z)));
        }
    }

    @Override // d.a.s0.h3.p0.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            stopRecord();
            TbPageContext<?> tbPageContext = this.f45342f;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                MediaService.stopMy(this.f45342f.getPageActivity());
            }
            Handler handler = this.f45338b;
            if (handler != null) {
                handler.removeCallbacks(this.f45341e);
            }
            this.f45342f = null;
            this.f45337a = null;
            this.f45338b = null;
        }
    }

    @Override // d.a.s0.h3.p0.a
    public void stopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.g.a.a.a.g();
            Handler handler = this.f45338b;
            if (handler != null) {
                handler.postDelayed(this.f45341e, 100L);
            }
            o();
        }
    }
}
