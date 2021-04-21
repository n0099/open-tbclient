package com.kwad.sdk.contentalliance.detail.photo.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public Presenter f32644a;

    /* renamed from: b  reason: collision with root package name */
    public c f32645b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f32646c;

    /* renamed from: d  reason: collision with root package name */
    public Button f32647d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f32648e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.photo.f.c f32649f;

    /* renamed from: g  reason: collision with root package name */
    public int f32650g;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public b(Context context) {
        super(context);
        this.f32646c = null;
        this.f32647d = null;
        this.f32648e = new ArrayList();
        this.f32649f = new com.kwad.sdk.contentalliance.detail.photo.f.c() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.b.1
            @Override // com.kwad.sdk.contentalliance.detail.photo.f.c
            public void a(com.kwad.sdk.contentalliance.detail.photo.f.d dVar) {
                b.this.c();
            }
        };
        b();
    }

    private c b(@NonNull d dVar) {
        c cVar = new c();
        cVar.f32656a = dVar;
        cVar.f32657b = this.f32649f;
        return cVar;
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_bottom_panel_2, (ViewGroup) this, true);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_photo_bottom_panel_buttons_layout);
        this.f32646c = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        Button button = (Button) findViewById(R.id.ksad_photo_bottom_panel_cancel_button);
        this.f32647d = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.d();
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.d();
            }
        });
        View findViewById = findViewById(R.id.ksad_space);
        if (findViewById == null || !com.kwad.sdk.core.config.c.R()) {
            return;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.c(b.this);
                if (b.this.f32650g > 10) {
                    i.a(b.this.getContext(), "ksad_debug_deviceId_and_gid", "did:" + ah.m() + "——————egid:" + com.kwad.sdk.core.b.e.a());
                    p.a(b.this.getContext(), "hello");
                    b.this.f32650g = 0;
                }
            }
        });
    }

    public static /* synthetic */ int c(b bVar) {
        int i = bVar.f32650g;
        bVar.f32650g = i + 1;
        return i;
    }

    private Presenter c(d dVar) {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new f());
        return presenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        for (a aVar : this.f32648e) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f32650g = 0;
        for (a aVar : this.f32648e) {
            aVar.b();
        }
    }

    public void a() {
        this.f32644a.j();
    }

    public void a(@NonNull a aVar) {
        this.f32648e.add(aVar);
    }

    public void a(@NonNull d dVar) {
        this.f32645b = b(dVar);
        if (this.f32644a == null) {
            Presenter c2 = c(dVar);
            this.f32644a = c2;
            c2.a((View) this.f32646c);
        }
        this.f32644a.a(this.f32645b);
    }

    public void b(@NonNull a aVar) {
        this.f32648e.remove(aVar);
    }
}
