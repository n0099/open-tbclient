package com.repackage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.message.GetTailsHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsNetMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class qi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public si7<Void> a;
    public si7<Integer> b;
    public List<TailData> c;
    public Boolean d;
    public boolean e;
    public wa f;
    public wa g;
    public CustomMessageListener h;

    /* loaded from: classes6.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qi7 qi7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qi7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qi7Var;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            sh7 resultData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.a.a == null) {
                return;
            }
            if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                resultData = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
            } else {
                resultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).getResultData() : null;
            }
            if (resultData == null) {
                return;
            }
            this.a.c = new ArrayList();
            if (resultData.b() != null) {
                for (TailData tailData : resultData.b()) {
                    TailData tailData2 = new TailData();
                    tailData2.setId(tailData.getId());
                    tailData2.setContent(tailData.getContent());
                    tailData2.setFontColor(tailData.getFontColor());
                    tailData2.setFontType(tailData.getFontType());
                    tailData2.setSelected(tailData.isSelected());
                    this.a.c.add(tailData2);
                }
            }
            this.a.a.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
            this.a.q();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qi7 qi7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qi7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qi7Var;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            uh7 resultData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.a.a == null) {
                return;
            }
            if (responsedMessage instanceof SetTailHttpResponseMessage) {
                resultData = ((SetTailHttpResponseMessage) responsedMessage).getResultData();
            } else {
                resultData = responsedMessage instanceof SetTailSocketResponseMessage ? ((SetTailSocketResponseMessage) responsedMessage).getResultData() : null;
            }
            this.a.b.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(qi7 qi7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qi7Var, Integer.valueOf(i)};
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
            this.a = qi7Var;
        }

        public final void a(th7 th7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th7Var) == null) {
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= this.a.c.size()) {
                        break;
                    } else if (((TailData) this.a.c.get(i)).getId() == th7Var.b.getId()) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return;
                }
                this.a.c.add(th7Var.b);
            }
        }

        public final void b(th7 th7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th7Var) == null) {
                boolean z = false;
                for (int i = 0; i < this.a.c.size(); i++) {
                    if (((TailData) this.a.c.get(i)).getId() == th7Var.b.getId()) {
                        this.a.c.remove(i);
                        if (this.a.c.size() != 0) {
                            Iterator it = this.a.c.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (((TailData) it.next()).isSelected()) {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001344, Boolean.valueOf(z)));
                        return;
                    }
                }
            }
        }

        public final void c(th7 th7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th7Var) == null) {
                for (int i = 0; i < this.a.c.size(); i++) {
                    if (((TailData) this.a.c.get(i)).getId() == th7Var.b.getId()) {
                        ((TailData) this.a.c.get(i)).setContent(th7Var.b.getContent());
                        ((TailData) this.a.c.get(i)).setFontColor(th7Var.b.getFontColor());
                        ((TailData) this.a.c.get(i)).setSelected(th7Var.b.isSelected());
                        return;
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof th7)) {
                return;
            }
            th7 th7Var = (th7) customResponsedMessage.getData();
            if (th7Var.b == null || this.a.c == null) {
                return;
            }
            int i = th7Var.a;
            if (i == 1) {
                a(th7Var);
            } else if (i == 3) {
                b(th7Var);
            } else if (i == 2) {
                c(th7Var);
            }
            this.a.a.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
        }
    }

    public qi7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = Boolean.FALSE;
        this.e = false;
        this.f = new a(this, CmdConfigHttp.CMD_TAIL_GET, 305001);
        this.g = new b(this, CmdConfigHttp.CMD_TAIL_SET, 305104);
        this.h = new c(this, 2001340);
        this.c = new ArrayList();
        f();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d = Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() != 0);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d.booleanValue() : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public List<TailData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().sendMessage(new GetTailsNetMessage("stat"));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().registerListener(this.f);
            MessageManager.getInstance().registerListener(this.g);
            MessageManager.getInstance().registerListener(this.h);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterListener(this.g);
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.e = z;
        }
    }

    public void n(si7<Integer> si7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, si7Var) == null) {
            this.b = si7Var;
        }
    }

    public void o(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            MessageManager.getInstance().sendMessage(new SetTailNetMessage(i, z ? 1 : 0));
        }
    }

    public void p(si7<Void> si7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, si7Var) == null) {
            this.a = si7Var;
        }
    }

    public final void q() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Iterator<TailData> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().isSelected()) {
                    z = true;
                    break;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001344, Boolean.valueOf(z)));
        }
    }
}
