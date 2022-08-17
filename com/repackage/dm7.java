package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailDataList;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsNetMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class dm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public boolean b;
    public List<TailData> c;
    public pm7<Void> d;
    public pm7<Integer> e;
    public ab f;
    public ab g;
    public CustomMessageListener h;

    /* loaded from: classes6.dex */
    public class a extends ab {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dm7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dm7 dm7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dm7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = dm7Var;
        }

        @Override // com.repackage.ab
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            pl7 resultData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.a.d == null) {
                return;
            }
            if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                resultData = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
            } else {
                resultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).getResultData() : null;
            }
            if (resultData != null) {
                this.a.c = resultData.b();
            }
            this.a.d.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ab {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dm7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(dm7 dm7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dm7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = dm7Var;
        }

        @Override // com.repackage.ab
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            ol7 resultData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.a.e == null) {
                return;
            }
            if (responsedMessage instanceof DeleteTailHttpResponseMessage) {
                resultData = ((DeleteTailHttpResponseMessage) responsedMessage).getResultData();
            } else {
                resultData = responsedMessage instanceof DeleteTailSocketResponseMessage ? ((DeleteTailSocketResponseMessage) responsedMessage).getResultData() : null;
            }
            this.a.e.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dm7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(dm7 dm7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dm7Var, Integer.valueOf(i)};
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
            this.a = dm7Var;
        }

        public final void a(ql7 ql7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ql7Var) == null) {
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= this.a.c.size()) {
                        break;
                    } else if (((TailData) this.a.c.get(i)).getId() == ql7Var.b.getId()) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return;
                }
                this.a.c.add(ql7Var.b);
            }
        }

        public final void b(ql7 ql7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ql7Var) == null) {
                boolean z = false;
                for (int i = 0; i < this.a.c.size(); i++) {
                    if (((TailData) this.a.c.get(i)).getId() == ql7Var.b.getId()) {
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

        public final void c(ql7 ql7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ql7Var) == null) {
                for (int i = 0; i < this.a.c.size(); i++) {
                    if (((TailData) this.a.c.get(i)).getId() == ql7Var.b.getId()) {
                        ((TailData) this.a.c.get(i)).setContent(ql7Var.b.getContent());
                        ((TailData) this.a.c.get(i)).setFontColor(ql7Var.b.getFontColor());
                        ((TailData) this.a.c.get(i)).setSelected(ql7Var.b.isSelected());
                        return;
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ql7) || this.a.d == null) {
                return;
            }
            ql7 ql7Var = (ql7) customResponsedMessage.getData();
            if (ql7Var.b == null || this.a.c == null) {
                return;
            }
            int i = ql7Var.a;
            if (i == 1) {
                a(ql7Var);
            } else if (i == 3) {
                b(ql7Var);
            } else if (i == 2) {
                c(ql7Var);
            }
            this.a.d.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
        }
    }

    public dm7(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.f = new a(this, CmdConfigHttp.CMD_TAIL_GET, 305001);
        this.g = new b(this, CmdConfigHttp.CMD_TAIL_DELETE, 305103);
        this.h = new c(this, 2001340);
        this.a = tbPageContext;
        this.c = new ArrayList();
        this.a.registerListener(this.f);
        this.a.registerListener(this.g);
        this.a.registerListener(this.h);
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.a.sendMessage(new DeleteTailNetMessage(i));
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? 3 - this.c.size() : invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public List<TailData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public boolean i(Serializable serializable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, serializable)) == null) {
            if (serializable != null && (serializable instanceof TailDataList)) {
                this.c = ((TailDataList) serializable).getTails();
                return true;
            }
            j();
            return false;
        }
        return invokeL.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.sendMessage(new GetTailsNetMessage("stat"));
        }
    }

    public void k(pm7<Integer> pm7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pm7Var) == null) {
            this.e = pm7Var;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.b = z;
        }
    }

    public void m(pm7<Void> pm7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pm7Var) == null) {
            this.d = pm7Var;
        }
    }

    public void n(List<TailData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            if (list == null) {
                this.c.clear();
            } else {
                this.c = list;
            }
        }
    }
}
