package com.kwad.sdk.entry;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsEntryElement;
import com.kwad.sdk.api.core.AbstractKsEntryElement;
import com.kwad.sdk.core.g.e;
import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.g.i;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.entry.view.EntryLinearView;
import com.kwad.sdk.entry.view.EntryTypeTabView;
import com.kwad.sdk.entry.view.b;
import com.kwad.sdk.entry.view.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class a extends AbstractKsEntryElement {

    /* renamed from: a  reason: collision with root package name */
    public static com.kwad.sdk.entry.model.a f35366a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.a f35367b;

    /* renamed from: c  reason: collision with root package name */
    public c f35368c;

    /* renamed from: e  reason: collision with root package name */
    public h.a f35370e;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35369d = false;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f35371f = new AtomicBoolean(false);

    public static com.kwad.sdk.entry.model.a a() {
        return f35366a;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, KsEntryElement.OnFeedClickListener onFeedClickListener) {
        com.kwad.sdk.core.response.model.a aVar;
        c cVar;
        c cVar2;
        int i2;
        if (this.f35368c != null || (aVar = this.f35367b) == null) {
            return;
        }
        int i3 = aVar.f34701a;
        if (i3 != 1) {
            if (i3 == 2) {
                i2 = R.layout.ksad_view_entry_viewpager;
            } else if (i3 == 3) {
                i2 = R.layout.ksad_view_entry_gifviewpager;
            } else if (i3 == 4) {
                i2 = R.layout.ksad_view_entryphoto4;
            } else if (i3 == 5) {
                c cVar3 = (c) View.inflate(context, R.layout.ksad_view_entry_tab, null);
                this.f35368c = cVar3;
                ((EntryTypeTabView) cVar3).setEnableSlideAutoOpen(this.f35369d);
                cVar2 = this.f35368c;
                if (cVar2 == null) {
                    if (!cVar2.a(this.f35367b)) {
                        this.f35368c = new b(context);
                    }
                    this.f35368c.setOnfeedClickListener(onFeedClickListener);
                    return;
                }
                return;
            } else {
                cVar = new b(context);
            }
            cVar = (c) View.inflate(context, i2, null);
        } else {
            cVar = (EntryLinearView) View.inflate(context, R.layout.ksad_view_entry_twophoto, null);
        }
        this.f35368c = cVar;
        cVar2 = this.f35368c;
        if (cVar2 == null) {
        }
    }

    public static void a(com.kwad.sdk.entry.model.a aVar) {
        f35366a = aVar;
    }

    public static void b() {
        f35366a = null;
    }

    public void a(h.a aVar) {
        this.f35370e = aVar;
    }

    public void a(com.kwad.sdk.core.response.model.a aVar) {
        this.f35367b = aVar;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsEntryElement
    @Nullable
    public View getEntryView2(Context context, KsEntryElement.OnFeedClickListener onFeedClickListener) {
        a(context, onFeedClickListener);
        return (View) this.f35368c;
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public int getEntryViewType() {
        com.kwad.sdk.core.response.model.a aVar = this.f35367b;
        if (aVar != null) {
            return aVar.f34701a;
        }
        return 0;
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void refresh() {
        if (this.f35370e == null || this.f35371f.get()) {
            return;
        }
        this.f35371f.set(true);
        i.a(this.f35370e, new e.a() { // from class: com.kwad.sdk.entry.a.1
            @Override // com.kwad.sdk.core.g.e.a
            public void a(int i2, String str) {
                a.this.f35371f.set(false);
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull AdResultData adResultData) {
                a.this.f35371f.set(false);
                com.kwad.sdk.core.response.model.a aVar = adResultData.entryInfo;
                if (aVar != null) {
                    a.this.a(aVar);
                    if (a.this.f35368c instanceof View) {
                        ((View) a.this.f35368c).post(new Runnable() { // from class: com.kwad.sdk.entry.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.f35368c.a(a.this.f35367b);
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void setEnableSlideAutoOpen(boolean z) {
        this.f35369d = z;
        c cVar = this.f35368c;
        if (cVar instanceof EntryTypeTabView) {
            ((EntryTypeTabView) cVar).setEnableSlideAutoOpen(z);
        }
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void setTouchIntercept(boolean z) {
    }
}
