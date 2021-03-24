package d.b.h0.b1.l.a;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<LoadingLayout> f49945e = new HashSet<>();

    public void a(LoadingLayout loadingLayout) {
        if (loadingLayout != null) {
            this.f49945e.add(loadingLayout);
        }
    }

    @Override // d.b.h0.b1.l.a.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.f49945e.iterator();
        while (it.hasNext()) {
            it.next().setLastUpdatedLabel(charSequence);
        }
    }

    @Override // d.b.h0.b1.l.a.a
    public void setLoadingDrawable(Drawable drawable) {
        Iterator<LoadingLayout> it = this.f49945e.iterator();
        while (it.hasNext()) {
            it.next().setLoadingDrawable(drawable);
        }
    }

    @Override // d.b.h0.b1.l.a.a
    public void setPullLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.f49945e.iterator();
        while (it.hasNext()) {
            it.next().setPullLabel(charSequence);
        }
    }

    @Override // d.b.h0.b1.l.a.a
    public void setRefreshingLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.f49945e.iterator();
        while (it.hasNext()) {
            it.next().setRefreshingLabel(charSequence);
        }
    }

    @Override // d.b.h0.b1.l.a.a
    public void setReleaseLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.f49945e.iterator();
        while (it.hasNext()) {
            it.next().setReleaseLabel(charSequence);
        }
    }
}
