package com.repackage;

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
/* loaded from: classes7.dex */
public class rp implements rl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cj a;
    public Handler b;
    public String c;
    public int d;
    public dj e;
    public Runnable f;
    public TbPageContext<?> g;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(rp rpVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rpVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ rp c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    rp rpVar = this.a.c;
                    rpVar.a.onShowErr(4, rpVar.g.getString(R.string.obfuscated_res_0x7f0f154f));
                    ej.a = 1;
                }
            }
        }

        /* renamed from: com.repackage.rp$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0503b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ b b;

            public RunnableC0503b(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ej.a = 1;
                    b bVar = this.b;
                    bVar.c.a.onSendVoice(this.a, bVar.b);
                }
            }
        }

        public b(rp rpVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rpVar, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rpVar;
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = iw4.c(gw4.d(this.a)).a;
                if (this.c.b != null) {
                    this.c.b.removeCallbacks(this.c.f);
                    if (StringUtils.isNull(str)) {
                        this.c.b.post(new a(this));
                    } else {
                        this.c.b.post(new RunnableC0503b(this, str));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp a;

        public c(rp rpVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rpVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rpVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            cj cjVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (cjVar = this.a.a) != null && ej.a == 2) {
                cjVar.onStopingRecorder();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements dj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp a;

        public d(rp rpVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rpVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rpVar;
        }

        @Override // com.repackage.dj
        public void a(int i) {
            cj cjVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (cjVar = this.a.a) == null) {
                return;
            }
            cjVar.onShowRecordTime(i);
        }

        @Override // com.repackage.bj
        public void b(int i) {
            cj cjVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (cjVar = this.a.a) == null) {
                return;
            }
            cjVar.onShowRecording(i);
        }

        @Override // com.repackage.bj
        public void c(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                this.a.p();
                ej.a = 1;
                if (this.a.c != null && str != null) {
                    rp rpVar = this.a;
                    cj cjVar = rpVar.a;
                    if (cjVar == null) {
                        return;
                    }
                    if (i > 1000) {
                        if (!str.endsWith(rpVar.c)) {
                            FieldBuilder fieldBuilder = new FieldBuilder();
                            fieldBuilder.append("file", str);
                            fieldBuilder.append("dur", Integer.valueOf(i));
                            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", fieldBuilder.toString());
                            return;
                        }
                        rp rpVar2 = this.a;
                        rpVar2.n(rpVar2.c, (int) Math.round((i * 1.0d) / 1000.0d));
                        this.a.c = null;
                        return;
                    }
                    cjVar.onShowErr(2, ej.a(R.string.obfuscated_res_0x7f0f1554));
                    FieldBuilder fieldBuilder2 = new FieldBuilder();
                    fieldBuilder2.append("file", str);
                    fieldBuilder2.append("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", fieldBuilder2.toString());
                    return;
                }
                FieldBuilder fieldBuilder3 = new FieldBuilder();
                fieldBuilder3.append("file", str);
                fieldBuilder3.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", fieldBuilder3.toString());
            }
        }

        @Override // com.repackage.dj
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ej.a = 1;
            }
        }

        @Override // com.repackage.bj
        public void error(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                this.a.p();
                TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
                rp rpVar = this.a;
                if (rpVar.a == null) {
                    ej.a = 1;
                } else if (i == 7) {
                    if (rpVar.c == null) {
                        TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                    } else if (this.a.a.isOnCancle()) {
                        gi.k(gw4.c(this.a.c));
                        this.a.c = null;
                        this.a.a.onStopingRecorder();
                        ej.a = 1;
                    } else {
                        rp rpVar2 = this.a;
                        rpVar2.n(rpVar2.c, this.a.d / 1000);
                        this.a.c = null;
                        if (this.a.d == aj.b) {
                            rp rpVar3 = this.a;
                            rpVar3.a.onShowErr(3, rpVar3.g.getString(R.string.obfuscated_res_0x7f0f1555));
                            return;
                        }
                        rp rpVar4 = this.a;
                        rpVar4.a.onShowErr(3, rpVar4.g.getString(R.string.obfuscated_res_0x7f0f1556));
                    }
                } else {
                    ej.a = 1;
                    if (i == 8) {
                        i = 2;
                    }
                    this.a.a.onShowErr(i, str);
                    TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
                }
            }
        }

        public /* synthetic */ d(rp rpVar, a aVar) {
            this(rpVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964028537, "Lcom/repackage/rp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964028537, "Lcom/repackage/rp;");
                return;
            }
        }
        ej.a = 1;
    }

    public rp() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = aj.a;
        this.e = null;
        this.f = new c(this);
        this.b = new Handler();
    }

    public static rp o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new rp() : (rp) invokeV.objValue;
    }

    @Override // com.repackage.rl8
    public void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.g = tbPageContext;
        }
    }

    @Override // com.repackage.rl8
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            stopRecord();
            r(false);
            cj cjVar = this.a;
            if (cjVar != null) {
                cjVar.onDeletedVoice(str);
            }
            Handler handler = this.b;
            if (handler == null) {
                return;
            }
            handler.postDelayed(new a(this), 200L);
        }
    }

    @Override // com.repackage.rl8
    public boolean c(cj cjVar, int i) {
        InterceptResult invokeLI;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cjVar, i)) == null) {
            if (cjVar == null || (tbPageContext = this.g) == null || !PermissionUtil.checkWriteExternalStorage(tbPageContext.getPageActivity())) {
                return false;
            }
            this.a = cjVar;
            if (!FileHelper.checkSD()) {
                String sdErrorString = FileHelper.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = ej.a(R.string.obfuscated_res_0x7f0f1550);
                }
                this.a.onShowErr(0, sdErrorString);
                return false;
            }
            r(true);
            String e = gw4.e();
            this.c = e;
            String c2 = gw4.c(e);
            if (this.e == null) {
                this.e = new d(this, null);
            }
            np.h();
            p();
            boolean g = np.g(c2, i, this.e);
            if (g) {
                this.a.onStartedRecorder(true);
                ej.a = 2;
            } else {
                ej.a = 1;
                np.h();
                FieldBuilder fieldBuilder = new FieldBuilder();
                fieldBuilder.append("voiceType", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", fieldBuilder.toString());
                this.a.onStartedRecorder(false);
            }
            return g;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.repackage.rl8
    public void cancelRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            np.e();
        }
    }

    @Override // com.repackage.rl8
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.d = i;
            np.f(i);
        }
    }

    @Override // com.repackage.rl8
    public void e(cj cjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cjVar) == null) {
            this.a = cjVar;
        }
    }

    @Override // com.repackage.rl8
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ej.a == 1 : invokeV.booleanValue;
    }

    public final void n(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) || str == null || i < 1) {
            return;
        }
        ej.a = 3;
        new Thread(new b(this, str, i)).start();
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            q();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, Boolean.valueOf(z)));
        }
    }

    @Override // com.repackage.rl8
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            stopRecord();
            TbPageContext<?> tbPageContext = this.g;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                MediaService.stopMy(this.g.getPageActivity());
            }
            Handler handler = this.b;
            if (handler != null) {
                handler.removeCallbacks(this.f);
            }
            this.g = null;
            this.a = null;
            this.b = null;
        }
    }

    @Override // com.repackage.rl8
    public void stopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            np.h();
            Handler handler = this.b;
            if (handler != null) {
                handler.postDelayed(this.f, 100L);
            }
            p();
        }
    }
}
