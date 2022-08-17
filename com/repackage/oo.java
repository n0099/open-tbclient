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
public class oo implements rm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fj a;
    public Handler b;
    public String c;
    public int d;
    public gj e;
    public Runnable f;
    public TbPageContext<?> g;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(oo ooVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ooVar};
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
        public final /* synthetic */ oo c;

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
                    oo ooVar = this.a.c;
                    ooVar.a.onShowErr(4, ooVar.g.getString(R.string.obfuscated_res_0x7f0f156a));
                    hj.a = 1;
                }
            }
        }

        /* renamed from: com.repackage.oo$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0551b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ b b;

            public RunnableC0551b(b bVar, String str) {
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
                    hj.a = 1;
                    b bVar = this.b;
                    bVar.c.a.onSendVoice(this.a, bVar.b);
                }
            }
        }

        public b(oo ooVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ooVar, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ooVar;
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = bx4.c(zw4.d(this.a)).a;
                if (this.c.b != null) {
                    this.c.b.removeCallbacks(this.c.f);
                    if (StringUtils.isNull(str)) {
                        this.c.b.post(new a(this));
                    } else {
                        this.c.b.post(new RunnableC0551b(this, str));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oo a;

        public c(oo ooVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ooVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ooVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            fj fjVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (fjVar = this.a.a) != null && hj.a == 2) {
                fjVar.onStopingRecorder();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements gj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oo a;

        public d(oo ooVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ooVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ooVar;
        }

        @Override // com.repackage.gj
        public void a(int i) {
            fj fjVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (fjVar = this.a.a) == null) {
                return;
            }
            fjVar.onShowRecordTime(i);
        }

        @Override // com.repackage.ej
        public void b(int i) {
            fj fjVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (fjVar = this.a.a) == null) {
                return;
            }
            fjVar.onShowRecording(i);
        }

        @Override // com.repackage.ej
        public void c(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                this.a.p();
                hj.a = 1;
                if (this.a.c != null && str != null) {
                    oo ooVar = this.a;
                    fj fjVar = ooVar.a;
                    if (fjVar == null) {
                        return;
                    }
                    if (i > 1000) {
                        if (!str.endsWith(ooVar.c)) {
                            FieldBuilder fieldBuilder = new FieldBuilder();
                            fieldBuilder.append("file", str);
                            fieldBuilder.append("dur", Integer.valueOf(i));
                            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", fieldBuilder.toString());
                            return;
                        }
                        oo ooVar2 = this.a;
                        ooVar2.n(ooVar2.c, (int) Math.round((i * 1.0d) / 1000.0d));
                        this.a.c = null;
                        return;
                    }
                    fjVar.onShowErr(2, hj.a(R.string.obfuscated_res_0x7f0f156f));
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

        @Override // com.repackage.gj
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                hj.a = 1;
            }
        }

        @Override // com.repackage.ej
        public void error(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                this.a.p();
                TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
                oo ooVar = this.a;
                if (ooVar.a == null) {
                    hj.a = 1;
                } else if (i == 7) {
                    if (ooVar.c == null) {
                        TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                    } else if (this.a.a.isOnCancle()) {
                        ki.k(zw4.c(this.a.c));
                        this.a.c = null;
                        this.a.a.onStopingRecorder();
                        hj.a = 1;
                    } else {
                        oo ooVar2 = this.a;
                        ooVar2.n(ooVar2.c, this.a.d / 1000);
                        this.a.c = null;
                        if (this.a.d == dj.b) {
                            oo ooVar3 = this.a;
                            ooVar3.a.onShowErr(3, ooVar3.g.getString(R.string.obfuscated_res_0x7f0f1570));
                            return;
                        }
                        oo ooVar4 = this.a;
                        ooVar4.a.onShowErr(3, ooVar4.g.getString(R.string.obfuscated_res_0x7f0f1571));
                    }
                } else {
                    hj.a = 1;
                    if (i == 8) {
                        i = 2;
                    }
                    this.a.a.onShowErr(i, str);
                    TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
                }
            }
        }

        public /* synthetic */ d(oo ooVar, a aVar) {
            this(ooVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964031451, "Lcom/repackage/oo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964031451, "Lcom/repackage/oo;");
                return;
            }
        }
        hj.a = 1;
    }

    public oo() {
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
        this.d = dj.a;
        this.e = null;
        this.f = new c(this);
        this.b = new Handler();
    }

    public static oo o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new oo() : (oo) invokeV.objValue;
    }

    @Override // com.repackage.rm8
    public void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.g = tbPageContext;
        }
    }

    @Override // com.repackage.rm8
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            stopRecord();
            r(false);
            fj fjVar = this.a;
            if (fjVar != null) {
                fjVar.onDeletedVoice(str);
            }
            Handler handler = this.b;
            if (handler == null) {
                return;
            }
            handler.postDelayed(new a(this), 200L);
        }
    }

    @Override // com.repackage.rm8
    public boolean c(fj fjVar, int i) {
        InterceptResult invokeLI;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, fjVar, i)) == null) {
            if (fjVar == null || (tbPageContext = this.g) == null || !PermissionUtil.checkWriteExternalStorage(tbPageContext.getPageActivity())) {
                return false;
            }
            this.a = fjVar;
            if (!FileHelper.checkSD()) {
                String sdErrorString = FileHelper.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = hj.a(R.string.obfuscated_res_0x7f0f156b);
                }
                this.a.onShowErr(0, sdErrorString);
                return false;
            }
            r(true);
            String e = zw4.e();
            this.c = e;
            String c2 = zw4.c(e);
            if (this.e == null) {
                this.e = new d(this, null);
            }
            ko.h();
            p();
            boolean g = ko.g(c2, i, this.e);
            if (g) {
                this.a.onStartedRecorder(true);
                hj.a = 2;
            } else {
                hj.a = 1;
                ko.h();
                FieldBuilder fieldBuilder = new FieldBuilder();
                fieldBuilder.append("voiceType", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", fieldBuilder.toString());
                this.a.onStartedRecorder(false);
            }
            return g;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.repackage.rm8
    public void cancelRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ko.e();
        }
    }

    @Override // com.repackage.rm8
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.d = i;
            ko.f(i);
        }
    }

    @Override // com.repackage.rm8
    public void e(fj fjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fjVar) == null) {
            this.a = fjVar;
        }
    }

    @Override // com.repackage.rm8
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? hj.a == 1 : invokeV.booleanValue;
    }

    public final void n(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) || str == null || i < 1) {
            return;
        }
        hj.a = 3;
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

    @Override // com.repackage.rm8
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

    @Override // com.repackage.rm8
    public void stopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ko.h();
            Handler handler = this.b;
            if (handler != null) {
                handler.postDelayed(this.f, 100L);
            }
            p();
        }
    }
}
