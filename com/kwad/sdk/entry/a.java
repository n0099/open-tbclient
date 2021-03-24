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
/* loaded from: classes6.dex */
public class a extends AbstractKsEntryElement {

    /* renamed from: a  reason: collision with root package name */
    public static com.kwad.sdk.entry.model.a f34708a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.a f34709b;

    /* renamed from: c  reason: collision with root package name */
    public c f34710c;

    /* renamed from: e  reason: collision with root package name */
    public h.a f34712e;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34711d = false;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f34713f = new AtomicBoolean(false);

    public static com.kwad.sdk.entry.model.a a() {
        return f34708a;
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
        int i;
        if (this.f34710c != null || (aVar = this.f34709b) == null) {
            return;
        }
        int i2 = aVar.f34064a;
        if (i2 != 1) {
            if (i2 == 2) {
                i = R.layout.ksad_view_entry_viewpager;
            } else if (i2 == 3) {
                i = R.layout.ksad_view_entry_gifviewpager;
            } else if (i2 == 4) {
                i = R.layout.ksad_view_entryphoto4;
            } else if (i2 == 5) {
                c cVar3 = (c) View.inflate(context, R.layout.ksad_view_entry_tab, null);
                this.f34710c = cVar3;
                ((EntryTypeTabView) cVar3).setEnableSlideAutoOpen(this.f34711d);
                cVar2 = this.f34710c;
                if (cVar2 == null) {
                    if (!cVar2.a(this.f34709b)) {
                        this.f34710c = new b(context);
                    }
                    this.f34710c.setOnfeedClickListener(onFeedClickListener);
                    return;
                }
                return;
            } else {
                cVar = new b(context);
            }
            cVar = (c) View.inflate(context, i, null);
        } else {
            cVar = (EntryLinearView) View.inflate(context, R.layout.ksad_view_entry_twophoto, null);
        }
        this.f34710c = cVar;
        cVar2 = this.f34710c;
        if (cVar2 == null) {
        }
    }

    public static void a(com.kwad.sdk.entry.model.a aVar) {
        f34708a = aVar;
    }

    public static void b() {
        f34708a = null;
    }

    public void a(h.a aVar) {
        this.f34712e = aVar;
    }

    public void a(com.kwad.sdk.core.response.model.a aVar) {
        this.f34709b = aVar;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsEntryElement
    @Nullable
    public View getEntryView2(Context context, KsEntryElement.OnFeedClickListener onFeedClickListener) {
        a(context, onFeedClickListener);
        return (View) this.f34710c;
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public int getEntryViewType() {
        com.kwad.sdk.core.response.model.a aVar = this.f34709b;
        if (aVar != null) {
            return aVar.f34064a;
        }
        return 0;
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void refresh() {
        if (this.f34712e == null || this.f34713f.get()) {
            return;
        }
        this.f34713f.set(true);
        i.a(this.f34712e, new e.a() { // from class: com.kwad.sdk.entry.a.1
            @Override // com.kwad.sdk.core.g.e.a
            public void a(int i, String str) {
                a.this.f34713f.set(false);
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull AdResultData adResultData) {
                a.this.f34713f.set(false);
                com.kwad.sdk.core.response.model.a aVar = adResultData.entryInfo;
                if (aVar != null) {
                    a.this.a(aVar);
                    if (a.this.f34710c instanceof View) {
                        ((View) a.this.f34710c).post(new Runnable() { // from class: com.kwad.sdk.entry.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.f34710c.a(a.this.f34709b);
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void setEnableSlideAutoOpen(boolean z) {
        this.f34711d = z;
        c cVar = this.f34710c;
        if (cVar instanceof EntryTypeTabView) {
            ((EntryTypeTabView) cVar).setEnableSlideAutoOpen(z);
        }
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void setTouchIntercept(boolean z) {
    }
}
