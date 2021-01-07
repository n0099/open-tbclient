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
/* loaded from: classes5.dex */
public class ActionBarH5 extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f10966a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f10967b;
    private AdTemplate c;
    private a d;

    /* loaded from: classes5.dex */
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

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        inflate(context, R.layout.ksad_video_actionbar_h5, this);
        this.f10966a = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.f10967b = (TextView) findViewById(R.id.ksad_h5_open_btn);
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.c = adTemplate;
        this.d = aVar;
        AdInfo j = c.j(this.c);
        this.f10966a.setText(com.kwad.sdk.core.response.b.a.n(j));
        this.f10967b.setText(com.kwad.sdk.core.response.b.a.w(j));
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.c, new a.InterfaceC1105a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarH5.1
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1105a
            public void a() {
                if (ActionBarH5.this.d != null) {
                    ActionBarH5.this.d.a();
                }
            }
        }, null);
    }
}
