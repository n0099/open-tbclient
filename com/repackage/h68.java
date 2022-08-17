package com.repackage;

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
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
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
import com.repackage.fs4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class h68 extends d68 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public final WriteImagesInfo c;
    public boolean d;
    public k68 e;
    public PersonChangeData f;
    public PermissionJudgePolicy g;
    public HttpMessageListener h;
    public HttpMessageListener i;
    public Runnable j;
    public CustomMessageListener k;

    /* loaded from: classes6.dex */
    public class a implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ds4 a;
        public final /* synthetic */ h68 b;

        public a(h68 h68Var, ds4 ds4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var, ds4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h68Var;
            this.a = ds4Var;
        }

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                this.b.d = false;
                if (i == 0) {
                    this.b.s();
                } else if (i == 1) {
                    this.b.u();
                }
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u15 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ds4 d;
        public final /* synthetic */ h68 e;

        public b(h68 h68Var, u15 u15Var, List list, int i, ds4 ds4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var, u15Var, list, Integer.valueOf(i), ds4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = h68Var;
            this.a = u15Var;
            this.b = list;
            this.c = i;
            this.d = ds4Var;
        }

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                this.e.d = true;
                if (i == 0) {
                    this.e.v(this.a, this.b, this.c);
                } else if (i == 1) {
                    h68 h68Var = this.e;
                    if (h68Var.a && h68Var.e != null && this.e.e.j() != null && !this.e.e.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.e.e.j().getCantModifyAvatarDesc())) {
                            qi.K(TbadkCoreApplication.getInst(), this.e.e.j().getCantModifyAvatarDesc());
                        } else {
                            qi.J(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0e19);
                        }
                    } else {
                        this.e.s();
                    }
                } else if (i == 2) {
                    h68 h68Var2 = this.e;
                    if (h68Var2.a && h68Var2.e != null && this.e.e.j() != null && !this.e.e.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.e.e.j().getCantModifyAvatarDesc())) {
                            qi.K(TbadkCoreApplication.getInst(), this.e.e.j().getCantModifyAvatarDesc());
                        } else {
                            qi.J(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0e19);
                        }
                    } else {
                        this.e.u();
                    }
                } else if (i == 3) {
                    TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                    this.e.t();
                }
                if (this.d.isShowing()) {
                    this.d.dismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u15 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ds4 d;
        public final /* synthetic */ h68 e;

        public c(h68 h68Var, u15 u15Var, List list, int i, ds4 ds4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var, u15Var, list, Integer.valueOf(i), ds4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = h68Var;
            this.a = u15Var;
            this.b = list;
            this.c = i;
            this.d = ds4Var;
        }

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                if (i == 0) {
                    this.e.v(this.a, this.b, this.c);
                } else if (i == 1) {
                    i68.d(this.a, this.e.b.getUniqueId());
                } else if (i == 2) {
                    i68.b(this.a, this.b);
                }
                if (this.d.isShowing()) {
                    this.d.dismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(h68 h68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                this.a.y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(h68 h68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    this.a.b.showToast(setUserPicsResponse.getErrorString());
                } else {
                    this.a.y();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(h68 h68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var};
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921424));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(h68 h68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                this.a.w((PersonChangeData) customResponsedMessage.getData());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h68(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new WriteImagesInfo(1);
        this.d = true;
        this.h = new d(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        this.i = new e(this, CmdConfigHttp.CMD_SET_USER_PICS);
        this.j = new f(this);
        g gVar = new g(this, 2001380);
        this.k = gVar;
        this.b = tbPageContext;
        gVar.setTag(bdUniqueId);
        this.i.setTag(bdUniqueId);
        this.h.setTag(bdUniqueId);
        this.b.registerListener(this.k);
        this.b.registerListener(this.i);
        this.b.registerListener(this.h);
    }

    public final void A() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbPageContext = this.b) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.obfuscated_res_0x7f0f03c7), this.b.getString(R.string.obfuscated_res_0x7f0f0396)};
        ds4 ds4Var = new ds4(this.b);
        ds4Var.i(null, strArr, new a(this, ds4Var));
        ds4Var.k();
    }

    public final void B(u15 u15Var, List<on> list, int i) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u15Var, list, i) == null) || (tbPageContext = this.b) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.obfuscated_res_0x7f0f083c), this.b.getString(R.string.obfuscated_res_0x7f0f0393), this.b.getString(R.string.obfuscated_res_0x7f0f0396), this.b.getString(R.string.obfuscated_res_0x7f0f03b1)};
        ds4 ds4Var = new ds4(this.b);
        ds4Var.i(null, strArr, new b(this, u15Var, list, i, ds4Var));
        ds4Var.k();
    }

    public final void C(u15 u15Var, List<on> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, u15Var, list, i) == null) {
            String[] strArr = {this.b.getString(R.string.obfuscated_res_0x7f0f0a6d), this.b.getString(R.string.obfuscated_res_0x7f0f1115), this.b.getString(R.string.obfuscated_res_0x7f0f04ab)};
            ds4 ds4Var = new ds4(this.b);
            ds4Var.i(null, strArr, new c(this, u15Var, list, i, ds4Var));
            ds4Var.k();
        }
    }

    public void n() {
        k68 k68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (k68Var = this.e) == null || k68Var.j() == null) {
            return;
        }
        i55.k().g(this.e.j().getPortrait());
    }

    public void o(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, intent) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.c.parseJson(stringExtra);
        this.c.updateQuality();
        if (!ListUtils.isEmpty(this.c.getChosedFiles())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.b.getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.c.getChosedFiles().get(0).getFilePath(), 1.0f, this.d).setUserGrowthTask(TbSingleton.getInstance().getUserGrowthTaskListData())));
        }
        this.c.clear();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view2) == null) || view2 == null || p() == null) {
            return;
        }
        on onVar = null;
        if (view2.getTag() instanceof PersonInfoUserPicViewHolder) {
            onVar = ((PersonInfoUserPicViewHolder) view2.getTag()).b();
        } else if (view2.getTag() instanceof PersonInfoAddUserPicViewHolder) {
            onVar = ((PersonInfoAddUserPicViewHolder) view2.getTag()).b();
        }
        int position = ListUtils.getPosition(p(), onVar);
        if (position < 0) {
            return;
        }
        q(onVar, p(), position);
    }

    public List<on> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            k68 k68Var = this.e;
            if (k68Var == null) {
                return null;
            }
            return k68Var.k();
        }
        return (List) invokeV.objValue;
    }

    public void q(on onVar, List<on> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, onVar, list, i) == null) {
            r(onVar, list, i, false);
        }
    }

    public void r(on onVar, List<on> list, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{onVar, list, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || onVar == null) {
            return;
        }
        if (z) {
            if (onVar instanceof u15) {
                v((u15) onVar, list, i);
                return;
            }
            return;
        }
        k68 k68Var = this.e;
        if (k68Var != null) {
            this.a = k68Var.m();
        }
        if (!qi.D()) {
            this.b.showToast(R.string.obfuscated_res_0x7f0f0c3d);
        } else if (!this.a) {
            if (onVar instanceof u15) {
                v((u15) onVar, list, i);
            }
        } else if (onVar instanceof u28) {
            A();
        } else if (onVar instanceof u15) {
            u15 u15Var = (u15) onVar;
            if (u15Var.c()) {
                B(u15Var, list, i);
            } else {
                C(u15Var, list, i);
            }
        }
    }

    public void s() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (tbPageContext = this.b) == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (this.g == null) {
            this.g = new PermissionJudgePolicy();
        }
        this.g.clearRequestPermissionList();
        this.g.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.g.startRequestPermission(pageActivity)) {
            return;
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.b.getPageActivity(), this.c.toJsonString(), true);
        albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.b == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.b.getPageActivity())));
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.b == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.b.getPageActivity(), 12014, this.d)));
    }

    public final void v(u15 u15Var, List<on> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048588, this, u15Var, list, i) == null) || this.b == null || u15Var == null || list == null || StringUtils.isNull(u15Var.a())) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (on onVar : list) {
            if (onVar instanceof u15) {
                u15 u15Var2 = (u15) onVar;
                if (u15Var2.c() && !u15Var2.a().startsWith("http")) {
                    arrayList.add(i68.c(this.b, u15Var2.a()));
                } else {
                    arrayList.add(u15Var2.a());
                }
            }
        }
        int size = arrayList.size();
        String str = size > 0 ? arrayList.get(size - 1) : "";
        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
        builder.y(arrayList);
        builder.C(i);
        builder.D(true);
        builder.K(str);
        builder.G(true);
        builder.J(false);
        ImageViewerConfig w = builder.w(this.b.getPageActivity());
        w.getIntent().putExtra("from", "portrait");
        this.b.sendMessage(new CustomMessage(2010000, w));
    }

    public final void w(PersonChangeData personChangeData) {
        k68 k68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, personChangeData) == null) || personChangeData == null || (k68Var = this.e) == null || k68Var.j() == null || !this.e.m() || !personChangeData.getPhotoChanged()) {
            return;
        }
        if (this.f == null) {
            this.f = new PersonChangeData();
        }
        this.f.setPhotoChanged(true);
        n();
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            rg.a().removeCallbacks(this.j);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            rg.a().postDelayed(this.j, 300L);
        }
    }

    public void z(k68 k68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, k68Var) == null) {
            this.e = k68Var;
        }
    }
}
