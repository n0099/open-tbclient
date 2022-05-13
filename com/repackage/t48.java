package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.event.PersonPolymericEventController;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.s08;
import com.repackage.s48;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes7.dex */
public class t48 extends r48 implements v58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity b;
    public BaseFragment c;
    public TbPageContext d;
    public final View e;
    public final BdUniqueId f;
    public long g;
    public String h;
    public s48 i;
    public final PersonPolymericModel j;
    public final q48 k;
    public final BlackListModel l;
    public x48 m;
    public rz5 n;
    public PersonPolymericEventController o;
    public u48 p;
    public int q;
    public boolean r;
    public final s48.e s;
    public CustomMessageListener t;

    /* loaded from: classes7.dex */
    public class a implements s48.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        public a(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
        }

        @Override // com.repackage.s48.e
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.loadData();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements s08.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        public c(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
        }

        @Override // com.repackage.s08.c
        public void a(int i, String str, ImageUploadResult imageUploadResult) {
            ImageUploadResult.PicDetailedInfo picDetailedInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, imageUploadResult) == null) && i == 0 && imageUploadResult != null) {
                String str2 = null;
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null) {
                    str2 = picDetailedInfo.picUrl;
                }
                w48.a(str2, this.a.s());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t48(BaseFragment baseFragment, View view2, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, view2, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), str};
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
        this.q = 3;
        this.r = false;
        this.s = new a(this);
        this.t = new b(this, 2921424);
        this.c = baseFragment;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.b = baseFragmentActivity;
        this.e = view2;
        this.f = bdUniqueId;
        this.g = j;
        this.h = str;
        this.d = baseFragmentActivity.getPageContext();
        MessageManager.getInstance().registerListener(this.t);
        this.k = new q48(this.c.getPageContext(), bdUniqueId);
        s48 s48Var = new s48(this.c.getPageContext(), view2, z);
        this.i = s48Var;
        s48Var.u(this.s);
        this.o = new PersonPolymericEventController(this.d, this);
        PersonPolymericModel personPolymericModel = new PersonPolymericModel(this.b, bdUniqueId, z);
        this.j = personPolymericModel;
        personPolymericModel.P(new n58(z));
        this.j.N(this);
        this.j.O(this.k);
        this.l = new BlackListModel(this.b.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.h)) {
            x48 x48Var = new x48(this.c, this, this.f, this.g, z);
            this.m = x48Var;
            x48Var.k(TbadkCoreApplication.getInst().getSkinType());
            this.m.j(this.o);
        }
        this.p = new u48(this.d, this.k, this.l, bdUniqueId);
        loadData();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TbadkCoreApplication.isLogin() && this.a) {
                this.i.B();
            } else if (ki.A()) {
                this.j.K(this.g, this.h);
            } else {
                this.i.n();
                mi.N(this.d.getContext(), this.d.getString(R.string.obfuscated_res_0x7f0f047b));
                ArrayList arrayList = new ArrayList();
                g58 g58Var = new g58();
                g58Var.a = this.a;
                arrayList.add(g58Var);
                this.i.m();
                this.i.w(arrayList);
                this.i.z();
            }
        }
    }

    @Override // com.repackage.v58
    public void c(y48 y48Var) {
        NicknameInfo nicknameInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y48Var) == null) {
            if (y48Var != null && y48Var.j() != null && !StringUtils.isNull(this.h)) {
                this.g = y48Var.j().getUserIdLong();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.g)));
                this.a = this.g == kg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            }
            this.i.n();
            u48 u48Var = this.p;
            if (u48Var != null) {
                u48Var.h(y48Var);
            }
            if (y48Var != null) {
                this.i.k(y48Var);
            }
            x48 x48Var = this.m;
            if (x48Var != null) {
                x48Var.o(y48Var);
            } else {
                x48 x48Var2 = new x48(this.c, this, this.f, this.g, this.a);
                this.m = x48Var2;
                x48Var2.k(TbadkCoreApplication.getInst().getSkinType());
                this.m.j(this.o);
                this.m.o(y48Var);
            }
            if (!this.r || y48Var == null || (nicknameInfo = y48Var.A) == null || nicknameInfo.left_days == null || y48Var.j() == null) {
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(y48Var.j().getIsMem());
            personChangeData.setNickNameLeftDays(y48Var.A.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            new s08().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new c(this));
        }
    }

    public boolean k(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || li.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (iu4.k().h(iu4.o(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.b).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public s48 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : (s48) invokeV.objValue;
    }

    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!TbadkCoreApplication.isLogin() && this.a) {
                this.i.B();
            } else if (ki.A()) {
                n38.d().m(System.currentTimeMillis());
                this.i.x(false, -1);
                this.i.C(true);
                this.j.L(this.g);
                this.j.K(this.g, this.h);
            } else {
                this.i.n();
                this.i.t(8);
                this.i.y(this.c.getString(R.string.obfuscated_res_0x7f0f0c2d), true);
            }
        }
    }

    public u48 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : (u48) invokeV.objValue;
    }

    public o48 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : (o48) invokeV.objValue;
    }

    public v48 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (v48) invokeV.objValue;
    }

    public y48 q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (z) {
                this.r = z;
                if (ki.A()) {
                    this.j.K(this.g, this.h);
                }
            }
            return this.j.J();
        }
        return (y48) invokeZ.objValue;
    }

    public PersonPolymericModel r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : (PersonPolymericModel) invokeV.objValue;
    }

    public List<ro> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.j.J() == null) {
                return null;
            }
            return this.j.J().k();
        }
        return (List) invokeV.objValue;
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || this.q == i) {
            return;
        }
        x48 x48Var = this.m;
        if (x48Var != null) {
            x48Var.k(i);
        }
        this.q = i;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t);
            x48 x48Var = this.m;
            if (x48Var != null) {
                x48Var.l();
            }
            PersonPolymericModel personPolymericModel = this.j;
            if (personPolymericModel != null) {
                personPolymericModel.destroy();
            }
        }
    }

    public void v(boolean z) {
        x48 x48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (x48Var = this.m) == null) {
            return;
        }
        x48Var.m(z);
    }

    public void w() {
        x48 x48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (x48Var = this.m) == null) {
            return;
        }
        x48Var.n();
    }

    public void x(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, postWriteCallBackData) == null) {
            if (this.n == null) {
                this.n = new rz5(this.b.getPageContext(), (NavigationBarCoverTip) this.b.findViewById(R.id.obfuscated_res_0x7f09153f));
            }
            this.n.l(postWriteCallBackData);
        }
    }
}
