package d.b.j0.q3.k;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class a extends BdAsyncTask<Void, Void, List<b>> {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1554a f61172a;

    /* renamed from: b  reason: collision with root package name */
    public Context f61173b;

    /* renamed from: c  reason: collision with root package name */
    public int f61174c;

    /* renamed from: e  reason: collision with root package name */
    public SimpleDateFormat f61176e = new SimpleDateFormat("mm:ss");

    /* renamed from: d  reason: collision with root package name */
    public SimpleDateFormat f61175d = new SimpleDateFormat("HH:mm:ss");

    /* renamed from: d.b.j0.q3.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1554a {
        void a(List<b> list);
    }

    public a(Context context) {
        this.f61173b = context;
        this.f61174c = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.f61176e.setTimeZone(timeZone);
        this.f61175d.setTimeZone(timeZone);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<b> doInBackground(Void... voidArr) {
        List<b> a2 = c.a(this.f61173b);
        c.d("/sdcard", a2, false);
        c.d("/sdcard/DCIM", a2, true);
        c.e(a2);
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(List<b> list) {
        super.onPostExecute(list);
        InterfaceC1554a interfaceC1554a = this.f61172a;
        if (interfaceC1554a != null) {
            interfaceC1554a.a(list);
        }
    }

    public void d(InterfaceC1554a interfaceC1554a) {
        this.f61172a = interfaceC1554a;
    }
}
