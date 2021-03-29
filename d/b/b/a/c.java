package d.b.b.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class c<T> extends d<T> {

    /* renamed from: a  reason: collision with root package name */
    public View f41469a;

    public c(f<T> fVar, int i) {
        super(fVar);
        this.f41469a = null;
        View inflate = LayoutInflater.from(fVar.getContext()).inflate(i, (ViewGroup) null);
        this.f41469a = inflate;
        inflate.setTag(this);
    }

    public View d(int i) {
        return this.f41469a.findViewById(i);
    }

    public View e() {
        return this.f41469a;
    }
}
