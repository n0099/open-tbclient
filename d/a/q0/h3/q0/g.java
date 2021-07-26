package d.a.q0.h3.q0;

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
import d.a.p0.s.q.j1;
import d.a.p0.s.q.l2;
import d.a.p0.t.c.k0;
import d.a.q0.h3.y;
import java.io.File;
/* loaded from: classes8.dex */
public class g implements NewWriteModel.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NewWriteModel f58793a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58794b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f58795c;

    /* renamed from: d  reason: collision with root package name */
    public String f58796d;

    /* renamed from: e  reason: collision with root package name */
    public String f58797e;

    /* renamed from: f  reason: collision with root package name */
    public String f58798f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f58799g;

    /* loaded from: classes8.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58800a;

        /* renamed from: d.a.q0.h3.q0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1459a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f58801e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ WriteData f58802f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f58803g;

            public RunnableC1459a(a aVar, PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, postWriteCallBackData, writeData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58803g = aVar;
                this.f58801e = postWriteCallBackData;
                this.f58802f = writeData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if ((!d.a.d.e.p.k.isEmpty(this.f58801e.getVideoid()) && this.f58802f.getVideoInfo() != null) || (this.f58802f.getVideoInfo() != null && this.f58802f.getVideoInfo().hasUpload())) {
                        i.n(this.f58801e);
                    } else {
                        i.m(this.f58801e);
                    }
                    if (this.f58802f.isWorkDraft()) {
                        y.r("");
                    }
                    if (!d.a.d.e.p.k.isEmpty(this.f58801e.getVideoid()) && this.f58802f.getVideoInfo() != null) {
                        this.f58801e.mVideoMd5 = this.f58802f.getVideoInfo().getVideoMd5();
                        if (!d.a.d.e.p.k.isEmpty(this.f58802f.getForumName())) {
                            this.f58801e.mFrom = 2;
                        }
                    }
                    this.f58803g.f58800a.o();
                }
            }
        }

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58800a = gVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) || writeData == null) {
                return;
            }
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, l2.b(postWriteCallBackData.getVideoid())));
                int k = d.a.p0.s.d0.b.j().k("key_video_works_progress_bar_waiting_time", 3);
                d.a.d.e.m.e.a().postDelayed(new RunnableC1459a(this, postWriteCallBackData, writeData), ((k > 0 ? k : 3) + 1) * 1000);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, l2.a(postWriteCallBackData.getErrorString())));
            i.l(postWriteCallBackData, k0Var, writeData, antiData);
            this.f58800a.o();
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final g f58804a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1653364973, "Ld/a/q0/h3/q0/g$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1653364973, "Ld/a/q0/h3/q0/g$b;");
                    return;
                }
            }
            f58804a = new g(null);
        }
    }

    public /* synthetic */ g(a aVar) {
        this();
    }

    public static g g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            h.a("AsyncWriteHelper.getInstance()");
            return b.f58804a;
        }
        return (g) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h.a("AsyncWriteHelper.cancelLoadData()");
            this.f58793a.cancelLoadData();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h.a("AsyncWriteHelper.checkImageNum = " + this.f58793a.U());
            return this.f58793a.U();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) || writeData == null) {
            return;
        }
        if (z) {
            j1.h(writeData, 100).f(true);
            if ((!d.a.d.e.p.k.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) || (writeData.getVideoInfo() != null && writeData.getVideoInfo().hasUpload())) {
                i.n(postWriteCallBackData);
            } else {
                i.m(postWriteCallBackData);
            }
            d();
            e();
            p(postWriteCallBackData);
            if (!d.a.d.e.p.k.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                if (!d.a.d.e.p.k.isEmpty(writeData.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
            }
            j1.h(writeData, 100).f(false);
        } else {
            j1.h(writeData, 100).f(false);
            i.l(postWriteCallBackData, k0Var, writeData, antiData);
        }
        NewWriteModel newWriteModel = this.f58793a;
        if (newWriteModel != null) {
            newWriteModel.setWriteData(null);
        }
        this.f58794b = false;
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
            FileHelper.deleteFileOrDir(new File(d.a.q0.v3.c.f66023f));
        }
    }

    public BdUniqueId f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58795c : (BdUniqueId) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f58796d : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58797e : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f58798f : (String) invokeV.objValue;
    }

    public WriteData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.getWriteData = ");
            sb.append(this.f58793a.X() == null ? StringUtil.NULL_STRING : this.f58793a.X().toDraftString());
            h.a(sb.toString());
            return this.f58793a.X();
        }
        return (WriteData) invokeV.objValue;
    }

    public void l(@NonNull TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContextSupport) == null) {
            h.a("AsyncWriteHelper.initWriteStatus()");
            this.f58793a.i0(tbPageContextSupport.getPageContext());
            this.f58793a.setWriteData(null);
            this.f58793a.d0(false);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f58794b : invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            h.a("AsyncWriteHelper.onWriteActClose()");
            this.f58793a.i0(null);
            this.f58793a.setSpanGroupManager(null);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            NewWriteModel newWriteModel = this.f58793a;
            if (newWriteModel != null) {
                newWriteModel.setWriteData(null);
            }
            this.f58794b = false;
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
            this.f58795c = bdUniqueId;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            h.a("AsyncWriteHelper.setHasImage = " + z);
            this.f58793a.d0(z);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f58796d = str;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f58797e = str;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f58798f = str;
        }
    }

    public void v(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, spanGroupManager) == null) {
            h.a("AsyncWriteHelper.setSpanGroupManager()");
            this.f58793a.Y();
            this.f58793a.setSpanGroupManager(spanGroupManager);
        }
    }

    public void w(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, writeData) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.setWriteData = ");
            sb.append(writeData == null ? StringUtil.NULL_STRING : writeData.toDraftString());
            h.a(sb.toString());
            this.f58793a.setWriteData(writeData);
            if (writeData != null && writeData.isWork()) {
                this.f58793a.h0(this.f58799g);
            } else {
                this.f58793a.h0(this);
            }
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            h.a("AsyncWriteHelper.startPostWrite()");
            this.f58793a.Y();
            boolean j0 = this.f58793a.j0();
            this.f58794b = j0;
            return j0;
        }
        return invokeV.booleanValue;
    }

    public g() {
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
        this.f58794b = false;
        this.f58795c = null;
        this.f58799g = new a(this);
        NewWriteModel newWriteModel = new NewWriteModel();
        this.f58793a = newWriteModel;
        newWriteModel.h0(this);
    }
}
