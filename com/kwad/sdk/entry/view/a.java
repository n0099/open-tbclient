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
/* loaded from: classes6.dex */
public abstract class a extends com.kwad.sdk.widget.b implements c {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.a f35165a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.widget.c f35166b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35167c;

    /* renamed from: d  reason: collision with root package name */
    public KsEntryElement.OnFeedClickListener f35168d;

    public a(Context context) {
        super(context);
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void c() {
        int a2 = ao.a(getContext(), 5.0f);
        if (this.f35167c == null) {
            TextView textView = new TextView(getContext());
            this.f35167c = textView;
            textView.setTextSize(10.0f);
            this.f35167c.setTextColor(Color.parseColor("#9c9c9c"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 3;
            layoutParams.topMargin = a2;
            layoutParams.rightMargin = getSourceRightMargin();
            this.f35167c.setLayoutParams(layoutParams);
            addView(this.f35167c);
        }
        if (this.f35166b == null) {
            com.kwad.sdk.widget.c cVar = new com.kwad.sdk.widget.c(getContext());
            this.f35166b = cVar;
            cVar.setGravity(16);
            this.f35166b.setTextSize(18.0f);
            this.f35166b.setTextColor(Color.parseColor("#323232"));
            this.f35166b.setCompoundDrawablePadding(ao.a(getContext(), 2.0f));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = ao.a(getContext(), 8.0f);
            this.f35166b.setLayoutParams(layoutParams2);
            this.f35166b.setMaxEms(15);
            this.f35166b.setMaxLines(1);
            Drawable drawable = getResources().getDrawable(R.drawable.ksad_entrytitle_arrow);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.f35166b.setCompoundDrawables(null, null, drawable, null);
            this.f35166b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.a.1
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
            addView(this.f35166b, 0);
        }
    }

    @Override // com.kwad.sdk.widget.b
    public void a() {
        super.a();
        e.a(this.f35165a);
    }

    public void a(AdTemplate adTemplate, int i, View view, int i2) {
        if (this.f35168d == null) {
            return;
        }
        com.kwad.sdk.entry.model.a aVar = new com.kwad.sdk.entry.model.a(this.f35165a);
        aVar.a(adTemplate);
        com.kwad.sdk.entry.a.a(aVar);
        e.a(adTemplate, this.f35165a.f34453e, i2);
        this.f35168d.handleFeedClick(this.f35165a.f34449a, i, view);
    }

    @Override // com.kwad.sdk.entry.view.c
    public boolean a(com.kwad.sdk.core.response.model.a aVar) {
        LinearLayout.LayoutParams layoutParams;
        int i;
        this.f35165a = aVar;
        if (aVar == null) {
            removeAllViews();
            return false;
        }
        boolean b2 = b();
        String entrySourceDesc = getEntrySourceDesc();
        if (entrySourceDesc != null) {
            this.f35167c.setText(entrySourceDesc);
        } else {
            if (TextUtils.isEmpty(aVar.f34450b)) {
                aVar.f34450b = "来自 快手推荐";
            }
            this.f35167c.setText(aVar.f34450b);
        }
        int entrySourcePos = getEntrySourcePos();
        if (entrySourcePos != 0) {
            if (entrySourcePos != 1) {
                layoutParams = (LinearLayout.LayoutParams) this.f35167c.getLayoutParams();
                i = 5;
            } else {
                layoutParams = (LinearLayout.LayoutParams) this.f35167c.getLayoutParams();
                i = 3;
            }
            layoutParams.gravity = i;
            this.f35167c.setLayoutParams(layoutParams);
            this.f35167c.setVisibility(0);
        } else {
            this.f35167c.setVisibility(8);
        }
        if (getEntryTitlePos() != 1 || TextUtils.isEmpty(this.f35165a.f34454f)) {
            this.f35166b.setVisibility(8);
        } else {
            this.f35166b.setText(this.f35165a.f34454f);
            this.f35166b.setVisibility(0);
        }
        return b2;
    }

    public abstract boolean b();

    public String getEntrySourceDesc() {
        return null;
    }

    public int getEntrySourcePos() {
        return this.f35165a.f34451c;
    }

    public int getEntryTitlePos() {
        return this.f35165a.f34455g;
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
        this.f35168d = onFeedClickListener;
    }
}
