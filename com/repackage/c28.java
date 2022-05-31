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
import com.repackage.oq4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c28 extends y18 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public final WriteImagesInfo c;
    public boolean d;
    public f28 e;
    public PersonChangeData f;
    public PermissionJudgePolicy g;
    public HttpMessageListener h;
    public HttpMessageListener i;
    public Runnable j;
    public CustomMessageListener k;

    /* loaded from: classes5.dex */
    public class a implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq4 a;
        public final /* synthetic */ c28 b;

        public a(c28 c28Var, mq4 mq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c28Var, mq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c28Var;
            this.a = mq4Var;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                this.b.d = false;
                if (i == 0) {
                    this.b.u();
                } else if (i == 1) {
                    this.b.w();
                }
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz4 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;
        public final /* synthetic */ mq4 d;
        public final /* synthetic */ c28 e;

        public b(c28 c28Var, hz4 hz4Var, List list, int i, mq4 mq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c28Var, hz4Var, list, Integer.valueOf(i), mq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = c28Var;
            this.a = hz4Var;
            this.b = list;
            this.c = i;
            this.d = mq4Var;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                this.e.d = true;
                if (i == 0) {
                    this.e.x(this.a, this.b, this.c);
                } else if (i == 1) {
                    c28 c28Var = this.e;
                    if (c28Var.a && c28Var.e != null && this.e.e.j() != null && !this.e.e.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.e.e.j().getCantModifyAvatarDesc())) {
                            li.L(TbadkCoreApplication.getInst(), this.e.e.j().getCantModifyAvatarDesc());
                        } else {
                            li.K(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0e04);
                        }
                    } else {
                        this.e.u();
                    }
                } else if (i == 2) {
                    c28 c28Var2 = this.e;
                    if (c28Var2.a && c28Var2.e != null && this.e.e.j() != null && !this.e.e.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.e.e.j().getCantModifyAvatarDesc())) {
                            li.L(TbadkCoreApplication.getInst(), this.e.e.j().getCantModifyAvatarDesc());
                        } else {
                            li.K(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0e04);
                        }
                    } else {
                        this.e.w();
                    }
                } else if (i == 3) {
                    TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                    this.e.v();
                }
                if (this.d.isShowing()) {
                    this.d.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz4 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;
        public final /* synthetic */ mq4 d;
        public final /* synthetic */ c28 e;

        public c(c28 c28Var, hz4 hz4Var, List list, int i, mq4 mq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c28Var, hz4Var, list, Integer.valueOf(i), mq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = c28Var;
            this.a = hz4Var;
            this.b = list;
            this.c = i;
            this.d = mq4Var;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                if (i == 0) {
                    this.e.x(this.a, this.b, this.c);
                } else if (i == 1) {
                    d28.d(this.a, this.e.b.getUniqueId());
                } else if (i == 2) {
                    d28.b(this.a, this.b);
                }
                if (this.d.isShowing()) {
                    this.d.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c28 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c28 c28Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c28Var, Integer.valueOf(i)};
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
            this.a = c28Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                this.a.A();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c28 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c28 c28Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c28Var, Integer.valueOf(i)};
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
            this.a = c28Var;
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
                    this.a.A();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(c28 c28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c28Var};
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

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c28 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(c28 c28Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c28Var, Integer.valueOf(i)};
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
            this.a = c28Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                this.a.y((PersonChangeData) customResponsedMessage.getData());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c28(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
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

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            mg.a().postDelayed(this.j, 300L);
        }
    }

    public void B(f28 f28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f28Var) == null) {
            this.e = f28Var;
        }
    }

    public final void C() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.b) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.obfuscated_res_0x7f0f03c6), this.b.getString(R.string.obfuscated_res_0x7f0f039b)};
        mq4 mq4Var = new mq4(this.b);
        mq4Var.j(null, strArr, new a(this, mq4Var));
        mq4Var.m();
    }

    public final void D(hz4 hz4Var, List<jn> list, int i) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048579, this, hz4Var, list, i) == null) || (tbPageContext = this.b) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.obfuscated_res_0x7f0f0826), this.b.getString(R.string.obfuscated_res_0x7f0f0398), this.b.getString(R.string.obfuscated_res_0x7f0f039b), this.b.getString(R.string.obfuscated_res_0x7f0f03b3)};
        mq4 mq4Var = new mq4(this.b);
        mq4Var.j(null, strArr, new b(this, hz4Var, list, i, mq4Var));
        mq4Var.m();
    }

    public final void E(hz4 hz4Var, List<jn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, hz4Var, list, i) == null) {
            String[] strArr = {this.b.getString(R.string.obfuscated_res_0x7f0f0a6a), this.b.getString(R.string.obfuscated_res_0x7f0f111c), this.b.getString(R.string.obfuscated_res_0x7f0f04a4)};
            mq4 mq4Var = new mq4(this.b);
            mq4Var.j(null, strArr, new c(this, hz4Var, list, i, mq4Var));
            mq4Var.m();
        }
    }

    public void o() {
        f28 f28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (f28Var = this.e) == null || f28Var.j() == null) {
            return;
        }
        u25.k().g(this.e.j().getPortrait());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view2) == null) || view2 == null || r() == null) {
            return;
        }
        jn jnVar = null;
        if (view2.getTag() instanceof PersonInfoUserPicViewHolder) {
            jnVar = ((PersonInfoUserPicViewHolder) view2.getTag()).d();
        } else if (view2.getTag() instanceof PersonInfoAddUserPicViewHolder) {
            jnVar = ((PersonInfoAddUserPicViewHolder) view2.getTag()).d();
        }
        int position = ListUtils.getPosition(r(), jnVar);
        if (position < 0) {
            return;
        }
        s(jnVar, r(), position);
    }

    public void q(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, intent) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.c.parseJson(stringExtra);
        this.c.updateQuality();
        if (!ListUtils.isEmpty(this.c.getChosedFiles())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.b.getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.c.getChosedFiles().get(0).getFilePath(), 1.0f, this.d)));
        }
        this.c.clear();
    }

    public List<jn> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            f28 f28Var = this.e;
            if (f28Var == null) {
                return null;
            }
            return f28Var.k();
        }
        return (List) invokeV.objValue;
    }

    public void s(jn jnVar, List<jn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048585, this, jnVar, list, i) == null) {
            t(jnVar, list, i, false);
        }
    }

    public void t(jn jnVar, List<jn> list, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{jnVar, list, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || jnVar == null) {
            return;
        }
        if (z) {
            if (jnVar instanceof hz4) {
                x((hz4) jnVar, list, i);
                return;
            }
            return;
        }
        f28 f28Var = this.e;
        if (f28Var != null) {
            this.a = f28Var.m();
        }
        if (!li.D()) {
            this.b.showToast(R.string.obfuscated_res_0x7f0f0c33);
        } else if (!this.a) {
            if (jnVar instanceof hz4) {
                x((hz4) jnVar, list, i);
            }
        } else if (jnVar instanceof qy7) {
            C();
        } else if (jnVar instanceof hz4) {
            hz4 hz4Var = (hz4) jnVar;
            if (hz4Var.e()) {
                D(hz4Var, list, i);
            } else {
                E(hz4Var, list, i);
            }
        }
    }

    public void u() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (tbPageContext = this.b) == null) {
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

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.b == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.b.getPageActivity())));
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.b == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.b.getPageActivity(), 12014, this.d)));
    }

    public final void x(hz4 hz4Var, List<jn> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048590, this, hz4Var, list, i) == null) || this.b == null || hz4Var == null || list == null || StringUtils.isNull(hz4Var.a())) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (jn jnVar : list) {
            if (jnVar instanceof hz4) {
                hz4 hz4Var2 = (hz4) jnVar;
                if (hz4Var2.e() && !hz4Var2.a().startsWith("http")) {
                    arrayList.add(d28.c(this.b, hz4Var2.a()));
                } else {
                    arrayList.add(hz4Var2.a());
                }
            }
        }
        int size = arrayList.size();
        String str = size > 0 ? arrayList.get(size - 1) : "";
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(arrayList);
        bVar.B(i);
        bVar.C(true);
        bVar.J(str);
        bVar.F(true);
        bVar.I(false);
        ImageViewerConfig v = bVar.v(this.b.getPageActivity());
        v.getIntent().putExtra("from", "portrait");
        this.b.sendMessage(new CustomMessage(2010000, v));
    }

    public final void y(PersonChangeData personChangeData) {
        f28 f28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, personChangeData) == null) || personChangeData == null || (f28Var = this.e) == null || f28Var.j() == null || !this.e.m() || !personChangeData.getPhotoChanged()) {
            return;
        }
        if (this.f == null) {
            this.f = new PersonChangeData();
        }
        this.f.setPhotoChanged(true);
        o();
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            mg.a().removeCallbacks(this.j);
        }
    }
}
