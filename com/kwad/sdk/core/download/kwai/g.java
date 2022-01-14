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
/* loaded from: classes3.dex */
public class g extends com.kwad.sdk.widget.a {
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public String f55815b;

    /* renamed from: c  reason: collision with root package name */
    public String f55816c;

    /* renamed from: d  reason: collision with root package name */
    public int f55817d;

    /* renamed from: e  reason: collision with root package name */
    public String f55818e;

    /* renamed from: f  reason: collision with root package name */
    public int f55819f;

    /* loaded from: classes3.dex */
    public static class a {
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public b f55820b;

        /* renamed from: c  reason: collision with root package name */
        public String f55821c;

        /* renamed from: d  reason: collision with root package name */
        public String f55822d;

        /* renamed from: e  reason: collision with root package name */
        public int f55823e;

        /* renamed from: f  reason: collision with root package name */
        public String f55824f;

        /* renamed from: g  reason: collision with root package name */
        public int f55825g;

        public a(@NonNull Context context) {
            this.a = context;
        }

        public a a(b bVar) {
            this.f55820b = bVar;
            return this;
        }

        public a a(@NonNull String str) {
            this.f55821c = str;
            return this;
        }

        public com.kwad.sdk.widget.a a() {
            return new g(this);
        }
    }

    /* loaded from: classes3.dex */
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
        if (!TextUtils.isEmpty(this.f55816c)) {
            textView.setText(this.f55816c);
        }
        textView.setTextColor(this.f55817d);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.kwai.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.a != null) {
                    g.this.a.a(g.this);
                }
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_no_title_common_negative_btn);
        if (!TextUtils.isEmpty(this.f55818e)) {
            textView2.setText(this.f55818e);
        }
        textView2.setTextColor(this.f55819f);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.kwai.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.a != null) {
                    g.this.a.b(g.this);
                }
            }
        });
        ((TextView) inflate.findViewById(R.id.ksad_no_title_common_content_text)).setText(this.f55815b);
        return inflate;
    }

    private void a(a aVar) {
        if (aVar.a instanceof Activity) {
            setOwnerActivity((Activity) aVar.a);
        }
        this.a = aVar.f55820b;
        this.f55815b = aVar.f55821c;
        this.f55816c = !TextUtils.isEmpty(aVar.f55822d) ? aVar.f55822d : aVar.a.getString(R.string.ksad_no_title_common_dialog_positivebtn_title);
        this.f55817d = aVar.f55823e != 0 ? aVar.f55823e : aVar.a.getResources().getColor(R.color.ksad_no_title_common_dialog_positivebtn_color);
        this.f55818e = !TextUtils.isEmpty(aVar.f55824f) ? aVar.f55824f : aVar.a.getString(R.string.ksad_no_title_common_dialog_negativebtn_title);
        this.f55819f = aVar.f55825g != 0 ? aVar.f55825g : aVar.a.getResources().getColor(R.color.ksad_no_title_common_dialog_negativebtn_color);
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
