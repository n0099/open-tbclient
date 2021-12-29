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
    public String f58011b;

    /* renamed from: c  reason: collision with root package name */
    public String f58012c;

    /* renamed from: d  reason: collision with root package name */
    public int f58013d;

    /* renamed from: e  reason: collision with root package name */
    public String f58014e;

    /* renamed from: f  reason: collision with root package name */
    public int f58015f;

    /* loaded from: classes3.dex */
    public static class a {
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public b f58016b;

        /* renamed from: c  reason: collision with root package name */
        public String f58017c;

        /* renamed from: d  reason: collision with root package name */
        public String f58018d;

        /* renamed from: e  reason: collision with root package name */
        public int f58019e;

        /* renamed from: f  reason: collision with root package name */
        public String f58020f;

        /* renamed from: g  reason: collision with root package name */
        public int f58021g;

        public a(@NonNull Context context) {
            this.a = context;
        }

        public a a(b bVar) {
            this.f58016b = bVar;
            return this;
        }

        public a a(@NonNull String str) {
            this.f58017c = str;
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
        if (!TextUtils.isEmpty(this.f58012c)) {
            textView.setText(this.f58012c);
        }
        textView.setTextColor(this.f58013d);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.kwai.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.a != null) {
                    g.this.a.a(g.this);
                }
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_no_title_common_negative_btn);
        if (!TextUtils.isEmpty(this.f58014e)) {
            textView2.setText(this.f58014e);
        }
        textView2.setTextColor(this.f58015f);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.kwai.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.a != null) {
                    g.this.a.b(g.this);
                }
            }
        });
        ((TextView) inflate.findViewById(R.id.ksad_no_title_common_content_text)).setText(this.f58011b);
        return inflate;
    }

    private void a(a aVar) {
        if (aVar.a instanceof Activity) {
            setOwnerActivity((Activity) aVar.a);
        }
        this.a = aVar.f58016b;
        this.f58011b = aVar.f58017c;
        this.f58012c = !TextUtils.isEmpty(aVar.f58018d) ? aVar.f58018d : aVar.a.getString(R.string.ksad_no_title_common_dialog_positivebtn_title);
        this.f58013d = aVar.f58019e != 0 ? aVar.f58019e : aVar.a.getResources().getColor(R.color.ksad_no_title_common_dialog_positivebtn_color);
        this.f58014e = !TextUtils.isEmpty(aVar.f58020f) ? aVar.f58020f : aVar.a.getString(R.string.ksad_no_title_common_dialog_negativebtn_title);
        this.f58015f = aVar.f58021g != 0 ? aVar.f58021g : aVar.a.getResources().getColor(R.color.ksad_no_title_common_dialog_negativebtn_color);
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
