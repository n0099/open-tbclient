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
/* loaded from: classes4.dex */
public class EntryTypeTabView extends a {
    private TextView c;
    private ImageView d;
    private TextView e;
    private AdTemplate f;
    private PhotoInfo g;
    private com.kwad.sdk.lib.widget.b<AdTemplate> h;
    private RadiusPvFrameLayout i;
    private volatile boolean j;
    private g k;
    private g.a l;
    private boolean m;
    private View.OnClickListener n;

    public EntryTypeTabView(Context context) {
        super(context);
        this.h = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
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
                EntryTypeTabView.this.a(EntryTypeTabView.this.f, 0, EntryTypeTabView.this.d, EntryTypeTabView.this.c == view ? 2 : 1);
            }
        };
    }

    public EntryTypeTabView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
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
                EntryTypeTabView.this.a(EntryTypeTabView.this.f, 0, EntryTypeTabView.this.d, EntryTypeTabView.this.c == view ? 2 : 1);
            }
        };
    }

    private void a(@NonNull ImageView imageView, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
        if (i2 >= i) {
            layoutParams.width = ao.a(getContext(), 247.0f);
            layoutParams.height = ao.a(getContext(), 330.0f);
            this.i.setRatio(1.3333334f);
            if (i2 * 3 >= i * 4) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
        } else {
            int c = ao.c(getContext()) - ao.a(getContext(), 32.0f);
            layoutParams.width = c;
            layoutParams.height = (int) ((c * 16.0f) / 9.0f);
            this.i.setRatio(0.5625f);
            if (i2 * 16 <= i * 9) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }
        this.i.setLayoutParams(layoutParams);
        com.kwad.sdk.core.d.a.a("EntryType5View", "w*h=" + layoutParams.width + " * " + layoutParams.height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        a(this.f, 0, this.d, 3);
    }

    private void h() {
        this.c = (TextView) findViewById(R.id.ksad_entryitem5_title);
        this.d = (ImageView) findViewById(R.id.ksad_entryitem5_thumb);
        this.e = (TextView) findViewById(R.id.ksad_entryitem5_like_count);
        this.i = (RadiusPvFrameLayout) findViewById(R.id.ksad_entryitem5_container);
        this.i.setRadius(ao.a(getContext(), 4.0f));
        this.i.setOnClickListener(this.n);
        this.c.setOnClickListener(this.n);
        c();
    }

    private boolean i() {
        return this.m && com.ksad.download.d.b.b(getContext());
    }

    private void j() {
        String str = this.g.baseInfo.videoDesc;
        if (TextUtils.isEmpty(str)) {
            this.c.setVisibility(8);
            return;
        }
        this.c.setText(str);
        this.c.setVisibility(0);
    }

    private void k() {
        com.kwad.sdk.core.response.model.c E = d.E(this.g);
        String a2 = E.a();
        a(this.d, E.c(), E.b());
        com.kwad.sdk.glide.c.b(getContext()).a(a2).a(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).c(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).a((e) new com.kwad.sdk.c(a2, this.f)).a(this.d);
    }

    private void l() {
        this.e.setText(String.format(getContext().getString(R.string.ksad_entry_tab_like_format), ag.a(d.m(this.g), "0")));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.entry.view.a, com.kwad.sdk.widget.b
    public void a() {
        super.a();
        com.kwad.sdk.core.report.e.b(this.f, this.f9801a.e);
    }

    @Override // com.kwad.sdk.entry.view.a
    protected boolean b() {
        this.h.clear();
        Iterator<AdTemplate> it = this.f9801a.k.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdTemplate next = it.next();
            if (!next.needHide) {
                this.h.add(next);
                break;
            }
        }
        if (this.h.size() > 0) {
            this.f = this.h.get(0);
            this.g = this.f.photoInfo;
        } else {
            this.f = null;
        }
        if (this.f == null) {
            return false;
        }
        j();
        l();
        k();
        return true;
    }

    public void c() {
        if (i() && this.k == null) {
            this.k = new g(this.d, 60);
            this.k.a(this.l);
            this.k.a();
        }
    }

    @Override // com.kwad.sdk.entry.view.a
    public int getEntrySourcePos() {
        return 0;
    }

    @Override // com.kwad.sdk.entry.view.a
    @NonNull
    protected List<AdTemplate> getRealShowData() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.widget.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.k != null) {
            this.k.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
