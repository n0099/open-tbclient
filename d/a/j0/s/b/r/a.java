package d.a.j0.s.b.r;

import android.os.Parcelable;
import android.util.Log;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import d.a.h0.a.i2.p;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a extends ActivityDelegation {

    /* renamed from: d.a.j0.s.b.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1533a implements d.a.h0.a.b1.d.d.d {
        public C1533a() {
        }

        @Override // d.a.h0.a.b1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList<? extends Parcelable> arrayList = (ArrayList) obj;
                if (d.a.h0.a.b1.d.c.c.f41422a) {
                    Iterator<? extends Parcelable> it = arrayList.iterator();
                    while (it.hasNext()) {
                        String simpleName = C1533a.class.getSimpleName();
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
        p.k(new b(getAgent(), this.mParams, new C1533a()), "delegation compress files");
        return false;
    }
}
