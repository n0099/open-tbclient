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
    public com.kwad.sdk.lib.widget.b<AdTemplate> f35103c;

    /* renamed from: d  reason: collision with root package name */
    public EntryPhotoView f35104d;

    /* renamed from: e  reason: collision with root package name */
    public EntryPhotoView f35105e;

    /* renamed from: f  reason: collision with root package name */
    public List<AdTemplate> f35106f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f35107g;

    public EntryLinearView(Context context) {
        super(context);
        this.f35103c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35107g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryLinearView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryLinearView.this.a(((EntryPhotoView) view).getTemplateData(), view == EntryLinearView.this.f35105e ? 1 : 0, view, 1);
            }
        };
    }

    public EntryLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35103c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35107g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryLinearView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryLinearView.this.a(((EntryPhotoView) view).getTemplateData(), view == EntryLinearView.this.f35105e ? 1 : 0, view, 1);
            }
        };
    }

    private void c() {
        EntryPhotoView entryPhotoView = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoleft);
        this.f35104d = entryPhotoView;
        entryPhotoView.setRatio(1.33f);
        this.f35104d.a(true, true);
        EntryPhotoView entryPhotoView2 = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoright);
        this.f35105e = entryPhotoView2;
        entryPhotoView2.setRatio(1.33f);
        this.f35105e.a(true, true);
        this.f35105e.setOnClickListener(this.f35107g);
        this.f35104d.setOnClickListener(this.f35107g);
    }

    @Override // com.kwad.sdk.entry.view.a
    public boolean b() {
        this.f35103c.clear();
        List<AdTemplate> list = ((a) this).f35165a.k;
        this.f35106f = list;
        for (AdTemplate adTemplate : list) {
            if (!adTemplate.needHide) {
                this.f35103c.add(adTemplate);
            }
            if (this.f35103c.size() >= 2) {
                break;
            }
        }
        if (this.f35103c.size() <= 1) {
            setVisibility(8);
            return false;
        }
        this.f35104d.a(0, ((a) this).f35165a.f34453e);
        this.f35104d.a(this.f35103c.get(0), ((a) this).f35165a);
        this.f35104d.setLikeViewPos(((a) this).f35165a.f34452d);
        this.f35104d.setAdShowStyle(1);
        this.f35105e.a(1, ((a) this).f35165a.f34453e);
        this.f35105e.a(this.f35103c.get(1), ((a) this).f35165a);
        this.f35105e.setLikeViewPos(((a) this).f35165a.f34452d);
        this.f35105e.setAdShowStyle(1);
        setVisibility(0);
        return true;
    }

    @Override // com.kwad.sdk.entry.view.a
    public List<AdTemplate> getRealShowData() {
        return this.f35103c;
    }

    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    public void setRealShowItem(List<AdTemplate> list) {
        this.f35106f = list;
    }
}
