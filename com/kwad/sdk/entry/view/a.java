package com.kwad.sdk.entry.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsEntryElement;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a extends com.kwad.sdk.widget.b implements c {

    /* renamed from: a  reason: collision with root package name */
    protected com.kwad.sdk.core.response.model.a f10101a;

    /* renamed from: b  reason: collision with root package name */
    protected com.kwad.sdk.widget.c f10102b;
    private TextView c;
    private KsEntryElement.OnFeedClickListener d;

    public a(Context context) {
        super(context);
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void c() {
        int a2 = ao.a(getContext(), 5.0f);
        if (this.c == null) {
            this.c = new TextView(getContext());
            this.c.setTextSize(10.0f);
            this.c.setTextColor(Color.parseColor("#9c9c9c"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 3;
            layoutParams.topMargin = a2;
            layoutParams.rightMargin = getSourceRightMargin();
            this.c.setLayoutParams(layoutParams);
            addView(this.c);
        }
        if (this.f10102b == null) {
            this.f10102b = new com.kwad.sdk.widget.c(getContext());
            this.f10102b.setGravity(16);
            this.f10102b.setTextSize(18.0f);
            this.f10102b.setTextColor(Color.parseColor("#323232"));
            this.f10102b.setCompoundDrawablePadding(ao.a(getContext(), 2.0f));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = ao.a(getContext(), 8.0f);
            this.f10102b.setLayoutParams(layoutParams2);
            this.f10102b.setMaxEms(15);
            this.f10102b.setMaxLines(1);
            Drawable drawable = getResources().getDrawable(R.drawable.ksad_entrytitle_arrow);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.f10102b.setCompoundDrawables(null, null, drawable, null);
            this.f10102b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    List<AdTemplate> realShowData = a.this.getRealShowData();
                    if (realShowData.size() < 1) {
                        return;
                    }
                    int size = realShowData.size() - 1;
                    a.this.a(realShowData.get(size), size, view, 2);
                }
            });
            addView(this.f10102b, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.widget.b
    public void a() {
        super.a();
        e.a(this.f10101a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AdTemplate adTemplate, int i, View view, int i2) {
        if (this.d == null) {
            return;
        }
        com.kwad.sdk.entry.model.a aVar = new com.kwad.sdk.entry.model.a(this.f10101a);
        aVar.a(adTemplate);
        com.kwad.sdk.entry.a.a(aVar);
        e.a(adTemplate, this.f10101a.e, i2);
        this.d.handleFeedClick(this.f10101a.f9730a, i, view);
    }

    @Override // com.kwad.sdk.entry.view.c
    public boolean a(com.kwad.sdk.core.response.model.a aVar) {
        this.f10101a = aVar;
        if (this.f10101a == null) {
            removeAllViews();
            return false;
        }
        boolean b2 = b();
        String entrySourceDesc = getEntrySourceDesc();
        if (entrySourceDesc != null) {
            this.c.setText(entrySourceDesc);
        } else {
            if (TextUtils.isEmpty(aVar.f9731b)) {
                aVar.f9731b = "来自 快手推荐";
            }
            this.c.setText(aVar.f9731b);
        }
        switch (getEntrySourcePos()) {
            case 0:
                this.c.setVisibility(8);
                break;
            case 1:
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
                layoutParams.gravity = 3;
                this.c.setLayoutParams(layoutParams);
                this.c.setVisibility(0);
                break;
            default:
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
                layoutParams2.gravity = 5;
                this.c.setLayoutParams(layoutParams2);
                this.c.setVisibility(0);
                break;
        }
        if (getEntryTitlePos() != 1 || TextUtils.isEmpty(this.f10101a.f)) {
            this.f10102b.setVisibility(8);
        } else {
            this.f10102b.setText(this.f10101a.f);
            this.f10102b.setVisibility(0);
        }
        return b2;
    }

    protected abstract boolean b();

    public String getEntrySourceDesc() {
        return null;
    }

    public int getEntrySourcePos() {
        return this.f10101a.c;
    }

    public int getEntryTitlePos() {
        return this.f10101a.g;
    }

    @NonNull
    protected abstract List<AdTemplate> getRealShowData();

    public int getSourceRightMargin() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    @Override // com.kwad.sdk.entry.view.c
    public void setOnfeedClickListener(KsEntryElement.OnFeedClickListener onFeedClickListener) {
        this.d = onFeedClickListener;
    }
}
