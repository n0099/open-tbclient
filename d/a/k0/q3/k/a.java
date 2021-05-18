package d.a.k0.q3.k;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class a extends BdAsyncTask<Void, Void, List<b>> {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1567a f60055a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60056b;

    /* renamed from: c  reason: collision with root package name */
    public int f60057c;

    /* renamed from: e  reason: collision with root package name */
    public SimpleDateFormat f60059e = new SimpleDateFormat("mm:ss");

    /* renamed from: d  reason: collision with root package name */
    public SimpleDateFormat f60058d = new SimpleDateFormat("HH:mm:ss");

    /* renamed from: d.a.k0.q3.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1567a {
        void a(List<b> list);
    }

    public a(Context context) {
        this.f60056b = context;
        this.f60057c = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.f60059e.setTimeZone(timeZone);
        this.f60058d.setTimeZone(timeZone);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<b> doInBackground(Void... voidArr) {
        List<b> a2 = c.a(this.f60056b);
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
        InterfaceC1567a interfaceC1567a = this.f60055a;
        if (interfaceC1567a != null) {
            interfaceC1567a.a(list);
        }
    }

    public void d(InterfaceC1567a interfaceC1567a) {
        this.f60055a = interfaceC1567a;
    }
}
