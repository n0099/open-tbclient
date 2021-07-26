package d.a.q0.m2.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.holder.PersonInfoAddUserPicViewHolder;
import com.baidu.tieba.person.holder.PersonInfoUserPicViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.d.k.e.n;
import d.a.p0.s.s.l;
import d.a.p0.u.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i extends d.a.q0.m2.d.e implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f60814f;

    /* renamed from: g  reason: collision with root package name */
    public final WriteImagesInfo f60815g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60816h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.m2.e.a f60817i;
    public PersonChangeData j;
    public PermissionJudgePolicy k;
    public HttpMessageListener l;
    public HttpMessageListener m;
    public Runnable n;
    public CustomMessageListener o;

    /* loaded from: classes8.dex */
    public class a implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.j f60818e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f60819f;

        public a(i iVar, d.a.p0.s.s.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60819f = iVar;
            this.f60818e = jVar;
        }

        @Override // d.a.p0.s.s.l.e
        public void onItemClick(l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                this.f60819f.f60816h = false;
                if (i2 == 0) {
                    this.f60819f.t();
                } else if (i2 == 1) {
                    this.f60819f.v();
                }
                if (this.f60818e.isShowing()) {
                    this.f60818e.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f60820e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f60821f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f60822g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.j f60823h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f60824i;

        public b(i iVar, m mVar, List list, int i2, d.a.p0.s.s.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, mVar, list, Integer.valueOf(i2), jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60824i = iVar;
            this.f60820e = mVar;
            this.f60821f = list;
            this.f60822g = i2;
            this.f60823h = jVar;
        }

        @Override // d.a.p0.s.s.l.e
        public void onItemClick(l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                this.f60824i.f60816h = true;
                if (i2 == 0) {
                    this.f60824i.w(this.f60820e, this.f60821f, this.f60822g);
                } else if (i2 == 1) {
                    i iVar = this.f60824i;
                    if (iVar.f60783e && iVar.f60817i != null && this.f60824i.f60817i.j() != null && !this.f60824i.f60817i.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f60824i.f60817i.j().getCantModifyAvatarDesc())) {
                            d.a.d.e.p.l.J(TbadkCoreApplication.getInst(), this.f60824i.f60817i.j().getCantModifyAvatarDesc());
                        } else {
                            d.a.d.e.p.l.I(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                        }
                    } else {
                        this.f60824i.t();
                    }
                } else if (i2 == 2) {
                    i iVar2 = this.f60824i;
                    if (iVar2.f60783e && iVar2.f60817i != null && this.f60824i.f60817i.j() != null && !this.f60824i.f60817i.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f60824i.f60817i.j().getCantModifyAvatarDesc())) {
                            d.a.d.e.p.l.J(TbadkCoreApplication.getInst(), this.f60824i.f60817i.j().getCantModifyAvatarDesc());
                        } else {
                            d.a.d.e.p.l.I(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                        }
                    } else {
                        this.f60824i.v();
                    }
                } else if (i2 == 3) {
                    TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                    this.f60824i.u();
                }
                if (this.f60823h.isShowing()) {
                    this.f60823h.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f60825e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f60826f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f60827g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.j f60828h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f60829i;

        public c(i iVar, m mVar, List list, int i2, d.a.p0.s.s.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, mVar, list, Integer.valueOf(i2), jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60829i = iVar;
            this.f60825e = mVar;
            this.f60826f = list;
            this.f60827g = i2;
            this.f60828h = jVar;
        }

        @Override // d.a.p0.s.s.l.e
        public void onItemClick(l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                if (i2 == 0) {
                    this.f60829i.w(this.f60825e, this.f60826f, this.f60827g);
                } else if (i2 == 1) {
                    j.d(this.f60825e, this.f60829i.f60814f.getUniqueId());
                } else if (i2 == 2) {
                    j.b(this.f60825e, this.f60826f);
                }
                if (this.f60828h.isShowing()) {
                    this.f60828h.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f60830a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60830a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                this.f60830a.z();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f60831a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60831a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    this.f60831a.f60814f.showToast(setUserPicsResponse.getErrorString());
                } else {
                    this.f60831a.z();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921424));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f60832a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60832a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                this.f60832a.x((PersonChangeData) customResponsedMessage.getData());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60815g = new WriteImagesInfo(1);
        this.f60816h = true;
        this.l = new d(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        this.m = new e(this, CmdConfigHttp.CMD_SET_USER_PICS);
        this.n = new f(this);
        g gVar = new g(this, 2001380);
        this.o = gVar;
        this.f60814f = tbPageContext;
        gVar.setTag(bdUniqueId);
        this.m.setTag(bdUniqueId);
        this.l.setTag(bdUniqueId);
        this.f60814f.registerListener(this.o);
        this.f60814f.registerListener(this.m);
        this.f60814f.registerListener(this.l);
    }

    public void A(d.a.q0.m2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f60817i = aVar;
        }
    }

    public final void B() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.f60814f) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.choose_local_photo), this.f60814f.getString(R.string.change_system_photo)};
        d.a.p0.s.s.j jVar = new d.a.p0.s.s.j(this.f60814f);
        jVar.i(null, strArr, new a(this, jVar));
        jVar.l();
    }

    public final void F(m mVar, List<n> list, int i2) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, mVar, list, i2) == null) || (tbPageContext = this.f60814f) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.hd_photo), this.f60814f.getString(R.string.change_photo), this.f60814f.getString(R.string.change_system_photo), this.f60814f.getString(R.string.check_headpendant)};
        d.a.p0.s.s.j jVar = new d.a.p0.s.s.j(this.f60814f);
        jVar.i(null, strArr, new b(this, mVar, list, i2, jVar));
        jVar.l();
    }

    public final void G(m mVar, List<n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, mVar, list, i2) == null) {
            String[] strArr = {this.f60814f.getString(R.string.look_big_photo), this.f60814f.getString(R.string.set_as_portrait_photo), this.f60814f.getString(R.string.delete)};
            d.a.p0.s.s.j jVar = new d.a.p0.s.s.j(this.f60814f);
            jVar.i(null, strArr, new c(this, mVar, list, i2, jVar));
            jVar.l();
        }
    }

    public void o() {
        d.a.q0.m2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f60817i) == null || aVar.j() == null) {
            return;
        }
        d.a.p0.b0.c.k().g(this.f60817i.j().getPortrait());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == null || q() == null) {
            return;
        }
        n nVar = null;
        if (view.getTag() instanceof PersonInfoUserPicViewHolder) {
            nVar = ((PersonInfoUserPicViewHolder) view.getTag()).c();
        } else if (view.getTag() instanceof PersonInfoAddUserPicViewHolder) {
            nVar = ((PersonInfoAddUserPicViewHolder) view.getTag()).c();
        }
        int position = ListUtils.getPosition(q(), nVar);
        if (position < 0) {
            return;
        }
        r(nVar, q(), position);
    }

    public void p(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, intent) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.f60815g.parseJson(stringExtra);
        this.f60815g.updateQuality();
        if (!ListUtils.isEmpty(this.f60815g.getChosedFiles())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.f60814f.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.f60815g.getChosedFiles().get(0).getFilePath(), 1.0f, this.f60816h)));
        }
        this.f60815g.clear();
    }

    public List<n> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d.a.q0.m2.e.a aVar = this.f60817i;
            if (aVar == null) {
                return null;
            }
            return aVar.k();
        }
        return (List) invokeV.objValue;
    }

    public void r(n nVar, List<n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar, list, i2) == null) {
            s(nVar, list, i2, false);
        }
    }

    public void s(n nVar, List<n> list, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{nVar, list, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || nVar == null) {
            return;
        }
        if (z) {
            if (nVar instanceof m) {
                w((m) nVar, list, i2);
                return;
            }
            return;
        }
        d.a.q0.m2.e.a aVar = this.f60817i;
        if (aVar != null) {
            this.f60783e = aVar.m();
        }
        if (!d.a.d.e.p.l.D()) {
            this.f60814f.showToast(R.string.neterror);
        } else if (!this.f60783e) {
            if (nVar instanceof m) {
                w((m) nVar, list, i2);
            }
        } else if (nVar instanceof d.a.q0.j2.i.c) {
            B();
        } else if (nVar instanceof m) {
            m mVar = (m) nVar;
            if (mVar.d()) {
                F(mVar, list, i2);
            } else {
                G(mVar, list, i2);
            }
        }
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbPageContext = this.f60814f) == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (this.k == null) {
            this.k = new PermissionJudgePolicy();
        }
        this.k.clearRequestPermissionList();
        this.k.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.k.startRequestPermission(pageActivity)) {
            return;
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f60814f.getPageActivity(), this.f60815g.toJsonString(), true);
        albumActivityConfig.setRequestCode(12002);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f60814f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.f60814f.getPageActivity())));
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f60814f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.f60814f.getPageActivity(), 12014, this.f60816h)));
    }

    public final void w(m mVar, List<n> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048589, this, mVar, list, i2) == null) || this.f60814f == null || mVar == null || list == null || StringUtils.isNull(mVar.b())) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (n nVar : list) {
            if (nVar instanceof m) {
                m mVar2 = (m) nVar;
                if (mVar2.d() && !mVar2.b().startsWith("http")) {
                    arrayList.add(j.c(this.f60814f, mVar2.b()));
                } else {
                    arrayList.add(mVar2.b());
                }
            }
        }
        int size = arrayList.size();
        String str = size > 0 ? arrayList.get(size - 1) : "";
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(arrayList);
        bVar.B(i2);
        bVar.C(true);
        bVar.J(str);
        bVar.F(true);
        bVar.I(false);
        ImageViewerConfig v = bVar.v(this.f60814f.getPageActivity());
        v.getIntent().putExtra("from", "portrait");
        this.f60814f.sendMessage(new CustomMessage(2010000, v));
    }

    public final void x(PersonChangeData personChangeData) {
        d.a.q0.m2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, personChangeData) == null) || personChangeData == null || (aVar = this.f60817i) == null || aVar.j() == null || !this.f60817i.m() || !personChangeData.getPhotoChanged()) {
            return;
        }
        if (this.j == null) {
            this.j = new PersonChangeData();
        }
        this.j.setPhotoChanged(true);
        o();
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            d.a.d.e.m.e.a().removeCallbacks(this.n);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            d.a.d.e.m.e.a().postDelayed(this.n, 300L);
        }
    }
}
