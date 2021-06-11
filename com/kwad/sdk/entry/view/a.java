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
/* loaded from: classes7.dex */
public abstract class a extends com.kwad.sdk.widget.b implements c {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.a f35441a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.widget.c f35442b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35443c;

    /* renamed from: d  reason: collision with root package name */
    public KsEntryElement.OnFeedClickListener f35444d;

    public a(Context context) {
        super(context);
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void c() {
        int a2 = ao.a(getContext(), 5.0f);
        if (this.f35443c == null) {
            TextView textView = new TextView(getContext());
            this.f35443c = textView;
            textView.setTextSize(10.0f);
            this.f35443c.setTextColor(Color.parseColor("#9c9c9c"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 3;
            layoutParams.topMargin = a2;
            layoutParams.rightMargin = getSourceRightMargin();
            this.f35443c.setLayoutParams(layoutParams);
            addView(this.f35443c);
        }
        if (this.f35442b == null) {
            com.kwad.sdk.widget.c cVar = new com.kwad.sdk.widget.c(getContext());
            this.f35442b = cVar;
            cVar.setGravity(16);
            this.f35442b.setTextSize(18.0f);
            this.f35442b.setTextColor(Color.parseColor("#323232"));
            this.f35442b.setCompoundDrawablePadding(ao.a(getContext(), 2.0f));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = ao.a(getContext(), 8.0f);
            this.f35442b.setLayoutParams(layoutParams2);
            this.f35442b.setMaxEms(15);
            this.f35442b.setMaxLines(1);
            Drawable drawable = getResources().getDrawable(R.drawable.ksad_entrytitle_arrow);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.f35442b.setCompoundDrawables(null, null, drawable, null);
            this.f35442b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.a.1
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
            addView(this.f35442b, 0);
        }
    }

    @Override // com.kwad.sdk.widget.b
    public void a() {
        super.a();
        e.a(this.f35441a);
    }

    public void a(AdTemplate adTemplate, int i2, View view, int i3) {
        if (this.f35444d == null) {
            return;
        }
        com.kwad.sdk.entry.model.a aVar = new com.kwad.sdk.entry.model.a(this.f35441a);
        aVar.a(adTemplate);
        com.kwad.sdk.entry.a.a(aVar);
        e.a(adTemplate, this.f35441a.f34705e, i3);
        this.f35444d.handleFeedClick(this.f35441a.f34701a, i2, view);
    }

    @Override // com.kwad.sdk.entry.view.c
    public boolean a(com.kwad.sdk.core.response.model.a aVar) {
        LinearLayout.LayoutParams layoutParams;
        int i2;
        this.f35441a = aVar;
        if (aVar == null) {
            removeAllViews();
            return false;
        }
        boolean b2 = b();
        String entrySourceDesc = getEntrySourceDesc();
        if (entrySourceDesc != null) {
            this.f35443c.setText(entrySourceDesc);
        } else {
            if (TextUtils.isEmpty(aVar.f34702b)) {
                aVar.f34702b = "来自 快手推荐";
            }
            this.f35443c.setText(aVar.f34702b);
        }
        int entrySourcePos = getEntrySourcePos();
        if (entrySourcePos != 0) {
            if (entrySourcePos != 1) {
                layoutParams = (LinearLayout.LayoutParams) this.f35443c.getLayoutParams();
                i2 = 5;
            } else {
                layoutParams = (LinearLayout.LayoutParams) this.f35443c.getLayoutParams();
                i2 = 3;
            }
            layoutParams.gravity = i2;
            this.f35443c.setLayoutParams(layoutParams);
            this.f35443c.setVisibility(0);
        } else {
            this.f35443c.setVisibility(8);
        }
        if (getEntryTitlePos() != 1 || TextUtils.isEmpty(this.f35441a.f34706f)) {
            this.f35442b.setVisibility(8);
        } else {
            this.f35442b.setText(this.f35441a.f34706f);
            this.f35442b.setVisibility(0);
        }
        return b2;
    }

    public abstract boolean b();

    public String getEntrySourceDesc() {
        return null;
    }

    public int getEntrySourcePos() {
        return this.f35441a.f34703c;
    }

    public int getEntryTitlePos() {
        return this.f35441a.f34707g;
    }

    @NonNull
    public abstract List<AdTemplate> getRealShowData();

    public int getSourceRightMargin() {
        return 0;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    @Override // com.kwad.sdk.entry.view.c
    public void setOnfeedClickListener(KsEntryElement.OnFeedClickListener onFeedClickListener) {
        this.f35444d = onFeedClickListener;
    }
}
