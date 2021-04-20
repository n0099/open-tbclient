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
    public com.kwad.sdk.core.response.model.a f35070a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.widget.c f35071b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35072c;

    /* renamed from: d  reason: collision with root package name */
    public KsEntryElement.OnFeedClickListener f35073d;

    public a(Context context) {
        super(context);
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void c() {
        int a2 = ao.a(getContext(), 5.0f);
        if (this.f35072c == null) {
            TextView textView = new TextView(getContext());
            this.f35072c = textView;
            textView.setTextSize(10.0f);
            this.f35072c.setTextColor(Color.parseColor("#9c9c9c"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 3;
            layoutParams.topMargin = a2;
            layoutParams.rightMargin = getSourceRightMargin();
            this.f35072c.setLayoutParams(layoutParams);
            addView(this.f35072c);
        }
        if (this.f35071b == null) {
            com.kwad.sdk.widget.c cVar = new com.kwad.sdk.widget.c(getContext());
            this.f35071b = cVar;
            cVar.setGravity(16);
            this.f35071b.setTextSize(18.0f);
            this.f35071b.setTextColor(Color.parseColor("#323232"));
            this.f35071b.setCompoundDrawablePadding(ao.a(getContext(), 2.0f));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = ao.a(getContext(), 8.0f);
            this.f35071b.setLayoutParams(layoutParams2);
            this.f35071b.setMaxEms(15);
            this.f35071b.setMaxLines(1);
            Drawable drawable = getResources().getDrawable(R.drawable.ksad_entrytitle_arrow);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.f35071b.setCompoundDrawables(null, null, drawable, null);
            this.f35071b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.a.1
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
            addView(this.f35071b, 0);
        }
    }

    @Override // com.kwad.sdk.widget.b
    public void a() {
        super.a();
        e.a(this.f35070a);
    }

    public void a(AdTemplate adTemplate, int i, View view, int i2) {
        if (this.f35073d == null) {
            return;
        }
        com.kwad.sdk.entry.model.a aVar = new com.kwad.sdk.entry.model.a(this.f35070a);
        aVar.a(adTemplate);
        com.kwad.sdk.entry.a.a(aVar);
        e.a(adTemplate, this.f35070a.f34358e, i2);
        this.f35073d.handleFeedClick(this.f35070a.f34354a, i, view);
    }

    @Override // com.kwad.sdk.entry.view.c
    public boolean a(com.kwad.sdk.core.response.model.a aVar) {
        LinearLayout.LayoutParams layoutParams;
        int i;
        this.f35070a = aVar;
        if (aVar == null) {
            removeAllViews();
            return false;
        }
        boolean b2 = b();
        String entrySourceDesc = getEntrySourceDesc();
        if (entrySourceDesc != null) {
            this.f35072c.setText(entrySourceDesc);
        } else {
            if (TextUtils.isEmpty(aVar.f34355b)) {
                aVar.f34355b = "来自 快手推荐";
            }
            this.f35072c.setText(aVar.f34355b);
        }
        int entrySourcePos = getEntrySourcePos();
        if (entrySourcePos != 0) {
            if (entrySourcePos != 1) {
                layoutParams = (LinearLayout.LayoutParams) this.f35072c.getLayoutParams();
                i = 5;
            } else {
                layoutParams = (LinearLayout.LayoutParams) this.f35072c.getLayoutParams();
                i = 3;
            }
            layoutParams.gravity = i;
            this.f35072c.setLayoutParams(layoutParams);
            this.f35072c.setVisibility(0);
        } else {
            this.f35072c.setVisibility(8);
        }
        if (getEntryTitlePos() != 1 || TextUtils.isEmpty(this.f35070a.f34359f)) {
            this.f35071b.setVisibility(8);
        } else {
            this.f35071b.setText(this.f35070a.f34359f);
            this.f35071b.setVisibility(0);
        }
        return b2;
    }

    public abstract boolean b();

    public String getEntrySourceDesc() {
        return null;
    }

    public int getEntrySourcePos() {
        return this.f35070a.f34356c;
    }

    public int getEntryTitlePos() {
        return this.f35070a.f34360g;
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
        this.f35073d = onFeedClickListener;
    }
}
