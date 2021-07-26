package d.a.p0.x.w;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.x.m;
import d.a.q0.h3.u;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class g extends d.a.p0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ForumData f54224a;

    /* renamed from: b  reason: collision with root package name */
    public String f54225b;

    /* renamed from: c  reason: collision with root package name */
    public String f54226c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54227d;

    /* renamed from: e  reason: collision with root package name */
    public DataModel<?> f54228e;

    /* loaded from: classes7.dex */
    public class a implements d.a.p0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f54229e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f54230f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f54231g;

        public a(g gVar, e eVar, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, eVar, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54231g = gVar;
            this.f54229e = eVar;
            this.f54230f = editorTools;
        }

        @Override // d.a.p0.x.b
        public void onAction(d.a.p0.x.a aVar) {
            e eVar;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (eVar = this.f54229e) == null || eVar.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.f54158a;
            if (i2 == 4) {
                this.f54229e.n0(aVar.f54160c.toString());
                Object obj = aVar.f54160c;
                if (obj instanceof SpanGroupManager) {
                    this.f54229e.r0((SpanGroupManager) obj);
                }
                this.f54231g.f54227d = false;
            } else if (i2 == 5) {
                if (this.f54230f.u()) {
                    return;
                }
                TiebaStatic.eventStat(this.f54230f.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i2 == 7) {
                this.f54229e.s().showToast(R.string.over_limit_tip);
                this.f54231g.f54227d = true;
            } else if (i2 == 8) {
                if (this.f54231g.j(this.f54229e.s(), 11001)) {
                    this.f54229e.M(null, null);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f54160c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f54229e.u0((VoiceData$VoiceModel) obj2);
                    this.f54229e.A(true, null);
                }
            } else if (i2 == 11) {
                this.f54229e.u0(null);
            } else if (i2 == 18) {
                if (aVar.f54160c != null) {
                    this.f54229e.R();
                    return;
                }
                int u = this.f54229e.u();
                if (u == 0) {
                    this.f54229e.K();
                } else if (u != 2) {
                } else {
                    this.f54229e.B();
                }
            } else if (i2 == 20) {
                this.f54229e.a().A(new d.a.p0.x.a(2, 7, null));
                d.a.q0.h3.m0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 27) {
                VideoInfo y = this.f54229e.y();
                if (y != null && y.isAvaliable()) {
                    this.f54229e.a().A(new d.a.p0.x.a(28, 20, y));
                } else if (this.f54229e.s() == null || this.f54229e.s().getResources() == null) {
                } else {
                    Resources resources = this.f54229e.s().getResources();
                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                        if (XiaoyingUtil.isXiaoyingForbidden()) {
                            XiaoyingUtil.showGoPluginDetailDialog(this.f54229e.s(), resources.getString(R.string.plugin_video_not_active), resources.getString(R.string.setup));
                            return;
                        } else {
                            XiaoyingUtil.startXiaoying(this.f54229e.s().getPageActivity());
                            return;
                        }
                    }
                    XiaoyingUtil.showGoPluginDetailDialog(this.f54229e.s(), resources.getString(R.string.plugin_video_install_tips), resources.getString(R.string.plugin_go_install));
                }
            } else if (i2 == 29) {
                this.f54229e.a().A(new d.a.p0.x.a(2, 19, null));
                this.f54229e.a().A(new d.a.p0.x.a(1, 2, null));
                this.f54229e.m();
            } else if (i2 == 32) {
                this.f54229e.a().A(new d.a.p0.x.a(1, 11, null));
            } else if (i2 == 36) {
                if (this.f54231g.j(this.f54229e.s(), 11040)) {
                    this.f54229e.a0();
                }
            } else if (i2 != 43) {
                switch (i2) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f54229e.s().getPageActivity(), this.f54229e.z().toJsonString(), true, true);
                        if (!StringUtils.isNull(this.f54231g.f54226c, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("from", this.f54231g.f54226c);
                        }
                        if (this.f54231g.f54224a != null && !StringUtils.isNull(this.f54231g.f54224a.getId(), true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f54231g.f54224a.getId());
                        }
                        albumFloatActivityConfig.setRequestCode(12002);
                        if (d.a.p0.x.w.a.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.f54229e.z() != null) {
                                this.f54229e.z().setMaxImagesAllowed(1);
                            }
                        } else if (this.f54229e.z() != null) {
                            this.f54229e.z().setMaxImagesAllowed(9);
                        }
                        l.x(this.f54229e.s().getPageActivity(), this.f54229e.s().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) aVar.f54160c).intValue();
                        if (this.f54229e.z() != null && this.f54229e.z().getChosedFiles() != null && (size = this.f54229e.z().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f54229e.s().getPageActivity(), 12012, this.f54229e.z(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (this.f54231g.f54227d) {
                            this.f54229e.s().showToast(R.string.over_limit_tip);
                        }
                        if (this.f54231g.j(this.f54229e.s(), 11025)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f54229e.s().getPageActivity(), 12004, true)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else if (d.a.p0.r0.b.c(this.f54229e.s(), true, false)) {
            } else {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.f54229e.s().getPageActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.f54231g.f54224a != null) {
                    hotSelectActivityConfig.setForumExtra(d.a.d.e.m.b.f(this.f54231g.f54224a.getId(), 0L), this.f54231g.f54224a.getFirst_class(), this.f54231g.f54224a.getSecond_class());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
            }
        }
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
        this.f54225b = null;
        this.f54226c = null;
        this.f54227d = false;
    }

    @Override // d.a.p0.x.c
    public d.a.p0.x.e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(3);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(false);
            editorTools.setMoreButtonAtEnd(true);
            e eVar = new e(editorTools);
            eVar.k0(this.f54228e);
            return eVar;
        }
        return (d.a.p0.x.e) invokeL.objValue;
    }

    @Override // d.a.p0.x.c
    public void c(d.a.p0.x.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && (eVar instanceof e)) {
            EditorTools a2 = eVar.a();
            a aVar = new a(this, (e) eVar, a2);
            a2.setActionListener(5, aVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(16, aVar);
            a2.setActionListener(14, aVar);
            a2.setActionListener(15, aVar);
            a2.setActionListener(8, aVar);
            a2.setActionListener(18, aVar);
            a2.setActionListener(20, aVar);
            a2.setActionListener(10, aVar);
            a2.setActionListener(11, aVar);
            a2.setActionListener(27, aVar);
            a2.setActionListener(29, aVar);
            a2.setActionListener(36, aVar);
            a2.setActionListener(32, aVar);
            a2.setActionListener(43, aVar);
            a2.setActionListener(45, aVar);
        }
    }

    @Override // d.a.p0.x.c
    public void d(d.a.p0.x.e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            arrayList.add(6);
            arrayList.add(9);
            a2.d(new d.a.p0.x.r.d(a2.getContext(), 1));
            if (d.a.q0.h3.p0.c.a() && u.a(this.f54225b, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                mVar.j = 2;
                a2.d(mVar);
            }
            d.a.p0.x.o.a aVar = new d.a.p0.x.o.a(a2.getContext(), 4);
            aVar.f54170g = false;
            a2.d(aVar);
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), m.class);
            if (runTask2 != null && runTask2.getData() != null) {
                m mVar2 = (m) runTask2.getData();
                mVar2.j = 6;
                a2.d(mVar2);
            }
            a2.d(new f(a2.getContext(), false, true));
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), m.class);
            if (runTask3 != null && runTask3.getData() != null) {
                m mVar3 = (m) runTask3.getData();
                mVar3.j = 7;
                a2.d(mVar3);
            }
            if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName())) {
                a2.d(new d.a.p0.x.q.a(a2.getContext(), 5));
            }
            a2.h(arrayList);
            m n = a2.n(5);
            if (n != null) {
                n.j = 3;
            }
            a2.f();
        }
    }

    public final boolean j(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public ForumData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f54224a : (ForumData) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f54226c : (String) invokeV.objValue;
    }

    public DataModel<?> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f54228e : (DataModel) invokeV.objValue;
    }

    public void n(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, forumData) == null) {
            this.f54224a = forumData;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f54225b = str;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f54226c = str;
        }
    }

    public void q(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dataModel) == null) {
            this.f54228e = dataModel;
        }
    }
}
