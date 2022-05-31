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
import com.repackage.nx4;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f57 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f57 c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ImMessageCenterPojo> a;
    public final CustomMessageListener b;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f57 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f57 f57Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f57Var, Integer.valueOf(i)};
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
            this.a = f57Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                this.a.s(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.r(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.t(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                if (this.a.a != null) {
                    this.a.a.clear();
                }
                cx4.f0().e0(new nx4());
                cx4.f0().a0(0);
                cx4.f0().a();
                cx4.f0().k();
            } else if (customResponsedMessage.getCmd() != 2016010 || this.a.a == null) {
            } else {
                this.a.u(false);
            }
        }
    }

    public f57() {
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
        v();
    }

    public static f57 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (c == null) {
                synchronized (f57.class) {
                    if (c == null) {
                        c = new f57();
                    }
                }
            }
            return c;
        }
        return (f57) invokeV.objValue;
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

    public final void g(ImMessageCenterPojo imMessageCenterPojo, nx4 nx4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterPojo, nx4Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && p57.a().b()) {
            nx4Var.Q(imMessageCenterPojo.getUnread_count());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(ImMessageCenterPojo imMessageCenterPojo, nx4 nx4Var) {
        int userType;
        String str;
        String str2;
        String str3;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo, nx4Var) == null) || imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != 4 || !q57.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) || StringUtils.isNull(imMessageCenterPojo.getLast_content()) || imMessageCenterPojo.getUnread_count() <= 0 || (userType = imMessageCenterPojo.getUserType()) == 3) {
            return;
        }
        nx4.a aVar = new nx4.a();
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
                    nx4Var.g().add(aVar);
                    if (userType == 4) {
                    }
                    nx4Var.R(nx4Var.u() + imMessageCenterPojo.getUnread_count());
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
            String str5 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f03cf, imMessageCenterPojo.getGroup_name()) + ZeusCrashHandler.NAME_SEPERATOR + imMessageCenterPojo.getLast_content();
            aVar.c = str5;
            aVar.d = str5;
        }
        aVar.f = userType;
        aVar.g = imMessageCenterPojo.getUnread_count();
        nx4Var.g().add(aVar);
        if (userType == 4) {
            nx4Var.P(nx4Var.s() + imMessageCenterPojo.getUnread_count());
        }
        nx4Var.R(nx4Var.u() + imMessageCenterPojo.getUnread_count());
    }

    public final void i(ImMessageCenterPojo imMessageCenterPojo, nx4 nx4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, imMessageCenterPojo, nx4Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && r57.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                nx4Var.F(imMessageCenterPojo.getLast_content());
                String nameShow = imMessageCenterPojo.getNameShow();
                HashMap<String, String> h = nx4Var.h();
                if (h != null) {
                    h.put(imMessageCenterPojo.getGid(), nameShow);
                }
            }
            nx4Var.T(nx4Var.w() + imMessageCenterPojo.getUnread_count());
        }
    }

    public final void j(ImMessageCenterPojo imMessageCenterPojo, nx4 nx4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, imMessageCenterPojo, nx4Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && s57.a().b()) {
            nx4Var.V(imMessageCenterPojo.getUnread_count());
        }
    }

    public final void k(ImMessageCenterPojo imMessageCenterPojo, nx4 nx4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, imMessageCenterPojo, nx4Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            nx4Var.N(imMessageCenterPojo.getUnread_count());
            nx4Var.G(imMessageCenterPojo.getLast_content());
            nx4Var.B(imMessageCenterPojo.getGroup_name());
        }
    }

    public final void l(ImMessageCenterPojo imMessageCenterPojo, nx4 nx4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, imMessageCenterPojo, nx4Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> a2 = nx4Var.a();
            if (!o57.k().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                nx4Var.K(nx4Var.l() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    nx4Var.E(imMessageCenterPojo.getLast_content());
                } else {
                    nx4Var.E(imMessageCenterPojo.getLast_user_name() + ":" + imMessageCenterPojo.getLast_content());
                }
                a2.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            nx4Var.J(nx4Var.j() + imMessageCenterPojo.getUnread_count());
        }
    }

    public final void m(List<nx4.a> list, List<nx4.a> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) || list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return;
        }
        for (nx4.a aVar : list) {
            if (aVar != null) {
                for (nx4.a aVar2 : list2) {
                    if (aVar2 != null && StringHelper.equals(aVar.a, aVar2.a)) {
                        aVar.h = aVar2.g;
                    }
                }
            }
        }
    }

    public final void o(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imMessageCenterPojo, list) == null) || imMessageCenterPojo == null || list == null) {
            return;
        }
        w(imMessageCenterPojo, list);
        list.add(imMessageCenterPojo);
    }

    public final boolean p(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                return f(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -4) {
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

    public final boolean q(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
                return r57.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            }
            if (imMessageCenterPojo.getCustomGroupType() != 1 && imMessageCenterPojo.getCustomGroupType() == 4) {
                return q57.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void r(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage)) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            boolean q = q(data);
            if (memoryChangedMessage.getType() == 1) {
                o(data, this.a);
            } else if (memoryChangedMessage.getType() == 2) {
                w(data, this.a);
            }
            u(q);
        }
    }

    public final void s(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1) {
                this.a.clear();
                for (ImMessageCenterPojo imMessageCenterPojo : data) {
                    if (p(imMessageCenterPojo)) {
                        this.a.add(imMessageCenterPojo);
                    }
                }
            }
        }
    }

    public final void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            nx4 nx4Var = new nx4();
            nx4Var.I(z);
            x(nx4Var);
            nx4Var.C();
            nx4Var.D();
            nx4Var.U(cx4.f0().D().w());
            nx4Var.L(cx4.f0().D().k());
            nx4Var.S(cx4.f0().D().u());
            nx4Var.O(cx4.f0().D().q());
            nx4Var.M(cx4.f0().D().n());
            m(nx4Var.g(), cx4.f0().D().g());
            if (!ex4.d().r()) {
                nx4Var.J(0);
            }
            if (!ex4.d().t()) {
                nx4Var.T(0);
            }
            if (!ex4.d().n()) {
                nx4Var.R(0);
                nx4Var.Q(0);
                nx4Var.P(0);
            }
            if (ex4.d().f() <= 0) {
                nx4Var.J(0);
                nx4Var.T(0);
                nx4Var.Q(0);
                nx4Var.R(0);
                nx4Var.P(0);
                nx4Var.V(0);
                nx4Var.I(false);
            }
            if ((((((nx4Var.w() + nx4Var.j()) + nx4Var.n()) + nx4Var.q()) + nx4Var.t()) + nx4Var.u()) - nx4Var.l() <= 0) {
                nx4Var.I(false);
            }
            cx4.f0().U(nx4Var);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageManager.getInstance().registerListener(2016004, this.b);
            MessageManager.getInstance().registerListener(2016007, this.b);
            MessageManager.getInstance().registerListener(2016001, this.b);
            MessageManager.getInstance().registerListener(2016010, this.b);
            MessageManager.getInstance().registerListener(2016002, this.b);
        }
    }

    public final void w(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, imMessageCenterPojo, list) == null) || imMessageCenterPojo == null || list == null) {
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

    public final void x(nx4 nx4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, nx4Var) == null) || nx4Var == null) {
            return;
        }
        for (ImMessageCenterPojo imMessageCenterPojo : this.a) {
            if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && p(imMessageCenterPojo)) {
                l(imMessageCenterPojo, nx4Var);
                h(imMessageCenterPojo, nx4Var);
                i(imMessageCenterPojo, nx4Var);
                k(imMessageCenterPojo, nx4Var);
                g(imMessageCenterPojo, nx4Var);
                j(imMessageCenterPojo, nx4Var);
            }
        }
    }
}
