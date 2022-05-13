package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.a.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
/* loaded from: classes5.dex */
public class ActionBarH5 extends FrameLayout implements d {
    public TextView a;
    public TextView b;
    public AdTemplate c;
    public a d;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
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
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0469, this);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091092);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091096);
    }

    private void a(View view2, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C0295a(view2.getContext()).a(this.c).a(new a.b() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarH5.1
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (ActionBarH5.this.d != null) {
                    ActionBarH5.this.d.a(z);
                }
            }
        }));
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.c = adTemplate;
        this.d = aVar;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(j));
        this.b.setText(com.kwad.sdk.core.response.a.a.A(j));
        setClickable(true);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view2) {
        a(view2, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view2) {
        if (c.g(this.c)) {
            a(view2, false);
        }
    }
}
