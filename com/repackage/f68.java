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
import com.repackage.e28;
import com.repackage.e68;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes6.dex */
public class f68 extends d68 implements h78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity b;
    public BaseFragment c;
    public TbPageContext d;
    public final View e;
    public final BdUniqueId f;
    public long g;
    public String h;
    public e68 i;
    public final PersonPolymericModel j;
    public final c68 k;
    public final BlackListModel l;
    public j68 m;
    public s16 n;
    public PersonPolymericEventController o;
    public g68 p;
    public int q;
    public boolean r;
    public final e68.e s;
    public CustomMessageListener t;

    /* loaded from: classes6.dex */
    public class a implements e68.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f68 a;

        public a(f68 f68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f68Var;
        }

        @Override // com.repackage.e68.e
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f68 f68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f68Var, Integer.valueOf(i)};
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
            this.a = f68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements e28.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f68 a;

        public c(f68 f68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f68Var;
        }

        @Override // com.repackage.e28.c
        public void a(int i, String str, ImageUploadResult imageUploadResult) {
            ImageUploadResult.PicDetailedInfo picDetailedInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, imageUploadResult) == null) && i == 0 && imageUploadResult != null) {
                String str2 = null;
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null) {
                    str2 = picDetailedInfo.picUrl;
                }
                i68.a(str2, this.a.q());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f68(BaseFragment baseFragment, View view2, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
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
        this.k = new c68(this.c.getPageContext(), bdUniqueId);
        e68 e68Var = new e68(this.c.getPageContext(), view2, z);
        this.i = e68Var;
        e68Var.s(this.s);
        this.o = new PersonPolymericEventController(this.d, this);
        PersonPolymericModel personPolymericModel = new PersonPolymericModel(this.b, bdUniqueId, z);
        this.j = personPolymericModel;
        personPolymericModel.Q(new z68(z));
        this.j.O(this);
        this.j.P(this.k);
        this.l = new BlackListModel(this.b.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.h)) {
            j68 j68Var = new j68(this.c, this, this.f, this.g, z);
            this.m = j68Var;
            j68Var.j(TbadkCoreApplication.getInst().getSkinType());
            this.m.i(this.o);
        }
        this.p = new g68(this.d, this.k, this.l, bdUniqueId);
        a();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TbadkCoreApplication.isLogin() && this.a) {
                this.i.z();
            } else if (oi.A()) {
                z48.d().m(System.currentTimeMillis());
                this.i.v(false, -1);
                this.i.A(true);
                this.j.M(this.g);
                this.j.L(this.g, this.h);
            } else {
                this.i.m();
                this.i.r(8);
                this.i.w(this.c.getString(R.string.obfuscated_res_0x7f0f0c3d), true);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TbadkCoreApplication.isLogin() && this.a) {
                this.i.z();
            } else if (oi.A()) {
                this.j.L(this.g, this.h);
            } else {
                this.i.m();
                qi.N(this.d.getContext(), this.d.getString(R.string.obfuscated_res_0x7f0f0487));
                ArrayList arrayList = new ArrayList();
                s68 s68Var = new s68();
                s68Var.a = this.a;
                arrayList.add(s68Var);
                this.i.l();
                this.i.u(arrayList);
                this.i.x();
            }
        }
    }

    @Override // com.repackage.h78
    public void d(k68 k68Var) {
        NicknameInfo nicknameInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k68Var) == null) {
            if (k68Var != null && k68Var.j() != null && !StringUtils.isNull(this.h)) {
                this.g = k68Var.j().getUserIdLong();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.g)));
                this.a = this.g == og.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            }
            this.i.m();
            g68 g68Var = this.p;
            if (g68Var != null) {
                g68Var.h(k68Var);
            }
            if (k68Var != null) {
                this.i.j(k68Var);
            }
            j68 j68Var = this.m;
            if (j68Var != null) {
                j68Var.n(k68Var);
            } else {
                j68 j68Var2 = new j68(this.c, this, this.f, this.g, this.a);
                this.m = j68Var2;
                j68Var2.j(TbadkCoreApplication.getInst().getSkinType());
                this.m.i(this.o);
                this.m.n(k68Var);
            }
            if (!this.r || k68Var == null || (nicknameInfo = k68Var.A) == null || nicknameInfo.left_days == null || k68Var.j() == null) {
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(k68Var.j().getIsMem());
            personChangeData.setNickNameLeftDays(k68Var.A.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            new e28().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new c(this));
        }
    }

    public boolean j(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || pi.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (ru4.k().h(ru4.o(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.b).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public e68 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (e68) invokeV.objValue;
    }

    public g68 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : (g68) invokeV.objValue;
    }

    public a68 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : (a68) invokeV.objValue;
    }

    public h68 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (h68) invokeV.objValue;
    }

    public k68 o(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (z) {
                this.r = z;
                if (oi.A()) {
                    this.j.L(this.g, this.h);
                }
            }
            return this.j.K();
        }
        return (k68) invokeZ.objValue;
    }

    public PersonPolymericModel p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : (PersonPolymericModel) invokeV.objValue;
    }

    public List<on> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.j.K() == null) {
                return null;
            }
            return this.j.K().k();
        }
        return (List) invokeV.objValue;
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || this.q == i) {
            return;
        }
        j68 j68Var = this.m;
        if (j68Var != null) {
            j68Var.j(i);
        }
        this.q = i;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t);
            j68 j68Var = this.m;
            if (j68Var != null) {
                j68Var.k();
            }
            PersonPolymericModel personPolymericModel = this.j;
            if (personPolymericModel != null) {
                personPolymericModel.destroy();
            }
        }
    }

    public void t(boolean z) {
        j68 j68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (j68Var = this.m) == null) {
            return;
        }
        j68Var.l(z);
    }

    public void u() {
        j68 j68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (j68Var = this.m) == null) {
            return;
        }
        j68Var.m();
    }

    public void v(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, postWriteCallBackData) == null) {
            if (this.n == null) {
                this.n = new s16(this.b.getPageContext(), (NavigationBarCoverTip) this.b.findViewById(R.id.obfuscated_res_0x7f091630));
            }
            this.n.l(postWriteCallBackData);
        }
    }
}
