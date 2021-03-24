package d.b.i0.p3.k;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class a extends BdAsyncTask<Void, Void, List<b>> {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1467a f59082a;

    /* renamed from: b  reason: collision with root package name */
    public Context f59083b;

    /* renamed from: c  reason: collision with root package name */
    public int f59084c;

    /* renamed from: e  reason: collision with root package name */
    public SimpleDateFormat f59086e = new SimpleDateFormat("mm:ss");

    /* renamed from: d  reason: collision with root package name */
    public SimpleDateFormat f59085d = new SimpleDateFormat("HH:mm:ss");

    /* renamed from: d.b.i0.p3.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1467a {
        void a(List<b> list);
    }

    public a(Context context) {
        this.f59083b = context;
        this.f59084c = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.f59086e.setTimeZone(timeZone);
        this.f59085d.setTimeZone(timeZone);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<b> doInBackground(Void... voidArr) {
        List<b> a2 = c.a(this.f59083b);
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
        InterfaceC1467a interfaceC1467a = this.f59082a;
        if (interfaceC1467a != null) {
            interfaceC1467a.a(list);
        }
    }

    public void d(InterfaceC1467a interfaceC1467a) {
        this.f59082a = interfaceC1467a;
    }
}
