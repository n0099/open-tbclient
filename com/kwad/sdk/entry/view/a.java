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
/* loaded from: classes4.dex */
public abstract class a extends com.kwad.sdk.widget.b implements c {

    /* renamed from: a  reason: collision with root package name */
    protected com.kwad.sdk.core.response.model.a f9801a;

    /* renamed from: b  reason: collision with root package name */
    protected com.kwad.sdk.widget.c f9802b;
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
        if (this.f9802b == null) {
            this.f9802b = new com.kwad.sdk.widget.c(getContext());
            this.f9802b.setGravity(16);
            this.f9802b.setTextSize(18.0f);
            this.f9802b.setTextColor(Color.parseColor("#323232"));
            this.f9802b.setCompoundDrawablePadding(ao.a(getContext(), 2.0f));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = ao.a(getContext(), 8.0f);
            this.f9802b.setLayoutParams(layoutParams2);
            this.f9802b.setMaxEms(15);
            this.f9802b.setMaxLines(1);
            Drawable drawable = getResources().getDrawable(R.drawable.ksad_entrytitle_arrow);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.f9802b.setCompoundDrawables(null, null, drawable, null);
            this.f9802b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.a.1
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
            addView(this.f9802b, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.widget.b
    public void a() {
        super.a();
        e.a(this.f9801a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AdTemplate adTemplate, int i, View view, int i2) {
        if (this.d == null) {
            return;
        }
        com.kwad.sdk.entry.model.a aVar = new com.kwad.sdk.entry.model.a(this.f9801a);
        aVar.a(adTemplate);
        com.kwad.sdk.entry.a.a(aVar);
        e.a(adTemplate, this.f9801a.e, i2);
        this.d.handleFeedClick(this.f9801a.f9430a, i, view);
    }

    @Override // com.kwad.sdk.entry.view.c
    public boolean a(com.kwad.sdk.core.response.model.a aVar) {
        this.f9801a = aVar;
        if (this.f9801a == null) {
            removeAllViews();
            return false;
        }
        boolean b2 = b();
        String entrySourceDesc = getEntrySourceDesc();
        if (entrySourceDesc != null) {
            this.c.setText(entrySourceDesc);
        } else {
            if (TextUtils.isEmpty(aVar.f9431b)) {
                aVar.f9431b = "来自 快手推荐";
            }
            this.c.setText(aVar.f9431b);
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
        if (getEntryTitlePos() != 1 || TextUtils.isEmpty(this.f9801a.f)) {
            this.f9802b.setVisibility(8);
        } else {
            this.f9802b.setText(this.f9801a.f);
            this.f9802b.setVisibility(0);
        }
        return b2;
    }

    protected abstract boolean b();

    public String getEntrySourceDesc() {
        return null;
    }

    public int getEntrySourcePos() {
        return this.f9801a.c;
    }

    public int getEntryTitlePos() {
        return this.f9801a.g;
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
