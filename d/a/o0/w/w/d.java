package d.a.o0.w.w;

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
import d.a.c.e.p.l;
import d.a.o0.w.m;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class d extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f53539e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f53540f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f53541g;

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
            this.f53541g = dVar;
            this.f53539e = eVar;
            this.f53540f = editorTools;
        }

        @Override // d.a.o0.w.b
        public void onAction(d.a.o0.w.a aVar) {
            e eVar;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (eVar = this.f53539e) == null || eVar.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.f53487a;
            if (i2 == 4) {
                this.f53539e.m0(aVar.f53489c.toString());
            } else if (i2 == 5) {
                if (this.f53540f.u()) {
                    return;
                }
                TiebaStatic.eventStat(this.f53540f.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i2 == 7) {
                this.f53539e.r().showToast(R.string.over_limit_tip);
            } else if (i2 == 8) {
                if (this.f53541g.j(this.f53539e.r(), 11001)) {
                    this.f53539e.L(null, null);
                }
            } else if (i2 != 14) {
                if (i2 != 15) {
                    return;
                }
                int intValue = ((Integer) aVar.f53489c).intValue();
                if (this.f53539e.y() != null && this.f53539e.y().getChosedFiles() != null && (size = this.f53539e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f53539e.r().getPageActivity(), 12012, this.f53539e.y(), intValue)));
                }
            } else {
                if (this.f53539e.y() != null) {
                    this.f53539e.y().setMaxImagesAllowed(1);
                }
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f53539e.r().getPageActivity(), this.f53539e.y().toJsonString(), true, true);
                if (!StringUtils.isNull(this.f53541g.l(), true)) {
                    albumActivityConfig.getIntent().putExtra("from", this.f53541g.l());
                }
                if (this.f53541g.k() != null && !StringUtils.isNull(this.f53541g.k().getId(), true)) {
                    albumActivityConfig.getIntent().putExtra("forum_id", this.f53541g.k().getId());
                }
                albumActivityConfig.setRequestCode(12002);
                l.x(this.f53539e.r().getPageActivity(), this.f53539e.r().getPageActivity().getCurrentFocus());
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

    @Override // d.a.o0.w.w.g, d.a.o0.w.c
    public d.a.o0.w.e b(Context context) {
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
        return (d.a.o0.w.e) invokeL.objValue;
    }

    @Override // d.a.o0.w.w.g, d.a.o0.w.c
    public void c(d.a.o0.w.e eVar) {
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

    @Override // d.a.o0.w.w.g, d.a.o0.w.c
    public void d(d.a.o0.w.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.d(new d.a.o0.w.r.d(a2.getContext(), 1));
            a2.d(new f(a2.getContext(), true, false));
            a2.h(arrayList);
            m n = a2.n(5);
            if (n != null) {
                n.j = 2;
                n.f(false);
            }
            a2.f();
            a2.A(new d.a.o0.w.a(35, 5, Boolean.FALSE));
        }
    }
}
