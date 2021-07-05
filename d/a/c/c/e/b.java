package d.a.c.c.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class b extends d.a.c.c.e.a<CustomMessage<?>, CustomMessageTask> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, String, CustomResponsedMessage<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CustomMessage f43882a;

        /* renamed from: b  reason: collision with root package name */
        public CustomMessageTask f43883b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f43884c;

        public a(b bVar, CustomMessage customMessage, CustomMessageTask customMessageTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, customMessage, customMessageTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43884c = bVar;
            this.f43882a = null;
            this.f43883b = null;
            setPriority(customMessageTask.getPriority());
            setParallel(customMessageTask.getParallel());
            setTag(customMessage.getTag());
            setKey(String.valueOf(customMessageTask.getCmd()));
            setParallel(customMessageTask.getTaskParallel());
            if (customMessageTask.isImme()) {
                setPriority(4);
            }
            this.f43882a = customMessage;
            this.f43883b = customMessageTask;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public CustomResponsedMessage doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                CustomMessageTask customMessageTask = this.f43883b;
                if (customMessageTask == null) {
                    return null;
                }
                if (customMessageTask.getRunnable() == null) {
                    BdLog.e("CustomTask :" + this.f43883b.getClass().getName() + "did not contain a runnable!!");
                    return null;
                }
                try {
                    return this.f43883b.getRunnable().run(this.f43882a);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                    return null;
                }
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }

        public CustomMessage c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43882a : (CustomMessage) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, customResponsedMessage) == null) {
                if (customResponsedMessage != null) {
                    customResponsedMessage.setOrginalMessage(this.f43882a);
                    this.f43884c.f43881a.dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                BdLog.e("CustomTask :" + this.f43883b.getClass().getName() + "returns a NULL!!");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(MessageManager messageManager) {
        super(messageManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((MessageManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.c.c.b
    public LinkedList<CustomMessage<?>> e(int i2, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, bdUniqueId)) == null) {
            LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(bdUniqueId, i2 != 0 ? String.valueOf(i2) : null);
            LinkedList<CustomMessage<?>> linkedList = new LinkedList<>();
            Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next instanceof a) {
                    linkedList.add(((a) next).c());
                }
            }
            return linkedList;
        }
        return (LinkedList) invokeIL.objValue;
    }

    @Override // d.a.c.c.b
    public void h(int i2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bdUniqueId) == null) {
            BdAsyncTask.removeAllTask(bdUniqueId, i2 != 0 ? String.valueOf(i2) : null);
        }
    }

    public LinkedList<CustomMessage<?>> i(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bdUniqueId)) == null) ? e(0, bdUniqueId) : (LinkedList) invokeL.objValue;
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public <T> CustomResponsedMessage<T> k(CustomMessage customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, customMessage, customMessageTask, cls)) == null) {
            CustomResponsedMessage<T> customResponsedMessage = null;
            if (customMessageTask == null) {
                return null;
            }
            if (customMessageTask.getType() == CustomMessageTask.TASK_TYPE.SYNCHRONIZED) {
                try {
                    customResponsedMessage = (CustomResponsedMessage<T>) customMessageTask.getRunnable().run(customMessage);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                if (customResponsedMessage != null) {
                    this.f43881a.dispatchResponsedMessage(customResponsedMessage);
                }
            } else {
                new a(this, customMessage, customMessageTask).execute(new String[0]);
            }
            return customResponsedMessage;
        }
        return (CustomResponsedMessage) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.c.b
    /* renamed from: l */
    public void f(CustomMessage customMessage, CustomMessageTask customMessageTask) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, customMessage, customMessageTask) == null) || customMessage == null || customMessageTask == null) {
            return;
        }
        if (customMessageTask.getType() == CustomMessageTask.TASK_TYPE.SYNCHRONIZED) {
            CustomResponsedMessage<?> customResponsedMessage = null;
            try {
                customResponsedMessage = customMessageTask.getRunnable().run(customMessage);
                if (customResponsedMessage != null) {
                    customResponsedMessage.setOrginalMessage(customMessage);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            if (customResponsedMessage != null) {
                this.f43881a.dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            return;
        }
        new a(this, customMessage, customMessageTask).execute(new String[0]);
    }
}
