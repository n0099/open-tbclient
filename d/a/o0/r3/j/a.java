package d.a.o0.r3.j;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class a extends BdAsyncTask<Void, Void, List<b>> {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1640a f64010a;

    /* renamed from: b  reason: collision with root package name */
    public Context f64011b;

    /* renamed from: c  reason: collision with root package name */
    public int f64012c;

    /* renamed from: e  reason: collision with root package name */
    public SimpleDateFormat f64014e = new SimpleDateFormat("mm:ss");

    /* renamed from: d  reason: collision with root package name */
    public SimpleDateFormat f64013d = new SimpleDateFormat("HH:mm:ss");

    /* renamed from: d.a.o0.r3.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1640a {
        void a(List<b> list);
    }

    public a(Context context) {
        this.f64011b = context;
        this.f64012c = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.f64014e.setTimeZone(timeZone);
        this.f64013d.setTimeZone(timeZone);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<b> doInBackground(Void... voidArr) {
        List<b> a2 = c.a(this.f64011b);
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
        InterfaceC1640a interfaceC1640a = this.f64010a;
        if (interfaceC1640a != null) {
            interfaceC1640a.a(list);
        }
    }

    public void d(InterfaceC1640a interfaceC1640a) {
        this.f64010a = interfaceC1640a;
    }
}
