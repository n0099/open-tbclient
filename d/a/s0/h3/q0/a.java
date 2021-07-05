package d.a.s0.h3.q0;

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
import d.a.r0.r.q.j1;
import d.a.r0.s.c.i0;
import d.a.s0.h3.y;
import java.io.File;
/* loaded from: classes9.dex */
public class a implements NewWriteModel.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NewWriteModel f61423a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61424b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f61425c;

    /* renamed from: d  reason: collision with root package name */
    public String f61426d;

    /* renamed from: e  reason: collision with root package name */
    public String f61427e;

    /* renamed from: f  reason: collision with root package name */
    public String f61428f;

    /* renamed from: d.a.s0.h3.q0.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1497a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f61429a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1066380213, "Ld/a/s0/h3/q0/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1066380213, "Ld/a/s0/h3/q0/a$b;");
                    return;
                }
            }
            f61429a = new a(null);
        }
    }

    public /* synthetic */ a(C1497a c1497a) {
        this();
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            d.a.s0.h3.q0.b.a("AsyncWriteHelper.getInstance()");
            return b.f61429a;
        }
        return (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.s0.h3.q0.b.a("AsyncWriteHelper.cancelLoadData()");
            this.f61423a.cancelLoadData();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.s0.h3.q0.b.a("AsyncWriteHelper.checkImageNum = " + this.f61423a.U());
            return this.f61423a.U();
        }
        return invokeV.booleanValue;
    }

    public final void c() {
        WriteData j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (j = j()) == null) {
            return;
        }
        if (j.getType() != 0 && j.getType() != 9 && j.getType() != 11) {
            if (j.getType() == 1) {
                y.p(j.getThreadId(), null);
            }
        } else if (j.isEvaluate()) {
            y.m(j.getItem_id(), null);
        } else if (TextUtils.isEmpty(j.getTopicId())) {
            y.o(j.getForumId(), j, true);
        } else {
            y.r(j.getTopicId(), null);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) || writeData == null) {
            return;
        }
        if (z) {
            j1.g(writeData, 100).e(true);
            if ((!k.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) || (writeData.getVideoInfo() != null && writeData.getVideoInfo().hasUpload())) {
                c.n(postWriteCallBackData);
            } else {
                c.m(postWriteCallBackData);
            }
            c();
            d();
            n(postWriteCallBackData);
            if (!k.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                if (!k.isEmpty(writeData.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
            }
            j1.g(writeData, 100).e(false);
        } else {
            j1.g(writeData, 100).e(false);
            c.l(postWriteCallBackData, i0Var, writeData, antiData);
        }
        NewWriteModel newWriteModel = this.f61423a;
        if (newWriteModel != null) {
            newWriteModel.j0(null);
        }
        this.f61424b = false;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FileHelper.deleteFileOrDir(new File(d.a.s0.v3.c.f68591d));
        }
    }

    public BdUniqueId e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f61425c : (BdUniqueId) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f61426d : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f61427e : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f61428f : (String) invokeV.objValue;
    }

    public WriteData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.getWriteData = ");
            sb.append(this.f61423a.X() == null ? StringUtil.NULL_STRING : this.f61423a.X().toDraftString());
            d.a.s0.h3.q0.b.a(sb.toString());
            return this.f61423a.X();
        }
        return (WriteData) invokeV.objValue;
    }

    public void k(@NonNull TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContextSupport) == null) {
            d.a.s0.h3.q0.b.a("AsyncWriteHelper.initWriteStatus()");
            this.f61423a.i0(tbPageContextSupport.getPageContext());
            this.f61423a.j0(null);
            this.f61423a.d0(false);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f61424b : invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.a.s0.h3.q0.b.a("AsyncWriteHelper.onWriteActClose()");
            this.f61423a.i0(null);
            this.f61423a.setSpanGroupManager(null);
        }
    }

    public final void n(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
            this.f61425c = bdUniqueId;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            d.a.s0.h3.q0.b.a("AsyncWriteHelper.setHasImage = " + z);
            this.f61423a.d0(z);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f61426d = str;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f61427e = str;
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f61428f = str;
        }
    }

    public void t(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, spanGroupManager) == null) {
            d.a.s0.h3.q0.b.a("AsyncWriteHelper.setSpanGroupManager()");
            this.f61423a.Y();
            this.f61423a.setSpanGroupManager(spanGroupManager);
        }
    }

    public void u(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, writeData) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.setWriteData = ");
            sb.append(writeData == null ? StringUtil.NULL_STRING : writeData.toDraftString());
            d.a.s0.h3.q0.b.a(sb.toString());
            this.f61423a.j0(writeData);
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            d.a.s0.h3.q0.b.a("AsyncWriteHelper.startPostWrite()");
            this.f61423a.Y();
            boolean k0 = this.f61423a.k0();
            this.f61424b = k0;
            return k0;
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
        this.f61424b = false;
        this.f61425c = null;
        NewWriteModel newWriteModel = new NewWriteModel();
        this.f61423a = newWriteModel;
        newWriteModel.h0(this);
    }
}
