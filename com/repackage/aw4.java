package com.repackage;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yr4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class aw4 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yv4 a;
    public WeakReference<zv4> b;
    public TbPageContext c;
    public py4 d;
    public BdUniqueId e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public wr4 j;
    public boolean k;
    public tm4 l;
    public f m;
    public CustomMessageListener n;
    public CustomMessageListener o;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(aw4 aw4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw4Var, Integer.valueOf(i)};
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
            this.a = aw4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(this.a.a.getUserId()) && this.a.a.getUserId().equals(str)) {
                    this.a.k = true;
                }
                pg.a(this.a.j, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(aw4 aw4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw4Var, Integer.valueOf(i)};
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
            this.a = aw4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                yv4 yv4Var = this.a.a;
                if (yv4Var == null || StringUtils.isNull(yv4Var.getUserId()) || data == null || !this.a.a.getUserId().equals(data.c)) {
                    return;
                }
                boolean z = (updateAttentionMessage.getOrginalMessage() == null || this.a.e == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(this.a.e)) ? false : true;
                BlockPopInfoData blockPopInfoData = data.l;
                if (blockPopInfoData != null) {
                    String str = blockPopInfoData.appeal_msg;
                    if (blockPopInfoData.appeal_status == 1) {
                        if (TextUtils.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f027a);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0284);
                    }
                    this.a.c.showToast(str);
                } else if (!data.a) {
                    this.a.k = false;
                    String str2 = updateAttentionMessage.getData() != null ? updateAttentionMessage.getData().b : "";
                    if (TextUtils.isEmpty(str2)) {
                        str2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cf5);
                    }
                    BdToast.h(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.obfuscated_res_0x7f0809be, 3000, true).q();
                    zv4 zv4Var = (zv4) this.a.b.get();
                    if (zv4Var == null) {
                        return;
                    }
                    if (z) {
                        zv4Var.c(this.a.a.getIsLike(), this.a.a.getLikeStatus(), z);
                    } else {
                        zv4Var.e(this.a.a.getIsLike(), this.a.a.getLikeStatus());
                    }
                } else {
                    int fansNum = this.a.a.getFansNum();
                    boolean isLike = this.a.a.getIsLike();
                    if (data.d && !isLike) {
                        fansNum++;
                    } else if (!data.d && isLike) {
                        if (!this.a.i || this.a.k) {
                            fansNum--;
                            if (!this.a.h) {
                                this.a.c.showToast(R.string.obfuscated_res_0x7f0f148e);
                            }
                        } else {
                            this.a.k = false;
                            this.a.t();
                            return;
                        }
                    }
                    this.a.a.setLikeStatus(data.m);
                    this.a.a.setIsLike(data.d);
                    this.a.a.setIsFromNetWork(false);
                    this.a.a.setFansNum(fansNum);
                    this.a.k = false;
                    zv4 zv4Var2 = (zv4) this.a.b.get();
                    if (zv4Var2 != null) {
                        zv4Var2.d(fansNum);
                        if (z) {
                            if (this.a.m != null) {
                                this.a.m.a(data.d);
                            }
                            zv4Var2.c(data.d, data.m, true);
                            return;
                        }
                        zv4Var2.e(data.d, data.m);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements yr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw4 a;

        public c(aw4 aw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw4Var;
        }

        @Override // com.repackage.yr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zv4 zv4Var = (zv4) this.a.b.get();
                if (zv4Var instanceof View) {
                    this.a.k = true;
                    MessageManager messageManager = MessageManager.getInstance();
                    yv4 yv4Var = this.a.a;
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921560, yv4Var != null ? yv4Var.getUserId() : "0"));
                    this.a.onClick((View) zv4Var);
                }
                pg.a(this.a.j, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements yr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw4 a;

        public d(aw4 aw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw4Var;
        }

        @Override // com.repackage.yr4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.j == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921560, "0"));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(aw4 aw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921560, "0"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(boolean z);
    }

    public aw4(TbPageContext tbPageContext, zv4 zv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, zv4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new WeakReference<>(null);
        this.f = "0";
        this.n = new a(this, 2921560);
        this.o = new b(this, 2001115);
        this.c = tbPageContext;
        this.d = new py4(tbPageContext);
        this.e = this.c.getUniqueId();
        tbPageContext.registerListener(this.o);
        tbPageContext.registerListener(this.n);
        s(zv4Var);
    }

    public yv4 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (yv4) invokeV.objValue;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.h = z;
            this.d.i(z);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.e = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(this.o);
        MessageManager.getInstance().unRegisterListener(this.n);
        this.o.setTag(this.e);
        this.n.setTag(this.e);
        MessageManager.getInstance().registerListener(this.o);
        MessageManager.getInstance().registerListener(this.n);
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f = str;
        }
    }

    public void n(yv4 yv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yv4Var) == null) {
            this.a = yv4Var;
            zv4 zv4Var = this.b.get();
            if (zv4Var == null || this.a == null) {
                return;
            }
            zv4Var.e(yv4Var.getIsLike(), yv4Var.getLikeStatus());
            zv4Var.d(yv4Var.getFansNum());
        }
    }

    public void o(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.m = fVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        yv4 yv4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            tm4 tm4Var = this.l;
            if (tm4Var == null || !tm4Var.a(view2)) {
                if (!ki.A()) {
                    this.c.showToast(R.string.obfuscated_res_0x7f0f0c2d);
                    return;
                }
                zv4 zv4Var = this.b.get();
                if (zv4Var != null) {
                    zv4Var.a(view2);
                }
                if (!ViewHelper.checkUpIsLogin(this.c.getPageActivity()) || (yv4Var = this.a) == null) {
                    return;
                }
                boolean z = !yv4Var.getIsLike();
                if (this.e == null) {
                    this.d.m(z, this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), this.f, this.c.getUniqueId(), null, "0", this.g);
                } else {
                    this.d.m(z, this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), this.f, this.e, null, "0", this.g);
                }
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.g = str;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.i = z;
        }
    }

    public void s(zv4 zv4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, zv4Var) == null) || zv4Var == null) {
            return;
        }
        this.b = new WeakReference<>(zv4Var);
        zv4Var.b(this);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.j == null) {
                yr4 yr4Var = new yr4(TbadkCoreApplication.getInst().getCurrentActivity());
                yr4Var.q(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0432));
                ArrayList arrayList = new ArrayList();
                ur4 ur4Var = new ur4(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0428), yr4Var);
                ur4Var.m(new c(this));
                arrayList.add(ur4Var);
                yr4Var.m(new d(this));
                yr4Var.j(arrayList);
                wr4 wr4Var = new wr4(UtilHelper.getTbPageContext(TbadkCoreApplication.getInst().getCurrentActivity()), yr4Var);
                this.j = wr4Var;
                wr4Var.l(0.7f);
            }
            this.j.setOnCancelListener(new e(this));
            pg.i(this.j, TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }

    public void u(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.o);
        MessageManager.getInstance().unRegisterListener(this.n);
    }
}
