package com.kwad.sdk.entry.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class EntryLinearView extends a {

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f34718c;

    /* renamed from: d  reason: collision with root package name */
    public EntryPhotoView f34719d;

    /* renamed from: e  reason: collision with root package name */
    public EntryPhotoView f34720e;

    /* renamed from: f  reason: collision with root package name */
    public List<AdTemplate> f34721f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f34722g;

    public EntryLinearView(Context context) {
        super(context);
        this.f34718c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f34722g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryLinearView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryLinearView.this.a(((EntryPhotoView) view).getTemplateData(), view == EntryLinearView.this.f34720e ? 1 : 0, view, 1);
            }
        };
    }

    public EntryLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34718c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f34722g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryLinearView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryLinearView.this.a(((EntryPhotoView) view).getTemplateData(), view == EntryLinearView.this.f34720e ? 1 : 0, view, 1);
            }
        };
    }

    private void c() {
        EntryPhotoView entryPhotoView = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoleft);
        this.f34719d = entryPhotoView;
        entryPhotoView.setRatio(1.33f);
        this.f34719d.a(true, true);
        EntryPhotoView entryPhotoView2 = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoright);
        this.f34720e = entryPhotoView2;
        entryPhotoView2.setRatio(1.33f);
        this.f34720e.a(true, true);
        this.f34720e.setOnClickListener(this.f34722g);
        this.f34719d.setOnClickListener(this.f34722g);
    }

    @Override // com.kwad.sdk.entry.view.a
    public boolean b() {
        this.f34718c.clear();
        List<AdTemplate> list = ((a) this).f34780a.k;
        this.f34721f = list;
        for (AdTemplate adTemplate : list) {
            if (!adTemplate.needHide) {
                this.f34718c.add(adTemplate);
            }
            if (this.f34718c.size() >= 2) {
                break;
            }
        }
        if (this.f34718c.size() <= 1) {
            setVisibility(8);
            return false;
        }
        this.f34719d.a(0, ((a) this).f34780a.f34068e);
        this.f34719d.a(this.f34718c.get(0), ((a) this).f34780a);
        this.f34719d.setLikeViewPos(((a) this).f34780a.f34067d);
        this.f34719d.setAdShowStyle(1);
        this.f34720e.a(1, ((a) this).f34780a.f34068e);
        this.f34720e.a(this.f34718c.get(1), ((a) this).f34780a);
        this.f34720e.setLikeViewPos(((a) this).f34780a.f34067d);
        this.f34720e.setAdShowStyle(1);
        setVisibility(0);
        return true;
    }

    @Override // com.kwad.sdk.entry.view.a
    public List<AdTemplate> getRealShowData() {
        return this.f34718c;
    }

    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    public void setRealShowItem(List<AdTemplate> list) {
        this.f34721f = list;
    }
}
