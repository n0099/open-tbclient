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
/* loaded from: classes5.dex */
public class a extends AbstractKsEntryElement {

    /* renamed from: a  reason: collision with root package name */
    private static com.kwad.sdk.entry.model.a f10067a = null;

    /* renamed from: b  reason: collision with root package name */
    private com.kwad.sdk.core.response.model.a f10068b;
    private c c;
    private h.a e;
    private boolean d = false;
    private AtomicBoolean f = new AtomicBoolean(false);

    public static com.kwad.sdk.entry.model.a a() {
        return f10067a;
    }

    private void a(Context context, KsEntryElement.OnFeedClickListener onFeedClickListener) {
        if (this.c == null && this.f10068b != null) {
            switch (this.f10068b.f9729a) {
                case 1:
                    this.c = (EntryLinearView) View.inflate(context, R.layout.ksad_view_entry_twophoto, null);
                    break;
                case 2:
                    this.c = (c) View.inflate(context, R.layout.ksad_view_entry_viewpager, null);
                    break;
                case 3:
                    this.c = (c) View.inflate(context, R.layout.ksad_view_entry_gifviewpager, null);
                    break;
                case 4:
                    this.c = (c) View.inflate(context, R.layout.ksad_view_entryphoto4, null);
                    break;
                case 5:
                    this.c = (c) View.inflate(context, R.layout.ksad_view_entry_tab, null);
                    ((EntryTypeTabView) this.c).setEnableSlideAutoOpen(this.d);
                    break;
                default:
                    this.c = new b(context);
                    break;
            }
            if (this.c != null) {
                if (!this.c.a(this.f10068b)) {
                    this.c = new b(context);
                }
                this.c.setOnfeedClickListener(onFeedClickListener);
            }
        }
    }

    public static void a(com.kwad.sdk.entry.model.a aVar) {
        f10067a = aVar;
    }

    public static void b() {
        f10067a = null;
    }

    public void a(h.a aVar) {
        this.e = aVar;
    }

    public void a(com.kwad.sdk.core.response.model.a aVar) {
        this.f10068b = aVar;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsEntryElement
    @Nullable
    public View getEntryView2(Context context, KsEntryElement.OnFeedClickListener onFeedClickListener) {
        a(context, onFeedClickListener);
        return (View) this.c;
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public int getEntryViewType() {
        if (this.f10068b != null) {
            return this.f10068b.f9729a;
        }
        return 0;
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void refresh() {
        if (this.e == null || this.f.get()) {
            return;
        }
        this.f.set(true);
        i.a(this.e, new e.a() { // from class: com.kwad.sdk.entry.a.1
            @Override // com.kwad.sdk.core.g.e.a
            public void a(int i, String str) {
                a.this.f.set(false);
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull AdResultData adResultData) {
                a.this.f.set(false);
                if (adResultData.entryInfo != null) {
                    a.this.a(adResultData.entryInfo);
                    if (a.this.c instanceof View) {
                        ((View) a.this.c).post(new Runnable() { // from class: com.kwad.sdk.entry.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.c.a(a.this.f10068b);
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void setEnableSlideAutoOpen(boolean z) {
        this.d = z;
        if (this.c instanceof EntryTypeTabView) {
            ((EntryTypeTabView) this.c).setEnableSlideAutoOpen(this.d);
        }
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void setTouchIntercept(boolean z) {
    }
}
