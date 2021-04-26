package d.a.j0.q3.k;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class a extends BdAsyncTask<Void, Void, List<b>> {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1493a f59310a;

    /* renamed from: b  reason: collision with root package name */
    public Context f59311b;

    /* renamed from: c  reason: collision with root package name */
    public int f59312c;

    /* renamed from: e  reason: collision with root package name */
    public SimpleDateFormat f59314e = new SimpleDateFormat("mm:ss");

    /* renamed from: d  reason: collision with root package name */
    public SimpleDateFormat f59313d = new SimpleDateFormat("HH:mm:ss");

    /* renamed from: d.a.j0.q3.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1493a {
        void a(List<b> list);
    }

    public a(Context context) {
        this.f59311b = context;
        this.f59312c = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.f59314e.setTimeZone(timeZone);
        this.f59313d.setTimeZone(timeZone);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<b> doInBackground(Void... voidArr) {
        List<b> a2 = c.a(this.f59311b);
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
        InterfaceC1493a interfaceC1493a = this.f59310a;
        if (interfaceC1493a != null) {
            interfaceC1493a.a(list);
        }
    }

    public void d(InterfaceC1493a interfaceC1493a) {
        this.f59310a = interfaceC1493a;
    }
}
