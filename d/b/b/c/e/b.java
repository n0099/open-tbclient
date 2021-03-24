package d.b.b.c.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b extends d.b.b.c.e.a<CustomMessage<?>, CustomMessageTask> {

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, CustomResponsedMessage<?>> {

        /* renamed from: a  reason: collision with root package name */
        public CustomMessage f41485a;

        /* renamed from: b  reason: collision with root package name */
        public CustomMessageTask f41486b;

        public a(CustomMessage customMessage, CustomMessageTask customMessageTask) {
            this.f41485a = null;
            this.f41486b = null;
            setPriority(customMessageTask.getPriority());
            setParallel(customMessageTask.getParallel());
            setTag(customMessage.getTag());
            setKey(String.valueOf(customMessageTask.getCmd()));
            setParallel(customMessageTask.getTaskParallel());
            if (customMessageTask.isImme()) {
                setPriority(4);
            }
            this.f41485a = customMessage;
            this.f41486b = customMessageTask;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public CustomResponsedMessage doInBackground(String... strArr) {
            CustomMessageTask customMessageTask = this.f41486b;
            if (customMessageTask == null) {
                return null;
            }
            if (customMessageTask.getRunnable() == null) {
                BdLog.e("CustomTask :" + this.f41486b.getClass().getName() + "did not contain a runnable!!");
                return null;
            }
            try {
                return this.f41486b.getRunnable().run(this.f41485a);
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }

        public CustomMessage c() {
            return this.f41485a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                customResponsedMessage.setOrginalMessage(this.f41485a);
                b.this.f41484a.dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            BdLog.e("CustomTask :" + this.f41486b.getClass().getName() + "returns a NULL!!");
        }
    }

    public b(MessageManager messageManager) {
        super(messageManager);
    }

    @Override // d.b.b.c.b
    public LinkedList<CustomMessage<?>> e(int i, BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(bdUniqueId, i != 0 ? String.valueOf(i) : null);
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

    @Override // d.b.b.c.b
    public void h(int i, BdUniqueId bdUniqueId) {
        BdAsyncTask.removeAllTask(bdUniqueId, i != 0 ? String.valueOf(i) : null);
    }

    public LinkedList<CustomMessage<?>> i(BdUniqueId bdUniqueId) {
        return e(0, bdUniqueId);
    }

    public void j(BdUniqueId bdUniqueId) {
        h(0, bdUniqueId);
    }

    public <T> CustomResponsedMessage<T> k(CustomMessage customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
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
                this.f41484a.dispatchResponsedMessage(customResponsedMessage);
            }
        } else {
            new a(customMessage, customMessageTask).execute(new String[0]);
        }
        return customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.c.b
    /* renamed from: l */
    public void f(CustomMessage customMessage, CustomMessageTask customMessageTask) {
        if (customMessage == null || customMessageTask == null) {
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
                this.f41484a.dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            return;
        }
        new a(customMessage, customMessageTask).execute(new String[0]);
    }
}
