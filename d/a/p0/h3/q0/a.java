package d.a.p0.h3.q0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.o0.r.q.j1;
import d.a.o0.r.q.l2;
import d.a.o0.s.c.i0;
import d.a.p0.h3.y;
import java.io.File;
/* loaded from: classes8.dex */
public class a implements NewWriteModel.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NewWriteModel f58179a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58180b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f58181c;

    /* renamed from: d  reason: collision with root package name */
    public String f58182d;

    /* renamed from: e  reason: collision with root package name */
    public String f58183e;

    /* renamed from: f  reason: collision with root package name */
    public String f58184f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f58185g;

    /* renamed from: d.a.p0.h3.q0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1452a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f58186a;

        /* renamed from: d.a.p0.h3.q0.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1453a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f58187e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ WriteData f58188f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C1452a f58189g;

            public RunnableC1453a(C1452a c1452a, PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1452a, postWriteCallBackData, writeData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58189g = c1452a;
                this.f58187e = postWriteCallBackData;
                this.f58188f = writeData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if ((!k.isEmpty(this.f58187e.getVideoid()) && this.f58188f.getVideoInfo() != null) || (this.f58188f.getVideoInfo() != null && this.f58188f.getVideoInfo().hasUpload())) {
                        c.n(this.f58187e);
                    } else {
                        c.m(this.f58187e);
                    }
                    if (this.f58188f.isWorkDraft()) {
                        y.r("");
                    }
                    if (!k.isEmpty(this.f58187e.getVideoid()) && this.f58188f.getVideoInfo() != null) {
                        this.f58187e.mVideoMd5 = this.f58188f.getVideoInfo().getVideoMd5();
                        if (!k.isEmpty(this.f58188f.getForumName())) {
                            this.f58187e.mFrom = 2;
                        }
                    }
                    this.f58189g.f58186a.o();
                }
            }
        }

        public C1452a(a aVar) {
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
            this.f58186a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) || writeData == null) {
                return;
            }
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, l2.b(postWriteCallBackData.getVideoid())));
                int k = d.a.o0.r.d0.b.j().k("key_video_works_progress_bar_waiting_time", 3);
                d.a.c.e.m.e.a().postDelayed(new RunnableC1453a(this, postWriteCallBackData, writeData), ((k > 0 ? k : 3) + 1) * 1000);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, l2.a(postWriteCallBackData.getErrorString())));
            c.l(postWriteCallBackData, i0Var, writeData, antiData);
            this.f58186a.o();
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f58190a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1946589234, "Ld/a/p0/h3/q0/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1946589234, "Ld/a/p0/h3/q0/a$b;");
                    return;
                }
            }
            f58190a = new a(null);
        }
    }

    public /* synthetic */ a(C1452a c1452a) {
        this();
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            d.a.p0.h3.q0.b.a("AsyncWriteHelper.getInstance()");
            return b.f58190a;
        }
        return (a) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.p0.h3.q0.b.a("AsyncWriteHelper.cancelLoadData()");
            this.f58179a.cancelLoadData();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.p0.h3.q0.b.a("AsyncWriteHelper.checkImageNum = " + this.f58179a.U());
            return this.f58179a.U();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) || writeData == null) {
            return;
        }
        if (z) {
            j1.h(writeData, 100).f(true);
            if ((!k.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) || (writeData.getVideoInfo() != null && writeData.getVideoInfo().hasUpload())) {
                c.n(postWriteCallBackData);
            } else {
                c.m(postWriteCallBackData);
            }
            d();
            e();
            p(postWriteCallBackData);
            if (!k.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                if (!k.isEmpty(writeData.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
            }
            j1.h(writeData, 100).f(false);
        } else {
            j1.h(writeData, 100).f(false);
            c.l(postWriteCallBackData, i0Var, writeData, antiData);
        }
        NewWriteModel newWriteModel = this.f58179a;
        if (newWriteModel != null) {
            newWriteModel.setWriteData(null);
        }
        this.f58180b = false;
    }

    public final void d() {
        WriteData k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (k = k()) == null) {
            return;
        }
        if (k.getType() != 0 && k.getType() != 9 && k.getType() != 11) {
            if (k.getType() == 1) {
                y.s(k.getThreadId(), null);
            }
        } else if (k.isEvaluate()) {
            y.o(k.getItem_id(), null);
        } else if (TextUtils.isEmpty(k.getTopicId())) {
            y.q(k.getForumId(), k, true);
        } else {
            y.u(k.getTopicId(), null);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FileHelper.deleteFileOrDir(new File(d.a.p0.v3.c.f65375f));
        }
    }

    public BdUniqueId f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58181c : (BdUniqueId) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f58182d : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58183e : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f58184f : (String) invokeV.objValue;
    }

    public WriteData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.getWriteData = ");
            sb.append(this.f58179a.X() == null ? StringUtil.NULL_STRING : this.f58179a.X().toDraftString());
            d.a.p0.h3.q0.b.a(sb.toString());
            return this.f58179a.X();
        }
        return (WriteData) invokeV.objValue;
    }

    public void l(@NonNull TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContextSupport) == null) {
            d.a.p0.h3.q0.b.a("AsyncWriteHelper.initWriteStatus()");
            this.f58179a.i0(tbPageContextSupport.getPageContext());
            this.f58179a.setWriteData(null);
            this.f58179a.d0(false);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f58180b : invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.a.p0.h3.q0.b.a("AsyncWriteHelper.onWriteActClose()");
            this.f58179a.i0(null);
            this.f58179a.setSpanGroupManager(null);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            NewWriteModel newWriteModel = this.f58179a;
            if (newWriteModel != null) {
                newWriteModel.setWriteData(null);
            }
            this.f58180b = false;
        }
    }

    public final void p(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) {
            this.f58181c = bdUniqueId;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            d.a.p0.h3.q0.b.a("AsyncWriteHelper.setHasImage = " + z);
            this.f58179a.d0(z);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f58182d = str;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f58183e = str;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f58184f = str;
        }
    }

    public void v(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, spanGroupManager) == null) {
            d.a.p0.h3.q0.b.a("AsyncWriteHelper.setSpanGroupManager()");
            this.f58179a.Y();
            this.f58179a.setSpanGroupManager(spanGroupManager);
        }
    }

    public void w(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, writeData) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.setWriteData = ");
            sb.append(writeData == null ? StringUtil.NULL_STRING : writeData.toDraftString());
            d.a.p0.h3.q0.b.a(sb.toString());
            this.f58179a.setWriteData(writeData);
            if (writeData != null && writeData.isWork()) {
                this.f58179a.h0(this.f58185g);
            } else {
                this.f58179a.h0(this);
            }
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            d.a.p0.h3.q0.b.a("AsyncWriteHelper.startPostWrite()");
            this.f58179a.Y();
            boolean j0 = this.f58179a.j0();
            this.f58180b = j0;
            return j0;
        }
        return invokeV.booleanValue;
    }

    public a() {
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
        this.f58180b = false;
        this.f58181c = null;
        this.f58185g = new C1452a(this);
        NewWriteModel newWriteModel = new NewWriteModel();
        this.f58179a = newWriteModel;
        newWriteModel.h0(this);
    }
}
