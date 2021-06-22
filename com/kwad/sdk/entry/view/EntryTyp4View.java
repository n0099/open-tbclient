package com.kwad.sdk.entry.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class EntryTyp4View extends a {

    /* renamed from: c  reason: collision with root package name */
    public TextView f35508c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f35509d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f35510e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35511f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f35512g;

    /* renamed from: h  reason: collision with root package name */
    public PhotoInfo f35513h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f35514i;
    public View.OnClickListener j;

    public EntryTyp4View(Context context) {
        super(context);
        this.f35514i = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.j = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryTyp4View.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryTyp4View entryTyp4View = EntryTyp4View.this;
                entryTyp4View.a(entryTyp4View.f35512g, 0, view, 1);
            }
        };
    }

    public EntryTyp4View(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35514i = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.j = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryTyp4View.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryTyp4View entryTyp4View = EntryTyp4View.this;
                entryTyp4View.a(entryTyp4View.f35512g, 0, view, 1);
            }
        };
    }

    private void c() {
        this.f35508c = (TextView) findViewById(R.id.ksad_entryitem4_title);
        this.f35509d = (ImageView) findViewById(R.id.ksad_entryitem4_background);
        this.f35510e = (ImageView) findViewById(R.id.ksad_entryitem4_thumb);
        this.f35511f = (TextView) findViewById(R.id.ksad_entryitem4_duration);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_entryitem4_container);
        ratioFrameLayout.setRatio(0.56f);
        ratioFrameLayout.setOnClickListener(this.j);
        this.f35508c.setOnClickListener(this.j);
    }

    private boolean g() {
        com.kwad.sdk.core.response.model.c E = d.E(this.f35513h);
        return E.b() * 16 > E.c() * 9;
    }

    @Override // com.kwad.sdk.entry.view.a, com.kwad.sdk.widget.b
    public void a() {
        super.a();
        e.b(this.f35512g, ((a) this).f35539a.f34803e);
    }

    @Override // com.kwad.sdk.entry.view.a
    public boolean b() {
        this.f35514i.clear();
        Iterator<AdTemplate> it = ((a) this).f35539a.k.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdTemplate next = it.next();
            if (!next.needHide && !com.kwad.sdk.core.response.b.c.c(next)) {
                this.f35514i.add(next);
                break;
            }
        }
        if (this.f35514i.size() > 0) {
            AdTemplate adTemplate = this.f35514i.get(0);
            this.f35512g = adTemplate;
            this.f35513h = adTemplate.photoInfo;
        } else {
            this.f35512g = null;
        }
        if (this.f35512g == null) {
            return false;
        }
        if (((a) this).f35539a.f34806h != 1 || TextUtils.isEmpty(this.f35513h.baseInfo.videoDesc)) {
            this.f35508c.setVisibility(8);
        } else {
            this.f35508c.setText(this.f35513h.baseInfo.videoDesc);
            this.f35508c.setVisibility(0);
        }
        String a2 = ai.a(this.f35513h.videoInfo.duration);
        if (((a) this).f35539a.f34806h == 1) {
            this.f35511f.setText(a2);
            this.f35511f.setVisibility(0);
        } else {
            this.f35511f.setVisibility(8);
        }
        if (g()) {
            this.f35510e.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f35509d.setVisibility(0);
            String h2 = d.h(this.f35513h);
            com.kwad.sdk.glide.c.b(this.f35509d.getContext()).a(h2).a(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).b(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).c(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).a((com.kwad.sdk.glide.request.e) new com.kwad.sdk.c(h2, this.f35512g)).a(this.f35509d);
            com.kwad.sdk.core.d.a.a("EntryTyp4View", "blurBackgroundUrl=" + h2 + " blurCoverUrl=" + this.f35513h.coverInfo.blurCoverUrl);
        } else {
            this.f35510e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f35509d.setVisibility(8);
        }
        String a3 = d.E(this.f35513h).a();
        com.kwad.sdk.glide.c.b(this.f35510e.getContext()).a(a3).a(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).b(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).c(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).a((com.kwad.sdk.glide.request.e) new com.kwad.sdk.c(a3, this.f35512g)).a(this.f35510e);
        return true;
    }

    @Override // com.kwad.sdk.entry.view.a
    public String getEntrySourceDesc() {
        if (TextUtils.isEmpty(((a) this).f35539a.f34800b)) {
            ((a) this).f35539a.f34800b = "快手推荐";
        }
        StringBuilder sb = new StringBuilder();
        com.kwad.sdk.core.response.model.a aVar = ((a) this).f35539a;
        if (aVar.f34801c != 0) {
            sb.append(aVar.f34800b);
            sb.append("   ");
        }
        if (((a) this).f35539a.j != 0) {
            sb.append(ag.a(this.f35513h.baseInfo.commentCount, "0"));
            sb.append(" 评论");
        }
        return sb.toString();
    }

    @Override // com.kwad.sdk.entry.view.a
    public int getEntrySourcePos() {
        int entrySourcePos = super.getEntrySourcePos();
        return entrySourcePos == 0 ? ((a) this).f35539a.j : entrySourcePos;
    }

    @Override // com.kwad.sdk.entry.view.a
    public List<AdTemplate> getRealShowData() {
        return this.f35514i;
    }

    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }
}
