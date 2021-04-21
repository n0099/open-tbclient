package d.b.c.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class c<T> extends d<T> {

    /* renamed from: a  reason: collision with root package name */
    public View f42206a;

    public c(f<T> fVar, int i) {
        super(fVar);
        this.f42206a = null;
        View inflate = LayoutInflater.from(fVar.getContext()).inflate(i, (ViewGroup) null);
        this.f42206a = inflate;
        inflate.setTag(this);
    }

    public View d(int i) {
        return this.f42206a.findViewById(i);
    }

    public View e() {
        return this.f42206a;
    }
}
