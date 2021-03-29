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
/* loaded from: classes6.dex */
public class EntryTyp4View extends a {

    /* renamed from: c  reason: collision with root package name */
    public TextView f34752c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f34753d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f34754e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f34755f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f34756g;

    /* renamed from: h  reason: collision with root package name */
    public PhotoInfo f34757h;
    public com.kwad.sdk.lib.widget.b<AdTemplate> i;
    public View.OnClickListener j;

    public EntryTyp4View(Context context) {
        super(context);
        this.i = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.j = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryTyp4View.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryTyp4View entryTyp4View = EntryTyp4View.this;
                entryTyp4View.a(entryTyp4View.f34756g, 0, view, 1);
            }
        };
    }

    public EntryTyp4View(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.j = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryTyp4View.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryTyp4View entryTyp4View = EntryTyp4View.this;
                entryTyp4View.a(entryTyp4View.f34756g, 0, view, 1);
            }
        };
    }

    private void c() {
        this.f34752c = (TextView) findViewById(R.id.ksad_entryitem4_title);
        this.f34753d = (ImageView) findViewById(R.id.ksad_entryitem4_background);
        this.f34754e = (ImageView) findViewById(R.id.ksad_entryitem4_thumb);
        this.f34755f = (TextView) findViewById(R.id.ksad_entryitem4_duration);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_entryitem4_container);
        ratioFrameLayout.setRatio(0.56f);
        ratioFrameLayout.setOnClickListener(this.j);
        this.f34752c.setOnClickListener(this.j);
    }

    private boolean g() {
        com.kwad.sdk.core.response.model.c E = d.E(this.f34757h);
        return E.b() * 16 > E.c() * 9;
    }

    @Override // com.kwad.sdk.entry.view.a, com.kwad.sdk.widget.b
    public void a() {
        super.a();
        e.b(this.f34756g, ((a) this).f34781a.f34069e);
    }

    @Override // com.kwad.sdk.entry.view.a
    public boolean b() {
        this.i.clear();
        Iterator<AdTemplate> it = ((a) this).f34781a.k.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdTemplate next = it.next();
            if (!next.needHide && !com.kwad.sdk.core.response.b.c.c(next)) {
                this.i.add(next);
                break;
            }
        }
        if (this.i.size() > 0) {
            AdTemplate adTemplate = this.i.get(0);
            this.f34756g = adTemplate;
            this.f34757h = adTemplate.photoInfo;
        } else {
            this.f34756g = null;
        }
        if (this.f34756g == null) {
            return false;
        }
        if (((a) this).f34781a.f34072h != 1 || TextUtils.isEmpty(this.f34757h.baseInfo.videoDesc)) {
            this.f34752c.setVisibility(8);
        } else {
            this.f34752c.setText(this.f34757h.baseInfo.videoDesc);
            this.f34752c.setVisibility(0);
        }
        String a2 = ai.a(this.f34757h.videoInfo.duration);
        if (((a) this).f34781a.f34072h == 1) {
            this.f34755f.setText(a2);
            this.f34755f.setVisibility(0);
        } else {
            this.f34755f.setVisibility(8);
        }
        if (g()) {
            this.f34754e.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f34753d.setVisibility(0);
            String h2 = d.h(this.f34757h);
            com.kwad.sdk.glide.c.b(this.f34753d.getContext()).a(h2).a(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).b(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).c(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).a((com.kwad.sdk.glide.request.e) new com.kwad.sdk.c(h2, this.f34756g)).a(this.f34753d);
            com.kwad.sdk.core.d.a.a("EntryTyp4View", "blurBackgroundUrl=" + h2 + " blurCoverUrl=" + this.f34757h.coverInfo.blurCoverUrl);
        } else {
            this.f34754e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f34753d.setVisibility(8);
        }
        String a3 = d.E(this.f34757h).a();
        com.kwad.sdk.glide.c.b(this.f34754e.getContext()).a(a3).a(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).b(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).c(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).a((com.kwad.sdk.glide.request.e) new com.kwad.sdk.c(a3, this.f34756g)).a(this.f34754e);
        return true;
    }

    @Override // com.kwad.sdk.entry.view.a
    public String getEntrySourceDesc() {
        if (TextUtils.isEmpty(((a) this).f34781a.f34066b)) {
            ((a) this).f34781a.f34066b = "快手推荐";
        }
        StringBuilder sb = new StringBuilder();
        com.kwad.sdk.core.response.model.a aVar = ((a) this).f34781a;
        if (aVar.f34067c != 0) {
            sb.append(aVar.f34066b);
            sb.append("   ");
        }
        if (((a) this).f34781a.j != 0) {
            sb.append(ag.a(this.f34757h.baseInfo.commentCount, "0"));
            sb.append(" 评论");
        }
        return sb.toString();
    }

    @Override // com.kwad.sdk.entry.view.a
    public int getEntrySourcePos() {
        int entrySourcePos = super.getEntrySourcePos();
        return entrySourcePos == 0 ? ((a) this).f34781a.j : entrySourcePos;
    }

    @Override // com.kwad.sdk.entry.view.a
    public List<AdTemplate> getRealShowData() {
        return this.i;
    }

    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }
}
