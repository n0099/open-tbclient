package d.b.i0.s.b.r;

import android.os.Parcelable;
import android.util.Log;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import d.b.g0.a.i2.p;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a extends ActivityDelegation {

    /* renamed from: d.b.i0.s.b.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1532a implements d.b.g0.a.b1.d.d.d {
        public C1532a() {
        }

        @Override // d.b.g0.a.b1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList<? extends Parcelable> arrayList = (ArrayList) obj;
                if (d.b.g0.a.b1.d.c.c.f43426a) {
                    Iterator<? extends Parcelable> it = arrayList.iterator();
                    while (it.hasNext()) {
                        String simpleName = C1532a.class.getSimpleName();
                        Log.d(simpleName, "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                a.this.mResult.putParcelableArrayList("mediaModels", arrayList);
            }
            a.this.finish();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        p.k(new b(getAgent(), this.mParams, new C1532a()), "delegation compress files");
        return false;
    }
}
