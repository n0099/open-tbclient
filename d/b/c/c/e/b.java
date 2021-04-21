package d.b.c.c.e;

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
public class b extends d.b.c.c.e.a<CustomMessage<?>, CustomMessageTask> {

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, CustomResponsedMessage<?>> {

        /* renamed from: a  reason: collision with root package name */
        public CustomMessage f42223a;

        /* renamed from: b  reason: collision with root package name */
        public CustomMessageTask f42224b;

        public a(CustomMessage customMessage, CustomMessageTask customMessageTask) {
            this.f42223a = null;
            this.f42224b = null;
            setPriority(customMessageTask.getPriority());
            setParallel(customMessageTask.getParallel());
            setTag(customMessage.getTag());
            setKey(String.valueOf(customMessageTask.getCmd()));
            setParallel(customMessageTask.getTaskParallel());
            if (customMessageTask.isImme()) {
                setPriority(4);
            }
            this.f42223a = customMessage;
            this.f42224b = customMessageTask;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public CustomResponsedMessage doInBackground(String... strArr) {
            CustomMessageTask customMessageTask = this.f42224b;
            if (customMessageTask == null) {
                return null;
            }
            if (customMessageTask.getRunnable() == null) {
                BdLog.e("CustomTask :" + this.f42224b.getClass().getName() + "did not contain a runnable!!");
                return null;
            }
            try {
                return this.f42224b.getRunnable().run(this.f42223a);
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }

        public CustomMessage c() {
            return this.f42223a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                customResponsedMessage.setOrginalMessage(this.f42223a);
                b.this.f42222a.dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            BdLog.e("CustomTask :" + this.f42224b.getClass().getName() + "returns a NULL!!");
        }
    }

    public b(MessageManager messageManager) {
        super(messageManager);
    }

    @Override // d.b.c.c.b
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

    @Override // d.b.c.c.b
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
                this.f42222a.dispatchResponsedMessage(customResponsedMessage);
            }
        } else {
            new a(customMessage, customMessageTask).execute(new String[0]);
        }
        return customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.c.b
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
                this.f42222a.dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            return;
        }
        new a(customMessage, customMessageTask).execute(new String[0]);
    }
}
