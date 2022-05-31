package com.repackage;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.MemeDiyEnableSwitch;
import com.baidu.tieba.faceshop.DiyEmotionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i05;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class y66 extends i05 {
    public static /* synthetic */ Interceptable $ic;
    public static y66 c;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<l05> a;
    public final CustomMessageListener b;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y66 a;

        /* renamed from: com.repackage.y66$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0565a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0565a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.g();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y66 y66Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y66Var, Integer.valueOf(i)};
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
            this.a = y66Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.d();
                new Thread(new RunnableC0565a(this)).start();
            }
        }
    }

    public y66() {
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
        this.b = new a(this, 2005016);
        MessageManager.getInstance().registerListener(this.b);
    }

    public static y66 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (y66.class) {
                    if (c == null) {
                        c = new y66();
                    }
                }
            }
            return c;
        }
        return (y66) invokeV.objValue;
    }

    @Override // com.repackage.i05
    public void b(i05.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && FileHelper.checkSD() && MemeDiyEnableSwitch.isOn()) {
            LinkedList<l05> linkedList = this.a;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator<l05> it = this.a.iterator();
                while (it.hasNext()) {
                    l05 next = it.next();
                    if (aVar != null) {
                        aVar.a(next);
                    }
                }
                return;
            }
            this.a = new LinkedList<>();
            x66 x66Var = new x66();
            this.a.add(x66Var);
            if (aVar != null) {
                aVar.a(x66Var);
            }
        }
    }

    @Override // com.repackage.i05
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.i05
    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        List<DiyEmotionData> r = b76.o().r(TbadkCoreApplication.getCurrentAccount());
        if (r != null && r.size() != 0) {
            int size = (r == null || r.size() == 0) ? 0 : r.size() - 1;
            StatisticItem statisticItem = new StatisticItem("c12224");
            statisticItem.param("obj_param1", size);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            return;
        }
        DiyEmotionData diyEmotionData = new DiyEmotionData();
        diyEmotionData.setPid("setting_icon");
        diyEmotionData.orderId = 301;
        diyEmotionData.setSharpText("#(meme,diysetting)");
        diyEmotionData.setUid(TbadkCoreApplication.getCurrentAccount());
        b76.o().c(diyEmotionData);
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            LinkedList<l05> linkedList = this.a;
            if (linkedList == null) {
                return false;
            }
            Iterator<l05> it = linkedList.iterator();
            while (it.hasNext()) {
                l05 next = it.next();
                if (next instanceof x66) {
                    return ((x66) next).w(str);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.a == null) {
                    return;
                }
                Iterator<l05> it = this.a.iterator();
                while (it.hasNext()) {
                    l05 next = it.next();
                    if (next instanceof x66) {
                        ((x66) next).y();
                    }
                }
            }
        }
    }
}
