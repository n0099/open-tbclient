package d.a.p0.s.f0.t;

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
import d.a.d.e.m.g;
import d.a.p0.s.s.h;
import d.a.p0.s.s.j;
import d.a.p0.s.s.l;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.s.f0.t.a f53077e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.s.f0.t.b f53078f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f53079g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.t.e.a f53080h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f53081i;
    public String j;
    public boolean k;
    public boolean l;
    public j m;
    public boolean n;
    public d.a.p0.n.d o;
    public f p;
    public CustomMessageListener q;
    public CustomMessageListener r;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f53082a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f53082a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(this.f53082a.f53077e.getUserId()) && this.f53082a.f53077e.getUserId().equals(str)) {
                    this.f53082a.n = true;
                }
                g.a(this.f53082a.m, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f53083a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f53083a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                d.a.p0.s.f0.t.a aVar = this.f53083a.f53077e;
                if (aVar == null || StringUtils.isNull(aVar.getUserId()) || data == null || !this.f53083a.f53077e.getUserId().equals(data.f12868c)) {
                    return;
                }
                boolean z = (updateAttentionMessage.getOrginalMessage() == null || this.f53083a.f53081i == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(this.f53083a.f53081i)) ? false : true;
                BlockPopInfoData blockPopInfoData = data.l;
                if (blockPopInfoData != null) {
                    String str = blockPopInfoData.appeal_msg;
                    if (blockPopInfoData.appeal_status == 1) {
                        if (TextUtils.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getString(R.string.anti_account_exception_appealing);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        str = TbadkCoreApplication.getInst().getString(R.string.anti_no_chance_com_tip);
                    }
                    this.f53083a.f53079g.showToast(str);
                } else if (!data.f12866a) {
                    this.f53083a.n = false;
                    String str2 = updateAttentionMessage.getData() != null ? updateAttentionMessage.getData().f12867b : "";
                    if (TextUtils.isEmpty(str2)) {
                        str2 = TbadkCoreApplication.getInst().getString(R.string.operation_failed);
                    }
                    BdToast.h(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                    if (this.f53083a.f53078f == null) {
                        return;
                    }
                    if (z) {
                        this.f53083a.f53078f.c(this.f53083a.f53077e.getIsLike(), this.f53083a.f53077e.getLikeStatus(), z);
                    } else {
                        this.f53083a.f53078f.e(this.f53083a.f53077e.getIsLike(), this.f53083a.f53077e.getLikeStatus());
                    }
                } else {
                    int fansNum = this.f53083a.f53077e.getFansNum();
                    boolean isLike = this.f53083a.f53077e.getIsLike();
                    if (data.f12869d && !isLike) {
                        fansNum++;
                    } else if (!data.f12869d && isLike) {
                        if (!this.f53083a.l || this.f53083a.n) {
                            fansNum--;
                            if (!this.f53083a.k) {
                                this.f53083a.f53079g.showToast(R.string.un_attention_success);
                            }
                        } else {
                            this.f53083a.n = false;
                            this.f53083a.r();
                            return;
                        }
                    }
                    this.f53083a.f53077e.setLikeStatus(data.m);
                    this.f53083a.f53077e.setIsLike(data.f12869d);
                    this.f53083a.f53077e.setIsFromNetWork(false);
                    this.f53083a.f53077e.setFansNum(fansNum);
                    this.f53083a.n = false;
                    if (this.f53083a.f53078f != null) {
                        this.f53083a.f53078f.d(fansNum);
                        if (z) {
                            if (this.f53083a.p != null) {
                                this.f53083a.p.a(data.f12869d);
                            }
                            this.f53083a.f53078f.c(data.f12869d, data.m, true);
                            return;
                        }
                        this.f53083a.f53078f.e(data.f12869d, data.m);
                    }
                }
            }
        }
    }

    /* renamed from: d.a.p0.s.f0.t.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1215c implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f53084a;

        public C1215c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53084a = cVar;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f53084a.f53078f instanceof View) {
                    this.f53084a.n = true;
                    MessageManager messageManager = MessageManager.getInstance();
                    d.a.p0.s.f0.t.a aVar = this.f53084a.f53077e;
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921560, aVar != null ? aVar.getUserId() : "0"));
                    c cVar = this.f53084a;
                    cVar.onClick((View) cVar.f53078f);
                }
                g.a(this.f53084a.m, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f53085a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53085a = cVar;
        }

        @Override // d.a.p0.s.s.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f53085a.m == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921560, "0"));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    public c(TbPageContext tbPageContext, d.a.p0.s.f0.t.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = "0";
        this.q = new a(this, 2921560);
        this.r = new b(this, 2001115);
        this.f53079g = tbPageContext;
        this.f53080h = new d.a.p0.t.e.a(tbPageContext);
        this.f53081i = this.f53079g.getUniqueId();
        tbPageContext.registerListener(this.r);
        tbPageContext.registerListener(this.q);
        q(bVar);
    }

    public d.a.p0.s.f0.t.a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53077e : (d.a.p0.s.f0.t.a) invokeV.objValue;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.k = z;
            this.f53080h.j(z);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.f53081i = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(this.r);
        MessageManager.getInstance().unRegisterListener(this.q);
        this.r.setTag(this.f53081i);
        this.q.setTag(this.f53081i);
        MessageManager.getInstance().registerListener(this.r);
        MessageManager.getInstance().registerListener(this.q);
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.j = str;
        }
    }

    public void n(d.a.p0.s.f0.t.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f53077e = aVar;
            d.a.p0.s.f0.t.b bVar = this.f53078f;
            if (bVar == null || aVar == null) {
                return;
            }
            bVar.e(aVar.getIsLike(), aVar.getLikeStatus());
            this.f53078f.d(aVar.getFansNum());
        }
    }

    public void o(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.p = fVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.p0.s.f0.t.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            d.a.p0.n.d dVar = this.o;
            if (dVar == null || !dVar.a(view)) {
                if (!d.a.d.e.p.j.A()) {
                    this.f53079g.showToast(R.string.neterror);
                    return;
                }
                d.a.p0.s.f0.t.b bVar = this.f53078f;
                if (bVar != null) {
                    bVar.a(view);
                }
                if (!ViewHelper.checkUpIsLogin(this.f53079g.getPageActivity()) || (aVar = this.f53077e) == null) {
                    return;
                }
                boolean z = !aVar.getIsLike();
                if (this.f53081i == null) {
                    this.f53080h.m(z, this.f53077e.getPortrait(), this.f53077e.getUserId(), this.f53077e.isGod(), this.j, this.f53079g.getUniqueId(), null, "0");
                } else {
                    this.f53080h.m(z, this.f53077e.getPortrait(), this.f53077e.getUserId(), this.f53077e.isGod(), this.j, this.f53081i, null, "0");
                }
            }
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.l = z;
        }
    }

    public void q(d.a.p0.s.f0.t.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f53078f = bVar;
            if (bVar != null) {
                bVar.b(this);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.m == null) {
                l lVar = new l(TbadkCoreApplication.getInst().getCurrentActivity());
                lVar.q(TbadkCoreApplication.getInst().getString(R.string.confirm_unlike));
                ArrayList arrayList = new ArrayList();
                h hVar = new h(TbadkCoreApplication.getInst().getString(R.string.confirm), lVar);
                hVar.m(new C1215c(this));
                arrayList.add(hVar);
                lVar.m(new d(this));
                lVar.k(arrayList);
                j jVar = new j(UtilHelper.getTbPageContext(TbadkCoreApplication.getInst().getCurrentActivity()), lVar);
                this.m = jVar;
                jVar.k(0.7f);
            }
            this.m.setOnCancelListener(new e(this));
            g.i(this.m, TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.r);
        MessageManager.getInstance().unRegisterListener(this.q);
    }
}
