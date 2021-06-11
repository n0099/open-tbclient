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
/* loaded from: classes7.dex */
public class ActionBarH5 extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public TextView f37231a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f37232b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f37233c;

    /* renamed from: d  reason: collision with root package name */
    public a f37234d;

    /* loaded from: classes7.dex */
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
        this.f37231a = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.f37232b = (TextView) findViewById(R.id.ksad_h5_open_btn);
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.f37233c = adTemplate;
        this.f37234d = aVar;
        AdInfo j = c.j(adTemplate);
        this.f37231a.setText(com.kwad.sdk.core.response.b.a.n(j));
        this.f37232b.setText(com.kwad.sdk.core.response.b.a.w(j));
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37233c, new a.InterfaceC0379a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarH5.1
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                if (ActionBarH5.this.f37234d != null) {
                    ActionBarH5.this.f37234d.a();
                }
            }
        }, null);
    }
}
