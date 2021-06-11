package d.a.n0.s.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class i extends BdAsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    public a f64065a;

    public i(a aVar) {
        this.f64065a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (f.f().b(this.f64065a)) {
            return null;
        }
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        j.t("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true);
        return null;
    }
}
