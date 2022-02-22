package com.kwad.sdk.core.download.kwai;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes4.dex */
public class g extends com.kwad.sdk.widget.a {
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public String f56027b;

    /* renamed from: c  reason: collision with root package name */
    public String f56028c;

    /* renamed from: d  reason: collision with root package name */
    public int f56029d;

    /* renamed from: e  reason: collision with root package name */
    public String f56030e;

    /* renamed from: f  reason: collision with root package name */
    public int f56031f;

    /* loaded from: classes4.dex */
    public static class a {
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public b f56032b;

        /* renamed from: c  reason: collision with root package name */
        public String f56033c;

        /* renamed from: d  reason: collision with root package name */
        public String f56034d;

        /* renamed from: e  reason: collision with root package name */
        public int f56035e;

        /* renamed from: f  reason: collision with root package name */
        public String f56036f;

        /* renamed from: g  reason: collision with root package name */
        public int f56037g;

        public a(@NonNull Context context) {
            this.a = context;
        }

        public a a(b bVar) {
            this.f56032b = bVar;
            return this;
        }

        public a a(@NonNull String str) {
            this.f56033c = str;
            return this;
        }

        public com.kwad.sdk.widget.a a() {
            return new g(this);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public g(a aVar) {
        super(aVar.a);
        a(aVar);
    }

    private View a() {
        View inflate = LayoutInflater.from(Wrapper.wrapContextIfNeed(getContext())).inflate(R.layout.ksad_no_title_common_dialog_content_layout, (ViewGroup) null, false);
        inflate.findViewById(R.id.ksad_no_title_common_dialog_layout).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.kwai.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.a != null) {
                    g.this.a.c(g.this);
                }
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_no_title_common_positive_btn);
        if (!TextUtils.isEmpty(this.f56028c)) {
            textView.setText(this.f56028c);
        }
        textView.setTextColor(this.f56029d);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.kwai.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.a != null) {
                    g.this.a.a(g.this);
                }
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_no_title_common_negative_btn);
        if (!TextUtils.isEmpty(this.f56030e)) {
            textView2.setText(this.f56030e);
        }
        textView2.setTextColor(this.f56031f);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.kwai.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.a != null) {
                    g.this.a.b(g.this);
                }
            }
        });
        ((TextView) inflate.findViewById(R.id.ksad_no_title_common_content_text)).setText(this.f56027b);
        return inflate;
    }

    private void a(a aVar) {
        if (aVar.a instanceof Activity) {
            setOwnerActivity((Activity) aVar.a);
        }
        this.a = aVar.f56032b;
        this.f56027b = aVar.f56033c;
        this.f56028c = !TextUtils.isEmpty(aVar.f56034d) ? aVar.f56034d : aVar.a.getString(R.string.ksad_no_title_common_dialog_positivebtn_title);
        this.f56029d = aVar.f56035e != 0 ? aVar.f56035e : aVar.a.getResources().getColor(R.color.ksad_no_title_common_dialog_positivebtn_color);
        this.f56030e = !TextUtils.isEmpty(aVar.f56036f) ? aVar.f56036f : aVar.a.getString(R.string.ksad_no_title_common_dialog_negativebtn_title);
        this.f56031f = aVar.f56037g != 0 ? aVar.f56037g : aVar.a.getResources().getColor(R.color.ksad_no_title_common_dialog_negativebtn_color);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(a());
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }
}
