package com.kwad.sdk.entry.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class EntryLinearView extends a {
    private com.kwad.sdk.lib.widget.b<AdTemplate> c;
    private EntryPhotoView d;
    private EntryPhotoView e;
    private List<AdTemplate> f;
    private View.OnClickListener g;

    public EntryLinearView(Context context) {
        super(context);
        this.c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryLinearView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryLinearView.this.a(((EntryPhotoView) view).getTemplateData(), view == EntryLinearView.this.e ? 1 : 0, view, 1);
            }
        };
    }

    public EntryLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryLinearView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryLinearView.this.a(((EntryPhotoView) view).getTemplateData(), view == EntryLinearView.this.e ? 1 : 0, view, 1);
            }
        };
    }

    private void c() {
        this.d = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoleft);
        this.d.setRatio(1.33f);
        this.d.a(true, true);
        this.e = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoright);
        this.e.setRatio(1.33f);
        this.e.a(true, true);
        this.e.setOnClickListener(this.g);
        this.d.setOnClickListener(this.g);
    }

    @Override // com.kwad.sdk.entry.view.a
    protected boolean b() {
        this.c.clear();
        this.f = this.f9803a.k;
        for (AdTemplate adTemplate : this.f) {
            if (!adTemplate.needHide) {
                this.c.add(adTemplate);
            }
            if (this.c.size() >= 2) {
                break;
            }
        }
        if (this.c.size() <= 1) {
            setVisibility(8);
            return false;
        }
        this.d.a(0, this.f9803a.e);
        this.d.a(this.c.get(0), this.f9803a);
        this.d.setLikeViewPos(this.f9803a.d);
        this.d.setAdShowStyle(1);
        this.e.a(1, this.f9803a.e);
        this.e.a(this.c.get(1), this.f9803a);
        this.e.setLikeViewPos(this.f9803a.d);
        this.e.setAdShowStyle(1);
        setVisibility(0);
        return true;
    }

    @Override // com.kwad.sdk.entry.view.a
    protected List<AdTemplate> getRealShowData() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    public void setRealShowItem(List<AdTemplate> list) {
        this.f = list;
    }
}
