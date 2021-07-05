package d.a.s0.k1.j;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.PlayerPostEvent;
import d.a.c.e.p.l;
import d.a.r0.w.e;
import d.a.r0.w.m;
import d.a.r0.w.r.d;
import d.a.r0.w.w.f;
import d.a.s0.h3.u;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b extends d.a.r0.w.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f62551a;

    /* renamed from: b  reason: collision with root package name */
    public String f62552b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62553c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62554d;

    /* loaded from: classes9.dex */
    public class a implements d.a.r0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.k1.j.a f62555e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f62556f;

        public a(b bVar, d.a.s0.k1.j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62556f = bVar;
            this.f62555e = aVar;
        }

        @Override // d.a.r0.w.b
        public void onAction(d.a.r0.w.a aVar) {
            d.a.s0.k1.j.a aVar2;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (aVar2 = this.f62555e) == null || aVar2.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.f56766a;
            if (i2 == 4) {
                this.f62555e.m0(aVar.f56768c.toString());
                Object obj = aVar.f56768c;
                if (obj instanceof SpanGroupManager) {
                    this.f62555e.q0((SpanGroupManager) obj);
                }
                this.f62556f.f62553c = false;
            } else if (i2 == 18) {
                if (aVar.f56768c != null) {
                    this.f62555e.Q();
                    return;
                }
                int t = this.f62555e.t();
                if (t == 0) {
                    this.f62555e.J();
                } else if (t != 2) {
                } else {
                    this.f62555e.A();
                }
            } else if (i2 == 20) {
                this.f62555e.a().A(new d.a.r0.w.a(2, 7, null));
                d.a.s0.h3.m0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 32) {
                this.f62555e.a().A(new d.a.r0.w.a(1, 11, null));
            } else if (i2 == 36) {
                if (this.f62556f.i(this.f62555e.r(), 11040)) {
                    this.f62555e.Z();
                }
            } else if (i2 == 7) {
                l.L(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                this.f62556f.f62553c = true;
            } else if (i2 == 8) {
                if (this.f62556f.i(this.f62555e.r(), 11001)) {
                    this.f62555e.L(null, null);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f56768c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f62555e.t0((VoiceData$VoiceModel) obj2);
                    this.f62555e.z(true, null);
                }
            } else if (i2 != 11) {
                switch (i2) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f62555e.r().getPageActivity(), this.f62555e.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(this.f62556f.f62552b, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f62556f.f62552b);
                        }
                        albumFloatActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
                        if (d.a.r0.w.w.a.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.f62555e.y() != null) {
                                this.f62555e.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.f62555e.y() != null) {
                            this.f62555e.y().setMaxImagesAllowed(9);
                        }
                        l.x(this.f62555e.r().getPageActivity(), this.f62555e.r().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) aVar.f56768c).intValue();
                        if (this.f62555e.y() != null && this.f62555e.y().getChosedFiles() != null && (size = this.f62555e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f62555e.r().getPageActivity(), 12012, this.f62555e.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (this.f62556f.f62553c) {
                            l.L(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                        }
                        if (this.f62556f.i(this.f62555e.r(), 11025)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f62555e.r().getPageActivity(), 12004, true)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else {
                this.f62555e.t0(null);
            }
        }
    }

    public b() {
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
        this.f62553c = false;
    }

    @Override // d.a.r0.w.c
    public e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(this.f62554d ? 2 : 3);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.setDeskBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(false);
            editorTools.setMoreButtonAtEnd(true);
            return new d.a.s0.k1.j.a(editorTools);
        }
        return (e) invokeL.objValue;
    }

    @Override // d.a.r0.w.c
    public void c(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && (eVar instanceof d.a.s0.k1.j.a)) {
            EditorTools a2 = eVar.a();
            a aVar = new a(this, (d.a.s0.k1.j.a) eVar);
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
            a2.setActionListener(36, aVar);
            a2.setActionListener(32, aVar);
        }
    }

    @Override // d.a.r0.w.c
    public void d(e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            if (d.a.s0.h3.p0.c.a() && u.a(this.f62551a, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                mVar.j = 2;
                a2.d(mVar);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.h(arrayList);
            m n = a2.n(5);
            if (n != null) {
                n.f(!this.f62554d);
                n.j = this.f62554d ? 1 : 3;
            }
            d.a.r0.w.o.a aVar = new d.a.r0.w.o.a(a2.getContext(), 4);
            aVar.f56778g = false;
            a2.d(aVar);
            if (!this.f62554d) {
                a2.d(new d(a2.getContext(), 1));
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
                a2.d(new d.a.r0.w.q.a(a2.getContext(), 5));
            } else {
                a2.d(new f(a2.getContext(), false, false));
            }
            a2.f();
        }
    }

    public final boolean i(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i2)) == null) {
            if (d.a.r0.f0.f.e()) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f62551a = str;
            this.f62552b = str2;
        }
    }
}
