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
import com.repackage.nr4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class yv4 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wv4 a;
    public WeakReference<xv4> b;
    public TbPageContext c;
    public ty4 d;
    public BdUniqueId e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public lr4 j;
    public boolean k;
    public hm4 l;
    public f m;
    public CustomMessageListener n;
    public CustomMessageListener o;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yv4 yv4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv4Var, Integer.valueOf(i)};
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
            this.a = yv4Var;
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
                sg.a(this.a.j, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yv4 yv4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv4Var, Integer.valueOf(i)};
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
            this.a = yv4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                wv4 wv4Var = this.a.a;
                if (wv4Var == null || StringUtils.isNull(wv4Var.getUserId()) || data == null || !this.a.a.getUserId().equals(data.c)) {
                    return;
                }
                boolean z = (updateAttentionMessage.getOrginalMessage() == null || this.a.e == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(this.a.e)) ? false : true;
                BlockPopInfoData blockPopInfoData = data.l;
                if (blockPopInfoData != null) {
                    String str = blockPopInfoData.appeal_msg;
                    if (blockPopInfoData.appeal_status == 1) {
                        if (TextUtils.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f027f);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0289);
                    }
                    this.a.c.showToast(str);
                } else if (!data.a) {
                    this.a.k = false;
                    String str2 = updateAttentionMessage.getData() != null ? updateAttentionMessage.getData().b : "";
                    if (TextUtils.isEmpty(str2)) {
                        str2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cf2);
                    }
                    BdToast b = BdToast.b(TbadkCoreApplication.getInst().getContext(), str2);
                    b.f(BdToast.ToastIcon.FAILURE);
                    b.c(3000);
                    b.h();
                    xv4 xv4Var = (xv4) this.a.b.get();
                    if (xv4Var == null) {
                        return;
                    }
                    if (z) {
                        xv4Var.c(this.a.a.getIsLike(), this.a.a.getLikeStatus(), z);
                    } else {
                        xv4Var.e(this.a.a.getIsLike(), this.a.a.getLikeStatus());
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
                                this.a.c.showToast(R.string.obfuscated_res_0x7f0f14a9);
                            }
                        } else {
                            this.a.k = false;
                            this.a.s();
                            return;
                        }
                    }
                    this.a.a.setLikeStatus(data.m);
                    this.a.a.setIsLike(data.d);
                    this.a.a.setIsFromNetWork(false);
                    this.a.a.setFansNum(fansNum);
                    this.a.k = false;
                    xv4 xv4Var2 = (xv4) this.a.b.get();
                    if (xv4Var2 != null) {
                        xv4Var2.d(fansNum);
                        if (z) {
                            if (this.a.m != null) {
                                this.a.m.a(data.d);
                            }
                            xv4Var2.c(data.d, data.m, true);
                            return;
                        }
                        xv4Var2.e(data.d, data.m);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements nr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv4 a;

        public c(yv4 yv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yv4Var;
        }

        @Override // com.repackage.nr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xv4 xv4Var = (xv4) this.a.b.get();
                if (xv4Var instanceof View) {
                    this.a.k = true;
                    MessageManager messageManager = MessageManager.getInstance();
                    wv4 wv4Var = this.a.a;
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921560, wv4Var != null ? wv4Var.getUserId() : "0"));
                    this.a.onClick((View) xv4Var);
                }
                sg.a(this.a.j, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements nr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv4 a;

        public d(yv4 yv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yv4Var;
        }

        @Override // com.repackage.nr4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.j == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921560, "0"));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(yv4 yv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv4Var};
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

    /* loaded from: classes7.dex */
    public interface f {
        void a(boolean z);
    }

    public yv4(TbPageContext tbPageContext, xv4 xv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xv4Var};
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
        this.d = new ty4(tbPageContext);
        this.e = this.c.getUniqueId();
        tbPageContext.registerListener(this.o);
        tbPageContext.registerListener(this.n);
        r(xv4Var);
    }

    public wv4 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (wv4) invokeV.objValue;
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

    public void n(wv4 wv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wv4Var) == null) {
            this.a = wv4Var;
            xv4 xv4Var = this.b.get();
            if (xv4Var == null || this.a == null) {
                return;
            }
            xv4Var.e(wv4Var.getIsLike(), wv4Var.getLikeStatus());
            xv4Var.d(wv4Var.getFansNum());
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
        wv4 wv4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            hm4 hm4Var = this.l;
            if (hm4Var == null || !hm4Var.a(view2)) {
                if (!ni.A()) {
                    this.c.showToast(R.string.obfuscated_res_0x7f0f0c2b);
                    return;
                }
                xv4 xv4Var = this.b.get();
                if (xv4Var != null) {
                    xv4Var.a(view2);
                }
                if (!ViewHelper.checkUpIsLogin(this.c.getPageActivity()) || (wv4Var = this.a) == null) {
                    return;
                }
                boolean z = !wv4Var.getIsLike();
                if (this.e == null) {
                    this.d.m(z, this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), this.f, this.c.getUniqueId(), null, "0", this.g);
                } else {
                    this.d.m(z, this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), this.f, this.e, null, "0", this.g);
                }
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.g = str;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.i = z;
        }
    }

    public void r(xv4 xv4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, xv4Var) == null) || xv4Var == null) {
            return;
        }
        this.b = new WeakReference<>(xv4Var);
        xv4Var.b(this);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.j == null) {
                nr4 nr4Var = new nr4(TbadkCoreApplication.getInst().getCurrentActivity());
                nr4Var.q(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0431));
                ArrayList arrayList = new ArrayList();
                jr4 jr4Var = new jr4(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0427), nr4Var);
                jr4Var.m(new c(this));
                arrayList.add(jr4Var);
                nr4Var.m(new d(this));
                nr4Var.j(arrayList);
                lr4 lr4Var = new lr4(UtilHelper.getTbPageContext(TbadkCoreApplication.getInst().getCurrentActivity()), nr4Var);
                this.j = lr4Var;
                lr4Var.l(0.7f);
            }
            this.j.setOnCancelListener(new e(this));
            sg.i(this.j, TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }

    public void t(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.o);
        MessageManager.getInstance().unRegisterListener(this.n);
    }
}
