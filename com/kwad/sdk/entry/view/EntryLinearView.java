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
    public com.kwad.sdk.lib.widget.b<AdTemplate> f35008c;

    /* renamed from: d  reason: collision with root package name */
    public EntryPhotoView f35009d;

    /* renamed from: e  reason: collision with root package name */
    public EntryPhotoView f35010e;

    /* renamed from: f  reason: collision with root package name */
    public List<AdTemplate> f35011f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f35012g;

    public EntryLinearView(Context context) {
        super(context);
        this.f35008c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35012g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryLinearView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryLinearView.this.a(((EntryPhotoView) view).getTemplateData(), view == EntryLinearView.this.f35010e ? 1 : 0, view, 1);
            }
        };
    }

    public EntryLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35008c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35012g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryLinearView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryLinearView.this.a(((EntryPhotoView) view).getTemplateData(), view == EntryLinearView.this.f35010e ? 1 : 0, view, 1);
            }
        };
    }

    private void c() {
        EntryPhotoView entryPhotoView = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoleft);
        this.f35009d = entryPhotoView;
        entryPhotoView.setRatio(1.33f);
        this.f35009d.a(true, true);
        EntryPhotoView entryPhotoView2 = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoright);
        this.f35010e = entryPhotoView2;
        entryPhotoView2.setRatio(1.33f);
        this.f35010e.a(true, true);
        this.f35010e.setOnClickListener(this.f35012g);
        this.f35009d.setOnClickListener(this.f35012g);
    }

    @Override // com.kwad.sdk.entry.view.a
    public boolean b() {
        this.f35008c.clear();
        List<AdTemplate> list = ((a) this).f35070a.k;
        this.f35011f = list;
        for (AdTemplate adTemplate : list) {
            if (!adTemplate.needHide) {
                this.f35008c.add(adTemplate);
            }
            if (this.f35008c.size() >= 2) {
                break;
            }
        }
        if (this.f35008c.size() <= 1) {
            setVisibility(8);
            return false;
        }
        this.f35009d.a(0, ((a) this).f35070a.f34358e);
        this.f35009d.a(this.f35008c.get(0), ((a) this).f35070a);
        this.f35009d.setLikeViewPos(((a) this).f35070a.f34357d);
        this.f35009d.setAdShowStyle(1);
        this.f35010e.a(1, ((a) this).f35070a.f34358e);
        this.f35010e.a(this.f35008c.get(1), ((a) this).f35070a);
        this.f35010e.setLikeViewPos(((a) this).f35070a.f34357d);
        this.f35010e.setAdShowStyle(1);
        setVisibility(0);
        return true;
    }

    @Override // com.kwad.sdk.entry.view.a
    public List<AdTemplate> getRealShowData() {
        return this.f35008c;
    }

    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    public void setRealShowItem(List<AdTemplate> list) {
        this.f35011f = list;
    }
}
