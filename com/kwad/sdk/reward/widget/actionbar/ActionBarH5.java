package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class ActionBarH5 extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public TextView f34628a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34629b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34630c;

    /* renamed from: d  reason: collision with root package name */
    public a f34631d;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public ActionBarH5(Context context) {
        super(context);
        a(context);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_video_actionbar_h5, this);
        this.f34628a = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.f34629b = (TextView) findViewById(R.id.ksad_h5_open_btn);
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.f34630c = adTemplate;
        this.f34631d = aVar;
        AdInfo g2 = c.g(adTemplate);
        this.f34628a.setText(com.kwad.sdk.core.response.b.a.m(g2));
        this.f34629b.setText(com.kwad.sdk.core.response.b.a.u(g2));
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f34630c, new a.InterfaceC0376a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarH5.1
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
            public void a() {
                if (ActionBarH5.this.f34631d != null) {
                    ActionBarH5.this.f34631d.a();
                }
            }
        }, null, false);
    }
}
