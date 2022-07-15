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
import com.repackage.y15;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class v86 extends y15 {
    public static /* synthetic */ Interceptable $ic;
    public static v86 c;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<b25> a;
    public final CustomMessageListener b;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;

        /* renamed from: com.repackage.v86$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0745a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0745a(a aVar) {
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
        public a(v86 v86Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v86Var, Integer.valueOf(i)};
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
            this.a = v86Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.d();
                new Thread(new RunnableC0745a(this)).start();
            }
        }
    }

    public v86() {
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

    public static v86 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (v86.class) {
                    if (c == null) {
                        c = new v86();
                    }
                }
            }
            return c;
        }
        return (v86) invokeV.objValue;
    }

    @Override // com.repackage.y15
    public void b(y15.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && FileHelper.checkSD() && MemeDiyEnableSwitch.isOn()) {
            LinkedList<b25> linkedList = this.a;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator<b25> it = this.a.iterator();
                while (it.hasNext()) {
                    b25 next = it.next();
                    if (aVar != null) {
                        aVar.a(next);
                    }
                }
                return;
            }
            this.a = new LinkedList<>();
            u86 u86Var = new u86();
            this.a.add(u86Var);
            if (aVar != null) {
                aVar.a(u86Var);
            }
        }
    }

    @Override // com.repackage.y15
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.y15
    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        List<DiyEmotionData> r = y86.o().r(TbadkCoreApplication.getCurrentAccount());
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
        diyEmotionData.setOrderId(301);
        diyEmotionData.setSharpText("#(meme,diysetting)");
        diyEmotionData.setUid(TbadkCoreApplication.getCurrentAccount());
        y86.o().c(diyEmotionData);
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            LinkedList<b25> linkedList = this.a;
            if (linkedList == null) {
                return false;
            }
            Iterator<b25> it = linkedList.iterator();
            while (it.hasNext()) {
                b25 next = it.next();
                if (next instanceof u86) {
                    return ((u86) next).w(str);
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
                Iterator<b25> it = this.a.iterator();
                while (it.hasNext()) {
                    b25 next = it.next();
                    if (next instanceof u86) {
                        ((u86) next).y();
                    }
                }
            }
        }
    }
}
