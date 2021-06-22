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
    public static com.kwad.sdk.entry.model.a f35464a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.a f35465b;

    /* renamed from: c  reason: collision with root package name */
    public c f35466c;

    /* renamed from: e  reason: collision with root package name */
    public h.a f35468e;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35467d = false;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f35469f = new AtomicBoolean(false);

    public static com.kwad.sdk.entry.model.a a() {
        return f35464a;
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
        if (this.f35466c != null || (aVar = this.f35465b) == null) {
            return;
        }
        int i3 = aVar.f34799a;
        if (i3 != 1) {
            if (i3 == 2) {
                i2 = R.layout.ksad_view_entry_viewpager;
            } else if (i3 == 3) {
                i2 = R.layout.ksad_view_entry_gifviewpager;
            } else if (i3 == 4) {
                i2 = R.layout.ksad_view_entryphoto4;
            } else if (i3 == 5) {
                c cVar3 = (c) View.inflate(context, R.layout.ksad_view_entry_tab, null);
                this.f35466c = cVar3;
                ((EntryTypeTabView) cVar3).setEnableSlideAutoOpen(this.f35467d);
                cVar2 = this.f35466c;
                if (cVar2 == null) {
                    if (!cVar2.a(this.f35465b)) {
                        this.f35466c = new b(context);
                    }
                    this.f35466c.setOnfeedClickListener(onFeedClickListener);
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
        this.f35466c = cVar;
        cVar2 = this.f35466c;
        if (cVar2 == null) {
        }
    }

    public static void a(com.kwad.sdk.entry.model.a aVar) {
        f35464a = aVar;
    }

    public static void b() {
        f35464a = null;
    }

    public void a(h.a aVar) {
        this.f35468e = aVar;
    }

    public void a(com.kwad.sdk.core.response.model.a aVar) {
        this.f35465b = aVar;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsEntryElement
    @Nullable
    public View getEntryView2(Context context, KsEntryElement.OnFeedClickListener onFeedClickListener) {
        a(context, onFeedClickListener);
        return (View) this.f35466c;
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public int getEntryViewType() {
        com.kwad.sdk.core.response.model.a aVar = this.f35465b;
        if (aVar != null) {
            return aVar.f34799a;
        }
        return 0;
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void refresh() {
        if (this.f35468e == null || this.f35469f.get()) {
            return;
        }
        this.f35469f.set(true);
        i.a(this.f35468e, new e.a() { // from class: com.kwad.sdk.entry.a.1
            @Override // com.kwad.sdk.core.g.e.a
            public void a(int i2, String str) {
                a.this.f35469f.set(false);
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull AdResultData adResultData) {
                a.this.f35469f.set(false);
                com.kwad.sdk.core.response.model.a aVar = adResultData.entryInfo;
                if (aVar != null) {
                    a.this.a(aVar);
                    if (a.this.f35466c instanceof View) {
                        ((View) a.this.f35466c).post(new Runnable() { // from class: com.kwad.sdk.entry.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.f35466c.a(a.this.f35465b);
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void setEnableSlideAutoOpen(boolean z) {
        this.f35467d = z;
        c cVar = this.f35466c;
        if (cVar instanceof EntryTypeTabView) {
            ((EntryTypeTabView) cVar).setEnableSlideAutoOpen(z);
        }
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void setTouchIntercept(boolean z) {
    }
}
