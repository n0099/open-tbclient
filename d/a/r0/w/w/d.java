package d.a.r0.w.w;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.PlayerPostEvent;
import d.a.c.e.p.l;
import d.a.r0.w.m;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class d extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements d.a.r0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f56818e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f56819f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f56820g;

        public a(d dVar, e eVar, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, eVar, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56820g = dVar;
            this.f56818e = eVar;
            this.f56819f = editorTools;
        }

        @Override // d.a.r0.w.b
        public void onAction(d.a.r0.w.a aVar) {
            e eVar;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (eVar = this.f56818e) == null || eVar.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.f56766a;
            if (i2 == 4) {
                this.f56818e.m0(aVar.f56768c.toString());
            } else if (i2 == 5) {
                if (this.f56819f.u()) {
                    return;
                }
                TiebaStatic.eventStat(this.f56819f.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i2 == 7) {
                this.f56818e.r().showToast(R.string.over_limit_tip);
            } else if (i2 == 8) {
                if (this.f56820g.j(this.f56818e.r(), 11001)) {
                    this.f56818e.L(null, null);
                }
            } else if (i2 != 14) {
                if (i2 != 15) {
                    return;
                }
                int intValue = ((Integer) aVar.f56768c).intValue();
                if (this.f56818e.y() != null && this.f56818e.y().getChosedFiles() != null && (size = this.f56818e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f56818e.r().getPageActivity(), 12012, this.f56818e.y(), intValue)));
                }
            } else {
                if (this.f56818e.y() != null) {
                    this.f56818e.y().setMaxImagesAllowed(1);
                }
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f56818e.r().getPageActivity(), this.f56818e.y().toJsonString(), true, true);
                if (!StringUtils.isNull(this.f56820g.l(), true)) {
                    albumActivityConfig.getIntent().putExtra("from", this.f56820g.l());
                }
                if (this.f56820g.k() != null && !StringUtils.isNull(this.f56820g.k().getId(), true)) {
                    albumActivityConfig.getIntent().putExtra("forum_id", this.f56820g.k().getId());
                }
                albumActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
                l.x(this.f56818e.r().getPageActivity(), this.f56818e.r().getPageActivity().getCurrentFocus());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    @Override // d.a.r0.w.w.g, d.a.r0.w.c
    public d.a.r0.w.e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0201);
            editorTools.D(false);
            editorTools.setMoreButtonAtEnd(true);
            e eVar = new e(editorTools);
            eVar.j0(m());
            eVar.z = true;
            return eVar;
        }
        return (d.a.r0.w.e) invokeL.objValue;
    }

    @Override // d.a.r0.w.w.g, d.a.r0.w.c
    public void c(d.a.r0.w.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && (eVar instanceof e)) {
            EditorTools a2 = eVar.a();
            a aVar = new a(this, (e) eVar, a2);
            a2.setActionListener(5, aVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(14, aVar);
            a2.setActionListener(15, aVar);
            a2.setActionListener(8, aVar);
            a2.setActionListener(32, aVar);
            a2.setActionListener(45, aVar);
        }
    }

    @Override // d.a.r0.w.w.g, d.a.r0.w.c
    public void d(d.a.r0.w.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.d(new d.a.r0.w.r.d(a2.getContext(), 1));
            a2.d(new f(a2.getContext(), true, false));
            a2.h(arrayList);
            m n = a2.n(5);
            if (n != null) {
                n.j = 2;
                n.f(false);
            }
            a2.f();
            a2.A(new d.a.r0.w.a(35, 5, Boolean.FALSE));
        }
    }
}
