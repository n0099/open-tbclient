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
    public com.kwad.sdk.lib.widget.b<AdTemplate> f35474c;

    /* renamed from: d  reason: collision with root package name */
    public EntryPhotoView f35475d;

    /* renamed from: e  reason: collision with root package name */
    public EntryPhotoView f35476e;

    /* renamed from: f  reason: collision with root package name */
    public List<AdTemplate> f35477f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f35478g;

    public EntryLinearView(Context context) {
        super(context);
        this.f35474c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35478g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryLinearView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryLinearView.this.a(((EntryPhotoView) view).getTemplateData(), view == EntryLinearView.this.f35476e ? 1 : 0, view, 1);
            }
        };
    }

    public EntryLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35474c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35478g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryLinearView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryLinearView.this.a(((EntryPhotoView) view).getTemplateData(), view == EntryLinearView.this.f35476e ? 1 : 0, view, 1);
            }
        };
    }

    private void c() {
        EntryPhotoView entryPhotoView = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoleft);
        this.f35475d = entryPhotoView;
        entryPhotoView.setRatio(1.33f);
        this.f35475d.a(true, true);
        EntryPhotoView entryPhotoView2 = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoright);
        this.f35476e = entryPhotoView2;
        entryPhotoView2.setRatio(1.33f);
        this.f35476e.a(true, true);
        this.f35476e.setOnClickListener(this.f35478g);
        this.f35475d.setOnClickListener(this.f35478g);
    }

    @Override // com.kwad.sdk.entry.view.a
    public boolean b() {
        this.f35474c.clear();
        List<AdTemplate> list = ((a) this).f35539a.k;
        this.f35477f = list;
        for (AdTemplate adTemplate : list) {
            if (!adTemplate.needHide) {
                this.f35474c.add(adTemplate);
            }
            if (this.f35474c.size() >= 2) {
                break;
            }
        }
        if (this.f35474c.size() <= 1) {
            setVisibility(8);
            return false;
        }
        this.f35475d.a(0, ((a) this).f35539a.f34803e);
        this.f35475d.a(this.f35474c.get(0), ((a) this).f35539a);
        this.f35475d.setLikeViewPos(((a) this).f35539a.f34802d);
        this.f35475d.setAdShowStyle(1);
        this.f35476e.a(1, ((a) this).f35539a.f34803e);
        this.f35476e.a(this.f35474c.get(1), ((a) this).f35539a);
        this.f35476e.setLikeViewPos(((a) this).f35539a.f34802d);
        this.f35476e.setAdShowStyle(1);
        setVisibility(0);
        return true;
    }

    @Override // com.kwad.sdk.entry.view.a
    public List<AdTemplate> getRealShowData() {
        return this.f35474c;
    }

    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    public void setRealShowItem(List<AdTemplate> list) {
        this.f35477f = list;
    }
}
