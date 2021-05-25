package d.a.n0.r3.k;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class a extends BdAsyncTask<Void, Void, List<b>> {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1580a f60196a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60197b;

    /* renamed from: c  reason: collision with root package name */
    public int f60198c;

    /* renamed from: e  reason: collision with root package name */
    public SimpleDateFormat f60200e = new SimpleDateFormat("mm:ss");

    /* renamed from: d  reason: collision with root package name */
    public SimpleDateFormat f60199d = new SimpleDateFormat("HH:mm:ss");

    /* renamed from: d.a.n0.r3.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1580a {
        void a(List<b> list);
    }

    public a(Context context) {
        this.f60197b = context;
        this.f60198c = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.f60200e.setTimeZone(timeZone);
        this.f60199d.setTimeZone(timeZone);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<b> doInBackground(Void... voidArr) {
        List<b> a2 = c.a(this.f60197b);
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
        InterfaceC1580a interfaceC1580a = this.f60196a;
        if (interfaceC1580a != null) {
            interfaceC1580a.a(list);
        }
    }

    public void d(InterfaceC1580a interfaceC1580a) {
        this.f60196a = interfaceC1580a;
    }
}
