package d.a.n0.r0.p;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.frs.FrsHotTopic.FrsHotTopicListData;
import com.baidu.tieba.frs.FrsHotTopic.FrsLinkHashMap;
import d.a.c.e.d.l;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f63025b;

    /* renamed from: a  reason: collision with root package name */
    public FrsLinkHashMap<String, Long> f63026a;

    /* renamed from: d.a.n0.r0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1588a extends BdAsyncTask<Void, Void, Void> {
        public C1588a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            FrsHotTopicListData frsHotTopicListData;
            l<String> h2 = d.a.m0.r.r.a.f().h("tb.frs_hottopic", "");
            if (h2 != null) {
                String str = h2.get("hot_topic_key");
                if (!StringUtils.isNull(str) && (frsHotTopicListData = (FrsHotTopicListData) OrmObject.objectWithJsonStr(str, FrsHotTopicListData.class)) != null) {
                    a.this.f63026a = frsHotTopicListData.mSceneMap;
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            l<String> h2 = d.a.m0.r.r.a.f().h("tb.frs_hottopic", "");
            if (h2 == null) {
                return null;
            }
            FrsHotTopicListData frsHotTopicListData = new FrsHotTopicListData();
            frsHotTopicListData.mSceneMap = a.this.f63026a;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(frsHotTopicListData);
            if (!StringUtils.isNull(jsonStrWithObject)) {
                h2.g("hot_topic_key", jsonStrWithObject);
            }
            return null;
        }
    }

    public static a d() {
        if (f63025b == null) {
            synchronized (a.class) {
                if (f63025b == null) {
                    f63025b = new a();
                }
            }
        }
        return f63025b;
    }

    public boolean c(String str, long j) {
        boolean z;
        if (this.f63026a == null) {
            this.f63026a = new FrsLinkHashMap<>();
            e(str, j);
        }
        if (StringUtils.isNull(str) || this.f63026a.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = this.f63026a.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Map.Entry<String, Long> next = it.next();
            if (next != null && str.equals(next.getKey())) {
                z = true;
                break;
            }
        }
        if (z && this.f63026a.get(str).longValue() == j) {
            return false;
        }
        this.f63026a.put(str, Long.valueOf(j));
        f();
        return true;
    }

    public final void e(String str, long j) {
        C1588a c1588a = new C1588a();
        c1588a.setPriority(3);
        c1588a.execute(new Void[0]);
    }

    public final void f() {
        b bVar = new b();
        bVar.setPriority(3);
        bVar.execute(new Void[0]);
    }
}
