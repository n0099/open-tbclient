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
/* loaded from: classes3.dex */
public class EntryTyp4View extends a {
    private TextView c;
    private ImageView d;
    private ImageView e;
    private TextView f;
    private AdTemplate g;
    private PhotoInfo h;
    private com.kwad.sdk.lib.widget.b<AdTemplate> i;
    private View.OnClickListener j;

    public EntryTyp4View(Context context) {
        super(context);
        this.i = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.j = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryTyp4View.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryTyp4View.this.a(EntryTyp4View.this.g, 0, view, 1);
            }
        };
    }

    public EntryTyp4View(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.j = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryTyp4View.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryTyp4View.this.a(EntryTyp4View.this.g, 0, view, 1);
            }
        };
    }

    private void c() {
        this.c = (TextView) findViewById(R.id.ksad_entryitem4_title);
        this.d = (ImageView) findViewById(R.id.ksad_entryitem4_background);
        this.e = (ImageView) findViewById(R.id.ksad_entryitem4_thumb);
        this.f = (TextView) findViewById(R.id.ksad_entryitem4_duration);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_entryitem4_container);
        ratioFrameLayout.setRatio(0.56f);
        ratioFrameLayout.setOnClickListener(this.j);
        this.c.setOnClickListener(this.j);
    }

    private boolean g() {
        com.kwad.sdk.core.response.model.c E = d.E(this.h);
        return E.b() * 16 > E.c() * 9;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.entry.view.a, com.kwad.sdk.widget.b
    public void a() {
        super.a();
        e.b(this.g, this.f9803a.e);
    }

    @Override // com.kwad.sdk.entry.view.a
    protected boolean b() {
        this.i.clear();
        Iterator<AdTemplate> it = this.f9803a.k.iterator();
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
            this.g = this.i.get(0);
            this.h = this.g.photoInfo;
        } else {
            this.g = null;
        }
        if (this.g == null) {
            return false;
        }
        if (this.f9803a.h != 1 || TextUtils.isEmpty(this.h.baseInfo.videoDesc)) {
            this.c.setVisibility(8);
        } else {
            this.c.setText(this.h.baseInfo.videoDesc);
            this.c.setVisibility(0);
        }
        String a2 = ai.a(this.h.videoInfo.duration);
        if (this.f9803a.h == 1) {
            this.f.setText(a2);
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
        if (g()) {
            this.e.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.d.setVisibility(0);
            String h = d.h(this.h);
            com.kwad.sdk.glide.c.b(this.d.getContext()).a(h).a(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).b(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).c(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).a((com.kwad.sdk.glide.request.e) new com.kwad.sdk.c(h, this.g)).a(this.d);
            com.kwad.sdk.core.d.a.a("EntryTyp4View", "blurBackgroundUrl=" + h + " blurCoverUrl=" + this.h.coverInfo.blurCoverUrl);
        } else {
            this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d.setVisibility(8);
        }
        String a3 = d.E(this.h).a();
        com.kwad.sdk.glide.c.b(this.e.getContext()).a(a3).a(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).b(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).c(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).a((com.kwad.sdk.glide.request.e) new com.kwad.sdk.c(a3, this.g)).a(this.e);
        return true;
    }

    @Override // com.kwad.sdk.entry.view.a
    public String getEntrySourceDesc() {
        if (TextUtils.isEmpty(this.f9803a.f9433b)) {
            this.f9803a.f9433b = "快手推荐";
        }
        StringBuilder sb = new StringBuilder();
        if (this.f9803a.c != 0) {
            sb.append(this.f9803a.f9433b);
            sb.append("   ");
        }
        if (this.f9803a.j != 0) {
            sb.append(ag.a(this.h.baseInfo.commentCount, "0")).append(" 评论");
        }
        return sb.toString();
    }

    @Override // com.kwad.sdk.entry.view.a
    public int getEntrySourcePos() {
        int entrySourcePos = super.getEntrySourcePos();
        return entrySourcePos == 0 ? this.f9803a.j : entrySourcePos;
    }

    @Override // com.kwad.sdk.entry.view.a
    protected List<AdTemplate> getRealShowData() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }
}
