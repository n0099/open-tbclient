package d.a.h.a.a;

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
import d.a.d.e.q.g;
import d.a.d.e.q.h;
/* loaded from: classes7.dex */
public class e implements d.a.q0.h3.p0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.d.e.q.f f42847a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f42848b;

    /* renamed from: c  reason: collision with root package name */
    public String f42849c;

    /* renamed from: d  reason: collision with root package name */
    public g f42850d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f42851e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f42852f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42853e;

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
            this.f42853e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.p0.s.g0.a.a(d.a.p0.s.g0.a.b(this.f42853e));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42854e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42855f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f42856g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f42857e;

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
                this.f42857e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f42857e.f42856g;
                    eVar.f42847a.onShowErr(4, eVar.f42852f.getString(R.string.voice_error_file_md5));
                    h.f41995a = 1;
                }
            }
        }

        /* renamed from: d.a.h.a.a.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0601b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f42858e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f42859f;

            public RunnableC0601b(b bVar, String str) {
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
                this.f42859f = bVar;
                this.f42858e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    h.f41995a = 1;
                    b bVar = this.f42859f;
                    bVar.f42856g.f42847a.onSendVoice(this.f42858e, bVar.f42855f);
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
            this.f42856g = eVar;
            this.f42854e = str;
            this.f42855f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = d.a.p0.s.g0.b.b.c(d.a.p0.s.g0.a.d(this.f42854e)).f53110a;
                if (this.f42856g.f42848b != null) {
                    this.f42856g.f42848b.removeCallbacks(this.f42856g.f42851e);
                    if (StringUtils.isNull(str)) {
                        this.f42856g.f42848b.post(new a(this));
                    } else {
                        this.f42856g.f42848b.post(new RunnableC0601b(this, str));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f42860e;

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
            this.f42860e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.d.e.q.f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (fVar = this.f42860e.f42847a) != null && h.f41995a == 2) {
                fVar.onStopingRecorder();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f42861a;

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
            this.f42861a = eVar;
        }

        @Override // d.a.d.e.q.g
        public void a(int i2) {
            d.a.d.e.q.f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (fVar = this.f42861a.f42847a) == null) {
                return;
            }
            fVar.onShowRecordTime(i2 / 1000);
        }

        @Override // d.a.d.e.q.e
        public void b(int i2) {
            d.a.d.e.q.f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (fVar = this.f42861a.f42847a) == null) {
                return;
            }
            fVar.onShowRecording(i2);
        }

        @Override // d.a.d.e.q.e
        public void c(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
                this.f42861a.o();
                h.f41995a = 1;
                if (this.f42861a.f42849c != null && str != null) {
                    e eVar = this.f42861a;
                    d.a.d.e.q.f fVar = eVar.f42847a;
                    if (fVar == null) {
                        return;
                    }
                    if (i2 > 1000) {
                        if (!str.endsWith(eVar.f42849c)) {
                            FieldBuilder fieldBuilder = new FieldBuilder();
                            fieldBuilder.append("file", str);
                            fieldBuilder.append("dur", Integer.valueOf(i2));
                            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", fieldBuilder.toString());
                            return;
                        }
                        e eVar2 = this.f42861a;
                        eVar2.m(eVar2.f42849c, (int) Math.round((i2 * 1.0d) / 1000.0d));
                        this.f42861a.f42849c = null;
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

        @Override // d.a.d.e.q.g
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                h.f41995a = 1;
            }
        }

        @Override // d.a.d.e.q.e
        public void error(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                this.f42861a.o();
                TiebaStatic.voiceError(i2, "RecoreCallback.error: " + str, "");
                e eVar = this.f42861a;
                if (eVar.f42847a == null) {
                    h.f41995a = 1;
                } else if (i2 == 7) {
                    if (eVar.f42849c == null) {
                        TiebaStatic.voiceError(i2, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                        return;
                    }
                    e eVar2 = this.f42861a;
                    eVar2.m(eVar2.f42849c, d.a.d.e.q.d.f41994a / 1000);
                    this.f42861a.f42849c = null;
                    e eVar3 = this.f42861a;
                    eVar3.f42847a.onShowErr(3, eVar3.f42852f.getString(R.string.voice_record_timeout_tip));
                } else {
                    h.f41995a = 1;
                    if (i2 == 8) {
                        i2 = 2;
                    }
                    this.f42861a.f42847a.onShowErr(i2, str);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2135692258, "Ld/a/h/a/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2135692258, "Ld/a/h/a/a/e;");
                return;
            }
        }
        h.f41995a = 1;
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
        this.f42849c = null;
        this.f42850d = null;
        this.f42851e = new c(this);
        this.f42848b = new Handler();
    }

    public static e n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new e() : (e) invokeV.objValue;
    }

    @Override // d.a.q0.h3.p0.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            stopRecord();
            q(false);
            d.a.d.e.q.f fVar = this.f42847a;
            if (fVar != null) {
                fVar.onDeletedVoice(str);
            }
            Handler handler = this.f42848b;
            if (handler == null) {
                return;
            }
            handler.postDelayed(new a(this, str), 200L);
        }
    }

    @Override // d.a.q0.h3.p0.a
    public boolean b(d.a.d.e.q.f fVar, int i2) {
        InterceptResult invokeLI;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, i2)) == null) {
            if (fVar == null || (tbPageContext = this.f42852f) == null || !PermissionUtil.checkWriteExternalStorage(tbPageContext.getPageActivity())) {
                return false;
            }
            this.f42847a = fVar;
            if (!FileHelper.checkSD()) {
                String sdErrorString = FileHelper.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = h.a(R.string.voice_error_sdcard);
                }
                this.f42847a.onShowErr(0, sdErrorString);
                return false;
            }
            q(true);
            String e2 = d.a.p0.s.g0.a.e();
            this.f42849c = e2;
            String c2 = d.a.p0.s.g0.a.c(e2);
            if (this.f42850d == null) {
                this.f42850d = new d(this, null);
            }
            d.a.h.a.a.a.g();
            o();
            boolean f2 = d.a.h.a.a.a.f(c2, i2, this.f42850d);
            if (f2) {
                this.f42847a.onStartedRecorder(true);
                h.f41995a = 2;
            } else {
                h.f41995a = 1;
                d.a.h.a.a.a.g();
                FieldBuilder fieldBuilder = new FieldBuilder();
                fieldBuilder.append("voiceType", Integer.valueOf(i2));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", fieldBuilder.toString());
                this.f42847a.onStartedRecorder(false);
            }
            return f2;
        }
        return invokeLI.booleanValue;
    }

    @Override // d.a.q0.h3.p0.a
    public void c(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext) == null) {
            this.f42852f = tbPageContext;
        }
    }

    @Override // d.a.q0.h3.p0.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.h.a.a.a.e();
        }
    }

    @Override // d.a.q0.h3.p0.a
    public void e(d.a.d.e.q.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f42847a = fVar;
        }
    }

    @Override // d.a.q0.h3.p0.a
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h.f41995a == 1 : invokeV.booleanValue;
    }

    public final void m(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) || str == null || i2 < 1) {
            return;
        }
        h.f41995a = 3;
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

    @Override // d.a.q0.h3.p0.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            stopRecord();
            TbPageContext<?> tbPageContext = this.f42852f;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                MediaService.stopMy(this.f42852f.getPageActivity());
            }
            Handler handler = this.f42848b;
            if (handler != null) {
                handler.removeCallbacks(this.f42851e);
            }
            this.f42852f = null;
            this.f42847a = null;
            this.f42848b = null;
        }
    }

    @Override // d.a.q0.h3.p0.a
    public void stopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.h.a.a.a.g();
            Handler handler = this.f42848b;
            if (handler != null) {
                handler.postDelayed(this.f42851e, 100L);
            }
            o();
        }
    }
}
