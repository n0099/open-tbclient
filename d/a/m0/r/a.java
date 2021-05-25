package d.a.m0.r;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements LayoutInflater.Factory {

    /* renamed from: e  reason: collision with root package name */
    public c f49634e;

    public void a(c cVar) {
        this.f49634e = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.f49634e == null) {
            this.f49634e = new c();
        }
        this.f49634e.i(str, context, attributeSet);
        return null;
    }
}
