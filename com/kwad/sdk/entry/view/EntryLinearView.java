package com.kwad.sdk.entry.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class EntryLinearView extends a {

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f35376c;

    /* renamed from: d  reason: collision with root package name */
    public EntryPhotoView f35377d;

    /* renamed from: e  reason: collision with root package name */
    public EntryPhotoView f35378e;

    /* renamed from: f  reason: collision with root package name */
    public List<AdTemplate> f35379f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f35380g;

    public EntryLinearView(Context context) {
        super(context);
        this.f35376c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35380g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryLinearView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryLinearView.this.a(((EntryPhotoView) view).getTemplateData(), view == EntryLinearView.this.f35378e ? 1 : 0, view, 1);
            }
        };
    }

    public EntryLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35376c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35380g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryLinearView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryLinearView.this.a(((EntryPhotoView) view).getTemplateData(), view == EntryLinearView.this.f35378e ? 1 : 0, view, 1);
            }
        };
    }

    private void c() {
        EntryPhotoView entryPhotoView = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoleft);
        this.f35377d = entryPhotoView;
        entryPhotoView.setRatio(1.33f);
        this.f35377d.a(true, true);
        EntryPhotoView entryPhotoView2 = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoright);
        this.f35378e = entryPhotoView2;
        entryPhotoView2.setRatio(1.33f);
        this.f35378e.a(true, true);
        this.f35378e.setOnClickListener(this.f35380g);
        this.f35377d.setOnClickListener(this.f35380g);
    }

    @Override // com.kwad.sdk.entry.view.a
    public boolean b() {
        this.f35376c.clear();
        List<AdTemplate> list = ((a) this).f35441a.k;
        this.f35379f = list;
        for (AdTemplate adTemplate : list) {
            if (!adTemplate.needHide) {
                this.f35376c.add(adTemplate);
            }
            if (this.f35376c.size() >= 2) {
                break;
            }
        }
        if (this.f35376c.size() <= 1) {
            setVisibility(8);
            return false;
        }
        this.f35377d.a(0, ((a) this).f35441a.f34705e);
        this.f35377d.a(this.f35376c.get(0), ((a) this).f35441a);
        this.f35377d.setLikeViewPos(((a) this).f35441a.f34704d);
        this.f35377d.setAdShowStyle(1);
        this.f35378e.a(1, ((a) this).f35441a.f34705e);
        this.f35378e.a(this.f35376c.get(1), ((a) this).f35441a);
        this.f35378e.setLikeViewPos(((a) this).f35441a.f34704d);
        this.f35378e.setAdShowStyle(1);
        setVisibility(0);
        return true;
    }

    @Override // com.kwad.sdk.entry.view.a
    public List<AdTemplate> getRealShowData() {
        return this.f35376c;
    }

    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    public void setRealShowItem(List<AdTemplate> list) {
        this.f35379f = list;
    }
}
