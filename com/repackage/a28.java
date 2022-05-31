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
import com.repackage.by7;
import com.repackage.z18;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes5.dex */
public class a28 extends y18 implements c38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity b;
    public BaseFragment c;
    public TbPageContext d;
    public final View e;
    public final BdUniqueId f;
    public long g;
    public String h;
    public z18 i;
    public final PersonPolymericModel j;
    public final x18 k;
    public final BlackListModel l;
    public e28 m;
    public cy5 n;
    public PersonPolymericEventController o;
    public b28 p;
    public int q;
    public boolean r;
    public final z18.e s;
    public CustomMessageListener t;

    /* loaded from: classes5.dex */
    public class a implements z18.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a28 a;

        public a(a28 a28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a28Var;
        }

        @Override // com.repackage.z18.e
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a28 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a28 a28Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a28Var, Integer.valueOf(i)};
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
            this.a = a28Var;
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

    /* loaded from: classes5.dex */
    public class c implements by7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a28 a;

        public c(a28 a28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a28Var;
        }

        @Override // com.repackage.by7.c
        public void a(int i, String str, ImageUploadResult imageUploadResult) {
            ImageUploadResult.PicDetailedInfo picDetailedInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, imageUploadResult) == null) && i == 0 && imageUploadResult != null) {
                String str2 = null;
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null) {
                    str2 = picDetailedInfo.picUrl;
                }
                d28.a(str2, this.a.s());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a28(BaseFragment baseFragment, View view2, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
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
        this.k = new x18(this.c.getPageContext(), bdUniqueId);
        z18 z18Var = new z18(this.c.getPageContext(), view2, z);
        this.i = z18Var;
        z18Var.u(this.s);
        this.o = new PersonPolymericEventController(this.d, this);
        PersonPolymericModel personPolymericModel = new PersonPolymericModel(this.b, bdUniqueId, z);
        this.j = personPolymericModel;
        personPolymericModel.P(new u28(z));
        this.j.N(this);
        this.j.O(this.k);
        this.l = new BlackListModel(this.b.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.h)) {
            e28 e28Var = new e28(this.c, this, this.f, this.g, z);
            this.m = e28Var;
            e28Var.k(TbadkCoreApplication.getInst().getSkinType());
            this.m.j(this.o);
        }
        this.p = new b28(this.d, this.k, this.l, bdUniqueId);
        loadData();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TbadkCoreApplication.isLogin() && this.a) {
                this.i.B();
            } else if (ji.A()) {
                this.j.K(this.g, this.h);
            } else {
                this.i.n();
                li.O(this.d.getContext(), this.d.getString(R.string.obfuscated_res_0x7f0f0482));
                ArrayList arrayList = new ArrayList();
                n28 n28Var = new n28();
                n28Var.a = this.a;
                arrayList.add(n28Var);
                this.i.m();
                this.i.w(arrayList);
                this.i.z();
            }
        }
    }

    @Override // com.repackage.c38
    public void c(f28 f28Var) {
        NicknameInfo nicknameInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f28Var) == null) {
            if (f28Var != null && f28Var.j() != null && !StringUtils.isNull(this.h)) {
                this.g = f28Var.j().getUserIdLong();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.g)));
                this.a = this.g == jg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            }
            this.i.n();
            b28 b28Var = this.p;
            if (b28Var != null) {
                b28Var.h(f28Var);
            }
            if (f28Var != null) {
                this.i.k(f28Var);
            }
            e28 e28Var = this.m;
            if (e28Var != null) {
                e28Var.o(f28Var);
            } else {
                e28 e28Var2 = new e28(this.c, this, this.f, this.g, this.a);
                this.m = e28Var2;
                e28Var2.k(TbadkCoreApplication.getInst().getSkinType());
                this.m.j(this.o);
                this.m.o(f28Var);
            }
            if (!this.r || f28Var == null || (nicknameInfo = f28Var.A) == null || nicknameInfo.left_days == null || f28Var.j() == null) {
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(f28Var.j().getIsMem());
            personChangeData.setNickNameLeftDays(f28Var.A.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            new by7().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new c(this));
        }
    }

    public boolean k(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ki.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (ys4.k().h(ys4.o(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.b).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public z18 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : (z18) invokeV.objValue;
    }

    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!TbadkCoreApplication.isLogin() && this.a) {
                this.i.B();
            } else if (ji.A()) {
                u08.d().m(System.currentTimeMillis());
                this.i.x(false, -1);
                this.i.C(true);
                this.j.L(this.g);
                this.j.K(this.g, this.h);
            } else {
                this.i.n();
                this.i.t(8);
                this.i.y(this.c.getString(R.string.obfuscated_res_0x7f0f0c33), true);
            }
        }
    }

    public b28 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : (b28) invokeV.objValue;
    }

    public v18 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : (v18) invokeV.objValue;
    }

    public c28 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (c28) invokeV.objValue;
    }

    public f28 q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (z) {
                this.r = z;
                if (ji.A()) {
                    this.j.K(this.g, this.h);
                }
            }
            return this.j.J();
        }
        return (f28) invokeZ.objValue;
    }

    public PersonPolymericModel r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : (PersonPolymericModel) invokeV.objValue;
    }

    public List<jn> s() {
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
        e28 e28Var = this.m;
        if (e28Var != null) {
            e28Var.k(i);
        }
        this.q = i;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t);
            e28 e28Var = this.m;
            if (e28Var != null) {
                e28Var.l();
            }
            PersonPolymericModel personPolymericModel = this.j;
            if (personPolymericModel != null) {
                personPolymericModel.destroy();
            }
        }
    }

    public void v(boolean z) {
        e28 e28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (e28Var = this.m) == null) {
            return;
        }
        e28Var.m(z);
    }

    public void w() {
        e28 e28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (e28Var = this.m) == null) {
            return;
        }
        e28Var.n();
    }

    public void x(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, postWriteCallBackData) == null) {
            if (this.n == null) {
                this.n = new cy5(this.b.getPageContext(), (NavigationBarCoverTip) this.b.findViewById(R.id.obfuscated_res_0x7f0914fd));
            }
            this.n.l(postWriteCallBackData);
        }
    }
}
