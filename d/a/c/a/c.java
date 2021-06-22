package d.a.c.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class c<T> extends d<T> {

    /* renamed from: a  reason: collision with root package name */
    public View f42056a;

    public c(f<T> fVar, int i2) {
        super(fVar);
        this.f42056a = null;
        View inflate = LayoutInflater.from(fVar.getContext()).inflate(i2, (ViewGroup) null);
        this.f42056a = inflate;
        inflate.setTag(this);
    }

    public View d(int i2) {
        return this.f42056a.findViewById(i2);
    }

    public View e() {
        return this.f42056a;
    }
}
