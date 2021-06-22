package d.a.n0.z0;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    public static k f54826c = new k();

    /* renamed from: a  reason: collision with root package name */
    public c f54827a;

    /* renamed from: b  reason: collision with root package name */
    public b f54828b;

    /* loaded from: classes3.dex */
    public interface b {
        void onResult(boolean z);
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<String, Integer, Boolean> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(k.this.d());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (k.this.f54828b == null || bool == null) {
                return;
            }
            k.this.f54828b.onResult(bool.booleanValue());
        }
    }

    public static k e() {
        return f54826c;
    }

    public void c(b bVar) {
        this.f54828b = bVar;
        c cVar = this.f54827a;
        if (cVar != null) {
            cVar.cancel();
        }
        c cVar2 = new c();
        this.f54827a = cVar2;
        cVar2.setPriority(4);
        this.f54827a.execute(new String[0]);
    }

    public final boolean d() {
        String[] split;
        int d2;
        byte[] GetFileData = FileHelper.GetFileData(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = GetFileData != null ? new String(GetFileData) : null;
        long j = StringUtils.getyyyyMMddHHTimeForNow();
        long j2 = 0;
        if (TextUtils.isEmpty(str) || (split = str.split(":")) == null || split.length != 2) {
            d2 = 0;
        } else {
            d2 = d.a.c.e.m.b.d(split[0], 0);
            j2 = d.a.c.e.m.b.f(split[1], j);
        }
        return j2 == j && d2 > 1;
    }
}
