package d.a.n0.b1.f.a;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public DataSetObservable f52800a = new DataSetObservable();

    public abstract int a();

    public abstract View b(int i2, ViewGroup viewGroup);

    public void c() {
        this.f52800a.notifyChanged();
    }

    public void d(DataSetObserver dataSetObserver) {
        try {
            this.f52800a.registerObserver(dataSetObserver);
        } catch (Throwable unused) {
        }
    }

    public void e(DataSetObserver dataSetObserver) {
        try {
            this.f52800a.unregisterObserver(dataSetObserver);
        } catch (Throwable unused) {
        }
    }
}
