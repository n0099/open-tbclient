package com.kwad.sdk.entry.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.glide.request.e;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.RadiusPvFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class EntryTypeTabView extends a {

    /* renamed from: c  reason: collision with root package name */
    public TextView f34758c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f34759d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34760e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f34761f;

    /* renamed from: g  reason: collision with root package name */
    public PhotoInfo f34762g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f34763h;
    public RadiusPvFrameLayout i;
    public volatile boolean j;
    public g k;
    public g.a l;
    public boolean m;
    public View.OnClickListener n;

    public EntryTypeTabView(Context context) {
        super(context);
        this.f34763h = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.j = false;
        this.l = new g.a() { // from class: com.kwad.sdk.entry.view.EntryTypeTabView.1
            @Override // com.kwad.sdk.core.view.g.a
            public void a(boolean z) {
                if (!z || EntryTypeTabView.this.j) {
                    return;
                }
                EntryTypeTabView.this.j = true;
                if (EntryTypeTabView.this.k != null) {
                    EntryTypeTabView.this.k.c();
                }
                EntryTypeTabView.this.g();
            }
        };
        this.n = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryTypeTabView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = EntryTypeTabView.this.f34758c == view ? 2 : 1;
                EntryTypeTabView entryTypeTabView = EntryTypeTabView.this;
                entryTypeTabView.a(entryTypeTabView.f34761f, 0, EntryTypeTabView.this.f34759d, i);
            }
        };
    }

    public EntryTypeTabView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34763h = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.j = false;
        this.l = new g.a() { // from class: com.kwad.sdk.entry.view.EntryTypeTabView.1
            @Override // com.kwad.sdk.core.view.g.a
            public void a(boolean z) {
                if (!z || EntryTypeTabView.this.j) {
                    return;
                }
                EntryTypeTabView.this.j = true;
                if (EntryTypeTabView.this.k != null) {
                    EntryTypeTabView.this.k.c();
                }
                EntryTypeTabView.this.g();
            }
        };
        this.n = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryTypeTabView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = EntryTypeTabView.this.f34758c == view ? 2 : 1;
                EntryTypeTabView entryTypeTabView = EntryTypeTabView.this;
                entryTypeTabView.a(entryTypeTabView.f34761f, 0, EntryTypeTabView.this.f34759d, i);
            }
        };
    }

    private void a(@NonNull ImageView imageView, int i, int i2) {
        ImageView.ScaleType scaleType;
        ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
        Context context = getContext();
        if (i2 >= i) {
            layoutParams.width = ao.a(context, 247.0f);
            layoutParams.height = ao.a(getContext(), 330.0f);
            this.i.setRatio(1.3333334f);
            if (i2 * 3 < i * 4) {
                scaleType = ImageView.ScaleType.CENTER_INSIDE;
            }
            scaleType = ImageView.ScaleType.CENTER_CROP;
        } else {
            int c2 = ao.c(context) - ao.a(getContext(), 32.0f);
            layoutParams.width = c2;
            layoutParams.height = (int) ((c2 * 16.0f) / 9.0f);
            this.i.setRatio(0.5625f);
            if (i2 * 16 > i * 9) {
                scaleType = ImageView.ScaleType.FIT_CENTER;
            }
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        imageView.setScaleType(scaleType);
        this.i.setLayoutParams(layoutParams);
        com.kwad.sdk.core.d.a.a("EntryType5View", "w*h=" + layoutParams.width + " * " + layoutParams.height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        a(this.f34761f, 0, this.f34759d, 3);
    }

    private void h() {
        this.f34758c = (TextView) findViewById(R.id.ksad_entryitem5_title);
        this.f34759d = (ImageView) findViewById(R.id.ksad_entryitem5_thumb);
        this.f34760e = (TextView) findViewById(R.id.ksad_entryitem5_like_count);
        RadiusPvFrameLayout radiusPvFrameLayout = (RadiusPvFrameLayout) findViewById(R.id.ksad_entryitem5_container);
        this.i = radiusPvFrameLayout;
        radiusPvFrameLayout.setRadius(ao.a(getContext(), 4.0f));
        this.i.setOnClickListener(this.n);
        this.f34758c.setOnClickListener(this.n);
        c();
    }

    private boolean i() {
        return this.m && com.ksad.download.d.b.b(getContext());
    }

    private void j() {
        TextView textView;
        int i;
        String str = this.f34762g.baseInfo.videoDesc;
        if (TextUtils.isEmpty(str)) {
            textView = this.f34758c;
            i = 8;
        } else {
            this.f34758c.setText(str);
            textView = this.f34758c;
            i = 0;
        }
        textView.setVisibility(i);
    }

    private void k() {
        com.kwad.sdk.core.response.model.c E = d.E(this.f34762g);
        String a2 = E.a();
        a(this.f34759d, E.c(), E.b());
        com.kwad.sdk.glide.c.b(getContext()).a(a2).a(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).c(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).a((e) new com.kwad.sdk.c(a2, this.f34761f)).a(this.f34759d);
    }

    private void l() {
        this.f34760e.setText(String.format(getContext().getString(R.string.ksad_entry_tab_like_format), ag.a(d.m(this.f34762g), "0")));
    }

    @Override // com.kwad.sdk.entry.view.a, com.kwad.sdk.widget.b
    public void a() {
        super.a();
        com.kwad.sdk.core.report.e.b(this.f34761f, ((a) this).f34780a.f34068e);
    }

    @Override // com.kwad.sdk.entry.view.a
    public boolean b() {
        this.f34763h.clear();
        Iterator<AdTemplate> it = ((a) this).f34780a.k.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdTemplate next = it.next();
            if (!next.needHide) {
                this.f34763h.add(next);
                break;
            }
        }
        if (this.f34763h.size() > 0) {
            AdTemplate adTemplate = this.f34763h.get(0);
            this.f34761f = adTemplate;
            this.f34762g = adTemplate.photoInfo;
        } else {
            this.f34761f = null;
        }
        if (this.f34761f == null) {
            return false;
        }
        j();
        l();
        k();
        return true;
    }

    public void c() {
        if (i() && this.k == null) {
            g gVar = new g(this.f34759d, 60);
            this.k = gVar;
            gVar.a(this.l);
            this.k.a();
        }
    }

    @Override // com.kwad.sdk.entry.view.a
    public int getEntrySourcePos() {
        return 0;
    }

    @Override // com.kwad.sdk.entry.view.a
    @NonNull
    public List<AdTemplate> getRealShowData() {
        return this.f34763h;
    }

    @Override // com.kwad.sdk.widget.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.k;
        if (gVar != null) {
            gVar.c();
        }
    }

    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        h();
    }

    public void setEnableSlideAutoOpen(boolean z) {
        this.m = z;
        c();
    }
}
