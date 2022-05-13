package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.repackage.uy4;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g77 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g77 c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ImMessageCenterPojo> a;
    public final CustomMessageListener b;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g77 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g77 g77Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g77Var, Integer.valueOf(i)};
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
            this.a = g77Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                this.a.t(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.s(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.u(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                if (this.a.a != null) {
                    this.a.a.clear();
                }
                ky4.h0().g0(new uy4());
                ky4.h0().c0(0);
                ky4.h0().a();
                ky4.h0().l();
            } else if (customResponsedMessage.getCmd() != 2016010 || this.a.a == null) {
            } else {
                this.a.v(false);
            }
        }
    }

    public g77() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList();
        this.b = new a(this, 0);
        w();
    }

    public static g77 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (c == null) {
                synchronized (g77.class) {
                    if (c == null) {
                        c = new g77();
                    }
                }
            }
            return c;
        }
        return (g77) invokeV.objValue;
    }

    public final boolean f(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final void g(ImMessageCenterPojo imMessageCenterPojo, uy4 uy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterPojo, uy4Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && r77.a().b()) {
            uy4Var.T(imMessageCenterPojo.getUnread_count());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(ImMessageCenterPojo imMessageCenterPojo, uy4 uy4Var) {
        int userType;
        String str;
        String str2;
        String str3;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo, uy4Var) == null) || imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != 4 || !s77.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) || StringUtils.isNull(imMessageCenterPojo.getLast_content()) || imMessageCenterPojo.getUnread_count() <= 0 || (userType = imMessageCenterPojo.getUserType()) == 3) {
            return;
        }
        uy4.a aVar = new uy4.a();
        aVar.a = imMessageCenterPojo.getGid();
        aVar.e = imMessageCenterPojo.getGroup_name();
        if (userType == 4) {
            String str4 = null;
            try {
                jSONArray = new JSONArray(imMessageCenterPojo.getLastContentRawData());
            } catch (Exception e) {
                e = e;
                str = null;
                str2 = null;
            }
            if (jSONArray.length() == 1) {
                JSONObject jSONObject = jSONArray.getJSONObject(0);
                str = jSONObject.optString("title", null);
                try {
                    str2 = jSONObject.optString("text", null);
                } catch (Exception e2) {
                    e = e2;
                    str2 = null;
                }
                try {
                    str3 = jSONObject.optString(UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, null);
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e, true);
                    str3 = null;
                    str4 = str;
                    if (str2 == null) {
                    }
                    if (str4 == null) {
                    }
                    aVar.b = str4;
                    aVar.c = str2;
                    aVar.i = str3;
                    aVar.d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
                    aVar.f = userType;
                    aVar.g = imMessageCenterPojo.getUnread_count();
                    uy4Var.g().add(aVar);
                    if (userType == 4) {
                    }
                    uy4Var.U(uy4Var.u() + imMessageCenterPojo.getUnread_count());
                }
                str4 = str;
                if (str2 == null) {
                    str4 = imMessageCenterPojo.getGroup_name();
                    str2 = imMessageCenterPojo.getLast_content();
                }
                if (str4 == null) {
                    str4 = imMessageCenterPojo.getGroup_name();
                }
                aVar.b = str4;
                aVar.c = str2;
                aVar.i = str3;
                aVar.d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
            } else {
                str3 = null;
                str2 = null;
                if (str2 == null) {
                }
                if (str4 == null) {
                }
                aVar.b = str4;
                aVar.c = str2;
                aVar.i = str3;
                aVar.d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
            }
        } else {
            String str5 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f03cc, imMessageCenterPojo.getGroup_name()) + ZeusCrashHandler.NAME_SEPERATOR + imMessageCenterPojo.getLast_content();
            aVar.c = str5;
            aVar.d = str5;
        }
        aVar.f = userType;
        aVar.g = imMessageCenterPojo.getUnread_count();
        uy4Var.g().add(aVar);
        if (userType == 4) {
            uy4Var.S(uy4Var.s() + imMessageCenterPojo.getUnread_count());
        }
        uy4Var.U(uy4Var.u() + imMessageCenterPojo.getUnread_count());
    }

    public final void i(ImMessageCenterPojo imMessageCenterPojo, uy4 uy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, imMessageCenterPojo, uy4Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && t77.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                uy4Var.H(imMessageCenterPojo.getLast_content());
                String nameShow = imMessageCenterPojo.getNameShow();
                HashMap<String, String> h = uy4Var.h();
                if (h != null) {
                    h.put(imMessageCenterPojo.getGid(), nameShow);
                }
            }
            uy4Var.W(uy4Var.w() + imMessageCenterPojo.getUnread_count());
        }
    }

    public final void j(ImMessageCenterPojo imMessageCenterPojo, uy4 uy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, imMessageCenterPojo, uy4Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && u77.a().b()) {
            uy4Var.Y(imMessageCenterPojo.getUnread_count());
        }
    }

    public final void k(ImMessageCenterPojo imMessageCenterPojo, uy4 uy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, imMessageCenterPojo, uy4Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            uy4Var.B(imMessageCenterPojo.getGroup_name());
            uy4Var.G(imMessageCenterPojo.getLast_content());
            uy4Var.O(imMessageCenterPojo.getUnread_count());
        }
    }

    public final void l(ImMessageCenterPojo imMessageCenterPojo, uy4 uy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, imMessageCenterPojo, uy4Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            uy4Var.Q(imMessageCenterPojo.getUnread_count());
            uy4Var.I(imMessageCenterPojo.getLast_content());
            uy4Var.C(imMessageCenterPojo.getGroup_name());
        }
    }

    public final void m(ImMessageCenterPojo imMessageCenterPojo, uy4 uy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, imMessageCenterPojo, uy4Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> a2 = uy4Var.a();
            if (!q77.k().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                uy4Var.M(uy4Var.l() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    uy4Var.F(imMessageCenterPojo.getLast_content());
                } else {
                    uy4Var.F(imMessageCenterPojo.getLast_user_name() + ":" + imMessageCenterPojo.getLast_content());
                }
                a2.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            uy4Var.L(uy4Var.j() + imMessageCenterPojo.getUnread_count());
        }
    }

    public final void n(List<uy4.a> list, List<uy4.a> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, list2) == null) || list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return;
        }
        for (uy4.a aVar : list) {
            if (aVar != null) {
                for (uy4.a aVar2 : list2) {
                    if (aVar2 != null && StringHelper.equals(aVar.a, aVar2.a)) {
                        aVar.h = aVar2.g;
                    }
                }
            }
        }
    }

    public final void p(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, imMessageCenterPojo, list) == null) || imMessageCenterPojo == null || list == null) {
            return;
        }
        x(imMessageCenterPojo, list);
        list.add(imMessageCenterPojo);
    }

    public final boolean q(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                return f(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                return f(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -8) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                return f(imMessageCenterPojo);
            }
            return imMessageCenterPojo.getCustomGroupType() == -7;
        }
        return invokeL.booleanValue;
    }

    public final boolean r(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
                return t77.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            }
            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                return false;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                return s77.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            }
            if (imMessageCenterPojo.getCustomGroupType() != -3) {
                imMessageCenterPojo.getCustomGroupType();
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void s(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage)) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            boolean r = r(data);
            if (memoryChangedMessage.getType() == 1) {
                p(data, this.a);
            } else if (memoryChangedMessage.getType() == 2) {
                x(data, this.a);
            }
            v(r);
        }
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void u(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1) {
                this.a.clear();
                for (ImMessageCenterPojo imMessageCenterPojo : data) {
                    if (q(imMessageCenterPojo)) {
                        this.a.add(imMessageCenterPojo);
                    }
                }
            }
        }
    }

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            uy4 uy4Var = new uy4();
            uy4Var.K(z);
            y(uy4Var);
            uy4Var.D();
            uy4Var.E();
            uy4Var.X(ky4.h0().F().w());
            uy4Var.N(ky4.h0().F().k());
            uy4Var.V(ky4.h0().F().u());
            uy4Var.R(ky4.h0().F().q());
            uy4Var.P(ky4.h0().F().n());
            n(uy4Var.g(), ky4.h0().F().g());
            if (!my4.d().r()) {
                uy4Var.L(0);
            }
            if (!my4.d().t()) {
                uy4Var.W(0);
            }
            if (!my4.d().n()) {
                uy4Var.U(0);
                uy4Var.T(0);
                uy4Var.S(0);
            }
            if (my4.d().f() <= 0) {
                uy4Var.L(0);
                uy4Var.W(0);
                uy4Var.T(0);
                uy4Var.U(0);
                uy4Var.S(0);
                uy4Var.Y(0);
                uy4Var.K(false);
            }
            if ((((((uy4Var.w() + uy4Var.j()) + uy4Var.n()) + uy4Var.q()) + uy4Var.t()) + uy4Var.u()) - uy4Var.l() <= 0) {
                uy4Var.K(false);
            }
            ky4.h0().W(uy4Var);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MessageManager.getInstance().registerListener(2016004, this.b);
            MessageManager.getInstance().registerListener(2016007, this.b);
            MessageManager.getInstance().registerListener(2016001, this.b);
            MessageManager.getInstance().registerListener(2016010, this.b);
            MessageManager.getInstance().registerListener(2016002, this.b);
        }
    }

    public final void x(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, imMessageCenterPojo, list) == null) || imMessageCenterPojo == null || list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo2 = list.get(i);
            if (imMessageCenterPojo2 != null && imMessageCenterPojo2.getGid().equals(imMessageCenterPojo.getGid()) && imMessageCenterPojo2.getCustomGroupType() == imMessageCenterPojo.getCustomGroupType()) {
                list.remove(i);
                return;
            }
        }
    }

    public final void y(uy4 uy4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, uy4Var) == null) || uy4Var == null) {
            return;
        }
        for (ImMessageCenterPojo imMessageCenterPojo : this.a) {
            if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && q(imMessageCenterPojo)) {
                m(imMessageCenterPojo, uy4Var);
                h(imMessageCenterPojo, uy4Var);
                i(imMessageCenterPojo, uy4Var);
                l(imMessageCenterPojo, uy4Var);
                k(imMessageCenterPojo, uy4Var);
                g(imMessageCenterPojo, uy4Var);
                j(imMessageCenterPojo, uy4Var);
            }
        }
    }
}
